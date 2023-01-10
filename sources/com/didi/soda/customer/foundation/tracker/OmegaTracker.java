package com.didi.soda.customer.foundation.tracker;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.param.GuideParam;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public final class OmegaTracker {

    /* renamed from: a */
    private static final String f43685a = "OmegaTracker";

    /* renamed from: b */
    private Map<String, Object> f43686b;

    /* renamed from: c */
    private String f43687c;

    private OmegaTracker(String str, ScopeContext scopeContext, boolean z, boolean z2, Map<String, Object> map) {
        this.f43687c = str;
        if (!z) {
            this.f43686b = OmegaCommonParamHelper.getCommonParam();
        } else if (scopeContext != null && !scopeContext.getLiveHandler().isDestroyed()) {
            this.f43686b = OmegaCommonParamHelper.m32648a(str, (String) scopeContext.getObject("ScopeContextPageId"), (GuideParam) scopeContext.getObject("ScopeContextPageGuideParam"), z2);
        } else {
            return;
        }
        this.f43686b.putAll(map);
    }

    public void track() {
        if (this.f43686b != null) {
            LogUtil.m32588i(f43685a, "trackEvent mEventName： " + this.f43687c);
            OmegaSDKAdapter.trackEvent(this.f43687c, this.f43686b);
        }
    }

    public static final class Builder {
        private boolean mEnableGuideParam = false;
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
            return new OmegaTracker(this.mEventName, this.mScopeContext, this.mNeedScopeContext, this.mEnableGuideParam, this.mEventParamsMap);
        }

        public Builder enableGuideParam() {
            if (!this.mNeedScopeContext) {
                this.mEnableGuideParam = false;
                ErrorTracker.create(ErrorConst.ErrorName.SALING_C_OMEGA_GUIDE_SCOPEERROR).addModuleName("omega").addErrorType(this.mEventName).build().trackError();
                return this;
            }
            this.mEnableGuideParam = true;
            return this;
        }
    }
}
