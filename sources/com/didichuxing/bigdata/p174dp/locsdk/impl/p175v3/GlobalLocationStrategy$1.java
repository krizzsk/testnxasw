package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.locator.IFLPLocationListener;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.GlobalLocationStrategy$1 */
class GlobalLocationStrategy$1 implements IFLPLocationListener {
    final /* synthetic */ C15952b this$0;

    GlobalLocationStrategy$1(C15952b bVar) {
        this.this$0 = bVar;
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        if (this.this$0.f48588f != null) {
            LocNTPHelper.adjustLocTimestampWhenDispatch(dIDILocation);
            this.this$0.f48588f.onLocationUpdate(dIDILocation, 0);
        }
    }
}
