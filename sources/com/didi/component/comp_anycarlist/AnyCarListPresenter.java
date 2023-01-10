package com.didi.component.comp_anycarlist;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseConstants;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.pageswitchparam.BackToConfirmParam;
import com.didi.component.business.tracker.anycar.AnycarTrack;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.common.bff.BFFStore;
import com.didi.component.common.dialog.ImageHintDialogInfo;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.common.util.GsonUtils;
import com.didi.component.comp_anycarlist.utils.AnycarEstimateOmegaUtil;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.estimate.view.guidedialog.NewbieDialogManager;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.request.EstimateParams;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimate;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import com.didi.travel.psnger.model.response.estimate.CarOperationDataModel;
import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didi.travel.psnger.utils.TextUtil;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.travel.util.CollectionUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AnyCarListPresenter extends AbsAnyCarListPresenter {
    public static final int REQUEST_FROM_GOOGLE_MAP = 1;

    /* renamed from: a */
    private static final int f13954a = 101;

    /* renamed from: b */
    private int f13955b = -1;

    /* renamed from: c */
    private boolean f13956c;

    /* renamed from: d */
    private List<AnyCarEstimateItemModel> f13957d;

    /* renamed from: e */
    private XEResponseCallback f13958e = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData != null) {
                AnyCarListPresenter.this.m11559a(xEngineData.jsonObject);
            } else {
                AnyCarListPresenter.this.doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, false);
                AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneAnycarResponse, (Map<String, Object>) null);
            }
            AnyCarListPresenter.this.m11562b();
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            AnyCarListPresenter.this.doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, false);
            AnyCarListPresenter.this.m11562b();
        }
    };

    /* renamed from: f */
    private XEReqJSONParamsCallbackImpl f13959f = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            EstimateParams b = AnyCarListPresenter.this.m11565c();
            b.setUserType(BFFStore.getCarWanliuUserType(DIDIApplication.getAppContext()));
            return new JSONObject(b.getParams());
        }
    };
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mShowConfirmEventListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS.equals(str)) {
                AnyCarListPresenter.this.mLogger.info("leaveEstimatebubbleSelectUpload mShowConfirmEventListener", new Object[0]);
                AnyCarListPresenter.this.leaveEstimatebubbleSelectUpload();
            }
        }
    };

    public AnyCarListPresenter(Context context) {
        super(context);
    }

    public void bubbleSelected(AnyCarEstimateItemModel anyCarEstimateItemModel, boolean z) {
        if (anyCarEstimateItemModel != null) {
            bubbleSelectUpload(anyCarEstimateItemModel, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11562b() {
        doPublish(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH);
        FormStore.getInstance().setEstimateTime(System.currentTimeMillis());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11559a(JsonObject jsonObject) {
        if (getHost() == null || getHost().getActivity() == null || jsonObject == null || TextUtils.isEmpty(jsonObject.toString())) {
            doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, false);
        } else {
            m11560a(jsonObject.toString());
        }
    }

    /* renamed from: a */
    private void m11560a(String str) {
        if (str != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    m11563b(optJSONObject.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
                doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, false);
                AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneAnycarResponse, (Map<String, Object>) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public EstimateParams m11565c() {
        String str;
        List<AnyCarEstimateItemModel> list;
        CarOperationDataModel.AnycarCarpoolSeat anycarCarpoolSeat;
        FormStore instance = FormStore.getInstance();
        EstimateParams estimateParams = new EstimateParams();
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
        if (this.f13955b != -1 && SceneHelper.getInstance().isDeepLinkFromGoogle) {
            estimateParams.setProductId(this.f13955b);
            estimateParams.setComboType(0);
            estimateParams.setRequireLevel(FormStore.getInstance().getCarLevel());
            estimateParams.setRequestSource(1);
        }
        estimateParams.setDepartureTime(instance.getTransportTime());
        Address startAddress = instance.getStartAddress();
        Address endAddress = instance.getEndAddress();
        estimateParams.setStartAddress(startAddress);
        estimateParams.setEndAddress(endAddress);
        estimateParams.setWayPointAddressList(instance.getWayPointAddressListJsonArray());
        Logger logger = this.mLogger;
        StringBuilder sb = new StringBuilder();
        sb.append("anycar_req startaddress ");
        sb.append(startAddress != null ? startAddress.toString() : "startaddress is null");
        logger.info(sb.toString(), new Object[0]);
        Logger logger2 = this.mLogger;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("anycar_req endaddress ");
        sb2.append(endAddress != null ? endAddress.toString() : "endAddress is null");
        logger2.info(sb2.toString(), new Object[0]);
        estimateParams.fixedPrice = false;
        if (instance.getCurCompany() != null) {
            estimateParams.curCompanyId = instance.getCurCompany().f46886id;
        }
        if (confirmListener == null || !confirmListener.isConfirmAddressPage()) {
            estimateParams.setUser_input_price((String) null);
        } else {
            estimateParams.setUser_input_price(instance.getInputOfferPrice());
        }
        if (confirmListener == null || !confirmListener.getIsAnyCar()) {
            str = FormStore.getInstance().getNewEstimateItem() != null ? "eyeball" : "";
        } else {
            str = "anycar";
        }
        estimateParams.addParam("last_estimate", str);
        if (confirmListener != null) {
            estimateParams.setAnyCarPreference(confirmListener.getPreference());
        }
        if (confirmListener != null) {
            int currentPage = confirmListener.getCurrentPage();
            if (currentPage == 1) {
                estimateParams.addParam("price_change_check", 0);
            } else if (currentPage == 3) {
                estimateParams.addParam("price_change_check", 1);
                AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
                if (!(selectedSingleAnyCarItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.extraData == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject == null)) {
                    try {
                        estimateParams.addParam("single_product_selected", new JSONObject(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject.toString()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        if (confirmListener != null) {
            if (this.f13956c) {
                list = this.f13957d;
                this.f13956c = false;
            } else {
                list = confirmListener.getSelectedAnyCarItems();
            }
            if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                Iterator<AnyCarEstimateItemModel> it = list.iterator();
                while (it.hasNext()) {
                    AnyCarEstimateItemModel next = it.next();
                    JsonObject jsonObject = (next == null || next.mAnyCarEstimateNetItem.carConfig == null || next.mAnyCarEstimateNetItem.carConfig.extraData == null || next.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject == null) ? null : next.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject;
                    if (!(next == null || next.anycarCarpool == null || next.anycarCarpool.operationData == null || CollectionUtil.isEmpty((Collection<?>) next.anycarCarpool.operationData.anycarCarpoolSeatList) || (anycarCarpoolSeat = next.anycarCarpool.operationData.anycarCarpoolSeatList.get(next.anycarCarpool.mSelectedIndex)) == null || anycarCarpoolSeat.selectValueParams == null)) {
                        if (jsonObject == null) {
                            jsonObject = anycarCarpoolSeat.selectValueParams;
                        } else {
                            for (String next2 : anycarCarpoolSeat.selectValueParams.keySet()) {
                                jsonObject.add(next2, anycarCarpoolSeat.selectValueParams.get(next2));
                            }
                        }
                    }
                    if (jsonObject != null) {
                        try {
                            arrayList.add(new JSONObject(jsonObject.toString()));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            estimateParams.setSelectProducts(arrayList);
        }
        if (confirmListener != null && !CollectionUtil.isEmpty((Collection<?>) confirmListener.getSelectedAnyCarItems())) {
            Iterator<AnyCarEstimateItemModel> it2 = confirmListener.getSelectedAnyCarItems().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                AnyCarEstimateItemModel next3 = it2.next();
                if (next3.estimatePass != null) {
                    if (next3.mAnyCarEstimateNetItem.carConfig != null) {
                        estimateParams.setPassProductId(next3.mAnyCarEstimateNetItem.carConfig.carProductId);
                    }
                    if (FormStore.getInstance().isEstimatePassConfirm()) {
                        estimateParams.setPassBuyChoose(2);
                    } else {
                        estimateParams.setPassBuyChoose(1);
                    }
                }
            }
        }
        estimateParams.setPaymentsType(FormStore.getInstance().getPayWay());
        estimateParams.setCardIndex(FormStore.getInstance().getCardIndex());
        estimateParams.setGroupType(ConfProxy.getInstance().getSelectedType());
        FriendItem selectedFriend = FormStore.getInstance().getSelectedFriend();
        if (!(selectedFriend == null || selectedFriend.getExtension() == null || selectedFriend.getExtension().getSelectValueParams() == null)) {
            try {
                HashMap hashMap = (HashMap) new Gson().fromJson((JsonElement) selectedFriend.getExtension().getSelectValueParams(), new TypeToken<HashMap<String, Object>>() {
                }.getType());
                if (!CollectionUtils.isEmpty((Map<?, ?>) hashMap) && estimateParams.getParams() != null) {
                    estimateParams.getParams().putAll(hashMap);
                }
            } catch (JsonSyntaxException e3) {
                e3.printStackTrace();
            }
        }
        if (!(confirmListener == null || confirmListener.getGroups() == null)) {
            List<AnyCarGroup> groups = confirmListener.getGroups();
            for (int i = 0; i < groups.size(); i++) {
                AnyCarGroup anyCarGroup = groups.get(i);
                if (!(anyCarGroup == null || anyCarGroup.config == null)) {
                    anyCarGroup.config.putOrderParams(estimateParams.getParams());
                }
            }
        }
        return estimateParams;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        ConfirmListener confirmListener;
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.mShowConfirmEventListener);
        if (bundle != null) {
            int i = bundle.getInt(BaseConstants.ConfirmPageExtraKeys.DEFAULT_SELECT_BIZ_INT, -1);
            this.f13955b = i;
            if (i != -1 && SceneHelper.getInstance().isDeepLinkFromGoogle) {
                FormStore.getInstance().setCurrentComboType(0);
            }
            Serializable serializable = bundle.getSerializable(BaseExtras.Common.EXTRA_BACK_TO_CONFIRM);
            BackToConfirmParam backToConfirmParam = null;
            if (serializable instanceof BackToConfirmParam) {
                backToConfirmParam = (BackToConfirmParam) serializable;
            }
            if (backToConfirmParam != null && !CollectionUtil.isEmpty((Collection<?>) backToConfirmParam.mAnyCarSelectedItemModels)) {
                ((IAnyCarListView) this.mView).setInitParam(backToConfirmParam.mAnyCarSelectedItemModels);
                this.f13957d = backToConfirmParam.mAnyCarSelectedItemModels;
                this.f13956c = true;
                ConfirmListener confirmListener2 = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener2 != null) {
                    confirmListener2.setSelectedAnyCarItem(this.f13957d);
                }
            }
            if (!(backToConfirmParam == null || (confirmListener = PageCompDataTransfer.getInstance().getConfirmListener()) == null)) {
                confirmListener.setCurrentPage(1);
                confirmListener.setIsAnyCar(backToConfirmParam.mIsAnyCar);
                confirmListener.setPreference(backToConfirmParam.mPreference);
                confirmListener.setGroups(backToConfirmParam.groups);
            }
        }
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.SingleCompRefresh.REQUEST_KEY_ANYCAR_EYEBALL, XERequestKey.SCENE_ESTIMATE, this.f13958e);
        xERegisterModel.requestParams = this.f13959f;
        XERegister.registerTemplate(xERegisterModel);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.mShowConfirmEventListener);
        XERegister.unregisterTemplate(XERequestKey.SingleCompRefresh.REQUEST_KEY_ANYCAR_EYEBALL);
    }

    /* renamed from: b */
    private void m11563b(String str) {
        GsonUtils.fromJsonAsync(str, AnyCarEstimate.class, new GsonUtils.OnFromJsonListener<AnyCarEstimate>() {
            public void onSuccess(AnyCarEstimate anyCarEstimate) {
                boolean z = false;
                if (anyCarEstimate != null) {
                    ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                    if (confirmListener != null) {
                        confirmListener.setIsAnyCar(true);
                        if (anyCarEstimate.anyCarResponse != null && !CollectionUtil.isEmpty((Collection<?>) anyCarEstimate.anyCarResponse.groups)) {
                            ((IAnyCarListView) AnyCarListPresenter.this.mView).setData(anyCarEstimate.anyCarResponse.groups);
                            confirmListener.setSelectedSingleAnyCarItem((AnyCarEstimateItemModel) null);
                            AnycarEstimateOmegaUtil.trackOrderConfirmDialogShow();
                        }
                        confirmListener.setAnyCarResponse(anyCarEstimate.anyCarResponse);
                        if (anyCarEstimate.anyCarResponse != null) {
                            confirmListener.setGroups(anyCarEstimate.anyCarResponse.groups);
                            if (!(anyCarEstimate.anyCarResponse.globalConfig == null || anyCarEstimate.anyCarResponse.globalConfig.preference == null)) {
                                confirmListener.setPreference(anyCarEstimate.anyCarResponse.globalConfig.preference.userType);
                            }
                        }
                        AnyCarListPresenter anyCarListPresenter = AnyCarListPresenter.this;
                        if (!(anyCarEstimate.anyCarResponse == null || anyCarEstimate.anyCarResponse.groups == null)) {
                            z = true;
                        }
                        anyCarListPresenter.doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, Boolean.valueOf(z));
                        return;
                    }
                    return;
                }
                AnyCarListPresenter.this.doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, false);
                AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneAnycarResponse, (Map<String, Object>) null);
            }

            public void onFail() {
                AnyCarListPresenter.this.doPublish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, false);
                AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneAnycarResponse, (Map<String, Object>) null);
            }
        });
    }

    /* renamed from: a */
    private String m11554a(AnyCarEstimateItemModel anyCarEstimateItemModel, int i) {
        if (anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null) {
            return "";
        }
        if (TextUtils.isEmpty(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.uniqueId)) {
            return m11553a(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carLevel, i);
        }
        String str = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.uniqueId + "_" + i;
        SceneHelper.getInstance().setLatestKey(str);
        return str;
    }

    /* renamed from: a */
    private String m11553a(int i, int i2, int i3) {
        String str = i + "_" + i2 + "_" + FormStore.getInstance().getCurrentComboType() + "_" + i3;
        SceneHelper.getInstance().setLatestKey(str);
        this.mLogger.info("new_guide_key", str);
        return str;
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null && !confirmListener.isConfirmAddressPage()) {
            leaveEstimatebubbleSelectUpload();
        }
        return super.onBackPressed(backType);
    }

    public void leaveEstimatebubbleSelectUpload() {
        CarOperationDataModel.AnycarCarpoolSeat anycarCarpoolSeat;
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || confirmListener.getAnyCarResponse() == null || confirmListener.getAnyCarResponse().globalConfig == null) {
            this.mLogger.info("bubbleSelectUpload response is null", new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        List<AnyCarEstimateItemModel> selectedAnyCarItems = confirmListener.getSelectedAnyCarItems();
        if (selectedAnyCarItems != null) {
            for (int i = 0; i < selectedAnyCarItems.size(); i++) {
                AnyCarEstimateItemModel anyCarEstimateItemModel = selectedAnyCarItems.get(i);
                hashSet.add(Integer.valueOf(anyCarEstimateItemModel.getCarBussinessId() + anyCarEstimateItemModel.getCarLevel()));
            }
        }
        List<AnyCarEstimateItemModel> allCarItems = confirmListener.getAllCarItems();
        if (allCarItems != null) {
            for (int i2 = 0; i2 < allCarItems.size(); i2++) {
                AnyCarEstimateItemModel anyCarEstimateItemModel2 = allCarItems.get(i2);
                if (anyCarEstimateItemModel2.mAnyCarEstimateNetItem.carConfig.singleCarSelect != 2) {
                    HashMap hashMap = new HashMap();
                    anyCarEstimateItemModel2.mAnyCarEstimateNetItem.carConfig.extraData.putOrderParams(hashMap);
                    if (!(anyCarEstimateItemModel2 == null || anyCarEstimateItemModel2.anycarCarpool == null || anyCarEstimateItemModel2.anycarCarpool.operationData == null || CollectionUtil.isEmpty((Collection<?>) anyCarEstimateItemModel2.anycarCarpool.operationData.anycarCarpoolSeatList) || (anycarCarpoolSeat = anyCarEstimateItemModel2.anycarCarpool.operationData.anycarCarpoolSeatList.get(anyCarEstimateItemModel2.anycarCarpool.mSelectedIndex)) == null || anycarCarpoolSeat.selectValueParams == null)) {
                        try {
                            hashMap.putAll((HashMap) new Gson().fromJson((JsonElement) anycarCarpoolSeat.selectValueParams, new TypeToken<HashMap<String, Object>>() {
                            }.getType()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    hashMap.put(ParamConst.PARAM_IS_SELECTED, Integer.valueOf(hashSet.add(Integer.valueOf(anyCarEstimateItemModel2.getCarBussinessId() + anyCarEstimateItemModel2.getCarLevel())) ^ true ? 1 : 0));
                    arrayList.add(new JSONObject(hashMap));
                }
            }
        }
        FormStore instance = FormStore.getInstance();
        Address startAddress = instance.getStartAddress();
        Address endAddress = instance.getEndAddress();
        HashMap hashMap2 = new HashMap();
        if (startAddress != null) {
            hashMap2.put("from_lng", Double.valueOf(startAddress.getLongitude()));
            hashMap2.put("from_lat", Double.valueOf(startAddress.getLatitude()));
        }
        if (endAddress != null) {
            hashMap2.put("to_lng", Double.valueOf(endAddress.getLongitude()));
            hashMap2.put("to_lat", Double.valueOf(endAddress.getLatitude()));
        }
        hashMap2.put("product_list", arrayList);
        String str = confirmListener.getAnyCarResponse().globalConfig.finalSelectCommitUrl;
        if (TextUtils.isEmpty(str)) {
            this.mLogger.info("levea estimate link is null", new Object[0]);
        } else {
            CarRequest.doBubbleSelectXEngineCommit(this.mContext, hashMap2, (JsonObject) null, str, XERequestKey.SCENE_ESTIMATE, (ResponseListener<String>) null);
        }
    }

    public void bubbleSelectUpload(AnyCarEstimateItemModel anyCarEstimateItemModel, boolean z) {
        String str;
        JsonObject jsonObject = null;
        if (!z) {
            if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData == null)) {
                jsonObject = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject;
            }
            JsonObject jsonObject2 = jsonObject;
            FormStore instance = FormStore.getInstance();
            Address startAddress = instance.getStartAddress();
            Address endAddress = instance.getEndAddress();
            HashMap hashMap = new HashMap();
            if (startAddress != null) {
                hashMap.put("from_lng", Double.valueOf(startAddress.getLongitude()));
                hashMap.put("from_lat", Double.valueOf(startAddress.getLatitude()));
            }
            if (endAddress != null) {
                hashMap.put("to_lng", Double.valueOf(endAddress.getLongitude()));
                hashMap.put("to_lat", Double.valueOf(endAddress.getLatitude()));
            }
            ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
            if (confirmListener == null || confirmListener.getAnyCarResponse() == null || confirmListener.getAnyCarResponse().globalConfig == null) {
                this.mLogger.info("bubbleSelectUpload response is null", new Object[0]);
                return;
            }
            String str2 = confirmListener.getAnyCarResponse().globalConfig.unSelecttemCommitUrl;
            if (TextUtils.isEmpty(str2)) {
                this.mLogger.info("onCheckedChanged link is null", new Object[0]);
            } else {
                CarRequest.doBubbleSelectXEngineCommit(this.mContext, hashMap, jsonObject2, str2, XERequestKey.SCENE_ESTIMATE, (ResponseListener<String>) null);
            }
        } else {
            if (!(getHost() == null || anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null)) {
                NewbieDialogManager.onInterceptNewGuideShow(getHost().getActivity(), anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.countPriceType, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carLevel, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carComboType, 0, m11554a(anyCarEstimateItemModel, 0));
            }
            FormStore instance2 = FormStore.getInstance();
            EstimateParams estimateParams = new EstimateParams();
            estimateParams.setDepartureTime(instance2.getTransportTime());
            estimateParams.setStartAddress(instance2.getStartAddress());
            estimateParams.setEndAddress(instance2.getEndAddress());
            estimateParams.setPaymentsType(instance2.getPayWay());
            estimateParams.setUserType(BFFStore.getCarWanliuUserType(this.mContext));
            String str3 = "";
            if (anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null) {
                str = str3;
            } else {
                str = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.estimateId;
                estimateParams.setBusinessId(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId);
                estimateParams.setCarLevelId(String.valueOf(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carLevel));
                if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData != null) {
                    jsonObject = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject;
                }
            }
            JsonObject jsonObject3 = jsonObject;
            ConfirmListener confirmListener2 = PageCompDataTransfer.getInstance().getConfirmListener();
            if (!(confirmListener2 == null || confirmListener2.getAnyCarResponse() == null || confirmListener2.getAnyCarResponse().globalConfig == null)) {
                str3 = confirmListener2.getAnyCarResponse().globalConfig.globalEstimateTraceId;
            }
            if (confirmListener2 == null || confirmListener2.getAnyCarResponse() == null) {
                this.mLogger.info("bubbleSelectUpload response is null", new Object[0]);
                return;
            }
            String str4 = confirmListener2.getAnyCarResponse().globalConfig.selectItemCommitUrl;
            if (TextUtils.isEmpty(str4)) {
                this.mLogger.info("onCheckedChanged link is null", new Object[0]);
                return;
            }
            Map<String, Object> params = estimateParams.getParams();
            params.put(CarServerParam.PARAM_PRE_ESTIMATE_ID, str);
            params.put("estimate_trace_id", str3);
            CarRequest.doBubbleSelectXEngineCommit(this.mContext, params, jsonObject3, str4, XERequestKey.SCENE_ESTIMATE, new ResponseListener<String>() {
                public void onFinish(String str) {
                    super.onFinish(str);
                    if (!TextUtils.isEmpty(str)) {
                        FormStore.getInstance().setBubbleId(str);
                    }
                }
            });
            m11558a(anyCarEstimateItemModel);
        }
    }

    /* renamed from: a */
    private void m11558a(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (anyCarEstimateItemModel != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.isEnableFixedPricePopup() && GlobalApolloUtil.getStatus("global_fix_price_user_guide") && !GlobalSPUtil.isShowedFixedPriceTipsDialog(this.mContext)) {
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
                m11555a(imageHintDialogInfo);
            }
            showDialog(imageHintDialogInfo);
            GlobalSPUtil.setShowedFixedPriceTipsDialog(this.mContext, true);
        }
    }

    /* renamed from: a */
    private void m11555a(ImageHintDialogInfo imageHintDialogInfo) {
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
}
