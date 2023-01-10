package com.didi.global.map.animation.transition.util;

import android.content.Context;
import com.didi.global.map.animation.transition.SodaAnimEngine;

public class AngleManager {

    /* renamed from: a */
    private static final AngleManager f24733a = new AngleManager();

    /* renamed from: b */
    private int f24734b = SodaAnimEngine.DefaultAngleFrame;

    /* renamed from: c */
    private int f24735c = SodaAnimEngine.DefaultAngleFrame;

    public static AngleManager getInstant() {
        return f24733a;
    }

    public int getFromIndex() {
        return this.f24734b;
    }

    public void setFromIndex(int i) {
        this.f24734b = i;
    }

    public int getToIndex() {
        return this.f24735c;
    }

    public void setToIndex(int i) {
        this.f24735c = i;
    }

    public int[] getRotateFrames(Context context) {
        return FramesUtil.getRotateFrames(context, this.f24734b, this.f24735c);
    }

    public int[] getRunningFrames(Context context) {
        return FramesUtil.getDeliveryFrames(context, this.f24735c);
    }

    public int getRunningFrame(Context context) {
        return FramesUtil.getDeliveryFrame(context, this.f24735c);
    }

    public void destroy() {
        this.f24734b = SodaAnimEngine.DefaultAngleFrame;
        this.f24735c = SodaAnimEngine.DefaultAngleFrame;
    }
}
