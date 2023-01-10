package com.didichuxing.request;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didichuxing.bean.UpdateResponse;
import com.didichuxing.util.HttpParamUtils;
import com.didichuxing.util.UpLogger;
import com.didichuxing.util.UpgradeSp;
import com.didiglobal.enginecore.data.parser.XEParseConst;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class UpgradeRequester extends UpgradeBaseRequest {

    /* renamed from: a */
    private static final String f51064a = "UpgradeSDK_InfoRequester";

    /* renamed from: b */
    private static final int f51065b = 999;

    /* renamed from: c */
    private HttpURLConnection f51066c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RequestCallback f51067d;

    /* renamed from: e */
    private Map<String, String> f51068e = new HashMap();

    /* renamed from: f */
    private Handler f51069f = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (UpgradeRequester.this.f51067d != null) {
                if (message == null) {
                    UpgradeRequester.this.f51067d.requestFailed(999);
                    return;
                }
                UpdateResponse updateResponse = (UpdateResponse) message.obj;
                if (updateResponse != null) {
                    UpgradeRequester.this.f51067d.requestSucceed(updateResponse);
                    return;
                }
                UpgradeRequester.this.f51067d.requestFailed(message.what);
                UpLogger.m38965d(UpgradeRequester.f51064a, "request update info failed. errCode = " + message.what);
            }
        }
    };

    public interface RequestCallback {
        void requestFailed(int i);

        void requestSucceed(UpdateResponse updateResponse);
    }

    public UpgradeRequester(Context context, RequestCallback requestCallback) {
        C17081a.m38235a(context, this.f51068e);
        C17081a.m38237b(context, this.f51068e);
        C17081a.m38236a(this.f51068e);
        Map<String, String> map = this.f51068e;
        map.put("gp_test", UpgradeSp.Companion.getInstance().getHasJoinedPlan() + "");
        this.f51067d = requestCallback;
    }

    /* renamed from: a */
    public void mo126708a() {
        StringBuilder sb = new StringBuilder(getHost() + "/muse/update/v2?");
        Map<String, String> map = this.f51068e;
        if (map != null) {
            sb.append(HttpParamUtils.getParamStrStr(map));
        }
        String sb2 = sb.toString();
        UpLogger.m38965d(f51064a, "request url = " + sb2);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(sb2).openConnection();
            this.f51066c = httpURLConnection;
            httpURLConnection.setRequestMethod("GET");
            this.f51066c.setConnectTimeout(15000);
            this.f51066c.connect();
            int responseCode = this.f51066c.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = this.f51066c.getInputStream();
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String byteArrayOutputStream2 = byteArrayOutputStream.toString("utf-8");
                inputStream.close();
                byteArrayOutputStream.close();
                UpdateResponse a = m38231a(byteArrayOutputStream2);
                if (a != null) {
                    this.f51067d.requestSucceed(a);
                    UpLogger.m38965d(f51064a, "request response = " + a.toString());
                } else {
                    this.f51067d.requestFailed(999);
                    UpLogger.m38965d(f51064a, "request fail code = " + responseCode);
                }
            } else {
                this.f51067d.requestFailed(responseCode);
                UpLogger.m38965d(f51064a, "request fail code = " + responseCode);
            }
        } catch (Exception e) {
            this.f51069f.sendEmptyMessage(999);
            e.printStackTrace();
        } catch (Throwable th) {
            this.f51066c.disconnect();
            throw th;
        }
        this.f51066c.disconnect();
    }

    /* renamed from: a */
    private static UpdateResponse m38231a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("err_no");
            String optString = jSONObject.optString("err_msg");
            if (optInt != 0) {
                return new UpdateResponse(optInt, optString);
            }
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
            String optString2 = jSONObject2.optString("abn_content");
            String optString3 = jSONObject2.optString("abn_ignore");
            String optString4 = jSONObject2.optString("abn_title");
            String optString5 = jSONObject2.optString("abn_update");
            boolean optBoolean = jSONObject2.optBoolean("is_force");
            boolean optBoolean2 = jSONObject2.optBoolean("need_update");
            int optInt2 = jSONObject2.optInt("task_id");
            int optInt3 = jSONObject2.optInt(XEParseConst.UPDATE_TYPE_TAG);
            String optString6 = jSONObject2.optString("update_url");
            String optString7 = jSONObject2.optString("version");
            int optInt4 = jSONObject2.optInt(ServerParam.PARAM_VERSION_CODE);
            int optInt5 = jSONObject2.optInt("version_id");
            UpdateResponse.Builder builder = new UpdateResponse.Builder();
            builder.errNum(optInt).errMsg(optString).updateDesc(optString2).ignoreBtn(optString3).updateTitle(optString4).isForce(optBoolean).updateBtn(optString5).needUpdate(optBoolean2).taskId(optInt2).updateType(optInt3).updateUrl(optString6).version(optString7).versionCode(optInt4).versionId(optInt5);
            return builder.builder();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
