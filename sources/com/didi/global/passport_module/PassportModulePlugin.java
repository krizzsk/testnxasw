package com.didi.global.passport_module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.flutter.nacho.Nacho;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.thirdpartylogin.base.ThirdPartyLoginManager;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.base.service.IPassportService;
import com.didi.unifylogin.base.service.PassportServiceListener;
import com.didi.unifylogin.base.service.model.DataJsonWrapper;
import com.didi.unifylogin.country.CountryListActivity;
import com.didi.unifylogin.flutter.PassportModulePluginHandler;
import com.didi.unifylogin.flutter.Result;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.third.ThirdPartyLoginHandler;
import com.didi.unifylogin.utils.SmsUtils;
import com.didi.unifylogin.utils.autologin.SmsReceiver;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p218io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;
import p218io.flutter.plugin.common.PluginRegistry;

public class PassportModulePlugin implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler {
    public static final String CHANNEL_NAME = "com.didi.global.passport_module.PassportModulePlugin";

    /* renamed from: c */
    private static final int f24807c = 1024;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MethodChannel f24808a;

    /* renamed from: b */
    private WeakReference<Activity> f24809b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MethodChannel.Result f24810d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Logger f24811e = LoggerFactory.getLogger("PassportModulePlugin");

    /* renamed from: f */
    private SmsUtils f24812f;

