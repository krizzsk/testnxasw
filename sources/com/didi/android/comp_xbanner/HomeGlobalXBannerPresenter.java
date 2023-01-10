package com.didi.android.comp_xbanner;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.xbanner.utils.XBannerUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.misconfig.p154v2.SecondConfProxy;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.xbanner.XBanner;
import com.didiglobal.xbanner.XBannerCallback;
import com.didiglobal.xbanner.net.model.BizParams;
import com.didiglobal.xbanner.template.view.XBannerNativeView;
import com.google.gson.JsonObject;
import com.taxis99.R;
import com.threatmetrix.TrustDefender.qttqtt;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class HomeGlobalXBannerPresenter extends AbsGlobalXBannerPresenter implements ILocation.ILocationChangedListener {
    public static final String TAG = "HomeRefactor";

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<String> f9941a = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            int a = HomeGlobalXBannerPresenter.this.m8655a(str2);
            SystemUtils.log(6, "xBannerReloadListener", str2, (Throwable) null, "com.didi.android.comp_xbanner.HomeGlobalXBannerPresenter$6", 436);
            GLog.m11354d(HomeGlobalXBannerPresenter.TAG, "refreshXBanner " + str2);
            HomeGlobalXBannerPresenter.this.m8657a(a);
        }
    };

    /* renamed from: b */
    BaseEventPublisher.OnEventListener<String> f9942b = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (HomeGlobalXBannerPresenter.this.f9944d != null && HomeGlobalXBannerPresenter.this.f9945e && !TextUtils.isEmpty(str2)) {
                HomeGlobalXBannerPresenter.this.f9944d.removeItemByCardid(str2);
            }
        }
    };

    /* renamed from: c */
    BaseEventPublisher.OnEventListener<Integer> f9943c = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            GLog.m11354d(HomeGlobalXBannerPresenter.TAG, "refreshXBanner " + num.toString());
            HomeGlobalXBannerPresenter.this.m8661a(LocationPerformer.getInstance().getLastLocation(), num.intValue());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d */
    public XBanner f9944d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f9945e;

    /* renamed from: f */
    private boolean f9946f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BizParams f9947g;

    /* renamed from: h */
    private int f9948h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public XBannerCallback f9949i;

    /* renamed from: j */
    private Activity f9950j;

    /* renamed from: k */
    private BusinessContext f9951k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f9952l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f9953m = 0;

    /* renamed from: n */
    private XEReqJSONParamsCallbackImpl f9954n = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            hashMap.put("scene", "home");
            if (HomeGlobalXBannerPresenter.this.f9947g != null) {
                hashMap.put("select_lat", Float.valueOf(HomeGlobalXBannerPresenter.this.f9947g.select_lat));
                hashMap.put("select_lng", Float.valueOf(HomeGlobalXBannerPresenter.this.f9947g.select_lng));
                hashMap.put("user_loc_accuracy", Float.valueOf(HomeGlobalXBannerPresenter.this.f9947g.user_loc_accuracy));
                hashMap.put("user_loc_provider", HomeGlobalXBannerPresenter.this.f9947g.user_loc_provider);
                hashMap.put("page_state", Integer.valueOf(HomeGlobalXBannerPresenter.this.f9947g.page_state));
                hashMap.put("station_switch", Integer.valueOf(HomeGlobalXBannerPresenter.this.f9947g.station_switch));
            }
            return new JSONObject(hashMap);
        }
    };

    /* renamed from: p */
    private XEResponseCallback f9955p = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData.jsonObject != null) {
                HomeGlobalXBannerPresenter.this.f9944d.setXBannerData(xEngineData.jsonObject, true, true, HomeGlobalXBannerPresenter.this.f9949i);
                if (HomeGlobalXBannerPresenter.this.f9945e) {
                    XBannerNativeView e = HomeGlobalXBannerPresenter.this.m8665b();
                    HomeGlobalXBannerPresenter.this.f9944d.reloadXBannerAndNativeCheck(HomeGlobalXBannerPresenter.this.f9949i, xEngineData.jsonObject, e);
                }
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            if (HomeGlobalXBannerPresenter.this.f9949i != null) {
                HomeGlobalXBannerPresenter.this.f9949i.onFail(engineErrorException);
            }
        }
    };

    /* renamed from: q */
    private LatLng f9956q = new LatLng(0.0d, 0.0d);

    /* renamed from: r */
    private double f9957r = ((double) ((Integer) GlobalApolloUtil.getParam("xbanner_request_filter", "distance", 200)).intValue());

    /* renamed from: s */
    private BaseEventPublisher.OnEventListener<Integer> f9958s = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED)) {
                int i = 0;
                if (!(HomeGlobalXBannerPresenter.this.mComponentParams == null || HomeGlobalXBannerPresenter.this.mComponentParams.bizCtx == null || HomeGlobalXBannerPresenter.this.mComponentParams.bizCtx.getBizBarHeight() <= 0)) {
                    i = HomeGlobalXBannerPresenter.this.mComponentParams.bizCtx.getBizBarHeight();
                }
                ((IGlobalXBannerView) HomeGlobalXBannerPresenter.this.mView).setTranslationY((-num.intValue()) - (i > 0 ? i - ResourcesHelper.getDimensionPixelSize(HomeGlobalXBannerPresenter.this.mContext, R.dimen.global_x_banner_normal_translate_offset) : -ResourcesHelper.getDimensionPixelSize(HomeGlobalXBannerPresenter.this.mContext, R.dimen.global_x_banner_no_bottom_banner_offset)));
            }
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: b */
    public XBannerNativeView m8665b() {
        return null;
    }

    /* renamed from: d */
    private int m8670d() {
        return 1;
    }

    public HomeGlobalXBannerPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f9950j = componentParams.getActivity();
        this.f9951k = componentParams.bizCtx;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m8655a(java.lang.String r9) {
        /*
            r8 = this;
            int r0 = r9.hashCode()
            r1 = 0
            r2 = -1
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r0) {
                case -1277259252: goto L_0x004b;
                case -739238274: goto L_0x0041;
                case 19817269: goto L_0x0037;
                case 440214241: goto L_0x002d;
                case 1166410875: goto L_0x0023;
                case 1293241812: goto L_0x0019;
                case 1693861782: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0055
        L_0x000f:
            java.lang.String r0 = "home_not_open"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 1
            goto L_0x0056
        L_0x0019:
            java.lang.String r0 = "home_station"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 4
            goto L_0x0056
        L_0x0023:
            java.lang.String r0 = "home_keep_page_state"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 5
            goto L_0x0056
        L_0x002d:
            java.lang.String r0 = "home_default"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 6
            goto L_0x0056
        L_0x0037:
            java.lang.String r0 = "home_warm_up"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 2
            goto L_0x0056
        L_0x0041:
            java.lang.String r0 = "home_banned"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 0
            goto L_0x0056
        L_0x004b:
            java.lang.String r0 = "home_pause_service"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 3
            goto L_0x0056
        L_0x0055:
            r9 = -1
        L_0x0056:
            if (r9 == 0) goto L_0x0068
            if (r9 == r7) goto L_0x0067
            if (r9 == r6) goto L_0x0066
            if (r9 == r5) goto L_0x0065
            if (r9 == r4) goto L_0x0064
            if (r9 == r3) goto L_0x0063
            return r1
        L_0x0063:
            return r2
        L_0x0064:
            return r3
        L_0x0065:
            return r4
        L_0x0066:
            return r5
        L_0x0067:
            return r6
        L_0x0068:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.android.comp_xbanner.HomeGlobalXBannerPresenter.m8655a(java.lang.String):int");
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m8658a(this.f9950j);
        GLog.m11354d(TAG, "Xbanner onAdd");
        if (GlobalApolloUtil.isHomeEngine()) {
            if (this.f9944d != null) {
                m8662a((DIDILocation) null, this.f9950j);
            }
            XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_XBANNER, XERequestKey.SCENE_HOME, this.f9955p);
            xERegisterModel.requestParams = this.f9954n;
            XERegister.registerTemplate(xERegisterModel);
        }
        subscribe(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_RELOAD_WITH_PAGE_STATE, this.f9941a);
        subscribe(BaseEventKeys.XBanner.EVENT_HOME_REFACTOR_XBANNER_RELOAD_WITH_PAGE_STATE, this.f9943c);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.f9958s);
        subscribe(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_DELETCT_ITEM, this.f9942b);
    }

    /* renamed from: a */
    private void m8658a(Activity activity) {
        this.f9944d = new XBanner(activity, ((IGlobalXBannerView) this.mView).getXBannerView());
        LocationPerformer.getInstance().addLocationListener(this);
        this.f9952l = XBannerUtil.getItemHeight(activity) - activity.getResources().getDimensionPixelOffset(R.dimen.global_x_banner_default_bottom_dimen);
        this.f9949i = new XBannerCallback() {
            public void onSuccess(JsonObject jsonObject) {
                if (GlobalApolloUtil.isHomeEngine()) {
                    boolean unused = HomeGlobalXBannerPresenter.this.f9945e = true;
                }
                if (HomeGlobalXBannerPresenter.this.f9953m != HomeGlobalXBannerPresenter.this.f9952l) {
                    HomeGlobalXBannerPresenter homeGlobalXBannerPresenter = HomeGlobalXBannerPresenter.this;
                    int unused2 = homeGlobalXBannerPresenter.f9953m = homeGlobalXBannerPresenter.f9952l;
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, Integer.valueOf(HomeGlobalXBannerPresenter.this.f9952l));
                }
            }

            public void onFail(Exception exc) {
                if (HomeGlobalXBannerPresenter.this.f9953m != 0) {
                    int unused = HomeGlobalXBannerPresenter.this.f9953m = 0;
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, 0);
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        LocationPerformer.getInstance().removeLocationListener(this);
        unsubscribe(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_RELOAD_WITH_PAGE_STATE, this.f9941a);
        unsubscribe(BaseEventKeys.XBanner.EVENT_HOME_REFACTOR_XBANNER_RELOAD_WITH_PAGE_STATE, this.f9943c);
        unsubscribe(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_DELETCT_ITEM, this.f9942b);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.f9958s);
        if (GlobalApolloUtil.isHomeEngine()) {
            XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_XBANNER);
        }
    }

    /* renamed from: a */
    private void m8662a(DIDILocation dIDILocation, Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("initXBannerR location");
        sb.append(dIDILocation == null ? " null" : " not null");
        GLog.m11354d(TAG, sb.toString());
        m8660a(dIDILocation);
        this.f9944d.initXBanner(activity);
    }

    /* renamed from: a */
    private void m8660a(DIDILocation dIDILocation) {
        this.f9947g = new BizParams();
        if (dIDILocation == null) {
            dIDILocation = LocationController.getInstance().getLastKnownLocation(this.f9950j);
        }
        XBannerNativeView b = m8665b();
        if (b != null) {
            this.f9944d.addNativeView(b);
        }
        if (dIDILocation == null) {
            this.f9947g.select_lat = 0.0f;
            this.f9947g.select_lng = 0.0f;
            this.f9947g.user_loc_accuracy = 0.0f;
            this.f9947g.user_loc_provider = "";
        } else {
            this.f9947g.select_lat = (float) dIDILocation.getLatitude();
            this.f9947g.select_lng = (float) dIDILocation.getLongitude();
            this.f9947g.user_loc_accuracy = dIDILocation.getAccuracy();
            this.f9947g.user_loc_provider = dIDILocation.getProvider();
        }
        this.f9947g.page_state = this.f9948h;
        this.f9947g.station_switch = m8670d();
    }

    /* renamed from: b */
    private void m8667b(DIDILocation dIDILocation, Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("initXBanner location");
        sb.append(dIDILocation == null ? "null" : " not null");
        GLog.m11354d(TAG, sb.toString());
        this.f9947g = new BizParams();
        if (dIDILocation == null) {
            dIDILocation = LocationController.getInstance().getLastKnownLocation(this.f9950j);
        }
        XBannerNativeView b = m8665b();
        if (b != null) {
            this.f9944d.addNativeView(b);
        }
        if (dIDILocation == null) {
            this.f9947g.select_lat = 0.0f;
            this.f9947g.select_lng = 0.0f;
            this.f9947g.user_loc_accuracy = 0.0f;
            this.f9947g.user_loc_provider = "";
        } else {
            this.f9947g.select_lat = (float) dIDILocation.getLatitude();
            this.f9947g.select_lng = (float) dIDILocation.getLongitude();
            this.f9947g.user_loc_accuracy = dIDILocation.getAccuracy();
            this.f9947g.user_loc_provider = dIDILocation.getProvider();
        }
        this.f9947g.page_state = this.f9948h;
        this.f9947g.station_switch = m8670d();
        this.f9944d.initXBanner(activity, "home", this.f9947g, new XBannerCallback() {
            public void onSuccess(JsonObject jsonObject) {
                boolean unused = HomeGlobalXBannerPresenter.this.f9945e = true;
                if (HomeGlobalXBannerPresenter.this.f9949i != null) {
                    HomeGlobalXBannerPresenter.this.f9949i.onSuccess(jsonObject);
                }
            }

            public void onFail(Exception exc) {
                if (HomeGlobalXBannerPresenter.this.f9949i != null) {
                    HomeGlobalXBannerPresenter.this.f9949i.onFail(exc);
                }
            }
        });
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        GLog.m11354d(TAG, qttqtt.br00720072007200720072);
        if (GlobalApolloUtil.isHomeEngine()) {
            if (!this.f9946f) {
                m8662a(dIDILocation, this.f9950j);
                m8669c();
                this.f9946f = true;
                return;
            }
            LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
            if (DDSphericalUtil.computeDistanceBetween(this.f9956q, latLng) > this.f9957r) {
                this.f9956q = latLng;
                GLog.m11354d(TAG, "refreshXBannerR onLocationChanged");
                m8661a(dIDILocation, this.f9948h);
            }
        } else if (!this.f9946f) {
            m8667b(dIDILocation, this.f9950j);
            this.f9946f = true;
        } else {
            LatLng latLng2 = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
            if (DDSphericalUtil.computeDistanceBetween(this.f9956q, latLng2) > this.f9957r) {
                this.f9956q = latLng2;
                GLog.m11354d(TAG, "refreshXBanner onLocationChanged");
                m8657a(this.f9948h);
            }
        }
    }

    /* renamed from: c */
    private void m8669c() {
        XEngineReq.simpleRequest(XERequestKey.SCENE_HOME, XERequestKey.REQUEST_KEY_XBANNER);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8661a(DIDILocation dIDILocation, int i) {
        this.f9948h = i;
        if (this.f9944d != null) {
            if (!this.f9945e) {
                m8662a(dIDILocation, this.f9950j);
            } else {
                m8660a(dIDILocation);
            }
            m8669c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8657a(int i) {
        if (FormStore.getInstance().isOrderBan() || FormStore.getInstance().isSafetyTrain()) {
            this.f9948h = 1;
        } else if (!BusinessUtils.isMisInvalid(this.f9951k)) {
            if (i == 5 || (i == -1 && this.f9948h == 5)) {
                this.f9948h = 5;
            } else {
                this.f9948h = 0;
            }
        } else if (!SecondConfProxy.getInstance().isCityOpen(this.f9951k.getBusinessGroupType())) {
            this.f9948h = 2;
        } else {
            BusinessContext businessContext = this.f9951k;
            if (businessContext == null || !BusinessUtils.isPreHeat(businessContext)) {
                this.f9948h = 4;
            } else {
                this.f9948h = 3;
            }
        }
        if (this.f9944d == null) {
            return;
        }
        if (!this.f9945e) {
            m8667b((DIDILocation) null, this.f9950j);
            return;
        }
        XBannerNativeView b = m8665b();
        this.f9947g.page_state = this.f9948h;
        this.f9944d.reloadXBannerAndNativeCheck(this.f9949i, "home", this.f9947g, b);
    }
}
