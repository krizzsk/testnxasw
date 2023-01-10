package com.didi.globalsafetoolkit.business.safeCenter;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.component.business.constant.BffConstants;
import com.didi.flutter.nacho.Nacho;
import com.didi.globalsafetoolkit.GlobaSfToFlutter;
import com.didi.globalsafetoolkit.GlobalSfDialogMgr;
import com.didi.globalsafetoolkit.GlobalSfFlutterHandle;
import com.didi.globalsafetoolkit.GlobalSfRequest;
import com.didi.globalsafetoolkit.api.IGlobalSfInfoService;
import com.didi.globalsafetoolkit.business.bubble.IGlobalSfViewOwner;
import com.didi.globalsafetoolkit.business.bubble.model.SfBubbleData;
import com.didi.globalsafetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.globalsafetoolkit.business.emergency.model.SfEmgStatus;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfBubbleData;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfPanelData;
import com.didi.globalsafetoolkit.business.triprecording.GlobalTripRecordingManagerNew;
import com.didi.globalsafetoolkit.model.SfBaseObject;
import com.didi.globalsafetoolkit.net.SfResponseListener;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.soda.customer.app.constant.Const;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GlobalSfManager implements ISfManagerInterface {

    /* renamed from: a */
    private static GlobalSfManager f25060a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map<String, WeakReference<IGlobalSfViewOwner>> f25061b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map<String, GlobalSfBubbleData> f25062c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Map<String, GlobalSfPanelData> f25063d = new HashMap();

    /* renamed from: e */
    private boolean f25064e = false;

    /* renamed from: f */
    private int f25065f = 0;

    /* renamed from: g */
    private GlobalSfDialogMgr f25066g = new GlobalSfDialogMgr();

    /* renamed from: h */
    private String f25067h = "home";

    /* renamed from: i */
    private GlobalSfFlutterHandle f25068i;
    public boolean isReleaseEnv = true;

    /* renamed from: j */
    private GlobaSfToFlutter f25069j;

    /* renamed from: k */
    private Map<String, IGlobalSfInfoService> f25070k = new HashMap();

    public void moveView(IGlobalSfViewOwner iGlobalSfViewOwner) {
    }

    public void openPanel() {
    }

    public void openSafeyCenterPage() {
    }

    public void openTripSharePage() {
    }

    public void stopBubbleAnimation() {
    }

    public void stopRecord() {
    }

    public static GlobalSfManager getInstance() {
        if (f25060a == null) {
            f25060a = new GlobalSfManager();
        }
        return f25060a;
    }

    public void setCurView(String str, IGlobalSfViewOwner iGlobalSfViewOwner) {
        this.f25061b.put(str, new WeakReference(iGlobalSfViewOwner));
        this.f25062c.put(str, (Object) null);
        this.f25063d.put(str, (Object) null);
    }

    public GlobalSfPanelData getPanelData() {
        return this.f25063d.get(this.f25067h);
    }

    public int getmIsRecording() {
        return this.f25065f;
    }

    public void setmIsRecording(int i) {
        this.f25065f = i;
    }

    public void refreshBubbleData(int i, Map<String, Object> map, BffResponseListener bffResponseListener) {
        String str = "";
        if (this.isReleaseEnv) {
            if (map != null) {
                Object obj = map.get("page");
                if (obj instanceof String) {
                    this.f25067h = (String) obj;
                }
            }
            String str2 = this.f25062c.get(this.f25067h) == null ? str : this.f25062c.get(this.f25067h).dataVer;
            int i2 = this.f25065f;
            if (str2 != null) {
                str = str2;
            }
            GlobalSfRequest.requestBubbleData(i2, i, str, map, new BffResponseListener<GlobalSfBubbleData>() {
                public void onSuccess(GlobalSfBubbleData globalSfBubbleData) {
                    if (globalSfBubbleData != null && globalSfBubbleData.errno == 0) {
                        String str = globalSfBubbleData.page;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (globalSfBubbleData.dataVer == null || GlobalSfManager.this.f25062c.get(str) == null || !globalSfBubbleData.dataVer.equals(((GlobalSfBubbleData) GlobalSfManager.this.f25062c.get(str)).dataVer)) {
                            WeakReference weakReference = (WeakReference) GlobalSfManager.this.f25061b.get(str);
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((IGlobalSfViewOwner) weakReference.get()).updateBubbleData(globalSfBubbleData);
                            }
                            GlobalSfManager.this.f25062c.put(globalSfBubbleData.page, globalSfBubbleData);
                        }
                    }
                }
            });
            return;
        }
        GlobalSfBubbleData globalSfBubbleData = new GlobalSfBubbleData();
        ArrayList arrayList = new ArrayList();
        SfBubbleData sfBubbleData = new SfBubbleData();
        sfBubbleData.bubbleId = str;
        sfBubbleData.bgColor = "#FFFCFEFF";
        sfBubbleData.dangerLevel = "Normal";
        sfBubbleData.text = "Welcome!";
        sfBubbleData.textColor = "#FF3388FF";
        sfBubbleData.show = 7;
        sfBubbleData.track = (JsonObject) new Gson().fromJson("{\"product_id\":316,\"status_id\":5}", JsonObject.class);
        arrayList.add(sfBubbleData);
        SfBubbleData sfBubbleData2 = new SfBubbleData();
        sfBubbleData2.bubbleId = str;
        sfBubbleData2.bgColor = "#FFFCFEFF";
        sfBubbleData2.dangerLevel = "Normal";
        sfBubbleData2.text = "Welcome!";
        sfBubbleData2.textColor = "#FF3388FF";
        sfBubbleData2.show = 7;
        sfBubbleData2.track = (JsonObject) new Gson().fromJson("{\"product_id\":316,\"status_id\":5}", JsonObject.class);
        arrayList.add(sfBubbleData2);
        globalSfBubbleData.bubbles = arrayList;
        globalSfBubbleData.errno = 0;
        ((IGlobalSfViewOwner) this.f25061b.get(this.f25067h).get()).updateBubbleData(globalSfBubbleData);
    }

    public static String mockResponse(Context context) {
        try {
            InputStream open = context.getAssets().open("safetools.txt");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            return new String(bArr);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void refreshPanelData(int i, Map<String, Object> map, final BffResponseListener<GlobalSfPanelData> bffResponseListener) {
        if (this.isReleaseEnv) {
            String str = "";
            String str2 = this.f25063d.get(this.f25067h) == null ? str : this.f25063d.get(this.f25067h).dataVer;
            String str3 = this.f25067h;
            int i2 = this.f25065f;
            if (str2 != null) {
                str = str2;
            }
            GlobalSfRequest.requestPanelData(str3, i2, i, str, new BffResponseListener<GlobalSfPanelData>() {
                public void onSuccess(GlobalSfPanelData globalSfPanelData) {
                    if (globalSfPanelData != null && globalSfPanelData.errno == 0) {
                        String str = globalSfPanelData.page;
                        if (!TextUtils.isEmpty(str)) {
                            WeakReference weakReference = (WeakReference) GlobalSfManager.this.f25061b.get(str);
                            if (globalSfPanelData.dataVer == null || GlobalSfManager.this.f25063d.get(str) == null || !globalSfPanelData.dataVer.equals(((GlobalSfPanelData) GlobalSfManager.this.f25063d.get(str)).dataVer)) {
                                if (!(weakReference == null || weakReference.get() == null)) {
                                    ((IGlobalSfViewOwner) weakReference.get()).updatePanelData(globalSfPanelData);
                                    BffResponseListener bffResponseListener = bffResponseListener;
                                    if (bffResponseListener != null) {
                                        bffResponseListener.onSuccess(globalSfPanelData);
                                    }
                                }
                                GlobalSfManager.this.f25063d.put(globalSfPanelData.page, globalSfPanelData);
                                return;
                            }
                            BffResponseListener bffResponseListener2 = bffResponseListener;
                            if (bffResponseListener2 != null) {
                                bffResponseListener2.onSuccess(GlobalSfManager.this.f25063d.get(str));
                            }
                        }
                    }
                }
            });
            return;
        }
        JsonObject asJsonObject = ((JsonObject) ((JsonObject) new Gson().fromJson(mockResponse(SfContextHelper.getContext()), JsonObject.class)).get("data")).getAsJsonObject("abilities").getAsJsonObject(BffConstants.AbilityID.ABILITY_JARVIS_STATUS).getAsJsonObject("data");
        GlobalSfPanelData globalSfPanelData = new GlobalSfPanelData();
        globalSfPanelData.dataVer = asJsonObject.get("data_version").getAsString();
        globalSfPanelData.banner = asJsonObject.getAsJsonArray(Const.ComponentType.BANNER);
        globalSfPanelData.menus = asJsonObject.getAsJsonArray("menus");
        globalSfPanelData.errno = 0;
        globalSfPanelData.errmsg = "SUCCESS";
        globalSfPanelData.setting = asJsonObject.getAsJsonObject("setting");
        bffResponseListener.onSuccess(globalSfPanelData);
    }

    public void requestEmergencyInfo(SfResponseListener<SfEmgInfo> sfResponseListener) {
        if (this.isReleaseEnv) {
            GlobalSfRequest.requestEmergencyInfo(sfResponseListener);
            return;
        }
        SfEmgInfo sfEmgInfo = new SfEmgInfo();
        sfEmgInfo.errno = 0;
        SfEmgInfo.Data data = new SfEmgInfo.Data();
        data.carBrand = "audio";
        data.carLicense = "123455";
        data.moreUrl = "http://www.baidu.com";
        sfEmgInfo.data = data;
        sfResponseListener.onSuccess(sfEmgInfo);
    }

    public void getEmergencyStatus(SfResponseListener<SfEmgStatus> sfResponseListener) {
        if (this.isReleaseEnv) {
            GlobalSfRequest.getEmergencyStatus(sfResponseListener);
            return;
        }
        SfEmgStatus sfEmgStatus = new SfEmgStatus();
        SfEmgStatus.Data data = new SfEmgStatus.Data();
        data.isOnEmergencyCallStatus = 2;
        sfEmgStatus.data = data;
        sfResponseListener.onSuccess(sfEmgStatus);
    }

    public void startEmergency(SfResponseListener<SfBaseObject> sfResponseListener) {
        if (!this.isReleaseEnv) {
            SfBaseObject sfBaseObject = new SfBaseObject();
            sfBaseObject.errno = 0;
            sfResponseListener.onSuccess(sfBaseObject);
            return;
        }
        GlobalSfRequest.startEmergency(sfResponseListener);
    }

    public void stopEmergencyCall(SfResponseListener<SfBaseObject> sfResponseListener) {
        if (!this.isReleaseEnv) {
            SfBaseObject sfBaseObject = new SfBaseObject();
            sfBaseObject.errno = 0;
            sfResponseListener.onSuccess(sfBaseObject);
            return;
        }
        GlobalSfRequest.stopEmergencyCall(sfResponseListener);
    }

    public void reportMonitorState(Context context, int i, int i2, RpcService.Callback<JsonObject> callback) {
        GlobalSfRequest.reportMonitorState(context, i, i2, callback);
    }

    public void reportUserState(Context context, RpcService.Callback<JsonObject> callback, String str) {
        GlobalSfRequest.reportUserState(context, callback, str);
    }

    public void reportMonitorEvent(Context context, int i, RpcService.Callback<JsonObject> callback) {
        GlobalSfRequest.reportMonitorEvent(context, i, callback);
    }

    public void closePanel() {
        if (m20073a(this.f25067h)) {
            ((IGlobalSfViewOwner) this.f25061b.get(this.f25067h).get()).closeSafePanel();
        }
    }

    /* renamed from: a */
    private boolean m20073a(String str) {
        return (this.f25061b.get(str) == null || this.f25061b.get(str).get() == null) ? false : true;
    }

    public void openEmergencyPage(Context context) {
        Nacho.Router().open(context, "/openEmergency");
    }

    public void openRecordAudioPage(Context context) {
        Nacho.Router().open(context, "/safety_record");
    }

    public void openRealTimeMonitorPage(Context context) {
        Nacho.Router().open(context, "/safety_monitor");
    }

    public void startRecord() {
        GlobalTripRecordingManagerNew.Companion.getInstance().startAndPermission(ActivityLifecycleManager.getInstance().getCurrentActivity());
    }

    public void onViewDestory() {
        if (m20073a(this.f25067h)) {
            ((IGlobalSfViewOwner) this.f25061b.get(this.f25067h).get()).onRemove();
        }
    }

    public String getCurPage() {
        return this.f25067h;
    }

    public void showRecoverPoliceDialog(Context context) {
        this.f25066g.showRecoverPoliceDialog(context);
    }

    public void showCancelPoliceDialog(Context context, String str) {
        this.f25066g.showCancelPoliceDialog(context, str);
    }

    public void safeToolKitRecordDurantionUpdate(Map<String, String> map) {
        GlobaSfToFlutter globaSfToFlutter = this.f25069j;
        if (globaSfToFlutter != null) {
            globaSfToFlutter.safeToolKitRecordDurantionUpdate(map);
        }
    }

    public void setFlutterDataHandle(GlobalSfFlutterHandle globalSfFlutterHandle) {
        this.f25068i = globalSfFlutterHandle;
    }

    public GlobalSfFlutterHandle getDataHandle() {
        return this.f25068i;
    }

    public void setFlutterListener(GlobaSfToFlutter globaSfToFlutter) {
        this.f25069j = globaSfToFlutter;
    }

    public GlobaSfToFlutter getFlutterListener() {
        return this.f25069j;
    }

    public IGlobalSfInfoService getmBusinessInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            Iterator<String> it = this.f25070k.keySet().iterator();
            if (it.hasNext()) {
                return this.f25070k.get(it.next());
            }
        }
        return this.f25070k.get(str);
    }

    public void setmBusinessInfo(String str, IGlobalSfInfoService iGlobalSfInfoService) {
        this.f25070k.put(str, iGlobalSfInfoService);
    }

    public boolean isCanRecord() {
        return this.f25064e;
    }

    public void setCanRecord(boolean z) {
        this.f25064e = z;
    }
}
