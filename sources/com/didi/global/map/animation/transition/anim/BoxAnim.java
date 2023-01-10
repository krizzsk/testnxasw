package com.didi.global.map.animation.transition.anim;

import android.content.Context;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.transition.callback.OnBoxAnimEndCallback;
import com.didi.global.map.animation.transition.callback.OnFrameAnimEndCallback;
import com.didi.global.map.animation.transition.util.AngleManager;
import com.didi.global.map.animation.transition.util.FramesUtil;
import com.didi.global.map.animation.transition.util.LogUtil;

public class BoxAnim {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f24685a;

    /* renamed from: b */
    private Marker f24686b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f24687c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f24688d;

    /* renamed from: e */
    private FrameAnim f24689e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FrameAnim f24690f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f24691g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnBoxAnimEndCallback f24692h;

    public BoxAnim(Context context, Marker marker) {
        this.f24685a = context;
        this.f24686b = marker;
    }

    public boolean isRunning() {
        return this.f24691g;
    }

    public void setOnBoxAnimEndCallback(OnBoxAnimEndCallback onBoxAnimEndCallback) {
        this.f24692h = onBoxAnimEndCallback;
    }

    public void doBoxAnim() {
        if (this.f24686b == null) {
            LogUtil.m19846e("doBoxAnim() mMarker = null");
            return;
        }
        this.f24691g = true;
        int toIndex = AngleManager.getInstant().getToIndex();
        this.f24687c = toIndex;
        this.f24688d = 11;
        if (toIndex >= 1 && toIndex <= 9) {
            this.f24688d = 7;
        }
        if (this.f24689e == null) {
            FrameAnim frameAnim = new FrameAnim(this.f24685a, this.f24686b);
            this.f24689e = frameAnim;
            frameAnim.setInfinite(false);
            this.f24689e.setOnFrameAnimEndCallback(new OnFrameAnimEndCallback() {
                public void onFrameAnimEnd() {
                    BoxAnim.this.f24690f.setFrames(FramesUtil.getBoxFrames(BoxAnim.this.f24685a, BoxAnim.this.f24688d));
                    BoxAnim.this.f24690f.doFrameAnim(true);
                }
            });
        }
        if (this.f24690f == null) {
            FrameAnim frameAnim2 = new FrameAnim(this.f24685a, this.f24686b);
            this.f24690f = frameAnim2;
            frameAnim2.setInfinite(false);
            this.f24690f.setOnFrameAnimEndCallback(new OnFrameAnimEndCallback() {
                public void onFrameAnimEnd() {
                    BoxAnim boxAnim = BoxAnim.this;
                    int unused = boxAnim.f24687c = boxAnim.f24688d;
                    AngleManager.getInstant().setFromIndex(BoxAnim.this.f24688d);
                    AngleManager.getInstant().setToIndex(BoxAnim.this.f24688d);
                    boolean unused2 = BoxAnim.this.f24691g = false;
                    if (BoxAnim.this.f24692h != null) {
                        BoxAnim.this.f24692h.onBoxAnimEnd();
                    }
                }
            });
        }
        int[] rotateFrames = FramesUtil.getRotateFrames(this.f24685a, this.f24687c, this.f24688d);
        if (rotateFrames == null || rotateFrames.length <= 0) {
            this.f24690f.setFrames(FramesUtil.getBoxFrames(this.f24685a, this.f24688d));
            this.f24690f.doFrameAnim(true);
            return;
        }
        this.f24689e.setFrames(rotateFrames);
        this.f24689e.doFrameAnim(true);
    }

    public void destory() {
        this.f24691g = false;
        this.f24692h = null;
        FrameAnim frameAnim = this.f24689e;
        if (frameAnim != null) {
            frameAnim.destory();
            this.f24689e = null;
        }
        FrameAnim frameAnim2 = this.f24690f;
        if (frameAnim2 != null) {
            frameAnim2.destory();
            this.f24690f = null;
        }
    }
}
