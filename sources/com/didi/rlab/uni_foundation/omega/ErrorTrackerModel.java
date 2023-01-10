package com.didi.rlab.uni_foundation.omega;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Map;

public class ErrorTrackerModel extends UniModel {

    /* renamed from: a */
    private String f36846a;

    /* renamed from: b */
    private String f36847b;

    /* renamed from: c */
    private String f36848c;

    /* renamed from: d */
    private String f36849d;

    /* renamed from: e */
    private Map<String, Object> f36850e;

    public String getModuleName() {
        return this.f36846a;
    }

    public void setModuleName(String str) {
        this.f36846a = str;
    }

    public String getErrorName() {
        return this.f36847b;
    }

    public void setErrorName(String str) {
        this.f36847b = str;
    }

    public String getErrorCode() {
        return this.f36848c;
    }

    public void setErrorCode(String str) {
        this.f36848c = str;
    }

    public String getErrorMsg() {
        return this.f36849d;
    }

    public void setErrorMsg(String str) {
        this.f36849d = str;
    }

    public Map<String, Object> getParameters() {
        return this.f36850e;
    }

    public void setParameters(Map<String, Object> map) {
        this.f36850e = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("moduleName", this.f36846a);
        hashMap.put("errorName", this.f36847b);
        hashMap.put(Constants.ERROR_CODE, this.f36848c);
        hashMap.put("errorMsg", this.f36849d);
        hashMap.put("parameters", this.f36850e);
        return hashMap;
    }

    public static ErrorTrackerModel fromMap(Map<String, Object> map) {
        ErrorTrackerModel errorTrackerModel = new ErrorTrackerModel();
        String str = "";
        errorTrackerModel.f36846a = (!map.containsKey("moduleName") || map.get("moduleName") == null) ? str : (String) map.get("moduleName");
        errorTrackerModel.f36847b = (!map.containsKey("errorName") || map.get("errorName") == null) ? str : (String) map.get("errorName");
        errorTrackerModel.f36848c = (!map.containsKey(Constants.ERROR_CODE) || map.get(Constants.ERROR_CODE) == null) ? str : (String) map.get(Constants.ERROR_CODE);
        if (map.containsKey("errorMsg") && map.get("errorMsg") != null) {
            str = (String) map.get("errorMsg");
        }
        errorTrackerModel.f36849d = str;
        errorTrackerModel.f36850e = (!map.containsKey("parameters") || map.get("parameters") == null) ? new HashMap<>() : (Map) map.get("parameters");
        return errorTrackerModel;
    }
}
