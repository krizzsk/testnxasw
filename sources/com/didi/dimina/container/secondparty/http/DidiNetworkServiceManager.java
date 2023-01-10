package com.didi.dimina.container.secondparty.http;

import android.util.Log;
import com.didi.dimina.container.service.NetworkService;
import com.didi.sdk.apm.SystemUtils;
import didihttp.DidiHttpClient;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class DidiNetworkServiceManager implements NetworkService {

    /* renamed from: a */
    private static final int f18994a = 180;

    /* renamed from: b */
    private static final int f18995b = 10;

    /* renamed from: c */
    private static final String f18996c = "abort";

    /* renamed from: d */
    private static DidiHttpClient f18997d;

    /* renamed from: e */
    private final C8140c f18998e = new C8140c();

    /* renamed from: f */
    private final C8138a f18999f = new C8138a();

    /* renamed from: g */
    private final C8141d f19000g = new C8141d();

    static {
        try {
            Class<?> cls = Class.forName("com.didichuxing.foundation.net.rpc.http.OkHttpRpcClient");
            Field declaredField = cls.getDeclaredField("CLIENT");
            declaredField.setAccessible(true);
            f18997d = (DidiHttpClient) declaredField.get(cls);
        } catch (Throwable th) {
            SystemUtils.log(3, "networking", "" + Log.getStackTraceString(th), (Throwable) null, "com.didi.dimina.container.secondparty.http.DidiNetworkServiceManager", 39);
        }
    }

    public DidiNetworkServiceManager() {
        if (f18997d == null) {
            DidiHttpClient build = new DidiHttpClient.Builder().readTimeout(180, TimeUnit.SECONDS).writeTimeout(180, TimeUnit.SECONDS).connectTimeout(180, TimeUnit.SECONDS).build();
            f18997d = build;
            build.dispatcher().setMaxRequests(10);
        }
    }

    public static DidiHttpClient getHttpClient() {
        return f18997d;
    }

    public static DidiHttpClient getHttpClient(long j) {
        return f18997d.newBuilder().connectTimeout(j, TimeUnit.MILLISECONDS).readTimeout(j, TimeUnit.MILLISECONDS).writeTimeout(j, TimeUnit.MILLISECONDS).build();
    }

    public void request(NetworkService.NetworkTaskModel.Request request, NetworkService.ITaskCallback iTaskCallback) {
        this.f18998e.mo60553a(this.f18998e.mo60551a(request, f18997d), request, iTaskCallback);
    }

    public void createRequestTask(String str, NetworkService.NetworkTaskModel.Request request, NetworkService.ITaskCallback iTaskCallback) {
        this.f18998e.mo60554a(str, this.f18998e.mo60552a(str, request, f18997d), request, iTaskCallback);
    }

    public void operateRequestTask(String str, String str2, JSONObject jSONObject, NetworkService.ITaskCallback iTaskCallback) {
        if (iTaskCallback != null && f18996c.equals(str2)) {
            boolean a = this.f18998e.mo60555a(str, f18997d);
            JSONObject jSONObject2 = new JSONObject();
            if (a) {
                try {
                    iTaskCallback.onSuccess(jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                iTaskCallback.onFailure(new Exception("请求池中无对应的taskId 请求"));
            }
        }
    }

    public void createDownloadTask(String str, NetworkService.NetworkTaskModel.Download download, NetworkService.ITaskCallback iTaskCallback) {
        this.f18999f.mo60549a(str, this.f18999f.mo60547a(str, download, f18997d), download, iTaskCallback);
    }

    public void operateDownloadTask(String str, String str2, JSONObject jSONObject, NetworkService.ITaskCallback iTaskCallback) {
        if (iTaskCallback != null && f18996c.equals(str2)) {
            boolean a = this.f18999f.mo60550a(str, f18997d);
            JSONObject jSONObject2 = new JSONObject();
            if (a) {
                try {
                    iTaskCallback.onSuccess(jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                iTaskCallback.onFailure(new Exception("请求池中无对应的taskId 请求"));
            }
        }
    }

    public void downloadFile(NetworkService.NetworkTaskModel.Download download, NetworkService.ITaskCallback iTaskCallback) {
        this.f18999f.mo60548a(this.f18999f.mo60546a(download, f18997d), download, iTaskCallback);
    }

    public void createUploadTask(String str, NetworkService.NetworkTaskModel.Upload upload, NetworkService.ITaskCallback iTaskCallback) {
        this.f19000g.mo60559a(str, this.f19000g.mo60557a(str, upload, f18997d, iTaskCallback), upload, iTaskCallback);
    }

    public void operateUploadTask(String str, String str2, JSONObject jSONObject, NetworkService.ITaskCallback iTaskCallback) {
        if (iTaskCallback != null && f18996c.equals(str2)) {
            boolean a = this.f19000g.mo60560a(str, f18997d);
            JSONObject jSONObject2 = new JSONObject();
            if (a) {
                try {
                    iTaskCallback.onSuccess(jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                iTaskCallback.onFailure(new Exception("请求池中无对应的taskId 请求"));
            }
        }
    }

    public void uploadFile(NetworkService.NetworkTaskModel.Upload upload, NetworkService.ITaskCallback iTaskCallback) {
        this.f19000g.mo60558a(this.f19000g.mo60556a(upload, f18997d, iTaskCallback), upload, iTaskCallback);
    }
}
