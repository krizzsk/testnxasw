package com.didi.globalsafetoolkit.api;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.globalsafetoolkit.SafeBusinessData;
import com.didi.globalsafetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.globalsafetoolkit.model.SfLocation;
import java.util.Map;

public interface IGlobalSfInfoService {
    public static final int EMEGENCY_ASSISTANCE = 9;
    public static final int EMEGENCY_CALL = 12;
    public static final int REAL_TIME_MONITOR = 1;
    public static final int REAL_TIME_MONITOR_OK = 1;
    public static final int REAL_TIME_MONITOR_TO_SAFETY = 2;
    public static final int RECORD_AUDIO = 5;
    public static final int SAFETY_CENTER = 10;
    public static final int SHARE_TRIP = 3;

    public interface ISfPushListener {
        void onCommonMsgReceived(int i, String str);
    }

    public interface SfCallback {
        void onFailed(String str);

        void onSucceed(SfLocation sfLocation);
    }

    void addOmegaEvent(String str, Map<String, Object> map);

    String getAlias();

    Map<String, Object> getBaseHttpParams(Context context);

    SafeBusinessData getBusinessInfo();

    void getCurrentLocation(Context context, SfCallback sfCallback);

    void handleUri(Context context, String str);

    @Deprecated
    void monitorAbnormalClick(Context context, String str);

    void nullShieldClick(Context context);

    void onContactsShared();

    void onNewTrustedContactAdded(boolean z);

    void onRecordingStatusChanged(Boolean bool);

    void onTrustedContactChanged(SfContactsManageModel sfContactsManageModel);

    void openLawWebView();

    void registerCommonMsgPush(ISfPushListener iSfPushListener);

    void sendLocation();

    void showDialog(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, View.OnClickListener onClickListener);

    void startSocialShare(boolean z);

    void unregisterCommonMsgPush(ISfPushListener iSfPushListener);
}
