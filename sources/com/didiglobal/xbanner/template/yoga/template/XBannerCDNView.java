package com.didiglobal.xbanner.template.yoga.template;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.global.xbanner.basemodel.XBCardView;
import com.didi.global.xbanner.view.recycler.XbCardReloadListener;
import com.didiglobal.xbanner.template.mdel.XBannerCDNData;
import com.didiglobal.xbanner.template.yoga.CDNCacheManager;
import com.didiglobal.xbanner.template.yoga.CommonEventListener;
import com.didiglobal.xbanner.template.yoga.EventListener;
import com.didiglobal.xbanner.template.yoga.TemplateParser;
import com.didiglobal.xbanner.template.yoga.XCardNode;
import com.didiglobal.xbanner.template.yoga.XCardRenderer;
import com.didiglobal.xbanner.template.yoga.XMLCacheEntity;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class XBannerCDNView implements XBCardView<XBannerCDNData> {

    /* renamed from: a */
    private int f54076a = 0;

    /* renamed from: b */
    private XBannerCDNData f54077b;

    /* renamed from: c */
    private Context f54078c;

    /* renamed from: d */
    private XbCardReloadListener f54079d;

    /* renamed from: e */
    private Object f54080e;

    /* renamed from: f */
    private ScriptableObject f54081f;

    public void setJavascriptValue(Object obj) {
        this.f54080e = obj;
    }

    public ScriptableObject getJSScope() {
        return this.f54081f;
    }

    public View createView(Context context, XBannerCDNData xBannerCDNData, int i) {
        this.f54078c = context;
        this.f54077b = xBannerCDNData;
        if (TextUtils.isEmpty(xBannerCDNData.getCdn())) {
            return null;
        }
        CDNCacheManager instance = CDNCacheManager.getInstance(context);
        XMLCacheEntity xMLCacheEntity = instance.get(xBannerCDNData.getCdn());
        if (xMLCacheEntity == null) {
            instance.tryCache(xBannerCDNData, this);
            return null;
        }
        XCardNode parse = new TemplateParser().parse(xMLCacheEntity.element, xBannerCDNData.getData());
        if (parse == null) {
            return null;
        }
        XCardRenderer xCardRenderer = new XCardRenderer(context, this.f54076a, xBannerCDNData);
        xCardRenderer.bindEventListener(createEventListener(xBannerCDNData));
        View render = xCardRenderer.render(parse);
        if (!TextUtils.isEmpty(xMLCacheEntity.script)) {
            org.mozilla.javascript.Context enter = org.mozilla.javascript.Context.enter();
            ScriptableObject initSafeStandardObjects = enter.initSafeStandardObjects();
            this.f54081f = initSafeStandardObjects;
            ScriptableObject.putProperty((Scriptable) this.f54081f, "xpJsTool", org.mozilla.javascript.Context.javaToJS(this.f54080e, initSafeStandardObjects));
            enter.evaluateString(this.f54081f, xMLCacheEntity.script, xBannerCDNData.getTemplate(), 1, (Object) null);
        }
        return render;
    }

    public void setReloadListener(XbCardReloadListener xbCardReloadListener) {
        this.f54079d = xbCardReloadListener;
    }

    public void onCDNCached(XMLCacheEntity xMLCacheEntity) {
        XCardNode parse = new TemplateParser().parse(xMLCacheEntity.element, this.f54077b.getData());
        if (parse != null) {
            XCardRenderer xCardRenderer = new XCardRenderer(this.f54078c, this.f54076a, this.f54077b);
            xCardRenderer.bindEventListener(createEventListener(this.f54077b));
            View render = xCardRenderer.render(parse);
            if (!TextUtils.isEmpty(xMLCacheEntity.script)) {
                org.mozilla.javascript.Context enter = org.mozilla.javascript.Context.enter();
                ScriptableObject initSafeStandardObjects = enter.initSafeStandardObjects();
                this.f54081f = initSafeStandardObjects;
                ScriptableObject.putProperty((Scriptable) this.f54081f, "xpJsTool", org.mozilla.javascript.Context.javaToJS(this.f54080e, initSafeStandardObjects));
                enter.evaluateString(this.f54081f, xMLCacheEntity.script, this.f54077b.getTemplate(), 1, (Object) null);
            }
            XbCardReloadListener xbCardReloadListener = this.f54079d;
            if (xbCardReloadListener != null) {
                xbCardReloadListener.onViewReload(render);
            }
        }
    }

    public EventListener createEventListener(XBannerCDNData xBannerCDNData) {
        return new CommonEventListener(xBannerCDNData);
    }
}
