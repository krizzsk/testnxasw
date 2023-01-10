package com.didi.soda.address.edit.component;

import com.didi.soda.address.util.AddressAnimHelper;
import com.didi.soda.order.view.AddressCardRecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: EditAddressInfoView.kt */
final class EditAddressInfoView$dragDownAddress$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ EditAddressInfoView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditAddressInfoView$dragDownAddress$2(EditAddressInfoView editAddressInfoView) {
        super(0);
        this.this$0 = editAddressInfoView;
    }

    public final void invoke() {
        AddressCardRecyclerView access$getRecyclerView$p = this.this$0.f41462c;
        if (access$getRecyclerView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            access$getRecyclerView$p = null;
        }
        access$getRecyclerView$p.setmIsMapExpend(this.this$0.f41472m);
        AddressAnimHelper access$getAddressAnimHelper$p = this.this$0.f41470k;
        if (access$getAddressAnimHelper$p != null) {
            final EditAddressInfoView editAddressInfoView = this.this$0;
            access$getAddressAnimHelper$p.onAddressDragDownPin(new AddressAnimHelper.AnimListener() {
                public void onAnimEnd() {
                    EditAddressInfoView editAddressInfoView = editAddressInfoView;
                    editAddressInfoView.m31114a(editAddressInfoView.m31133d());
                }
            });
        }
    }
}
