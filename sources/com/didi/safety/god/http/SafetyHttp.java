package com.didi.safety.god.http;

import android.content.Context;
import android.os.Build;
import com.didi.safety.god.util.LogUtils;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.http.MultipartSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.HashMap;
import java.util.Map;

public class SafetyHttp {
    public static final int CODE_PARAMS_ERROR = 100001;
    public static final int CODE_SUCCESS = 100000;
    public static final int CODE_TIMEOUT = 200001;
    public static final int ENV_OFFLINE = 2;
    public static final int ENV_ONLINE = 0;
    public static final int ENV_PRE = 1;
    public static final String ENV_SWITCH_KEY = "doorgodEnv";
    public static final int ENV_TEMP_OFFLINE = 3;

    /* renamed from: a */
    private static String f37335a = "https://api-sec.didiglobal.com";

    /* renamed from: b */
    private static final String f37336b = "https://api-sec.didiglobal.com";

    /* renamed from: c */
    private static final String f37337c = "https://api-sec.didiglobal.comm";

    /* renamed from: d */
    private static String f37338d = "";

    /* renamed from: e */
    private static Map<String, Object> f37339e = new HashMap();

    /* renamed from: f */
    private static Map<String, Object> f37340f = new HashMap();

    public enum HttpAction {
        RETRY,
        QUIT,
        SUCCESS
    }

    public interface SafetyRequest extends RpcService {
        @Deserialization(DownloadDeserializer.class)
        Object downloadFile(@BodyParameter("") Map<String, Object> map, @QueryParameter("") Map<String, Object> map2, @TargetThread(ThreadType.WORKER) RpcService.Callback<Long> callback);

