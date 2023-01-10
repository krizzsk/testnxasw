package com.didi.globalsafetoolkit.business.bubble;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.didi.flutter.nacho.Nacho;
import com.didi.flutter.nacho.p115ui.UIHelper;
import com.didi.globalsafetoolkit.business.JarvisDataHelper;
import com.didi.globalsafetoolkit.business.bubble.BubbleSwitcherView;
import com.didi.globalsafetoolkit.business.bubble.ISafePresenter;
import com.didi.globalsafetoolkit.business.bubble.model.SfBubbleData;
import com.didi.globalsafetoolkit.business.bubble.model.SfJarvisData;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfBubbleData;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfPanelData;
import com.didi.globalsafetoolkit.business.sdk.GlobalSafeToolKit;
import com.didi.globalsafetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.globalsafetoolkit.business.triprecording.GlobalTripRecordingManagerNew;
import com.didi.globalsafetoolkit.omega.SfOmegaUtil;
import com.didi.globalsafetoolkit.router.SfRouterUtil;
import com.didi.globalsafetoolkit.util.SfListenerManager;
import com.didi.globalsafetoolkit.util.SfOmegaOptListener;
import com.didi.globalsafetoolkit.util.SfOnAntiShakeClickListener;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class GlobalSfViewOwner implements IGlobalSfViewOwner {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f24943a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ISafePresenter f24944b;

    /* renamed from: c */
    private BubbleView f24945c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public GlobalSfPanelData f24946d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f24947e;

    /* renamed from: f */
    private boolean f24948f = false;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19988a() {
    }

    public void onRemove() {
    }

    public GlobalSfViewOwner(Context context) {
        this.f24943a = context;
        this.f24945c = new BubbleView(this.f24943a);
        this.f24944b = new SafePresenter(context);
    }

    public GlobalSfViewOwner(Context context, int i) {
        this.f24943a = context;
        BubbleView bubbleView = new BubbleView(this.f24943a, i);
        this.f24945c = bubbleView;
        bubbleView.setIconSize(i);
        this.f24944b = new SafePresenter(context);
    }

    public View getView() {
        return this.f24945c;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19992a(final SfBubbleData sfBubbleData) {
        if (sfBubbleData == null) {
            this.f24945c.setVisibleExceptImg(false);
            this.f24945c.updateSwitcher((SfBubbleData) null, (BubbleSwitcherView.ClickListener) null);
            this.f24945c.setBubbleSymbol("Normal");
            this.f24945c.setBubbleBg("#FFFCFEFF");
            this.f24945c.setOnClickListener(new SfOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    String str;
                    GlobalSfViewOwner.this.m19988a();
                    if (GlobalSfViewOwner.this.f24946d == null) {
                        str = "?_nacho_container_tag=safe_toolkit&_nacho_height=" + UIHelper.flutterDesignPx2NativePx(GlobalSfViewOwner.this.f24943a, (float) 1144);
                    } else {
                        str = "";
                    }
                    if (!(GlobalSfViewOwner.this.f24946d == null || GlobalSfViewOwner.this.f24946d.timeline != null || GlobalSfViewOwner.this.f24946d.menus == null)) {
                        str = "?_nacho_container_tag=safe_toolkit&_nacho_height=" + UIHelper.flutterDesignPx2NativePx(GlobalSfViewOwner.this.f24943a, (float) ((GlobalSfViewOwner.this.f24946d.menus.size() * 168) + 304));
                    }
                    GlobalSfViewOwner.this.f24944b.onActionClick("globalOneTravel://one/safety/safety_panel" + str);
                    SfOmegaUtil.addEventId("ibt_gp_safetyicon_btn_ck").report();
                }
            });
            return;
        }
        this.f24945c.setVisibleExceptImg(true);
        this.f24945c.setBubbleSymbol(sfBubbleData.dangerLevel);
        this.f24945c.setBubbleBg(sfBubbleData.bgColor);
        this.f24945c.updateSwitcher(sfBubbleData, new BubbleSwitcherView.ClickListener() {
            public void onActionClick(String str) {
                String unused = GlobalSfViewOwner.this.f24947e = str;
                GlobalSfViewOwner.this.f24944b.onActionClick(str);
            }
        });
        this.f24945c.setOnClickListener(new SfOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                String str;
                GlobalSfViewOwner.this.m19988a();
                if (GlobalSfViewOwner.this.f24946d == null) {
                    str = "?_nacho_container_tag=safe_toolkit&_nacho_height=" + UIHelper.flutterDesignPx2NativePx(GlobalSfViewOwner.this.f24943a, (float) 1144);
                } else {
                    str = "";
                }
                if (!(GlobalSfViewOwner.this.f24946d == null || GlobalSfViewOwner.this.f24946d.timeline != null || GlobalSfViewOwner.this.f24946d.menus == null)) {
                    str = "?_nacho_container_tag=safe_toolkit&_nacho_height=" + UIHelper.flutterDesignPx2NativePx(GlobalSfViewOwner.this.f24943a, (float) ((GlobalSfViewOwner.this.f24946d.menus.size() * 168) + 304));
                }
                GlobalSfViewOwner.this.f24944b.onActionClick("globalOneTravel://one/safety/safety_panel" + str);
                SfOmegaUtil.addEventId("ibt_gp_safetyicon_btn_ck").addKeyValue(SfOmegaUtil.getJsonObjectMap(sfBubbleData.track)).report();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m19997b(SfBubbleData sfBubbleData) {
        if (sfBubbleData != null) {
            Map<String, Object> jsonObjectMap = SfOmegaUtil.getJsonObjectMap(sfBubbleData.track);
            if (m19994a(jsonObjectMap)) {
                SfOmegaUtil.addEventId("ibt_gp_safetyicon_view_sw").addKeyValue(jsonObjectMap).report();
            }
        }
    }

    /* renamed from: a */
    private boolean m19993a(SfJarvisData sfJarvisData) {
        return (sfJarvisData == null || sfJarvisData.menus == null || sfJarvisData.banner == null) ? false : true;
    }

    public void closeSafePanel() {
        Nacho.getInstance().dismissFlutterDialog();
    }

    public void removeCallback() {
        ISafePresenter iSafePresenter = this.f24944b;
        if (iSafePresenter != null) {
            iSafePresenter.removeCallBacks();
        }
    }

    public void updateBubbleData(GlobalSfBubbleData globalSfBubbleData) {
        this.f24944b.refreshJarvisData(globalSfBubbleData, new ISafePresenter.Callback() {
            public void callback(SfBubbleData sfBubbleData, boolean z) {
                GlobalSfViewOwner.this.m19992a(sfBubbleData);
                if (z) {
                    GlobalSfViewOwner.this.m19997b(sfBubbleData);
                }
            }
        });
    }

    public void updatePanelData(GlobalSfPanelData globalSfPanelData) {
        GlobalSfPanelData globalSfPanelData2;
        this.f24946d = globalSfPanelData;
        if (Nacho.getInstance().isFlutterOnTop() && GlobalSfManager.getInstance().getFlutterListener() != null) {
            GlobalSfManager.getInstance().getFlutterListener().updateInfo(new Gson().toJson((Object) globalSfPanelData));
        }
        boolean z = true;
        try {
            if (!this.f24948f && !GlobalTripRecordingManagerNew.Companion.getInstance().isRecording() && JarvisDataHelper.openVoice(globalSfPanelData) && (this.f24943a instanceof Activity)) {
                this.f24948f = true;
                GlobalTripRecordingManagerNew.Companion.getInstance().startAndPermission((Activity) this.f24943a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (SfListenerManager.getMonitorUpdateListener() != null && (globalSfPanelData2 = this.f24946d) != null && globalSfPanelData2.menus != null && this.f24946d.menus.size() > 0) {
            Iterator<JsonElement> it = this.f24946d.menus.iterator();
            while (it.hasNext()) {
                JsonElement next = it.next();
                if (next instanceof JsonObject) {
                    String asString = ((JsonObject) next).get("action").getAsString();
                    if (!TextUtils.isEmpty(asString)) {
                        Uri parse = Uri.parse(asString);
                        String path = parse.getPath();
                        if (!TextUtils.isEmpty(path) && path.equals("/safety/trip_monitor")) {
                            SfViewMonitorMenuModel sfViewMonitorMenuModel = new SfViewMonitorMenuModel();
                            sfViewMonitorMenuModel.canMonitor = SfRouterUtil.parseInt(parse.getQueryParameter("enable_notice"), 0) == 1;
                            if (SfRouterUtil.parseInt(parse.getQueryParameter("monitor_type"), 0) != 2) {
                                z = false;
                            }
                            sfViewMonitorMenuModel.isMonitoring = z;
                            sfViewMonitorMenuModel.pushId = parse.getQueryParameter("push_id");
                            sfViewMonitorMenuModel.alertTile = parse.getQueryParameter("alert_title");
                            sfViewMonitorMenuModel.btnOkText = parse.getQueryParameter("button_ok");
                            sfViewMonitorMenuModel.btnJumpText = parse.getQueryParameter("button_to_safety");
                            sfViewMonitorMenuModel.pageTitle = parse.getQueryParameter("detail_page_title");
                            sfViewMonitorMenuModel.imgUrl = parse.getQueryParameter("detail_page_imgurl");
                            sfViewMonitorMenuModel.monitorDesc = parse.getQueryParameter("detail_page_content");
                            sfViewMonitorMenuModel.monitorStateText = parse.getQueryParameter("detail_page_monitor_state_text");
                            if (SfListenerManager.getMonitorUpdateListener() != null) {
                                SfListenerManager.getMonitorUpdateListener().monitorUpdate(sfViewMonitorMenuModel);
                                return;
                            }
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m19989a(Context context, String str) {
        GlobalSfManager.getInstance().reportUserState(this.f24943a, new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
            }
        }, str);
    }

    /* renamed from: a */
    private boolean m19994a(Map<String, Object> map) {
        SfOmegaOptListener sfSpListener = GlobalSafeToolKit.getIns().getSfSpListener();
        if (sfSpListener == null || map == null) {
            return false;
        }
        return sfSpListener.isReportOmega(String.valueOf(map.get("status_id")));
    }
}
