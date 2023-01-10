package p230const;

import p095switch.C3674goto;

/* renamed from: const.if */
/* compiled from: FPSMeter */
public class C21729if {

    /* renamed from: a */
    private final C3674goto f59068a = new C3674goto(10);

    /* renamed from: b */
    private long f59069b = -1;

    /* renamed from: c */
    private volatile long f59070c = -1;

    /* renamed from: d */
    private long f59071d = 0;

    /* renamed from: do */
    public float mo178976do() {
        return 1.0f / this.f59068a.mo43501do();
    }

    /* renamed from: for  reason: not valid java name */
    public synchronized void m48207for() {
        if (!mo178978if()) {
            long nanoTime = System.nanoTime();
            long j = this.f59069b;
            if (j != -1) {
                this.f59068a.mo43502do(((double) ((nanoTime - j) - this.f59071d)) / 1.0E9d);
            }
            this.f59069b = nanoTime;
            this.f59071d = 0;
        }
    }

    /* renamed from: if */
    public boolean mo178978if() {
        return this.f59070c != -1;
    }

    /* renamed from: new  reason: not valid java name */
    public synchronized void m48208new() {
        if (!mo178978if()) {
            this.f59070c = System.nanoTime();
        }
    }

    /* renamed from: try  reason: not valid java name */
    public synchronized void m48209try() {
        if (mo178978if()) {
            this.f59071d = System.nanoTime() - this.f59070c;
            this.f59070c = -1;
        }
    }
}
