package com.jumio.core.scanpart;

import android.os.Handler;
import android.os.Looper;
import com.didi.component.comp_xpanel.XPanelScene;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.core.Controller;
import com.jumio.core.data.ScanMode;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.core.plugins.C20991a;
import com.jumio.core.plugins.ExtractionPlugin;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioAnimationView;
import java.util.HashMap;
import jumio.core.C19484j0;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B'\u0012\u0006\u00101\u001a\u00020,\u0012\u0006\u00107\u001a\u000202\u0012\u0006\u0010<\u001a\u00028\u0000\u0012\u0006\u0010B\u001a\u00020=¢\u0006\u0004\b[\u0010\\J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0004J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0004J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0004J\u001c\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0004J$\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0004J(\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0004J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0004J\b\u0010\u0019\u001a\u00020\u0005H\u0014J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0017J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0017J\b\u0010\u001f\u001a\u00020\u0005H\u0017J\b\u0010 \u001a\u00020\u0005H\u0017J\b\u0010!\u001a\u00020\u0005H\u0017J-\u0010(\u001a\u00020\u00052#\u0010'\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00050\"H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H&R\u0019\u00101\u001a\u00020,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00107\u001a\u0002028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0019\u0010<\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0019\u0010B\u001a\u00020=8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001c\u0010H\u001a\u00020C8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR*\u0010M\u001a\u00020I2\u0006\u0010J\u001a\u00020I8\u0006@DX\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020Q8D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020I8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bU\u0010NR\u0016\u0010W\u001a\u00020I8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bV\u0010NR\u0016\u0010\u0016\u001a\u00020X8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bY\u0010Z¨\u0006]"}, mo148868d2 = {"Lcom/jumio/core/scanpart/ScanPart;", "Lcom/jumio/core/models/ScanPartModel;", "T", "", "Lkotlin/Function0;", "", "task", "onUi", "post", "async", "Lcom/jumio/sdk/enums/JumioScanUpdate;", "scanUpdate", "data", "sendUpdate", "", "time", "sendUpdateThrottled", "Lcom/jumio/sdk/enums/JumioScanStep;", "scanStep", "analytics", "sendScanStep", "Lcom/jumio/core/data/ScanMode;", "scanMode", "Lcom/jumio/core/plugins/a$c;", "getScanPluginMode", "reset", "persist", "start", "Lcom/jumio/sdk/retry/JumioRetryReason;", "reason", "retry", "fallback", "cancel", "finish", "Lkotlin/Function1;", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "Lkotlin/ParameterName;", "name", "addonScanPart", "complete", "checkForAddon", "Lcom/jumio/sdk/views/JumioAnimationView;", "animationView", "getHelpAnimation", "Lcom/jumio/core/Controller;", "a", "Lcom/jumio/core/Controller;", "getController", "()Lcom/jumio/core/Controller;", "controller", "Lcom/jumio/sdk/credentials/JumioCredential;", "b", "Lcom/jumio/sdk/credentials/JumioCredential;", "getCredential", "()Lcom/jumio/sdk/credentials/JumioCredential;", "credential", "c", "Lcom/jumio/core/models/ScanPartModel;", "getScanPartModel", "()Lcom/jumio/core/models/ScanPartModel;", "scanPartModel", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "d", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "getScanPartInterface", "()Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "scanPartInterface", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "getUiHandler$jumio_core_release", "()Landroid/os/Handler;", "uiHandler", "", "<set-?>", "g", "Z", "isComplete", "()Z", "setComplete", "(Z)V", "Lcom/jumio/analytics/MetaInfo;", "getAnalyticsScanData", "()Lcom/jumio/analytics/MetaInfo;", "analyticsScanData", "isCancelable", "getHasFallback", "hasFallback", "Lcom/jumio/sdk/enums/JumioScanMode;", "getScanMode", "()Lcom/jumio/sdk/enums/JumioScanMode;", "<init>", "(Lcom/jumio/core/Controller;Lcom/jumio/sdk/credentials/JumioCredential;Lcom/jumio/core/models/ScanPartModel;Lcom/jumio/sdk/interfaces/JumioScanPartInterface;)V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: ScanPart.kt */
public abstract class ScanPart<T extends ScanPartModel> {

    /* renamed from: a */
    public final Controller f57826a;

    /* renamed from: b */
    public final JumioCredential f57827b;

    /* renamed from: c */
    public final T f57828c;

    /* renamed from: d */
    public final JumioScanPartInterface f57829d;

    /* renamed from: e */
    public HashMap<JumioScanUpdate, Long> f57830e = new HashMap<>();

    /* renamed from: f */
    public final Handler f57831f = new Handler(Looper.getMainLooper());

    /* renamed from: g */
    public boolean f57832g;

    /* renamed from: com.jumio.core.scanpart.ScanPart$a */
    /* compiled from: ScanPart.kt */
    public /* synthetic */ class C20996a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f57833a;

        static {
            int[] iArr = new int[ScanMode.values().length];
            iArr[ScanMode.MRP.ordinal()] = 1;
            iArr[ScanMode.MRV.ordinal()] = 2;
            iArr[ScanMode.MRV_A.ordinal()] = 3;
            iArr[ScanMode.MRV_B.ordinal()] = 4;
            iArr[ScanMode.TD1.ordinal()] = 5;
            iArr[ScanMode.TD2.ordinal()] = 6;
            iArr[ScanMode.CNIS.ordinal()] = 7;
            iArr[ScanMode.PDF417.ordinal()] = 8;
            iArr[ScanMode.FACE_MANUAL.ordinal()] = 9;
            iArr[ScanMode.MANUAL.ordinal()] = 10;
            iArr[ScanMode.NFC.ordinal()] = 11;
            iArr[ScanMode.LINEFINDER.ordinal()] = 12;
            iArr[ScanMode.FACE_IPROOV.ordinal()] = 13;
            f57833a = iArr;
        }
    }

    public ScanPart(Controller controller, JumioCredential jumioCredential, T t, JumioScanPartInterface jumioScanPartInterface) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(jumioCredential, "credential");
        Intrinsics.checkNotNullParameter(t, "scanPartModel");
        Intrinsics.checkNotNullParameter(jumioScanPartInterface, "scanPartInterface");
        this.f57826a = controller;
        this.f57827b = jumioCredential;
        this.f57828c = t;
        this.f57829d = jumioScanPartInterface;
        if (this instanceof ApiBinding) {
            controller.getBackendManager().addBinding((ApiBinding) this);
        }
    }

    /* renamed from: a */
    public static final void m43824a(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$task");
        function0.invoke();
    }

    /* renamed from: b */
    public static final void m43825b(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$task");
        function0.invoke();
    }

    /* renamed from: c */
    public static final void m43826c(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$task");
        function0.invoke();
    }

    public static /* synthetic */ void sendScanStep$default(ScanPart scanPart, JumioScanStep jumioScanStep, Object obj, Object obj2, int i, Object obj3) {
        if (obj3 == null) {
            if ((i & 2) != 0) {
                obj = null;
            }
            if ((i & 4) != 0) {
                obj2 = obj;
            }
            scanPart.sendScanStep(jumioScanStep, obj, obj2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendScanStep");
    }

    public static /* synthetic */ void sendUpdate$default(ScanPart scanPart, JumioScanUpdate jumioScanUpdate, Object obj, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 2) != 0) {
                obj = null;
            }
            scanPart.sendUpdate(jumioScanUpdate, obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendUpdate");
    }

    public static /* synthetic */ void sendUpdateThrottled$default(ScanPart scanPart, int i, JumioScanUpdate jumioScanUpdate, Object obj, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 4) != 0) {
                obj = null;
            }
            scanPart.sendUpdateThrottled(i, jumioScanUpdate, obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendUpdateThrottled");
    }

    public final void async(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "task");
        new Thread(new Runnable() {
            public final void run() {
                ScanPart.m43824a(Function0.this);
            }
        }).start();
    }

    public void cancel() {
        Analytics.Companion.add(MobileEvents.userAction("cancel", this.f57828c.getScanStep(), this.f57828c.getSide().name()));
        C19484j0 j0Var = (C19484j0) this.f57826a.getDataManager().get(C19484j0.class);
        j0Var.mo148650a(getCredential().getData$jumio_core_release().mo148671e(), getScanPartModel().getSide());
        j0Var.mo148648a(getScanPartModel().getScanStep());
        j0Var.mo148647a(getScanPartModel().getSide());
        j0Var.mo148646a(getScanPartModel().getMode());
        if (this instanceof ApiBinding) {
            this.f57826a.getBackendManager().removeBinding((ApiBinding) this);
        }
    }

    public void checkForAddon(Function1<? super JumioScanPart, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "complete");
        function1.invoke(null);
    }

    public void fallback() {
        Analytics.Companion.add(MobileEvents.userAction("fallback", this.f57828c.getScanStep(), this.f57828c.getSide().name()));
    }

    public void finish() {
        Analytics.Companion.add(MobileEvents.userAction(XPanelScene.SCENE_FINISH, this.f57828c.getScanStep(), this.f57828c.getSide().name()));
        ((C19484j0) this.f57826a.getDataManager().get(C19484j0.class)).mo148650a(this.f57827b.getData$jumio_core_release().mo148671e(), this.f57828c.getSide());
        if (this instanceof ApiBinding) {
            this.f57826a.getBackendManager().removeBinding((ApiBinding) this);
        }
    }

    public final MetaInfo getAnalyticsScanData() {
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("side", this.f57828c.getSide().toString());
        metaInfo.put("type", getScanPluginMode(this.f57828c.getMode()).toString());
        return metaInfo;
    }

    public final Controller getController() {
        return this.f57826a;
    }

    public final JumioCredential getCredential() {
        return this.f57827b;
    }

    public abstract boolean getHasFallback();

    public abstract void getHelpAnimation(JumioAnimationView jumioAnimationView);

    public abstract JumioScanMode getScanMode();

    public final JumioScanPartInterface getScanPartInterface() {
        return this.f57829d;
    }

    public final T getScanPartModel() {
        return this.f57828c;
    }

    public final C20991a.C20994c getScanPluginMode(ScanMode scanMode) {
        Intrinsics.checkNotNullParameter(scanMode, "scanMode");
        switch (C20996a.f57833a[scanMode.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return C20991a.C20994c.MRZ;
            case 8:
                C20991a.C20994c cVar = C20991a.C20994c.BARCODE;
                ExtractionPlugin extractionPlugin = (ExtractionPlugin) C20991a.m43783b(cVar);
                if (extractionPlugin == null || !extractionPlugin.isUsable(this.f57826a, this.f57828c)) {
                    return C20991a.C20994c.BARCODE_NATIVE;
                }
                return cVar;
            case 9:
                return C20991a.C20994c.FACE_MANUAL;
            case 10:
                return C20991a.C20994c.MANUAL;
            case 11:
                return C20991a.C20994c.NFC;
            case 12:
                return C20991a.C20994c.LINEFINDER;
            case 13:
                return C20991a.C20994c.FACE_IPROOV;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final Handler getUiHandler$jumio_core_release() {
        return this.f57831f;
    }

    public abstract boolean isCancelable();

    public final boolean isComplete() {
        return this.f57832g;
    }

    public final void onUi(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "task");
        if (Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper())) {
            function0.invoke();
        } else {
            this.f57831f.post(new Runnable() {
                public final void run() {
                    ScanPart.m43825b(Function0.this);
                }
            });
        }
    }

    public void persist() {
    }

    public final void post(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "task");
        this.f57831f.post(new Runnable() {
            public final void run() {
                ScanPart.m43826c(Function0.this);
            }
        });
    }

    public void reset() {
        this.f57828c.getImageData().clear();
    }

    public void retry(JumioRetryReason jumioRetryReason) {
        Intrinsics.checkNotNullParameter(jumioRetryReason, "reason");
        int code = jumioRetryReason.getCode();
        JumioRetryReason lastRetryReason = this.f57828c.getLastRetryReason();
        if (lastRetryReason != null && code == lastRetryReason.getCode()) {
            this.f57828c.setLastRetryReason((JumioRetryReason) null);
            Analytics.Companion.add(MobileEvents.userAction("retry", this.f57828c.getScanStep(), this.f57828c.getSide().name()));
            return;
        }
        throw new IllegalArgumentException("Specified retry reason is not valid".toString());
    }

    public final void sendScanStep(JumioScanStep jumioScanStep, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(jumioScanStep, "scanStep");
        this.f57828c.setScanStep(jumioScanStep);
        if (jumioScanStep == JumioScanStep.RETRY) {
            this.f57828c.setLastRetryReason((JumioRetryReason) obj);
        }
        Analytics.Companion.add(MobileEvents.scanStep(jumioScanStep, obj2));
        this.f57831f.post(new Runnable(jumioScanStep, obj) {
            public final /* synthetic */ JumioScanStep f$1;
            public final /* synthetic */ Object f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                ScanPart.m43822a(ScanPart.this, this.f$1, this.f$2);
            }
        });
    }

    public final void sendUpdate(JumioScanUpdate jumioScanUpdate, Object obj) {
        Intrinsics.checkNotNullParameter(jumioScanUpdate, "scanUpdate");
        this.f57831f.post(new Runnable(jumioScanUpdate, obj) {
            public final /* synthetic */ JumioScanUpdate f$1;
            public final /* synthetic */ Object f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                ScanPart.m43823a(ScanPart.this, this.f$1, this.f$2);
            }
        });
    }

    public final void sendUpdateThrottled(int i, JumioScanUpdate jumioScanUpdate, Object obj) {
        Intrinsics.checkNotNullParameter(jumioScanUpdate, "scanUpdate");
        long currentTimeMillis = System.currentTimeMillis();
        Long l = this.f57830e.get(jumioScanUpdate);
        if (l == null) {
            l = 0L;
        }
        if (l.longValue() + ((long) i) <= currentTimeMillis) {
            this.f57830e.put(jumioScanUpdate, Long.valueOf(currentTimeMillis));
            sendUpdate(jumioScanUpdate, obj);
        }
    }

    public final void setComplete(boolean z) {
        this.f57832g = z;
    }

    public void start() {
        ((C19484j0) this.f57826a.getDataManager().get(C19484j0.class)).mo148652b(this.f57827b.getData$jumio_core_release().mo148671e(), this.f57828c.getSide());
        Analytics.Companion.add(MobileEvents.userAction("start", this.f57828c.getScanStep(), this.f57828c.getSide().name()));
    }

    /* renamed from: a */
    public static final void m43823a(ScanPart scanPart, JumioScanUpdate jumioScanUpdate, Object obj) {
        Intrinsics.checkNotNullParameter(scanPart, "this$0");
        Intrinsics.checkNotNullParameter(jumioScanUpdate, "$scanUpdate");
        scanPart.getScanPartInterface().onUpdate(jumioScanUpdate, obj);
    }

    /* renamed from: a */
    public static final void m43822a(ScanPart scanPart, JumioScanStep jumioScanStep, Object obj) {
        Intrinsics.checkNotNullParameter(scanPart, "this$0");
        Intrinsics.checkNotNullParameter(jumioScanStep, "$scanStep");
        scanPart.getScanPartInterface().onScanStep(jumioScanStep, obj);
    }
}
