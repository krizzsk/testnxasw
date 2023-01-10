package com.didichuxing.mlcp.drtc.p192a;

import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.enums.DrtcTransactionType;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16694d;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16697g;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16699i;

/* renamed from: com.didichuxing.mlcp.drtc.a.f */
/* compiled from: DrtcTransactionCallbackFactory */
public class C16682f {

    /* renamed from: com.didichuxing.mlcp.drtc.a.f$a */
    /* compiled from: DrtcTransactionCallbackFactory */
    static /* synthetic */ class C16683a {

        /* renamed from: a */
        static final /* synthetic */ int[] f50887a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didichuxing.mlcp.drtc.enums.DrtcTransactionType[] r0 = com.didichuxing.mlcp.drtc.enums.DrtcTransactionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50887a = r0
                com.didichuxing.mlcp.drtc.enums.DrtcTransactionType r1 = com.didichuxing.mlcp.drtc.enums.DrtcTransactionType.create     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50887a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didichuxing.mlcp.drtc.enums.DrtcTransactionType r1 = com.didichuxing.mlcp.drtc.enums.DrtcTransactionType.attach     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f50887a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didichuxing.mlcp.drtc.enums.DrtcTransactionType r1 = com.didichuxing.mlcp.drtc.enums.DrtcTransactionType.detach     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mlcp.drtc.p192a.C16682f.C16683a.<clinit>():void");
        }
    }

    /* renamed from: a */
    public static C16699i m37912a(C16697g gVar) {
        return new C16677d(gVar);
    }

    /* renamed from: a */
    public static C16699i m37911a(C16679e eVar, DrtcTransactionType drtcTransactionType, DrtcSupportedPlugins drtcSupportedPlugins, C16694d dVar) {
        int i = C16683a.f50887a[drtcTransactionType.ordinal()];
        if (i == 1) {
            return new C16675b(eVar);
        }
        if (i == 2) {
            return new C16674a(eVar, drtcSupportedPlugins, dVar);
        }
        if (i != 3) {
            return null;
        }
        return new C16676c(eVar, drtcSupportedPlugins, dVar);
    }
}
