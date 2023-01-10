package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.jni.JniHelper;

public final class GLOverlayLayer implements Comparable<GLOverlayLayer> {
    public static final GLOverlayLayer LANE_TEXT = new GLOverlayLayer(6);
    public static final GLOverlayLayer LOCATOR = new GLOverlayLayer(29);
    public static final GLOverlayLayer MASKLAYER = new GLOverlayLayer(3);
    public static final GLOverlayLayer MAX = new GLOverlayLayer(30);
    public static final GLOverlayLayer OVERLAY = new GLOverlayLayer(24);
    public static final GLOverlayLayer ROUTE = new GLOverlayLayer(9);
    public static final GLOverlayLayer TILE = new GLOverlayLayer(8);

    /* renamed from: a */
    static final GLOverlayLayer f26179a = new GLOverlayLayer(0);

    /* renamed from: b */
    final int f26180b;

    private GLOverlayLayer(int i) {
        this.f26180b = i;
    }

    public static int getZIndexStart(GLOverlayLayer gLOverlayLayer) {
        return JniHelper.getZIndexStart(gLOverlayLayer);
    }

    public boolean equals(Object obj) {
        return (obj instanceof GLOverlayLayer) && ((GLOverlayLayer) obj).f26180b == this.f26180b;
    }

    public int compareTo(GLOverlayLayer gLOverlayLayer) {
        return this.f26180b - gLOverlayLayer.f26180b;
    }
}
