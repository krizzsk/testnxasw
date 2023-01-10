package com.didi.globalsafetoolkit.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.SafeBusinessData;
import com.didi.globalsafetoolkit.business.record.request.SfAutoRecordRequest;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.business.sdk.GlobalSafeToolKit;
import com.didi.globalsafetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.globalsafetoolkit.business.triprecording.GlobalTripRecordingManagerNew;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.io.IOException;

public class GlobalSfRouterHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path)) {
            char c = 65535;
            boolean z = true;
            switch (path.hashCode()) {
                case -1915864856:
                    if (path.equals("/safety/cancel_call_police")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1164833725:
                    if (path.equals("/safety/share_silent")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1138155478:
                    if (path.equals("/safety/auto_record_audio")) {
                        c = 7;
                        break;
                    }
                    break;
                case 183230701:
                    if (path.equals("/safety/trip_monitor_ok")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1280884214:
                    if (path.equals("/safety/record_audio")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1460277139:
                    if (path.equals("/safety/share_trip")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1595247811:
                    if (path.equals("/safety/emergency")) {
                        c = 5;
                        break;
                    }
                    break;
                case 2075621070:
                    if (path.equals("/safety/trip_monitor")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (SfRouterUtil.parseInt(uri.getQueryParameter("onlyAddContact"), 0) != 1) {
                        z = false;
                    }
                    m20138a(z);
                    return;
                case 1:
                    GlobalSafeToolKit.getIns().shareToSOSContacts();
                    return;
                case 2:
                    m20139b(uri, request.getContext());
                    return;
                case 3:
                    m20140c(uri, request.getContext());
                    return;
                case 4:
                    GlobalSfManager.getInstance().showCancelPoliceDialog(request.getContext(), uri.toString());
                    return;
                case 5:
                    int parseInt = SfRouterUtil.parseInt(uri.getQueryParameter("isAcceptedOrder"), 0);
                    GlobalSfManager.getInstance().openEmergencyPage(request.getContext());
                    return;
                case 6:
                    String queryParameter = uri.getQueryParameter("bubbleId");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        m20136a(request.getContext(), queryParameter);
                        return;
                    }
                    return;
                case 7:
                    m20137a(uri, request.getContext());
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private void m20137a(Uri uri, Context context) {
        int i = 0;
        if ((SfRouterUtil.parseInt(uri.getQueryParameter("enable"), 0) == 1) && (context instanceof Activity)) {
            GlobalTripRecordingManagerNew.Companion.getInstance().startAndPermission((Activity) context);
        }
        int parseInt = SfRouterUtil.parseInt(uri.getQueryParameter("auto_allow"), 0);
        if (parseInt == 0 || parseInt == 1) {
            i = 1;
        }
        if (parseInt == 1) {
            SfAutoRecordRequest.autoRecordReport(1, i);
        } else if (parseInt == 2) {
            SfAutoRecordRequest.autoRecordReport(uri.getQueryParameter("action_id"), i);
        } else {
            SfAutoRecordRequest.requestJarvis(i);
        }
    }

    /* renamed from: a */
    private void m20136a(Context context, String str) {
        GlobalSfManager.getInstance().reportUserState(context, new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
            }
        }, str);
    }

    /* renamed from: b */
    private void m20139b(Uri uri, Context context) {
        SfViewMonitorMenuModel sfViewMonitorMenuModel = new SfViewMonitorMenuModel();
        boolean z = false;
        sfViewMonitorMenuModel.canMonitor = SfRouterUtil.parseInt(uri.getQueryParameter("enable_notice"), 0) == 1;
        if (SfRouterUtil.parseInt(uri.getQueryParameter("monitor_type"), 0) == 2) {
            z = true;
        }
        sfViewMonitorMenuModel.isMonitoring = z;
        sfViewMonitorMenuModel.pushId = uri.getQueryParameter("push_id");
        sfViewMonitorMenuModel.alertTile = uri.getQueryParameter("alert_title");
        sfViewMonitorMenuModel.btnOkText = uri.getQueryParameter("button_ok");
        sfViewMonitorMenuModel.btnJumpText = uri.getQueryParameter("button_to_safety");
        sfViewMonitorMenuModel.pageTitle = uri.getQueryParameter("detail_page_title");
        sfViewMonitorMenuModel.imgUrl = uri.getQueryParameter("detail_page_imgurl");
        sfViewMonitorMenuModel.monitorDesc = uri.getQueryParameter("detail_page_content");
        sfViewMonitorMenuModel.monitorStateText = uri.getQueryParameter("detail_page_monitor_state_text");
        GlobalSfManager.getInstance().openRealTimeMonitorPage(context);
        GlobalSfManager.getInstance().reportMonitorEvent(context, 10, new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
            }
        });
    }

    /* renamed from: c */
    private void m20140c(Uri uri, Context context) {
        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
        if (businessInfo != null) {
            businessInfo.getOid();
        }
        GlobalSfManager instance = GlobalSfManager.getInstance();
        boolean z = false;
        if (SfRouterUtil.parseInt(uri.getQueryParameter("enable"), 0) == 1) {
            z = true;
        }
        instance.setCanRecord(z);
        GlobalSfManager.getInstance().openRecordAudioPage(context);
        GlobalSfManager.getInstance().reportMonitorEvent(context, 5, new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
            }
        });
    }

    /* renamed from: a */
    private void m20138a(boolean z) {
        GlobalSfBusinessInterface.startSocialShare(z);
    }
}
