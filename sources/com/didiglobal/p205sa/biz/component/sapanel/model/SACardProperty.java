package com.didiglobal.p205sa.biz.component.sapanel.model;

import android.view.View;
import com.didi.sdk.app.sapanel.ICardVisibleListener;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ICardPosition;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.model.SACardProperty */
public class SACardProperty {

    /* renamed from: a */
    private View f53641a;

    /* renamed from: b */
    private String f53642b;

    /* renamed from: c */
    private ICardVisibleListener f53643c;

    /* renamed from: d */
    private ICardPosition f53644d;

    /* renamed from: e */
    private boolean f53645e;

    /* renamed from: f */
    private Map<String, Object> f53646f;

    public void setListener(ICardVisibleListener iCardVisibleListener) {
        this.f53643c = iCardVisibleListener;
    }

    public ICardVisibleListener getListener() {
        return this.f53643c;
    }

    public void setPosition(ICardPosition iCardPosition) {
        this.f53644d = iCardPosition;
    }

    public ICardPosition getPosition() {
        return this.f53644d;
    }

    public String getId() {
        return this.f53642b;
    }

    public void setId(String str) {
        this.f53642b = str;
    }

    public View getView() {
        return this.f53641a;
    }

    public void setView(View view) {
        this.f53641a = view;
    }

    public void setTransparent(boolean z) {
        this.f53645e = z;
    }

    public boolean isTransparent() {
        return this.f53645e;
    }

    public Map<String, Object> getExtension() {
        return this.f53646f;
    }

    public void setExtension(Map<String, Object> map) {
        this.f53646f = map;
    }
}
