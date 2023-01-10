package com.jumio.core;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.C20921a;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.enums.Rotation;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.commons.utils.C20932a;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.core.api.BackendManager;
import com.jumio.core.api.calls.C20947a;
import com.jumio.core.api.calls.C20948b;
import com.jumio.core.api.calls.C20949c;
import com.jumio.core.data.ScanMode;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.environment.Environment;
import com.jumio.core.error.Error;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.core.models.CountryDocumentModel;
import com.jumio.core.models.FaceScanPartModel;
import com.jumio.core.models.IproovTokenModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.core.persistence.C20987a;
import com.jumio.core.persistence.DataManager;
import com.jumio.core.plugins.AnalyticsPlugin;
import com.jumio.core.plugins.C20991a;
import com.jumio.core.plugins.ScanPartPlugin;
import com.jumio.core.util.ReflectionUtil;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.error.JumioError;
import com.jumio.sdk.exceptions.SDKNotConfiguredException;
import com.jumio.sdk.interfaces.JumioControllerInterface;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.result.JumioCredentialResult;
import com.jumio.sdk.result.JumioFaceResult;
import com.jumio.sdk.result.JumioIDResult;
import com.jumio.sdk.result.JumioImageData;
import com.jumio.sdk.result.JumioResult;
import com.jumio.sdk.scanpart.JumioScanPart;
import java.io.File;
import java.io.Serializable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jumio.core.C19464b;
import jumio.core.C19470d0;
import jumio.core.C19482i0;
import jumio.core.C19484j0;
import jumio.core.C19489l;
import jumio.core.C19497p;
import jumio.core.C19501r;
import jumio.core.C19507t0;
import jumio.core.C19508u;
import jumio.core.C19511w;
import jumio.core.C19512x;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B+\b\u0010\u0012\u0006\u0010=\u001a\u00020y\u0012\u0006\u0010-\u001a\u00020&\u0012\u0006\u00105\u001a\u00020.\u0012\b\b\u0002\u0010{\u001a\u00020z¢\u0006\u0004\b|\u0010}B/\b\u0010\u0012\u0006\u0010=\u001a\u00020y\u0012\u0006\u0010~\u001a\u00020\u0003\u0012\u0006\u00105\u001a\u00020.\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010¢\u0006\u0005\b|\u0010\u0001J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u001b\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00182\f\b\u0002\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0007J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u001e\u0010%\u001a\u00020\u00052\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u001e\u0010\u001b\u001a\u00020\u00052\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030!2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0018H\u0016R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010=\u001a\u0002068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0019\u0010C\u001a\u00020>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0019\u0010I\u001a\u00020D8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0019\u0010O\u001a\u00020J8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0019\u0010U\u001a\u00020P8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR$\u0010[\u001a\u0004\u0018\u00010\u00128\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010\u0016R\"\u0010b\u001a\u00020\u00078\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010f\u001a\u00020\u00078\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bc\u0010]\u001a\u0004\bd\u0010_\"\u0004\be\u0010aR$\u0010m\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0019\u0010o\u001a\u00020n8\u0006@\u0006¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR(\u0010w\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030t0\u00190s8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0013\u0010x\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\bx\u0010_¨\u0006\u0001"}, mo148868d2 = {"Lcom/jumio/core/Controller;", "Ljumio/core/x$b;", "Lcom/jumio/core/network/ApiBinding;", "Landroid/os/Bundle;", "bundle", "", "saveState", "", "stop", "persistAllData", "Lcom/jumio/sdk/error/JumioError;", "error", "retry", "cancel", "finish", "userConsented", "Lcom/jumio/sdk/credentials/JumioCredentialInfo;", "credentialInfo", "Lcom/jumio/sdk/credentials/JumioCredential;", "startCredential", "credential", "finishCredential$jumio_core_release", "(Lcom/jumio/sdk/credentials/JumioCredential;)V", "finishCredential", "", "Ljava/lang/Class;", "sourceClass", "onError", "canceled", "reporting", "Landroid/location/Address;", "address", "onAddressAvailable", "Lcom/jumio/core/models/ApiCallDataModel;", "apiCallDataModel", "", "result", "onResult", "Lcom/jumio/core/models/AuthorizationModel;", "a", "Lcom/jumio/core/models/AuthorizationModel;", "getAuthorizationModel", "()Lcom/jumio/core/models/AuthorizationModel;", "setAuthorizationModel", "(Lcom/jumio/core/models/AuthorizationModel;)V", "authorizationModel", "Lcom/jumio/sdk/interfaces/JumioControllerInterface;", "b", "Lcom/jumio/sdk/interfaces/JumioControllerInterface;", "getControllerInterface", "()Lcom/jumio/sdk/interfaces/JumioControllerInterface;", "setControllerInterface", "(Lcom/jumio/sdk/interfaces/JumioControllerInterface;)V", "controllerInterface", "Lcom/jumio/core/MobileContext;", "c", "Lcom/jumio/core/MobileContext;", "getContext", "()Lcom/jumio/core/MobileContext;", "setContext", "(Lcom/jumio/core/MobileContext;)V", "context", "Lcom/jumio/commons/utils/DeviceRotationManager;", "e", "Lcom/jumio/commons/utils/DeviceRotationManager;", "getRotationManager", "()Lcom/jumio/commons/utils/DeviceRotationManager;", "rotationManager", "Lcom/jumio/core/persistence/DataManager;", "f", "Lcom/jumio/core/persistence/DataManager;", "getDataManager", "()Lcom/jumio/core/persistence/DataManager;", "dataManager", "Lcom/jumio/core/api/BackendManager;", "g", "Lcom/jumio/core/api/BackendManager;", "getBackendManager", "()Lcom/jumio/core/api/BackendManager;", "backendManager", "Lcom/jumio/analytics/Analytics;", "i", "Lcom/jumio/analytics/Analytics;", "getAnalytics", "()Lcom/jumio/analytics/Analytics;", "analytics", "j", "Lcom/jumio/sdk/credentials/JumioCredential;", "getActiveCredential$jumio_core_release", "()Lcom/jumio/sdk/credentials/JumioCredential;", "setActiveCredential$jumio_core_release", "activeCredential", "k", "Z", "isActive$jumio_core_release", "()Z", "setActive$jumio_core_release", "(Z)V", "isActive", "l", "isConsented$jumio_core_release", "setConsented$jumio_core_release", "isConsented", "m", "Lcom/jumio/sdk/error/JumioError;", "getLastError$jumio_core_release", "()Lcom/jumio/sdk/error/JumioError;", "setLastError$jumio_core_release", "(Lcom/jumio/sdk/error/JumioError;)V", "lastError", "Ljumio/core/d0;", "pluginManager", "Ljumio/core/d0;", "getPluginManager", "()Ljumio/core/d0;", "", "Lcom/jumio/core/network/ApiCall;", "getBindingClasses", "()[Ljava/lang/Class;", "bindingClasses", "isComplete", "Landroid/content/Context;", "", "customThemeId", "<init>", "(Landroid/content/Context;Lcom/jumio/core/models/AuthorizationModel;Lcom/jumio/sdk/interfaces/JumioControllerInterface;I)V", "data", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "scanPartInterface", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/jumio/sdk/interfaces/JumioControllerInterface;Lcom/jumio/sdk/interfaces/JumioScanPartInterface;)V", "Companion", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: Controller.kt */
public final class Controller implements ApiBinding, C19512x.C19514b {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String STORAGE = "tmp_store";

