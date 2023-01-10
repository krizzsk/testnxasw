package com.didi.component.framework.pages.invitation.fragment;

import com.didi.component.framework.pages.invitation.helper.CustomPagerSnapHelper;
import com.didi.component.framework.pages.invitation.helper.TrackEvent;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didi/component/framework/pages/invitation/fragment/InvitationPageFragment$initRecyclerView$1", "Lcom/didi/component/framework/pages/invitation/helper/CustomPagerSnapHelper$TrackEventListener;", "trackEvent", "", "framework_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: InvitationPageFragment.kt */
public final class InvitationPageFragment$initRecyclerView$1 implements CustomPagerSnapHelper.TrackEventListener {
    final /* synthetic */ InvitationPageFragment this$0;

    InvitationPageFragment$initRecyclerView$1(InvitationPageFragment invitationPageFragment) {
        this.this$0 = invitationPageFragment;
    }

    public void trackEvent() {
        InvitationPageFragment invitationPageFragment = this.this$0;
        InvitationPageFragment.m13003a(invitationPageFragment, TrackEvent.REFERHOME_CARD_CK, (Integer) null, invitationPageFragment.f15694k, 2, (Object) null);
    }
}
