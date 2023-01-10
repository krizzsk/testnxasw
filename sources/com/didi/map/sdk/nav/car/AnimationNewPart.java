package com.didi.map.sdk.nav.car;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.TypedValue;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.CameraUpdate;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.MapUtils;
import com.didi.map.sdk.nav.inertia.ApolloCache;
import com.map.sdk.nav.libc.common.ApolloUtil;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AnimationNewPart implements AnimationPartInterface {

    /* renamed from: a */
    private static final String f30784a = "AnimationNewPart";

    /* renamed from: b */
    private static final float f30785b = 1.1f;

    /* renamed from: r */
    private static final int f30786r = 2;

    /* renamed from: A */
    private AnimateNode f30787A;

    /* renamed from: B */
    private double f30788B = 15.0d;

    /* renamed from: C */
    private double f30789C;

    /* renamed from: D */
    private ApolloCache f30790D = new ApolloCache();

    /* renamed from: E */
    private boolean f30791E = true;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public float f30792F = -1.0f;

    /* renamed from: G */
    private AnimationPartCallback f30793G = new AnimationPartCallback() {
        public void onFinish() {
            boolean unused = AnimationNewPart.this.f30810o = false;
            if (AnimationNewPart.this.f30808m != null && AnimationNewPart.this.f30809n) {
                AnimationNewPart.this.f30808m.onCancel();
                onCarAnimationCancelListener unused2 = AnimationNewPart.this.f30808m = null;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: H */
    public ValueAnimator f30794H = null;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public float f30795I = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public LatLng f30796J = null;

    /* renamed from: K */
    private int f30797K = 0;

    /* renamed from: c */
    private CameraMode f30798c = CameraMode.NORTH_UP;

    /* renamed from: d */
    private Map f30799d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CarMarker f30800e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<LatLng> f30801f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public onCarAnimationListener f30802g;

    /* renamed from: h */
    private NavOverlay f30803h;

    /* renamed from: i */
    private List<AnimationPartNode> f30804i = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AnimateNode f30805j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AnimatorSet f30806k;

    /* renamed from: l */
    private int f30807l = 3000;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public onCarAnimationCancelListener f30808m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f30809n = false;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f30810o = false;

    /* renamed from: p */
    private List<LatLng> f30811p = Collections.synchronizedList(new ArrayList());

    /* renamed from: q */
    private int f30812q = 0;

    /* renamed from: s */
    private boolean f30813s = false;

    /* renamed from: t */
    private AnimateNode f30814t;

    /* renamed from: u */
    private boolean f30815u = false;

    /* renamed from: v */
    private int f30816v = -1;

    /* renamed from: w */
    private int f30817w = -1;

    /* renamed from: x */
    private Handler f30818x = new Handler();

    /* renamed from: y */
    private Runnable f30819y;

    /* renamed from: z */
    private int f30820z;

    /* renamed from: a */
    private int m23676a(float f) {
        if (f >= 0.0f && f < 90.0f) {
            return 1;
        }
        if (f >= 90.0f && f < 180.0f) {
            return 2;
        }
        if (f < 180.0f || f >= 270.0f) {
            return (f < 270.0f || f >= 360.0f) ? 1 : 4;
        }
        return 3;
    }

    public AnimationNewPart(Map map, CarMarker carMarker) {
        this.f30799d = map;
        this.f30788B = ZoomLevelAdapter.getCarHeadMinZoom(map);
        this.f30789C = ZoomLevelAdapter.getCarHeadMaxZoom(map);
        if (DriverCarNewAnimApollo.getInstance().enable()) {
            this.f30789C = (double) DriverCarNewAnimApollo.getInstance().getMaxZoomLevel();
        }
        this.f30820z = map.getHeight() / 3;
        this.f30800e = carMarker;
        if (this.f30799d == null) {
            DLog.m10773d(f30784a, "AnimationPart, mMap is null", new Object[0]);
        } else if (carMarker == null) {
            DLog.m10773d(f30784a, "AnimationPart, mCarMarker == null", new Object[0]);
        } else if (carMarker.getMarker() == null) {
            DLog.m10773d(f30784a, "AnimationPart, getMarker == null", new Object[0]);
        } else if (this.f30800e.getPosition() == null) {
            DLog.m10773d(f30784a, "AnimationPart, getPosition == null", new Object[0]);
        } else {
            this.f30805j = new AnimateNode(this.f30800e.getPosition(), -1, 0, false);
        }
    }

    public void setRoutePoints(List<LatLng> list) {
        if (list == null || !list.equals(this.f30801f)) {
            this.f30801f = list;
            this.f30814t = null;
            CarMarker carMarker = this.f30800e;
            if (carMarker != null) {
                this.f30805j = new AnimateNode(carMarker.getPosition(), -1, 0, false);
            }
            this.f30812q = 0;
            List<AnimationPartNode> list2 = this.f30804i;
            if (list2 != null) {
                list2.clear();
            }
            if (this.f30798c == CameraMode.CAR_HEAD_UP && this.f30801f != null) {
                Runnable runnable = this.f30819y;
                if (runnable != null) {
                    this.f30818x.removeCallbacks(runnable);
                }
                $$Lambda$AnimationNewPart$SoZksn9vdUvNtjNLf6TR9EZsXU0 r4 = new Runnable() {
                    public final void run() {
                        AnimationNewPart.this.m23711f();
                    }
                };
                this.f30819y = r4;
                this.f30818x.postDelayed(r4, (long) (((float) this.f30807l) * f30785b));
                return;
            }
            return;
        }
        DLog.m10773d(f30784a, "setRoutePoints, the same !", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m23711f() {
        List<LatLng> list = this.f30801f;
        if (list != null && list.size() > 0 && !this.f30813s) {
            start(new AnimateNode(this.f30801f.get(0), 0, 0, false));
        }
    }

    public void setOnCarAnimationListener(onCarAnimationListener oncaranimationlistener) {
        this.f30802g = oncaranimationlistener;
    }

    public void start(AnimateNode animateNode) {
        start(animateNode, (DMKEventPoint) null);
    }

    public void start(AnimateNode animateNode, DMKEventPoint dMKEventPoint) {
        if (animateNode == null || animateNode.latLng == null) {
            DLog.m10773d(f30784a, "start fail node=null", new Object[0]);
            return;
        }
        if (!this.f30813s) {
            this.f30814t = null;
        }
        if (dMKEventPoint != null) {
            this.f30817w = dMKEventPoint.geoIndex;
        }
        if (!animateNode.compare(this.f30805j) || this.f30798c == CameraMode.CAR_HEAD_UP) {
            this.f30787A = animateNode;
            stop(new onCarAnimationCancelListener(animateNode) {
                public final /* synthetic */ AnimateNode f$1;

                {
                    this.f$1 = r2;
                }

                public final void onCancel() {
                    AnimationNewPart.this.m23705c(this.f$1);
                }
            }, false);
            return;
        }
        this.f30805j = animateNode;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m23705c(AnimateNode animateNode) {
        this.f30809n = false;
        m23691a(animateNode);
    }

    public void stop(onCarAnimationCancelListener oncaranimationcancellistener, boolean z) {
        ValueAnimator valueAnimator;
        this.f30809n = true;
        this.f30808m = oncaranimationcancellistener;
        AnimatorSet animatorSet = this.f30806k;
        if (animatorSet == null || !animatorSet.isRunning()) {
            ValueAnimator valueAnimator2 = this.f30794H;
            if (valueAnimator2 != null && valueAnimator2.isRunning() && z) {
                this.f30794H.cancel();
            }
            onCarAnimationCancelListener oncaranimationcancellistener2 = this.f30808m;
            if (oncaranimationcancellistener2 != null) {
                oncaranimationcancellistener2.onCancel();
                this.f30808m = null;
                return;
            }
            return;
        }
        if (z && (valueAnimator = this.f30794H) != null && valueAnimator.isRunning()) {
            this.f30794H.cancel();
        }
        this.f30806k.cancel();
    }

    public void setAnimationInterval(int i) {
        DLog.m10773d(f30784a, "setAnimationInterval =" + i, new Object[0]);
        this.f30807l = i;
    }

    public void setIsBackground(boolean z) {
        AnimateNode animateNode;
        this.f30813s = z;
        if (!z && (animateNode = this.f30814t) != null) {
            start(animateNode);
        }
    }

    public void destroy() {
        stop((onCarAnimationCancelListener) null, true);
        List<AnimationPartNode> list = this.f30804i;
        if (list != null) {
            list.clear();
            this.f30804i = null;
        }
        List<LatLng> list2 = this.f30811p;
        if (list2 != null) {
            list2.clear();
            this.f30811p = null;
        }
        this.f30790D = null;
        this.f30800e = null;
        this.f30801f = null;
        this.f30806k = null;
        this.f30808m = null;
        Runnable runnable = this.f30819y;
        if (runnable != null) {
            this.f30818x.removeCallbacks(runnable);
        }
        this.f30818x = null;
        DLog.m10773d(f30784a, "destroy ok", new Object[0]);
    }

    /* renamed from: a */
    private void m23687a() {
        List<AnimationPartNode> list = this.f30804i;
        if (list == null || list.size() <= 0) {
            AnimationPartCallback animationPartCallback = this.f30793G;
            if (animationPartCallback != null) {
                animationPartCallback.onFinish();
                return;
            }
            return;
        }
        m23701b();
        m23692a((AnimationPartCallback) new AnimationPartCallback() {
            public final void onFinish() {
                AnimationNewPart.this.m23709e();
            }
        }, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m23709e() {
        List<AnimationPartNode> list = this.f30804i;
        if (list != null && list.size() > 0) {
            this.f30804i.remove(0);
        }
        m23687a();
    }

    /* renamed from: a */
    private void m23692a(final AnimationPartCallback animationPartCallback, boolean z) {
        List<AnimationPartNode> list = this.f30804i;
        if (list != null && list.size() != 0 && this.f30800e != null && !this.f30809n && this.f30799d != null) {
            AnimationPartNode animationPartNode = this.f30804i.get(0);
            ValueAnimator b = m23699b(animationPartNode);
            ValueAnimator a = m23680a(animationPartNode);
            ValueAnimator a2 = m23681a((AnimationPartNode) (this.f30804i.size() > 1 ? this.f30804i.get(1) : this.f30804i.get(0)), z);
            LinkedList linkedList = new LinkedList();
            if (a != null) {
                linkedList.add(a);
            }
            if (b != null) {
                linkedList.add(b);
            }
            if (linkedList.size() != 0 || a2 != null) {
                if (linkedList.size() != 0) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    this.f30806k = animatorSet;
                    animatorSet.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            AnimatorSet unused = AnimationNewPart.this.f30806k = null;
                            AnimationPartCallback animationPartCallback = animationPartCallback;
                            if (animationPartCallback != null) {
                                animationPartCallback.onFinish();
                            }
                        }
                    });
                    this.f30806k.playTogether(linkedList);
                    this.f30806k.setDuration((long) (((float) animationPartNode.totalDuration) * f30785b));
                    if (!this.f30809n) {
                        this.f30806k.start();
                    } else if (animationPartCallback != null) {
                        animationPartCallback.onFinish();
                        return;
                    } else {
                        return;
                    }
                }
                if (a2 != null) {
                    a2.start();
                }
                this.f30805j = new AnimateNode(animationPartNode.latLng, animationPartNode.index, animationPartNode.offset, animationPartNode.isEraseEnd);
                if (linkedList.size() == 0) {
                    DLog.m10773d(f30784a, "doAnimationSet: animatorList.size() == 0", new Object[0]);
                    if (animationPartCallback != null) {
                        animationPartCallback.onFinish();
                    }
                }
            } else if (animationPartCallback != null) {
                animationPartCallback.onFinish();
            }
        } else if (animationPartCallback != null) {
            animationPartCallback.onFinish();
        }
    }

    /* renamed from: a */
    private ValueAnimator m23681a(AnimationPartNode animationPartNode, boolean z) {
        RotateStatus a;
        CarMarker carMarker = this.f30800e;
        if (!(carMarker == null || this.f30809n || this.f30799d == null)) {
            HeadingStatus headingOfAnimate = C10824utils.getHeadingOfAnimate(this.f30801f, carMarker.getPosition(), animationPartNode, false);
            if (!headingOfAnimate.success) {
                return null;
            }
            float rotation = this.f30800e.getRotation();
            if (this.f30798c == CameraMode.CAR_HEAD_UP && z && this.f30815u) {
                rotation = this.f30799d.getCameraPosition().bearing;
            }
            float reviseRotate = C10824utils.getReviseRotate(rotation, (float) headingOfAnimate.heading);
            float f = rotation % 360.0f;
            if (f < 0.0f) {
                f += 360.0f;
            }
            float f2 = reviseRotate % 360.0f;
            if (f2 < 0.0f) {
                f2 += 360.0f;
            }
            if (this.f30798c == CameraMode.CAR_HEAD_UP && this.f30815u && ((a = m23684a(f, f2)) == null || a.offsetRotate < 10.0f)) {
                return null;
            }
            RotateStatus a2 = m23684a(f, f2);
            if (a2 != null && a2.offsetRotate >= 1.0f) {
                ValueAnimator valueAnimator = this.f30794H;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    if (Math.abs(f2 - this.f30795I) < 10.0f) {
                        return null;
                    }
                    this.f30794H.cancel();
                }
                long max = Math.max((long) (((float) animationPartNode.totalDuration) * f30785b), 500);
                this.f30795I = f2;
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                this.f30794H = ofFloat;
                ofFloat.setDuration(max);
                this.f30794H.setInterpolator(new LinearInterpolator());
                this.f30794H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(a2, f, z) {
                    public final /* synthetic */ RotateStatus f$1;
                    public final /* synthetic */ float f$2;
                    public final /* synthetic */ boolean f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AnimationNewPart.this.m23694a(this.f$1, this.f$2, this.f$3, valueAnimator);
                    }
                });
                this.f30794H.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        ValueAnimator unused = AnimationNewPart.this.f30794H = null;
                        float unused2 = AnimationNewPart.this.f30795I = 0.0f;
                    }
                });
                return this.f30794H;
            } else if (this.f30794H == null) {
                m23688a(f2, true);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23694a(RotateStatus rotateStatus, float f, boolean z, ValueAnimator valueAnimator) {
        float f2;
        Float f3 = (Float) valueAnimator.getAnimatedValue();
        if (this.f30800e != null && f3 != null) {
            if (rotateStatus.isClockise) {
                f2 = f + (rotateStatus.offsetRotate * f3.floatValue());
            } else {
                f2 = f - (rotateStatus.offsetRotate * f3.floatValue());
            }
            m23688a(f2, z);
        }
    }

    /* renamed from: a */
    private ValueAnimator m23680a(AnimationPartNode animationPartNode) {
        if (this.f30800e == null || this.f30809n || this.f30792F < 0.0f) {
            return null;
        }
        long max = Math.max((long) (((float) animationPartNode.totalDuration) * f30785b), 100);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) this.f30799d.getCameraPosition().zoom, this.f30792F});
        ofFloat.setDuration(max);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimationNewPart.this.m23689a(valueAnimator);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                float unused = AnimationNewPart.this.f30792F = -1.0f;
            }
        });
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23689a(ValueAnimator valueAnimator) {
        this.f30792F = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* renamed from: b */
    private ValueAnimator m23699b(final AnimationPartNode animationPartNode) {
        if (this.f30800e == null || this.f30809n) {
            return null;
        }
        if (this.f30802g != null && animationPartNode.isEraseRunning) {
            updateLines(this.f30801f, this.f30800e.getPosition(), animationPartNode);
        }
        LatLng position = this.f30800e.getPosition();
        final LatLng latLng = animationPartNode.latLng;
        if (DDSphericalUtil.computeDistanceBetween(position, latLng) < 0.1d) {
            if (this.f30800e != null) {
                m23690a(latLng);
                if (this.f30802g != null && animationPartNode.isEraseEnd) {
                    updateLines(this.f30801f, this.f30800e.getPosition(), animationPartNode);
                }
            }
            return null;
        }
        long max = Math.max((long) (((float) animationPartNode.totalDuration) * f30785b), 100);
        ValueAnimator ofObject = ValueAnimator.ofObject(new LatLngTypeEvaluator(), new Object[]{position, latLng});
        ofObject.setDuration(max);
        ofObject.setInterpolator(new LinearInterpolator());
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(animationPartNode) {
            public final /* synthetic */ AnimationPartNode f$1;

            {
                this.f$1 = r2;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimationNewPart.this.m23693a(this.f$1, valueAnimator);
            }
        });
        ofObject.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                LatLng unused = AnimationNewPart.this.f30796J = null;
            }

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                if (AnimationNewPart.this.f30800e != null && AnimationNewPart.this.f30801f != null && AnimationNewPart.this.f30801f.size() > animationPartNode.index) {
                    if (AnimationNewPart.this.f30796J == null || !AnimationNewPart.this.f30796J.equals(latLng)) {
                        int i = 0;
                        if (animationPartNode.type != AnimateNodeStatus.ON_ROAD) {
                            AnimationNewPart animationNewPart = AnimationNewPart.this;
                            AnimateNode unused = animationNewPart.f30805j = new AnimateNode(animationNewPart.f30800e.getPosition(), -1, 0, true);
                        } else if (animationPartNode.offset > 0) {
                            AnimationNewPart animationNewPart2 = AnimationNewPart.this;
                            AnimateNode unused2 = animationNewPart2.f30805j = new AnimateNode(animationNewPart2.f30800e.getPosition(), animationPartNode.index, (int) DDSphericalUtil.computeDistanceBetween((LatLng) AnimationNewPart.this.f30801f.get(animationPartNode.index), AnimationNewPart.this.f30800e.getPosition()), true);
                        } else {
                            int i2 = animationPartNode.index - 1;
                            if (i2 >= 0) {
                                i = i2;
                            }
                            AnimationNewPart animationNewPart3 = AnimationNewPart.this;
                            AnimateNode unused3 = animationNewPart3.f30805j = new AnimateNode(animationNewPart3.f30800e.getPosition(), i, (int) DDSphericalUtil.computeDistanceBetween((LatLng) AnimationNewPart.this.f30801f.get(i), AnimationNewPart.this.f30800e.getPosition()), true);
                        }
                    } else {
                        AnimateNode unused4 = AnimationNewPart.this.f30805j = new AnimateNode(animationPartNode.latLng, animationPartNode.index, animationPartNode.offset, animationPartNode.isEraseEnd);
                        if (AnimationNewPart.this.f30802g != null && animationPartNode.isEraseEnd) {
                            AnimationNewPart animationNewPart4 = AnimationNewPart.this;
                            animationNewPart4.updateLines(animationNewPart4.f30801f, AnimationNewPart.this.f30800e.getPosition(), animationPartNode);
                        }
                    }
                }
            }
        });
        return ofObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23693a(AnimationPartNode animationPartNode, ValueAnimator valueAnimator) {
        LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
        this.f30796J = latLng;
        if (this.f30800e != null) {
            m23690a(latLng);
            if (this.f30802g != null && animationPartNode.isEraseRunning) {
                updateLines(this.f30801f, this.f30800e.getPosition(), animationPartNode);
            }
        }
    }

    /* renamed from: a */
    private void m23691a(AnimateNode animateNode) {
        CarMarker carMarker;
        HeadingStatus headingOfAnimate;
        if (!this.f30810o && this.f30800e != null) {
            List<AnimationPartNode> b = m23700b(animateNode);
            this.f30804i = b;
            if (b != null && b.size() != 0) {
                boolean z = true;
                this.f30810o = true;
                AnimationPartNode animationPartNode = this.f30804i.get(0);
                int i = C108206.$SwitchMap$com$didi$map$sdk$nav$car$AnimateNodeStatus[animationPartNode.type.ordinal()];
                if (i == 1) {
                    if (animationPartNode.jump) {
                        HeadingStatus headingOfAnimate2 = C10824utils.getHeadingOfAnimate(this.f30801f, this.f30800e.getPosition(), animationPartNode, false);
                        if (headingOfAnimate2 == null || !headingOfAnimate2.success) {
                            this.f30810o = false;
                            return;
                        }
                        this.f30805j = new AnimateNode(animationPartNode.latLng, animationPartNode.index, animationPartNode.offset, true);
                        m23690a(animationPartNode.latLng);
                        m23688a((float) headingOfAnimate2.heading, false);
                        if (this.f30802g != null && animationPartNode.isEraseEnd) {
                            updateLines(this.f30801f, this.f30800e.getPosition(), animationPartNode);
                        }
                        this.f30810o = false;
                    } else {
                        m23687a();
                    }
                    Runnable runnable = this.f30819y;
                    if (runnable != null) {
                        this.f30818x.removeCallbacks(runnable);
                        this.f30819y = null;
                    }
                } else if (i == 2 || i == 3) {
                    if (animationPartNode.jump) {
                        HeadingStatus headingOfAnimate3 = C10824utils.getHeadingOfAnimate(this.f30801f, this.f30800e.getPosition(), animationPartNode, false);
                        if (headingOfAnimate3 == null || !headingOfAnimate3.success) {
                            this.f30810o = false;
                            return;
                        }
                        this.f30805j = new AnimateNode(animationPartNode.latLng, animationPartNode.index, animationPartNode.offset, false);
                        m23690a(animationPartNode.latLng);
                        m23688a((float) headingOfAnimate3.heading, false);
                        this.f30810o = false;
                        return;
                    }
                    if (this.f30798c != CameraMode.CAR_HEAD_UP || (carMarker = this.f30800e) == null) {
                        z = false;
                    } else {
                        HeadingStatus headingOfAnimate4 = C10824utils.getHeadingOfAnimate(this.f30801f, carMarker.getPosition(), animationPartNode, false);
                        if (headingOfAnimate4 == null || !headingOfAnimate4.success) {
                            this.f30810o = false;
                        }
                    }
                    m23692a(this.f30793G, z);
                } else if (i == 4) {
                    Runnable runnable2 = this.f30819y;
                    if (runnable2 != null) {
                        this.f30818x.removeCallbacks(runnable2);
                        this.f30818x.postDelayed(this.f30819y, (long) (((float) this.f30807l) * f30785b));
                    }
                    if (animationPartNode.jump) {
                        HeadingStatus headingOfAnimate5 = C10824utils.getHeadingOfAnimate(this.f30801f, this.f30800e.getPosition(), animationPartNode, true);
                        if (headingOfAnimate5 == null || !headingOfAnimate5.success) {
                            this.f30810o = false;
                            return;
                        }
                        this.f30805j = new AnimateNode(animationPartNode.latLng, animationPartNode.index, animationPartNode.offset, false);
                        m23690a(animationPartNode.latLng);
                        m23688a((float) headingOfAnimate5.heading, false);
                        this.f30810o = false;
                        if (this.f30802g != null && animationPartNode.isEraseEnd) {
                            updateLines(this.f30801f, this.f30800e.getPosition(), animationPartNode);
                            return;
                        }
                        return;
                    }
                    CarMarker carMarker2 = this.f30800e;
                    if (carMarker2 != null && ((headingOfAnimate = C10824utils.getHeadingOfAnimate(this.f30801f, carMarker2.getPosition(), animationPartNode, false)) == null || !headingOfAnimate.success)) {
                        this.f30810o = false;
                    }
                    m23692a((AnimationPartCallback) new AnimationPartCallback() {
                        public final void onFinish() {
                            AnimationNewPart.this.m23707d();
                        }
                    }, true);
                }
            }
        }
    }

    /* renamed from: com.didi.map.sdk.nav.car.AnimationNewPart$6 */
    static /* synthetic */ class C108206 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$map$sdk$nav$car$AnimateNodeStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.map.sdk.nav.car.AnimateNodeStatus[] r0 = com.didi.map.sdk.nav.car.AnimateNodeStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$map$sdk$nav$car$AnimateNodeStatus = r0
                com.didi.map.sdk.nav.car.AnimateNodeStatus r1 = com.didi.map.sdk.nav.car.AnimateNodeStatus.ON_ROAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$car$AnimateNodeStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.sdk.nav.car.AnimateNodeStatus r1 = com.didi.map.sdk.nav.car.AnimateNodeStatus.OUT_ROAD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$car$AnimateNodeStatus     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.sdk.nav.car.AnimateNodeStatus r1 = com.didi.map.sdk.nav.car.AnimateNodeStatus.ON_BUILDING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$map$sdk$nav$car$AnimateNodeStatus     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.sdk.nav.car.AnimateNodeStatus r1 = com.didi.map.sdk.nav.car.AnimateNodeStatus.TO_ROAD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.nav.car.AnimationNewPart.C108206.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m23707d() {
        List<AnimationPartNode> list = this.f30804i;
        if (list != null && list.size() > 1) {
            this.f30804i.remove(0);
        }
        AnimationPartCallback animationPartCallback = this.f30793G;
        if (animationPartCallback != null) {
            animationPartCallback.onFinish();
        }
    }

    /* renamed from: b */
    private List<AnimationPartNode> m23700b(AnimateNode animateNode) {
        boolean z;
        int i;
        AnimateNode animateNode2 = animateNode;
        if (animateNode2 == null) {
            return null;
        }
        if (this.f30801f != null && animateNode2.index >= this.f30801f.size()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (animateNode2.index < 0 || this.f30805j.index < 0 || this.f30801f == null) {
            if (animateNode2.index != -1 || this.f30805j.index < 0) {
                if (animateNode2.index < 0 || this.f30805j.index != -1) {
                    if (DDSphericalUtil.computeDistanceBetween(this.f30805j.latLng, animateNode2.latLng) > ((double) this.f30790D.getCatch_dis())) {
                        arrayList.add(new AnimationPartNode((long) this.f30807l, animateNode2.latLng, animateNode2.index, 0, false, false, true, AnimateNodeStatus.ON_BUILDING));
                        return arrayList;
                    }
                    LatLng latLng = animateNode2.latLng;
                    int i2 = animateNode2.index;
                    arrayList.add(new AnimationPartNode((long) this.f30807l, latLng, i2, 0, false, false, false, AnimateNodeStatus.ON_BUILDING));
                } else if (this.f30798c != CameraMode.CAR_HEAD_UP) {
                    arrayList.add(new AnimationPartNode((long) this.f30807l, animateNode2.latLng, animateNode2.index, animateNode2.offSet, false, true, true, AnimateNodeStatus.TO_ROAD));
                } else if (DDSphericalUtil.computeDistanceBetween(this.f30805j.latLng, animateNode2.latLng) > ((double) this.f30790D.getCatch_dis())) {
                    arrayList.add(new AnimationPartNode((long) this.f30807l, animateNode2.latLng, animateNode2.index, animateNode2.offSet, false, true, true, AnimateNodeStatus.TO_ROAD));
                } else {
                    AnimationPartNode animationPartNode = new AnimationPartNode((long) this.f30807l, animateNode2.latLng, animateNode2.index, animateNode2.offSet, false, true, false, AnimateNodeStatus.TO_ROAD);
                    if (this.f30801f == null || animateNode2.index + 1 >= this.f30801f.size()) {
                        arrayList.add(animationPartNode);
                    } else {
                        animationPartNode.totalDuration = (long) (this.f30807l / 2);
                        AnimationPartNode animationPartNode2 = new AnimationPartNode((long) (this.f30807l / 2), this.f30801f.get(animateNode2.index + 1), animateNode2.index + 1, 0, true, true, false, AnimateNodeStatus.ON_ROAD);
                        arrayList.add(animationPartNode);
                        arrayList.add(animationPartNode2);
                    }
                }
            } else if (DDSphericalUtil.computeDistanceBetween(this.f30805j.latLng, animateNode2.latLng) > ((double) this.f30790D.getCatch_dis())) {
                arrayList.add(new AnimationPartNode((long) this.f30807l, animateNode2.latLng, animateNode2.index, animateNode2.offSet, false, false, true, AnimateNodeStatus.OUT_ROAD));
                return arrayList;
            } else {
                LatLng latLng2 = animateNode2.latLng;
                int i3 = animateNode2.index;
                int i4 = animateNode2.offSet;
                arrayList.add(new AnimationPartNode((long) this.f30807l, latLng2, i3, i4, false, false, false, AnimateNodeStatus.OUT_ROAD));
            }
        } else if (animateNode2.index < this.f30805j.index) {
            DLog.m10773d(f30784a, "makeReadyNodes index error", new Object[0]);
            return null;
        } else if (animateNode2.index != this.f30805j.index || animateNode2.offSet > this.f30805j.offSet) {
            double onRoadDistance = C10824utils.getOnRoadDistance(this.f30801f, this.f30805j, animateNode2);
            if (onRoadDistance > ((double) this.f30790D.getCatch_dis())) {
                arrayList.add(new AnimationPartNode(10, animateNode2.latLng, animateNode2.index, animateNode2.offSet, true, true, true, AnimateNodeStatus.ON_ROAD));
                return arrayList;
            } else if (animateNode2.index > this.f30805j.index) {
                double d = 1.0d;
                arrayList.add(new AnimationPartNode((long) (((double) this.f30807l) * Math.min(DDSphericalUtil.computeDistanceBetween(this.f30805j.latLng, this.f30801f.get(this.f30805j.index + 1)) / onRoadDistance, 1.0d)), this.f30801f.get(this.f30805j.index + 1), this.f30805j.index + 1, 0, true, true, false, AnimateNodeStatus.ON_ROAD));
                int i5 = this.f30805j.index + 1;
                int i6 = 0;
                while (true) {
                    if (i5 >= animateNode2.index || (i = i5 + 1) >= this.f30801f.size()) {
                        z = false;
                    } else {
                        long min = (long) (((double) this.f30807l) * Math.min(DDSphericalUtil.computeDistanceBetween(this.f30801f.get(i5), this.f30801f.get(i)) / onRoadDistance, d));
                        if (i6 > 10) {
                            if (animateNode2.offSet <= 0) {
                                LatLng latLng3 = animateNode2.latLng;
                                arrayList.add(new AnimationPartNode(min, latLng3, animateNode2.index, 0, true, true, true, AnimateNodeStatus.ON_ROAD));
                            } else {
                                arrayList.add(new AnimationPartNode(min, this.f30801f.get(i), i, 0, true, true, false, AnimateNodeStatus.ON_ROAD));
                            }
                            z = true;
                        } else {
                            arrayList.add(new AnimationPartNode(min, this.f30801f.get(i), i, 0, true, true, false, AnimateNodeStatus.ON_ROAD));
                            i6++;
                            i5 = i;
                            d = 1.0d;
                        }
                    }
                }
                z = false;
                if (animateNode2.offSet > 0) {
                    arrayList.add(new AnimationPartNode((long) (((double) this.f30807l) * Math.min(DDSphericalUtil.computeDistanceBetween(this.f30801f.get(animateNode2.index), animateNode2.latLng) / onRoadDistance, 1.0d)), animateNode2.latLng, animateNode2.index, animateNode2.offSet, true, true, z, AnimateNodeStatus.ON_ROAD));
                }
            } else if (animateNode2.index == this.f30805j.index && animateNode2.offSet > this.f30805j.offSet) {
                arrayList.add(new AnimationPartNode((long) this.f30807l, animateNode2.latLng, animateNode2.index, animateNode2.offSet, true, true, false, AnimateNodeStatus.ON_ROAD));
            }
        } else {
            DLog.m10773d(f30784a, " makeReadyNodes offSet error", new Object[0]);
            return null;
        }
        return arrayList;
    }

    /* renamed from: a */
    private RotateStatus m23684a(float f, float f2) {
        int i = (f > f2 ? 1 : (f == f2 ? 0 : -1));
        if (i == 0) {
            return null;
        }
        RotateStatus rotateStatus = new RotateStatus();
        int a = m23676a(f);
        int a2 = m23676a(f2);
        if (a == 1) {
            if (a2 == 2) {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = f2 - f;
                return rotateStatus;
            } else if (a2 == 4) {
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = (f + 360.0f) - f2;
                return rotateStatus;
            } else if (a2 == 3) {
                if (180.0f + f > f2) {
                    rotateStatus.isClockise = true;
                    rotateStatus.offsetRotate = f2 - f;
                    return rotateStatus;
                }
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = (f + 360.0f) - f2;
                return rotateStatus;
            } else if (i > 0) {
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = f - f2;
                return rotateStatus;
            } else {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = f2 - f;
                return rotateStatus;
            }
        } else if (a == 2) {
            if (a2 == 3) {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = f2 - f;
                return rotateStatus;
            } else if (a2 == 1) {
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = f - f2;
                return rotateStatus;
            } else if (a2 == 4) {
                if (180.0f + f > f2) {
                    rotateStatus.isClockise = true;
                    rotateStatus.offsetRotate = f2 - f;
                    return rotateStatus;
                }
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = (f + 360.0f) - f2;
                return rotateStatus;
            } else if (i > 0) {
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = f - f2;
                return rotateStatus;
            } else {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = f2 - f;
                return rotateStatus;
            }
        } else if (a == 3) {
            if (a2 == 4) {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = f2 - f;
                return rotateStatus;
            } else if (a2 == 2) {
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = f - f2;
                return rotateStatus;
            } else if (a2 == 1) {
                if (180.0f + f > f2) {
                    rotateStatus.isClockise = true;
                    rotateStatus.offsetRotate = (360.0f - f) + f2;
                    return rotateStatus;
                }
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = f - f2;
                return rotateStatus;
            } else if (i > 0) {
                rotateStatus.isClockise = false;
                rotateStatus.offsetRotate = f - f2;
                return rotateStatus;
            } else {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = f2 - f;
                return rotateStatus;
            }
        } else if (a2 == 1) {
            rotateStatus.isClockise = true;
            rotateStatus.offsetRotate = (f2 + 360.0f) - f;
            return rotateStatus;
        } else if (a2 == 3) {
            rotateStatus.isClockise = false;
            rotateStatus.offsetRotate = f - f2;
            return rotateStatus;
        } else if (a2 == 2) {
            if (f - 180.0f > f2) {
                rotateStatus.isClockise = true;
                rotateStatus.offsetRotate = (360.0f - f) + f2;
                return rotateStatus;
            }
            rotateStatus.isClockise = false;
            rotateStatus.offsetRotate = f - f2;
            return rotateStatus;
        } else if (i > 0) {
            rotateStatus.isClockise = false;
            rotateStatus.offsetRotate = f - f2;
            return rotateStatus;
        } else {
            rotateStatus.isClockise = true;
            rotateStatus.offsetRotate = f2 - f;
            return rotateStatus;
        }
    }

    /* renamed from: b */
    private void m23701b() {
        List<LatLng> list;
        List<AnimationPartNode> list2 = this.f30804i;
        if (list2 != null && list2.size() != 0 && this.f30800e != null && !this.f30809n && this.f30799d != null && this.f30798c == CameraMode.CAR_HEAD_UP) {
            int i = this.f30816v;
            int i2 = this.f30817w;
            if (i <= i2 || (list = this.f30801f) == null || i2 >= list.size()) {
                float f = (float) this.f30799d.getCameraPosition().zoom;
                float a = m23674a(this.f30817w);
                if (f == a || Math.abs(f - a) < 0.2f) {
                    this.f30816v = this.f30817w;
                    return;
                }
                this.f30792F = a;
                this.f30816v = this.f30817w;
            }
        }
    }

    private class LatLngTypeEvaluator implements TypeEvaluator<LatLng> {
        private LatLngTypeEvaluator() {
        }

        public LatLng evaluate(float f, LatLng latLng, LatLng latLng2) {
            double d = (double) f;
            return new LatLng(((latLng2.latitude - latLng.latitude) * d) + latLng.latitude, ((latLng2.longitude - latLng.longitude) * d) + latLng.longitude);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0130, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0135, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateLines(java.util.List<com.didi.common.map.model.LatLng> r8, com.didi.common.map.model.LatLng r9, com.didi.map.sdk.nav.car.AnimationPartNode r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r9 == 0) goto L_0x0134
            if (r8 == 0) goto L_0x0134
            int r0 = r8.size()     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x0134
            if (r10 == 0) goto L_0x0134
            int r0 = r10.index     // Catch:{ all -> 0x0131 }
            r1 = -1
            if (r0 != r1) goto L_0x0014
            goto L_0x0134
        L_0x0014:
            java.util.List<com.didi.common.map.model.LatLng> r0 = r7.f30811p     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x001a
            monitor-exit(r7)
            return
        L_0x001a:
            java.util.List<com.didi.common.map.model.LatLng> r0 = r7.f30811p     // Catch:{ all -> 0x0131 }
            r0.clear()     // Catch:{ all -> 0x0131 }
            java.util.List<com.didi.common.map.model.LatLng> r0 = r7.f30811p     // Catch:{ all -> 0x0131 }
            r0.add(r9)     // Catch:{ all -> 0x0131 }
            int r0 = r7.f30812q     // Catch:{ all -> 0x0131 }
            int r1 = r10.index     // Catch:{ all -> 0x0131 }
            if (r0 <= r1) goto L_0x0097
            int r0 = r10.offset     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x0031
            int r0 = r10.index     // Catch:{ all -> 0x0131 }
            goto L_0x0035
        L_0x0031:
            int r0 = r10.index     // Catch:{ all -> 0x0131 }
            int r0 = r0 + 1
        L_0x0035:
            int r1 = r8.size()     // Catch:{ all -> 0x0131 }
            if (r0 < r1) goto L_0x003d
            monitor-exit(r7)
            return
        L_0x003d:
            java.lang.Object r1 = r8.get(r0)     // Catch:{ all -> 0x0131 }
            com.didi.common.map.model.LatLng r1 = (com.didi.common.map.model.LatLng) r1     // Catch:{ all -> 0x0131 }
            double r2 = r9.latitude     // Catch:{ all -> 0x0131 }
            double r4 = r1.latitude     // Catch:{ all -> 0x0131 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0053
            double r2 = r9.longitude     // Catch:{ all -> 0x0131 }
            double r4 = r1.longitude     // Catch:{ all -> 0x0131 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0058
        L_0x0053:
            java.util.List<com.didi.common.map.model.LatLng> r2 = r7.f30811p     // Catch:{ all -> 0x0131 }
            r2.add(r1)     // Catch:{ all -> 0x0131 }
        L_0x0058:
            int r1 = r8.size()     // Catch:{ all -> 0x0131 }
            int r2 = r7.f30812q     // Catch:{ all -> 0x0131 }
            int r2 = r2 + 1
            if (r1 < r2) goto L_0x0079
            int r1 = r7.f30812q     // Catch:{ all -> 0x0131 }
            if (r0 > r1) goto L_0x0079
            goto L_0x0076
        L_0x0067:
            int r1 = r7.f30812q     // Catch:{ all -> 0x0131 }
            int r1 = r1 + 1
            if (r0 >= r1) goto L_0x0079
            java.util.List<com.didi.common.map.model.LatLng> r1 = r7.f30811p     // Catch:{ all -> 0x0131 }
            java.lang.Object r2 = r8.get(r0)     // Catch:{ all -> 0x0131 }
            r1.add(r2)     // Catch:{ all -> 0x0131 }
        L_0x0076:
            int r0 = r0 + 1
            goto L_0x0067
        L_0x0079:
            com.didi.map.sdk.nav.car.onCarAnimationListener r8 = r7.f30802g     // Catch:{ all -> 0x0131 }
            if (r8 == 0) goto L_0x012f
            com.didi.map.sdk.nav.car.onCarAnimationListener r8 = r7.f30802g     // Catch:{ all -> 0x0131 }
            java.util.List<com.didi.common.map.model.LatLng> r0 = r7.f30811p     // Catch:{ all -> 0x0131 }
            r8.onErase(r0)     // Catch:{ all -> 0x0131 }
            int r8 = r10.index     // Catch:{ all -> 0x0131 }
            int r0 = r10.offset     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x008c
            int r8 = r8 + -1
        L_0x008c:
            if (r8 < 0) goto L_0x012f
            com.didi.map.sdk.nav.car.onCarAnimationListener r0 = r7.f30802g     // Catch:{ all -> 0x0131 }
            int r10 = r10.offset     // Catch:{ all -> 0x0131 }
            r0.onErase(r8, r10, r9)     // Catch:{ all -> 0x0131 }
            goto L_0x012f
        L_0x0097:
            int r0 = r10.index     // Catch:{ all -> 0x0131 }
            int r0 = r0 + 2
            r7.f30812q = r0     // Catch:{ all -> 0x0131 }
            int r1 = r8.size()     // Catch:{ all -> 0x0131 }
            int r1 = r1 + -1
            if (r0 <= r1) goto L_0x00ad
            int r0 = r8.size()     // Catch:{ all -> 0x0131 }
            int r0 = r0 + -1
            r7.f30812q = r0     // Catch:{ all -> 0x0131 }
        L_0x00ad:
            int r0 = r10.offset     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x00b4
            int r0 = r10.index     // Catch:{ all -> 0x0131 }
            goto L_0x00b8
        L_0x00b4:
            int r0 = r10.index     // Catch:{ all -> 0x0131 }
            int r0 = r0 + 1
        L_0x00b8:
            int r1 = r8.size()     // Catch:{ all -> 0x0131 }
            if (r0 < r1) goto L_0x00c0
            monitor-exit(r7)
            return
        L_0x00c0:
            java.lang.Object r1 = r8.get(r0)     // Catch:{ all -> 0x0131 }
            com.didi.common.map.model.LatLng r1 = (com.didi.common.map.model.LatLng) r1     // Catch:{ all -> 0x0131 }
            double r2 = r9.latitude     // Catch:{ all -> 0x0131 }
            double r4 = r1.latitude     // Catch:{ all -> 0x0131 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x00d6
            double r2 = r9.longitude     // Catch:{ all -> 0x0131 }
            double r4 = r1.longitude     // Catch:{ all -> 0x0131 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00db
        L_0x00d6:
            java.util.List<com.didi.common.map.model.LatLng> r2 = r7.f30811p     // Catch:{ all -> 0x0131 }
            r2.add(r1)     // Catch:{ all -> 0x0131 }
        L_0x00db:
            int r1 = r8.size()     // Catch:{ all -> 0x0131 }
            int r2 = r7.f30812q     // Catch:{ all -> 0x0131 }
            int r2 = r2 + 1
            if (r1 < r2) goto L_0x00fc
            int r1 = r7.f30812q     // Catch:{ all -> 0x0131 }
            if (r0 > r1) goto L_0x00fc
            goto L_0x00f9
        L_0x00ea:
            int r1 = r7.f30812q     // Catch:{ all -> 0x0131 }
            int r1 = r1 + 1
            if (r0 >= r1) goto L_0x00fc
            java.util.List<com.didi.common.map.model.LatLng> r1 = r7.f30811p     // Catch:{ all -> 0x0131 }
            java.lang.Object r2 = r8.get(r0)     // Catch:{ all -> 0x0131 }
            r1.add(r2)     // Catch:{ all -> 0x0131 }
        L_0x00f9:
            int r0 = r0 + 1
            goto L_0x00ea
        L_0x00fc:
            com.didi.map.sdk.nav.car.onCarAnimationListener r0 = r7.f30802g     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x012f
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0131 }
            r0.<init>()     // Catch:{ all -> 0x0131 }
            int r1 = r7.f30812q     // Catch:{ all -> 0x0131 }
        L_0x0107:
            int r2 = r8.size()     // Catch:{ all -> 0x0131 }
            if (r1 >= r2) goto L_0x0117
            java.lang.Object r2 = r8.get(r1)     // Catch:{ all -> 0x0131 }
            r0.add(r2)     // Catch:{ all -> 0x0131 }
            int r1 = r1 + 1
            goto L_0x0107
        L_0x0117:
            com.didi.map.sdk.nav.car.onCarAnimationListener r8 = r7.f30802g     // Catch:{ all -> 0x0131 }
            java.util.List<com.didi.common.map.model.LatLng> r1 = r7.f30811p     // Catch:{ all -> 0x0131 }
            r8.onUpdateAllLine(r1, r0)     // Catch:{ all -> 0x0131 }
            int r8 = r10.index     // Catch:{ all -> 0x0131 }
            int r0 = r10.offset     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x0126
            int r8 = r8 + -1
        L_0x0126:
            if (r8 < 0) goto L_0x012f
            com.didi.map.sdk.nav.car.onCarAnimationListener r0 = r7.f30802g     // Catch:{ all -> 0x0131 }
            int r10 = r10.offset     // Catch:{ all -> 0x0131 }
            r0.onErase(r8, r10, r9)     // Catch:{ all -> 0x0131 }
        L_0x012f:
            monitor-exit(r7)
            return
        L_0x0131:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x0134:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.nav.car.AnimationNewPart.updateLines(java.util.List, com.didi.common.map.model.LatLng, com.didi.map.sdk.nav.car.AnimationPartNode):void");
    }

    /* renamed from: a */
    private void m23690a(LatLng latLng) {
        if (latLng != null) {
            CarMarker carMarker = this.f30800e;
            if (carMarker != null) {
                carMarker.setPosition(latLng);
            }
            if (this.f30799d != null && this.f30815u) {
                CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
                cameraUpdateParams.latLng = latLng;
                cameraUpdateParams.bearing = this.f30799d.getCameraPosition().bearing;
                float f = this.f30792F;
                if (f >= 0.0f) {
                    cameraUpdateParams.level = (double) f;
                } else {
                    cameraUpdateParams.level = this.f30799d.getCameraPosition().zoom;
                }
                cameraUpdateParams.tilt = (float) m23677a(this.f30798c);
                this.f30799d.moveCamera(new CameraUpdate(cameraUpdateParams));
            }
        }
    }

    /* renamed from: a */
    private void m23688a(float f, boolean z) {
        CarMarker carMarker = this.f30800e;
        if (carMarker != null) {
            if (carMarker != null && (this.f30798c != CameraMode.CAR_HEAD_UP || this.f30815u || z)) {
                this.f30800e.setRotation(f);
            }
            if (this.f30798c == CameraMode.NORTH_UP) {
                Map map = this.f30799d;
                if (map != null && map.getCameraPosition().bearing != 0.0f) {
                    CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
                    cameraUpdateParams.latLng = this.f30800e.getPosition();
                    cameraUpdateParams.level = this.f30799d.getCameraPosition().zoom;
                    cameraUpdateParams.bearing = 0.0f;
                    this.f30799d.moveCamera(new CameraUpdate(cameraUpdateParams));
                }
            } else if (this.f30815u) {
                if (z && this.f30799d != null) {
                    CameraUpdate.CameraUpdateParams cameraUpdateParams2 = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
                    cameraUpdateParams2.latLng = this.f30800e.getPosition();
                    cameraUpdateParams2.level = this.f30799d.getCameraPosition().zoom;
                    cameraUpdateParams2.bearing = f;
                    cameraUpdateParams2.tilt = (float) m23677a(this.f30798c);
                    this.f30799d.moveCamera(new CameraUpdate(cameraUpdateParams2));
                }
                m23695a(z);
            }
        }
    }

    /* renamed from: a */
    private void m23695a(boolean z) {
        NavOverlay navOverlay;
        CarMarker carMarker;
        CarMarker carMarker2;
        if (this.f30799d == null || !ApolloUtil.shouldRemoveCarImage()) {
            if (!this.f30815u || !z || this.f30798c != CameraMode.CAR_HEAD_UP) {
                if (this.f30800e != null && (navOverlay = this.f30803h) != null) {
                    navOverlay.setVisible(false);
                    this.f30800e.setVisible(true);
                }
            } else if (this.f30803h != null && (carMarker = this.f30800e) != null) {
                carMarker.setVisible(false);
                this.f30803h.setVisible(true);
            }
        } else if (this.f30803h != null && (carMarker2 = this.f30800e) != null) {
            carMarker2.setVisible(true);
            this.f30803h.setVisible(false);
        }
    }

    public void setCameraMode(CameraMode cameraMode, boolean z) {
        if (this.f30798c != cameraMode || z) {
            if (!(this.f30800e == null || this.f30799d == null)) {
                if (this.f30798c == CameraMode.CAR_HEAD_UP) {
                    this.f30800e.restoreMarkerIcon();
                    CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
                    cameraUpdateParams.latLng = this.f30799d.getCameraPosition().target;
                    cameraUpdateParams.level = this.f30799d.getCameraPosition().zoom;
                    cameraUpdateParams.bearing = 0.0f;
                    this.f30799d.moveCamera(new CameraUpdate(cameraUpdateParams));
                } else {
                    this.f30800e.enlargeMarkerIcon();
                    if (z) {
                        CameraUpdate.CameraUpdateParams cameraUpdateParams2 = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
                        cameraUpdateParams2.latLng = this.f30800e.getPosition();
                        int i = this.f30817w;
                        if (i > 0) {
                            cameraUpdateParams2.level = (double) m23674a(i);
                        } else {
                            cameraUpdateParams2.level = this.f30789C;
                        }
                        cameraUpdateParams2.bearing = (float) m23703c();
                        cameraUpdateParams2.tilt = (float) m23677a(CameraMode.CAR_HEAD_UP);
                        this.f30799d.moveCamera(new CameraUpdate(cameraUpdateParams2));
                        m23690a(this.f30800e.getPosition());
                    }
                }
            }
            this.f30815u = false;
            this.f30798c = cameraMode;
            if (cameraMode == CameraMode.CAR_HEAD_UP) {
                this.f30800e.setFlat(true);
            } else {
                this.f30800e.setFlat(false);
            }
        }
    }

    public void setCameraMode(CameraMode cameraMode) {
        setCameraMode(cameraMode, true);
    }

    public void setCarImageView(NavOverlay navOverlay) {
        this.f30803h = navOverlay;
    }

    public void followMyLocation(boolean z) {
        this.f30815u = z;
        m23695a(false);
    }

    public void zoomToNav() {
        this.f30815u = true;
        this.f30798c = CameraMode.CAR_HEAD_UP;
        CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
        int i = this.f30817w;
        if (i > 0) {
            cameraUpdateParams.level = (double) m23674a(i);
        } else {
            cameraUpdateParams.level = (this.f30788B + this.f30789C) / 2.0d;
        }
        cameraUpdateParams.bearing = (float) m23703c();
        CarMarker carMarker = this.f30800e;
        if (carMarker != null) {
            carMarker.setRotation(cameraUpdateParams.bearing);
            cameraUpdateParams.latLng = this.f30800e.getPosition();
        } else {
            cameraUpdateParams.latLng = this.f30799d.getCameraPosition().target;
        }
        cameraUpdateParams.tilt = (float) m23677a(this.f30798c);
        this.f30799d.moveCamera(new CameraUpdate(cameraUpdateParams));
        CarMarker carMarker2 = this.f30800e;
        if (carMarker2 != null) {
            m23690a(carMarker2.getPosition());
        }
    }

    public void setCarHeadParams(int i, int i2) {
        this.f30820z = i;
        this.f30797K = i2;
    }

    public double distanceLeft() {
        List<LatLng> list = this.f30801f;
        if (list == null || list.isEmpty()) {
            return -1.0d;
        }
        List<LatLng> list2 = this.f30801f;
        AnimateNode animateNode = new AnimateNode(list2.get(list2.size() - 1), this.f30801f.size() - 1, 0, false);
        AnimateNode animateNode2 = this.f30805j;
        if (animateNode2 != null && animateNode2.index >= 0) {
            return C10824utils.getOnRoadDistance(this.f30801f, this.f30805j, animateNode);
        }
        CarMarker carMarker = this.f30800e;
        if (carMarker == null || carMarker.getPosition() == null) {
            return -1.0d;
        }
        return DDSphericalUtil.computeDistanceBetween(this.f30800e.getPosition(), animateNode.latLng);
    }

    public void setCarMarkerOrImageEnable(boolean z) {
        this.f30791E = z;
    }

    public void setCarHeadMaxMapLevel(double d) {
        Map map = this.f30799d;
        if (map != null && map.getMapVendor() == MapVendor.GOOGLE) {
            this.f30789C = d;
            DLog.m10773d(f30784a, "AutoBackController setCarHeadMaxMapLevel = " + d, new Object[0]);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007d, code lost:
        if (r0 < r2) goto L_0x0077;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float m23674a(int r5) {
        /*
            r4 = this;
            double r0 = r4.f30788B
            java.util.List<com.didi.common.map.model.LatLng> r2 = r4.f30801f
            if (r2 == 0) goto L_0x0071
            int r2 = r2.size()
            if (r5 >= r2) goto L_0x0071
            if (r5 <= 0) goto L_0x0071
            com.didi.map.sdk.nav.car.CarMarker r2 = r4.f30800e
            if (r2 == 0) goto L_0x0071
            com.didi.common.map.Map r2 = r4.f30799d
            if (r2 == 0) goto L_0x0071
            java.util.List<com.didi.common.map.model.LatLng> r0 = r4.f30801f
            java.lang.Object r5 = r0.get(r5)
            com.didi.common.map.model.LatLng r5 = (com.didi.common.map.model.LatLng) r5
            com.didi.map.sdk.nav.car.CarMarker r0 = r4.f30800e
            com.didi.common.map.model.LatLng r0 = r0.getPosition()
            double r0 = com.didi.common.map.util.DDSphericalUtil.computeDistanceBetween(r5, r0)
            com.didi.map.sdk.nav.car.DriverCarNewAnimApollo r5 = com.didi.map.sdk.nav.car.DriverCarNewAnimApollo.getInstance()
            boolean r5 = r5.enable()
            if (r5 == 0) goto L_0x0044
            com.didi.map.sdk.nav.car.DriverCarNewAnimApollo r5 = com.didi.map.sdk.nav.car.DriverCarNewAnimApollo.getInstance()
            int r5 = r5.getMapTiltValue()
            double r2 = (double) r5
            double r2 = com.didi.map.sdk.nav.car.C10824utils.angle2Rad(r2)
            double r2 = java.lang.Math.cos(r2)
            double r0 = r0 / r2
        L_0x0044:
            r2 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            double r0 = r0 * r2
            int r5 = r4.f30820z
            float r5 = (float) r5
            r2 = 1116733440(0x42900000, float:72.0)
            float r5 = r5 * r2
            com.didi.common.map.Map r2 = r4.f30799d
            android.content.Context r2 = r2.getContext()
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            float r2 = r2.ydpi
            float r5 = r5 / r2
            double r2 = (double) r5
            double r0 = r0 / r2
            com.didi.map.sdk.nav.car.CarMarker r5 = r4.f30800e
            com.didi.common.map.model.LatLng r5 = r5.getPosition()
            double r2 = r5.latitude
            double r0 = com.didi.map.sdk.nav.util.VisibleUtil.getBestZoomByMetersPerPonit(r2, r0)
        L_0x0071:
            double r2 = r4.f30789C
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0079
        L_0x0077:
            r0 = r2
            goto L_0x0080
        L_0x0079:
            double r2 = r4.f30788B
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x0080
            goto L_0x0077
        L_0x0080:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = "AutoBackController getNavZoomLevel level = "
            r5.append(r2)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "AnimationNewPart"
            com.didi.common.map.util.DLog.m10773d(r3, r5, r2)
            float r5 = (float) r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.nav.car.AnimationNewPart.m23674a(int):float");
    }

    /* renamed from: b */
    private double m23697b(int i) {
        List<LatLng> list;
        if (this.f30799d == null || (list = this.f30801f) == null || list.isEmpty() || this.f30800e == null) {
            return 0.0d;
        }
        double d = this.f30789C;
        float width = (float) this.f30799d.getWidth();
        float f = (float) this.f30820z;
        if (width <= 0.0f) {
            width = 1.0f;
        }
        if (f <= 0.0f) {
            f = 1.0f;
        }
        MapUtils.getSymmetry(this.f30800e.getPosition(), this.f30801f.get(i));
        LatLngBounds.Builder builder = LatLngBounds.builder();
        builder.include(this.f30801f.get(i));
        builder.include(this.f30800e.getPosition());
        LatLngBounds build = builder.build();
        float f2 = (float) d;
        float lng2Pixel = lng2Pixel(this.f30799d.getContext(), build.northeast.longitude, f2);
        float lat2Pixel = lat2Pixel(this.f30799d.getContext(), build.northeast.latitude, f2);
        float lng2Pixel2 = lng2Pixel(this.f30799d.getContext(), build.southwest.longitude, f2);
        float abs = Math.abs(lat2Pixel - lat2Pixel(this.f30799d.getContext(), build.southwest.latitude, f2));
        float abs2 = Math.abs(lng2Pixel - lng2Pixel2);
        if (abs / abs2 > f / width) {
            width = f;
        } else {
            abs = abs2;
        }
        Map map = this.f30799d;
        if (map == null || map.getCameraPosition() == null) {
            DLog.m10773d(f30784a, "map == null or getCameraPosition == null", new Object[0]);
            return 2.0d;
        }
        float log10 = (float) (Math.log10((double) ((width / (abs / ((float) (((double) TypedValue.applyDimension(1, 256.0f, this.f30799d.getContext().getResources().getDisplayMetrics())) * Math.pow(2.0d, d))))) / TypedValue.applyDimension(1, 256.0f, this.f30799d.getContext().getResources().getDisplayMetrics()))) / Math.log10(2.0d));
        if (Float.isNaN(log10)) {
            return this.f30799d.getMaxZoomLevel();
        }
        double d2 = (double) log10;
        if (d2 > this.f30799d.getMaxZoomLevel()) {
            return this.f30799d.getMaxZoomLevel();
        }
        if (d2 < this.f30799d.getMinZoomLevel()) {
            return this.f30799d.getMinZoomLevel();
        }
        DLog.m10773d(f30784a, "The bestLevel = " + log10 + ", from Level = " + this.f30799d.getCameraPosition().zoom, new Object[0]);
        return d2;
    }

    public static float lng2Pixel(Context context, double d, float f) {
        return (float) (((d + 180.0d) * (((double) TypedValue.applyDimension(1, 256.0f, context.getResources().getDisplayMetrics())) * Math.pow(2.0d, (double) f))) / 360.0d);
    }

    public static float lat2Pixel(Context context, double d, float f) {
        double sin = Math.sin((d * 3.141592653589793d) / 180.0d);
        return (float) (((double) TypedValue.applyDimension(1, 128.0f, context.getResources().getDisplayMetrics())) * Math.pow(2.0d, (double) f) * (1.0d - (Math.log((sin + 1.0d) / (1.0d - sin)) / 6.283185307179586d)));
    }

    /* renamed from: c */
    private double m23703c() {
        LatLng latLng;
        Map map = this.f30799d;
        double d = map != null ? (double) map.getCameraPosition().bearing : 0.0d;
        int i = 0;
        List<LatLng> list = this.f30801f;
        LatLng latLng2 = null;
        if (list == null || list.size() <= 0) {
            CarMarker carMarker = this.f30800e;
            if (carMarker != null && ((double) carMarker.getRotation()) != 0.0d) {
                return (((double) this.f30800e.getRotation()) + 360.0d) % 360.0d;
            }
            latLng = null;
        } else {
            AnimateNode animateNode = this.f30805j;
            if (animateNode != null) {
                if (-1 == animateNode.index) {
                    AnimateNode animateNode2 = this.f30787A;
                    if (animateNode2 == null || animateNode2.index == -1) {
                        i = this.f30797K;
                    } else {
                        i = this.f30787A.index;
                    }
                } else {
                    i = this.f30805j.index;
                }
            }
            LatLng latLng3 = this.f30801f.size() > i ? this.f30801f.get(i) : null;
            int i2 = i + 1;
            if (this.f30801f.size() > i2) {
                latLng2 = this.f30801f.get(i2);
            }
            latLng = latLng2;
            latLng2 = latLng3;
        }
        return (latLng2 == null || latLng == null) ? d : (DDSphericalUtil.computeHeading(latLng2, latLng) + 360.0d) % 360.0d;
    }

    public AnimateNode getCurrentAnimNode() {
        return this.f30805j;
    }

    public void resetMapTilt() {
        Map map;
        if (DriverCarNewAnimApollo.getInstance().enable() && (map = this.f30799d) != null && map.getCameraPosition() != null) {
            CameraUpdate.CameraUpdateParams cameraUpdateParams = new CameraUpdate.CameraUpdateParams(CameraUpdate.CameraUpdateParams.CameraUpdateType.CAMERA_POSITION);
            cameraUpdateParams.latLng = this.f30799d.getCameraPosition().target;
            cameraUpdateParams.level = this.f30799d.getCameraPosition().zoom;
            cameraUpdateParams.bearing = this.f30799d.getCameraPosition().bearing;
            cameraUpdateParams.tilt = 0.0f;
            this.f30799d.moveCamera(new CameraUpdate(cameraUpdateParams));
        }
    }

    /* renamed from: a */
    private int m23677a(CameraMode cameraMode) {
        if (DriverCarNewAnimApollo.getInstance().enable() && cameraMode == CameraMode.CAR_HEAD_UP) {
            return DriverCarNewAnimApollo.getInstance().getMapTiltValue();
        }
        return 0;
    }
}
