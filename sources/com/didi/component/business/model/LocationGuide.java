package com.didi.component.business.model;

import android.content.Context;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.Utils;

public class LocationGuide {
    public static final int APP_TYPE = 2;
    public static final int DEFAULT_TYPE = 0;
    public static final int SYSTEM_TYPE = 1;

    /* renamed from: a */
    private static Context f13159a = DIDIBaseApplication.getAppContext();
    public String guideContent;
    public int type = 0;

    private LocationGuide(String str, int i) {
        this.guideContent = str;
        this.type = i;
    }

    public static LocationGuide parseLocation() {
        boolean isLocationSwitchOff = DIDILocationManager.getInstance(f13159a).isLocationSwitchOff();
        int i = !Utils.isLocationPermissionGranted(f13159a) ? 2 : 0;
        if (isLocationSwitchOff) {
            i = 1;
        }
        return new LocationGuide(GlobalApolloUtil.getLocationServiceDisabledCP(f13159a), i);
    }
}
