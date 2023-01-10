package com.didichuxing.gbankcard.ocr.log;

import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.data.BaseInnerResult;
import com.didichuxing.dfbasesdk.http.AbsOkHttpCallback;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.SPHelper;
import com.didichuxing.gbankcard.ocr.network.GBankcardApi;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class GLogReporter {

    /* renamed from: f */
    private static final String f50269f = "gbankcard_logs_prefs";

    /* renamed from: a */
    private final String f50270a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f50271b;

    /* renamed from: c */
    private final String f50272c;

    /* renamed from: d */
    private final JSONArray f50273d = new JSONArray();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final SPHelper f50274e;

    public GLogReporter(String str, String str2) {
        this.f50270a = str;
        this.f50271b = UUID.randomUUID().toString();
        this.f50272c = str2;
        this.f50274e = new SPHelper(AppContextHolder.getAppContext(), f50269f);
    }

    public void report(LogData logData) {
        logData.setSeqId(this.f50271b);
        this.f50273d.put(logData.toJsonObj());
    }

    public void onEnter() {
        LogUtils.m37051d("onEnter called...");
        Map<String, ?> all = this.f50274e.getAll();
        if (all == null || all.isEmpty()) {
            LogUtils.m37051d("no logs left before, nice...");
        } else {
            m37606a(all);
        }
    }

    /* renamed from: a */
    private void m37606a(Map<String, ?> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", this.f50270a);
            jSONObject.put(GBankcardApi.KEY_CLIENT_DEVICE_INFO, this.f50272c);
            JSONArray jSONArray = new JSONArray();
            final Set<String> keySet = map.keySet();
            LogUtils.m37051d("uploadLeftLogs, size===" + keySet.size());
            for (Map.Entry next : map.entrySet()) {
                LogUtils.m37051d("leftLogs seqId===" + ((String) next.getKey()));
                JSONArray jSONArray2 = new JSONArray((String) next.getValue());
                for (int i = 0; i < jSONArray2.length(); i++) {
                    jSONArray.put(jSONArray2.getJSONObject(i));
                }
            }
            jSONObject.put("jsonArray", jSONArray);
            m37605a(jSONObject.toString(), new AbsOkHttpCallback<BaseInnerResult>() {
                public void onSuccess(BaseInnerResult baseInnerResult) {
                    LogUtils.m37051d("leftLogs, report_sdk_data ok...");
                    for (String remove : keySet) {
                        GLogReporter.this.f50274e.remove(remove);
                    }
                    GLogReporter.this.f50274e.apply();
                }

                public void onFailed(int i, String str) {
                    LogUtils.m37051d("leftLogs, report_sdk_data failed, code===" + i + ", msg=" + str);
                }
            });
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }

    /* renamed from: a */
    private void m37605a(String str, AbsOkHttpCallback<BaseInnerResult> absOkHttpCallback) {
        GBankcardApi.getInstance().reportSdkData("risk_ocr_global_report_sdk_data", str, absOkHttpCallback);
    }

    public void onExit() {
        LogUtils.m37051d("onExit called...");
        m37604a();
    }

    /* renamed from: a */
    private void m37604a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", this.f50270a);
            jSONObject.put(GBankcardApi.KEY_CLIENT_DEVICE_INFO, this.f50272c);
            jSONObject.put("jsonArray", this.f50273d);
            String jSONObject2 = jSONObject.toString();
            this.f50274e.put(this.f50271b, this.f50273d.toString()).apply();
            m37605a(jSONObject2, new AbsOkHttpCallback<BaseInnerResult>() {
                public void onSuccess(BaseInnerResult baseInnerResult) {
                    LogUtils.m37051d("report_sdk_data ok...");
                    GLogReporter.this.f50274e.remove(GLogReporter.this.f50271b).apply();
                }

                public void onFailed(int i, String str) {
                    LogUtils.m37051d("report_sdk_data failed, code===" + i + ", msg=" + str);
                }
            });
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }
}
