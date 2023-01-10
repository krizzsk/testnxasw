package com.didi.sdk.p155ms.p156ad;

import android.content.Context;
import com.didi.sdk.p155ms.common.type.IMSType;

/* renamed from: com.didi.sdk.ms.ad.IAdOperation */
public interface IAdOperation extends IMSType {
    String getAdvertisingId(Context context);

    boolean isLimitAdTrackingEnabled(Context context) throws Exception;
}
