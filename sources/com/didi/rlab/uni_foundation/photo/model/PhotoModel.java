package com.didi.rlab.uni_foundation.photo.model;

import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.didi.soda.customer.blocks.BlocksConst;
import java.util.HashMap;
import java.util.Map;

public class PhotoModel extends UniModel {

    /* renamed from: a */
    private String f36927a;

    /* renamed from: b */
    private String f36928b;

    /* renamed from: c */
    private long f36929c;

    /* renamed from: d */
    private long f36930d;

    /* renamed from: e */
    private double f36931e;

    public String getType() {
        return this.f36927a;
    }

    public void setType(String str) {
        this.f36927a = str;
    }

    public String getExt() {
        return this.f36928b;
    }

    public void setExt(String str) {
        this.f36928b = str;
    }

    public long getImageWidth() {
        return this.f36929c;
    }

    public void setImageWidth(long j) {
        this.f36929c = j;
    }

    public long getImageHeight() {
        return this.f36930d;
    }

    public void setImageHeight(long j) {
        this.f36930d = j;
    }

    public double getQuality() {
        return this.f36931e;
    }

    public void setQuality(double d) {
        this.f36931e = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", this.f36927a);
        hashMap.put("ext", this.f36928b);
        hashMap.put(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH, Long.valueOf(this.f36929c));
        hashMap.put(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT, Long.valueOf(this.f36930d));
        hashMap.put(CollectionConstant.APOLLO_PARAM_QUALITY, Double.valueOf(this.f36931e));
        return hashMap;
    }

    public static PhotoModel fromMap(Map<String, Object> map) {
        PhotoModel photoModel = new PhotoModel();
        String str = "";
        photoModel.f36927a = (!map.containsKey("type") || map.get("type") == null) ? str : (String) map.get("type");
        if (map.containsKey("ext") && map.get("ext") != null) {
            str = (String) map.get("ext");
        }
        photoModel.f36928b = str;
        long j = 0;
        photoModel.f36929c = (!map.containsKey(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH) || map.get(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH) == null) ? 0 : ((Number) map.get(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH)).longValue();
        if (map.containsKey(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT) && map.get(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT) != null) {
            j = ((Number) map.get(BlocksConst.WIDGET_PARAMS_IMAGE_HEIGHT)).longValue();
        }
        photoModel.f36930d = j;
        photoModel.f36931e = (!map.containsKey(CollectionConstant.APOLLO_PARAM_QUALITY) || map.get(CollectionConstant.APOLLO_PARAM_QUALITY) == null) ? 0.0d : ((Double) map.get(CollectionConstant.APOLLO_PARAM_QUALITY)).doubleValue();
        return photoModel;
    }
}
