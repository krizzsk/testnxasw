package com.didi.beatles.p101im.debug;

/* renamed from: com.didi.beatles.im.debug.IMMethodTracker */
public class IMMethodTracker {

    /* renamed from: a */
    private static final boolean f11046a = false;

    /* renamed from: b */
    private static final String f11047b = "ImMethod";

    /* renamed from: d */
    private static IMMethodTracker f11048d;

    /* renamed from: c */
    private String f11049c;

    public void track() {
    }

    public void track(String str) {
    }

    public void track(Object... objArr) {
    }

    private IMMethodTracker(String str) {
        this.f11049c = str;
    }

    public static IMMethodTracker newInstance(String str) {
        if (f11048d == null) {
            f11048d = new IMMethodTracker(str);
        }
        return f11048d;
    }

    /* renamed from: a */
    private static String m9609a() {
        return new Exception().getStackTrace()[2].getMethodName();
    }
}
