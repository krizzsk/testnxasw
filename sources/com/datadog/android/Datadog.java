package com.datadog.android;

import android.app.Application;
import android.content.Context;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.configuration.Credentials;
import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.lifecycle.ProcessLifecycleCallback;
import com.datadog.android.core.internal.lifecycle.ProcessLifecycleMonitor;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.core.model.UserInfo;
import com.datadog.android.error.internal.CrashReportsFeature;
import com.datadog.android.log.Logger;
import com.datadog.android.log.internal.LogsFeature;
import com.datadog.android.monitoring.internal.InternalLogsFeature;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.monitor.DatadogRumMonitor;
import com.datadog.android.tracing.internal.TracesFeature;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010#H\u0002J\b\u0010$\u001a\u00020!H\u0007J\b\u0010%\u001a\u00020!H\u0002J(\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0007J\u001a\u0010/\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020(H\u0002J\u001a\u00102\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u0001032\u0006\u00101\u001a\u00020(H\u0002J\u001a\u00104\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u0001052\u0006\u00101\u001a\u00020(H\u0002J\u001a\u00106\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u0001072\u0006\u00101\u001a\u00020(H\u0002J\u001a\u00108\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u0001092\u0006\u00101\u001a\u00020(H\u0002J\b\u0010:\u001a\u00020\u0012H\u0007J\u0010\u0010;\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020.H\u0007JD\u0010>\u001a\u00020!2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010#H\u0007J\u0010\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020\u0018H\u0007J\u0010\u0010E\u001a\u00020!2\u0006\u00101\u001a\u00020(H\u0002J\b\u0010F\u001a\u00020!H\u0002J\u0010\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006I"}, mo148868d2 = {"Lcom/datadog/android/Datadog;", "", "()V", "DD_SDK_VERSION_TAG", "", "DD_SOURCE_TAG", "ENV_NAME_VALIDATION_REG_EX", "MESSAGE_ALREADY_INITIALIZED", "MESSAGE_DEPRECATED", "MESSAGE_ENV_NAME_NOT_VALID", "MESSAGE_NOT_INITIALIZED", "SHUTDOWN_THREAD", "WARNING_MESSAGE_APPLICATION_ID_IS_NULL", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialized$dd_sdk_android_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isDebug", "", "isDebug$dd_sdk_android_release", "()Z", "setDebug$dd_sdk_android_release", "(Z)V", "<set-?>", "", "libraryVerbosity", "getLibraryVerbosity$dd_sdk_android_release", "()I", "startupTimeNs", "", "getStartupTimeNs$dd_sdk_android_release", "()J", "applyAdditionalConfiguration", "", "additionalConfiguration", "", "clearAllData", "flushAndShutdownExecutors", "initialize", "context", "Landroid/content/Context;", "credentials", "Lcom/datadog/android/core/configuration/Credentials;", "configuration", "Lcom/datadog/android/core/configuration/Configuration;", "trackingConsent", "Lcom/datadog/android/privacy/TrackingConsent;", "initializeCrashReportFeature", "Lcom/datadog/android/core/configuration/Configuration$Feature$CrashReport;", "appContext", "initializeInternalLogsFeature", "Lcom/datadog/android/core/configuration/Configuration$Feature$InternalLogs;", "initializeLogsFeature", "Lcom/datadog/android/core/configuration/Configuration$Feature$Logs;", "initializeRumFeature", "Lcom/datadog/android/core/configuration/Configuration$Feature$RUM;", "initializeTracingFeature", "Lcom/datadog/android/core/configuration/Configuration$Feature$Tracing;", "isInitialized", "resolveIsDebug", "setTrackingConsent", "consent", "setUserInfo", "id", "name", "email", "extraInfo", "setVerbosity", "level", "setupLifecycleMonitorCallback", "stop", "validateEnvironmentName", "envName", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Datadog.kt */
public final class Datadog {
    public static final String DD_SDK_VERSION_TAG = "_dd.sdk_version";
    public static final String DD_SOURCE_TAG = "_dd.source";
    public static final String ENV_NAME_VALIDATION_REG_EX = "[a-zA-Z0-9_:./-]{0,195}[a-zA-Z0-9_./-]";
    public static final Datadog INSTANCE = new Datadog();
    public static final String MESSAGE_ALREADY_INITIALIZED = "The Datadog library has already been initialized.";
    public static final String MESSAGE_DEPRECATED = "%s has been deprecated. If you need it, submit an issue at https://github.com/DataDog/dd-sdk-android/issues/";
    public static final String MESSAGE_ENV_NAME_NOT_VALID = "The environment name should contain maximum 196 of the following allowed characters [a-zA-Z0-9_:./-] and should never finish with a semicolon.In this case the Datadog SDK will not be initialised.";
    public static final String MESSAGE_NOT_INITIALIZED = "Datadog has not been initialized.\nPlease add the following code in your application's onCreate() method:\nval credentials = Credentials(\"<CLIENT_TOKEN>\", \"<ENVIRONMENT>\", \"<VARIANT>\", \"<APPLICATION_ID>\")\nDatadog.initialize(context, credentials, configuration, trackingConsent);";
    public static final String SHUTDOWN_THREAD = "datadog_shutdown";
    public static final String WARNING_MESSAGE_APPLICATION_ID_IS_NULL = "You're trying to enable RUM but no Application Id was provided. Please pass this value into the Datadog Credentials:\nval credentials = Credentials(\"<CLIENT_TOKEN>\", \"<ENVIRONMENT>\", \"<VARIANT>\", \"<APPLICATION_ID>\")\nDatadog.initialize(context, credentials, configuration, trackingConsent);";

