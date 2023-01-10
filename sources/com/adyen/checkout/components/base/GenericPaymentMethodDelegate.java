package com.adyen.checkout.components.base;

import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo148868d2 = {"Lcom/adyen/checkout/components/base/GenericPaymentMethodDelegate;", "Lcom/adyen/checkout/components/base/PaymentMethodDelegate;", "paymentMethod", "Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;", "(Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;)V", "getPaymentMethod", "()Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;", "getPaymentMethodType", "", "components-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GenericPaymentMethodDelegate.kt */
public final class GenericPaymentMethodDelegate implements PaymentMethodDelegate {

    /* renamed from: a */
    private final PaymentMethod f658a;

    public GenericPaymentMethodDelegate(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        this.f658a = paymentMethod;
    }

    public final PaymentMethod getPaymentMethod() {
        return this.f658a;
    }

    public String getPaymentMethodType() {
        String type = this.f658a.getType();
        return type == null ? "unknown" : type;
    }
}
