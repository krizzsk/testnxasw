package com.didi.addressold.view.tips;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;

public class TipsView extends FrameLayout {

    /* renamed from: a */
    private CharSequence f9830a;

    /* renamed from: b */
    private TextView f9831b;

    /* renamed from: c */
    private TextView f9832c;

    /* renamed from: d */
    private TextView f9833d;

    /* renamed from: e */
    private boolean f9834e;

    /* renamed from: f */
    private boolean f9835f = false;

    /* renamed from: g */
    private boolean f9836g = false;

    /* renamed from: h */
    private Context f9837h;

    /* renamed from: i */
    private int f9838i;

    /* renamed from: j */
    private int f9839j;

    /* renamed from: k */
    private int f9840k;

    /* renamed from: l */
    private int f9841l;

    /* renamed from: m */
    private View f9842m;
    protected ImageView mIvGuide;
    protected View mIvTriangleBC;
    protected View mIvTriangleBL;
    protected View mIvTriangleBR;
    protected View mIvTriangleLC;
    protected View mIvTriangleRC;
    protected View mIvTriangleTC;
    protected View mIvTriangleTL;
    protected View mIvTriangleTR;
    protected FrameLayout mLineContainer;

    /* renamed from: n */
    private View f9843n;

    /* renamed from: o */
    private View f9844o;

    /* renamed from: p */
    private int f9845p;

    /* renamed from: q */
    private int f9846q;

    /* renamed from: r */
    private int f9847r;

    /* renamed from: s */
    private int f9848s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public TipsContainer f9849t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public View.OnClickListener f9850u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public View.OnClickListener f9851v;

    public TipsView(Context context) {
        super(context);
        m8558a(context);
    }

