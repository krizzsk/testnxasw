package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public abstract class ZipHeader {

    /* renamed from: a */
    private HeaderSignature f6838a;

    public HeaderSignature getSignature() {
        return this.f6838a;
    }

    public void setSignature(HeaderSignature headerSignature) {
        this.f6838a = headerSignature;
    }
}
