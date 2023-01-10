package com.didi.globalsafetoolkit.business.emergency.widget;

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
import com.didi.globalsafetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.globalsafetoolkit.util.SfStringGetter;
import com.taxis99.R;

public class SfEmergencyInfoCardView extends FrameLayout {

    /* renamed from: a */
    static int f25001a = 300;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f25002b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f25003c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f25004d;

    /* renamed from: e */
    private TextView f25005e;

    /* renamed from: f */
    private TextView f25006f;

    /* renamed from: g */
    private TextView f25007g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f25008h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f25009i;

    public SfEmergencyInfoCardView(Context context) {
        super(context);
        m20047a(context);
    }

    public SfEmergencyInfoCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20047a(context);
    }

    /* renamed from: a */
    private void m20047a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.sf_emergency_info_view, this);
        TextView textView = (TextView) findViewById(R.id.sf_location_tv);
        this.f25002b = textView;
        textView.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_updating_location));
        this.f25003c = (ImageView) findViewById(R.id.sf_address_status_icon);
        TextView textView2 = (TextView) findViewById(R.id.sf_address_tv);
        this.f25004d = textView2;
        textView2.setBackground(getResources().getDrawable(R.drawable.sf_emergency_location_info_bg));
        this.f25005e = (TextView) findViewById(R.id.vehicle_info);
        this.f25006f = (TextView) findViewById(R.id.vehicle_id_number);
        this.f25007g = (TextView) findViewById(R.id.vehicle_model);
    }

    public void setVehicleInfoVisible(boolean z) {
        if (!z) {
            this.f25005e.setVisibility(8);
            this.f25006f.setVisibility(8);
            this.f25007g.setVisibility(8);
            return;
        }
        this.f25005e.setVisibility(0);
        this.f25006f.setVisibility(0);
        this.f25007g.setVisibility(0);
    }

    public void setEmgInfo(SfEmgInfo sfEmgInfo) {
        this.f25006f.setText(sfEmgInfo.data.carLicense);
        this.f25007g.setText(sfEmgInfo.data.carBrand);
    }

    public void updatingLocation() {
        this.f25002b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_updating_location));
        final Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), R.animator.jump_flip_anim);
        loadAnimator.setTarget(this.f25003c);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.2f);
        translateAnimation.setDuration((long) f25001a);
        translateAnimation.setStartOffset(0);
        translateAnimation.setInterpolator(new JumpInterpolator(0.5f));
        translateAnimation.setAnimationListener(new SimpleAnimationListenerAdapter() {
            public void onAnimationStart(Animation animation) {
                loadAnimator.start();
            }

            public void onAnimationEnd(Animation animation) {
                animation.cancel();
                SfEmergencyInfoCardView.this.f25003c.clearAnimation();
                if (!TextUtils.isEmpty(SfEmergencyInfoCardView.this.f25009i)) {
                    SfEmergencyInfoCardView.this.f25002b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_current_location));
                    SfEmergencyInfoCardView.this.f25004d.setText(SfEmergencyInfoCardView.this.f25009i);
                    SfEmergencyInfoCardView.this.f25004d.setBackground((Drawable) null);
                    SfEmergencyInfoCardView.this.f25004d.setTextColor(SfEmergencyInfoCardView.this.getResources().getColor(R.color.sf_color_333333));
                    long unused = SfEmergencyInfoCardView.this.f25008h = System.currentTimeMillis();
                    String unused2 = SfEmergencyInfoCardView.this.f25009i = "";
                }
            }
        });
        this.f25003c.startAnimation(translateAnimation);
        this.f25004d.setTextColor(getResources().getColor(R.color.sf_color_CCCCCC));
    }

    public void updateCurrentLocation(String str) {
        this.f25009i = str;
    }

    public void showLastKnowLocation() {
        if (!TextUtils.isEmpty(this.f25004d.getText())) {
            this.f25002b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_last_know_location, Integer.valueOf((int) Math.ceil((double) (((float) ((System.currentTimeMillis() - this.f25008h) / 1000)) / 60.0f)))));
            this.f25004d.setBackground((Drawable) null);
            this.f25004d.setTextColor(getResources().getColor(R.color.sf_color_333333));
        }
    }

    public void onPause() {
        Animation animation = this.f25003c.getAnimation();
        if (animation != null) {
            animation.cancel();
            this.f25003c.clearAnimation();
        }
    }
}
