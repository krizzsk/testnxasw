package com.didi.soda.address.util;

import com.didi.soda.address.util.AddressAnimHelper;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didi/soda/address/util/AddressAnimHelper$onAddressDownPin$1$1", "Lcom/didi/soda/address/util/AddressAnimHelper$AnimListener;", "onAnimEnd", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AddressAnimHelper.kt */
public final class AddressAnimHelper$onAddressDownPin$1$1 implements AddressAnimHelper.AnimListener {
    final /* synthetic */ AddressAnimHelper this$0;

    AddressAnimHelper$onAddressDownPin$1$1(AddressAnimHelper addressAnimHelper) {
        this.this$0 = addressAnimHelper;
    }

    public void onAnimEnd() {
        AddressAnimHelper addressAnimHelper = this.this$0;
        addressAnimHelper.m31167a(addressAnimHelper.getPinView(), this.this$0.getGonaGone());
        AddressAnimHelper addressAnimHelper2 = this.this$0;
        addressAnimHelper2.m31167a(addressAnimHelper2.getBarView(), this.this$0.getGonaVisible());
    }
}
