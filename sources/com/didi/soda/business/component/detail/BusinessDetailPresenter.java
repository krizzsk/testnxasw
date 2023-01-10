package com.didi.soda.business.component.detail;

import android.os.Bundle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.soda.business.component.detail.Contract;
import com.didi.soda.business.manager.BusinessOmegaHelper;
import com.didi.soda.business.manager.BusinessOmegaModel;
import com.didi.soda.business.model.BusinessDetailModel;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import com.didi.soda.router.DiRouter;

public class BusinessDetailPresenter extends Contract.AbsBusinessDetailPresenter implements IRFFloatingExpand {

    /* renamed from: a */
    private BusinessInfoEntity f42100a;

    /* renamed from: b */
    private BusinessOmegaHelper f42101b;

    /* renamed from: c */
    private BusinessOmegaModel f42102c;

    /* renamed from: d */
    private BusinessDetailModel f42103d;

    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    public void openBusinessPositionMapPage() {
        BusinessOmegaHelper businessOmegaHelper = this.f42101b;
        if (businessOmegaHelper != null) {
            businessOmegaHelper.onDetailAddressClick();
        }
        DiRouter.request().path(RoutePath.BUSINESS_ADDRESS_MAP).putString(Const.PageParams.SHOP_ADDRESS, this.f42103d.mBusinessAddress).putString(Const.PageParams.SHOP_NAME, this.f42103d.mBusinessName).putParcelable(Const.PageParams.SHOP_ADDRESS_LAT_LNG, this.f42103d.mBusinessLatLng).open();
    }

    public void openBusinessDisclaimerPage(String str) {
        BusinessOmegaHelper businessOmegaHelper = this.f42101b;
        if (businessOmegaHelper != null) {
            businessOmegaHelper.onDetailRuleClick(1);
        }
        SchemeHelper.dispatchMsg(str);
    }

    public void onPageClose() {
        dismiss(getScopeContext());
    }

    public void openCouponExclusivePage(RuleDescEntity ruleDescEntity) {
        DiRouter.request().path("priceRuleDescPage").putParcelable("entity", ruleDescEntity).putInt("from", 1).putString(Const.PageParams.SHOP_ID, this.f42100a.shopId).open();
        this.f42101b.onCouponReduceCk();
    }

    public void onCouponReduceShow() {
        this.f42101b.onCouponReduceShow();
    }

    public void onBuyAgentClick() {
        this.f42101b.onDetailRuleClick(2);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m31547a();
        m31548b();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        BusinessOmegaModel businessOmegaModel;
        super.onResume();
        BusinessOmegaHelper businessOmegaHelper = this.f42101b;
        if (businessOmegaHelper != null && (businessOmegaModel = this.f42102c) != null) {
            businessOmegaHelper.onDetailShow(businessOmegaModel.mDistance, this.f42102c.mDeliveryFee, this.f42102c.mDeliveryTime, this.f42102c.mDeliveryType, this.f42102c.mRecId);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BusinessOmegaHelper businessOmegaHelper = this.f42101b;
        if (businessOmegaHelper != null) {
            businessOmegaHelper.onDetailExit();
        }
    }

    /* renamed from: a */
    private void m31547a() {
        Bundle bundle = getScopeContext().getBundle();
        this.f42100a = (BusinessInfoEntity) bundle.getSerializable(Const.PageParams.SHOP_INFO_ENTITY);
        this.f42102c = (BusinessOmegaModel) bundle.getSerializable(Const.PageParams.SHOP_OMEGA_MODEL);
        if (this.f42100a != null) {
            this.f42101b = new BusinessOmegaHelper(getScopeContext(), this.f42100a.shopId, this.f42100a.cShopStatus);
        }
    }

    /* renamed from: b */
    private void m31548b() {
        BusinessInfoEntity businessInfoEntity = this.f42100a;
        if (businessInfoEntity != null) {
            this.f42103d = BusinessDetailModel.newInstance(businessInfoEntity);
            ((Contract.AbsBusinessDetailView) getLogicView()).updateBusinessDetail(this.f42103d);
        }
    }
}
