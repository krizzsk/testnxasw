package com.didi.beatles.p101im.views.eggs;

import com.didi.beatles.p101im.api.entity.IMConfig;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.views.eggs.fall.IMFallEggsDrop;

/* renamed from: com.didi.beatles.im.views.eggs.IMEggsDropFactory */
public final class IMEggsDropFactory {

    /* renamed from: a */
    private static final String f12041a = IMEggsDropFactory.class.getSimpleName();

    private IMEggsDropFactory() {
    }

    public static IIMEggsDrop create(IMConfig.EggsInfo eggsInfo) {
        if (eggsInfo.displayStyle == 0) {
            return IMFallEggsDrop.obtain();
        }
        IMLog.m10021e(f12041a, C4786I.m9980t("[drop] Invalid displayType -> ", Integer.valueOf(eggsInfo.displayStyle)));
        return null;
    }
}
