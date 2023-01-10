package com.didichuxing.xpanel.models;

import android.content.Context;
import com.didichuxing.xpanel.util.LogcatUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class ModelsFactory {

    /* renamed from: a */
    private static final String f52143a = "ModelsFactory";

    /* renamed from: b */
    private Map<String, Class<? extends IXPanelModelView>> f52144b;

    /* renamed from: c */
    private Map<String, Class<? extends IXPanelModel>> f52145c;

    /* renamed from: d */
    private Map<String, Integer> f52146d;

    /* renamed from: e */
    private List<String> f52147e;

    private ModelsFactory() {
        this.f52144b = Collections.synchronizedMap(new LinkedHashMap());
        this.f52145c = Collections.synchronizedMap(new LinkedHashMap());
        this.f52146d = Collections.synchronizedMap(new LinkedHashMap());
        this.f52147e = Collections.synchronizedList(new ArrayList());
    }

    /* renamed from: a */
    private void m39233a(String str, Class cls) {
        this.f52144b.put(str, cls);
    }

    /* renamed from: b */
    private void m39236b(String str, Class cls) {
        this.f52145c.put(str, cls);
    }

    /* renamed from: a */
    private void m39234a(String str, Integer num) {
        this.f52146d.put(str, num);
    }

    public IXPanelModelView newTemplateView(Context context, int i) {
        try {
            IXPanelModelView iXPanelModelView = (IXPanelModelView) this.f52144b.get(this.f52147e.get(i)).newInstance();
            iXPanelModelView.init(context);
            return iXPanelModelView;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public IXPanelModel newTemplateData(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Class cls = this.f52145c.get(str);
            if (cls == null) {
                return null;
            }
            IXPanelModel iXPanelModel = (IXPanelModel) cls.newInstance();
            if (iXPanelModel.defaultParse(jSONObject, jSONObject2)) {
                return iXPanelModel;
            }
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private int m39232a(String str) {
        return this.f52147e.indexOf(str);
    }

    public static int getTemplateType(String str) {
        return get().m39232a(str);
    }

    public void register(String str, Class cls, Class cls2, Integer num) {
        if (m39235a(str, cls, cls2, num)) {
            this.f52147e.add(str);
            m39233a(str, cls);
            m39236b(str, cls2);
            m39234a(str, num);
        }
    }

    /* renamed from: a */
    private boolean m39235a(String str, Class cls, Class cls2, Integer num) {
        if (this.f52147e.contains(str)) {
            LogcatUtil.m39240w(f52143a, "template:" + str + ",value:" + num + " has been register,view：" + cls.getName() + ",Data:" + cls2.getName());
            return false;
        } else if (this.f52144b.containsKey(str)) {
            LogcatUtil.m39240w(f52143a, "View template:" + str + ",Class:" + cls.getName() + " has been register");
            return false;
        } else if (this.f52145c.containsKey(str)) {
            LogcatUtil.m39240w(f52143a, "Data template:" + str + ",Class:" + cls.getName() + " has been register");
            return false;
        } else if (!this.f52146d.containsKey(str)) {
            return true;
        } else {
            LogcatUtil.m39240w(f52143a, "ID template:" + str + ",value:" + num + " has been register");
            return false;
        }
    }

    public static ModelsFactory get() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final ModelsFactory INSTANCE = new ModelsFactory();

        private Holder() {
        }
    }
}
