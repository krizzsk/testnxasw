package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierThirdChannelViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.didi.global.fintech.cashier.model.net.response.PaymentGroup;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierThirdChannelViewHolder;
import com.didi.global.fintech.cashier.p118ui.viewholder.item.ChannelItemViewHolderData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierThirdChannelViewBinder;", "Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierThirdChannelViewHolder;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierThirdChannelViewBinder;", "presenter", "spread", "", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;Z)V", "data", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "onMethodClick", "", "d", "onSpreadClick", "removeAllMethodSelect", "setupView", "updateList", "validate", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierThirdChannelViewBinder.kt */
public final class GlobalCashierThirdChannelViewBinder extends GlobalCashierBaseViewBinder<IGlobalCashierThirdChannelViewHolder, IGlobalMainCashierPresenter, PayInfoResponse> implements IGlobalCashierThirdChannelViewBinder {

    /* renamed from: a */
    private boolean f23395a;

    /* renamed from: b */
    private final List<ChannelItemViewHolderData> f23396b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalCashierThirdChannelViewBinder(IGlobalMainCashierPresenter iGlobalMainCashierPresenter, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iGlobalMainCashierPresenter, (i & 2) != 0 ? false : z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierThirdChannelViewBinder(IGlobalMainCashierPresenter iGlobalMainCashierPresenter, boolean z) {
        super(iGlobalMainCashierPresenter);
        Intrinsics.checkNotNullParameter(iGlobalMainCashierPresenter, "presenter");
        this.f23395a = z;
        this.f23396b = new ArrayList();
    }

    public void onMethodClick(ChannelItemViewHolderData channelItemViewHolderData) {
        Intrinsics.checkNotNullParameter(channelItemViewHolderData, "d");
        ((IGlobalMainCashierPresenter) getPresenter()).onPayChannelClick(channelItemViewHolderData);
    }

    public void setupView(PayInfoResponse payInfoResponse) {
        List<PaymentGroup> paymentGroups;
        Object obj;
        super.setupView(payInfoResponse);
        if (payInfoResponse != null && (paymentGroups = payInfoResponse.getPaymentGroups()) != null) {
            Iterator it = paymentGroups.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((PaymentGroup) obj).getType(), (Object) "2")) {
                    break;
                }
            }
            PaymentGroup paymentGroup = (PaymentGroup) obj;
            if (paymentGroup != null) {
                this.f23396b.clear();
                List<Payment> payments = paymentGroup.getPayments();
                if (payments != null) {
                    for (Payment groupType : payments) {
                        groupType.setGroupType("2");
                    }
                }
                List<R> parseDataList = ViewBinderDataParser.Companion.parseDataList(paymentGroup.getPayments(), new GlobalCashierThirdChannelViewBinder$setupView$2$2(ViewBinderDataParser.Companion));
                if (parseDataList != null) {
                    this.f23396b.addAll(parseDataList);
                }
                m19184a();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.didi.global.fintech.cashier.model.net.response.PaymentGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.didi.global.fintech.cashier.model.net.response.PaymentGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.didi.global.fintech.cashier.model.net.response.PaymentGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.didi.global.fintech.cashier.model.net.response.PaymentGroup} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.didi.global.fintech.cashier.model.net.response.PaymentGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean validate(com.didi.global.fintech.cashier.model.net.response.PayInfoResponse r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            goto L_0x002d
        L_0x0004:
            java.util.List r5 = r5.getPaymentGroups()
            if (r5 != 0) goto L_0x000b
            goto L_0x002d
        L_0x000b:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0011:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x002b
            java.lang.Object r1 = r5.next()
            r2 = r1
            com.didi.global.fintech.cashier.model.net.response.PaymentGroup r2 = (com.didi.global.fintech.cashier.model.net.response.PaymentGroup) r2
            java.lang.String r2 = r2.getType()
            java.lang.String r3 = "2"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0011
            r0 = r1
        L_0x002b:
            com.didi.global.fintech.cashier.model.net.response.PaymentGroup r0 = (com.didi.global.fintech.cashier.model.net.response.PaymentGroup) r0
        L_0x002d:
            if (r0 == 0) goto L_0x0031
            r5 = 1
            goto L_0x0032
        L_0x0031:
            r5 = 0
        L_0x0032:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierThirdChannelViewBinder.validate(com.didi.global.fintech.cashier.model.net.response.PayInfoResponse):boolean");
    }

    public void removeAllMethodSelect() {
        for (ChannelItemViewHolderData selected : this.f23396b) {
            selected.setSelected(false);
        }
        m19184a();
    }

    /* renamed from: a */
    private final void m19184a() {
        if (this.f23396b.size() == 2) {
            IGlobalCashierThirdChannelViewHolder iGlobalCashierThirdChannelViewHolder = (IGlobalCashierThirdChannelViewHolder) getViewHolder();
            if (iGlobalCashierThirdChannelViewHolder != null) {
                iGlobalCashierThirdChannelViewHolder.updateItems(this.f23396b, new GlobalCashierThirdChannelViewBinder$updateList$1(this));
            }
        } else if (this.f23395a || this.f23396b.size() <= 2) {
            IGlobalCashierThirdChannelViewHolder iGlobalCashierThirdChannelViewHolder2 = (IGlobalCashierThirdChannelViewHolder) getViewHolder();
            if (iGlobalCashierThirdChannelViewHolder2 != null) {
                iGlobalCashierThirdChannelViewHolder2.removeSpreadItem();
            }
            IGlobalCashierThirdChannelViewHolder iGlobalCashierThirdChannelViewHolder3 = (IGlobalCashierThirdChannelViewHolder) getViewHolder();
            if (iGlobalCashierThirdChannelViewHolder3 != null) {
                iGlobalCashierThirdChannelViewHolder3.updateItems(this.f23396b, new GlobalCashierThirdChannelViewBinder$updateList$4(this));
            }
        } else {
            IGlobalCashierThirdChannelViewHolder iGlobalCashierThirdChannelViewHolder4 = (IGlobalCashierThirdChannelViewHolder) getViewHolder();
            if (iGlobalCashierThirdChannelViewHolder4 != null) {
                iGlobalCashierThirdChannelViewHolder4.updateItems(this.f23396b.subList(0, 2), new GlobalCashierThirdChannelViewBinder$updateList$2(this));
            }
            IGlobalCashierThirdChannelViewHolder iGlobalCashierThirdChannelViewHolder5 = (IGlobalCashierThirdChannelViewHolder) getViewHolder();
            if (iGlobalCashierThirdChannelViewHolder5 != null) {
                iGlobalCashierThirdChannelViewHolder5.appendSpreadItem((String) null, new GlobalCashierThirdChannelViewBinder$updateList$3(this));
            }
        }
    }

    public void onSpreadClick(ChannelItemViewHolderData channelItemViewHolderData) {
        boolean z = this.f23395a;
        if (!z) {
            this.f23395a = !z;
            m19184a();
            ((IGlobalMainCashierPresenter) getPresenter()).omegaThirdUnfoldCk();
        }
    }
}
