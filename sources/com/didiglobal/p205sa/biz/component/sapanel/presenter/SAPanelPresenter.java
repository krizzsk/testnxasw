package com.didiglobal.p205sa.biz.component.sapanel.presenter;

import android.os.Bundle;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenter;
import com.didi.component.never.core.IViewContainer;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.component.never.core.sender.NullData;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.util.NewUISwitchUtils;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.xengine.register.XERegister;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didi.xengine.request.XECacheParamsImpl;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.sdk.alphaface.utils.UIHandler;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.data.parser.util.XEParserUtil;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.activity.omega.ActivityOmegaTracker;
import com.didiglobal.p205sa.biz.component.ridecard.model.RideCardModel;
import com.didiglobal.p205sa.biz.component.sapanel.model.PageTouchEventManger;
import com.didiglobal.p205sa.biz.component.sapanel.model.SABizCardProperty;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import com.didiglobal.p205sa.biz.component.sapanel.view.SAPanelView;
import com.didiglobal.p205sa.biz.component.sapanel.view.XPCardView;
import com.didiglobal.p205sa.biz.component.xengine.CachedPageData;
import com.didiglobal.p205sa.biz.component.xengine.SAXEngineLoggerUtils;
import com.didiglobal.p205sa.biz.component.xengine.SAXEngineReqUtil;
import com.didiglobal.p205sa.biz.sender.IAddressData;
import com.didiglobal.p205sa.biz.sender.IHomepData;
import com.didiglobal.p205sa.biz.util.BaseEventKeys;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.presenter.SAPanelPresenter */
public class SAPanelPresenter extends AbsPanelPresenter implements IViewContainer {

    /* renamed from: a */
    RideCardModel f53653a;

    /* renamed from: b */
    Address f53654b;

    /* renamed from: c */
    private HashMap<String, LinkedTreeMap<String, Object>> f53655c = new HashMap<>();

    /* renamed from: d */
    private long f53656d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<SACardProperty> f53657e;

    /* renamed from: f */
    private boolean f53658f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f53659g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f53660h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f53661i = true;

