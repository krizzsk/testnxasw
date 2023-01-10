package com.didi.safetoolkit.business.emergency.widget;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.safetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;

public class SfEmergencyInfoCardView extends FrameLayout {

    /* renamed from: a */
    static int f37107a = 300;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f37108b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f37109c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f37110d;

    /* renamed from: e */
    private TextView f37111e;

    /* renamed from: f */
    private TextView f37112f;

    /* renamed from: g */
    private TextView f37113g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f37114h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f37115i;

    public SfEmergencyInfoCardView(Context context) {
        super(context);
        m28031a(context);
    }

    public SfEmergencyInfoCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28031a(context);
    }

    /* renamed from: a */
    private void m28031a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.sf_emergency_info_view, this);
        TextView textView = (TextView) findViewById(R.id.sf_location_tv);
        this.f37108b = textView;
        textView.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_updating_location));
        this.f37109c = (ImageView) findViewById(R.id.sf_address_status_icon);
        TextView textView2 = (TextView) findViewById(R.id.sf_address_tv);
        this.f37110d = textView2;
        textView2.setBackground(getResources().getDrawable(R.drawable.sf_emergency_location_info_bg));
        this.f37111e = (TextView) findViewById(R.id.vehicle_info);
        this.f37112f = (TextView) findViewById(R.id.vehicle_id_number);
        this.f37113g = (TextView) findViewById(R.id.vehicle_model);
    }

    public void setVehicleInfoVisible(boolean z) {
        if (!z) {
            this.f37111e.setVisibility(8);
            this.f37112f.setVisibility(8);
            this.f37113g.setVisibility(8);
            return;
        }
        this.f37111e.setVisibility(0);
        this.f37112f.setVisibility(0);
        this.f37113g.setVisibility(0);
    }

    public void setEmgInfo(SfEmgInfo sfEmgInfo) {
        this.f37112f.setText(sfEmgInfo.data.carLicense);
        this.f37113g.setText(sfEmgInfo.data.carBrand);
    }

    public void updatingLocation() {
        this.f37108b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_updating_location));
        final Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), R.animator.jump_flip_anim);
        loadAnimator.setTarget(this.f37109c);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.2f);
        translateAnimation.setDuration((long) f37107a);
        translateAnimation.setStartOffset(0);
        translateAnimation.setInterpolator(new JumpInterpolator(0.5f));
        translateAnimation.setAnimationListener(new SimpleAnimationListenerAdapter() {
            public void onAnimationStart(Animation animation) {
                loadAnimator.start();
            }

            public void onAnimationEnd(Animation animation) {
                animation.cancel();
                SfEmergencyInfoCardView.this.f37109c.clearAnimation();
                if (!TextUtils.isEmpty(SfEmergencyInfoCardView.this.f37115i)) {
                    SfEmergencyInfoCardView.this.f37108b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_current_location));
                    SfEmergencyInfoCardView.this.f37110d.setText(SfEmergencyInfoCardView.this.f37115i);
                    SfEmergencyInfoCardView.this.f37110d.setBackground((Drawable) null);
                    SfEmergencyInfoCardView.this.f37110d.setTextColor(SfEmergencyInfoCardView.this.getResources().getColor(R.color.sf_color_333333));
                    long unused = SfEmergencyInfoCardView.this.f37114h = System.currentTimeMillis();
                    String unused2 = SfEmergencyInfoCardView.this.f37115i = "";
                }
            }
        });
        this.f37109c.startAnimation(translateAnimation);
        this.f37110d.setTextColor(getResources().getColor(R.color.sf_color_CCCCCC));
    }

    public void updateCurrentLocation(String str) {
        this.f37115i = str;
    }

    public void showLastKnowLocation() {
        if (!TextUtils.isEmpty(this.f37110d.getText())) {
            this.f37108b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_last_know_location, Integer.valueOf((int) Math.ceil((double) (((float) ((System.currentTimeMillis() - this.f37114h) / 1000)) / 60.0f)))));
            this.f37110d.setBackground((Drawable) null);
            this.f37110d.setTextColor(getResources().getColor(R.color.sf_color_333333));
        }
    }

    public void onPause() {
        Animation animation = this.f37109c.getAnimation();
        if (animation != null) {
            animation.cancel();
            this.f37109c.clearAnimation();
        }
    }
}
