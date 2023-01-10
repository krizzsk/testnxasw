package com.didi.global.map.animation.transition;

import android.content.Context;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.transition.anim.BoxAnim;
import com.didi.global.map.animation.transition.anim.FrameAnim;
import com.didi.global.map.animation.transition.anim.RippleAnimParam;
import com.didi.global.map.animation.transition.anim.TranslateAnim;
import com.didi.global.map.animation.transition.callback.OnBoxAnimEndCallback;
import com.didi.global.map.animation.transition.callback.OnTranslateAnimEndCallback;
import com.didi.global.map.animation.transition.util.AngleManager;
import com.didi.global.map.animation.transition.util.FramesUtil;
import com.didi.global.map.animation.transition.util.LogUtil;
import java.util.List;

public class SodaAnimEngine {
    public static final int AngleFramesMaxIndex = 16;
    public static final int AngleFramesMinIndex = 1;
    public static float DefaultAngle = 0.0f;
    public static int DefaultAngleFrame = 1;
    public static final long DefaultTranslateIntervalTime = 3000;
    public static double DistanceThreshold = 300.0d;
    public static final int IntervalTimeMillis = 100;
    public static final float TranslateIntervalTimeFraction = 1.2f;
    public static final int jumpIntervalTimeMillis = 45;

    /* renamed from: a */
    private Context f24666a;

    /* renamed from: b */
    private int f24667b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SodaAnimLatLng f24668c = null;

    /* renamed from: d */
    private boolean f24669d = false;

    /* renamed from: e */
    private boolean f24670e = false;

    /* renamed from: f */
    private boolean f24671f = false;

    /* renamed from: g */
    private Marker f24672g;

    /* renamed from: h */
    private FrameAnim f24673h;

    /* renamed from: i */
    private List<Circle> f24674i;

    /* renamed from: j */
    private RippleAnimParam f24675j;

    /* renamed from: k */
    private Marker f24676k;

    /* renamed from: l */
    private FrameAnim f24677l;

    /* renamed from: m */
    private List<Circle> f24678m;

    /* renamed from: n */
    private RippleAnimParam f24679n;

    /* renamed from: o */
    private Marker f24680o;

    /* renamed from: p */
    private TranslateAnim f24681p;

    /* renamed from: q */
    private long f24682q = 3600;

    /* renamed from: r */
    private BoxAnim f24683r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public OnTranslateAnimEndCallback f24684s;

    public SodaAnimEngine(Context context) {
        this.f24666a = context;
        if (context != null) {
            LogUtil.m19847i("SodaAnimEngine constructor");
            return;
        }
        throw new NullPointerException("MarkerAnimEngine context == null");
    }

    public SodaAnimEngine setBusinessMarker(Marker marker) {
        this.f24672g = marker;
        return this;
    }

    public void setOnTranslateAnimEndCallback(OnTranslateAnimEndCallback onTranslateAnimEndCallback) {
        this.f24684s = onTranslateAnimEndCallback;
    }

    public SodaAnimEngine setBusinessRippleCircles(List<Circle> list) {
        this.f24674i = list;
        return this;
    }

    public SodaAnimEngine setBusinessRippleAnimParam(RippleAnimParam rippleAnimParam) {
        this.f24675j = rippleAnimParam;
        return this;
    }

    public void doBusinessAnim(boolean z) {
        Marker marker = this.f24672g;
        if (marker == null) {
            LogUtil.m19846e("doBusinessAnim() mBusinessMarker = null");
        } else if (z) {
            if (this.f24673h == null) {
                FrameAnim frameAnim = new FrameAnim(this.f24666a, marker, this.f24674i, this.f24675j);
                this.f24673h = frameAnim;
                frameAnim.setFrames(FramesUtil.getBusinessFrames(this.f24666a));
                this.f24673h.setInfinite(false);
                this.f24673h.setFrameIntervalTimeMillis(45);
            }
            this.f24673h.doFrameAnim(z);
        } else if (isBusinessAnimRunning()) {
            this.f24673h.doFrameAnim(false);
        }
    }

    public void doBusinessRippleAnim(boolean z) {
        if (this.f24672g == null) {
            LogUtil.m19846e("doBusinessRippleAnim() mBusinessMarker = null");
            return;
        }
        FrameAnim frameAnim = this.f24673h;
        if (frameAnim != null) {
            frameAnim.doRippleAnim(z);
        }
    }

    public boolean isBusinessAnimRunning() {
        FrameAnim frameAnim = this.f24673h;
        return frameAnim != null && frameAnim.isRunning();
    }

