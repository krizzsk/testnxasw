package com.didi.safetoolkit.business.bubble;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.didi.flutter.nacho.Nacho;
import com.didi.flutter.nacho.p115ui.UIHelper;
import com.didi.safetoolkit.FlutterDataHandle;
import com.didi.safetoolkit.api.ISfJarvisService;
import com.didi.safetoolkit.business.JarvisDataHelper;
import com.didi.safetoolkit.business.bubble.BubbleSwitcherView;
import com.didi.safetoolkit.business.bubble.ISafePresenter;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.safetoolkit.router.SfRouterUtil;
import com.didi.safetoolkit.util.SfListenerManager;
import com.didi.safetoolkit.util.SfOmegaOptListener;
import com.didi.safetoolkit.util.SfOnAntiShakeClickListener;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import p218io.flutter.plugin.common.MethodChannel;

public class SfJarvisController implements ISfJarvisController {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f37035a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ISafePresenter f37036b;

    /* renamed from: c */
    private BubbleView f37037c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SfJarvisData f37038d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f37039e;

    /* renamed from: f */
    private boolean f37040f = false;

    /* renamed from: g */
    private FlutterDataHandle f37041g = new FlutterDataHandle() {
        public void onGetInfo(MethodChannel.Result result) {
            if (SfJarvisController.this.f37038d != null) {
                try {
                    result.success(new Gson().toJson((Object) SfJarvisController.this.f37038d));
                } catch (Exception e) {
                    e.printStackTrace();
                    result.error("", "", (Object) null);
                }
            } else {
                result.error("", "", (Object) null);
            }
        }

        public void onDetached() {
            Uri parse = Uri.parse(SfJarvisController.this.f37039e);
            String path = parse.getPath();
            if (!TextUtils.isEmpty(path) && "/safety/safety_panel".equals(path) && !TextUtils.isEmpty(parse.getQueryParameter("bubbleId"))) {
                String queryParameter = parse.getQueryParameter("bubbleId");
                SfJarvisController sfJarvisController = SfJarvisController.this;
                sfJarvisController.m27978a(sfJarvisController.f37035a, queryParameter);
            }
        }
    };

    public void onRemove() {
    }

    public SfJarvisController(Context context) {
        this.f37035a = context;
        this.f37037c = new BubbleView(this.f37035a);
        this.f37036b = new SafePresenter(context);
        init();
    }

    public SfJarvisController(Context context, int i) {
        this.f37035a = context;
        BubbleView bubbleView = new BubbleView(this.f37035a, i);
        this.f37037c = bubbleView;
        bubbleView.setIconSize(i);
        this.f37036b = new SafePresenter(context);
        init();
    }

    public View getView() {
        return this.f37037c;
    }

