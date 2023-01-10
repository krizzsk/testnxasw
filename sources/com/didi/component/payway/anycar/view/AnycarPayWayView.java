package com.didi.component.payway.anycar.view;

import android.app.Activity;
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
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmGetListener;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.view.DotLoadingView;
import com.didi.component.common.view.GlobalTipsContainer;
import com.didi.component.common.widget.CouponView;
import com.didi.component.common.widget.NewBubbleHelper;
import com.didi.component.core.ComponentParams;
import com.didi.component.payway.anycar.callback.NewPopShowResultListener;
import com.didi.component.payway.anycar.presenter.AbsPayWayPresenter;
import com.didi.component.payway.anycar.presenter.AnyCarPayWayPresenter;
import com.didi.component.payway.widget.CurrentPaymentsView;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.Utils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarPayModel;
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

public class AnycarPayWayView implements View.OnClickListener, IAnycarPayWayView {

    /* renamed from: a */
    Map<String, Object> f16992a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f16993b;

    /* renamed from: c */
    private View f16994c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AnyCarPayWayPresenter f16995d;

    /* renamed from: e */
    private CurrentPaymentsView f16996e;

    /* renamed from: f */
    private ViewGroup f16997f;

    /* renamed from: g */
    private ViewGroup f16998g;

    /* renamed from: h */
    private DotLoadingView f16999h;

    /* renamed from: i */
    private LinearLayout f17000i;

    /* renamed from: j */
    private TextView f17001j;

    /* renamed from: k */
    private ImageView f17002k;

    /* renamed from: l */
    private ViewGroup f17003l;

    /* renamed from: m */
    private GlobalTipsContainer f17004m;

    /* renamed from: n */
    private Runnable f17005n;

    /* renamed from: o */
    private BusinessContext f17006o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public LEGOBubble f17007p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public NewBubbleHelper f17008q;

    /* renamed from: r */
    private View f17009r;

    /* renamed from: s */
    private CouponView f17010s;

    /* renamed from: t */
    private int f17011t;

