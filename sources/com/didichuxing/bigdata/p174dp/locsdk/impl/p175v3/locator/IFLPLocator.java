package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.locator;

import android.content.Context;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.locator.IFLPLocator */
public interface IFLPLocator {
    void destroy();

    DIDILocation getFLPLocation();

    void init(Context context, long j);

    void setLocationListener(IFLPLocationListener iFLPLocationListener);
}
