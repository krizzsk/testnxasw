package com.didi.global.map.animation.util;

import android.content.Context;
import com.didi.global.map.animation.SodaAnimEngine;

public class AngleManager {

    /* renamed from: a */
    private static final AngleManager f24754a = new AngleManager();

    /* renamed from: b */
    private int f24755b = SodaAnimEngine.DefaultAngleFrame;

    /* renamed from: c */
    private int f24756c = SodaAnimEngine.DefaultAngleFrame;

    public static AngleManager getInstant() {
        return f24754a;
    }

    public int getFromIndex() {
        return this.f24755b;
    }

    public void setFromIndex(int i) {
        this.f24755b = i;
    }

    public int getToIndex() {
        return this.f24756c;
    }

    public void setToIndex(int i) {
        this.f24756c = i;
    }

    public int[] getRotateFrames(Context context) {
        return FramesUtil.getRotateFrames(context, this.f24755b, this.f24756c);
    }

    public int[] getRunningFrames(Context context) {
        return FramesUtil.getDeliveryFrames(context, this.f24756c);
    }

    public int getRunningFrame(Context context) {
        return FramesUtil.getDeliveryFrame(context, this.f24756c);
    }

    public void destroy() {
        this.f24755b = SodaAnimEngine.DefaultAngleFrame;
        this.f24756c = SodaAnimEngine.DefaultAngleFrame;
    }
}
