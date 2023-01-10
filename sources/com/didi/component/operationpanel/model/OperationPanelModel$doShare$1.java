package com.didi.component.operationpanel.model;

import com.didi.component.business.sharetrip.CommonTripShareManager;
import kotlin.Metadata;
import p218io.reactivex.functions.Action;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OperationPanelModel.kt */
final class OperationPanelModel$doShare$1 implements Action {
    final /* synthetic */ OperationPanelModel this$0;

    OperationPanelModel$doShare$1(OperationPanelModel operationPanelModel) {
        this.this$0 = operationPanelModel;
    }

    public final void run() {
        CommonTripShareManager access$get_shareManager$p = this.this$0.f16683e;
        if (access$get_shareManager$p != null) {
            access$get_shareManager$p.disMissOneKeyShareDialog();
        }
    }
}
