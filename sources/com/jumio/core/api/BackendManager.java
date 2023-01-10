package com.jumio.core.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.sdk.apm.SystemUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.jumio.ale.swig.ALECore;
import com.jumio.ale.swig.ALESettings;
import com.jumio.analytics.AnalyticsEvent;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.api.calls.AnalyticsCall;
import com.jumio.core.api.calls.C20947a;
import com.jumio.core.api.calls.C20948b;
import com.jumio.core.api.calls.C20949c;
import com.jumio.core.api.calls.IproovTokenCall;
import com.jumio.core.api.calls.IproovValidateCall;
import com.jumio.core.api.calls.UploadCall;
import com.jumio.core.api.calls.UsabilityCall;
import com.jumio.core.enums.C20953b;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.environment.Environment;
import com.jumio.core.error.Error;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.core.network.ApiCall;
import com.jumio.core.network.C20982b;
import com.jumio.core.persistence.C20987a;
import com.jumio.core.persistence.DataManager;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.enums.JumioDataCenter;
import com.jumio.sdk.enums.JumioScanSide;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLException;
import jumio.core.C19465b0;
import jumio.core.C19466c;
import jumio.core.C19471e;
import jumio.core.C19475f;
import jumio.core.C19477g;
import jumio.core.C19482i0;
import jumio.core.C19500q0;
import jumio.core.C19502r0;
import jumio.core.C19504s0;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p074io.IOUtils;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0001_B\u001f\u0012\u0006\u0010B\u001a\u00020=\u0012\u0006\u0010H\u001a\u00020C\u0012\u0006\u0010N\u001a\u00020I¢\u0006\u0004\b]\u0010^J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0007J\u001a\u0010\u0016\u001a\u00020\u00072\u0012\u0010\u0015\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013J\u0006\u0010\u0017\u001a\u00020\u0007J\u0016\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0007J0\u0010-\u001a\u00020\u00072\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(2\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010,\u001a\u00020\u0005J0\u0010/\u001a\u00020\u00072\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(2\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010.\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u0007J\u001e\u00105\u001a\u00020\u00072\n\u00102\u001a\u0006\u0012\u0002\b\u0003012\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u001e\u00108\u001a\u00020\u00072\n\u00102\u001a\u0006\u0012\u0002\b\u0003012\b\u00107\u001a\u0004\u0018\u000106H\u0016J\u001c\u0010<\u001a\u00020;2\b\u00109\u001a\u0004\u0018\u0001032\n\u0010:\u001a\u0006\u0012\u0002\b\u00030\u0013R\u001c\u0010B\u001a\u00020=8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001c\u0010H\u001a\u00020C8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0019\u0010N\u001a\u00020I8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bR\u0010PR\u0016\u0010W\u001a\u00020T8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0X8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[¨\u0006`"}, mo148868d2 = {"Lcom/jumio/core/api/BackendManager;", "Ljumio/core/f;", "Ljumio/core/g;", "Lcom/jumio/core/persistence/a$a;", "persistor", "", "stop", "", "persist", "Lcom/jumio/core/persistence/a$b;", "restorer", "restore", "Lcom/jumio/core/network/ApiBinding;", "binding", "addBinding", "removeBinding", "clearQueue", "cancelCall", "retry", "Ljava/lang/Class;", "Lcom/jumio/core/network/ApiCall;", "clazz", "remove", "settings", "Lcom/jumio/sdk/credentials/JumioCredential;", "credential", "Lcom/jumio/core/models/ScanPartModel;", "scanPart", "uploadPart", "Lcom/jumio/core/extraction/liveness/extraction/LivenessDataModel;", "livenessModel", "uploadLiveness", "", "resultKey", "usability", "requestIproovToken", "validateIproovToken", "extractData", "Ljava/util/ArrayList;", "Lcom/jumio/analytics/AnalyticsEvent;", "Lkotlin/collections/ArrayList;", "events", "", "offset", "fireAndForget", "reporting", "lastCall", "analytics", "finalizeCall", "Lcom/jumio/core/models/ApiCallDataModel;", "apiCallDataModel", "", "error", "onError", "", "result", "onResult", "e", "sourceClass", "Lcom/jumio/core/error/Error;", "errorFromThrowable", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/jumio/core/persistence/DataManager;", "b", "Lcom/jumio/core/persistence/DataManager;", "getDataManager", "()Lcom/jumio/core/persistence/DataManager;", "dataManager", "Lcom/jumio/core/models/AuthorizationModel;", "c", "Lcom/jumio/core/models/AuthorizationModel;", "getAuthorizationModel", "()Lcom/jumio/core/models/AuthorizationModel;", "authorizationModel", "getEndpoint", "()Ljava/lang/String;", "endpoint", "getUserAgent", "userAgent", "Lcom/jumio/core/network/b;", "getEncryptionProvider", "()Lcom/jumio/core/network/b;", "encryptionProvider", "", "", "getPublicKeys", "()[[B", "publicKeys", "<init>", "(Landroid/content/Context;Lcom/jumio/core/persistence/DataManager;Lcom/jumio/core/models/AuthorizationModel;)V", "Companion", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: BackendManager.kt */
public final class BackendManager implements C19475f, C19477g {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: j */
    public static final String f57461j;

    /* renamed from: k */
    public static final String f57462k;

    /* renamed from: l */
    public static final String f57463l;

    /* renamed from: m */
    public static final String f57464m = StringDeobfuscator.deobfuscate(new byte[]{-102, 125, 101, -22, Ascii.ESC, -1, -83}, 4627847860243393458L);

    /* renamed from: n */
    public static final String f57465n;

    /* renamed from: o */
    public static final String f57466o;

    /* renamed from: p */
    public static final String f57467p;

    /* renamed from: q */
    public static final String f57468q = C19471e.f55336a;

    /* renamed from: r */
    public static final String f57469r = C19471e.f55337b;

    /* renamed from: s */
    public static final String f57470s = C19471e.f55338c;

    /* renamed from: t */
    public static final String f57471t = C19471e.f55339d;

    /* renamed from: u */
    public static final String f57472u = C19471e.f55340e;

    /* renamed from: v */
    public static final String f57473v = C19471e.f55341f;

    /* renamed from: a */
    public final Context f57474a;

    /* renamed from: b */
    public final DataManager f57475b;

    /* renamed from: c */
    public final AuthorizationModel f57476c;

    /* renamed from: d */
    public final SingleProcessor f57477d;

    /* renamed from: e */
    public final QueueProcessor f57478e;

    /* renamed from: f */
    public ALECore f57479f;

    /* renamed from: g */
    public final C19502r0 f57480g = ((C19502r0) getDataManager().get(SettingsModel.class));

    /* renamed from: h */
    public final Object f57481h = new Object();

    /* renamed from: i */
    public final HashMap<Class<?>, ApiBinding> f57482i = new HashMap<>();

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\bR\u001e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\bR\u001e\u0010\u0011\u001a\n \r*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\bR\u001e\u0010\u0014\u001a\n \r*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\n \r*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\b¨\u0006\u0019"}, mo148868d2 = {"Lcom/jumio/core/api/BackendManager$Companion;", "", "Ljava/lang/Class;", "sourceClass", "", "callNumber", "", "URL_API_NV", "Ljava/lang/String;", "URL_PREFIX_EU", "URL_PREFIX_SG", "URL_PREFIX_US", "USER_AGENT", "kotlin.jvm.PlatformType", "euAleKeyID", "euAlePublicKey", "euPrefix", "sgAleKeyID", "sgAlePublicKey", "sgPrefix", "usAleKeyID", "usAlePublicKey", "usPrefix", "<init>", "()V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: BackendManager.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int callNumber(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "sourceClass");
            if (Intrinsics.areEqual((Object) cls, (Object) C20949c.class)) {
                return 1;
            }
            if (Intrinsics.areEqual((Object) cls, (Object) C20947a.class)) {
                return 3;
            }
            if (Intrinsics.areEqual((Object) cls, (Object) UploadCall.class)) {
                return 4;
            }
            if (Intrinsics.areEqual((Object) cls, (Object) C19482i0.class)) {
                return 5;
            }
            if (Intrinsics.areEqual((Object) cls, (Object) C20948b.class)) {
                return 6;
            }
            if (Intrinsics.areEqual((Object) cls, (Object) UsabilityCall.class)) {
                return 7;
            }
            if (Intrinsics.areEqual((Object) cls, (Object) IproovTokenCall.class)) {
                return 8;
            }
            return Intrinsics.areEqual((Object) cls, (Object) IproovValidateCall.class) ? 9 : 0;
        }
    }

    /* renamed from: com.jumio.core.api.BackendManager$a */
    /* compiled from: BackendManager.kt */
    public /* synthetic */ class C20945a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f57483a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f57484b;

        static {
            int[] iArr = new int[JumioScanSide.values().length];
            iArr[JumioScanSide.FRONT.ordinal()] = 1;
            iArr[JumioScanSide.NFC.ordinal()] = 2;
            iArr[JumioScanSide.BACK.ordinal()] = 3;
            iArr[JumioScanSide.FACE.ordinal()] = 4;
            iArr[JumioScanSide.DOCUMENT.ordinal()] = 5;
            f57483a = iArr;
            int[] iArr2 = new int[JumioDataCenter.values().length];
            iArr2[JumioDataCenter.EU.ordinal()] = 1;
            iArr2[JumioDataCenter.US.ordinal()] = 2;
            iArr2[JumioDataCenter.SG.ordinal()] = 3;
            f57484b = iArr2;
        }
    }

    static {
        String deobfuscate = StringDeobfuscator.deobfuscate(new byte[]{-38, -22, -25, -126, -69, 10, 65, Ascii.ETB, -28, -59, -20, -57, 45, 85, -81, 79, 32, 42, -106, -35, Ascii.ESC, -118, -85, -69, -95, -37, -83, 79}, 3102386395588422242L);
        f57461j = deobfuscate;
        String deobfuscate2 = StringDeobfuscator.deobfuscate(new byte[]{84, 44, -61, -52, -17, -21, -52, -94, -124, -123, -62, Ascii.f55142FS, -27, 46, SignedBytes.MAX_POWER_OF_TWO, 109, -8, -103, 58, 104, -12, 69, -16, 96, -113, 84, 124, -71}, -2860111990246517939L);
        f57462k = deobfuscate2;
        String deobfuscate3 = StringDeobfuscator.deobfuscate(new byte[]{76, -51, -1, -118, 106, -19, 70, Ascii.ETB, -28, 88, 53, 95, 60, 56, 79, -35, -16, -117, 97, 54, Ascii.f55148SI, -117, -47, -32, -101, 11, -76, -85}, -412348624451039355L);
        f57463l = deobfuscate3;
        f57465n = deobfuscate;
        f57466o = deobfuscate2;
        f57467p = deobfuscate3;
    }

    public BackendManager(Context context, DataManager dataManager, AuthorizationModel authorizationModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataManager, "dataManager");
        Intrinsics.checkNotNullParameter(authorizationModel, "authorizationModel");
        this.f57474a = context;
        this.f57475b = dataManager;
        this.f57476c = authorizationModel;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        this.f57477d = new SingleProcessor(newSingleThreadExecutor, this, this);
        ExecutorService newSingleThreadExecutor2 = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor2, "newSingleThreadExecutor()");
        this.f57478e = new QueueProcessor(newSingleThreadExecutor2, this, this);
    }

    /* renamed from: a */
    public static /* synthetic */ void m43690a(BackendManager backendManager, ApiCallDataModel apiCallDataModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        backendManager.mo171933a(apiCallDataModel, z);
    }

    public static /* synthetic */ void analytics$default(BackendManager backendManager, ArrayList arrayList, long j, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        backendManager.analytics(arrayList, j, z);
    }

    @JvmStatic
    public static final int callNumber(Class<?> cls) {
        return Companion.callNumber(cls);
    }

    public static /* synthetic */ void cancelCall$default(BackendManager backendManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        backendManager.cancelCall(z);
    }

    public static /* synthetic */ void reporting$default(BackendManager backendManager, ArrayList arrayList, long j, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        backendManager.reporting(arrayList, j, z);
    }

    public final void addBinding(ApiBinding apiBinding) {
        Intrinsics.checkNotNullParameter(apiBinding, "binding");
        synchronized (this.f57481h) {
            for (Class put : apiBinding.getBindingClasses()) {
                this.f57482i.put(put, apiBinding);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void analytics(ArrayList<AnalyticsEvent> arrayList, long j, boolean z) {
        Intrinsics.checkNotNullParameter(arrayList, "events");
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(AnalyticsCall.class);
        apiCallDataModel.setTimeout(this.f57480g.getAnalytics());
        apiCallDataModel.setFireAndForget(z);
        apiCallDataModel.setIgnoreErrors(z);
        apiCallDataModel.getData().put("DATA_EVENTS", arrayList);
        apiCallDataModel.getData().put("DATA_OFFSET", Long.valueOf(j));
        mo171933a(apiCallDataModel, z);
    }

    public final void cancelCall(boolean z) {
        this.f57478e.mo171956a();
        if (z) {
            this.f57478e.mo171961b();
        }
    }

    public final Error errorFromThrowable(Throwable th, Class<?> cls) {
        ErrorCase errorCase;
        Intrinsics.checkNotNullParameter(cls, "sourceClass");
        if (th instanceof Error) {
            return (Error) th;
        }
        Object systemService = getContext().getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) systemService);
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                errorCase = ErrorCase.DEVICE_IS_OFFLINE;
            } else {
                boolean z = th instanceof C19504s0;
                if (z && ((C19504s0) th).mo148730a() == 401) {
                    errorCase = ErrorCase.AUTH_FAILED;
                } else if (z && ((C19504s0) th).mo148730a() == 305) {
                    errorCase = ErrorCase.ALE_KEY_NOT_VALID;
                } else if (z && ((C19504s0) th).mo148730a() == 412) {
                    errorCase = ErrorCase.TRANSACTION_FINISHED;
                } else if (th instanceof SSLException) {
                    errorCase = ErrorCase.CERTIFICATE_ERROR;
                } else if (!z || ((C19504s0) th).mo148730a() != 400 || !Intrinsics.areEqual((Object) cls, (Object) C20948b.class)) {
                    errorCase = ErrorCase.GENERAL_NETWORK_ERROR;
                } else {
                    errorCase = ErrorCase.PROCESS_CANT_BE_COMPLETED;
                }
            }
            return new Error(errorCase, Companion.callNumber(cls), th instanceof C19504s0 ? ((C19504s0) th).mo148730a() : 0);
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public final void extractData() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(C20947a.class);
        apiCallDataModel.setTimeout(this.f57480g.getExtractdata());
        m43690a(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void finalizeCall() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(C20948b.class);
        apiCallDataModel.setTimeout(this.f57480g.getFinalize());
        m43690a(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final AuthorizationModel getAuthorizationModel() {
        return this.f57476c;
    }

    public Context getContext() {
        return this.f57474a;
    }

    public DataManager getDataManager() {
        return this.f57475b;
    }

    public synchronized C20982b getEncryptionProvider() {
        if (this.f57479f == null) {
            Environment.loadAleLib();
            ALESettings aLESettings = new ALESettings();
            String str = "";
            int i = C20945a.f57484b[this.f57476c.getDataCenter().ordinal()];
            if (i == 1) {
                aLESettings.setKeyID(f57469r);
                aLESettings.setPublicKey(f57472u);
                str = f57466o;
            } else if (i == 2) {
                aLESettings.setKeyID(f57468q);
                aLESettings.setPublicKey(f57471t);
                str = f57465n;
            } else if (i == 3) {
                aLESettings.setKeyID(f57470s);
                aLESettings.setPublicKey(f57473v);
                str = f57467p;
            }
            String a = C19471e.m41126a(str);
            String stringPlus = Intrinsics.stringPlus(Environment.getDataDirectory(getContext()).getAbsolutePath(), "/ale/");
            if (a != null) {
                stringPlus = stringPlus + a + IOUtils.DIR_SEPARATOR_UNIX;
            }
            File file = new File(stringPlus);
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    throw new RuntimeException(Intrinsics.stringPlus("cannot create directory ", file));
                }
            }
            aLESettings.setDirectory(stringPlus);
            this.f57479f = new C19500q0(aLESettings);
        }
        return new C19466c(this.f57479f, this.f57476c.getAuthorization());
    }

    public String getEndpoint() {
        String str;
        int i = C20945a.f57484b[this.f57476c.getDataCenter().ordinal()];
        if (i == 1) {
            str = f57466o;
        } else if (i == 2) {
            str = f57465n;
        } else if (i == 3) {
            str = f57467p;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Intrinsics.stringPlus(str, f57464m);
    }

    public byte[][] getPublicKeys() {
        int i = C20945a.f57484b[this.f57476c.getDataCenter().ordinal()];
        if (i == 1) {
            byte[][] bArr = C19465b0.f55329b;
            Intrinsics.checkNotNullExpressionValue(bArr, "PUBLIC_KEY_EU");
            return bArr;
        } else if (i == 2) {
            byte[][] bArr2 = C19465b0.f55328a;
            Intrinsics.checkNotNullExpressionValue(bArr2, "PUBLIC_KEY_US");
            return bArr2;
        } else if (i == 3) {
            byte[][] bArr3 = C19465b0.f55330c;
            Intrinsics.checkNotNullExpressionValue(bArr3, "PUBLIC_KEY_SG");
            return bArr3;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public String getUserAgent() {
        return "Netverify Android SDK 4.1.0";
    }

    public void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        synchronized (this.f57481h) {
            if (this.f57482i.containsKey(apiCallDataModel.getCall())) {
                ApiBinding apiBinding = this.f57482i.get(apiCallDataModel.getCall());
                if (apiBinding != null) {
                    apiBinding.onError(apiCallDataModel, th);
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                Log.m43648e(Intrinsics.stringPlus("No error binding for ", apiCallDataModel.getCall().getSimpleName()));
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        synchronized (this.f57481h) {
            if (this.f57482i.containsKey(apiCallDataModel.getCall())) {
                ApiBinding apiBinding = this.f57482i.get(apiCallDataModel.getCall());
                if (apiBinding != null) {
                    apiBinding.onResult(apiCallDataModel, obj);
                    Unit unit = Unit.INSTANCE;
                }
            } else {
                Log.m43648e(Intrinsics.stringPlus("No result binding for ", apiCallDataModel.getCall().getSimpleName()));
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public final void persist(C20987a.C20988a aVar, boolean z) {
        Intrinsics.checkNotNullParameter(aVar, "persistor");
        this.f57477d.mo171966a(aVar, z);
        this.f57478e.mo171958a(aVar, z);
    }

    public final void remove(Class<? extends ApiCall<?>> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.f57478e.mo171960a(cls);
    }

    public final void removeBinding(ApiBinding apiBinding) {
        Intrinsics.checkNotNullParameter(apiBinding, "binding");
        for (Class remove : apiBinding.getBindingClasses()) {
            this.f57482i.remove(remove);
        }
    }

    public final void reporting(ArrayList<AnalyticsEvent> arrayList, long j, boolean z) {
        Intrinsics.checkNotNullParameter(arrayList, "events");
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(C19482i0.class);
        apiCallDataModel.setTimeout(this.f57480g.getAnalytics());
        apiCallDataModel.setFireAndForget(z);
        apiCallDataModel.setIgnoreErrors(z);
        apiCallDataModel.getData().put("DATA_EVENTS", arrayList);
        apiCallDataModel.getData().put("DATA_OFFSET", Long.valueOf(j));
        m43690a(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void requestIproovToken() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(IproovTokenCall.class);
        apiCallDataModel.setTimeout(this.f57480g.getIproovtoken());
        m43690a(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void restore(C20987a.C20989b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "restorer");
        this.f57477d.mo171967a(bVar);
        this.f57478e.mo171959a(bVar);
    }

    public final void retry() {
        this.f57478e.mo171962c();
    }

    public final void settings() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(C20949c.class);
        apiCallDataModel.setTimeout(10000);
        m43690a(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void uploadLiveness(JumioCredential jumioCredential, LivenessDataModel livenessDataModel) {
        Intrinsics.checkNotNullParameter(jumioCredential, "credential");
        Intrinsics.checkNotNullParameter(livenessDataModel, "livenessModel");
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(UploadCall.class);
        apiCallDataModel.setTimeout(this.f57480g.getUpload());
        apiCallDataModel.getData().put(UploadCall.DATA_UPLOAD_TYPE, UploadCall.DATA_UPLOAD_TYPE_LIVENESS);
        apiCallDataModel.getData().put(UploadCall.DATA_CREDENTIAL_ID, jumioCredential.getData$jumio_core_release().mo148671e());
        HashMap hashMap = new HashMap();
        hashMap.put(C20953b.LIVENESS_SERIES, livenessDataModel);
        apiCallDataModel.getData().put(UploadCall.DATA_PARTS, hashMap);
        m43690a(this, apiCallDataModel, false, 2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c7, code lost:
        if (r3 != false) goto L_0x00c9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void uploadPart(com.jumio.sdk.credentials.JumioCredential r10, com.jumio.core.models.ScanPartModel r11) {
        /*
            r9 = this;
            java.lang.String r0 = "credential"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "scanPart"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.jumio.core.models.ApiCallDataModel r0 = new com.jumio.core.models.ApiCallDataModel
            java.lang.Class<com.jumio.core.api.calls.UploadCall> r1 = com.jumio.core.api.calls.UploadCall.class
            r0.<init>(r1)
            jumio.core.r0 r1 = r9.f57480g
            int r1 = r1.getUpload()
            r0.setTimeout(r1)
            java.util.HashMap r1 = r0.getData()
            java.lang.String r2 = "DATA_UPLOAD_TYPE"
            java.lang.String r3 = "DATA_UPLOAD_TYPE_DEFAULT"
            r1.put(r2, r3)
            java.util.HashMap r1 = r0.getData()
            jumio.core.l r10 = r10.getData$jumio_core_release()
            java.lang.String r10 = r10.mo148671e()
            java.lang.String r2 = "DATA_CREDENTIAL_ID"
            r1.put(r2, r10)
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            com.jumio.sdk.enums.JumioScanSide r1 = r11.getSide()
            int[] r2 = com.jumio.core.api.BackendManager.C20945a.f57483a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L_0x0068
            if (r1 == r2) goto L_0x0065
            r4 = 3
            if (r1 == r4) goto L_0x0062
            r4 = 4
            if (r1 == r4) goto L_0x005f
            r4 = 5
            if (r1 != r4) goto L_0x0059
            com.jumio.core.enums.b r1 = com.jumio.core.enums.C20953b.FRONTSIDE
            goto L_0x006a
        L_0x0059:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L_0x005f:
            com.jumio.core.enums.b r1 = com.jumio.core.enums.C20953b.f57547d
            goto L_0x006a
        L_0x0062:
            com.jumio.core.enums.b r1 = com.jumio.core.enums.C20953b.BACKSIDE
            goto L_0x006a
        L_0x0065:
            com.jumio.core.enums.b r1 = com.jumio.core.enums.C20953b.FRONTSIDE
            goto L_0x006a
        L_0x0068:
            com.jumio.core.enums.b r1 = com.jumio.core.enums.C20953b.FRONTSIDE
        L_0x006a:
            r10.put(r1, r11)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            boolean r4 = r11 instanceof com.jumio.core.models.IDScanPartModel
            r5 = 0
            r6 = 0
            if (r4 == 0) goto L_0x00da
            r4 = r11
            com.jumio.core.models.IDScanPartModel r4 = (com.jumio.core.models.IDScanPartModel) r4
            com.jumio.core.models.DocumentDataModel r7 = r4.getDocumentData()
            if (r7 != 0) goto L_0x0082
            goto L_0x0085
        L_0x0082:
            r7.fillRequest(r1, r11)
        L_0x0085:
            com.jumio.core.util.b r11 = com.jumio.core.util.C20998b.f57834a
            com.jumio.core.models.SelectionModel r7 = r4.getSelectionModel()
            com.jumio.core.data.document.DocumentType r7 = r7.getDocumentType()
            com.jumio.sdk.document.JumioDocumentType r7 = r7.getIdType()
            java.lang.String r7 = r7.name()
            java.lang.String r8 = "idType"
            r11.mo172492a(r1, r8, r7)
            com.jumio.core.models.SelectionModel r7 = r4.getSelectionModel()
            com.jumio.core.data.document.DocumentVariant r7 = r7.getVariant()
            com.jumio.sdk.document.JumioDocumentVariant r7 = r7.getVariant()
            java.lang.String r7 = r7.name()
            java.lang.String r8 = "documentVariant"
            r11.mo172492a(r1, r8, r7)
            com.jumio.core.models.DocumentDataModel r7 = r4.getDocumentData()
            if (r7 != 0) goto L_0x00b9
            r7 = r5
            goto L_0x00bd
        L_0x00b9:
            java.lang.String r7 = r7.getIssuingCountry()
        L_0x00bd:
            if (r7 == 0) goto L_0x00c9
            int r8 = r7.length()
            if (r8 != 0) goto L_0x00c6
            goto L_0x00c7
        L_0x00c6:
            r3 = 0
        L_0x00c7:
            if (r3 == 0) goto L_0x00d5
        L_0x00c9:
            com.jumio.core.models.SelectionModel r3 = r4.getSelectionModel()
            com.jumio.core.data.country.Country r3 = r3.getCountry()
            java.lang.String r7 = r3.getIsoCode()
        L_0x00d5:
            java.lang.String r3 = "issuingCountry"
            r11.mo172492a(r1, r3, r7)
        L_0x00da:
            int r11 = r1.length()
            if (r11 == 0) goto L_0x00ee
            com.jumio.core.enums.b r11 = com.jumio.core.enums.C20953b.DATA
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "json.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r10.put(r11, r1)
        L_0x00ee:
            java.util.HashMap r11 = r0.getData()
            java.lang.String r1 = "DATA_PARTS"
            r11.put(r1, r10)
            m43690a(r9, r0, r6, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.api.BackendManager.uploadPart(com.jumio.sdk.credentials.JumioCredential, com.jumio.core.models.ScanPartModel):void");
    }

    public final void usability(String str) {
        Intrinsics.checkNotNullParameter(str, "resultKey");
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(UsabilityCall.class);
        apiCallDataModel.setTimeout(this.f57480g.getUsability());
        apiCallDataModel.getData().put("DATA_RESULT_KEY", str);
        m43690a(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void validateIproovToken() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(IproovValidateCall.class);
        apiCallDataModel.setTimeout(this.f57480g.getIproovvalidate());
        m43690a(this, apiCallDataModel, false, 2, (Object) null);
    }

    /* renamed from: a */
    public final void mo171933a(ApiCallDataModel<?> apiCallDataModel, boolean z) {
        if (z) {
            this.f57478e.mo171957a(apiCallDataModel);
        } else {
            this.f57477d.mo171965a(apiCallDataModel);
        }
    }
}
