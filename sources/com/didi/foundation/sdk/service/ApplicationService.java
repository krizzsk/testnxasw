package com.didi.foundation.sdk.service;

import com.didichuxing.foundation.spi.ServiceLoader;

public final class ApplicationService implements ApplicationServiceProvider {

    /* renamed from: a */
    private final ApplicationServiceProvider f23155a;

    private ApplicationService() {
        this.f23155a = (ApplicationServiceProvider) ServiceLoader.load(ApplicationServiceProvider.class).get();
    }

    public static final ApplicationService getInstance() {
        return Singleton.INSTANCE;
    }

    public final int getVersionCode() {
        ApplicationServiceProvider applicationServiceProvider = this.f23155a;
        if (applicationServiceProvider != null) {
            return applicationServiceProvider.getVersionCode();
        }
        return 0;
    }

    public final String getVersionName() {
        ApplicationServiceProvider applicationServiceProvider = this.f23155a;
        if (applicationServiceProvider != null) {
            return applicationServiceProvider.getVersionName();
        }
        return null;
    }

    public final boolean isDebuggable() {
        ApplicationServiceProvider applicationServiceProvider = this.f23155a;
        return applicationServiceProvider != null && applicationServiceProvider.isDebuggable();
    }

    public final String getChannelId() {
        ApplicationServiceProvider applicationServiceProvider = this.f23155a;
        if (applicationServiceProvider != null) {
            return applicationServiceProvider.getChannelId();
        }
        return null;
    }

    private static final class Singleton {
        static final ApplicationService INSTANCE = new ApplicationService();

        private Singleton() {
        }
    }
}
