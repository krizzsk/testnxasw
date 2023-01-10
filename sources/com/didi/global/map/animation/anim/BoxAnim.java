package com.didi.global.map.animation.anim;

import android.content.Context;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.callback.OnBoxAnimEndCallback;
import com.didi.global.map.animation.callback.OnFrameAnimEndCallback;
import com.didi.global.map.animation.util.AngleManager;
import com.didi.global.map.animation.util.FramesUtil;
import com.didi.global.map.animation.util.LogUtil;

public class BoxAnim {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f24618a;

    /* renamed from: b */
    private Marker f24619b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f24620c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f24621d;

    /* renamed from: e */
    private FrameAnim f24622e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FrameAnim f24623f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f24624g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnBoxAnimEndCallback f24625h;

    public BoxAnim(Context context, Marker marker) {
        this.f24618a = context;
        this.f24619b = marker;
    }

    public boolean isRunning() {
        return this.f24624g;
    }

    public void setOnBoxAnimEndCallback(OnBoxAnimEndCallback onBoxAnimEndCallback) {
        this.f24625h = onBoxAnimEndCallback;
    }

    public void doBoxAnim() {
        if (this.f24619b == null) {
            LogUtil.m19855e("doBoxAnim() mMarker = null");
            return;
        }
        this.f24624g = true;
        int toIndex = AngleManager.getInstant().getToIndex();
        this.f24620c = toIndex;
        this.f24621d = 11;
        if (toIndex >= 1 && toIndex <= 9) {
            this.f24621d = 7;
        }
        if (this.f24622e == null) {
            FrameAnim frameAnim = new FrameAnim(this.f24618a, this.f24619b);
            this.f24622e = frameAnim;
            frameAnim.setInfinite(false);
            this.f24622e.setOnFrameAnimEndCallback(new OnFrameAnimEndCallback() {
                public void onFrameAnimEnd() {
                    BoxAnim.this.f24623f.setFrames(FramesUtil.getBoxFrames(BoxAnim.this.f24618a, BoxAnim.this.f24621d));
                    BoxAnim.this.f24623f.doFrameAnim(true);
                }
            });
        }
        if (this.f24623f == null) {
            FrameAnim frameAnim2 = new FrameAnim(this.f24618a, this.f24619b);
            this.f24623f = frameAnim2;
            frameAnim2.setInfinite(false);
            this.f24623f.setOnFrameAnimEndCallback(new OnFrameAnimEndCallback() {
                public void onFrameAnimEnd() {
                    BoxAnim boxAnim = BoxAnim.this;
                    int unused = boxAnim.f24620c = boxAnim.f24621d;
                    AngleManager.getInstant().setFromIndex(BoxAnim.this.f24621d);
                    AngleManager.getInstant().setToIndex(BoxAnim.this.f24621d);
                    boolean unused2 = BoxAnim.this.f24624g = false;
                    if (BoxAnim.this.f24625h != null) {
                        BoxAnim.this.f24625h.onBoxAnimEnd();
                    }
                }
            });
        }
        int[] rotateFrames = FramesUtil.getRotateFrames(this.f24618a, this.f24620c, this.f24621d);
        if (rotateFrames == null || rotateFrames.length <= 0) {
            this.f24623f.setFrames(FramesUtil.getBoxFrames(this.f24618a, this.f24621d));
            this.f24623f.doFrameAnim(true);
            return;
        }
        this.f24622e.setFrames(rotateFrames);
        this.f24622e.doFrameAnim(true);
    }

    public void destory() {
        this.f24624g = false;
        this.f24625h = null;
        FrameAnim frameAnim = this.f24622e;
        if (frameAnim != null) {
            frameAnim.destory();
            this.f24622e = null;
        }
        FrameAnim frameAnim2 = this.f24623f;
        if (frameAnim2 != null) {
            frameAnim2.destory();
            this.f24623f = null;
        }
    }
}
