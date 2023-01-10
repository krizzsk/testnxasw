package com.didi.safetoolkit.business.emergency;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.android.didi.safetoolkit.activity.BaseActivityWithUIStuff;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.safetoolkit.apollo.SfApolloUtil;
import com.didi.safetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.safetoolkit.business.emergency.widget.SfEmergencyInfoCardView;
import com.didi.safetoolkit.business.emergency.widget.SfRippleAnimationLayout;
import com.didi.safetoolkit.business.emergency.widget.SliderMoveView;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.model.SfLocation;
import com.didi.safetoolkit.net.SfResponseListener;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didi.safetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.safetoolkit.widget.SfBaseDialog;
import com.didi.safetoolkit.widget.SfCommonTitleBar;
import com.didi.sdk.app.tap.BusinessConstants;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.taxis99.R;

public class SfEmergencyAssistanceActivity extends BaseActivityWithUIStuff implements ISfEmergencyAssistanceView {

    /* renamed from: a */
    private SfCommonTitleBar f37081a;

    /* renamed from: b */
    private TextView f37082b;

    /* renamed from: c */
    private TextView f37083c;

    /* renamed from: d */
    private TextView f37084d;

    /* renamed from: e */
    private TextView f37085e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SfEmergencyInfoCardView f37086f;

    /* renamed from: g */
    private SfRippleAnimationLayout f37087g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SfCommonTitleBar f37088h;

    /* renamed from: i */
    private CardView f37089i;

    /* renamed from: j */
    private ImageView f37090j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f37091k;

    /* renamed from: l */
    private ImageView f37092l;

    /* renamed from: m */
    private TextView f37093m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public TextView f37094n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public TextView f37095o;

    /* renamed from: p */
    private ImageView f37096p;

    /* renamed from: q */
    private TextView f37097q;

    /* renamed from: r */
    private TextView f37098r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public SliderMoveView f37099s;

    /* renamed from: t */
    private long f37100t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public SfEmergencyAssistancePresenter f37101u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f37102v = true;

    /* renamed from: w */
    private boolean f37103w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f37104x;

