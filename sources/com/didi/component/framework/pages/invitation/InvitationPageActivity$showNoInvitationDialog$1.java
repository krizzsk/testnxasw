package com.didi.component.framework.pages.invitation;

import android.view.View;
import com.didi.component.framework.pages.invitation.helper.INoInvite;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo148868d2 = {"com/didi/component/framework/pages/invitation/InvitationPageActivity$showNoInvitationDialog$1", "Lcom/didi/sdk/view/dialog/AlertDialogFragment$OnClickListener;", "onClick", "", "p0", "Lcom/didi/sdk/view/dialog/AlertDialogFragment;", "p1", "Landroid/view/View;", "framework_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: InvitationPageActivity.kt */
public final class InvitationPageActivity$showNoInvitationDialog$1 implements AlertDialogFragment.OnClickListener {
    final /* synthetic */ INoInvite $listener;

    InvitationPageActivity$showNoInvitationDialog$1(INoInvite iNoInvite) {
        this.$listener = iNoInvite;
    }

    public void onClick(AlertDialogFragment alertDialogFragment, View view) {
        INoInvite iNoInvite = this.$listener;
        if (iNoInvite != null) {
            iNoInvite.confirm(alertDialogFragment, view);
        }
    }
}
