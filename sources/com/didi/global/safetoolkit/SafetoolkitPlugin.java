package com.didi.global.safetoolkit;

import com.didi.globalsafetoolkit.GlobaSfToFlutter;
import com.didi.globalsafetoolkit.GlobalSfFlutterHandle;
import com.didi.globalsafetoolkit.apollo.SfApolloUtil;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.safetoolkit.IFlutter2Native;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.plugin.common.JSONUtil;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;

public class SafetoolkitPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static final String NAME = "com.didi.flutter.safetoolkit";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MethodChannel f24849a;

    public SafetoolkitPlugin() {
        if (!m19931a()) {
            SafeToolKit.getIns().setFlutterListener(new IFlutter2Native() {
                public void updateInfo(String str) {
                    if (SafetoolkitPlugin.this.f24849a != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("safetoolkit_rsp", str);
                        SafetoolkitPlugin.this.f24849a.invokeMethod("safeToolkitDataUpdate", hashMap);
                    }
                }

                public void buttonStatusChanged(String str, String str2) {
                    if (SafetoolkitPlugin.this.f24849a != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("action", str);
                        hashMap.put("status", str2);
                        SafetoolkitPlugin.this.f24849a.invokeMethod("buttonStatusChanged", hashMap);
                    }
                }
            });
        } else {
            GlobalSfManager.getInstance().setFlutterListener(new GlobaSfToFlutter() {
                public void showCancelAlarmDialog() {
                }

                public void updateInfo(String str) {
                    if (SafetoolkitPlugin.this.f24849a != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("safetoolkit_rsp", str);
                        SafetoolkitPlugin.this.f24849a.invokeMethod("safeToolkitDataUpdate", hashMap);
                    }
                }

                public void buttonStatusChanged(String str, String str2) {
                    if (SafetoolkitPlugin.this.f24849a != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("action", str);
                        hashMap.put("status", str2);
                        SafetoolkitPlugin.this.f24849a.invokeMethod("buttonStatusChanged", hashMap);
                    }
                }

                public void stopEmergency() {
                    if (SafetoolkitPlugin.this.f24849a != null) {
                        SafetoolkitPlugin.this.f24849a.invokeMethod("stopEmergency", (Object) null);
                    }
                }

                public void safeToolKitRecordDurantionUpdate(Map<String, String> map) {
                    if (SafetoolkitPlugin.this.f24849a != null) {
                        SafetoolkitPlugin.this.f24849a.invokeMethod("safeToolKitRecordDurantionUpdate", JSONUtil.wrap(map).toString());
                    }
                }
            });
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel.MethodCallHandler methodCallHandler;
        boolean a = m19931a();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), NAME);
        this.f24849a = methodChannel;
        if (a) {
            methodCallHandler = this;
        } else {
            methodCallHandler = new MethodChannel.MethodCallHandler() {
                public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                    if ("getInfo".equals(methodCall.method)) {
                        if (SafeToolKit.getIns().getDataHandle() != null) {
                            SafeToolKit.getIns().getDataHandle().onGetInfo(result);
                        }
                    } else if (!"onDetached".equals(methodCall.method)) {
                    } else {
                        if (SafeToolKit.getIns().getDataHandle() != null) {
                            try {
                                SafeToolKit.getIns().getDataHandle().onDetached();
                                result.success(true);
                            } catch (Exception e) {
                                result.success(false);
                                e.printStackTrace();
                            }
                        } else {
                            result.success(true);
                        }
                    }
                }
            };
        }
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    /* renamed from: a */
    private boolean m19931a() {
        return SfApolloUtil.isNewSafe();
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        SystemUtils.log(4, "SafetoolkitPlugin", "onMethodCall: " + methodCall.method, (Throwable) null, "com.didi.global.safetoolkit.SafetoolkitPlugin", 151);
        GlobalSfFlutterHandle dataHandle = GlobalSfManager.getInstance().getDataHandle();
        if (dataHandle != null) {
            if ("getInfo".equals(methodCall.method)) {
                dataHandle.onGetInfo(result);
            } else if ("onDetached".equals(methodCall.method)) {
                try {
                    dataHandle.onDetached();
                    result.success(true);
                } catch (Exception e) {
                    result.success(false);
                    e.printStackTrace();
                }
            } else if ("getEmergencyInfo".equals(methodCall.method)) {
                dataHandle.getEmergencyInfo(result);
            } else if ("getEmergencyStatus".equals(methodCall.method)) {
                dataHandle.getEmergencyStatus(result);
            } else if ("jumpToEmergencyPhone".equals(methodCall.method)) {
                dataHandle.jumpToPhoneCall(result);
            } else if ("getUserLocation".equals(methodCall.method)) {
                dataHandle.getUserLocation(result);
            } else if ("sendCurrentLocation".equals(methodCall.method)) {
                dataHandle.sendCurrentLocation(result);
            } else if ("startEmergencyCall".equals(methodCall.method)) {
                dataHandle.startEmergencyCall(result);
            } else if ("stopEmergencyCall".equals(methodCall.method)) {
                dataHandle.stopEmergencyCall(result);
            } else if ("getEmergencyPhoneNumber".equals(methodCall.method)) {
                dataHandle.getEmergencyPhoneNumber(result);
            } else if ("registerPushMessage".equals(methodCall.method)) {
                dataHandle.registerPushMessage(result);
            } else if ("unregisterPushMessage".equals(methodCall.method)) {
                dataHandle.unregisterPushMessage(result);
            } else if ("jumpToLearnMore".equals(methodCall.method)) {
                dataHandle.jumpToLearnMore(result, (String) methodCall.arguments);
            } else if ("getMonitorInfo".equals(methodCall.method)) {
                dataHandle.getMonitorInfo(result);
            } else if ("getRecordInfo".equals(methodCall.method)) {
                dataHandle.getRecordInfo(result);
            } else if ("openOrCloseMonitor".equals(methodCall.method)) {
                dataHandle.openOrCloseMonitor(result, (Map) methodCall.arguments);
            } else if ("setAutoRecordState".equals(methodCall.method)) {
                dataHandle.setAutoRecordState(result, (Map) methodCall.arguments);
            } else if ("openOrCloseRecord".equals(methodCall.method)) {
                dataHandle.openOrCloseRecord(result, (Map) methodCall.arguments);
            } else if ("getRecordStatus".equals(methodCall.method)) {
                dataHandle.getRecordStatus(result);
            } else if ("isnewsafe".equals(methodCall.method)) {
                result.success(Boolean.valueOf(m19931a()));
            }
        }
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f24849a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }
}
