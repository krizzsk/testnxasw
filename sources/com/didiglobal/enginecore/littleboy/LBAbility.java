package com.didiglobal.enginecore.littleboy;

import android.content.Context;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

public class LBAbility {

    /* renamed from: a */
    private String f52689a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map<String, Object> f52690b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RpcService.Callback<JsonObject> f52691c;

    /* renamed from: d */
    private Context f52692d;

    private LBAbility(Context context, String str) {
        this.f52690b = new HashMap();
        this.f52692d = context;
        this.f52689a = str;
    }

    public static class Builder {
        private LBAbility mAbility;

        public Builder(Context context, String str) {
            this.mAbility = new LBAbility(context, str);
        }

        public Builder setParams(Map<String, Object> map) {
            if (CollectionUtil.isEmpty((Map<?, ?>) map)) {
                return this;
            }
            Map unused = this.mAbility.f52690b = map;
            return this;
        }

        public Builder addParams(String str, Object obj) {
            if (this.mAbility.f52690b == null) {
                Map unused = this.mAbility.f52690b = new HashMap();
            }
            this.mAbility.f52690b.put(str, obj);
            return this;
        }

        public Builder removeParams() {
            if (this.mAbility.f52690b != null) {
                this.mAbility.f52690b.clear();
            }
            return this;
        }

        public Builder setCallback(RpcService.Callback<JsonObject> callback) {
            RpcService.Callback unused = this.mAbility.f52691c = callback;
            return this;
        }

        public LBAbility build() {
            return this.mAbility;
        }
    }

    public String getRequestKey() {
        return this.f52689a;
    }

    public Map<String, Object> getRequestParam() {
        return this.f52690b;
    }

    public RpcService.Callback<JsonObject> getCallback() {
        return this.f52691c;
    }

    public Context getContext() {
        return this.f52692d;
    }
}
