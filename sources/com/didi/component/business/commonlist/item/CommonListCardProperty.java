package com.didi.component.business.commonlist.item;

import android.view.View;
import java.util.Map;

public class CommonListCardProperty {

    /* renamed from: a */
    private View f13023a;

    /* renamed from: b */
    private String f13024b;

    /* renamed from: c */
    private String f13025c;

    /* renamed from: d */
    private Map<String, Object> f13026d;

    public String getId() {
        return this.f13024b;
    }

    public void setId(String str) {
        this.f13024b = str;
    }

    public View getView() {
        return this.f13023a;
    }

    public void setView(View view) {
        this.f13023a = view;
    }

    public Map<String, Object> getExtension() {
        return this.f13026d;
    }

    public void setExtension(Map<String, Object> map) {
        this.f13026d = map;
    }

    public String getTemplate() {
        return this.f13025c;
    }

    public void setTemplate(String str) {
        this.f13025c = str;
    }
}
