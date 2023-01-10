package com.didi.entrega.info.component.send;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.info.model.HistoryModel;
import com.didi.entrega.info.repo.HistoryListRepo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/entrega/info/component/send/SendContactUpdatePresenter$subscrib$2", "Lcom/didi/app/nova/skeleton/repo/Action1;", "", "call", "", "t", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SendContactUpdatePresenter.kt */
public final class SendContactUpdatePresenter$subscrib$2 implements Action1<String> {
    final /* synthetic */ SendContactUpdatePresenter this$0;

    SendContactUpdatePresenter$subscrib$2(SendContactUpdatePresenter sendContactUpdatePresenter) {
        this.this$0 = sendContactUpdatePresenter;
    }

    public void call(String str) {
        ArrayList<HistoryModel> historySendContactList;
        if (Intrinsics.areEqual((Object) str, (Object) HistoryListRepo.Companion.getDELETE())) {
            if (this.this$0.getHistoryListRepo().getHistorySendContactList() != null) {
                SendContactUpdatePresenter sendContactUpdatePresenter = this.this$0;
                sendContactUpdatePresenter.randerHistoryListAfterChange(sendContactUpdatePresenter.getHistoryListRepo().getHistorySendContactList());
            } else {
                return;
            }
        }
        String tag = this.this$0.getTAG();
        StringBuilder sb = new StringBuilder();
        sb.append("历史联系人监听,模式：");
        sb.append(str);
        sb.append(",size:");
        HistoryListRepo historyListRepo = this.this$0.getHistoryListRepo();
        int i = 0;
        if (!(historyListRepo == null || (historySendContactList = historyListRepo.getHistorySendContactList()) == null)) {
            i = historySendContactList.size();
        }
        sb.append(i);
        LogUtil.m18185i(tag, sb.toString());
    }
}
