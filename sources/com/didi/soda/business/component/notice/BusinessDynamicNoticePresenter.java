package com.didi.soda.business.component.notice;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.soda.business.component.notice.Contract;
import com.didi.soda.business.manager.BusinessOmegaHelper;
import com.didi.soda.business.manager.BusinessRepo;
import com.didi.soda.customer.foundation.rpc.entity.BusinessEntity;
import com.didi.soda.customer.repo.CustomerResource;

public class BusinessDynamicNoticePresenter extends Contract.IDynamicNoticePresenter {

    /* renamed from: a */
    private BusinessOmegaHelper f42270a;

    /* renamed from: b */
    private String f42271b;

    /* renamed from: c */
    private int f42272c;

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        BusinessRepo.get(getScopeContext()).subscribe(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                BusinessDynamicNoticePresenter.this.m31774a((CustomerResource) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31774a(CustomerResource customerResource) {
        if (customerResource == null || customerResource.status != Resource.Status.SUCCESS || customerResource.data == null || ((BusinessEntity) customerResource.data).alertInfo == null || TextUtils.isEmpty(((BusinessEntity) customerResource.data).alertInfo.content)) {
            ((Contract.IDynamicNoticeView) getLogicView()).updateView((String) null);
            return;
        }
        ((Contract.IDynamicNoticeView) getLogicView()).updateView(((BusinessEntity) customerResource.data).alertInfo.content);
        this.f42271b = ((BusinessEntity) customerResource.data).shopInfo.shopId;
        this.f42272c = ((BusinessEntity) customerResource.data).shopInfo.cShopStatus;
        if (((BusinessEntity) customerResource.data).shopInfo.isDeliveryPriceAdjusted == 1) {
            m31773a().onDemandMessageShow(2);
        } else {
            m31773a().onDemandMessageShow(1);
        }
    }

    /* renamed from: a */
    private BusinessOmegaHelper m31773a() {
        if (this.f42270a == null) {
            this.f42270a = new BusinessOmegaHelper(getScopeContext(), this.f42271b, this.f42272c);
        }
        return this.f42270a;
    }
}