        @Post
        @Deserialization(StringDeserializer.class)
        Object getCarColorList(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

        @Deserialization(StringDeserializer.class)
        Object getCarModelList(@TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

        @Deserialization(StringDeserializer.class)
        Object getCarNumPreCode(@TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

        @Serialization(MultipartSerializer.class)
        @Path("/sec/risk-gateway/common/risk_god_global_init_config")
        @Post(contentType = "multipart/form-data")
        @Deserialization(GsonDeserializer.class)
        Object getInitConfig2(@BodyParameter("") Map<String, Object> map, @QueryParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<SafetyResponse2<InitConfigResp2>> callback);

        @Serialization(MultipartSerializer.class)
        @Path("/sec/risk-gateway/common/risk_god_global_get_keeperid")
        @Post(contentType = "multipart/form-data")
        @Deserialization(GsonDeserializer.class)
        Object getKeeperId(@BodyParameter("") Map<String, Object> map, @QueryParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<SafetyResponse<KeeperIdResponse>> callback);

        @Serialization(MultipartSerializer.class)
        @Path("/sec/risk-gateway/common/risk_god_global_get_keeperid")
        @Post(contentType = "multipart/form-data")
        @Deserialization(GsonDeserializer.class)
        Object getKeeperId2(@BodyParameter("") Map<String, Object> map, @QueryParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<SafetyResponse2<KeeperIdResp2>> callback);

        @Serialization(MultipartSerializer.class)
        @Path("/sec/risk-gateway/common/risk_god_cards_ocr_read")
        @Post(contentType = "multipart/form-data")
        @Deserialization(StringDeserializer.class)
        Object getOcrInfo(@BodyParameter("") Map<String, Object> map, @QueryParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

        @Serialization(MultipartSerializer.class)
        @Path("/sec/risk-gateway/common/risk_god_new_get_ocr")
        @Post(contentType = "multipart/form-data")
        @Deserialization(StringDeserializer.class)
        Object getOcrInfo2(@BodyParameter("") Map<String, Object> map, @QueryParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

        @Serialization(MultipartSerializer.class)
        @Path("/sec/risk-gateway/common/risk_zues_ocr_apply_keeperId")
        @Post(contentType = "multipart/form-data")
        @Deserialization(GsonDeserializer.class)
        Object getOcrKeeperId(@BodyParameter("") Map<String, Object> map, @QueryParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<SafetyResponse<KeeperIdResponse>> callback);

        @Serialization(MultipartSerializer.class)
        @Path("/sec/risk-gateway/common/risk_god_global_check_sdk")
        @Post(contentType = "multipart/form-data")
        @Deserialization(StringDeserializer.class)
        Object globalCheckSdk(@BodyParameter("") Map<String, Object> map, @QueryParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

        @Serialization(MultipartSerializer.class)
        @Path("/sec/risk-gateway/common/risk_god_save_ocr_v2")
        @Post(contentType = "multipart/form-data")
        @Deserialization(StringDeserializer.class)
        Object uploadFile(@BodyParameter("") Map<String, Object> map, @QueryParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

        @Serialization(MultipartSerializer.class)
        @Path("/sec/risk-gateway/common/risk_god_global_upload")
        @Post(contentType = "multipart/form-data")
        @Deserialization(StringDeserializer.class)
        Object uploadFile2(@BodyParameter("") Map<String, Object> map, @QueryParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

        @Serialization(MultipartSerializer.class)
        @Path("/sec/risk-gateway/common/risk_god_save_ocr_local_pic")
        @Post(contentType = "multipart/form-data")
        @Deserialization(StringDeserializer.class)
        Object uploadLocalAlbumPic(@BodyParameter("") Map<String, Object> map, @QueryParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

        @Serialization(MultipartSerializer.class)
        @Path("/sec/risk-gateway/common/risk_god_new_vin_analysis")
        @Post(contentType = "multipart/form-data")
        @Deserialization(GsonDeserializer.class)
        Object vinAnalize2(@BodyParameter("") Map<String, Object> map, @QueryParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<SafetyResponse2<VinAnalizeResp2>> callback);

        @Serialization(MultipartSerializer.class)
        @Path("/sec/risk-gateway/common/risk_god_new_x1_rule_check")
        @Post(contentType = "multipart/form-data")
        @Deserialization(GsonDeserializer.class)
        Object x1RuleCheck(@BodyParameter("") Map<String, Object> map, @QueryParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<SafetyResponse2<X1RuleCheckResp2>> callback);
    }

    public static HttpAction getHttpAction(int i) {
        if (i == 200001 || i == 100001) {
            return HttpAction.QUIT;
        }
        if (i == 100000) {
            return HttpAction.SUCCESS;
        }
        return HttpAction.RETRY;
    }

    public static void switchOnOff(boolean z) {
        boolean equals = f37338d.equals("");
        String str = f37336b;
        if (!equals) {
            if (z) {
                str = f37338d;
            }
            f37335a = str;
            return;
        }
        f37335a = str;
    }

    public static void setOffLineEnv(String str) {
        f37338d = str;
        LogUtils.m28307d("HOST_OFFLINE is " + f37338d);
    }

    public static void setApiEnv(int i) {
        if (i == 0) {
            f37335a = f37336b;
        } else if (i == 1) {
            f37335a = f37337c;
        }
    }

    public static String getApiHost() {
        return f37335a;
    }

    public static String getFullLogApi() {
        return getApiHost() + "/sec/risk-gateway/common/risk_god_global_burypoint_v2?apiVersion=1.0.0&postKey=data";
    }

    public static void initParams(Context context) {
        f37340f.clear();
        f37340f.put("model", SystemUtil.getModel());
        f37340f.put("brand", Build.BRAND);
        f37340f.put("sdkVer", "7.0.0.7");
        f37340f.put("sysVer", Build.VERSION.RELEASE);
        f37340f.put("appVer", SystemUtil.getVersionName(context));
        f37340f.put("appPac", context.getPackageName());
        f37340f.put("imei", SystemUtil.getIMEI());
        f37340f.put("isWifi", SystemUtil.getNetworkType());
        f37339e.put("apiVersion", "1.0.0");
    }

    public static void initParams2020(Context context) {
        initParams(context);
        f37340f.put("newP", 1);
    }

    public static void setNation(String str) {
        f37340f.put("nation", str);
    }

    public static Map<String, Object> getQueryParams() {
        return f37339e;
    }

    public static Map<String, Object> getCommonBodyParams() {
        return f37340f;
    }
}
