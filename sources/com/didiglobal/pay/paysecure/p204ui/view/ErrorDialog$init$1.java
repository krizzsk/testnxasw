package com.didiglobal.pay.paysecure.p204ui.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.view.ErrorDialog$init$1 */
/* compiled from: ErrorDialog.kt */
final class ErrorDialog$init$1 implements View.OnClickListener {
    final /* synthetic */ ErrorDialog this$0;

    ErrorDialog$init$1(ErrorDialog errorDialog) {
        this.this$0 = errorDialog;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.this$0.dismiss();
        ErrorDialogCallback access$getListener$p = this.this$0.f52974f;
        if (access$getListener$p != null) {
            access$getListener$p.onCloseDialog(this.this$0);
        }
    }
}
