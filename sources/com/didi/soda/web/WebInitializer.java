package com.didi.soda.web;

import android.app.Application;
import android.content.res.Resources;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.FusionInitConfig;
import com.didi.soda.web.SodaFusionEngine;
import com.didi.soda.web.config.WebConstant;
import com.didi.soda.web.tools.LogUtil;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public final class WebInitializer {
    public static final String GLOBAL_JS_KEY = "Soda";

    /* renamed from: a */
    private static WebInitializer f46420a;

    /* renamed from: b */
    private FusionInitConfig.Builder f46421b;

    /* renamed from: c */
    private SodaFusionEngine.SodaConfingBuilder f46422c;

    /* renamed from: d */
    private Class<? extends GlobalJsBridge> f46423d;

    /* renamed from: e */
    private BizAgent f46424e;

    /* renamed from: f */
    private HashMap<String, Class<? extends BaseHybridModule>> f46425f = new HashMap<>();

    /* renamed from: g */
    private FusionInitConfig f46426g;

    /* renamed from: h */
    private LogUtil.LogInterface f46427h;

    /* renamed from: i */
    private boolean f46428i = true;
    public Application mApplication;

    private WebInitializer(Application application) {
        Resources resources = application.getApplicationContext().getResources();
        this.f46422c = new SodaFusionEngine.SodaConfingBuilder();
        FusionInitConfig.Builder builder = new FusionInitConfig.Builder();
        this.f46421b = builder;
        builder.addExtraAttr(WebConstant.TITLE_BAR_BACKGROUND_COLOR, Integer.valueOf(resources.getColor(R.color.assembly_color_titleBar)));
        this.f46421b.addExtraAttr(WebConstant.TITLE_BAR_TEXT_COLOR, Integer.valueOf(resources.getColor(R.color.white)));
        this.f46421b.addExtraAttr("progressbar_color", Integer.valueOf(resources.getColor(R.color.assembly_unit_color_fffc9153)));
    }

    public static WebInitializer start(Application application) {
        if (f46420a == null) {
            WebInitializer webInitializer = new WebInitializer(application);
            f46420a = webInitializer;
            webInitializer.mApplication = application;
        }
        return f46420a;
    }

    public static WebInitializer getInitializer() {
        return f46420a;
    }

    public WebInitializer setPhone(String str) {
        this.f46421b.setPhone(str);
        return this;
    }

    public WebInitializer setCityId(int i) {
        this.f46421b.setCityId(i);
        return this;
    }

    public WebInitializer setBusinessAgent(BizAgent bizAgent) {
        this.f46424e = bizAgent;
        return this;
    }

    public WebInitializer setAppKey(String str) {
        this.f46421b.setAppKey(str);
        return this;
    }

    public WebInitializer setProgressBarColor(int i) {
        this.f46421b.addExtraAttr("progressbar_color", Integer.valueOf(i));
        return this;
    }

    public WebInitializer setReadTimeMillisecond(long j) {
        this.f46421b.addExtraAttr(WebConstant.READ_TIMEOUT, Long.valueOf(j));
        return this;
    }

    public WebInitializer exportGlobalJsBridge(Class<? extends GlobalJsBridge> cls) {
        this.f46423d = cls;
        return this;
    }

    public WebInitializer isAddFusionAgent(boolean z) {
        this.f46428i = z;
        return this;
    }

    public void execute() {
        this.f46422c.setBusinessAgent(this.f46424e).setGlobalJsBridge(this.f46423d);
        SodaFusionEngine.init(this.f46422c);
        if (this.f46428i) {
            this.f46421b.setBusinessAgent(this.f46424e);
            FusionEngine.init(this.mApplication, getFusionInitConfig());
        }
        m34592a();
    }

    public FusionInitConfig getFusionInitConfig() {
        if (this.f46426g == null) {
            this.f46426g = this.f46421b.build();
        }
        return this.f46426g;
    }

    /* renamed from: a */
    private void m34592a() {
        Class<? extends GlobalJsBridge> cls = this.f46423d;
        if (cls != null) {
            m34593a(GLOBAL_JS_KEY, cls);
        }
        if (this.f46425f.size() > 0) {
            for (Map.Entry next : this.f46425f.entrySet()) {
                m34593a((String) next.getKey(), (Class) next.getValue());
            }
        }
    }

    @Deprecated
    public WebInitializer setTitleBarBackground(int i) {
        this.f46421b.addExtraAttr(WebConstant.TITLE_BAR_BACKGROUND_COLOR, Integer.valueOf(i));
        return this;
    }

    /* renamed from: a */
    private void m34593a(String str, Class cls) {
        FusionEngine.export(str, cls);
    }

    public WebInitializer setLogUtil(LogUtil.LogInterface logInterface) {
        this.f46427h = logInterface;
        return this;
    }

    public LogUtil.LogInterface getLogUtil() {
        return this.f46427h;
    }

    @Deprecated
    public WebInitializer setTitleBarTextColor(int i) {
        this.f46421b.addExtraAttr(WebConstant.TITLE_BAR_TEXT_COLOR, Integer.valueOf(i));
        return this;
    }

    public WebInitializer exportJsBridge(String str, Class<? extends BaseHybridModule> cls) {
        this.f46425f.put(str, cls);
        return this;
    }

    @Deprecated
    public WebInitializer exportJsBridges(HashMap<String, Class<? extends BaseHybridModule>> hashMap) {
        this.f46425f.putAll(hashMap);
        return this;
    }

    @Deprecated
    public WebInitializer addExtraAttr(String str, Object obj) {
        this.f46421b.addExtraAttr(str, obj);
        return this;
    }
}
