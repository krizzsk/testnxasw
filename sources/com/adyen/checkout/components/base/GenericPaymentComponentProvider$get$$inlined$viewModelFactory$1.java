package com.adyen.checkout.components.base;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b¸\u0006\u0000"}, mo148868d2 = {"com/adyen/checkout/components/base/lifecycle/ViewModelExtKt$viewModelFactory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "components-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ViewModelExt.kt */
public final class GenericPaymentComponentProvider$get$$inlined$viewModelFactory$1 implements ViewModelProvider.Factory {
    final /* synthetic */ Configuration $configuration$inlined;
    final /* synthetic */ PaymentMethod $paymentMethod$inlined;
    final /* synthetic */ GenericPaymentComponentProvider this$0;

    public GenericPaymentComponentProvider$get$$inlined$viewModelFactory$1(GenericPaymentComponentProvider genericPaymentComponentProvider, Configuration configuration, PaymentMethod paymentMethod) {
        this.this$0 = genericPaymentComponentProvider;
        this.$configuration$inlined = configuration;
        this.$paymentMethod$inlined = paymentMethod;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return (ViewModel) ((BasePaymentComponent) this.this$0.f657a.getConstructor(new Class[]{GenericPaymentMethodDelegate.class, this.$configuration$inlined.getClass()}).newInstance(new Object[]{new GenericPaymentMethodDelegate(this.$paymentMethod$inlined), this.$configuration$inlined}));
    }
}
