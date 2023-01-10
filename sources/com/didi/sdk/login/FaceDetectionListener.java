package com.didi.sdk.login;

import android.content.Context;
import com.didi.sdk.component.protocol.ComponentLoadUtil;
import com.didi.sdk.component.protocol.IA3Manager;
import com.didi.sdk.util.SystemUtil;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.listener.pojo.FaceParam;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceConfig;
import com.didichuxing.diface.DiFaceParam;
import com.didichuxing.diface.DiFaceResult;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceDetectionListener implements LoginListeners.FaceListener {

    /* renamed from: a */
    Context f39444a;

    public FaceDetectionListener(Context context) {
        this.f39444a = context;
        DiFace.initialize(new DiFaceConfig.Builder().setAppContext(context).setDebug(false).create());
    }

    public void callFaceListener(FaceParam faceParam, final LoginListeners.FaceCallback faceCallback) {
        DiFaceParam diFaceParam = new DiFaceParam();
        JSONObject jSONObject = new JSONObject();
        try {
            DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f39444a).getLastKnownLocation();
            if (lastKnownLocation != null) {
                jSONObject.put("lat", lastKnownLocation.getLatitude());
                jSONObject.put("lng", lastKnownLocation.getLongitude());
                jSONObject.put("a3", m29711a(this.f39444a));
            }
            jSONObject.put("ip", SystemUtil.getIPAddress(this.f39444a));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        diFaceParam.setData(jSONObject.toString());
        diFaceParam.setBizCode(faceParam.getBizCode());
        diFaceParam.setSessionId(faceParam.getSessionId());
        diFaceParam.setToken(faceParam.getAccessToken());
        DiFace.startFaceRecognition(diFaceParam, new DiFace.IDiFaceCallback() {
            public void onResult(DiFaceResult diFaceResult) {
                faceCallback.onResult(diFaceResult.getCode());
            }
        });
    }

    /* renamed from: a */
    private String m29711a(Context context) {
        IA3Manager iA3Manager = (IA3Manager) ComponentLoadUtil.getComponent(IA3Manager.class);
        return iA3Manager != null ? iA3Manager.getToken(context) : "";
    }
}
