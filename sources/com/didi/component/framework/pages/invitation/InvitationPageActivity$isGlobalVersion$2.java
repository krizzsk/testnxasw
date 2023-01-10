package com.didi.component.framework.pages.invitation;

import com.didi.sdk.util.AppUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: InvitationPageActivity.kt */
final class InvitationPageActivity$isGlobalVersion$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ InvitationPageActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InvitationPageActivity$isGlobalVersion$2(InvitationPageActivity invitationPageActivity) {
        super(0);
        this.this$0 = invitationPageActivity;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(AppUtils.isGlobalApp(this.this$0));
    }
}
