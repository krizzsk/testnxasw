package com.didiglobal.p205sa.biz.component.activity.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.didi.component.never.core.ComponentParams;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.NetUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.data.parser.XEParseConst;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityCardModel;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityProperty;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityViewType;
import com.didiglobal.p205sa.biz.component.activity.omega.ActivityOmegaTracker;
import com.didiglobal.p205sa.biz.component.activity.view.ActivityPanelView;
import com.didiglobal.p205sa.biz.component.activity.view.ToastUtils;
import com.didiglobal.p205sa.biz.component.xengine.SAXEngineReqUtil;
import com.didiglobal.p205sa.biz.util.GsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* renamed from: com.didiglobal.sa.biz.component.activity.presenter.ActivityPanelPresenter */
public class ActivityPanelPresenter extends AbsActivityPanelPresenter implements LoginListeners.LoginListener, IActivityPresenter {
    public static boolean isNoData = false;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f53268a = -1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f53269b = -1;

    /* renamed from: c */
    private boolean f53270c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f53271d = -1;

    /* renamed from: e */
    private Timer f53272e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f53273f = 1;

    /* renamed from: g */
    private long f53274g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Handler f53275h = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Logger f53276i = LoggerFactory.getLogger("ActivityPanelPresenter");
    /* access modifiers changed from: private */

    /* renamed from: j */
    public List<ActivityProperty> f53277j;

    /* renamed from: k */
    private TimerTask f53278k;

