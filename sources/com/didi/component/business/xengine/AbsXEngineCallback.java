package com.didi.component.business.xengine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u00020\u00072\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004R,\u0010\u0003\u001a\u0014\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0001\u0002\u000e\u000f¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/component/business/xengine/AbsXEngineCallback;", "", "()V", "onErrorAction", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "getOnErrorAction$common_release", "()Lkotlin/jvm/functions/Function1;", "setOnErrorAction$common_release", "(Lkotlin/jvm/functions/Function1;)V", "onFail", "action", "Lcom/didi/component/business/xengine/XELogicCallbackSupplier;", "Lcom/didi/component/business/xengine/XEngineUiCallbackSupplier;", "common_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: XEngineRegister.kt */
public abstract class AbsXEngineCallback {

    /* renamed from: a */
    private Function1<? super Exception, Unit> f13242a;

    public /* synthetic */ AbsXEngineCallback(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AbsXEngineCallback() {
    }

    public final Function1<Exception, Unit> getOnErrorAction$common_release() {
        return this.f13242a;
    }

    public final void setOnErrorAction$common_release(Function1<? super Exception, Unit> function1) {
        this.f13242a = function1;
    }

    public final void onFail(Function1<? super Exception, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.f13242a = function1;
    }
}
