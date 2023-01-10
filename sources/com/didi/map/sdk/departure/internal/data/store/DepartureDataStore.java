package com.didi.map.sdk.departure.internal.data.store;

public class DepartureDataStore {

    /* renamed from: a */
    private static final String f30611a = "DepartureDataStore";

    /* renamed from: b */
    private static DepartureDataStore f30612b;

    /* renamed from: c */
    private boolean f30613c;

    private DepartureDataStore() {
    }

    public static DepartureDataStore getInstance() {
        if (f30612b == null) {
            synchronized (DepartureDataStore.class) {
                if (f30612b == null) {
                    f30612b = new DepartureDataStore();
                }
            }
        }
        return f30612b;
    }

    public boolean IsFirstLaunch() {
        if (!this.f30613c) {
            return false;
        }
        this.f30613c = false;
        return true;
    }
}
