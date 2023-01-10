package com.didi.component.realtimeprice.impl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.PriceUtils;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.widget.CouponView;
import com.didi.component.common.widget.TripCouponView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.realtimeprice.AbsRealTimePricePresenter;
import com.didi.component.realtimeprice.IRealTimePriceView;
import com.didi.component.realtimeprice.model.PayInfo;
import com.didi.component.realtimeprice.model.RealTimePrice;
import com.didi.component.realtimeprice.model.SelectPaywayItem;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.model.OrderStatus;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class RealTimePriceViewV2 implements View.OnClickListener, IRealTimePriceView {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public ImageView f17117A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public ImageView f17118B;

    /* renamed from: C */
    private Map<String, Object> f17119C = new HashMap();

    /* renamed from: D */
    private boolean f17120D = false;

    /* renamed from: E */
    private boolean f17121E = false;

    /* renamed from: F */
    private boolean f17122F = false;

    /* renamed from: G */
    private int f17123G = 0;

    /* renamed from: H */
    private CouponView f17124H;

    /* renamed from: I */
    private View f17125I;

    /* renamed from: J */
    private View f17126J;

    /* renamed from: K */
    private TripCouponView f17127K;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AbsRealTimePricePresenter f17128a;

    /* renamed from: b */
    private View f17129b;

    /* renamed from: c */
    private TextView f17130c;

    /* renamed from: d */
    private TextView f17131d;

    /* renamed from: e */
    private TextView f17132e;

    /* renamed from: f */
    private TextView f17133f;

    /* renamed from: g */
    private IRealTimePriceView.OnActionListener f17134g;

    /* renamed from: h */
    private boolean f17135h = false;

    /* renamed from: i */
    private Context f17136i;

    /* renamed from: j */
    private TextView f17137j;

    /* renamed from: k */
    private boolean f17138k;

    /* renamed from: l */
    private TextView f17139l;

    /* renamed from: m */
    private TextView f17140m;

    /* renamed from: n */
    private ImageView f17141n;

    /* renamed from: o */
    private ImageView f17142o;

    /* renamed from: p */
    private TextView f17143p;

    /* renamed from: q */
    private TextView f17144q;

    /* renamed from: r */
    private View f17145r;

    /* renamed from: s */
    private View f17146s;

    /* renamed from: t */
    private ImageView f17147t;

    /* renamed from: u */
    private ImageView f17148u;

    /* renamed from: v */
    private ImageView f17149v;

    /* renamed from: w */
    private ImageView f17150w;

    /* renamed from: x */
    private ConstraintLayout f17151x;

    /* renamed from: y */
    private ConstraintLayout f17152y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public PayInfo f17153z;

    public void hideNewbieGuide() {
    }

    public void hideOnTripCoupon() {
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    public void setClickable(boolean z) {
    }

    public void showFixedPriceGuidePopup(String str) {
    }

    public void showNewbieGuide(String str) {
    }

    public RealTimePriceViewV2(Context context, ViewGroup viewGroup) {
        this.f17136i = context;
        this.f17129b = LayoutInflater.from(context).inflate(R.layout.global_real_time_price_view_v2, viewGroup, false);
        this.f17130c = (TextView) m14372a((int) R.id.real_time_pay_way);
        this.f17132e = (TextView) m14372a((int) R.id.real_time_price_text);
        this.f17141n = (ImageView) m14372a((int) R.id.real_time_pay_way_ic);
        this.f17137j = (TextView) m14372a((int) R.id.real_time_coupon_tv);
        this.f17139l = (TextView) m14372a((int) R.id.real_time_pay_way_99);
        this.f17143p = (TextView) m14372a((int) R.id.real_time_price_text_origin);
        this.f17145r = m14372a((int) R.id.combine_payway);
        this.f17147t = (ImageView) m14372a((int) R.id.pay_way_balance_icon);
        this.f17149v = (ImageView) m14372a((int) R.id.pay_way_card_icon);
        this.f17151x = (ConstraintLayout) m14372a((int) R.id.payway_container);
        this.f17117A = (ImageView) m14372a((int) R.id.iv_img_arrow);
        this.f17124H = (CouponView) m14372a((int) R.id.real_time_coupon_v);
        this.f17131d = (TextView) m14372a((int) R.id.new_real_time_pay_way);
        this.f17133f = (TextView) m14372a((int) R.id.new_real_time_price_text);
        this.f17142o = (ImageView) m14372a((int) R.id.new_real_time_pay_way_ic);
        this.f17140m = (TextView) m14372a((int) R.id.new_real_time_pay_way_99);
        this.f17144q = (TextView) m14372a((int) R.id.new_real_time_price_text_origin);
        this.f17146s = m14372a((int) R.id.new_combine_payway);
        this.f17148u = (ImageView) m14372a((int) R.id.new_pay_way_balance_icon);
        this.f17150w = (ImageView) m14372a((int) R.id.new_pay_way_card_icon);
        this.f17152y = (ConstraintLayout) m14372a((int) R.id.new_payway_container);
        this.f17118B = (ImageView) m14372a((int) R.id.new_iv_img_arrow);
        this.f17127K = (TripCouponView) m14372a((int) R.id.new_real_time_coupon_v);
        this.f17125I = m14372a((int) R.id.old_real_price_container);
        this.f17126J = m14372a((int) R.id.new_real_time_price_container);
        this.f17151x.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (RealTimePriceViewV2.this.f17117A.getVisibility() == 0) {
                    RealTimePriceViewV2.this.f17128a.paywayChange(RealTimePriceViewV2.this.f17153z);
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.OnService.EVENT_PAYWAY_CHANGE_GUIDE_DISMISS);
            }
        });
        this.f17152y.setOnClickListener(new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (RealTimePriceViewV2.this.f17118B.getVisibility() == 0) {
                    RealTimePriceViewV2.this.f17128a.paywayChange(RealTimePriceViewV2.this.f17153z);
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.OnService.EVENT_PAYWAY_CHANGE_GUIDE_DISMISS);
            }
        });
    }

    public View getView() {
        return this.f17129b;
    }

    public void setPresenter(AbsRealTimePricePresenter absRealTimePricePresenter) {
        this.f17128a = absRealTimePricePresenter;
    }

    public void setData(RealTimePrice realTimePrice) {
        String str;
        if (realTimePrice == null) {
            return;
        }
        if (!TextUtils.isEmpty(realTimePrice.meterFare) || !TextUtils.isEmpty(realTimePrice.totalPrice)) {
            hideLoading();
            this.f17138k = realTimePrice.isDetailPriceClosed;
            this.f17132e.setVisibility(0);
            this.f17133f.setVisibility(0);
            if (!TextUtils.isEmpty(realTimePrice.meterFare)) {
                str = realTimePrice.meterFare;
            } else {
                str = this.f17128a.getPrice(realTimePrice);
            }
            PriceUtils.setFeeDisplayForTextView(this.f17132e, str);
            PriceUtils.setFeeDisplayForTextView(this.f17133f, str);
            m14375a(str);
        }
    }

    public void showLoading() {
        this.f17132e.setVisibility(4);
        this.f17133f.setVisibility(4);
        this.f17135h = true;
    }

    public void hideLoading() {
        this.f17135h = false;
    }

    public boolean isLoading() {
        return this.f17135h;
    }

    public void setOnActionListener(IRealTimePriceView.OnActionListener onActionListener) {
        this.f17134g = onActionListener;
    }

    public void setPayWay(String str) {
        this.f17130c.setText(str);
        this.f17131d.setText(str);
    }

    /* renamed from: a */
    private void m14375a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f17132e.setContentDescription(this.f17129b.getContext().getString(R.string.global_accessible_real_time_price, new Object[]{str}));
            this.f17133f.setContentDescription(this.f17129b.getContext().getString(R.string.global_accessible_real_time_price, new Object[]{str}));
        }
    }

    /* renamed from: a */
    private <T extends View> T m14372a(int i) {
        return this.f17129b.findViewById(i);
    }

    public void setData(PayInfo payInfo) {
        this.f17153z = payInfo;
        if (payInfo.mNewUI == 1) {
            this.f17125I.setVisibility(8);
            this.f17126J.setVisibility(0);
            m14374a(payInfo);
            return;
        }
        this.f17125I.setVisibility(0);
        this.f17126J.setVisibility(8);
        if (CollectionUtils.isEmpty((Collection) payInfo.payWayList)) {
            this.f17117A.setVisibility(8);
        } else {
            this.f17117A.setVisibility(0);
        }
        if (!CollectionUtils.isEmpty((Collection) payInfo.paywayItems)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < payInfo.paywayItems.size(); i++) {
                SelectPaywayItem selectPaywayItem = payInfo.paywayItems.get(i);
                if (selectPaywayItem != null && !TextUtils.isEmpty(selectPaywayItem.paywayText)) {
                    sb.append(selectPaywayItem.paywayText);
                    if (i < payInfo.paywayItems.size() - 1) {
                        sb.append("+");
                    }
                }
            }
            this.f17130c.setText(m14378b(sb.toString()));
            if (this.f17130c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f17130c.getLayoutParams();
                layoutParams.removeRule(17);
                if (payInfo.paywayItems.size() == 2) {
                    this.f17145r.setVisibility(0);
                    this.f17141n.setVisibility(8);
                    Glide.with(this.f17136i).asBitmap().load(payInfo.paywayItems.get(0).paywayUrl).into(this.f17147t);
                    Glide.with(this.f17136i).asBitmap().load(payInfo.paywayItems.get(1).paywayUrl).into(this.f17149v);
                    layoutParams.addRule(17, R.id.combine_payway);
                } else {
                    this.f17145r.setVisibility(8);
                    this.f17141n.setVisibility(0);
                    Glide.with(this.f17136i).asBitmap().load(payInfo.paywayItems.get(0).paywayUrl).into(this.f17141n);
                    layoutParams.addRule(17, R.id.real_time_pay_way_ic);
                }
            }
        }
        if (!TextUtils.isEmpty(payInfo.totalFee)) {
            this.f17132e.setText(payInfo.totalFee);
            this.f17132e.setVisibility(0);
        }
        if (!TextUtils.isEmpty(payInfo.originFee)) {
            this.f17143p.setVisibility(0);
            this.f17143p.setText(payInfo.originFee);
            this.f17143p.getPaint().setFlags(16);
        } else {
            this.f17143p.setVisibility(8);
        }
        if (payInfo.payBrandRich == null || TextUtils.isEmpty(payInfo.payBrandRich.getContent())) {
            this.f17139l.setVisibility(8);
        } else {
            payInfo.payBrandRich.bindTextView(this.f17139l);
            this.f17139l.setVisibility(0);
        }
        if (payInfo.mPayAssistorModule != null) {
            GGKData gGKData = new GGKData();
            gGKData.parse(payInfo.mPayAssistorModule);
            if (gGKData.getData() != null) {
                JSONObject data = gGKData.getData();
                this.f17124H.setVisibility(0);
                this.f17124H.bindData((CouponView.CouponModel) new Gson().fromJson(data.toString(), CouponView.CouponModel.class));
            } else {
                this.f17124H.setVisibility(8);
            }
        } else {
            this.f17124H.setVisibility(8);
        }
        if (payInfo != null && !TextUtils.isEmpty(payInfo.changeResultText)) {
            ToastHelper.showShortInfo(this.f17136i, payInfo.changeResultText, (int) R.drawable.icon_toast_success);
        }
        float[] fArr = {UIUtils.dip2px(this.f17136i, 12.0f), UIUtils.dip2px(this.f17136i, 12.0f), 0.0f, 0.0f, UIUtils.dip2px(this.f17136i, 12.0f), UIUtils.dip2px(this.f17136i, 12.0f), 0.0f, 0.0f};
        if (!TextUtils.isEmpty(payInfo.payBrandBgStart) && !TextUtils.isEmpty(payInfo.payBrandBgEnd)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(new int[]{Color.parseColor(payInfo.payBrandBgStart), Color.parseColor(payInfo.payBrandBgEnd)});
            gradientDrawable.setCornerRadii(fArr);
            this.f17139l.setBackground(gradientDrawable);
        }
        tracePaymentShow(this.f17153z.paymentsType);
    }

    /* renamed from: a */
    private void m14374a(PayInfo payInfo) {
        if (CollectionUtils.isEmpty((Collection) payInfo.payWayList)) {
            this.f17118B.setVisibility(8);
        } else {
            this.f17118B.setVisibility(0);
        }
        if (!CollectionUtils.isEmpty((Collection) payInfo.paywayItems)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < payInfo.paywayItems.size(); i++) {
                SelectPaywayItem selectPaywayItem = payInfo.paywayItems.get(i);
                if (selectPaywayItem != null && !TextUtils.isEmpty(selectPaywayItem.paywayText)) {
                    sb.append(selectPaywayItem.paywayText);
                    if (i < payInfo.paywayItems.size() - 1) {
                        sb.append("+");
                    }
                }
            }
            this.f17131d.setText(m14378b(sb.toString()));
            if (this.f17131d.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f17131d.getLayoutParams();
                layoutParams.removeRule(17);
                if (payInfo.paywayItems.size() == 2) {
                    this.f17146s.setVisibility(0);
                    this.f17142o.setVisibility(8);
                    Glide.with(this.f17136i).asBitmap().load(payInfo.paywayItems.get(0).paywayUrl).into(this.f17148u);
                    Glide.with(this.f17136i).asBitmap().load(payInfo.paywayItems.get(1).paywayUrl).into(this.f17150w);
                    layoutParams.addRule(17, R.id.new_combine_payway);
                } else {
                    this.f17146s.setVisibility(8);
                    this.f17142o.setVisibility(0);
                    Glide.with(this.f17136i).asBitmap().load(payInfo.paywayItems.get(0).paywayUrl).into(this.f17142o);
                    layoutParams.addRule(17, R.id.new_real_time_pay_way_ic);
                }
            }
        }
        if (!TextUtils.isEmpty(payInfo.totalFee)) {
            this.f17133f.setText(payInfo.totalFee);
            this.f17133f.setVisibility(0);
        }
        if (!TextUtils.isEmpty(payInfo.originFee)) {
            this.f17144q.setVisibility(0);
            this.f17144q.setText(payInfo.originFee);
            this.f17144q.getPaint().setFlags(16);
        } else {
            this.f17144q.setVisibility(8);
        }
        if (payInfo.payBrandRich == null || TextUtils.isEmpty(payInfo.payBrandRich.getContent())) {
            this.f17140m.setVisibility(8);
        } else {
            payInfo.payBrandRich.bindTextView(this.f17140m);
            this.f17140m.setVisibility(0);
        }
        if (payInfo.mPayAssistorModule != null) {
            GGKData gGKData = new GGKData();
            gGKData.parse(payInfo.mPayAssistorModule);
            if (gGKData.getData() != null) {
                JSONObject data = gGKData.getData();
                this.f17127K.setVisibility(0);
                this.f17127K.bindData((TripCouponView.CouponModel) new Gson().fromJson(data.toString(), TripCouponView.CouponModel.class));
            } else {
                this.f17127K.setVisibility(8);
            }
        } else {
            this.f17127K.setVisibility(8);
        }
        if (payInfo != null && !TextUtils.isEmpty(payInfo.changeResultText)) {
            if (payInfo.changeResultSuccess == 1) {
                LEGOToastHelper.showShortPosToast(this.f17136i, payInfo.changeResultText);
            } else {
                LEGOToastHelper.showShortNagToast(this.f17136i, payInfo.changeResultText);
            }
        }
        float[] fArr = {0.0f, 0.0f, UIUtils.dip2px(this.f17136i, 12.0f), UIUtils.dip2px(this.f17136i, 12.0f), 0.0f, 0.0f, UIUtils.dip2px(this.f17136i, 12.0f), UIUtils.dip2px(this.f17136i, 12.0f)};
        if (!TextUtils.isEmpty(payInfo.payBrandBgStart) && !TextUtils.isEmpty(payInfo.payBrandBgEnd)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(new int[]{Color.parseColor(payInfo.payBrandBgStart), Color.parseColor(payInfo.payBrandBgEnd)});
            gradientDrawable.setCornerRadii(fArr);
            this.f17140m.setBackground(gradientDrawable);
        }
        tracePaymentShow(this.f17153z.paymentsType);
    }

    /* renamed from: b */
    private String m14378b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return Pattern.compile("[.]").matcher(str).replaceAll("").trim();
        }
        return "";
    }

    public void tracePaymentShow(int i) {
        int i2 = this.f17123G;
        int i3 = (i2 <= 0 || i <= 0) ? -1 : i2 != i ? 1 : 0;
        this.f17123G = i;
        if (i3 > -1) {
            if (OrderStatus.isWaitResponse(CarOrderHelper.getOrder()) && (!this.f17120D || i3 == 1)) {
                m14376a("wait_reply_page", i3, i);
                this.f17120D = true;
            }
            if (CarOrderHelper.isWaitDriver() && (!this.f17121E || i3 == 1)) {
                m14376a("wait_driver_page", i3, i);
                this.f17121E = true;
            }
            if (!CarOrderHelper.isOnService()) {
                return;
            }
            if (!this.f17122F || i3 == 1) {
                m14376a("in_trip_page", i3, i);
                this.f17122F = true;
            }
        }
    }

    /* renamed from: a */
    private void m14376a(String str, int i, int i2) {
        this.f17119C.put(GlobalPayOmegaConstant.EventKey.TAB, str);
        this.f17119C.put("style", Integer.valueOf(this.f17137j.getVisibility() == 0 ? 1 : 0));
        PayInfo payInfo = this.f17153z;
        if (!(payInfo == null || payInfo.mLog == null)) {
            try {
                this.f17119C.putAll((Map) new Gson().fromJson(this.f17153z.mLog.toString(), new TypeToken<HashMap<String, Object>>() {
                }.getType()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f17119C.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        this.f17119C.put("ischange", Integer.valueOf(i));
        this.f17119C.put("paytype", Integer.valueOf(i2));
        GlobalOmegaUtils.trackEvent("ibt_gp_payment_sw", this.f17119C);
        this.f17119C.clear();
    }
}
