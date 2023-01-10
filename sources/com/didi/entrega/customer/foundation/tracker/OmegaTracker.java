package com.didi.entrega.customer.foundation.tracker;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public final class OmegaTracker {

    /* renamed from: a */
    private static final String f21892a = "OmegaTracker";

    /* renamed from: b */
    private Map<String, Object> f21893b;

    /* renamed from: c */
    private String f21894c;

    private OmegaTracker(String str, ScopeContext scopeContext, boolean z, Map<String, Object> map) {
        this.f21894c = str;
        if (!z) {
            this.f21893b = OmegaCommonParamHelper.getCommonParam();
        } else if (scopeContext != null && !scopeContext.getLiveHandler().isDestroyed()) {
            this.f21893b = OmegaCommonParamHelper.m18219a((String) scopeContext.getObject("ScopeContextPageId"));
        } else {
            return;
        }
        this.f21893b.putAll(map);
    }

    public void track() {
        if (this.f21893b != null) {
            LogUtil.m18185i(f21892a, "trackEvent mEventName： " + this.f21894c);
            OmegaSDKAdapter.trackEvent(this.f21894c, this.f21893b);
        }
    }

    public static final class Builder {
        private String mEventName;
        private Map<String, Object> mEventParamsMap = new HashMap();
        private boolean mNeedScopeContext;
        private ScopeContext mScopeContext;

        private Builder(String str, ScopeContext scopeContext, boolean z) {
            if (!TextUtils.isEmpty(str)) {
                this.mEventName = str;
                this.mScopeContext = scopeContext;
                this.mNeedScopeContext = z;
                return;
            }
            throw new IllegalStateException("eventName must have value");
        }

        public static Builder create(String str, ScopeContext scopeContext) {
            return new Builder(str, scopeContext, true);
        }

        public static Builder create(String str) {
            return new Builder(str, (ScopeContext) null, false);
        }

        public Builder addAllEventParam(Map map) {
            this.mEventParamsMap.putAll(map);
            return this;
        }

        public Builder addEventParam(String str, Object obj) {
            this.mEventParamsMap.put(str, obj);
            return this;
        }

        public OmegaTracker build() {
            return new OmegaTracker(this.mEventName, this.mScopeContext, this.mNeedScopeContext, this.mEventParamsMap);
        }
    }
}
