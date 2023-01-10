package com.didi.hawaii.mapsdkv2.core;

import android.graphics.PointF;

public final class Gesture {
    public static final int MOTION_ACTION_DOWN = 0;
    public static final int MOTION_ACTION_MOVE = 2;
    public static final int MOTION_ACTION_POINTER_DOWN = 5;
    public static final int MOTION_ACTION_POINTER_UP = 6;
    public static final int MOTION_ACTION_UP = 1;
    public static final int MOTION_DOUBLE_FINGER_TAP = 36;
    public static final int MOTION_DOUBLE_TAP = 23;
    public static final int MOTION_DOUBLE_TAP_DOWN = 33;
    public static final int MOTION_DOUBLE_TAP_MOVE = 35;
    public static final int MOTION_DOUBLE_TAP_UP = 34;
    public static final int MOTION_DOUBLE_TAP_ZOOMIN = 32;
    public static final int MOTION_FLING = 19;
    public static final int MOTION_LONG_CLICK = 18;
    public static final int MOTION_ROTATE_MOVE = 21;
    public static final int MOTION_SCALE_MOVE = 22;
    public static final int MOTION_SCROLL = 8;
    public static final int MOTION_SINGLE_CLICK = 17;
    public static final int MOTION_SKEW_MOVE = 20;

    /* renamed from: a */
    private static final Object f26222a = new Object();

    /* renamed from: b */
    private static Gesture f26223b = null;

    /* renamed from: c */
    private static int f26224c = 0;

    /* renamed from: d */
    private static final int f26225d = 5;

    /* renamed from: e */
    private int f26226e;

    /* renamed from: f */
    private float f26227f;

    /* renamed from: g */
    private float f26228g;

    /* renamed from: h */
    private Object f26229h;

    /* renamed from: i */
    private Gesture f26230i;

    /* renamed from: j */
    private boolean f26231j;

    /* renamed from: k */
    private GLOverlayView f26232k;
    public PointF postCenter;
    public double postVector;
    public PointF preCenter;
    public double preVector;

    private Gesture(float f, float f2, int i) {
        this.f26227f = f;
        this.f26228g = f2;
        this.f26226e = i;
        this.f26231j = false;
    }

    private Gesture() {
    }

    public int getType() {
        return this.f26226e;
    }

    public float getX() {
        return this.f26227f;
    }

    public float getY() {
        return this.f26228g;
    }

    public Object getObj() {
        return this.f26229h;
    }

    public void setObj(Object obj) {
        this.f26229h = obj;
    }

    public GLOverlayView getGlOverlayView() {
        return this.f26232k;
    }

    public void setGlOverlayView(GLOverlayView gLOverlayView) {
        this.f26232k = gLOverlayView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo76066a() {
        if (!this.f26231j) {
            synchronized (f26222a) {
                if (f26224c < 5) {
                    f26224c++;
                    this.f26230i = f26223b;
                    this.f26229h = null;
                    this.preCenter = null;
                    this.postCenter = null;
                    this.preVector = 0.0d;
                    this.postVector = 0.0d;
                    this.f26232k = null;
                    f26223b = this;
                    this.f26231j = true;
                }
            }
        }
    }

    /* renamed from: b */
    private static Gesture m20722b() {
        synchronized (f26222a) {
            Gesture gesture = f26223b;
            if (gesture == null) {
                Gesture gesture2 = new Gesture();
                return gesture2;
            }
            f26223b = gesture.f26230i;
            f26224c--;
            return gesture;
        }
    }

    /* renamed from: a */
    static Gesture m20720a(float f, float f2, int i, Object obj) {
        Gesture b = m20722b();
        b.f26230i = null;
        b.f26227f = f;
        b.f26228g = f2;
        b.f26226e = i;
        b.f26229h = obj;
        b.f26231j = false;
        return b;
    }

    /* renamed from: a */
    static Gesture m20721a(int i, Object obj) {
        return m20720a(0.0f, 0.0f, i, obj);
    }
}
