package com.didi.globalsafetoolkit;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.android.didi.bfflib.business.BffRequestUtil;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.globalsafetoolkit.business.emergency.TimeSendLocationMgr;
import com.didi.globalsafetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.globalsafetoolkit.business.emergency.model.SfEmgStatus;
import com.didi.globalsafetoolkit.business.emergency.request.SfEmergencyInfoRequest;
import com.didi.globalsafetoolkit.business.emergency.request.SfEmergencyStatusRequest;
import com.didi.globalsafetoolkit.business.emergency.request.SfStartEmergencyCallRequest;
import com.didi.globalsafetoolkit.business.emergency.request.SfStopEmergencyCallRequest;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfBubbleData;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfPanelData;
import com.didi.globalsafetoolkit.model.SfBaseObject;
import com.didi.globalsafetoolkit.net.SfHttpManager;
import com.didi.globalsafetoolkit.net.SfResponseListener;
import com.didi.globalsafetoolkit.net.SfRpcCallback;
import com.didi.globalsafetoolkit.omega.SfOmegaUtil;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

public class GlobalSfRequest {
    public static final String ABILITY_MONITOR_REPORT_EVENT = "dexter/passengerRecord";
    public static final String ABILITY_MONITOR_STATE = "heimdallr/pMonitorState";
    public static final String ABILITY_MONITOR_USER_STATE = "heimdallr/pBubbleReport";
    public static final String JARVIS_BUBBLE = "heimdallr/pJarvisSafetoolkit/bubbles";
    public static final String JARVIS_PANEL = "heimdallr/pJarvisSafetoolkit/details";

