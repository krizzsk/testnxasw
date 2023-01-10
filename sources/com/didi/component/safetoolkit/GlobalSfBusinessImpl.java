package com.didi.component.safetoolkit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.sharetrip.ShareTripDialogCache;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.config.GlobalComponentConfig;
import com.didi.component.common.dialog.GlobalDialog;
import com.didi.component.common.track.DidiTrackingClient;
import com.didi.component.common.util.LocationController;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.api.requests.SafeToolkitBffRequest;
import com.didi.component.safetoolkit.presenter.AbsJarvisPresenter;
import com.didi.component.safetoolkit.presenter.AbsSafeToolkitPresenter;
import com.didi.component.safetoolkit.presenter.PresenterHolder;
import com.didi.globalsafetoolkit.SafeBusinessData;
import com.didi.globalsafetoolkit.api.IGlobalSfInfoService;
import com.didi.globalsafetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.globalsafetoolkit.model.SfContactsModel;
import com.didi.globalsafetoolkit.model.SfLocation;
import com.didi.safetoolkit.util.SfLog;
import com.didi.safetoolkit.util.SfUIThreadHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.messagecenter.p153pb.CommonMsgReq;
import com.didi.sdk.messagecenter.p153pb.PushMessageType;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.push.manager.DPushBody;
import com.didi.sdk.push.manager.DPushListener;
import com.didi.sdk.push.manager.DPushManager;
import com.didi.sdk.push.manager.DPushType;
import com.didi.sdk.reversegeo.ReverseLocationStore;
import com.didi.sdk.store.FetchCallback;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import com.squareup.wire.Wire;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GlobalSfBusinessImpl implements IGlobalSfInfoService {

    /* renamed from: a */
    private Map<IGlobalSfInfoService.ISfPushListener, DPushListener> f17212a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public GlobalDialog f17213b = new GlobalDialog();

    private interface SfCallback {
        void onFailed(String str);

        void onSucceed(SfLocation sfLocation);
    }

    public String getAlias() {
        return GlobalComponentConfig.TRIP_AUDIO_RECORD_ALIAS_PASSENGET;
    }

    public SafeBusinessData getBusinessInfo() {
        SafeBusinessData safeBusinessData = new SafeBusinessData();
        CarOrder order = CarOrderHelper.getOrder();
        safeBusinessData.setOid(order != null ? order.getOid() : "");
        safeBusinessData.setPage("home");
        safeBusinessData.setProductId(String.valueOf(CarOrderHelper.getOrder() == null ? BusinessDataUtil.getProductId() : Integer.valueOf(CarOrderHelper.getOrder().getProductId())));
        safeBusinessData.setCountryIsoCode(BusinessUtils.getCountryIsoCode((BusinessContext) BusinessContextManager.getInstance().getCurBusinessContext()));
        safeBusinessData.setBusinessType(ConfProxy.getInstance().getSelectedType());
        return safeBusinessData;
    }

    public void onNewTrustedContactAdded(boolean z) {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_NEW_TRUSTED_CONTACT_ADDED_FROM_NEW_SHARE);
        if (z) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_DISMISS_BUBBLE);
        }
    }

    public void onContactsShared() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_DISMISS_BUBBLE);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_REQUEST_JARVIS);
    }

    public void onTrustedContactChanged(SfContactsManageModel sfContactsManageModel) {
        if (sfContactsManageModel != null && sfContactsManageModel.datas != null && sfContactsManageModel.datas.contacts != null) {
            ArrayList arrayList = new ArrayList();
            for (SfContactsModel next : sfContactsManageModel.datas.contacts) {
                com.didi.safetoolkit.model.SfContactsModel sfContactsModel = new com.didi.safetoolkit.model.SfContactsModel();
                sfContactsModel.name = next.name;
                sfContactsModel.phone = next.phone;
                sfContactsModel.need_areacode = next.need_areacode;
                sfContactsModel.origin_phone = next.origin_phone;
                sfContactsModel.phone_mask = next.phone_mask;
                sfContactsModel.phone_encode = next.phone_encode;
                sfContactsModel.checked = next.checked;
                arrayList.add(sfContactsModel);
            }
            ShareTripDialogCache.getInstance().setContacts(arrayList);
        }
    }

    public void startSocialShare(boolean z) {
        BaseEventPublisher.getPublisher().publish("event_Share_before_accepted", Boolean.valueOf(z));
    }

    public void monitorAbnormalClick(Context context, String str) {
        SafeToolkitBffRequest.reportUserState(context, new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_REQUEST_JARVIS);
            }
        }, str);
    }

    public void nullShieldClick(Context context) {
        if (!OneLoginFacade.getStore().isLoginNow()) {
            OneLoginFacade.getAction().go2Login(context);
        }
    }

    public void getCurrentLocation(final Context context, final IGlobalSfInfoService.SfCallback sfCallback) {
        if (sfCallback != null) {
            if (context == null) {
                try {
                    sfCallback.onFailed("context is null");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                LocationController instance = LocationController.getInstance();
                final ComponentParams componentParams = null;
                IPresenter presenter = PresenterHolder.getIns().getPresenter();
                if (presenter == null || !(presenter instanceof AbsSafeToolkitPresenter) || (componentParams = ((AbsSafeToolkitPresenter) presenter).getComponentParams()) != null) {
                    if (componentParams == null) {
                        componentParams = new ComponentParams();
                    }
                    instance.requestLocationUpdateOnce(context, new LocationController.OneCarLocationListener() {
                        public void onStatusUpdate(String str, int i, String str2) {
                        }

                        public void onLocationChanged(DIDILocation dIDILocation) {
                            SfLocation a = GlobalSfBusinessImpl.this.m14424a(dIDILocation);
                            ComponentParams componentParams = componentParams;
                            if (componentParams != null) {
                                GlobalSfBusinessImpl.this.m14425a(context, a, dIDILocation, componentParams, sfCallback);
                            }
                        }

                        public void onLocationError(int i, ErrInfo errInfo) {
                            try {
                                IGlobalSfInfoService.SfCallback sfCallback = sfCallback;
                                sfCallback.onFailed("location error:" + errInfo.getErrMessage());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public SfLocation m14424a(DIDILocation dIDILocation) {
        if (dIDILocation == null) {
            return null;
        }
        SfLocation sfLocation = new SfLocation();
        sfLocation.lat = dIDILocation.getLatitude();
        sfLocation.lng = dIDILocation.getLongitude();
        return sfLocation;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14425a(Context context, final SfLocation sfLocation, DIDILocation dIDILocation, ComponentParams componentParams, final IGlobalSfInfoService.SfCallback sfCallback) {
        ReverseLocationStore.getsInstance().fetchReverseLocation(context, componentParams.bid, dIDILocation.getLatitude(), dIDILocation.getLongitude(), dIDILocation.getAccuracy(), dIDILocation.getProvider(), new FetchCallback<Address>() {
            public void onSuccess(Address address) {
                sfLocation.address = address.address;
                SfLocation sfLocation = sfLocation;
                sfLocation.cityId = address.cityId + "";
                sfLocation.cityName = address.cityName;
                sfLocation.coordinate_type = address.coordinate_type;
                sfLocation.displayName = address.displayName;
                sfLocation.fullName = address.fullName;
                sfLocation.name = address.name;
                try {
                    sfCallback.onSucceed(sfLocation);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onFail(int i) {
                try {
                    IGlobalSfInfoService.SfCallback sfCallback = sfCallback;
                    sfCallback.onFailed("geo fail code:" + i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void registerCommonMsgPush(final IGlobalSfInfoService.ISfPushListener iSfPushListener) {
        final int value = PushMessageType.kPushMessageTypeCommonMsgReq.getValue();
        C72674 r1 = new DPushListener() {
            public DPushType pushType() {
                return DPushType.TENCENT_PUSH;
            }

            public void pushBody(DPushBody dPushBody) {
                CommonMsgReq commonMsgReq;
                try {
                    commonMsgReq = (CommonMsgReq) new Wire((Class<?>[]) new Class[0]).parseFrom(dPushBody.getData(), CommonMsgReq.class);
                } catch (IOException e) {
                    e.printStackTrace();
                    commonMsgReq = null;
                }
                if (commonMsgReq != null) {
                    final int intValue = ((Integer) Wire.get(commonMsgReq.recommond_type, CommonMsgReq.DEFAULT_RECOMMOND_TYPE)).intValue();
                    final String str = (String) Wire.get(commonMsgReq.recommond_msg, "");
                    SfLog.m28130d("received push message: (type: " + intValue + "\t  message: " + str + ")");
                    SfUIThreadHelper.post(new Runnable() {
                        public void run() {
                            iSfPushListener.onCommonMsgReceived(intValue, str);
                        }
                    });
                }
            }

            public String topic() {
                return value + "";
            }
        };
        this.f17212a.put(iSfPushListener, r1);
        DPushManager.getInstance().registerPush((DPushListener) r1);
    }

    public void unregisterCommonMsgPush(IGlobalSfInfoService.ISfPushListener iSfPushListener) {
        if (this.f17212a.containsKey(iSfPushListener)) {
            DPushManager.getInstance().unregisterPush(this.f17212a.remove(iSfPushListener));
        }
    }

    public void openLawWebView() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_OPEN_LAW_URL);
    }

    public void showDialog(final FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, final View.OnClickListener onClickListener) {
        if (this.f17213b.isPendingDismiss() || !this.f17213b.isVisible()) {
            this.f17213b.build().title(str2).actions(new GlobalDialog.IButtonAction[]{new GlobalDialog.PositiveButtonAction() {
                public String getName() {
                    return fragmentActivity.getString(R.string.global_record_permission_confirm);
                }

                public Runnable getAction() {
                    return new Runnable() {
                        public void run() {
                            onClickListener.onClick((View) null);
                            GlobalSfBusinessImpl.this.f17213b.dismiss();
                        }
                    };
                }

                public GlobalDialog.IButtonAction.ButtonType getType() {
                    return GlobalDialog.IButtonAction.ButtonType.POSITIVE;
                }
            }, new GlobalDialog.PositiveButtonAction() {
                public String getName() {
                    return fragmentActivity.getString(R.string.global_record_permission_cancel);
                }

                public Runnable getAction() {
                    return new Runnable() {
                        public void run() {
                            GlobalSfBusinessImpl.this.f17213b.dismiss();
                        }
                    };
                }

                public GlobalDialog.IButtonAction.ButtonType getType() {
                    return GlobalDialog.IButtonAction.ButtonType.NEGATIVE;
                }
            }}).show(fragmentActivity.getSupportFragmentManager(), "audio_record");
        }
    }

    public void onRecordingStatusChanged(Boolean bool) {
        BaseEventPublisher.getPublisher().publish("event_record_status_changed", bool);
    }

    public void sendLocation() {
        DidiTrackingClient.getInstance().callTrackingAtOnce(3);
    }

    public void handleUri(Context context, String str) {
        CountryInfo countryInfo;
        IPresenter presenter = PresenterHolder.getIns().getPresenter();
        if (!TextUtils.isEmpty(str)) {
            if (presenter instanceof AbsSafeToolkitPresenter) {
                countryInfo = BusinessUtils.getCountryInfo(((AbsSafeToolkitPresenter) presenter).getComponentParams().bizCtx);
            } else {
                countryInfo = BusinessUtils.getCountryInfo((BusinessContext) BusinessContextManager.getInstance().getCurBusinessContext());
            }
            if (countryInfo != null) {
                str = Uri.parse(str).buildUpon().appendQueryParameter(ServerParam.PARAM_TRIPCOUNTRY, countryInfo.getCountryIsoCode()).build().toString();
            }
            Intent intent = new Intent(context, GlobalWebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(str));
            context.startActivity(intent);
        }
    }

    public void addOmegaEvent(String str, Map<String, Object> map) {
        IPresenter presenter = PresenterHolder.getIns().getPresenter();
        if (presenter instanceof AbsSafeToolkitPresenter) {
            int i = 0;
            AbsSafeToolkitPresenter absSafeToolkitPresenter = (AbsSafeToolkitPresenter) presenter;
            if (absSafeToolkitPresenter.getComponentParams().pageID != 1001) {
                i = absSafeToolkitPresenter.getComponentParams().bid;
            }
            map.put("g_BizId", i + "");
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null) {
                map.put("g_orderid", order.oid + "");
            }
            map.put("g_pageid", absSafeToolkitPresenter.getComponentParams().pageID + "");
            GlobalOmegaUtils.trackEvent(str, map);
            return;
        }
        int currentBID = BusinessUtils.getCurrentBID((BusinessContext) BusinessContextManager.getInstance().getCurBusinessContext());
        map.put("g_BizId", currentBID + "");
        CarOrder order2 = CarOrderHelper.getOrder();
        if (order2 != null) {
            map.put("g_orderid", order2.oid + "");
        }
        map.put("page", AbsJarvisPresenter.sGPageId);
        GlobalOmegaUtils.trackEvent(str, map);
    }

    public Map<String, Object> getBaseHttpParams(Context context) {
        return new ProviderBaseRequest().createBaseParams(context);
    }

    private class ProviderBaseRequest extends BaseRequest {
        private ProviderBaseRequest() {
        }

        public Map<String, Object> createBaseParams(Context context) {
            return super.createBaseParams(context);
        }
    }
}
