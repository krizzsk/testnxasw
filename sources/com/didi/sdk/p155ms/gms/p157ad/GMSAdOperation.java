package com.didi.sdk.p155ms.gms.p157ad;

import android.content.Context;
import com.didi.sdk.p155ms.common.utils.LogUtil;
import com.didi.sdk.p155ms.gms.common.GMSType;
import com.didi.sdk.p155ms.p156ad.IAdOperation;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

@ServiceProvider(alias = "GMS", value = {IAdOperation.class})
/* renamed from: com.didi.sdk.ms.gms.ad.GMSAdOperation */
public class GMSAdOperation extends GMSType implements IAdOperation {
    private static final String TAG = GMSAdOperation.class.getSimpleName();

    public String getAdvertisingId(Context context) {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(context.getApplicationContext()).getId();
        } catch (Exception e) {
            e.printStackTrace();
            String str = TAG;
            LogUtil.m29854e(str, "getAdvertisingId : exception = " + e);
            return "";
        }
    }

    public boolean isLimitAdTrackingEnabled(Context context) throws Exception {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(context.getApplicationContext()).isLimitAdTrackingEnabled();
        } catch (Exception e) {
            e.printStackTrace();
            String str = TAG;
            LogUtil.m29854e(str, "getAdvertisingId : exception = " + e);
            throw new Exception(e);
        }
    }
}
