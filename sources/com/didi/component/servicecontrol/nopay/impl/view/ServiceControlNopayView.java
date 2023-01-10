package com.didi.component.servicecontrol.nopay.impl.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.loading.LoadingWrapper;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.servicecontrol.nopay.AbsServiceControlNopayPresenter;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.CashUnPayInterceptInfo;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class ServiceControlNopayView extends LoadingWrapper implements IServiceControlNopayView, ILoadingHolder {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AbsServiceControlNopayPresenter f17732a;

    /* renamed from: b */
    private ViewGroup f17733b;

    /* renamed from: c */
    private TextView f17734c = ((TextView) this.f17733b.findViewById(R.id.title));

    /* renamed from: d */
    private TextView f17735d = ((TextView) this.f17733b.findViewById(R.id.cartype));

    /* renamed from: e */
    private TextView f17736e = ((TextView) this.f17733b.findViewById(R.id.price));

    /* renamed from: f */
    private TextView f17737f = ((TextView) this.f17733b.findViewById(R.id.start_address));

    /* renamed from: g */
    private TextView f17738g = ((TextView) this.f17733b.findViewById(R.id.end_address));

    /* renamed from: h */
    private TextView f17739h = ((TextView) this.f17733b.findViewById(R.id.time));

    /* renamed from: i */
    private TextView f17740i;

    /* renamed from: j */
    private TextView f17741j = ((TextView) this.f17733b.findViewById(R.id.bind_card_next_button));

    /* renamed from: k */
    private TextView f17742k = ((TextView) this.f17733b.findViewById(R.id.paid_button));

    /* renamed from: l */
    private TextView f17743l = ((TextView) this.f17733b.findViewById(R.id.content));

    /* renamed from: m */
    private FrameLayout f17744m = ((FrameLayout) this.f17733b.findViewById(R.id.global_service_control_no_pay_loading));

    /* renamed from: n */
    private ImageView f17745n = ((ImageView) this.f17733b.findViewById(R.id.iv_dialog_close));

    /* renamed from: o */
    private TextView f17746o = ((TextView) this.f17733b.findViewById(R.id.pay_question_link));

    /* renamed from: p */
    private LinearLayout f17747p = ((LinearLayout) this.f17733b.findViewById(R.id.btn_layout));

    /* renamed from: a */
    private int m15010a() {
        return R.layout.global_service_control_no_pay_layout_new;
    }

    public void close() {
    }

    public ServiceControlNopayView(Activity activity, ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(activity).inflate(m15010a(), viewGroup, false);
        this.f17733b = viewGroup2;
        this.f17740i = (TextView) viewGroup2.findViewById(R.id.pay_now_button);
        setLoadingShowOn(this);
        m15012b();
    }

    /* renamed from: b */
    private void m15012b() {
        this.f17740i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ServiceControlNopayView.this.f17732a != null) {
                    ServiceControlNopayView.this.f17732a.payNow();
                }
            }
        });
        this.f17741j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ServiceControlNopayView.this.f17732a != null) {
                    ServiceControlNopayView.this.f17732a.bindCardNextTime();
                }
            }
        });
        this.f17742k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ServiceControlNopayView.this.f17732a != null) {
                    ServiceControlNopayView.this.f17732a.havePaid();
                }
            }
        });
        this.f17745n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ServiceControlNopayView.this.f17732a != null) {
                    ServiceControlNopayView.this.f17732a.close();
                }
            }
        });
    }

    public void setPresenter(AbsServiceControlNopayPresenter absServiceControlNopayPresenter) {
        this.f17732a = absServiceControlNopayPresenter;
    }

    public View getView() {
        return this.f17733b;
    }

    public void showNoPayView(final CashUnPayInterceptInfo cashUnPayInterceptInfo) {
        if (cashUnPayInterceptInfo != null) {
            this.f17734c.setText(cashUnPayInterceptInfo.title);
            this.f17743l.setText(cashUnPayInterceptInfo.content);
            this.f17735d.setText(cashUnPayInterceptInfo.productName);
            this.f17736e.setText(cashUnPayInterceptInfo.feeDisplay);
            this.f17737f.setText(cashUnPayInterceptInfo.startAddress);
            this.f17738g.setText(cashUnPayInterceptInfo.endAddress);
            this.f17739h.setText(cashUnPayInterceptInfo.endTime);
            if (cashUnPayInterceptInfo.payNow != null) {
                this.f17740i.setText(cashUnPayInterceptInfo.payNow.name);
                HashMap hashMap = new HashMap();
                hashMap.put("type", cashUnPayInterceptInfo.payNow.action);
                Map<String, Object> extraLog = cashUnPayInterceptInfo.getExtraLog();
                if (!CollectionUtils.isEmpty((Map) extraLog)) {
                    hashMap.putAll(extraLog);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_btn_sw", (Map<String, Object>) hashMap);
            }
            if (cashUnPayInterceptInfo.nextBindCard != null) {
                this.f17741j.setText(cashUnPayInterceptInfo.nextBindCard.name);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("type", cashUnPayInterceptInfo.nextBindCard.action);
                Map<String, Object> extraLog2 = cashUnPayInterceptInfo.getExtraLog();
                if (!CollectionUtils.isEmpty((Map) extraLog2)) {
                    hashMap2.putAll(extraLog2);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_btn_sw", (Map<String, Object>) hashMap2);
            } else {
                this.f17741j.setVisibility(8);
            }
            if (cashUnPayInterceptInfo.havePaid != null) {
                this.f17742k.setText(cashUnPayInterceptInfo.havePaid.name);
                HashMap hashMap3 = new HashMap();
                hashMap3.put("type", cashUnPayInterceptInfo.havePaid.action);
                Map<String, Object> extraLog3 = cashUnPayInterceptInfo.getExtraLog();
                if (!CollectionUtils.isEmpty((Map) extraLog3)) {
                    hashMap3.putAll(extraLog3);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_btn_sw", (Map<String, Object>) hashMap3);
            } else {
                this.f17742k.setVisibility(8);
            }
            if (cashUnPayInterceptInfo.mFeedback == null || TextUtils.isEmpty(cashUnPayInterceptInfo.mFeedback.name) || TextUtils.isEmpty(cashUnPayInterceptInfo.mFeedback.url)) {
                this.f17746o.setVisibility(8);
            } else {
                final String str = cashUnPayInterceptInfo.mFeedback.url;
                this.f17746o.setVisibility(0);
                this.f17746o.setText(cashUnPayInterceptInfo.mFeedback.name);
                HashMap hashMap4 = new HashMap();
                hashMap4.put("type", "LINK");
                Map<String, Object> extraLog4 = cashUnPayInterceptInfo.getExtraLog();
                if (!CollectionUtils.isEmpty((Map) extraLog4)) {
                    hashMap4.putAll(extraLog4);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_btn_sw", (Map<String, Object>) hashMap4);
                this.f17746o.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "LINK");
                        Map<String, Object> extraLog = cashUnPayInterceptInfo.getExtraLog();
                        if (!CollectionUtils.isEmpty((Map) extraLog)) {
                            hashMap.putAll(extraLog);
                        }
                        GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_btn_ck", (Map<String, Object>) hashMap);
                        DRouter.build(str).start();
                    }
                });
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17747p.getLayoutParams();
                layoutParams.topMargin = UiUtils.dip2px(this.f17733b.getContext(), 30.0f);
                this.f17747p.setLayoutParams(layoutParams);
            }
            HashMap hashMap5 = new HashMap();
            if (!TextUtils.isEmpty(cashUnPayInterceptInfo.mEntry)) {
                hashMap5.put(ParamKeys.PARAM_COMPLAIN_ENTRY, cashUnPayInterceptInfo.mEntry);
                Map<String, Object> extraLog5 = cashUnPayInterceptInfo.getExtraLog();
                if (!CollectionUtils.isEmpty((Map) extraLog5)) {
                    hashMap5.putAll(extraLog5);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_sw", (Map<String, Object>) hashMap5);
            }
        }
    }

    public void showLoading() {
        super.showLoading();
    }

    public void hideLoading() {
        super.hideLoading();
    }

    public View getFallbackView() {
        return this.f17744m;
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().setRenderType(LoadingRenderType.ANIMATION).build();
    }
}
