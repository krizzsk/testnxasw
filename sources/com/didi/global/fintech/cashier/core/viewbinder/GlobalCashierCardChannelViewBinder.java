package com.didi.global.fintech.cashier.core.viewbinder;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierCardChannelViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.core.datapraser.ViewBinderDataParser;
import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.didi.global.fintech.cashier.model.net.response.PaymentGroup;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierCardChannelViewHolder;
import com.didi.global.fintech.cashier.p118ui.viewholder.item.ChannelItemViewHolderData;
import com.didi.global.fintech.cashier.p118ui.viewholder.item.GlobalCashierBaseItemViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010\u0019\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierCardChannelViewBinder;", "Lcom/didi/global/fintech/cashier/core/viewbinder/GlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCardChannelViewHolder;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCardChannelViewBinder;", "presenter", "spread", "", "(Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;Z)V", "data", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "groupName", "", "getGroupName", "()Ljava/lang/String;", "setGroupName", "(Ljava/lang/String;)V", "onMethodClick", "", "d", "onSpreadClick", "removeAllMethodSelect", "setupView", "topMethod", "payment", "", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "updateList", "validate", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierCardChannelViewBinder.kt */
public final class GlobalCashierCardChannelViewBinder extends GlobalCashierBaseViewBinder<IGlobalCashierCardChannelViewHolder, IGlobalMainCashierPresenter, PayInfoResponse> implements IGlobalCashierCardChannelViewBinder {

    /* renamed from: a */
    private boolean f23392a;

    /* renamed from: b */
    private final List<ChannelItemViewHolderData> f23393b;

