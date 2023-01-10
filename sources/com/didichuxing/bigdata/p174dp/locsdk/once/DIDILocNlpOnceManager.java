package com.didichuxing.bigdata.p174dp.locsdk.once;

import android.content.Context;
import com.didi.mapbizinterface.MapBizInterface;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.biz.BizManager;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDILocNlpOnceManager */
public class DIDILocNlpOnceManager {

    /* renamed from: a */
    private static volatile DIDILocNlpOnceManager f48723a;

    /* renamed from: b */
    private static Context f48724b;

    private DIDILocNlpOnceManager(Context context) {
        f48724b = context.getApplicationContext();
        BizManager.getIntance().init(context);
        MapBizInterface.getInstance().init(context);
        SystemUtil.init(context.getApplicationContext());
        DLog.m36225d("DIDILocationManager single instance constructed!!");
    }

    public static DIDILocNlpOnceManager getInstance(Context context) {
        if (context == null) {
            return null;
        }
        f48724b = context.getApplicationContext();
        if (f48723a == null) {
            synchronized (DIDILocNlpOnceManager.class) {
                if (f48723a == null) {
                    f48723a = new DIDILocNlpOnceManager(f48724b);
                }
            }
        }
        return f48723a;
    }

    public int requestLocationUpdateOnce(DIDILocationListener dIDILocationListener, DIDILocationUpdateOnceParam dIDILocationUpdateOnceParam, int i) {
        if (i == 3) {
            return new SpliteDIDINLPOnceRequester(f48724b).request(dIDILocationListener, dIDILocationUpdateOnceParam);
        }
        return -1;
    }
}
