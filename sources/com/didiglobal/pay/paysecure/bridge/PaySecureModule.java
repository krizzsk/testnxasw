package com.didiglobal.pay.paysecure.bridge;

import android.text.TextUtils;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didiglobal.pay.paysecure.tmx.TMXProfilingMgr;
import com.didiglobal.pay.paysecure.util.PaySecureLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\f"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/bridge/PaySecureModule;", "Lcom/didi/onehybrid/BaseHybridModule;", "hybridableContainer", "Lcom/didi/onehybrid/container/HybridableContainer;", "(Lcom/didi/onehybrid/container/HybridableContainer;)V", "getTMXSessionId", "", "args", "Lorg/json/JSONObject;", "callback", "Lcom/didi/onehybrid/jsbridge/CallbackFunction;", "Companion", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: PaySecureModule.kt */
public final class PaySecureModule extends BaseHybridModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ModuleName = "PaySecureModule";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaySecureModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        Intrinsics.checkParameterIsNotNull(hybridableContainer, "hybridableContainer");
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/bridge/PaySecureModule$Companion;", "", "()V", "ModuleName", "", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: PaySecureModule.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JsInterface({"getTMXSessionId"})
    public final void getTMXSessionId(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkParameterIsNotNull(callbackFunction, "callback");
        JSONObject jSONObject2 = new JSONObject();
        try {
            String apiSessionId = TMXProfilingMgr.INSTANCE.getApiSessionId();
            if (TextUtils.isEmpty(apiSessionId)) {
                apiSessionId = "";
            }
            jSONObject2.put("result", apiSessionId);
            PaySecureLog paySecureLog = PaySecureLog.INSTANCE;
            paySecureLog.mo129704i("js get sessionId=" + apiSessionId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callbackFunction.onCallBack(jSONObject2);
    }
}
