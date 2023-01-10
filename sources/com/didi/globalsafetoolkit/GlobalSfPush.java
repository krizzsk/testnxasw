package com.didi.globalsafetoolkit;

import com.didi.globalsafetoolkit.api.IGlobalSfInfoService;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import org.json.JSONException;
import org.json.JSONObject;

public class GlobalSfPush implements IGlobalSfInfoService.ISfPushListener {

    /* renamed from: a */
    private static final int f24883a = 151;

    /* renamed from: b */
    private static final String f24884b = "CLOSED";

    public void onCommonMsgReceived(int i, String str) {
        GlobaSfToFlutter flutterListener;
        if (i == 151) {
            try {
                if (f24884b.equals(new JSONObject(str).getString("dexter_status")) && (flutterListener = GlobalSfManager.getInstance().getFlutterListener()) != null) {
                    flutterListener.stopEmergency();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
