package p098try;

import com.iproov.sdk.core.C20871for;
import com.iproov.sdk.core.exception.IProovException;
import p095switch.C3665class;
import p098try.C3690if;

/* renamed from: try.for */
/* compiled from: StateManager */
public final class C3689for {

    /* renamed from: a */
    private static final C3690if f8822a = new C3690if.C3696goto();

    /* renamed from: b */
    private final C3690if.C3699this f8823b;

    /* renamed from: c */
    private volatile C3690if f8824c = f8822a;

    /* renamed from: d */
    private final C3665class<C3688do> f8825d = new C3665class<>(750);

    public C3689for(C3690if.C3699this thisR) {
        this.f8823b = thisR;
    }

    /* renamed from: do */
    public synchronized C3690if.C3695for mo43541do(String str) {
        C3690if.C3695for forR;
        if (!(this.f8824c instanceof C3690if.C3698new)) {
            forR = null;
        } else {
            forR = (C3690if.C3695for) m7502a(new C3690if.C3695for(str));
        }
        return forR;
    }

    /* renamed from: for  reason: not valid java name */
    public synchronized C3690if.C3693do m46681for() {
        return this.f8824c.mo43553if() ? null : (C3690if.C3693do) m7502a(new C3690if.C3693do());
    }

    /* renamed from: if */
    public synchronized C3690if mo43546if() {
        return this.f8824c;
    }

    /* renamed from: new  reason: not valid java name */
    public synchronized C3690if.C3698new m46682new() {
        C3690if.C3698new newR;
        if (!(this.f8824c == f8822a)) {
            newR = null;
        } else {
            newR = (C3690if.C3698new) m7502a(new C3690if.C3698new());
        }
        return newR;
    }

    /* renamed from: try  reason: not valid java name */
    public synchronized C3690if.C3694else m46683try() {
        if (this.f8824c instanceof C3690if.C3697if) {
            C3690if.C3697if ifVar = (C3690if.C3697if) this.f8824c;
            if (ifVar.m46694for()) {
                return (C3690if.C3694else) m7502a(new C3690if.C3694else(ifVar.m46696try()));
            }
        }
        return null;
    }

    /* renamed from: do */
    public synchronized boolean mo43544do() {
        return (this.f8824c instanceof C3690if.C3697if) || (this.f8824c instanceof C3690if.C3695for);
    }

    /* renamed from: do */
    public synchronized C3690if.C3697if mo43542do(C3690if.C3697if ifVar) {
        return !mo43544do() ? null : (C3690if.C3697if) m7502a(ifVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0015  */
    /* renamed from: do */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized p098try.C3690if.C3694else mo43540do(p238for.C21839do r2, int r3, float r4, float r5) {
        /*
            r1 = this;
            monitor-enter(r1)
            try.if r0 = r1.f8824c     // Catch:{ all -> 0x0022 }
            boolean r0 = r0 instanceof p098try.C3690if.C3698new     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0010
            try.if r0 = r1.f8824c     // Catch:{ all -> 0x0022 }
            boolean r0 = r0 instanceof p098try.C3690if.C3694else     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            if (r0 != 0) goto L_0x0015
            r2 = 0
            goto L_0x0020
        L_0x0015:
            try.if$else r0 = new try.if$else     // Catch:{ all -> 0x0022 }
            r0.<init>(r2, r3, r4, r5)     // Catch:{ all -> 0x0022 }
            try.if r2 = r1.m7502a(r0)     // Catch:{ all -> 0x0022 }
            try.if$else r2 = (p098try.C3690if.C3694else) r2     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r1)
            return r2
        L_0x0022:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p098try.C3689for.mo43540do(for.do, int, float, float):try.if$else");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001b  */
    /* renamed from: do */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized p098try.C3690if.C3691break mo43538do(double r2, java.lang.String r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            try.if r0 = r1.f8824c     // Catch:{ all -> 0x0028 }
            boolean r0 = r0 instanceof p098try.C3690if.C3697if     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0016
            try.if r0 = r1.f8824c     // Catch:{ all -> 0x0028 }
            boolean r0 = r0 instanceof p098try.C3690if.C3694else     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0016
            try.if r0 = r1.f8824c     // Catch:{ all -> 0x0028 }
            boolean r0 = r0 instanceof p098try.C3690if.C3691break     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r0 = 0
            goto L_0x0017
        L_0x0016:
            r0 = 1
        L_0x0017:
            if (r0 != 0) goto L_0x001b
            r2 = 0
            goto L_0x0026
        L_0x001b:
            try.if$break r0 = new try.if$break     // Catch:{ all -> 0x0028 }
            r0.<init>(r2, r4)     // Catch:{ all -> 0x0028 }
            try.if r2 = r1.m7502a(r0)     // Catch:{ all -> 0x0028 }
            try.if$break r2 = (p098try.C3690if.C3691break) r2     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1)
            return r2
        L_0x0028:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p098try.C3689for.mo43538do(double, java.lang.String):try.if$break");
    }

    /* renamed from: do */
    public synchronized C3690if.C3700try mo43543do(IProovException iProovException) {
        return this.f8824c.mo43553if() ? null : (C3690if.C3700try) m7502a(new C3690if.C3700try(iProovException));
    }

    /* renamed from: do */
    public synchronized C3690if.C3692case mo43539do(C20871for forR) {
        return this.f8824c.mo43553if() ? null : (C3690if.C3692case) m7502a(new C3690if.C3692case(forR));
    }

    /* renamed from: a */
    private synchronized <S extends C3690if> S m7502a(S s) {
        if ((this.f8824c instanceof C3690if.C3697if) && (s instanceof C3690if.C3697if)) {
            C3690if.C3697if ifVar = (C3690if.C3697if) s;
            C3688do doVar = this.f8825d.mo43495do();
            if (doVar != null && doVar.mo43537if()) {
                return null;
            }
            if (ifVar.m46695new().m46680for()) {
                if (doVar == this.f8825d.mo43497if(ifVar.m46695new())) {
                    return null;
                }
            } else if (doVar == ifVar.m46695new()) {
                return null;
            } else {
                this.f8825d.mo43496do(ifVar.m46695new());
            }
        }
        this.f8824c = s;
        this.f8824c.mo43552if(this.f8823b);
        return s;
    }
}
