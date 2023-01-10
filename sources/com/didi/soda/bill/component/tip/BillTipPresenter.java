package com.didi.soda.bill.component.tip;

import android.os.Bundle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.tip.Contract;
import com.didi.soda.bill.model.datamodel.BillTipModel;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/soda/bill/component/tip/BillTipPresenter;", "Lcom/didi/soda/bill/component/tip/Contract$AbsBillTipPresenter;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "billTipModel", "Lcom/didi/soda/bill/model/datamodel/BillTipModel;", "cartId", "", "currency", "orderPrice", "", "shopId", "calculatePrice", "", "tipFee", "confirmTip", "", "isManual", "", "finish", "bundle", "Landroid/os/Bundle;", "getPercentPayFee", "percent", "onCreate", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BillTipPresenter.kt */
public final class BillTipPresenter extends Contract.AbsBillTipPresenter implements IRFFloatingExpand {

    /* renamed from: a */
    private BillTipModel f41672a;

    /* renamed from: b */
    private int f41673b;

    /* renamed from: c */
    private String f41674c;

    /* renamed from: d */
    private String f41675d;

    /* renamed from: e */
    private String f41676e;

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

    public void finish(Bundle bundle) {
        if (bundle == null) {
            dismiss(getScopeContext());
        } else {
            dismiss(getScopeContext(), bundle);
        }
    }

    public long calculatePrice(long j) {
        BillTipModel billTipModel = this.f41672a;
        if (billTipModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billTipModel");
            billTipModel = null;
        }
        return billTipModel.isPercent() ? m31339a(this.f41673b, j) : j;
    }

    public void confirmTip(long j, boolean z) {
        long j2;
        BillTipModel billTipModel = this.f41672a;
        if (billTipModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billTipModel");
            billTipModel = null;
        }
        billTipModel.setTipFeeValue(j);
        BillTipModel billTipModel2 = this.f41672a;
        if (billTipModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billTipModel");
            billTipModel2 = null;
        }
        BillTipModel billTipModel3 = this.f41672a;
        if (billTipModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billTipModel");
            billTipModel3 = null;
        }
        if (billTipModel3.isPercent()) {
            j2 = m31339a(this.f41673b, j);
        } else {
            BillTipModel billTipModel4 = this.f41672a;
            if (billTipModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("billTipModel");
                billTipModel4 = null;
            }
            j2 = billTipModel4.getTipFeeValue();
        }
        billTipModel2.setTipPayValue(j2);
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String str = this.f41675d;
        String str2 = this.f41676e;
        BillTipModel billTipModel5 = this.f41672a;
        if (billTipModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billTipModel");
            billTipModel5 = null;
        }
        companion.traceBillTipsFeeCK(str, str2, z, j, billTipModel5.getTipFeeType());
        ICustomerBillManager iCustomerBillManager = (ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class);
        BillTipModel billTipModel6 = this.f41672a;
        if (billTipModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billTipModel");
            billTipModel6 = null;
        }
        iCustomerBillManager.dispatchChange(billTipModel6.convertToEntity());
        finish((Bundle) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        Object obj = getScopeContext().getBundle().get("tip_info");
        if (obj != null) {
            this.f41672a = (BillTipModel) obj;
            Object obj2 = getScopeContext().getBundle().get("price");
            if (obj2 != null) {
                this.f41673b = ((Integer) obj2).intValue();
                this.f41674c = (String) getScopeContext().getBundle().get("currency");
                this.f41675d = (String) getScopeContext().getBundle().get("cart_id");
                this.f41676e = (String) getScopeContext().getBundle().get("shop_id");
                Contract.AbsBillTipView absBillTipView = (Contract.AbsBillTipView) getLogicView();
                BillTipModel billTipModel = this.f41672a;
                if (billTipModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("billTipModel");
                    billTipModel = null;
                }
                absBillTipView.initData(billTipModel);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.bill.model.datamodel.BillTipModel");
    }

    /* renamed from: a */
    private final long m31339a(int i, long j) {
        return Math.round((((double) i) * ((double) j)) / ((double) 100));
    }
}
