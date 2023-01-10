package com.didi.rlab.uni_foundation.photo.model;

import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Map;

public class PhotoErrorModel extends UniModel {

    /* renamed from: a */
    private long f36919a;

    /* renamed from: b */
    private String f36920b;

    /* renamed from: c */
    private String f36921c;

    /* renamed from: d */
    private String f36922d;

    /* renamed from: e */
    private String f36923e;

    /* renamed from: f */
    private long f36924f;

    /* renamed from: g */
    private long f36925g;

    /* renamed from: h */
    private double f36926h;

    public long getErrorCode() {
        return this.f36919a;
    }

    public void setErrorCode(long j) {
        this.f36919a = j;
    }

    public String getPath() {
        return this.f36920b;
    }

    public void setPath(String str) {
        this.f36920b = str;
    }

    public String getErrorMsg() {
        return this.f36921c;
    }

    public void setErrorMsg(String str) {
        this.f36921c = str;
    }

    public String getType() {
        return this.f36922d;
    }

    public void setType(String str) {
        this.f36922d = str;
    }

    public String getExt() {
        return this.f36923e;
    }

    public void setExt(String str) {
        this.f36923e = str;
    }

    public long getImageWidth() {
        return this.f36924f;
    }

    public void setImageWidth(long j) {
        this.f36924f = j;
    }

    public long getImageHeight() {
        return this.f36925g;
    }

    public void setImageHeight(long j) {
        this.f36925g = j;
    }

    public double getQuality() {
        return this.f36926h;
    }

    public void setQuality(double d) {
        this.f36926h = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.ERROR_CODE, Long.valueOf(this.f36919a));
        hashMap.put("path", this.f36920b);
        hashMap.put("errorMsg", this.f36921c);
        hashMap.put("type", this.f36922d);
        hashMap.put("ext", this.f36923e);
        hashMap.put(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH, Long.valueOf(this.f36924f));
        hashMap.put(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT, Long.valueOf(this.f36925g));
        hashMap.put(CollectionConstant.APOLLO_PARAM_QUALITY, Double.valueOf(this.f36926h));
        return hashMap;
    }

    public static PhotoErrorModel fromMap(Map<String, Object> map) {
        PhotoErrorModel photoErrorModel = new PhotoErrorModel();
        long j = 0;
        photoErrorModel.f36919a = (!map.containsKey(Constants.ERROR_CODE) || map.get(Constants.ERROR_CODE) == null) ? 0 : ((Number) map.get(Constants.ERROR_CODE)).longValue();
        String str = "";
        photoErrorModel.f36920b = (!map.containsKey("path") || map.get("path") == null) ? str : (String) map.get("path");
        photoErrorModel.f36921c = (!map.containsKey("errorMsg") || map.get("errorMsg") == null) ? str : (String) map.get("errorMsg");
        photoErrorModel.f36922d = (!map.containsKey("type") || map.get("type") == null) ? str : (String) map.get("type");
        if (map.containsKey("ext") && map.get("ext") != null) {
            str = (String) map.get("ext");
        }
        photoErrorModel.f36923e = str;
        photoErrorModel.f36924f = (!map.containsKey(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH) || map.get(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH) == null) ? 0 : ((Number) map.get(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH)).longValue();
        if (map.containsKey(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT) && map.get(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT) != null) {
            j = ((Number) map.get(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT)).longValue();
        }
        photoErrorModel.f36925g = j;
        photoErrorModel.f36926h = (!map.containsKey(CollectionConstant.APOLLO_PARAM_QUALITY) || map.get(CollectionConstant.APOLLO_PARAM_QUALITY) == null) ? 0.0d : ((Double) map.get(CollectionConstant.APOLLO_PARAM_QUALITY)).doubleValue();
        return photoErrorModel;
    }
}
