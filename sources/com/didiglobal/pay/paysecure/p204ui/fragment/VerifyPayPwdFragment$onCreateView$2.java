package com.didiglobal.pay.paysecure.p204ui.fragment;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didiglobal.pay.paysecure.base.PaySecureState;
import com.didiglobal.pay.paysecure.omega.OmegaUtil;
import com.didiglobal.pay.paysecure.util.UiUtils;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment$onCreateView$2 */
/* compiled from: VerifyPayPwdFragment.kt */
final class VerifyPayPwdFragment$onCreateView$2 implements View.OnClickListener {
    final /* synthetic */ VerifyPayPwdFragment this$0;

    VerifyPayPwdFragment$onCreateView$2(VerifyPayPwdFragment verifyPayPwdFragment) {
        this.this$0 = verifyPayPwdFragment;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        OmegaUtil.Companion.trackEvent("ibt_password_forgot_password_ck");
        this.this$0.getMessenger().setScene("FORGET");
        this.this$0.getMessenger().setSceneType(3);
        UiUtils.INSTANCE.hideKeyboard(this.this$0.getContext(), VerifyPayPwdFragment.access$getMRootView$p(this.this$0));
        this.this$0.transform(PaySecureState.STATE_FORGOT_PWD);
    }
}