    /* renamed from: j */
    private XEResponseCallback f53662j = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData != null) {
                SAPanelPresenter.this.m40039a(list, xEngineData.isCache, XEParserUtil.isUpdateChildMode(xEngineData.jsonObject));
            }
            SAXEngineLoggerUtils.INSTANCE.info(" sapanel onSuccess");
            if (list == null || list.size() == 0) {
                SAXEngineLoggerUtils.INSTANCE.info("list null");
                return;
            }
            SAXEngineLoggerUtils sAXEngineLoggerUtils = SAXEngineLoggerUtils.INSTANCE;
            sAXEngineLoggerUtils.info(" list.size: " + list.size());
            SAXEngineLoggerUtils sAXEngineLoggerUtils2 = SAXEngineLoggerUtils.INSTANCE;
            sAXEngineLoggerUtils2.info(" XEngineData: " + xEngineData);
            JsonObject jsonObject = null;
            if (xEngineData != null) {
                jsonObject = xEngineData.jsonObject;
            }
            if (jsonObject != null) {
                SAPanelPresenter.this.m40035a(jsonObject.getAsJsonArray("list"));
            }
            if (xEngineData != null && !xEngineData.isCache && SAPanelPresenter.this.f53661i && SAPanelPresenter.this.f53660h > 0) {
                boolean unused = SAPanelPresenter.this.f53661i = false;
                ActivityOmegaTracker.OmegaSATime(System.currentTimeMillis() - SAPanelPresenter.this.f53660h);
            }
            if (xEngineData != null && xEngineData.isCache) {
                SAPanelPresenter.this.m40029a(xEngineData, list);
            } else if (XEParserUtil.isUpdateChildMode(jsonObject)) {
                SystemUtils.log(6, "tagtagtag", "SAPanelPresenter doUpdate()" + list.size() + " list= " + list.toString(), (Throwable) null, "com.didiglobal.sa.biz.component.sapanel.presenter.SAPanelPresenter$1", 128);
                SAPanelPresenter.this.m40038a(list);
            } else {
                SAPanelPresenter.this.m40029a(xEngineData, list);
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            SAXEngineLoggerUtils.INSTANCE.info(" sapanel onFailed");
            SystemUtils.log(6, "tagtagtag", "SAPanelPresenter onFailed ", (Throwable) null, "com.didiglobal.sa.biz.component.sapanel.presenter.SAPanelPresenter$1", 139);
            HashMap hashMap = new HashMap();
            hashMap.put("card_exception", engineErrorException.toString());
            OmegaSDKAdapter.trackEvent("tech_sa_pax_event_card_show_exception", (Map<String, Object>) hashMap);
        }
    };

    /* renamed from: k */
    private BaseEventPublisher.OnEventListener f53663k = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (!SAPanelPresenter.this.f53659g) {
                ((SAPanelView) SAPanelPresenter.this.mView).scrollTop(0);
            }
        }
    };

    /* renamed from: l */
    private ILocation.ILocationChangedListener f53664l = new ILocation.ILocationChangedListener() {
        private DIDILocation mLastDiDiLocation;

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (dIDILocation != null) {
                DIDILocation dIDILocation2 = this.mLastDiDiLocation;
                if (dIDILocation2 == null || dIDILocation.distanceTo(dIDILocation2) > ((double) NewUISwitchUtils.getConfRefreshDistance())) {
                    this.mLastDiDiLocation = dIDILocation;
                    if (SuperAppBusinessManager.INSTANCE.isSaRealShow() && ActivityLifecycleManager.getInstance().isAppActive()) {
                        SAXEngineLoggerUtils.INSTANCE.info(" onLocationChanged requestPage ");
                        SAPanelPresenter.this.m40028a();
                    } else if (ActivityLifecycleManager.getInstance().isAppActive()) {
                        SAPanelPresenter.this.m40036a(ComponentType.COMPONENT_BUSINESS_CARD);
                    }
                }
            }
        }
    };

    /* renamed from: m */
    private BaseEventPublisher.OnEventListener f53665m = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if ("sa_guider".equals(str) && SAPanelPresenter.this.IGuider != null && SAPanelPresenter.this.f53657e != null) {
                SAPanelPresenter.this.IGuider.showGuid(SAPanelPresenter.this.mContext, SAPanelPresenter.this.panelProxy.getContainer(), SAPanelPresenter.this.f53657e);
            }
        }
    };

    /* renamed from: n */
    private BaseEventPublisher.OnEventListener f53666n = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (PageTouchEventManger.mapInFirstPosition && PageTouchEventManger.showMap) {
                ((SAPanelView) SAPanelPresenter.this.mView).expandPage();
            }
        }
    };

    /* access modifiers changed from: protected */
    public String getComponentIdByType(String str) {
        return str;
    }

    public ComponentPresenter getHostPresenter() {
        return null;
    }

    public SAPanelPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.google.gson.internal.LinkedTreeMap} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m40035a(com.google.gson.JsonArray r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0064 }
            r0.<init>()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0064 }
            com.didiglobal.sa.biz.component.sapanel.presenter.SAPanelPresenter$4 r1 = new com.didiglobal.sa.biz.component.sapanel.presenter.SAPanelPresenter$4     // Catch:{ Exception -> 0x0064 }
            r1.<init>()     // Catch:{ Exception -> 0x0064 }
            java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x0064 }
            java.lang.Object r5 = r0.fromJson((java.lang.String) r5, (java.lang.reflect.Type) r1)     // Catch:{ Exception -> 0x0064 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ Exception -> 0x0064 }
            boolean r0 = com.didi.sdk.util.collection.CollectionUtil.isEmpty((java.util.Collection<?>) r5)     // Catch:{ Exception -> 0x0064 }
            if (r0 == 0) goto L_0x0022
            return
        L_0x0022:
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0064 }
        L_0x0026:
            boolean r0 = r5.hasNext()     // Catch:{ Exception -> 0x0064 }
            if (r0 == 0) goto L_0x0068
            java.lang.Object r0 = r5.next()     // Catch:{ Exception -> 0x0064 }
            com.google.gson.internal.LinkedTreeMap r0 = (com.google.gson.internal.LinkedTreeMap) r0     // Catch:{ Exception -> 0x0064 }
            if (r0 != 0) goto L_0x0035
            goto L_0x0026
        L_0x0035:
            java.lang.String r1 = "id"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0064 }
            r2 = 0
            java.lang.String r3 = "extension"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x0064 }
            com.google.gson.internal.LinkedTreeMap r0 = (com.google.gson.internal.LinkedTreeMap) r0     // Catch:{ Exception -> 0x0064 }
            if (r0 == 0) goto L_0x0051
            java.lang.String r2 = "log_data"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x0064 }
            r2 = r0
            com.google.gson.internal.LinkedTreeMap r2 = (com.google.gson.internal.LinkedTreeMap) r2     // Catch:{ Exception -> 0x0064 }
        L_0x0051:
            if (r2 == 0) goto L_0x0026
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0064 }
            if (r0 != 0) goto L_0x0026
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0064 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0064 }
            java.util.HashMap<java.lang.String, com.google.gson.internal.LinkedTreeMap<java.lang.String, java.lang.Object>> r0 = r4.f53655c     // Catch:{ Exception -> 0x0064 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0064 }
            goto L_0x0026
        L_0x0064:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.sapanel.presenter.SAPanelPresenter.m40035a(com.google.gson.JsonArray):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40038a(List<XEComponent> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            for (XEComponent next : list) {
                if (next.getView() != null) {
                    SACardProperty sACardProperty = new SACardProperty();
                    sACardProperty.setId(next.getId());
                    sACardProperty.setView(next.getView());
                    this.panelProxy.updateCard(sACardProperty);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40029a(XEngineData xEngineData, List<XEComponent> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            ArrayList arrayList = new ArrayList();
            for (XEComponent next : list) {
                if (next.getView() == null) {
                    Iterator it = this.mBizCardProperties.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        SABizCardProperty sABizCardProperty = (SABizCardProperty) it.next();
                        if (next.getId().equals(sABizCardProperty.mId)) {
                            if (sABizCardProperty.mView == null) {
                                m40037a(sABizCardProperty.mId, "view == null");
                            } else {
                                SACardProperty sACardProperty = new SACardProperty();
                                sACardProperty.setId(sABizCardProperty.mId);
                                sACardProperty.setView(sABizCardProperty.mView);
                                Map map = this.f53655c.get(next.getId());
                                if (map != null) {
                                    sACardProperty.setExtension(map);
                                }
                                sACardProperty.setListener(sABizCardProperty.mVisibleListener);
                                if (sABizCardProperty.rideView != null) {
                                    sACardProperty.setTransparent(sABizCardProperty.rideView.containMap());
                                }
                                if (sABizCardProperty.cardPosition != null) {
                                    sACardProperty.setPosition(sABizCardProperty.cardPosition);
                                }
                                arrayList.add(sACardProperty);
                            }
                        }
                    }
                } else {
                    SACardProperty sACardProperty2 = new SACardProperty();
                    sACardProperty2.setId(next.getId());
                    sACardProperty2.setView(next.getView());
                    Map map2 = this.f53655c.get(next.getId());
                    if (map2 != null) {
                        sACardProperty2.setExtension(map2);
                    }
                    arrayList.add(sACardProperty2);
                }
            }
            this.f53657e = arrayList;
            this.panelProxy.setData(arrayList);
            m40045b((List<SACardProperty>) arrayList);
            if (this.IDranageGuider != null) {
                UIHandler.getHandler().postDelayed(new Runnable() {
                    public void run() {
                        SAPanelPresenter.this.IDranageGuider.showGuid(SAPanelPresenter.this.mContext, SAPanelPresenter.this.panelProxy.getContainer(), SAPanelPresenter.this.f53657e);
                    }
                }, 200);
            }
        }
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f53658f = true;
        XECacheParamsImpl xECacheParamsImpl = new XECacheParamsImpl();
        xECacheParamsImpl.scene = "sa_home";
        xECacheParamsImpl.component = null;
        CachedPageData cachedPageData = new CachedPageData();
        int type = SaApolloUtil.INSTANCE.getSaType().getType();
        SAXEngineLoggerUtils sAXEngineLoggerUtils = SAXEngineLoggerUtils.INSTANCE;
        sAXEngineLoggerUtils.info(" onAdd sa type: " + type);
        if (type == 1) {
            xECacheParamsImpl.jsonString = cachedPageData.getMData_type1();
        } else if (type != 3) {
            xECacheParamsImpl.jsonString = cachedPageData.getMData_type2();
        } else {
            xECacheParamsImpl.jsonString = cachedPageData.getMData_type3();
        }
        SAXEngineReqUtil.INSTANCE.setDefaultCache(xECacheParamsImpl);
        subscribe("sa_guider", this.f53665m);
        subscribe(BaseEventKeys.SA_Panel.PANEL_EXPAND, this.f53666n);
        subscribe(BaseEventKeys.SA_Panel.EVENT_HOME_PANEL_SCROLL_TOP, this.f53663k);
        addSender(new IHomepData() {
            public RideCardModel getData(NullData nullData) {
                return SAPanelPresenter.this.f53653a;
            }

            public void setData(RideCardModel rideCardModel) {
                SAPanelPresenter.this.f53653a = rideCardModel;
            }
        });
        addSender(new IAddressData() {
            public Address getData(NullData nullData) {
                return SAPanelPresenter.this.f53654b;
            }

            public void setData(Address address) {
                SAPanelPresenter.this.f53654b = address;
            }
        });
        XERegister.registerTemplate(new XERegisterModel(ComponentType.COMPONENT_SA_XPANEL, "sa_home", this.f53662j));
        SAXEngineLoggerUtils.INSTANCE.info(" pageRequestWithCache: ");
        SAXEngineReqUtil.INSTANCE.pageRequestCacheOnly("sa_home");
        LocationPerformer.getInstance().addLocationListener(this.f53664l);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40028a() {
        if (this.f53658f) {
            this.f53658f = false;
            return;
        }
        SAXEngineReqUtil.INSTANCE.pageRequest("sa_home");
        if (this.f53661i) {
            this.f53660h = System.currentTimeMillis();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40036a(String str) {
        XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
        xEBizParamsImpl.requestKeys = new String[]{str};
        xEBizParamsImpl.scene = "sa_home";
        SAXEngineReqUtil.INSTANCE.simpleRequest(xEBizParamsImpl);
    }

    public void onPageHiddenChanged(boolean z) {
        super.onPageHiddenChanged(z);
        this.f53659g = z;
        if (z) {
            m40043b();
        } else {
            m40046c();
        }
    }

    /* renamed from: b */
    private void m40043b() {
        m40053f();
    }

    /* renamed from: c */
    private void m40046c() {
        if (PageTouchEventManger.pullToRid) {
            PageTouchEventManger.pullToRid = false;
            ((SAPanelView) this.mView).resumePageSize();
        }
        SAXEngineLoggerUtils.INSTANCE.info(" onPageVisible requestPage ");
        m40028a();
        m40050e();
    }

    public void onRemove() {
        super.onRemove();
        unsubscribe("sa_guider", this.f53665m);
        unsubscribe(BaseEventKeys.SA_Panel.PANEL_EXPAND, this.f53666n);
        unsubscribe(BaseEventKeys.SA_Panel.EVENT_HOME_PANEL_SCROLL_TOP, this.f53663k);
        LocationPerformer.getInstance().removeLocationListener(this.f53664l);
        XERegister.unregisterTemplate(ComponentType.COMPONENT_SA_XPANEL);
    }

    /* renamed from: d */
    private List<SACardProperty> m40049d() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            SACardProperty sACardProperty = new SACardProperty();
            sACardProperty.setId("id:" + i);
            sACardProperty.setView(new XPCardView(this.mContext, i).getView());
            arrayList.add(sACardProperty);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public String[] getNativeCards() {
        return new String[]{ComponentType.COMPONENT_RIDE_CARD, ComponentType.COMPONENT_BUSINESS_CARD, ComponentType.COMPONENT_HOME_MSG, ComponentType.COMPONENT_RECOMMEND, ComponentType.COMPONENT_SA_GUIDE, ComponentType.COMPONENT_DRAINAGE_GUIDE, ComponentType.COMPONENT_BIZ_CARD};
    }

    public void onPageResume() {
        super.onPageResume();
        if (SuperAppBusinessManager.INSTANCE.isActivityResume()) {
            if (SuperAppBusinessManager.INSTANCE.isSaRealShow()) {
                SAXEngineLoggerUtils.INSTANCE.info(" onPageResume requestPage ");
                m40028a();
                m40050e();
            } else {
                if (this.f53658f) {
                    m40044b("not issarealshow");
                }
                m40036a(ComponentType.COMPONENT_BUSINESS_CARD);
            }
        } else if (this.f53658f) {
            m40044b("not isactivityresume");
        }
        this.f53658f = false;
    }

    public void onPageStop() {
        super.onPageStop();
        m40053f();
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mComponentCreator = iComponentCreator;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40039a(List<XEComponent> list, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            hashMap.put("card_count", 0);
        } else {
            hashMap.put("card_count", Integer.valueOf(list.size()));
            StringBuilder sb = new StringBuilder();
            for (XEComponent id : list) {
                sb.append(id.getId());
                sb.append(",");
            }
            hashMap.put("card_name", sb.toString());
        }
        hashMap.put("iscache", Boolean.valueOf(z));
        hashMap.put("isupdatechildmode", Boolean.valueOf(z2));
        OmegaSDKAdapter.trackEvent("tech_sa_pax_event_xpanel_data_card_count", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m40037a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("card_name", str);
        hashMap.put("card_exception", str2);
        OmegaSDKAdapter.trackEvent("tech_sa_pax_event_card_show_exception", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private void m40045b(List<SACardProperty> list) {
        HashMap hashMap = new HashMap();
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            hashMap.put("card_count", 0);
        } else {
            hashMap.put("card_count", Integer.valueOf(list.size()));
            StringBuilder sb = new StringBuilder();
            for (SACardProperty id : list) {
                sb.append(id.getId());
                sb.append(",");
            }
            hashMap.put("card_name", sb.toString());
        }
        OmegaSDKAdapter.trackEvent("tech_sa_pax_event_xpanel_show_card_count", (Map<String, Object>) hashMap);
    }

    /* renamed from: e */
    private void m40050e() {
        this.f53656d = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("k", "access");
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_home_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: f */
    private void m40053f() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "notice");
        hashMap.put(RavenKey.VERSION, "staytime");
        hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f53656d));
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_home_staytime_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private void m40044b(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("des", str);
            OmegaSDKAdapter.trackEvent("tech_sa_pax_event_xpanel_not_resume", (Map<String, Object>) hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
