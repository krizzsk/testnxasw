package com.wallet.flutter.wallet_flutter.function;

import androidx.lifecycle.Observer;
import com.didi.drouter.api.DRouter;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo148868d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, mo148869k = 3, mo148870mv = {1, 5, 1})
/* compiled from: LiveData.kt */
public final class FlutterToTopUpCreateOrder$createOrder$$inlined$observe$2<T> implements Observer<T> {
    final /* synthetic */ FlutterToTopUpCreateOrder this$0;

    public FlutterToTopUpCreateOrder$createOrder$$inlined$observe$2(FlutterToTopUpCreateOrder flutterToTopUpCreateOrder) {
        this.this$0 = flutterToTopUpCreateOrder;
    }

    public final void onChanged(T t) {
        DRouter.build((String) t).start();
        this.this$0.getActivity().finish();
    }
}
