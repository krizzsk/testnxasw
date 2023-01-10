package com.didi.sdk.fusionbridge;

import android.content.Context;
import android.text.TextUtils;
import com.didi.onehybrid.util.C11212Util;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.store.WebConfigStore;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FusionUrlRecorder {

    /* renamed from: a */
    private static final String f38732a = "tone_p_x_fusion_user_link_path";

    /* renamed from: b */
    private static final String f38733b = "access_path";

    /* renamed from: c */
    private static final String f38734c = "extern_count";

    /* renamed from: d */
    private static final int f38735d = 30;

    /* renamed from: e */
    private final Context f38736e;

    /* renamed from: f */
    private final WebConfigStore f38737f;

    /* renamed from: g */
    private final LinkedList<UrlInfo> f38738g;

    /* renamed from: h */
    private int f38739h = 0;

    public FusionUrlRecorder(Context context) {
        this.f38736e = context;
        this.f38737f = WebConfigStore.getInstance();
        this.f38738g = new LinkedList<>();
    }

    public void recordUrl(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            boolean isWhiteUrl = this.f38737f.isWhiteUrl(str, this.f38736e);
            if (!isWhiteUrl) {
                this.f38739h++;
            }
            this.f38738g.add(new UrlInfo(str, str2, isWhiteUrl));
            if (this.f38738g.size() > 30) {
                this.f38738g.remove(0);
            }
        }
    }

    public void flush() {
        if (this.f38738g.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f38738g.iterator();
            while (it.hasNext()) {
                jSONArray.put(((UrlInfo) it.next()).toJSON());
            }
            HashMap hashMap = new HashMap();
            hashMap.put(f38733b, jSONArray.toString());
            hashMap.put(f38734c, Integer.valueOf(this.f38739h));
            if (C11212Util.isApkDebug(this.f38736e)) {
                SystemUtils.log(4, "FusionUrl", hashMap.toString(), (Throwable) null, "com.didi.sdk.fusionbridge.FusionUrlRecorder", 74);
            }
            OmegaSDKAdapter.trackEvent(f38732a, (Map<String, Object>) hashMap);
        }
    }

    private class UrlInfo {
        private boolean hasToken;
        private boolean isExtern;
        private boolean isHttps;
        private String title;
        private String url;

        public UrlInfo(String str, String str2, boolean z) {
            this.title = str2;
            this.isHttps = str.startsWith("https://");
            if (str.contains("?")) {
                String[] split = str.split("\\?");
                this.url = split[0];
                if (split.length >= 2) {
                    this.hasToken = split[1].contains("token=");
                } else {
                    this.hasToken = false;
                }
            } else {
                this.url = str;
                this.hasToken = false;
            }
            this.isExtern = !z;
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.url);
                jSONObject.put("title", this.title);
                jSONObject.put("isHttps", this.isHttps);
                jSONObject.put("hasToken", this.hasToken);
                jSONObject.put("isExtern", this.isExtern);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
