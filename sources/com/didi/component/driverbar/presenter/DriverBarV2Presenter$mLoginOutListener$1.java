package com.didi.component.driverbar.presenter;

import android.view.ViewGroup;
import com.didi.unifylogin.listener.LoginListeners;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DriverBarV2Presenter.kt */
final class DriverBarV2Presenter$mLoginOutListener$1 implements LoginListeners.LoginOutListener {
    final /* synthetic */ DriverBarV2Presenter this$0;

    DriverBarV2Presenter$mLoginOutListener$1(DriverBarV2Presenter driverBarV2Presenter) {
        this.this$0 = driverBarV2Presenter;
    }

    public final void onSuccess() {
        if (this.this$0.f14850e != null) {
            ViewGroup access$getMContainer$p = this.this$0.f14851f;
            if (access$getMContainer$p != null) {
                access$getMContainer$p.removeView(this.this$0.f14850e);
            }
            this.this$0.f14850e = null;
        }
    }
}
