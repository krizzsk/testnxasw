package com.didi.security.uuid.adapter;

import android.content.Context;
import com.didi.security.uuid.ApolloCallBack;
import com.didi.security.uuid.DeviceTokenManager;
import com.didichuxing.apollo.sdk.Apollo;

public class DeviceTokenWrapper {

    /* renamed from: a */
    private static final String f41267a = "wsg_dtoken_global_toggle";

    /* renamed from: b */
    private static final String f41268b = "wsg_dtoken_upload_toggle";

    /* renamed from: c */
    private DeviceTokenManager f41269c;

    public String getDeviceId() {
        return null;
    }

    private static class SigletonInstance {
        /* access modifiers changed from: private */
        public static final DeviceTokenWrapper INSTANCE = new DeviceTokenWrapper();

        private SigletonInstance() {
        }
    }

    public static DeviceTokenWrapper getInstance() {
        return SigletonInstance.INSTANCE;
    }

    public synchronized void init() {
        if (this.f41269c == null) {
            DeviceTokenManager instance = DeviceTokenManager.getInstance();
            this.f41269c = instance;
            if (instance != null) {
                m30982a();
            }
        }
    }

    public synchronized void init(Context context) {
        init();
    }

    /* renamed from: a */
    private void m30982a() {
        this.f41269c.setApolloCallBack(new ApolloCallBack() {
            public boolean isOn() {
                try {
                    return Apollo.getToggle(DeviceTokenWrapper.f41267a, true).allow();
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }

            public boolean isDeviceTokenUploadOn() {
                try {
                    return Apollo.getToggle(DeviceTokenWrapper.f41268b, true).allow();
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }
        });
    }

    public String getDeviceToken() {
        DeviceTokenManager deviceTokenManager = this.f41269c;
        if (deviceTokenManager != null) {
            return deviceTokenManager.getDeviceToken();
        }
        return DeviceTokenManager.getInstance().getDegradeNoInitToken();
    }
}
