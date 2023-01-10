package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detectionjob;

import com.didichuxing.mas.sdk.quality.report.backend.UploadStrategy;
import com.didichuxing.mas.sdk.quality.report.transport.HttpSender;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class DetectionJobFetcher {
    public DetectionJobs fetch() {
        String a = m37633a();
        DetectionJobs detectionJobs = new DetectionJobs();
        return (a == null || a.length() <= 0) ? detectionJobs : mo124330a(a);
    }

    /* renamed from: a */
    private String m37633a() {
        try {
            return HttpSender.get(UploadStrategy.getUploadCNDUrl(), (Map<String, String>) null).getBody();
        } catch (Throwable th) {
            OLog.m37861e("Throwable getHttpResponse fail" + th.getMessage());
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public DetectionJobs mo124330a(String str) {
        DetectionJobs detectionJobs = new DetectionJobs();
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            detectionJobs.setErrorNo(jSONObject.getInt("errno"));
            if (detectionJobs.getErrorNo() == 0) {
                JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("cdn_list");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    detectionJobs.addDetectionJob((String) jSONObject2.get("url"), (String) jSONObject2.get("md5"), jSONObject2.has("ccc") ? (String) jSONObject2.get("ccc") : "");
                }
            }
        } catch (Exception unused) {
            OLog.m37867w("other exception parseResponse.");
        }
        return detectionJobs;
    }
}
