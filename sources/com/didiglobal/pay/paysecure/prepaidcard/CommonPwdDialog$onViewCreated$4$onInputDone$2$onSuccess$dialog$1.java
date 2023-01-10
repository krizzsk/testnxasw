package com.didiglobal.pay.paysecure.prepaidcard;

import android.app.Dialog;
import com.didiglobal.pay.paysecure.prepaidcard.BottomDialog;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didiglobal/pay/paysecure/prepaidcard/CommonPwdDialog$onViewCreated$4$onInputDone$2$onSuccess$dialog$1", "Lcom/didiglobal/pay/paysecure/prepaidcard/BottomDialog$IClickListener;", "onClick", "", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: CommonPwdDialog.kt */
public final class CommonPwdDialog$onViewCreated$4$onInputDone$2$onSuccess$dialog$1 implements BottomDialog.IClickListener {
    final /* synthetic */ CommonPwdDialog$onViewCreated$4$onInputDone$2 this$0;

    CommonPwdDialog$onViewCreated$4$onInputDone$2$onSuccess$dialog$1(CommonPwdDialog$onViewCreated$4$onInputDone$2 commonPwdDialog$onViewCreated$4$onInputDone$2) {
        this.this$0 = commonPwdDialog$onViewCreated$4$onInputDone$2;
    }

    public void onClick() {
        Dialog dialog = this.this$0.this$0.this$0.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
        TrackerManager.Companion.trackInputCardPwdLimitClick();
    }
}
