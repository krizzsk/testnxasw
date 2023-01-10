package com.didi.component.comp_selectseat.seatselect;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_selectseat.model.SeatListItemModel;
import com.didi.component.comp_selectseat.model.SeatOptionsModel;
import com.didi.component.comp_selectseat.model.SeatSelectModel;
import com.didi.component.comp_selectseat.model.SeatSelectModelData;
import com.didi.component.core.PresenterGroup;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.p172v2.util.LogUtils;
import com.didi.travel.psnger.core.model.request.EstimateParams;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class SeatSelectTopPresenter extends PresenterGroup<ISeatSelectView> {

    /* renamed from: a */
    private static final String f14277a = "SelectSeatTopPresenter";

    /* renamed from: b */
    private int f14278b;

    /* renamed from: c */
    private String f14279c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final FormStore f14280d = FormStore.getInstance();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map<String, Object> f14281e = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f14282f;

    /* renamed from: g */
    private final BaseEventPublisher.OnEventListener<EstimateParams> f14283g = new BaseEventPublisher.OnEventListener<EstimateParams>() {
        public void onEvent(String str, EstimateParams estimateParams) {
            if (estimateParams == null || CollectionUtils.isEmpty((Map) estimateParams.getParams())) {
                Map unused = SeatSelectTopPresenter.this.f14281e = new HashMap();
            } else {
                Map unused2 = SeatSelectTopPresenter.this.f14281e = estimateParams.getParams();
            }
            XEngineReq.simpleRequest(XERequestKey.SCENE_ESTIMATE, XERequestKey.SingleCompRefresh.REQUEST_KEY_SELECT_SEAT);
        }
    };

    /* renamed from: h */
    private final XEReqJSONParamsCallbackImpl f14284h = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            AnyCarEstimateItemModel selectedSingleAnyCarItem;
            ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
            if (confirmListener == null || (selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem()) == null) {
                EstimateItemModel newEstimateItem = SeatSelectTopPresenter.this.f14280d.getNewEstimateItem();
                if (!(newEstimateItem == null || newEstimateItem.carConfig == null)) {
                    SeatSelectTopPresenter.this.f14281e.put("product_id", Integer.valueOf(newEstimateItem.carConfig.carProductId));
                    SeatSelectTopPresenter.this.f14281e.put("combo_type", Integer.valueOf(newEstimateItem.carConfig.carComboType));
                    SeatSelectTopPresenter.this.f14281e.put("require_level", Integer.valueOf(newEstimateItem.carConfig.carProductId));
                    SeatSelectTopPresenter.this.f14281e.put("seat_num", Integer.valueOf(SeatSelectTopPresenter.this.f14282f));
                }
                return new JSONObject(SeatSelectTopPresenter.this.f14281e);
            }
            if (selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig != null) {
                SeatSelectTopPresenter.this.f14281e.put("product_id", Integer.valueOf(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.carProductId));
                SeatSelectTopPresenter.this.f14281e.put("combo_type", Integer.valueOf(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.carComboType));
                SeatSelectTopPresenter.this.f14281e.put("require_level", Integer.valueOf(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.carProductId));
                SeatSelectTopPresenter.this.f14281e.put("seat_num", Integer.valueOf(SeatSelectTopPresenter.this.f14282f));
            }
            return new JSONObject(SeatSelectTopPresenter.this.f14281e);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LEGODrawer f14285i = null;
    protected XEResponseCallback mXELogicCallbackSelectSeat = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData != null) {
                LogUtils.m34980i(SeatSelectTopPresenter.f14277a, "onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
                SeatSelectTopPresenter.this.onSuccess(xEngineData.jsonObject);
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            LogUtils.m34980i(SeatSelectTopPresenter.f14277a, "onFailed:e = " + engineErrorException);
            SeatSelectTopPresenter.this.onFail(engineErrorException);
        }
    };

    public SeatSelectTopPresenter(Context context, Bundle bundle) {
        super(context, bundle);
    }

    /* access modifiers changed from: protected */
    public void onSuccess(JsonObject jsonObject) {
        if (getHost() != null && getHost().getActivity() != null && jsonObject != null) {
            setSeatData(jsonObject.toString(), false);
        }
    }

    /* access modifiers changed from: protected */
    public void onFail(Exception exc) {
        GLog.m11357e(f14277a, "onFail" + exc.toString());
        ((ISeatSelectView) this.mView).showOrHideLoadingTimeoutView(0);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.SingleCompRefresh.REQUEST_KEY_SELECT_SEAT, XERequestKey.SCENE_ESTIMATE, this.mXELogicCallbackSelectSeat);
        xERegisterModel.requestParams = this.f14284h;
        XERegister.registerTemplate(xERegisterModel);
        subscribe(BaseEventKeys.Estimate.EVENT_SEND_ESTIMATE_PARAMS, this.f14283g);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterCallback(XERequestKey.SingleCompRefresh.REQUEST_KEY_SELECT_SEAT, this.mXELogicCallbackSelectSeat);
        unsubscribe(BaseEventKeys.Estimate.EVENT_SEND_ESTIMATE_PARAMS, this.f14283g);
    }

    public void singleCompRefresh(int i) {
        this.f14282f = i;
        doPublish(BaseEventKeys.Estimate.EVENT_GET_ESTIMATE_PARAMS);
    }

    public void onItemClick(int i, int i2) {
        this.f14278b = i;
        singleCompRefresh(i2);
    }

    public void setSeatData(String str, boolean z) {
        if (TextUtils.isEmpty(this.f14279c)) {
            GLog.m11357e(f14277a, "setSeatData() >> mUniqueId is null");
            ((ISeatSelectView) this.mView).showOrHideLoadingTimeoutView(0);
        } else if (!TextUtil.isEmpty(str)) {
            SeatSelectModel seatSelectModel = null;
            try {
                seatSelectModel = (SeatSelectModel) new Gson().fromJson(str, SeatSelectModel.class);
            } catch (JsonSyntaxException e) {
                ((ISeatSelectView) this.mView).showOrHideLoadingTimeoutView(0);
                GLog.m11357e(f14277a, "setSeatData>> " + e.toString());
            }
            if (seatSelectModel == null || seatSelectModel.data == null) {
                GLog.m11357e(f14277a, "setSeatData() >> seatSelectModelData is null ");
                ((ISeatSelectView) this.mView).showOrHideLoadingTimeoutView(0);
            } else if (seatSelectModel.data.mErrorHint != null) {
                m11846a(seatSelectModel.data.mErrorHint);
            } else if (seatSelectModel.data.seatList == null || seatSelectModel.data.seatList.size() <= 0) {
                GLog.m11357e(f14277a, "eatSelectModelData.seatList is null or seatList.size=0");
            } else {
                for (SeatListItemModel next : seatSelectModel.data.seatList) {
                    if (next == null) {
                        GLog.m11357e(f14277a, "SeatListItemModel is null");
                    } else if (this.f14279c.equals(next.uniqueId)) {
                        ((ISeatSelectView) this.mView).setMainTitle(next.title);
                        ((ISeatSelectView) this.mView).setSubTitle(next.content);
                        if (next.options != null && next.options.size() > 0) {
                            List<SeatOptionsModel> list = next.options;
                            if (z) {
                                SeatOptionsModel seatOptionsModel = list.get(0);
                                seatOptionsModel.setmItemIsSelected(true);
                                ((ISeatSelectView) this.mView).setSeatsData(list);
                                m11845a(seatOptionsModel);
                            } else {
                                int size = list.size();
                                int i = this.f14278b;
                                if (size >= i + 1) {
                                    SeatOptionsModel seatOptionsModel2 = list.get(i);
                                    seatOptionsModel2.setmItemIsSelected(true);
                                    ((ISeatSelectView) this.mView).setSeatsData(list);
                                    m11849b(seatOptionsModel2);
                                } else {
                                    this.f14278b = 0;
                                    ((ISeatSelectView) this.mView).showOrHideLoadingTimeoutView(0);
                                    ((ISeatSelectView) this.mView).resetSlideBgView();
                                    GLog.m11357e(f14277a, "setSeatData >> seatList.size()<" + this.f14278b);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            GLog.m11357e(f14277a, "setSeatData() >> jsonStr is null");
            ((ISeatSelectView) this.mView).showOrHideLoadingTimeoutView(0);
        }
    }

    /* renamed from: a */
    private void m11845a(SeatOptionsModel seatOptionsModel) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "access");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, GPageIdConstant.G_PAGE_ID_CONF);
        trackEventEstimateId(hashMap, "seatExposureTrackEvent");
        m11847a((Map<String, Object>) hashMap, seatOptionsModel);
        GlobalOmegaUtils.trackEvent("ibt_gp_minibus_request__seats_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private void m11849b(SeatOptionsModel seatOptionsModel) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, GPageIdConstant.G_PAGE_ID_CONF);
        hashMap.put(RavenKey.VERSION, "seats");
        trackEventEstimateId(hashMap, "seatSelectTrackEvent");
        m11847a((Map<String, Object>) hashMap, seatOptionsModel);
        GlobalOmegaUtils.trackEvent("ibt_gp_minibus_request_seats_ck", (Map<String, Object>) hashMap);
    }

    public void trackEventEstimateId(Map<String, Object> map, String str) {
        AnyCarEstimateItemModel selectedSingleAnyCarItem;
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || (selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem()) == null) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem == null || newEstimateItem.carConfig == null || TextUtils.isEmpty(newEstimateItem.carConfig.estimateId)) {
                GLog.m11357e(f14277a, str + " >> estimateId is null");
                return;
            }
            map.put("pre_bubble_id", newEstimateItem.carConfig.estimateId);
        } else if (selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig != null && !TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.estimateId)) {
            map.put("pre_bubble_id", selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.estimateId);
        }
    }

    /* renamed from: a */
    private void m11847a(Map<String, Object> map, SeatOptionsModel seatOptionsModel) {
        if (seatOptionsModel != null && seatOptionsModel.mExtension != null && seatOptionsModel.mExtension.mLogData != null) {
            try {
                HashMap hashMap = (HashMap) new Gson().fromJson((JsonElement) seatOptionsModel.mExtension.mLogData, new TypeToken<HashMap<String, Object>>() {
                }.getType());
                if (!CollectionUtils.isEmpty((Map) hashMap)) {
                    map.putAll(hashMap);
                }
            } catch (JsonSyntaxException e) {
                GLog.m11357e(f14277a, "cardClickUseTrackEvent " + e.toString());
            }
        }
    }

    /* renamed from: a */
    private void m11846a(SeatSelectModelData.ErrorHint errorHint) {
        String str = "";
        String str2 = !TextUtils.isEmpty(errorHint.title) ? errorHint.title : str;
        if (!TextUtils.isEmpty(errorHint.button)) {
            str = errorHint.button;
        }
        LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(str2, new LEGOBtnTextAndCallback(str, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (SeatSelectTopPresenter.this.f14285i != null) {
                    SeatSelectTopPresenter.this.f14285i.dismiss();
                }
                ((ISeatSelectView) SeatSelectTopPresenter.this.mView).onBackPress();
            }
        }));
        lEGODrawerModel1.setClickOutsideCanCancel(false);
        if (!TextUtils.isEmpty(errorHint.content)) {
            lEGODrawerModel1.setSubTitle(errorHint.content);
        }
        lEGODrawerModel1.setIsShowCloseImg(true);
        lEGODrawerModel1.setShowCloseImgListener(new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (SeatSelectTopPresenter.this.f14285i != null) {
                    SeatSelectTopPresenter.this.f14285i.dismiss();
                }
                ((ISeatSelectView) SeatSelectTopPresenter.this.mView).onBackPress();
            }
        });
        this.f14285i = LEGOUICreator.showDrawerTemplate(this.mContext, lEGODrawerModel1);
        HashMap hashMap = new HashMap();
        hashMap.put("k", "show");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "request_again_banner");
        GlobalOmegaUtils.trackEvent("ibt_gp_minibus_noseats_return_ck", (Map<String, Object>) hashMap);
    }

    public void setmUniqueId(String str) {
        this.f14279c = str;
    }
}
