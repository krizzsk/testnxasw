package net.lingala.zip4j.model;

import java.nio.charset.Charset;

public class Zip4jConfig {

    /* renamed from: a */
    private Charset f6818a;

    /* renamed from: b */
    private int f6819b;

    public Zip4jConfig(Charset charset, int i) {
        this.f6818a = charset;
        this.f6819b = i;
    }

    public Charset getCharset() {
        return this.f6818a;
    }

    public int getBufferSize() {
        return this.f6819b;
    }
}
