package com.didi.soda.home.topgun.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.tips.RFTips;
import com.didi.soda.address.manager.AddressTipInfo;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LocalPermissionHelper;
import com.didi.soda.home.topgun.manager.HomeLogTrackerHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import java.util.HashMap;

public class HomeAddressTipView extends LinearLayout {

    /* renamed from: a */
    private RFTips f45585a;

    public HomeAddressTipView(Context context) {
        super(context);
        m33865b();
    }

    public HomeAddressTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33865b();
    }

    public HomeAddressTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33865b();
    }

    public HomeAddressTipView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m33865b();
    }

    public void updateAddressTip(ScopeContext scopeContext, AddressTipInfo addressTipInfo) {
        removeAllViews();
        if (addressTipInfo != null && !TextUtils.isEmpty(addressTipInfo.mTip)) {
            String str = addressTipInfo.mTip;
            m33864a(scopeContext, str, addressTipInfo.mTipType);
            AddressOmegaHelper.cachePoiTipSw(addressTipInfo.mTipType, m33867c(), CustomerSystemUtil.isGpsEnabled(getContext()));
            HashMap hashMap = new HashMap();
            hashMap.put("tips", str);
            HomeLogTrackerHelper.setLogTracker("updateAddressTips", "c-data|", hashMap);
        }
    }

    public void setScrollProgress(float f, float f2) {
        RFTips rFTips = this.f45585a;
        if (rFTips != null) {
            float f3 = 0.0f;
            if (f > 0.0f) {
                rFTips.stopShake();
            } else {
                rFTips.startShake();
            }
            float f4 = 1.0f - f;
            setAlpha(f4);
            setPivotX((float) (DisplayUtils.getScreenWidth(getContext()) / 2));
            float dip2px = (float) (DisplayUtils.dip2px(getContext(), 40.0f) + CustomerSystemUtil.getStatusBarHeight(getContext()));
            if (GlobalContext.isEmbed()) {
                f3 = getResources().getDimension(R.dimen.customer_topgun_home_embed_address_offset);
            }
            setPivotY(dip2px + f3);
            setScaleX(f4);
            setScaleY(f4);
            setTranslationY(f2);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        this.f45585a = null;
    }

    /* renamed from: a */
    private void m33862a() {
        this.f45585a.setArrowLocation(1);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f45585a.getLayoutParams();
        layoutParams.gravity = 3;
        layoutParams.leftMargin = DisplayUtils.dip2px(getContext(), 15.0f);
        this.f45585a.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private void m33864a(ScopeContext scopeContext, String str, int i) {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_home_topgun_tip_view, this, true);
        this.f45585a = (RFTips) findViewById(R.id.customer_custom_address_tips);
        findViewById(R.id.customer_custom_tips_top_margin).setVisibility(GlobalContext.isEmbed() ? 0 : 8);
        if (!GlobalContext.isEmbed()) {
            m33862a();
        }
        if (!TextUtils.isEmpty(str)) {
            this.f45585a.setText((CharSequence) str);
            this.f45585a.setIcon((int) R.drawable.customer_pic_location);
            this.f45585a.setVisibility(0);
        } else {
            this.f45585a.setVisibility(8);
        }
        this.f45585a.setOnCloseListener(new View.OnClickListener(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeAddressTipView.this.m33866b(this.f$1, view);
            }
        });
        this.f45585a.setOnClickListener(new View.OnClickListener(i) {
            public final /* synthetic */ int f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(View view) {
                HomeAddressTipView.m33863a(this.f$0, view);
            }
        });
        setScrollProgress(0.0f, 0.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m33866b(int i, View view) {
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).clearAddressTip();
        AddressOmegaHelper.cachePoiTipCloseCk(i, 1, m33867c(), CustomerSystemUtil.isGpsEnabled(getContext()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m33863a(int i, View view) {
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).clearAddressTip();
        DiRouter.request().path(RoutePath.ADDRESS_HOME).putInt("from", 3).open();
        AddressOmegaHelper.cachePoiTipCk(i);
        HomeLogTrackerHelper.setLogTracker("onAddressTipClick", "c-act|");
    }

    /* renamed from: b */
    private void m33865b() {
        setOrientation(1);
    }

    /* renamed from: c */
    private boolean m33867c() {
        return LocalPermissionHelper.checkoutPermission((Activity) GlobalContext.getContext(), LocalPermissionHelper.LOCATION_PERMISSIONS);
    }
}
