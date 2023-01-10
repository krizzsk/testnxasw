package com.didiglobal.pay.paysecure.prepaidcard;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&¨\u0006\u000b"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/IPasswordCallback;", "", "onFail", "", "index", "", "msg", "", "onSuccess", "callback", "Lkotlin/Function0;", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: CardPwdManagerFragment.kt */
public interface IPasswordCallback {
    void onFail(int i, String str);

    void onSuccess(int i, Function0<Unit> function0);

    @Metadata(mo148866bv = {1, 0, 3}, mo148869k = 3, mo148870mv = {1, 1, 16})
    /* compiled from: CardPwdManagerFragment.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onSuccess$default(IPasswordCallback iPasswordCallback, int i, Function0 function0, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    function0 = IPasswordCallback$onSuccess$1.INSTANCE;
                }
                iPasswordCallback.onSuccess(i, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
        }
    }
}
