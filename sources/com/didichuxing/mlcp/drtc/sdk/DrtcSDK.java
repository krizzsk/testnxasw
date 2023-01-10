package com.didichuxing.mlcp.drtc.sdk;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcEnvType;
import com.didichuxing.mlcp.drtc.enums.DrtcSvcStatus;
import com.didichuxing.mlcp.drtc.interfaces.CallingService;
import com.didichuxing.mlcp.drtc.interfaces.DrtcSDKInitializeListener;
import com.didichuxing.mlcp.drtc.interfaces.InCallingService;
import com.didichuxing.mlcp.drtc.models.LogModel;
import com.didichuxing.mlcp.drtc.utils.DrtcAudioManager;
import com.didichuxing.mlcp.drtc.utils.MetricReporter;
import java.lang.ref.WeakReference;
import org.apache.commons.lang3.StringUtils;

public class DrtcSDK {

    /* renamed from: c */
    private static boolean f50955c = false;

    /* renamed from: d */
    private static DrtcSDK f50956d;

    /* renamed from: a */
    DrtcPluginHandle f50957a;

    /* renamed from: b */
    DrtcAudioManager f50958b;

    /* renamed from: e */
    private WeakReference<Context> f50959e;

    /* renamed from: f */
    private DrtcSDKInitializeListener f50960f;

    /* renamed from: g */
    private CallingService f50961g = null;

    /* renamed from: h */
    private InCallingService f50962h = null;

    /* renamed from: i */
    private final Boolean f50963i = true;

    /* renamed from: j */
    private String f50964j = null;

    private DrtcSDK() {
        f50955c = false;
    }

    public static Boolean IsSDKOnUsing() {
        boolean z = false;
        if (f50956d == null) {
            return false;
        }
        if (C16709a.m38059a() != DrtcSvcStatus.idle) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static synchronized DrtcSDK getInstance() {
        DrtcSDK drtcSDK;
        synchronized (DrtcSDK.class) {
            if (f50956d == null) {
                f50956d = new DrtcSDK();
            }
            drtcSDK = f50956d;
        }
        return drtcSDK;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Context mo125540a() {
        return (Context) this.f50959e.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo125543b() {
        return this.f50964j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo125544c() {
        this.f50964j = "";
    }

    public CallingService getCallingService() {
        if (!f50955c) {
            mo125541a("[W] Try to get calling svc,but sdk did't initialized");
            return null;
        }
        if (this.f50961g == null) {
            this.f50961g = new C16709a(this);
        }
        return this.f50961g;
    }

    public InCallingService getInCallingService() {
        if (!f50955c) {
            mo125541a("[W] Try to get In-calling svc,but sdk did't initialized");
            return null;
        }
        if (this.f50962h == null) {
            this.f50962h = new DrtcInCallingServiceImpl(this);
        }
        return this.f50962h;
    }

    public void initializeSDK(Context context, DrtcSDKInitializeListener drtcSDKInitializeListener, DrtcEnvType drtcEnvType) {
        m38051a(context, drtcSDKInitializeListener, drtcEnvType, (String) null);
    }

    public boolean isInitialized() {
        return f50955c;
    }

    public void releaseSDK() {
        if (f50955c) {
            mo125541a("[I] SDK on releasing...");
            f50955c = false;
            this.f50958b.mo125561a();
            this.f50958b = null;
            this.f50957a = null;
            this.f50960f = null;
            this.f50961g = null;
            this.f50962h = null;
            f50956d = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo125542a(int i) {
        this.f50964j = String.valueOf(i);
        return SDKConsts.getSysConfig().mo125508a(i);
    }

    public void initializeSDK(Context context, DrtcSDKInitializeListener drtcSDKInitializeListener, String str) {
        if (!StringUtils.isEmpty(str)) {
            m38051a(context, drtcSDKInitializeListener, DrtcEnvType.ENV_CUSTOM, str);
            return;
        }
        throw new NullPointerException("Domain uri can't be null");
    }

    /* renamed from: a */
    private void m38051a(Context context, DrtcSDKInitializeListener drtcSDKInitializeListener, DrtcEnvType drtcEnvType, String str) {
        if (context == null) {
            throw new NullPointerException("Application Ctx can't be null");
        } else if (drtcSDKInitializeListener == null) {
            throw new NullPointerException("Init listener can't be null");
        } else if (drtcEnvType != DrtcEnvType.ENV_CUSTOM || !StringUtils.isEmpty(str)) {
            MetricReporter.getInstance().Clear();
            this.f50964j = null;
            if (!f50955c) {
                if (drtcEnvType == DrtcEnvType.ENV_CUSTOM) {
                    SDKConsts.Set_Sys_Config_Custom(str);
                } else {
                    SDKConsts.Set_Sys_Config(drtcEnvType);
                }
                WeakReference<Context> weakReference = new WeakReference<>(context);
                this.f50959e = weakReference;
                this.f50960f = drtcSDKInitializeListener;
                DrtcAudioManager a = DrtcAudioManager.m38156a((Context) weakReference.get());
                this.f50958b = a;
                a.mo125562a((DrtcAudioManager.C16714a) null);
                mo125541a("[I] SDK Initialize Beginning");
            } else {
                mo125541a("[W] SDK Initialized Twice");
            }
            f50955c = true;
            drtcSDKInitializeListener.onSDKInitializeResult(0);
        } else {
            throw new NullPointerException("Domain Uri can't be null while custom env");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo125541a(String str) {
        if (this.f50960f != null && !StringUtils.isEmpty(str)) {
            this.f50960f.onSDKLogMessage(str);
            if (this.f50963i.booleanValue()) {
                SystemUtils.log(3, "DRTCLOG", "SDK invoke system report", (Throwable) null, "com.didichuxing.mlcp.drtc.sdk.DrtcSDK", 58);
                MetricReporter.getInstance().systemLogReporter(LogModel.m37980d(this.f50964j).mo125486a(str));
            }
        }
    }
}
