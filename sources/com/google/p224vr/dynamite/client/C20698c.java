package com.google.p224vr.dynamite.client;

/* renamed from: com.google.vr.dynamite.client.c */
/* compiled from: LoaderException */
public final class C20698c extends Exception {

    /* renamed from: a */
    private final int f56664a = 1;

    public C20698c(int i) {
    }

    public final String getMessage() {
        int i = this.f56664a;
        String str = i != 1 ? i != 2 ? "Unknown error" : "Package obsolete" : "Package not available";
        StringBuilder sb = new StringBuilder(str.length() + 17);
        sb.append("LoaderException{");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
