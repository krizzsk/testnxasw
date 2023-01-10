package com.didi.rlab.uni_im_map.map;

import com.didi.rlab.uni_im_map.uniapi.UniModel;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Map;

public class IMMapErrorTrackerModel extends UniModel {

    /* renamed from: a */
    private String f36960a;

    /* renamed from: b */
    private String f36961b;

    /* renamed from: c */
    private String f36962c;

    /* renamed from: d */
    private String f36963d;

    /* renamed from: e */
    private Map<String, Object> f36964e;

    public String getModuleName() {
        return this.f36960a;
    }

    public void setModuleName(String str) {
        this.f36960a = str;
    }

    public String getErrorName() {
        return this.f36961b;
    }

    public void setErrorName(String str) {
        this.f36961b = str;
    }

    public String getErrorCode() {
        return this.f36962c;
    }

    public void setErrorCode(String str) {
        this.f36962c = str;
    }

    public String getErrorMsg() {
        return this.f36963d;
    }

    public void setErrorMsg(String str) {
        this.f36963d = str;
    }

    public Map<String, Object> getParameters() {
        return this.f36964e;
    }

    public void setParameters(Map<String, Object> map) {
        this.f36964e = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("moduleName", this.f36960a);
        hashMap.put("errorName", this.f36961b);
        hashMap.put(Constants.ERROR_CODE, this.f36962c);
        hashMap.put("errorMsg", this.f36963d);
        hashMap.put("parameters", this.f36964e);
        return hashMap;
    }

    public static IMMapErrorTrackerModel fromMap(Map<String, Object> map) {
        IMMapErrorTrackerModel iMMapErrorTrackerModel = new IMMapErrorTrackerModel();
        String str = "";
        iMMapErrorTrackerModel.f36960a = (!map.containsKey("moduleName") || map.get("moduleName") == null) ? str : (String) map.get("moduleName");
        iMMapErrorTrackerModel.f36961b = (!map.containsKey("errorName") || map.get("errorName") == null) ? str : (String) map.get("errorName");
        iMMapErrorTrackerModel.f36962c = (!map.containsKey(Constants.ERROR_CODE) || map.get(Constants.ERROR_CODE) == null) ? str : (String) map.get(Constants.ERROR_CODE);
        if (map.containsKey("errorMsg") && map.get("errorMsg") != null) {
            str = (String) map.get("errorMsg");
        }
        iMMapErrorTrackerModel.f36963d = str;
        iMMapErrorTrackerModel.f36964e = (!map.containsKey("parameters") || map.get("parameters") == null) ? new HashMap<>() : (Map) map.get("parameters");
        return iMMapErrorTrackerModel;
    }
}