    /* renamed from: a */
    public AuthorizationModel f57435a;

    /* renamed from: b */
    public JumioControllerInterface f57436b;

    /* renamed from: c */
    public MobileContext f57437c;

    /* renamed from: d */
    public C19512x f57438d;

    /* renamed from: e */
    public final DeviceRotationManager f57439e;

    /* renamed from: f */
    public final DataManager f57440f;

    /* renamed from: g */
    public final BackendManager f57441g;

    /* renamed from: h */
    public final C19470d0 f57442h;

    /* renamed from: i */
    public final Analytics f57443i;

    /* renamed from: j */
    public JumioCredential f57444j;

    /* renamed from: k */
    public boolean f57445k;

    /* renamed from: l */
    public boolean f57446l;

    /* renamed from: m */
    public JumioError f57447m;

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, mo148868d2 = {"Lcom/jumio/core/Controller$Companion;", "", "", "STORAGE", "Ljava/lang/String;", "<init>", "()V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: Controller.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: com.jumio.core.Controller$a */
    /* compiled from: Controller.kt */
    public /* synthetic */ class C20934a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f57448a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f57449b;

        static {
            int[] iArr = new int[JumioCredentialCategory.values().length];
            iArr[JumioCredentialCategory.ID.ordinal()] = 1;
            iArr[JumioCredentialCategory.FACE.ordinal()] = 2;
            iArr[JumioCredentialCategory.DOCUMENT.ordinal()] = 3;
            f57448a = iArr;
            int[] iArr2 = new int[ScanMode.values().length];
            iArr2[ScanMode.FACE_IPROOV.ordinal()] = 1;
            iArr2[ScanMode.FACE_MANUAL.ordinal()] = 2;
            f57449b = iArr2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Controller(Context context, AuthorizationModel authorizationModel, JumioControllerInterface jumioControllerInterface, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, authorizationModel, jumioControllerInterface, (i2 & 8) != 0 ? 0 : i);
    }

    public static /* synthetic */ void onError$default(Controller controller, Throwable th, Class<Object> cls, int i, Object obj) {
        if ((i & 2) != 0) {
            cls = Object.class;
        }
        controller.onError(th, (Class<?>) cls);
    }

    /* renamed from: a */
    public final void mo171873a(JumioCredential jumioCredential, JumioScanPartInterface jumioScanPartInterface) {
        JumioScanSide a = jumioCredential.getData$jumio_core_release().mo148665a();
        if (a != null) {
            mo171872a(jumioCredential, a, jumioScanPartInterface);
        }
    }

    /* renamed from: b */
    public final void mo171882b(boolean z) {
        Thread.setDefaultUncaughtExceptionHandler(new C19508u(Thread.getDefaultUncaughtExceptionHandler()));
        this.f57438d.mo148755a(true, true);
        if (!z) {
            ((C19484j0) this.f57440f.get(C19484j0.class)).mo148645a(System.currentTimeMillis());
            C19501r.m41214a((Context) this.f57437c, System.currentTimeMillis());
            C19501r.m41216a(this.f57437c, "Jumio03", 0);
            SettingsModel settingsModel = (SettingsModel) this.f57440f.get(SettingsModel.class);
            if (settingsModel.isLoaded()) {
                mo171871a(settingsModel);
            } else {
                this.f57441g.settings();
            }
        }
    }

    public final void cancel() throws SDKNotConfiguredException, IllegalArgumentException {
        JumioCredential jumioCredential = this.f57444j;
        if (jumioCredential != null) {
            jumioCredential.cancel();
        }
        C19511w wVar = (C19511w) this.f57440f.get(C19511w.class);
        String b = wVar.mo148753b();
        String a = wVar.mo148751a();
        JumioError jumioError = this.f57447m;
        if (jumioError == null) {
            jumioError = new Error(ErrorCase.CANCEL_TYPE_USER, 0, 0, 6, (DefaultConstructorMarker) null).getJumioError(this.f57437c);
        }
        JumioResult jumioResult = new JumioResult(b, a, false, (ArrayList) null, (HashMap) null, jumioError, 24, (DefaultConstructorMarker) null);
        JumioControllerInterface jumioControllerInterface = this.f57436b;
        if (jumioControllerInterface != null) {
            jumioControllerInterface.onFinished(jumioResult);
        }
        this.f57441g.cancelCall(true);
        reporting(true);
        mo171879a(true);
        mo171870a();
    }

    public final void finish() throws IllegalArgumentException {
        if (isComplete()) {
            reporting(false);
            this.f57441g.finalizeCall();
            return;
        }
        throw new IllegalArgumentException("Workflow is not completed".toString());
    }

    public final synchronized void finishCredential$jumio_core_release(JumioCredential jumioCredential) {
        Intrinsics.checkNotNullParameter(jumioCredential, "credential");
        if (jumioCredential == this.f57444j) {
            this.f57444j = null;
        }
    }

    public final JumioCredential getActiveCredential$jumio_core_release() {
        return this.f57444j;
    }

    public final Analytics getAnalytics() {
        return this.f57443i;
    }

    public final AuthorizationModel getAuthorizationModel() {
        return this.f57435a;
    }

    public final BackendManager getBackendManager() {
        return this.f57441g;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[] getBindingClasses() {
        /*
            r3 = this;
            r0 = 4
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<com.jumio.core.api.calls.a> r2 = com.jumio.core.api.calls.C20947a.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<com.jumio.core.api.calls.b> r2 = com.jumio.core.api.calls.C20948b.class
            r0[r1] = r2
            r1 = 2
            java.lang.Class<jumio.core.i0> r2 = jumio.core.C19482i0.class
            r0[r1] = r2
            r1 = 3
            java.lang.Class<com.jumio.core.api.calls.c> r2 = com.jumio.core.api.calls.C20949c.class
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.Controller.getBindingClasses():java.lang.Class[]");
    }

    public final MobileContext getContext() {
        return this.f57437c;
    }

    public final JumioControllerInterface getControllerInterface() {
        return this.f57436b;
    }

    public final DataManager getDataManager() {
        return this.f57440f;
    }

    public final JumioError getLastError$jumio_core_release() {
        return this.f57447m;
    }

    public final C19470d0 getPluginManager() {
        return this.f57442h;
    }

    public final DeviceRotationManager getRotationManager() {
        return this.f57439e;
    }

    public final boolean isActive$jumio_core_release() {
        return this.f57445k;
    }

    public final boolean isComplete() {
        C19497p pVar = (C19497p) this.f57440f.get(C19497p.class);
        return (pVar.mo148714d().isEmpty() ^ true) && pVar.mo148713c();
    }

    public final boolean isConsented$jumio_core_release() {
        return this.f57446l;
    }

    public void onAddressAvailable(Address address) {
        if (address != null) {
            ((C19464b) this.f57440f.get(C19464b.class)).mo148601a(address);
        }
    }

    public final void onError(Throwable th, Class<?> cls) {
        JumioControllerInterface controllerInterface;
        Intrinsics.checkNotNullParameter(cls, "sourceClass");
        Error errorFromThrowable = this.f57441g.errorFromThrowable(th, cls);
        Analytics.Companion.add(MobileEvents.lifecycle(C20921a.ERROR, errorFromThrowable));
        JumioError jumioError = errorFromThrowable.getJumioError(this.f57437c);
        this.f57447m = jumioError;
        if (jumioError != null && (controllerInterface = getControllerInterface()) != null) {
            controllerInterface.onError(jumioError);
        }
    }

    public void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        Class<?> call = apiCallDataModel.getCall();
        if (Intrinsics.areEqual((Object) call, (Object) C20949c.class)) {
            mo171881b(obj);
        } else if (!Intrinsics.areEqual((Object) call, (Object) C19482i0.class)) {
            if (Intrinsics.areEqual((Object) call, (Object) C20948b.class)) {
                mo171875a(obj);
            } else if (!Intrinsics.areEqual((Object) call, (Object) C20947a.class)) {
            } else {
                if (obj != null) {
                    mo171877a((HashMap<String, JumioCredentialResult>) (HashMap) obj);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, com.jumio.sdk.result.JumioCredentialResult>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, com.jumio.sdk.result.JumioCredentialResult> }");
            }
        }
    }

    public final void persistAllData(boolean z) {
        C20987a.C20988a aVar = new C20987a.C20988a(this.f57435a.getSessionKey(), new File(Environment.getDataDirectory(this.f57437c), STORAGE));
        aVar.mo172439a(Integer.valueOf(getContext().getCustomThemeId()));
        aVar.mo172439a(Boolean.valueOf(isActive$jumio_core_release()));
        aVar.mo172439a(Boolean.valueOf(isConsented$jumio_core_release()));
        aVar.mo172439a(getLastError$jumio_core_release());
        aVar.mo172439a(getDataManager());
        getBackendManager().persist(aVar, z);
        aVar.mo172438a();
    }

    public final void reporting(boolean z) {
        try {
            if (((SettingsModel) this.f57440f.get(SettingsModel.class)).isAdditionalDataPointsEnabled()) {
                Analytics.Companion.add(MobileEvents.additionalDatapoints(this.f57437c, this.f57440f));
            }
        } catch (Exception e) {
            Log.printStackTrace(e);
        }
        try {
            C19484j0 j0Var = (C19484j0) this.f57440f.get(C19484j0.class);
            if (!z) {
                j0Var.mo148651b((String) null);
                j0Var.mo148647a((JumioScanSide) null);
                j0Var.mo148648a((JumioScanStep) null);
            }
            Analytics.Companion.add(MobileEvents.reporting(j0Var, (C19497p) this.f57440f.get(C19497p.class)));
        } catch (Exception e2) {
            Log.printStackTrace(e2);
        }
        this.f57443i.reporting(z);
    }

    public final void retry(JumioError jumioError) {
        Intrinsics.checkNotNullParameter(jumioError, "error");
        if (Intrinsics.areEqual((Object) jumioError, (Object) this.f57447m)) {
            this.f57441g.retry();
            Analytics.Companion.add(MobileEvents.userAction$default("retry_error", (JumioScanStep) null, (Object) null, 6, (Object) null));
            return;
        }
        throw new IllegalArgumentException("Specified error is not valid".toString());
    }

    public final void saveState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        bundle.putSerializable("Jumio1", this.f57435a);
        persistAllData(false);
    }

    public final void setActive$jumio_core_release(boolean z) {
        this.f57445k = z;
    }

    public final void setActiveCredential$jumio_core_release(JumioCredential jumioCredential) {
        this.f57444j = jumioCredential;
    }

    public final void setAuthorizationModel(AuthorizationModel authorizationModel) {
        Intrinsics.checkNotNullParameter(authorizationModel, "<set-?>");
        this.f57435a = authorizationModel;
    }

    public final void setConsented$jumio_core_release(boolean z) {
        this.f57446l = z;
    }

    public final void setContext(MobileContext mobileContext) {
        Intrinsics.checkNotNullParameter(mobileContext, "<set-?>");
        this.f57437c = mobileContext;
    }

    public final void setControllerInterface(JumioControllerInterface jumioControllerInterface) {
        this.f57436b = jumioControllerInterface;
    }

    public final void setLastError$jumio_core_release(JumioError jumioError) {
        this.f57447m = jumioError;
    }

    public final synchronized JumioCredential startCredential(JumioCredentialInfo jumioCredentialInfo) throws IllegalArgumentException {
        JumioCredential jumioCredential;
        Intrinsics.checkNotNullParameter(jumioCredentialInfo, "credentialInfo");
        if (this.f57446l) {
            boolean z = true;
            if (this.f57444j == null) {
                JumioCredential a = ((C19497p) this.f57440f.get(C19497p.class)).mo148705a(this, jumioCredentialInfo.getId());
                this.f57444j = a;
                if (a == null) {
                    z = false;
                }
                if (z) {
                    if (a != null) {
                        a.start$jumio_core_release();
                    }
                    jumioCredential = this.f57444j;
                    Intrinsics.checkNotNull(jumioCredential);
                } else {
                    throw new IllegalArgumentException("Could not start credential".toString());
                }
            } else {
                throw new IllegalArgumentException("Please finish the active credential first".toString());
            }
        } else {
            throw new IllegalArgumentException("User consent is missing".toString());
        }
        return jumioCredential;
    }

    public final void userConsented() {
        if (!this.f57446l) {
            this.f57446l = true;
        }
    }

    public Controller(Context context, AuthorizationModel authorizationModel, JumioControllerInterface jumioControllerInterface, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(authorizationModel, "authorizationModel");
        Intrinsics.checkNotNullParameter(jumioControllerInterface, "controllerInterface");
        this.f57442h = new C19470d0();
        this.f57445k = true;
        this.f57446l = true;
        this.f57437c = new MobileContext(context.getApplicationContext(), authorizationModel, i);
        this.f57438d = new C19512x(context, this);
        this.f57439e = new DeviceRotationManager(context, Rotation.NATIVE);
        DataManager dataManager = new DataManager();
        this.f57440f = dataManager;
        BackendManager backendManager = new BackendManager(this.f57437c, dataManager, authorizationModel);
        this.f57441g = backendManager;
        backendManager.addBinding(this);
        this.f57443i = new Analytics(backendManager);
        this.f57435a = authorizationModel;
        this.f57436b = jumioControllerInterface;
        mo171882b(false);
    }

    /* renamed from: a */
    public final void mo171872a(JumioCredential jumioCredential, JumioScanSide jumioScanSide, JumioScanPartInterface jumioScanPartInterface) {
        ScanPartPlugin scanPartPlugin;
        if (jumioCredential.getData$jumio_core_release().mo148668b() != null) {
            ScanPartModel b = jumioCredential.getData$jumio_core_release().mo148668b();
            if ((b == null ? null : b.getSide()) == jumioCredential.getData$jumio_core_release().mo148665a()) {
                ScanPartModel b2 = jumioCredential.getData$jumio_core_release().mo148668b();
                if (b2 != null && jumioCredential.getData$jumio_core_release().mo148665a() == JumioScanSide.NFC && (scanPartPlugin = (ScanPartPlugin) getPluginManager().mo148608a(C20991a.C20994c.NFC)) != null) {
                    jumioCredential.setActiveScanPart$jumio_core_release(new JumioScanPart(scanPartPlugin.getScanPart(jumioCredential.getController$jumio_core_release(), jumioCredential, b2, jumioScanPartInterface)));
                    return;
                }
                return;
            }
        }
        jumioCredential.initScanPart(jumioScanSide, jumioScanPartInterface);
    }

    public void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        onError(th, apiCallDataModel.getCall());
    }

    /* renamed from: a */
    public final void mo171871a(SettingsModel settingsModel) {
        Analytics.Companion companion = Analytics.Companion;
        companion.setEnabled(settingsModel.isAnalyticsEnabled());
        this.f57443i.start(settingsModel.getServerTimestamp(), 20000, 20);
        C19501r.m41215a((Context) this.f57437c, this.f57440f);
        companion.add(MobileEvents.deviceInformation(this.f57437c));
        companion.add(MobileEvents.sdkParameters(this.f57437c, this.f57440f, this.f57441g.getAuthorizationModel(), mo171883b()));
        boolean z = !C19507t0.f55406a.mo148739a(this.f57440f, settingsModel);
        this.f57446l = z;
        String str = null;
        if (!z) {
            companion.add(MobileEvents.alert$default("bipa", (MetaInfo) null, 2, (Object) null));
            str = settingsModel.getConsentUrl();
        }
        JumioControllerInterface jumioControllerInterface = this.f57436b;
        if (jumioControllerInterface != null) {
            jumioControllerInterface.onInitialized(((C19497p) this.f57440f.get(C19497p.class)).mo148715e(), str);
        }
    }

    /* renamed from: b */
    public final void mo171881b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                SettingsModel settingsModel = (SettingsModel) this.f57440f.get(SettingsModel.class);
                settingsModel.fromJson(jSONObject, CountryDocumentModel.f57655b.isDeviceLanguageLocalizable(this.f57437c));
                String b = mo171880b(jSONObject);
                C19497p a = mo171869a(jSONObject);
                C19511w wVar = new C19511w();
                if (!a.mo148714d().isEmpty()) {
                    wVar.mo148754b(jSONObject.getString("acquisitionReference"));
                    wVar.mo148752a(jSONObject.getString("accountId"));
                    this.f57440f.put(C19511w.class, wVar);
                    if (Log.isFileLoggingActivated()) {
                        LogUtils.setSessionLogFolderName(Intrinsics.stringPlus("SDK_", wVar.mo148753b()));
                    }
                    mo171878a(a, settingsModel, b);
                    mo171876a(settingsModel.getDataDog().getClientId(), settingsModel.getDataDog().getAppId());
                    return;
                }
                throw new Exception("No credentials available");
            } catch (Exception e) {
                throw e;
            } catch (Exception e2) {
                Log.printStackTrace(e2);
                onError$default(this, new Error(ErrorCase.PROCESS_CANT_BE_COMPLETED, 1, 0), (Class) null, 2, (Object) null);
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Controller(Context context, Bundle bundle, JumioControllerInterface jumioControllerInterface, JumioScanPartInterface jumioScanPartInterface, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, bundle, jumioControllerInterface, (i & 8) != 0 ? null : jumioScanPartInterface);
    }

    public Controller(Context context, Bundle bundle, JumioControllerInterface jumioControllerInterface, JumioScanPartInterface jumioScanPartInterface) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "data");
        Intrinsics.checkNotNullParameter(jumioControllerInterface, "controllerInterface");
        this.f57442h = new C19470d0();
        this.f57445k = true;
        this.f57446l = true;
        Serializable serializable = bundle.getSerializable("Jumio1");
        if (serializable != null) {
            AuthorizationModel authorizationModel = (AuthorizationModel) serializable;
            this.f57435a = authorizationModel;
            C20987a.C20989b bVar = new C20987a.C20989b(authorizationModel.getSessionKey(), new File(Environment.getDataDirectory(context), STORAGE));
            Context applicationContext = context.getApplicationContext();
            AuthorizationModel authorizationModel2 = this.f57435a;
            Integer num = (Integer) bVar.mo172440a();
            this.f57437c = new MobileContext(applicationContext, authorizationModel2, num == null ? 0 : num.intValue());
            Boolean bool = (Boolean) bVar.mo172440a();
            this.f57445k = bool == null ? true : bool.booleanValue();
            Boolean bool2 = (Boolean) bVar.mo172440a();
            this.f57446l = bool2 == null ? true : bool2.booleanValue();
            this.f57447m = (JumioError) bVar.mo172440a();
            DataManager dataManager = (DataManager) bVar.mo172440a();
            dataManager = dataManager == null ? new DataManager() : dataManager;
            this.f57440f = dataManager;
            BackendManager backendManager = new BackendManager(this.f57437c, dataManager, this.f57435a);
            this.f57441g = backendManager;
            backendManager.restore(bVar);
            this.f57438d = new C19512x(context, this);
            this.f57439e = new DeviceRotationManager(context, Rotation.NATIVE);
            this.f57436b = jumioControllerInterface;
            backendManager.addBinding(this);
            this.f57443i = new Analytics(backendManager);
            C19497p pVar = (C19497p) dataManager.get(C19497p.class);
            String a = pVar.mo148706a();
            if (a != null) {
                setActiveCredential$jumio_core_release(pVar.mo148705a(this, a));
                JumioCredential activeCredential$jumio_core_release = getActiveCredential$jumio_core_release();
                if (!(activeCredential$jumio_core_release == null || jumioScanPartInterface == null)) {
                    mo171873a(activeCredential$jumio_core_release, jumioScanPartInterface);
                }
            }
            mo171882b(true);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.jumio.core.models.AuthorizationModel");
    }

