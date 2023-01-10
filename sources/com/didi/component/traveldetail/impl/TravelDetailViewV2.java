package com.didi.component.traveldetail.impl;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.I18NUtils;
import com.didi.component.common.util.StringUtil;
import com.didi.component.traveldetail.AbsTravelDetailPresenterV2;
import com.didi.component.traveldetail.CommonTravelDetailItemDecorationV2;
import com.didi.component.traveldetail.ITravelDetailViewV2;
import com.didi.component.traveldetail.OnServiceUtil;
import com.didi.component.traveldetail.adapter.TravelDetailCommonAdapterV2;
import com.didi.component.traveldetail.model.AgreementLinkInfo;
import com.didi.component.traveldetail.model.TravelDetailItemV2;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didiglobal.travel.util.CollectionUtils;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;

public class TravelDetailViewV2 implements View.OnClickListener, ITravelDetailViewV2 {

    /* renamed from: a */
    private View f18045a;

    /* renamed from: b */
    private RecyclerView f18046b;

    /* renamed from: c */
    private ImageView f18047c = ((ImageView) this.f18045a.findViewById(R.id.routeEditButton));

    /* renamed from: d */
    private TravelDetailCommonAdapterV2 f18048d = new TravelDetailCommonAdapterV2();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AbsTravelDetailPresenterV2 f18049e;

    /* renamed from: f */
    private TextView f18050f;

    /* renamed from: g */
    private TextView f18051g;

    /* renamed from: h */
    private View f18052h;

    /* renamed from: i */
    private ViewGroup f18053i;

    /* renamed from: j */
    private TextView f18054j;

    /* renamed from: k */
    private ImageView f18055k;

    /* renamed from: l */
    private LEGOBubble f18056l;

    /* renamed from: m */
    private AgreementLinkInfo f18057m;

    /* renamed from: n */
    private Context f18058n;

    public void doXPanelStatusChanged(int i) {
    }

    public void setTravelDetailData(List<TravelDetailItemV2> list) {
        if (!CollectionUtils.isEmpty((Collection<?>) list)) {
            m15297a();
            this.f18048d.setTravelDetailList(list);
            if (CarOrderHelper.getOrderStatus() != 4 || CarOrderHelper.getOrder().isSplitFareUser()) {
                this.f18047c.setVisibility(8);
                m15298a(this.f18047c.getContext(), false);
            } else {
                this.f18047c.setVisibility(0);
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        TravelDetailViewV2.this.m15302b();
                    }
                }, 1000);
            }
            setAgreementLinkInfo(this.f18057m);
        }
    }

    public void setAgreementLinkInfo(AgreementLinkInfo agreementLinkInfo) {
        this.f18057m = agreementLinkInfo;
        if (agreementLinkInfo != null) {
            if (!StringUtil.isNullOrEmpty(agreementLinkInfo.icon)) {
                this.f18055k.setVisibility(0);
                Glide.with(this.f18058n).load(agreementLinkInfo.icon).into(this.f18055k);
            } else {
                this.f18055k.setVisibility(8);
            }
            if (agreementLinkInfo.title != null) {
                this.f18054j.setVisibility(0);
                agreementLinkInfo.title.bindTextView(this.f18054j);
                return;
            }
            this.f18054j.setVisibility(8);
            return;
        }
        this.f18055k.setVisibility(8);
        this.f18054j.setVisibility(8);
    }

    public void hideGuide() {
        if (getView() != null) {
            m15298a(getView().getContext(), false);
        }
    }

    public void showGuide() {
        m15302b();
    }

    public View getView() {
        return this.f18045a;
    }

    public void setPresenter(AbsTravelDetailPresenterV2 absTravelDetailPresenterV2) {
        this.f18049e = absTravelDetailPresenterV2;
    }

    public TravelDetailViewV2(Context context, int i) {
        this.f18058n = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_travel_detail_layout_v2, (ViewGroup) null);
        this.f18045a = inflate;
        this.f18046b = (RecyclerView) inflate.findViewById(R.id.travelDetailRecycler);
        this.f18046b.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.f18046b.setNestedScrollingEnabled(false);
        this.f18046b.addItemDecoration(new CommonTravelDetailItemDecorationV2(context));
        this.f18046b.setAdapter(this.f18048d);
        this.f18047c.setOnClickListener(this);
        this.f18050f = (TextView) this.f18045a.findViewById(R.id.title);
        this.f18051g = (TextView) this.f18045a.findViewById(R.id.subTitle);
        this.f18052h = this.f18045a.findViewById(R.id.divider);
        this.f18053i = (ViewGroup) this.f18045a.findViewById(R.id.guideLayout);
        this.f18054j = (TextView) this.f18045a.findViewById(R.id.agreement_link);
        ImageView imageView = (ImageView) this.f18045a.findViewById(R.id.agreement_link_icon);
        this.f18055k = imageView;
        imageView.setOnClickListener(this);
        this.f18054j.setOnClickListener(this);
    }

    /* renamed from: a */
    private void m15297a() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (CarOrderHelper.isOrderEnd()) {
                this.f18050f.setVisibility(0);
                this.f18051g.setVisibility(0);
                this.f18051g.setText(I18NUtils.getTimeAllDate(order.createTime, true));
                this.f18052h.setVisibility(0);
                return;
            }
            this.f18050f.setVisibility(8);
            this.f18051g.setVisibility(8);
            this.f18052h.setVisibility(8);
        }
    }

    public void onClick(View view) {
        AgreementLinkInfo agreementLinkInfo;
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == this.f18047c.getId()) {
            m15298a(this.f18047c.getContext(), true);
            this.f18049e.onEditClick();
        } else if ((view.getId() == this.f18055k.getId() || view.getId() == this.f18054j.getId()) && (agreementLinkInfo = this.f18057m) != null && !TextUtils.isEmpty(agreementLinkInfo.link)) {
            DRouter.build(this.f18057m.link).start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m15302b() {
        ImageView imageView = this.f18047c;
        if (imageView != null && imageView.getVisibility() == 0) {
            final Context context = this.f18045a.getContext();
            AbsTravelDetailPresenterV2 absTravelDetailPresenterV2 = this.f18049e;
            if ((!(absTravelDetailPresenterV2 instanceof TravelDetailPresenterV2) || !((TravelDetailPresenterV2) absTravelDetailPresenterV2).getShowEditGuideNow()) && OnServiceUtil.INSTANCE.needShowOnServiceRouteEditShow(context) && GlobalSPUtil.getChangePaywayGuideShown(context)) {
                if (this.f18056l == null) {
                    LEGOBubble.Builder builder = new LEGOBubble.Builder(context);
                    GlobalOmegaUtils.trackEvent("ibt_gp_editroute_newguide_sw");
                    this.f18056l = builder.setDirection("right").setCloseBtnListener((BubbleCloseListener) null).setText(ResourcesHelper.getString(context, R.string.GR_Pick_and_OnTrip_2020_tripCard_editRoute_edu)).setTextTypeface(3).setCloseBtnVisible(false).setBgColor(Color.parseColor("#E05C6166")).setContentViewOnClick(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            TravelDetailViewV2.this.m15298a(context, true);
                            TravelDetailViewV2.this.f18049e.onEditClick();
                        }
                    }).build();
                }
                this.f18053i.removeAllViews();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 8388629;
                this.f18053i.addView(this.f18056l.getView(), layoutParams);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15298a(Context context, boolean z) {
        if (this.f18056l != null) {
            this.f18053i.removeAllViews();
            if (z) {
                OnServiceUtil.INSTANCE.setOnServiceRouteEditShow(context, true);
            }
        }
    }
}