    /* renamed from: a */
    private static final AtomicBoolean f3374a = new AtomicBoolean(false);

    /* renamed from: b */
    private static final long f3375b = System.nanoTime();

    /* renamed from: c */
    private static int f3376c = Integer.MAX_VALUE;

    /* renamed from: d */
    private static boolean f3377d;

    @JvmStatic
    public static final void setUserInfo() {
        setUserInfo$default((String) null, (String) null, (String) null, (Map) null, 15, (Object) null);
    }

    @JvmStatic
    public static final void setUserInfo(String str) {
        setUserInfo$default(str, (String) null, (String) null, (Map) null, 14, (Object) null);
    }

    @JvmStatic
    public static final void setUserInfo(String str, String str2) {
        setUserInfo$default(str, str2, (String) null, (Map) null, 12, (Object) null);
    }

    @JvmStatic
    public static final void setUserInfo(String str, String str2, String str3) {
        setUserInfo$default(str, str2, str3, (Map) null, 8, (Object) null);
    }

    private Datadog() {
    }

    public final AtomicBoolean getInitialized$dd_sdk_android_release() {
        return f3374a;
    }

    public final long getStartupTimeNs$dd_sdk_android_release() {
        return f3375b;
    }

    public final int getLibraryVerbosity$dd_sdk_android_release() {
        return f3376c;
    }

    public final boolean isDebug$dd_sdk_android_release() {
        return f3377d;
    }

    public final void setDebug$dd_sdk_android_release(boolean z) {
        f3377d = z;
    }

