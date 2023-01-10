package com.didichuxing.diface.biz.bioassay.alpha.p181M.compare;

import android.content.Context;
import com.didichuxing.dfbasesdk.http.BizAccessInterceptor;
import com.didichuxing.dfbasesdk.http.SecurityAccessWsgInterceptor;
import com.didichuxing.dfbasesdk.utils.HttpParamUtils;
import com.didichuxing.diface.biz.bioassay.alpha.p181M.compare.CompareModel;
import com.didichuxing.diface.utils.HttpUtils;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.http.MultipartSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.compare.RealCompareModel */
public class RealCompareModel {

    /* renamed from: b */
    private static final String f49821b = "dd_face_global_compare";

    /* renamed from: a */
    private Context f49822a;

    @Timeout(connectTimeout = 30000, readTimeout = 30000, writeTimeout = 30000)
    @Interception({BizAccessInterceptor.class})
    /* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.compare.RealCompareModel$ICompareRequester */
    public interface ICompareRequester extends RpcService {
        @Serialization(MultipartSerializer.class)
        @Post(contentType = "multipart/form-data")
        @Deserialization(GsonDeserializer.class)
        @Interception({SecurityAccessWsgInterceptor.class})
        void compare(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, RpcService.Callback<CompareResult> callback);
    }

    public RealCompareModel(Context context) {
        this.f49822a = context.getApplicationContext();
    }

    public void compare(CompareParam compareParam, List<String> list, List<File> list2, final AbsHttpCallback<CompareResult> absHttpCallback) {
        CompareModel.ICompareRequester iCompareRequester = (CompareModel.ICompareRequester) new RpcServiceFactory(this.f49822a).newRpcService(CompareModel.ICompareRequester.class, HttpUtils.getHostNew(f49821b));
        String json = new Gson().toJson((Object) compareParam);
        Map<String, Object> queryParam = HttpParamUtils.getQueryParam(json);
        TreeMap<String, Object> convertObj2Map = HttpParamUtils.convertObj2Map(json);
        if (convertObj2Map == null) {
            convertObj2Map = new TreeMap<>();
        }
        if (!(list == null || list2 == null || list.size() != list2.size())) {
            for (int i = 0; i < list.size(); i++) {
                convertObj2Map.put(list.get(i), list2.get(i));
            }
        }
        iCompareRequester.compare(queryParam, convertObj2Map, new RpcService.Callback<CompareResult>() {
            public void onSuccess(CompareResult compareResult) {
                HttpUtils.successCallbackSwitch(absHttpCallback, compareResult);
            }

            public void onFailure(IOException iOException) {
                HttpUtils.failedCallbackSwitch(absHttpCallback, iOException);
            }
        });
    }
}
