package com.didi.globalsafetoolkit;

import java.util.Map;

public interface GlobaSfToFlutter {
    void buttonStatusChanged(String str, String str2);

    void safeToolKitRecordDurantionUpdate(Map<String, String> map);

    void showCancelAlarmDialog();

    void stopEmergency();

    void updateInfo(String str);
}