    public SodaAnimEngine setCustomerMarker(Marker marker) {
        this.f24676k = marker;
        return this;
    }

    public SodaAnimEngine setCustomerRippleCircles(List<Circle> list) {
        this.f24678m = list;
        return this;
    }

    public SodaAnimEngine setCustomerRippleAnimParam(RippleAnimParam rippleAnimParam) {
        this.f24679n = rippleAnimParam;
        return this;
    }

    public void doCustomerAnim(boolean z) {
        Marker marker = this.f24676k;
        if (marker == null) {
            LogUtil.m19846e("doCustomerAnim() mCustomerMarker = null");
        } else if (z) {
            if (this.f24677l == null) {
                FrameAnim frameAnim = new FrameAnim(this.f24666a, marker, this.f24678m, this.f24679n);
                this.f24677l = frameAnim;
                frameAnim.setFrames(FramesUtil.customer_frames);
                this.f24677l.setInfinite(false);
                this.f24677l.setFrameIntervalTimeMillis(45);
            }
            this.f24677l.doFrameAnim(z);
        } else if (isCustomerAnimRunning()) {
            this.f24677l.doFrameAnim(false);
        }
    }

    public void doCustomerRippleAnim(boolean z) {
        if (this.f24676k == null) {
            LogUtil.m19846e("doBusinessRippleAnim() mBusinessMarker = null");
            return;
        }
        FrameAnim frameAnim = this.f24677l;
        if (frameAnim != null) {
            frameAnim.doRippleAnim(z);
        }
    }

    public boolean isCustomerAnimRunning() {
        FrameAnim frameAnim = this.f24677l;
        return frameAnim != null && frameAnim.isRunning();
    }

    public boolean isDeliverTranslateAnimRunning() {
        TranslateAnim translateAnim = this.f24681p;
        return translateAnim != null && translateAnim.isRunning();
    }

    public SodaAnimEngine setDeliveryMarker(Marker marker) {
        this.f24680o = marker;
        return this;
    }

