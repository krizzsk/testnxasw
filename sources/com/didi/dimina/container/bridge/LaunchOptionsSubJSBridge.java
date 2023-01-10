package com.didi.dimina.container.bridge;

import android.text.TextUtils;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.NavigateUtil;
import com.didi.dimina.container.util.TextUtil;
import com.didi.dimina.container.util.TraceUtil;
import org.json.JSONObject;

public class LaunchOptionsSubJSBridge {

    /* renamed from: a */
    private final DMMina f18494a;

    LaunchOptionsSubJSBridge(DMMina dMMina) {
        this.f18494a = dMMina;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo59429a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject showOption = getShowOption(jSONObject, this.f18494a);
        LogUtil.iRelease("launch options", showOption.toString());
        return showOption;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo59430b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.f18494a.invokePreloadReady();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo59431c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        int minaIndex = this.f18494a.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.LAUNCH_INVOKE_BUSINESS_READY, "msg: " + jSONObject);
        if (!this.f18494a.checkAndDoExitInMiniLaunch()) {
            this.f18494a.getPerformance().markJSRequireEnd();
            m15657a(jSONObject, this.f18494a.getJSAppConfig(), this.f18494a.getConfig());
            this.f18494a.getPerformance().markNativeJSBusinessReady();
            this.f18494a.getPerformance().markAppServiceExecuteEnd();
        }
    }

    /* renamed from: a */
    private void m15657a(JSONObject jSONObject, JSAppConfig jSAppConfig, DMConfig dMConfig) {
        DMMinaNavigatorDelegate navigator;
        DMMinaNavigatorDelegate curNavigator = NavigateUtil.getCurNavigator(this.f18494a);
        if (!(jSONObject == null || (navigator = this.f18494a.getNavigator(jSONObject.optInt(MessageWrapperBuilder.ARG_STACK_ID, -1))) == null)) {
            curNavigator = navigator;
        }
        if (curNavigator != null) {
            int index = curNavigator.getIndex();
            this.f18494a.m15578a(index, curNavigator.getExtraShowOptions());
            String entryPath = dMConfig.getLaunchConfig().getEntryPath();
            if (TextUtil.isEmpty(entryPath) && jSAppConfig != null && !TextUtils.isEmpty(jSAppConfig.entryPagePath)) {
                entryPath = jSAppConfig.entryPagePath;
            }
            JSONObject combineJson = JSONUtil.combineJson(HttpUtil.parseUrlQueryJSONObject(this.f18494a.getConfig().getLaunchConfig().getAppId(), entryPath), dMConfig.getLaunchConfig().getExtraOptions());
            JSONObject jSONObject2 = new JSONObject();
            JSONUtil.put(jSONObject2, "openType", (Object) "appLaunch");
            JSONUtil.put(jSONObject2, "url", (Object) entryPath);
            JSONUtil.put(jSONObject2, "query", (Object) combineJson);
            JSONObject build = new MessageWrapperBuilder().stackId(index).data(jSONObject2).build();
            this.f18494a.getMessageTransfer().sendMessageToServiceFromNative("launchPage", build);
            this.f18494a.getMessageTransfer().setBusinessReady();
            int minaIndex = this.f18494a.getMinaIndex();
            TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.LAUNCH_LAUNCH_PAGE, "msg: " + build);
        }
    }

    public static JSONObject getShowOption(JSONObject jSONObject, DMMina dMMina) {
        JSONObject jSONObject2;
        DMMinaNavigatorDelegate navigator;
        JSAppConfig jSAppConfig;
        if (dMMina == null || dMMina.getConfig() == null) {
            return new JSONObject();
        }
        String entryPath = dMMina.getConfig().getLaunchConfig().getEntryPath();
        if (TextUtil.isEmpty(entryPath) && (jSAppConfig = dMMina.getJSAppConfig()) != null && !TextUtils.isEmpty(jSAppConfig.entryPagePath)) {
            entryPath = jSAppConfig.entryPagePath;
        }
        DMMinaNavigatorDelegate curNavigator = NavigateUtil.getCurNavigator(dMMina);
        if (!(jSONObject == null || (navigator = dMMina.getNavigator(jSONObject.optInt(MessageWrapperBuilder.ARG_STACK_ID, -1))) == null)) {
            curNavigator = navigator;
        }
        JSONObject extraOptions = dMMina.getConfig().getLaunchConfig().getExtraOptions();
        JSONObject jSONObject3 = null;
        if (curNavigator != null) {
            JSONObject extraOptions2 = curNavigator.getExtraOptions() != null ? curNavigator.getExtraOptions() : null;
            if (curNavigator.getExtraShowOptions() != null) {
                jSONObject3 = curNavigator.getExtraShowOptions();
            }
            jSONObject2 = jSONObject3;
            jSONObject3 = extraOptions2;
        } else {
            jSONObject2 = null;
        }
        int scene = dMMina.getConfig().getLaunchConfig().getScene();
        if (scene < 1000) {
            scene = 1000;
        }
        JSONObject combineJson = JSONUtil.combineJson(JSONUtil.combineJson(JSONUtil.combineJson(extraOptions, jSONObject3), jSONObject2), HttpUtil.parseUrlQueryJSONObject(dMMina.getConfig().getLaunchConfig().getAppId(), entryPath));
        JSONObject jSONObject4 = new JSONObject();
        JSONUtil.put(jSONObject4, "path", (Object) entryPath);
        JSONUtil.put(jSONObject4, "scene", scene);
        JSONUtil.put(jSONObject4, "query", (Object) combineJson);
        return jSONObject4;
    }
}
