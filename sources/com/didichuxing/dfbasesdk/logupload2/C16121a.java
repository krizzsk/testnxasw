package com.didichuxing.dfbasesdk.logupload2;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.logupload.UploadObj;
import com.didichuxing.dfbasesdk.logupload2.LogUploadModel;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.didichuxing.dfbasesdk.utils.HttpParamUtils;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didichuxing.dfbasesdk.logupload2.a */
/* compiled from: LogUploader2 */
class C16121a {

    /* renamed from: a */
    private final Handler f49319a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f49320b;

    /* renamed from: c */
    private RpcServiceFactory f49321c = new RpcServiceFactory(AppContextHolder.getAppContext());

    C16121a(Handler handler) {
        this.f49319a = handler;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36993a(int i, Object obj) {
        Message obtain = Message.obtain(this.f49319a);
        obtain.what = i;
        obtain.obj = obj;
        obtain.sendToTarget();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo122328a(String str, UploadObj uploadObj, String str2, boolean z) {
        if (!z) {
            mo122326a(str, uploadObj, str2);
            return;
        }
        this.f49320b = true;
        List<Object> list = uploadObj.ids;
        HashMap hashMap = new HashMap();
        try {
            JsonObject asJsonObject = new JsonParser().parse(uploadObj.jsonBody).getAsJsonObject();
            if (TextUtils.isEmpty(str2) || !str2.equals("data")) {
                hashMap.put("jsonArray", asJsonObject.get(str2).getAsString());
            } else {
                hashMap.put("data", asJsonObject.get(str2).getAsString());
            }
            hashMap.put("sc", asJsonObject.get("sc").getAsString());
            ((LogUploadModel.ILogUploadRequester) this.f49321c.newRpcService(LogUploadModel.ILogUploadRequester.class, str)).logUploadRequester(HttpParamUtils.getQueryParam(GsonUtils.toJson(hashMap)), hashMap, new LogUploader2$1(this, list));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo122326a(String str, UploadObj uploadObj, String str2) {
        this.f49320b = true;
        List<Object> list = uploadObj.ids;
        HashMap hashMap = new HashMap();
        try {
            if (TextUtils.isEmpty(str2) || !str2.equals("data")) {
                hashMap.put("jsonArray", new Gson().fromJson((JsonElement) new JsonParser().parse(uploadObj.jsonBody).getAsJsonObject().getAsJsonArray(str2), new LogUploader2$3(this).getType()));
            } else {
                hashMap.put("data", new Gson().fromJson((JsonElement) new JsonParser().parse(uploadObj.jsonBody).getAsJsonObject().getAsJsonArray(str2), new LogUploader2$2(this).getType()));
            }
            ((LogUploadModel.ILogUploadRequester) this.f49321c.newRpcService(LogUploadModel.ILogUploadRequester.class, str)).logUploadRequester(HttpParamUtils.getQueryParam(GsonUtils.toJson(hashMap)), hashMap, new LogUploader2$4(this, list));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo122327a(String str, UploadObj uploadObj, String str2, String str3) {
        int i = 1;
        this.f49320b = true;
        List<Object> list = uploadObj.ids;
        HashMap hashMap = new HashMap();
        try {
            if (TextUtils.isEmpty(str2) || !str2.equals("data")) {
                hashMap.put("jsonArray", new Gson().fromJson((JsonElement) new JsonParser().parse(uploadObj.jsonBody).getAsJsonObject().getAsJsonArray(str2), new LogUploader2$6(this).getType()));
            } else {
                hashMap.put("data", new Gson().fromJson((JsonElement) new JsonParser().parse(uploadObj.jsonBody).getAsJsonObject().getAsJsonArray(str2), new LogUploader2$5(this).getType()));
            }
            if (!TextUtils.isEmpty(str3)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append("_1_");
                if (TextUtils.isEmpty(uploadObj.jsonBody)) {
                    i = 0;
                }
                sb.append(i);
                hashMap.put("extraData", sb.toString());
            }
            ((LogUploadModel.ILogUploadRequester) this.f49321c.newRpcService(LogUploadModel.ILogUploadRequester.class, str)).logUploadRequester(HttpParamUtils.getQueryParam(GsonUtils.toJson(hashMap)), hashMap, new LogUploader2$7(this, list));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo122329a() {
        return this.f49320b;
    }
}
