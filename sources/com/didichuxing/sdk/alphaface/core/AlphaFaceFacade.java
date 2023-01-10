package com.didichuxing.sdk.alphaface.core;

import android.content.Context;
import android.os.Handler;
import com.didichuxing.sdk.alphaface.AFConfig;
import com.didichuxing.sdk.alphaface.AlphaFace;
import com.didichuxing.sdk.alphaface.utils.AFLog;
import com.didichuxing.sdk.alphaface.utils.FileUtils;
import com.didichuxing.sdk.alphaface.utils.IOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class AlphaFaceFacade {

    /* renamed from: a */
    private static volatile AlphaFaceFacade f51170a;

    /* renamed from: b */
    private static final String[] f51171b = {"attack.all.bin", "quality.all.bin", "landmark.all.bin", "eye.all.bin", "light_detect.all.bin", "didimark.bin"};

    /* renamed from: c */
    private static final String[] f51172c = {"921b3a396a66987eb8142261a8fdbadb", "c930e506ee274fd4dac8b70bdf7d4d8c", "9e07fdba6c2511586955da69492d1ccb", "ee32287b708f6eda86c06031029826bc", "93ee10c478658d949b621469e015a00e", "e29e1b7989cddc7ea867b5c7261d67d7"};
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f51173d;

    /* renamed from: e */
    private Handler f51174e;

    /* renamed from: f */
    private AFConfig f51175f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final AlphaFaceNativeProxy f51176g = new AlphaFaceNativeProxy();

    /* renamed from: h */
    private boolean f51177h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f51178i;

    private AlphaFaceFacade() {
    }

    public static AlphaFaceFacade getInstance() {
        if (f51170a == null) {
            synchronized (AlphaFaceFacade.class) {
                if (f51170a == null) {
                    f51170a = new AlphaFaceFacade();
                }
            }
        }
        return f51170a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void preInit(com.didichuxing.sdk.alphaface.AFConfig r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x0029
            android.content.Context r0 = r2.getAppContext()     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0029
        L_0x000a:
            boolean r0 = r1.f51177h     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0024
            r1.f51175f = r2     // Catch:{ all -> 0x0026 }
            android.content.Context r2 = r2.getAppContext()     // Catch:{ all -> 0x0026 }
            r1.f51173d = r2     // Catch:{ all -> 0x0026 }
            android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x0026 }
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0026 }
            r2.<init>(r0)     // Catch:{ all -> 0x0026 }
            r1.f51174e = r2     // Catch:{ all -> 0x0026 }
            r2 = 1
            r1.f51177h = r2     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r1)
            return
        L_0x0026:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0029:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.sdk.alphaface.core.AlphaFaceFacade.preInit(com.didichuxing.sdk.alphaface.AFConfig):void");
    }

    public void releaseModelFilesIfNeeded() {
        if (this.f51177h) {
            int i = 0;
            File dir = this.f51173d.getDir(AlphaFace.MODEL_FILES_DIR, 0);
            while (i < f51171b.length) {
                try {
                    String str = f51171b[i];
                    if (m38272a(new File(dir, str), f51172c[i])) {
                        PrintStream printStream = System.out;
                        printStream.println("start release " + str + " to " + dir);
                        m38274b(dir, str);
                        PrintStream printStream2 = System.out;
                        printStream2.println("release " + str + " done.");
                    }
                    i++;
                } catch (Exception e) {
                    AFLog.m38439e(e.getMessage());
                    return;
                }
            }
            return;
        }
        throw new RuntimeException("preInit must be called firstly!!!");
    }

    /* renamed from: a */
    private boolean m38272a(File file, String str) {
        return !file.exists() || !str.equals(FileUtils.fileToMD5(file));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m38271a(File file) {
        int i = 0;
        while (true) {
            String[] strArr = f51171b;
            if (i >= strArr.length) {
                return true;
            }
            String str = strArr[i];
            String fileToMD5 = FileUtils.fileToMD5(new File(file, str));
            String str2 = f51172c[i];
            if (!str2.equals(fileToMD5)) {
                PrintStream printStream = System.out;
                printStream.println("verify " + str + " failed, realMd5=" + fileToMD5 + ", expectedMd5=" + str2);
                return false;
            }
            i++;
        }
    }

    /* renamed from: b */
    private boolean m38275b(File file) {
        boolean z = true;
        for (String file2 : f51171b) {
            z &= new File(file, file2).exists();
        }
        return z;
    }

    /* renamed from: b */
    private synchronized void m38274b(File file, String str) throws Exception {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Exception e;
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.createNewFile();
        }
        try {
            inputStream = this.f51173d.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    IOUtils.copy(inputStream, fileOutputStream);
                    IOUtils.closeQuietly(inputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        AFLog.m38439e("copy from assets error, msg=" + e.getMessage());
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.closeQuietly(inputStream);
                        IOUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                fileOutputStream = null;
                e = e3;
                AFLog.m38439e("copy from assets error, msg=" + e.getMessage());
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(fileOutputStream);
            } catch (Throwable th2) {
                fileOutputStream = null;
                th = th2;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            fileOutputStream = null;
            e = e4;
            inputStream = null;
            AFLog.m38439e("copy from assets error, msg=" + e.getMessage());
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream);
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
            inputStream = null;
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream);
            throw th;
        }
        IOUtils.closeQuietly(fileOutputStream);
    }

    public synchronized void initialize(AlphaFace.IInitCallback iInitCallback) {
        if (!this.f51177h) {
            throw new RuntimeException("preInit must be called firstly!!!");
        } else if (!this.f51178i) {
            m38266a(iInitCallback);
        } else {
            iInitCallback.onResult(100000, "");
        }
    }

    /* renamed from: a */
    private void m38266a(final AlphaFace.IInitCallback iInitCallback) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    File dir = AlphaFaceFacade.this.f51173d.getDir(AlphaFace.MODEL_FILES_DIR, 0);
                    if (!AlphaFaceFacade.this.m38271a(dir)) {
                        AlphaFaceFacade.this.m38267a(iInitCallback, 100001, "model files verify failed");
                    } else if (AlphaFaceFacade.this.f51176g.modelInit(dir.getPath())) {
                        boolean unused = AlphaFaceFacade.this.f51178i = true;
                        AlphaFaceFacade.this.m38267a(iInitCallback, 100000, "success");
                    } else {
                        AlphaFaceFacade.this.m38267a(iInitCallback, 100001, "failed with modelInit");
                    }
                } catch (Exception e) {
                    AlphaFaceFacade alphaFaceFacade = AlphaFaceFacade.this;
                    AlphaFace.IInitCallback iInitCallback = iInitCallback;
                    alphaFaceFacade.m38267a(iInitCallback, 100001, "failed with exception: " + e.getMessage());
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38267a(final AlphaFace.IInitCallback iInitCallback, final int i, final String str) {
        if (iInitCallback != null) {
            this.f51174e.post(new Runnable() {
                public void run() {
                    iInitCallback.onResult(i, str);
                }
            });
        }
    }

    public synchronized void unInitModels() {
        this.f51176g.modelUnInit();
        this.f51178i = false;
    }

    public AlphaFaceNativeProxy getAfNative() {
        return this.f51176g;
    }

    public AFConfig getConfig() {
        return this.f51175f;
    }
}
