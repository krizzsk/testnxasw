package com.didi.beatles.p101im.plugin;

import com.didi.beatles.p101im.protocol.plugin.IMPluginService;
import com.didi.beatles.p101im.protocol.service.IMSpiServiceProvider;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;

/* renamed from: com.didi.beatles.im.plugin.IMPluginFactory */
public final class IMPluginFactory {

    /* renamed from: a */
    private static final String f11309a = IMPluginFactory.class.getSimpleName();

    public static IMPluginService getPlugin(int i) {
        if (i <= 0) {
            return null;
        }
        IMPluginService iMPluginService = (IMPluginService) IMSpiServiceProvider.getService(IMPluginService.class, String.valueOf(i));
        IMLog.m10020d(f11309a, C4786I.m9980t("[getPlugin] pluginId=", Integer.valueOf(i), " |plugin=", iMPluginService));
        return iMPluginService;
    }
}
