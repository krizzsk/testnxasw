package org.bouncycastle.util;

public class StoreException extends RuntimeException {

    /* renamed from: _e */
    private Throwable f8418_e;

    public StoreException(String str, Throwable th) {
        super(str);
        this.f8418_e = th;
    }

    public Throwable getCause() {
        return this.f8418_e;
    }
}
