package com.didi.component.estimate.newui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.util.Utils;
import com.didi.component.common.util.ActivityUtil;
import com.didi.component.common.util.StringUtil;
import com.didi.component.estimate.newui.view.EstimateDetailShareCarView;
import com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarDetailModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstimateDetailPageView extends ConstraintLayout {

    /* renamed from: a */
    private static final float f14909a = 0.18f;

    /* renamed from: b */
    private static final float f14910b = 0.5f;

    /* renamed from: c */
    private static final int f14911c = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<CarDetailModel> f14912d = new ArrayList();

    /* renamed from: e */
    private Context f14913e;

    /* renamed from: f */
    private View f14914f;

    /* renamed from: g */
    private TextView f14915g;

    /* renamed from: h */
    private TextView f14916h;

    /* renamed from: i */
    private TextView f14917i;

    /* renamed from: j */
    private LinearLayout f14918j;

    /* renamed from: k */
    private View f14919k;

    /* renamed from: l */
    private TextView f14920l;

    /* renamed from: m */
    private ImageView f14921m;

    /* renamed from: n */
    private ImageView f14922n;

    /* renamed from: o */
    private CarDetailFeeListView f14923o;

    /* renamed from: p */
    private FrameLayout f14924p;

    /* renamed from: q */
    private FrameLayout f14925q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public EstimateItemModel f14926r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public AnyCarEstimateItemModel f14927s;

    public EstimateDetailPageView(Context context, List<CarDetailModel> list, EstimateItemModel estimateItemModel) {
        super(context);
        this.f14912d = list;
        this.f14913e = context;
        this.f14914f = LayoutInflater.from(context).inflate(R.layout.estimate_detail_item, this, true);
        this.f14926r = estimateItemModel;
        m12278a();
    }

    public EstimateDetailPageView(Context context, List<CarDetailModel> list, AnyCarEstimateItemModel anyCarEstimateItemModel) {
        super(context);
        this.f14912d = list;
        this.f14913e = context;
        this.f14914f = LayoutInflater.from(context).inflate(R.layout.estimate_detail_item, this, true);
        this.f14927s = anyCarEstimateItemModel;
        m12278a();
    }

    public EstimateDetailPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EstimateDetailPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m12278a() {
        this.f14915g = (TextView) this.f14914f.findViewById(R.id.car_detail_name);
        this.f14916h = (TextView) this.f14914f.findViewById(R.id.car_detail_desc);
        this.f14917i = (TextView) this.f14914f.findViewById(R.id.car_detail_eta);
        this.f14918j = (LinearLayout) this.f14914f.findViewById(R.id.car_detail_seat_ll);
        this.f14920l = (TextView) this.f14914f.findViewById(R.id.car_detail_seat_tv);
        this.f14921m = (ImageView) this.f14914f.findViewById(R.id.car_detail_seat_ic);
        this.f14922n = (ImageView) this.f14914f.findViewById(R.id.car_detail_icon);
        this.f14925q = (FrameLayout) this.f14914f.findViewById(R.id.car_detail_icon_ll);
        View findViewById = this.f14914f.findViewById(R.id.car_bottom_shadow_view);
        this.f14919k = findViewById;
        findViewById.setBackground(getResources().getDrawable(Utils.isBrazilPackage(this.f14913e) ? R.drawable.estimate_car_detail_popup_shadow_99 : R.drawable.estimate_car_detail_popup_shadow));
        this.f14923o = (CarDetailFeeListView) this.f14914f.findViewById(R.id.estimate_detail_fee_list);
        this.f14924p = (FrameLayout) this.f14914f.findViewById(R.id.estimate_detail_share_car_container);
        if (this.f14912d.size() > 1 && this.f14912d.get(0).carTwoPrice != null) {
            this.f14923o.setVisibility(8);
            this.f14924p.setVisibility(0);
            this.f14924p.addView(new EstimateDetailShareCarView(this.f14913e, this.f14912d, this.f14927s, new EstimateDetailShareCarView.ShareCarTabListener() {
                public void chooseTab(int i) {
                    EstimateDetailPageView estimateDetailPageView = EstimateDetailPageView.this;
                    estimateDetailPageView.m12283a((CarDetailModel) estimateDetailPageView.f14912d.get(i));
                    if (EstimateDetailPageView.this.f14927s != null) {
                        EstimateDetailPageView estimateDetailPageView2 = EstimateDetailPageView.this;
                        estimateDetailPageView2.m12282a(estimateDetailPageView2.f14927s, i);
                        return;
                    }
                    EstimateDetailPageView estimateDetailPageView3 = EstimateDetailPageView.this;
                    estimateDetailPageView3.m12284a(estimateDetailPageView3.f14926r, i);
                }
            }));
            m12283a(this.f14912d.get(0));
        } else if (this.f14912d.size() > 0) {
            CarDetailModel carDetailModel = this.f14912d.get(0);
            this.f14924p.removeAllViews();
            this.f14924p.setVisibility(8);
            this.f14923o.setVisibility(0);
            this.f14923o.setData(carDetailModel.carDetailFeeInfo);
            m12283a(carDetailModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12284a(EstimateItemModel estimateItemModel, int i) {
        HashMap hashMap = new HashMap();
        if (!(estimateItemModel == null || estimateItemModel.carConfig == null)) {
            hashMap.put("bubble_id", estimateItemModel.carConfig.estimateId);
            hashMap.put("product_id", Integer.valueOf(estimateItemModel.carConfig.carProductId));
            hashMap.put("combo_type", Integer.valueOf(estimateItemModel.carConfig.carComboType));
            hashMap.put("cartype", Integer.valueOf(estimateItemModel.carConfig.carLevel));
            hashMap.put("action_type", Integer.valueOf(i));
            if (estimateItemModel.carConfig.extraData != null) {
                estimateItemModel.carConfig.extraData.putAllExtraLog(hashMap);
            }
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_orderconfirm_cartypedetail_notmatch_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12282a(AnyCarEstimateItemModel anyCarEstimateItemModel, int i) {
        HashMap hashMap = new HashMap();
        if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null)) {
            AnyCarConfigModel anyCarConfigModel = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig;
            hashMap.put("bubble_id", anyCarConfigModel.estimateId);
            hashMap.put("product_id", Integer.valueOf(anyCarConfigModel.carProductId));
            hashMap.put("combo_type", Integer.valueOf(anyCarConfigModel.carComboType));
            hashMap.put("cartype", Integer.valueOf(anyCarConfigModel.carLevel));
            hashMap.put("action_type", Integer.valueOf(i));
            if (anyCarConfigModel.extraData != null) {
                anyCarConfigModel.extraData.putAllExtraLog(hashMap);
            }
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_orderconfirm_cartypedetail_notmatch_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12283a(CarDetailModel carDetailModel) {
        if (!StringUtil.isNullOrEmpty(carDetailModel.carName)) {
            this.f14915g.setText(carDetailModel.carName);
        }
        if (!StringUtil.isNullOrEmpty(carDetailModel.carIcon)) {
            this.f14922n.setVisibility(0);
            Glide.with(this.f14913e.getApplicationContext()).load(carDetailModel.carIcon).into(this.f14922n);
        } else {
            this.f14922n.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(carDetailModel.carDesc)) {
            this.f14916h.setVisibility(0);
            this.f14916h.setText(carDetailModel.carDesc);
        } else {
            this.f14916h.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(carDetailModel.carEta)) {
            this.f14917i.setVisibility(0);
            this.f14917i.setText(carDetailModel.carEta);
        } else {
            this.f14917i.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(carDetailModel.carSeatNum)) {
            this.f14918j.setVisibility(0);
            this.f14920l.setText(carDetailModel.carSeatNum);
            if (!ActivityUtil.isActivityDestroyed(this.f14913e)) {
                ((RequestBuilder) Glide.with(this.f14913e).load(carDetailModel.carSeatIcon).placeholder((int) R.drawable.estimate_seat_people)).into(this.f14921m);
                return;
            }
            return;
        }
        this.f14918j.setVisibility(8);
    }

    public void startAnimOfPositive(float f) {
        float f2 = f > 0.5f ? 0.0f : (0.5f - f) * 2.0f;
        float screenWidth = (float) ((int) (((float) UiUtils.getScreenWidth(this.f14913e)) * f));
        this.f14915g.setAlpha(f2);
        this.f14916h.setAlpha(f2);
        this.f14917i.setAlpha(f2);
        this.f14918j.setAlpha(f2);
        this.f14923o.setAlpha(f2);
        this.f14924p.setAlpha(f2);
        this.f14922n.setTranslationX(screenWidth);
        if (!Utils.isBrazilPackage(this.f14913e)) {
            this.f14922n.setTranslationY(-(screenWidth * f14909a));
        }
    }

    public void resetAnim() {
        this.f14915g.setAlpha(1.0f);
        this.f14916h.setAlpha(1.0f);
        this.f14917i.setAlpha(1.0f);
        this.f14918j.setAlpha(1.0f);
        this.f14923o.setAlpha(1.0f);
        this.f14924p.setAlpha(1.0f);
        this.f14922n.setTranslationX(0.0f);
        if (!Utils.isBrazilPackage(this.f14913e)) {
            this.f14922n.setTranslationY(0.0f);
        }
    }

    public void startAnimOfMinus(float f) {
        float f2 = 0.0f;
        float f3 = 1.0f;
        int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
        if (!(i == 0 || f == 0.0f)) {
            f3 = 1.0f - (2.0f * f);
        }
        if (!(i == 0 || f == 0.0f)) {
            f2 = (float) ((int) (((float) UiUtils.getScreenWidth(this.f14913e)) * f));
        }
        this.f14915g.setAlpha(f3);
        this.f14916h.setAlpha(f3);
        this.f14917i.setAlpha(f3);
        this.f14918j.setAlpha(f3);
        this.f14923o.setAlpha(f3);
        this.f14924p.setAlpha(f3);
        this.f14922n.setTranslationX(-f2);
        if (!Utils.isBrazilPackage(this.f14913e)) {
            this.f14922n.setTranslationY(f2 * f14909a);
        }
    }
}
