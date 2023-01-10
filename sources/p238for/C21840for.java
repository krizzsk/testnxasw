package p238for;

import com.iproov.sdk.core.C20892try;
import com.iproov.sdk.logging.IPLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p095switch.C3660catch;
import p095switch.C3679throw;

/* renamed from: for.for */
/* compiled from: FlashingManager */
public final class C21840for implements C20892try {

    /* renamed from: a */
    private static final String f60014a = ("🔦 " + C21840for.class.getSimpleName());

    /* renamed from: b */
    private static long f60015b = -1;

    /* renamed from: c */
    private boolean f60016c = false;

    /* renamed from: d */
    private final List<C21839do> f60017d;

    /* renamed from: e */
    private final C21841do f60018e;

    /* renamed from: f */
    private final C21843new f60019f;

    /* renamed from: g */
    private final AtomicInteger f60020g = new AtomicInteger(0);

    /* renamed from: for.for$do */
    /* compiled from: FlashingManager */
    public interface C21841do {
        /* renamed from: do */
        void mo171513do();

        /* renamed from: do */
        void mo171514do(int i, C21839do doVar, int i2);

        /* renamed from: if */
        void mo171515if();
    }

    public C21840for(C21842if ifVar, C21843new newR, C21841do doVar) {
        this.f60019f = newR;
        this.f60017d = ifVar.mo180491do(newR.f62453new, newR.f62454try);
        this.f60018e = doVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m45168b() {
        int i = 0;
        while (i < m48248new() && !this.f60016c) {
            try {
                C21839do doVar = this.f60017d.get(i);
                m45167a();
                StringBuilder sb = new StringBuilder();
                sb.append("========== FLASHING ");
                sb.append(doVar);
                sb.append(" ==========");
                int i2 = this.f60020g.get();
                this.f60018e.mo171514do(i, doVar, i2);
                Thread.sleep((long) i2);
                if (i >= this.f60019f.f62452for) {
                    for (int i3 = 0; i3 < this.f60019f.f60023if; i3++) {
                        this.f60018e.mo171515if();
                    }
                }
                i++;
            } catch (InterruptedException unused) {
            }
        }
        this.f60018e.mo171513do();
    }

    /* renamed from: do */
    public void mo180487do(float f, float f2) {
        float min = Math.min(f, f2);
        C21843new newR = this.f60019f;
        int i = (int) C3679throw.m7436do((1.0d / ((double) min)) * ((double) newR.f60022do), (double) newR.f62450case, (double) newR.f62451else);
        this.f60020g.set(i);
        StringBuilder sb = new StringBuilder();
        sb.append("Flash speed: ");
        sb.append(i);
        sb.append("ms FPS=");
        sb.append(min);
        sb.append(" scalefactor=");
        sb.append(this.f60019f.f60022do);
        sb.append(" limits=");
        sb.append(this.f60019f.f62450case);
        sb.append("..");
        sb.append(this.f60019f.f62451else);
    }

    /* renamed from: for  reason: not valid java name */
    public void m48247for() {
        this.f60016c = true;
    }

    /* renamed from: if */
    public void mo180489if(float f, float f2) {
        mo180487do(f, f2);
        C3660catch.m7404do("FlashingLoop", C3660catch.C3662for.HIGH, (Runnable) new Runnable() {
            public final void run() {
                C21840for.this.m45168b();
            }
        }).start();
    }

    /* renamed from: new  reason: not valid java name */
    public int m48248new() {
        return this.f60017d.size();
    }

    /* renamed from: do */
    public int mo171466do() {
        int i = m48248new();
        C21843new newR = this.f60019f;
        return (i - newR.f62452for) * newR.f60023if;
    }

    /* renamed from: a */
    private static void m45167a() {
        long nanoTime = System.nanoTime();
        long j = (nanoTime - f60015b) / 1000000;
        if (j >= 175) {
            f60015b = nanoTime;
            return;
        }
        String str = "Maximum flash rate (175 ms) exceeded, flashing aborted (" + j + " ms)";
        IPLog.m43494w(f60014a, "Epilepsy warning! " + str);
        throw new IllegalStateException(str);
    }
}
