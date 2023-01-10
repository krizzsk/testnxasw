package com.didi.globalsafetoolkit.business.bubble;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TimingLogger;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.globalsafetoolkit.business.bubble.BubbleSwitcherView;
import com.didi.globalsafetoolkit.business.bubble.model.SfBubbleData;
import com.didi.globalsafetoolkit.imageloader.SfOnlineImageCacheRegister;
import com.didi.globalsafetoolkit.util.JarvisArgbEvaluator;
import com.didi.globalsafetoolkit.util.SfViewUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.resource.warehouse.tools.LogUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.taxis99.R;
import global.didi.pay.newview.pix.IPixView;
import rui.config.RConfigConstants;

public class BubbleView extends FrameLayout implements ViewSwitcher.ViewFactory {

    /* renamed from: a */
    private static final String f24930a = "BubbleView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SimpleDraweeView f24931b;

    /* renamed from: c */
    private ViewSwitcher f24932c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f24933d;

    /* renamed from: e */
    private String f24934e;

    /* renamed from: f */
    private int f24935f;

    /* renamed from: g */
    private boolean f24936g = true;

    /* renamed from: h */
    private int f24937h;

    /* renamed from: i */
    private int f24938i;

    /* renamed from: j */
    private int f24939j;

    /* renamed from: k */
    private int f24940k;

    /* renamed from: l */
    private int f24941l = -1;

    /* renamed from: m */
    private SparseArray<Drawable> f24942m = new SparseArray<>();

    public BubbleView(Context context) {
        super(context);
        this.f24933d = context;
        m19980a(context);
    }

    public BubbleView(Context context, int i) {
        super(context);
        this.f24933d = context;
        this.f24941l = i;
        m19980a(context);
    }

