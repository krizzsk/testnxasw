package com.didi.foundation.sdk.service;

import com.didichuxing.foundation.spi.ServiceLoader;

public final class DeviceService implements DeviceServiceProvider {

    /* renamed from: a */
    private final DeviceServiceProvider f23163a;

    private DeviceService() {
        this.f23163a = (DeviceServiceProvider) ServiceLoader.load(DeviceServiceProvider.class).get();
    }

    public static final DeviceService getInstance() {
        return Singleton.INSTANCE;
    }

    public final String getDeviceId() {
        DeviceServiceProvider deviceServiceProvider = this.f23163a;
        if (deviceServiceProvider != null) {
            return deviceServiceProvider.getDeviceId();
        }
        return null;
    }

    public final String getUuid() {
        DeviceServiceProvider deviceServiceProvider = this.f23163a;
        if (deviceServiceProvider != null) {
            return deviceServiceProvider.getUuid();
        }
        return null;
    }

    private static final class Singleton {
        static final DeviceService INSTANCE = new DeviceService();

        private Singleton() {
        }
    }
}
