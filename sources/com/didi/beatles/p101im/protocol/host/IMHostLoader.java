package com.didi.beatles.p101im.protocol.host;

import com.didi.beatles.p101im.protocol.service.IMSpiServiceProvider;
import com.didi.beatles.p101im.utils.IMLog;

/* renamed from: com.didi.beatles.im.protocol.host.IMHostLoader */
public class IMHostLoader {

    /* renamed from: a */
    private static final String f11404a = IMHostLoader.class.getSimpleName();

    /* renamed from: b */
    private static final IMHostService f11405b = new IMHostService() {
        public boolean invoke(String str, Object... objArr) {
            return false;
        }
    };

    private IMHostLoader() {
    }

    /* renamed from: a */
    private static IMHostLoader m9872a() {
        return Holder.INSTANCE;
    }

    /* renamed from: com.didi.beatles.im.protocol.host.IMHostLoader$Holder */
    private static final class Holder {
        /* access modifiers changed from: private */
        public static final IMHostLoader INSTANCE = new IMHostLoader();

        private Holder() {
        }
    }

    public static IMHostService getHost() {
        return m9872a().m9873b();
    }

    /* renamed from: b */
    private IMHostService m9873b() {
        IMHostService iMHostService = (IMHostService) IMSpiServiceProvider.getService(IMHostService.class);
        if (iMHostService != null) {
            return iMHostService;
        }
        IMLog.m10021e(f11404a, "[getPlugin] No one plugin implement compiled. -> ");
        return f11405b;
    }
}
