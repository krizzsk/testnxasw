package com.didi.component.evaluate.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.ImageUtils;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.taxis99.R;

public class EvaluateTagImageLayout extends AbsBaseTagLayout {

    /* renamed from: a */
    private ViewGroup f15249a;

    /* renamed from: b */
    private TextView f15250b;

    /* renamed from: c */
    private ImageView f15251c;

    /* renamed from: d */
    private View f15252d;

    /* renamed from: e */
    private FrameLayout f15253e;

    /* renamed from: f */
    private LinearLayout f15254f;

    /* renamed from: g */
    private View f15255g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LottieAnimationView f15256h;

    public EvaluateTagImageLayout(Context context) {
        super(context);
        m12581a();
    }

    public EvaluateTagImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12581a();
    }

    public EvaluateTagImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12581a();
    }

    /* renamed from: a */
    private void m12581a() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.global_new_evaluate_tag_image_layout, this, true);
        this.f15249a = viewGroup;
        this.f15250b = (TextView) viewGroup.findViewById(R.id.tag_text_view);
        this.f15251c = (ImageView) this.f15249a.findViewById(R.id.tag_image_view);
        this.f15252d = this.f15249a.findViewById(R.id.mask_view);
        this.f15253e = (FrameLayout) this.f15249a.findViewById(R.id.tag_image_layout);
        this.f15254f = (LinearLayout) this.f15249a.findViewById(R.id.new_evaluate_tag_image_layout);
        this.f15255g = this.f15249a.findViewById(R.id.tag_text_loading);
        this.f15256h = (LottieAnimationView) this.f15249a.findViewById(R.id.lottie_animation);
        this.f15253e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (EvaluateTagImageLayout.this.mEnable) {
                    EvaluateTagImageLayout evaluateTagImageLayout = EvaluateTagImageLayout.this;
                    evaluateTagImageLayout.mIsSelected = !evaluateTagImageLayout.mIsSelected;
                    EvaluateTagImageLayout evaluateTagImageLayout2 = EvaluateTagImageLayout.this;
                    evaluateTagImageLayout2.setSelected(evaluateTagImageLayout2.mIsSelected);
                }
            }
        });
    }

    private void setText(String str) {
        this.f15250b.setVisibility(0);
        this.f15250b.setText(str);
    }

    private void setImageUrl(String str) {
        ImageUtils.glideLoad(getContext(), str, this.f15251c);
    }

    public void setSelected(boolean z) {
        if (z) {
            m12582a(this.f15251c, this.f15252d);
        } else {
            this.f15252d.setVisibility(0);
        }
    }

    public View getView() {
        return this.f15249a;
    }

    public void setMarginRight(int i) {
        ((FrameLayout.LayoutParams) this.f15254f.getLayoutParams()).rightMargin = i;
    }

    public void setTagModel(CarNoEvaluateData.EvaluateTagImpl evaluateTagImpl) {
        super.setTagModel(evaluateTagImpl);
        if (evaluateTagImpl != null) {
            setText(evaluateTagImpl.getText());
            setImageUrl(evaluateTagImpl.getIcon());
        }
    }

    public void setTagModel(EvaluateTag evaluateTag) {
        super.setTagModel(evaluateTag);
        if (evaluateTag != null) {
            setText(evaluateTag.getText());
            setImageUrl(evaluateTag.getIcon());
        }
    }

    public void setLoading(boolean z) {
        super.setLoading(z);
        if (z) {
            this.f15255g.setVisibility(0);
            this.f15250b.setVisibility(8);
            this.f15252d.setVisibility(8);
            return;
        }
        this.f15255g.setVisibility(8);
        this.f15250b.setVisibility(0);
        this.f15252d.setVisibility(0);
    }

    /* renamed from: a */
    private void m12582a(final View view, final View view2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(100);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view2.setVisibility(8);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(200);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        EvaluateTagImageLayout.this.f15256h.setVisibility(8);
                        EvaluateTagImageLayout.this.f15256h.cancelAnimation();
                    }
                });
                view.startAnimation(scaleAnimation);
            }
        });
        view.startAnimation(scaleAnimation);
        this.f15256h.setVisibility(0);
        this.f15256h.playAnimation();
    }
}