    /* renamed from: c */
    private String f23394c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalCashierCardChannelViewBinder(IGlobalMainCashierPresenter iGlobalMainCashierPresenter, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iGlobalMainCashierPresenter, (i & 2) != 0 ? false : z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierCardChannelViewBinder(IGlobalMainCashierPresenter iGlobalMainCashierPresenter, boolean z) {
        super(iGlobalMainCashierPresenter);
        Intrinsics.checkNotNullParameter(iGlobalMainCashierPresenter, "presenter");
        this.f23392a = z;
        this.f23393b = new ArrayList();
    }

    public final String getGroupName() {
        return this.f23394c;
    }

    public final void setGroupName(String str) {
        this.f23394c = str;
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
            java.lang.String r3 = "1"
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierCardChannelViewBinder.validate(com.didi.global.fintech.cashier.model.net.response.PayInfoResponse):boolean");
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
                if (Intrinsics.areEqual((Object) ((PaymentGroup) obj).getType(), (Object) "1")) {
                    break;
                }
            }
            PaymentGroup paymentGroup = (PaymentGroup) obj;
            if (paymentGroup != null) {
                setGroupName(paymentGroup.getName());
                IGlobalCashierCardChannelViewHolder iGlobalCashierCardChannelViewHolder = (IGlobalCashierCardChannelViewHolder) getViewHolder();
                if (iGlobalCashierCardChannelViewHolder != null) {
                    iGlobalCashierCardChannelViewHolder.updateHeader(paymentGroup.getName(), paymentGroup.getIcon(), paymentGroup.getIconType());
                }
                this.f23393b.clear();
                List<Payment> payments = paymentGroup.getPayments();
                if (payments != null) {
                    for (Payment groupType : payments) {
                        groupType.setGroupType("1");
                    }
                }
                List<R> parseDataList = ViewBinderDataParser.Companion.parseDataList(paymentGroup.getPayments(), new GlobalCashierCardChannelViewBinder$setupView$2$2(ViewBinderDataParser.Companion));
                if (parseDataList != null) {
                    for (R r : parseDataList) {
                        ChannelItemViewHolderData channelItemViewHolderData = r.getInstallment() != null ? r : null;
                        if (channelItemViewHolderData != null) {
                            channelItemViewHolderData.setOnPlansClick(new GlobalCashierCardChannelViewBinder$setupView$2$3$1$2$1(this, r));
                            channelItemViewHolderData.setOnInstallmentClick(new GlobalCashierCardChannelViewBinder$setupView$2$3$1$2$2(this, r));
                        }
                    }
                    this.f23393b.addAll(parseDataList);
                }
                m19183a();
            }
        }
    }

    public void topMethod(List<? extends BasicPayment> list) {
        int i;
        Intrinsics.checkNotNullParameter(list, "payment");
        Iterator it = this.f23393b.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            ChannelItemViewHolderData channelItemViewHolderData = (ChannelItemViewHolderData) it.next();
            Iterable<BasicPayment> iterable = list;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                i = 0;
                for (BasicPayment uniqueId : iterable) {
                    int uniqueId2 = uniqueId.uniqueId();
                    Integer uniqueId3 = channelItemViewHolderData.getUniqueId();
                    if ((uniqueId3 != null && uniqueId2 == uniqueId3.intValue()) && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            } else {
                i = 0;
            }
            if (i == 0) {
                z = false;
            }
            channelItemViewHolderData.setSelected(z);
        }
        List<ChannelItemViewHolderData> list2 = this.f23393b;
        if (list2.size() > 1) {
            CollectionsKt.sortWith(list2, new C9050x75414f47());
        }
        m19183a();
    }

    public void removeAllMethodSelect() {
        for (ChannelItemViewHolderData selected : this.f23393b) {
            selected.setSelected(false);
        }
        m19183a();
    }

    /* renamed from: a */
    private final void m19183a() {
        if (this.f23393b.size() == 4) {
            IGlobalCashierCardChannelViewHolder iGlobalCashierCardChannelViewHolder = (IGlobalCashierCardChannelViewHolder) getViewHolder();
            if (iGlobalCashierCardChannelViewHolder != null) {
                iGlobalCashierCardChannelViewHolder.updateItems(this.f23393b, new GlobalCashierCardChannelViewBinder$updateList$1(this));
            }
        } else if (this.f23392a || this.f23393b.size() <= 3) {
            IGlobalCashierCardChannelViewHolder iGlobalCashierCardChannelViewHolder2 = (IGlobalCashierCardChannelViewHolder) getViewHolder();
            if (iGlobalCashierCardChannelViewHolder2 != null) {
                iGlobalCashierCardChannelViewHolder2.removeSpreadItem();
            }
            IGlobalCashierCardChannelViewHolder iGlobalCashierCardChannelViewHolder3 = (IGlobalCashierCardChannelViewHolder) getViewHolder();
            if (iGlobalCashierCardChannelViewHolder3 != null) {
                iGlobalCashierCardChannelViewHolder3.updateItems(this.f23393b, new GlobalCashierCardChannelViewBinder$updateList$4(this));
            }
        } else {
            IGlobalCashierCardChannelViewHolder iGlobalCashierCardChannelViewHolder4 = (IGlobalCashierCardChannelViewHolder) getViewHolder();
            if (iGlobalCashierCardChannelViewHolder4 != null) {
                iGlobalCashierCardChannelViewHolder4.updateItems(this.f23393b.subList(0, 3), new GlobalCashierCardChannelViewBinder$updateList$2(this));
            }
            IGlobalCashierCardChannelViewHolder iGlobalCashierCardChannelViewHolder5 = (IGlobalCashierCardChannelViewHolder) getViewHolder();
            if (iGlobalCashierCardChannelViewHolder5 != null) {
                iGlobalCashierCardChannelViewHolder5.appendSpreadItem(this.f23394c, new GlobalCashierCardChannelViewBinder$updateList$3(this));
            }
        }
    }

    public void onMethodClick(ChannelItemViewHolderData channelItemViewHolderData) {
        Intrinsics.checkNotNullParameter(channelItemViewHolderData, "d");
        if (channelItemViewHolderData.getViewType() == GlobalCashierBaseItemViewHolder.ViewType.AddCard) {
            ((IGlobalMainCashierPresenter) getPresenter()).onBindCardClick();
        } else if (channelItemViewHolderData.getViewType() != GlobalCashierBaseItemViewHolder.ViewType.Balance || channelItemViewHolderData.getOperatorType() != ChannelItemViewHolderData.Operation.OPERATION_TOP_UP) {
            ((IGlobalMainCashierPresenter) getPresenter()).onPayChannelClick(channelItemViewHolderData);
        } else if (channelItemViewHolderData.signed()) {
            ((IGlobalMainCashierPresenter) getPresenter()).onGoTopUp();
        } else {
            ((IGlobalMainCashierPresenter) getPresenter()).onGoSignUp();
        }
    }

    public void onSpreadClick(ChannelItemViewHolderData channelItemViewHolderData) {
        boolean z = this.f23392a;
        if (!z) {
            this.f23392a = !z;
            m19183a();
            ((IGlobalMainCashierPresenter) getPresenter()).omega99PayUnfoldCk();
        }
    }
}
