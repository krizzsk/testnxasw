package com.didiglobal.dittoview.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didiglobal.dittoview.DittoCDNCacheManager;
import com.didiglobal.dittoview.DittoCardNode;
import com.didiglobal.dittoview.DittoCardRenderer;
import com.didiglobal.dittoview.DittoEventListener;
import com.didiglobal.dittoview.DittoTemplateParser;
import com.didiglobal.dittoview.DittoXMLCacheEntity;
import com.didiglobal.dittoview.mvvm.DittoData;
import com.didiglobal.dittoview.mvvm.DittoViewBinder;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class DittoViewBinderImpl implements DittoViewBinder {

    /* renamed from: a */
    private int f52456a = 0;

    /* renamed from: b */
    private Object f52457b;

    /* renamed from: c */
    private ScriptableObject f52458c;

    public void bind(View view, DittoData dittoData) {
    }

    public void onCDNCached(DittoXMLCacheEntity dittoXMLCacheEntity) {
    }

    public void setJavascriptValue(Object obj) {
        this.f52457b = obj;
    }

    public ScriptableObject getJSScope() {
        return this.f52458c;
    }

    public View createView(Context context, DittoData dittoData) {
        if (TextUtils.isEmpty(dittoData.getCdn())) {
            return null;
        }
        DittoCDNCacheManager instance = DittoCDNCacheManager.getInstance(context);
        DittoXMLCacheEntity dittoXMLCacheEntity = instance.get(dittoData.getCdn());
        if (dittoXMLCacheEntity == null) {
            instance.tryCache(dittoData, this);
            return null;
        }
        DittoCardNode parse = new DittoTemplateParser().parse(dittoXMLCacheEntity.element, dittoData.getData());
        if (parse == null) {
            return null;
        }
        DittoCardRenderer dittoCardRenderer = new DittoCardRenderer(context, this.f52456a, dittoData);
        dittoCardRenderer.bindEventListener(dittoData.getEventListener());
        View render = dittoCardRenderer.render(parse);
        if (!TextUtils.isEmpty(dittoXMLCacheEntity.script)) {
            org.mozilla.javascript.Context enter = org.mozilla.javascript.Context.enter();
            ScriptableObject initSafeStandardObjects = enter.initSafeStandardObjects();
            this.f52458c = initSafeStandardObjects;
            ScriptableObject.putProperty((Scriptable) this.f52458c, "xpJsTool", org.mozilla.javascript.Context.javaToJS(this.f52457b, initSafeStandardObjects));
            enter.evaluateString(this.f52458c, dittoXMLCacheEntity.script, dittoData.getTemplate(), 1, (Object) null);
        }
        return render;
    }

    public DittoEventListener createEventListener(DittoData dittoData) {
        return new DittoEventListenerImpl(dittoData);
    }
}
