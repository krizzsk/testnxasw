package com.didiglobal.dittoview.mvvm;

import android.text.TextUtils;
import com.didi.global.globaluikit.utils.JsonUtil;
import com.didichuxing.publicservice.p196db.model.ScreenAdNewModel;
import com.didiglobal.dittoview.DittoEventListener;
import com.didiglobal.dittoview.callback.CDNCallback;
import com.didiglobal.dittoview.impl.DittoEventListenerImpl;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DittoData {
    protected CDNCallback CDNCallback;
    protected String cdn;
    protected JSONObject data;
    protected Map<String, Object> ext = new HashMap();
    protected JSONObject extension;

    /* renamed from: id */
    protected String f52459id;
    protected DittoEventListener mEventListener = new DittoEventListenerImpl(this);
    protected JSONObject originalData;
    protected String template;

    public DittoData() {
    }

    public DittoData(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2) {
        this.f52459id = str;
        this.template = str2;
        this.cdn = str3;
        this.data = jSONObject;
        this.extension = jSONObject2;
        m39441a();
    }

    public DittoData(String str, String str2, String str3, JsonObject jsonObject, JsonObject jsonObject2) {
        this.f52459id = str;
        this.template = str2;
        this.cdn = str3;
        if (jsonObject != null) {
            try {
                this.data = new JSONObject(jsonObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (jsonObject2 != null) {
            try {
                this.extension = new JSONObject(jsonObject2.toString());
                m39441a();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public DittoData(String str, String str2, String str3, String str4, String str5) {
        this.f52459id = str;
        this.template = str2;
        this.cdn = str3;
        try {
            this.data = new JSONObject(str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (str5 != null) {
            try {
                this.extension = new JSONObject(str5);
                m39441a();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public JSONObject getOriginalData() {
        return this.originalData;
    }

    public String getId() {
        return this.f52459id;
    }

    public String getTemplate() {
        return this.template;
    }

    public JSONObject getData() {
        return this.data;
    }

    public JSONObject getExtension() {
        return this.extension;
    }

    public String getCdn() {
        return this.cdn;
    }

    public CDNCallback getCDNCallback() {
        return this.CDNCallback;
    }

    public void setCDNCallback(CDNCallback cDNCallback) {
        this.CDNCallback = cDNCallback;
    }

    public void setEventListener(DittoEventListener dittoEventListener) {
        this.mEventListener = dittoEventListener;
    }

    public DittoEventListener getEventListener() {
        return this.mEventListener;
    }

    public Map<String, Object> getExt() {
        return this.ext;
    }

    public void setId(String str) {
        this.f52459id = str;
    }

    public void setTemplate(String str) {
        this.template = str;
    }

    public void setData(JSONObject jSONObject) {
        this.data = jSONObject;
    }

    public void setExtension(JSONObject jSONObject) {
        this.extension = jSONObject;
        m39441a();
    }

    public void setCdn(String str) {
        this.cdn = str;
    }

    public DittoData parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.originalData = jSONObject;
        this.f52459id = jSONObject.optString("id");
        this.template = jSONObject.optString("template");
        this.cdn = jSONObject.optString(ScreenAdNewModel.ScreenAdNewColumn.CDN);
        this.data = jSONObject.optJSONObject("data");
        this.extension = jSONObject.optJSONObject("extension");
        m39441a();
        return this;
    }

    /* renamed from: a */
    private void m39441a() {
        JSONObject optJSONObject;
        JSONObject jSONObject = this.extension;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("log_data")) != null) {
            try {
                this.ext = JsonUtil.jsonToMap(optJSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String debugInfo() {
        return String.format("{id:%s,template:%s,hasCDN:%s}", new Object[]{this.f52459id, this.template, Boolean.valueOf(!TextUtils.isEmpty(this.cdn))});
    }
}
