package com.didi.xengine.register;

import android.text.TextUtils;
import com.didi.xengine.model.XECallbackModel;
import com.didiglobal.enginecore.TemplateCompRegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;

public class XERegister {
    public static void registerTemplate(XERegisterModel xERegisterModel) {
        if (xERegisterModel != null && !TextUtils.isEmpty(xERegisterModel.requestKey)) {
            XEngineCallbackRegister.m35946a(xERegisterModel);
            TemplateCompRegister.registerTemplate(xERegisterModel);
        }
    }

    public static void updateScene(String str, String... strArr) {
        XECallbackModel xECallbackModel;
        if (!TextUtils.isEmpty(str) && strArr != null && (xECallbackModel = XEngineCallbackRegister.getCallbackMap().get(str)) != null && xECallbackModel.scenes != null) {
            for (String str2 : strArr) {
                if (!xECallbackModel.scenes.contains(str2)) {
                    xECallbackModel.scenes.add(str2);
                }
            }
            TemplateCompRegister.updateRequiredMapScene(str, strArr);
        }
    }

    @Deprecated
    public static void registerCallback(String str, XEResponseCallback xEResponseCallback) {
        XEngineCallbackRegister.m35948a(str, xEResponseCallback);
    }

    @Deprecated
    public static void unregisterCallback(String str, XEResponseCallback xEResponseCallback) {
        XEngineCallbackRegister.m35949b(str, xEResponseCallback);
    }

    public static void unregisterTemplate(String str) {
        XEngineCallbackRegister.m35947a(str);
        TemplateCompRegister.unregisterTemplate(str);
    }
}
