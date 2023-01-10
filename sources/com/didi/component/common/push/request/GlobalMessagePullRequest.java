package com.didi.component.common.push.request;

import android.content.Context;
import android.os.Build;
import com.didi.sdk.common.DDRpcServiceHelper;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.Utils;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didichuxing.foundation.rpc.RpcService;
import java.util.HashMap;

public class GlobalMessagePullRequest extends BaseRequest {

    /* renamed from: a */
    private static final String f13541a = "https://msggate.didiglobal.com/";

    /* renamed from: b */
    private C5367a f13542b = ((C5367a) DDRpcServiceHelper.getRpcServiceFactory().newRpcService(C5367a.class, "https://msggate.didiglobal.com/"));

    public void getMessageFromServerByPull(Context context, RpcService.Callback<String> callback) {
        NationComponentData.LoginInfo loginInfo = NationTypeUtil.getNationComponentData().getLoginInfo();
        if (loginInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("token", loginInfo.getToken());
            hashMap.put(ServerParam.PARAM_APP_TYPE_PUSH, AppUtils.getMetaDataByKey(EventKeys.APP_FCM_APPKEY));
            hashMap.put("uid", loginInfo.getUid());
            hashMap.put("brand", Build.BOARD);
            hashMap.put("platform", "android");
            hashMap.put("appversion", Utils.getCurrentVersion(context));
            this.f13542b.mo51896a((HashMap<String, Object>) hashMap, callback);
        }
    }
}
