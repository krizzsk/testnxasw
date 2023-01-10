package com.didiglobal.domainprocessor;

import android.app.Application;

public class DomainProcessor {

    /* renamed from: b */
    private static volatile DomainProcessor f52589b;

    /* renamed from: a */
    private Application f52590a;

    public static DomainProcessor getInstance() {
        if (f52589b == null) {
            synchronized (DomainProcessor.class) {
                if (f52589b == null) {
                    f52589b = new DomainProcessor();
                }
            }
        }
        return f52589b;
    }

    public void init(Application application) {
        this.f52590a = application;
    }

    public Application getApplication() {
        return this.f52590a;
    }
}
