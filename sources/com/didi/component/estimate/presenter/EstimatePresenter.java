package com.didi.component.estimate.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.component.business.constant.BaseConstants;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.oneconfig.AbsConfirmConfigState;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.EstimateUtils;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.base.EventDataObj;
import com.didi.component.common.base.IPresenterDataMapCallback;
import com.didi.component.common.bff.BFFStore;
import com.didi.component.common.cache.CacheApolloUtils;
import com.didi.component.common.dialog.ImageHintDialogInfo;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.model.CPFBlockingModel;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.common.util.AppForegroundTracker;
import com.didi.component.common.util.GsonUtils;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.estimate.model.EstimateState;
import com.didi.component.estimate.newui.presenter.NewEstimatePresenter;
import com.didi.component.estimate.newui.view.IV2EstimateView;
import com.didi.component.estimate.view.guidedialog.NewbieDialogManager;
import com.didi.component.estimate.view.widget.carpooldialog.SeatCountFragmentDialogV2;
import com.didi.component.estimate.view.widget.newtwoprice.TwoPriceSeatCountNewDialog;
import com.didi.component.utils.EstimateTrackEventUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.monitor.GlobalPaxTechTracker;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.DebugUtils;
import com.didi.travel.p172v2.util.LogUtils;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.request.EstimateParams;
import com.didi.travel.psnger.model.response.ExpoDataResponse;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didi.travel.psnger.model.response.estimate.EstimateAbnormalModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.EstimateResponse;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didi.travel.psnger.utils.TextUtil;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.p205sa.biz.tracker.AddressMonitorTrack;
import com.didiglobal.travel.util.CollectionUtils;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class EstimatePresenter extends AbsEstimatePresenter<IV2EstimateView> {
    public static final int REQUEST_FROM_GOOGLE_MAP = 1;

    /* renamed from: c */
    private static final int f15079c = 101;

    /* renamed from: d */
    private static final int f15080d = 1000;

    /* renamed from: e */
    private static final int f15081e = 70;

    /* renamed from: A */
    private XEReqJSONParamsCallbackImpl f15082A = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            EstimateParams c = EstimatePresenter.this.m12406f();
            EstimatePresenter.this.f15084a = String.valueOf(System.currentTimeMillis());
            c.setReqId(EstimatePresenter.this.f15084a);
            c.setUserType(BFFStore.getCarWanliuUserType(DIDIApplication.getAppContext()));
            EstimateTrackEventUtils.trackEstimateDialogShow(EstimatePresenter.this.mContext);
            return new JSONObject(c.getParams());
        }
    };

    /* renamed from: B */
    private BaseEventPublisher.OnEventListener<Integer> f15083B = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            EstimatePresenter.this.f15089i.hideMessageView();
        }
    };

    /* renamed from: a */
    String f15084a = String.valueOf(System.currentTimeMillis());

    /* renamed from: b */
    BffResponseListener<ExpoDataResponse> f15085b = new BffResponseListener<ExpoDataResponse>() {
        public void onSuccess(ExpoDataResponse expoDataResponse) {
            super.onSuccess(expoDataResponse);
            boolean z = false;
            AbsConfirmConfigState.isLoadingInConfirmPage = false;
            if (expoDataResponse == null || expoDataResponse.multiEstimateData == null || expoDataResponse.multiEstimateData.estimateResponse == null) {
                EstimatePresenter.this.onNewEstimateError((EstimateResponse) null);
                return;
            }
            EstimateResponse estimateResponse = expoDataResponse.multiEstimateData.estimateResponse;
            if (DebugUtils.isDebug() || TextUtils.isEmpty(estimateResponse.req_id) || TextUtils.equals(estimateResponse.req_id, EstimatePresenter.this.f15084a)) {
                EstimatePresenter.this.setGlobalEstimateTraceID(estimateResponse);
                if (EstimatePresenter.this.f15089i == null || CollectionUtils.isEmpty((Collection<?>) estimateResponse.allGroups) || estimateResponse.recommends == null || CollectionUtils.isNotEmpty((Collection<?>) estimateResponse.abnormalModels)) {
                    EstimatePresenter.this.onNewEstimateError(estimateResponse);
                    if (EstimatePresenter.this.f15086f) {
                        EstimatePresenter.this.doPublish(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR);
                        return;
                    }
                    return;
                }
                EstimatePresenter.this.f15089i.allGroups = estimateResponse.allGroups;
                EstimatePresenter.this.f15089i.recommendIds = estimateResponse.recommends;
                EstimatePresenter.this.f15089i.globalConfigModel = estimateResponse.globalConfigModel;
                EstimatePresenter.this.f15089i.handleEstimateList(estimateResponse.allGroups, EstimatePresenter.this.isNewEstimate);
                ((IV2EstimateView) EstimatePresenter.this.mView).setEstimatePresenter(EstimatePresenter.this.f15089i);
                ((IV2EstimateView) EstimatePresenter.this.mView).setRecommendData(EstimatePresenter.this.f15089i.recommendsList, EstimatePresenter.this.f15089i.getAllModels(), EstimatePresenter.this.f15089i.getSelectModel(), estimateResponse.globalConfigModel);
                EstimatePresenter.this.onNewEstimateSucces();
                if (EstimatePresenter.this.f15086f) {
                    EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                    EstimateItemModel estimateItemModel = EstimatePresenter.this.f15089i.lastSelectModel;
                    if (!(newEstimateItem == null || estimateItemModel == null || estimateItemModel.carConfig == null || estimateItemModel.carConfig.extraData == null || estimateItemModel.carConfig.extraData.getOrderParams() == null || (!BusinessDataUtil.isEstimateSuccessWithNoPrice(newEstimateItem) && newEstimateItem.feeNumber == estimateItemModel.carConfig.extraData.getOrderParams().feeAmount))) {
                        z = true;
                    }
                    EstimatePresenter.this.doPublish(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_SUCCESS, Boolean.valueOf(z));
                    return;
                }
                return;
            }
            Logger logger = EstimatePresenter.this.mLogger;
            logger.info("reqid diff" + EstimatePresenter.this.f15084a, new Object[0]);
        }

        public void onError(ExpoDataResponse expoDataResponse) {
            AbsConfirmConfigState.isLoadingInConfirmPage = false;
            super.onError(expoDataResponse);
            if (!EstimatePresenter.this.mRemoved) {
                if (DebugUtils.isDebug() || expoDataResponse == null || expoDataResponse.multiEstimateData == null || expoDataResponse.multiEstimateData.estimateResponse == null || TextUtils.isEmpty(expoDataResponse.multiEstimateData.estimateResponse.req_id) || TextUtils.equals(expoDataResponse.multiEstimateData.estimateResponse.req_id, EstimatePresenter.this.f15084a)) {
                    EstimatePresenter.this.onNewEstimateError((EstimateResponse) null);
                    if (EstimatePresenter.this.f15086f) {
                        EstimatePresenter.this.doPublish(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR);
                        return;
                    }
                    return;
                }
                Logger logger = EstimatePresenter.this.mLogger;
                logger.info("reqid diff " + EstimatePresenter.this.f15084a, new Object[0]);
            }
        }

        public void onFail(ExpoDataResponse expoDataResponse) {
            AbsConfirmConfigState.isLoadingInConfirmPage = false;
            super.onFail(expoDataResponse);
            if (!EstimatePresenter.this.mRemoved) {
                if (DebugUtils.isDebug() || expoDataResponse == null || expoDataResponse.multiEstimateData == null || expoDataResponse.multiEstimateData.estimateResponse == null || TextUtils.isEmpty(expoDataResponse.multiEstimateData.estimateResponse.req_id) || TextUtils.equals(expoDataResponse.multiEstimateData.estimateResponse.req_id, EstimatePresenter.this.f15084a)) {
                    EstimatePresenter.this.onNewEstimateError((EstimateResponse) null);
                    if (EstimatePresenter.this.f15086f) {
                        EstimatePresenter.this.doPublish(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FAIL);
                        return;
                    }
                    return;
                }
                Logger logger = EstimatePresenter.this.mLogger;
                logger.info("reqid diff " + EstimatePresenter.this.f15084a, new Object[0]);
            }
        }

        public void onFinish(ExpoDataResponse expoDataResponse) {
            ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
            if (confirmListener != null) {
                confirmListener.setIsAnyCar(false);
            }
            if (EstimatePresenter.this.mView != null) {
                ((IV2EstimateView) EstimatePresenter.this.mView).hideLoading();
            }
            AbsConfirmConfigState.isLoadingInConfirmPage = false;
            super.onFinish(expoDataResponse);
            if (!EstimatePresenter.this.mRemoved) {
                if (!DebugUtils.isDebug() && expoDataResponse != null && expoDataResponse.multiEstimateData != null && expoDataResponse.multiEstimateData.estimateResponse != null && !TextUtils.isEmpty(expoDataResponse.multiEstimateData.estimateResponse.req_id) && !TextUtils.equals(expoDataResponse.multiEstimateData.estimateResponse.req_id, EstimatePresenter.this.f15084a)) {
                    Logger logger = EstimatePresenter.this.mLogger;
                    logger.info("reqid diff " + EstimatePresenter.this.f15084a, new Object[0]);
                } else if (expoDataResponse == null) {
                    EstimatePresenter.this.onNewEstimateError((EstimateResponse) null);
                } else {
                    FormStore.getInstance().setEstimateTime(System.currentTimeMillis());
                    if (EstimatePresenter.this.f15086f) {
                        boolean unused = EstimatePresenter.this.f15086f = false;
                        EstimatePresenter.this.doPublish(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH);
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f15086f = false;

    /* renamed from: g */
    private int f15087g = -1;

    /* renamed from: h */
    private boolean f15088h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public NewEstimatePresenter f15089i;
    protected boolean isInEstimatePage;
    public boolean isNewEstimate = true;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f15090j = false;

    /* renamed from: k */
    private long f15091k = 0;

    /* renamed from: l */
    private final Runnable f15092l = new Runnable() {
        public void run() {
            if (!EstimatePresenter.this.mRemoved) {
                EstimatePresenter.this.m12404e();
            }
        }
    };

    /* renamed from: m */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15093m = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            EstimatePresenter.this.getEstimate();
        }
    };
    protected BusinessContext mBusinessContext;
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mConfirmStateListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE.equals(str)) {
                boolean unused = EstimatePresenter.this.f15090j = false;
            }
        }
    };
    protected final FormStore mFormStore;
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mShowConifrmEventListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS.equals(str)) {
                boolean unused = EstimatePresenter.this.f15090j = true;
            }
            ((IV2EstimateView) EstimatePresenter.this.mView).dismissTips();
        }
    };
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mVerticalEstimateViewListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Confirm.EVENT_VERTICAL_ESTIMATE_VIEW_TOP.equals(str)) {
                EstimatePresenter.this.f15089i.setScrollToTop();
            } else if (BaseEventKeys.Confirm.EVENT_VERTICAL_ESTIMATE_VIEW_BOTTOM.equals(str)) {
                EstimatePresenter.this.f15089i.setScrollToBottom();
            }
        }
    };
    protected XEResponseCallback mXELogicCallback = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData == null || xEngineData.jsonObject == null) {
                EstimatePresenter.this.f15085b.onFail(null);
                EstimatePresenter.this.f15085b.onFinish(null);
                return;
            }
            String w = EstimatePresenter.this.TAG;
            LogUtils.m34980i(w, "onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
            GsonUtils.fromJsonAsync(xEngineData.jsonObject.toString(), ExpoDataResponse.class, new GsonUtils.OnFromJsonListener<ExpoDataResponse>() {
                public void onSuccess(ExpoDataResponse expoDataResponse) {
                    if (expoDataResponse != null) {
                        EstimatePresenter.this.f15085b.onSuccess(expoDataResponse);
                        EstimatePresenter.this.f15085b.onFinish(expoDataResponse);
                        return;
                    }
                    EstimatePresenter.this.f15085b.onFail(null);
                    EstimatePresenter.this.f15085b.onFinish(null);
                }

                public void onFail() {
                    EstimatePresenter.this.f15085b.onFail(null);
                    EstimatePresenter.this.f15085b.onFinish(null);
                }
            });
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            String x = EstimatePresenter.this.TAG;
            LogUtils.m34980i(x, "onFailed:e = " + engineErrorException);
            EstimatePresenter.this.f15085b.onError(null);
            EstimatePresenter.this.f15085b.onFinish(null);
        }
    };

    /* renamed from: n */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15094n = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            EstimateParams c = EstimatePresenter.this.m12406f();
            EstimatePresenter.this.f15084a = String.valueOf(System.currentTimeMillis());
            c.setReqId(EstimatePresenter.this.f15084a);
            c.setUserType(BFFStore.getCarWanliuUserType(DIDIApplication.getAppContext()));
            EstimateTrackEventUtils.trackEstimateDialogShow(EstimatePresenter.this.mContext);
            EstimatePresenter.this.doPublish(BaseEventKeys.Estimate.EVENT_SEND_ESTIMATE_PARAMS, c);
        }
    };

    /* renamed from: p */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15095p = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            EstimatePresenter.this.getEstimate();
        }
    };

    /* renamed from: q */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15096q = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            boolean unused = EstimatePresenter.this.f15086f = true;
            EstimatePresenter.this.m12404e();
        }
    };

    /* renamed from: r */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15097r = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            EstimatePresenter.this.isInEstimatePage = false;
            ((IV2EstimateView) EstimatePresenter.this.mView).dismissTips();
            SceneHelper.getInstance().setCarList((List<Integer>) null);
        }
    };

    /* renamed from: s */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15098s = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            EstimatePresenter.this.isInEstimatePage = true;
            ((IV2EstimateView) EstimatePresenter.this.mView).showTipBubble(false, true);
        }
    };

    /* renamed from: t */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15099t = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(str, BaseEventKeys.Estimate.ESTIMATE_DISPATCH_FEE_SHOW_NEWBIE_DIALOG_EVENT) && EstimatePresenter.this.getHost() != null) {
                NewbieDialogManager.showNewUIBottomGuideDialog(EstimatePresenter.this.getHost().getActivity(), 2, EstimatePresenter.this.m12395b(2));
            }
        }
    };

    /* renamed from: u */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15100u = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            EstimatePresenter.this.m12400c();
        }
    };

    /* renamed from: v */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15101v = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            EstimatePresenter.this.m12402d();
        }
    };

    /* renamed from: w */
    private final BaseEventPublisher.OnEventListener<Boolean> f15102w = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            ((IV2EstimateView) EstimatePresenter.this.mView).changeMargin(bool.booleanValue());
        }
    };

    /* renamed from: x */
    private final BaseEventPublisher.OnEventListener<Float> f15103x = new BaseEventPublisher.OnEventListener<Float>() {
        public void onEvent(String str, Float f) {
            ((IV2EstimateView) EstimatePresenter.this.mView).recommandSlide(f.floatValue());
        }
    };

    /* renamed from: y */
    private TwoPriceSeatCountNewDialog f15104y;

    /* renamed from: z */
    private SeatCountFragmentDialogV2 f15105z;

    public EstimatePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mBusinessContext = componentParams.bizCtx;
        this.mFormStore = FormStore.getInstance();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f15091k = 0;
        if (bundle.getBoolean(BaseExtras.ConfirmService.CANCEL_ORDER_BACK_TO_ESTIMATE, false)) {
            this.isNewEstimate = false;
        } else {
            this.isNewEstimate = true;
        }
        NewEstimatePresenter newEstimatePresenter = new NewEstimatePresenter();
        this.f15089i = newEstimatePresenter;
        newEstimatePresenter.estimatePresenter = this;
        ((IV2EstimateView) this.mView).setEstimatePresenter(this.f15089i);
        EstimateTrackEventUtils.trackEstimateShow(this.mContext);
        if (bundle != null) {
            int i = bundle.getInt(BaseConstants.ConfirmPageExtraKeys.DEFAULT_SELECT_BIZ_INT, -1);
            this.f15087g = i;
            if (i != -1 && SceneHelper.getInstance().isDeepLinkFromGoogle) {
                FormStore.getInstance().setCurrentComboType(0);
            }
        }
        registerListener();
        if (bundle != null && TextUtils.equals(BaseConstants.ConfirmPageExtraKeys.PAGE_SOURCE_DEEPLINK, bundle.getString("page_source")) && (!NationComponentDataUtil.isLoginNow() || TextUtils.isEmpty(NationComponentDataUtil.getToken()))) {
            NationComponentDataUtil.goToLoginPageForResult(getHost(), requestCodeForHost(70));
        }
        m12396b();
    }

    /* renamed from: b */
    private void m12396b() {
        if (this.mContext != null && CacheApolloUtils.isNewCPFBlockingOpen() == -1) {
            CarRequest.getCPFBlockingSuffixApollo(this.mContext, (ResponseListener<CPFBlockingModel>) null);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        NewEstimatePresenter newEstimatePresenter;
        ((IV2EstimateView) this.mView).closeTipBubble();
        if (!EstimateState.INSTANCE.isInOneCarPage() || this.f15090j || (newEstimatePresenter = this.f15089i) == null || newEstimatePresenter.expandList == null || this.f15089i.expandList.size() <= 1) {
            if (this.f15090j) {
                this.f15090j = false;
                FormStore.getInstance().setFlexOfferPrice(false);
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener != null) {
                    confirmListener.setConfirmBack(true);
                }
            } else {
                GlobalOmegaUtils.trackEvent("cancel_ck");
            }
            return super.onBackPressed(backType);
        }
        ((IV2EstimateView) this.mView).backToRecommendData();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        boolean z = !AppForegroundTracker.isAppTurnInfoForeground() || (System.currentTimeMillis() - this.f15091k) / 1000 >= ((long) GlobalApolloUtil.estimateRefresInterval());
        this.f15091k = 0;
        if (!this.f15090j && !FormStore.getInstance().isSkipEstimateGet() && z) {
            getEstimate();
        }
        FormStore.getInstance().setSkipEstimateGet(false);
        EstimateTrackEventUtils.trackEstimateShow(this.mContext);
        if (!GPageIdConstant.G_PAGE_ID_PICONF.equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
            GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_CONF);
        }
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
        this.f15091k = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unregisterListener();
        ((IV2EstimateView) this.mView).dismissTips();
        TwoPriceSeatCountNewDialog twoPriceSeatCountNewDialog = this.f15104y;
        if (twoPriceSeatCountNewDialog != null) {
            twoPriceSeatCountNewDialog.dismissDialog();
        }
    }

    /* access modifiers changed from: protected */
    public void registerListener() {
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_ESTIMATE, XERequestKey.SCENE_ESTIMATE, this.mXELogicCallback);
        xERegisterModel.requestParams = this.f15082A;
        XERegister.registerTemplate(xERegisterModel);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE, this.f15093m);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_TIME_CHANGED, this.f15095p);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_FIXED_PRICE_RE_ESTIMATE, this.f15096q);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_COMPONENT_HIDDEN, this.f15097r);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_COMPONENT_SHOWN, this.f15098s);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_DISPATCH_FEE_SHOW_NEWBIE_DIALOG_EVENT, this.f15099t);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_TWO_PRICE_SELECT_SEAT_SHOW, this.f15100u);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.mShowConifrmEventListener);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.mConfirmStateListener);
        subscribe(BaseEventKeys.Confirm.EVENT_VERTICAL_ESTIMATE_VIEW_TOP, this.mVerticalEstimateViewListener);
        subscribe(BaseEventKeys.Confirm.EVENT_VERTICAL_ESTIMATE_VIEW_BOTTOM, this.mVerticalEstimateViewListener);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY, this.f15083B);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_TOP_MARGIN_CHANGED, this.f15102w);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_RECOMMAND_SLIDE, this.f15103x);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_COMBO_SELECT_SEAT_SHOW, this.f15101v);
        subscribe(BaseEventKeys.Estimate.EVENT_GET_ESTIMATE_PARAMS, this.f15094n);
    }

    /* access modifiers changed from: protected */
    public void unregisterListener() {
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_ESTIMATE);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE, this.f15093m);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_TIME_CHANGED, this.f15095p);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_FIXED_PRICE_RE_ESTIMATE, this.f15096q);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_COMPONENT_HIDDEN, this.f15097r);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_COMPONENT_SHOWN, this.f15098s);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_DISPATCH_FEE_SHOW_NEWBIE_DIALOG_EVENT, this.f15099t);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_TWO_PRICE_SELECT_SEAT_SHOW, this.f15100u);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.mShowConifrmEventListener);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.mConfirmStateListener);
        unsubscribe(BaseEventKeys.Confirm.EVENT_VERTICAL_ESTIMATE_VIEW_TOP, this.mVerticalEstimateViewListener);
        unsubscribe(BaseEventKeys.Confirm.EVENT_VERTICAL_ESTIMATE_VIEW_BOTTOM, this.mVerticalEstimateViewListener);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY, this.f15083B);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_TOP_MARGIN_CHANGED, this.f15102w);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_RECOMMAND_SLIDE, this.f15103x);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_COMBO_SELECT_SEAT_SHOW, this.f15101v);
        unsubscribe(BaseEventKeys.Estimate.EVENT_GET_ESTIMATE_PARAMS, this.f15094n);
    }

    /* access modifiers changed from: protected */
    public final void getEstimate() {
        ((IV2EstimateView) this.mView).getView().removeCallbacks(this.f15092l);
        ((IV2EstimateView) this.mView).getView().postDelayed(this.f15092l, 100);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12400c() {
        if (this.f15104y == null) {
            this.f15104y = TwoPriceSeatCountNewDialog.newInstance(FormStore.getInstance().getSeatCount());
        }
        this.f15104y.setPresenter(this);
        this.f15104y.setBusinessContext(this.mBusinessContext);
        if (!(this.mContext == null || ((FragmentActivity) this.mContext).getSupportFragmentManager() == null)) {
            this.f15104y.show(((FragmentActivity) this.mContext).getSupportFragmentManager(), "TwoPriceSeatCountNewDialog");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", 2);
        GlobalOmegaUtils.trackEvent("ibt_gp_ordercomfirm_sharenum_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m12402d() {
        int seatCount = FormStore.getInstance().getSeatCount();
        if (this.f15105z == null) {
            this.f15105z = SeatCountFragmentDialogV2.newInstance(seatCount);
        }
        this.f15105z.setBusinessContext(this.mBusinessContext);
        if (this.mContext != null && ((FragmentActivity) this.mContext).getSupportFragmentManager() != null) {
            this.f15105z.show(((FragmentActivity) this.mContext).getSupportFragmentManager(), "SeatCountFragmentDialogV2");
        }
    }

    public void onTwoPriceConfirmClick() {
        int selectedSeatCount = this.f15104y.getSelectedSeatCount();
        FormStore.getInstance().setTwoPriceSeatConfirm(true);
        if (selectedSeatCount <= 2) {
            FormStore.getInstance().setSeatCount(selectedSeatCount);
            FormStore.getInstance().setTwoPriceBiz(true);
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (!(newEstimateItem == null || newEstimateItem.twoPriceChoice == null)) {
                newEstimateItem.twoPriceChoice.selectedValue = "1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", 2);
            hashMap.put("num", Integer.valueOf(selectedSeatCount));
            GlobalOmegaUtils.trackEvent("ibt_gp_ordercomfirm_sharenum_order_ck", (Map<String, Object>) hashMap);
        } else {
            FormStore.getInstance().setSeatCount(1);
            FormStore.getInstance().setTwoPriceBiz(false);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("type", 2);
            hashMap2.put("num", 0);
            GlobalOmegaUtils.trackEvent("ibt_gp_ordercomfirm_sharenum_order_ck", (Map<String, Object>) hashMap2);
            EstimateItemModel newEstimateItem2 = FormStore.getInstance().getNewEstimateItem();
            if (!(newEstimateItem2 == null || newEstimateItem2.twoPriceChoice == null)) {
                newEstimateItem2.twoPriceChoice.selectedValue = "0";
            }
        }
        ((IV2EstimateView) this.mView).updateSelectItem();
        this.f15104y.dismissDialog();
        doPublish(BaseEventKeys.Estimate.ESTIMATE_TWO_PRICE_SELECT_SEAT_CONFIRM);
    }

    /* access modifiers changed from: protected */
    public void setFixedPriceTipsDialogDefaultImage(ImageHintDialogInfo imageHintDialogInfo) {
        if (imageHintDialogInfo == null) {
            return;
        }
        if (AppUtils.isBrazilApp(DIDIApplication.getAppContext())) {
            imageHintDialogInfo.setImageHolder(1);
        } else {
            imageHintDialogInfo.setImageHolder(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        super.onDialogAction(i, i2);
        if (101 == i) {
            dismissDialog(i);
        }
    }

    /* access modifiers changed from: protected */
    public void refreshFormOptionItemsIfNeed() {
        doPublish(BaseEventKeys.Confirm.EVENT_REFRESH_FORM_OPERATION_ITEMS);
    }

    /* renamed from: a */
    private String m12391a(int i) {
        String str = BusinessDataUtil.getProductId() + "_" + FormStore.getInstance().getCarLevel() + "_" + FormStore.getInstance().getCurrentComboType() + "_" + i;
        SceneHelper.getInstance().setLatestKey(str);
        this.mLogger.info("new_guide_key", str);
        return str;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m12395b(int i) {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.carConfig == null || TextUtils.isEmpty(newEstimateItem.carConfig.uniqueId)) {
            return m12391a(i);
        }
        String str = newEstimateItem.carConfig.uniqueId + "_" + i;
        SceneHelper.getInstance().setLatestKey(str);
        return str;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m12404e() {
        boolean z;
        if (this.mFormStore.isAddressValid()) {
            ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
            if (confirmListener != null && !confirmListener.isConfirmAddressPage()) {
                Address startAddress = this.mFormStore.getStartAddress();
                Address endAddress = this.mFormStore.getEndAddress();
                Logger logger = this.mLogger;
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("eyeball_req startaddress ");
                sb.append(startAddress != null ? startAddress.toString() : "startaddress is null");
                objArr[0] = sb.toString();
                logger.info("RideBizMapLog", objArr);
                Logger logger2 = this.mLogger;
                Object[] objArr2 = new Object[1];
                StringBuilder sb2 = new StringBuilder();
                sb2.append("eyeball_req endaddress ");
                sb2.append(endAddress != null ? endAddress.toString() : "endAddress is null");
                objArr2[0] = sb2.toString();
                logger2.info("RideBizMapLog", objArr2);
                HashMap hashMap = new HashMap();
                String str = "null";
                if (startAddress == null || startAddress.cityId == 0 || startAddress.cityId == -1 || startAddress.latitude == 0.0d || startAddress.longitude == 0.0d) {
                    this.mLogger.info("generateNewEstimateParams startAddress cityid or latlng error ", new Object[0]);
                    hashMap.put("start_search_id", startAddress != null ? startAddress.searchId : str);
                    z = true;
                } else {
                    z = false;
                }
                if (endAddress == null || endAddress.cityId == 0 || endAddress.cityId == -1 || endAddress.latitude == 0.0d || endAddress.longitude == 0.0d) {
                    this.mLogger.info("generateNewEstimateParams endAddress cityid or latlng error ", new Object[0]);
                    if (endAddress != null) {
                        str = endAddress.searchId;
                    }
                    hashMap.put("end_search_id", str);
                    z = true;
                }
                if (z) {
                    if (confirmListener == null || !confirmListener.isConfirmPageBack()) {
                        AddressMonitorTrack.adddressMonitorTrack(AddressMonitorTrack.mSceneRideEstimate, hashMap);
                    } else {
                        AddressMonitorTrack.adddressMonitorTrack(AddressMonitorTrack.mSceneRideBackEstimate, hashMap);
                    }
                }
            }
            if (confirmListener == null || !confirmListener.isConfirmAddressPage() || !confirmListener.getIsAnyCar()) {
                ((IV2EstimateView) this.mView).showLoading();
                ((IV2EstimateView) this.mView).dismissTips();
                TwoPriceSeatCountNewDialog twoPriceSeatCountNewDialog = this.f15104y;
                if (twoPriceSeatCountNewDialog != null && twoPriceSeatCountNewDialog.isAdded()) {
                    this.f15104y.dismissAllowingStateLoss();
                }
                SeatCountFragmentDialogV2 seatCountFragmentDialogV2 = this.f15105z;
                if (seatCountFragmentDialogV2 != null && seatCountFragmentDialogV2.isAdded()) {
                    this.f15105z.dismissAllowingStateLoss();
                }
                doPublish(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING);
                AbsConfirmConfigState.isLoadingInConfirmPage = true;
                XEngineReq.pageRequest(XERequestKey.SCENE_ESTIMATE);
                this.mLogger.info("doGetEngineEstimate", new Object[0]);
                return;
            }
            showLoading();
            this.mLogger.info("doGetEngineEstimate current page is confirmaddrss", new Object[0]);
            XEngineReq.pageRequest(XERequestKey.SCENE_ESTIMATE);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewEstimateSucces() {
        if (!this.mRemoved) {
            this.isNewEstimate = false;
            boolean isNewCarPoolCanUseInEstimate = EstimateUtils.isNewCarPoolCanUseInEstimate(this.f15089i.getAllModels());
            this.f15088h = isNewCarPoolCanUseInEstimate;
            this.mFormStore.setCarpoolShow(isNewCarPoolCanUseInEstimate);
            refreshFormOptionItemsIfNeed();
            if (FormStore.getInstance().isShowPayWayAfterEstimate()) {
                doPublish(BaseEventKeys.Confirm.SHOW_PAYMENTS);
                FormStore.getInstance().setShowPayWayAfterEstimate(false);
            }
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_SHOW_GROUP_FORM);
        }
    }

    public void setNewEstimateAbnormal(EstimateResponse estimateResponse) {
        if (CollectionUtils.isNotEmpty((Collection<?>) estimateResponse.abnormalModels)) {
            List<EstimateAbnormalModel> list = estimateResponse.abnormalModels;
            if (list == null || list.size() <= 0 || list.get(0) == null) {
                doPublish(BaseEventKeys.AnyCar.ESTIMATE_FAIL_TRANSFER_ANYCAR);
            } else {
                doPublish(BaseEventKeys.AnyCar.ESTIMATE_ABNORMAL_TRANSFER_ANYCAR, list.get(0));
            }
            ((IV2EstimateView) this.mView).setAbnormalView(estimateResponse.abnormalModels);
            GlobalPaxTechTracker.getInstance().trackEstimateError(2, FormStore.getInstance().getEstimateModelTraceId());
            return;
        }
        doPublish(BaseEventKeys.AnyCar.ESTIMATE_FAIL_TRANSFER_ANYCAR);
        ((IV2EstimateView) this.mView).setAbnormalView((List<EstimateAbnormalModel>) null);
        GlobalPaxTechTracker.getInstance().trackEstimateError(1, FormStore.getInstance().getEstimateModelTraceId());
    }

    public void onNewEstimateError(EstimateResponse estimateResponse) {
        this.mFormStore.setNewEstimateItem((EstimateItemModel) null);
        doPublish(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, Boolean.FALSE);
        if (estimateResponse != null) {
            setNewEstimateAbnormal(estimateResponse);
        } else {
            ((IV2EstimateView) this.mView).setAbnormalView((List<EstimateAbnormalModel>) null);
            GlobalPaxTechTracker.getInstance().trackEstimateError(0, "");
            doPublish(BaseEventKeys.AnyCar.ESTIMATE_FAIL_TRANSFER_ANYCAR);
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_HIDE_GROUP_FORM);
    }

    public void setGlobalEstimateTraceID(EstimateResponse estimateResponse) {
        if (estimateResponse.globalConfigModel != null && estimateResponse.globalConfigModel.globalEstimateTraceId != null) {
            FormStore.getInstance().setEstimateModelTraceId(estimateResponse.globalConfigModel.globalEstimateTraceId);
        }
    }

    public void updateSelectModel(EstimateItemModel estimateItemModel, boolean z) {
        FormStore.getInstance().setNewEstimateItem(estimateItemModel);
        doPublish(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, Boolean.TRUE);
        doPublish(BaseEventKeys.Estimate.NEW_ESTIMATE_CHANGE, Boolean.TRUE);
        ((IV2EstimateView) this.mView).showTipBubble(z, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public EstimateParams m12406f() {
        final EstimateParams estimateParams = new EstimateParams();
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (FormStore.getInstance().isFromOpenRide()) {
            estimateParams.setFormOpenRide(true);
            PinCodeInfoResult driverInfo = FormStore.getInstance().getDriverInfo();
            if (driverInfo != null) {
                int parseInt = NumberUtil.parseInt(driverInfo.carLevel);
                estimateParams.setProductId(NumberUtil.parseInt(driverInfo.driverProductId));
                estimateParams.setRequireLevel(parseInt);
                estimateParams.setComboType(500);
            }
        } else {
            estimateParams.setFormOpenRide(false);
        }
        if (this.f15087g != -1 && SceneHelper.getInstance().isDeepLinkFromGoogle) {
            estimateParams.setProductId(this.f15087g);
            estimateParams.setComboType(0);
            estimateParams.setRequireLevel(FormStore.getInstance().getCarLevel());
            estimateParams.setRequestSource(1);
        }
        estimateParams.setDepartureTime(this.mFormStore.getTransportTime());
        Address startAddress = this.mFormStore.getStartAddress();
        Address endAddress = this.mFormStore.getEndAddress();
        estimateParams.setStartAddress(startAddress);
        estimateParams.setEndAddress(endAddress);
        estimateParams.setWayPointAddressList(this.mFormStore.getWayPointAddressListJsonArray());
        Logger logger = this.mLogger;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("eyeball_req startaddress ");
        sb.append(startAddress != null ? startAddress.toString() : "startaddress is null");
        objArr[0] = sb.toString();
        logger.info("RideBizMapLog", objArr);
        Logger logger2 = this.mLogger;
        Object[] objArr2 = new Object[1];
        StringBuilder sb2 = new StringBuilder();
        sb2.append("eyeball_req endaddress ");
        sb2.append(endAddress != null ? endAddress.toString() : "endAddress is null");
        objArr2[0] = sb2.toString();
        logger2.info("RideBizMapLog", objArr2);
        estimateParams.fixedPrice = false;
        if (this.mFormStore.getCurCompany() != null) {
            estimateParams.curCompanyId = this.mFormStore.getCurCompany().f46886id;
        }
        estimateParams.setNewUIType(1);
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (!(newEstimateItem == null || newEstimateItem.carConfig == null)) {
            estimateParams.setPassProductId(newEstimateItem.carConfig.carProductId);
        }
        if (confirmListener == null || !confirmListener.isConfirmAddressPage()) {
            estimateParams.setUser_input_price((String) null);
        } else {
            estimateParams.setUser_input_price(this.mFormStore.getInputOfferPrice());
        }
        if (FormStore.getInstance().isEstimatePassConfirm()) {
            estimateParams.setPassBuyChoose(2);
        } else {
            estimateParams.setPassBuyChoose(1);
        }
        estimateParams.setPaymentsType(FormStore.getInstance().getPayWay());
        estimateParams.setCardIndex(FormStore.getInstance().getCardIndex());
        estimateParams.setGroupType(ConfProxy.getInstance().getSelectedType());
        EventDataObj eventDataObj = new EventDataObj();
        eventDataObj.setCallback(new IPresenterDataMapCallback() {
            public void onCallBack(Map<String, Object> map) {
                Object obj = map.get("select");
                Object obj2 = map.get("default");
                if (obj != null && obj2 != null) {
                    Logger logger = EstimatePresenter.this.mLogger;
                    logger.info("onCallBack select:" + obj, new Object[0]);
                    Logger logger2 = EstimatePresenter.this.mLogger;
                    logger2.info("onCallBack default:" + obj2, new Object[0]);
                    estimateParams.setMultiRouteId(((Long) obj).longValue());
                    estimateParams.setDefaultRouteId(((Long) obj2).longValue());
                }
            }
        });
        if (!(confirmListener == null || confirmListener.getCurrentPage() != 1 || newEstimateItem == null || newEstimateItem.carConfig == null || newEstimateItem.carConfig.extraData == null || newEstimateItem.carConfig.extraData.orderParamsObject == null)) {
            try {
                estimateParams.addParam("single_product_selected", new JSONObject(newEstimateItem.carConfig.extraData.orderParamsObject.toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        BaseEventPublisher.getPublisher().publishSync(BaseEventKeys.Estimate.EVENT_ESTIMATE_GET_ROUTE_ID, eventDataObj);
        return estimateParams;
    }

    public void reEstimate() {
        super.reEstimate();
        getEstimate();
    }

    public void bubbleSelectUpload(EstimateItemModel estimateItemModel) {
        int i = 0;
        if (getHost() != null) {
            if (estimateItemModel == null || estimateItemModel.twoPriceChoice == null || (!estimateItemModel.twoPriceChoice.selectedValue.isEmpty() && !estimateItemModel.twoPriceChoice.selectedValue.equals("0"))) {
                NewbieDialogManager.showNewUIBottomGuideDialog(getHost().getActivity(), 0, m12395b(0));
            } else {
                NewbieDialogManager.showNewUIBottomGuideDialog(getHost().getActivity(), 5, m12395b(5));
            }
        }
        String str = "";
        SearchIdUploadManager.getInstance().setBubbleId(estimateItemModel == null ? str : estimateItemModel.estimateId);
        EstimateParams estimateParams = new EstimateParams();
        if (estimateItemModel == null || estimateItemModel.carConfig == null) {
            estimateParams.setBusinessId(0);
        } else {
            estimateParams.setBusinessId(estimateItemModel.carConfig.carBussinessId);
        }
        estimateParams.setDepartureTime(this.mFormStore.getTransportTime());
        estimateParams.setStartAddress(this.mFormStore.getStartAddress());
        estimateParams.setEndAddress(this.mFormStore.getEndAddress());
        if (estimateItemModel != null) {
            i = estimateItemModel.getCarLevel();
        }
        estimateParams.setCarLevelId(String.valueOf(i));
        estimateParams.setPaymentsType(FormStore.getInstance().getPayWay());
        estimateParams.setUserType(BFFStore.getCarWanliuUserType(this.mContext));
        JsonObject jsonObject = null;
        if (!(estimateItemModel == null || estimateItemModel.carConfig == null || estimateItemModel.carConfig.extraData == null)) {
            jsonObject = estimateItemModel.carConfig.extraData.orderParamsObject;
        }
        JsonObject jsonObject2 = jsonObject;
        NewEstimatePresenter newEstimatePresenter = this.f15089i;
        if (!(newEstimatePresenter == null || newEstimatePresenter.globalConfigModel == null)) {
            String str2 = this.f15089i.globalConfigModel.selectItemCommitUrl;
            if (!TextUtils.isEmpty(str2)) {
                Map<String, Object> params = estimateParams.getParams();
                if (estimateItemModel != null) {
                    str = estimateItemModel.estimateId;
                }
                params.put(CarServerParam.PARAM_PRE_ESTIMATE_ID, str);
                params.put("estimate_trace_id", FormStore.getInstance().getEstimateModelTraceId());
                CarRequest.doBubbleSelectXEngineCommit(this.mContext, params, jsonObject2, str2, XERequestKey.SCENE_ESTIMATE, new ResponseListener<String>() {
                    public void onFinish(String str) {
                        super.onFinish(str);
                        if (!TextUtils.isEmpty(str)) {
                            FormStore.getInstance().setBubbleId(str);
                        }
                    }
                });
            } else {
                return;
            }
        }
        m12408g();
    }

    /* renamed from: g */
    private void m12408g() {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null && newEstimateItem.carConfig != null && newEstimateItem.carConfig.isEnableFixedPricePopup() && GlobalApolloUtil.getStatus("global_fix_price_user_guide") && !GlobalSPUtil.isShowedFixedPriceTipsDialog(this.mContext)) {
            String fixedPriceCommunicationTitle = DDTravelConfigStore.getInstance().getFixedPriceCommunicationTitle(this.mContext.getString(R.string.global_estimate_fixed_price_dialog_title));
            String fixedPriceCommunicationImageUrl = DDTravelConfigStore.getInstance().getFixedPriceCommunicationImageUrl((String) null);
            String fixedPriceCommunicationContent = DDTravelConfigStore.getInstance().getFixedPriceCommunicationContent(this.mContext.getString(R.string.global_estimate_fixed_price_dialog_content));
            String fixedPriceCommunicationButton = DDTravelConfigStore.getInstance().getFixedPriceCommunicationButton(this.mContext.getString(R.string.global_estimate_fixed_price_dialog_button));
            ImageHintDialogInfo imageHintDialogInfo = new ImageHintDialogInfo(101);
            imageHintDialogInfo.setTitle(fixedPriceCommunicationTitle);
            imageHintDialogInfo.setSubtitle(fixedPriceCommunicationContent);
            imageHintDialogInfo.setImageUrl(fixedPriceCommunicationImageUrl);
            imageHintDialogInfo.setButton(fixedPriceCommunicationButton);
            imageHintDialogInfo.setCancelable(false);
            if (TextUtil.isEmpty(fixedPriceCommunicationImageUrl)) {
                imageHintDialogInfo.setImageHolder(R.drawable.global_estimate_fixed_price_dialog_bg);
            } else {
                setFixedPriceTipsDialogDefaultImage(imageHintDialogInfo);
            }
            showDialog(imageHintDialogInfo);
            GlobalSPUtil.setShowedFixedPriceTipsDialog(this.mContext, true);
        }
    }

    public void hideGuidePopUp() {
        doPublish(BaseEventKeys.Confirm.EVENT_HIDE_PAY_POPUP);
    }
}
