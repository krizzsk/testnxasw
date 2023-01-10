package com.didi.xengine.config;

import com.didi.xengine.callback.XEReqUtilMethod;

public class EngineConfig {

    /* renamed from: a */
    private XEReqUtilMethod f47847a;

    private EngineConfig(Builder builder) {
        this.f47847a = builder.method;
    }

    public XEReqUtilMethod getMethod() {
        return this.f47847a;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public XEReqUtilMethod method;

        public EngineConfig build() {
            return new EngineConfig(this);
        }

        public Builder setReqMethod(XEReqUtilMethod xEReqUtilMethod) {
            this.method = xEReqUtilMethod;
            return this;
        }
    }
}
