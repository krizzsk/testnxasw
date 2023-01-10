package com.didi.component.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.bfflib.business.BffBaseObject;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.cpf.CPFAuthWebActivity;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.TripListener;
import com.didi.component.business.oneconfig.AbsConfirmConfigState;
import com.didi.component.business.pageswitchparam.CreateOrderParam;
import com.didi.component.business.recovery.GlobalOrderRecovery;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarHttpHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.OrderBanUIUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.cache.CacheStore;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.ggk.GgkConstant;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.service.activity.risk.RiskInterceptPopup;
import com.didi.component.service.activity.risk.RiskUserActivity;
import com.didi.component.service.activity.risk.items.ItemType;
import com.didi.component.service.cancelreason.cache.CancelTripCache;
import com.didi.component.service.util.verifycard.IDialogOperation;
import com.didi.component.service.util.verifycard.IProgressOperation;
import com.didi.component.service.util.verifycard.IVerifyOperation;
import com.didi.component.service.util.verifycard.VerifyCardOperator;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.GGKUICreator;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.config.ButtonModel;
import com.didi.global.globalgenerickit.config.GGKConfigCallbackAdapter;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.global.globalgenerickit.drawer.GGKAbsDrawer;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.convert.GGKDrawerModelConverter;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKBaseDrawerModel;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel2;
import com.didi.global.globalgenerickit.model.sheet.ComponentSheetModel;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.dialog.LEGOBaseAlertDialogFragment;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel2;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.sdk.monitor.GlobalPaxTechTracker;
import com.didi.sdk.reversegeo.ReverseLocationStore;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.p172v2.store.Store;
import com.didi.travel.p172v2.util.LogUtils;
import com.didi.travel.psnger.TEBridge;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.core.model.request.OrderParams;
import com.didi.travel.psnger.model.CommonPopUp;
import com.didi.travel.psnger.model.response.CarConfig;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.CarOrderPrepay;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.OrderBanPopInfo;
import com.didi.travel.psnger.model.response.PayEnterpriseInfo;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.PrePayTipsModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarOperationDataModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.p171v2.TravelUtil;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didi.xengine.register.XERegister;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceParam;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didichuxing.request.ServerParam;
import com.didiglobal.enginecore.callback.XEReqParamsCallback;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.travel.util.CollectionUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsSendOrderServicePresenter extends AbsServicePresenter {
    public static final int CREATE_ORDER_CONFIRMED = 1;
    public static final int CREATE_ORDER_FIRST = 0;

    /* renamed from: a */
    LEGODrawer f17416a = null;

    /* renamed from: b */
    private List<String> f17417b = new ArrayList();

    /* renamed from: c */
    private String f17418c;

    /* renamed from: d */
    private String f17419d;

    /* renamed from: e */
    private AlertDialogFragment f17420e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public GGKAbsDrawer f17421f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public GGKDrawer f17422g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LEGODrawer f17423h;

    /* renamed from: i */
    private AnyCarEstimateItemModel f17424i;

    /* renamed from: j */
    private Map<String, Object> f17425j;

    /* renamed from: k */
    private String f17426k;

    /* renamed from: l */
    private AnyCarEstimateItemModel f17427l;

    /* renamed from: m */
    private List<AnyCarEstimateItemModel> f17428m;
    protected BusinessContext mBusinessContext;
    protected int mDoubleCheck;
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());
    protected XEReqParamsCallback mNewOrderCallback = new XEReqParamsCallback<Map<String, Object>>() {
        public Map<String, Object> getRequestParams() {
            if (FormStore.getInstance().isInMiniBus()) {
                AbsSendOrderServicePresenter absSendOrderServicePresenter = AbsSendOrderServicePresenter.this;
                Map<String, Object> params = absSendOrderServicePresenter.m14690b(absSendOrderServicePresenter.mContext, AbsSendOrderServicePresenter.this.mDoubleCheck).getParams();
                if (CollectionUtils.isNotEmpty((Map<?, ?>) FormStore.getInstance().getSelectValueParams())) {
                    params.putAll(FormStore.getInstance().getSelectValueParams());
                }
                return params;
            }
            AbsSendOrderServicePresenter absSendOrderServicePresenter2 = AbsSendOrderServicePresenter.this;
            return absSendOrderServicePresenter2.m14690b(absSendOrderServicePresenter2.mContext, AbsSendOrderServicePresenter.this.mDoubleCheck).getParams();
        }
    };
    protected XEResponseCallback mPrepayCallback = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            String str2 = AbsSendOrderServicePresenter.this.TAG;
            LogUtils.m34980i(str2, "PrepayCallback onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
            CarOrderPrepay carOrderPrepay = new CarOrderPrepay();
            carOrderPrepay.parse(xEngineData.jsonObject.toString());
            if (carOrderPrepay.needPrepay()) {
                AbsSendOrderServicePresenter.this.m14686a(carOrderPrepay.prePayTipsModel);
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            String str2 = AbsSendOrderServicePresenter.this.TAG;
            LogUtils.m34980i(str2, "PrepayCallback onFailed:e = " + engineErrorException);
        }
    };
    protected XEResponseCallback mXELogicCallback = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            String str2 = AbsSendOrderServicePresenter.this.TAG;
            LogUtils.m34980i(str2, "onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
            CarOrder carOrder = new CarOrder();
            carOrder.setIsNewVersion(true);
            carOrder.parse(xEngineData.jsonObject.getAsJsonObject("data").toString());
            String str3 = AbsSendOrderServicePresenter.this.TAG;
            LogUtils.m34980i(str3, "onSuccess:carOrder = " + carOrder + ", isAvailable = " + carOrder.isAvailable());
            if (carOrder.isAvailable()) {
                AbsSendOrderServicePresenter.this.onCreateOrderSuccess(carOrder);
            } else {
                String str4 = AbsSendOrderServicePresenter.this.TAG;
                LogUtils.m34980i(str4, "onCreateOrderFail:traceId = " + xEngineData.traceId + ", code = " + carOrder.getErrorCode());
                GlobalPaxTechTracker.getInstance().trackNewOrderError(2, carOrder.getErrorCode(), carOrder.getErrorMsg(), xEngineData.traceId);
                AbsSendOrderServicePresenter.this.onCreateOrderFail(carOrder);
            }
            AbsSendOrderServicePresenter.this.m14685a(carOrder);
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            String str2 = AbsSendOrderServicePresenter.this.TAG;
            LogUtils.m34980i(str2, "onFailed:e = " + engineErrorException);
            CarOrder carOrder = new CarOrder();
            carOrder.setErrorCode(-1);
            carOrder.setThrowable(engineErrorException);
            GlobalPaxTechTracker.getInstance().trackNewOrderError(0, -1, "", "");
            AbsSendOrderServicePresenter.this.onCreateOrderError(carOrder);
            AbsSendOrderServicePresenter.this.m14685a(carOrder);
        }
    };

    /* renamed from: r */
    private Bundle f17429r;

    /* renamed from: s */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17430s = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsSendOrderServicePresenter.this.backToEstimate();
        }
    };

    /* renamed from: t */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17431t = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsSendOrderServicePresenter.this.backToEstimate();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: u */
    public GGKDrawer f17432u;

    /* renamed from: v */
    private BaseEventPublisher.OnEventListener<String> f17433v = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (AbsSendOrderServicePresenter.this.f17432u != null) {
                AbsSendOrderServicePresenter.this.f17432u.dismiss();
                GGKDrawer unused = AbsSendOrderServicePresenter.this.f17432u = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (str2.equals("cancel")) {
                    AbsSendOrderServicePresenter.this.gotoConfirmPage(false, "");
                } else if (str2.equals("continue")) {
                    FormStore.getInstance().setPassengerSheetKey((String) CacheStore.getInstance().getCache(GgkConstant.GGK_CACHE_KEY_4_ORDER_BLOCKED, ""));
                    AbsSendOrderServicePresenter.this.createOrder(0);
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public void backConfirmPricePage() {
    }

    /* access modifiers changed from: protected */
    public void backToEstimate() {
    }

    /* access modifiers changed from: protected */
    public String getCustomFeaturesParam() {
        return "";
    }

    /* access modifiers changed from: protected */
    public void showPaymentsPage() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14686a(PrePayTipsModel prePayTipsModel) {
        try {
            Intent intent = new Intent();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("sign", prePayTipsModel.sign);
            jsonObject.addProperty(Const.PayParams.SIGN_TYPE, prePayTipsModel.signType);
            jsonObject.addProperty(Const.PayParams.BIZ_CONTENT, prePayTipsModel.bizContent);
            jsonObject.addProperty(Const.PayParams.OUT_TRADE_ID, prePayTipsModel.outTradeId);
            jsonObject.addProperty("pixPrepay", Boolean.valueOf(prePayTipsModel.pixPrepay));
            intent.setPackage(this.mContext.getPackageName());
            intent.setAction("com.didi.global.unifiedPay.entrance");
            intent.putExtra("uni_pay_param", jsonObject.toString());
            startActivityForResult(intent, 77);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AbsSendOrderServicePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mBusinessContext = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f17429r = bundle;
        m14696c();
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_NEW_ORDER, XERequestKey.SCENE_NEW_ORDER, this.mXELogicCallback);
        xERegisterModel.required = true;
        xERegisterModel.requestParams = this.mNewOrderCallback;
        XERegister.registerTemplate(xERegisterModel);
        XERegisterModel xERegisterModel2 = new XERegisterModel(XERequestKey.REQUEST_KEY_UNIPAY, XERequestKey.SCENE_NEW_ORDER, this.mPrepayCallback);
        xERegisterModel2.addScene(XERequestKey.SCENE_TRIP);
        XERegister.registerTemplate(xERegisterModel2);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m14706f();
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_NEW_ORDER);
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_UNIPAY);
    }

    /* access modifiers changed from: protected */
    public void onSubscribeEventReceiver() {
        super.onSubscribeEventReceiver();
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_ONE_KEY_SEND_ORDER_BLOCKING_BY_CPF, this.f17430s);
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_BACK_TO_ESTIMATE, this.f17431t);
        subscribe(BaseEventKeys.Service.EVENT_CREATE_ORDER_BLOCK, this.f17433v);
    }

    /* access modifiers changed from: protected */
    public void onUnsubscribeEventReceiver() {
        super.onUnsubscribeEventReceiver();
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_ONE_KEY_SEND_ORDER_BLOCKING_BY_CPF, this.f17430s);
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_BACK_TO_ESTIMATE, this.f17431t);
        unsubscribe(BaseEventKeys.Service.EVENT_CREATE_ORDER_BLOCK, this.f17433v);
    }

    /* access modifiers changed from: protected */
    public void omegaTrackSendOrderErrorCode(int i) {
        String str;
        HashMap hashMap = new HashMap();
        String estimateModelTraceId = FormStore.getInstance().getEstimateModelTraceId();
        if (estimateModelTraceId != null) {
            hashMap.put("estimate_trace_id", estimateModelTraceId);
        }
        hashMap.put("err_no", Integer.valueOf(i));
        EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (estimateItem != null && estimateItem.payWayList != null) {
            Iterator<PayWayModel.PayWayItem> it = estimateItem.payWayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PayWayModel.PayWayItem next = it.next();
                if (next.isSelected() == 1) {
                    str = next.title;
                    break;
                }
            }
        }
        str = "";
        if (newEstimateItem != null) {
            hashMap.put("bubble_id", newEstimateItem.estimateId);
            hashMap.put("price_estimated", Float.valueOf(newEstimateItem.feeNumber));
        }
        hashMap.put("payment", str);
        GlobalOmegaUtils.trackEvent("gp_popup_view_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 72) {
            if (i != 100) {
                if (i != 76) {
                    if (i == 77 && i2 == -1 && intent != null) {
                        int intExtra = intent.getIntExtra("code", 0);
                        if (intExtra == 2) {
                            m14688a(false);
                        } else if (intExtra == 5) {
                            m14688a(true);
                        } else if (intExtra == 4) {
                            LEGODrawer lEGODrawer = this.f17423h;
                            if (lEGODrawer != null && lEGODrawer.isShowing()) {
                                this.f17423h.dismiss();
                            }
                            LEGODrawerModel2 lEGODrawerModel2 = new LEGODrawerModel2(this.mContext.getString(R.string.GRider_Prepay_Pix_payment_rejH), new LEGOBtnTextAndCallback(this.mContext.getString(R.string.GRider_Prepay_Replacement_GRsz), new LEGOOnAntiShakeClickListener() {
                                public void onAntiShakeClick(View view) {
                                    if (AbsSendOrderServicePresenter.this.f17423h != null) {
                                        AbsSendOrderServicePresenter.this.f17423h.dismiss();
                                    }
                                    AbsSendOrderServicePresenter.this.m14688a(true);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("k", "click");
                                    hashMap.put(RavenKey.VERSION, "change_btn");
                                    hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "timeout_page");
                                    GlobalOmegaUtils.trackEvent("ibt_gp_timeout_page_change_ck", (Map<String, Object>) hashMap);
                                }
                            }), new LEGOBtnTextAndCallback(this.mContext.getString(R.string.GRider_Prepay_Cancel_BjKC), new LEGOOnAntiShakeClickListener() {
                                public void onAntiShakeClick(View view) {
                                    if (AbsSendOrderServicePresenter.this.f17423h != null) {
                                        AbsSendOrderServicePresenter.this.f17423h.dismiss();
                                    }
                                    AbsSendOrderServicePresenter.this.m14688a(false);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("k", "click");
                                    hashMap.put(RavenKey.VERSION, "continue_btn");
                                    hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "timeout_page");
                                    GlobalOmegaUtils.trackEvent("ibt_gp_timeout_page_continue_ck", (Map<String, Object>) hashMap);
                                }
                            }));
                            lEGODrawerModel2.setClickOutsideCanCancel(false);
                            this.f17423h = LEGOUICreator.showDrawerTemplate(this.mContext, lEGODrawerModel2);
                            HashMap hashMap = new HashMap();
                            hashMap.put("k", "show");
                            hashMap.put(RavenKey.VERSION, "thepage");
                            hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "timeout_page");
                            GlobalOmegaUtils.trackEvent("ibt_gp_timeout_page_num_sw", (Map<String, Object>) hashMap);
                        }
                    }
                } else if (i2 == -1) {
                    backToEstimate();
                    GlobalOmegaUtils.trackEvent("Brazil_card_success_sw", getOmgeaParamsOfForceBindOnlinePayment());
                }
            } else if (i2 == -1 && intent != null && "credit_card".equals(intent.getStringExtra("type"))) {
                backToEstimate();
            }
        } else if (i2 == 0 && intent != null && intent.getBooleanExtra(BaseEventKeys.Confirm.INTENT_KEY_SIGN_CREDIT_CARD, false)) {
            backToEstimate();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14688a(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "continue");
        if (z) {
            FormStore.getInstance().setShowPayWayAfterEstimate(true);
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_WAITRSP_CANCEL, bundle);
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        if (i == 10001 && i2 == 2) {
            Intent intent = new Intent(this.mContext, RiskUserActivity.class);
            intent.putExtra(RiskUserActivity.RISK_USER_ACTIVITY_EXTRA_KEY, (String[]) this.f17417b.toArray(new String[0]));
            intent.putExtra("url", this.f17418c);
            intent.putExtra("extension", this.f17419d);
            startActivityForResult(intent, 100);
            HashMap hashMap = new HashMap();
            hashMap.put("bubble_id", SearchIdUploadManager.getInstance().getBubbleId());
            GlobalOmegaUtils.trackEvent("ibt_gp_safetyvarifypopup_varify_ck", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void createOrder(int i) {
        m14677a(this.mContext, i);
    }

    /* access modifiers changed from: protected */
    public void onCreateOrderSuccess(CarOrder carOrder) {
        if (carOrder == null || TextUtils.isEmpty(carOrder.oid)) {
            String str = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onCreateOrderSuccess:order = ");
            sb.append(carOrder);
            sb.append(", oid = ");
            sb.append(carOrder == null ? "" : carOrder.oid);
            LogUtils.m34979e(str, sb.toString());
        } else {
            Store orCreateStore = Store.getOrCreateStore(TravelUtil.generateCarOrderStoreKey(carOrder.oid));
            orCreateStore.setStore(Store.S_NONE_INVOKE_ARGS, carOrder);
            orCreateStore.setOuterLifecycle(this.mComponentProxy.getSession().getLifecycle());
            this.mComponentProxy.updateOrderId(this.mComponentParams.pageID, carOrder.getOid());
        }
        onOrderCreated(carOrder);
    }

    /* access modifiers changed from: protected */
    public void onCreateOrderFail(CarOrder carOrder) {
        onOrderCreateFail(carOrder);
    }

    /* access modifiers changed from: protected */
    public void onCreateOrderError(CarOrder carOrder) {
        onOrderCreateFail(carOrder);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14685a(CarOrder carOrder) {
        GlobalOmegaUtils.trackEvent("gp_confirm_newOrder_request_result", Constants.ERROR_CODE, carOrder.getErrorCode() + "");
        dismissProgressDialog();
    }

    /* renamed from: b */
    private boolean m14694b(CarOrder carOrder) {
        if (carOrder.ConfigJson == null) {
            return false;
        }
        JSONObject jSONObject = carOrder.ConfigJson;
        if (jSONObject.has("passenger_newSheet")) {
            GGKConfigManager.legoConfig(getHost().getActivity(), jSONObject.optJSONObject("passenger_newSheet"), "passenger_newSheet", new GGKConfigCallbackAdapter() {
                public boolean sheetClickLis(LEGODrawer lEGODrawer, ButtonModel buttonModel, String str) {
                    if (lEGODrawer == null) {
                        return false;
                    }
                    DRouter.build(str).start(AbsSendOrderServicePresenter.this.mContext);
                    if (buttonModel.nodismiss == 1) {
                        return false;
                    }
                    lEGODrawer.dismiss();
                    return true;
                }
            });
            return true;
        } else if (!jSONObject.has("passenger_newPopup")) {
            return false;
        } else {
            GGKConfigManager.legoConfig(getHost().getActivity(), jSONObject.optJSONObject("passenger_newPopup"), "passenger_newPopup", new GGKConfigCallbackAdapter() {
                public boolean alertClickLis(LEGOBaseAlertDialogFragment lEGOBaseAlertDialogFragment, ButtonModel buttonModel, String str) {
                    if (lEGOBaseAlertDialogFragment == null) {
                        return false;
                    }
                    DRouter.build(str).start(AbsSendOrderServicePresenter.this.mContext);
                    if (buttonModel.nodismiss == 1) {
                        return false;
                    }
                    lEGOBaseAlertDialogFragment.dismiss();
                    return true;
                }
            });
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean orderIntercept(CarOrder carOrder) {
        if (TextUtils.isEmpty(carOrder.GGKJson)) {
            return false;
        }
        try {
            String obj = new JSONObject(carOrder.GGKJson).getJSONArray("passenger_sheet").get(0).toString();
            if (TextUtils.isEmpty(obj) || !NationComponentDataUtil.isLoginNow()) {
                return false;
            }
            ComponentSheetModel parse = new ComponentSheetModel().parse(obj);
            GGKBaseDrawerModel convert2GGKDrawerModel = GGKDrawerModelConverter.convert2GGKDrawerModel(parse);
            convert2GGKDrawerModel.setClickOutsideCanCancel(false);
            convert2GGKDrawerModel.setmBackPressedEnabled(false);
            this.f17432u = GGKUICreator.showDrawerModel(this.mContext, convert2GGKDrawerModel);
            CacheStore.getInstance().addCache(GgkConstant.GGK_CACHE_KEY_4_ORDER_BLOCKED, parse.f24112id);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private void m14677a(Context context, int i) {
        EstimateItemModel estimateItemModel;
        String str;
        if (FormStore.getInstance().getStartAddress() == null) {
            GLog.m11354d("quxiaozaifadan", "startaddress null");
            return;
        }
        if (CancelTripCache.getInstance().isUsingCachedEstimateParams()) {
            str = CancelTripCache.getInstance().getEstimateTraceId();
            estimateItemModel = CancelTripCache.getInstance().getNewEstimateModel();
        } else {
            estimateItemModel = FormStore.getInstance().getNewEstimateItem();
            str = FormStore.getInstance().getEstimateModelTraceId();
            if (!TextUtils.isEmpty(this.f17426k)) {
                str = this.f17426k;
            }
            if (str == null) {
                str = null;
            }
            CancelTripCache.getInstance().setEstimateTraceId(str);
            CancelTripCache.getInstance().setEstimateTime(System.currentTimeMillis());
        }
        if ((TextUtils.isEmpty(str) || (estimateItemModel == null && this.f17424i == null)) && GlobalApolloUtil.isSendOrderParamsErrorBackup()) {
            CarOrder carOrder = new CarOrder();
            carOrder.errno = 596;
            onOrderCreateFail(carOrder);
            GLog.m11354d("quxiaozaifadan", "isSendOrderParamsErrorBackup");
            GlobalOmegaUtils.sendOrderParamsEstimateNull();
            return;
        }
        OrderParams b = m14690b(context, i);
        if (!b.isEstimateInfoMatch()) {
            CarOrder carOrder2 = new CarOrder();
            carOrder2.errno = 596;
            GLog.m11354d("quxiaozaifadan", "isEstimateInfoMatch");
            onOrderCreateFail(carOrder2);
            return;
        }
        m14693b();
        LogUtils.m34980i(this.TAG, "createOrder");
        this.mDoubleCheck = i;
        XEngineReq.pageRequest(XERequestKey.SCENE_NEW_ORDER);
        GLog.m11353d("pNewOrder : " + b.getParams().toString());
        GlobalOmegaUtils.trackEvent("gp_confirm_newOrder_request");
    }

    /* renamed from: b */
    private void m14693b() {
        int i;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        AnyCarEstimateItemModel anyCarEstimateItemModel;
        int i2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONObject optJSONObject6;
        String str = null;
        if (this.f17427l != null || CollectionUtil.isEmpty((Collection<?>) this.f17428m)) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem != null && newEstimateItem.carConfig != null) {
                if (!(newEstimateItem.carBreakModel == null || newEstimateItem.carBreakModel.carBreakMember == null || newEstimateItem.carBreakModel.carBreakMember.passengerNewSheet == null)) {
                    try {
                        JSONArray optJSONArray = new JSONObject(newEstimateItem.carBreakModel.carBreakMember.passengerNewSheet.toString()).optJSONArray("list");
                        if (!(optJSONArray == null || (optJSONObject = optJSONArray.getJSONObject(0).optJSONObject("normal")) == null || (optJSONObject2 = optJSONObject.optJSONObject("data")) == null)) {
                            optJSONObject2.optInt("buy_type");
                            str = optJSONObject2.optString("package_id");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(str) && FormStore.getInstance().getPassPackageId() != 0) {
                    str = String.valueOf(FormStore.getInstance().getPassPackageId());
                }
                String str2 = str;
                int i3 = (FormStore.getInstance().isEstimatePassConfirm() || FormStore.getInstance().getIsDialogPassConfirm()) ? 1 : 2;
                if (FormStore.getInstance().getIsPassShowDialog()) {
                    i = 1;
                } else {
                    i = (FormStore.getInstance().isEstimatePassConfirm() || FormStore.getInstance().isHasEstimatePassData()) ? 10 : 0;
                }
                if (!TextUtils.isEmpty(str2) && i > 0) {
                    CarRequest.tripBuy(this.mContext, newEstimateItem.carConfig.estimateId, str2, i3, i, new BffResponseListener<BffBaseObject>() {
                        public void onSuccess(BffBaseObject bffBaseObject) {
                            super.onSuccess(bffBaseObject);
                            GlobalOmegaUtils.trackEvent("ibt_bp_passpurchase_bt");
                            HashMap hashMap = new HashMap();
                            if (FormStore.getInstance().isEstimatePassConfirm()) {
                                hashMap.put("is_checked", 2);
                            } else {
                                hashMap.put("is_checked", 1);
                            }
                            GlobalOmegaUtils.trackEvent("ibt_gp_bubblepage_ckrequest_checkboxstatus_bt", (Map<String, Object>) hashMap);
                        }

                        public void onError(BffBaseObject bffBaseObject) {
                            super.onError(bffBaseObject);
                        }

                        public void onFail(BffBaseObject bffBaseObject) {
                            super.onFail(bffBaseObject);
                        }

                        public void onFinish(BffBaseObject bffBaseObject) {
                            super.onFinish(bffBaseObject);
                            FormStore.getInstance().setEstimatePassConfirm(false);
                            FormStore.getInstance().setIsDialogPassConfirm(false);
                            FormStore.getInstance().setIsPassShowDialog(false);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        Iterator<AnyCarEstimateItemModel> it = this.f17428m.iterator();
        while (true) {
            if (!it.hasNext()) {
                anyCarEstimateItemModel = null;
                break;
            }
            anyCarEstimateItemModel = it.next();
            if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember.passengerNewSheet == null)) {
                try {
                    JSONArray optJSONArray2 = new JSONObject(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember.passengerNewSheet.toString()).optJSONArray("list");
                    if (!(optJSONArray2 == null || optJSONArray2.length() <= 0 || optJSONArray2.getJSONObject(0) == null || (optJSONObject5 = optJSONArray2.getJSONObject(0).optJSONObject("normal")) == null || (optJSONObject6 = optJSONObject5.optJSONObject("data")) == null || TextUtils.isEmpty(optJSONObject6.optString("package_id")))) {
                        break;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (anyCarEstimateItemModel != null && anyCarEstimateItemModel.estimatePass != null) {
                break;
            }
        }
        if (anyCarEstimateItemModel != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig != null) {
            if (!(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember.passengerNewSheet == null)) {
                try {
                    JSONArray optJSONArray3 = new JSONObject(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember.passengerNewSheet.toString()).optJSONArray("list");
                    if (!(optJSONArray3 == null || (optJSONObject3 = optJSONArray3.getJSONObject(0).optJSONObject("normal")) == null || (optJSONObject4 = optJSONObject3.optJSONObject("data")) == null)) {
                        optJSONObject4.optInt("buy_type");
                        str = optJSONObject4.optString("package_id");
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str) && FormStore.getInstance().getPassPackageId() != 0) {
                str = String.valueOf(FormStore.getInstance().getPassPackageId());
            }
            String str3 = str;
            int i4 = (FormStore.getInstance().isEstimatePassConfirm() || FormStore.getInstance().getIsDialogPassConfirm()) ? 1 : 2;
            if (FormStore.getInstance().getIsPassShowDialog()) {
                i2 = 1;
            } else {
                i2 = (FormStore.getInstance().isEstimatePassConfirm() || FormStore.getInstance().isHasEstimatePassData()) ? 10 : 0;
            }
            if (!TextUtils.isEmpty(str3) && i2 > 0) {
                CarRequest.tripBuy(this.mContext, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.estimateId, str3, i4, i2, new BffResponseListener<BffBaseObject>() {
                    public void onSuccess(BffBaseObject bffBaseObject) {
                        super.onSuccess(bffBaseObject);
                        GlobalOmegaUtils.trackEvent("ibt_bp_passpurchase_bt");
                        HashMap hashMap = new HashMap();
                        if (FormStore.getInstance().isEstimatePassConfirm()) {
                            hashMap.put("is_checked", 2);
                        } else {
                            hashMap.put("is_checked", 1);
                        }
                        GlobalOmegaUtils.trackEvent("ibt_gp_bubblepage_ckrequest_checkboxstatus_bt", (Map<String, Object>) hashMap);
                    }

                    public void onError(BffBaseObject bffBaseObject) {
                        super.onError(bffBaseObject);
                    }

                    public void onFail(BffBaseObject bffBaseObject) {
                        super.onFail(bffBaseObject);
                    }

                    public void onFinish(BffBaseObject bffBaseObject) {
                        super.onFinish(bffBaseObject);
                        FormStore.getInstance().setEstimatePassConfirm(false);
                        FormStore.getInstance().setIsDialogPassConfirm(false);
                        FormStore.getInstance().setIsPassShowDialog(false);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0340  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0381  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x038f A[Catch:{ Exception -> 0x0478 }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0468 A[Catch:{ Exception -> 0x0478 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x046a A[Catch:{ Exception -> 0x0478 }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0489  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x048e  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x049b  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x04a6 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0508  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x05c2 A[Catch:{ Exception -> 0x05c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x05d6  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0649 A[Catch:{ Exception -> 0x064e }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x06d2  */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x0784  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x079d  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x084f  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x085d  */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x0883 A[SYNTHETIC, Splitter:B:352:0x0883] */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x08e6  */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x08f4  */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x091c A[SYNTHETIC, Splitter:B:373:0x091c] */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0950  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x020e  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.travel.psnger.core.model.request.OrderParams m14690b(android.content.Context r23, int r24) {
        /*
            r22 = this;
            r1 = r22
            com.didi.component.service.cancelreason.cache.CancelTripCache r0 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            boolean r2 = r0.isUsingCachedEstimateParams()
            com.didi.component.business.data.form.FormStore r3 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.sdk.address.address.entity.Address r4 = r3.getStartAddress()
            java.lang.String r0 = r4.toString()
            java.lang.String r5 = "ccclxscreateorder"
            com.didi.component.common.util.GLog.m11357e(r5, r0)
            com.didi.sdk.address.address.entity.Address r0 = r3.getEndAddress()
            long r5 = r3.getTransportTime()
            com.didi.travel.psnger.core.model.request.OrderParams r7 = new com.didi.travel.psnger.core.model.request.OrderParams
            r7.<init>()
            if (r4 == 0) goto L_0x0041
            r7.setStartAddress(r4)
            java.lang.String r8 = r1.m14675a((com.didi.sdk.address.address.entity.Address) r4)
            java.lang.String r9 = "fromAddressAll"
            r7.addParam(r9, r8)
            java.lang.String r8 = r4.hideAddress
            if (r8 == 0) goto L_0x0041
            java.lang.String r8 = r4.hideAddress
            java.lang.String r9 = "startingVagueName"
            r7.addParam(r9, r8)
        L_0x0041:
            if (r0 == 0) goto L_0x005a
            r7.setEndAddress(r0)
            java.lang.String r8 = r1.m14675a((com.didi.sdk.address.address.entity.Address) r0)
            java.lang.String r9 = "toAddressAll"
            r7.addParam(r9, r8)
            java.lang.String r8 = r0.hideAddress
            if (r8 == 0) goto L_0x005a
            java.lang.String r8 = r0.hideAddress
            java.lang.String r9 = "destVagueName"
            r7.addParam(r9, r8)
        L_0x005a:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r24)
            java.lang.String r9 = "double_check"
            r7.addParam(r9, r8)
            java.lang.String r8 = com.didi.component.business.util.NationComponentDataUtil.getMapTypeString()
            java.lang.String r9 = "mapType"
            r7.addParam(r9, r8)
            int r8 = r3.Bid
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r9 = r1.f17424i
            if (r9 == 0) goto L_0x0078
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r8 = r9.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r8 = r8.carConfig
            int r8 = r8.carBussinessId
        L_0x0078:
            r7.setBusinessId(r8)
            r7.setEndAddress(r0)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r9 = "null"
            r10 = 0
            r12 = -1
            r14 = 0
            if (r4 == 0) goto L_0x00a2
            int r15 = r4.cityId
            if (r15 == 0) goto L_0x00a2
            int r15 = r4.cityId
            if (r15 == r12) goto L_0x00a2
            double r12 = r4.latitude
            int r16 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r16 == 0) goto L_0x00a2
            double r12 = r4.longitude
            int r16 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r16 != 0) goto L_0x00a0
            goto L_0x00a2
        L_0x00a0:
            r15 = 0
            goto L_0x00b7
        L_0x00a2:
            com.didi.sdk.logging.Logger r12 = r1.mLogger
            java.lang.Object[] r13 = new java.lang.Object[r14]
            java.lang.String r15 = "sendorder generateNewEstimateParams startAddress cityid or latlng error "
            r12.info((java.lang.String) r15, (java.lang.Object[]) r13)
            if (r4 == 0) goto L_0x00b0
            java.lang.String r12 = r4.searchId
            goto L_0x00b1
        L_0x00b0:
            r12 = r9
        L_0x00b1:
            java.lang.String r13 = "start_search_id"
            r8.put(r13, r12)
            r15 = 1
        L_0x00b7:
            if (r0 == 0) goto L_0x00ce
            int r12 = r0.cityId
            if (r12 == 0) goto L_0x00ce
            int r12 = r0.cityId
            r13 = -1
            if (r12 == r13) goto L_0x00ce
            double r12 = r0.latitude
            int r17 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r17 == 0) goto L_0x00ce
            double r12 = r0.longitude
            int r17 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r17 != 0) goto L_0x00e1
        L_0x00ce:
            com.didi.sdk.logging.Logger r10 = r1.mLogger
            java.lang.Object[] r11 = new java.lang.Object[r14]
            java.lang.String r12 = "sendorder generateNewEstimateParams endAddress cityid or latlng error "
            r10.info((java.lang.String) r12, (java.lang.Object[]) r11)
            if (r0 == 0) goto L_0x00db
            java.lang.String r9 = r0.searchId
        L_0x00db:
            java.lang.String r0 = "end_search_id"
            r8.put(r0, r9)
            r15 = 1
        L_0x00e1:
            if (r15 == 0) goto L_0x00e8
            int r0 = com.didiglobal.p205sa.biz.tracker.AddressMonitorTrack.mSceneCreateOrder
            com.didiglobal.p205sa.biz.tracker.AddressMonitorTrack.adddressMonitorTrack(r0, r8)
        L_0x00e8:
            r8 = 0
            int r0 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f9
            r8 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r8
            r7.setDepartureTime(r5)
            r5 = 1
            r7.setBookingType(r5)
            goto L_0x00fc
        L_0x00f9:
            r7.setBookingType(r14)
        L_0x00fc:
            int r0 = r3.getEnterpriseFlag()
            r7.setEnterpriseFlag(r0)
            if (r2 == 0) goto L_0x0116
            com.didi.component.service.cancelreason.cache.CancelTripCache r0 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            int r0 = r0.getComboType()
            com.didi.component.service.cancelreason.cache.CancelTripCache r5 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            boolean r5 = r5.isCarPool()
            goto L_0x0131
        L_0x0116:
            int r0 = r3.getCurrentComboType()
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r5 = r1.f17424i
            if (r5 == 0) goto L_0x0124
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r5.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r0 = r0.carConfig
            int r0 = r0.carComboType
        L_0x0124:
            com.didi.component.service.cancelreason.cache.CancelTripCache r5 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            r5.setComboType(r0)
            r5 = 4
            if (r0 != r5) goto L_0x0130
            r5 = 1
            goto L_0x0131
        L_0x0130:
            r5 = 0
        L_0x0131:
            java.lang.String r6 = "pool_seat"
            if (r5 == 0) goto L_0x0140
            int r8 = r3.getSeatCount()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.addParam(r6, r8)
        L_0x0140:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r8 = "car_pool"
            r7.addParam(r8, r5)
            boolean r5 = r3.isCarpoolShow()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r9 = "carpool_show"
            r7.addParam(r9, r5)
            com.didi.component.business.data.form.FormStore r5 = com.didi.component.business.data.form.FormStore.getInstance()
            boolean r5 = r5.isFromOpenRide()
            if (r5 == 0) goto L_0x0171
            com.didi.travel.psnger.model.response.PinCodeInfoResult r5 = r3.getDriverInfo()
            if (r5 == 0) goto L_0x0171
            com.didi.travel.psnger.model.response.PinCodeInfoResult r5 = r3.getDriverInfo()
            java.lang.String r5 = r5.driverId
            java.lang.String r10 = "openride_driver_id"
            r7.addParam(r10, r5)
        L_0x0171:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r5 = "combo_type"
            r7.addParam(r5, r0)
            r7.setTipPrice(r14)
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getPassengerSheetKey()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0196
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getPassengerSheetKey()
            r7.setPassengerSheetKey(r0)
        L_0x0196:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()     // Catch:{ Exception -> 0x01c1 }
            int r10 = r0.getCarLevel()     // Catch:{ Exception -> 0x01c1 }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i     // Catch:{ Exception -> 0x01bf }
            if (r0 == 0) goto L_0x01aa
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i     // Catch:{ Exception -> 0x01bf }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem     // Catch:{ Exception -> 0x01bf }
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r0 = r0.carConfig     // Catch:{ Exception -> 0x01bf }
            int r10 = r0.carLevel     // Catch:{ Exception -> 0x01bf }
        L_0x01aa:
            java.lang.String r0 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x01bf }
            r7.setCarLevelId(r0)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r0 = r22.getCustomFeaturesParam()     // Catch:{ Exception -> 0x01bf }
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01bf }
            if (r11 != 0) goto L_0x01c6
            r7.setCustomFeatures(r0)     // Catch:{ Exception -> 0x01bf }
            goto L_0x01c6
        L_0x01bf:
            r0 = move-exception
            goto L_0x01c3
        L_0x01c1:
            r0 = move-exception
            r10 = 0
        L_0x01c3:
            r0.printStackTrace()
        L_0x01c6:
            if (r2 == 0) goto L_0x01da
            com.didi.component.service.cancelreason.cache.CancelTripCache r0 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            java.lang.String r0 = r0.getEstimateTraceId()
            com.didi.component.service.cancelreason.cache.CancelTripCache r12 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r12 = r12.getNewEstimateModel()
            r11 = r0
            goto L_0x0207
        L_0x01da:
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r12 = r3.getNewEstimateItem()
            java.lang.String r0 = r3.getEstimateModelTraceId()
            java.lang.String r13 = r1.f17426k
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x01ec
            java.lang.String r0 = r1.f17426k
        L_0x01ec:
            if (r0 == 0) goto L_0x01ef
            goto L_0x01f0
        L_0x01ef:
            r0 = 0
        L_0x01f0:
            com.didi.component.service.cancelreason.cache.CancelTripCache r13 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            r13.setEstimateTraceId(r0)
            com.didi.component.service.cancelreason.cache.CancelTripCache r13 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            r17 = r12
            long r11 = java.lang.System.currentTimeMillis()
            r13.setEstimateTime(r11)
            r11 = r0
            r12 = r17
        L_0x0207:
            r7.setEstimateTraceId(r11)
            java.lang.String r13 = "count_price_type"
            if (r12 == 0) goto L_0x024b
            float r15 = r12.feeNumber
            r7.setEstimatePrice(r15)
            java.lang.String r15 = r12.estimateId
            r7.setEstimateId(r15)
            int r15 = r7.getBusinessId()
            int r0 = r12.getCarBussinessId()
            if (r15 != r0) goto L_0x0228
            int r0 = r12.getCarLevel()
            if (r10 == r0) goto L_0x022b
        L_0x0228:
            r7.setEstimateInfoMatch(r14)
        L_0x022b:
            boolean r0 = com.didi.component.business.util.EstimateUtils.isFixedPricingTypeShowing()
            if (r0 == 0) goto L_0x023b
            r0 = 101(0x65, float:1.42E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r0)
            r7.addParam(r13, r15)
            goto L_0x0244
        L_0x023b:
            int r0 = r12.countPriceType
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r13, r0)
        L_0x0244:
            com.didi.component.service.cancelreason.cache.CancelTripCache r0 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            r0.setEstimateModel((com.didi.travel.psnger.model.response.estimate.EstimateItemModel) r12)
        L_0x024b:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i
            if (r0 == 0) goto L_0x028d
            float r0 = r0.feeNumber
            r7.setEstimatePrice(r0)
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i
            java.lang.String r0 = r0.estimateId
            r7.setEstimateId(r0)
            int r0 = r7.getBusinessId()
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r15 = r1.f17424i
            int r15 = r15.getCarBussinessId()
            if (r0 != r15) goto L_0x026f
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i
            int r0 = r0.getCarLevel()
            if (r10 == r0) goto L_0x0272
        L_0x026f:
            r7.setEstimateInfoMatch(r14)
        L_0x0272:
            boolean r0 = com.didi.component.business.util.EstimateUtils.isFixedPricingTypeShowing()
            if (r0 == 0) goto L_0x0282
            r0 = 101(0x65, float:1.42E-43)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r13, r0)
            goto L_0x028d
        L_0x0282:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i
            int r0 = r0.countPriceType
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r13, r0)
        L_0x028d:
            com.didichuxing.bigdata.dp.locsdk.DIDILocationManager r0 = com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager.getInstance(r23)
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r0 = r0.getLastKnownLocation()
            r7.setLastKnownLocation(r0)
            r1.m14684a((com.didi.travel.psnger.core.model.request.OrderParams) r7)
            com.didi.travel.psnger.core.model.request.OrderParams$DTSDKOrder412Param r0 = r22.m14708g()
            r7.setOrder412Param(r0)
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()
            java.lang.String r10 = "special_start"
            if (r0 == 0) goto L_0x02b3
            r15 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r15)
            r7.addParam(r10, r0)
            goto L_0x02ba
        L_0x02b3:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)
            r7.addParam(r10, r0)
        L_0x02ba:
            java.lang.String r0 = r3.getWayPointAddressListJsonArray()
            boolean r10 = android.text.TextUtils.isEmpty(r0)
            if (r10 != 0) goto L_0x02c9
            java.lang.String r10 = "stopover_point"
            r7.addParam(r10, r0)
        L_0x02c9:
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()
            java.lang.String r10 = "station_guide_name"
            java.lang.String r15 = "station_walk_guide_link"
            if (r0 == 0) goto L_0x0313
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()
            if (r0 == 0) goto L_0x0313
            com.didi.map.global.component.departure.model.AddressWalkGuide r18 = r0.getWalkGuide()
            if (r18 == 0) goto L_0x0313
            com.didi.map.global.component.departure.model.AddressWalkGuide r18 = r0.getWalkGuide()
            java.lang.String r18 = r18.getGuidePhotoH5()
            boolean r18 = android.text.TextUtils.isEmpty(r18)
            if (r18 != 0) goto L_0x0313
            com.didi.map.global.component.departure.model.DepartureAddress r18 = r3.getAirPotAddress()
            com.didi.sdk.address.address.entity.Address r18 = r18.getAddress()
            if (r18 == 0) goto L_0x0313
            com.didi.map.global.component.departure.model.AddressWalkGuide r0 = r0.getWalkGuide()
            java.lang.String r0 = r0.getGuidePhotoH5()
            r7.addParam(r15, r0)
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()
            com.didi.sdk.address.address.entity.Address r0 = r0.getAddress()
            java.lang.String r0 = r0.displayName
            r7.addParam(r10, r0)
        L_0x0313:
            android.content.Context r0 = r1.mContext
            java.lang.String r0 = com.didi.component.business.util.GlobalSPUtil.getLastFaceSessionId(r0)
            if (r0 == 0) goto L_0x0334
            java.lang.String r14 = "last_face_session_id"
            r7.addParam(r14, r0)
            android.content.Context r0 = r1.mContext
            boolean r0 = com.didi.component.business.util.GlobalSPUtil.getLastFacePassed(r0)
            if (r0 == 0) goto L_0x032a
            r0 = 1
            goto L_0x032b
        L_0x032a:
            r0 = 2
        L_0x032b:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r14 = "last_face_passed"
            r7.addParam(r14, r0)
        L_0x0334:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r14 = r0.getNewEstimateItem()
            java.lang.String r0 = "dispatch_fee"
            if (r14 == 0) goto L_0x035d
            r19 = r11
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r11 = r14.dispatchFeeChoice     // Catch:{ Exception -> 0x0359 }
            if (r11 == 0) goto L_0x035f
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r11 = r14.dispatchFeeChoice     // Catch:{ Exception -> 0x0359 }
            java.lang.String r11 = r11.selectedValue     // Catch:{ Exception -> 0x0359 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x0359 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0359 }
            r7.addParam(r0, r11)     // Catch:{ Exception -> 0x0359 }
            r20 = r4
            r11 = 0
            goto L_0x0371
        L_0x0359:
            r20 = r4
            r11 = 0
            goto L_0x036a
        L_0x035d:
            r19 = r11
        L_0x035f:
            r20 = r4
            r11 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x036a }
            r7.addParam(r0, r4)     // Catch:{ Exception -> 0x036a }
            goto L_0x0371
        L_0x036a:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            r7.addParam(r0, r4)
        L_0x0371:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getStartParkingProperty()
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r11 = "specialPoiParkingProperty"
            if (r4 != 0) goto L_0x0384
            r7.addParam(r11, r0)
        L_0x0384:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0478 }
            r4.<init>()     // Catch:{ Exception -> 0x0478 }
            boolean r21 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0478 }
            if (r21 != 0) goto L_0x0392
            r4.put(r11, r0)     // Catch:{ Exception -> 0x0478 }
        L_0x0392:
            java.lang.String r0 = "showInterceptView"
            com.didi.component.business.data.form.FormStore r11 = com.didi.component.business.data.form.FormStore.getInstance()     // Catch:{ Exception -> 0x0478 }
            boolean r11 = r11.isShowInterceptorPop()     // Catch:{ Exception -> 0x0478 }
            r4.put(r0, r11)     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            if (r0 == 0) goto L_0x03d0
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            com.didi.sdk.address.address.entity.Address r0 = r0.getAddress()     // Catch:{ Exception -> 0x0478 }
            if (r0 == 0) goto L_0x03d0
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            com.didi.sdk.address.address.entity.Address r0 = r0.getAddress()     // Catch:{ Exception -> 0x0478 }
            java.lang.String r0 = r0.getDisplayName()     // Catch:{ Exception -> 0x0478 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0478 }
            if (r0 != 0) goto L_0x03d0
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            com.didi.sdk.address.address.entity.Address r0 = r0.getAddress()     // Catch:{ Exception -> 0x0478 }
            java.lang.String r0 = r0.getDisplayName()     // Catch:{ Exception -> 0x0478 }
            r4.put(r10, r0)     // Catch:{ Exception -> 0x0478 }
        L_0x03d0:
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            if (r0 == 0) goto L_0x0417
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x0478 }
            if (r0 == 0) goto L_0x0417
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressWalkGuide r0 = r0.getWalkGuide()     // Catch:{ Exception -> 0x0478 }
            if (r0 == 0) goto L_0x0417
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressWalkGuide r0 = r0.getWalkGuide()     // Catch:{ Exception -> 0x0478 }
            java.lang.String r0 = r0.getGuidePhotoH5()     // Catch:{ Exception -> 0x0478 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0478 }
            if (r0 != 0) goto L_0x0417
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressWalkGuide r0 = r0.getWalkGuide()     // Catch:{ Exception -> 0x0478 }
            java.lang.String r0 = r0.getGuidePhotoH5()     // Catch:{ Exception -> 0x0478 }
            r4.put(r15, r0)     // Catch:{ Exception -> 0x0478 }
        L_0x0417:
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            if (r0 == 0) goto L_0x0460
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x0478 }
            if (r0 == 0) goto L_0x0460
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressWalkGuide r0 = r0.getWalkGuide()     // Catch:{ Exception -> 0x0478 }
            if (r0 == 0) goto L_0x0460
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressWalkGuide r0 = r0.getWalkGuide()     // Catch:{ Exception -> 0x0478 }
            java.lang.String r0 = r0.getGuidePhoto()     // Catch:{ Exception -> 0x0478 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0478 }
            if (r0 != 0) goto L_0x0460
            java.lang.String r0 = "walk_guide_photo"
            com.didi.map.global.component.departure.model.DepartureAddress r10 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressExtendInfo r10 = r10.getExtendInfo()     // Catch:{ Exception -> 0x0478 }
            com.didi.map.global.component.departure.model.AddressWalkGuide r10 = r10.getWalkGuide()     // Catch:{ Exception -> 0x0478 }
            java.lang.String r10 = r10.getGuidePhoto()     // Catch:{ Exception -> 0x0478 }
            r4.put(r0, r10)     // Catch:{ Exception -> 0x0478 }
        L_0x0460:
            java.lang.String r0 = "is_show_real_pic_in_xpanel"
            boolean r10 = r3.isShowRealPicInXpanel()     // Catch:{ Exception -> 0x0478 }
            if (r10 != 0) goto L_0x046a
            r15 = 1
            goto L_0x046b
        L_0x046a:
            r15 = 0
        L_0x046b:
            r4.put(r0, r15)     // Catch:{ Exception -> 0x0478 }
            java.lang.String r0 = "ibt_map_data"
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0478 }
            r7.addParam(r0, r4)     // Catch:{ Exception -> 0x0478 }
            goto L_0x047c
        L_0x0478:
            r0 = move-exception
            r0.printStackTrace()
        L_0x047c:
            java.lang.String r0 = r3.getFlightNum()
            r7.setFlightNum(r0)
            if (r14 == 0) goto L_0x048e
            com.didi.travel.psnger.model.response.estimate.NewEsimateCompanyOperation r0 = r14.company
            if (r0 == 0) goto L_0x048e
            com.didi.travel.psnger.model.response.estimate.NewEsimateCompanyOperation r0 = r14.company
            com.didi.travel.psnger.model.response.TaxiCompanyListModel$CompanyModel r11 = r0.companyModel
            goto L_0x048f
        L_0x048e:
            r11 = 0
        L_0x048f:
            java.lang.String r0 = "1"
            if (r11 == 0) goto L_0x04a6
            java.lang.String r4 = r11.f46886id
            boolean r4 = r0.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x04a6
            r4 = 2
            java.lang.Integer r10 = java.lang.Integer.valueOf(r4)
            java.lang.String r4 = "assign_company_type"
            r7.addParam(r4, r10)
            goto L_0x04cd
        L_0x04a6:
            if (r11 == 0) goto L_0x04cd
            java.lang.String r4 = r11.f46886id
            boolean r4 = com.didi.sdk.util.TextUtil.isEmpty(r4)
            if (r4 != 0) goto L_0x04cd
            java.lang.String r4 = r11.f46886id
            java.lang.String r10 = "0"
            boolean r4 = r10.equals(r4)
            if (r4 != 0) goto L_0x04cd
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            java.lang.String r10 = r11.f46886id
            r4.put(r10)
            java.lang.String r4 = r4.toString()
            java.lang.String r10 = "company_group_ids"
            r7.addParam(r10, r4)
        L_0x04cd:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r10 = ""
            r4.append(r10)
            com.didi.component.business.data.form.FormStore r10 = com.didi.component.business.data.form.FormStore.getInstance()
            int r10 = r10.getCarpoolOrderScene()
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            java.lang.String r10 = "carpool_order_scene"
            r7.addParam(r10, r4)
            boolean r4 = r3.isTwoPriceBiz()
            if (r4 == 0) goto L_0x0506
            int r4 = r3.getSeatCount()
            r11 = 2
            if (r4 > r11) goto L_0x0506
            r7.addParam(r10, r0)
            int r0 = r3.getSeatCount()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r6, r0)
        L_0x0506:
            if (r2 == 0) goto L_0x0510
            com.didi.component.service.cancelreason.cache.CancelTripCache r0 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            r2 = 0
            r0.setUsingCacheEstimateParams(r2)
        L_0x0510:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i
            java.lang.String r2 = "intercepted"
            if (r0 == 0) goto L_0x0546
            com.didi.travel.psnger.model.response.CarConfig$ConfirmActionInfo r0 = r22.getConfirmActionInfo()
            if (r0 == 0) goto L_0x0546
            boolean r0 = r0.validated()
            if (r0 == 0) goto L_0x0546
            org.json.JSONObject r0 = r3.getDeliveryInfo()
            if (r0 == 0) goto L_0x0546
            java.lang.String r4 = r0.toString()
            r11 = 1
            r0.put(r2, r11)     // Catch:{ JSONException -> 0x0542 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0542 }
            r0.<init>(r4)     // Catch:{ JSONException -> 0x0542 }
            r0.remove(r2)     // Catch:{ JSONException -> 0x0542 }
            java.lang.String r4 = "delivery_info"
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0542 }
            r7.addParam(r4, r0)     // Catch:{ JSONException -> 0x0542 }
            goto L_0x0546
        L_0x0542:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0546:
            if (r12 == 0) goto L_0x057c
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.CarConfig$ConfirmActionInfo r0 = r0.getConfirmActionInfo()
            if (r0 == 0) goto L_0x057c
            boolean r0 = r0.validated()
            if (r0 == 0) goto L_0x057c
            org.json.JSONObject r0 = r3.getDeliveryInfo()
            if (r0 == 0) goto L_0x057c
            java.lang.String r4 = r0.toString()
            r11 = 1
            r0.put(r2, r11)     // Catch:{ JSONException -> 0x0578 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0578 }
            r0.<init>(r4)     // Catch:{ JSONException -> 0x0578 }
            r0.remove(r2)     // Catch:{ JSONException -> 0x0578 }
            java.lang.String r2 = "delivery_info"
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0578 }
            r7.addParam(r2, r0)     // Catch:{ JSONException -> 0x0578 }
            goto L_0x057c
        L_0x0578:
            r0 = move-exception
            r0.printStackTrace()
        L_0x057c:
            java.util.Map r2 = r7.getParams()
            if (r2 == 0) goto L_0x060f
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i
            if (r0 == 0) goto L_0x060f
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r0 = r0.carConfig
            if (r0 == 0) goto L_0x05ca
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r0 = r0.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r0 = r0.extraData
            if (r0 == 0) goto L_0x05ca
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r0 = r0.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r0 = r0.extraData
            com.google.gson.JsonObject r0 = r0.orderParamsObject
            if (r0 == 0) goto L_0x05ca
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x05c6 }
            r0.<init>()     // Catch:{ Exception -> 0x05c6 }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r4 = r1.f17424i     // Catch:{ Exception -> 0x05c6 }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r4 = r4.mAnyCarEstimateNetItem     // Catch:{ Exception -> 0x05c6 }
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r4 = r4.carConfig     // Catch:{ Exception -> 0x05c6 }
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r4 = r4.extraData     // Catch:{ Exception -> 0x05c6 }
            com.google.gson.JsonObject r4 = r4.orderParamsObject     // Catch:{ Exception -> 0x05c6 }
            com.didi.component.service.AbsSendOrderServicePresenter$13 r11 = new com.didi.component.service.AbsSendOrderServicePresenter$13     // Catch:{ Exception -> 0x05c6 }
            r11.<init>()     // Catch:{ Exception -> 0x05c6 }
            java.lang.reflect.Type r11 = r11.getType()     // Catch:{ Exception -> 0x05c6 }
            java.lang.Object r0 = r0.fromJson((com.google.gson.JsonElement) r4, (java.lang.reflect.Type) r11)     // Catch:{ Exception -> 0x05c6 }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x05c6 }
            if (r0 == 0) goto L_0x05ca
            r2.putAll(r0)     // Catch:{ Exception -> 0x05c6 }
            goto L_0x05ca
        L_0x05c6:
            r0 = move-exception
            r0.printStackTrace()
        L_0x05ca:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i
            java.util.HashMap r4 = r0.getSelectedValueMap()
            int r0 = r4.size()
            if (r0 <= 0) goto L_0x060f
            java.util.Set r0 = r4.keySet()
            java.util.Iterator r11 = r0.iterator()
        L_0x05de:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x060f
            java.lang.Object r0 = r11.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x060a }
            com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0     // Catch:{ Exception -> 0x060a }
            com.google.gson.Gson r12 = new com.google.gson.Gson     // Catch:{ Exception -> 0x060a }
            r12.<init>()     // Catch:{ Exception -> 0x060a }
            com.didi.component.service.AbsSendOrderServicePresenter$14 r14 = new com.didi.component.service.AbsSendOrderServicePresenter$14     // Catch:{ Exception -> 0x060a }
            r14.<init>()     // Catch:{ Exception -> 0x060a }
            java.lang.reflect.Type r14 = r14.getType()     // Catch:{ Exception -> 0x060a }
            java.lang.Object r0 = r12.fromJson((com.google.gson.JsonElement) r0, (java.lang.reflect.Type) r14)     // Catch:{ Exception -> 0x060a }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x060a }
            if (r0 == 0) goto L_0x05de
            r2.putAll(r0)     // Catch:{ Exception -> 0x060a }
            goto L_0x05de
        L_0x060a:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x05de
        L_0x060f:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r4 = r0.getNewEstimateItem()
            if (r2 == 0) goto L_0x0769
            if (r4 == 0) goto L_0x0769
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r0 = r4.carConfig
            if (r0 == 0) goto L_0x06c8
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r0 = r4.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r0 = r0.extraData
            if (r0 == 0) goto L_0x06c8
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r0 = r4.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r0 = r0.extraData
            com.google.gson.JsonObject r0 = r0.orderParamsObject
            if (r0 == 0) goto L_0x06c8
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x064e }
            r0.<init>()     // Catch:{ Exception -> 0x064e }
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r11 = r4.carConfig     // Catch:{ Exception -> 0x064e }
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r11 = r11.extraData     // Catch:{ Exception -> 0x064e }
            com.google.gson.JsonObject r11 = r11.orderParamsObject     // Catch:{ Exception -> 0x064e }
            com.didi.component.service.AbsSendOrderServicePresenter$15 r12 = new com.didi.component.service.AbsSendOrderServicePresenter$15     // Catch:{ Exception -> 0x064e }
            r12.<init>()     // Catch:{ Exception -> 0x064e }
            java.lang.reflect.Type r12 = r12.getType()     // Catch:{ Exception -> 0x064e }
            java.lang.Object r0 = r0.fromJson((com.google.gson.JsonElement) r11, (java.lang.reflect.Type) r12)     // Catch:{ Exception -> 0x064e }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x064e }
            if (r0 == 0) goto L_0x06c8
            r2.putAll(r0)     // Catch:{ Exception -> 0x064e }
            goto L_0x06c8
        L_0x064e:
            r0 = move-exception
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r11 = r4.carConfig
            if (r11 == 0) goto L_0x06c8
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r11 = r4.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r11 = r11.extraData
            if (r11 == 0) goto L_0x06c8
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r11 = r4.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r11 = r11.extraData
            com.didi.travel.psnger.model.response.estimate.OrderParams r11 = r11.getOrderParams()
            if (r11 == 0) goto L_0x06c8
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r11 = r4.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r11 = r11.extraData
            com.didi.travel.psnger.model.response.estimate.OrderParams r11 = r11.getOrderParams()
            java.lang.String r12 = "AbsSendOrderServicePresenter"
            com.didichuxing.omega.sdk.Omega.trackError(r12, r0)
            int r0 = r11.availableStatus
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r12 = "available_status"
            r7.addParam(r12, r0)
            float r0 = r11.feeAmount
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            java.lang.String r12 = "estimate_price"
            r7.addParam(r12, r0)
            int r0 = r11.countPriceType
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r13, r0)
            int r0 = r11.carPoolShow
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r9, r0)
            int r0 = r11.comboId
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r9 = "combo_id"
            r7.addParam(r9, r0)
            int r0 = r11.sceneType
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r9 = "scene_type"
            r7.addParam(r9, r0)
            int r0 = r11.availableStatus
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r9 = "available_status"
            r7.addParam(r9, r0)
            java.lang.String r0 = r11.bubbleId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x06c8
            java.lang.String r0 = r11.bubbleId
            java.lang.String r9 = "bubble_id"
            r7.addParam(r9, r0)
        L_0x06c8:
            java.util.HashMap r9 = r4.getSelectedValueMap()
            int r0 = r9.size()
            if (r0 <= 0) goto L_0x0769
            java.util.Set r0 = r9.keySet()
            java.util.Iterator r11 = r0.iterator()
        L_0x06da:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0769
            java.lang.Object r0 = r11.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r9.get(r0)     // Catch:{ Exception -> 0x0706 }
            com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0     // Catch:{ Exception -> 0x0706 }
            com.google.gson.Gson r12 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0706 }
            r12.<init>()     // Catch:{ Exception -> 0x0706 }
            com.didi.component.service.AbsSendOrderServicePresenter$16 r14 = new com.didi.component.service.AbsSendOrderServicePresenter$16     // Catch:{ Exception -> 0x0706 }
            r14.<init>()     // Catch:{ Exception -> 0x0706 }
            java.lang.reflect.Type r14 = r14.getType()     // Catch:{ Exception -> 0x0706 }
            java.lang.Object r0 = r12.fromJson((com.google.gson.JsonElement) r0, (java.lang.reflect.Type) r14)     // Catch:{ Exception -> 0x0706 }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x0706 }
            if (r0 == 0) goto L_0x06da
            r2.putAll(r0)     // Catch:{ Exception -> 0x0706 }
            goto L_0x06da
        L_0x0706:
            r0 = move-exception
            r0.printStackTrace()
            com.didi.travel.psnger.model.response.estimate.SelectedValueParams r12 = r4.getSelectedValueParams()
            if (r12 == 0) goto L_0x06da
            java.lang.String r14 = "AbsSendOrderServicePresenter"
            com.didichuxing.omega.sdk.Omega.trackError(r14, r0)
            java.lang.String r0 = r12.seatPoolEstimateId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0724
            java.lang.String r0 = r12.seatPoolEstimateId
            java.lang.String r14 = "estimate_id"
            r7.addParam(r14, r0)
        L_0x0724:
            float r0 = r12.seatPoolEstimatePrice
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            java.lang.String r14 = "estimate_price"
            r7.addParam(r14, r0)
            int r0 = r12.seatPoolCountType
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r13, r0)
            int r0 = r12.carpoolOrderScene
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r10, r0)
            int r0 = r12.carPool
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r8, r0)
            int r0 = r12.poolSeat
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r6, r0)
            int r0 = r12.comboType
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r5, r0)
            int r0 = r12.comboId
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r12 = "combo_id"
            r7.addParam(r12, r0)
            goto L_0x06da
        L_0x0769:
            java.lang.String r0 = r3.getBubbleId()
            java.lang.String r2 = "bubble_id"
            r7.addParam(r2, r0)
            com.didi.sdk.nation.NationComponentData r0 = com.didi.sdk.nation.NationTypeUtil.getNationComponentData()     // Catch:{ Exception -> 0x0780 }
            java.lang.String r0 = r0.getCityId()     // Catch:{ Exception -> 0x0780 }
            int r13 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0780 }
            r2 = -1
            goto L_0x0782
        L_0x0780:
            r2 = -1
            r13 = -1
        L_0x0782:
            if (r13 == r2) goto L_0x078d
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            java.lang.String r2 = "city_id"
            r7.addParam(r2, r0)
        L_0x078d:
            com.didi.map.global.component.departure.model.DepartureAddress r0 = new com.didi.map.global.component.departure.model.DepartureAddress
            r0.<init>()
            r2 = r20
            r0.setAddress(r2)
            com.didi.map.global.component.departure.model.DepartureAddress r2 = r3.getAirPotAddress()
            if (r2 == 0) goto L_0x07a1
            r2 = 0
            r0.setZoneType(r2)
        L_0x07a1:
            android.content.Context r2 = r1.mContext
            boolean r0 = com.didi.map.global.flow.utils.SceneUtils.isCallForOther(r2, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "is_callcar"
            r7.addParam(r2, r0)
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            boolean r0 = r0.isHasSubstituteCall()
            if (r0 == 0) goto L_0x0808
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem r0 = r0.getSelectedFriend()
            if (r0 == 0) goto L_0x0808
            com.didi.travel.psnger.model.response.estimate.daijiao.Extension r2 = r0.getExtension()
            if (r2 == 0) goto L_0x0808
            com.didi.travel.psnger.model.response.estimate.daijiao.Extension r2 = r0.getExtension()
            com.google.gson.JsonObject r2 = r2.getSelectValueParams()
            if (r2 == 0) goto L_0x0808
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x0804 }
            r2.<init>()     // Catch:{ JsonSyntaxException -> 0x0804 }
            com.didi.travel.psnger.model.response.estimate.daijiao.Extension r0 = r0.getExtension()     // Catch:{ JsonSyntaxException -> 0x0804 }
            com.google.gson.JsonObject r0 = r0.getSelectValueParams()     // Catch:{ JsonSyntaxException -> 0x0804 }
            com.didi.component.service.AbsSendOrderServicePresenter$17 r5 = new com.didi.component.service.AbsSendOrderServicePresenter$17     // Catch:{ JsonSyntaxException -> 0x0804 }
            r5.<init>()     // Catch:{ JsonSyntaxException -> 0x0804 }
            java.lang.reflect.Type r5 = r5.getType()     // Catch:{ JsonSyntaxException -> 0x0804 }
            java.lang.Object r0 = r2.fromJson((com.google.gson.JsonElement) r0, (java.lang.reflect.Type) r5)     // Catch:{ JsonSyntaxException -> 0x0804 }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ JsonSyntaxException -> 0x0804 }
            boolean r2 = com.didiglobal.travel.util.CollectionUtils.isEmpty((java.util.Map<?, ?>) r0)     // Catch:{ JsonSyntaxException -> 0x0804 }
            if (r2 != 0) goto L_0x0808
            java.util.Map r2 = r7.getParams()     // Catch:{ JsonSyntaxException -> 0x0804 }
            if (r2 == 0) goto L_0x0808
            java.util.Map r2 = r7.getParams()     // Catch:{ JsonSyntaxException -> 0x0804 }
            r2.putAll(r0)     // Catch:{ JsonSyntaxException -> 0x0804 }
            goto L_0x0808
        L_0x0804:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0808:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i
            java.lang.String r2 = "user_input_price"
            if (r0 == 0) goto L_0x08af
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem
            if (r0 == 0) goto L_0x08af
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r0 = r0.carBreakModel
            if (r0 == 0) goto L_0x08af
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f17424i
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r0 = r0.carBreakModel
            java.lang.String r0 = r0.offer_flex_price_scheme
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x08af
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getInputOfferPrice()
            com.didi.sdk.logging.Logger r5 = r1.mLogger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = " generateCreateOrderParams flex input price ="
            r6.append(r8)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r8 = 0
            java.lang.Object[] r9 = new java.lang.Object[r8]
            r5.info((java.lang.String) r6, (java.lang.Object[]) r9)
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 == 0) goto L_0x0857
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getFlex_recommend_price()
        L_0x0857:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x0860
            r7.addParam(r2, r0)
        L_0x0860:
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r6 = "estimate_trace_id"
            r8 = r19
            r5.put(r6, r8)
            r5.put(r2, r0)
            r0 = 5
            java.lang.String r6 = "ibt_monitor_flex_error_ck"
            com.didi.component.business.tracker.flex.FlexTrack.track(r6, r0, r5)
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getFlex_order_params()
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x08af
            com.google.gson.Gson r5 = new com.google.gson.Gson     // Catch:{ Exception -> 0x08ab }
            r5.<init>()     // Catch:{ Exception -> 0x08ab }
            com.didi.component.service.AbsSendOrderServicePresenter$18 r6 = new com.didi.component.service.AbsSendOrderServicePresenter$18     // Catch:{ Exception -> 0x08ab }
            r6.<init>()     // Catch:{ Exception -> 0x08ab }
            java.lang.reflect.Type r6 = r6.getType()     // Catch:{ Exception -> 0x08ab }
            java.lang.Object r0 = r5.fromJson((java.lang.String) r0, (java.lang.reflect.Type) r6)     // Catch:{ Exception -> 0x08ab }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x08ab }
            boolean r5 = com.didiglobal.travel.util.CollectionUtils.isEmpty((java.util.Map<?, ?>) r0)     // Catch:{ Exception -> 0x08ab }
            if (r5 != 0) goto L_0x08af
            java.util.Map r5 = r7.getParams()     // Catch:{ Exception -> 0x08ab }
            if (r5 == 0) goto L_0x08af
            java.util.Map r5 = r7.getParams()     // Catch:{ Exception -> 0x08ab }
            r5.putAll(r0)     // Catch:{ Exception -> 0x08ab }
            goto L_0x08af
        L_0x08ab:
            r0 = move-exception
            r0.printStackTrace()
        L_0x08af:
            if (r4 == 0) goto L_0x0948
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r0 = r4.carBreakModel
            if (r0 == 0) goto L_0x0948
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r0 = r4.carBreakModel
            java.lang.String r0 = r0.offer_flex_price_scheme
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0948
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getInputOfferPrice()
            com.didi.sdk.logging.Logger r4 = r1.mLogger
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = " generateCreateOrderParams flex input price ="
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r4.info((java.lang.String) r5, (java.lang.Object[]) r6)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L_0x08ee
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getFlex_recommend_price()
        L_0x08ee:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x08f7
            r7.addParam(r2, r0)
        L_0x08f7:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r3 = r3.getEstimateModelTraceId()
            java.lang.String r5 = "estimate_trace_id"
            r4.put(r5, r3)
            r4.put(r2, r0)
            r0 = 5
            java.lang.String r2 = "ibt_monitor_flex_error_ck"
            com.didi.component.business.tracker.flex.FlexTrack.track(r2, r0, r4)
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getFlex_order_params()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0948
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0944 }
            r2.<init>()     // Catch:{ Exception -> 0x0944 }
            com.didi.component.service.AbsSendOrderServicePresenter$19 r3 = new com.didi.component.service.AbsSendOrderServicePresenter$19     // Catch:{ Exception -> 0x0944 }
            r3.<init>()     // Catch:{ Exception -> 0x0944 }
            java.lang.reflect.Type r3 = r3.getType()     // Catch:{ Exception -> 0x0944 }
            java.lang.Object r0 = r2.fromJson((java.lang.String) r0, (java.lang.reflect.Type) r3)     // Catch:{ Exception -> 0x0944 }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x0944 }
            boolean r2 = com.didiglobal.travel.util.CollectionUtils.isEmpty((java.util.Map<?, ?>) r0)     // Catch:{ Exception -> 0x0944 }
            if (r2 != 0) goto L_0x0948
            java.util.Map r2 = r7.getParams()     // Catch:{ Exception -> 0x0944 }
            if (r2 == 0) goto L_0x0948
            java.util.Map r2 = r7.getParams()     // Catch:{ Exception -> 0x0944 }
            r2.putAll(r0)     // Catch:{ Exception -> 0x0944 }
            goto L_0x0948
        L_0x0944:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0948:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.f17425j
            boolean r0 = com.didi.sdk.util.collection.CollectionUtil.isEmpty((java.util.Map<?, ?>) r0)
            if (r0 != 0) goto L_0x0959
            java.util.Map r0 = r7.getParams()
            java.util.Map<java.lang.String, java.lang.Object> r2 = r1.f17425j
            r0.putAll(r2)
        L_0x0959:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.service.AbsSendOrderServicePresenter.m14690b(android.content.Context, int):com.didi.travel.psnger.core.model.request.OrderParams");
    }

    public CarConfig.ConfirmActionInfo getConfirmActionInfo() {
        AnyCarEstimateItemModel anyCarEstimateItemModel = this.f17424i;
        if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel == null || this.f17424i.mAnyCarEstimateNetItem.carBreakModel.carBreakDelivery == null || this.f17424i.mAnyCarEstimateNetItem.carConfig == null)) {
            try {
                JSONObject jSONObject = new JSONObject(this.f17424i.mAnyCarEstimateNetItem.carBreakModel.carBreakDelivery.toString());
                return new CarConfig.ConfirmActionInfo(this.f17424i.mAnyCarEstimateNetItem.carConfig.carProductId + "", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: c */
    private void m14696c() {
        Serializable serializable = this.f17429r.getSerializable(BaseExtras.Common.EXTRA_CREATE_ORDER);
        setParam(serializable instanceof CreateOrderParam ? (CreateOrderParam) serializable : null);
    }

    /* access modifiers changed from: protected */
    public void setParam(CreateOrderParam createOrderParam) {
        boolean z;
        CarOperationDataModel.AnycarCarpoolSeat anycarCarpoolSeat;
        HashMap hashMap = new HashMap();
        this.f17425j = hashMap;
        hashMap.put("is_anycar", "0");
        if (createOrderParam != null) {
            List<AnyCarEstimateItemModel> list = createOrderParam.mAllCar;
            List<AnyCarEstimateItemModel> list2 = createOrderParam.mAnyCarSelectedItemModels;
            AnyCarEstimateItemModel anyCarEstimateItemModel = createOrderParam.mSelectedSingleModel;
            this.f17428m = list2;
            this.f17427l = anyCarEstimateItemModel;
            TripListener tripListener = PageCompDataTransfer.getInstance().getTripListener();
            if (tripListener != null) {
                tripListener.setSelectedSingleAnyCarItem(anyCarEstimateItemModel);
                tripListener.setSelectedAnyCarItem(list2);
                tripListener.setPreference(createOrderParam.mPreference);
                tripListener.setIsAnyCar(createOrderParam.mIsAnyCar);
                tripListener.setGroups(createOrderParam.groups);
            }
            int i = createOrderParam.mPreference;
            this.f17426k = createOrderParam.mTraceId;
            if (anyCarEstimateItemModel != null) {
                this.f17424i = anyCarEstimateItemModel;
                return;
            }
            HashMap hashMap2 = new HashMap();
            ArrayList arrayList = new ArrayList();
            int i2 = 1;
            if (this.f17427l == null && !CollectionUtil.isEmpty((Collection<?>) list) && !CollectionUtil.isEmpty((Collection<?>) list2)) {
                for (AnyCarEstimateItemModel next : list) {
                    if (next.mAnyCarEstimateNetItem.carConfig.singleCarSelect != 2) {
                        HashMap hashMap3 = new HashMap();
                        Iterator<AnyCarEstimateItemModel> it = list2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            AnyCarEstimateItemModel next2 = it.next();
                            if (next != null && next2 != null && next.mAnyCarEstimateNetItem.carConfig != null && next2.mAnyCarEstimateNetItem.carConfig != null && !TextUtils.isEmpty(next.mAnyCarEstimateNetItem.carConfig.uniqueId) && next.mAnyCarEstimateNetItem.carConfig.uniqueId.equals(next2.mAnyCarEstimateNetItem.carConfig.uniqueId) && next2.mAnyCarEstimateNetItem.carConfig.extraData != null) {
                                if (this.f17424i == null) {
                                    this.f17424i = next2;
                                }
                                next.mAnyCarEstimateNetItem.carConfig.extraData.putOrderParams(hashMap3);
                                if (!(next2 == null || next2.anycarCarpool == null || next2.anycarCarpool.operationData == null || CollectionUtil.isEmpty((Collection<?>) next2.anycarCarpool.operationData.anycarCarpoolSeatList) || (anycarCarpoolSeat = next2.anycarCarpool.operationData.anycarCarpoolSeatList.get(next2.anycarCarpool.mSelectedIndex)) == null || anycarCarpoolSeat.selectValueParams == null)) {
                                    try {
                                        hashMap3.putAll((HashMap) new Gson().fromJson((JsonElement) anycarCarpoolSeat.selectValueParams, new TypeToken<HashMap<String, Object>>() {
                                        }.getType()));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                hashMap3.put(ParamConst.PARAM_IS_SELECTED, 1);
                                arrayList.add(new JSONObject(hashMap3));
                                z = true;
                            }
                        }
                        if (!(z || next == null || next.mAnyCarEstimateNetItem.carConfig == null || next.mAnyCarEstimateNetItem.carConfig.extraData == null)) {
                            next.mAnyCarEstimateNetItem.carConfig.extraData.putOrderParams(hashMap3);
                            hashMap3.put(ParamConst.PARAM_IS_SELECTED, 0);
                            arrayList.add(new JSONObject(hashMap3));
                        }
                    }
                }
            }
            hashMap2.put(ParamKeys.PARAM_ANYCAR_PREFERENCE, Integer.valueOf(i));
            hashMap2.put("products_info", arrayList);
            Map<String, Object> map = this.f17425j;
            if (arrayList.size() == 0) {
                i2 = 0;
            }
            map.put("is_anycar", Integer.valueOf(i2));
            this.f17425j.put("anycar_info", hashMap2);
        }
    }

    /* renamed from: a */
    private String m14675a(Address address) {
        if (address != null) {
            if (!TextUtils.isEmpty(address.getFullName())) {
                return address.getFullName();
            }
            if (!TextUtils.isEmpty(address.getDisplayName())) {
                return address.getDisplayName();
            }
            if (!TextUtils.isEmpty(address.getName())) {
                return address.getName();
            }
        }
        return ResourcesHelper.getString(this.mContext, R.string.global_pin_location);
    }

    /* access modifiers changed from: protected */
    public void onOrderCreated(CarOrder carOrder) {
        CarInfo carInfo;
        this.mLogger.info("onOrderCreated", new Object[0]);
        if (carOrder != null) {
            TravelUtil.checkAndStoreOid(carOrder.oid, this.TAG);
            GlobalSPUtil.setRedPacketOid(this.mContext, carOrder.getOid());
            if (carOrder.checkIsSplitFare == 1 && carOrder.checkSplitStatus == 0) {
                carOrder.errno = 30001;
                onOrderCreateFail(carOrder);
                return;
            }
            if (carOrder.isNearbyWait == 1) {
                doPublish(BaseEventKeys.WaitRsp.EVENT_WAIT_NEARBY_ORDER_MATCH, carOrder.getOid());
                doPublish(BaseEventKeys.WaitRsp.EVENT_WAIT_NEARBY_MARK, true);
                doPublish(BaseEventKeys.WaitRsp.EVENT_WAIT_NEARBY_SHOW);
            }
            AnyCarEstimateItemModel anyCarEstimateItemModel = this.f17424i;
            if (anyCarEstimateItemModel != null) {
                int carBussinessId = anyCarEstimateItemModel.getCarBussinessId();
                if (carBussinessId == 0) {
                    carBussinessId = FormStore.getInstance().Bid;
                }
                CarOrderHelper.fillOrder(carOrder, carBussinessId);
            } else {
                CarOrderHelper.fillOrder(carOrder, FormStore.getInstance().Bid);
            }
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem == null || newEstimateItem.carConfig == null) {
                carInfo = null;
            } else {
                carInfo = new CarInfo();
                carInfo.setCarLevel(newEstimateItem.carConfig.carLevel);
                carInfo.setBusinessNumId(newEstimateItem.carConfig.carBussinessId);
                carInfo.setMapIcon(newEstimateItem.carConfig.carMapIconUrl);
                carInfo.setComboType(newEstimateItem.carConfig.carComboType);
            }
            if (carInfo != null && carInfo.getBusinessNumId() > 0 && carInfo.getCarLevel() > 0 && carOrder.productid > 0 && NumberUtil.parseInt(carOrder.carLevel) > 0) {
                GlobalSPUtil.saveLastCreatedOrderCarInfo(this.mContext, carOrder.productid, NumberUtil.parseInt(carOrder.carLevel), carInfo.getBusinessNumId(), carInfo.getCarLevel(), carInfo.getComboType(), !TextUtil.isEmpty(carOrder.carPoolOrderScene) ? NumberUtil.parseInt(carOrder.carPoolOrderScene) : -1);
            }
            doPublish(BaseEventKeys.Service.EVENT_ORDER_CREATED, carOrder.getOid());
            if (!FormStore.getInstance().isInMiniBus()) {
                XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
            }
            FormStore.getInstance().setFlexOfferPrice(false);
            FormStore.getInstance().setDeliveryInfo((JSONObject) null);
            this.mLogger.info("onOrderCreated id = " + carOrder.getOid(), new Object[0]);
            GlobalOmegaUtils.setOrderType(carOrder.orderType);
            m14697c(carOrder);
        }
    }

    /* renamed from: c */
    private void m14697c(CarOrder carOrder) {
        HashMap hashMap = new HashMap();
        hashMap.put("country_code", BusinessUtils.getCountryIsoCode(this.mBusinessContext));
        hashMap.put("city_id", Integer.valueOf(BusinessUtils.getCurrentCityId(this.mBusinessContext)));
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            hashMap.put("scene", 0);
            hashMap.put("combo_type", 0);
            hashMap.put("require_level", Integer.valueOf(newEstimateItem.getCarLevel()));
        }
        if (this.f17424i != null) {
            hashMap.put("scene", 0);
            hashMap.put("combo_type", 0);
            hashMap.put("require_level", Integer.valueOf(this.f17424i.getCarLevel()));
        }
        hashMap.put(ServerParam.PARAM_NETWORK_TYPE, SystemUtil.getNetworkType());
        hashMap.put("response", Integer.valueOf(carOrder.errno));
        GlobalOmegaUtils.trackEvent("p_requireDlg_sendOrderStatus_ck", (Map<String, Object>) hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("search_id", SearchIdUploadManager.getInstance().getSearchIdBunch());
        hashMap2.put("bubble_id", SearchIdUploadManager.getInstance().getBubbleId());
        GlobalOmegaUtils.trackEvent("searchid_upload", (Map<String, Object>) hashMap2);
        SearchIdUploadManager.getInstance().clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.didi.travel.psnger.model.CommonPopUp} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r5v21 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onOrderCreateFail(final com.didi.travel.psnger.model.response.CarOrder r13) {
        /*
            r12 = this;
            r0 = 2131953657(0x7f1307f9, float:1.9543791E38)
            r1 = 0
            if (r13 != 0) goto L_0x0023
            com.didi.sdk.logging.Logger r13 = r12.mLogger
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "onOrderCreateFail  order == null"
            r13.info((java.lang.String) r2, (java.lang.Object[]) r1)
            android.content.Context r13 = r12.mContext
            androidx.fragment.app.Fragment r1 = r12.getHost()
            androidx.fragment.app.FragmentManager r1 = r1.getFragmentManager()
            android.content.Context r2 = r12.mContext
            java.lang.String r0 = r2.getString(r0)
            com.didi.component.service.util.SendOrderTipDialogHelper.showOrderFailDialog(r13, r1, r0)
            return
        L_0x0023:
            com.didi.sdk.logging.Logger r2 = r12.mLogger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "onOrderCreateFail  errorCode == "
            r3.append(r4)
            int r4 = r13.getErrorCode()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r2.info((java.lang.String) r3, (java.lang.Object[]) r4)
            java.lang.String r2 = r13.errmsg
            boolean r2 = com.didi.sdk.util.TextUtil.isEmpty(r2)
            if (r2 == 0) goto L_0x004f
            android.content.Context r2 = r12.mContext
            java.lang.String r0 = r2.getString(r0)
            r13.errmsg = r0
        L_0x004f:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            boolean r0 = r0.isInMiniBus()
            if (r0 == 0) goto L_0x0060
            boolean r0 = r12.orderIntercept(r13)
            if (r0 == 0) goto L_0x0060
            return
        L_0x0060:
            boolean r0 = r12.m14694b((com.didi.travel.psnger.model.response.CarOrder) r13)
            if (r0 == 0) goto L_0x0067
            return
        L_0x0067:
            int r0 = r13.getErrorCode()
            r2 = 1127(0x467, float:1.579E-42)
            if (r0 == r2) goto L_0x048a
            r2 = 1128(0x468, float:1.58E-42)
            r3 = 1
            if (r0 == r2) goto L_0x0440
            r2 = 20010(0x4e2a, float:2.804E-41)
            r4 = 2131954688(0x7f130c00, float:1.9545882E38)
            if (r0 == r2) goto L_0x0410
            r2 = 20011(0x4e2b, float:2.8041E-41)
            r5 = 0
            if (r0 == r2) goto L_0x0398
            r2 = 2131953658(0x7f1307fa, float:1.9543793E38)
            r4 = 2131233549(0x7f080b0d, float:1.8083239E38)
            switch(r0) {
                case 101: goto L_0x036d;
                case 596: goto L_0x035d;
                case 1011: goto L_0x036d;
                case 1016: goto L_0x0347;
                case 1020: goto L_0x0335;
                case 1039: goto L_0x0347;
                case 1047: goto L_0x0347;
                case 1053: goto L_0x02a4;
                case 1055: goto L_0x0295;
                case 1102: goto L_0x0285;
                case 1123: goto L_0x0285;
                case 1144: goto L_0x0279;
                case 1154: goto L_0x01d9;
                case 10625: goto L_0x0197;
                case 20077: goto L_0x0186;
                case 30001: goto L_0x015b;
                default: goto L_0x0089;
            }
        L_0x0089:
            switch(r0) {
                case 1058: goto L_0x014c;
                case 1059: goto L_0x0120;
                case 1060: goto L_0x0116;
                default: goto L_0x008c;
            }
        L_0x008c:
            switch(r0) {
                case 1133: goto L_0x00ea;
                case 1134: goto L_0x00c0;
                case 1135: goto L_0x00bb;
                case 1136: goto L_0x0098;
                case 1137: goto L_0x00c0;
                default: goto L_0x008f;
            }
        L_0x008f:
            android.content.Context r0 = r12.mContext
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            com.didi.component.business.util.CarHttpHelper.validate(r0, r13)
            goto L_0x048d
        L_0x0098:
            com.didi.travel.psnger.model.response.CashUnPayInterceptInfo r0 = r13.cashUnPayInterceptInfo
            if (r0 == 0) goto L_0x048d
            com.didi.travel.psnger.model.response.CashUnPayInterceptInfo r0 = r13.cashUnPayInterceptInfo
            java.lang.String r0 = r0.link
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x048d
            com.didi.travel.psnger.model.response.CashUnPayInterceptInfo r13 = r13.cashUnPayInterceptInfo
            java.lang.String r13 = r13.link
            com.didi.drouter.router.Request r13 = com.didi.drouter.api.DRouter.build((java.lang.String) r13)
            androidx.fragment.app.Fragment r0 = r12.getHost()
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            r13.start(r0)
            goto L_0x048d
        L_0x00bb:
            r12.m14699d((com.didi.travel.psnger.model.response.CarOrder) r13)
            goto L_0x048d
        L_0x00c0:
            com.didi.travel.psnger.model.response.CashUnPayInterceptInfo r0 = r13.cashUnPayInterceptInfo
            if (r0 == 0) goto L_0x048d
            com.didi.component.common.base.ComponentWrap r0 = new com.didi.component.common.base.ComponentWrap
            java.lang.String r1 = "service_control_no_pay"
            r0.<init>(r1)
            r0.setClickMaskHide(r3)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            com.didi.travel.psnger.model.response.CashUnPayInterceptInfo r2 = r13.cashUnPayInterceptInfo
            java.lang.String r3 = "order"
            r2.mEntry = r3
            com.didi.travel.psnger.model.response.CashUnPayInterceptInfo r13 = r13.cashUnPayInterceptInfo
            java.lang.String r2 = "BUNDLE_CAR_ORDER_UNPAY_INFO"
            r1.putSerializable(r2, r13)
            r0.setBundle(r1)
            java.lang.String r13 = "event_show_popup_component"
            r12.doPublish(r13, r0)
            goto L_0x048d
        L_0x00ea:
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            java.lang.String r13 = r13.errmsg
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r0.setMessage(r13)
            com.didi.sdk.view.dialog.AlertController$IconType r3 = com.didi.sdk.view.dialog.AlertController.IconType.INFO
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setIcon((com.didi.sdk.view.dialog.AlertController.IconType) r3)
            android.content.Context r3 = r12.mContext
            java.lang.String r2 = r3.getString(r2)
            com.didi.component.service.AbsSendOrderServicePresenter$33 r3 = new com.didi.component.service.AbsSendOrderServicePresenter$33
            r3.<init>()
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setPositiveButton((java.lang.CharSequence) r2, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r3)
            r13.setPositiveButtonDefault()
            r0.setCancelable(r1)
            r12.m14683a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            goto L_0x048d
        L_0x0116:
            java.lang.String r13 = "estimate_get_estimate"
            r12.doPublish(r13)
            r12.backConfirmPricePage()
            goto L_0x048d
        L_0x0120:
            androidx.fragment.app.Fragment r0 = r12.getHost()
            if (r0 == 0) goto L_0x048d
            if (r13 == 0) goto L_0x012e
            com.didi.travel.psnger.model.RGCommonPopUp r0 = r13.mRGCommonPopUp
            if (r0 == 0) goto L_0x012e
            com.didi.travel.psnger.model.RGCommonPopUp r5 = r13.mRGCommonPopUp
        L_0x012e:
            r6 = r5
            java.lang.String r7 = r13.keeper_id
            int r8 = r13.bizCode
            java.lang.String r9 = r13.cardArray
            java.lang.String r10 = r13.auth_h5_url
            java.lang.String r11 = r12.m14705f((com.didi.travel.psnger.model.response.CarOrder) r13)
            com.didi.component.service.view.RGBlockingPopup r13 = com.didi.component.service.view.RGBlockingPopup.getInstance(r6, r7, r8, r9, r10, r11)
            androidx.fragment.app.Fragment r0 = r12.getHost()
            androidx.fragment.app.FragmentManager r0 = r0.getFragmentManager()
            r13.show(r0)
            goto L_0x048d
        L_0x014c:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            boolean r0 = r0.isInMiniBus()
            if (r0 == 0) goto L_0x048d
            r12.enterFaceRecognize(r13)
            goto L_0x048d
        L_0x015b:
            r12.backConfirmPricePage()
            com.didi.component.common.dialog.GlobalCommonBottomPop$BottomPopModel r0 = new com.didi.component.common.dialog.GlobalCommonBottomPop$BottomPopModel
            r0.<init>()
            java.lang.String r13 = r13.checkSplitFareMsg
            r0.content = r13
            android.content.Context r13 = r12.mContext
            r1 = 2131954869(0x7f130cb5, float:1.954625E38)
            java.lang.String r13 = r13.getString(r1)
            r0.positive = r13
            com.didi.component.common.dialog.GlobalCommonBottomPop r13 = new com.didi.component.common.dialog.GlobalCommonBottomPop
            android.content.Context r1 = r12.mContext
            r13.<init>(r1, r0)
            com.didi.component.service.AbsSendOrderServicePresenter$34 r0 = new com.didi.component.service.AbsSendOrderServicePresenter$34
            r0.<init>(r13)
            r13.setBottomActionListener(r0)
            r13.show()
            goto L_0x048d
        L_0x0186:
            android.content.Context r0 = r12.mContext
            java.lang.String r13 = r13.errmsg
            com.didi.sdk.util.ToastHelper.showLongInfo((android.content.Context) r0, (java.lang.String) r13, (int) r4)
            r12.backConfirmPricePage()
            java.lang.String r13 = "ibt_gp_carconfirm_deliverynumlimit_sw"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent(r13)
            goto L_0x048d
        L_0x0197:
            androidx.fragment.app.Fragment r0 = r12.getHost()
            if (r0 == 0) goto L_0x01d8
            androidx.fragment.app.Fragment r0 = r12.getHost()
            androidx.fragment.app.FragmentManager r0 = r0.getFragmentManager()
            if (r0 != 0) goto L_0x01a8
            goto L_0x01d8
        L_0x01a8:
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            java.lang.String r13 = r13.errmsg
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r0.setMessage(r13)
            com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.INFO
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setIcon((com.didi.sdk.view.dialog.AlertController.IconType) r1)
            android.content.Context r1 = r12.mContext
            java.lang.String r1 = r1.getString(r2)
            com.didi.component.service.AbsSendOrderServicePresenter$24 r2 = new com.didi.component.service.AbsSendOrderServicePresenter$24
            r2.<init>()
            r13.setPositiveButton((java.lang.CharSequence) r1, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r2)
            r0.setCancelable(r3)
            com.didi.component.service.AbsSendOrderServicePresenter$25 r13 = new com.didi.component.service.AbsSendOrderServicePresenter$25
            r13.<init>()
            r0.setOnDismissListener(r13)
            r12.m14683a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            goto L_0x048d
        L_0x01d8:
            return
        L_0x01d9:
            com.didi.travel.psnger.model.response.CommonPopUpModel r0 = r13.popup
            if (r0 == 0) goto L_0x0278
            com.didi.travel.psnger.model.response.CommonPopUpModel r0 = r13.popup
            java.util.List<com.didi.travel.psnger.model.response.CommonPopUpModel$PopUpOptions> r0 = r0.options
            boolean r0 = com.didi.sdk.util.collection.CollectionUtil.isEmpty((java.util.Collection<?>) r0)
            if (r0 == 0) goto L_0x01e9
            goto L_0x0278
        L_0x01e9:
            com.didi.travel.psnger.model.response.CommonPopUpModel r0 = r13.popup
            java.lang.String r0 = r0.title
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0278
            com.didi.travel.psnger.model.response.CommonPopUpModel r0 = r13.popup
            java.lang.String r0 = r0.showMsg
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01ff
            goto L_0x0278
        L_0x01ff:
            com.didi.travel.psnger.model.response.CommonPopUpModel r0 = r13.popup
            java.util.List<com.didi.travel.psnger.model.response.CommonPopUpModel$PopUpOptions> r0 = r0.options
            java.util.Iterator r0 = r0.iterator()
            r1 = r5
        L_0x0208:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0237
            java.lang.Object r2 = r0.next()
            com.didi.travel.psnger.model.response.CommonPopUpModel$PopUpOptions r2 = (com.didi.travel.psnger.model.response.CommonPopUpModel.PopUpOptions) r2
            int r4 = r2.type
            if (r4 != r3) goto L_0x0226
            com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback r4 = new com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback
            java.lang.String r2 = r2.text
            com.didi.component.service.AbsSendOrderServicePresenter$21 r5 = new com.didi.component.service.AbsSendOrderServicePresenter$21
            r5.<init>()
            r4.<init>(r2, r5)
            r5 = r4
            goto L_0x0208
        L_0x0226:
            int r4 = r2.type
            if (r4 != 0) goto L_0x0208
            com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback r1 = new com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback
            java.lang.String r2 = r2.text
            com.didi.component.service.AbsSendOrderServicePresenter$22 r4 = new com.didi.component.service.AbsSendOrderServicePresenter$22
            r4.<init>()
            r1.<init>(r2, r4)
            goto L_0x0208
        L_0x0237:
            if (r5 == 0) goto L_0x0278
            if (r1 != 0) goto L_0x023c
            goto L_0x0278
        L_0x023c:
            android.content.Context r0 = r12.mContext
            com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel2 r2 = new com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel2
            com.didi.travel.psnger.model.response.CommonPopUpModel r3 = r13.popup
            java.lang.String r3 = r3.title
            r2.<init>(r3, r5, r1)
            com.didi.travel.psnger.model.response.CommonPopUpModel r13 = r13.popup
            java.lang.String r13 = r13.showMsg
            com.didi.global.globalgenerickit.drawer.templatemodel.GGKBaseDrawerModel r13 = r2.setSubTitle(r13)
            com.didi.global.globalgenerickit.drawer.GGKDrawer r13 = com.didi.global.globalgenerickit.GGKUICreator.showDrawerModel(r0, r13)
            r12.f17422g = r13
            java.util.HashMap r13 = new java.util.HashMap
            r13.<init>()
            java.lang.String r0 = "point_id"
            java.lang.String r1 = ""
            r13.put(r0, r1)
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r2
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "timestamp"
            r13.put(r1, r0)
            java.lang.String r0 = "ibt_shortparking_request_prompt_sw"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r13)
            goto L_0x048d
        L_0x0278:
            return
        L_0x0279:
            com.didi.travel.psnger.model.CommonPopUp r13 = r13.mPopUp
            com.didi.component.service.AbsSendOrderServicePresenter$35 r0 = new com.didi.component.service.AbsSendOrderServicePresenter$35
            r0.<init>()
            r12.showDrawerDialog(r13, r0, r3)
            goto L_0x048d
        L_0x0285:
            android.content.Context r0 = r12.mContext
            java.lang.String r13 = r13.getErrorMsg()
            com.didi.component.business.util.UiHelper.showTip(r0, r13)
            java.lang.String r13 = "estimate_expired"
            r12.doPublish(r13)
            goto L_0x048d
        L_0x0295:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            boolean r0 = r0.isInMiniBus()
            if (r0 == 0) goto L_0x048d
            r12.verifyCard(r13)
            goto L_0x048d
        L_0x02a4:
            androidx.fragment.app.Fragment r0 = r12.getHost()
            if (r0 == 0) goto L_0x0334
            androidx.fragment.app.Fragment r0 = r12.getHost()
            androidx.fragment.app.FragmentManager r0 = r0.getFragmentManager()
            if (r0 != 0) goto L_0x02b6
            goto L_0x0334
        L_0x02b6:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r13 = r13.authData     // Catch:{ JSONException -> 0x02cc }
            r0.<init>(r13)     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r13 = "title"
            java.lang.String r13 = r0.optString(r13)     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r2 = "msg"
            java.lang.String r5 = r0.optString(r2)     // Catch:{ JSONException -> 0x02ca }
            goto L_0x02d1
        L_0x02ca:
            r0 = move-exception
            goto L_0x02ce
        L_0x02cc:
            r0 = move-exception
            r13 = r5
        L_0x02ce:
            r0.printStackTrace()
        L_0x02d1:
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            com.didi.sdk.view.dialog.AlertController$IconType r2 = com.didi.sdk.view.dialog.AlertController.IconType.INFO
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r2 = r0.setIcon((com.didi.sdk.view.dialog.AlertController.IconType) r2)
            boolean r3 = android.text.TextUtils.isEmpty(r13)
            if (r3 == 0) goto L_0x02ec
            android.content.Context r13 = r12.mContext
            r3 = 2131954791(0x7f130c67, float:1.9546091E38)
            java.lang.String r13 = r13.getString(r3)
        L_0x02ec:
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r2.setTitle(r13)
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 == 0) goto L_0x02ff
            android.content.Context r2 = r12.mContext
            r3 = 2131954790(0x7f130c66, float:1.954609E38)
            java.lang.String r5 = r2.getString(r3)
        L_0x02ff:
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setMessage(r5)
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setPositiveButtonDefault()
            android.content.Context r2 = r12.mContext
            r3 = 2131954789(0x7f130c65, float:1.9546087E38)
            java.lang.String r2 = r2.getString(r3)
            com.didi.component.service.AbsSendOrderServicePresenter$31 r3 = new com.didi.component.service.AbsSendOrderServicePresenter$31
            r3.<init>()
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setPositiveButton((java.lang.CharSequence) r2, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r3)
            r2 = 2131954788(0x7f130c64, float:1.9546085E38)
            com.didi.component.service.AbsSendOrderServicePresenter$30 r3 = new com.didi.component.service.AbsSendOrderServicePresenter$30
            r3.<init>()
            r13.setNegativeButton((int) r2, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r3)
            r0.setCancelable(r1)
            com.didi.component.service.AbsSendOrderServicePresenter$32 r13 = new com.didi.component.service.AbsSendOrderServicePresenter$32
            r13.<init>()
            r0.setOnDismissListener(r13)
            r12.m14683a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            goto L_0x048d
        L_0x0334:
            return
        L_0x0335:
            android.content.Context r2 = r12.mContext
            com.didi.sdk.app.BusinessContext r3 = r12.mBusinessContext
            java.lang.String r4 = r13.getErrorMsg()
            java.lang.String r5 = r13.overdraftOid
            int r6 = r13.productid
            r1 = r12
            r1.showNonpaymentOrderDialog(r2, r3, r4, r5, r6)
            goto L_0x048d
        L_0x0347:
            android.content.Context r0 = r12.mContext
            androidx.fragment.app.Fragment r1 = r12.getHost()
            androidx.fragment.app.FragmentManager r1 = r1.getFragmentManager()
            java.lang.String r13 = r13.getErrorMsg()
            com.didi.sdk.view.dialog.AlertDialogFragment r13 = com.didi.component.service.util.SendOrderTipDialogHelper.showOrderFailDialog(r0, r1, r13)
            r12.f17420e = r13
            goto L_0x048d
        L_0x035d:
            android.content.Context r13 = r12.mContext
            android.content.Context r0 = r12.mContext
            r1 = 2131955487(0x7f130f1f, float:1.9547503E38)
            java.lang.String r0 = com.didi.sdk.util.ResourcesHelper.getString(r0, r1)
            com.didi.sdk.util.ToastHelper.showShortInfo((android.content.Context) r13, (java.lang.String) r0, (int) r4)
            goto L_0x048d
        L_0x036d:
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            java.lang.String r13 = r13.errmsg
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r0.setMessage(r13)
            com.didi.sdk.view.dialog.AlertController$IconType r2 = com.didi.sdk.view.dialog.AlertController.IconType.INFO
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setIcon((com.didi.sdk.view.dialog.AlertController.IconType) r2)
            android.content.Context r2 = r12.mContext
            r3 = 2131953654(0x7f1307f6, float:1.9543785E38)
            java.lang.String r2 = r2.getString(r3)
            com.didi.component.service.AbsSendOrderServicePresenter$23 r3 = new com.didi.component.service.AbsSendOrderServicePresenter$23
            r3.<init>()
            r13.setPositiveButton((java.lang.CharSequence) r2, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r3)
            r0.setCancelable(r1)
            r12.m14683a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            goto L_0x048d
        L_0x0398:
            int r0 = com.didi.component.common.cache.CacheApolloUtils.isNewCPFBlockingOpen()
            if (r0 != r3) goto L_0x03c3
            androidx.fragment.app.Fragment r0 = r12.getHost()
            if (r0 == 0) goto L_0x048d
            if (r13 == 0) goto L_0x03ac
            com.didi.travel.psnger.model.CommonPopUp r0 = r13.mPopUp
            if (r0 == 0) goto L_0x03ac
            com.didi.travel.psnger.model.CommonPopUp r5 = r13.mPopUp
        L_0x03ac:
            java.lang.String r0 = r13.auth_h5_url
            java.lang.String r13 = r12.m14705f((com.didi.travel.psnger.model.response.CarOrder) r13)
            com.didi.component.service.view.CPFBlockingPopup r13 = com.didi.component.service.view.CPFBlockingPopup.getInstance(r5, r0, r13)
            androidx.fragment.app.Fragment r0 = r12.getHost()
            androidx.fragment.app.FragmentManager r0 = r0.getFragmentManager()
            r13.show(r0)
            goto L_0x048d
        L_0x03c3:
            int r0 = com.didi.component.common.cache.CacheApolloUtils.isNewCPFBlockingOpen()
            r2 = 2
            if (r0 != r2) goto L_0x03da
            java.lang.String r0 = r13.auth_h5_url
            java.lang.String r13 = r12.m14705f((com.didi.travel.psnger.model.response.CarOrder) r13)
            r12.m14687a((java.lang.String) r0, (java.lang.String) r13)
            java.lang.String r13 = "tech_CPFpopup_null_view_sw"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r13)
            goto L_0x048d
        L_0x03da:
            java.lang.String r0 = "gp_CPFpopup_old_view_sw"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r0)
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            java.lang.String r2 = r13.errmsg
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r2 = r0.setMessage(r2)
            com.didi.sdk.view.dialog.AlertController$IconType r3 = com.didi.sdk.view.dialog.AlertController.IconType.INFO
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r2 = r2.setIcon((com.didi.sdk.view.dialog.AlertController.IconType) r3)
            android.content.Context r3 = r12.mContext
            java.lang.String r3 = r3.getString(r4)
            com.didi.component.service.AbsSendOrderServicePresenter$27 r4 = new com.didi.component.service.AbsSendOrderServicePresenter$27
            r4.<init>(r13)
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r2.setPositiveButton((java.lang.CharSequence) r3, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r4)
            r13.setPositiveButtonDefault()
            r0.setCancelable(r1)
            r12.m14683a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            java.lang.String r13 = "Brazil_Safety_intercept_CPF_verification_sw"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent(r13)
            goto L_0x048d
        L_0x0410:
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            java.lang.String r13 = r13.errmsg
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r0.setMessage(r13)
            com.didi.sdk.view.dialog.AlertController$IconType r2 = com.didi.sdk.view.dialog.AlertController.IconType.INFO
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setIcon((com.didi.sdk.view.dialog.AlertController.IconType) r2)
            android.content.Context r2 = r12.mContext
            java.lang.String r2 = r2.getString(r4)
            com.didi.component.service.AbsSendOrderServicePresenter$26 r3 = new com.didi.component.service.AbsSendOrderServicePresenter$26
            r3.<init>()
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setPositiveButton((java.lang.CharSequence) r2, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r3)
            r13.setPositiveButtonDefault()
            r0.setCancelable(r1)
            r12.m14683a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            java.lang.String r13 = "gp_safetyInterceptOnlinePayError_popup_sw"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent(r13)
            goto L_0x048d
        L_0x0440:
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            java.lang.String r13 = r13.errmsg
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r0.setMessage(r13)
            r1 = 2131232489(0x7f0806e9, float:1.8081089E38)
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setIcon((int) r1)
            android.content.Context r1 = r12.mContext
            r2 = 2131955099(0x7f130d9b, float:1.9546716E38)
            java.lang.String r1 = r1.getString(r2)
            com.didi.component.service.AbsSendOrderServicePresenter$29 r2 = new com.didi.component.service.AbsSendOrderServicePresenter$29
            r2.<init>()
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setPositiveButton((java.lang.CharSequence) r1, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r2)
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setPositiveButtonDefault()
            android.content.Context r1 = r12.mContext
            r2 = 2131955100(0x7f130d9c, float:1.9546718E38)
            java.lang.String r1 = r1.getString(r2)
            com.didi.component.service.AbsSendOrderServicePresenter$28 r2 = new com.didi.component.service.AbsSendOrderServicePresenter$28
            r2.<init>()
            r13.setNegativeButton((java.lang.CharSequence) r1, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r2)
            r0.setCancelable(r3)
            r12.m14683a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            java.util.Map r13 = r12.getOmgeaParamsOfForceBindOnlinePayment()
            java.lang.String r0 = "Brazil_card_show_sw"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r13)
            goto L_0x048d
        L_0x048a:
            r12.m14702e((com.didi.travel.psnger.model.response.CarOrder) r13)
        L_0x048d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.service.AbsSendOrderServicePresenter.onOrderCreateFail(com.didi.travel.psnger.model.response.CarOrder):void");
    }

    /* renamed from: d */
    private boolean m14700d() {
        return this instanceof ConfirmServicePresenter;
    }

    /* renamed from: e */
    private boolean m14703e() {
        return !m14700d();
    }

    public LEGODrawer showNonpaymentOrderDialog(Context context, final BusinessContext businessContext, String str, final String str2, final int i) {
        LEGODrawerModel2 lEGODrawerModel2 = new LEGODrawerModel2(context.getString(R.string.car_unpay_title), new LEGOBtnTextAndCallback(context.getString(R.string.car_unpay_confirm), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (AbsSendOrderServicePresenter.this.f17416a != null) {
                    AbsConfirmConfigState.isShowPopInConfirmPage = false;
                    AbsSendOrderServicePresenter.this.f17416a.dismiss();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("oid:");
                String str = str2;
                if (str == null) {
                    str = "overdraftOid is Null";
                }
                sb.append(str);
                SystemUtils.log(6, "OidNullCheck", sb.toString(), new Exception(), "com.didi.component.service.AbsSendOrderServicePresenter$36", 2162);
                if (!TextUtils.isEmpty(str2)) {
                    new GlobalOrderRecovery(businessContext).recovery(i, str2, 2);
                }
            }
        }), new LEGOBtnTextAndCallback(context.getString(R.string.cancel), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (AbsSendOrderServicePresenter.this.f17416a != null) {
                    AbsConfirmConfigState.isShowPopInConfirmPage = false;
                    AbsSendOrderServicePresenter.this.f17416a.dismiss();
                }
            }
        }));
        lEGODrawerModel2.setIsShowCloseImg(false);
        lEGODrawerModel2.setClickOutsideCanCancel(false);
        lEGODrawerModel2.setSubTitle(str);
        AbsConfirmConfigState.isShowPopInConfirmPage = true;
        LEGODrawer showDrawerTemplate = LEGOUICreator.showDrawerTemplate(context, lEGODrawerModel2);
        this.f17416a = showDrawerTemplate;
        return showDrawerTemplate;
    }

    /* renamed from: d */
    private void m14699d(final CarOrder carOrder) {
        if (carOrder != null) {
            OrderBanPopInfo orderBanPopInfo = carOrder.banPopInfo;
            if (orderBanPopInfo == null) {
                CarHttpHelper.validate((FragmentActivity) this.mContext, carOrder);
            } else {
                OrderBanUIUtils.showBanPopDialogIfNeed(this.mContext, orderBanPopInfo, new Runnable() {
                    public void run() {
                        HashMap hashMap = new HashMap();
                        CarOrder carOrder = carOrder;
                        if (carOrder != null) {
                            hashMap.put("passenger_status", Integer.valueOf(carOrder.banStatus));
                            hashMap.put("global_id", carOrder.banGlobalId);
                        }
                        hashMap.put("passenger_id", Long.valueOf(NationComponentDataUtil.getUid()));
                        GlobalOmegaUtils.trackEvent("pax_suspension_banner_ck", (Map<String, Object>) hashMap);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14687a(String str, String str2) {
        String authH5UrlWithSourceAdded = DDTravelConfigStore.getInstance().getAuthH5UrlWithSourceAdded(3, str);
        if (!TextUtils.isEmpty(authH5UrlWithSourceAdded)) {
            Intent intent = new Intent(this.mContext, CPFAuthWebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(GlobalWebUrl.buildUrl(authH5UrlWithSourceAdded, m14676a(str2))));
            intent.putExtra("CPF_AUTH_SOURCE_KEY", 3);
            startActivityForResult(intent, 72);
        }
    }

    /* renamed from: a */
    private Map<String, Object> m14676a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (HashMap) new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void verifyCard(final CarOrder carOrder) {
        final VerifyCardOperator verifyCardOperator = new VerifyCardOperator(this.mContext);
        verifyCardOperator.setIDialogOperation(new IDialogOperation() {
            public void show(AlertDialogFragment.Builder builder) {
                AbsSendOrderServicePresenter.this.m14683a(builder);
            }

            public void dismiss() {
                AbsSendOrderServicePresenter.this.m14706f();
            }

            public void cancelDismiss() {
                AbsSendOrderServicePresenter.this.m14706f();
                AbsSendOrderServicePresenter.this.backToEstimate();
            }
        });
        verifyCardOperator.setIVerifyOperation(new IVerifyOperation() {
            public void onReVerfiry() {
                AbsSendOrderServicePresenter.this.m14706f();
                verifyCardOperator.createVerifyDialog(carOrder);
            }

            public void onSuccess() {
                AbsSendOrderServicePresenter.this.createOrder(0);
            }

            public void onChangePayMethod() {
                AbsSendOrderServicePresenter.this.m14706f();
                AbsSendOrderServicePresenter.this.showPaymentsPage();
            }
        });
        verifyCardOperator.setIProgressOperation(new IProgressOperation() {
            public void show() {
                AbsSendOrderServicePresenter absSendOrderServicePresenter = AbsSendOrderServicePresenter.this;
                absSendOrderServicePresenter.showProgressDialog(absSendOrderServicePresenter.mContext.getString(R.string.car_sending_order));
            }

            public void dismiss() {
                AbsSendOrderServicePresenter.this.dismissProgressDialog();
            }
        });
        verifyCardOperator.createVerifyDialog(carOrder);
    }

    /* access modifiers changed from: protected */
    public void enterFaceRecognize(final CarOrder carOrder) {
        DiFaceParam diFaceParam = new DiFaceParam();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lat", LocationController.getInstance().getLat(this.mContext));
            jSONObject.put("lng", LocationController.getInstance().getLng(this.mContext));
            jSONObject.put("a3", TEBridge.clientConfig().a3Token());
            jSONObject.put("ip", SystemUtil.getIPAddress(this.mContext));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        diFaceParam.setData(jSONObject.toString());
        diFaceParam.setBizCode(carOrder.faceBizcode);
        diFaceParam.setToken(NationComponentDataUtil.getToken());
        diFaceParam.setSessionId(carOrder.faceSessionId);
        DiFace.startFaceRecognition(diFaceParam, new DiFace.IDiFaceCallback() {
            public void onResult(DiFaceResult diFaceResult) {
                GLog.m11359i("face result: " + diFaceResult.getCode() + " " + diFaceResult.getMsg());
                if (diFaceResult.isSuccessful()) {
                    GlobalSPUtil.setLastFaceSessionId(AbsSendOrderServicePresenter.this.mContext, carOrder.faceSessionId);
                    GlobalSPUtil.setLastFacePassed(AbsSendOrderServicePresenter.this.mContext, true);
                    AbsSendOrderServicePresenter.this.createOrder(0);
                    FormStore.getInstance().setCreateFailOrder((CarOrder) null);
                    return;
                }
                GlobalSPUtil.setLastFaceSessionId(AbsSendOrderServicePresenter.this.mContext, carOrder.faceSessionId);
                GlobalSPUtil.setLastFacePassed(AbsSendOrderServicePresenter.this.mContext, false);
                AbsSendOrderServicePresenter.this.backToEstimate();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14683a(AlertDialogFragment.Builder builder) {
        if (getHost().getFragmentManager() != null) {
            AlertDialogFragment create = builder.create();
            this.f17420e = create;
            create.show(getHost().getFragmentManager(), getClass().getName());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m14706f() {
        AlertDialogFragment alertDialogFragment = this.f17420e;
        if (alertDialogFragment != null) {
            alertDialogFragment.dismiss();
        }
        dismissDrawerDialog();
    }

    /* renamed from: a */
    private void m14684a(OrderParams orderParams) {
        String str;
        PayEnterpriseInfo payEnterpriseInfo;
        try {
            if (CancelTripCache.getInstance().isUsingCachedEstimateParams()) {
                str = CancelTripCache.getInstance().getPayInfo();
            } else {
                str = getPayWayTag();
                CancelTripCache.getInstance().setPayInfo(str);
            }
            if (!TextUtils.isEmpty(str)) {
                orderParams.setPayType(m14692b(str, FormStore.getInstance().getCardIndex()));
                if (str.equals(String.valueOf(512)) && (payEnterpriseInfo = (PayEnterpriseInfo) FormStore.getInstance().getData(FormStore.KEY_PAY_ENTERPRISE)) != null) {
                    orderParams.setPayEnterpriseInfo(payEnterpriseInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public String getPayWayTag() {
        FormStore instance = FormStore.getInstance();
        if (instance == null) {
            return "";
        }
        return instance.getPayWay();
    }

    /* renamed from: b */
    private String m14692b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.putOpt(com.didi.entrega.customer.foundation.tracker.param.ParamConst.PARAM_PAY_TYPE, str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject.putOpt("card_index", str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        String cardPrefix = FormStore.getInstance().getCardPrefix();
        if (!TextUtils.isEmpty(cardPrefix)) {
            try {
                jSONObject.putOpt("card_prefix", cardPrefix);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    /* renamed from: g */
    private OrderParams.DTSDKOrder412Param m14708g() {
        OrderParams.DTSDKOrder412Param dTSDKOrder412Param = new OrderParams.DTSDKOrder412Param();
        dTSDKOrder412Param.defaultFSearchId = "";
        dTSDKOrder412Param.defaultFUid = "";
        dTSDKOrder412Param.defaultFSrcTag = "";
        return dTSDKOrder412Param;
    }

    /* renamed from: h */
    private OrderParams.DTSDKOrder412Param m14710h() {
        return new OrderParams.DTSDKOrder412Param();
    }

    /* renamed from: e */
    private void m14702e(CarOrder carOrder) {
        int i = carOrder.verifyMode;
        this.f17417b.clear();
        this.f17419d = null;
        this.f17418c = null;
        if (i >= 0) {
            this.f17419d = m14705f(carOrder);
            this.f17418c = carOrder.auth_h5_url;
            if (i == 1) {
                this.f17417b.add(ItemType.CREDIT_CARD.getType());
                this.f17417b.add(ItemType.FACEBOOK.getType());
            } else if (i == 2) {
                this.f17417b.add(ItemType.FACEBOOK.getType());
            } else if (i == 3) {
                this.f17417b.add(ItemType.CREDIT_CARD.getType());
            } else if (i == 5) {
                this.f17417b.add(ItemType.CREDIT_CARD.getType());
                this.f17417b.add(ItemType.FACEBOOK.getType());
                this.f17417b.add(ItemType.MEXICO_CURP.getType());
            } else if (i != 6) {
                RiskInterceptPopup.getInstance(String.valueOf(i), m14705f(carOrder)).show(((FragmentActivity) this.mContext).getSupportFragmentManager(), "");
                return;
            } else {
                this.f17417b.add(ItemType.CREDIT_CARD.getType());
                this.f17417b.add(ItemType.MEXICO_CURP.getType());
            }
            NormalDialogInfo normalDialogInfo = new NormalDialogInfo(10001);
            normalDialogInfo.setTitle((CharSequence) null);
            normalDialogInfo.setIcon(AlertController.IconType.INFO);
            normalDialogInfo.setMessage(this.mContext.getString(R.string.risk_page_dialog_msg_alert));
            normalDialogInfo.setPositiveText(this.mContext.getString(R.string.risk_page_dialog_msg_alert_confirm));
            normalDialogInfo.setTitle(this.mContext.getString(R.string.risk_page_dialog_title_alert));
            normalDialogInfo.setCancelable(false);
            normalDialogInfo.setCloseVisible(true);
            HashMap hashMap = new HashMap();
            hashMap.put("bubble_id", SearchIdUploadManager.getInstance().getBubbleId());
            GlobalOmegaUtils.trackEvent("ibt_gp_safetyvarifypopup_sw", (Map<String, Object>) hashMap);
            showDialog(normalDialogInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public String m14705f(CarOrder carOrder) {
        return carOrder.mExtendResult == null ? "" : carOrder.mExtendResult.toString();
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getOmgeaParamsOfForceBindOnlinePayment() {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", String.valueOf(NationComponentDataUtil.getUid()));
        AnyCarEstimateItemModel anyCarEstimateItemModel = this.f17424i;
        if (anyCarEstimateItemModel != null) {
            int carBussinessId = anyCarEstimateItemModel.getCarBussinessId();
            if (carBussinessId == 0) {
                carBussinessId = FormStore.getInstance().Bid;
            }
            hashMap.put("product_id", String.valueOf(carBussinessId));
        } else {
            hashMap.put("product_id", String.valueOf(FormStore.getInstance().Bid));
        }
        hashMap.put("city_id", Integer.valueOf(ReverseLocationStore.getsInstance().getCityId() == -1 ? ReverseLocationStore.getsInstance().getCachedCityId(this.mContext) : ReverseLocationStore.getsInstance().getCityId()));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void goToAddBankCard() {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 15;
        addCardParam.resourceId = DiFaceLogger.EVENT_ID_BIOASSAY_EXIT;
        DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(getHost(), requestCodeForHost(76), addCardParam);
    }

    /* access modifiers changed from: protected */
    public void dismissDrawerDialog() {
        GGKAbsDrawer gGKAbsDrawer = this.f17421f;
        if (gGKAbsDrawer != null) {
            gGKAbsDrawer.hideLoading();
            this.f17421f.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void showDrawerDialog(CommonPopUp commonPopUp, final CommonPopUp.OnOptionClickListener onOptionClickListener, final boolean z) {
        GGKBaseDrawerModel gGKBaseDrawerModel;
        if (commonPopUp != null && !CollectionUtils.isEmpty((Collection<?>) commonPopUp.options)) {
            GGKBtnTextAndCallback gGKBtnTextAndCallback = null;
            GGKBtnTextAndCallback gGKBtnTextAndCallback2 = null;
            for (final CommonPopUp.PopUpOptions next : commonPopUp.options) {
                if (next.type == 1 || next.type == 3) {
                    gGKBtnTextAndCallback = new GGKBtnTextAndCallback(next.text, new GGKOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            if (!z) {
                                AbsSendOrderServicePresenter.this.dismissDrawerDialog();
                            }
                            CommonPopUp.OnOptionClickListener onOptionClickListener = onOptionClickListener;
                            if (onOptionClickListener != null) {
                                onOptionClickListener.onConfirm(next.data);
                            }
                        }
                    });
                } else if (next.type == 0) {
                    gGKBtnTextAndCallback2 = new GGKBtnTextAndCallback(next.text, new GGKOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            AbsSendOrderServicePresenter.this.dismissDrawerDialog();
                            CommonPopUp.OnOptionClickListener onOptionClickListener = onOptionClickListener;
                            if (onOptionClickListener != null) {
                                onOptionClickListener.onCancel();
                            }
                        }
                    });
                }
            }
            if (gGKBtnTextAndCallback == null) {
                gGKBtnTextAndCallback = gGKBtnTextAndCallback2;
            }
            if (gGKBtnTextAndCallback != null) {
                if (gGKBtnTextAndCallback2 == null) {
                    gGKBaseDrawerModel = new GGKDrawerModel1(commonPopUp.title, gGKBtnTextAndCallback);
                } else {
                    gGKBaseDrawerModel = new GGKDrawerModel2(commonPopUp.title, gGKBtnTextAndCallback, gGKBtnTextAndCallback2);
                }
                gGKBaseDrawerModel.setSubTitle(commonPopUp.showMsg).setClickOutsideCanCancel(false).setIsLoadingEnable(z);
                this.f17421f = GGKUICreator.showDrawerModel(this.mContext, gGKBaseDrawerModel);
            }
        }
    }
}
