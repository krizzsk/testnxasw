package com.didi.sdk.misconfig.p154v2;

import java.util.HashMap;

/* renamed from: com.didi.sdk.misconfig.v2.SecondConfProxy */
public class SecondConfProxy implements ISecondConf {

    /* renamed from: a */
    private HashMap<String, ISecondConf> f39619a;

    private SecondConfProxy() {
        this.f39619a = new HashMap<>();
    }

    /* renamed from: com.didi.sdk.misconfig.v2.SecondConfProxy$SingletonHolder */
    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final SecondConfProxy instance = new SecondConfProxy();

        private SingletonHolder() {
        }
    }

    public void addSecondConf(String str, ISecondConf iSecondConf) {
        this.f39619a.put(str, iSecondConf);
    }

    public ISecondConf getSecondConf(String str) {
        return this.f39619a.get(str);
    }

    public static SecondConfProxy getInstance() {
        return SingletonHolder.instance;
    }

    public void getSecConfigFromNet(double d, double d2, int i) {
        ISecondConf a = m29831a();
        if (a != null) {
            a.getSecConfigFromNet(d, d2, i);
        }
    }

    public boolean isCityOpen(String str) {
        ISecondConf iSecondConf = this.f39619a.get(str);
        if (iSecondConf != null) {
            return iSecondConf.isCityOpen(str);
        }
        return false;
    }

    /* renamed from: a */
    private ISecondConf m29831a() {
        return this.f39619a.get(ConfProxy.getInstance().getSelectedType());
    }
}