    public TipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8558a(context);
    }

    public TipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8558a(context);
    }

    public TipsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m8558a(context);
    }

    /* renamed from: a */
    private void m8558a(Context context) {
        this.f9837h = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.v_common_tips, this, true);
        this.f9842m = inflate;
        m8559a(inflate);
    }

    public String getTips() {
        CharSequence charSequence = this.f9830a;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void setTips(String str) {
        setTips((CharSequence) str);
    }

    public void setTips(CharSequence charSequence) {
        this.f9830a = charSequence;
        TextPaint paint = this.f9831b.getPaint();
        paint.setTextSize(this.f9831b.getTextSize());
        paint.measureText(charSequence.toString());
        if (charSequence.length() <= 3) {
            paint.measureText(charSequence.toString());
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f9831b.setVisibility(8);
            this.f9832c.setVisibility(8);
            this.f9833d.setVisibility(8);
            if (this.f9834e) {
                this.f9831b.setText(charSequence);
                this.f9831b.setVisibility(0);
                setContainerHeight(40);
            } else if (charSequence.length() > 20) {
                this.f9832c.setText(charSequence);
                this.f9832c.setVisibility(0);
                setContainerHeight(57);
            } else {
                this.f9831b.setText(charSequence);
                this.f9831b.setVisibility(0);
                setContainerHeight(40);
            }
        }
    }

    public void setSingleLine(boolean z) {
        this.f9834e = z;
        CharSequence charSequence = this.f9830a;
        if (charSequence != null && !TextUtil.isEmpty(charSequence.toString())) {
            setTips(this.f9830a);
        }
    }

    public void setShowGuideIcon(boolean z) {
        if (z) {
            this.f9836g = z;
            this.mIvGuide.setVisibility(0);
            findViewById(R.id.iv_guide_frame_close).setVisibility(0);
            this.f9843n.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_container);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.rightMargin = 0;
            relativeLayout.setLayoutParams(layoutParams);
        }
    }

    public void setMoreLineTips(String str) {
        setMoreLineTips((CharSequence) str);
    }

    public void setMoreLineTips(CharSequence charSequence) {
        this.f9830a = charSequence;
        if (!TextUtils.isEmpty(charSequence)) {
            this.f9833d.setText(charSequence);
            this.f9833d.setVisibility(0);
            this.f9831b.setVisibility(8);
            this.f9832c.setVisibility(8);
        }
    }

    public void setTipsSize(int i, float f) {
        TextView textView = this.f9833d;
        if (textView != null) {
            textView.setTextSize(i, f);
        }
        TextView textView2 = this.f9831b;
        if (textView2 != null) {
            textView2.setTextSize(i, f);
        }
        TextView textView3 = this.f9832c;
        if (textView3 != null) {
            textView3.setTextSize(i, f);
        }
    }

    public void setIcon(int i) {
        this.mIvGuide.setImageResource(i);
    }

    public void setIcon(String str) {
        if (!TextUtil.isEmpty(str)) {
            Glide.with(this.f9837h).load(str).into(this.mIvGuide);
        }
    }

    /* access modifiers changed from: protected */
    public void updateContent(String str) {
        updateContent((CharSequence) str);
    }

    /* access modifiers changed from: protected */
    public void updateContent(CharSequence charSequence) {
        this.f9830a = charSequence;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (this.f9831b.getVisibility() == 0) {
            this.f9831b.setText(charSequence);
        } else if (this.f9832c.getVisibility() == 0) {
            this.f9832c.setText(charSequence);
        } else if (this.f9833d.getVisibility() == 0) {
            this.f9833d.setText(charSequence);
        }
    }

    public void setEndAnimationDisable() {
        this.f9848s = 0;
    }

    public void setGuideWireMode(boolean z) {
        this.f9835f = z;
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.f9850u = onClickListener;
    }

    public void setmRemoveListener(View.OnClickListener onClickListener) {
        this.f9851v = onClickListener;
    }

    public void setMargins(int i, int i2, int i3, int i4) {
        this.f9838i = i;
        this.f9839j = i2;
        this.f9841l = i3;
        this.f9840k = i4;
    }

    public int getLeftMargin() {
        return this.f9838i;
    }

    public void setLeftMargin(int i) {
        this.f9838i = i;
    }

    public int getTopMargin() {
        return this.f9839j;
    }

    public void setTopMargin(int i) {
        this.f9839j = i;
    }

    public int getBottomMargin() {
        return this.f9840k;
    }

    public void setBottomMargin(int i) {
        this.f9840k = i;
    }

    public int getRightMargin() {
        return this.f9841l;
    }

    public void setRightMargin(int i) {
        this.f9841l = i;
    }

    public void attachContainer(TipsContainer tipsContainer) {
        this.f9849t = tipsContainer;
    }

    public void setPos(int i, int i2) {
        this.f9845p = i;
        this.f9846q = i2;
        mo44804a(i, i2);
        m8564b(this.f9845p, this.f9846q);
    }

    public void setPosGone() {
        View view = this.mIvTriangleTL;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mIvTriangleTC;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.mIvTriangleTR;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.mIvTriangleBL;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.mIvTriangleBC;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        View view6 = this.mIvTriangleBR;
        if (view6 != null) {
            view6.setVisibility(8);
        }
        View view7 = this.mIvTriangleLC;
        if (view7 != null) {
            view7.setVisibility(8);
        }
        View view8 = this.mIvTriangleRC;
        if (view8 != null) {
            view8.setVisibility(8);
        }
    }

    public void showEnterAnim() {
        int i = this.f9847r;
        if (i <= 0) {
            return;
        }
        if (!this.f9836g) {
            startAnimation(AnimationUtils.loadAnimation(this.f9837h, i));
        } else if (i == R.anim.tips_anima_top_align_left_in) {
            m8562b();
        } else if (i == R.anim.tips_anima_top_align_right_in) {
            m8566c();
        } else if (i == R.anim.tips_anima_top_center_in) {
            m8556a();
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.f9837h, i));
        }
    }

    public void setLines(int i) {
        this.f9833d.setLines(i);
    }

    /* renamed from: a */
    private void m8556a() {
        float f = this.f9837h.getResources().getDisplayMetrics().density;
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.02f, 0.0f, 1.02f, 1, 0.5f, 1, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setDuration(200);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.02f, 1.0f, 1.02f, 1.0f, 1, 0.5f, 1, 1.0f);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation2.setInterpolator(new LinearInterpolator());
        scaleAnimation2.setDuration(200);
        scaleAnimation2.setStartOffset(100);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);
        startAnimation(animationSet);
    }

    /* renamed from: b */
    private void m8562b() {
        float f = this.f9837h.getResources().getDisplayMetrics().density;
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.02f, 0.0f, 1.02f, 1, 0.05f, 1, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setDuration(200);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.02f, 1.0f, 1.02f, 1.0f, 1, 0.05f, 1, 1.0f);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation2.setInterpolator(new LinearInterpolator());
        scaleAnimation2.setDuration(200);
        scaleAnimation2.setStartOffset(100);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);
        startAnimation(animationSet);
    }

    /* renamed from: c */
    private void m8566c() {
        float f = this.f9837h.getResources().getDisplayMetrics().density;
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.02f, 0.0f, 1.02f, 1, 0.95f, 1, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setDuration(250);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.02f, 1.0f, 1.02f, 1.0f, 1, 0.95f, 1, 1.0f);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation2.setInterpolator(new LinearInterpolator());
        scaleAnimation2.setDuration(250);
        scaleAnimation2.setStartOffset(100);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);
        startAnimation(animationSet);
    }

    public void detachFromContainer() {
        int i = this.f9848s;
        if (i > 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f9837h, i);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    TipsView.this.m8569d();
                }
            });
            startAnimation(loadAnimation);
            return;
        }
        m8569d();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8569d() {
        post(new Runnable() {
            public void run() {
                if (TipsView.this.f9849t != null) {
                    TipsView.this.f9849t.removeView(TipsView.this);
                } else {
                    ViewParent parent = TipsView.this.getParent();
                    if (parent != null && (parent instanceof ViewGroup)) {
                        ((ViewGroup) parent).removeView(TipsView.this);
                    }
                }
                if (TipsView.this.f9851v != null) {
                    TipsView.this.f9851v.onClick((View) null);
                }
                TipsContainer.subtractShowTime();
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44804a(int i, int i2) {
        if (i == 0) {
            m8557a(i2);
        } else if (i == 1) {
            m8563b(i2);
        } else if (i == 2) {
            m8567c(i2);
        } else if (i == 3) {
            m8557a(i2);
        } else if (i == 4) {
            m8557a(i2);
        }
    }

    private void setContainerHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.mLineContainer.getLayoutParams();
        layoutParams.height = -2;
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    public void setContainerMargin(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLineContainer.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    public void setContainerMarginLeft(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLineContainer.getLayoutParams();
        layoutParams.leftMargin = i;
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    public void setContainerMarginTop(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLineContainer.getLayoutParams();
        layoutParams.topMargin = i;
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    public void setContainerMarginRight(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLineContainer.getLayoutParams();
        layoutParams.rightMargin = i;
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    public void setContainerMarginBottom(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLineContainer.getLayoutParams();
        layoutParams.bottomMargin = i;
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private void m8559a(View view) {
        this.mLineContainer = (FrameLayout) view.findViewById(R.id.tv_tips_content_container);
        this.f9831b = (TextView) view.findViewById(R.id.tv_tips_content_1_line);
        this.f9832c = (TextView) view.findViewById(R.id.tv_tips_content_2_line);
        this.f9833d = (TextView) view.findViewById(R.id.tv_tips_content_more_line);
        this.mIvGuide = (ImageView) view.findViewById(R.id.iv_guide);
        this.mIvTriangleTC = view.findViewById(R.id.iv_tc);
        this.mIvTriangleTR = view.findViewById(R.id.iv_tr);
        this.mIvTriangleTL = view.findViewById(R.id.iv_tl);
        this.mIvTriangleBC = view.findViewById(R.id.iv_bc);
        this.mIvTriangleBR = view.findViewById(R.id.iv_br);
        this.mIvTriangleBL = view.findViewById(R.id.iv_bl);
        this.mIvTriangleLC = view.findViewById(R.id.iv_lc);
        this.mIvTriangleRC = view.findViewById(R.id.iv_rc);
        View findViewById = view.findViewById(R.id.iv_close);
        this.f9843n = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TipsView.this.f9850u != null) {
                    TipsView.this.f9850u.onClick(view);
                }
                TipsView.this.detachFromContainer();
            }
        });
        this.f9844o = view.findViewById(R.id.iv_guide_close);
        findViewById(R.id.iv_guide_frame_close).setVisibility(8);
        findViewById(R.id.iv_guide_frame_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TipsView.this.f9850u != null) {
                    TipsView.this.f9850u.onClick(view);
                }
                TipsView.this.detachFromContainer();
            }
        });
        setOnClickListener((View.OnClickListener) null);
        if (getTag() == null) {
            setTag(Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* renamed from: a */
    private void m8557a(int i) {
        if (i == 0) {
            this.mIvTriangleBC.setVisibility(0);
        } else if (i == 1) {
            this.mIvTriangleRC.setVisibility(0);
        } else if (i == 2) {
            this.mIvTriangleLC.setVisibility(0);
        } else if (i == 3) {
            this.mIvTriangleLC.setVisibility(0);
        } else if (i == 4) {
            this.mIvTriangleRC.setVisibility(0);
        }
    }

    /* renamed from: b */
    private void m8563b(int i) {
        if (i == 0) {
            this.mIvTriangleBC.setVisibility(0);
        } else if (i == 1) {
            this.mIvTriangleBR.setVisibility(0);
        } else if (i == 2) {
            this.mIvTriangleBL.setVisibility(0);
        } else if (i == 3) {
            this.mIvTriangleBL.setVisibility(0);
        } else if (i == 4) {
            this.mIvTriangleBR.setVisibility(0);
        }
    }

    /* renamed from: c */
    private void m8567c(int i) {
        if (i == 0) {
            this.mIvTriangleTC.setVisibility(0);
        } else if (i == 1) {
            this.mIvTriangleTR.setVisibility(0);
        } else if (i == 2) {
            this.mIvTriangleTL.setVisibility(0);
        } else if (i == 3) {
            this.mIvTriangleTL.setVisibility(0);
        } else if (i == 4) {
            this.mIvTriangleTR.setVisibility(0);
        }
    }

    /* renamed from: b */
    private void m8564b(int i, int i2) {
        if (i == 1 && i2 == 0) {
            this.f9847r = R.anim.tips_anima_top_center_in;
            this.f9848s = R.anim.tips_anima_top_center_out;
        } else if (i == 2 && i2 == 0) {
            this.f9847r = R.anim.tips_anima_bottom_center_in;
            this.f9848s = R.anim.tips_anima_bottom_center_out;
        } else if (i == 0 && i2 == 1) {
            this.f9847r = R.anim.tips_anima_center_left_in;
            this.f9848s = R.anim.tips_anima_center_left_out;
        } else if (i == 0 && i2 == 2) {
            this.f9847r = R.anim.tips_anima_center_right_in;
            this.f9848s = R.anim.tips_anima_center_right_out;
        } else if ((i == 1 && i2 == 3) || (i == 1 && i2 == 2)) {
            this.f9847r = R.anim.tips_anima_top_align_left_in;
            this.f9848s = R.anim.tips_anima_top_align_left_out;
        } else if ((i == 1 && i2 == 4) || (i == 1 && i2 == 1)) {
            this.f9847r = R.anim.tips_anima_top_align_right_in;
            this.f9848s = R.anim.tips_anima_top_align_right_out;
        } else if ((i == 2 && i2 == 3) || (i == 2 && i2 == 2)) {
            this.f9847r = R.anim.tips_anima_bottom_align_left_in;
            this.f9848s = R.anim.tips_anima_bottom_align_left_out;
        } else if ((i == 2 && i2 == 4) || (i == 2 && i2 == 1)) {
            this.f9847r = R.anim.tips_anima_bottom_align_right_in;
            this.f9848s = R.anim.tips_anima_bottom_align_right_out;
        } else if (i2 == 1 && (i == 3 || i == 4)) {
            this.f9847r = R.anim.tips_anima_center_left_in;
            this.f9848s = R.anim.tips_anima_center_left_out;
        } else if (i2 != 2) {
        } else {
            if (i == 3 || i == 4) {
                this.f9847r = R.anim.tips_anima_center_right_in;
                this.f9848s = R.anim.tips_anima_center_right_out;
            }
        }
    }
}
