package com.didiglobal.enginecore.component;

import android.view.View;
import org.json.JSONObject;

public abstract class XEAbsComponent {

    /* renamed from: a */
    private JSONObject f44017a;

    /* renamed from: b */
    private boolean f44018b = false;

    /* renamed from: id */
    protected String f44019id;
    protected View mView;

    public abstract String getId();

    public boolean isDefered() {
        return this.f44018b;
    }

    public void setDefered(boolean z) {
        this.f44018b = z;
    }

    public View getView() {
        return this.mView;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public JSONObject getData() {
        return this.f44017a;
    }

    public void setData(JSONObject jSONObject) {
        this.f44017a = jSONObject;
    }

    public String toString() {
        return "XEComponent{ getId=" + getId() + ", mView=" + this.mView + ", data=" + this.f44017a + ", defered=" + this.f44018b + " }";
    }
}
