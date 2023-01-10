package com.didi.global.map.animation;

import android.content.Context;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.anim.BoxAnim;
import com.didi.global.map.animation.anim.FrameAnim;
import com.didi.global.map.animation.anim.RippleAnimParam;
import com.didi.global.map.animation.anim.TranslateAnim;
import com.didi.global.map.animation.callback.OnBoxAnimEndCallback;
import com.didi.global.map.animation.callback.OnTranslateAnimEndCallback;
import com.didi.global.map.animation.util.AngleManager;
import com.didi.global.map.animation.util.FramesUtil;
import com.didi.global.map.animation.util.LogUtil;
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
    private Context f24600a;

    /* renamed from: b */
    private int f24601b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SodaAnimLatLng f24602c = null;

    /* renamed from: d */
    private boolean f24603d = false;

    /* renamed from: e */
    private boolean f24604e = false;

    /* renamed from: f */
    private boolean f24605f = false;

    /* renamed from: g */
    private Marker f24606g;

    /* renamed from: h */
    private FrameAnim f24607h;

    /* renamed from: i */
    private List<Circle> f24608i;

    /* renamed from: j */
    private RippleAnimParam f24609j;

    /* renamed from: k */
    private Marker f24610k;

    /* renamed from: l */
    private FrameAnim f24611l;

    /* renamed from: m */
    private List<Circle> f24612m;

    /* renamed from: n */
    private RippleAnimParam f24613n;

    /* renamed from: o */
    private Marker f24614o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public TranslateAnim f24615p;

    /* renamed from: q */
    private long f24616q = 3600;

    /* renamed from: r */
    private BoxAnim f24617r;

    public SodaAnimEngine(Context context) {
        this.f24600a = context;
        if (context != null) {
            LogUtil.m19856i("SodaAnimEngine constructor");
            return;
        }
        throw new NullPointerException("MarkerAnimEngine context == null");
    }

    public SodaAnimEngine setBusinessMarker(Marker marker) {
        this.f24606g = marker;
        return this;
    }

    public SodaAnimEngine setBusinessRippleCircles(List<Circle> list) {
        this.f24608i = list;
        return this;
    }

    public SodaAnimEngine setBusinessRippleAnimParam(RippleAnimParam rippleAnimParam) {
        this.f24609j = rippleAnimParam;
        return this;
    }

    public void doBusinessAnim(boolean z) {
        Marker marker = this.f24606g;
        if (marker == null) {
            LogUtil.m19855e("doBusinessAnim() mBusinessMarker = null");
        } else if (z) {
            if (this.f24607h == null) {
                FrameAnim frameAnim = new FrameAnim(this.f24600a, marker, this.f24608i, this.f24609j);
                this.f24607h = frameAnim;
                frameAnim.setFrames(FramesUtil.getBusinessFrames(this.f24600a));
                this.f24607h.setInfinite(false);
                this.f24607h.setFrameIntervalTimeMillis(45);
            }
            this.f24607h.doFrameAnim(z);
        } else if (isBusinessAnimRunning()) {
            this.f24607h.doFrameAnim(false);
        }
    }

    public void doBusinessRippleAnim(boolean z) {
        if (this.f24606g == null) {
            LogUtil.m19855e("doBusinessRippleAnim() mBusinessMarker = null");
            return;
        }
        FrameAnim frameAnim = this.f24607h;
        if (frameAnim != null) {
            frameAnim.doRippleAnim(z);
        }
    }

    public boolean isBusinessAnimRunning() {
        FrameAnim frameAnim = this.f24607h;
        return frameAnim != null && frameAnim.isRunning();
    }

    public SodaAnimEngine setCustomerMarker(Marker marker) {
        this.f24610k = marker;
        return this;
    }

    public SodaAnimEngine setCustomerRippleCircles(List<Circle> list) {
        this.f24612m = list;
        return this;
    }

    public SodaAnimEngine setCustomerRippleAnimParam(RippleAnimParam rippleAnimParam) {
        this.f24613n = rippleAnimParam;
        return this;
    }

    public void doCustomerAnim(boolean z) {
        Marker marker = this.f24610k;
        if (marker == null) {
            LogUtil.m19855e("doCustomerAnim() mCustomerMarker = null");
        } else if (z) {
            if (this.f24611l == null) {
                FrameAnim frameAnim = new FrameAnim(this.f24600a, marker, this.f24612m, this.f24613n);
                this.f24611l = frameAnim;
                frameAnim.setFrames(FramesUtil.customer_frames);
                this.f24611l.setInfinite(false);
                this.f24611l.setFrameIntervalTimeMillis(45);
            }
            this.f24611l.doFrameAnim(z);
        } else if (isCustomerAnimRunning()) {
            this.f24611l.doFrameAnim(false);
        }
    }

    public void doCustomerRippleAnim(boolean z) {
        if (this.f24610k == null) {
            LogUtil.m19855e("doBusinessRippleAnim() mBusinessMarker = null");
            return;
        }
        FrameAnim frameAnim = this.f24611l;
        if (frameAnim != null) {
            frameAnim.doRippleAnim(z);
        }
    }

    public boolean isCustomerAnimRunning() {
        FrameAnim frameAnim = this.f24611l;
        return frameAnim != null && frameAnim.isRunning();
    }

    public SodaAnimEngine setDeliveryMarker(Marker marker) {
        this.f24614o = marker;
        return this;
    }

    public SodaAnimEngine setTranslateIntervalTime(long j) {
        long j2 = (long) (((float) j) * 1.2f);
        this.f24616q = j2;
        TranslateAnim translateAnim = this.f24615p;
        if (translateAnim != null) {
            translateAnim.setTranslateIntervalTime(j2);
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19762a(LatLng latLng) {
        Marker marker = this.f24614o;
        if (marker == null) {
            LogUtil.m19855e("doDeliveryTranslateAnim() mDeliveryMarker = null");
            return;
        }
        if (this.f24615p == null) {
            TranslateAnim translateAnim = new TranslateAnim(this.f24600a, marker);
            this.f24615p = translateAnim;
            translateAnim.setTranslateIntervalTime(this.f24616q);
        }
        this.f24615p.doTranslateAnim(latLng);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19761a() {
        Marker marker = this.f24614o;
        if (marker == null) {
            LogUtil.m19855e("doBoxAnimInternal() mDeliveryMarker = null");
            return;
        }
        if (this.f24617r == null) {
            this.f24617r = new BoxAnim(this.f24600a, marker);
        }
        this.f24617r.doBoxAnim();
    }

    public boolean doBoxAnim() {
        if (!this.f24603d) {
            LogUtil.m19855e("doBoxAnim() isForeground == false");
            return false;
        } else if (this.f24601b == 2 && !this.f24604e) {
            this.f24604e = true;
            m19766a((OnTranslateAnimEndCallback) new OnTranslateAnimEndCallback() {
                public void onTranslateAnimEnd() {
                    SodaAnimEngine.this.m19761a();
                }
            });
            return true;
        } else if (this.f24601b != 4 || this.f24605f) {
            return false;
        } else {
            this.f24605f = true;
            m19766a((OnTranslateAnimEndCallback) new OnTranslateAnimEndCallback() {
                public void onTranslateAnimEnd() {
                    SodaAnimEngine.this.m19761a();
                }
            });
            return true;
        }
    }

    public SodaAnimEngine setAnimState(int i) {
        this.f24601b = i;
        LogUtil.m19856i("setAnimState() mAnimState: " + this.f24601b);
        return this;
    }

    /* renamed from: a */
    private void m19766a(final OnTranslateAnimEndCallback onTranslateAnimEndCallback) {
        TranslateAnim translateAnim = this.f24615p;
        if (translateAnim != null && translateAnim.isRunning()) {
            this.f24615p.setOnTranslateAnimEndCallback(new OnTranslateAnimEndCallback() {
                public void onTranslateAnimEnd() {
                    OnTranslateAnimEndCallback onTranslateAnimEndCallback = onTranslateAnimEndCallback;
                    if (onTranslateAnimEndCallback != null) {
                        onTranslateAnimEndCallback.onTranslateAnimEnd();
                    }
                    SodaAnimEngine.this.f24615p.setOnTranslateAnimEndCallback((OnTranslateAnimEndCallback) null);
                }
            });
        } else if (onTranslateAnimEndCallback != null) {
            onTranslateAnimEndCallback.onTranslateAnimEnd();
        }
    }

    /* renamed from: a */
    private void m19765a(final OnBoxAnimEndCallback onBoxAnimEndCallback) {
        BoxAnim boxAnim = this.f24617r;
        if (boxAnim != null && boxAnim.isRunning()) {
            this.f24617r.setOnBoxAnimEndCallback(new OnBoxAnimEndCallback() {
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
        if (!this.f24603d) {
            LogUtil.m19855e("onLocationChanged() isForeground == false");
        } else if (this.f24601b == 0) {
            LogUtil.m19855e("onLocationChanged() mAnimState == SodaAnimState.UNKNOWN");
        } else if (sodaAnimLatLng == null || sodaAnimLatLng.latLng == null) {
            LogUtil.m19855e("onLocationChanged() sodaLatLng == null || sodaLatLng.latLng == null");
        } else {
            SodaAnimLatLng sodaAnimLatLng2 = this.f24602c;
            if (sodaAnimLatLng2 == null || !sodaAnimLatLng2.equals(sodaAnimLatLng)) {
                this.f24602c = sodaAnimLatLng;
                int i = this.f24601b;
                if (i == 1) {
                    this.f24604e = false;
                    this.f24605f = false;
                    m19762a(sodaAnimLatLng.latLng);
                } else if (i == 2) {
                    doBoxAnim();
                } else if (i == 3) {
                    this.f24605f = false;
                    m19765a((OnBoxAnimEndCallback) new OnBoxAnimEndCallback() {
                        public void onBoxAnimEnd() {
                            SodaAnimEngine sodaAnimEngine = SodaAnimEngine.this;
                            sodaAnimEngine.m19762a(sodaAnimEngine.f24602c.latLng);
                        }
                    });
                } else if (i != 4) {
                    LogUtil.m19855e("onLocationChanged() switch to default");
                } else {
                    doBoxAnim();
                    m19765a((OnBoxAnimEndCallback) new OnBoxAnimEndCallback() {
                        public void onBoxAnimEnd() {
                            SodaAnimEngine sodaAnimEngine = SodaAnimEngine.this;
                            sodaAnimEngine.m19762a(sodaAnimEngine.f24602c.latLng);
                        }
                    });
                }
            } else {
                LogUtil.m19855e("onLocationChanged() mLastSodaLatLng.equals(sodaLatLng)");
            }
        }
    }

    public void setForeground(boolean z) {
        this.f24603d = z;
    }

    public void onResume() {
        this.f24603d = true;
    }

    public void onPause() {
        this.f24603d = false;
    }

    public void onStop() {
        this.f24603d = false;
    }

    public void onDestroy() {
        this.f24601b = 0;
        this.f24602c = null;
        this.f24603d = false;
        this.f24604e = false;
        this.f24605f = false;
        AngleManager.getInstant().destroy();
        FrameAnim frameAnim = this.f24607h;
        if (frameAnim != null) {
            frameAnim.destory();
            this.f24607h = null;
        }
        FrameAnim frameAnim2 = this.f24611l;
        if (frameAnim2 != null) {
            frameAnim2.destory();
            this.f24611l = null;
        }
        TranslateAnim translateAnim = this.f24615p;
        if (translateAnim != null) {
            translateAnim.destory();
            this.f24615p = null;
        }
        BoxAnim boxAnim = this.f24617r;
        if (boxAnim != null) {
            boxAnim.destory();
            this.f24617r = null;
        }
    }
}
