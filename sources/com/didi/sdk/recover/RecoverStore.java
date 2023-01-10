package com.didi.sdk.recover;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.bff.BffConstants;
import com.didi.sdk.common.DDRpcServiceHelper;
import com.didi.sdk.event.DefaultEvent;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.sidebar.sdk.commonapi.Consts;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.store.FetchCallback;
import com.didi.sdk.util.CommonParamsUtil;
import com.didi.sdk.util.SingletonHolder;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RecoverStore extends BaseStore {
    public static final String ACTION_REFRESH_RECOVER = "refresh_order";
    public static final String ACTION_REFRESH_RECOVER_FORCE = "refresh_order_force";
    public static final int ERROR_NETWORK_EXCEPT = -1000;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Logger f39807a = LoggerFactory.getLogger("RecoverStore");

    /* renamed from: b */
    private static final String f39808b = "new_order_recover";

    /* renamed from: c */
    private RecoverService f39809c;

    /* renamed from: d */
    private RpcServiceFactory f39810d;

    /* renamed from: e */
    private boolean f39811e = true;

    /* renamed from: f */
    private boolean f39812f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f39813g = false;

    public static RecoverStore getInstance() {
        return (RecoverStore) SingletonHolder.getInstance(RecoverStore.class);
    }

    private RecoverStore() {
        super("framework-RecoverStore");
    }

    public void orderRecover(Context context, final FetchCallback<RecoverInfo> fetchCallback) {
        if (this.f39813g) {
            f39807a.debug("当前已经在执行崩溃恢复，不再重复请求。。", new Object[0]);
            return;
        }
        String token = NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
        String kDToken = NationTypeUtil.getNationComponentData().getLoginInfo().getKDToken();
        String pid = NationTypeUtil.getNationComponentData().getLoginInfo().getPid();
        f39807a.debug("token: %s\nKDToken: %s\nuid: %s", token, kDToken, pid);
        if (!TextUtils.isEmpty(token) || !TextUtils.isEmpty(kDToken)) {
            this.f39813g = true;
            m29968b(context);
            new RpcService.Callback<RecoverInfo>() {
                public void onSuccess(RecoverInfo recoverInfo) {
                    RecoverStore.f39807a.debug("recoverInfo: %s", recoverInfo);
                    int errorNo = recoverInfo.getErrorNo();
                    if (errorNo == 0) {
                        fetchCallback.onSuccess(recoverInfo);
                    } else {
                        fetchCallback.onFail(errorNo);
                    }
                    boolean unused = RecoverStore.this.f39813g = false;
                }

                public void onFailure(IOException iOException) {
                    RecoverStore.f39807a.error("", iOException.getMessage());
                    fetchCallback.onFail(-1000);
                    boolean unused = RecoverStore.this.f39813g = false;
                }
            };
            HashMap hashMap = new HashMap();
            hashMap.put("token", token);
            hashMap.put("appversion", SystemUtil.getVersionName());
            hashMap.put(ServerParam.PARAM_DDRIVER_OSTYPE, "2");
            hashMap.put("osVersion", SystemUtil.getVersion());
            hashMap.put("model", SystemUtil.getModel());
            hashMap.put("timestamp", SystemUtil.getDeviceTime());
            hashMap.put("imei", SystemUtil.getIMEI());
            hashMap.put("imsi", SystemUtil.getIMSI());
            if (!TextUtils.isEmpty(pid)) {
                hashMap.put("uid", pid);
                hashMap.put(ServerParam.PARAM_DDRIVER_SWITCH, 1);
                hashMap.put("daijiaToken", kDToken);
            }
            CommonParamsUtil.addCommonParam(hashMap, context);
            Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_ORDER_RECOVER).addParams("enable_questionaire_recover", 1).setCallback(new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    int asInt = jsonObject.get("errno").getAsInt();
                    if (asInt != 0) {
                        fetchCallback.onFail(asInt);
                        boolean unused = RecoverStore.this.f39813g = false;
                        return;
                    }
                    RecoverInfo recoverInfo = (RecoverInfo) new Gson().fromJson((JsonElement) jsonObject.get("data").getAsJsonObject().get("orderrecover_info").getAsJsonObject(), RecoverInfo.class);
                    recoverInfo.setErrorNo(jsonObject.get("errno").getAsInt());
                    recoverInfo.setErrorMessage(jsonObject.get("errmsg").getAsString());
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.add("errno", jsonObject.get("errno"));
                    jsonObject2.add("errmsg", jsonObject.get("errmsg"));
                    jsonObject2.add("data", jsonObject.get("data").getAsJsonObject().get("order_detail"));
                    recoverInfo.setOrderDetail(jsonObject2.toString());
                    int errorNo = recoverInfo.getErrorNo();
                    if (errorNo == 0) {
                        fetchCallback.onSuccess(recoverInfo);
                    } else {
                        fetchCallback.onFail(errorNo);
                    }
                    boolean unused2 = RecoverStore.this.f39813g = false;
                }

                public void onFailure(IOException iOException) {
                    boolean unused = RecoverStore.this.f39813g = false;
                }
            }).build());
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("error", "no token");
        OmegaSDKAdapter.trackEvent("tone_orderrecover", (Map<String, Object>) hashMap2);
    }

    /* renamed from: a */
    private RpcServiceFactory m29966a(Context context) {
        if (this.f39810d == null) {
            this.f39810d = DDRpcServiceHelper.getRpcServiceFactory();
        }
        return this.f39810d;
    }

    /* renamed from: b */
    private RecoverService m29968b(Context context) {
        if (this.f39809c == null) {
            this.f39809c = (RecoverService) m29966a(context).newRpcService(RecoverService.class, Consts.getCommonApiByEnviroment(context));
        }
        return this.f39809c;
    }

    public static boolean isNewOrderRecover() {
        if (!TextUtils.isEmpty(Apollo.getToggle(f39808b).getName())) {
            return Apollo.getToggle(f39808b).allow();
        }
        return true;
    }

    public void setIsRecoverSuccess(boolean z) {
        Logger logger = f39807a;
        logger.debug("set isRecoverSuccess = " + z, new Object[0]);
        this.f39811e = z;
    }

    public boolean isRecoverSuccess() {
        return this.f39811e;
    }

    public void setIsSidebarOpen(boolean z) {
        Logger logger = f39807a;
        logger.debug("setIsSidebarOpen = " + z, new Object[0]);
        this.f39812f = z;
    }

    public void dispatchConfigEvent() {
        dispatchEvent(new DefaultEvent(ACTION_REFRESH_RECOVER));
    }

    public void dispatchForeceRefreshRecoverEvent() {
        dispatchEvent(new DefaultEvent(ACTION_REFRESH_RECOVER_FORCE));
    }

    public boolean canRecover() {
        Logger logger = f39807a;
        logger.debug("isSideBarOpen = " + this.f39812f + " isInHomePage = " + BusinessContextManager.getInstance().isInHomePage(), new Object[0]);
        if (!BusinessContextManager.getInstance().isInHomePage() || this.f39812f) {
            return false;
        }
        return true;
    }
}
