package com.didi.component.driverbar.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.core.IViewContainer;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.driverbar.AbsDriverBarPresenter;
import com.didi.component.driverbar.IDriverBarView;
import com.didi.component.driverbar.model.DriverBarCardInfo;
import com.didi.component.driverbar.model.DriverBarStyle;
import com.didi.component.driverbar.model.DriverBarV2Model;
import com.didi.component.driverbar.util.DriverBarInfoUtilsKt;
import com.didi.component.driverbar.view.DriverBarWaitingJapanStyleView;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.sdk.app.DIDIApplication;
import com.didiglobal.travel.infra.content.ContextKt;
import com.didiglobal.travel.util.Preconditions;
import com.didiglobal.travel.util.view.ViewEx;
import com.taxis99.R;

public class DriverBarV2View implements IViewContainer, IDriverBarView {

    /* renamed from: a */
    private static final int f14829a = 0;

    /* renamed from: b */
    private static final int f14830b = 1;

    /* renamed from: c */
    private static final int f14831c = 2;

    /* renamed from: d */
    private static final int f14832d = 1;

    /* renamed from: e */
    private static final int f14833e = 2;
    protected DriverBarFieldBase currentView;

    /* renamed from: f */
    private FrameLayout f14834f;

    /* renamed from: g */
    private FrameLayout f14835g;

    /* renamed from: h */
    private FrameLayout f14836h;

    /* renamed from: i */
    private DriverBarV2Model f14837i;

    /* renamed from: j */
    private boolean f14838j = false;

    /* renamed from: k */
    private boolean f14839k;

    /* renamed from: l */
    private int f14840l = -1;

    /* renamed from: m */
    private int f14841m = 0;
    protected View mContainerView;
    protected Context mContext;
    protected AbsDriverBarPresenter mPresenter;

    /* renamed from: n */
    private DriverBarCardInfo f14842n;

    /* renamed from: o */
    private DriverBarStyle f14843o = DriverBarStyle.DEFAULT_STYLE;

    public void showPhoneGuide(String str) {
    }

    public DriverBarV2View(Context context, ViewGroup viewGroup) {
        m12194a(context, viewGroup);
        this.mContext = context;
        this.f14834f = (FrameLayout) findView(R.id.driver_bar_near_container);
        this.f14835g = (FrameLayout) findView(R.id.driver_bar_far_container);
        this.f14836h = (FrameLayout) findView(R.id.driver_bar_on_service_container);
    }

