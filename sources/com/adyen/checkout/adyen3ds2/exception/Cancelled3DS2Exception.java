package com.adyen.checkout.adyen3ds2.exception;

import com.adyen.checkout.core.exception.ComponentException;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, mo148868d2 = {"Lcom/adyen/checkout/adyen3ds2/exception/Cancelled3DS2Exception;", "Lcom/adyen/checkout/core/exception/ComponentException;", "errorMessage", "", "(Ljava/lang/String;)V", "Companion", "3ds2_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Cancelled3DS2Exception.kt */
public final class Cancelled3DS2Exception extends ComponentException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 3858008275644429050L;

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/adyen/checkout/adyen3ds2/exception/Cancelled3DS2Exception$Companion;", "", "()V", "serialVersionUID", "", "3ds2_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: Cancelled3DS2Exception.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Cancelled3DS2Exception(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, ParamConst.PARAM_ERROR_MESSAGE);
    }
}
