package com.didichuxing.bigdata.p174dp.locsdk;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.WifiManagerWrapper */
public class WifiManagerWrapper implements IWifiManagerWrapper {

    /* renamed from: a */
    private IWifiManagerWrapper f48401a;

    private WifiManagerWrapper() {
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.WifiManagerWrapper$SingletonHolder */
    private static class SingletonHolder {
        static final WifiManagerWrapper INSTANCE = new WifiManagerWrapper();

        private SingletonHolder() {
        }
    }

    public static WifiManagerWrapper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* renamed from: a */
    private synchronized void m36241a(Context context) {
        this.f48401a = com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.WifiManagerWrapper.getInstance();
    }

    /* renamed from: a */
    private synchronized IWifiManagerWrapper m36240a() {
        return this.f48401a;
    }

    public void init(Context context) {
        m36241a(context);
        m36240a().init(context);
    }

    public WifiInfo getConnectionInfo() {
        return m36240a().getConnectionInfo();
    }

    public List<ScanResult> getScanResults() {
        return m36240a().getScanResults();
    }

    public boolean wifiEnabled() {
        return m36240a().wifiEnabled();
    }
}
