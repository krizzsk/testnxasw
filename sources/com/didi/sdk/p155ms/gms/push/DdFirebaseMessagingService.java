package com.didi.sdk.p155ms.gms.push;

import android.content.Intent;
import android.text.TextUtils;
import com.didi.sdk.p155ms.common.type.IMSType;
import com.didi.sdk.p155ms.push.PushTokenInterceptor;
import com.didi.sdk.push.common.IThirdPartyMsgParamsGetter;
import com.didi.sdk.push.common.PushAckParams;
import com.didi.sdk.push.common.ThirdPartyMsgHttpApi;
import com.didi.sdk.push.common.ThirdPartyMsgManager;
import com.didi.sdk.push.dpush.LogUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.sdk.ms.gms.push.DdFirebaseMessagingService */
public class DdFirebaseMessagingService extends FirebaseMessagingService {
    public static int FCM_PUSH_BACKGROUND_ARRIVE = 2;
    public static int FCM_PUSH_FOREGROUND_ARRIVE = 5;

    public void onNewToken(String str) {
        super.onNewToken(str);
        List<PushTokenInterceptor.Interceptor> interceptors = PushTokenInterceptor.getInterceptors();
        if (interceptors != null) {
            for (PushTokenInterceptor.Interceptor onNewToken : interceptors) {
                onNewToken.onNewToken(getApplicationContext(), str, IMSType.GMS);
            }
        }
        sendRegistrationToServer(str);
    }

    private void sendRegistrationToServer(String str) {
        LogUtil.m29959d(3, "sendRegistrationToServer token: " + str);
        FcmUtil.saveFcmToken(getApplicationContext(), str);
        IThirdPartyMsgParamsGetter serverParamsGetter = ThirdPartyMsgManager.getInstance().getServerParamsGetter();
        if (serverParamsGetter == null) {
            LogUtil.m29959d(3, "sendRegistrationToServer IServerParamsGetter is null");
        } else if (!FcmUtil.getSyncStatus(getApplicationContext())) {
            serverParamsGetter.getUploadThirdIdParams().fcm_id = str;
            ThirdPartyMsgHttpApi.uploadThirdId(getApplicationContext(), serverParamsGetter.getUploadThirdIdParams(), (RpcService.Callback<String>) new RpcService.Callback<String>() {
                public void onSuccess(String str) {
                    FcmUtil.saveSyncStatus(DdFirebaseMessagingService.this.getApplicationContext(), true);
                }

                public void onFailure(IOException iOException) {
                    FcmUtil.saveSyncStatus(DdFirebaseMessagingService.this.getApplicationContext(), false);
                }
            });
        }
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str;
        if (remoteMessage == null) {
            LogUtil.m29959d(3, "onMessageReceived null");
            return;
        }
        LogUtil.m29959d(3, "From: " + remoteMessage.getFrom());
        Map<String, String> data = remoteMessage.getData();
        if (data == null) {
            LogUtil.m29959d(3, "onMessageReceived data null");
        }
        if (data != null && data.size() > 0) {
            LogUtil.m29959d(3, "Message data outer payload: " + data);
            String str2 = data.get("payload");
            if (!TextUtils.isEmpty(str2)) {
                ThirdPartyMsgManager.getInstance().dispatchMsg(str2);
                try {
                    String string = new JSONObject(str2).getString("p_id");
                    if (!TextUtils.isEmpty(string)) {
                        PushAckParams pushAckParams = new PushAckParams();
                        pushAckParams.pId = string;
                        IThirdPartyMsgParamsGetter serverParamsGetter = ThirdPartyMsgManager.getInstance().getServerParamsGetter();
                        if (!(serverParamsGetter == null || serverParamsGetter.getUploadThirdIdParams() == null)) {
                            pushAckParams.appType = serverParamsGetter.getUploadThirdIdParams().app_type;
                        }
                        pushAckParams.state = 3;
                        ThirdPartyMsgHttpApi.uploadBackToServer(getApplicationContext(), pushAckParams);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                HashMap hashMap = new HashMap();
                if (data == null) {
                    str = "data is null";
                } else {
                    str = data.toString();
                }
                hashMap.put("data", str);
                OmegaSDKAdapter.trackEvent("tech_push_data_no_payload", (Map<String, Object>) hashMap);
            }
        }
        if (remoteMessage.getNotification() != null) {
            LogUtil.m29959d(3, "Message Notification title: " + remoteMessage.getNotification().getTitle() + " body = " + remoteMessage.getNotification().getBody());
        }
    }

    public void handleIntent(Intent intent) {
        super.handleIntent(intent);
        if (intent != null) {
            String str = null;
            String string = intent.getExtras() != null ? intent.getExtras().getString("gcm.notification.title") : null;
            String string2 = intent.getExtras() != null ? intent.getExtras().getString("gcm.notification.body") : null;
            if (intent.getExtras() != null) {
                str = intent.getExtras().getString("payload");
            }
            HashMap hashMap = new HashMap();
            hashMap.put("title", string);
            hashMap.put("body", string2);
            hashMap.put("content", str);
            OmegaSDKAdapter.trackEvent("tech_fcm_push_data_all_msg", (Map<String, Object>) hashMap);
            uploadFcmPushStatusToServer(str);
        }
    }

    private void uploadFcmPushStatusToServer(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String string = new JSONObject(str).getString("p_id");
                if (!TextUtils.isEmpty(string)) {
                    PushAckParams pushAckParams = new PushAckParams();
                    pushAckParams.pId = string;
                    IThirdPartyMsgParamsGetter serverParamsGetter = ThirdPartyMsgManager.getInstance().getServerParamsGetter();
                    if (!(serverParamsGetter == null || serverParamsGetter.getUploadThirdIdParams() == null)) {
                        pushAckParams.appType = serverParamsGetter.getUploadThirdIdParams().app_type;
                    }
                    pushAckParams.state = FcmUtil.isAppInForeground(getApplicationContext()) ? FCM_PUSH_FOREGROUND_ARRIVE : FCM_PUSH_BACKGROUND_ARRIVE;
                    ThirdPartyMsgHttpApi.uploadBackToServer(getApplicationContext(), pushAckParams);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
