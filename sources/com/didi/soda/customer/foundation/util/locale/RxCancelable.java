package com.didi.soda.customer.foundation.util.locale;

import com.didi.app.nova.skeleton.tools.Cancelable;
import p218io.reactivex.disposables.Disposable;

public class RxCancelable implements Cancelable {

    /* renamed from: a */
    private Disposable f43863a;

    public RxCancelable(Disposable disposable) {
        this.f43863a = disposable;
    }

    public void cancel() {
        Disposable disposable = this.f43863a;
        if (disposable != null && !disposable.isDisposed()) {
            this.f43863a.dispose();
        }
    }
}
