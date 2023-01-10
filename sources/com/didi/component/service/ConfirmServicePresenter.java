package com.didi.component.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.android.didi.bfflib.business.BffBaseObject;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.oneconfig.AbsConfirmConfigState;
import com.didi.component.business.oneconfig.NewConfirmAddressConfigState;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.tracker.flex.FlexTrack;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.core.Animations;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.service.activity.DynamicWebActivity;
import com.didi.component.service.cancelreason.cache.CancelTripCache;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKUICreator;
import com.didi.global.globalgenerickit.GGKView;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.global.globalgenerickit.config.GGKConfigCallbackAdapter;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel0;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOImgModel;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.p155ms.common.utils.LogUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.p172v2.session.Scene;
import com.didi.travel.p172v2.util.LogUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.listener.DefaultDiDiCoreCallback;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.NextPayResult;
import com.didi.travel.psnger.model.response.NextTotalFeeDetail;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarPayModel;
import com.didi.travel.psnger.model.response.estimate.CarBreakConfirmBlockInfoModel;
import com.didi.travel.psnger.model.response.estimate.CarBreakMemberModel;
import com.didi.travel.psnger.model.response.estimate.CarBreakModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.p171v2.TravelUtil;
import com.didiglobal.enginecore.data.model.XEDataHandleModel;
import com.didiglobal.travel.util.CollectionUtils;
import com.didiglobal.travel.util.Preconditions;
import com.taxis99.R;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfirmServicePresenter extends AbsSendOrderServicePresenter implements AbsConfirmConfigState.IConfirmConfigCallback {

    /* renamed from: b */
    private static final String f17466b = "ConfirmServicePresenter";

    /* renamed from: s */
    private static final int f17467s = 101;

    /* renamed from: c */
    private boolean f17468c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f17469d;

    /* renamed from: e */
    private boolean f17470e;

    /* renamed from: f */
    private AbsConfirmConfigState f17471f;

    /* renamed from: g */
    private GGKDrawer f17472g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LEGODrawer f17473h;

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17474i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f17475j;

    /* renamed from: k */
    private BaseEventPublisher.OnEventListener<XEDataHandleModel> f17476k;

    /* renamed from: l */
    private BaseEventPublisher.OnEventListener<DTSDKOrderStatus> f17477l;

    /* renamed from: m */
    private BaseEventPublisher.OnEventListener<String> f17478m;
    protected boolean mIsSendOrderInWaitRspPage;
    protected final Logger mLogger;
    public long memberShipDrawerStartTime;
    public String offerPriceJsonString;

    /* renamed from: r */
    private BaseEventPublisher.OnEventListener<String> f17479r;

    /* renamed from: t */
    private BaseEventPublisher.OnEventListener<Object> f17480t;

    /* renamed from: u */
    private final DefaultDiDiCoreCallback f17481u;

    /* renamed from: v */
    private final BaseEventPublisher.OnEventListener<Boolean> f17482v;

    /* renamed from: w */
    private final BaseEventPublisher.OnEventListener<Boolean> f17483w;

    /* renamed from: x */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17484x;

    /* renamed from: y */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17485y;

    /* renamed from: z */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17486z;

    public static class OrderCreateErrorCode {
        public static final int ERROR_CODE_AIRPORT_INTERCEPTOR = 1154;
        public static final int ERROR_CODE_BOOKING_NOSUPPORTED = 1133;
        public static final int ERROR_CODE_CARPOOLING_TIME_LIMIT = 1047;
        public static final int ERROR_CODE_CASH_FENCE = 1060;
        public static final int ERROR_CODE_CASH_UNPAY = 1134;
        public static final int ERROR_CODE_CLEAN_FEE = 1136;
        public static final int ERROR_CODE_CREATE_ORDER_FAIL_NEED_REFRESH_ESTIMATE = 10625;
        public static final int ERROR_CODE_DELIVERY_ORDER_LIMIT = 20077;
        public static final int ERROR_CODE_DYNAMIC_PRICE_EXPIRED = 1102;
        public static final int ERROR_CODE_ESTIMATE_EXPIRED = 1123;
        public static final int ERROR_CODE_EXPRESS_NOT_SUPPORT = 1039;
        public static final int ERROR_CODE_HAVE_ORDER_TO_PAY = 1020;
        public static final int ERROR_CODE_HIGHWAY_FEE = 1137;
        public static final int ERROR_CODE_NEED_ADD_CARD = 1128;
        public static final int ERROR_CODE_NEED_CPF_CHECK = 20011;
        public static final int ERROR_CODE_NEED_FACE_RECOGNIZE = 1058;
        public static final int ERROR_CODE_NEED_RG_CHECK = 1059;
        public static final int ERROR_CODE_NEED_SAFETY_AUTH = 1127;
        public static final int ERROR_CODE_NEED_VERIFY_CARD = 1055;
        public static final int ERROR_CODE_NO_SERVICE_CURRENT = 1016;
        public static final int ERROR_CODE_ORDER_BAN = 1135;
        public static final int ERROR_CODE_ORDER_CONFLICT = 1053;
        public static final int ERROR_CODE_ORDER_VAMOS_CONFLICT = 1144;
        public static final int ERROR_CODE_RISK_BLOCK = 20010;
        public static final int ERROR_CODE_SPLITFARE_ERROR = 30001;
    }

    /* access modifiers changed from: protected */
    public boolean interceptFixPrice() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void trackEventCreateOrder() {
    }

    public boolean gotoOfferPrice() {
        doPublish(BaseEventKeys.Service.SendOrder.EVENT_OFFER_PRICE_DIALOG);
        return true;
    }

    public ConfirmServicePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mLogger = LoggerFactory.getLogger(getClass());
        this.f17468c = false;
        this.f17469d = false;
        this.f17470e = false;
        this.mIsSendOrderInWaitRspPage = false;
        this.memberShipDrawerStartTime = System.currentTimeMillis();
        this.f17474i = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                if (BaseEventKeys.Service.SendOrder.EVENT_REQUEST_SEND_ORDER.equals(str)) {
                    FormStore instance = FormStore.getInstance();
                    if (instance.getDepartureAddress() != null) {
                        instance.setStartAddress(instance.getDepartureAddress(), false);
                    }
                    ConfirmServicePresenter.this.onSendOrderRequestAction();
                }
            }
        };
        this.f17475j = false;
        this.f17476k = new BaseEventPublisher.OnEventListener<XEDataHandleModel>() {
            public void onEvent(String str, XEDataHandleModel xEDataHandleModel) {
                if (xEDataHandleModel != null && !ConfirmServicePresenter.this.f17475j) {
                    GLog.m11354d("minibusOrderStatus", "forwardOnService");
                    ConfirmServicePresenter.this.doPublish(BaseEventKeys.Confirm.EVENT_CONFORM_HIDE_START_END_LOADING);
                    ConfirmServicePresenter.this.m14768a(xEDataHandleModel);
                    boolean unused = ConfirmServicePresenter.this.f17475j = true;
                }
            }
        };
        this.f17477l = new BaseEventPublisher.OnEventListener<DTSDKOrderStatus>() {
            public void onEvent(String str, DTSDKOrderStatus dTSDKOrderStatus) {
                if (TextUtils.equals(str, BaseEventKeys.WaitRspNew.EVENT_ORDER_STATUS)) {
                    XEngineReq.pageRequest(XERequestKey.SCENE_CONFIRM);
                }
            }
        };
        this.offerPriceJsonString = "";
        this.f17478m = new BaseEventPublisher.OnEventListener<String>() {
            public void onEvent(String str, String str2) {
                ConfirmServicePresenter confirmServicePresenter = ConfirmServicePresenter.this;
                confirmServicePresenter.m14770a(" offerPriceJsonString +" + str2);
                ConfirmServicePresenter.this.offerPriceJsonString = str2;
            }
        };
        this.f17479r = new BaseEventPublisher.OnEventListener<String>() {
            public void onEvent(String str, String str2) {
                ConfirmServicePresenter confirmServicePresenter = ConfirmServicePresenter.this;
                confirmServicePresenter.m14770a(" gotoConfirmAddress " + str2);
                FormStore.getInstance().setFlexOfferPrice(true);
                FormStore.getInstance().setInputOfferPrice(str2);
                if (ConfirmServicePresenter.this.m14795j()) {
                    ConfirmServicePresenter.this.onSendOrderRequestAction();
                } else {
                    ConfirmServicePresenter.this.gotoConfirmAddress();
                }
            }
        };
        this.f17480t = new BaseEventPublisher.OnEventListener<Object>() {
            public void onEvent(String str, Object obj) {
                ConfirmServicePresenter.this.mLogger.info("ConfirmServicePresenter sendOrderActionReceiver", new Object[0]);
                if (!ConfirmServicePresenter.this.interceptRequestAction()) {
                    if (obj instanceof Boolean) {
                        boolean unused = ConfirmServicePresenter.this.f17469d = ((Boolean) obj).booleanValue();
                    }
                    ConfirmServicePresenter.this.onSendOrderRequestAction();
                    return;
                }
                SceneHelper.getInstance().setOrderIntercepted(true);
            }
        };
        this.f17481u = new DefaultDiDiCoreCallback() {
            public void onOrderPollTimeChange(int i) {
            }

            public void onOrderStatusChange(IOrderStatus iOrderStatus) {
                super.onOrderStatusChange(iOrderStatus);
            }

            public void onOrderStatusTimeOut() {
                GLog.m11354d("minibusOrderStatus", "onOrderStatusTimeOut");
            }

            public void onCommonMessageReceive(int i, String str) {
                GLog.m11354d("minibusOrderStatus", "onCommonMessageReceive");
            }

            public void onCarpoolInfoChange() {
                GLog.m11354d("minibusOrderStatus", "onCarpoolInfoChange");
            }

            public void onRealtimePriceRefresh(OrderRealtimePriceCount orderRealtimePriceCount) {
                GLog.m11354d("minibusOrderStatus", "onRealtimePriceRefresh");
            }

            public void onTotalFeeDetailReceive(NextTotalFeeDetail nextTotalFeeDetail) {
                GLog.m11354d("minibusOrderStatus", "onTotalFeeDetailReceive");
            }

            public void onPayResultReceive(NextPayResult nextPayResult) {
                GLog.m11354d("minibusOrderStatus", "onPayResultReceive");
            }
        };
        this.f17482v = new BaseEventPublisher.OnEventListener<Boolean>() {
            public void onEvent(String str, Boolean bool) {
                ConfirmServicePresenter.this.reEstimateSuccess(bool.booleanValue());
            }
        };
        this.f17483w = new BaseEventPublisher.OnEventListener<Boolean>() {
            public void onEvent(String str, Boolean bool) {
                ConfirmServicePresenter.this.reEstimateSuccess(false);
            }
        };
        this.f17484x = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                ConfirmServicePresenter.this.reEstimateFail();
            }
        };
        this.f17485y = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                ConfirmServicePresenter.this.reEstimateFail();
            }
        };
        this.f17486z = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                ConfirmServicePresenter.this.endReEstimate();
            }
        };
        this.mIsSendOrderInWaitRspPage = true;
    }

    /* access modifiers changed from: protected */
    public void onSubscribeEventReceiver() {
        super.onSubscribeEventReceiver();
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_ACTION_SEND_ORDER, this.f17480t);
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_SEND_ORDER, this.f17474i);
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_ENTER_CONFIRM_ADDRESS, this.f17479r);
        subscribe(BaseEventKeys.WaitRspNew.EVENT_ORDER_STATUS, this.f17477l);
        subscribe(BaseEventKeys.XEngine.EVENT_XENGINE_DATA_HANDLE, this.f17476k);
    }

    /* access modifiers changed from: protected */
    public void onUnsubscribeEventReceiver() {
        super.onUnsubscribeEventReceiver();
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_ACTION_SEND_ORDER, this.f17480t);
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_SEND_ORDER, this.f17474i);
        unsubscribe(BaseEventKeys.WaitRspNew.EVENT_ORDER_STATUS, this.f17477l);
        unsubscribe(BaseEventKeys.XEngine.EVENT_XENGINE_DATA_HANDLE, this.f17476k);
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_ENTER_CONFIRM_ADDRESS, this.f17479r);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14770a(String str) {
        this.mLogger.info(str, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        GLog.m11357e("BizLog", "Confirm onAdd");
        super.onAdd(bundle);
        boolean z = false;
        if (bundle != null) {
            this.f17468c = bundle.getBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_GET_ON_SCENE, false);
            m14771a(bundle.getBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_GET_ON_SCENE, false));
            z = bundle.getBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_REQUEST_BY_CANCEL_TRIP, false);
            String string = bundle.getString(BaseExtras.ConfirmService.EXTRA_BACK_TO_CONFIRM_TIP);
            if (!TextUtils.isEmpty(string)) {
                m14779b(string);
            }
        } else {
            m14771a(false);
        }
        GlobalOmegaUtils.removeOrderType();
        m14798m();
        m14802q();
        if (z) {
            this.f17470e = true;
            CancelTripCache.getInstance().setUsingCacheEstimateParams(true);
            onSendOrderRequestAction();
        }
        if (this.mComponentProxy.getSession() == null) {
            LogUtils.m34979e(f17466b, "onAdd:Unknown Reason, Session is null");
            this.mComponentProxy.createSession("ConfirmServicePresenter.Unknown");
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        GLog.m11357e("BizLog", "Confirm onRemove");
        dismissProgressDialog();
        AbsConfirmConfigState absConfirmConfigState = this.f17471f;
        if (absConfirmConfigState != null) {
            absConfirmConfigState.unsubscribeConfig();
        }
        m14801p();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        if (this.f17468c) {
            backConfirmPricePage();
        } else {
            m14797l();
        }
        GGKDrawer gGKDrawer = this.f17472g;
        if (gGKDrawer == null || !gGKDrawer.isShowing()) {
            return true;
        }
        this.f17472g.dismiss();
        return true;
    }

    /* renamed from: a */
    private void m14771a(boolean z) {
        AbsConfirmConfigState absConfirmConfigState = this.f17471f;
        if (absConfirmConfigState != null) {
            absConfirmConfigState.unsubscribeConfig();
        }
        if (z) {
            this.f17471f = new NewConfirmAddressConfigState(this.mBusinessContext, (AbsConfirmConfigState.IConfirmConfigCallback) null);
        }
        AbsConfirmConfigState absConfirmConfigState2 = this.f17471f;
        if (absConfirmConfigState2 != null) {
            absConfirmConfigState2.subscribeConfig();
        }
    }

    public void onNetStart() {
        showLoading();
    }

    public void onNetSuccess() {
        hideLoading();
    }

    public void onNetFail() {
        m14776b();
        GlobalOmegaUtils.trackEvent("pas_onconffailure_sw");
    }

    /* renamed from: b */
    private void m14776b() {
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(101);
        normalDialogInfo.setMessage(ResourcesHelper.getString(this.mContext, R.string.g_oneconf_fail));
        normalDialogInfo.setPositiveText(ResourcesHelper.getString(this.mContext, R.string.g_oneconf_fail_retry));
        normalDialogInfo.setNegativeText(ResourcesHelper.getString(this.mContext, R.string.g_oneconf_fail_back));
        normalDialogInfo.setCancelable(false);
        showDialog(normalDialogInfo);
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        AbsConfirmConfigState absConfirmConfigState;
        super.onDialogAction(i, i2);
        if (i == 101) {
            if (i2 == 1) {
                goBack();
            } else if (i2 == 2 && (absConfirmConfigState = this.f17471f) != null) {
                absConfirmConfigState.reGetMisConfigFromNet();
            }
        }
    }

    public void onChangeSelf() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        forward(1030, bundle);
    }

    /* renamed from: c */
    private boolean m14783c() {
        EstimateItemModel newEstimateItem;
        boolean z = false;
        if (this.f17468c || (newEstimateItem = FormStore.getInstance().getNewEstimateItem()) == null || newEstimateItem.carBreakModel == null || newEstimateItem.carBreakModel.confirmBlockInfo == null || TextUtils.isEmpty(newEstimateItem.carBreakModel.confirmBlockInfo.url)) {
            return false;
        }
        CarBreakConfirmBlockInfoModel carBreakConfirmBlockInfoModel = newEstimateItem.carBreakModel.confirmBlockInfo;
        if (carBreakConfirmBlockInfoModel != null) {
            try {
                if (!(carBreakConfirmBlockInfoModel.params == null || carBreakConfirmBlockInfoModel.params.get("is_back_home") == null || carBreakConfirmBlockInfoModel.params.get("is_back_home").getAsInt() != 1)) {
                    z = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.m29854e(f17466b, "interceptRequestAction:isBackHome data error, e = " + e);
            }
        }
        if (z) {
            m14797l();
        }
        final StringBuilder sb = new StringBuilder(carBreakConfirmBlockInfoModel.url);
        if (!(carBreakConfirmBlockInfoModel == null || carBreakConfirmBlockInfoModel.params == null || carBreakConfirmBlockInfoModel.params.size() <= 0)) {
            if (!carBreakConfirmBlockInfoModel.url.contains("?")) {
                sb.append("?");
            } else {
                sb.append(ParamKeys.SIGN_AND);
            }
            try {
                sb.append("params=");
                sb.append(URLEncoder.encode(carBreakConfirmBlockInfoModel.params.toString(), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            public void run() {
                DRouter.build(sb.toString()).start(ConfirmServicePresenter.this.mContext);
            }
        }, 100);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean interceptRequestAction() {
        Logger logger = this.mLogger;
        logger.info("ConfirmServicePresenter interceptRequestAction isConfirmAddressState=" + this.f17468c, new Object[0]);
        if (m14783c() || m14793h()) {
            return true;
        }
        if (this.f17468c) {
            return m14789f();
        }
        FormStore instance = FormStore.getInstance();
        boolean booleanData = instance.getBooleanData(FormStore.KEY_RECALL_ORDER, false);
        Logger logger2 = this.mLogger;
        logger2.info("AbsServicePresenter interceptRequestAction autoSendOrder=" + booleanData, new Object[0]);
        if (booleanData) {
            FormStore.getInstance().setData(FormStore.KEY_RECALL_ORDER, false);
            return false;
        } else if (!instance.isAddressValid()) {
            ToastHelper.showLongInfo(this.mContext, (int) R.string.car_toast_address_empty);
            return true;
        } else if (interceptBookOrder()) {
            doPublish(BaseEventKeys.Confirm.EVENT_CONFIRM_BOOK_TIME_ERROR);
            return true;
        } else if (interceptPayWay()) {
            doPublish(BaseEventKeys.Confirm.SHOW_PAYMENTS);
            this.mLogger.info("AbsServicePresenter interceptRequestAction interceptPayWay", new Object[0]);
            return true;
        } else if (m14787e() || interceptCarpoolSelectSeatCount() || m14785d()) {
            return true;
        } else {
            if (NationComponentDataUtil.isLoginNow() && !TextUtils.isEmpty(NationComponentDataUtil.getToken())) {
                return super.interceptRequestAction();
            }
            gotoLoginForResult(70);
            return true;
        }
    }

    /* renamed from: d */
    private boolean m14785d() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null) {
            return false;
        }
        if (confirmListener.getIsAnyCar()) {
            AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
            if (this.f17468c || FormStore.getInstance().isShiftSelected() || selectedSingleAnyCarItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel == null || TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.seatSelectScheme)) {
                return false;
            }
            DRouter.build(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.seatSelectScheme).start();
            return true;
        }
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (this.f17468c || FormStore.getInstance().isShiftSelected() || newEstimateItem == null || newEstimateItem.carBreakModel == null || TextUtils.isEmpty(newEstimateItem.carBreakModel.seatSelectScheme)) {
            return false;
        }
        DRouter.build(newEstimateItem.carBreakModel.seatSelectScheme).start();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        r1 = m14775a(r2.mAnyCarEstimateNetItem.carBreakModel);
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m14787e() {
        /*
            r5 = this;
            com.didi.component.business.data.form.PageCompDataTransfer r0 = com.didi.component.business.data.form.PageCompDataTransfer.getInstance()
            com.didi.component.business.data.form.listener.ConfirmListener r0 = r0.getConfirmListener()
            r1 = 0
            if (r0 == 0) goto L_0x0077
            boolean r2 = r0.getIsAnyCar()
            if (r2 == 0) goto L_0x0062
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r2 = r0.getSelectedSingleAnyCarItem()
            java.util.List r3 = r0.getSelectedAnyCarItems()
            if (r2 == 0) goto L_0x002f
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r3 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r3 = r3.carBreakModel
            if (r3 == 0) goto L_0x002e
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r1 = r1.carBreakModel
            boolean r1 = r5.m14775a((com.didi.travel.psnger.model.response.estimate.CarBreakModel) r1)
            if (r1 == 0) goto L_0x002e
            r0.setHitPreOrderItem(r2)
        L_0x002e:
            return r1
        L_0x002f:
            boolean r2 = com.didi.sdk.util.collection.CollectionUtil.isEmpty((java.util.Collection<?>) r3)
            if (r2 != 0) goto L_0x0077
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r2 = r0.getHitPreOrderItem()
            if (r2 == 0) goto L_0x003c
            return r1
        L_0x003c:
            java.util.Iterator r2 = r3.iterator()
        L_0x0040:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0061
            java.lang.Object r3 = r2.next()
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r3 = (com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel) r3
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r4 = r3.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r4 = r4.carBreakModel
            if (r4 == 0) goto L_0x0040
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r4 = r3.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r4 = r4.carBreakModel
            boolean r4 = r5.m14775a((com.didi.travel.psnger.model.response.estimate.CarBreakModel) r4)
            if (r4 == 0) goto L_0x0040
            r0.setHitPreOrderItem(r3)
            r0 = 1
            return r0
        L_0x0061:
            return r1
        L_0x0062:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r0 = r0.getNewEstimateItem()
            if (r0 == 0) goto L_0x0077
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r2 = r0.carBreakModel
            if (r2 == 0) goto L_0x0077
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r0 = r0.carBreakModel
            boolean r0 = r5.m14775a((com.didi.travel.psnger.model.response.estimate.CarBreakModel) r0)
            return r0
        L_0x0077:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.service.ConfirmServicePresenter.m14787e():boolean");
    }

    /* renamed from: a */
    private boolean m14775a(CarBreakModel carBreakModel) {
        if (this.f17468c || carBreakModel.preorderExpoInterceptInfo == null || TextUtils.isEmpty(carBreakModel.preorderExpoInterceptInfo.interceptScheme) || carBreakModel.preorderExpoInterceptInfo.show) {
            return false;
        }
        DRouter.build(carBreakModel.preorderExpoInterceptInfo.interceptScheme).start();
        carBreakModel.preorderExpoInterceptInfo.show = true;
        return true;
    }

    /* renamed from: f */
    private boolean m14789f() {
        this.mLogger.info("brz confirmsvr interceptRequestAction()", new Object[0]);
        if (interceptFixPrice()) {
            this.mLogger.info("interceptFixPrice", new Object[0]);
            return true;
        } else if (interceptBookOrder()) {
            this.mLogger.info("interceptBookOrder", new Object[0]);
            ToastHelper.showLongInfo(this.mContext, (int) R.string.car_toast_info_booktime_error);
            onBackPressed((IPresenter.BackType) null);
            return true;
        } else if (reEstimateBeforeSendOrder()) {
            return true;
        } else {
            if (!m14791g()) {
                return false;
            }
            this.mLogger.info("interceptLocationAbnormal", new Object[0]);
            return true;
        }
    }

    /* renamed from: g */
    private boolean m14791g() {
        if (FormStore.getInstance().isCarPoolLineBeforeHaveOrder()) {
            return false;
        }
        doPublish(BaseEventKeys.Service.SendOrder.EVENT_START_END_ABNORMAL);
        return true;
    }

    /* renamed from: h */
    private boolean m14793h() {
        PayWayModel.PayWayItem i = m14794i();
        if (i == null || i.expired != 1) {
            return false;
        }
        doPublish(BaseEventKeys.Service.SendOrder.EVENT_CARD_EXPIRED_INTERCEPT, i);
        return true;
    }

    /* renamed from: i */
    private PayWayModel.PayWayItem m14794i() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null) {
            if (confirmListener.getIsAnyCar()) {
                AnyCarPayModel anycarPayModel = confirmListener.getAnycarPayModel();
                if (anycarPayModel != null) {
                    return anycarPayModel.getSelectPayWayItem();
                }
            } else {
                EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
                if (estimateItem != null) {
                    return estimateItem.getSelectPayWayItem();
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean interceptCarpoolSelectSeatCount() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null) {
            return false;
        }
        if (confirmListener.getIsAnyCar()) {
            AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
            if (selectedSingleAnyCarItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.carBreakSeat == null || !CollectionUtils.isNotEmpty((Collection<?>) selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.carBreakSeat.seatBreakChoice) || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig == null || TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.uniqueId) || FormStore.getInstance().getIsSeatConfirmDialogShowed(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.uniqueId)) {
                return false;
            }
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_COMBO_SELECT_SEAT_SHOW);
            return true;
        }
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            if (newEstimateItem.isOperationContainsTwoPrice()) {
                if (!FormStore.getInstance().isTwoPriceBiz() || FormStore.getInstance().isTwoPriceSeatConfirm()) {
                    return false;
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_TWO_PRICE_SELECT_SEAT_SHOW);
                return true;
            } else if (newEstimateItem.carBreakModel != null && newEstimateItem.carBreakModel.carBreakSeat != null && CollectionUtils.isNotEmpty((Collection<?>) newEstimateItem.carBreakModel.carBreakSeat.seatBreakChoice) && newEstimateItem.carConfig != null && !TextUtils.isEmpty(newEstimateItem.carConfig.uniqueId) && !FormStore.getInstance().getIsSeatConfirmDialogShowed(newEstimateItem.carConfig.uniqueId)) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_COMBO_SELECT_SEAT_SHOW);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 70) {
            if (i == 71 && i2 == -1 && intent != null) {
                int intExtra = intent.getIntExtra(DynamicWebActivity.KEY_CLICK_RESULT, 0);
                Logger logger = this.mLogger;
                logger.info("result = " + intExtra, new Object[0]);
                if (intExtra == 1) {
                    onSendOrderRequestAction();
                    buildDYEstimateShow("dypricesec_ok_ck");
                } else if (intExtra == 2) {
                    buildDYEstimateShow("dypricesec_wait_ck");
                }
            }
        } else if (i2 == -1) {
            this.mLogger.info("login success, getstimate", new Object[0]);
            doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
        }
    }

    /* access modifiers changed from: protected */
    public void onSendOrderRequestAction() {
        Logger logger = this.mLogger;
        logger.info("onSendOrderRequestAction isConfirmAddressState=" + this.f17468c, new Object[0]);
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null && confirmListener.getIsAnyCar() && m14795j()) {
            AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
            if (selectedSingleAnyCarItem != null && selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig != null && selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.carBussinessId == 21070 && (selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel == null || TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.offer_flex_price_scheme))) {
                FlexTrack.track(FlexTrack.FlexEvent.sFlexMonitorEventId, 4);
            }
            if (selectedSingleAnyCarItem != null && selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel != null && !TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.offer_flex_price_scheme) && TextUtils.isEmpty(FormStore.getInstance().getInputOfferPrice())) {
                this.mLogger.info("onSendOrderRequestAction inputprice is empty", new Object[0]);
                if (!gotoOfferPrice()) {
                    onSendOrderRequestAction();
                    return;
                }
                return;
            }
        }
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null && newEstimateItem.carConfig != null && m14795j() && newEstimateItem.carConfig.carBussinessId == 21070 && (newEstimateItem.carBreakModel == null || TextUtils.isEmpty(newEstimateItem.carBreakModel.offer_flex_price_scheme))) {
            FlexTrack.track(FlexTrack.FlexEvent.sFlexMonitorEventId, 4);
        }
        if (newEstimateItem != null && newEstimateItem.carBreakModel != null && !TextUtils.isEmpty(newEstimateItem.carBreakModel.offer_flex_price_scheme) && m14795j() && TextUtils.isEmpty(FormStore.getInstance().getInputOfferPrice())) {
            this.mLogger.info("onSendOrderRequestAction inputprice is empty", new Object[0]);
            if (!gotoOfferPrice()) {
                onSendOrderRequestAction();
            }
        } else if (m14795j()) {
            this.f17469d = false;
            this.f17470e = false;
            this.mLogger.info("onSendOrderRequestAction CREATE_ORDER_FIRST", new Object[0]);
            createOrder(0);
            trackEventCreateOrder();
        } else {
            onFirstConfirm();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public boolean m14795j() {
        return this.f17470e || this.f17468c || this.f17469d || FormStore.getInstance().isFromOpenRide();
    }

    /* access modifiers changed from: protected */
    public void onFirstConfirm() {
        this.mLogger.info("onFirstConfirm ", new Object[0]);
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || !confirmListener.getIsAnyCar()) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem != null && newEstimateItem.carConfig != null && newEstimateItem.carConfig.carBussinessId == 21070 && (newEstimateItem.carBreakModel == null || TextUtils.isEmpty(newEstimateItem.carBreakModel.offer_flex_price_scheme))) {
                FlexTrack.track(FlexTrack.FlexEvent.sFlexMonitorEventId, 4);
            }
            if (newEstimateItem == null || newEstimateItem.carBreakModel == null || TextUtils.isEmpty(newEstimateItem.carBreakModel.offer_flex_price_scheme)) {
                if (newEstimateItem == null || newEstimateItem.carBreakModel == null || newEstimateItem.carBreakModel.carBreakMember == null || newEstimateItem.carConfig == null || FormStore.getInstance().isEstimatePassConfirm()) {
                    gotoConfirmAddress();
                } else {
                    m14767a(newEstimateItem);
                }
            } else if (!gotoOfferPrice()) {
                gotoConfirmAddress();
            }
        } else {
            AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
            List<AnyCarEstimateItemModel> selectedAnyCarItems = confirmListener.getSelectedAnyCarItems();
            if (selectedSingleAnyCarItem != null && selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig != null && selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.carBussinessId == 21070 && (selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel == null || TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.offer_flex_price_scheme))) {
                FlexTrack.track(FlexTrack.FlexEvent.sFlexMonitorEventId, 4);
            }
            if (selectedSingleAnyCarItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel == null || TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.offer_flex_price_scheme)) {
                if (selectedSingleAnyCarItem == null && !CollectionUtil.isEmpty((Collection<?>) selectedAnyCarItems)) {
                    for (AnyCarEstimateItemModel next : selectedAnyCarItems) {
                        if (next.mAnyCarEstimateNetItem.carBreakModel != null && next.mAnyCarEstimateNetItem.carBreakModel.carBreakMember != null && next.mAnyCarEstimateNetItem.carConfig != null && !FormStore.getInstance().isEstimatePassConfirm()) {
                            m14766a(next);
                            return;
                        }
                    }
                }
                gotoConfirmAddress();
            } else if (!gotoOfferPrice()) {
                gotoConfirmAddress();
            }
        }
    }

    /* renamed from: b */
    private void m14779b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f17473h = LEGOUICreator.showDrawerTemplate(this.mContext, new LEGODrawerModel1(str, new LEGOBtnTextAndCallback(ResourcesHelper.getString(this.mContext, R.string.GRider_page_Determination_yMCk), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    ConfirmServicePresenter.this.f17473h.dismiss();
                }
            })));
        }
    }

    /* renamed from: a */
    private void m14767a(final EstimateItemModel estimateItemModel) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        this.memberShipDrawerStartTime = System.currentTimeMillis();
        final CarBreakMemberModel carBreakMemberModel = estimateItemModel.carBreakModel.carBreakMember;
        if (carBreakMemberModel.passengerNewSheet != null) {
            try {
                JSONObject jSONObject = new JSONObject(carBreakMemberModel.passengerNewSheet.toString());
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (!(optJSONArray == null || (optJSONObject = optJSONArray.getJSONObject(0).optJSONObject("normal")) == null || (optJSONObject2 = optJSONObject.optJSONObject("data")) == null)) {
                    if (optJSONObject2.optInt("buy_type") == 1) {
                        GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_view_sw");
                    } else {
                        GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_view_sw");
                    }
                }
                GGKConfigManager.legoConfig(getHost().getActivity(), jSONObject, "passenger_newSheet", new GGKConfigCallbackAdapter() {
                    public boolean sheetXMLClickLis(final LEGODrawer lEGODrawer, GGKData gGKData, String str, String str2, Map<String, Object> map) {
                        if (!TextUtils.isEmpty(str2) && !"null".equals(str2)) {
                            if (str2.startsWith("http") || str2.startsWith("https")) {
                                DRouter.build(str2).start(ConfirmServicePresenter.this.getHost().getActivity());
                            } else {
                                int optInt = gGKData.getData().optInt("buy_type");
                                gGKData.getData().optString("package_id");
                                C75541 r3 = new Runnable() {
                                    public void run() {
                                        LEGODrawer lEGODrawer = lEGODrawer;
                                        if (lEGODrawer != null) {
                                            lEGODrawer.dismiss();
                                            ConfirmServicePresenter.this.gotoConfirmAddress();
                                        }
                                    }
                                };
                                FormStore.getInstance().setIsPassShowDialog(true);
                                if (str2.endsWith("confirm_buy") || str2.endsWith("confirm_renew")) {
                                    GlobalOmegaUtils.trackEvent(optInt == 1 ? "ibt_gp_firstpoppasscard_buy_btn_ck" : "ibt_gp_secondpoppasscard_buy_btn_ck");
                                    FormStore.getInstance().setIsDialogPassConfirm(true);
                                    ConfirmServicePresenter.this.m14769a((Runnable) r3, true, 1);
                                } else {
                                    GlobalOmegaUtils.trackEvent(optInt == 1 ? "ibt_gp_firstpoppasscard_refuse_btn_ck" : "ibt_gp_secondpoppasscard_refuse_btn_ck");
                                    FormStore.getInstance().setIsDialogPassConfirm(false);
                                    ConfirmServicePresenter.this.m14769a((Runnable) r3, false, 2);
                                }
                                return true;
                            }
                        }
                        return true;
                    }
                });
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                gotoConfirmAddress();
            }
        }
        if (carBreakMemberModel == null || TextUtils.isEmpty(carBreakMemberModel.memberTopImg) || carBreakMemberModel.memberTopImg.equals("null") || TextUtils.isEmpty(carBreakMemberModel.memberCancelMsg) || TextUtils.isEmpty(carBreakMemberModel.memberConfirmMsg) || TextUtils.isEmpty(carBreakMemberModel.memberContent) || TextUtils.isEmpty(carBreakMemberModel.memberTitle) || TextUtils.isEmpty(carBreakMemberModel.packageId) || estimateItemModel.carConfig == null || TextUtils.isEmpty(estimateItemModel.carConfig.estimateId)) {
            gotoConfirmAddress();
            return;
        }
        final int i = carBreakMemberModel.memberBuyType;
        if (i == 1) {
            GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_view_sw");
        } else {
            GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_view_sw");
        }
        LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(carBreakMemberModel.memberTitle, new LEGOBtnTextAndCallback(carBreakMemberModel.memberConfirmMsg, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (i == 1) {
                    GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_buy_btn_ck");
                } else {
                    GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_buy_btn_ck");
                }
                ConfirmServicePresenter.this.m14772a(true, estimateItemModel.carConfig.estimateId, carBreakMemberModel.packageId, 1, new Runnable() {
                    public void run() {
                        if (ConfirmServicePresenter.this.f17473h != null) {
                            ConfirmServicePresenter.this.f17473h.dismiss();
                        }
                        ConfirmServicePresenter.this.gotoConfirmAddress();
                    }
                });
            }
        }));
        lEGODrawerModel1.setIsShowCloseImg(true);
        lEGODrawerModel1.setClickOutsideCanCancel(false);
        lEGODrawerModel1.setSubTitle(carBreakMemberModel.memberContent);
        lEGODrawerModel1.addMinorBtn(new LEGOBtnTextAndCallback(carBreakMemberModel.memberCancelMsg, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (i == 1) {
                    GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_refuse_btn_ck");
                } else {
                    GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_refuse_btn_ck");
                }
                ConfirmServicePresenter.this.m14772a(false, estimateItemModel.carConfig.estimateId, carBreakMemberModel.packageId, 2, new Runnable() {
                    public void run() {
                        if (ConfirmServicePresenter.this.f17473h != null) {
                            ConfirmServicePresenter.this.f17473h.dismiss();
                        }
                        ConfirmServicePresenter.this.gotoConfirmAddress();
                    }
                });
            }
        }));
        LEGOImgModel lEGOImgModel = new LEGOImgModel();
        lEGOImgModel.setImgUrl(carBreakMemberModel.memberTopImg);
        lEGODrawerModel1.setImgModel(lEGOImgModel);
        this.f17473h = LEGOUICreator.showDrawerTemplate(this.mContext, lEGODrawerModel1);
    }

    /* renamed from: a */
    private void m14766a(final AnyCarEstimateItemModel anyCarEstimateItemModel) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        this.memberShipDrawerStartTime = System.currentTimeMillis();
        final CarBreakMemberModel carBreakMemberModel = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember;
        if (carBreakMemberModel.passengerNewSheet != null) {
            try {
                JSONObject jSONObject = new JSONObject(carBreakMemberModel.passengerNewSheet.toString());
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (!(optJSONArray == null || (optJSONObject = optJSONArray.getJSONObject(0).optJSONObject("normal")) == null || (optJSONObject2 = optJSONObject.optJSONObject("data")) == null)) {
                    if (optJSONObject2.optInt("buy_type") == 1) {
                        GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_view_sw");
                    } else {
                        GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_view_sw");
                    }
                }
                GGKConfigManager.legoConfig(getHost().getActivity(), jSONObject, "passenger_newSheet", new GGKConfigCallbackAdapter() {
                    public boolean sheetXMLClickLis(final LEGODrawer lEGODrawer, GGKData gGKData, String str, String str2, Map<String, Object> map) {
                        if (!TextUtils.isEmpty(str2) && !"null".equals(str2)) {
                            if (str2.startsWith("http") || str2.startsWith("https")) {
                                DRouter.build(str2).start(ConfirmServicePresenter.this.getHost().getActivity());
                            } else {
                                int optInt = gGKData.getData().optInt("buy_type");
                                gGKData.getData().optString("package_id");
                                C75301 r3 = new Runnable() {
                                    public void run() {
                                        LEGODrawer lEGODrawer = lEGODrawer;
                                        if (lEGODrawer != null) {
                                            lEGODrawer.dismiss();
                                            ConfirmServicePresenter.this.gotoConfirmAddress();
                                        }
                                    }
                                };
                                FormStore.getInstance().setIsPassShowDialog(true);
                                if (str2.endsWith("confirm_buy") || str2.endsWith("confirm_renew")) {
                                    GlobalOmegaUtils.trackEvent(optInt == 1 ? "ibt_gp_firstpoppasscard_buy_btn_ck" : "ibt_gp_secondpoppasscard_buy_btn_ck");
                                    FormStore.getInstance().setIsDialogPassConfirm(true);
                                    ConfirmServicePresenter.this.m14769a((Runnable) r3, true, 1);
                                } else {
                                    GlobalOmegaUtils.trackEvent(optInt == 1 ? "ibt_gp_firstpoppasscard_refuse_btn_ck" : "ibt_gp_secondpoppasscard_refuse_btn_ck");
                                    FormStore.getInstance().setIsDialogPassConfirm(false);
                                    ConfirmServicePresenter.this.m14769a((Runnable) r3, false, 2);
                                }
                                return true;
                            }
                        }
                        return true;
                    }
                });
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                gotoConfirmAddress();
            }
        }
        if (carBreakMemberModel == null || TextUtils.isEmpty(carBreakMemberModel.memberTopImg) || carBreakMemberModel.memberTopImg.equals("null") || TextUtils.isEmpty(carBreakMemberModel.memberCancelMsg) || TextUtils.isEmpty(carBreakMemberModel.memberConfirmMsg) || TextUtils.isEmpty(carBreakMemberModel.memberContent) || TextUtils.isEmpty(carBreakMemberModel.memberTitle) || TextUtils.isEmpty(carBreakMemberModel.packageId) || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null || TextUtils.isEmpty(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.estimateId)) {
            gotoConfirmAddress();
            return;
        }
        final int i = carBreakMemberModel.memberBuyType;
        if (i == 1) {
            GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_view_sw");
        } else {
            GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_view_sw");
        }
        LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(carBreakMemberModel.memberTitle, new LEGOBtnTextAndCallback(carBreakMemberModel.memberConfirmMsg, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (i == 1) {
                    GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_buy_btn_ck");
                } else {
                    GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_buy_btn_ck");
                }
                ConfirmServicePresenter.this.m14772a(true, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.estimateId, carBreakMemberModel.packageId, 1, new Runnable() {
                    public void run() {
                        if (ConfirmServicePresenter.this.f17473h != null) {
                            ConfirmServicePresenter.this.f17473h.dismiss();
                        }
                        ConfirmServicePresenter.this.gotoConfirmAddress();
                    }
                });
            }
        }));
        lEGODrawerModel1.setIsShowCloseImg(true);
        lEGODrawerModel1.setClickOutsideCanCancel(false);
        lEGODrawerModel1.setSubTitle(carBreakMemberModel.memberContent);
        lEGODrawerModel1.addMinorBtn(new LEGOBtnTextAndCallback(carBreakMemberModel.memberCancelMsg, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (i == 1) {
                    GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_refuse_btn_ck");
                } else {
                    GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_refuse_btn_ck");
                }
                ConfirmServicePresenter.this.m14772a(false, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.estimateId, carBreakMemberModel.packageId, 2, new Runnable() {
                    public void run() {
                        if (ConfirmServicePresenter.this.f17473h != null) {
                            ConfirmServicePresenter.this.f17473h.dismiss();
                        }
                        ConfirmServicePresenter.this.gotoConfirmAddress();
                    }
                });
            }
        }));
        LEGOImgModel lEGOImgModel = new LEGOImgModel();
        lEGOImgModel.setImgUrl(carBreakMemberModel.memberTopImg);
        lEGODrawerModel1.setImgModel(lEGOImgModel);
        this.f17473h = LEGOUICreator.showDrawerTemplate(this.mContext, lEGODrawerModel1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14769a(Runnable runnable, boolean z, int i) {
        if (runnable != null) {
            runnable.run();
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("scene", z ? "buy" : "refuse");
        hashMap.put("residencetime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.memberShipDrawerStartTime)));
        GlobalOmegaUtils.trackEvent(i == 1 ? "ibt_gp_firstpoppasscard_residencetime_ex" : "ibt_gp_secondpoppasscard_residencetime_ex", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14772a(final boolean z, String str, String str2, final int i, final Runnable runnable) {
        CarRequest.tripBuy(this.mContext, str, str2, i, 1, new BffResponseListener<BffBaseObject>() {
            public void onSuccess(BffBaseObject bffBaseObject) {
                super.onSuccess(bffBaseObject);
                GlobalOmegaUtils.trackEvent("ibt_bp_passpurchase_bt");
                next();
            }

            public void onError(BffBaseObject bffBaseObject) {
                super.onError(bffBaseObject);
                ToastHelper.showShortCompleted(ConfirmServicePresenter.this.mContext, (int) R.string.global_system_busy_click_toast);
                next();
            }

            public void onFail(BffBaseObject bffBaseObject) {
                super.onFail(bffBaseObject);
                ToastHelper.showShortCompleted(ConfirmServicePresenter.this.mContext, (int) R.string.global_system_busy_click_toast);
                next();
            }

            private void next() {
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
                HashMap hashMap = new HashMap(1);
                hashMap.put("scene", z ? "buy" : "refuse");
                hashMap.put("residencetime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - ConfirmServicePresenter.this.memberShipDrawerStartTime)));
                GlobalOmegaUtils.trackEvent(i == 1 ? "ibt_gp_firstpoppasscard_residencetime_ex" : "ibt_gp_secondpoppasscard_residencetime_ex", (Map<String, Object>) hashMap);
            }
        });
    }

    /* renamed from: a */
    private void m14763a(GGKData gGKData) {
        GGKView createTemplateView = GlobalGenericKit.createTemplateView(this.mContext, gGKData);
        if (createTemplateView != null) {
            GGKDrawerModel0 gGKDrawerModel0 = new GGKDrawerModel0();
            gGKDrawerModel0.setExtendedView(createTemplateView.getView()).setIsLoadingEnable(true).setClickOutsideCanCancel(false).setmBackPressedEnabled(false);
            this.f17472g = GGKUICreator.showDrawerModel(this.mContext, gGKDrawerModel0);
            this.memberShipDrawerStartTime = System.currentTimeMillis();
        }
    }

    /* access modifiers changed from: protected */
    public void gotoConfirmAddress() {
        this.f17468c = true;
        FormStore.getInstance().setDepartureAddress((Address) null);
        FormStore.getInstance().setFlightNum((String) null);
        FormStore.getInstance().setShiftSelected(false);
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || !confirmListener.getIsAnyCar()) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (!(newEstimateItem == null || newEstimateItem.carBreakModel == null || newEstimateItem.carBreakModel.preorderExpoInterceptInfo == null || !newEstimateItem.carBreakModel.preorderExpoInterceptInfo.show)) {
                newEstimateItem.carBreakModel.preorderExpoInterceptInfo.show = false;
            }
        } else {
            AnyCarEstimateItemModel hitPreOrderItem = confirmListener.getHitPreOrderItem();
            if (!(hitPreOrderItem == null || hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel == null || hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel.preorderExpoInterceptInfo == null || !hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel.preorderExpoInterceptInfo.show)) {
                hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel.preorderExpoInterceptInfo.show = false;
            }
        }
        GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PICONF);
        m14771a(true);
        if (confirmListener != null) {
            confirmListener.setCurrentPage(3);
        }
        doPublish(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS);
        if (confirmListener != null) {
            AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
            if (!confirmListener.getIsAnyCar()) {
                EstimateItemModel newEstimateItem2 = FormStore.getInstance().getNewEstimateItem();
                if (newEstimateItem2 != null && newEstimateItem2.carConfig != null && !TextUtils.isEmpty(newEstimateItem2.carConfig.uniqueId)) {
                    FormStore.getInstance().setIsSeatConfirmDialogShowed(newEstimateItem2.carConfig.uniqueId, false);
                }
            } else if (selectedSingleAnyCarItem != null && selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig != null && !TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.uniqueId)) {
                FormStore.getInstance().setIsSeatConfirmDialogShowed(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.uniqueId, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void backConfirmPricePage() {
        Logger logger = this.mLogger;
        logger.info("backConfirmPricePage " + this.f17468c, new Object[0]);
        this.f17468c = false;
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null) {
            confirmListener.setCurrentPage(1);
        }
        if (FormStore.getInstance().isInMiniBus()) {
            doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
        }
        FormStore.getInstance().setIsInMiniBus(false);
        FormStore.getInstance().setFlexOfferPrice(false);
        GlobalOmegaUtils.trackEvent("gp_confirm_service_confirmDeparture_back");
        GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_CONF);
        m14771a(false);
        doPublish(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE);
        m14796k();
    }

    /* renamed from: k */
    private void m14796k() {
        FormStore.getInstance().setEstimatePassConfirm(false);
        FormStore.getInstance().setIsDialogPassConfirm(false);
        FormStore.getInstance().setIsPassShowDialog(false);
    }

    /* renamed from: l */
    private void m14797l() {
        PinCodeInfoResult driverInfo;
        if (FormStore.getInstance().isFromOpenRide() && (driverInfo = FormStore.getInstance().getDriverInfo()) != null) {
            m14756a(2, driverInfo.driverId);
        }
        FormStore.getInstance().setCurCompany((TaxiCompanyListModel.CompanyModel) null);
        GlobalOmegaUtils.trackEvent("global_checkpage_back_ck", "country", BusinessUtils.getCountryIsoCode(this.mBusinessContext));
        Bundle bundle = new Bundle();
        bundle.putSerializable("home_map_user_start_address", FormStore.getInstance().getStartAddress());
        bundle.putBoolean("is_form_confirm_back_home", true);
        goBackRoot(bundle);
    }

    /* renamed from: a */
    private void m14756a(int i, String str) {
        CarRequest.notifyDriverStateOfPsg(this.mContext, i, str, (ResponseListener<BaseObject>) null);
    }

    /* renamed from: m */
    private void m14798m() {
        Boolean bool;
        try {
            bool = (Boolean) FormStore.getInstance().getData(FormStore.KEY_RECALL_ORDER);
        } catch (Exception unused) {
            bool = false;
        }
        if (bool != null && bool.booleanValue()) {
            FormStore.getInstance().setData(FormStore.KEY_RECALL_ORDER, false);
            createOrder(0);
        }
    }

    /* access modifiers changed from: protected */
    public void createOrder(int i) {
        if (FormStore.getInstance().isInMiniBus()) {
            this.mIsSendOrderInWaitRspPage = false;
        } else {
            this.mIsSendOrderInWaitRspPage = true;
        }
        CarOrderHelper.saveOrder((CarOrder) null);
        boolean z = this.mIsSendOrderInWaitRspPage;
        if (z) {
            gotoWaitRspPage((CarOrder) null, z);
            return;
        }
        showProgressDialog(this.mContext.getString(R.string.car_sending_order));
        setParam(getCreateOrderParam());
        super.createOrder(i);
    }

    /* access modifiers changed from: protected */
    public void onOrderCreated(CarOrder carOrder) {
        super.onOrderCreated(carOrder);
        if (FormStore.getInstance().isInMiniBus()) {
            m14799n();
            m14800o();
            FormStore.getInstance().setIsInMiniBus(false);
        }
        if (Preconditions.nonNull(carOrder) && carOrder.isBooking() && carOrder.isBookingDelayAssign()) {
            m14765a(carOrder, (ResponseListener<CarOrder>) new ResponseListener<CarOrder>() {
                public void onSuccess(CarOrder carOrder) {
                    ConfirmServicePresenter.this.m14764a(carOrder);
                }
            });
        } else if (carOrder.getProductId() == 21009) {
            m14765a(carOrder, (ResponseListener<CarOrder>) new ResponseListener<CarOrder>() {
                public void onSuccess(CarOrder carOrder) {
                    ConfirmServicePresenter confirmServicePresenter = ConfirmServicePresenter.this;
                    confirmServicePresenter.gotoWaitRspPage(carOrder, confirmServicePresenter.mIsSendOrderInWaitRspPage);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14768a(XEDataHandleModel xEDataHandleModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BaseExtras.Common.EXTRA_GETON_TO_RSP, xEDataHandleModel);
        bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        bundle.putInt(BaseExtras.Trip.EXTRA_TRIP_SCENE, 10402);
        bundle.putBoolean(BaseExtras.Trip.EXTRA_TRIP_IS_ANY_CAR, this.isAnyCar);
        forward(1040, bundle, new Animations(0, 0, 0, 0));
    }

    /* renamed from: n */
    private void m14799n() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            order.status = 7;
        }
    }

    /* renamed from: o */
    private void m14800o() {
        if (this.mOrderStatusPoll == null) {
            LogUtils.m34979e(f17466b, "startOrderService:mOrderStatusPoll is null, mTag = ConfirmServicePresenter");
            return;
        }
        this.mOrderStatusPoll.addCoreCallback(this.f17481u);
        this.mOrderStatusPoll.startPoll((Scene) null);
    }

    /* renamed from: p */
    private void m14801p() {
        if (this.mOrderStatusPoll != null) {
            this.mOrderStatusPoll.removeCoreCallback(this.f17481u);
            this.mOrderStatusPoll.stopPoll((Scene) null);
            return;
        }
        LogUtils.m34982w(f17466b, "stopOrderService:mOrderStatusPoll is null");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14765a(final CarOrder carOrder, final ResponseListener<CarOrder> responseListener) {
        TravelUtil.getOrderDetail(this.mComponentProxy.getSession(), carOrder.oid, new ITravelOrderListener() {
            public void onSuccess(ICarOrder iCarOrder) {
                responseListener.onSuccess((CarOrder) iCarOrder);
            }

            public void onError(int i, String str) {
                ConfirmServicePresenter.this.m14778b(carOrder, (ResponseListener<CarOrder>) responseListener);
            }

            public void onFail(int i, String str) {
                ConfirmServicePresenter.this.m14778b(carOrder, (ResponseListener<CarOrder>) responseListener);
            }

            public void onTimeout(String str) {
                ConfirmServicePresenter.this.m14778b(carOrder, (ResponseListener<CarOrder>) responseListener);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14778b(final CarOrder carOrder, final ResponseListener<CarOrder> responseListener) {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                ConfirmServicePresenter.this.m14765a(carOrder, (ResponseListener<CarOrder>) responseListener);
            }
        }, 3000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14764a(CarOrder carOrder) {
        dismissProgressDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable(BaseExtras.Common.EXTRA_ORDER_BEAN, carOrder);
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        forwardNew(1025, bundle);
    }

    /* access modifiers changed from: protected */
    public void onOrderCreateFail(CarOrder carOrder) {
        int errorCode;
        super.onOrderCreateFail(carOrder);
        if (carOrder != null) {
            omegaTrackSendOrderErrorCode(carOrder.errno);
            if (FormStore.getInstance().isInMiniBus() && (errorCode = carOrder.getErrorCode()) != 1058 && errorCode != 1055 && errorCode != 10001) {
                backConfirmPricePage();
                doPublish(BaseEventKeys.Confirm.EVENT_CONFORM_HIDE_START_END_LOADING);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void backToEstimate() {
        if (this.f17468c) {
            onBackPressed(IPresenter.BackType.BackKey);
        }
        FormStore.getInstance().setPayWay("");
        FormStore.getInstance().setPayWayMsg("");
        doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
    }

    /* access modifiers changed from: protected */
    public void showPaymentsPage() {
        if (this.f17468c) {
            onBackPressed(IPresenter.BackType.BackKey);
            doPublish(BaseEventKeys.Confirm.SHOW_PAYMENTS);
        }
    }

    /* renamed from: q */
    private void m14802q() {
        CarOrder createFailOrder = FormStore.getInstance().getCreateFailOrder();
        if (createFailOrder != null) {
            FormStore.getInstance().setCreateFailOrder((CarOrder) null);
            onOrderCreateFail(createFailOrder);
        }
    }

    /* access modifiers changed from: protected */
    public void startReEstimate() {
        super.startReEstimate();
        doPublish(BaseEventKeys.Estimate.ESTIMATE_FIXED_PRICE_RE_ESTIMATE);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_SUCCESS, this.f17482v);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FAIL, this.f17484x);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR, this.f17485y);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH, this.f17486z);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f17483w);
    }

    /* access modifiers changed from: protected */
    public void endReEstimate() {
        super.endReEstimate();
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_SUCCESS, this.f17482v);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FAIL, this.f17484x);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR, this.f17485y);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH, this.f17486z);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f17483w);
    }
}
