package com.didi.component.framework.pages.invitation.fragment;

import android.view.View;
import com.didi.component.framework.pages.invitation.helper.InvitationItemClickedListener;
import com.didi.component.framework.pages.invitation.presenter.InvitationContactsPresenter;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo148868d2 = {"com/didi/component/framework/pages/invitation/fragment/InvitationContactsFragment$initRecView$1", "Lcom/didi/component/framework/pages/invitation/helper/InvitationItemClickedListener;", "onClicked", "", "view", "Landroid/view/View;", "phoneNum", "", "framework_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: InvitationContactsFragment.kt */
public final class InvitationContactsFragment$initRecView$1 implements InvitationItemClickedListener {
    final /* synthetic */ InvitationContactsFragment this$0;

    InvitationContactsFragment$initRecView$1(InvitationContactsFragment invitationContactsFragment) {
        this.this$0 = invitationContactsFragment;
    }

    public void onClicked(View view, String str) {
        InvitationContactsPresenter access$getMPresenter$p = this.this$0.f15649c;
        if (access$getMPresenter$p != null) {
            access$getMPresenter$p.checkContactIsOrInvite(new InvitationContactsFragment$initRecView$1$onClicked$1(this.this$0, str), CollectionsKt.listOf(str));
        }
    }
}
