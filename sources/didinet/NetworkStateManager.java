package didinet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.didi.beatles.p101im.access.utils.IMTextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import org.json.JSONObject;

public class NetworkStateManager {
    public static final int NETWORK_CLASS_2_G = 200;
    public static final int NETWORK_CLASS_3_G = 300;
    public static final int NETWORK_CLASS_4_G = 400;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_CLASS_WIFI = 100;

    /* renamed from: a */
    private Context f59890a;

    /* renamed from: b */
    private InPhoneStateListener f59891b = new InPhoneStateListener();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f59892c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f59893d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f59894e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f59895f = 0;

    /* renamed from: a */
    private static int m45062a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 200;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 300;
            case 13:
                return 400;
            default:
                return 0;
        }
    }

    NetworkStateManager(Context context) {
        this.f59890a = context.getApplicationContext();
    }

    public boolean isWifiAvailable() {
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) this.f59890a.getSystemService("connectivity"));
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getType() != 1) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isMobileAvailable() {
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) this.f59890a.getSystemService("connectivity"));
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getType() != 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isNetAvailable() {
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) this.f59890a.getSystemService("connectivity"));
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void listene() {
        this.f59892c = -1;
        this.f59893d = -1;
        m45066a();
        try {
            ((TelephonyManager) this.f59890a.getSystemService("phone")).listen(this.f59891b, 65);
        } catch (Throwable unused) {
        }
    }

    public void remove() {
        this.f59892c = -1;
        this.f59893d = -1;
        this.f59894e = 0;
        this.f59895f = 0;
        try {
            ((TelephonyManager) this.f59890a.getSystemService("phone")).listen(this.f59891b, 0);
        } catch (Throwable unused) {
        }
    }

    public String getOperatorServiceStateDesc() {
        int i = this.f59892c;
        if (i == -1) {
            return "NOT_INIT";
        }
        if (i == 0) {
            return "IN_SERVICE";
        }
        if (i == 1) {
            return "OUT_OF_SERVICE";
        }
        if (i != 2) {
            return i != 3 ? "UNKNOWN_STATE" : "RADIO_SHUTDOWN";
        }
        return "EMERGENCY_ONLY";
    }

    public String getDataConnectionStateDesc() {
        int i = this.f59893d;
        if (i == -1) {
            return "NOT_INIT";
        }
        if (i == 0) {
            return "DISCONNECTED";
        }
        if (i == 1) {
            return "CONNECTING";
        }
        if (i != 2) {
            return i != 3 ? "UNKNOWN_STATE" : DebugCoroutineInfoImplKt.SUSPENDED;
        }
        return "CONNECTED";
    }

    public String getNetworkTypeDesc() {
        switch (this.f59894e) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKNOWN";
        }
    }

    public String getNetworkClassDesc() {
        int i = this.f59895f;
        if (i == 200) {
            return "2G";
        }
        if (i != 300) {
            return i != 400 ? "unknown" : "4G";
        }
        return "3G";
    }

    public int getOperatorServiceState() {
        return this.f59892c;
    }

    public int getDataConnectionState() {
        return this.f59893d;
    }

    public int getNetworkType() {
        return this.f59894e;
    }

    public int getNetworkClass() {
        return this.f59895f;
    }

    private class InPhoneStateListener extends PhoneStateListener {
        private InPhoneStateListener() {
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            super.onServiceStateChanged(serviceState);
            if (serviceState != null) {
                int unused = NetworkStateManager.this.f59892c = serviceState.getState();
                if (NetworkStateManager.this.f59892c == 0) {
                    NetworkStateManager.this.m45066a();
                    return;
                }
                int unused2 = NetworkStateManager.this.f59894e = 0;
                int unused3 = NetworkStateManager.this.f59895f = 0;
            }
        }

        public void onDataConnectionStateChanged(int i, int i2) {
            super.onDataConnectionStateChanged(i, i2);
            int unused = NetworkStateManager.this.f59893d = i;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45066a() {
        try {
            this.f59894e = ((TelephonyManager) this.f59890a.getSystemService("phone")).getNetworkType();
        } catch (Exception unused) {
            this.f59894e = 0;
        }
        this.f59895f = m45062a(this.f59894e);
    }

    public String getDozeMode() {
        try {
            PowerManager powerManager = (PowerManager) this.f59890a.getSystemService("power");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("light", m45067b());
            if (Build.VERSION.SDK_INT >= 23) {
                int i = 1;
                jSONObject.put("idle", powerManager.isDeviceIdleMode() ? 1 : 0);
                jSONObject.put("pw_save", powerManager.isPowerSaveMode() ? 1 : 0);
                if (!powerManager.isIgnoringBatteryOptimizations(this.f59890a.getPackageName())) {
                    i = 0;
                }
                jSONObject.put("pw_wl", i);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /* renamed from: b */
    private int m45067b() {
        PowerManager powerManager = (PowerManager) this.f59890a.getSystemService("power");
        if (powerManager == null || Build.VERSION.SDK_INT >= 28) {
            return -1;
        }
        try {
            return ((Boolean) powerManager.getClass().getDeclaredMethod("isLightDeviceIdleMode", new Class[0]).invoke(powerManager, new Object[0])).booleanValue() ? 1 : 0;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return -1;
        }
    }

    public String getHttpProxyInfo() {
        int i;
        String str;
        if (Build.VERSION.SDK_INT >= 14) {
            str = System.getProperty("http.proxyHost");
            String property = System.getProperty("http.proxyPort");
            if (property == null) {
                property = "-1";
            }
            i = Integer.parseInt(property);
        } else {
            str = Proxy.getHost(this.f59890a);
            i = Proxy.getPort(this.f59890a);
        }
        Logger.m45047d("NetworkStateManager", "getHttpProxyInfo() proxy Host: " + str + ", port:" + i);
        if (TextUtils.isEmpty(str) || i == -1) {
            return null;
        }
        return str + ":" + i;
    }

    public String getVpnInfo() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return null;
            }
            Iterator<T> it = Collections.list(networkInterfaces).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.isUp()) {
                    if (networkInterface.getInterfaceAddresses().size() != 0) {
                        if ("tun0".equals(networkInterface.getName()) || "ppp0".equals(networkInterface.getName())) {
                            Logger.m45047d("NetworkStateManager", "getVpnInfo() NetworkInterface Name: " + networkInterface.toString());
                            return m45065a(networkInterface);
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            Logger.m45049e("NetworkStateManager", "error occur => " + th.getLocalizedMessage());
            return null;
        }
    }

    /* renamed from: a */
    private String m45065a(NetworkInterface networkInterface) {
        StringBuilder sb = new StringBuilder();
        sb.append(IMTextUtils.STREET_IMAGE_TAG_START);
        sb.append(networkInterface.toString());
        Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
        while (inetAddresses.hasMoreElements()) {
            sb.append(",");
            sb.append(inetAddresses.nextElement().toString());
        }
        sb.append(IMTextUtils.STREET_IMAGE_TAG_END);
        return sb.toString();
    }
}
