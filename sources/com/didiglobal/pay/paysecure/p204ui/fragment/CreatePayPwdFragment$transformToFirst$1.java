package com.didiglobal.pay.paysecure.p204ui.fragment;

import com.didiglobal.pay.paysecure.util.UiUtils;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment$transformToFirst$1 */
/* compiled from: CreatePayPwdFragment.kt */
final class CreatePayPwdFragment$transformToFirst$1 implements Runnable {
    final /* synthetic */ CreatePayPwdFragment this$0;

    CreatePayPwdFragment$transformToFirst$1(CreatePayPwdFragment createPayPwdFragment) {
        this.this$0 = createPayPwdFragment;
    }

    public final void run() {
        UiUtils.INSTANCE.showKeyboard(this.this$0.getContext(), CreatePayPwdFragment.access$getMInputPwdView$p(this.this$0));
    }
}