    public void setBubbleStatusAndShow(final SfBubbleData sfBubbleData) {
        if (sfBubbleData == null) {
            this.f37037c.setVisibleExceptImg(false);
            this.f37037c.updateSwitcher((SfBubbleData) null, (BubbleSwitcherView.ClickListener) null);
            this.f37037c.setBubbleSymbol("Normal");
            this.f37037c.setBubbleBg("#FFFCFEFF");
            this.f37037c.setOnClickListener(new SfOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    String str;
                    if (SfJarvisController.this.f37038d == null || SfJarvisController.this.f37038d.menus == null || SfJarvisController.this.f37038d.banner == null) {
                        ISfJarvisService iSfJarvisService = (ISfJarvisService) ServiceLoader.load(ISfJarvisService.class, SafeToolKit.getIns().getBusinessType()).get();
                        if (iSfJarvisService != null) {
                            iSfJarvisService.nullShieldClick(SfJarvisController.this.f37035a);
                            return;
                        }
                        return;
                    }
                    if (SfJarvisController.this.f37038d.timeline == null) {
                        str = "?_nacho_container_tag=safe_toolkit&_nacho_height=" + UIHelper.flutterDesignPx2NativePx(SfJarvisController.this.f37035a, (float) ((SfJarvisController.this.f37038d.menus.size() * 168) + 304));
                    } else {
                        str = "";
                    }
                    SfJarvisController.this.f37036b.onActionClick("globalOneTravel://one/safety/safety_panel" + str);
                    SfOmegaUtil.addEventId("ibt_gp_safetyicon_btn_ck").report();
                }
            });
            return;
        }
        this.f37037c.setVisibleExceptImg(true);
        this.f37037c.setBubbleSymbol(sfBubbleData.dangerLevel);
        this.f37037c.setBubbleBg(sfBubbleData.bgColor);
        this.f37037c.updateSwitcher(sfBubbleData, new BubbleSwitcherView.ClickListener() {
            public void onActionClick(String str) {
                String unused = SfJarvisController.this.f37039e = str;
                SfJarvisController.this.f37036b.onActionClick(str);
            }
        });
        this.f37037c.setOnClickListener(new SfOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                String str;
                if (SfJarvisController.this.f37038d != null && SfJarvisController.this.f37038d.menus != null && SfJarvisController.this.f37038d.banner != null) {
                    if (SfJarvisController.this.f37038d.timeline == null) {
                        str = "?_nacho_container_tag=safe_toolkit&_nacho_height=" + UIHelper.flutterDesignPx2NativePx(SfJarvisController.this.f37035a, (float) ((SfJarvisController.this.f37038d.menus.size() * 168) + 304));
                    } else {
                        str = "";
                    }
                    SfJarvisController.this.f37036b.onActionClick("globalOneTravel://one/safety/safety_panel" + str);
                    SfOmegaUtil.addEventId("ibt_gp_safetyicon_btn_ck").addKeyValue(SfOmegaUtil.getJsonObjectMap(sfBubbleData.track)).report();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27981a(SfBubbleData sfBubbleData) {
        if (sfBubbleData != null) {
            String str = sfBubbleData.dangerLevel;
            Map<String, Object> jsonObjectMap = SfOmegaUtil.getJsonObjectMap(sfBubbleData.track);
            char c = 65535;
            switch (str.hashCode()) {
                case -1955878649:
                    if (str.equals("Normal")) {
                        c = 0;
                        break;
                    }
                    break;
                case -224957234:
                    if (str.equals("Low_Medium_Risk")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1310068556:
                    if (str.equals("High_Risk")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1795442690:
                    if (str.equals("Important")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            String str2 = c != 0 ? c != 1 ? c != 2 ? c != 3 ? "" : "red" : "yellow" : "blue" : "white";
            if (m27983a(jsonObjectMap)) {
                SfOmegaUtil.addEventId("ibt_gp_safetyicon_view_sw").addKeyValue(jsonObjectMap).addKeyValue("style", str2).report();
            }
        }
    }

    /* renamed from: a */
    private boolean m27982a(SfJarvisData sfJarvisData) {
        return (sfJarvisData == null || sfJarvisData.menus == null || sfJarvisData.banner == null) ? false : true;
    }

    public void refreshJarvisData(SfJarvisData sfJarvisData) {
        this.f37038d = sfJarvisData;
        if (Nacho.getInstance().isFlutterOnTop() && m27982a(sfJarvisData) && SafeToolKit.getIns().getmFlutterListener() != null) {
            SafeToolKit.getIns().getmFlutterListener().updateInfo(new Gson().toJson((Object) this.f37038d));
        }
        boolean z = true;
        try {
            if (!this.f37040f && !TripRecordingManager.Companion.getInstance().isRecording() && JarvisDataHelper.openVoice(sfJarvisData) && (this.f37035a instanceof Activity)) {
                this.f37040f = true;
                TripRecordingManager.Companion.getInstance().startAndPermission((Activity) this.f37035a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f37036b.refreshJarvisData(sfJarvisData, new ISafePresenter.Callback() {
            public void callback(SfBubbleData sfBubbleData, boolean z) {
                SfJarvisController.this.setBubbleStatusAndShow(sfBubbleData);
                if (z) {
                    SfJarvisController.this.m27981a(sfBubbleData);
                }
            }
        });
        if (SfListenerManager.getMonitorUpdateListener() != null && sfJarvisData != null && sfJarvisData.menus != null && sfJarvisData.menus.size() > 0) {
            Iterator<JsonElement> it = sfJarvisData.menus.iterator();
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
                            SfListenerManager.getMonitorUpdateListener().monitorUpdate(sfViewMonitorMenuModel);
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    public void closeSafePanel() {
        Nacho.getInstance().dismissFlutterDialog();
    }

    public void init() {
        SafeToolKit.getIns().setFlutterDataHandle(this.f37041g);
    }

    public void removeCallback() {
        ISafePresenter iSafePresenter = this.f37036b;
        if (iSafePresenter != null) {
            iSafePresenter.removeCallBacks();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27978a(Context context, String str) {
        ISfJarvisService iSfJarvisService = (ISfJarvisService) ServiceLoader.load(ISfJarvisService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfJarvisService != null) {
            iSfJarvisService.monitorAbnormalClick(context, str);
        }
    }

    /* renamed from: a */
    private boolean m27983a(Map<String, Object> map) {
        SfOmegaOptListener sfSpListener = SafeToolKit.getIns().getSfSpListener();
        if (sfSpListener == null || map == null) {
            return false;
        }
        return sfSpListener.isReportOmega(String.valueOf(map.get("status_id")));
    }
}