    /* renamed from: a */
    public static /* synthetic */ void m43673a(Controller controller, HashMap hashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            hashMap = new HashMap();
        }
        controller.mo171877a((HashMap<String, JumioCredentialResult>) hashMap);
    }

    /* renamed from: a */
    public final void mo171877a(HashMap<String, JumioCredentialResult> hashMap) {
        SettingsModel settingsModel = (SettingsModel) this.f57440f.get(SettingsModel.class);
        C19511w wVar = (C19511w) this.f57440f.get(C19511w.class);
        try {
            for (C19489l lVar : ((C19497p) this.f57440f.get(C19497p.class)).mo148714d()) {
                mo171874a(mo171868a(hashMap, lVar), lVar, settingsModel);
            }
        } catch (Exception e) {
            onError$default(this, e, (Class) null, 2, (Object) null);
        }
        JumioResult jumioResult = new JumioResult(wVar.mo148753b(), wVar.mo148751a(), true, ((C19497p) this.f57440f.get(C19497p.class)).mo148715e(), hashMap, (JumioError) null, 32, (DefaultConstructorMarker) null);
        mo171879a(false);
        JumioControllerInterface jumioControllerInterface = this.f57436b;
        if (jumioControllerInterface != null) {
            jumioControllerInterface.onFinished(jumioResult);
        }
        mo171870a();
    }

    /* renamed from: b */
    public final String mo171880b(JSONObject jSONObject) {
        String optString = jSONObject.optString("iproovTokenData");
        Intrinsics.checkNotNullExpressionValue(optString, "iproovTokenData");
        if (optString.length() > 0) {
            try {
                IproovTokenModel.Companion companion = IproovTokenModel.Companion;
                String string = jSONObject.getString("iproovTokenData");
                Intrinsics.checkNotNullExpressionValue(string, "data.getString(\"iproovTokenData\")");
                this.f57440f.put(IproovTokenModel.class, companion.fromString(string));
            } catch (Exception e) {
                Log.printStackTrace(e);
            }
        }
        return optString;
    }

    /* renamed from: b */
    public final boolean mo171883b() {
        Class<?> cls = ReflectionUtil.getClass("com.jumio.defaultui.viewmodel.JumioViewModel");
        KClass<?> kotlinClass = cls == null ? null : JvmClassMappingKt.getKotlinClass(cls);
        if (kotlinClass == null) {
            return false;
        }
        return kotlinClass.isInstance(this.f57436b);
    }

    /* renamed from: a */
    public final JumioCredentialResult mo171868a(HashMap<String, JumioCredentialResult> hashMap, C19489l lVar) {
        JumioFaceResult jumioFaceResult;
        JumioCredentialResult jumioCredentialResult;
        JumioScanMode jumioScanMode;
        String e = lVar.mo148671e();
        JumioCredentialResult jumioCredentialResult2 = hashMap.get(e);
        JumioCredentialResult jumioCredentialResult3 = jumioCredentialResult2;
        if (jumioCredentialResult2 == null) {
            int i = C20934a.f57448a[lVar.mo148670d().ordinal()];
            if (i == 1) {
                jumioCredentialResult = new JumioIDResult();
            } else if (i == 2) {
                JumioFaceResult jumioFaceResult2 = new JumioFaceResult();
                FaceScanPartModel faceScanPartModel = (FaceScanPartModel) lVar.mo148672f().get(JumioScanSide.FACE);
                jumioFaceResult = jumioFaceResult2;
                if (faceScanPartModel != null) {
                    LivenessDataModel livenessData = faceScanPartModel.getLivenessData();
                    jumioFaceResult = jumioFaceResult2;
                    if (livenessData != null) {
                        jumioFaceResult2.setPassed(livenessData.isPassed());
                        ScanMode type = livenessData.getType();
                        int i2 = type == null ? -1 : C20934a.f57449b[type.ordinal()];
                        if (i2 == 1) {
                            jumioScanMode = JumioScanMode.FACE_IPROOV;
                        } else if (i2 != 2) {
                            jumioScanMode = null;
                        } else {
                            jumioScanMode = JumioScanMode.FACE_MANUAL;
                        }
                        jumioFaceResult2.setExtractionMode(jumioScanMode);
                        jumioFaceResult = jumioFaceResult2;
                    }
                }
                hashMap.put(e, jumioFaceResult);
                jumioCredentialResult3 = jumioFaceResult;
            } else if (i == 3) {
                jumioCredentialResult = new JumioCredentialResult();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            jumioFaceResult = jumioCredentialResult;
            hashMap.put(e, jumioFaceResult);
            jumioCredentialResult3 = jumioFaceResult;
        }
        return jumioCredentialResult3;
    }

    /* renamed from: a */
    public final void mo171874a(JumioCredentialResult jumioCredentialResult, C19489l lVar, SettingsModel settingsModel) {
        if (settingsModel.getReturnImages()) {
            JumioImageData jumioImageData = new JumioImageData(this.f57435a);
            for (Map.Entry<JumioScanSide, ScanPartModel> value : lVar.mo148672f().entrySet()) {
                ScanPartModel scanPartModel = (ScanPartModel) value.getValue();
                try {
                    jumioImageData.addImage$jumio_core_release(this.f57437c, C20932a.m43672a(scanPartModel.getImageData().getImage().getPath(), this.f57435a.getSessionKey()), scanPartModel.getSide());
                } catch (Exception e) {
                    Log.m43651e("ImageData", "Error reading File", (Throwable) e);
                }
            }
            jumioCredentialResult.setImageData(jumioImageData);
        }
    }

    /* renamed from: a */
    public final void mo171870a() {
        this.f57438d.mo148758d();
        this.f57441g.removeBinding(this);
        this.f57439e.destroy();
        this.f57442h.mo148609a();
        this.f57436b = null;
        try {
            this.f57440f.removeAll();
        } catch (Exception e) {
            Log.printStackTrace(e);
        }
        try {
            File[] listFiles = new File(this.f57437c.getFilesDir(), "jumio").listFiles(new C20932a.C20933a("tmp_"));
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file = listFiles[i];
                    i++;
                    if (file.isFile() && !file.delete()) {
                        file.deleteOnExit();
                    }
                }
            }
        } catch (Exception e2) {
            Log.printStackTrace(e2);
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof C19508u) {
            ((C19508u) defaultUncaughtExceptionHandler).mo148740a();
        }
        this.f57445k = false;
    }

    /* renamed from: a */
    public final void mo171879a(boolean z) {
        C20921a aVar;
        if (z) {
            try {
                C19501r.m41217b(this.f57437c, "Jumio05");
                aVar = C20921a.CANCELLED;
            } catch (Exception e) {
                Log.printStackTrace(e);
            }
        } else {
            C19501r.m41217b(this.f57437c, "Jumio04");
            aVar = C20921a.FINISHED;
        }
        Analytics.Companion.add(MobileEvents.lifecycle$default(aVar, (Object) null, 2, (Object) null));
        try {
            this.f57443i.shutdown();
        } catch (Exception e2) {
            Log.printStackTrace(e2);
        }
    }

    /* renamed from: a */
    public final void mo171876a(String str, String str2) {
        AnalyticsPlugin analyticsPlugin = (AnalyticsPlugin) C20991a.m43783b(C20991a.C20994c.DATADOG);
        if (analyticsPlugin == null) {
            Log.m43655i(Analytics.LOGTAG, "DataDog plugin is turned off");
        } else if (str == null || str2 == null) {
            Log.m43665w(Analytics.LOGTAG, "Credentials are not provided for launching DataDog, skipping launch!");
        } else {
            analyticsPlugin.run(this.f57437c, str, str2);
        }
    }

    /* renamed from: a */
    public final void mo171875a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        } else if (((JSONObject) obj).optBoolean("extractDataExecuted", false)) {
            this.f57441g.extractData();
        } else {
            m43673a(this, (HashMap) null, 1, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078 A[EDGE_INSN: B:35:0x0078->B:29:0x0078 ?: BREAK  , SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo171878a(jumio.core.C19497p r9, com.jumio.core.models.SettingsModel r10, java.lang.String r11) {
        /*
            r8 = this;
            java.util.ArrayList r0 = r9.mo148714d()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0077
            java.lang.Object r1 = r0.next()
            r2 = r1
            jumio.core.l r2 = (jumio.core.C19489l) r2
            com.jumio.sdk.credentials.JumioCredentialCategory r3 = r2.mo148670d()
            com.jumio.sdk.credentials.JumioCredentialCategory r4 = com.jumio.sdk.credentials.JumioCredentialCategory.ID
            r5 = 0
            r6 = 1
            if (r3 != r4) goto L_0x0029
            com.jumio.core.models.CountryDocumentModel r3 = r10.getCountryModel()
            boolean r3 = r3.mo172212b()
            if (r3 != 0) goto L_0x0073
        L_0x0029:
            com.jumio.sdk.credentials.JumioCredentialCategory r3 = r2.mo148670d()
            com.jumio.sdk.credentials.JumioCredentialCategory r4 = com.jumio.sdk.credentials.JumioCredentialCategory.FACE
            if (r3 != r4) goto L_0x003d
            com.jumio.commons.camera.JumioCameraManager$Companion r3 = com.jumio.commons.camera.JumioCameraManager.Companion
            com.jumio.core.MobileContext r7 = r8.getContext()
            boolean r3 = r3.hasFrontFacingCamera(r7)
            if (r3 == 0) goto L_0x0073
        L_0x003d:
            com.jumio.sdk.credentials.JumioCredentialCategory r3 = r2.mo148670d()
            if (r3 != r4) goto L_0x0074
            java.util.ArrayList r2 = r2.mo148669c()
            com.jumio.core.credentials.b r3 = com.jumio.core.credentials.C20951b.AUTHENTICATION
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x0074
            java.util.ArrayList r2 = r9.mo148714d()
            int r2 = r2.size()
            r3 = 2
            if (r2 > r3) goto L_0x0073
            int r2 = r11.length()
            if (r2 != 0) goto L_0x0062
            r2 = 1
            goto L_0x0063
        L_0x0062:
            r2 = 0
        L_0x0063:
            if (r2 != 0) goto L_0x0073
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r2 < r3) goto L_0x0073
            com.jumio.core.plugins.a$c r2 = com.jumio.core.plugins.C20991a.C20994c.FACE_IPROOV
            boolean r2 = com.jumio.core.plugins.C20991a.m43784c(r2)
            if (r2 != 0) goto L_0x0074
        L_0x0073:
            r5 = 1
        L_0x0074:
            if (r5 == 0) goto L_0x0008
            goto L_0x0078
        L_0x0077:
            r1 = 0
        L_0x0078:
            if (r1 != 0) goto L_0x007e
            r8.mo171871a((com.jumio.core.models.SettingsModel) r10)
            return
        L_0x007e:
            java.lang.Exception r9 = new java.lang.Exception
            java.lang.String r10 = "Credential not supported"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.Controller.mo171878a(jumio.core.p, com.jumio.core.models.SettingsModel, java.lang.String):void");
    }

    /* renamed from: a */
    public final C19497p mo171869a(JSONObject jSONObject) {
        T t;
        ScanPartPlugin scanPartPlugin;
        boolean z;
        int length;
        C19497p pVar = new C19497p();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("credentials");
            if (!(optJSONArray == null || optJSONArray.length() == 0 || (length = optJSONArray.length()) <= 0)) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonArray.getJSONObject(i)");
                    pVar.mo148708a(jSONObject2);
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            this.f57440f.put(C19497p.class, pVar);
            Iterator<T> it = pVar.mo148714d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (((C19489l) t).mo148670d() == JumioCredentialCategory.ID) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            if (!(((C19489l) t) == null || (scanPartPlugin = (ScanPartPlugin) getPluginManager().mo148608a(C20991a.C20994c.NFC)) == null)) {
                scanPartPlugin.preload(this);
            }
            return pVar;
        } catch (Exception e) {
            throw e;
        }
    }
}
