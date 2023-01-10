package com.didi.component.expectation.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.didi.component.common.util.UIUtils;
import com.didi.component.expectation.model.ProgressState;
import com.didi.travel.psnger.utils.UIThreadHandler;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class WaitView extends LinearLayout {

    /* renamed from: a */
    List<ProgressState> f15491a;

    /* renamed from: b */
    private final View f15492b;

    /* renamed from: c */
    private final FrameLayout f15493c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ProgressBar f15494d;

    /* renamed from: e */
    private final LottieAnimationView f15495e;

    /* renamed from: f */
    private final LottieAnimationView f15496f;

    /* renamed from: g */
    private final LottieAnimationView f15497g;

    /* renamed from: h */
    private final LottieAnimationView f15498h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final LottieAnimationView f15499i;

    /* renamed from: j */
    private final FrameLayout f15500j;

    /* renamed from: k */
    private final ImageView f15501k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final FrameLayout f15502l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final ImageView f15503m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final TextView f15504n;

    /* renamed from: o */
    private int f15505o;

    /* renamed from: p */
    private float f15506p;

    /* renamed from: q */
    private final int f15507q;

    /* renamed from: r */
    private float f15508r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final Context f15509s;

    /* renamed from: t */
    private ObjectAnimator f15510t;

    /* renamed from: u */
    private ObjectAnimator f15511u;

    /* renamed from: v */
    private final int f15512v;

    /* renamed from: w */
    private float f15513w;

    /* renamed from: x */
    private List<ViewHolder> f15514x;

    /* renamed from: y */
    private int f15515y;

    public WaitView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WaitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15505o = 100;
        View inflate = LayoutInflater.from(context).inflate(R.layout.wait_need_compensation_layout, this, false);
        this.f15492b = inflate;
        this.f15493c = (FrameLayout) inflate.findViewById(R.id.root_fl);
        this.f15494d = (ProgressBar) this.f15492b.findViewById(R.id.progress_bar);
        this.f15496f = (LottieAnimationView) this.f15492b.findViewById(R.id.gift_lottie_view);
        this.f15497g = (LottieAnimationView) this.f15492b.findViewById(R.id.discount_lottie_view);
        this.f15498h = (LottieAnimationView) this.f15492b.findViewById(R.id.start_bg_lottie_view);
        this.f15499i = (LottieAnimationView) this.f15492b.findViewById(R.id.discount_lottie_view_translate);
        this.f15500j = (FrameLayout) this.f15492b.findViewById(R.id.thumb_layout_fl);
        this.f15495e = (LottieAnimationView) this.f15492b.findViewById(R.id.thumb_lottie_view);
        this.f15501k = (ImageView) this.f15492b.findViewById(R.id.thumb_image);
        this.f15502l = (FrameLayout) this.f15492b.findViewById(R.id.gift_box_layout_fl);
        this.f15503m = (ImageView) this.f15492b.findViewById(R.id.discount_coupon_image);
        this.f15504n = (TextView) this.f15492b.findViewById(R.id.discount_number);
        this.f15505o = this.f15494d.getMax();
        this.f15509s = context;
        this.f15512v = UIUtils.dip2pxInt(context, 282.0f);
        this.f15507q = UIUtils.dip2pxInt(this.f15509s, 217.0f);
        addView(this.f15492b);
    }

    public void addNodeView(List<ProgressState> list) {
        if (list != null && list.size() > 0) {
            this.f15491a = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                ProgressState progressState = list.get(i);
                ProgressState progressState2 = new ProgressState();
                progressState2.setEndIconType(progressState.getEndIconType());
                progressState2.setEndIconUri(progressState.getEndIconUri());
                progressState2.setEndProgress(progressState.getEndProgress());
                progressState2.setProcessIconType(progressState.getProcessIconType());
                progressState2.setProcessIconUri(progressState.getProcessIconUri());
                progressState2.setShowTime(progressState.getShowTime());
                progressState2.setStartProgress(progressState.getStartProgress());
                progressState2.setTimeInterval(progressState.getTimeInterval());
                this.f15491a.add(progressState2);
            }
            List<ViewHolder> list2 = this.f15514x;
            if (list2 != null && list2.size() > 0) {
                for (int i2 = 0; i2 < this.f15514x.size(); i2++) {
                    if (!(this.f15514x.get(i2).nodeRoot == null || this.f15514x.get(i2).nodeRoot.getParent() == null)) {
                        this.f15493c.removeView(this.f15514x.get(i2).nodeRoot);
                    }
                }
            }
            if (this.f15514x == null) {
                this.f15514x = new ArrayList();
            }
            this.f15514x.clear();
            int size = list.size();
            this.f15515y = size;
            this.f15506p = (((float) this.f15505o) * 1.0f) / ((float) size);
            float f = (float) size;
            float f2 = (((float) this.f15512v) * 1.0f) / f;
            this.f15513w = f2;
            this.f15508r = (((float) this.f15507q) * 1.0f) / f;
            int i3 = 0;
            while (i3 < list.size()) {
                View inflate = LayoutInflater.from(this.f15509s).inflate(R.layout.wait_progress_node_layout, this.f15493c, false);
                FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.node_fl);
                LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.node_lottie);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.node_image);
                frameLayout.setId(View.generateViewId());
                lottieAnimationView.setId(View.generateViewId());
                imageView.setId(View.generateViewId());
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.nodeRoot = inflate;
                viewHolder.nodeFl = frameLayout;
                viewHolder.nodeImage = imageView;
                viewHolder.nodeLottie = lottieAnimationView;
                this.f15514x.add(viewHolder);
                int i4 = i3 + 1;
                int dip2pxInt = (((int) f2) * i4) - UIUtils.dip2pxInt(this.f15509s, 100.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UIUtils.dip2pxInt(this.f15509s, 100.0f), UIUtils.dip2pxInt(this.f15509s, 100.0f), 16);
                layoutParams.setMargins(dip2pxInt, 0, 0, 0);
                frameLayout.setLayoutParams(layoutParams);
                this.f15493c.addView(inflate);
                ProgressState progressState3 = list.get(i3);
                if (progressState3 == null) {
                    frameLayout.setVisibility(8);
                } else if (progressState3.getEndIconType() == 0) {
                    frameLayout.setVisibility(8);
                } else if (progressState3.getEndIconType() == 1 && !TextUtils.isEmpty(progressState3.getEndIconUri()) && !isDestroy((Activity) this.f15509s)) {
                    frameLayout.setVisibility(0);
                    lottieAnimationView.setVisibility(8);
                    imageView.setVisibility(0);
                    Glide.with(this.f15509s).load(progressState3.getEndIconUri()).into(imageView);
                } else if (progressState3.getEndIconType() != 2 || TextUtils.isEmpty(progressState3.getEndIconUri())) {
                    frameLayout.setVisibility(8);
                } else {
                    frameLayout.setVisibility(0);
                    lottieAnimationView.setVisibility(0);
                    imageView.setVisibility(8);
                    playLocalNodeLottie(lottieAnimationView, progressState3.getEndIconUri());
                }
                i3 = i4;
            }
        }
    }

    static class ViewHolder {
        public FrameLayout nodeFl;
        public ImageView nodeImage;
        public LottieAnimationView nodeLottie;
        public View nodeRoot;

        ViewHolder() {
        }
    }

    public void setThumbLayoutVisibility(int i) {
        FrameLayout frameLayout = this.f15500j;
        if (frameLayout != null) {
            frameLayout.setVisibility(i);
        }
    }

    public void setThumbLottieVisibility(int i) {
        LottieAnimationView lottieAnimationView = this.f15495e;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(i);
        }
    }

    public void setThumbImageVisibility(int i) {
        ImageView imageView = this.f15501k;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setDiscountLottieVisibility(int i) {
        LottieAnimationView lottieAnimationView = this.f15497g;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(i);
        }
    }

    public void setProgressBarVisibility(int i) {
        ProgressBar progressBar = this.f15494d;
        if (progressBar != null) {
            progressBar.setVisibility(i);
        }
    }

    public void setEndGiftBoxFlVisibility(int i) {
        FrameLayout frameLayout = this.f15502l;
        if (frameLayout != null) {
            frameLayout.setVisibility(i);
        }
    }

    public void setGiftBoxLottieVisibility(int i) {
        LottieAnimationView lottieAnimationView = this.f15496f;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(i);
        }
    }

    public void setDiscountCouponVisibility(int i) {
        ImageView imageView = this.f15503m;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setDiscountNumberVisibility(int i) {
        TextView textView = this.f15504n;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    public void setStartBgLottieVisibility(int i) {
        LottieAnimationView lottieAnimationView = this.f15498h;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(i);
        }
    }

    public void setNodesVisibility(int i) {
        List<ViewHolder> list = this.f15514x;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.f15514x.size(); i2++) {
                this.f15514x.get(i2).nodeFl.setVisibility(i);
            }
        }
    }

    public void cancelThumbAnim() {
        ObjectAnimator objectAnimator = this.f15510t;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f15510t.removeAllListeners();
            this.f15510t = null;
        }
    }

    public void cancelShakeAnim() {
        ObjectAnimator objectAnimator = this.f15511u;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f15511u.removeAllListeners();
            this.f15511u = null;
        }
    }

    public void cancelThumbLottie() {
        LottieAnimationView lottieAnimationView = this.f15495e;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            this.f15495e.clearAnimation();
        }
    }

    public void cancelGiftBoxLottie() {
        LottieAnimationView lottieAnimationView = this.f15496f;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            this.f15496f.clearAnimation();
        }
    }

    public void updateThumbMargin(float f, float f2, int i) {
        ProgressState progressState = this.f15491a.get(i);
        float startProgress = (((float) i) * this.f15508r) + (((f - progressState.getStartProgress()) / (progressState.getEndProgress() - progressState.getStartProgress())) * this.f15508r);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UIUtils.dip2pxInt(this.f15509s, 40.0f), UIUtils.dip2pxInt(this.f15509s, 40.0f), 16);
        layoutParams.setMargins((int) startProgress, 0, 0, 0);
        this.f15500j.setLayoutParams(layoutParams);
    }

    public void setProgress(float f, ProgressState progressState, int i) {
        ProgressState progressState2 = this.f15491a.get(i);
        this.f15494d.setProgress((int) ((((float) i) * this.f15506p) + (((f - progressState2.getStartProgress()) / (progressState2.getEndProgress() - progressState2.getStartProgress())) * this.f15506p)));
    }

    public void setMaxProgress(int i) {
        this.f15505o = i;
        this.f15506p = (((float) i) * 1.0f) / ((float) this.f15515y);
        this.f15494d.setMax(i);
    }

    public void showRemoteThumbImage(String str) {
        if (this.f15501k != null && !TextUtils.isEmpty(str) && !isDestroy((Activity) this.f15509s)) {
            Glide.with(this.f15509s).load(str).into(this.f15501k);
        }
    }

    public void playLocalNodeLottie(LottieAnimationView lottieAnimationView, String str) {
        if (lottieAnimationView.isAnimating()) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.clearAnimation();
        }
        lottieAnimationView.setAnimation(str);
        lottieAnimationView.setRepeatMode(1);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.playAnimation();
    }

    public void playLocalThumbLottie(String str) {
        if (this.f15495e.isAnimating()) {
            this.f15495e.cancelAnimation();
            this.f15495e.clearAnimation();
        }
        this.f15495e.setAnimation(str);
        this.f15495e.setRepeatMode(1);
        this.f15495e.setRepeatCount(-1);
        this.f15495e.playAnimation();
    }

    public void translateThumb(float f, float f2, int i, int i2) {
        ObjectAnimator objectAnimator = this.f15510t;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f15510t.removeAllListeners();
            this.f15510t = null;
        }
        ProgressState progressState = this.f15491a.get(i2);
        float endProgress = (((float) i2) * this.f15508r) + (((f2 - f) / (progressState.getEndProgress() - progressState.getStartProgress())) * this.f15508r);
        int i3 = ((FrameLayout.LayoutParams) this.f15500j.getLayoutParams()).leftMargin;
        float translationX = this.f15500j.getTranslationX();
        if (i3 > 0) {
            endProgress = (((float) (i2 + 1)) * this.f15508r) - ((float) i3);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f15500j, "translationX", new float[]{translationX, endProgress});
        this.f15510t = ofFloat;
        ofFloat.setDuration((long) ((i * 1000) + 2000));
        this.f15510t.start();
    }

    public void setTranslationX(float f) {
        FrameLayout frameLayout = this.f15500j;
        if (frameLayout != null) {
            frameLayout.setTranslationX(f);
            this.f15500j.requestLayout();
        }
    }

    public void playGiftBoxLottie(String str, Animator.AnimatorListener animatorListener) {
        if (this.f15496f.isAnimating()) {
            this.f15496f.cancelAnimation();
            this.f15496f.removeAllAnimatorListeners();
            this.f15496f.clearAnimation();
        }
        this.f15496f.setAnimation(str);
        this.f15496f.setImageAssetsFolder("images/");
        this.f15496f.setRepeatMode(1);
        this.f15496f.setRepeatCount(0);
        if (animatorListener != null) {
            this.f15496f.addAnimatorListener(animatorListener);
        }
        this.f15496f.playAnimation();
    }

    public void shakeGiftBox(float f, long j, int i, int i2, Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimator = this.f15511u;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f15511u.removeAllListeners();
            this.f15511u = null;
        }
        List<ViewHolder> list = this.f15514x;
        ViewHolder viewHolder = list.get(list.size() - 1);
        viewHolder.nodeImage.setRotation(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewHolder.nodeImage, "rotation", new float[]{0.0f, f, 0.0f, -f, 0.0f});
        this.f15511u = ofFloat;
        ofFloat.setDuration(j);
        this.f15511u.setRepeatMode(1);
        if (i == 0) {
            this.f15511u.setRepeatCount(0);
        } else if (i == -1) {
            this.f15511u.setRepeatCount(-1);
        }
        if (animatorListener != null) {
            this.f15511u.addListener(animatorListener);
        }
        this.f15511u.start();
    }

    public void openBoxAndShowCoupon(final float f) {
        List<ViewHolder> list = this.f15514x;
        list.get(list.size() - 1).nodeFl.setVisibility(8);
        this.f15498h.setVisibility(8);
        setThumbLayoutVisibility(8);
        this.f15496f.setVisibility(0);
        UIThreadHandler.post(new Runnable() {
            public void run() {
                WaitView.this.f15503m.setVisibility(0);
                WaitView.this.f15504n.setVisibility(0);
                WaitView.this.f15504n.setText(String.valueOf((int) f));
            }
        }, 300);
        playGiftBoxLottie("gift_box_open.json", new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator, boolean z) {
            }

            public void onAnimationEnd(Animator animator, boolean z) {
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.setStartOffset(500);
                animationSet.setInterpolator(PathInterpolatorCompat.create(0.26f, 0.0f, 0.46f, 1.0f));
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -UIUtils.dip2px(WaitView.this.f15509s, 88.0f), 0.0f, 0.0f);
                translateAnimation.setFillAfter(true);
                translateAnimation.setDuration(500);
                translateAnimation.setRepeatCount(0);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setRepeatCount(0);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        WaitView.this.f15502l.setVisibility(8);
                    }
                });
                WaitView.this.f15502l.startAnimation(animationSet);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setInterpolator(PathInterpolatorCompat.create(0.26f, 0.0f, 0.46f, 1.0f));
                alphaAnimation2.setDuration(250);
                alphaAnimation2.setStartOffset(500);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setRepeatCount(0);
                alphaAnimation2.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        WaitView.this.setProgressBarVisibility(8);
                        WaitView.this.setEndGiftBoxFlVisibility(8);
                        WaitView.this.setNodesVisibility(8);
                    }
                });
                WaitView.this.f15494d.startAnimation(alphaAnimation2);
                UIThreadHandler.post(new Runnable() {
                    public void run() {
                        WaitView.this.f15499i.setVisibility(0);
                        AnimationSet animationSet = new AnimationSet(true);
                        animationSet.setInterpolator(PathInterpolatorCompat.create(0.26f, 0.0f, 0.46f, 1.0f));
                        animationSet.setAnimationListener(new Animation.AnimationListener() {
                            public void onAnimationRepeat(Animation animation) {
                            }

                            public void onAnimationStart(Animation animation) {
                            }

                            public void onAnimationEnd(Animation animation) {
                                WaitView.this.setDiscountLottieVisibility(0);
                                WaitView.this.f15499i.setVisibility(8);
                            }
                        });
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -UIUtils.dip2px(WaitView.this.f15509s, 94.0f), 0.0f, 0.0f);
                        translateAnimation.setDuration(500);
                        translateAnimation.setRepeatCount(0);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration(500);
                        alphaAnimation.setRepeatCount(0);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(alphaAnimation);
                        WaitView.this.f15499i.startAnimation(animationSet);
                    }
                }, 500);
            }
        });
    }

    public static boolean isDestroy(Activity activity) {
        return activity == null || activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed());
    }
}
