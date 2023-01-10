package com.didi.sdk.app;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.didi.app.router.PageRouter;
import com.didi.drouter.api.DRouter;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.app.TabEventManager;
import com.didi.sdk.app.business.BusinessInitCallback;
import com.didi.sdk.events.OpenSideBarPageEvent;
import com.didi.sdk.events.SwitchTypeEvent;
import com.didi.sdk.home.model.TopBarData;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.event.CarInfoUpdateEvent;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.sidebar.templet.AutoLinker;
import com.didi.sdk.util.EventKeys;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class BizManager {
    public static final String ENTRANCE = "entrance";

    /* renamed from: a */
    private Logger f37883a = LoggerFactory.getLogger("BizManager");

    /* renamed from: b */
    private String f37884b;

    /* renamed from: c */
    private String f37885c;

    /* renamed from: d */
    private BusinessContextHelper f37886d = null;

    /* renamed from: e */
    private HashMap<String, BusinessContext> f37887e = new HashMap<>();

    /* renamed from: f */
    private final HashMap<String, Boolean> f37888f = new HashMap<>();

    /* renamed from: g */
    private BizListener f37889g;

    public interface BizListener {
        void onBizDataChanged(int i);

        void onBizSwitched(CarGrop carGrop, String str, BusinessContext businessContext, TabEventManager.TabHandleModel tabHandleModel);
    }

    public void init(BusinessContextHelper businessContextHelper) {
        this.f37886d = businessContextHelper;
        EventBus.getDefault().register(this);
    }

    public void destory() {
        EventBus.getDefault().unregister(this);
        this.f37887e.clear();
    }

    public void setBizListener(BizListener bizListener) {
        this.f37889g = bizListener;
    }

    /* renamed from: a */
    private void m28560a(String str, BusinessContext businessContext) {
        if (businessContext != null && this.f37887e.get(str) == null) {
            this.f37887e.put(str, businessContext);
        }
    }

    public void loadBiz(String str, String str2, boolean z, TabEventManager.TabHandleModel tabHandleModel) {
        loadBiz(ConfProxy.getInstance().getGroupByType(str), str2, z, tabHandleModel);
    }

    public void loadBiz(final CarGrop carGrop, final String str, boolean z, final TabEventManager.TabHandleModel tabHandleModel) {
        if (carGrop == null) {
            this.f37883a.error("biz not exist", new Object[0]);
            return;
        }
        String groupType = carGrop.getGroupType();
        String navTag = carGrop.getNavTag();
        if (!z && navTag.equals(this.f37884b) && groupType.equals(this.f37885c)) {
            return;
        }
        if (!"ride".equals(groupType) && !ConfProxy.getInstance().isContainsGroupType(groupType)) {
            Logger logger = this.f37883a;
            logger.error("loadbiz failed, while topbar not contains " + groupType, new Object[0]);
        } else if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ApmThreadPool.excuteOnUiThread(new Runnable() {
                public void run() {
                    BusinessContext unused = BizManager.this.m28558a(carGrop, str, tabHandleModel);
                }
            });
        } else {
            m28558a(carGrop, str, tabHandleModel);
        }
    }

    public void loadBiz(CarGrop carGrop, boolean z, TabEventManager.TabHandleModel tabHandleModel) {
        loadBiz(carGrop, (String) null, z, tabHandleModel);
    }

    /* renamed from: a */
    private void m28559a(String str) {
        BusinessInitCallback businessInitCallback = (BusinessInitCallback) ServiceLoader.load(BusinessInitCallback.class, str).get();
        if (businessInitCallback != null) {
            if (this.f37888f.containsKey(str)) {
                Logger logger = this.f37883a;
                logger.debug("syncInitBusiness", "has init " + str + ", just return");
            } else {
                Logger logger2 = this.f37883a;
                logger2.debug("syncInitBusiness", "init " + str);
                businessInitCallback.onSyncInit(DIDIBaseApplication.getAppContext());
                HashMap hashMap = new HashMap();
                hashMap.put("group_type", str);
                OmegaSDKAdapter.trackEvent("product_group_loaded", (Map<String, Object>) hashMap);
                this.f37888f.put(str, true);
            }
            businessInitCallback.onSwitchToBusiness(DIDIBaseApplication.getAppContext(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public BusinessContext m28558a(CarGrop carGrop, String str, TabEventManager.TabHandleModel tabHandleModel) {
        String groupType = carGrop.getGroupType();
        String navTag = carGrop.getNavTag();
        m28559a(groupType);
        BusinessContext businessContext = (BusinessContext) this.f37886d.getBusinessContext(groupType, BusinessContext.class);
        businessContext.setBusinessGroupType(groupType);
        businessContext.setCountryInfo(ConfProxy.getInstance().getCountryInfo());
        m28560a(groupType, businessContext);
        String schema = carGrop.getSchema();
        this.f37884b = navTag;
        this.f37885c = groupType;
        if (TextUtils.isEmpty(schema) || schema.contains("entrance")) {
            ConfProxy.getInstance().setSelectedType(groupType);
        } else {
            TopBarData topBarData = ConfProxy.getInstance().getTopBarData();
            if (topBarData != null) {
                topBarData.setSelectedGroup(groupType);
            }
        }
        SafeToolKit.getIns().setProductId(ConfProxy.getInstance().getSelectedGroupId());
        SafeToolKit.getIns().setBusinessType(groupType);
        if ("bus".equals(groupType)) {
            SafeToolKit.getIns().setBusinessType("ride");
        }
        BusinessContextManager.getInstance().mo97016a((BaseBusinessContext) businessContext);
        PageRouter.getInstance().setBusinessContext(businessContext);
        BizListener bizListener = this.f37889g;
        if (bizListener != null) {
            bizListener.onBizSwitched(carGrop, str, businessContext, tabHandleModel);
        }
        if (tabHandleModel != null && !TextUtils.isEmpty(tabHandleModel.getActionUrl())) {
            DRouter.build(tabHandleModel.getActionUrl()).start();
        }
        return businessContext;
    }

    public void refreshMis(boolean z) {
        BusinessContext businessContext = (BusinessContext) this.f37886d.getBusinessContext(ConfProxy.getInstance().getSelectedType(), BusinessContext.class);
        if (!(businessContext == null || businessContext.getCountryInfo() == null)) {
            int cityId = businessContext.getCountryInfo().getCityId();
            Logger logger = this.f37883a;
            logger.debug("MainActivity refreshMis cityId = " + cityId, new Object[0]);
        }
        EventBus.getDefault().post(new Pair(EventKeys.MisConfig.REFRESH_MIS, Integer.valueOf(z ? 1 : 0)));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(CarInfoUpdateEvent carInfoUpdateEvent) {
        if (carInfoUpdateEvent != null && EventKeys.MisConfig.MIS_DATA_FROM_UPDATE.equalsIgnoreCase(carInfoUpdateEvent.tag)) {
            Logger logger = this.f37883a;
            logger.debug("onReceive CarInfoUpdateEvent result = " + carInfoUpdateEvent.result, new Object[0]);
            if (this.f37887e.size() > 0) {
                for (String str : this.f37887e.keySet()) {
                    BusinessContext businessContext = this.f37887e.get(str);
                    businessContext.setCountryInfo(ConfProxy.getInstance().getCountryInfo());
                    businessContext.setMisDataFrom(carInfoUpdateEvent.result);
                }
            }
            if (this.f37889g != null && carInfoUpdateEvent.versionChanged) {
                this.f37889g.onBizDataChanged(carInfoUpdateEvent.result);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSwitchType(SwitchTypeEvent switchTypeEvent) {
        if (!TextUtils.isEmpty(switchTypeEvent.type)) {
            loadBiz(switchTypeEvent.type, switchTypeEvent.urlGetParams, false, switchTypeEvent.tabHandleModel);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSideBarPageRequested(OpenSideBarPageEvent openSideBarPageEvent) {
        AutoLinker.getLinker().linkToTarget(openSideBarPageEvent.item, (BusinessContext) this.f37886d.getBusinessContext(ConfProxy.getInstance().getSelectedType(), BusinessContext.class), openSideBarPageEvent.subLevel);
    }
}