    @JvmStatic
    public static final void initialize(Context context, Credentials credentials, Configuration configuration, TrackingConsent trackingConsent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(trackingConsent, "trackingConsent");
        if (f3374a.get()) {
            Logger.w$default(RuntimeUtilsKt.getDevLogger(), MESSAGE_ALREADY_INITIALIZED, (Throwable) null, (Map) null, 6, (Object) null);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        f3377d = INSTANCE.m2284b(context);
        if (INSTANCE.m2282a(credentials.getEnvName())) {
            CoreFeature coreFeature = CoreFeature.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(applicationContext, "appContext");
            coreFeature.initialize(applicationContext, credentials, configuration.getCoreConfig$dd_sdk_android_release(), trackingConsent);
            INSTANCE.m2281a((Map<String, ? extends Object>) configuration.getAdditionalConfig$dd_sdk_android_release());
            INSTANCE.m2278a(configuration.getLogsConfig$dd_sdk_android_release(), applicationContext);
            INSTANCE.m2280a(configuration.getTracesConfig$dd_sdk_android_release(), applicationContext);
            INSTANCE.m2279a(configuration.getRumConfig$dd_sdk_android_release(), applicationContext);
            INSTANCE.m2276a(configuration.getCrashReportConfig$dd_sdk_android_release(), applicationContext);
            INSTANCE.m2277a(configuration.getInternalLogsConfig$dd_sdk_android_release(), applicationContext);
            CoreFeature.INSTANCE.getNdkCrashHandler$dd_sdk_android_release().handleNdkCrash(LogsFeature.INSTANCE.getPersistenceStrategy$dd_sdk_android_release().getWriter(), RumFeature.INSTANCE.getPersistenceStrategy$dd_sdk_android_release().getWriter());
            INSTANCE.m2275a(applicationContext);
            f3374a.set(true);
            Runtime.getRuntime().addShutdownHook(new Thread($$Lambda$Datadog$RDK1eIdNQHL8Y23qXEe1E5Ne8w.INSTANCE, SHUTDOWN_THREAD));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m2285c() {
        INSTANCE.m2274a();
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return f3374a.get();
    }

    @JvmStatic
    public static final void clearAllData() {
        LogsFeature.INSTANCE.clearAllData();
        CrashReportsFeature.INSTANCE.clearAllData();
        RumFeature.INSTANCE.clearAllData();
        TracesFeature.INSTANCE.clearAllData();
        InternalLogsFeature.INSTANCE.clearAllData();
    }

    /* renamed from: a */
    private final void m2274a() {
        if (f3374a.get()) {
            LogsFeature.INSTANCE.stop();
            TracesFeature.INSTANCE.stop();
            RumFeature.INSTANCE.stop();
            CrashReportsFeature.INSTANCE.stop();
            CoreFeature.INSTANCE.stop();
            InternalLogsFeature.INSTANCE.stop();
            f3377d = false;
            f3374a.set(false);
        }
    }

    /* renamed from: b */
    private final void m2283b() {
        if (f3374a.get()) {
            RumMonitor rumMonitor = GlobalRum.get();
            DatadogRumMonitor datadogRumMonitor = rumMonitor instanceof DatadogRumMonitor ? (DatadogRumMonitor) rumMonitor : null;
            if (datadogRumMonitor != null) {
                datadogRumMonitor.stopKeepAliveCallback$dd_sdk_android_release();
                datadogRumMonitor.drainExecutorService$dd_sdk_android_release();
            }
            CoreFeature.INSTANCE.drainAndShutdownExecutors();
            LogsFeature.INSTANCE.flushStoredData();
            TracesFeature.INSTANCE.flushStoredData();
            RumFeature.INSTANCE.flushStoredData();
            CrashReportsFeature.INSTANCE.flushStoredData();
        }
    }

    @JvmStatic
    public static final void setVerbosity(int i) {
        f3376c = i;
    }

    @JvmStatic
    public static final void setTrackingConsent(TrackingConsent trackingConsent) {
        Intrinsics.checkNotNullParameter(trackingConsent, "consent");
        CoreFeature.INSTANCE.getTrackingConsentProvider$dd_sdk_android_release().setConsent(trackingConsent);
    }

    public static /* synthetic */ void setUserInfo$default(String str, String str2, String str3, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            map = MapsKt.emptyMap();
        }
        setUserInfo(str, str2, str3, map);
    }

    @JvmStatic
    public static final void setUserInfo(String str, String str2, String str3, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "extraInfo");
        CoreFeature.INSTANCE.getUserInfoProvider$dd_sdk_android_release().setUserInfo(new UserInfo(str, str2, str3, map));
    }

    /* renamed from: a */
    private final void m2278a(Configuration.Feature.Logs logs, Context context) {
        if (logs != null) {
            LogsFeature.INSTANCE.initialize(context, logs);
        }
    }

    /* renamed from: a */
    private final void m2276a(Configuration.Feature.CrashReport crashReport, Context context) {
        if (crashReport != null) {
            CrashReportsFeature.INSTANCE.initialize(context, crashReport);
        }
    }

    /* renamed from: a */
    private final void m2280a(Configuration.Feature.Tracing tracing, Context context) {
        if (tracing != null) {
            TracesFeature.INSTANCE.initialize(context, tracing);
        }
    }

    /* renamed from: a */
    private final void m2279a(Configuration.Feature.RUM rum, Context context) {
        if (rum != null) {
            CharSequence rumApplicationId$dd_sdk_android_release = CoreFeature.INSTANCE.getRumApplicationId$dd_sdk_android_release();
            if (rumApplicationId$dd_sdk_android_release == null || StringsKt.isBlank(rumApplicationId$dd_sdk_android_release)) {
                Logger.w$default(RuntimeUtilsKt.getDevLogger(), WARNING_MESSAGE_APPLICATION_ID_IS_NULL, (Throwable) null, (Map) null, 6, (Object) null);
            }
            RumFeature.INSTANCE.initialize(context, rum);
        }
    }

    /* renamed from: a */
    private final void m2277a(Configuration.Feature.InternalLogs internalLogs, Context context) {
        if (internalLogs != null) {
            InternalLogsFeature.INSTANCE.initialize(context, internalLogs);
        }
    }

    /* renamed from: a */
    private final void m2281a(Map<String, ? extends Object> map) {
        Object obj = map.get(DD_SOURCE_TAG);
        if (obj != null && (obj instanceof String) && (!StringsKt.isBlank((CharSequence) obj))) {
            CoreFeature.INSTANCE.setSourceName$dd_sdk_android_release((String) obj);
        }
        Object obj2 = map.get(DD_SDK_VERSION_TAG);
        if (obj2 != null && (obj2 instanceof String) && (!StringsKt.isBlank((CharSequence) obj2))) {
            CoreFeature.INSTANCE.setSdkVersion$dd_sdk_android_release((String) obj2);
        }
    }

    /* renamed from: a */
    private final boolean m2282a(String str) {
        if (new Regex(ENV_NAME_VALIDATION_REG_EX).matches(str)) {
            return true;
        }
        if (!f3377d) {
            Logger.e$default(RuntimeUtilsKt.getDevLogger(), MESSAGE_ENV_NAME_NOT_VALID, (Throwable) null, (Map) null, 6, (Object) null);
            return false;
        }
        throw new IllegalArgumentException(MESSAGE_ENV_NAME_NOT_VALID);
    }

    /* renamed from: a */
    private final void m2275a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(new ProcessLifecycleMonitor(new ProcessLifecycleCallback(CoreFeature.INSTANCE.getNetworkInfoProvider$dd_sdk_android_release(), context)));
        }
    }

    /* renamed from: b */
    private final boolean m2284b(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }
}
