package com.didi.soda.web;

import com.didi.onehybrid.BusinessAgent;

public class SodaFusionEngine {

    /* renamed from: a */
    private static BusinessAgent f46417a;

    /* renamed from: b */
    private static Class<? extends GlobalJsBridge> f46418b;

    public static void init(SodaConfingBuilder sodaConfingBuilder) {
        f46417a = sodaConfingBuilder.businessAgent;
        f46418b = sodaConfingBuilder.globalJsBridge;
    }

    public static BusinessAgent getBusinessAgent() {
        return f46417a;
    }

    public static Class<? extends GlobalJsBridge> getGlobalJsBridge() {
        return f46418b;
    }

    public static class SodaConfingBuilder {
        BusinessAgent businessAgent;
        Class<? extends GlobalJsBridge> globalJsBridge;

        public SodaConfingBuilder setBusinessAgent(BusinessAgent businessAgent2) {
            this.businessAgent = businessAgent2;
            return this;
        }

        public void setGlobalJsBridge(Class<? extends GlobalJsBridge> cls) {
            this.globalJsBridge = cls;
        }
    }
}
