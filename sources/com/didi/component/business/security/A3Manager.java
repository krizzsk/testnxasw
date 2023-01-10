package com.didi.component.business.security;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.net.CarRequest;
import com.didi.sdk.component.protocol.IA3Manager;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.common.net.host.HostGroupManager;
import com.didi.travel.psnger.model.response.A3DeviceInfo;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.concurrent.atomic.AtomicBoolean;

@ServiceProvider({IA3Manager.class})
public class A3Manager implements IA3Manager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final AtomicBoolean f13182a = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f13183b;

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static String m11058c(String str) {
        return str;
    }

    /* renamed from: d */
    private static String m11059d(String str) {
        return str;
    }

    public String getToken(Context context) {
        return getA3Token(context);
    }

    public static String getA3Token(Context context) {
        if (!TextUtils.isEmpty(f13183b)) {
            return f13183b;
        }
        String a = m11051a(context);
        f13183b = a;
        if (TextUtils.isEmpty(a) && NationComponentDataUtil.isLoginNow()) {
            m11056b(context);
        }
        return f13183b;
    }

    public static boolean isNeedRequestTokenFromNet(Context context) {
        if (TextUtils.isEmpty(f13183b) && TextUtils.isEmpty(m11051a(context))) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static String m11051a(Context context) {
        String a3TokenEncrypt = GlobalSPUtil.getA3TokenEncrypt(context);
        if (TextUtils.isEmpty(a3TokenEncrypt)) {
            return null;
        }
        return m11059d(a3TokenEncrypt);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m11057b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            GlobalSPUtil.setA3TokenEncrypt(context, str);
        }
    }

    /* renamed from: b */
    private static void m11056b(final Context context) {
        if (!f13182a.getAndSet(true)) {
            HostGroupManager.getInstance().initDefaultHost();
            CarRequest.getDeviceInfo(context, new ResponseListener<A3DeviceInfo>() {
                public void onSuccess(A3DeviceInfo a3DeviceInfo) {
                    if (a3DeviceInfo != null && !TextUtils.isEmpty(a3DeviceInfo.getData())) {
                        String a = A3Manager.m11058c(a3DeviceInfo.getData());
                        if (!TextUtils.isEmpty(a)) {
                            String unused = A3Manager.f13183b = a3DeviceInfo.getData();
                            A3Manager.m11057b(context, a);
                        }
                    }
                }

                public void onFinish(A3DeviceInfo a3DeviceInfo) {
                    super.onFinish(a3DeviceInfo);
                    A3Manager.f13182a.set(false);
                }
            });
        }
    }
}
