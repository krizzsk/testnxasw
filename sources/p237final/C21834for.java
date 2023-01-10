package p237final;

import android.content.Context;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import p237final.C21834for;

/* renamed from: final.for */
/* compiled from: Vibrator */
public class C21834for {

    /* renamed from: a */
    private final Vibrator f59999a;

    /* renamed from: b */
    private final Handler f60000b = new Handler();

    /* renamed from: final.for$do */
    /* compiled from: Vibrator */
    public enum C21835do {
        FACE_FOUND(50, new long[]{0, 20, 100, 20}, new int[]{0, 255, 0, 255}),
        COMPLETED(0, new long[]{0, 50, 100, 50}, new int[]{0, 255, 0, 255}),
        START_FLASHING(0, new long[]{0, 20}, new int[]{0, 255});
        
        /* access modifiers changed from: private */

        /* renamed from: do */
        public long f60001do;
        /* access modifiers changed from: private */

        /* renamed from: for  reason: not valid java name */
        public int[] f62444for;
        /* access modifiers changed from: private */

        /* renamed from: if */
        public long[] f60002if;

        private C21835do(long j, long[] jArr, int[] iArr) {
            this.f60001do = j;
            this.f60002if = jArr;
            this.f62444for = iArr;
        }
    }

    public C21834for(Context context) {
        this.f59999a = (Vibrator) context.getSystemService("vibrator");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45153b(C21835do doVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                this.f59999a.vibrate(VibrationEffect.createWaveform(doVar.f60002if, doVar.f62444for, -1));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        } else {
            this.f59999a.vibrate(doVar.f60002if, -1, (AudioAttributes) null);
        }
    }

    /* renamed from: for  reason: not valid java name */
    public void m48238for(C21835do doVar) {
        if (this.f59999a.hasVibrator()) {
            this.f60000b.postDelayed(new Runnable(doVar) {
                public final /* synthetic */ C21834for.C21835do f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C21834for.this.m45153b(this.f$1);
                }
            }, doVar.f60001do);
        }
    }
}
