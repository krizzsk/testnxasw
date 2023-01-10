package com.didi.xengine.config;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class EngineInitInstance {

    /* renamed from: a */
    private Map<String, EngineConfig> f47848a;

    private EngineInitInstance() {
        this.f47848a = new HashMap();
    }

    public EngineConfig getConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            for (String str2 : this.f47848a.keySet()) {
                EngineConfig engineConfig = this.f47848a.get(str2);
                if (engineConfig != null) {
                    return engineConfig;
                }
            }
        }
        return this.f47848a.get(str);
    }

    public void setConfig(String str, EngineConfig engineConfig) {
        this.f47848a.put(str, engineConfig);
    }

    private static class SingleTonHolder {
        /* access modifiers changed from: private */
        public static final EngineInitInstance INSTANCE = new EngineInitInstance();

        private SingleTonHolder() {
        }
    }

    public static EngineInitInstance getInstance() {
        return SingleTonHolder.INSTANCE;
    }
}
