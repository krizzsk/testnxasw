package com.didi.globalsafetoolkit;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.globalsafetoolkit.api.IGlobalSfInfoService;
import com.didi.globalsafetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.business.sdk.GlobalSafeToolKit;
import java.util.Map;

public class GlobalSfBusinessInterface {
    /* access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: a */
    public void mo72771a(Context context, String str) {
    }

    public static SafeBusinessData getBusinessInfo() {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            return a.getBusinessInfo();
        }
        return null;
    }

    /* renamed from: a */
    private static IGlobalSfInfoService m19954a() {
        return GlobalSfManager.getInstance().getmBusinessInfo(GlobalSafeToolKit.getIns().getBusinessType());
    }

    public static void onNewTrustedContactAdded(boolean z) {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.onNewTrustedContactAdded(z);
        }
    }

    public static void onContactsShared() {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.onContactsShared();
        }
    }

    public static void onTrustedContactChanged(SfContactsManageModel sfContactsManageModel) {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.onTrustedContactChanged(sfContactsManageModel);
        }
    }

    public static void startSocialShare(boolean z) {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.startSocialShare(z);
        }
    }

    public static Map<String, Object> getBaseHttpParams(Context context) {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            return a.getBaseHttpParams(context);
        }
        return null;
    }

    public static void nullShieldClick(Context context) {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.nullShieldClick(context);
        }
    }

    public static void getCurrentLocation(Context context, IGlobalSfInfoService.SfCallback sfCallback) {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.getCurrentLocation(context, sfCallback);
        }
    }

    public static void registerCommonMsgPush(IGlobalSfInfoService.ISfPushListener iSfPushListener) {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.registerCommonMsgPush(iSfPushListener);
        }
    }

    public static void unregisterCommonMsgPush(IGlobalSfInfoService.ISfPushListener iSfPushListener) {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.unregisterCommonMsgPush(iSfPushListener);
        }
    }

    public static String getAlias() {
        IGlobalSfInfoService a = m19954a();
        return a != null ? a.getAlias() : "";
    }

    public static void openLawWebView() {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.openLawWebView();
        }
    }

    public static void showDialog(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, View.OnClickListener onClickListener) {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.showDialog(fragmentActivity, str, str2, str3, str4, onClickListener);
        }
    }

    public static void onRecordingStatusChanged(Boolean bool) {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.onRecordingStatusChanged(bool);
        }
    }

    public static void sendLocation() {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.sendLocation();
        }
    }

    public static void handleUri(Context context, String str) {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.handleUri(context, str);
        }
    }

    public static void addOmegaEvent(String str, Map<String, Object> map) {
        IGlobalSfInfoService a = m19954a();
        if (a != null) {
            a.addOmegaEvent(str, map);
        }
    }
}
