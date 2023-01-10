package com.didi.sdk.p161sa;

import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/sdk/sa/SaManager$request$1", "Lcom/didi/sdk/map/ILocation$ILocationChangedListener;", "onLocationChanged", "", "location", "Lcom/didichuxing/bigdata/dp/locsdk/DIDILocation;", "TheOneSDKGlobal_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.sdk.sa.SaManager$request$1 */
/* compiled from: SaManager.kt */
public final class SaManager$request$1 implements ILocation.ILocationChangedListener {
    SaManager$request$1() {
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        if (dIDILocation != null) {
            SaManager.INSTANCE.m29997b();
            LocationPerformer.getInstance().removeLocationListener(this);
        }
    }
}
