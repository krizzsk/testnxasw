package com.didi.component.mapflow.view.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.component.common.util.HandlerUtils;
import com.didi.component.core.IPresenter;
import com.didi.component.lifecycle.LifecycleOwner;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;

public class LottieSowingAnimationView extends FrameLayout {

    /* renamed from: a */
    private LottieAnimationView f16359a = ((LottieAnimationView) findViewById(R.id.global_map_anim_background));
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LottieAnimationView f16360b = ((LottieAnimationView) findViewById(R.id.global_map_anim_sowing));
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LottieAnimationView f16361c = ((LottieAnimationView) findViewById(R.id.global_map_anim_location));
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f16362d = findViewById(R.id.global_map_anim_sowing_group);

    /* renamed from: e */
    private boolean f16363e;

    /* renamed from: f */
    private boolean f16364f;

    /* renamed from: g */
    private boolean f16365g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f16366h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f16367i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LottieComposition f16368j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public LottieComposition f16369k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public LottieComposition f16370l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Map f16371m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public LatLng f16372n;

    /* renamed from: o */
    private IPresenter f16373o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ObjectAnimator f16374p;

    /* renamed from: q */
    private boolean f16375q;

    public LottieSowingAnimationView(IPresenter iPresenter, Context context) {
        super(context);
        this.f16373o = iPresenter;
        LayoutInflater.from(context).inflate(R.layout.global_map_sowing_animation, this, true);
        ApmThreadPool.execute((Runnable) new Runnable() {
            public void run() {
                LottieSowingAnimationView lottieSowingAnimationView = LottieSowingAnimationView.this;
                LottieComposition unused = lottieSowingAnimationView.f16368j = LottieCompositionFactory.fromRawResSync(lottieSowingAnimationView.getContext(), R.raw.map_anim_background).getValue();
                LottieSowingAnimationView lottieSowingAnimationView2 = LottieSowingAnimationView.this;
                LottieComposition unused2 = lottieSowingAnimationView2.f16369k = LottieCompositionFactory.fromRawResSync(lottieSowingAnimationView2.getContext(), R.raw.map_anim_sowing).getValue();
                LottieSowingAnimationView lottieSowingAnimationView3 = LottieSowingAnimationView.this;
                LottieComposition unused3 = lottieSowingAnimationView3.f16370l = LottieCompositionFactory.fromRawResSync(lottieSowingAnimationView3.getContext(), R.raw.map_anim_location).getValue();
                LottieSowingAnimationView.this.m13713a();
            }
        });
        this.f16359a.post(new Runnable() {
            public void run() {
                LottieSowingAnimationView lottieSowingAnimationView = LottieSowingAnimationView.this;
                float unused = lottieSowingAnimationView.f16366h = (float) lottieSowingAnimationView.getMeasuredWidth();
                LottieSowingAnimationView lottieSowingAnimationView2 = LottieSowingAnimationView.this;
                float unused2 = lottieSowingAnimationView2.f16367i = (float) lottieSowingAnimationView2.getMeasuredHeight();
                LottieSowingAnimationView.this.m13713a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13713a() {
        LottieComposition lottieComposition = this.f16368j;
        if (lottieComposition != null) {
            int width = lottieComposition.getBounds().width();
            float f = this.f16366h;
            if (f > 0.0f) {
                float f2 = this.f16367i;
                if (f2 > 0.0f && width > 0) {
                    this.f16368j.getBounds().set(0, 0, width, (int) ((f2 / f) * ((float) width)));
                    this.f16364f = true;
                    if (this.f16365g) {
                        start();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    public void bindMap(Map map, LatLng latLng) {
        if (map != null && latLng != null) {
            this.f16371m = map;
            this.f16372n = latLng;
            m13718b();
        }
    }

    /* renamed from: b */
    private void m13718b() {
        if (this.f16371m != null && this.f16372n != null && this.f16362d != null) {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    LottieSowingAnimationView.this.f16361c.playAnimation();
                }
            }, 400);
            HandlerUtils.getMainHandler().lifecycle((LifecycleOwner) this.f16373o).last(new Runnable() {
                public void run() {
                    LottieSowingAnimationView.this.f16360b.playAnimation();
                }
            }).loop(new Runnable() {
                public void run() {
                    PointF pointF;
                    if (LottieSowingAnimationView.this.f16371m.getProjection() != null) {
                        pointF = LottieSowingAnimationView.this.f16371m.getProjection().toScreenLocation(LottieSowingAnimationView.this.f16372n);
                    } else {
                        pointF = new PointF((float) LottieSowingAnimationView.this.getResources().getDisplayMetrics().widthPixels, (float) (LottieSowingAnimationView.this.getResources().getDisplayMetrics().heightPixels / 2));
                    }
                    if (pointF != null) {
                        int measuredWidth = LottieSowingAnimationView.this.f16362d.getMeasuredWidth();
                        int measuredHeight = LottieSowingAnimationView.this.f16362d.getMeasuredHeight();
                        if (measuredWidth > 0 && measuredHeight > 0) {
                            LottieSowingAnimationView.this.f16362d.getX();
                            float y = LottieSowingAnimationView.this.f16362d.getY();
                            float f = pointF.x;
                            int i = measuredWidth / 2;
                            float f2 = pointF.y - ((float) (measuredHeight / 2));
                            if (LottieSowingAnimationView.this.f16374p != null) {
                                LottieSowingAnimationView.this.f16374p.cancel();
                            }
                            LottieSowingAnimationView lottieSowingAnimationView = LottieSowingAnimationView.this;
                            ObjectAnimator unused = lottieSowingAnimationView.f16374p = ObjectAnimator.ofFloat(lottieSowingAnimationView.f16362d, View.Y, new float[]{y, f2});
                            LottieSowingAnimationView.this.f16374p.setDuration(200);
                            LottieSowingAnimationView.this.f16374p.start();
                        }
                    }
                }
            }, 200, 1200);
        }
    }

    public boolean isSowing() {
        return this.f16375q;
    }

    public void start() {
        this.f16375q = true;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            m13721c();
        } else {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    LottieSowingAnimationView.this.m13721c();
                }
            });
        }
    }

    public void stop() {
        this.f16375q = false;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            m13723d();
        } else {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    LottieSowingAnimationView.this.m13723d();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m13721c() {
        LottieComposition lottieComposition;
        LottieComposition lottieComposition2;
        LottieComposition lottieComposition3;
        this.f16363e = true;
        if (!this.f16364f) {
            this.f16365g = true;
            m13713a();
            return;
        }
        if (this.f16359a.getComposition() == null && (lottieComposition3 = this.f16368j) != null) {
            this.f16359a.setComposition(lottieComposition3);
        }
        if (this.f16360b.getComposition() == null && (lottieComposition2 = this.f16369k) != null) {
            this.f16360b.setComposition(lottieComposition2);
        }
        if (this.f16361c.getComposition() == null && (lottieComposition = this.f16370l) != null) {
            this.f16361c.setComposition(lottieComposition);
        }
        this.f16360b.setRepeatCount(-1);
        this.f16360b.addAnimatorListener(new AnimatorListenerAdapter() {
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                LottieSowingAnimationView.this.f16360b.setMinFrame(107);
            }

            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                LottieSowingAnimationView.this.f16360b.setMinFrame(36);
            }
        });
        this.f16359a.playAnimation();
        m13718b();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m13723d() {
        this.f16359a.cancelAnimation();
        this.f16360b.cancelAnimation();
        this.f16361c.cancelAnimation();
        this.f16363e = false;
    }

    public void hideSowing() {
        this.f16360b.setVisibility(8);
        this.f16361c.setVisibility(8);
        this.f16359a.animate().alpha(0.0f).setDuration(640).start();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f16363e) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