    /* renamed from: l */
    private XEResponseCallback f53279l = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            boolean z = false;
            ActivityPanelPresenter.this.f53276i.info("XEResponseCallback success: %s", xEngineData);
            List a = ActivityPanelPresenter.this.m39850a(xEngineData);
            if (!CollectionUtil.isEmpty((Collection<?>) a)) {
                ActivityOmegaTracker.clear();
                if (a.size() == 1) {
                    z = true;
                }
                ActivityPanelPresenter.isNoData = z;
                if (ActivityPanelPresenter.isNoData) {
                    ActivityOmegaTracker.OmegaActivityNoData(1);
                }
                ((ActivityPanelView) ActivityPanelPresenter.this.mView).setData(a, ActivityPanelPresenter.this.f53269b, ActivityPanelPresenter.this.f53271d);
            } else {
                ActivityPanelPresenter.this.m39853a();
            }
            List unused = ActivityPanelPresenter.this.f53277j = a;
            ActivityPanelPresenter.this.m39855b();
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            ActivityPanelPresenter.this.f53276i.info("XEResponseCallback fail: %s", engineErrorException.toString());
            ActivityPanelPresenter.this.m39853a();
        }
    };

    /* renamed from: m */
    private XEReqJSONParamsCallbackImpl f53280m = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            hashMap.put("page", Integer.valueOf(ActivityPanelPresenter.this.f53273f));
            return new JSONObject(hashMap);
        }
    };

    /* access modifiers changed from: protected */
    public String getComponentIdByType(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    public String[] getNativeCards() {
        return new String[0];
    }

    public ActivityPanelPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39853a() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f53277j)) {
            ((ActivityPanelView) this.mView).showErrorView(R.drawable.activity_page_lost, this.mContext.getResources().getString(R.string.GRider_batch1__ijLA));
            ActivityOmegaTracker.OmegaActivityNoData(3);
            return;
        }
        ((ActivityPanelView) this.mView).resetLoading();
        ToastUtils.showToast(this.mContext, this.mContext.getString(R.string.GRider_batch1__ijLA), R.drawable.activity_toast_icon);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<ActivityProperty> m39850a(XEngineData xEngineData) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            JsonObject jsonObject = xEngineData.jsonObject;
            JsonArray asJsonArray = jsonObject.getAsJsonArray("list");
            JsonObject asJsonObject = jsonObject.getAsJsonObject(XEParseConst.XE_JSON_KEY_UI_CONFIG).getAsJsonObject("setting");
            if (asJsonObject.has("refresh_interval")) {
                this.f53268a = asJsonObject.get("refresh_interval").getAsInt() * 1000;
            }
            if (asJsonArray.get(0).getAsJsonObject().has("max_count")) {
                this.f53269b = asJsonArray.get(0).getAsJsonObject().get("max_count").getAsInt();
            }
            if (asJsonArray.size() > 1 && asJsonArray.get(1).getAsJsonObject().has("is_all_data")) {
                this.f53271d = asJsonArray.get(1).getAsJsonObject().get("is_all_data").getAsInt();
            }
            for (int i = 0; i < asJsonArray.size(); i++) {
                JsonArray asJsonArray2 = asJsonArray.get(i).getAsJsonObject().getAsJsonArray("cards");
                for (int i2 = 0; i2 < asJsonArray2.size(); i2++) {
                    ActivityCardModel activityCardModel = (ActivityCardModel) GsonUtils.fromJson(asJsonArray2.get(i2).getAsJsonObject().toString(), ActivityCardModel.class);
                    ActivityProperty activityProperty = new ActivityProperty();
                    activityProperty.setModel(activityCardModel);
                    activityProperty.setTypeId(activityCardModel.getType_id());
                    if (ActivityViewType.ongoing_card.getTypeId().equals(activityCardModel.getType_id())) {
                        arrayList2.add(activityProperty);
                    }
                    arrayList.add(activityProperty);
                }
            }
            if (CollectionUtil.isEmpty((Collection<?>) arrayList)) {
                ActivityOmegaTracker.OmegaError(1);
            }
            if (arrayList2.size() > this.f53269b) {
                ActivityProperty activityProperty2 = new ActivityProperty();
                activityProperty2.setTypeId(ActivityViewType.ongoing_more_card.getTypeId());
                arrayList.add(arrayList2.size() + 1, activityProperty2);
            }
            return arrayList;
        } catch (Exception e) {
            Logger logger = this.f53276i;
            logger.info("parseData error" + e.toString(), new Object[0]);
            ActivityOmegaTracker.OmegaError(3);
            return null;
        }
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f53276i.info("onAdd", new Object[0]);
        this.f53270c = false;
        m39860e();
    }

    public void onPageHiddenChanged(boolean z) {
        Logger logger = this.f53276i;
        logger.info("onPageHiddenChanged：" + z, new Object[0]);
        this.f53270c = z;
        super.onPageHiddenChanged(z);
        if (!z) {
            if (!m39863f()) {
                ActivityOmegaTracker.OmegaError(4);
            }
            m39865g();
            m39859d();
            this.f53274g = System.currentTimeMillis();
            ActivityOmegaTracker.OmegaActivityVisible(CollectionUtil.isEmpty((Collection<?>) this.f53277j) ^ true ? 1 : 0);
            return;
        }
        m39866h();
        m39857c();
        ActivityOmegaTracker.OmegaActivityShowTime(System.currentTimeMillis() - this.f53274g, CollectionUtil.isEmpty((Collection<?>) this.f53277j) ^ true ? 1 : 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m39855b() {
        this.f53276i.info("scheduleRequest %s", Integer.valueOf(this.f53268a));
        m39857c();
        if (this.f53268a >= 0) {
            this.f53272e = new Timer();
            C178632 r2 = new TimerTask() {
                public void run() {
                    ActivityPanelPresenter.this.f53275h.post(new Runnable() {
                        public void run() {
                            ActivityPanelPresenter.this.f53276i.info("TimerTask schedule: %s", Integer.valueOf(ActivityPanelPresenter.this.f53268a));
                            ActivityPanelPresenter.this.m39859d();
                        }
                    });
                }
            };
            this.f53278k = r2;
            Timer timer = this.f53272e;
            int i = this.f53268a;
            timer.schedule(r2, (long) i, (long) i);
        }
    }

    /* renamed from: c */
    private void m39857c() {
        this.f53276i.info("stopSchedule", new Object[0]);
        Timer timer = this.f53272e;
        if (timer != null) {
            timer.cancel();
            this.f53272e = null;
        }
        TimerTask timerTask = this.f53278k;
        if (timerTask != null) {
            timerTask.cancel();
            this.f53278k = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m39859d() {
        this.f53276i.info("requestActivity", new Object[0]);
        if (NetUtil.isAvailable(this.mContext)) {
            SAXEngineReqUtil.INSTANCE.pageRequest("sa_activity");
        } else if (CollectionUtil.isEmpty((Collection<?>) this.f53277j)) {
            ((ActivityPanelView) this.mView).showErrorView(R.drawable.activity_network_error, this.mContext.getResources().getString(R.string.GRider_batch1__SSTN));
            ActivityOmegaTracker.OmegaActivityNoData(2);
        } else {
            ToastUtils.showToast(this.mContext, this.mContext.getString(R.string.GRider_batch1__SSTN), R.drawable.activity_toast_icon);
        }
    }

    public void onPageResume() {
        super.onPageResume();
        Logger logger = this.f53276i;
        logger.info("onPageResumepageHidden: " + this.f53270c, new Object[0]);
        if (!this.f53270c) {
            m39865g();
            m39859d();
            this.f53274g = System.currentTimeMillis();
            ActivityOmegaTracker.OmegaActivityVisible(CollectionUtil.isEmpty((Collection<?>) this.f53277j) ^ true ? 1 : 0);
        }
    }

    public void onPagePause() {
        super.onPagePause();
        this.f53276i.info("onPagePause", new Object[0]);
        m39857c();
        ActivityOmegaTracker.OmegaActivityShowTime(System.currentTimeMillis() - this.f53274g, CollectionUtil.isEmpty((Collection<?>) this.f53277j) ^ true ? 1 : 0);
    }

    public void onPageStop() {
        super.onPageStop();
        this.f53276i.info("onPageStop", new Object[0]);
        m39866h();
    }

    /* renamed from: e */
    private void m39860e() {
        XERegisterModel xERegisterModel = new XERegisterModel(ComponentType.COMPONENT_SA_ACTIVITY_PANEL, "sa_activity", this.f53279l);
        xERegisterModel.required = true;
        xERegisterModel.requestParams = this.f53280m;
        XERegister.registerTemplate(xERegisterModel);
    }

    public void reqeustRetry() {
        m39859d();
    }

    public void requestRefresh() {
        this.f53273f = 1;
        m39859d();
    }

    public void requestLoadMore() {
        this.f53273f++;
        m39859d();
    }

    /* renamed from: f */
    private boolean m39863f() {
        return NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow();
    }

    /* renamed from: g */
    private void m39865g() {
        OneLoginFacade.getFunction().addLoginListener(this);
    }

    /* renamed from: h */
    private void m39866h() {
        OneLoginFacade.getFunction().removeLoginListener(this);
    }

    public void onSuccess(Activity activity, String str) {
        this.f53276i.info("login_onSuccess", new Object[0]);
    }

    public void onCancel() {
        Logger logger = this.f53276i;
        logger.info("login_cancel " + this.f53270c, new Object[0]);
        if (!this.f53270c) {
            DRouter.build("GlobalOneTravel://one/switch_tab?tab_id=tab_home").start();
        }
    }
}
