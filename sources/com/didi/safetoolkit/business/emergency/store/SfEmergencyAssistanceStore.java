package com.didi.safetoolkit.business.emergency.store;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.safetoolkit.api.ISfInfoService;
import com.didi.safetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.safetoolkit.business.emergency.model.SfEmgStatus;
import com.didi.safetoolkit.business.emergency.model.SfGetEmergencyInfo;
import com.didi.safetoolkit.business.emergency.request.SfEmergencyInfoRequest;
import com.didi.safetoolkit.business.emergency.request.SfEmergencyStatusRequest;
import com.didi.safetoolkit.business.emergency.request.SfStartEmergencyCallRequest;
import com.didi.safetoolkit.business.emergency.request.SfStopEmergencyCallRequest;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.model.SfBaseObject;
import com.didi.safetoolkit.net.SfHttpManager;
import com.didi.safetoolkit.net.SfResponseListener;
import com.didi.safetoolkit.net.SfRpcCallback;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.safetoolkit.util.SfContextHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;

public class SfEmergencyAssistanceStore {

    /* renamed from: a */
    private static volatile SfEmergencyAssistanceStore f37105a;

    public static SfEmergencyAssistanceStore getInstance() {
        if (f37105a == null) {
            synchronized (SfEmergencyAssistanceStore.class) {
                if (f37105a == null) {
                    f37105a = new SfEmergencyAssistanceStore();
                }
            }
        }
        return f37105a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28026a(boolean z) {
        Intent intent = new Intent();
        intent.setAction(z ? "sf_emergency_assist_on" : "sf_emergency_assist_off");
        LocalBroadcastManager.getInstance(SfContextHelper.getContext()).sendBroadcast(intent);
    }

    /* renamed from: a */
    private String m28024a() {
        ISfInfoService iSfInfoService = (ISfInfoService) ServiceLoader.load(ISfInfoService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfInfoService != null) {
            return iSfInfoService.getCarOrderId();
        }
        return null;
    }

    /* renamed from: b */
    private String m28027b() {
        ISfInfoService iSfInfoService = (ISfInfoService) ServiceLoader.load(ISfInfoService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfInfoService != null) {
            return iSfInfoService.getCountryIsoCode();
        }
        return null;
    }

    public void getEmergencyInfo(final SfResponseListener<SfEmgInfo> sfResponseListener) {
        if (SafeToolKit.getIns().isVamosDriver()) {
            Bff.call(new IBffProxy.Ability.Builder(SfContextHelper.getContext(), "heimdallr/dGetEmergencyInfo").setCallback(new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    sfResponseListener.onSuccess(SfEmgInfo.convertFrom((SfGetEmergencyInfo) new Gson().fromJson(jsonObject.toString(), SfGetEmergencyInfo.class)));
                }

                public void onFailure(IOException iOException) {
                    sfResponseListener.onFail(-1, iOException.getMessage());
                }
            }).build());
            return;
        }
        SfEmergencyInfoRequest sfEmergencyInfoRequest = new SfEmergencyInfoRequest();
        sfEmergencyInfoRequest.orderId = m28024a();
        sfEmergencyInfoRequest.countryCode = m28027b();
        sfEmergencyInfoRequest.productId = SafeToolKit.getIns().getProductId();
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfEmergencyInfoRequest, new SfRpcCallback<SfEmgInfo>(new SfResponseListener<SfEmgInfo>() {
            public void onSuccess(SfEmgInfo sfEmgInfo) {
                sfResponseListener.onSuccess(sfEmgInfo);
            }

            public void onError(SfEmgInfo sfEmgInfo) {
                if (sfEmgInfo != null) {
                    sfResponseListener.onFail(sfEmgInfo.errno, sfEmgInfo.errmsg);
                }
            }

            public void onFail(int i, String str) {
                sfResponseListener.onFail(i, str);
            }
        }) {
        });
    }

    public void getEmergencyStatus(final SfResponseListener<SfEmgStatus> sfResponseListener) {
        SfEmergencyStatusRequest sfEmergencyStatusRequest = new SfEmergencyStatusRequest();
        sfEmergencyStatusRequest.orderId = m28024a();
        sfEmergencyStatusRequest.countryCode = m28027b();
        sfEmergencyStatusRequest.productId = SafeToolKit.getIns().getProductId();
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfEmergencyStatusRequest, new SfRpcCallback<SfEmgStatus>(new SfResponseListener<SfEmgStatus>() {
            public void onSuccess(SfEmgStatus sfEmgStatus) {
                sfResponseListener.onSuccess(sfEmgStatus);
                if (sfEmgStatus.data.isOnEmergencyCallStatus > 0) {
                    SfEmergencyAssistanceStore.this.m28026a(true);
                    SfOmegaUtil.addEventId("gp_safetyToolkit_inHelp_sw").report();
                }
            }

            public void onError(SfEmgStatus sfEmgStatus) {
                if (sfEmgStatus != null) {
                    sfResponseListener.onFail(sfEmgStatus.errno, sfEmgStatus.errmsg);
                }
            }

            public void onFail(int i, String str) {
                sfResponseListener.onFail(i, str);
            }
        }) {
        });
    }

    public void startEmergencyCall(final SfResponseListener<SfBaseObject> sfResponseListener) {
        if (SafeToolKit.getIns().isVamosDriver()) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", m28024a());
            Bff.call(new IBffProxy.Ability.Builder(SfContextHelper.getContext(), "heimdallr/dReportEmergencyInfo").setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    sfResponseListener.onSuccess((SfEmgStatus) new Gson().fromJson(jsonObject.toString(), SfEmgStatus.class));
                    SfEmergencyAssistanceStore.this.m28026a(true);
                    SfOmegaUtil.addEventId("gp_safetyToolkit_inHelp_sw").report();
                }

                public void onFailure(IOException iOException) {
                    sfResponseListener.onFail(-1, iOException.getMessage());
                }
            }).build());
            return;
        }
        SfStartEmergencyCallRequest sfStartEmergencyCallRequest = new SfStartEmergencyCallRequest();
        sfStartEmergencyCallRequest.orderId = m28024a();
        sfStartEmergencyCallRequest.countryCode = m28027b();
        sfStartEmergencyCallRequest.productId = SafeToolKit.getIns().getProductId();
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfStartEmergencyCallRequest, new SfRpcCallback<SfBaseObject>(new SfResponseListener<SfBaseObject>() {
            public void onSuccess(SfBaseObject sfBaseObject) {
                SfEmergencyAssistanceStore.this.m28026a(true);
                SfOmegaUtil.addEventId("gp_safetyToolkit_inHelp_sw").report();
                sfResponseListener.onSuccess(sfBaseObject);
            }

            public void onError(SfBaseObject sfBaseObject) {
                if (sfBaseObject != null) {
                    sfResponseListener.onFail(sfBaseObject.errno, sfBaseObject.errmsg);
                }
            }

            public void onFail(int i, String str) {
                sfResponseListener.onFail(i, str);
            }
        }) {
        });
    }

    public void stopEmergencyCall(final SfResponseListener<SfBaseObject> sfResponseListener) {
        SfStopEmergencyCallRequest sfStopEmergencyCallRequest = new SfStopEmergencyCallRequest();
        sfStopEmergencyCallRequest.orderId = m28024a();
        sfStopEmergencyCallRequest.countryCode = m28027b();
        sfStopEmergencyCallRequest.productId = SafeToolKit.getIns().getProductId();
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfStopEmergencyCallRequest, new SfRpcCallback<SfBaseObject>(new SfResponseListener<SfBaseObject>() {
            public void onSuccess(SfBaseObject sfBaseObject) {
                SfEmergencyAssistanceStore.this.m28026a(false);
                sfResponseListener.onSuccess(sfBaseObject);
            }

            public void onError(SfBaseObject sfBaseObject) {
                if (sfBaseObject != null) {
                    sfResponseListener.onFail(sfBaseObject.errno, sfBaseObject.errmsg);
                }
            }

            public void onFail(int i, String str) {
                sfResponseListener.onFail(i, str);
            }
        }) {
        });
    }
}
