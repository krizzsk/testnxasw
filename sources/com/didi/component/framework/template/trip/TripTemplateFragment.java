package com.didi.component.framework.template.trip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.util.Supplier;
import androidx.core.view.GravityCompat;
import com.didi.app.SchemeDispatcherImpl;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.TripSwitchSceneEvent;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.animator.GlobalXPanelAnimatorWithAlphaImpl;
import com.didi.component.common.animator.IGlobalXPanelAnimator;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.cache.CacheApolloUtils;
import com.didi.component.common.model.PermissionResults;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.UIUtils;
import com.didi.component.confirmupdateaddress.OnServiceUpdateAddressComponent;
import com.didi.component.confirmupdateaddress.view.IUpdateAddress;
import com.didi.component.core.IComponent;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.framework.template.TemplateUtils;
import com.didi.component.framework.template.common.CommonTemplateFragment;
import com.didi.component.framework.template.common.CommonTemplatePresenter;
import com.didi.component.framework.template.endservice.EndServiceTemplatePresenter;
import com.didi.component.framework.template.trip.scene.EndServiceCompScene;
import com.didi.component.framework.template.trip.scene.ICompScene;
import com.didi.component.framework.template.trip.scene.OnServiceCompScene;
import com.didi.component.framework.template.trip.scene.WaitCompScene;
import com.didi.component.framework.template.trip.view.PayNoPsdView;
import com.didi.component.framework.util.TripApolloUtils;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.ComponentConfigManager;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMView;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.LockScreenUtilKt;
import com.didi.sdk.util.SPUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didiglobal.enginecore.data.model.XEDataHandleModel;
import com.didiglobal.travel.biz.ride.CarOrderUtils;
import com.didiglobal.travel.biz.ride.strategy.WaitRspBehaviorStrategy;
import com.didiglobal.travel.biz.ride.trip.TripBehaviorController;
import com.didiglobal.travel.util.Preconditions;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class TripTemplateFragment extends CommonTemplateFragment {
    public static final String DELIVERY_LIMIT_KEY = "delivery_limit";
    public static final int DELIVERY_LIMIT_MAX = 5;
    public static final String DELIVERY_PLACE_STRING = "{{product_name}}";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f15819c = TripTemplateFragment.class.getSimpleName();

    /* renamed from: d */
    private static final int f15820d = 20000;

    /* renamed from: a */
    int f15821a = -1;

    /* renamed from: b */
    EndServiceTemplatePresenter f15822b;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f15823e = -1;

    /* renamed from: f */
    private ICompScene f15824f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public RelativeLayout f15825g;

    /* renamed from: h */
    private FrameLayout f15826h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public PayNoPsdView f15827i;

    /* renamed from: j */
    private boolean f15828j = true;

    /* renamed from: k */
    private PayTimeoutHandler f15829k;

    /* renamed from: l */
    private XEDataHandleModel f15830l;

    /* renamed from: m */
    private IComponent f15831m;

    /* renamed from: n */
    private IComponent f15832n;

    /* renamed from: o */
    private ViewGroup f15833o;

    /* renamed from: p */
    private BaseEventPublisher.OnEventListener<Boolean> f15834p = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (bool.booleanValue()) {
                TripTemplateFragment.this.showFlex();
                TripTemplateFragment.this.mLogger.info("lxslxs: showFlex", new Object[0]);
                return;
            }
            TripTemplateFragment.this.hideFlex();
            TripTemplateFragment.this.mLogger.info("lxslxs: hideFlex", new Object[0]);
        }
    };

    /* renamed from: q */
    private BaseEventPublisher.OnEventListener<TripSwitchSceneEvent> f15835q = new BaseEventPublisher.OnEventListener<TripSwitchSceneEvent>() {
        public void onEvent(String str, TripSwitchSceneEvent tripSwitchSceneEvent) {
            if (tripSwitchSceneEvent != null && tripSwitchSceneEvent.scene != -1) {
                if (!(tripSwitchSceneEvent.bundle == null || TripTemplateFragment.this.f15822b == null)) {
                    TripTemplateFragment.this.f15822b.setArguments(tripSwitchSceneEvent.bundle);
                }
                if (!tripSwitchSceneEvent.waitXpanelEvent) {
                    int unused = TripTemplateFragment.this.f15823e = tripSwitchSceneEvent.scene;
                    TripTemplateFragment.this.f15821a = -1;
                    TripTemplateFragment tripTemplateFragment = TripTemplateFragment.this;
                    tripTemplateFragment.m13125a(tripTemplateFragment.f15823e, TripTemplateFragment.this.f15825g, true);
                    TripTemplateFragment.this.mLogger.info("lxslxs: loadComponentsByScene", new Object[0]);
                    return;
                }
                GLog.m11354d(TripTemplateFragment.f15819c, "switch scene wait xpanel");
                TripTemplateFragment.this.f15821a = tripSwitchSceneEvent.scene;
                TripTemplateFragment.this.m13124a(1000);
            }
        }
    };

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 1040;
    }

    /* access modifiers changed from: protected */
    public int currentVersionCode() {
        return 2;
    }

    public int getRootLayout() {
        return R.layout.global_fragment_trip_new;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == SctxBTMView.Companion.getBLE_REQUEST_CODE()) {
            PermissionResults permissionResults = new PermissionResults();
            permissionResults.permissions = strArr;
            permissionResults.results = iArr;
            permissionResults.requestCode = i;
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_PERMISSION_RESULT, permissionResults);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f15823e = arguments.getInt(BaseExtras.Trip.EXTRA_TRIP_SCENE, -1);
            if (arguments.getSerializable(BaseExtras.Common.EXTRA_GETON_TO_RSP) instanceof XEDataHandleModel) {
                this.f15830l = (XEDataHandleModel) arguments.getSerializable(BaseExtras.Common.EXTRA_GETON_TO_RSP);
            }
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Home.EVENT_HIDE_HOME_NEW_USER_GUIDE, true);
        m13132b();
    }

    /* renamed from: b */
    private void m13132b() {
        OrderFloatWindowManager.Instance().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Intent intent = new Intent(DIDIApplication.getAppContext(), SchemeDispatcherImpl.class);
                intent.addFlags(268435456);
                DIDIApplication.getAppContext().startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStartImpl() {
        super.onStartImpl();
        m13136c();
        if (this.f15828j) {
            m13140e();
            this.f15828j = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onStopImpl() {
        super.onStopImpl();
    }

    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        m13138d();
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f15828j = true;
        return super.onCreateViewImpl(layoutInflater, viewGroup, bundle);
    }

    /* access modifiers changed from: protected */
    public void initComponents(RelativeLayout relativeLayout) {
        this.f15825g = relativeLayout;
        m13126a(requireContext());
        int i = this.f15823e;
        if (i != -1) {
            m13125a(i, relativeLayout, false);
        }
    }

    /* access modifiers changed from: protected */
    public CommonTemplatePresenter onCreateTopPresenter() {
        EndServiceTemplatePresenter endServiceTemplatePresenter = new EndServiceTemplatePresenter(getBusinessContext(), getArguments());
        this.f15822b = endServiceTemplatePresenter;
        return endServiceTemplatePresenter;
    }

    public int currentScene() {
        return this.f15823e;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() != R.id.global_title_btn_back) {
            return;
        }
        if ("sodaEntrega".equals(ConfProxy.getInstance().getSelectedType())) {
            if (this.mTopPresenter != null) {
                ((CommonTemplatePresenter) this.mTopPresenter).dispatchBackPressed(IPresenter.BackType.TopLeft);
            }
            CarOrderHelper.saveOrder((CarOrder) null);
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_CLEAR_MAP_SCENE);
            DRouter.build(NationTypeUtil.getNationComponentData().getProductPreFix() + "OneTravel://sodaEntrega/homePage?noSwitchTab=1").start();
        } else if (this.mTopPresenter != null) {
            ((CommonTemplatePresenter) this.mTopPresenter).dispatchBackPressed(IPresenter.BackType.TopLeft);
        }
    }

    /* access modifiers changed from: protected */
    public int getComboType() {
        if (this.f15823e != 10401) {
            return super.getComboType();
        }
        int currentComboType = FormStore.getInstance().getCurrentComboType();
        if (currentComboType != 4 || !FormStore.getInstance().isTwoPriceBiz()) {
            return currentComboType;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int currentComboType() {
        if (this.f15823e != 10401) {
            return super.currentComboType();
        }
        Bundle arguments = getArguments();
        int currentComboType = BusinessUtils.getCurrentComboType(CarOrderHelper.getOrder(), arguments != null ? arguments.getBoolean(BaseExtras.ConfirmService.EXTRA_SEND_ORDER_IN_WAIT_RSP_PAGE, false) : false);
        Logger logger = this.mLogger;
        logger.info("WaitRspTemplateFragment#comboType:" + currentComboType, new Object[0]);
        return currentComboType;
    }

    /* access modifiers changed from: protected */
    public Animator offerExitAnimation() {
        boolean z;
        if (this.f15825g != null) {
            IGlobalXPanelAnimator iGlobalXPanelAnimator = this.mGlobalXpanelAnimator;
            if (this.f15823e == 10401) {
                iGlobalXPanelAnimator = new GlobalXPanelAnimatorWithAlphaImpl();
                z = CacheApolloUtils.openWaitRspOptimization();
            } else {
                z = false;
            }
            TemplateUtils.toggleBottomInOut(iGlobalXPanelAnimator, false, (View) this.f15825g, (IGlobalXPanelAnimator.VisibilityChangedListener) null, z);
        }
        return null;
    }

    /* renamed from: a */
    private void m13126a(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(UIUtils.dip2pxInt(context, 70.0f), (int) (((float) AppUtils.getStatusBarHeight(context)) + UIUtils.dip2px(context, 15.0f)), UIUtils.dip2pxInt(context, 10.0f), 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        OnServiceUpdateAddressComponent onServiceUpdateAddressComponent = (OnServiceUpdateAddressComponent) inflateComponent(ComponentType.ON_SERVICE_UPDATE_ADDRESS, this.f15825g, layoutParams);
        IUpdateAddress iUpdateAddress = Preconditions.nonNull(onServiceUpdateAddressComponent) ? (IUpdateAddress) onServiceUpdateAddressComponent.getView() : null;
        if (Preconditions.nonNull(iUpdateAddress)) {
            iUpdateAddress.setViewVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        inflateViewlessComponents(ComponentType.PAGE_DATA);
        inflateViewlessComponent(ComponentType.GLOBAL_XENGINE, (Bundle) null);
        inflateViewlessComponent(ComponentType.GLOBAL_X_ENGINE_ORDER_DETAIL_COMPAT, (Bundle) null);
        inflateViewlessComponent("config", (Bundle) null);
        inflateComponent(ComponentType.NEW_XPANEL, this.f15825g, layoutParams2);
        inflateComponent("message", this.f15825g, layoutParams2);
        m13133b(context);
    }

    /* renamed from: b */
    private void m13133b(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        PayNoPsdView payNoPsdView = new PayNoPsdView(context);
        this.f15827i = payNoPsdView;
        payNoPsdView.setLayoutParams(layoutParams);
        if (this.f15827i.getParent() != null) {
            this.f15825g.removeView(this.f15827i);
        }
        this.f15825g.addView(this.f15827i);
        this.f15827i.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13125a(int i, RelativeLayout relativeLayout, boolean z) {
        Logger logger = LoggerFactory.getLogger(f15819c);
        boolean z2 = false;
        logger.info("loadComponentsByScene:" + i, new Object[0]);
        if (Preconditions.nonNull(this.f15824f)) {
            this.f15824f.unLoadComponents();
            if (this.f15831m != null) {
                generateComponentCreator().removeComponent(this.f15831m);
            }
            if (this.f15832n != null) {
                generateComponentCreator().removeComponent(this.f15832n);
            }
        }
        boolean z3 = true;
        switch (i) {
            case 10401:
                this.f15824f = new WaitCompScene(getContext(), generateComponentCreator());
                GGKConfigManager.requestConfig(getActivity(), m13123a(ComponentConfigManager.BUSINESS_SCENE_WAIT), ComponentConfigManager.BUSINESS_SCENE_WAIT, (String) null, "passenger_newPopup");
                WaitRspBehaviorStrategy orPutRspBehavior = TripBehaviorController.getOrPutRspBehavior(1040, (Supplier<WaitRspBehaviorStrategy>) new Supplier<WaitRspBehaviorStrategy>() {
                    public WaitRspBehaviorStrategy get() {
                        return new WaitRspBehaviorStrategy();
                    }
                });
                if (CarOrderUtils.isInBooking(getCarOrder()) || (getCarOrder() == null && FormStore.getInstance().getTransportTime() > 0)) {
                    orPutRspBehavior.setAllowBack(true);
                    z2 = true;
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = AppUtils.getStatusBarHeight(getContext());
                this.f15831m = inflateComponent(ComponentType.FLEX_LIST, this.f15826h, layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = GravityCompat.END;
                layoutParams2.topMargin = AppUtils.getStatusBarHeight(getContext());
                this.f15832n = inflateComponent(ComponentType.FLEX_OPTION, this.f15826h, layoutParams2);
                z3 = z2;
                break;
            case 10402:
                this.mLogger.info("lxslxs: hideFlex onservice", new Object[0]);
                hideFlex();
                this.f15824f = new OnServiceCompScene(getContext(), generateComponentCreator());
                if (CarOrderHelper.getOrder() != null) {
                    String str = CarOrderHelper.getOrder().substatus == 4006 ? ComponentConfigManager.BUSINESS_SCENE_ON_TRIP : ComponentConfigManager.BUSINESS_SCENE_PICK_UP;
                    GGKConfigManager.requestConfig(getActivity(), m13123a(str), str, (String) null, "passenger_newPopup");
                }
                m13142f();
                break;
            case 10403:
                hideFlex();
                this.f15824f = new EndServiceCompScene(getContext(), generateComponentCreator());
                GGKConfigManager.requestConfig(getActivity(), m13123a(ComponentConfigManager.BUSINESS_SCENE_END), ComponentConfigManager.BUSINESS_SCENE_END, (String) null, "passenger_newPopup");
                break;
        }
        if (!Preconditions.isNull(this.f15824f)) {
            Bundle arguments = getArguments();
            if (Preconditions.nonNull(arguments)) {
                arguments.putBoolean(IGroupView.BACK_VISIBILITY, z3);
            }
            m13127a(relativeLayout, z3, z);
        }
    }

    /* renamed from: a */
    private Map<String, Object> m13123a(String str) {
        String str2;
        String str3 = CarOrderHelper.getOrder() != null ? CarOrderHelper.getOrder().oid : "";
        HashMap hashMap = new HashMap();
        hashMap.put("oid", str3);
        if (str.equals(ComponentConfigManager.BUSINESS_SCENE_PICK_UP)) {
            hashMap.put("has_overlay_permission", Boolean.valueOf(LockScreenUtilKt.hasOverlayPermission(getActivity())));
            if (AppUtils.isBrazilApp(getContext())) {
                str2 = getContext().getString(R.string.app_name_99);
            } else {
                str2 = getContext().getString(R.string.app_name_global);
            }
            hashMap.put("app_name", str2);
        }
        return hashMap;
    }

    /* renamed from: c */
    private void m13136c() {
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Service.Trip.EVENT_TRIP_SCENE_SWITCH, this.f15835q);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.WaitRsp.EVENT_TRIP_SHOW_OR_HIDE_FLEX, this.f15834p);
    }

    /* renamed from: d */
    private void m13138d() {
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Service.Trip.EVENT_TRIP_SCENE_SWITCH, this.f15835q);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.WaitRsp.EVENT_TRIP_SHOW_OR_HIDE_FLEX, this.f15834p);
    }

    public View getFallbackView() {
        return this.f15833o;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13124a(int i) {
        if (this.f15821a != -1) {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    if (TripTemplateFragment.this.isAdded() && TripTemplateFragment.this.f15821a != -1) {
                        TripTemplateFragment tripTemplateFragment = TripTemplateFragment.this;
                        int unused = tripTemplateFragment.f15823e = tripTemplateFragment.f15821a;
                        TripTemplateFragment tripTemplateFragment2 = TripTemplateFragment.this;
                        tripTemplateFragment2.m13125a(tripTemplateFragment2.f15823e, TripTemplateFragment.this.f15825g, true);
                        TripTemplateFragment.this.mLogger.info("lxslxs: post loadComponentsByScene", new Object[0]);
                        TripTemplateFragment.this.f15821a = -1;
                    }
                }
            }, (long) i);
        }
    }

    /* renamed from: a */
    private void m13127a(RelativeLayout relativeLayout, boolean z, boolean z2) {
        setBackVisible(z);
        this.f15824f.loadComponents(relativeLayout);
        if (z2) {
            m13140e();
        }
    }

    /* renamed from: e */
    private void m13140e() {
        CarOrder order = CarOrderHelper.getOrder();
        if (!Preconditions.isNull(order) && !TextUtils.isEmpty(order.oid)) {
            if (Preconditions.isNull(this.f15830l)) {
                XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
                return;
            }
            JsonObject nextActionJsonObject = this.f15830l.getNextActionJsonObject();
            if (Preconditions.nonNull(nextActionJsonObject)) {
                XEngineReq.engineDispatch(nextActionJsonObject, XERequestKey.SCENE_TRIP);
            }
            String nextAction = this.f15830l.getNextAction();
            if (!TextUtils.isEmpty(nextAction)) {
                DRouter.build(nextAction).start();
            }
            this.f15830l = null;
        }
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        super.initViews();
        this.f15826h = (FrameLayout) this.mRootView.findViewById(R.id.flex_driver_container);
        int statusBarHeight = AppUtils.getStatusBarHeight(getContext());
        ViewGroup.LayoutParams layoutParams = this.mTitleBackBtn.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = statusBarHeight;
            this.mTitleBackBtn.setLayoutParams(layoutParams);
        }
        ViewGroup viewGroup = (ViewGroup) this.mRootView.findViewById(R.id.trip_loading_layout);
        this.f15833o = viewGroup;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams2.topMargin = statusBarHeight;
        this.f15833o.setLayoutParams(layoutParams2);
    }

    public void showFlex() {
        RelativeLayout relativeLayout = this.f15825g;
        if (relativeLayout != null) {
            relativeLayout.setAlpha(0.0f);
        }
        FrameLayout frameLayout = this.f15826h;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    public void hideFlex() {
        RelativeLayout relativeLayout = this.f15825g;
        if (relativeLayout != null) {
            relativeLayout.setAlpha(1.0f);
        }
        FrameLayout frameLayout = this.f15826h;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void updatePaddingTop() {
        this.mTitleBackBtn.post(new Runnable() {
            public void run() {
                if (TripTemplateFragment.this.mTopPresenter != null) {
                    int tripMapPaddingTop = TripApolloUtils.INSTANCE.getTripMapPaddingTop();
                    GLog.m11353d("updatePaddingTop:tripMapPaddingTop:" + tripMapPaddingTop);
                    ((CommonTemplatePresenter) TripTemplateFragment.this.mTopPresenter).onPaddingTopChanged(UiUtils.dip2px(TripTemplateFragment.this.getContext(), (float) tripMapPaddingTop));
                }
            }
        });
    }

    public void setBackVisible(boolean z) {
        super.setBackVisible(z);
        updatePaddingTop();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if ("sodaEntrega".equals(ConfProxy.getInstance().getSelectedType())) {
            CarOrderHelper.saveOrder((CarOrder) null);
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_CLEAR_MAP_SCENE);
            DRouter.build(NationTypeUtil.getNationComponentData().getProductPreFix() + "OneTravel://sodaEntrega/homePage?noSwitchTab=1").start();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: f */
    private void m13142f() {
        int intValue = ((Integer) SPUtils.get(getContext(), DELIVERY_LIMIT_KEY, 0)).intValue();
        if (intValue < 5 && CarOrderHelper.getOrder() != null && !TextUtils.isEmpty(CarOrderHelper.getOrder().toastData)) {
            final ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.vs_title_tips_guide);
            try {
                View inflate = viewStub.inflate();
                ((TextView) inflate.findViewById(R.id.tv_title_guide_text)).setText(CarOrderHelper.getOrder().toastData.replace(DELIVERY_PLACE_STRING, NationTypeUtil.getNationComponentData().getBrand()));
                inflate.findViewById(R.id.iv_title_guide_close).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        SPUtils.put(TripTemplateFragment.this.getContext(), TripTemplateFragment.DELIVERY_LIMIT_KEY, 5);
                        ViewStub viewStub = viewStub;
                        if (viewStub != null) {
                            viewStub.setVisibility(8);
                        }
                        GlobalOmegaUtils.trackEvent("ibt_gp_tripservice_deliverymultiple_close_ck");
                    }
                });
                SPUtils.put(getContext(), DELIVERY_LIMIT_KEY, Integer.valueOf(intValue + 1));
            } catch (Exception e) {
                e.printStackTrace();
                if (viewStub != null) {
                    viewStub.setVisibility(0);
                }
            }
            GlobalOmegaUtils.trackEvent("ibt_gp_tripservice_deliverymultiple_sw");
        }
    }

    public void showPayProcessLoading() {
        if (this.f15827i.getVisibility() != 0) {
            float dip2px = (float) UiUtils.dip2px(getContext(), 51.5f);
            this.f15827i.setTranslationY(dip2px);
            this.f15827i.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f15827i, "translationY", new float[]{dip2px, 0.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f15827i, "alpha", new float[]{0.0f, 1.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.start();
        }
    }

    public void showPayProcessLoading4XPanel() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_DOWN, Integer.valueOf(UiUtils.dip2px(getContext(), 51.5f)));
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_TRIP_END_DISMISS_WHEN_PAYING, true);
        m13144g();
    }

    private static class PayTimeoutHandler extends Handler {
        private final WeakReference<TripTemplateFragment> ref;

        public PayTimeoutHandler(TripTemplateFragment tripTemplateFragment) {
            this.ref = new WeakReference<>(tripTemplateFragment);
        }

        public void handleMessage(Message message) {
            if (this.ref.get() != null) {
                ((TripTemplateFragment) this.ref.get()).m13130a(true);
            }
        }
    }

    /* renamed from: g */
    private void m13144g() {
        PayTimeoutHandler payTimeoutHandler = new PayTimeoutHandler(this);
        this.f15829k = payTimeoutHandler;
        payTimeoutHandler.sendEmptyMessageDelayed(1, 20000);
    }

    public void hidePayProcessLoading() {
        super.hidePayProcessLoading();
        m13130a(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13130a(boolean z) {
        if (this.f15827i.getVisibility() == 0 || z) {
            PayTimeoutHandler payTimeoutHandler = this.f15829k;
            if (payTimeoutHandler != null) {
                payTimeoutHandler.removeCallbacksAndMessages((Object) null);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f15827i.getInnerLayout(), "translationY", new float[]{0.0f, (float) (-UiUtils.dip2px(getContext(), 51.5f))});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f15827i, "alpha", new float[]{1.0f, 0.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPANEL_HEIGHT_CHANGED_4_PAY_UP, 0);
                }

                public void onAnimationEnd(Animator animator) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_TRIP_END_DISMISS_WHEN_PAYING, false);
                    TripTemplateFragment.this.f15827i.setVisibility(8);
                }
            });
            animatorSet.setDuration(250).start();
        }
    }
}
