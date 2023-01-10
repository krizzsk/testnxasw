package com.adyen.checkout.adyen3ds2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import com.adyen.checkout.adyen3ds2.exception.Authentication3DS2Exception;
import com.adyen.checkout.adyen3ds2.exception.Cancelled3DS2Exception;
import com.adyen.checkout.adyen3ds2.model.ChallengeToken;
import com.adyen.checkout.adyen3ds2.model.FingerprintToken;
import com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository;
import com.adyen.checkout.components.ActionComponentData;
import com.adyen.checkout.components.ActionComponentProvider;
import com.adyen.checkout.components.base.BaseActionComponent;
import com.adyen.checkout.components.base.IntentHandlingComponent;
import com.adyen.checkout.components.encoding.Base64Encoder;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.components.model.payments.response.Threeds2Action;
import com.adyen.checkout.components.model.payments.response.Threeds2ChallengeAction;
import com.adyen.checkout.components.model.payments.response.Threeds2FingerprintAction;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.exception.ComponentException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import com.adyen.checkout.redirect.RedirectDelegate;
import com.adyen.threeds2.AuthenticationRequestParameters;
import com.adyen.threeds2.ChallengeStatusReceiver;
import com.adyen.threeds2.CompletionEvent;
import com.adyen.threeds2.ErrorMessage;
import com.adyen.threeds2.ProtocolErrorEvent;
import com.adyen.threeds2.RuntimeErrorEvent;
import com.adyen.threeds2.ThreeDS2Service;
import com.adyen.threeds2.Transaction;
import com.adyen.threeds2.customization.UiCustomization;
import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.exception.SDKNotInitializedException;
import com.adyen.threeds2.parameters.ChallengeParameters;
import com.adyen.threeds2.parameters.ConfigParameters;
import com.adyen.threeds2.util.AdyenConfigParameters;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo148867d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001MB-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0010H\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u000e\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+J\u0018\u0010,\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J \u0010-\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0010H\u0002J\u0010\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u000203H\u0016J \u00104\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u0016H\u0002J\u001e\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0016J\b\u0010=\u001a\u00020\u001aH\u0014J\u0010\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020@H\u0016J\u0012\u0010A\u001a\u00020\u001a2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010D\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020FH\u0016J\u0012\u0010G\u001a\u00020\u001a2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010H\u001a\u00020\u001a2\b\u0010I\u001a\u0004\u0018\u00010\u0014J!\u00106\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010KJ\b\u0010L\u001a\u00020\u001aH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006N"}, mo148868d2 = {"Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Component;", "Lcom/adyen/checkout/components/base/BaseActionComponent;", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;", "Lcom/adyen/threeds2/ChallengeStatusReceiver;", "Lcom/adyen/checkout/components/base/IntentHandlingComponent;", "application", "Landroid/app/Application;", "configuration", "submitFingerprintRepository", "Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintRepository;", "adyen3DS2Serializer", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Serializer;", "redirectDelegate", "Lcom/adyen/checkout/redirect/RedirectDelegate;", "(Landroid/app/Application;Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;Lcom/adyen/checkout/adyen3ds2/repository/SubmitFingerprintRepository;Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Serializer;Lcom/adyen/checkout/redirect/RedirectDelegate;)V", "authorizationToken", "", "mTransaction", "Lcom/adyen/threeds2/Transaction;", "mUiCustomization", "Lcom/adyen/threeds2/customization/UiCustomization;", "canHandleAction", "", "action", "Lcom/adyen/checkout/components/model/payments/response/Action;", "cancelled", "", "challengeShopper", "activity", "Landroid/app/Activity;", "encodedChallengeToken", "closeTransaction", "context", "Landroid/content/Context;", "completed", "completionEvent", "Lcom/adyen/threeds2/CompletionEvent;", "createChallengeParameters", "Lcom/adyen/threeds2/parameters/ChallengeParameters;", "challenge", "Lcom/adyen/checkout/adyen3ds2/model/ChallengeToken;", "createEncodedFingerprint", "authenticationRequestParameters", "Lcom/adyen/threeds2/AuthenticationRequestParameters;", "handleActionInternal", "handleActionSubtype", "subtype", "Lcom/adyen/checkout/components/model/payments/response/Threeds2Action$SubType;", "token", "handleIntent", "intent", "Landroid/content/Intent;", "identifyShopper", "encodedFingerprintToken", "submitFingerprintAutomatically", "observe", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "Lcom/adyen/checkout/components/ActionComponentData;", "onCleared", "protocolError", "protocolErrorEvent", "Lcom/adyen/threeds2/ProtocolErrorEvent;", "restoreState", "bundle", "Landroid/os/Bundle;", "runtimeError", "runtimeErrorEvent", "Lcom/adyen/threeds2/RuntimeErrorEvent;", "saveState", "setUiCustomization", "uiCustomization", "encodedFingerprint", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timedout", "Companion", "3ds2_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Adyen3DS2Component.kt */
public final class Adyen3DS2Component extends BaseActionComponent<Adyen3DS2Configuration> implements IntentHandlingComponent, ChallengeStatusReceiver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final ActionComponentProvider<Adyen3DS2Component, Adyen3DS2Configuration> PROVIDER = new Adyen3DS2ComponentProvider();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final String f528g;

    /* renamed from: h */
    private static final String f529h = "authorization_token";

    /* renamed from: i */
    private static final int f530i = 10;

    /* renamed from: j */
    private static final String f531j = "2.1.0";

    /* renamed from: k */
    private static boolean f532k;

    /* renamed from: a */
    private final SubmitFingerprintRepository f533a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Adyen3DS2Serializer f534b;

    /* renamed from: c */
    private final RedirectDelegate f535c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Transaction f536d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public UiCustomization f537e;

    /* renamed from: f */
    private String f538f;

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: Adyen3DS2Component.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Threeds2Action.SubType.values().length];
            iArr[Threeds2Action.SubType.FINGERPRINT.ordinal()] = 1;
            iArr[Threeds2Action.SubType.CHALLENGE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Adyen3DS2Component(Application application, Adyen3DS2Configuration adyen3DS2Configuration, SubmitFingerprintRepository submitFingerprintRepository, Adyen3DS2Serializer adyen3DS2Serializer, RedirectDelegate redirectDelegate) {
        super(application, adyen3DS2Configuration);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(adyen3DS2Configuration, "configuration");
        Intrinsics.checkNotNullParameter(submitFingerprintRepository, "submitFingerprintRepository");
        Intrinsics.checkNotNullParameter(adyen3DS2Serializer, "adyen3DS2Serializer");
        Intrinsics.checkNotNullParameter(redirectDelegate, "redirectDelegate");
        this.f533a = submitFingerprintRepository;
        this.f534b = adyen3DS2Serializer;
        this.f535c = redirectDelegate;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        Logger.m1076d(f528g, "onCleared");
        if (this.f536d != null) {
            f532k = true;
        }
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer<ActionComponentData> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.observe(lifecycleOwner, observer);
        if (f532k) {
            Logger.m1078e(f528g, "Lost challenge result reference.");
        }
    }

    public final void setUiCustomization(UiCustomization uiCustomization) {
        this.f537e = uiCustomization;
    }

    public boolean canHandleAction(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return PROVIDER.canHandleAction(action);
    }

    public void saveState(Bundle bundle) {
        if (!(bundle == null || this.f538f == null)) {
            if (bundle.containsKey(f529h)) {
                Logger.m1076d(f528g, "bundle already has authorizationToken, overriding");
            }
            bundle.putString(f529h, this.f538f);
        }
        super.saveState(bundle);
    }

    public void restoreState(Bundle bundle) {
        if (bundle != null && bundle.containsKey(f529h) && this.f538f == null) {
            this.f538f = bundle.getString(f529h);
        }
        super.restoreState(bundle);
    }

    /* access modifiers changed from: protected */
    public void handleActionInternal(Activity activity, Action action) throws ComponentException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(action, "action");
        boolean z = true;
        String str = "";
        if (action instanceof Threeds2FingerprintAction) {
            Threeds2FingerprintAction threeds2FingerprintAction = (Threeds2FingerprintAction) action;
            CharSequence token = threeds2FingerprintAction.getToken();
            if (!(token == null || token.length() == 0)) {
                z = false;
            }
            if (!z) {
                String token2 = threeds2FingerprintAction.getToken();
                if (token2 != null) {
                    str = token2;
                }
                m1029a(activity, str, false);
                return;
            }
            throw new ComponentException("Fingerprint token not found.");
        } else if (action instanceof Threeds2ChallengeAction) {
            Threeds2ChallengeAction threeds2ChallengeAction = (Threeds2ChallengeAction) action;
            CharSequence token3 = threeds2ChallengeAction.getToken();
            if (!(token3 == null || token3.length() == 0)) {
                z = false;
            }
            if (!z) {
                String token4 = threeds2ChallengeAction.getToken();
                if (token4 != null) {
                    str = token4;
                }
                m1028a(activity, str);
                return;
            }
            throw new ComponentException("Challenge token not found.");
        } else if (action instanceof Threeds2Action) {
            Threeds2Action threeds2Action = (Threeds2Action) action;
            CharSequence token5 = threeds2Action.getToken();
            if (!(token5 == null || token5.length() == 0)) {
                z = false;
            }
            if (z) {
                throw new ComponentException("3DS2 token not found.");
            } else if (threeds2Action.getSubtype() != null) {
                Threeds2Action.SubType.Companion companion = Threeds2Action.SubType.Companion;
                String subtype = threeds2Action.getSubtype();
                if (subtype == null) {
                    subtype = str;
                }
                Threeds2Action.SubType parse = companion.parse(subtype);
                this.f538f = threeds2Action.getAuthorisationToken();
                String token6 = threeds2Action.getToken();
                if (token6 != null) {
                    str = token6;
                }
                m1027a(activity, parse, str);
            } else {
                throw new ComponentException("3DS2 Action subtype not found.");
            }
        }
    }

    /* renamed from: a */
    private final void m1027a(Activity activity, Threeds2Action.SubType subType, String str) {
        int i = WhenMappings.$EnumSwitchMapping$0[subType.ordinal()];
        if (i == 1) {
            m1029a(activity, str, true);
        } else if (i == 2) {
            m1028a(activity, str);
        }
    }

    public void completed(CompletionEvent completionEvent) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(completionEvent, "completionEvent");
        Logger.m1076d(f528g, "challenge completed");
        try {
            String str = this.f538f;
            if (str == null) {
                jSONObject = this.f534b.createChallengeDetails(completionEvent);
            } else {
                jSONObject = this.f534b.createThreeDsResultDetails(completionEvent, str);
            }
            notifyDetails(jSONObject);
        } catch (CheckoutException e) {
            notifyException(e);
        } catch (Throwable th) {
            Application application = getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
            m1030a((Context) application);
            throw th;
        }
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "getApplication()");
        m1030a((Context) application2);
    }

    public void cancelled() {
        Logger.m1076d(f528g, "challenge cancelled");
        notifyException(new Cancelled3DS2Exception("Challenge canceled."));
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        m1030a((Context) application);
    }

    public void timedout() {
        Logger.m1076d(f528g, "challenge timed out");
        notifyException(new Authentication3DS2Exception("Challenge timed out."));
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        m1030a((Context) application);
    }

    public void protocolError(ProtocolErrorEvent protocolErrorEvent) {
        Intrinsics.checkNotNullParameter(protocolErrorEvent, "protocolErrorEvent");
        ErrorMessage errorMessage = protocolErrorEvent.getErrorMessage();
        String str = f528g;
        Logger.m1078e(str, "protocolError - " + errorMessage.getErrorCode() + " - " + errorMessage.getErrorDescription() + " - " + errorMessage.getErrorDetails());
        notifyException(new Authentication3DS2Exception(Intrinsics.stringPlus("Protocol Error - ", errorMessage)));
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        m1030a((Context) application);
    }

    public void runtimeError(RuntimeErrorEvent runtimeErrorEvent) {
        Intrinsics.checkNotNullParameter(runtimeErrorEvent, "runtimeErrorEvent");
        Logger.m1076d(f528g, "runtimeError");
        notifyException(new Authentication3DS2Exception(Intrinsics.stringPlus("Runtime Error - ", runtimeErrorEvent.getErrorMessage())));
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        m1030a((Context) application);
    }

    /* renamed from: a */
    private final void m1029a(Activity activity, String str, boolean z) throws ComponentException {
        Logger.m1076d(f528g, Intrinsics.stringPlus("identifyShopper - submitFingerprintAutomatically: ", Boolean.valueOf(z)));
        String decode = Base64Encoder.decode(str);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(encodedFingerprintToken)");
        try {
            FingerprintToken deserialize = FingerprintToken.SERIALIZER.deserialize(new JSONObject(decode));
            Intrinsics.checkNotNullExpressionValue(deserialize, "SERIALIZER.deserialize(fingerprintJson)");
            FingerprintToken fingerprintToken = deserialize;
            ConfigParameters build = new AdyenConfigParameters.Builder(fingerprintToken.getDirectoryServerId(), fingerprintToken.getDirectoryServerPublicKey()).build();
            CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
            Job unused = C2746d.m5821a(viewModelScope, Dispatchers.getDefault().plus(new C1295x95519ee2(CoroutineExceptionHandler.Key, this)), (CoroutineStart) null, new Adyen3DS2Component$identifyShopper$1(activity, build, this, fingerprintToken, z, (Continuation<? super Adyen3DS2Component$identifyShopper$1>) null), 2, (Object) null);
        } catch (JSONException e) {
            throw new ComponentException("JSON parsing of FingerprintToken failed", e);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0069 A[Catch:{ ComponentException -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086 A[Catch:{ ComponentException -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1026a(android.app.Activity r8, java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.adyen.checkout.adyen3ds2.Adyen3DS2Component$submitFingerprintAutomatically$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.adyen.checkout.adyen3ds2.Adyen3DS2Component$submitFingerprintAutomatically$1 r0 = (com.adyen.checkout.adyen3ds2.Adyen3DS2Component$submitFingerprintAutomatically$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.adyen.checkout.adyen3ds2.Adyen3DS2Component$submitFingerprintAutomatically$1 r0 = new com.adyen.checkout.adyen3ds2.Adyen3DS2Component$submitFingerprintAutomatically$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r8 = r0.L$1
            android.app.Activity r8 = (android.app.Activity) r8
            java.lang.Object r9 = r0.L$0
            com.adyen.checkout.adyen3ds2.Adyen3DS2Component r9 = (com.adyen.checkout.adyen3ds2.Adyen3DS2Component) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ ComponentException -> 0x0032 }
            goto L_0x005f
        L_0x0032:
            r8 = move-exception
            goto L_0x00a8
        L_0x0035:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository r10 = r7.f533a     // Catch:{ ComponentException -> 0x00a6 }
            com.adyen.checkout.components.base.Configuration r2 = r7.getConfiguration()     // Catch:{ ComponentException -> 0x00a6 }
            java.lang.String r4 = "configuration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ ComponentException -> 0x00a6 }
            com.adyen.checkout.adyen3ds2.Adyen3DS2Configuration r2 = (com.adyen.checkout.adyen3ds2.Adyen3DS2Configuration) r2     // Catch:{ ComponentException -> 0x00a6 }
            java.lang.String r4 = r7.getPaymentData()     // Catch:{ ComponentException -> 0x00a6 }
            r0.L$0 = r7     // Catch:{ ComponentException -> 0x00a6 }
            r0.L$1 = r8     // Catch:{ ComponentException -> 0x00a6 }
            r0.label = r3     // Catch:{ ComponentException -> 0x00a6 }
            java.lang.Object r10 = r10.submitFingerprint(r9, r2, r4, r0)     // Catch:{ ComponentException -> 0x00a6 }
            if (r10 != r1) goto L_0x005e
            return r1
        L_0x005e:
            r9 = r7
        L_0x005f:
            com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult r10 = (com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult) r10     // Catch:{ ComponentException -> 0x0032 }
            r0 = 0
            r9.setPaymentData(r0)     // Catch:{ ComponentException -> 0x0032 }
            boolean r1 = r10 instanceof com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult.Completed     // Catch:{ ComponentException -> 0x0032 }
            if (r1 == 0) goto L_0x0086
            r8 = r9
            androidx.lifecycle.ViewModel r8 = (androidx.lifecycle.ViewModel) r8     // Catch:{ ComponentException -> 0x0032 }
            kotlinx.coroutines.CoroutineScope r1 = androidx.lifecycle.ViewModelKt.getViewModelScope(r8)     // Catch:{ ComponentException -> 0x0032 }
            kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ ComponentException -> 0x0032 }
            r2 = r8
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2     // Catch:{ ComponentException -> 0x0032 }
            r3 = 0
            com.adyen.checkout.adyen3ds2.Adyen3DS2Component$submitFingerprintAutomatically$2 r8 = new com.adyen.checkout.adyen3ds2.Adyen3DS2Component$submitFingerprintAutomatically$2     // Catch:{ ComponentException -> 0x0032 }
            r8.<init>(r9, r10, r0)     // Catch:{ ComponentException -> 0x0032 }
            r4 = r8
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ ComponentException -> 0x0032 }
            r5 = 2
            r6 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.C2746d.m5821a(r1, r2, r3, r4, r5, r6)     // Catch:{ ComponentException -> 0x0032 }
            goto L_0x00ad
        L_0x0086:
            boolean r0 = r10 instanceof com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult.Redirect     // Catch:{ ComponentException -> 0x0032 }
            if (r0 == 0) goto L_0x0096
            com.adyen.checkout.redirect.RedirectDelegate r0 = r9.f535c     // Catch:{ ComponentException -> 0x0032 }
            com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult$Redirect r10 = (com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult.Redirect) r10     // Catch:{ ComponentException -> 0x0032 }
            com.adyen.checkout.components.model.payments.response.RedirectAction r10 = r10.getAction()     // Catch:{ ComponentException -> 0x0032 }
            r0.makeRedirect((android.app.Activity) r8, (com.adyen.checkout.components.model.payments.response.RedirectAction) r10)     // Catch:{ ComponentException -> 0x0032 }
            goto L_0x00ad
        L_0x0096:
            boolean r0 = r10 instanceof com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult.Threeds2     // Catch:{ ComponentException -> 0x0032 }
            if (r0 == 0) goto L_0x00ad
            com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult$Threeds2 r10 = (com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult.Threeds2) r10     // Catch:{ ComponentException -> 0x0032 }
            com.adyen.checkout.components.model.payments.response.Threeds2Action r10 = r10.getAction()     // Catch:{ ComponentException -> 0x0032 }
            com.adyen.checkout.components.model.payments.response.Action r10 = (com.adyen.checkout.components.model.payments.response.Action) r10     // Catch:{ ComponentException -> 0x0032 }
            r9.handleAction(r8, r10)     // Catch:{ ComponentException -> 0x0032 }
            goto L_0x00ad
        L_0x00a6:
            r8 = move-exception
            r9 = r7
        L_0x00a8:
            com.adyen.checkout.core.exception.CheckoutException r8 = (com.adyen.checkout.core.exception.CheckoutException) r8
            r9.notifyException(r8)
        L_0x00ad:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.adyen3ds2.Adyen3DS2Component.m1026a(android.app.Activity, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: a */
    private final void m1028a(Activity activity, String str) throws ComponentException {
        Logger.m1076d(f528g, "challengeShopper");
        if (this.f536d == null) {
            notifyException(new Authentication3DS2Exception("Failed to make challenge, missing reference to initial transaction."));
            return;
        }
        String decode = Base64Encoder.decode(str);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(encodedChallengeToken)");
        try {
            ChallengeToken deserialize = ChallengeToken.SERIALIZER.deserialize(new JSONObject(decode));
            Intrinsics.checkNotNullExpressionValue(deserialize, "SERIALIZER.deserialize(challengeTokenJson)");
            ChallengeParameters a = m1025a(deserialize);
            try {
                Transaction transaction = this.f536d;
                if (transaction != null) {
                    transaction.doChallenge(activity, a, this, 10);
                }
            } catch (InvalidInputException e) {
                notifyException(new CheckoutException("Error starting challenge", e));
            }
        } catch (JSONException e2) {
            throw new ComponentException("JSON parsing of FingerprintToken failed", e2);
        }
    }

    public final String createEncodedFingerprint(AuthenticationRequestParameters authenticationRequestParameters) throws ComponentException {
        Intrinsics.checkNotNullParameter(authenticationRequestParameters, "authenticationRequestParameters");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdkAppID", authenticationRequestParameters.getSDKAppID());
            jSONObject.put("sdkEncData", authenticationRequestParameters.getDeviceData());
            jSONObject.put("sdkEphemPubKey", new JSONObject(authenticationRequestParameters.getSDKEphemeralPublicKey()));
            jSONObject.put("sdkReferenceNumber", authenticationRequestParameters.getSDKReferenceNumber());
            jSONObject.put("sdkTransID", authenticationRequestParameters.getSDKTransactionID());
            jSONObject.put("messageVersion", authenticationRequestParameters.getMessageVersion());
            String encode = Base64Encoder.encode(jSONObject.toString());
            Intrinsics.checkNotNullExpressionValue(encode, "encode(fingerprintJson.toString())");
            return encode;
        } catch (JSONException e) {
            throw new ComponentException("Failed to create encoded fingerprint", e);
        }
    }

    /* renamed from: a */
    private final ChallengeParameters m1025a(ChallengeToken challengeToken) {
        ChallengeParameters challengeParameters = new ChallengeParameters();
        challengeParameters.set3DSServerTransactionID(challengeToken.getThreeDSServerTransID());
        challengeParameters.setAcsTransactionID(challengeToken.getAcsTransID());
        challengeParameters.setAcsRefNumber(challengeToken.getAcsReferenceNumber());
        challengeParameters.setAcsSignedContent(challengeToken.getAcsSignedContent());
        if (!Intrinsics.areEqual((Object) challengeToken.getMessageVersion(), (Object) f531j)) {
            challengeParameters.setThreeDSRequestorAppURL(ChallengeParameters.getEmbeddedRequestorAppURL(getApplication()));
        }
        return challengeParameters;
    }

    /* renamed from: a */
    private final void m1030a(Context context) {
        Transaction transaction = this.f536d;
        if (transaction != null) {
            transaction.close();
        }
        this.f536d = null;
        try {
            ThreeDS2Service.INSTANCE.cleanup(context);
        } catch (SDKNotInitializedException unused) {
        }
    }

    public void handleIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            notifyDetails(this.f535c.handleRedirectResponse(intent.getData()));
        } catch (CheckoutException e) {
            notifyException(e);
        }
    }

    @Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo148868d2 = {"Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Component$Companion;", "", "()V", "AUTHORIZATION_TOKEN_KEY", "", "DEFAULT_CHALLENGE_TIME_OUT", "", "PROTOCOL_VERSION_2_1_0", "PROVIDER", "Lcom/adyen/checkout/components/ActionComponentProvider;", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Component;", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;", "TAG", "sGotDestroyedWhileChallenging", "", "3ds2_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: Adyen3DS2Component.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String tag = LogUtil.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "getTag()");
        f528g = tag;
    }
}
