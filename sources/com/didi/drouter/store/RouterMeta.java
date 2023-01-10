package com.didi.drouter.store;

import android.content.Intent;
import android.net.Uri;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.IRouterInterceptor;
import com.didi.drouter.service.IFeatureMatcher;
import com.didi.drouter.utils.TextUtils;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouterMeta {
    public static int ACTIVITY = 1;
    public static int FRAGMENT = 2;
    public static int HANDLER = 4;
    public static int INTERCEPTOR = 5;
    public static int SERVICE = 6;
    public static int VIEW = 3;

    /* renamed from: a */
    private int f21102a;

    /* renamed from: b */
    private Class<?> f21103b;

    /* renamed from: c */
    private int f21104c;

    /* renamed from: d */
    private boolean f21105d;

    /* renamed from: e */
    private String f21106e;

    /* renamed from: f */
    private String f21107f;

    /* renamed from: g */
    private String f21108g;

    /* renamed from: h */
    private String f21109h;

    /* renamed from: i */
    private Class<? extends IRouterInterceptor>[] f21110i;

    /* renamed from: j */
    private int f21111j;

    /* renamed from: k */
    private boolean f21112k;

    /* renamed from: l */
    private Intent f21113l;

    /* renamed from: m */
    private RouterKey f21114m;

    /* renamed from: n */
    private IRouterHandler f21115n;

    /* renamed from: o */
    private String f21116o;

    /* renamed from: p */
    private IFeatureMatcher<?> f21117p;

    /* renamed from: q */
    private ServiceKey f21118q;

    /* renamed from: r */
    private Object f21119r;

    /* renamed from: s */
    private boolean f21120s;

    /* renamed from: t */
    private int f21121t;

    /* renamed from: u */
    private Map<String, List<String>> f21122u;

    private RouterMeta(int i) {
        this.f21102a = i;
    }

    public static RouterMeta build(int i) {
        return new RouterMeta(i);
    }

    public RouterMeta assembleRouter(String str, String str2, String str3, String str4, Class<? extends IRouterInterceptor>[] clsArr, int i, int i2, boolean z) {
        this.f21106e = str;
        this.f21107f = str2;
        this.f21108g = str3;
        this.f21109h = str4;
        this.f21110i = clsArr;
        this.f21111j = i;
        this.f21104c = i2;
        this.f21112k = z;
        return this;
    }

    public RouterMeta assembleRouter(String str, String str2, String str3, Class<?> cls, Class<? extends IRouterInterceptor>[] clsArr, int i, int i2, boolean z) {
        this.f21106e = str;
        this.f21107f = str2;
        this.f21108g = str3;
        this.f21103b = cls;
        this.f21110i = clsArr;
        this.f21111j = i;
        this.f21104c = i2;
        this.f21112k = z;
        return this;
    }

    public RouterMeta assembleRouter(Intent intent) {
        this.f21113l = intent;
        return this;
    }

    public void setHandler(RouterKey routerKey, IRouterHandler iRouterHandler) {
        this.f21114m = routerKey;
        this.f21115n = iRouterHandler;
        this.f21105d = true;
    }

    public RouterMeta assembleService(Class<?> cls, String str, IFeatureMatcher<?> iFeatureMatcher, int i, int i2) {
        this.f21103b = cls;
        this.f21116o = str;
        this.f21117p = iFeatureMatcher;
        this.f21104c = i;
        this.f21121t = i2;
        return this;
    }

    public void setService(ServiceKey serviceKey, Object obj) {
        this.f21118q = serviceKey;
        this.f21119r = obj;
        this.f21105d = true;
    }

    public RouterMeta assembleInterceptor(Class<? extends IRouterInterceptor> cls, int i, boolean z, int i2) {
        this.f21103b = cls;
        this.f21104c = i;
        this.f21120s = z;
        this.f21121t = i2;
        return this;
    }

    public int getRouterType() {
        return this.f21102a;
    }

    public String getActivityClassName() {
        return this.f21109h;
    }

    public Class<?> getTargetClass() {
        return this.f21103b;
    }

    public String getSimpleClassName() {
        String str = this.f21109h;
        if (str != null) {
            return str.substring(str.lastIndexOf(".") + 1);
        }
        Class<?> cls = this.f21103b;
        if (cls != null) {
            return cls.getSimpleName();
        }
        IRouterHandler iRouterHandler = this.f21115n;
        if (iRouterHandler != null) {
            return iRouterHandler.getClass().getName().substring(this.f21115n.getClass().getName().lastIndexOf(".") + 1);
        }
        return null;
    }

    public Class<? extends IRouterInterceptor>[] getInterceptors() {
        return this.f21110i;
    }

    public int getThread() {
        return this.f21111j;
    }

    public boolean isHold() {
        return this.f21112k;
    }

    public Intent getIntent() {
        return this.f21113l;
    }

    public boolean isRegexMatch(Uri uri) {
        String scheme = uri.getScheme();
        String host = uri.getHost();
        String path = uri.getPath();
        return scheme != null && scheme.matches(this.f21106e) && host != null && host.matches(this.f21107f) && path != null && path.matches(this.f21108g);
    }

    public boolean isRegexUri() {
        return TextUtils.isRegex(this.f21106e) || TextUtils.isRegex(this.f21107f) || TextUtils.isRegex(this.f21108g);
    }

    public String getLegalUri() {
        return this.f21106e + HWMapConstant.HTTP.SEPARATOR + this.f21107f + this.f21108g;
    }

    public IRouterHandler getHandler() {
        return this.f21115n;
    }

    public String getServiceAlias() {
        return this.f21116o;
    }

    public int getCache() {
        return this.f21121t;
    }

    public ServiceKey getServiceKey() {
        return this.f21118q;
    }

    public Object getService() {
        return this.f21119r;
    }

    public IFeatureMatcher getFeatureMatcher() {
        return this.f21117p;
    }

    public boolean isGlobal() {
        return this.f21120s;
    }

    public int getPriority() {
        return this.f21104c;
    }

    public boolean isDynamic() {
        return this.f21105d;
    }

    public void addInterceptorHandled(String str, IRouterInterceptor iRouterInterceptor) {
        if (this.f21122u == null) {
            this.f21122u = new HashMap();
        }
        List list = this.f21122u.get(str);
        if (list == null) {
            list = new ArrayList();
            this.f21122u.put(str, list);
        }
        list.add(iRouterInterceptor.getClass().getSimpleName());
    }

    public void clearInterceptorHandled(String str) {
        Map<String, List<String>> map = this.f21122u;
        if (map != null) {
            map.remove(str);
        }
    }

    public List<String> getInterceptorHandled(String str) {
        Map<String, List<String>> map = this.f21122u;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }
}
