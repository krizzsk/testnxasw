package com.didiglobal.pay.paysecure.prepaidcard;

import android.app.Dialog;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo148868d2 = {"<anonymous>", "", "run", "com/didiglobal/pay/paysecure/prepaidcard/CommonPwdDialog$onViewCreated$4$onInputDone$2$onSuccess$2$1"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.CommonPwdDialog$onViewCreated$4$onInputDone$2$onSuccess$$inlined$let$lambda$1 */
/* compiled from: CommonPwdDialog.kt */
final class C17777xd513e6b7 implements Runnable {
    final /* synthetic */ BottomDialog $dialog$inlined;
    final /* synthetic */ CommonPwdDialog$onViewCreated$4$onInputDone$2 this$0;

    C17777xd513e6b7(CommonPwdDialog$onViewCreated$4$onInputDone$2 commonPwdDialog$onViewCreated$4$onInputDone$2, BottomDialog bottomDialog) {
        this.this$0 = commonPwdDialog$onViewCreated$4$onInputDone$2;
        this.$dialog$inlined = bottomDialog;
    }

    public final void run() {
        Dialog dialog = this.$dialog$inlined.getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
    }
}
