package com.didi.soda.bill.component.tipfee;

import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.tipfee.Contract;
import com.didi.soda.bill.model.datamodel.BillTipModel;
import com.didi.soda.bill.view.item.tipfee.BillTipsFeeListItemAdapter;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/soda/bill/component/tipfee/BillTipsFeeEditPresenter;", "Lcom/didi/soda/bill/component/tipfee/Contract$AbsTipsFeeEditPresenter;", "()V", "TAG", "", "mBillTipFeeModel", "Lcom/didi/soda/bill/model/datamodel/BillTipModel;", "mCartId", "mCurrency", "mOrderPrice", "", "mSelectedFee", "", "mShopId", "confirmTipsFeeInput", "", "tipsFeeStr", "getBillTipFeeModel", "handleBillTipsFeeData", "onCreate", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BillTipsFeeEditPresenter.kt */
public final class BillTipsFeeEditPresenter extends Contract.AbsTipsFeeEditPresenter {

    /* renamed from: a */
    private final String f41687a = "BillTipsFeeEditPresenter";

    /* renamed from: b */
    private BillTipModel f41688b;

    /* renamed from: c */
    private String f41689c = "";

    /* renamed from: d */
    private int f41690d;

    /* renamed from: e */
    private long f41691e;

    /* renamed from: f */
    private String f41692f;

    /* renamed from: g */
    private String f41693g;

    public BillTipsFeeEditPresenter() {
        Long l = BillTipsFeeListItemAdapter.FLAG_OF_OTHER_ITEM_VALUE;
        Intrinsics.checkNotNullExpressionValue(l, "FLAG_OF_OTHER_ITEM_VALUE");
        this.f41691e = l.longValue();
    }

    public BillTipModel getBillTipFeeModel() {
        return this.f41688b;
    }

    public void confirmTipsFeeInput(String str) {
        Intrinsics.checkNotNullParameter(str, "tipsFeeStr");
        BillTipModel billTipModel = this.f41688b;
        if (billTipModel != null) {
            long parseLong = str.length() == 0 ? 0 : Long.parseLong(str);
            if (!billTipModel.isPercent()) {
                parseLong *= (long) 100;
            }
            billTipModel.setTipFeeValue(parseLong);
            BillOmegaHelper.Companion.traceBillTipsFeeCK(this.f41693g, this.f41692f, true, billTipModel.getTipFeeValue(), billTipModel.getTipFeeType());
            ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(billTipModel.convertToEntity());
            getScopeContext().getNavigator().finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m31349a();
    }

    /* renamed from: a */
    private final void m31349a() {
        String str = "";
        try {
            Serializable serializable = getScopeContext().getBundle().getSerializable(Const.PageParams.KEY_BILL_TIP_FEE_MODEL);
            if (serializable != null) {
                this.f41688b = serializable instanceof BillTipModel ? (BillTipModel) serializable : null;
            }
            String string = getScopeContext().getBundle().getString(Const.PageParams.KEY_BILL_TIP_FEE_CURRENCY, str);
            if (string == null) {
                string = str;
            }
            this.f41689c = string;
            Object obj = getScopeContext().getBundle().get("price");
            if (obj != null) {
                this.f41690d = ((Integer) obj).intValue();
                Object obj2 = getScopeContext().getBundle().get(Const.PageParams.KEY_BILL_TIP_FEE_SELECTED_FEE);
                if (obj2 != null) {
                    this.f41691e = ((Long) obj2).longValue();
                    String string2 = getScopeContext().getBundle().getString(Const.PageParams.CART_ID, str);
                    if (string2 == null) {
                        string2 = str;
                    }
                    this.f41693g = string2;
                    String string3 = getScopeContext().getBundle().getString(Const.PageParams.SHOP_ID, str);
                    if (string3 != null) {
                        str = string3;
                    }
                    this.f41692f = str;
                    ((Contract.AbsTipsFeeEditView) getLogicView()).bindTipsFeeData(this.f41688b, this.f41691e, this.f41689c);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        } catch (Exception e) {
            LogUtil.m32588i(this.f41687a, e.getLocalizedMessage());
        }
    }
}