    /* access modifiers changed from: protected */
    public void beforeContentViewLoaded() {
        super.beforeContentViewLoaded();
        if (BusinessConstants.TYPE_VAMOS.equals(SafeToolKit.getIns().getBusinessType())) {
            this.f37102v = false;
        } else {
            this.f37102v = SfApolloUtil.isNewCallPoliceUI();
        }
        this.f37103w = DRtlToolkit.rtl();
    }

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return this.f37102v ? R.layout.sf_layout_act_emergency_assistance_new : R.layout.sf_layout_act_emergency_assistance;
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        if (this.f37102v) {
            this.f37088h = (SfCommonTitleBar) findViewById(R.id.sf_title_bar);
            this.f37089i = (CardView) findViewById(R.id.layout_card);
            this.f37090j = (ImageView) findViewById(R.id.iv_shield);
            this.f37091k = findViewById(R.id.layout_car_info);
            this.f37092l = (ImageView) findViewById(R.id.iv_car_icon);
            this.f37093m = (TextView) findViewById(R.id.tv_car_tag);
            this.f37094n = (TextView) findViewById(R.id.tv_car_number);
            this.f37095o = (TextView) findViewById(R.id.tv_car_brand);
            this.f37096p = (ImageView) findViewById(R.id.iv_location_icon);
            this.f37097q = (TextView) findViewById(R.id.tv_location_tag);
            this.f37098r = (TextView) findViewById(R.id.tv_location_info);
            SliderMoveView sliderMoveView = (SliderMoveView) findViewById(R.id.v_call_police);
            this.f37099s = sliderMoveView;
            sliderMoveView.setListener(new SliderMoveView.SlideButtonViewListener() {
                public void onSliderMove(float f, float f2) {
                }

                public boolean onSliderStateChange(int i) {
                    if (i != 3 || SfEmergencyAssistanceActivity.this.f37099s.getCurrentPercent() <= 0.95f) {
                        return false;
                    }
                    SfEmergencyAssistanceActivity.this.f37101u.handleEmergencyCallClickedNew();
                    return true;
                }
            });
            return;
        }
        this.f37081a = (SfCommonTitleBar) findViewById(R.id.sf_title_bar);
        this.f37082b = (TextView) findViewById(R.id.sf_call_btn);
        this.f37083c = (TextView) findViewById(R.id.sf_sub_title);
        this.f37084d = (TextView) findViewById(R.id.sf_status_tv);
        this.f37085e = (TextView) findViewById(R.id.sf_call_msg);
        this.f37086f = (SfEmergencyInfoCardView) findViewById(R.id.sf_info_card);
        this.f37087g = (SfRippleAnimationLayout) findViewById(R.id.sf_ripple_container);
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        if (bundle != null) {
            this.f37104x = bundle.getBoolean("isNotAccepted");
        }
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        this.f37101u = new SfEmergencyAssistancePresenter(this);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        if (this.f37102v) {
            this.f37088h.setTitleText(SfStringGetter.getString(R.string.sf_emergency_assistance_main_title));
            this.f37091k.setVisibility(this.f37104x ? 8 : 0);
            int i = 5;
            this.f37094n.setGravity(this.f37103w ? 5 : 3);
            this.f37095o.setGravity(this.f37103w ? 5 : 3);
            TextView textView = this.f37098r;
            if (!this.f37103w) {
                i = 3;
            }
            textView.setGravity(i);
            updateUIByCallPoliceState(false);
        } else {
            this.f37081a.setTitleText(SfStringGetter.getString(R.string.sf_emergency_assistance_main_title));
            if (this.f37104x) {
                this.f37083c.setText(SfStringGetter.getString(R.string.GRider_Global_Under_the_hmOG));
            } else {
                this.f37083c.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_latest_trip_info, SfEmergencyNumHelper.getEmergencyCallNum()));
            }
            this.f37082b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_call, SfEmergencyNumHelper.getEmergencyCallNum()));
            this.f37085e.getPaint().setUnderlineText(true);
            this.f37085e.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_call_again_tips, SfEmergencyNumHelper.getEmergencyCallNum()));
            this.f37086f.setVehicleInfoVisible(true ^ this.f37104x);
        }
        this.f37101u.requestEmergencyInfo(new SfResponseListener<SfEmgInfo>() {
            public void onSuccess(final SfEmgInfo sfEmgInfo) {
                if (SfEmergencyAssistanceActivity.this.f37102v) {
                    if (sfEmgInfo == null || sfEmgInfo.data == null || (TextUtils.isEmpty(sfEmgInfo.data.carLicense) && TextUtils.isEmpty(sfEmgInfo.data.carBrand))) {
                        SfEmergencyAssistanceActivity.this.f37091k.setVisibility(8);
                    } else {
                        SfEmergencyAssistanceActivity.this.f37091k.setVisibility(0);
                        SfEmergencyAssistanceActivity.this.f37094n.setText(sfEmgInfo.data.carLicense);
                        SfEmergencyAssistanceActivity.this.f37095o.setText(sfEmgInfo.data.carBrand);
                    }
                    if (sfEmgInfo == null || sfEmgInfo.data == null || TextUtils.isEmpty(sfEmgInfo.data.moreUrl)) {
                        SfEmergencyAssistanceActivity.this.f37088h.setRightTextView("", (View.OnClickListener) null);
                    } else {
                        SfEmergencyAssistanceActivity.this.f37088h.setRightTextView(SfStringGetter.getString(R.string.GRider_improvement_Learn_more_HvDY), new View.OnClickListener() {
                            public void onClick(View view) {
                                AutoTrackHelper.trackViewOnClick(view);
                                DRouter.build(sfEmgInfo.data.moreUrl).start(SfEmergencyAssistanceActivity.this);
                            }
                        });
                    }
                } else if (!SfEmergencyAssistanceActivity.this.f37104x) {
                    SfEmergencyAssistanceActivity.this.f37086f.setEmgInfo(sfEmgInfo);
                }
            }
        });
        if (!SafeToolKit.getIns().isVamosDriver()) {
            this.f37101u.requestEmergencyStatus();
        }
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        if (this.f37102v) {
            this.f37088h.setLeftBtnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SfEmergencyAssistanceActivity.this.onBackPressed();
                }
            });
            return;
        }
        this.f37081a.setLeftBtnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfEmergencyAssistanceActivity.this.onBackPressed();
            }
        });
        this.f37085e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfEmergencyAssistanceActivity.this.f37101u.makeEmergencyCall();
            }
        });
        this.f37082b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfEmergencyAssistanceActivity.this.f37101u.handleEmergencyCallClicked();
            }
        });
    }

    public void showLocationLoadingStatus() {
        if (!this.f37102v) {
            this.f37086f.updatingLocation();
        }
    }

    public void showLocationLoadedSucceedStatus(SfLocation sfLocation) {
        if (this.f37102v) {
            this.f37100t = System.currentTimeMillis();
            this.f37097q.setText(SfStringGetter.getString(R.string.GRider_improvement_Estimated_current_OHzq));
            this.f37098r.setText(sfLocation.address);
            return;
        }
        this.f37086f.updateCurrentLocation(sfLocation.address);
    }

    public void showLocationLoadedFailStatus() {
        if (!this.f37102v) {
            this.f37086f.showLastKnowLocation();
        } else if (!TextUtils.isEmpty(this.f37098r.getText())) {
            this.f37097q.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_last_know_location, Integer.valueOf((int) Math.ceil((double) (((float) ((System.currentTimeMillis() - this.f37100t) / 1000)) / 60.0f)))));
        }
    }

    public void startCallButtonAnimation() {
        if (!SafeToolKit.getIns().isVamosDriver() && !this.f37102v) {
            this.f37087g.startRippleAnimation();
            this.f37082b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_stop_uploading_location));
            this.f37082b.setTextColor(getResources().getColor(R.color.sf_color_ff525d));
            this.f37082b.setBackground(getResources().getDrawable(R.drawable.sf_emergency_call_stop_btn_selector));
            this.f37084d.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_uploading_location));
            this.f37084d.setVisibility(0);
            this.f37085e.setVisibility(0);
        }
    }

    public void stopCallButtonAnimation() {
        if (!this.f37102v) {
            this.f37087g.stopRippleAnimation();
            this.f37082b.setText(SfStringGetter.getString(R.string.sf_emergency_assistance_call, SfEmergencyNumHelper.getEmergencyCallNum()));
            this.f37082b.setTextColor(getResources().getColor(R.color.sf_white));
            this.f37082b.setBackground(getResources().getDrawable(R.drawable.sf_emergency_call_start_btn_selector));
            this.f37084d.setVisibility(4);
            this.f37085e.setVisibility(4);
        }
    }

    public void showStopEmerAssistConfirmDialog(View.OnClickListener onClickListener) {
        if (!isFinishing() && !isDestroyed()) {
            new SfBaseDialog.DialogBuilder(getContext()).setTitle(SfStringGetter.getString(R.string.sf_emergency_assistance_stop_title)).setTitleTypeface(1).setContent(SfStringGetter.getString(R.string.sf_emergency_assistance_stop_message)).setLeftBtn(SfStringGetter.getString(R.string.sf_emergency_assistance_confirm_stop_btn), onClickListener).setLeftBtnTextColorRes(R.color.sf_color_999999).setRightBtn(SfStringGetter.getString(R.string.sf_emergency_assistance_no_stop_btn)).setRightBtnTypeface(1).setRightBtnTextColorRes(R.color.sf_color_FC9153).setCancelableWhenTouchOutside(false).build().show(getSupportFragmentManager(), "StopEmerAssistConfirmDialog");
        }
    }

    public void updateUIByCallPoliceState(boolean z) {
        String str;
        String str2;
        if (this.f37102v) {
            String str3 = "#FFFFFF";
            this.f37089i.setCardBackgroundColor(Color.parseColor(z ? "#FF4050" : str3));
            this.f37090j.setImageResource(z ? R.drawable.sf_ic_call_police_shield_special : R.drawable.sf_ic_call_police_shield_normal);
            this.f37092l.setImageResource(z ? R.drawable.sf_ic_call_police_car_special : R.drawable.sf_ic_call_police_car_normal);
            String str4 = "#CDFFFFFF";
            this.f37093m.setTextColor(Color.parseColor(z ? str4 : "#919599"));
            this.f37094n.setTextColor(Color.parseColor(z ? str3 : "#000000"));
            TextView textView = this.f37095o;
            if (z) {
                str = str3;
            } else {
                str = "#000000";
            }
            textView.setTextColor(Color.parseColor(str));
            this.f37096p.setImageResource(z ? R.drawable.sf_ic_call_police_location_special : R.drawable.sf_ic_call_police_location_normal);
            TextView textView2 = this.f37097q;
            if (!z) {
                str4 = "#919599";
            }
            textView2.setTextColor(Color.parseColor(str4));
            TextView textView3 = this.f37098r;
            if (!z) {
                str3 = "#000000";
            }
            textView3.setTextColor(Color.parseColor(str3));
            if (z) {
                str2 = SfStringGetter.getString(R.string.GRider_improvement_Sliding_again_EZlR);
            } else {
                str2 = SfStringGetter.getString(R.string.GRider_improvement_Swipe_alarm_sPBI, SfEmergencyNumHelper.getEmergencyCallNum());
            }
            this.f37099s.setForegroundText(str2);
            this.f37099s.setBackgroundText(str2);
        }
    }

    public View getFallbackView() {
        if (this.f37102v) {
            return this.f37088h.getLoadingFallback();
        }
        return this.f37081a.getLoadingFallback();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        SfEmergencyInfoCardView sfEmergencyInfoCardView;
        if (!this.f37102v && (sfEmergencyInfoCardView = this.f37086f) != null) {
            sfEmergencyInfoCardView.onPause();
        }
        super.onPause();
    }
}
