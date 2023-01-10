package com.didi.globalsafetoolkit.business.safeCenter;

import android.content.Context;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.globalsafetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.globalsafetoolkit.business.emergency.model.SfEmgStatus;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfPanelData;
import com.didi.globalsafetoolkit.model.SfBaseObject;
import com.didi.globalsafetoolkit.net.SfResponseListener;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.util.Map;

public interface ISfManagerInterface {
    void closePanel();

    void getEmergencyStatus(SfResponseListener<SfEmgStatus> sfResponseListener);

    void onViewDestory();

    void openEmergencyPage(Context context);

    void openPanel();

    void openRealTimeMonitorPage(Context context);

    void openRecordAudioPage(Context context);

    void openSafeyCenterPage();

    void openTripSharePage();

    void refreshBubbleData(int i, Map<String, Object> map, BffResponseListener bffResponseListener);

    void refreshPanelData(int i, Map<String, Object> map, BffResponseListener<GlobalSfPanelData> bffResponseListener);

    void reportMonitorEvent(Context context, int i, RpcService.Callback<JsonObject> callback);

    void reportMonitorState(Context context, int i, int i2, RpcService.Callback<JsonObject> callback);

    void reportUserState(Context context, RpcService.Callback<JsonObject> callback, String str);

    void requestEmergencyInfo(SfResponseListener<SfEmgInfo> sfResponseListener);

    void safeToolKitRecordDurantionUpdate(Map<String, String> map);

    void showCancelPoliceDialog(Context context, String str);

    void showRecoverPoliceDialog(Context context);

    void startEmergency(SfResponseListener<SfBaseObject> sfResponseListener);

    void startRecord();

    void stopBubbleAnimation();

    void stopEmergencyCall(SfResponseListener<SfBaseObject> sfResponseListener);

    void stopRecord();
}