    public static void requestBubbleData(int i, int i2, String str, Map<String, Object> map, BffResponseListener<GlobalSfBubbleData> bffResponseListener) {
        HashMap hashMap = new HashMap();
        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
        if (businessInfo != null) {
            hashMap.put("oid", businessInfo.getOid());
            hashMap.put("product", businessInfo.getProductId());
            hashMap.put("page", GlobalSfManager.getInstance().getCurPage());
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("is_oasis_driver", 0);
        hashMap.put("data_version", str);
        hashMap.put("in_recording", Integer.valueOf(i));
        hashMap.put("open_manual_record", Integer.valueOf(i2));
        BffRequestUtil.request(SfContextHelper.getContext(), JARVIS_BUBBLE, hashMap, bffResponseListener);
    }

    public static void requestPanelData(String str, int i, int i2, String str2, BffResponseListener<GlobalSfPanelData> bffResponseListener) {
        HashMap hashMap = new HashMap();
        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
        if (businessInfo != null) {
            hashMap.put("oid", businessInfo.getOid());
            hashMap.put("product", businessInfo.getProductId());
            if (TextUtils.isEmpty(str)) {
                str = businessInfo.getPage();
            }
            hashMap.put("page", str);
        }
        hashMap.put("is_oasis_driver", 0);
        hashMap.put("data_version", str2);
        hashMap.put("in_recording", Integer.valueOf(i));
        hashMap.put("open_manual_record", Integer.valueOf(i2));
        BffRequestUtil.request(SfContextHelper.getContext(), JARVIS_PANEL, hashMap, bffResponseListener);
    }

    public static void requestEmergencyInfo(final SfResponseListener<SfEmgInfo> sfResponseListener) {
        SfEmergencyInfoRequest sfEmergencyInfoRequest = new SfEmergencyInfoRequest();
        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
        if (businessInfo != null) {
            sfEmergencyInfoRequest.orderId = businessInfo.getOid();
            sfEmergencyInfoRequest.countryCode = businessInfo.getCountryIsoCode();
            sfEmergencyInfoRequest.productId = Integer.parseInt(businessInfo.getProductId());
        }
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

    public static void getEmergencyStatus(final SfResponseListener<SfEmgStatus> sfResponseListener) {
        SfEmergencyStatusRequest sfEmergencyStatusRequest = new SfEmergencyStatusRequest();
        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
        if (businessInfo != null) {
            sfEmergencyStatusRequest.orderId = businessInfo.getOid();
            sfEmergencyStatusRequest.countryCode = businessInfo.getCountryIsoCode();
            sfEmergencyStatusRequest.productId = Integer.parseInt(businessInfo.getProductId());
        }
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfEmergencyStatusRequest, new SfRpcCallback<SfEmgStatus>(new SfResponseListener<SfEmgStatus>() {
            public void onSuccess(SfEmgStatus sfEmgStatus) {
                sfResponseListener.onSuccess(sfEmgStatus);
                if (sfEmgStatus.data.isOnEmergencyCallStatus > 0) {
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

    public static void startEmergency(final SfResponseListener<SfBaseObject> sfResponseListener) {
        SfStartEmergencyCallRequest sfStartEmergencyCallRequest = new SfStartEmergencyCallRequest();
        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
        if (businessInfo != null) {
            sfStartEmergencyCallRequest.orderId = businessInfo.getOid();
            sfStartEmergencyCallRequest.countryCode = businessInfo.getCountryIsoCode();
            sfStartEmergencyCallRequest.productId = Integer.parseInt(businessInfo.getProductId());
        }
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfStartEmergencyCallRequest, new SfRpcCallback<SfBaseObject>(new SfResponseListener<SfBaseObject>() {
            public void onSuccess(SfBaseObject sfBaseObject) {
                GlobalSfManager.getInstance().refreshBubbleData(0, (Map<String, Object>) null, (BffResponseListener) null);
                GlobalSfManager.getInstance().refreshPanelData(0, (Map<String, Object>) null, (BffResponseListener<GlobalSfPanelData>) null);
                TimeSendLocationMgr.getInstance().startSendLocation();
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

    public static void stopEmergencyCall(final SfResponseListener<SfBaseObject> sfResponseListener) {
        SfStopEmergencyCallRequest sfStopEmergencyCallRequest = new SfStopEmergencyCallRequest();
        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
        if (businessInfo != null) {
            sfStopEmergencyCallRequest.orderId = businessInfo.getOid();
            sfStopEmergencyCallRequest.countryCode = businessInfo.getCountryIsoCode();
            sfStopEmergencyCallRequest.productId = Integer.parseInt(businessInfo.getProductId());
        }
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfStopEmergencyCallRequest, new SfRpcCallback<SfBaseObject>(new SfResponseListener<SfBaseObject>() {
            public void onSuccess(SfBaseObject sfBaseObject) {
                GlobalSfManager.getInstance().refreshBubbleData(0, (Map<String, Object>) null, (BffResponseListener) null);
                GlobalSfManager.getInstance().refreshPanelData(0, (Map<String, Object>) null, (BffResponseListener<GlobalSfPanelData>) null);
                TimeSendLocationMgr.getInstance().stopSendLocation();
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

    public static void reportMonitorState(Context context, int i, int i2, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("state", Integer.valueOf(i2));
        Bff.call(new IBffProxy.Ability.Builder(context, "heimdallr/pMonitorState").setParams(hashMap).setCallback(callback).build());
    }

    public static void reportUserState(Context context, RpcService.Callback<JsonObject> callback, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("bubble_id", str);
        Bff.call(new IBffProxy.Ability.Builder(context, "heimdallr/pBubbleReport").setParams(hashMap).setCallback(callback).build());
    }

    public static void reportMonitorEvent(Context context, int i, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
        if (businessInfo != null) {
            hashMap.put("order_id", businessInfo.getOid());
            hashMap.put("push_id", businessInfo.getPushId());
        }
        hashMap.put("code", Integer.valueOf(i));
        Bff.call(new IBffProxy.Ability.Builder(context, "dexter/passengerRecord").setParams(hashMap).setCallback(callback).build());
    }
}
