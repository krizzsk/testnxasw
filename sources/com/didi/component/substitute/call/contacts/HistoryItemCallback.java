package com.didi.component.substitute.call.contacts;

import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, mo148868d2 = {"Lcom/didi/component/substitute/call/contacts/HistoryItemCallback;", "", "click", "", "data", "Lcom/didi/travel/psnger/model/response/estimate/daijiao/FriendItem;", "longClick", "", "comp-substitute-call_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HistoryItemCallback.kt */
public interface HistoryItemCallback {
    void click(FriendItem friendItem);

    boolean longClick(FriendItem friendItem);
}
