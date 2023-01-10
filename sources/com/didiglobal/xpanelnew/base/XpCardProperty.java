package com.didiglobal.xpanelnew.base;

import android.view.View;
import java.util.Map;

public class XpCardProperty {

    /* renamed from: a */
    private View f54145a;

    /* renamed from: b */
    private String f54146b;

    /* renamed from: c */
    private Map<String, Object> f54147c;

    public String getId() {
        return this.f54146b;
    }

    public void setId(String str) {
        this.f54146b = str;
    }

    public View getView() {
        return this.f54145a;
    }

    public void setView(View view) {
        this.f54145a = view;
    }

    public Map<String, Object> getExtension() {
        return this.f54147c;
    }

    public void setExtension(Map<String, Object> map) {
        this.f54147c = map;
    }
}