    /* renamed from: a */
    private void m12194a(Context context, ViewGroup viewGroup) {
        this.mContainerView = ViewEx.inflateViewAsync(context, (int) R.layout.driver_bar_v2_view, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findView(int i) {
        return this.mContainerView.findViewById(i);
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mPresenter.setComponentCreator(iComponentCreator);
    }

    public void setData(DriverBarV2Model driverBarV2Model) {
        if (!this.f14839k) {
            this.currentView.setPresenter(this.mPresenter);
            this.f14837i = driverBarV2Model;
            boolean z = true;
            if (driverBarV2Model.switchNearEnable != 1) {
                z = false;
            }
            m12196a(z);
            m12197b();
            m12200c();
        }
    }

    public void setData(DriverBarCardInfo driverBarCardInfo) {
        this.f14839k = true;
        this.f14842n = driverBarCardInfo;
        this.f14837i = DriverBarInfoUtilsKt.toDriverBarV2Model(driverBarCardInfo);
        m12196a(driverBarCardInfo.isNearEnable());
        m12197b();
        this.currentView.setPresenter(this.mPresenter);
        m12200c();
    }

    /* renamed from: a */
    private void m12192a() {
        this.f14835g.removeAllViews();
        this.f14834f.removeAllViews();
        this.f14836h.removeAllViews();
        this.currentView = null;
    }

    public ViewGroup getContainer(int i) {
        DriverBarFieldBase driverBarFieldBase = this.currentView;
        if (Preconditions.nonNull(driverBarFieldBase)) {
            return driverBarFieldBase.getContainer(i);
        }
        return null;
    }

    public void setPhoneVisible(boolean z) {
        if (Preconditions.nonNull(this.currentView)) {
            this.currentView.setPhoneVisible(z);
        }
    }

    public boolean isPhoneVisible() {
        DriverBarFieldBase driverBarFieldBase = this.currentView;
        return Preconditions.nonNull(driverBarFieldBase) && driverBarFieldBase.isPhoneVisible();
    }

    public void setDriverBarStyle(DriverBarStyle driverBarStyle) {
        if (this.f14843o != driverBarStyle) {
            this.f14841m |= 1;
        }
        this.f14843o = driverBarStyle;
    }

    public void showCarUpdateInfo(String str, String str2, String str3, String str4) {
        if (Preconditions.nonNull(this.currentView)) {
            this.currentView.showCarUpdateInfo(str, str2, str3, str4);
        }
    }

    public void hideCarUpdateInfo() {
        if (Preconditions.nonNull(this.currentView)) {
            this.currentView.hideCarUpdateInfo();
        }
    }

    public void nearPickupShow(EtaEda etaEda) {
        if (!(this.f14837i == null || this.currentView == null)) {
            if (!m12202e()) {
                m12192a();
                DriverBarOnServiceView driverBarOnServiceView = new DriverBarOnServiceView(this.mContext, this.f14836h);
                driverBarOnServiceView.setData(this.f14837i);
                this.currentView = driverBarOnServiceView;
                this.f14836h.addView(driverBarOnServiceView.getView());
                this.mPresenter.buildInnerComponent(this.f14837i.imOption, this.f14837i.phoneOption, "small");
                this.currentView.setPresenter(this.mPresenter);
            } else if (this.f14838j) {
                showNearView();
            } else {
                this.currentView.nearPickupShow(etaEda);
            }
        }
        this.f14838j = true;
    }

    public void newMessageBubbleShow(boolean z) {
        if (Preconditions.nonNull(this.currentView)) {
            this.currentView.newMessageBubbleShow(z);
        }
    }

    public void handleBluetoothMeetEntranceShow(Boolean bool) {
        if (Preconditions.nonNull(this.currentView)) {
            this.currentView.handleBluetoothMeetEntranceShow(bool);
        }
    }

    public void hideBlueMeetGuide() {
        if (Preconditions.nonNull(this.currentView)) {
            this.currentView.hideBlueMeetGuide();
        }
    }

    public View getView() {
        return this.mContainerView;
    }

    public void setPresenter(AbsDriverBarPresenter absDriverBarPresenter) {
        this.mPresenter = absDriverBarPresenter;
    }

    /* renamed from: a */
    private void m12196a(boolean z) {
        boolean z2 = this.currentView == null;
        if (!m12201d()) {
            m12193a(0);
        } else if (this.f14843o != DriverBarStyle.DEFAULT_STYLE || !z || (!this.f14838j && (!m12203f() || !z2))) {
            m12193a(2);
        } else {
            m12193a(1);
        }
    }

    /* renamed from: b */
    private void m12197b() {
        m12192a();
        int i = this.f14840l;
        if (i == 0) {
            m12199b(this.f14842n, this.f14837i);
        } else if (i != 2) {
            showNearView();
        } else {
            m12195a(this.f14842n, this.f14837i);
        }
    }

    /* renamed from: c */
    private void m12200c() {
        m12198b(2);
        m12198b(1);
    }

    /* renamed from: d */
    private boolean m12201d() {
        int orderStatus = CarOrderHelper.getOrderStatus();
        if (orderStatus == 1 || orderStatus == 7) {
            return true;
        }
        if (orderStatus != 4 || !m12202e()) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    private boolean m12202e() {
        int orderSubStatus = CarOrderHelper.getOrderSubStatus();
        return orderSubStatus == 4002 || orderSubStatus == 4003 || orderSubStatus == 4004 || orderSubStatus == 4001 || orderSubStatus == 4007;
    }

    /* renamed from: f */
    private boolean m12203f() {
        int orderSubStatus = CarOrderHelper.getOrderSubStatus();
        return orderSubStatus >= 4003 && orderSubStatus < 4006;
    }

    public void showNearView() {
        m12192a();
        DriverBarNearFieldView driverBarNearFieldView = new DriverBarNearFieldView(this.mContext, this.f14834f);
        if (Preconditions.nonNull(this.f14842n)) {
            driverBarNearFieldView.setData(this.f14842n);
        }
        driverBarNearFieldView.setData(this.f14837i);
        this.currentView = driverBarNearFieldView;
        this.f14834f.addView(driverBarNearFieldView.getView());
        this.mPresenter.buildInnerComponent(this.f14837i.imOption, this.f14837i.phoneOption, "near");
        this.currentView.setPresenter(this.mPresenter);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_CONFIG_DEFAULT_SHOW_HEIGHT, 0);
        this.f14838j = true;
    }

    /* renamed from: a */
    private void m12195a(DriverBarCardInfo driverBarCardInfo, DriverBarV2Model driverBarV2Model) {
        DriverBarFieldBase driverBarFieldBase;
        if (this.f14843o == DriverBarStyle.JAPAN_STYLE) {
            driverBarFieldBase = new DriverBarWaitingJapanStyleView(this.mContext, this.f14835g);
        } else {
            driverBarFieldBase = new DriverBarFarFieldView(this.mContext, this.f14835g, this);
        }
        this.currentView = driverBarFieldBase;
        driverBarFieldBase.setData(driverBarCardInfo);
        driverBarFieldBase.setData(driverBarV2Model);
        this.f14835g.addView(driverBarFieldBase.getView());
        this.mPresenter.buildInnerComponent(driverBarCardInfo.getImOption(), driverBarCardInfo.getPhoneOption(), this.f14843o == DriverBarStyle.JAPAN_STYLE ? "small" : "far", m12191a(this.f14843o));
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_CONFIG_DEFAULT_SHOW_HEIGHT, 83);
    }

    /* renamed from: b */
    private void m12199b(DriverBarCardInfo driverBarCardInfo, DriverBarV2Model driverBarV2Model) {
        DriverBarOnServiceView driverBarOnServiceView = new DriverBarOnServiceView(this.mContext, this.f14835g);
        this.currentView = driverBarOnServiceView;
        driverBarOnServiceView.setData(driverBarCardInfo);
        driverBarOnServiceView.setData(driverBarV2Model);
        this.f14836h.addView(driverBarOnServiceView.getView());
        this.mPresenter.buildInnerComponent(driverBarCardInfo.getImOption(), driverBarCardInfo.getPhoneOption(), "small");
    }

    /* renamed from: a */
    private void m12193a(int i) {
        if (this.f14840l == i) {
            m12198b(2);
            return;
        }
        this.f14840l = i;
        this.f14841m |= 2;
    }

    /* renamed from: g */
    private boolean m12204g() {
        int i = this.f14841m;
        return (i & 1) == 1 || (i & 2) == 2;
    }

    /* renamed from: b */
    private void m12198b(int i) {
        int i2 = this.f14841m;
        if ((i2 & i) == i) {
            this.f14841m = i ^ i2;
        }
    }

    /* renamed from: a */
    private Bundle m12191a(DriverBarStyle driverBarStyle) {
        if (driverBarStyle != DriverBarStyle.JAPAN_STYLE) {
            return null;
        }
        Context appContext = Preconditions.nonNull(this.mContext) ? this.mContext : DIDIApplication.getAppContext();
        Bundle bundle = new Bundle();
        bundle.putBoolean("notify_message", true);
        bundle.putInt("message_anchor_view", R.id.civ_driver_avatar);
        bundle.putInt("message_bubble_tint_color", ContextKt.colorOf(appContext, R.color.global_driver_bar_im_message_bubble_jp_style));
        return bundle;
    }
}
