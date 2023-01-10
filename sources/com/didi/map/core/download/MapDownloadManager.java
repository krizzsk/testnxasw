package com.didi.map.core.download;

import com.didi.hawaii.log.HWLog;
import com.didi.map.constant.NavUrls;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;

public class MapDownloadManager {

    /* renamed from: a */
    private Hashtable<String, Boolean> f26977a = new Hashtable<>();

    /* renamed from: b */
    private ExecutorService f26978b;

    /* renamed from: c */
    private ExecutorService f26979c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MapDownloadExecutor f26980d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MapDownloadListener f26981e;

    /* renamed from: f */
    private final Object f26982f = new Object();

    /* renamed from: g */
    private boolean f26983g = false;

    public void setDownloadExecutor(MapDownloadExecutor mapDownloadExecutor) {
        this.f26980d = mapDownloadExecutor;
    }

    public void setDownloadListener(MapDownloadListener mapDownloadListener) {
        this.f26981e = mapDownloadListener;
    }

    public void stop() {
        stop((Runnable) null);
    }

    public void stop(Runnable runnable) {
        this.f26983g = true;
        cancel();
        this.f26980d = null;
        ExecutorService executorService = this.f26978b;
        if (executorService != null) {
            executorService.shutdown();
            this.f26978b = null;
        }
        synchronized (this.f26982f) {
            if (this.f26979c != null) {
                this.f26979c.shutdown();
                this.f26979c = null;
            }
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void cancel() {
        this.f26977a.clear();
    }

    public void addRequestIgnoreCache(String str, byte[] bArr) {
        if (this.f26980d != null) {
            m21253a(str, bArr);
        }
    }

    public void addRequest(String str) {
        if (this.f26980d != null && !this.f26977a.containsKey(str)) {
            m21252a(str);
            this.f26977a.put(str, true);
        }
    }

    /* renamed from: a */
    private void m21253a(final String str, final byte[] bArr) {
        m21249a();
        try {
            this.f26978b.execute(new Runnable() {
                public void run() {
                    try {
                        MapDownloadManager.this.m21256b(str, MapDownloadManager.this.f26980d.download(NavUrls.DiDiVecEnlargeUrl, bArr));
                    } catch (Exception e) {
                        e.printStackTrace();
                        MapDownloadManager.this.m21256b(str, (byte[]) null);
                    }
                }
            });
        } catch (IllegalMonitorStateException e) {
            e.printStackTrace();
        } catch (RejectedExecutionException unused) {
            HWLog.m20432e(1, "MapDownloadMannager", "Download Crossing Manager has Reject:" + str);
        }
    }

    /* renamed from: a */
    private void m21252a(final String str) {
        m21249a();
        try {
            this.f26978b.execute(new Runnable() {
                public void run() {
                    MapDownloadManager.this.m21255b(str);
                }
            });
        } catch (IllegalMonitorStateException e) {
            e.printStackTrace();
        } catch (RejectedExecutionException unused) {
            HWLog.m20432e(1, "MapDownloadMannager", "Download Crossing Manager has Reject:" + str);
        }
    }

    /* renamed from: a */
    private void m21249a() {
        if (this.f26978b == null) {
            this.f26978b = Executors.newFixedThreadPool(5, new ThreadFactory() {
                public Thread newThread(Runnable runnable) {
                    return new Thread(runnable, "HAWAII SDK MapDownloadManager Downloadpool");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21255b(String str) {
        try {
            m21256b(str, this.f26980d.download(str));
        } catch (Exception e) {
            e.printStackTrace();
            m21256b(str, (byte[]) null);
        }
        this.f26977a.remove(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21256b(final String str, final byte[] bArr) {
        if (this.f26981e != null) {
            synchronized (this.f26982f) {
                if (this.f26979c == null && !this.f26983g) {
                    this.f26979c = Executors.newSingleThreadExecutor(new ThreadFactory() {
                        public Thread newThread(Runnable runnable) {
                            return new Thread(runnable, "HAWAII SDK MapDownloadManager WritePool");
                        }
                    });
                }
                if (!this.f26983g) {
                    this.f26979c.execute(new Runnable() {
                        public void run() {
                            try {
                                if (bArr == null) {
                                    MapDownloadManager.this.f26981e.onFail(str);
                                } else {
                                    MapDownloadManager.this.f26981e.onData(str, bArr);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            }
        }
    }
}
