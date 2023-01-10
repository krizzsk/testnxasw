package com.didi.xengine.register;

import android.text.TextUtils;
import com.didi.xengine.model.XECallbackModel;
import com.didiglobal.enginecore.TemplateCompRegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XEngineCallbackRegister {

    /* renamed from: a */
    private static Map<String, XECallbackModel> f47850a = new ConcurrentHashMap();

    /* renamed from: a */
    static void m35947a(String str) {
        if (!TextUtils.isEmpty(str)) {
            f47850a.remove(str);
        }
    }

    public static Map<String, XECallbackModel> getCallbackMap() {
        return f47850a;
    }

    /* renamed from: a */
    static void m35946a(XERegisterModel xERegisterModel) {
        if (xERegisterModel != null && !TextUtils.isEmpty(xERegisterModel.requestKey)) {
            XECallbackModel xECallbackModel = f47850a.get(xERegisterModel.requestKey);
            if (xECallbackModel == null) {
                xECallbackModel = new XECallbackModel();
            }
            xECallbackModel.scenes = xERegisterModel.scenes;
            xECallbackModel.requestParams = xERegisterModel.requestParams;
            if (xECallbackModel.responses == null) {
                xECallbackModel.responses = new ArrayList();
            }
            if (xERegisterModel.response != null) {
                xECallbackModel.responses.add(xERegisterModel.response);
            }
            xECallbackModel.runnable = xERegisterModel.paramRunnable;
            f47850a.put(xERegisterModel.requestKey, xECallbackModel);
        }
    }

    @Deprecated
    /* renamed from: a */
    static void m35948a(String str, XEResponseCallback xEResponseCallback) {
        if (!TextUtils.isEmpty(str)) {
            XECallbackModel xECallbackModel = f47850a.get(str);
            boolean z = false;
            if (xECallbackModel == null) {
                z = true;
                xECallbackModel = new XECallbackModel();
            }
            if (xECallbackModel.responses == null) {
                xECallbackModel.responses = new ArrayList();
            }
            if (xEResponseCallback != null) {
                xECallbackModel.responses.add(xEResponseCallback);
            }
            if (z) {
                f47850a.put(str, xECallbackModel);
            }
        }
    }

    @Deprecated
    /* renamed from: b */
    static void m35949b(String str, XEResponseCallback xEResponseCallback) {
        XECallbackModel xECallbackModel;
        if (!TextUtils.isEmpty(str) && (xECallbackModel = f47850a.get(str)) != null && xECallbackModel.responses != null) {
            xECallbackModel.responses.remove(xEResponseCallback);
            if (xECallbackModel.responses.isEmpty()) {
                f47850a.remove(str);
                TemplateCompRegister.unregisterTemplate(str);
            }
        }
    }
}
