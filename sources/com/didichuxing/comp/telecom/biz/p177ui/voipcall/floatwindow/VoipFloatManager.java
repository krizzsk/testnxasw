package com.didichuxing.comp.telecom.biz.p177ui.voipcall.floatwindow;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.comp.telecom.biz.api.VoipBusinessSDK;
import com.didichuxing.comp.telecom.biz.p177ui.voipcall.floatwindow.task.ACallFloatWindowTask;
import com.didichuxing.comp.telecom.biz.p177ui.voipcall.floatwindow.task.CalledFloatWindowTask;
import com.didichuxing.comp.telecom.biz.p177ui.voipcall.floatwindow.task.CallingFloatWindowTask;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManager;
import com.didichuxing.comp.telecom.core.CallRole;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.base.ICall;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0002J\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fJ\n\u0010 \u001a\u0004\u0018\u00010\rH\u0002J\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020#J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020#H\u0002J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020#H\u0002J\u001e\u0010*\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/VoipFloatManager;", "", "()V", "TAG", "", "<set-?>", "Landroid/content/Context;", "mContext", "getMContext", "()Landroid/content/Context;", "mCurFloatWindowTask", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/task/ACallFloatWindowTask;", "mSp", "Landroid/content/SharedPreferences;", "mStartedCount", "", "mTopActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mVoipCallPage", "bindActivityCallback", "", "context", "buildAndShowFloatWindow", "audioCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "destroyFloatWindowTask", "task", "getCacheFloatLocation", "prefix", "lp", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/CallFloatWindowLayoutParams;", "getMSp", "getTopActivity", "hasVoipCallPage", "", "init", "isAppVisible", "onAppVisibleChange", "visible", "onVoipCallPageShow", "show", "recordFloatLocation", "x", "y", "Companion", "voip-biz_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.VoipFloatManager */
/* compiled from: VoipFloatManager.kt */
public final class VoipFloatManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final Lazy f48986h = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, VoipFloatManager$Companion$sInstance$2.INSTANCE);

    /* renamed from: a */
    private final String f48987a = "VoipFloatManager";

    /* renamed from: b */
    private Context f48988b;

    /* renamed from: c */
    private ACallFloatWindowTask f48989c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WeakReference<Activity> f48990d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f48991e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WeakReference<Activity> f48992f;

    /* renamed from: g */
    private SharedPreferences f48993g;

    @Metadata(mo148866bv = {1, 0, 3}, mo148869k = 3, mo148870mv = {1, 1, 13})
    /* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.VoipFloatManager$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CallRole.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CallRole.CALLEE.ordinal()] = 1;
            $EnumSwitchMapping$0[CallRole.CALL_MAKER.ordinal()] = 2;
        }
    }

    @JvmStatic
    public static final VoipFloatManager getInstance() {
        return Companion.getInstance();
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, mo148868d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/VoipFloatManager$Companion;", "", "()V", "sInstance", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/VoipFloatManager;", "getSInstance", "()Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/VoipFloatManager;", "sInstance$delegate", "Lkotlin/Lazy;", "getInstance", "voip-biz_release"}, mo148869k = 1, mo148870mv = {1, 1, 13})
    /* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.VoipFloatManager$Companion */
    /* compiled from: VoipFloatManager.kt */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(Companion.class), "sInstance", "getSInstance()Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/VoipFloatManager;"))};

        private final VoipFloatManager getSInstance() {
            Lazy access$getSInstance$cp = VoipFloatManager.f48986h;
            Companion companion = VoipFloatManager.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (VoipFloatManager) access$getSInstance$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final VoipFloatManager getInstance() {
            return getSInstance();
        }
    }

    public final void init(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f48988b = context;
        m36747a(context);
    }

    public final Context getMContext() {
        return this.f48988b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36750a(boolean z) {
        if (VoipBusinessSDK.INSTANCE.isInitialized()) {
            VoipAudioCall voipAudioCall = null;
            if (FloatWindowUtils.hasFloatWindowPermission$default(FloatWindowUtils.INSTANCE, (Context) null, 1, (Object) null)) {
                String str = this.f48987a;
                CallLogUtil.logI(str, "onVoipCallPageShow " + z);
                if (z) {
                    m36748a(this.f48989c);
                    return;
                }
                ICall mCurrentCall = CallManager.Companion.getInstance().getMCurrentCall();
                if (mCurrentCall instanceof VoipAudioCall) {
                    voipAudioCall = mCurrentCall;
                }
                VoipAudioCall voipAudioCall2 = voipAudioCall;
                if (voipAudioCall2 != null && voipAudioCall2.getState() != CallState.END_CALL) {
                    CallLogUtil.logI(this.f48987a, "onVoipCallPageShow - show new float");
                    m36749a(voipAudioCall2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m36751b(boolean z) {
        if (VoipBusinessSDK.INSTANCE.isInitialized()) {
            VoipAudioCall voipAudioCall = null;
            boolean z2 = true;
            if (FloatWindowUtils.hasFloatWindowPermission$default(FloatWindowUtils.INSTANCE, (Context) null, 1, (Object) null)) {
                String str = this.f48987a;
                CallLogUtil.logI(str, "onAppVisibleChange " + z);
                ACallFloatWindowTask aCallFloatWindowTask = this.f48989c;
                if (z) {
                    ICall mCurrentCall = CallManager.Companion.getInstance().getMCurrentCall();
                    if (mCurrentCall instanceof VoipAudioCall) {
                        voipAudioCall = mCurrentCall;
                    }
                    VoipAudioCall voipAudioCall2 = voipAudioCall;
                    if (voipAudioCall2 == null || voipAudioCall2.getState() == CallState.END_CALL) {
                        z2 = false;
                    }
                    if (aCallFloatWindowTask == null) {
                        boolean hasVoipCallPage = hasVoipCallPage();
                        if (z2 && !hasVoipCallPage) {
                            CallLogUtil.logI(this.f48987a, "onAppVisibleChange - show new float");
                            if (voipAudioCall2 == null) {
                                Intrinsics.throwNpe();
                            }
                            m36749a(voipAudioCall2);
                        }
                    } else if (z2) {
                        CallLogUtil.logI(this.f48987a, "onAppVisibleChange - show exist float");
                        aCallFloatWindowTask.performHide(false);
                    } else {
                        CallLogUtil.logI(this.f48987a, "onAppVisibleChange - destroy exist float");
                        m36748a(aCallFloatWindowTask);
                    }
                } else if (aCallFloatWindowTask != null) {
                    aCallFloatWindowTask.performHide(true);
                }
            }
        }
    }

    /* renamed from: a */
    private final void m36748a(ACallFloatWindowTask aCallFloatWindowTask) {
        if (aCallFloatWindowTask != null) {
            aCallFloatWindowTask.performDestroy();
            if (Intrinsics.areEqual((Object) this.f48989c, (Object) aCallFloatWindowTask)) {
                this.f48989c = null;
            }
        }
    }

    /* renamed from: a */
    private final void m36749a(VoipAudioCall voipAudioCall) {
        ACallFloatWindowTask aCallFloatWindowTask;
        CallLogUtil.logI(this.f48987a, "buildAndShowFloatWindow");
        if (FloatWindowUtils.INSTANCE.hasFloatWindowPermission(this.f48988b)) {
            int i = WhenMappings.$EnumSwitchMapping$0[voipAudioCall.getRole().ordinal()];
            if (i == 1) {
                aCallFloatWindowTask = new CalledFloatWindowTask(voipAudioCall);
            } else if (i != 2) {
                aCallFloatWindowTask = null;
            } else {
                aCallFloatWindowTask = new CallingFloatWindowTask(voipAudioCall);
            }
            if (aCallFloatWindowTask != null) {
                aCallFloatWindowTask.performShow();
                this.f48989c = aCallFloatWindowTask;
            }
        }
    }

    public final boolean hasVoipCallPage() {
        WeakReference<Activity> weakReference = this.f48990d;
        return (weakReference != null ? (Activity) weakReference.get() : null) != null;
    }

    public final boolean isAppVisible() {
        return this.f48991e > 0;
    }

    public final Activity getTopActivity() {
        WeakReference<Activity> weakReference;
        if (!isAppVisible() || (weakReference = this.f48992f) == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    /* renamed from: a */
    private final void m36747a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            applicationContext = null;
        }
        Application application = (Application) applicationContext;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new VoipFloatManager$bindActivityCallback$1(this));
        }
    }

    /* renamed from: a */
    private final SharedPreferences m36746a() {
        Context context;
        if (this.f48993g == null && (context = this.f48988b) != null) {
            this.f48993g = SystemUtils.getSharedPreferences(context, "voip_cache", 0);
        }
        return this.f48993g;
    }

    public final void recordFloatLocation(String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "prefix");
        SharedPreferences a = m36746a();
        if (a != null) {
            SharedPreferences.Editor edit = a.edit();
            edit.putInt(str + "_x", i);
            edit.putInt(str + "_y", i2);
            edit.commit();
        }
    }

    public final void getCacheFloatLocation(String str, CallFloatWindowLayoutParams callFloatWindowLayoutParams) {
        Intrinsics.checkParameterIsNotNull(str, "prefix");
        Intrinsics.checkParameterIsNotNull(callFloatWindowLayoutParams, "lp");
        SharedPreferences a = m36746a();
        if (a != null) {
            Integer valueOf = Integer.valueOf(a.getInt(str + "_x", -1));
            boolean z = true;
            Integer num = null;
            if (!(valueOf.intValue() >= 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                callFloatWindowLayoutParams.setCacheX(Integer.valueOf(valueOf.intValue()));
            }
            Integer valueOf2 = Integer.valueOf(a.getInt(str + "_y", -1));
            if (valueOf2.intValue() < 0) {
                z = false;
            }
            if (z) {
                num = valueOf2;
            }
            if (num != null) {
                callFloatWindowLayoutParams.setCacheY(Integer.valueOf(num.intValue()));
            }
        }
    }
}
