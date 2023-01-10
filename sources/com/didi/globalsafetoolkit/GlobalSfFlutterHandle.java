package com.didi.globalsafetoolkit;

import java.util.Map;
import p218io.flutter.plugin.common.MethodChannel;

public interface GlobalSfFlutterHandle {
    void getEmergencyInfo(MethodChannel.Result result);

    void getEmergencyPhoneNumber(MethodChannel.Result result);

    void getEmergencyStatus(MethodChannel.Result result);

    void getMonitorInfo(MethodChannel.Result result);

    void getRecordInfo(MethodChannel.Result result);

    void getRecordStatus(MethodChannel.Result result);

    void getUserLocation(MethodChannel.Result result);

    void jumpToLearnMore(MethodChannel.Result result, String str);

    void jumpToPhoneCall(MethodChannel.Result result);

    void onDetached();

    void onGetInfo(MethodChannel.Result result);

    void openOrCloseMonitor(MethodChannel.Result result, Map<String, Object> map);

    void openOrCloseRecord(MethodChannel.Result result, Map<String, Object> map);

    void registerPushMessage(MethodChannel.Result result);

    void sendCurrentLocation(MethodChannel.Result result);

    void setAutoRecordState(MethodChannel.Result result, Map<String, Object> map);

    void startEmergencyCall(MethodChannel.Result result);

    void stopEmergencyCall(MethodChannel.Result result);

    void unregisterPushMessage(MethodChannel.Result result);
}