    /* renamed from: u */
    private AnyCarPayModel f17012u;

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.global_payway_layout_new_ui;
    }

    public AnycarPayWayView(ComponentParams componentParams, ViewGroup viewGroup) {
        this.f17006o = componentParams.bizCtx;
        Activity activity = componentParams.getActivity();
        this.f16993b = activity;
        View inflate = LayoutInflater.from(activity).inflate(getLayoutId(), viewGroup, true);
        this.f16994c = inflate;
        inflate.setOnClickListener(this);
        this.f17000i = (LinearLayout) this.f16994c.findViewById(R.id.pay_way_default_lv);
        this.f17001j = (TextView) this.f16994c.findViewById(R.id.pay_way_default_tv);
        this.f17002k = (ImageView) this.f16994c.findViewById(R.id.pay_way_default_iv);
        this.f16996e = (CurrentPaymentsView) this.f16994c.findViewById(R.id.pay_way_select);
        this.f16997f = (ViewGroup) this.f16994c.findViewById(R.id.content_container);
        this.f16999h = (DotLoadingView) this.f16994c.findViewById(R.id.pay_way_loading);
        this.f17003l = (ViewGroup) this.f16994c.findViewById(R.id.pay_way_layout);
        this.f16998g = (ViewGroup) this.f16994c.findViewById(R.id.loading_container);
        this.f16999h.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f17009r = this.f16994c.findViewById(R.id.v_show_new_pay_way);
        this.f17010s = (CouponView) this.f16994c.findViewById(R.id.payway_coupon_layout);
    }

    public void setLabel(List<PayWayModel.PayWayItem> list, String str) {
        if (list != null && list.size() > 0 && this.f17000i.getVisibility() == 0) {
            this.f17000i.setVisibility(8);
        }
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f17000i.setVisibility(0);
        }
        this.f16996e.updateLabel(m14244a(list), str);
        AnyCarPayModel anyCarPayModel = this.f17012u;
        if (anyCarPayModel == null || anyCarPayModel.mPayAssistorModule == null) {
            this.f17010s.setVisibility(8);
            this.f17011t = 0;
        } else {
            try {
                GGKData gGKData = new GGKData();
                gGKData.parse(new JSONObject(anyCarPayModel.mPayAssistorModule.toString()));
                if (gGKData.getData() != null) {
                    JSONObject data = gGKData.getData();
                    this.f17010s.setVisibility(0);
                    this.f17010s.bindData((CouponView.CouponModel) new Gson().fromJson(data.toString(), CouponView.CouponModel.class));
                    this.f17011t = 1;
                } else {
                    this.f17010s.setVisibility(8);
                    this.f17011t = 0;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.f16992a.put(GlobalPayOmegaConstant.EventKey.TAB, "orderconfirm_page");
        this.f16992a.put("style", Integer.valueOf(this.f17011t));
        this.f16992a.put("ischange", 0);
        this.f16992a.put("paytype", FormStore.getInstance().getPayWay());
        this.f16992a.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        GlobalOmegaUtils.trackEvent("ibt_gp_payment_sw", this.f16992a);
        this.f16992a.clear();
        notifyUpdate();
    }

    /* renamed from: a */
    private List<PayWayModel.PayWayItem> m14244a(List<PayWayModel.PayWayItem> list) {
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
        this.f16994c.setClickable(z);
        this.f17000i.setEnabled(z);
        changeEnableColor(z);
    }

    public void changeEnableColor(boolean z) {
        if (z) {
            m14246a(this.f16993b.getResources().getColor(R.color.g_color_666666));
            this.f17001j.setTextColor(this.f16993b.getResources().getColor(R.color.pay_way_default_tv_color));
            this.f17002k.setVisibility(0);
            return;
        }
        m14246a(this.f16993b.getResources().getColor(R.color.g_color_D9D9D9));
        this.f17001j.setTextColor(this.f16993b.getResources().getColor(R.color.g_color_D9D9D9));
        this.f17002k.setVisibility(8);
    }

    public void setContentDescription(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f16993b.getString(R.string.pay_way_title);
        }
        this.f16994c.setContentDescription(str);
    }

    public boolean isClickable() {
        return this.f16994c.isClickable();
    }

    /* renamed from: a */
    private void m14246a(int i) {
        CurrentPaymentsView currentPaymentsView = this.f16996e;
        if (currentPaymentsView != null && currentPaymentsView.getChildCount() > 0) {
            for (int i2 = 0; i2 < this.f16996e.getChildCount(); i2++) {
                View childAt = this.f16996e.getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextColor(i);
                }
            }
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!Utils.isFastDoubleClick()) {
            LEGOBubble lEGOBubble = this.f17007p;
            if (lEGOBubble != null && lEGOBubble.isShowing()) {
                this.f17008q.saveBubbleShowCount(this.f16993b);
            }
            m14245a();
            this.f16995d.onFormPayWayClicked();
            HashMap hashMap = new HashMap();
            List<PayWayModel.PayWayItem> list = this.f16995d.mSelectedPaywayItem;
            if (list != null && list.size() > 0) {
                PayWayModel.PayWayItem payWayItem = list.get(0);
                if (payWayItem != null) {
                    hashMap.put("payment", Integer.valueOf(payWayItem.tag));
                }
                String str = null;
                ConfirmGetListener confirmGetListener = PageCompDataTransfer.getInstance().getConfirmGetListener();
                if (confirmGetListener != null) {
                    str = confirmGetListener.getTraceId();
                }
                if (str != null) {
                    hashMap.put("estimate_trace_id", str);
                }
            }
            SceneHelper.getInstance().setFromPayMethod(true);
            GlobalOmegaUtils.trackEvent("pas_orderconfirm_payment_ck", (Map<String, Object>) hashMap);
            this.f16992a.put(GlobalPayOmegaConstant.EventKey.TAB, "orderconfirm_page");
            this.f16992a.put("style", Integer.valueOf(this.f17011t));
            this.f16992a.put("ischange", 0);
            this.f16992a.put("paytype", FormStore.getInstance().getPayWay());
            hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
            GlobalOmegaUtils.trackEvent("ibt_gp_payment_ck", this.f16992a);
        }
    }

    public View getView() {
        return this.f16994c;
    }

    public void setPresenter(AbsPayWayPresenter absPayWayPresenter) {
        this.f16995d = (AnyCarPayWayPresenter) absPayWayPresenter;
    }

    public void showNewPopup(final BubbleItemModel bubbleItemModel, NewPopShowResultListener newPopShowResultListener) {
        LEGOBubble lEGOBubble = this.f17007p;
        final boolean z = false;
        if (lEGOBubble != null && lEGOBubble.isShowing()) {
            this.f17007p.dismiss();
            m14249a(false);
        }
        if (bubbleItemModel.actionEvent == null) {
            z = true;
        }
        NewBubbleHelper newBubbleHelper = new NewBubbleHelper(this.f16993b, bubbleItemModel);
        this.f17008q = newBubbleHelper;
        LEGOBubble.Builder builder = newBubbleHelper.getmBuilder();
        builder.setContentViewOnClick(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarPayWayView.this.f17008q.saveBubbleShowCount(AnycarPayWayView.this.f16993b);
                AnycarPayWayView.this.m14245a();
                AnycarPayWayView.this.f17008q.trackEvent(false);
                AnycarPayWayView.this.m14249a(false);
                if (z) {
                    AnycarPayWayView.this.f17007p.dismiss();
                } else if (AnycarPayWayView.this.f16995d != null) {
                    AnycarPayWayView.this.f16995d.onNewPayWayGuideClicked(bubbleItemModel);
                }
            }
        });
        this.f17007p = builder.build();
        builder.setMaxLines(2);
        if (this.f17007p.isShowing()) {
            return;
        }
        if (z) {
            View view = this.f16994c;
            if (view != null && view.getRootView().isAttachedToWindow()) {
                m14248a(this.f17007p, newPopShowResultListener);
                return;
            }
            return;
        }
        m14248a(this.f17007p, newPopShowResultListener);
    }

    /* renamed from: a */
    private void m14248a(LEGOBubble lEGOBubble, NewPopShowResultListener newPopShowResultListener) {
        newPopShowResultListener.success(this.f17008q);
        m14249a(true);
        View view = this.f16994c;
        lEGOBubble.show(view, 0, (-view.getMeasuredHeight()) - ResourcesHelper.getDimensionPixelSize(this.f16993b, R.dimen.pay_method_bubble_yoff), 1999);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14249a(boolean z) {
        if (z) {
            showRedDot(this.f17008q.isShowRedMark(this.f16993b));
        } else {
            showRedDot(false);
        }
    }

    /* renamed from: a */
    private float m14241a(View view) {
        if (view != null) {
            return ((float) view.getLeft()) + m14242a(view.getParent());
        }
        return 0.0f;
    }

    /* renamed from: a */
    private float m14242a(ViewParent viewParent) {
        if (viewParent == null || !(viewParent instanceof ViewGroup)) {
            return 0.0f;
        }
        return ((float) ((ViewGroup) viewParent).getLeft()) + m14242a(viewParent.getParent());
    }

    public void dismissPopup() {
        LEGOBubble lEGOBubble = this.f17007p;
        if (lEGOBubble != null && lEGOBubble.isShowing()) {
            this.f17007p.dismiss();
            m14249a(false);
        }
    }

    public void hideLoading() {
        DotLoadingView dotLoadingView = this.f16999h;
        if (dotLoadingView != null && this.f16998g != null && this.f16997f != null) {
            dotLoadingView.stopLoading();
            this.f16998g.setVisibility(8);
            this.f16999h.setVisibility(8);
            this.f16997f.setVisibility(0);
        }
    }

    public String getContent() {
        String string = this.f16993b.getString(R.string.pay_way_title);
        CurrentPaymentsView currentPaymentsView = this.f16996e;
        return (currentPaymentsView == null || TextUtils.isEmpty(currentPaymentsView.getContent())) ? string : this.f16996e.getContent();
    }

    public List<String> getIcon() {
        CurrentPaymentsView currentPaymentsView = this.f16996e;
        if (currentPaymentsView != null) {
            return currentPaymentsView.getIcon();
        }
        return null;
    }

    public void notifyUpdate() {
        AnyCarPayWayPresenter anyCarPayWayPresenter = this.f16995d;
        if (anyCarPayWayPresenter != null) {
            anyCarPayWayPresenter.notifyUpdate();
        }
    }

    public void show() {
        ViewGroup viewGroup = this.f17003l;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public void hide() {
        ViewGroup viewGroup = this.f17003l;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void showRedDot(boolean z) {
        if (z) {
            this.f17009r.setVisibility(0);
        } else {
            this.f17009r.setVisibility(8);
        }
    }

    public void setData(AnyCarPayModel anyCarPayModel) {
        this.f17012u = anyCarPayModel;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14245a() {
        View view = this.f17009r;
        if (view != null && view.getVisibility() == 0) {
            this.f17008q.saveRedMarkShowCount(this.f16993b);
        }
    }
}