    public void onDetachedFromActivityForConfigChanges() {
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), CHANNEL_NAME);
        this.f24808a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        Logger logger = this.f24811e;
        int i = 0;
        logger.debug("onMethodCall:" + methodCall.method, new Object[0]);
        Logger logger2 = this.f24811e;
        logger2.debug("arguments:" + methodCall.arguments, new Object[0]);
        Activity activity = (Activity) this.f24809b.get();
        if (activity == null) {
            activity = Nacho.getInstance().getTopActivity();
        }
        if (methodCall.method.equals("selectCountryCode")) {
            if (activity != null) {
                Intent intent = new Intent(activity, CountryListActivity.class);
                intent.putExtra(CountryListActivity.SEND_RESULT_2_CALLER, true);
                activity.startActivityForResult(intent, 1024);
                this.f24810d = result;
                return;
            }
            m19887a(result, (Object) "");
        } else if (methodCall.method.equals("verifySms")) {
            IPassportService iPassportService = (IPassportService) ServiceLoader.load(IPassportService.class).get();
            if (iPassportService == null) {
                m19887a(result, (Object) "");
            } else {
                iPassportService.onVerifyCodeReceived((String) methodCall.argument("sms"), new PassportServiceListener<BaseResponse>() {
                    public void onSuccess(BaseResponse baseResponse) {
                        PassportModulePlugin.this.m19887a(result, (Object) Result.from(baseResponse));
                    }

                    public void onFail() {
                        PassportModulePlugin.this.m19887a(result, (Object) "");
                    }
                });
            }
        } else if (methodCall.method.equals("getSplashResInfo")) {
            IPassportService iPassportService2 = (IPassportService) ServiceLoader.load(IPassportService.class).get();
            if (iPassportService2 == null) {
                m19887a(result, (Object) "");
            } else {
                iPassportService2.getHeadActivityRes(new PassportServiceListener<DataJsonWrapper>() {
                    public void onSuccess(DataJsonWrapper dataJsonWrapper) {
                        PassportModulePlugin.this.m19887a(result, (Object) dataJsonWrapper.json);
                    }

                    public void onFail() {
                        PassportModulePlugin.this.m19887a(result, (Object) "");
                    }
                });
            }
        } else if (methodCall.method.equals("getAutoFillInformation")) {
            this.f24810d = result;
            LoginListeners.InfoAutoFillListener infoAutoFillListener = ListenerManager.getInfoAutoFillListener();
            if (infoAutoFillListener != null) {
                infoAutoFillListener.onEntryPage(activity);
            } else {
                m19886a(result);
            }
        } else if (methodCall.method.equals("thirdPartyLogin")) {
            String str = (String) methodCall.argument("channel");
            try {
                List<AbsThirdPartyLoginBase> thirdPartyLogins = ThirdPartyLoginManager.getThirdPartyLogins();
                if (thirdPartyLogins == null) {
                    m19887a(result, (Object) Result.error("Not supported"));
                    return;
                }
                AbsThirdPartyLoginBase absThirdPartyLoginBase = null;
                while (true) {
                    if (i >= thirdPartyLogins.size()) {
                        break;
                    }
                    AbsThirdPartyLoginBase absThirdPartyLoginBase2 = thirdPartyLogins.get(i);
                    if (absThirdPartyLoginBase2.getChannel().equals(str) && absThirdPartyLoginBase2.isSupport()) {
                        absThirdPartyLoginBase = absThirdPartyLoginBase2;
                        break;
                    }
                    i++;
                }
                if (absThirdPartyLoginBase != null) {
                    absThirdPartyLoginBase.startLogin(activity, new ThirdPartyLoginHandler(activity, str, result));
                } else {
                    m19887a(result, (Object) Result.error());
                }
            } catch (Exception e) {
                this.f24811e.error("thirdPartyLogin error", (Throwable) e);
                m19887a(result, (Object) Result.error(e.getMessage()));
            }
        } else if (methodCall.method.equals("registeSmsRetriever")) {
            try {
                SmsUtils smsUtils = new SmsUtils();
                this.f24812f = smsUtils;
                smsUtils.registeSmsRetriever(activity, new SmsReceiver.SmsReceiverListener() {
                    public void handleSmsCode(String str) {
                        Logger a = PassportModulePlugin.this.f24811e;
                        a.error("SmsRetriever sms code back" + str, new Object[0]);
                        PassportModulePlugin.this.f24808a.invokeMethod("setSmsCode", str);
                    }
                });
            } catch (Exception e2) {
                this.f24811e.error("registeSmsRetriever error", (Throwable) e2);
            }
        } else if (new PassportModulePluginHandler(activity).onMethodCall(methodCall, result)) {
            this.f24811e.debug("process by PassportModulePluginHandler", new Object[0]);
        } else {
            result.notImplemented();
        }
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f24808a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.f24809b = new WeakReference<>(activityPluginBinding.getActivity());
        activityPluginBinding.addActivityResultListener(new PluginRegistry.ActivityResultListener() {
            public boolean onActivityResult(int i, int i2, Intent intent) {
                if (i == 1024 && PassportModulePlugin.this.f24810d != null) {
                    if (i2 == -1) {
                        try {
                            PassportModulePlugin.this.m19887a(PassportModulePlugin.this.f24810d, (Object) ((CountryListResponse.CountryRule) intent.getSerializableExtra("country")).toJSON());
                        } catch (JSONException e) {
                            e.printStackTrace();
                            PassportModulePlugin passportModulePlugin = PassportModulePlugin.this;
                            passportModulePlugin.m19887a(passportModulePlugin.f24810d, (Object) "");
                        }
                    } else {
                        PassportModulePlugin passportModulePlugin2 = PassportModulePlugin.this;
                        passportModulePlugin2.m19887a(passportModulePlugin2.f24810d, (Object) "");
                    }
                    return true;
                } else if (i == 2000 && PassportModulePlugin.this.f24810d != null) {
                    LoginListeners.InfoAutoFillListener infoAutoFillListener = ListenerManager.getInfoAutoFillListener();
                    if (infoAutoFillListener != null) {
                        String onGetResult = infoAutoFillListener.onGetResult(i, i2, intent);
                        if (TextUtils.isEmpty(onGetResult)) {
                            PassportModulePlugin passportModulePlugin3 = PassportModulePlugin.this;
                            passportModulePlugin3.m19886a(passportModulePlugin3.f24810d);
                        } else {
                            PassportModulePlugin passportModulePlugin4 = PassportModulePlugin.this;
                            passportModulePlugin4.m19887a(passportModulePlugin4.f24810d, (Object) onGetResult);
                        }
                    } else {
                        PassportModulePlugin passportModulePlugin5 = PassportModulePlugin.this;
                        passportModulePlugin5.m19886a(passportModulePlugin5.f24810d);
                    }
                    return true;
                } else if (ThirdPartyLoginManager.getThirdPartyLogins() == null) {
                    return false;
                } else {
                    for (AbsThirdPartyLoginBase handleLoginResult : ThirdPartyLoginManager.getThirdPartyLogins()) {
                        handleLoginResult.handleLoginResult(i, i2, intent);
                    }
                    return false;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19887a(MethodChannel.Result result, Object obj) {
        try {
            result.success(obj);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19886a(MethodChannel.Result result) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errno", -1);
            jSONObject.put("error", "");
            m19887a(result, (Object) jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            m19887a(result, (Object) new HashMap());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onDetachedFromActivity() {
        this.f24810d = null;
        SmsUtils smsUtils = this.f24812f;
        if (smsUtils != null) {
            smsUtils.unRegisteSmsRetriever((Context) this.f24809b.get());
            this.f24812f = null;
        }
        this.f24809b.clear();
    }
}
