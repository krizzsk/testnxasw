package com.didiglobal.p205sa.biz.component.activity.model;

import android.view.View;
import com.didi.sdk.app.sapanel.ICardVisibleListener;
import com.google.gson.JsonObject;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.activity.model.ActivityProperty */
public class ActivityProperty {

    /* renamed from: a */
    private View f53260a;

    /* renamed from: b */
    private JsonObject f53261b;

    /* renamed from: c */
    private ActivityCardModel f53262c;

    /* renamed from: d */
    private String f53263d;

    /* renamed from: e */
    private String f53264e;

    /* renamed from: f */
    private ICardVisibleListener f53265f;

    /* renamed from: g */
    private Map<String, Object> f53266g;

    public ActivityCardModel getModel() {
        return this.f53262c;
    }

    public void setModel(ActivityCardModel activityCardModel) {
        this.f53262c = activityCardModel;
    }

    public String getTypeId() {
        return this.f53264e;
    }

    public void setTypeId(String str) {
        this.f53264e = str;
    }

    public View getView() {
        return this.f53260a;
    }

    public void setView(View view) {
        this.f53260a = view;
    }

    public JsonObject getData() {
        return this.f53261b;
    }

    public void setData(JsonObject jsonObject) {
        this.f53261b = jsonObject;
    }

    public String getId() {
        return this.f53263d;
    }

    public void setId(String str) {
        this.f53263d = str;
    }

    public ICardVisibleListener getListener() {
        return this.f53265f;
    }

    public void setListener(ICardVisibleListener iCardVisibleListener) {
        this.f53265f = iCardVisibleListener;
    }

    public Map<String, Object> getExtension() {
        return this.f53266g;
    }

    public void setExtension(Map<String, Object> map) {
        this.f53266g = map;
    }
}
