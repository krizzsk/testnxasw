package com.didi.soda.address.edit.component;

import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.soda.address.util.AddressAnimHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/soda/address/edit/component/EditAddressInfoView$cameraListener$1", "Lcom/didi/common/map/listener/OnCameraChangeListener;", "onCameraChange", "", "p0", "Lcom/didi/common/map/model/CameraPosition;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: EditAddressInfoView.kt */
public final class EditAddressInfoView$cameraListener$1 implements OnCameraChangeListener {
    final /* synthetic */ EditAddressInfoView this$0;

    EditAddressInfoView$cameraListener$1(EditAddressInfoView editAddressInfoView) {
        this.this$0 = editAddressInfoView;
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        if (this.this$0.f41481v && this.this$0.f41472m) {
            LogUtil.m32584d("map", Intrinsics.stringPlus("onCameraChange isMapStable:", Boolean.valueOf(this.this$0.f41480u)));
            if (this.this$0.f41480u) {
                this.this$0.f41480u = false;
                AddressAnimHelper access$getAddressAnimHelper$p = this.this$0.f41470k;
                if (access$getAddressAnimHelper$p != null) {
                    access$getAddressAnimHelper$p.onDragStartPin();
                }
            }
        }
    }
}
