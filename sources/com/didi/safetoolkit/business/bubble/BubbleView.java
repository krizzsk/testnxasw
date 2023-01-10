package com.didi.safetoolkit.business.bubble;

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
import com.didi.safetoolkit.business.bubble.BubbleSwitcherView;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.imageloader.SfOnlineImageCacheRegister;
import com.didi.safetoolkit.util.JarvisArgbEvaluator;
import com.didi.safetoolkit.util.SfViewUtils;
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
import rui.config.RConfigConstants;

public class BubbleView extends FrameLayout implements ViewSwitcher.ViewFactory {

    /* renamed from: a */
    private static final String f37015a = "BubbleView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SimpleDraweeView f37016b;

    /* renamed from: c */
    private ViewSwitcher f37017c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f37018d;

    /* renamed from: e */
    private String f37019e;

    /* renamed from: f */
    private int f37020f;

    /* renamed from: g */
    private boolean f37021g = true;

    /* renamed from: h */
    private int f37022h;

    /* renamed from: i */
    private int f37023i;

    /* renamed from: j */
    private int f37024j;

    /* renamed from: k */
    private int f37025k;

    /* renamed from: l */
    private int f37026l = -1;

    /* renamed from: m */
    private SparseArray<Drawable> f37027m = new SparseArray<>();

    public BubbleView(Context context) {
        super(context);
        this.f37018d = context;
        m27957a(context);
    }

    public BubbleView(Context context, int i) {
        super(context);
        this.f37018d = context;
        this.f37026l = i;
        m27957a(context);
    }

