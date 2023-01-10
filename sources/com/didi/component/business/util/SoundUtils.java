package com.didi.component.business.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.SparseArray;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.utils.ApmThreadPool;

public class SoundUtils {

    /* renamed from: b */
    private static SoundUtils f13230b;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f13231a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SoundPool f13232c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SparseArray<Integer> f13233d = new SparseArray<>();

    public static SoundUtils getInstance(Context context) {
        if (f13230b == null) {
            synchronized (SoundUtils.class) {
                if (f13230b == null) {
                    f13230b = new SoundUtils(context);
                }
            }
        }
        return f13230b;
    }

    public SoundUtils(Context context) {
        this.f13231a = context.getApplicationContext();
    }

    public void playMustSound(int i) {
        ApmThreadPool.execute((Runnable) new TaskWorker(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m11109a() {
        AudioManager audioManager = (AudioManager) this.f13231a.getSystemService("audio");
        if (audioManager.getRingerMode() != 2) {
            return 0.0f;
        }
        return ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
    }

    private class TaskWorker implements Runnable {
        private int mTaskResourceId;

        public TaskWorker(int i) {
            this.mTaskResourceId = i;
        }

        public void run() {
            playSound(this.mTaskResourceId);
        }

        private void playSound(int i) {
            if (SoundUtils.this.f13232c == null) {
                SoundPool unused = SoundUtils.this.f13232c = new SoundPool(2, 3, 0);
            }
            final int peekSound = peekSound(i);
            if (peekSound == 0) {
                try {
                    peekSound = SoundUtils.this.f13232c.load(SoundUtils.this.f13231a, i, 1);
                    SoundUtils.this.f13232c.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                        public void onLoadComplete(SoundPool soundPool, int i, int i2) {
                            TaskWorker.this.play(peekSound);
                        }
                    });
                } catch (Exception unused2) {
                }
                SystemUtils.log(4, "loadSound", "load sound " + i, (Throwable) null, "com.didi.component.business.util.SoundUtils$TaskWorker", 88);
            }
            SoundUtils.this.f13233d.put(i, Integer.valueOf(peekSound));
            play(peekSound);
        }

        private int peekSound(int i) {
            Integer num;
            if (SoundUtils.this.f13233d == null || (num = (Integer) SoundUtils.this.f13233d.get(i)) == null) {
                return 0;
            }
            return num.intValue();
        }

        /* access modifiers changed from: private */
        public void play(int i) {
            if (i > 0) {
                float d = SoundUtils.this.m11109a();
                SoundUtils.this.f13232c.play(i, d, d, 1, 0, 1.0f);
            }
        }
    }
}
