package com.didi.entrega.info.component.receive;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.entrega.info.binder.HistoryItemBinder;
import com.didi.entrega.info.component.ContactConstract;
import com.didi.entrega.info.model.HistoryModel;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo148868d2 = {"com/didi/entrega/info/component/receive/ReceiveContactView$initItemBinders$2$1", "Lcom/didi/entrega/info/binder/HistoryItemBinder$HistoryClickListener;", "onClickDelete", "", "item", "Lcom/didi/entrega/info/model/HistoryModel;", "onClickItem", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ReceiveContactView.kt */
public final class ReceiveContactView$initItemBinders$2$1 implements HistoryItemBinder.HistoryClickListener {
    final /* synthetic */ ReceiveContactView this$0;

    ReceiveContactView$initItemBinders$2$1(ReceiveContactView receiveContactView) {
        this.this$0 = receiveContactView;
    }

    public void onClickDelete(HistoryModel historyModel) {
        IPresenter presenter = this.this$0.getPresenter();
        if (presenter != null) {
            ((ContactConstract.AbsEditContactPresenter) presenter).onHistoryItemDeleteClick(historyModel);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.entrega.info.component.ContactConstract.AbsEditContactPresenter");
    }

    public void onClickItem(HistoryModel historyModel) {
        IPresenter presenter = this.this$0.getPresenter();
        if (presenter != null) {
            ((ContactConstract.AbsEditContactPresenter) presenter).onHistoryItemClick(historyModel);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.entrega.info.component.ContactConstract.AbsEditContactPresenter");
    }
}
