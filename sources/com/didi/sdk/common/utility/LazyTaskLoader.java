package com.didi.sdk.common.utility;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.SystemClock;
import android.util.SparseArray;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.common.DDThreadPool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class LazyTaskLoader {
    public static final int TASK_BITMAP = 2;
    public static final int TASK_SOUND = 1;

    /* renamed from: a */
    private static final String f38403a = "LazyTaskLoader";

    /* renamed from: b */
    private static final long f38404b = 10000;

    /* renamed from: e */
    private static volatile LazyTaskLoader f38405e;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AtomicBoolean f38406c = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Object f38407d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f38408f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SoundPool f38409g = new SoundPool(2, 3, 0);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SparseArray<Integer> f38410h = new SparseArray<>();

    /* renamed from: i */
    private int f38411i = 0;

    /* renamed from: j */
    private List<AssetManager.AssetInputStream> f38412j = new ArrayList();

    public interface OnTaskLoadedListener {
        void onTaskLoaded(int i, Object obj);
    }

    private LazyTaskLoader(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f38408f = applicationContext;
        if (applicationContext == null) {
            this.f38408f = context;
        }
    }

    public static LazyTaskLoader getInstance(Context context) {
        if (f38405e == null) {
            synchronized (LazyTaskLoader.class) {
                if (f38405e == null) {
                    f38405e = new LazyTaskLoader(context);
                }
            }
        }
        return f38405e;
    }

    public void requestLoad(int i, List<Integer> list) {
        requestLoad(i, list, (OnTaskLoadedListener) null);
    }

    public void requestLoad(int i, List<Integer> list, OnTaskLoadedListener onTaskLoadedListener) {
        if (i == 1) {
            m28974a(list, onTaskLoadedListener);
        }
    }

    public void scheduleTask(final Runnable runnable) {
        m28973a((Runnable) new Runnable() {
            public void run() {
                if (!LazyTaskLoader.this.f38406c.get()) {
                    SystemUtils.log(4, LazyTaskLoader.f38403a, "wait schedule task", (Throwable) null, "com.didi.sdk.common.utility.LazyTaskLoader$1", 112);
                    synchronized (LazyTaskLoader.this.f38407d) {
                        if (!LazyTaskLoader.this.f38406c.get()) {
                            try {
                                LazyTaskLoader.this.f38407d.wait(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                SystemUtils.log(4, LazyTaskLoader.f38403a, "start execute task", (Throwable) null, "com.didi.sdk.common.utility.LazyTaskLoader$1", 123);
                runnable.run();
            }
        });
    }

    /* renamed from: a */
    private synchronized void m28974a(List<Integer> list, OnTaskLoadedListener onTaskLoadedListener) {
        if (this.f38409g == null) {
            this.f38409g = new SoundPool(2, 3, 0);
        }
        m28973a((Runnable) new TaskWorker(list, onTaskLoadedListener));
    }

    public SoundPool getSoundPool() {
        return this.f38409g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r9 = r0.get(r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int peekSound(int r9) {
        /*
            r8 = this;
            android.util.SparseArray<java.lang.Integer> r0 = r8.f38410h
            if (r0 == 0) goto L_0x0011
            java.lang.Object r9 = r0.get(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            if (r9 == 0) goto L_0x0011
            int r9 = r9.intValue()
            goto L_0x0012
        L_0x0011:
            r9 = 0
        L_0x0012:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "peek sound, return: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r4 = r0.toString()
            r2 = 4
            r5 = 0
            r7 = 150(0x96, float:2.1E-43)
            java.lang.String r3 = "LazyTaskLoader"
            java.lang.String r6 = "com.didi.sdk.common.utility.LazyTaskLoader"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.common.utility.LazyTaskLoader.peekSound(int):int");
    }

    public void setHasMainActivityLaunched(boolean z) {
        this.f38406c.set(z);
        if (this.f38406c.get()) {
            synchronized (this.f38407d) {
                this.f38407d.notifyAll();
                SystemUtils.log(4, f38403a, "notify Task Worker", (Throwable) null, "com.didi.sdk.common.utility.LazyTaskLoader", 159);
            }
        }
    }

    /* renamed from: a */
    private void m28973a(Runnable runnable) {
        DDThreadPool.getInstance().addBkgTask(runnable);
    }

    public void acquireAssetManager() {
        this.f38411i++;
    }

    public void releaseAssetManager(AssetManager.AssetInputStream assetInputStream) {
        this.f38411i--;
        this.f38412j.add(assetInputStream);
        if (this.f38411i <= 0) {
            this.f38412j.clear();
            System.gc();
        }
    }

    /* renamed from: a */
    private void m28972a() {
        SparseArray<Integer> sparseArray = this.f38410h;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        this.f38409g.release();
        this.f38409g = null;
    }

    private class TaskWorker implements Runnable {
        private OnTaskLoadedListener mTaskListener;
        private List<Integer> mTaskResourceIds;

        public TaskWorker(List<Integer> list, OnTaskLoadedListener onTaskLoadedListener) {
            this.mTaskResourceIds = list;
            this.mTaskListener = onTaskLoadedListener;
        }

        public void run() {
            if (!LazyTaskLoader.this.f38406c.get()) {
                SystemUtils.log(4, LazyTaskLoader.f38403a, "wait schedule task", (Throwable) null, "com.didi.sdk.common.utility.LazyTaskLoader$TaskWorker", 209);
                synchronized (LazyTaskLoader.this.f38407d) {
                    if (!LazyTaskLoader.this.f38406c.get()) {
                        try {
                            LazyTaskLoader.this.f38407d.wait(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            SystemUtils.log(4, LazyTaskLoader.f38403a, "start execute task with size " + this.mTaskResourceIds.size(), (Throwable) null, "com.didi.sdk.common.utility.LazyTaskLoader$TaskWorker", 220);
            loadSound(this.mTaskResourceIds, this.mTaskListener);
        }

        private SparseArray<Integer> loadSound(List<Integer> list, OnTaskLoadedListener onTaskLoadedListener) {
            if (list == null) {
                return null;
            }
            SparseArray<Integer> sparseArray = new SparseArray<>();
            for (int i = 0; i < list.size(); i++) {
                int intValue = list.get(i).intValue();
                int peekSound = LazyTaskLoader.this.peekSound(intValue);
                if (peekSound == 0) {
                    try {
                        peekSound = LazyTaskLoader.this.f38409g.load(LazyTaskLoader.this.f38408f, intValue, 1);
                    } catch (Exception unused) {
                    }
                    SystemUtils.log(4, "loadSound", "load sound " + intValue, (Throwable) null, "com.didi.sdk.common.utility.LazyTaskLoader$TaskWorker", 238);
                }
                sparseArray.put(intValue, Integer.valueOf(peekSound));
                SystemClock.sleep(10);
            }
            refreshSoundPool(sparseArray);
            if (onTaskLoadedListener != null) {
                onTaskLoadedListener.onTaskLoaded(1, sparseArray);
            }
            return sparseArray;
        }

        private void refreshSoundPool(SparseArray<Integer> sparseArray) {
            synchronized (LazyTaskLoader.this) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    int keyAt = sparseArray.keyAt(i);
                    if (((Integer) LazyTaskLoader.this.f38410h.get(keyAt)) == null) {
                        LazyTaskLoader.this.f38410h.put(keyAt, sparseArray.valueAt(i));
                    }
                }
            }
        }
    }

    @Deprecated
    public float getVolume() {
        AudioManager audioManager = (AudioManager) this.f38408f.getSystemService("audio");
        if (audioManager.getRingerMode() != 2) {
            return 0.0f;
        }
        return ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
    }
}
