package com.didi.global.fintech.cashier.fastpay.presenter;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FastPaySettingPresenter.kt */
/* synthetic */ class FastPaySettingPresenter$onSwitchFastPayStatusSuccess$drawer$1 extends FunctionReferenceImpl implements Function2<String, List<? extends String>, Unit> {
    FastPaySettingPresenter$onSwitchFastPayStatusSuccess$drawer$1(Object obj) {
        super(2, obj, FastPaySettingPresenter.class, "onQuizBack", "onQuizBack(Ljava/lang/String;Ljava/util/List;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (List<String>) (List) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, List<String> list) {
        ((FastPaySettingPresenter) this.receiver).onQuizBack(str, list);
    }
}
