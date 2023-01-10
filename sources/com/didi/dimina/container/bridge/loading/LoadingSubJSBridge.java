package com.didi.dimina.container.bridge.loading;

import android.content.Context;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.p065ui.loadpage.AbsLoadingManager;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import org.json.JSONObject;

public class LoadingSubJSBridge {
    public static BackupLoadingWindowManager sBackupPopupWindowManager;

    /* renamed from: a */
    private AbsLoadingManager f18628a;

    /* renamed from: b */
    private final Context f18629b;

    /* renamed from: c */
    private final DMMina f18630c;

    public interface BackupLoadingWindowManager {
        void hideLoading(Context context, JSONObject jSONObject, CallbackFunction callbackFunction);

        void showLoading(Context context, JSONObject jSONObject, CallbackFunction callbackFunction);
    }

    public LoadingSubJSBridge(Context context, DMMina dMMina) {
        this.f18629b = context;
        this.f18630c = dMMina;
        LogUtil.m16841i("LoadingSubJSBridge init");
    }

    public void showLoading(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("LoadingSubJSBridge showLoading: " + jSONObject);
        BackupLoadingWindowManager backupLoadingWindowManager = sBackupPopupWindowManager;
        if (backupLoadingWindowManager != null) {
            backupLoadingWindowManager.showLoading(this.f18629b, jSONObject, callbackFunction);
        } else if (jSONObject.has("title")) {
            String optString = jSONObject.optString("title");
            AbsLoadingManager absLoadingManager = this.f18628a;
            if (absLoadingManager != null) {
                absLoadingManager.dismiss();
                this.f18628a = null;
            }
            DMMina dMMina = this.f18630c;
            if (dMMina == null || dMMina.getConfig() == null || this.f18630c.getConfig().getUIConfig().getCommonLoadingViewClazz() == null) {
                this.f18628a = new DefaultLoadingManager(this.f18629b, optString, this.f18630c);
            } else {
                this.f18628a = new CustomLoadingManager(this.f18629b, optString, this.f18630c);
            }
            this.f18628a.show();
            CallBackUtil.onSuccess(callbackFunction);
        } else {
            CallBackUtil.onFail("参数出错", callbackFunction);
        }
    }

    public void hideLoading(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("LoadingSubJSBridge hideLoading: " + jSONObject);
        BackupLoadingWindowManager backupLoadingWindowManager = sBackupPopupWindowManager;
        if (backupLoadingWindowManager != null) {
            backupLoadingWindowManager.hideLoading(this.f18629b, jSONObject, callbackFunction);
            return;
        }
        AbsLoadingManager absLoadingManager = this.f18628a;
        if (absLoadingManager != null) {
            absLoadingManager.dismiss();
            this.f18628a = null;
        }
        CallBackUtil.onSuccess(callbackFunction);
    }
}
