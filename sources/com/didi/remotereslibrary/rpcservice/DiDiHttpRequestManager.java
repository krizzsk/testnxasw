package com.didi.remotereslibrary.rpcservice;

import android.content.Context;
import android.os.Handler;
import com.didi.remotereslibrary.RemoteResourceManager;
import com.didi.remotereslibrary.response.BaseResponse;
import com.didi.remotereslibrary.response.IRemoteCallBack;
import com.didi.remotereslibrary.utils.C12329Util;
import com.didi.remotereslibrary.utils.DLog;
import com.didi.remotereslibrary.utils.H5GenUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.io.IOException;
import java.util.HashMap;

public class DiDiHttpRequestManager implements IRemoteResourceHttpRequestManager {

    /* renamed from: a */
    private RpcServiceFactory f35938a;

    /* renamed from: b */
    private Handler f35939b = UiThreadHandler.getsUiHandler();

    /* renamed from: c */
    private Context f35940c;

    public DiDiHttpRequestManager(Context context) {
        this.f35940c = context;
        this.f35938a = new RpcServiceFactory(context);
    }

    public long httpRequest(String str, HashMap hashMap, final BaseResponse baseResponse, final IRemoteCallBack iRemoteCallBack) {
        String str2 = str.startsWith("https") ? "https:" : "http:";
        HashMap<String, Object> createBaseParams = createBaseParams();
        createBaseParams.putAll(hashMap);
        String link = H5GenUtil.link(str, createBaseParams);
        HttpRpcRequest build = new HttpRpcRequest.Builder().get(link).build();
        DLog.m27099d(C12329Util.TAG, "请求链接:" + link);
        ((HttpRpcClient) this.f35938a.getRpcClient(str2)).newRpc(build).enqueue(new HttpRpc.Callback() {
            public void onSuccess(HttpRpcResponse httpRpcResponse) {
                DiDiHttpRequestManager.this.m27098a(httpRpcResponse, baseResponse, iRemoteCallBack);
            }

            public void onFailure(HttpRpcRequest httpRpcRequest, IOException iOException) {
                DLog.m27099d(C12329Util.TAG, "远程资源返回失败");
                IRemoteCallBack iRemoteCallBack = iRemoteCallBack;
                if (iRemoteCallBack != null) {
                    iRemoteCallBack.onError(null);
                }
            }
        });
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27098a(HttpRpcResponse httpRpcResponse, BaseResponse baseResponse, IRemoteCallBack iRemoteCallBack) {
        try {
            String convertStreamToString = C12329Util.convertStreamToString(httpRpcResponse.getEntity().getContent());
            DLog.m27099d(C12329Util.TAG, "远程资源返回成功:" + convertStreamToString);
            if (baseResponse != null) {
                baseResponse.parser(convertStreamToString);
            }
            if (iRemoteCallBack == null) {
                return;
            }
        } catch (Exception e) {
            DLog.m27099d(C12329Util.TAG, "远程资源返回异常:" + e.getMessage());
            if (iRemoteCallBack == null) {
                return;
            }
        } catch (Throwable th) {
            if (iRemoteCallBack != null) {
                iRemoteCallBack.onSuccess(baseResponse);
            }
            throw th;
        }
        iRemoteCallBack.onSuccess(baseResponse);
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Object> createBaseParams() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("appversion", SystemUtil.getVersionName(this.f35940c));
        hashMap.put("token", getToken());
        hashMap.put("os_type", "android");
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f35940c).getLastKnownLocation();
        if (lastKnownLocation != null) {
            hashMap.put("lat", Double.valueOf(lastKnownLocation.getLatitude()));
            hashMap.put("lng", Double.valueOf(lastKnownLocation.getLongitude()));
        } else {
            hashMap.put("lat", 0);
            hashMap.put("lng", 0);
        }
        return hashMap;
    }

    public static String getToken() {
        return RemoteResourceManager.getInstance().getLoginParam().getToken();
    }
}
