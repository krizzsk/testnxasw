package org.bouncycastle.util;

public class StreamParsingException extends Exception {

    /* renamed from: _e */
    Throwable f8419_e;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.f8419_e = th;
    }

    public Throwable getCause() {
        return this.f8419_e;
    }
}
