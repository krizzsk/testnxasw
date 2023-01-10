package com.p226hp.hpl.sparta;

/* renamed from: com.hp.hpl.sparta.ParseSource */
public interface ParseSource {
    public static final ParseLog DEFAULT_LOG = new C20729c();
    public static final int MAXLOOKAHEAD = 71;

    int getLineNumber();

    String getSystemId();

    String toString();
}
