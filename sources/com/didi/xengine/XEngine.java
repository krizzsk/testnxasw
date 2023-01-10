package com.didi.xengine;

import android.content.Context;
import com.android.didi.bfflib.BffExtra;
import com.didi.xengine.callback.XEBizParamMapCallback;
import com.didi.xengine.callback.XECallback;
import com.didi.xengine.callback.XESceneGetter;
import com.didi.xengine.callback.XEngineCallbackImpl;
import com.didi.xengine.config.EngineConfig;
import com.didi.xengine.config.EngineInitInstance;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didi.xengine.request.XECacheParamsImpl;
import com.didi.xengine.request.XECommitBizParams;
import com.didi.xengine.request.XEParamBuilder;
import com.didiglobal.enginecore.TemplateCompRegister;
import com.didiglobal.enginecore.XEngineCallback;
import com.didiglobal.enginecore.XEngineCommitCallback;
import com.didiglobal.enginecore.XEngineDataHandleCallback;
import com.didiglobal.enginecore.XEngineInnerRequest;
import com.didiglobal.enginecore.cache.XECacheMgr;
import com.didiglobal.enginecore.data.model.EngineCommitModel;
import com.didiglobal.enginecore.data.model.EngineInnerRequestModel;
import com.didiglobal.enginecore.data.parser.XEEngineParser;
import com.didiglobal.enginecore.data.parser.model.EngineParseModel;
import com.didiglobal.enginecore.push.EnginePushRegister;
import com.didiglobal.enginecore.push.PushCallbackCreator;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Map;

public class XEngine {

    /* renamed from: a */
    private XEngineInnerRequest f47838a = new XEngineInnerRequest();

    /* renamed from: b */
    private XEParamBuilder f47839b = new XEParamBuilder(this);

    /* renamed from: c */
    private String f47840c;

    /* renamed from: d */
    private EnginePushRegister f47841d;

    /* renamed from: e */
    private XESceneGetter f47842e;

    /* renamed from: f */
    private XECacheMgr f47843f;

    public XEngine(String str) {
        this.f47840c = str;
    }

    public void initCache(Context context) {
        XECacheMgr xECacheMgr = new XECacheMgr(context.getApplicationContext());
        this.f47843f = xECacheMgr;
        this.f47838a.setCacheManager(xECacheMgr);
    }

    public void register(Context context, final XESceneGetter xESceneGetter, XEngineDataHandleCallback xEngineDataHandleCallback) {
        if (xESceneGetter != null) {
            this.f47842e = xESceneGetter;
            if (this.f47841d == null) {
                this.f47841d = new EnginePushRegister();
            }
            this.f47841d.register(context, new PushCallbackCreator() {
                public XEngineCallback getEngineCallback() {
                    return new XECallback(xESceneGetter.getCurrentScene());
                }

                public String getCurrentScene() {
                    return xESceneGetter.getCurrentScene();
                }
            }, xEngineDataHandleCallback);
            XEngineInnerRequest xEngineInnerRequest = this.f47838a;
            if (xEngineInnerRequest != null) {
                xEngineInnerRequest.setDataHandleCallback(xEngineDataHandleCallback);
                return;
            }
            return;
        }
        throw new NullPointerException("XESceneGetter can not be null");
    }

    public void unregister() {
        EnginePushRegister enginePushRegister = this.f47841d;
        if (enginePushRegister != null) {
            enginePushRegister.unregister();
            this.f47841d = null;
        }
        XEngineInnerRequest xEngineInnerRequest = this.f47838a;
        if (xEngineInnerRequest != null) {
            xEngineInnerRequest.setDataHandleCallback((XEngineDataHandleCallback) null);
        }
    }

    public void setXEConfig(EngineConfig engineConfig) {
        EngineInitInstance.getInstance().setConfig(this.f47840c, engineConfig);
    }

