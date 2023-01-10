package com.didi.component.comp_anycar_append_list;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.tracker.anycar.AnycarTrack;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.OrderComManager;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.IXpCardLifeCycle;
import com.didi.component.business.xpanelnew.IXpCompRefresh;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GsonUtils;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.OrderCom;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.didi.travel.psnger.model.response.estimate.CarOperationDataModel;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.JsonObject;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnyCarAppendListPresenter extends IPresenter<IAnyCarAppendListView> implements IXpCardLifeCycle, IXpCompRefresh, XpNewAdapter {

    /* renamed from: a */
    private static final Logger f13929a = LoggerFactory.getLogger((Class<?>) AnyCarAppendListPresenter.class);

    /* renamed from: b */
    private AnyCarAppendData f13930b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<AnyCarEstimateItemModel> f13931c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f13932d = false;

    /* renamed from: e */
    private boolean f13933e = false;

    /* renamed from: f */
    private int f13934f;

    /* renamed from: g */
    private boolean f13935g = false;

    /* renamed from: h */
    private String f13936h = "";

    /* renamed from: i */
    private XEResponseCallback f13937i = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            BaseEventPublisher.getPublisher().publish("event_hide_loading_on_titlebar_in_home");
            if (XERequestKey.SCENE_TRIP.equals(str)) {
                boolean unused = AnyCarAppendListPresenter.this.f13932d = false;
            }
        }
    };

    /* renamed from: j */
    private XEReqJSONParamsCallbackImpl f13938j = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            hashMap.put("need_append_card", Boolean.valueOf(AnyCarAppendListPresenter.this.f13932d));
            hashMap.put(ParamKeys.PARAM_ANYCAR_PRODUCTS_SELECTED, AnyCarAppendListPresenter.this.m11541b());
            return new JSONObject(hashMap);
        }
    };

    /* renamed from: k */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f13939k = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AnyCarAppendListPresenter.this.bubbleSelectFinalUpload();
        }
    };

    public void compIds(List<String> list, int i, IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb) {
    }

    public void compRefresh(int i, String str, int i2, IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb) {
    }

    public void onCardAdd() {
    }

    public void onCardRemove() {
    }

    public AnyCarAppendListPresenter(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f13936h = "";
        subscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_RSP_FINISH_REPORT, this.f13939k);
        XERegisterModel xERegisterModel = new XERegisterModel(ComponentType.ANY_CAR_APPEND_LIST, XERequestKey.SCENE_TRIP, this.f13937i);
        xERegisterModel.requestParams = this.f13938j;
        XERegister.registerTemplate(xERegisterModel);
        this.f13935g = false;
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_RSP_FINISH_REPORT, this.f13939k);
        XERegister.unregisterTemplate(ComponentType.ANY_CAR_APPEND_LIST);
        this.f13935g = false;
        this.f13936h = "";
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        JSONObject optJSONObject = jSONObject.optJSONObject("normal");
        if (optJSONObject != null) {
            try {
                AnyCarAppendData anyCarAppendData = (AnyCarAppendData) GsonUtils.singleGson().fromJson(optJSONObject.optString("data"), AnyCarAppendData.class);
                this.f13930b = anyCarAppendData;
                if (!(anyCarAppendData == null || anyCarAppendData.carAppendList == null)) {
                    if (this.f13930b.carAppendList.size() != 0) {
                        this.f13931c.clear();
                        ((IAnyCarAppendListView) this.mView).getView().setVisibility(0);
                        ((IAnyCarAppendListView) this.mView).setTitle(this.f13930b.title);
                        ((IAnyCarAppendListView) this.mView).setData(this.f13930b.carAppendList);
                        ((IAnyCarAppendListView) this.mView).setSubmitBtn(this.f13930b.btnInfo);
                        if (!this.f13935g) {
                            m11538a(this.f13930b.carAppendList);
                        }
                        this.f13935g = true;
                        this.f13936h = CarOrderHelper.getOrderId();
                        iXpCardBindDataReadyCallback.ready(true);
                        return;
                    }
                }
                ((IAnyCarAppendListView) this.mView).getView().setVisibility(8);
                if (!this.f13933e) {
                    new Timer(true).schedule(new TimerTask() {
                        public void run() {
                            boolean unused = AnyCarAppendListPresenter.this.f13932d = true;
                            XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
                        }
                    }, new Date(this.f13930b.show_timestamp * 1000));
                    this.f13933e = true;
                }
                iXpCardBindDataReadyCallback.ready(false);
            } catch (Exception e) {
                e.printStackTrace();
                AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneAppendCarList, (Map<String, Object>) null);
                iXpCardBindDataReadyCallback.ready(false);
            }
        } else {
            iXpCardBindDataReadyCallback.ready(false);
        }
    }

    public List<AnyCarEstimateItemModel> getSelectedAnyCarItems() {
        return this.f13931c;
    }

    public void defaultSelectedItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        this.f13931c.add(anyCarEstimateItemModel);
    }

    public void selectedItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        this.f13931c.add(anyCarEstimateItemModel);
        ((IAnyCarAppendListView) this.mView).refreshBtnContent();
        ((IAnyCarAppendListView) this.mView).updateMsgTips(getAnyCarMsg());
        bubbleSelectUpload(anyCarEstimateItemModel, true);
        m11535a(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId);
    }

    public void unSelectItem(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        this.f13931c.remove(anyCarEstimateItemModel);
        ((IAnyCarAppendListView) this.mView).refreshBtnContent();
        ((IAnyCarAppendListView) this.mView).updateMsgTips(getAnyCarMsg());
        bubbleSelectUpload(anyCarEstimateItemModel, false);
    }

    public void carpoolSeatSelected(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (anyCarEstimateItemModel != null && anyCarEstimateItemModel.anycarCarpool != null) {
            this.f13934f = anyCarEstimateItemModel.anycarCarpool.mSelectedIndex + 1;
            XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
            xEBizParamsImpl.requestKeys = new String[]{ComponentType.ANY_CAR_APPEND_LIST};
            xEBizParamsImpl.scene = XERequestKey.SCENE_TRIP;
            XEngineReq.simpleRequest(xEBizParamsImpl);
        }
    }

    public CarMessageModel getAnyCarMsg() {
        CarMessageModel carMessageModel = null;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f13931c)) {
            int i = Integer.MIN_VALUE;
            for (AnyCarEstimateItemModel next : this.f13931c) {
                if (!(next == null || next.mAnyCarEstimateNetItem == null || next.mAnyCarEstimateNetItem.carMessage == null || next.mAnyCarEstimateNetItem.carMessage.level < i)) {
                    int i2 = next.mAnyCarEstimateNetItem.carMessage.level;
                    i = i2;
                    carMessageModel = next.mAnyCarEstimateNetItem.carMessage;
                }
            }
        }
        return carMessageModel;
    }

    public void submitCarModelAppend() {
        if (this.f13931c.size() != 0) {
            OrderCom orderCom = OrderComManager.getInstance().getOrderCom();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("oid", orderCom.getOid());
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.f13931c.size(); i++) {
                    AnyCarEstimateItemModel anyCarEstimateItemModel = this.f13931c.get(i);
                    if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null)) {
                        if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData != null) {
                            JsonObject jsonObject = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject;
                            if (jsonObject != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                if (jsonObject.has("bubble_id")) {
                                    jSONObject2.put("bubble_id", jsonObject.get("bubble_id").getAsString());
                                }
                                if (jsonObject.has(ParamKeys.PARAM_ESTIMATE_ID)) {
                                    jSONObject2.put(ParamKeys.PARAM_ESTIMATE_ID, jsonObject.get(ParamKeys.PARAM_ESTIMATE_ID).getAsString());
                                }
                                jSONObject2.put("seat_num", this.f13934f);
                                jSONArray.put(jSONObject2);
                            }
                        }
                    }
                }
                jSONObject.put("append_list", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                if (!TextUtils.isEmpty(this.f13930b.append_link)) {
                    String str = this.f13930b.append_link;
                    String queryParameter = Uri.parse(str).getQueryParameter("query");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        String substring = str.substring(0, str.indexOf("?"));
                        JSONObject jSONObject3 = new JSONObject(URLDecoder.decode(queryParameter, "UTF-8"));
                        jSONObject3.put("anycar_append_list", jSONObject);
                        ((Request) DRouter.build(substring + "?query=" + URLEncoder.encode(jSONObject3.toString(), "UTF-8")).putExtra("KEY_COMMIT_SCENE", XERequestKey.SCENE_TRIP)).start(this.mContext, new RouterCallback() {
                            public void onResult(Result result) {
                                AnyCarAppendListPresenter.this.m11547d();
                                BaseEventPublisher.getPublisher().publish("event_hide_loading_on_titlebar_in_home");
                                ((IAnyCarAppendListView) AnyCarAppendListPresenter.this.mView).updateBtnLoading(false);
                                AnyCarAppendListPresenter.this.f13931c.clear();
                                ((IAnyCarAppendListView) AnyCarAppendListPresenter.this.mView).refreshBtnContent();
                                ((IAnyCarAppendListView) AnyCarAppendListPresenter.this.mView).updateMsgTips((CarMessageModel) null);
                                AnyCarAppendListPresenter.this.m11537a(result);
                            }
                        });
                        bubbleSelectFinalUpload();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<JSONObject> m11541b() {
        CarOperationDataModel.AnycarCarpoolSeat anycarCarpoolSeat;
        ArrayList arrayList = new ArrayList();
        for (AnyCarEstimateItemModel next : this.f13931c) {
            JsonObject jsonObject = null;
            if (!(next == null || next.mAnyCarEstimateNetItem == null || next.mAnyCarEstimateNetItem.carConfig == null || next.mAnyCarEstimateNetItem.carConfig.extraData == null || next.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject == null)) {
                jsonObject = next.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject;
            }
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
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public void bubbleSelectFinalUpload() {
        AnyCarAppendData anyCarAppendData = this.f13930b;
        if (anyCarAppendData != null && anyCarAppendData.carAppendList != null) {
            String str = this.f13930b.finalSelectCommitUrl;
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                String orderId = CarOrderHelper.getOrderId();
                if (!TextUtils.isEmpty(orderId) && !TextUtils.equals(this.f13936h, orderId)) {
                    this.f13936h = orderId;
                }
                hashMap.put("oid", this.f13936h);
                ArrayList arrayList = new ArrayList();
                HashSet hashSet = new HashSet();
                if (this.f13931c != null) {
                    for (int i = 0; i < this.f13931c.size(); i++) {
                        AnyCarEstimateItemModel anyCarEstimateItemModel = this.f13931c.get(i);
                        hashSet.add(Integer.valueOf(anyCarEstimateItemModel.getCarBussinessId() + anyCarEstimateItemModel.getCarLevel()));
                    }
                }
                List<AnyCarEstimateNetModel> b = m11543b(this.f13930b.carAppendList);
                for (int i2 = 0; i2 < b.size(); i2++) {
                    AnyCarEstimateNetModel anyCarEstimateNetModel = b.get(i2);
                    HashMap hashMap2 = new HashMap();
                    anyCarEstimateNetModel.carConfig.extraData.putOrderParams(hashMap2);
                    hashMap2.put(ParamConst.PARAM_IS_SELECTED, Integer.valueOf(hashSet.add(Integer.valueOf(anyCarEstimateNetModel.carConfig.carBussinessId + anyCarEstimateNetModel.carConfig.carLevel)) ^ true ? 1 : 0));
                    arrayList.add(new JSONObject(hashMap2));
                }
                hashMap.put("product_list", arrayList);
                CarRequest.doBubbleSelectXEngineCommit(this.mContext, hashMap, (JsonObject) null, str, XERequestKey.SCENE_TRIP, (ResponseListener<String>) null);
            }
        }
    }

    public void bubbleSelectUpload(AnyCarEstimateItemModel anyCarEstimateItemModel, boolean z) {
        JsonObject jsonObject;
        String str;
        if (anyCarEstimateItemModel != null) {
            String str2 = z ? this.f13930b.selectItemCommitUrl : this.f13930b.unSelecttemCommitUrl;
            if (!TextUtils.isEmpty(str2)) {
                HashMap hashMap = new HashMap();
                String orderId = CarOrderHelper.getOrderId();
                if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig != null) {
                    str = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.estimateId;
                    if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData != null) {
                        jsonObject = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.extraData.orderParamsObject;
                        hashMap.put("oid", orderId);
                        hashMap.put(ParamKeys.PARAM_ESTIMATE_ID, str);
                        CarRequest.doBubbleSelectXEngineCommit(this.mContext, hashMap, jsonObject, str2, XERequestKey.SCENE_TRIP, (ResponseListener<String>) null);
                    }
                } else {
                    str = "";
                }
                jsonObject = null;
                hashMap.put("oid", orderId);
                hashMap.put(ParamKeys.PARAM_ESTIMATE_ID, str);
                CarRequest.doBubbleSelectXEngineCommit(this.mContext, hashMap, jsonObject, str2, XERequestKey.SCENE_TRIP, (ResponseListener<String>) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11537a(Result result) {
        JSONObject optJSONObject;
        String string = result.getString("KEY_CALLBACK");
        if (TextUtils.isEmpty(string)) {
            f13929a.info("xEngine commit failed", new Object[0]);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("data")) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                if (optJSONObject2.has("extension") && (optJSONObject = optJSONObject2.optJSONObject("extension")) != null && optJSONObject.optInt("errno") != 0) {
                    LEGOToastHelper.showToast(this.mContext, optJSONObject.optString("errmsg"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ab  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> m11544c() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel> r1 = r9.f13931c
            int r1 = r1.size()
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            java.util.List<com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel> r1 = r9.f13931c
            java.util.Iterator r1 = r1.iterator()
        L_0x0014:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00ce
            java.lang.Object r2 = r1.next()
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r2 = (com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel) r2
            if (r2 == 0) goto L_0x0014
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r3 = r2.mAnyCarEstimateNetItem
            if (r3 == 0) goto L_0x0014
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r3 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r3 = r3.carConfig
            if (r3 == 0) goto L_0x0014
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r3 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r3 = r3.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r3 = r3.extraData
            if (r3 != 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r3 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r3 = r3.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r3 = r3.extraData
            if (r3 != 0) goto L_0x003e
            goto L_0x0014
        L_0x003e:
            r4 = 0
            com.didi.travel.psnger.model.response.estimate.CarExtraLogModel r5 = r3.getExtraLog()
            if (r5 == 0) goto L_0x0014
            com.didi.travel.psnger.model.response.estimate.CarExtraLogModel r3 = r3.getExtraLog()
            java.lang.String r5 = r3.eta
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0059
            java.lang.String r5 = r3.eta     // Catch:{ Exception -> 0x0058 }
            int r4 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0058 }
            goto L_0x0059
        L_0x0058:
        L_0x0059:
            java.lang.String r5 = r3.originFee
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r6 = 0
            if (r5 != 0) goto L_0x0069
            java.lang.String r3 = r3.originFee     // Catch:{ Exception -> 0x0069 }
            float r3 = java.lang.Float.parseFloat(r3)     // Catch:{ Exception -> 0x0069 }
            goto L_0x006a
        L_0x0069:
            r3 = 0
        L_0x006a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r7 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r7 = r7.carConfig
            int r7 = r7.carLevel
            r5.append(r7)
            java.lang.String r7 = ""
            java.lang.String r8 = ":"
            if (r4 != 0) goto L_0x0085
            r5.append(r8)
            r5.append(r7)
            goto L_0x008b
        L_0x0085:
            r5.append(r8)
            r5.append(r4)
        L_0x008b:
            float r4 = r2.feeNumber
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x0098
            r5.append(r8)
            r5.append(r7)
            goto L_0x00a0
        L_0x0098:
            r5.append(r8)
            float r4 = r2.feeNumber
            r5.append(r4)
        L_0x00a0:
            int r4 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x00ab
            r5.append(r8)
            r5.append(r7)
            goto L_0x00b1
        L_0x00ab:
            r5.append(r8)
            r5.append(r3)
        L_0x00b1:
            r5.append(r8)
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r3 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r3 = r3.carConfig
            java.util.List<java.lang.String> r3 = r3.guideType
            r5.append(r3)
            r5.append(r8)
            boolean r2 = r2.isSelected
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r0.add(r2)
            goto L_0x0014
        L_0x00ce:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.comp_anycar_append_list.AnyCarAppendListPresenter.m11544c():java.util.List");
    }

    /* renamed from: a */
    private void m11538a(List<AnyCarGroup> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        List<AnyCarEstimateNetModel> b = m11543b(list);
        if (b != null && b.size() > 0) {
            for (int i = 0; i < b.size(); i++) {
                if (i < b.size() - 1) {
                    sb.append(b.get(i).carConfig.carBussinessId);
                    sb.append(",");
                } else {
                    sb.append(b.get(i).carConfig.carBussinessId);
                }
            }
        }
        hashMap.put("actual_bizlist", sb.toString());
        OmegaSDKAdapter.trackEvent("ibt_gp_anycar_morecartype_card_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m11535a(int i) {
        int i2 = getAnyCarMsg() != null ? 1 : 0;
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i2));
        hashMap.put("info_list", m11544c().toString());
        hashMap.put("actual_biz", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("ibt_gp_anycar_morecartypes_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m11547d() {
        int i = getAnyCarMsg() != null ? 1 : 0;
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("info_list", m11544c().toString());
        StringBuilder sb = new StringBuilder();
        if (this.f13931c.size() > 0) {
            for (int i2 = 0; i2 < this.f13931c.size(); i2++) {
                AnyCarEstimateItemModel anyCarEstimateItemModel = this.f13931c.get(i2);
                if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null)) {
                    if (i2 < this.f13931c.size() - 1) {
                        sb.append(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId);
                        sb.append(",");
                    } else {
                        sb.append(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId);
                    }
                }
            }
        }
        hashMap.put("actual_bizlist", sb.toString());
        OmegaSDKAdapter.trackEvent("ibt_gp_anycar_morecartypes_request_ck", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private List<AnyCarEstimateNetModel> m11543b(List<AnyCarGroup> list) {
        ArrayList arrayList = new ArrayList();
        for (AnyCarGroup next : list) {
            if (next != null && !CollectionUtil.isEmpty((Collection<?>) next.group)) {
                for (AnyCarEstimateNetModel next2 : next.group) {
                    if (next2 != null) {
                        arrayList.add(next2);
                    }
                }
            }
        }
        return arrayList;
    }
}
