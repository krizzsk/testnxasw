package com.didi.beatles.p101im.plugin;

import com.didi.beatles.p101im.event.IMSendAddressEvent;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMLog;

/* renamed from: com.didi.beatles.im.plugin.IMHostProxy */
public class IMHostProxy {

    /* renamed from: a */
    private static final String f11304a = IMHostProxy.class.getSimpleName();

    /* renamed from: b */
    private IMPluginSendListener f11305b;

    private IMHostProxy() {
    }

    public static IMHostProxy getInstance() {
        return Holder.INSTANCE;
    }

    public void registerPluginSendListener(IMPluginSendListener iMPluginSendListener) {
        this.f11305b = null;
        this.f11305b = iMPluginSendListener;
    }

    public void unregisterPluginSendListener(IMPluginSendListener iMPluginSendListener) {
        this.f11305b = null;
    }

    public boolean navigation(int i, String str) {
        IMLog.m10020d(f11304a, C4786I.m9980t("[navigation] pluginId=", Integer.valueOf(i), " |scheme=", str));
        IMPluginSendListener iMPluginSendListener = this.f11305b;
        if (iMPluginSendListener == null) {
            IMLog.m10021e(f11304a, "[navigation] failed with NULL listener");
            return false;
        } else if (iMPluginSendListener.getHostContext() == null) {
            IMLog.m10021e(f11304a, "[navigation] failed with NULL context");
            return false;
        } else {
            IMCommonUtil.startUriActivity(this.f11305b.getHostContext(), str);
            return true;
        }
    }

    public boolean sendTextMessage(int i, String str) {
        IMLog.m10020d(f11304a, C4786I.m9980t("[sendTextMessage] -> ", str));
        IMPluginSendListener iMPluginSendListener = this.f11305b;
        if (iMPluginSendListener == null) {
            IMLog.m10021e(f11304a, "[sendTextMessage] failed with NULL listener");
            return false;
        }
        iMPluginSendListener.sendPluginTextMessage(i, str, 65536, (Object) null);
        return true;
    }

    public boolean sendPluginMessage(int i, String str, String str2, int i2) {
        IMLog.m10020d(f11304a, C4786I.m9980t("[sendPluginMessage] content= ", str, " |listText=", str2));
        IMPluginSendListener iMPluginSendListener = this.f11305b;
        if (iMPluginSendListener == null) {
            IMLog.m10021e(f11304a, "[sendPluginMessage] failed with NULL listener");
            return false;
        }
        iMPluginSendListener.sendPluginMessage(i, str, str2, i2);
        return true;
    }

    public boolean sendStreetViewMessage(int i) {
        IMLog.m10020d(f11304a, C4786I.m9980t("[sendStreetViewMessage] pluginId= ", Integer.valueOf(i)));
        IMPluginSendListener iMPluginSendListener = this.f11305b;
        if (iMPluginSendListener == null) {
            IMLog.m10021e(f11304a, "[sendStreetViewMessage] failed with NULL listener");
            return false;
        }
        iMPluginSendListener.sendStreetViewMessage(i);
        return true;
    }

    public boolean sendLocationMessage(IMSendAddressEvent iMSendAddressEvent, boolean z) {
        String str = f11304a;
        StringBuilder sb = new StringBuilder();
        sb.append(C4786I.m9980t("[sendLocationMessage] sendAddressEvent=" + iMSendAddressEvent.toString()));
        sb.append("needDialog");
        sb.append(z);
        IMLog.m10020d(str, sb.toString());
        IMPluginSendListener iMPluginSendListener = this.f11305b;
        if (iMPluginSendListener == null) {
            IMLog.m10021e(f11304a, "[sendLocationMessage] failed with NULL listener");
            return false;
        }
        iMPluginSendListener.sendLocationMessage(iMSendAddressEvent, z);
        return true;
    }

    /* renamed from: com.didi.beatles.im.plugin.IMHostProxy$Holder */
    private static final class Holder {
        /* access modifiers changed from: private */
        public static final IMHostProxy INSTANCE = new IMHostProxy();

        private Holder() {
        }
    }
}