    public void simpleRequest(Context context, XEBizParamsImpl xEBizParamsImpl, Map<String, Object> map, String[] strArr) {
        xEBizParamsImpl.scene = m35942a(xEBizParamsImpl.scene);
        this.f47839b.buildBizParamsMap(xEBizParamsImpl, new XEBizParamMapCallback(xEBizParamsImpl, map, strArr, context) {
            public final /* synthetic */ XEBizParamsImpl f$1;
            public final /* synthetic */ Map f$2;
            public final /* synthetic */ String[] f$3;
            public final /* synthetic */ Context f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void getBizMap(Map map) {
                XEngine.this.m35944a(this.f$1, this.f$2, this.f$3, this.f$4, map);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m35944a(XEBizParamsImpl xEBizParamsImpl, Map map, String[] strArr, Context context, Map map2) {
        EngineInnerRequestModel engineInnerRequestModel = new EngineInnerRequestModel(xEBizParamsImpl.scene, map2, map, new XECallback(xEBizParamsImpl.scene));
        engineInnerRequestModel.requestKeys = strArr;
        engineInnerRequestModel.requestCache = xEBizParamsImpl.requestCache;
        engineInnerRequestModel.requestCacheOnly = xEBizParamsImpl.requestCacheOnly;
        this.f47838a.xEngineLoad4Simple(context, engineInnerRequestModel);
    }

    public void commitRequest(Context context, XECommitBizParams xECommitBizParams, Map<String, Object> map) {
        xECommitBizParams.scene = m35942a(xECommitBizParams.scene);
        this.f47839b.buildBizParamsMap(xECommitBizParams, new XEBizParamMapCallback(xECommitBizParams, map, context) {
            public final /* synthetic */ XECommitBizParams f$1;
            public final /* synthetic */ Map f$2;
            public final /* synthetic */ Context f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void getBizMap(Map map) {
                XEngine.this.m35945a(this.f$1, this.f$2, this.f$3, map);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m35945a(XECommitBizParams xECommitBizParams, Map map, Context context, Map map2) {
        EngineInnerRequestModel engineInnerRequestModel = new EngineInnerRequestModel(xECommitBizParams.scene, map2, map, new XECallback(xECommitBizParams.scene));
        engineInnerRequestModel.commitModel = new EngineCommitModel(xECommitBizParams.callback);
        engineInnerRequestModel.commitModel.commitModel = xECommitBizParams.commitModel;
        if (engineInnerRequestModel.commitModel.commitModel == null && xECommitBizParams.extraParams != null && !xECommitBizParams.extraParams.isEmpty()) {
            new Gson().toJson((Object) xECommitBizParams.extraParams);
        }
        this.f47838a.xEngineCommit(context, engineInnerRequestModel);
    }

    public void pageRequest(Context context, XEBizParamsImpl xEBizParamsImpl, Map<String, Object> map) {
        xEBizParamsImpl.scene = m35942a(xEBizParamsImpl.scene);
        this.f47839b.buildBizParamsMap(xEBizParamsImpl, new XEBizParamMapCallback(xEBizParamsImpl, map, context) {
            public final /* synthetic */ XEBizParamsImpl f$1;
            public final /* synthetic */ Map f$2;
            public final /* synthetic */ Context f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void getBizMap(Map map) {
                XEngine.this.m35943a(this.f$1, this.f$2, this.f$3, map);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m35943a(XEBizParamsImpl xEBizParamsImpl, Map map, Context context, Map map2) {
        EngineInnerRequestModel engineInnerRequestModel = new EngineInnerRequestModel(xEBizParamsImpl.scene, map2, map, new XECallback(xEBizParamsImpl.scene));
        engineInnerRequestModel.requestCache = xEBizParamsImpl.requestCache;
        engineInnerRequestModel.requestCacheOnly = xEBizParamsImpl.requestCacheOnly;
        this.f47838a.xEngineLoad(context, engineInnerRequestModel);
    }

    public void engineDispatch(Context context, String str, JsonObject jsonObject, XEngineDataHandleCallback xEngineDataHandleCallback) {
        XEEngineParser.parseAndDispatch(context, EngineParseModel.Companion.createParseModel(str, TemplateCompRegister.getTemplateKeyList(), TemplateCompRegister.getRequiredTemplateSet(str), jsonObject, new XEngineCallbackImpl(str), (XEngineCommitCallback) null, (BffExtra) null, xEngineDataHandleCallback));
    }

    public void setCache(XECacheParamsImpl xECacheParamsImpl, Boolean bool) {
        if (this.f47843f != null && xECacheParamsImpl != null) {
            if (bool.booleanValue()) {
                this.f47843f.putDefault(xECacheParamsImpl.scene, xECacheParamsImpl.component, xECacheParamsImpl.jsonString, true);
            } else {
                this.f47843f.putNormal(xECacheParamsImpl.scene, xECacheParamsImpl.component, xECacheParamsImpl.jsonString, true);
            }
        }
    }

    public XECacheMgr getCacheMgr() {
        return this.f47843f;
    }

    public void setEngineCallbackTimeOut(int i) {
        this.f47838a.setEngineCallbackTimeOut(i);
    }

    public void setEngineReqRunnableTimeOut(int i) {
        this.f47838a.setEngineReqRunnableTimeOut(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f47842e;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m35942a(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x000e
            com.didi.xengine.callback.XESceneGetter r0 = r1.f47842e
            if (r0 == 0) goto L_0x000e
            java.lang.String r2 = r0.getCurrentScene()
        L_0x000e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.xengine.XEngine.m35942a(java.lang.String):java.lang.String");
    }
}
