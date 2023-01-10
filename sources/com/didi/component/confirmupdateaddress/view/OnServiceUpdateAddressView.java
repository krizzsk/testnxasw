package com.didi.component.confirmupdateaddress.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.confirmupdateaddress.presenter.OnServiceUpdateAddressPresenter;
import com.didi.component.confirmupdateaddress.util.OnServiceGuideUtil;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.popup.BubbleCloseListener;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.async.AsyncLayoutFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;

public class OnServiceUpdateAddressView implements View.OnClickListener, IUpdateAddress {

    /* renamed from: a */
    private final Context f14565a;

    /* renamed from: b */
    private View f14566b;

    /* renamed from: c */
    private OnServiceUpdateAddressPresenter f14567c;

    /* renamed from: d */
    private TextView f14568d;

    /* renamed from: e */
    private TextView f14569e;

    /* renamed from: f */
    private View f14570f;

    /* renamed from: g */
    private ViewGroup f14571g;

    public OnServiceUpdateAddressView(ComponentParams componentParams, ViewGroup viewGroup) {
        this.f14565a = componentParams.bizCtx.getContext();
        View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(R.layout.global_onservice_update_address_layout);
        viewByResId = viewByResId == null ? LayoutInflater.from(this.f14565a).inflate(R.layout.global_onservice_update_address_layout, viewGroup, false) : viewByResId;
        this.f14566b = viewByResId;
        this.f14568d = (TextView) viewByResId.findViewById(R.id.global_confirm_update_address_pick_up_tv);
        this.f14569e = (TextView) this.f14566b.findViewById(R.id.global_confirm_update_address_change_tv);
        this.f14570f = this.f14566b.findViewById(R.id.divider);
        this.f14571g = (ViewGroup) this.f14566b.findViewById(R.id.global_confirm_update_address_guide_layout);
        this.f14569e.setOnClickListener(this);
        this.f14571g.setOnClickListener(this);
        this.f14568d.setOnClickListener(this);
        updateAddress();
        m12063c();
    }

    public void updateAddress() {
        CarOrder order = CarOrderHelper.getOrder();
        Address address = order != null ? order.startAddress : null;
        if (address == null || TextUtils.isEmpty(address.getDisplayName())) {
            this.f14568d.setText(ResourcesHelper.getString(this.f14565a, R.string.map_flow_current_location));
        } else {
            this.f14568d.setText(address.getDisplayName());
        }
    }

    /* renamed from: a */
    private boolean m12061a() {
        CarOrder order = CarOrderHelper.getOrder();
        boolean isFromOpenRide = FormStore.getInstance().isFromOpenRide();
        boolean z = order != null && order.isSplitFareUser();
        if (!(order != null && order.showUpdatePickUpPop) || isFromOpenRide || z) {
            return false;
        }
        return true;
    }

    public View getView() {
        return this.f14566b;
    }

    public void setPresenter(OnServiceUpdateAddressPresenter onServiceUpdateAddressPresenter) {
        this.f14567c = onServiceUpdateAddressPresenter;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.global_confirm_update_address_change_tv) {
            GlobalOmegaUtils.trackEvent("gp_changeFromAddress_edit_ck");
            m12062b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12062b() {
        if (this.f14567c != null) {
            m12065e();
            this.f14567c.onChangeClick();
        }
    }

    public void updateChangeVisible() {
        m12063c();
    }

    public void setChangeVisible(int i) {
        TextView textView = this.f14569e;
        if (textView != null && this.f14570f != null) {
            textView.setVisibility(i);
            this.f14570f.setVisibility(i);
        }
    }

    public void setViewVisible(int i) {
        if (this.f14566b != null) {
            updateAddress();
            this.f14566b.setVisibility(i);
        }
    }

    /* renamed from: c */
    private void m12063c() {
        if (m12061a()) {
            setChangeVisible(0);
            m12064d();
            return;
        }
        setChangeVisible(8);
        m12065e();
    }

    /* renamed from: d */
    private void m12064d() {
        if (OnServiceGuideUtil.INSTANCE.isShowEditGuideOnService(this.f14565a)) {
            m12065e();
            return;
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.OnService.EVENT_SHOW_EDIT_GUIDE, true);
        LEGOBubble createBubble = LEGOUICreator.createBubble(this.f14566b.getContext(), ResourcesHelper.getString(this.f14565a, R.string.GR_Pick_and_OnTrip_2020_PUP_change_eduBubble), Color.parseColor("#5C6166"), "top_right", 3, false, (BubbleCloseListener) null);
        this.f14571g.removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        View view = createBubble.getView();
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OnServiceUpdateAddressView.this.m12062b();
            }
        });
        this.f14571g.addView(view, layoutParams);
        OnServiceGuideUtil.INSTANCE.setShowEditGuideOnService(this.f14565a, true);
    }

    /* renamed from: e */
    private void m12065e() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.OnService.EVENT_SHOW_EDIT_GUIDE, false);
        this.f14571g.removeAllViews();
    }
}
