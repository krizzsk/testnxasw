package com.didi.globalsafetoolkit;

import android.content.Intent;
import android.net.Uri;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.drouter.api.DRouter;
import com.didi.globalsafetoolkit.api.IGlobalSfInfoService;
import com.didi.globalsafetoolkit.business.emergency.SfEmergencyNumHelper;
import com.didi.globalsafetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.globalsafetoolkit.business.emergency.model.SfEmgStatus;
import com.didi.globalsafetoolkit.business.record.request.SfAutoRecordRequest;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfPanelData;
import com.didi.globalsafetoolkit.business.triprecording.GlobalTripRecordingManagerNew;
import com.didi.globalsafetoolkit.model.SfBaseObject;
import com.didi.globalsafetoolkit.model.SfLocation;
import com.didi.globalsafetoolkit.net.SfResponseListener;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import p218io.flutter.plugin.common.MethodChannel;

public class GlobalSfFlutterHandleImpl implements GlobalSfFlutterHandle {

    /* renamed from: b */
    private static final String f24880b = "GlobalSfFlutterHandle";

    /* renamed from: a */
    HashMap<String, String> f24881a = new HashMap<>();

    /* renamed from: c */
    private GlobalSfPush f24882c;

    public void onDetached() {
    }

    public void onGetInfo(final MethodChannel.Result result) {
        GlobalSfManager.getInstance().refreshPanelData(0, (Map<String, Object>) null, new BffResponseListener<GlobalSfPanelData>() {
            public void onSuccess(GlobalSfPanelData globalSfPanelData) {
                result.success(new Gson().toJson((Object) globalSfPanelData));
            }
        });
    }

    public void getEmergencyInfo(final MethodChannel.Result result) {
        SystemUtils.log(4, f24880b, "getEmergencyInfo: ", (Throwable) null, "com.didi.globalsafetoolkit.GlobalSfFlutterHandleImpl", 66);
        GlobalSfManager.getInstance().requestEmergencyInfo(new SfResponseListener<SfEmgInfo>() {
            public void onSuccess(SfEmgInfo sfEmgInfo) {
                result.success(new Gson().toJson((Object) sfEmgInfo));
            }
        });
    }

    public void getEmergencyStatus(final MethodChannel.Result result) {
        GlobalSfManager.getInstance().getEmergencyStatus(new SfResponseListener<SfEmgStatus>() {
            public void onSuccess(SfEmgStatus sfEmgStatus) {
                result.success(new Gson().toJson((Object) sfEmgStatus));
            }
        });
    }

