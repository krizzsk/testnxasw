package com.didi.component.payway.view;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.common.view.DotLoadingView;
import com.didi.component.common.view.GlobalTipsContainer;
import com.didi.component.common.widget.CouponView;
import com.didi.component.common.widget.NewBubbleHelper;
import com.didi.component.core.ComponentParams;
import com.didi.component.payway.PaywayGuidanceActivity;
import com.didi.component.payway.callback.NewPopShowResultListener;
import com.didi.component.payway.presenter.AbsPayWayPresenter;
import com.didi.component.payway.presenter.PayWayPresenter;
import com.didi.component.payway.widget.CurrentPaymentsView;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.Utils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel;
import com.google.gson.Gson;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PayWayView implements View.OnClickListener, IPayWayView {

    /* renamed from: a */
    Map f17041a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f17042b;

    /* renamed from: c */
    private View f17043c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public PayWayPresenter f17044d;

    /* renamed from: e */
    private CurrentPaymentsView f17045e;

    /* renamed from: f */
    private ViewGroup f17046f;

    /* renamed from: g */
    private ViewGroup f17047g;

    /* renamed from: h */
    private DotLoadingView f17048h;

    /* renamed from: i */
    private LinearLayout f17049i;

    /* renamed from: j */
    private TextView f17050j;

    /* renamed from: k */
    private ImageView f17051k;

    /* renamed from: l */
    private ViewGroup f17052l;

    /* renamed from: m */
    private GlobalTipsContainer f17053m;

    /* renamed from: n */
    private Runnable f17054n;

    /* renamed from: o */
    private BusinessContext f17055o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public LEGOBubble f17056p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public NewBubbleHelper f17057q;

    /* renamed from: r */
    private View f17058r;

    /* renamed from: s */
    private CouponView f17059s;

    /* renamed from: t */
    private int f17060t;

    /* renamed from: u */
    private boolean f17061u = false;

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.global_payway_layout_new_ui;
    }

    public void showPayWayCouponPopup(int i, int i2, String str, String str2) {
    }

    public PayWayView(ComponentParams componentParams, ViewGroup viewGroup) {
        this.f17055o = componentParams.bizCtx;
        Activity activity = componentParams.getActivity();
        this.f17042b = activity;
        View inflate = LayoutInflater.from(activity).inflate(getLayoutId(), viewGroup, true);
        this.f17043c = inflate;
        inflate.setOnClickListener(this);
        this.f17049i = (LinearLayout) this.f17043c.findViewById(R.id.pay_way_default_lv);
        this.f17050j = (TextView) this.f17043c.findViewById(R.id.pay_way_default_tv);
        this.f17051k = (ImageView) this.f17043c.findViewById(R.id.pay_way_default_iv);
        this.f17045e = (CurrentPaymentsView) this.f17043c.findViewById(R.id.pay_way_select);
        this.f17046f = (ViewGroup) this.f17043c.findViewById(R.id.content_container);
        this.f17048h = (DotLoadingView) this.f17043c.findViewById(R.id.pay_way_loading);
        this.f17052l = (ViewGroup) this.f17043c.findViewById(R.id.pay_way_layout);
        this.f17047g = (ViewGroup) this.f17043c.findViewById(R.id.loading_container);
        this.f17048h.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f17058r = this.f17043c.findViewById(R.id.v_show_new_pay_way);
        this.f17059s = (CouponView) this.f17043c.findViewById(R.id.payway_coupon_layout);
    }

    public void hidePayWayLabel() {
        this.f17043c.setVisibility(8);
    }

    public void showPayWayLabel() {
        this.f17043c.setVisibility(0);
    }

    public void setLabel(List<PayWayModel.PayWayItem> list, String str) {
        if (list != null && list.size() > 0 && this.f17049i.getVisibility() == 0) {
            this.f17049i.setVisibility(8);
        }
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f17049i.setVisibility(0);
        }
        this.f17045e.updateLabel(m14292a(list), str);
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.mPayAssistorModule == null) {
            this.f17059s.setVisibility(8);
            this.f17060t = 0;
        } else {
            try {
                GGKData gGKData = new GGKData();
                gGKData.parse(new JSONObject(newEstimateItem.mPayAssistorModule.toString()));
                if (gGKData.getData() != null) {
                    JSONObject data = gGKData.getData();
                    this.f17059s.setVisibility(0);
                    this.f17059s.bindData((CouponView.CouponModel) new Gson().fromJson(data.toString(), CouponView.CouponModel.class));
                    this.f17060t = 1;
                } else {
                    this.f17059s.setVisibility(8);
                    this.f17060t = 0;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (!(newEstimateItem == null || newEstimateItem.carConfig == null || newEstimateItem.carConfig.extraData == null)) {
            newEstimateItem.carConfig.extraData.putAllExtraLog(this.f17041a);
        }
        this.f17041a.put(GlobalPayOmegaConstant.EventKey.TAB, "orderconfirm_page");
        this.f17041a.put("style", Integer.valueOf(this.f17060t));
        this.f17041a.put("ischange", 0);
        this.f17041a.put("paytype", FormStore.getInstance().getPayWay());
        this.f17041a.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f17041a.put("status", "1");
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_payment_sw", (Map<String, Object>) this.f17041a);
        this.f17041a.clear();
        notifyUpdate();
    }

    /* renamed from: a */
    private List<PayWayModel.PayWayItem> m14292a(List<PayWayModel.PayWayItem> list) {
        List<PayWayModel.PayWayItem> arrayList = new ArrayList<>();
        if (!(list == null || list.size() == 0)) {
            int i = 0;
            while (i < list.size()) {
                if (list.get(i).priorityShow == 1) {
                    arrayList.clear();
                    arrayList.add(list.get(i));
                    return arrayList;
                }
                i++;
                arrayList = list;
            }
        }
        return arrayList;
    }

    public void setLabel(List<PayWayModel.PayWayItem> list) {
        setLabel(list, (String) null);
    }

    public void setClickable(boolean z) {
        this.f17043c.setClickable(z);
        this.f17049i.setEnabled(z);
        changeEnableColor(z);
    }

    public void changeEnableColor(boolean z) {
        if (z) {
            m14294a(this.f17042b.getResources().getColor(R.color.g_color_666666));
            this.f17050j.setTextColor(this.f17042b.getResources().getColor(R.color.pay_way_default_tv_color));
            this.f17051k.setVisibility(0);
            return;
        }
        m14294a(this.f17042b.getResources().getColor(R.color.g_color_D9D9D9));
        this.f17050j.setTextColor(this.f17042b.getResources().getColor(R.color.g_color_D9D9D9));
        this.f17051k.setVisibility(8);
    }

    public void setContentDescription(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f17042b.getString(R.string.pay_way_title);
        }
        this.f17043c.setContentDescription(str);
    }

    public boolean isClickable() {
        return this.f17043c.isClickable();
    }

    /* renamed from: a */
    private void m14294a(int i) {
        CurrentPaymentsView currentPaymentsView = this.f17045e;
        if (currentPaymentsView != null && currentPaymentsView.getChildCount() > 0) {
            for (int i2 = 0; i2 < this.f17045e.getChildCount(); i2++) {
                View childAt = this.f17045e.getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextColor(i);
                }
            }
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!Utils.isFastDoubleClick()) {
            LEGOBubble lEGOBubble = this.f17056p;
            if (lEGOBubble != null && lEGOBubble.isShowing()) {
                this.f17057q.saveBubbleShowCount(this.f17042b);
            }
            m14293a();
            this.f17044d.onFormPayWayClicked();
            HashMap hashMap = new HashMap();
            List<PayWayModel.PayWayItem> list = this.f17044d.mSelectedPaywayItem;
            if (list != null && list.size() > 0) {
                PayWayModel.PayWayItem payWayItem = list.get(0);
                if (payWayItem != null) {
                    hashMap.put("payment", Integer.valueOf(payWayItem.tag));
                }
                hashMap.put("bubble_id", SearchIdUploadManager.getInstance().getBubbleId());
                String estimateModelTraceId = FormStore.getInstance().getEstimateModelTraceId();
                if (estimateModelTraceId != null) {
                    hashMap.put("estimate_trace_id", estimateModelTraceId);
                }
            }
            SceneHelper.getInstance().setFromPayMethod(true);
            GlobalOmegaUtils.trackEvent("pas_orderconfirm_payment_ck", (Map<String, Object>) hashMap);
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (!(newEstimateItem == null || newEstimateItem.carConfig == null || newEstimateItem.carConfig.extraData == null)) {
                newEstimateItem.carConfig.extraData.putAllExtraLog(this.f17041a);
            }
            this.f17041a.put(GlobalPayOmegaConstant.EventKey.TAB, "orderconfirm_page");
            this.f17041a.put("style", Integer.valueOf(this.f17060t));
            this.f17041a.put("ischange", 0);
            this.f17041a.put("paytype", FormStore.getInstance().getPayWay());
            if (CollectionUtil.isEmpty((Collection<?>) list)) {
                this.f17041a.put("status", 1);
            }
            hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
            GlobalOmegaUtils.trackEvent("ibt_gp_payment_ck", (Map<String, Object>) this.f17041a);
        }
    }

    public View getView() {
        return this.f17043c;
    }

    public void setPresenter(AbsPayWayPresenter absPayWayPresenter) {
        this.f17044d = (PayWayPresenter) absPayWayPresenter;
    }

    public void showNewPopup(final BubbleItemModel bubbleItemModel, NewPopShowResultListener newPopShowResultListener) {
        final boolean z = true;
        if (CollectionUtil.isEmpty((Collection<?>) this.f17044d.mSelectedPaywayItem)) {
            if (GlobalSPUtil.isShowPaywayGuide(this.f17042b) && bubbleItemModel.bubbleText != null && !TextUtils.isEmpty(bubbleItemModel.bubbleText.getContent())) {
                Intent intent = new Intent(this.f17042b, PaywayGuidanceActivity.class);
                intent.setFlags(268435456);
                Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
                if (!this.f17061u) {
                    this.f17061u = true;
                    currentActivity.startActivity(intent);
                    currentActivity.overridePendingTransition(0, 0);
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", "pay_guide");
                    hashMap.put("status", 1);
                    GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_paymentnewlearn_sw", (Map<String, Object>) hashMap);
                }
            }
        } else if (GlobalSPUtil.isShowPaywayGuide(this.f17042b)) {
            GlobalSPUtil.savePaywayGuideShown(this.f17042b);
            if (bubbleItemModel.actionEvent != null) {
                z = false;
            }
            NewBubbleHelper newBubbleHelper = new NewBubbleHelper(this.f17042b, bubbleItemModel);
            this.f17057q = newBubbleHelper;
            LEGOBubble.Builder builder = newBubbleHelper.getmBuilder();
            builder.setContentViewOnClick(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    PayWayView.this.f17057q.saveBubbleShowCount(PayWayView.this.f17042b);
                    PayWayView.this.m14293a();
                    PayWayView.this.f17057q.trackEvent(false);
                    PayWayView.this.m14297a(false);
                    if (z) {
                        PayWayView.this.f17056p.dismiss();
                    } else if (PayWayView.this.f17044d != null) {
                        PayWayView.this.f17044d.onNewPayWayGuideClicked(bubbleItemModel);
                    }
                }
            });
            this.f17056p = builder.build();
            builder.setMaxLines(2);
            if (this.f17056p.isShowing()) {
                return;
            }
            if (z) {
                View view = this.f17043c;
                if (view != null && view.getRootView().isAttachedToWindow()) {
                    m14296a(this.f17056p, newPopShowResultListener);
                    return;
                }
                return;
            }
            m14296a(this.f17056p, newPopShowResultListener);
        }
    }

    /* renamed from: a */
    private void m14296a(LEGOBubble lEGOBubble, NewPopShowResultListener newPopShowResultListener) {
        newPopShowResultListener.success(this.f17057q);
        m14297a(true);
        View view = this.f17043c;
        lEGOBubble.show(view, 0, (-view.getMeasuredHeight()) - ResourcesHelper.getDimensionPixelSize(this.f17042b, R.dimen.pay_method_bubble_yoff), 1999);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14297a(boolean z) {
        if (z) {
            showRedDot(this.f17057q.isShowRedMark(this.f17042b));
        } else {
            showRedDot(false);
        }
    }

    public void showGuildPopup(String str, boolean z) {
        if (this.f17053m == null) {
            this.f17053m = new GlobalTipsContainer(this.f17042b);
        }
        this.f17053m.showWithLocationBinded(str, this.f17043c, 1, 0, 0, ResourcesHelper.getDimensionPixelSize(this.f17042b, R.dimen.ms_12dp));
    }

    /* renamed from: a */
    private float m14289a(View view) {
        if (view != null) {
            return ((float) view.getLeft()) + m14290a(view.getParent());
        }
        return 0.0f;
    }

    /* renamed from: a */
    private float m14290a(ViewParent viewParent) {
        if (viewParent == null || !(viewParent instanceof ViewGroup)) {
            return 0.0f;
        }
        return ((float) ((ViewGroup) viewParent).getLeft()) + m14290a(viewParent.getParent());
    }

    public void dismissPopup() {
        LEGOBubble lEGOBubble = this.f17056p;
        if (lEGOBubble != null && lEGOBubble.isShowing()) {
            this.f17056p.dismiss();
            m14297a(false);
        }
    }

    public void showLoading() {
        this.f17047g.setVisibility(0);
        this.f17048h.setVisibility(0);
        this.f17048h.startLoading();
        this.f17046f.setVisibility(8);
    }

    public void hideLoading() {
        DotLoadingView dotLoadingView = this.f17048h;
        if (dotLoadingView != null && this.f17047g != null && this.f17046f != null) {
            dotLoadingView.stopLoading();
            this.f17047g.setVisibility(8);
            this.f17048h.setVisibility(8);
            this.f17046f.setVisibility(0);
        }
    }

    public String getContent() {
        String string = this.f17042b.getString(R.string.pay_way_title);
        CurrentPaymentsView currentPaymentsView = this.f17045e;
        return (currentPaymentsView == null || TextUtils.isEmpty(currentPaymentsView.getContent())) ? string : this.f17045e.getContent();
    }

    public List<String> getIcon() {
        CurrentPaymentsView currentPaymentsView = this.f17045e;
        if (currentPaymentsView != null) {
            return currentPaymentsView.getIcon();
        }
        return null;
    }

    public void notifyUpdate() {
        PayWayPresenter payWayPresenter = this.f17044d;
        if (payWayPresenter != null) {
            payWayPresenter.notifyUpdate();
        }
    }

    public void show() {
        ViewGroup viewGroup = this.f17052l;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public void hide() {
        ViewGroup viewGroup = this.f17052l;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void showRedDot(boolean z) {
        if (z) {
            this.f17058r.setVisibility(0);
        } else {
            this.f17058r.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14293a() {
        View view = this.f17058r;
        if (view != null && view.getVisibility() == 0) {
            this.f17057q.saveRedMarkShowCount(this.f17042b);
        }
    }
}
