package com.didi.soda.order.component.receipt;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.binder.model.CustomerDividerLineRvModel;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.OrderReceiptInfoEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.order.binder.receipt.OrderReceiptInputLogicRepo;
import com.didi.soda.order.component.receipt.Contract;
import com.didi.soda.order.model.OrderReceiptHeaderRvModel;
import com.didi.soda.order.model.OrderReceiptInputRvModel;
import com.taxis99.R;
import java.util.ArrayList;

/* renamed from: com.didi.soda.order.component.receipt.a */
/* compiled from: OrderReceiptPresenter */
class C14897a extends Contract.AbsOrderReceiptPresenter {

    /* renamed from: a */
    private static final String f46007a = "OrderDetailPresenter";

    /* renamed from: b */
    private String f46008b = "";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f46009c = "";

    /* renamed from: d */
    private int f46010d = 0;

    /* renamed from: e */
    private OrderReceiptInfoEntity f46011e;

    /* renamed from: f */
    private ChildDataListManager<RecyclerModel> f46012f;

    /* renamed from: g */
    private boolean f46013g;

    /* renamed from: h */
    private String f46014h;

    /* renamed from: i */
    private ComponentLogicUnit f46015i;

    C14897a() {
    }

    public void onCreate() {
        super.onCreate();
        m34160d();
        m34159c();
    }

    public ComponentLogicUnit provideComponentLogicUnit() {
        if (this.f46015i == null) {
            this.f46015i = new OrderReceiptPresenter$1(this);
        }
        return this.f46015i;
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f46012f == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f46012f = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
    }

    /* access modifiers changed from: package-private */
    public void onConformClicked() {
        if (this.f46013g) {
            m34158b();
        } else {
            m34152a();
        }
    }

    /* access modifiers changed from: package-private */
    public void goBack() {
        ((Contract.AbsOrderReceiptView) getLogicView()).hideSoftInput();
        getScopeContext().getNavigator().finish();
    }

    /* renamed from: a */
    private void m34152a() {
        ((Contract.AbsOrderReceiptView) getLogicView()).showLoading();
        CustomerRpcManagerProxy.get().saveReceiptInfo(this.f46014h, this.f46009c, new OrderReceiptPresenter$2(this));
    }

    /* renamed from: b */
    private void m34158b() {
        ((Contract.AbsOrderReceiptView) getLogicView()).showLoading();
        CustomerRpcManagerProxy.get().sendReceipt(this.f46008b, this.f46009c, this.f46014h, new OrderReceiptPresenter$3(this));
    }

    /* renamed from: c */
    private void m34159c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new OrderReceiptHeaderRvModel());
        arrayList.add(OrderReceiptInputRvModel.newInstance(this.f46011e, this.f46013g));
        arrayList.add(m34164h());
        this.f46012f.set(arrayList);
        this.f46014h = this.f46011e.receiptUp;
        this.f46009c = this.f46011e.email;
        ((Contract.AbsOrderReceiptView) getLogicView()).updateViewStyle(this.f46013g);
        m34165i();
    }

    /* renamed from: d */
    private void m34160d() {
        Bundle bundle = getScopeContext().getBundle();
        this.f46008b = bundle.getString("orderid");
        this.f46010d = bundle.getInt(Const.PageParams.ORDER_RECEIPT_STATE);
        boolean z = true;
        if (bundle.getInt(Const.PageParams.RECEIPT_PAGE_TYPE) != 1) {
            z = false;
        }
        this.f46013g = z;
        this.f46011e = (OrderReceiptInfoEntity) bundle.getSerializable(Const.PageParams.RECEIPT_ENTITIES);
        m34161e();
    }

    /* renamed from: e */
    private void m34161e() {
        OmegaTracker.Builder.create(EventConst.Order.ORDER_SEND_RECEIPT_SW).addEventParam("order_id", this.f46008b).addEventParam(ParamConst.PARAM_RECEIPT_STATUS, Integer.valueOf(this.f46010d)).build().track();
    }

    /* renamed from: f */
    private void m34162f() {
        OmegaTracker.Builder.create(EventConst.Order.ORDER_SEND_RECEIPT_CK).addEventParam("order_id", this.f46008b).addEventParam(ParamConst.PARAM_RECEIPT_STATUS, Integer.valueOf(this.f46010d)).build().track();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m34163g() {
        OmegaTracker.Builder.create(EventConst.Order.ORDER_SEND_RECEIPT_SUCCESS_SW).addEventParam("order_id", this.f46008b).build().track();
    }

    /* renamed from: h */
    private CustomerDividerLineRvModel m34164h() {
        return new CustomerDividerLineRvModel(DisplayUtils.dip2px(getContext(), 100.0f), 0, 0, getContext().getResources().getColor(R.color.rf_color_white_100_FFFFFF));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34153a(OrderReceiptInputLogicRepo.ReceiptInputLogicModel receiptInputLogicModel) {
        if (receiptInputLogicModel != null) {
            if (receiptInputLogicModel.logicType == 0) {
                LoginUtil.go2ModifyEmail(getContext(), new OrderReceiptPresenter$4(this));
            } else if (receiptInputLogicModel.logicType == 1) {
                this.f46014h = receiptInputLogicModel.receiptName != null ? receiptInputLogicModel.receiptName.toString() : "";
                m34165i();
            }
        }
    }

    /* renamed from: i */
    private void m34165i() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f46014h);
        boolean z3 = this.f46011e.status == 1;
        if (!z2 || !z3) {
            z = false;
        }
        ((Contract.AbsOrderReceiptView) getLogicView()).updateConfirmButtonState(z, new View.OnClickListener(z, z2, z3) {
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ boolean f$2;
            public final /* synthetic */ boolean f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onClick(View view) {
                C14897a.this.m34156a(this.f$1, this.f$2, this.f$3, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34156a(boolean z, boolean z2, boolean z3, View view) {
        if (z) {
            onConformClicked();
        } else {
            ((OrderReceiptInputLogicRepo) getComponentLogicUnit().getLogic(OrderReceiptInputLogicRepo.class)).setValue(OrderReceiptInputLogicRepo.ReceiptInputLogicModel.newValidStateChangedModel(z2, z3));
        }
    }
}