    public void jumpToPhoneCall(MethodChannel.Result result) {
        String emergencyCallNum = SfEmergencyNumHelper.getEmergencyCallNum();
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + emergencyCallNum));
        intent.addFlags(268435456);
        if (SfContextHelper.getContext() != null) {
            SfContextHelper.getContext().startActivity(intent);
        }
    }

    public void getUserLocation(final MethodChannel.Result result) {
        GlobalSfBusinessInterface.getCurrentLocation(SfContextHelper.getContext(), new IGlobalSfInfoService.SfCallback() {
            public void onFailed(String str) {
            }

            public void onSucceed(SfLocation sfLocation) {
                result.success(sfLocation.address);
            }
        });
    }

    public void startEmergencyCall(final MethodChannel.Result result) {
        GlobalSfManager.getInstance().startEmergency(new SfResponseListener<SfBaseObject>() {
            public void onSuccess(SfBaseObject sfBaseObject) {
                result.success(new Gson().toJson((Object) sfBaseObject));
            }
        });
    }

    public void stopEmergencyCall(final MethodChannel.Result result) {
        GlobalSfManager.getInstance().stopEmergencyCall(new SfResponseListener<SfBaseObject>() {
            public void onSuccess(SfBaseObject sfBaseObject) {
                result.success(new Gson().toJson((Object) sfBaseObject));
            }
        });
    }

    public void sendCurrentLocation(MethodChannel.Result result) {
        GlobalSfBusinessInterface.sendLocation();
    }

    public void getEmergencyPhoneNumber(MethodChannel.Result result) {
        result.success(SfEmergencyNumHelper.getEmergencyCallNum());
    }

    public void registerPushMessage(MethodChannel.Result result) {
        if (this.f24882c == null) {
            this.f24882c = new GlobalSfPush();
        }
        GlobalSfBusinessInterface.registerCommonMsgPush(this.f24882c);
    }

    public void unregisterPushMessage(MethodChannel.Result result) {
        GlobalSfBusinessInterface.unregisterCommonMsgPush(this.f24882c);
    }

    public void jumpToLearnMore(MethodChannel.Result result, String str) {
        DRouter.build(str).start(SfContextHelper.getContext());
    }

    public void openOrCloseRecord(MethodChannel.Result result, Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("open_record");
            Object obj2 = map.get("is_auto_record");
            if ((obj instanceof Integer) && ((Integer) obj).intValue() == 1) {
                GlobalSfManager.getInstance().startRecord();
            }
            if (obj2 instanceof Integer) {
                GlobalSfManager.getInstance().refreshBubbleData(((Integer) obj2).intValue(), (Map<String, Object>) null, (BffResponseListener) null);
            }
        }
    }

    public void setAutoRecordState(MethodChannel.Result result, Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("open_record");
            Object obj2 = map.get("auto_voice_switch");
            if ((obj instanceof Integer) && ((Integer) obj).intValue() == 1) {
                GlobalSfManager.getInstance().startRecord();
            }
            if (obj2 instanceof Integer) {
                SfAutoRecordRequest.autoRecordReport(((Integer) obj2).intValue(), 0);
                GlobalSfManager.getInstance().refreshBubbleData(0, (Map<String, Object>) null, (BffResponseListener) null);
            }
        }
    }

    public void openOrCloseMonitor(final MethodChannel.Result result, Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("state");
            if (obj instanceof Boolean) {
                GlobalSfManager.getInstance().reportMonitorState(SfContextHelper.getContext(), 1, ((Boolean) obj).booleanValue() ? 1 : 2, new RpcService.Callback<JsonObject>() {
                    public void onFailure(IOException iOException) {
                    }

                    public void onSuccess(JsonObject jsonObject) {
                        result.success(jsonObject);
                    }
                });
            }
        }
    }

    public void getMonitorInfo(final MethodChannel.Result result) {
        if (GlobalSfManager.getInstance().getPanelData() != null) {
            result.success(new Gson().toJson((Object) GlobalSfManager.getInstance().getPanelData()));
        } else {
            GlobalSfManager.getInstance().refreshPanelData(0, (Map<String, Object>) null, new BffResponseListener<GlobalSfPanelData>() {
                public void onSuccess(GlobalSfPanelData globalSfPanelData) {
                    result.success(new Gson().toJson((Object) globalSfPanelData));
                }
            });
        }
    }

    public void getRecordInfo(final MethodChannel.Result result) {
        if (GlobalSfManager.getInstance().getPanelData() != null) {
            result.success(new Gson().toJson((Object) GlobalSfManager.getInstance().getPanelData()));
        } else {
            GlobalSfManager.getInstance().refreshPanelData(0, (Map<String, Object>) null, new BffResponseListener<GlobalSfPanelData>() {
                public void onSuccess(GlobalSfPanelData globalSfPanelData) {
                    result.success(new Gson().toJson((Object) globalSfPanelData));
                }
            });
        }
    }

    public void getRecordStatus(MethodChannel.Result result) {
        this.f24881a.put("state", GlobalTripRecordingManagerNew.Companion.getInstance().getState());
        this.f24881a.put("duration", GlobalTripRecordingManagerNew.Companion.getInstance().isRecording() ? GlobalTripRecordingManagerNew.Companion.getInstance().getDuration() : "00:00:00");
        result.success(this.f24881a);
    }
}
