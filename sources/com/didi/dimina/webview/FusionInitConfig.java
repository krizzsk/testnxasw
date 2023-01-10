package com.didi.dimina.webview;

import java.util.HashMap;
import java.util.Map;

public class FusionInitConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f20085a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f20086b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f20087c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f20088d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map<String, Object> f20089e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BusinessAgent f20090f;

    public String getAppKey() {
        return this.f20087c;
    }

    public String getPhone() {
        return this.f20085a;
    }

    public int getCityId() {
        return this.f20086b;
    }

    public String getHybridUrl() {
        return this.f20088d;
    }

    public BusinessAgent getBusinessAgent() {
        return this.f20090f;
    }

    public Map<String, Object> getExtraAttrsMap() {
        return this.f20089e;
    }

    private FusionInitConfig() {
    }

    public static class Builder {
        String appKey;
        BusinessAgent businessAgent;
        int cityId;
        Map<String, Object> extraAttrsMap = new HashMap();
        String hybridUrl;
        String phone;

        public Builder setPhone(String str) {
            this.phone = str;
            return this;
        }

        public Builder setCityId(int i) {
            this.cityId = i;
            return this;
        }

        public Builder setBusinessAgent(BusinessAgent businessAgent2) {
            this.businessAgent = businessAgent2;
            return this;
        }

        public Builder setAppKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder setHybridUrl(String str) {
            this.hybridUrl = str;
            return this;
        }

        public Builder addExtraAttr(String str, Object obj) {
            this.extraAttrsMap.put(str, obj);
            return this;
        }

        public FusionInitConfig build() {
            FusionInitConfig fusionInitConfig = new FusionInitConfig();
            String unused = fusionInitConfig.f20087c = this.appKey;
            String unused2 = fusionInitConfig.f20085a = this.phone;
            int unused3 = fusionInitConfig.f20086b = this.cityId;
            String unused4 = fusionInitConfig.f20088d = this.hybridUrl;
            BusinessAgent unused5 = fusionInitConfig.f20090f = this.businessAgent;
            Map unused6 = fusionInitConfig.f20089e = this.extraAttrsMap;
            return fusionInitConfig;
        }
    }
}
