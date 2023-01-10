package com.didi.onehybrid;

import java.util.HashMap;
import java.util.Map;

public class FusionInitConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f31958a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f31959b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f31960c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f31961d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map<String, Object> f31962e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BusinessAgent f31963f;

    public String getAppKey() {
        return this.f31960c;
    }

    public String getPhone() {
        return this.f31958a;
    }

    public int getCityId() {
        return this.f31959b;
    }

    public String getHybridUrl() {
        return this.f31961d;
    }

    public BusinessAgent getBusinessAgent() {
        return this.f31963f;
    }

    public Map<String, Object> getExtraAttrsMap() {
        return this.f31962e;
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
            String unused = fusionInitConfig.f31960c = this.appKey;
            String unused2 = fusionInitConfig.f31958a = this.phone;
            int unused3 = fusionInitConfig.f31959b = this.cityId;
            String unused4 = fusionInitConfig.f31961d = this.hybridUrl;
            BusinessAgent unused5 = fusionInitConfig.f31963f = this.businessAgent;
            Map unused6 = fusionInitConfig.f31962e = this.extraAttrsMap;
            return fusionInitConfig;
        }
    }
}
