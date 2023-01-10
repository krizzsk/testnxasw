package com.didi.sdk.sidebar.data;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.component.search.city.p149db.DIDIDbTables;
import com.didi.sdk.events.RedDotStatusChangedEvent;
import com.didi.sdk.events.RedDotStatusEvent;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.misconfig.store.ICityChangeListener;
import com.didi.sdk.monitor.GlobalPaxTechTracker;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.configer.Configer;
import com.didi.sdk.sidebar.configer.DidiPassSp;
import com.didi.sdk.sidebar.configer.SharedPrefercencesHelper;
import com.didi.sdk.sidebar.configer.SideBarConfiger;
import com.didi.sdk.sidebar.model.OriginData;
import com.didi.sdk.sidebar.model.RedPoints;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.model.SidebarPage;
import com.didi.sdk.sidebar.model.SidebarResponse;
import com.didi.sdk.sidebar.setup.mutilocale.LocaleChangeListener;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.AssetsUtil;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DataContainer implements ICityChangeListener, ISetSidebarData, LocaleChangeListener {
    public static final String DATA_HOST_TEST = "https://conf.didiglobal.com";

    /* renamed from: b */
    private static final String f39941b = "/one/usercenter";

    /* renamed from: c */
    private static final DataContainer f39942c = new DataContainer();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f39943a = LoggerFactory.getLogger("DataContainer");

    /* renamed from: d */
    private OriginData f39944d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Context f39945e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f39946f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f39947g;

    /* renamed from: h */
    private boolean f39948h;

    /* renamed from: i */
    private SidebarPage f39949i;

    /* renamed from: j */
    private SidebarPage f39950j;

    /* renamed from: k */
    private LoadConfigThread f39951k;

    @Path("")
    public interface SidebarConfigService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Timeout(connectTimeout = 80000, readTimeout = 8000)
        @Deserialization(StringDeserializer.class)
        Object getSidebarInfo(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.WORKER) RpcService.Callback<String> callback);
    }

    public static DataContainer getInstance() {
        return f39942c;
    }

    private DataContainer() {
        EventBus.getDefault().register(this);
    }

    public void initData(Context context, String str) {
        this.f39945e = context;
        this.f39946f = str;
        LoadConfigThread loadConfigThread = new LoadConfigThread();
        this.f39951k = loadConfigThread;
        loadConfigThread.setPriority(1);
        this.f39951k.setName("loadThreadSidebar");
        SystemUtils.startThread(this.f39951k);
        MultiLocaleStore.getInstance().addLocaleChangeListener(this);
        ConfProxy.getInstance().registerCityChangeListener(this);
        IToggle toggle = Apollo.getToggle("global_theone_usercenter_update");
        if (toggle != null && toggle.allow()) {
            OneLoginFacade.getFunction().addLoginOutListener(new LoginListeners.LoginOutListener() {
                public void onSuccess() {
                    DataContainer dataContainer = DataContainer.this;
                    dataContainer.m30098b(dataContainer.f39945e.getCacheDir(), DataContainer.this.f39946f);
                }
            });
            OneLoginFacade.getFunction().addLoginListener(new LoginListeners.LoginListener() {
                public void onCancel() {
                }

                public void onSuccess(Activity activity, String str) {
                    boolean unused = DataContainer.this.f39947g = true;
                    DataContainer.this.refreshData();
                }
            });
        }
    }

    public void onCityChange(int i, int i2) {
        if (i != i2) {
            this.f39947g = true;
        }
    }

    public void onLocaleChange(String str, String str2) {
        Logger logger = this.f39943a;
        logger.info("onLocaleChange,old = " + str + ",newLocale = " + str2, new Object[0]);
        if (this.f39945e != null) {
            this.f39946f = str2;
            LoadConfigThread loadConfigThread = new LoadConfigThread();
            this.f39951k = loadConfigThread;
            loadConfigThread.setPriority(1);
            this.f39951k.setName("loadThreadSidebar");
        }
    }

    public void refreshData() {
        if (this.f39947g) {
            m30081a(this.f39945e.getCacheDir(), this.f39946f, 0);
        }
    }

    public SidebarPage getSettingData() {
        return ((ISetSidebarData) ServiceLoader.load(ISetSidebarData.class).get()).getSettingData();
    }

    public SidebarPage getAccountData() {
        return ((ISetSidebarData) ServiceLoader.load(ISetSidebarData.class).get()).getAccountData();
    }

    private class LoadConfigThread extends Thread {
        public LoadConfigThread() {
            super("load_sidebar_config");
        }

        public void run() {
            super.run();
            File cacheDir = DataContainer.this.f39945e.getCacheDir();
            String locCountry = NationTypeUtil.getNationComponentData().getLocCountry();
            Logger c = DataContainer.this.f39943a;
            c.info("begin load config,cacheDir = " + cacheDir + ",lang = " + DataContainer.this.f39946f + ",country = " + locCountry, new Object[0]);
            DataContainer dataContainer = DataContainer.this;
            long unused = dataContainer.m30070a(cacheDir, dataContainer.f39946f);
            DataContainer dataContainer2 = DataContainer.this;
            dataContainer2.m30081a(cacheDir, dataContainer2.f39946f, 0);
        }
    }

    /* renamed from: a */
    private boolean m30091a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f39943a.info("loadFinish,json is empty", new Object[0]);
            return false;
        }
        Gson gson = new Gson();
        SidebarPage a = m30072a("level0", "root", (OriginData) gson.fromJson(str, OriginData.class));
        if (a != null) {
            OriginData originData = (OriginData) gson.fromJson(str, OriginData.class);
            this.f39944d = originData;
            m30085a(originData.getRedPoints(), true);
            m30100b(this.f39944d.getFireTorchs(), true);
            m30101b(m30092a(false));
            EventBus.getDefault().post(a);
            Logger logger = this.f39943a;
            logger.info("loadFinish,notify pageData = " + a, new Object[0]);
            return true;
        }
        this.f39943a.error("loadFinish,pageData is null", new Object[0]);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m30090a(OriginData originData, boolean z) {
        if (originData == null) {
            return false;
        }
        SidebarPage a = m30072a("level0", "root", originData);
        if (a == null || a.getGroupList() == null || a.getGroupList().size() <= 0 || a.getGroupList().get(0) == null) {
            this.f39943a.error("loadFinish,pageData is null", new Object[0]);
            return false;
        }
        this.f39944d = originData;
        m30085a(originData.getRedPoints(), z);
        m30100b(originData.getFireTorchs(), z);
        m30101b(m30092a(false));
        EventBus.getDefault().post(a);
        Logger logger = this.f39943a;
        logger.info("loadFinish,notify pageData = " + a, new Object[0]);
        return true;
    }

    public void refreshCache(SidebarItem sidebarItem) {
        SidebarPage sidebarPage;
        List<List<SidebarItem>> groupList;
        boolean z;
        String b = m30095b(this.f39946f);
        File cacheDir = this.f39945e.getCacheDir();
        if (!TextUtils.isEmpty(b)) {
            File file = new File(cacheDir, b);
            if (file.exists()) {
                Logger logger = this.f39943a;
                logger.info("loadFromCache,file = " + file.getAbsolutePath() + ",exist = " + file.exists(), new Object[0]);
                try {
                    String a = mo102478a(file);
                    Gson gson = new Gson();
                    SidebarResponse sidebarResponse = (SidebarResponse) gson.fromJson(a, SidebarResponse.class);
                    OriginData[] data = sidebarResponse.getData();
                    if (this.f39944d != null && data.length != 0) {
                        Map map = data[0].getLevels().get("level0");
                        if (map != null && (sidebarPage = (SidebarPage) map.get("root")) != null && (groupList = sidebarPage.getGroupList()) != null) {
                            for (List<SidebarItem> it : groupList) {
                                Iterator it2 = it.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        continue;
                                        break;
                                    }
                                    SidebarItem sidebarItem2 = (SidebarItem) it2.next();
                                    if (sidebarItem2.getId() == sidebarItem.getId()) {
                                        sidebarItem2.setRedTag("");
                                        z = true;
                                        continue;
                                        break;
                                    }
                                }
                                if (z) {
                                    break;
                                }
                            }
                        }
                        String json = gson.toJson((Object) sidebarResponse);
                        LogcatUtil.m39237d("DataContainer", json);
                        File file2 = new File(cacheDir, m30095b(this.f39946f));
                        Logger logger2 = this.f39943a;
                        logger2.info("loadFromServer.. write local finish, file = " + file2.getAbsolutePath(), new Object[0]);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        FileWriter fileWriter = new FileWriter(file2);
                        fileWriter.write(json, 0, json.length());
                        fileWriter.flush();
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0088  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m30070a(java.io.File r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = r6.m30095b((java.lang.String) r8)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x0085
            java.io.File r1 = new java.io.File
            r1.<init>(r7, r0)
            boolean r7 = r1.exists()
            if (r7 == 0) goto L_0x0085
            com.didi.sdk.logging.Logger r7 = r6.f39943a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "loadFromCache,file = "
            r0.append(r5)
            java.lang.String r5 = r1.getAbsolutePath()
            r0.append(r5)
            java.lang.String r5 = ",exist = "
            r0.append(r5)
            boolean r5 = r1.exists()
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r7.info((java.lang.String) r0, (java.lang.Object[]) r5)
            java.lang.String r7 = r6.mo102478a((java.io.File) r1)     // Catch:{ JsonSyntaxException -> 0x006c, IOException -> 0x0067 }
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x006c, IOException -> 0x0067 }
            r0.<init>()     // Catch:{ JsonSyntaxException -> 0x006c, IOException -> 0x0067 }
            java.lang.Class<com.didi.sdk.sidebar.model.SidebarResponse> r1 = com.didi.sdk.sidebar.model.SidebarResponse.class
            java.lang.Object r7 = r0.fromJson((java.lang.String) r7, r1)     // Catch:{ JsonSyntaxException -> 0x006c, IOException -> 0x0067 }
            com.didi.sdk.sidebar.model.SidebarResponse r7 = (com.didi.sdk.sidebar.model.SidebarResponse) r7     // Catch:{ JsonSyntaxException -> 0x006c, IOException -> 0x0067 }
            r0 = 1
            if (r7 == 0) goto L_0x0085
            long r3 = r7.getVersion()     // Catch:{ JsonSyntaxException -> 0x006c, IOException -> 0x0067 }
            com.didi.sdk.sidebar.model.OriginData[] r7 = r7.getData()     // Catch:{ JsonSyntaxException -> 0x006c, IOException -> 0x0067 }
            if (r7 == 0) goto L_0x0085
            int r1 = r7.length     // Catch:{ JsonSyntaxException -> 0x006c, IOException -> 0x0067 }
            if (r1 <= 0) goto L_0x0085
            r7 = r7[r2]     // Catch:{ JsonSyntaxException -> 0x006c, IOException -> 0x0067 }
            r6.m30090a((com.didi.sdk.sidebar.model.OriginData) r7, (boolean) r0)     // Catch:{ JsonSyntaxException -> 0x006c, IOException -> 0x0067 }
            goto L_0x0086
        L_0x0067:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x0085
        L_0x006c:
            r7 = move-exception
            r7.printStackTrace()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            java.lang.String r1 = "source"
            r7.put(r1, r0)
            java.lang.String r0 = "tech_gpfile_cache_read"
            com.didi.sdk.util.GlobalOmegaUtils.trackEvent(r0, r7)
        L_0x0085:
            r0 = 0
        L_0x0086:
            if (r0 != 0) goto L_0x00af
            java.lang.String r7 = r6.m30103c((java.lang.String) r8)
            android.app.Application r8 = com.didi.sdk.app.DIDIApplication.getAppContext()
            java.lang.String r8 = com.didi.sdk.util.AssetsUtil.getAssetsFile(r8, r7)
            com.didi.sdk.logging.Logger r0 = r6.f39943a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "load asset file finish,assetFile = "
            r1.append(r5)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r0.info((java.lang.String) r7, (java.lang.Object[]) r1)
            r6.m30091a((java.lang.String) r8)
        L_0x00af:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.sidebar.data.DataContainer.m30070a(java.io.File, java.lang.String):long");
    }

    /* renamed from: a */
    private String m30073a() {
        boolean isTestNow = AppUtils.isTestNow(this.f39945e);
        return "https://conf.didiglobal.com/one/usercenter";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30081a(File file, String str, long j) {
        String locCountry = NationTypeUtil.getNationComponentData().getLocCountry();
        if (TextUtils.isEmpty(locCountry)) {
            this.f39947g = true;
        } else {
            this.f39947g = false;
        }
        Logger logger = this.f39943a;
        logger.info("loadFromServer.. version = " + j + ",lang = " + j + ",country = " + locCountry, new Object[0]);
        m30086a((Map) new HashMap(), locCountry, file, str, String.valueOf(j));
    }

    /* renamed from: a */
    private void m30086a(Map map, final String str, final File file, final String str2, String str3) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", str3);
        hashMap.put("is_new_ride", 1);
        hashMap.put("is_sa", Integer.valueOf(SaApolloUtil.INSTANCE.getSaState() ? 1 : 0));
        hashMap.put("is_new_japan", 1);
        map.put("passenger_Sidebar", hashMap);
        Bff.call(new IBffProxy.Ability.Builder(this.f39945e, "expo/passenger").setParams(map).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                try {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.add("errno", jsonObject.get("errno"));
                    if (jsonObject.has("data")) {
                        JsonObject asJsonObject = jsonObject.get("data").getAsJsonObject();
                        if (asJsonObject.has("passenger_Sidebar")) {
                            JsonObject asJsonObject2 = asJsonObject.get("passenger_Sidebar").getAsJsonObject();
                            new SharedPrefercencesHelper(DataContainer.this.f39945e, "passenger_Sidebar").put((Configer) SideBarConfiger.Passenger_Sidebar, TextUtils.isEmpty(asJsonObject2.toString()) ? "" : asJsonObject2.toString());
                            DataContainer.this.m30097b(asJsonObject2);
                            DataContainer.this.m30080a(asJsonObject2);
                            jsonObject2.add("passenger_Sidebar", asJsonObject2);
                            if (asJsonObject2.has("userCenterData") && asJsonObject2.get("userCenterData") != null) {
                                JsonObject asJsonObject3 = asJsonObject2.get("userCenterData").getAsJsonObject();
                                if (asJsonObject3.has("lang")) {
                                    jsonObject2.add("lang", asJsonObject3.get("lang"));
                                }
                                if (asJsonObject3.has("key")) {
                                    jsonObject2.add("key", asJsonObject3.get("key"));
                                }
                                if (asJsonObject3.has("data")) {
                                    jsonObject2.add("data", asJsonObject3.get("data"));
                                }
                                if (asJsonObject3.has("version")) {
                                    jsonObject2.add("version", asJsonObject3.get("version"));
                                }
                            }
                        }
                    }
                    DataContainer.this.m30082a(new Gson().toJson((JsonElement) jsonObject2), str, file, str2);
                } catch (Exception e) {
                    GlobalPaxTechTracker.getInstance().trackSideBar(3, e.getMessage());
                }
            }

            public void onFailure(IOException iOException) {
                Logger c = DataContainer.this.f39943a;
                c.info("loadFromServer onFailure,e = " + iOException.getMessage(), new Object[0]);
                GlobalPaxTechTracker.getInstance().trackSideBar(1, iOException.getMessage());
            }
        }).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30080a(JsonObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        if (jsonObject.has("getProfile")) {
            JsonElement jsonElement = jsonObject.get("getProfile");
            if (jsonElement != null) {
                try {
                    if (!jsonElement.isJsonNull()) {
                        JsonObject asJsonObject = jsonElement.getAsJsonObject();
                        String str = null;
                        if (asJsonObject != null && !asJsonObject.isJsonNull()) {
                            str = new Gson().toJson((JsonElement) asJsonObject);
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        DidiPassSp.getIns(this.f39945e).put((Configer) SideBarConfiger.DIDI_PASS_DATA, str);
                        return;
                    }
                } catch (Exception e) {
                    DidiPassSp.getIns(this.f39945e).put((Configer) SideBarConfiger.DIDI_PASS_DATA, "");
                    e.printStackTrace();
                    return;
                }
            }
            DidiPassSp.getIns(this.f39945e).put((Configer) SideBarConfiger.DIDI_PASS_DATA, "");
            return;
        }
        DidiPassSp.getIns(this.f39945e).put((Configer) SideBarConfiger.DIDI_PASS_DATA, "");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0086, code lost:
        r11 = r7;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m30097b(com.google.gson.JsonObject r11) {
        /*
            r10 = this;
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.lang.String r11 = r0.toJson((com.google.gson.JsonElement) r11)
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.lang.Class<com.didi.sdk.sidebar.model.SidebarResponse$PassengerSidebar> r1 = com.didi.sdk.sidebar.model.SidebarResponse.PassengerSidebar.class
            java.lang.Object r11 = r0.fromJson((java.lang.String) r11, r1)
            com.didi.sdk.sidebar.model.SidebarResponse$PassengerSidebar r11 = (com.didi.sdk.sidebar.model.SidebarResponse.PassengerSidebar) r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "customerData"
            r0.add(r1)
            java.lang.String r2 = "didiPassData"
            r0.add(r2)
            java.lang.String r3 = "imData"
            r0.add(r3)
            java.lang.String r4 = "emotionalData"
            r0.add(r4)
            java.util.List<java.lang.String> r5 = r11.priorityData
            if (r5 != 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            java.util.List<java.lang.String> r0 = r11.priorityData
        L_0x0036:
            r5 = 0
            java.util.Iterator r0 = r0.iterator()
        L_0x003b:
            boolean r6 = r0.hasNext()
            java.lang.String r7 = ""
            if (r6 == 0) goto L_0x0096
            java.lang.Object r6 = r0.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r8 = android.text.TextUtils.equals(r6, r4)
            if (r8 == 0) goto L_0x0062
            com.didi.sdk.sidebar.model.SidebarResponse$EmotionalData r6 = r11.emotionalData
            if (r6 == 0) goto L_0x003b
            com.didi.sdk.sidebar.model.SidebarResponse$EmotionalData r6 = r11.emotionalData
            java.lang.String r6 = r6.text
            if (r6 == 0) goto L_0x003b
            com.didi.sdk.sidebar.model.SidebarResponse$EmotionalData r11 = r11.emotionalData
            java.lang.String r11 = r11.text
            r1 = r4
            r9 = r7
            r7 = r11
            r11 = r9
            goto L_0x0098
        L_0x0062:
            boolean r8 = android.text.TextUtils.equals(r6, r1)
            if (r8 == 0) goto L_0x007b
            com.didi.sdk.sidebar.model.SidebarResponse$CustomerData r6 = r11.customerData
            if (r6 == 0) goto L_0x003b
            com.didi.sdk.sidebar.model.SidebarResponse$CustomerData r6 = r11.customerData
            java.lang.String r6 = r6.text
            if (r6 == 0) goto L_0x003b
            com.didi.sdk.sidebar.model.SidebarResponse$CustomerData r0 = r11.customerData
            java.lang.String r7 = r0.text
            com.didi.sdk.sidebar.model.SidebarResponse$CustomerData r11 = r11.customerData
            java.lang.String r11 = r11.number
            goto L_0x0098
        L_0x007b:
            boolean r8 = android.text.TextUtils.equals(r6, r3)
            if (r8 == 0) goto L_0x0088
            boolean r8 = r10.f39948h
            if (r8 == 0) goto L_0x0088
            r1 = r3
        L_0x0086:
            r11 = r7
            goto L_0x0098
        L_0x0088:
            boolean r6 = android.text.TextUtils.equals(r6, r2)
            if (r6 == 0) goto L_0x003b
            com.didi.sdk.sidebar.model.SidebarResponse$DidiPassData r6 = r11.didiPassData
            if (r6 == 0) goto L_0x003b
            com.didi.sdk.sidebar.model.SidebarResponse$DidiPassData r5 = r11.didiPassData
            r1 = r2
            goto L_0x0086
        L_0x0096:
            r11 = r7
            r1 = r11
        L_0x0098:
            org.greenrobot.eventbus.EventBus r0 = org.greenrobot.eventbus.EventBus.getDefault()
            com.didi.sdk.events.RemotionalMessageEvent r2 = new com.didi.sdk.events.RemotionalMessageEvent
            r2.<init>(r7, r11, r1, r5)
            r0.post(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.sidebar.data.DataContainer.m30097b(com.google.gson.JsonObject):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30082a(String str, String str2, File file, String str3) {
        final String str4 = str;
        final String str5 = str2;
        final File file2 = file;
        final String str6 = str3;
        Executors.newCachedThreadPool().execute(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0153 A[SYNTHETIC, Splitter:B:41:0x0153] */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x019b A[SYNTHETIC, Splitter:B:51:0x019b] */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x01b5 A[SYNTHETIC, Splitter:B:59:0x01b5] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x01c5  */
            /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:48:0x0165=Splitter:B:48:0x0165, B:38:0x011d=Splitter:B:38:0x011d} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r11 = this;
                    java.lang.String r0 = ",value = "
                    java.lang.String r1 = ""
                    r2 = 3
                    r3 = 1
                    r4 = 0
                    r5 = 0
                    com.google.gson.Gson r6 = new com.google.gson.Gson     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r6.<init>()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r7 = r3     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.Class<com.didi.sdk.sidebar.model.SidebarResponse> r8 = com.didi.sdk.sidebar.model.SidebarResponse.class
                    java.lang.Object r6 = r6.fromJson((java.lang.String) r7, r8)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    com.didi.sdk.sidebar.model.SidebarResponse r6 = (com.didi.sdk.sidebar.model.SidebarResponse) r6     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    int r7 = r6.getErrno()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    com.didi.sdk.sidebar.data.DataContainer r8 = com.didi.sdk.sidebar.data.DataContainer.this     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    com.didi.sdk.logging.Logger r8 = r8.f39943a     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r9.<init>()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r10 = "loadFromServer.. error = "
                    r9.append(r10)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r9.append(r7)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.Object[] r10 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r8.info((java.lang.String) r9, (java.lang.Object[]) r10)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    com.didi.sdk.sidebar.model.OriginData[] r6 = r6.getData()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    if (r7 != 0) goto L_0x00d5
                    if (r6 == 0) goto L_0x00d5
                    int r8 = r6.length     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    if (r8 <= 0) goto L_0x00d5
                    com.didi.sdk.sidebar.data.DataContainer r7 = com.didi.sdk.sidebar.data.DataContainer.this     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r6 = r6[r4]     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    boolean r6 = r7.m30090a((com.didi.sdk.sidebar.model.OriginData) r6, (boolean) r4)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    if (r6 == 0) goto L_0x00cc
                    java.lang.String r6 = r4     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    if (r6 != 0) goto L_0x00ad
                    java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.io.File r7 = r5     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    com.didi.sdk.sidebar.data.DataContainer r8 = com.didi.sdk.sidebar.data.DataContainer.this     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r9 = r6     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r8 = r8.m30095b((java.lang.String) r9)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r6.<init>(r7, r8)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    com.didi.sdk.sidebar.data.DataContainer r7 = com.didi.sdk.sidebar.data.DataContainer.this     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    com.didi.sdk.logging.Logger r7 = r7.f39943a     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r8.<init>()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r9 = "loadFromServer.. write local finish, file = "
                    r8.append(r9)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r9 = r6.getAbsolutePath()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r8.append(r9)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r7.info((java.lang.String) r8, (java.lang.Object[]) r9)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    boolean r7 = r6.exists()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    if (r7 != 0) goto L_0x008c
                    r6.createNewFile()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                L_0x008c:
                    java.io.FileWriter r7 = new java.io.FileWriter     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r7.<init>(r6)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r5 = r3     // Catch:{ IOException -> 0x00a9, Exception -> 0x00a5, all -> 0x00a1 }
                    java.lang.String r6 = r3     // Catch:{ IOException -> 0x00a9, Exception -> 0x00a5, all -> 0x00a1 }
                    int r6 = r6.length()     // Catch:{ IOException -> 0x00a9, Exception -> 0x00a5, all -> 0x00a1 }
                    r7.write(r5, r4, r6)     // Catch:{ IOException -> 0x00a9, Exception -> 0x00a5, all -> 0x00a1 }
                    r7.flush()     // Catch:{ IOException -> 0x00a9, Exception -> 0x00a5, all -> 0x00a1 }
                    r5 = r7
                    goto L_0x00fe
                L_0x00a1:
                    r0 = move-exception
                    r5 = r7
                    goto L_0x01b3
                L_0x00a5:
                    r6 = move-exception
                    r5 = r7
                    goto L_0x011d
                L_0x00a9:
                    r6 = move-exception
                    r5 = r7
                    goto L_0x0165
                L_0x00ad:
                    com.didi.sdk.sidebar.data.DataContainer r6 = com.didi.sdk.sidebar.data.DataContainer.this     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    com.didi.sdk.logging.Logger r6 = r6.f39943a     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r7.<init>()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r8 = "loadFromServer.. write local finish, get country = "
                    r7.append(r8)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r8 = r4     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r7.append(r8)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r6.info((java.lang.String) r7, (java.lang.Object[]) r8)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    goto L_0x00fe
                L_0x00cc:
                    com.didi.sdk.sidebar.data.DataContainer r6 = com.didi.sdk.sidebar.data.DataContainer.this     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    boolean unused = r6.f39947g = r3     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r0 = "load fail"
                    r1 = r0
                    goto L_0x00fe
                L_0x00d5:
                    com.didi.sdk.sidebar.data.DataContainer r8 = com.didi.sdk.sidebar.data.DataContainer.this     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    boolean unused = r8.f39947g = r3     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    com.didi.sdk.sidebar.data.DataContainer r8 = com.didi.sdk.sidebar.data.DataContainer.this     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    com.didi.sdk.logging.Logger r8 = r8.f39943a     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r9.<init>()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r10 = "loadFromServer,failed, error = "
                    r9.append(r10)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r9.append(r7)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r7 = ",data = "
                    r9.append(r7)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r9.append(r6)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.String r6 = r9.toString()     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                    r8.info((java.lang.String) r6, (java.lang.Object[]) r7)     // Catch:{ IOException -> 0x0164, Exception -> 0x011c }
                L_0x00fe:
                    if (r5 == 0) goto L_0x0108
                    r5.close()     // Catch:{ IOException -> 0x0104 }
                    goto L_0x0108
                L_0x0104:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x0108:
                    com.didi.sdk.sidebar.data.DataContainer r0 = com.didi.sdk.sidebar.data.DataContainer.this
                    boolean r0 = r0.f39947g
                    if (r0 == 0) goto L_0x01b2
                    com.didi.sdk.monitor.GlobalPaxTechTracker r0 = com.didi.sdk.monitor.GlobalPaxTechTracker.getInstance()
                    r0.trackSideBar(r2, r1)
                    goto L_0x01b2
                L_0x0119:
                    r0 = move-exception
                    goto L_0x01b3
                L_0x011c:
                    r6 = move-exception
                L_0x011d:
                    com.didi.sdk.sidebar.data.DataContainer r7 = com.didi.sdk.sidebar.data.DataContainer.this     // Catch:{ all -> 0x0119 }
                    boolean unused = r7.f39947g = r3     // Catch:{ all -> 0x0119 }
                    com.didi.sdk.sidebar.data.DataContainer r3 = com.didi.sdk.sidebar.data.DataContainer.this     // Catch:{ all -> 0x0119 }
                    com.didi.sdk.logging.Logger r3 = r3.f39943a     // Catch:{ all -> 0x0119 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0119 }
                    r7.<init>()     // Catch:{ all -> 0x0119 }
                    java.lang.String r8 = "loadFromServer Exception,e = "
                    r7.append(r8)     // Catch:{ all -> 0x0119 }
                    java.lang.String r8 = r6.getMessage()     // Catch:{ all -> 0x0119 }
                    r7.append(r8)     // Catch:{ all -> 0x0119 }
                    r7.append(r0)     // Catch:{ all -> 0x0119 }
                    java.lang.String r0 = r3     // Catch:{ all -> 0x0119 }
                    r7.append(r0)     // Catch:{ all -> 0x0119 }
                    java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0119 }
                    java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0119 }
                    r3.info((java.lang.String) r0, (java.lang.Object[]) r4)     // Catch:{ all -> 0x0119 }
                    r6.printStackTrace()     // Catch:{ all -> 0x0119 }
                    java.lang.String r0 = r6.getMessage()     // Catch:{ all -> 0x0119 }
                    if (r5 == 0) goto L_0x015b
                    r5.close()     // Catch:{ IOException -> 0x0157 }
                    goto L_0x015b
                L_0x0157:
                    r1 = move-exception
                    r1.printStackTrace()
                L_0x015b:
                    com.didi.sdk.sidebar.data.DataContainer r1 = com.didi.sdk.sidebar.data.DataContainer.this
                    boolean r1 = r1.f39947g
                    if (r1 == 0) goto L_0x01b2
                    goto L_0x01ab
                L_0x0164:
                    r6 = move-exception
                L_0x0165:
                    com.didi.sdk.sidebar.data.DataContainer r7 = com.didi.sdk.sidebar.data.DataContainer.this     // Catch:{ all -> 0x0119 }
                    boolean unused = r7.f39947g = r3     // Catch:{ all -> 0x0119 }
                    com.didi.sdk.sidebar.data.DataContainer r3 = com.didi.sdk.sidebar.data.DataContainer.this     // Catch:{ all -> 0x0119 }
                    com.didi.sdk.logging.Logger r3 = r3.f39943a     // Catch:{ all -> 0x0119 }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0119 }
                    r7.<init>()     // Catch:{ all -> 0x0119 }
                    java.lang.String r8 = "loadFromServer IOException,e = "
                    r7.append(r8)     // Catch:{ all -> 0x0119 }
                    java.lang.String r8 = r6.getMessage()     // Catch:{ all -> 0x0119 }
                    r7.append(r8)     // Catch:{ all -> 0x0119 }
                    r7.append(r0)     // Catch:{ all -> 0x0119 }
                    java.lang.String r0 = r3     // Catch:{ all -> 0x0119 }
                    r7.append(r0)     // Catch:{ all -> 0x0119 }
                    java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0119 }
                    java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0119 }
                    r3.info((java.lang.String) r0, (java.lang.Object[]) r4)     // Catch:{ all -> 0x0119 }
                    r6.printStackTrace()     // Catch:{ all -> 0x0119 }
                    java.lang.String r0 = r6.getMessage()     // Catch:{ all -> 0x0119 }
                    if (r5 == 0) goto L_0x01a3
                    r5.close()     // Catch:{ IOException -> 0x019f }
                    goto L_0x01a3
                L_0x019f:
                    r1 = move-exception
                    r1.printStackTrace()
                L_0x01a3:
                    com.didi.sdk.sidebar.data.DataContainer r1 = com.didi.sdk.sidebar.data.DataContainer.this
                    boolean r1 = r1.f39947g
                    if (r1 == 0) goto L_0x01b2
                L_0x01ab:
                    com.didi.sdk.monitor.GlobalPaxTechTracker r1 = com.didi.sdk.monitor.GlobalPaxTechTracker.getInstance()
                    r1.trackSideBar(r2, r0)
                L_0x01b2:
                    return
                L_0x01b3:
                    if (r5 == 0) goto L_0x01bd
                    r5.close()     // Catch:{ IOException -> 0x01b9 }
                    goto L_0x01bd
                L_0x01b9:
                    r3 = move-exception
                    r3.printStackTrace()
                L_0x01bd:
                    com.didi.sdk.sidebar.data.DataContainer r3 = com.didi.sdk.sidebar.data.DataContainer.this
                    boolean r3 = r3.f39947g
                    if (r3 == 0) goto L_0x01cc
                    com.didi.sdk.monitor.GlobalPaxTechTracker r3 = com.didi.sdk.monitor.GlobalPaxTechTracker.getInstance()
                    r3.trackSideBar(r2, r1)
                L_0x01cc:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.sidebar.data.DataContainer.C138804.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m30095b(String str) {
        return m30075a(NationTypeUtil.getNationComponentData().getLocCountry(), str);
    }

    /* renamed from: a */
    private String m30075a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + "_" + str2 + "_sidebar_config.txt";
    }

    /* renamed from: c */
    private String m30103c(String str) {
        if (AppUtils.isGlobalApp(DIDIApplication.getAppContext())) {
            return "Default_" + str + "_sidebar_config.txt";
        } else if (str.equalsIgnoreCase("en-US")) {
            return "Default_en-BR_sidebar_config.txt";
        } else {
            return "Default_" + str + "_sidebar_config.txt";
        }
    }

    /* renamed from: a */
    private void m30085a(List<RedPoints> list, boolean z) {
        m30084a(list, DIDIDbTables.SideBarReddotColumn.CONTENT_URI, z);
        m30083a(list);
    }

    /* renamed from: b */
    private void m30100b(List<RedPoints> list, boolean z) {
        m30084a(list, DIDIDbTables.SideBarFireTorchColumn.CONTENT_URI, z);
        m30099b(list);
    }

    /* renamed from: a */
    private void m30084a(List<RedPoints> list, Uri uri, boolean z) {
        RedPoints redPoints;
        HashMap<String, RedPoints> queryAll = SideBarDbUtil.queryAll(DIDIApplication.getAppContext(), uri);
        if (!(queryAll == null || list == null)) {
            for (RedPoints next : list) {
                if (!(next == null || (redPoints = queryAll.get(String.valueOf(next.getId()))) == null)) {
                    next.setIsCLicked(redPoints.getIsCLicked());
                }
            }
        }
        if ((list != null && list.size() != 0) || !z) {
            SideBarDbUtil.delete(DIDIApplication.getAppContext(), (String) null, (String[]) null, uri);
            SideBarDbUtil.bulkInsert(DIDIApplication.getAppContext(), list, uri);
        }
    }

    /* renamed from: a */
    private void m30083a(List<RedPoints> list) {
        List<List<SidebarItem>> groupList;
        if (list != null) {
            for (RedPoints next : list) {
                if (next != null) {
                    long componentId = next.getComponentId();
                    SidebarPage pageData = getPageData(next.getLevel(), next.getPage());
                    if (!(pageData == null || (groupList = pageData.getGroupList()) == null)) {
                        for (List<SidebarItem> next2 : groupList) {
                            if (next2 != null) {
                                for (SidebarItem sidebarItem : next2) {
                                    if (sidebarItem != null && ((long) sidebarItem.getId()) == componentId && next.getIsCLicked() == 0 && m30087a(next.getStartTime(), next.getEndTime())) {
                                        sidebarItem.setRedPoints(next);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m30087a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis >= j && currentTimeMillis <= j2;
    }

    /* renamed from: b */
    private void m30099b(List<RedPoints> list) {
        List<List<SidebarItem>> groupList;
        if (list != null) {
            for (RedPoints next : list) {
                if (next != null) {
                    long componentId = next.getComponentId();
                    SidebarPage pageData = getPageData(next.getLevel(), next.getPage());
                    if (!(pageData == null || (groupList = pageData.getGroupList()) == null)) {
                        for (List<SidebarItem> next2 : groupList) {
                            if (next2 != null) {
                                for (SidebarItem sidebarItem : next2) {
                                    if (sidebarItem != null && ((long) sidebarItem.getId()) == componentId && next.getIsCLicked() == 0 && m30087a(next.getStartTime(), next.getEndTime())) {
                                        sidebarItem.setFireTorch(next);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private SidebarPage m30072a(String str, String str2, OriginData originData) {
        Map map;
        if (originData == null || (map = originData.getLevels().get(str)) == null) {
            return null;
        }
        return (SidebarPage) map.get(str2);
    }

    public SidebarPage getPageData(String str, String str2) {
        return m30072a(str, str2, this.f39944d);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(RedDotStatusChangedEvent redDotStatusChangedEvent) {
        m30101b(m30092a(redDotStatusChangedEvent.isShow));
        this.f39948h = redDotStatusChangedEvent.isShow;
        SharedPrefercencesHelper sharedPrefercencesHelper = new SharedPrefercencesHelper(this.f39945e, "passenger_Sidebar");
        String string = sharedPrefercencesHelper.getString(SideBarConfiger.Passenger_Sidebar);
        if (!TextUtils.isEmpty(string)) {
            m30097b(new Gson().toJsonTree(string).getAsJsonObject());
            sharedPrefercencesHelper.put((Configer) SideBarConfiger.Passenger_Sidebar, "");
        }
    }

    /* renamed from: a */
    private boolean m30092a(boolean z) {
        if (z) {
            return true;
        }
        OriginData originData = this.f39944d;
        if (!(originData == null || originData.getRedPoints() == null)) {
            for (RedPoints next : this.f39944d.getRedPoints()) {
                if (next.getIsCLicked() == 0 && m30087a(next.getStartTime(), next.getEndTime())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m30101b(boolean z) {
        EventBus.getDefault().post(new RedDotStatusEvent(z));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo102478a(java.io.File r5) throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x001f, all -> 0x001d }
            r1.<init>(r5)     // Catch:{ IOException -> 0x001f, all -> 0x001d }
            int r5 = r1.available()     // Catch:{ IOException -> 0x001b }
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x001b }
            r1.read(r5)     // Catch:{ IOException -> 0x001b }
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x001b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r5, r3)     // Catch:{ IOException -> 0x001b }
            r1.close()
            r0 = r2
            goto L_0x0029
        L_0x001b:
            r5 = move-exception
            goto L_0x0021
        L_0x001d:
            r5 = move-exception
            goto L_0x002c
        L_0x001f:
            r5 = move-exception
            r1 = r0
        L_0x0021:
            r5.printStackTrace()     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0029
            r1.close()
        L_0x0029:
            return r0
        L_0x002a:
            r5 = move-exception
            r0 = r1
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()
        L_0x0031:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.sidebar.data.DataContainer.mo102478a(java.io.File):java.lang.String");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m30098b(File file, String str) {
        try {
            File file2 = new File(file, m30095b(str));
            if (file2.exists()) {
                file2.delete();
            }
        } catch (Exception e) {
            this.f39943a.info(e.getMessage(), new Object[0]);
        }
        String c = m30103c(this.f39946f);
        String assetsFile = AssetsUtil.getAssetsFile(DIDIApplication.getAppContext(), c);
        Logger logger = this.f39943a;
        logger.info("load asset file finish,assetFile = " + c, new Object[0]);
        m30091a(assetsFile);
    }

    public SidebarPage getmAccountModel() {
        return this.f39949i;
    }

    public void setmAccountModel(SidebarPage sidebarPage) {
        this.f39949i = sidebarPage;
    }

    public SidebarPage getmSettingModel() {
        return this.f39950j;
    }

    public void setmSettingModel(SidebarPage sidebarPage) {
        this.f39950j = sidebarPage;
    }
}