    public BubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37018d = context;
        m27957a(context);
    }

    public BubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f37018d = context;
        m27957a(context);
    }

    /* renamed from: a */
    private void m27957a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.sf_jarvis_bubble_layout, this, true);
        this.f37016b = (SimpleDraweeView) findViewById(R.id.sf_safe_toolkit_bubble_icon);
        this.f37017c = (ViewSwitcher) findViewById(R.id.sf_jarvis_switcher);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f37018d, R.anim.in);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f37018d, R.anim.out);
        this.f37017c.setInAnimation(loadAnimation);
        this.f37017c.setOutAnimation(loadAnimation2);
        this.f37017c.setFactory(this);
    }

    public void setIconSize(int i) {
        int dip2px = (i - UiUtils.dip2px(getContext(), 30.0f)) / 2;
        ((FrameLayout.LayoutParams) this.f37016b.getLayoutParams()).setMargins(dip2px, dip2px, dip2px, dip2px);
    }

    public void setVisibleExceptImg(boolean z) {
        this.f37017c.setVisibility(z ? 0 : 8);
    }

    public void updateSwitcher(SfBubbleData sfBubbleData, BubbleSwitcherView.ClickListener clickListener) {
        if (this.f37021g) {
            ViewSwitcher viewSwitcher = this.f37017c;
            if (viewSwitcher != null && (viewSwitcher.getCurrentView() instanceof BubbleSwitcherView)) {
                ((BubbleSwitcherView) this.f37017c.getCurrentView()).updateSwitcherView(sfBubbleData, clickListener);
                this.f37021g = false;
                this.f37017c.getCurrentView().getLayoutParams().width = -2;
                this.f37017c.getCurrentView().getLayoutParams().height = -2;
                ((FrameLayout.LayoutParams) this.f37017c.getCurrentView().getLayoutParams()).gravity = 80;
                this.f37017c.getCurrentView().measure(0, 0);
                this.f37024j = this.f37017c.getCurrentView().getMeasuredHeight();
                this.f37022h = this.f37017c.getCurrentView().getMeasuredWidth();
                if (this.f37024j == 0) {
                    this.f37024j = getMeasuredHeight();
                }
                if (this.f37022h == 0) {
                    this.f37022h = getMeasuredWidth();
                }
                getLayoutParams().width = this.f37022h;
                getLayoutParams().height = this.f37024j;
                SystemUtils.log(4, f37015a, "first w = " + this.f37022h + "fist h = " + this.f37024j, (Throwable) null, "com.didi.safetoolkit.business.bubble.BubbleView", 139);
                return;
            }
            return;
        }
        ViewSwitcher viewSwitcher2 = this.f37017c;
        if (viewSwitcher2 != null && (viewSwitcher2.getNextView() instanceof BubbleSwitcherView)) {
            BubbleSwitcherView bubbleSwitcherView = (BubbleSwitcherView) this.f37017c.getNextView();
            bubbleSwitcherView.updateSwitcherView(sfBubbleData, clickListener);
            ((FrameLayout.LayoutParams) bubbleSwitcherView.getLayoutParams()).gravity = 80;
            this.f37017c.getNextView().getLayoutParams().width = -2;
            this.f37017c.getNextView().getLayoutParams().height = -2;
            this.f37017c.getNextView().measure(0, 0);
            int measuredHeight = this.f37017c.getNextView().getMeasuredHeight();
            int measuredWidth = this.f37017c.getNextView().getMeasuredWidth();
            if (measuredWidth == 0 || measuredHeight == 0) {
                measure(0, 0);
                if (measuredHeight == 0) {
                    measuredHeight = getMeasuredHeight();
                }
                if (measuredWidth == 0) {
                    measuredWidth = getMeasuredWidth();
                }
            }
            int i = this.f37022h;
            if (i != measuredWidth) {
                m27962b(i, measuredWidth);
                SystemUtils.log(4, f37015a, "lw = " + this.f37022h + "w = " + measuredWidth, (Throwable) null, "com.didi.safetoolkit.business.bubble.BubbleView", 170);
            }
            this.f37022h = measuredWidth;
            int i2 = this.f37024j;
            if (i2 != measuredHeight) {
                m27956a(i2, measuredHeight);
                SystemUtils.log(4, f37015a, "lh = " + this.f37024j + "h = " + measuredHeight, (Throwable) null, "com.didi.safetoolkit.business.bubble.BubbleView", 176);
            }
            this.f37024j = measuredHeight;
            this.f37017c.showNext();
        }
    }

    /* renamed from: a */
    private void m27956a(int i, int i2) {
        if (i != i2) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BubbleView.this.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    SystemUtils.log(4, BubbleView.f37015a, "animationH = " + valueAnimator.getAnimatedValue(), (Throwable) null, "com.didi.safetoolkit.business.bubble.BubbleView$1", 194);
                    BubbleView.this.requestLayout();
                }
            });
            ofInt.setDuration(1000).start();
        }
    }

    /* renamed from: b */
    private void m27962b(int i, int i2) {
        if (i != i2) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BubbleView.this.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    SystemUtils.log(4, BubbleView.f37015a, "animationW = " + valueAnimator.getAnimatedValue(), (Throwable) null, "com.didi.safetoolkit.business.bubble.BubbleView$2", 213);
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
        int i = this.f37020f;
        if (i == 0) {
            setBackground(createBgDrawable(parseColor, SfViewUtils.dp2px(this.f37018d, 20.0f)));
            this.f37020f = parseColor;
            return;
        }
        if (i != parseColor) {
            m27963c(i, parseColor);
        }
        this.f37020f = parseColor;
    }

    public void setIconResources(int i) {
        if (this.f37016b != null) {
            try {
                ((RequestBuilder) ((RequestBuilder) Glide.with(getContext()).load(Integer.valueOf(i)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).fitCenter()).into((ImageView) this.f37016b);
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
        if (TextUtils.isEmpty(this.f37019e)) {
            m27960a(str, str);
        } else {
            m27960a(this.f37019e, str);
        }
    }

    /* renamed from: c */
    private void m27963c(final int i, final int i2) {
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
                bubbleView.setBackground(bubbleView.createBgDrawable(intValue, SfViewUtils.dp2px(bubbleView.f37018d, 20.0f)));
            }
        });
        valueAnimator.setDuration(1000).start();
    }

    /* renamed from: a */
    private void m27960a(String str, final String str2) {
        LogUtil.m29978d(f37015a, "symbolAnimator:lastLevel = " + str + ", nowLevel = " + str2);
        this.f37019e = str2;
        m27959a(this.f37016b, str, false, new Runnable() {
            public void run() {
                BubbleView bubbleView = BubbleView.this;
                bubbleView.m27959a(bubbleView.f37016b, str2, true, (Runnable) null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27959a(final SimpleDraweeView simpleDraweeView, final String str, boolean z, final Runnable runnable) {
        LogUtil.m29978d(f37015a, "loadImage:draweeView = " + simpleDraweeView + ", dangerLevel = " + str + ", isIn = " + z + ", animationEndAction = " + runnable);
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
                    LogUtil.m29978d(BubbleView.f37015a, "onFinalImageSet:animatable = " + animatable);
                    if (animatable instanceof AnimatedDrawable2) {
                        ((AnimatedDrawable2) animatable).setAnimationListener(new AnimationListener() {
                            public void onAnimationStart(AnimatedDrawable2 animatedDrawable2) {
                                LogUtil.m29978d(BubbleView.f37015a, "onAnimationStart");
                            }

                            public void onAnimationStop(AnimatedDrawable2 animatedDrawable2) {
                                LogUtil.m29978d(BubbleView.f37015a, "onAnimationStop");
                                if (runnable != null && simpleDraweeView != null) {
                                    simpleDraweeView.post(new Runnable() {
                                        public void run() {
                                            runnable.run();
                                        }
                                    });
                                }
                            }

                            public void onAnimationReset(AnimatedDrawable2 animatedDrawable2) {
                                LogUtil.m29978d(BubbleView.f37015a, "onAnimationReset");
                            }

                            public void onAnimationRepeat(AnimatedDrawable2 animatedDrawable2) {
                                LogUtil.m29978d(BubbleView.f37015a, "onAnimationRepeat");
                            }

                            public void onAnimationFrame(AnimatedDrawable2 animatedDrawable2, int i) {
                                LogUtil.m29978d(BubbleView.f37015a, "onAnimationFrame");
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
    private Drawable m27955a(String str) {
        int identifier = getResources().getIdentifier(str, RConfigConstants.TYPE_DRAWABLE, getContext().getPackageName());
        if (identifier == 0) {
            return null;
        }
        Drawable drawable = this.f37027m.get(identifier);
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = getResources().getDrawable(identifier);
        this.f37027m.put(identifier, drawable2);
        return drawable2;
    }

    public View makeView() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        BubbleSwitcherView bubbleSwitcherView = new BubbleSwitcherView(this.f37018d);
        bubbleSwitcherView.setSize(this.f37026l);
        bubbleSwitcherView.setLayoutParams(layoutParams);
        return bubbleSwitcherView;
    }
}
