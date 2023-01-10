package com.didi.soda.address.edit.component;

import com.didi.soda.address.edit.component.Contract;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.map.listener.MapGestureListener;
import com.didi.soda.customer.widget.map.SodaMapView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/soda/address/edit/component/EditAddressInfoView$gesListener$1", "Lcom/didi/soda/customer/map/listener/MapGestureListener;", "onDown", "", "v", "", "v1", "onMapStable", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: EditAddressInfoView.kt */
public final class EditAddressInfoView$gesListener$1 extends MapGestureListener {
    final /* synthetic */ EditAddressInfoView this$0;

    EditAddressInfoView$gesListener$1(EditAddressInfoView editAddressInfoView) {
        this.this$0 = editAddressInfoView;
    }

    public boolean onDown(float f, float f2) {
        this.this$0.f41481v = true;
        LogUtil.m32584d("map", Intrinsics.stringPlus("onDown isMapStable:", Boolean.valueOf(this.this$0.f41480u)));
        return super.onDown(f, f2);
    }

    public void onMapStable() {
        SodaMapView access$getSodaMapView$p = this.this$0.f41460a;
        if (access$getSodaMapView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            access$getSodaMapView$p = null;
        }
        access$getSodaMapView$p.setMapGestureEnable(true);
        if (this.this$0.f41481v) {
            this.this$0.f41481v = false;
            ((Contract.AbsEditAddressInfoPresent) this.this$0.getPresenter()).freshAddressTipStatus(true);
            this.this$0.f41480u = true;
            if (this.this$0.f41473n != null && this.this$0.f41475p != null && this.this$0.f41470k != null) {
                AddressOmegaHelper.traceLocationMapMove();
                if (!this.this$0.f41472m) {
                    this.this$0.f41472m = true;
                    EditAddressInfoView editAddressInfoView = this.this$0;
                    editAddressInfoView.m31130c(editAddressInfoView.m31133d());
                    AddressOmegaHelper.traceLocationSw(1);
                    return;
                }
                EditAddressInfoView editAddressInfoView2 = this.this$0;
                editAddressInfoView2.m31114a(editAddressInfoView2.m31133d());
            }
        }
    }
}
