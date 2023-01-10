package com.didi.soda.address.component.feed;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.address.component.feed.binder.DeliveryAddressRvModel;

class AddressFeedMessagePresenter$2 implements Action1<DeliveryAddressRvModel> {
    final /* synthetic */ C14191a this$0;

    AddressFeedMessagePresenter$2(C14191a aVar) {
        this.this$0 = aVar;
    }

    public void call(DeliveryAddressRvModel deliveryAddressRvModel) {
        int indexOf = this.this$0.f41382e.indexOf(deliveryAddressRvModel);
        if (indexOf >= 0 && indexOf < this.this$0.f41382e.size()) {
            this.this$0.f41382e.set(indexOf, deliveryAddressRvModel);
        }
    }
}
