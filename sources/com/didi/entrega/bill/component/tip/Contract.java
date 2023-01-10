package com.didi.entrega.bill.component.tip;

import android.os.Bundle;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.entrega.bill.model.BillTipModel;
import com.didi.entrega.bill.widgets.tip.EditTipItemView;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/entrega/bill/component/tip/Contract;", "", "AbsBillTipPresenter", "AbsBillTipView", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, mo148868d2 = {"Lcom/didi/entrega/bill/component/tip/Contract$AbsBillTipView;", "Lcom/didi/app/nova/skeleton/mvp/IView;", "Lcom/didi/entrega/bill/component/tip/Contract$AbsBillTipPresenter;", "Lcom/didi/entrega/bill/widgets/tip/EditTipItemView$BillTipEditCallback;", "()V", "initData", "", "model", "Lcom/didi/entrega/bill/model/BillTipModel;", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsBillTipView extends IView<AbsBillTipPresenter> implements EditTipItemView.BillTipEditCallback {
        public abstract void initData(BillTipModel billTipModel);
    }

    @Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0014\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, mo148868d2 = {"Lcom/didi/entrega/bill/component/tip/Contract$AbsBillTipPresenter;", "Lcom/didi/app/nova/skeleton/mvp/IPresenter;", "Lcom/didi/entrega/bill/component/tip/Contract$AbsBillTipView;", "()V", "calculatePrice", "", "tipFee", "confirmTip", "", "isManual", "", "finish", "bundle", "Landroid/os/Bundle;", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsBillTipPresenter extends IPresenter<AbsBillTipView> {
        public abstract long calculatePrice(long j);

        public abstract void confirmTip(long j, boolean z);

        public abstract void finish(Bundle bundle);

        public static /* synthetic */ void finish$default(AbsBillTipPresenter absBillTipPresenter, Bundle bundle, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    bundle = null;
                }
                absBillTipPresenter.finish(bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finish");
        }
    }
}
