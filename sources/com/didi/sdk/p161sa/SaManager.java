package com.didi.sdk.p161sa;

import android.app.Application;
import android.content.SharedPreferences;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.util.SaApolloUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0006\u0010\u0014\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \b*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/sdk/sa/SaManager;", "", "()V", "KEY_TYPE", "", "apiName", "context", "Landroid/app/Application;", "kotlin.jvm.PlatformType", "fileName", "isLoaded", "", "saOneState", "saOneType", "", "sp", "Landroid/content/SharedPreferences;", "initSa", "", "initSaOne", "request", "requestReal", "TheOneSDKGlobal_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.sdk.sa.SaManager */
/* compiled from: SaManager.kt */
public final class SaManager {
    public static final SaManager INSTANCE = new SaManager();

    /* renamed from: a */
    private static Application f39851a;

    /* renamed from: b */
    private static String f39852b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static String f39853c = "sa_type";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final SharedPreferences f39854d;

    /* renamed from: e */
    private static final String f39855e = "expo/cardStyle";

    /* renamed from: f */
    private static boolean f39856f;

    /* renamed from: g */
    private static boolean f39857g;

    /* renamed from: h */
    private static int f39858h = -1;

    private SaManager() {
    }

    static {
        Application appContext = DIDIApplication.getAppContext();
        f39851a = appContext;
        String stringPlus = Intrinsics.stringPlus(appContext.getPackageName(), "_sa_apollo");
        f39852b = stringPlus;
        f39854d = SystemUtils.getSharedPreferences(f39851a, stringPlus, 0);
    }

    /* renamed from: a */
    private final void m29996a() {
        if (!f39856f) {
            boolean z = true;
            f39856f = true;
            IToggle toggle = Apollo.getToggle("sa_phaseone");
            if (toggle.allow()) {
                IExperiment experiment = toggle.getExperiment();
                int intParam = experiment == null ? 0 : experiment.getIntParam("version", 0);
                f39858h = intParam;
                if (intParam == 0) {
                    z = false;
                }
                f39857g = z;
                SaApolloUtil.INSTANCE.setSaOneType(f39858h);
                return;
            }
            SaApolloUtil.INSTANCE.setSaOneType(-1);
        }
    }

    public final void initSa() {
        m29996a();
        int i = f39854d.getInt(f39853c, SaApolloUtil.SaType.SA_NONE_CONTROL.getType());
        SaApolloUtil.INSTANCE.setSaOneState(f39857g);
        SaApolloUtil.INSTANCE.setSaType(i);
    }

    public final void request() {
        if (DIDILocationManager.getInstance(f39851a).getLastKnownLocation() == null) {
            LocationPerformer.getInstance().addLocationListener(new SaManager$request$1());
        } else {
            m29997b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m29997b() {
        Bff.call(new IBffProxy.Ability.Builder(f39851a, f39855e).setBffCallBack(new SaManager$requestReal$ability$1()).build());
    }
}
