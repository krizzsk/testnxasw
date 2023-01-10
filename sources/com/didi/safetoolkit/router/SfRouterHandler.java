package com.didi.safetoolkit.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.globalsafetoolkit.apollo.SfApolloUtil;
import com.didi.globalsafetoolkit.router.GlobalSfRouterHandler;
import com.didi.safetoolkit.api.ISMonitorDetailsService;
import com.didi.safetoolkit.api.ISfInfoService;
import com.didi.safetoolkit.api.ISfJarvisService;
import com.didi.safetoolkit.business.record.request.SfAutoRecordRequest;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewRecordMenuModel;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didichuxing.foundation.spi.ServiceLoader;

public class SfRouterHandler implements IRouterHandler {

    /* renamed from: a */
    private GlobalSfRouterHandler f37295a;

    public void handle(Request request, Result result) {
        if (SfApolloUtil.isNewSafe()) {
            if (this.f37295a == null) {
                this.f37295a = new GlobalSfRouterHandler();
            }
            this.f37295a.handle(request, result);
            return;
        }
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
                    m28125a(z);
                    return;
                case 1:
                    SafeToolKit.getIns().shareToSOSContacts();
                    return;
                case 2:
                    m28126b(uri, request.getContext());
                    return;
                case 3:
                    m28127c(uri, request.getContext());
                    return;
                case 4:
                    SafeToolKit.getIns().showPoliceDialog(request.getContext(), uri.toString());
                    return;
                case 5:
                    if (SfRouterUtil.parseInt(uri.getQueryParameter("isAcceptedOrder"), 0) != 2) {
                        z = false;
                    }
                    SafeToolKit.getIns().startEmergencyAssistanceActivity(request.getContext(), z);
                    return;
                case 6:
                    String queryParameter = uri.getQueryParameter("bubbleId");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        m28123a(request.getContext(), queryParameter);
                        return;
                    }
                    return;
                case 7:
                    m28124a(uri, request.getContext());
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private void m28124a(Uri uri, Context context) {
        int i = 0;
        if ((SfRouterUtil.parseInt(uri.getQueryParameter("enable"), 0) == 1) && (context instanceof Activity)) {
            TripRecordingManager.Companion.getInstance().startAndPermission((Activity) context);
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
    private void m28123a(Context context, String str) {
        ISfJarvisService iSfJarvisService = (ISfJarvisService) ServiceLoader.load(ISfJarvisService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfJarvisService != null) {
            iSfJarvisService.monitorAbnormalClick(context, str);
        }
    }

    /* renamed from: b */
    private void m28126b(Uri uri, Context context) {
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
        SafeToolKit.getIns().startMonitorDetails(context, sfViewMonitorMenuModel);
        ISMonitorDetailsService iSMonitorDetailsService = (ISMonitorDetailsService) ServiceLoader.load(ISMonitorDetailsService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSMonitorDetailsService != null) {
            iSMonitorDetailsService.reportMonitorEvent(context, 10);
        }
    }

    /* renamed from: c */
    private void m28127c(Uri uri, Context context) {
        ISfInfoService iSfInfoService = (ISfInfoService) ServiceLoader.load(ISfInfoService.class, SafeToolKit.getIns().getBusinessType()).get();
        String carOrderId = iSfInfoService != null ? iSfInfoService.getCarOrderId() : null;
        SfViewRecordMenuModel sfViewRecordMenuModel = new SfViewRecordMenuModel();
        boolean z = true;
        if (SfRouterUtil.parseInt(uri.getQueryParameter("enable"), 0) != 1) {
            z = false;
        }
        sfViewRecordMenuModel.canRecord = z;
        sfViewRecordMenuModel.detailContent = uri.getQueryParameter("detail_page_content");
        sfViewRecordMenuModel.detailLawUrl = uri.getQueryParameter("detail_page_law_url");
        sfViewRecordMenuModel.detailLawTitle = uri.getQueryParameter("detail_page_law_text");
        sfViewRecordMenuModel.autoVoiceSwitch = SfRouterUtil.parseInt(uri.getQueryParameter("auto_voice_switch"), 0);
        sfViewRecordMenuModel.autoPopTitle = uri.getQueryParameter("auto_pop_title");
        sfViewRecordMenuModel.autoPopContent = uri.getQueryParameter("auto_pop_content");
        sfViewRecordMenuModel.autoKeepOn = uri.getQueryParameter("auto_keep_on");
        sfViewRecordMenuModel.autoTurnOff = uri.getQueryParameter("auto_turn_off");
        sfViewRecordMenuModel.manualPopTitle = uri.getQueryParameter("manual_pop_title");
        sfViewRecordMenuModel.manualPopContent = uri.getQueryParameter("manual_pop_content");
        sfViewRecordMenuModel.manualTurnOn = uri.getQueryParameter("manual_turn_on");
        sfViewRecordMenuModel.manualCancel = uri.getQueryParameter("manual_cancel");
        SafeToolKit.getIns().startJarvisTripRecordingPage(context, carOrderId, sfViewRecordMenuModel);
        ISMonitorDetailsService iSMonitorDetailsService = (ISMonitorDetailsService) ServiceLoader.load(ISMonitorDetailsService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSMonitorDetailsService != null) {
            iSMonitorDetailsService.reportMonitorEvent(context, 5);
        }
    }

    /* renamed from: a */
    private void m28125a(boolean z) {
        ISfJarvisService iSfJarvisService = (ISfJarvisService) ServiceLoader.load(ISfJarvisService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfJarvisService != null) {
            iSfJarvisService.startSocialShare(z);
        }
    }
}
