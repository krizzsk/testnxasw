package com.didichuxing.bigdata.p174dp.locsdk.spi;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.spi.UserInfoProvider */
public class UserInfoProvider {

    /* renamed from: a */
    private static IUserInfoProvider f48824a;

    static {
        f48824a = new EmptyProvider();
        try {
            Iterator<S> it = ServiceLoader.load(IUserInfoProvider.class).iterator();
            while (it.hasNext()) {
                IUserInfoProvider iUserInfoProvider = (IUserInfoProvider) it.next();
                if (iUserInfoProvider != null) {
                    f48824a = iUserInfoProvider;
                }
            }
        } catch (Exception unused) {
        }
    }

    public static IUserInfoProvider getDefault() {
        return f48824a;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.spi.UserInfoProvider$EmptyProvider */
    private static final class EmptyProvider implements IUserInfoProvider {
        public String getPhone() {
            return "";
        }

        public String getPlateNumber() {
            return "";
        }

        public String getToken() {
            return "";
        }

        public String getUid() {
            return "";
        }

        private EmptyProvider() {
        }
    }
}