    public SodaAnimEngine setTranslateIntervalTime(long j) {
        long j2 = (long) (((float) j) * 1.2f);
        this.f24682q = j2;
        TranslateAnim translateAnim = this.f24681p;
        if (translateAnim != null) {
            translateAnim.setTranslateIntervalTime(j2);
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19805a(LatLng latLng) {
        Marker marker = this.f24680o;
        if (marker == null) {
            LogUtil.m19846e("doDeliveryTranslateAnim() mDeliveryMarker = null");
            return;
        }
        TranslateAnim translateAnim = new TranslateAnim(this.f24666a, marker);
        this.f24681p = translateAnim;
        translateAnim.setTranslateIntervalTime(this.f24682q);
        this.f24681p.setOnTranslateAnimEndCallback(new OnTranslateAnimEndCallback() {
            public void onTranslateAnimEnd() {
                if (SodaAnimEngine.this.f24684s != null) {
                    SodaAnimEngine.this.f24684s.onTranslateAnimEnd();
                }
            }
        });
        this.f24681p.doTranslateAnim(latLng);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19804a() {
        Marker marker = this.f24680o;
        if (marker == null) {
            LogUtil.m19846e("doBoxAnimInternal() mDeliveryMarker = null");
            return;
        }
        if (this.f24683r == null) {
            this.f24683r = new BoxAnim(this.f24666a, marker);
        }
        this.f24683r.doBoxAnim();
    }

    public boolean doBoxAnim() {
        if (!this.f24669d) {
            LogUtil.m19846e("doBoxAnim() isForeground == false");
            return false;
        } else if (this.f24667b == 2 && !this.f24670e) {
            this.f24670e = true;
            m19808a((OnTranslateAnimEndCallback) new OnTranslateAnimEndCallback() {
                public void onTranslateAnimEnd() {
                    SodaAnimEngine.this.m19804a();
                }
            });
            return true;
        } else if (this.f24667b != 4 || this.f24671f) {
            return false;
        } else {
            this.f24671f = true;
            m19808a((OnTranslateAnimEndCallback) new OnTranslateAnimEndCallback() {
                public void onTranslateAnimEnd() {
                    SodaAnimEngine.this.m19804a();
                }
            });
            return true;
        }
    }

    public SodaAnimEngine setAnimState(int i) {
        this.f24667b = i;
        LogUtil.m19847i("setAnimState() mAnimState: " + this.f24667b);
        return this;
    }

    /* renamed from: a */
    private void m19808a(final OnTranslateAnimEndCallback onTranslateAnimEndCallback) {
        TranslateAnim translateAnim = this.f24681p;
        if (translateAnim != null && translateAnim.isRunning()) {
            this.f24681p.setOnTranslateAnimEndCallback(new OnTranslateAnimEndCallback() {
                public void onTranslateAnimEnd() {
                    OnTranslateAnimEndCallback onTranslateAnimEndCallback = onTranslateAnimEndCallback;
                    if (onTranslateAnimEndCallback != null) {
                        onTranslateAnimEndCallback.onTranslateAnimEnd();
                    }
                }
            });
        } else if (onTranslateAnimEndCallback != null) {
            onTranslateAnimEndCallback.onTranslateAnimEnd();
        }
    }

    /* renamed from: a */
    private void m19807a(final OnBoxAnimEndCallback onBoxAnimEndCallback) {
        BoxAnim boxAnim = this.f24683r;
        if (boxAnim != null && boxAnim.isRunning()) {
            this.f24683r.setOnBoxAnimEndCallback(new OnBoxAnimEndCallback() {
                public void onBoxAnimEnd() {
                    OnBoxAnimEndCallback onBoxAnimEndCallback = onBoxAnimEndCallback;
                    if (onBoxAnimEndCallback != null) {
                        onBoxAnimEndCallback.onBoxAnimEnd();
                    }
                }
            });
        } else if (onBoxAnimEndCallback != null) {
            onBoxAnimEndCallback.onBoxAnimEnd();
        }
    }

    public void onLocationChanged(SodaAnimLatLng sodaAnimLatLng) {
        if (!this.f24669d) {
            LogUtil.m19846e("onLocationChanged() isForeground == false");
        } else if (this.f24667b == 0) {
            LogUtil.m19846e("onLocationChanged() mAnimState == SodaAnimState.UNKNOWN");
        } else if (sodaAnimLatLng == null || sodaAnimLatLng.latLng == null) {
            LogUtil.m19846e("onLocationChanged() sodaLatLng == null || sodaLatLng.latLng == null");
        } else {
            SodaAnimLatLng sodaAnimLatLng2 = this.f24668c;
            if (sodaAnimLatLng2 == null || !sodaAnimLatLng2.equals(sodaAnimLatLng)) {
                this.f24668c = sodaAnimLatLng;
                int i = this.f24667b;
                if (i == 1) {
                    this.f24670e = false;
                    this.f24671f = false;
                    m19805a(sodaAnimLatLng.latLng);
                } else if (i == 2) {
                    doBoxAnim();
                } else if (i == 3) {
                    this.f24671f = false;
                    m19807a((OnBoxAnimEndCallback) new OnBoxAnimEndCallback() {
                        public void onBoxAnimEnd() {
                            SodaAnimEngine sodaAnimEngine = SodaAnimEngine.this;
                            sodaAnimEngine.m19805a(sodaAnimEngine.f24668c.latLng);
                        }
                    });
                } else if (i != 4) {
                    LogUtil.m19846e("onLocationChanged() switch to default");
                } else {
                    doBoxAnim();
                    m19807a((OnBoxAnimEndCallback) new OnBoxAnimEndCallback() {
                        public void onBoxAnimEnd() {
                            SodaAnimEngine sodaAnimEngine = SodaAnimEngine.this;
                            sodaAnimEngine.m19805a(sodaAnimEngine.f24668c.latLng);
                        }
                    });
                }
            } else {
                LogUtil.m19846e("onLocationChanged() mLastSodaLatLng.equals(sodaLatLng)");
            }
        }
    }

    public void setForeground(boolean z) {
        this.f24669d = z;
    }

    public void onResume() {
        this.f24669d = true;
    }

    public void onPause() {
        this.f24669d = false;
    }

    public void onStop() {
        this.f24669d = false;
    }

    public void onDestroy() {
        this.f24667b = 0;
        this.f24668c = null;
        this.f24669d = false;
        this.f24670e = false;
        this.f24671f = false;
        AngleManager.getInstant().destroy();
        FrameAnim frameAnim = this.f24673h;
        if (frameAnim != null) {
            frameAnim.destory();
            this.f24673h = null;
        }
        FrameAnim frameAnim2 = this.f24677l;
        if (frameAnim2 != null) {
            frameAnim2.destory();
            this.f24677l = null;
        }
        TranslateAnim translateAnim = this.f24681p;
        if (translateAnim != null) {
            translateAnim.destory();
            this.f24681p = null;
        }
        BoxAnim boxAnim = this.f24683r;
        if (boxAnim != null) {
            boxAnim.destory();
            this.f24683r = null;
        }
    }
}