    public BubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24933d = context;
        m19980a(context);
    }

    public BubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24933d = context;
        m19980a(context);
    }

    /* renamed from: a */
    private void m19980a(Context context) {
        TimingLogger timingLogger = new TimingLogger(f24930a, IPixView.PAGE_STATUS_INIT);
        LayoutInflater.from(context).inflate(R.layout.sf_jarvis_bubble_layout, this, true);
        timingLogger.addSplit("inflate");
        this.f24931b = (SimpleDraweeView) findViewById(R.id.sf_safe_toolkit_bubble_icon);
        timingLogger.addSplit("mIconView");
        this.f24932c = (ViewSwitcher) findViewById(R.id.sf_jarvis_switcher);
        timingLogger.addSplit("mViewSwitcher");
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f24933d, R.anim.in);
        timingLogger.addSplit("Animation in");
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f24933d, R.anim.out);
        timingLogger.addSplit("Animation out");
        this.f24932c.setInAnimation(loadAnimation);
        timingLogger.addSplit("Animation set in");
        this.f24932c.setOutAnimation(loadAnimation2);
        timingLogger.addSplit("Animation set out");
        this.f24932c.setFactory(this);
        timingLogger.addSplit("setfactory");
        timingLogger.dumpToLog();
    }

    public void setIconSize(int i) {
        int dip2px = (i - UiUtils.dip2px(getContext(), 30.0f)) / 2;
        ((FrameLayout.LayoutParams) this.f24931b.getLayoutParams()).setMargins(dip2px, dip2px, dip2px, dip2px);
    }

    public void setVisibleExceptImg(boolean z) {
        this.f24932c.setVisibility(z ? 0 : 8);
    }

    public void updateSwitcher(SfBubbleData sfBubbleData, BubbleSwitcherView.ClickListener clickListener) {
        if (this.f24936g) {
            ViewSwitcher viewSwitcher = this.f24932c;
            if (viewSwitcher != null && (viewSwitcher.getCurrentView() instanceof BubbleSwitcherView)) {
                ((BubbleSwitcherView) this.f24932c.getCurrentView()).updateSwitcherView(sfBubbleData, clickListener);
                this.f24936g = false;
                this.f24932c.getCurrentView().getLayoutParams().width = -2;
                this.f24932c.getCurrentView().getLayoutParams().height = -2;
                ((FrameLayout.LayoutParams) this.f24932c.getCurrentView().getLayoutParams()).gravity = 80;
                this.f24932c.getCurrentView().measure(0, 0);
                this.f24939j = this.f24932c.getCurrentView().getMeasuredHeight();
                this.f24937h = this.f24932c.getCurrentView().getMeasuredWidth();
                if (this.f24939j == 0) {
                    this.f24939j = getMeasuredHeight();
                }
                if (this.f24937h == 0) {
                    this.f24937h = getMeasuredWidth();
                }
                getLayoutParams().width = this.f24937h;
                getLayoutParams().height = this.f24939j;
                SystemUtils.log(4, f24930a, "first w = " + this.f24937h + "fist h = " + this.f24939j, (Throwable) null, "com.didi.globalsafetoolkit.business.bubble.BubbleView", 142);
                return;
            }
            return;
        }
        ViewSwitcher viewSwitcher2 = this.f24932c;
        if (viewSwitcher2 != null && (viewSwitcher2.getNextView() instanceof BubbleSwitcherView)) {
            BubbleSwitcherView bubbleSwitcherView = (BubbleSwitcherView) this.f24932c.getNextView();
            bubbleSwitcherView.updateSwitcherView(sfBubbleData, clickListener);
            ((FrameLayout.LayoutParams) bubbleSwitcherView.getLayoutParams()).gravity = 80;
            this.f24932c.getNextView().getLayoutParams().width = -2;
            this.f24932c.getNextView().getLayoutParams().height = -2;
            this.f24932c.getNextView().measure(0, 0);
            int measuredHeight = this.f24932c.getNextView().getMeasuredHeight();
            int measuredWidth = this.f24932c.getNextView().getMeasuredWidth();
            if (measuredWidth == 0 || measuredHeight == 0) {
                measure(0, 0);
                if (measuredHeight == 0) {
                    measuredHeight = getMeasuredHeight();
                }
                if (measuredWidth == 0) {
                    measuredWidth = getMeasuredWidth();
                }
            }
            int i = this.f24937h;
            if (i != measuredWidth) {
                m19985b(i, measuredWidth);
                SystemUtils.log(4, f24930a, "lw = " + this.f24937h + "w = " + measuredWidth, (Throwable) null, "com.didi.globalsafetoolkit.business.bubble.BubbleView", 173);
            }
            this.f24937h = measuredWidth;
            int i2 = this.f24939j;
            if (i2 != measuredHeight) {
                m19979a(i2, measuredHeight);
                SystemUtils.log(4, f24930a, "lh = " + this.f24939j + "h = " + measuredHeight, (Throwable) null, "com.didi.globalsafetoolkit.business.bubble.BubbleView", 179);
            }
            this.f24939j = measuredHeight;
            this.f24932c.showNext();
        }
    }

    /* renamed from: a */
    private void m19979a(int i, int i2) {
        if (i != i2) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BubbleView.this.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    SystemUtils.log(4, BubbleView.f24930a, "animationH = " + valueAnimator.getAnimatedValue(), (Throwable) null, "com.didi.globalsafetoolkit.business.bubble.BubbleView$1", 197);
                    BubbleView.this.requestLayout();
                }
            });
            ofInt.setDuration(1000).start();
        }
    }

    /* renamed from: b */
    private void m19985b(int i, int i2) {
        if (i != i2) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BubbleView.this.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    SystemUtils.log(4, BubbleView.f24930a, "animationW = " + valueAnimator.getAnimatedValue(), (Throwable) null, "com.didi.globalsafetoolkit.business.bubble.BubbleView$2", 216);
                    BubbleView.this.requestLayout();
                }
            });
            ofInt.setDuration(1000).start();
        }
    }

    public void setBubbleBg(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 1) {
            str = "#00000000";
        }
        int parseColor = Color.parseColor(str);
        int i = this.f24935f;
        if (i == 0) {
            setBackground(createBgDrawable(parseColor, SfViewUtils.dp2px(this.f24933d, 20.0f)));
            this.f24935f = parseColor;
            return;
        }
        if (i != parseColor) {
            m19986c(i, parseColor);
        }
        this.f24935f = parseColor;
    }

    public void setIconResources(int i) {
        if (this.f24931b != null) {
            try {
                ((RequestBuilder) ((RequestBuilder) Glide.with(getContext()).load(Integer.valueOf(i)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).fitCenter()).into((ImageView) this.f24931b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public GradientDrawable createBgDrawable(int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius((float) i2);
        return gradientDrawable;
    }

    public void setBubbleSymbol(String str) {
        if (TextUtils.isEmpty(this.f24934e)) {
            m19983a(str, str);
        } else {
            m19983a(this.f24934e, str);
        }
    }

    /* renamed from: c */
    private void m19986c(final int i, final int i2) {
        ValueAnimator valueAnimator;
        if (Build.VERSION.SDK_INT < 21) {
            valueAnimator = ValueAnimator.ofObject(JarvisArgbEvaluator.getInstance(), new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            valueAnimator = ValueAnimator.ofArgb(new int[]{i, i2});
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            private JarvisArgbEvaluator evaluator = JarvisArgbEvaluator.getInstance();

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) this.evaluator.evaluate(valueAnimator.getAnimatedFraction(), Integer.valueOf(i), Integer.valueOf(i2))).intValue();
                BubbleView bubbleView = BubbleView.this;
                bubbleView.setBackground(bubbleView.createBgDrawable(intValue, SfViewUtils.dp2px(bubbleView.f24933d, 20.0f)));
            }
        });
        valueAnimator.setDuration(1000).start();
    }

    /* renamed from: a */
    private void m19983a(String str, final String str2) {
        LogUtil.m29978d(f24930a, "symbolAnimator:lastLevel = " + str + ", nowLevel = " + str2);
        this.f24934e = str2;
        m19982a(this.f24931b, str, false, new Runnable() {
            public void run() {
                BubbleView bubbleView = BubbleView.this;
                bubbleView.m19982a(bubbleView.f24931b, str2, true, (Runnable) null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19982a(final SimpleDraweeView simpleDraweeView, final String str, boolean z, final Runnable runnable) {
        LogUtil.m29978d(f24930a, "loadImage:draweeView = " + simpleDraweeView + ", dangerLevel = " + str + ", isIn = " + z + ", animationEndAction = " + runnable);
        if (simpleDraweeView != null) {
            simpleDraweeView.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(SfOnlineImageCacheRegister.getUrl(str, z)).setAutoPlayAnimations(true)).setControllerListener(new ControllerListener<ImageInfo>() {
                public void onIntermediateImageFailed(String str, Throwable th) {
                }

                public void onIntermediateImageSet(String str, ImageInfo imageInfo) {
                }

                public void onRelease(String str) {
                }

                public void onSubmit(String str, Object obj) {
                }

                public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
                    LogUtil.m29978d(BubbleView.f24930a, "onFinalImageSet:animatable = " + animatable);
                    if (animatable instanceof AnimatedDrawable2) {
                        ((AnimatedDrawable2) animatable).setAnimationListener(new AnimationListener() {
                            public void onAnimationStart(AnimatedDrawable2 animatedDrawable2) {
                                LogUtil.m29978d(BubbleView.f24930a, "onAnimationStart");
                            }

                            public void onAnimationStop(AnimatedDrawable2 animatedDrawable2) {
                                LogUtil.m29978d(BubbleView.f24930a, "onAnimationStop");
                                if (runnable != null && simpleDraweeView != null) {
                                    simpleDraweeView.post(new Runnable() {
                                        public void run() {
                                            runnable.run();
                                        }
                                    });
                                }
                            }

                            public void onAnimationReset(AnimatedDrawable2 animatedDrawable2) {
                                LogUtil.m29978d(BubbleView.f24930a, "onAnimationReset");
                            }

                            public void onAnimationRepeat(AnimatedDrawable2 animatedDrawable2) {
                                LogUtil.m29978d(BubbleView.f24930a, "onAnimationRepeat");
                            }

                            public void onAnimationFrame(AnimatedDrawable2 animatedDrawable2, int i) {
                                LogUtil.m29978d(BubbleView.f24930a, "onAnimationFrame");
                            }
                        });
                    }
                }

                public void onFailure(String str, Throwable th) {
                    SimpleDraweeView simpleDraweeView = simpleDraweeView;
                    if (simpleDraweeView != null) {
                        simpleDraweeView.setImageResource(SfOnlineImageCacheRegister.getPlaceHolderRes(str));
                        simpleDraweeView.postDelayed(new Runnable() {
                            public void run() {
                                if (runnable != null) {
                                    runnable.run();
                                }
                            }
                        }, 500);
                    }
                }
            })).build());
        }
    }

    /* renamed from: a */
    private Drawable m19978a(String str) {
        int identifier = getResources().getIdentifier(str, RConfigConstants.TYPE_DRAWABLE, getContext().getPackageName());
        if (identifier == 0) {
            return null;
        }
        Drawable drawable = this.f24942m.get(identifier);
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = getResources().getDrawable(identifier);
        this.f24942m.put(identifier, drawable2);
        return drawable2;
    }

    public View makeView() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        BubbleSwitcherView bubbleSwitcherView = new BubbleSwitcherView(this.f24933d);
        bubbleSwitcherView.setSize(this.f24941l);
        bubbleSwitcherView.setLayoutParams(layoutParams);
        return bubbleSwitcherView;
    }
}
