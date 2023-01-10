package com.jumio.core.api.calls;

import com.google.common.base.Ascii;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.automation.AutomationModel;
import com.jumio.core.network.C20984d;
import java.io.Serializable;
import jumio.core.C19475f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UsabilityCall.kt */
public final class UsabilityCall extends C20984d<AutomationModel> {

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, mo148868d2 = {"Lcom/jumio/core/api/calls/UsabilityCall$Companion;", "", "", "DATA_RESULT_KEY", "Ljava/lang/String;", "<init>", "()V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: UsabilityCall.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        new Companion((DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UsabilityCall(C19475f fVar, ApiCallDataModel<?> apiCallDataModel) {
        super(fVar, apiCallDataModel);
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        if (!apiCallDataModel.getData().containsKey("DATA_RESULT_KEY")) {
            throw new IllegalArgumentException("Result Key is missing".toString());
        }
    }

    /* renamed from: a */
    public AutomationModel parseResponse(String str) {
        Intrinsics.checkNotNullParameter(str, "plainTextAnswer");
        return AutomationModel.f57733d.fromString(str);
    }

    /* renamed from: b */
    public final String mo171981b() {
        Serializable serializable = getApiCallDataModel().getData().get("DATA_RESULT_KEY");
        if (serializable != null) {
            return (String) serializable;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public String getRequest() throws Exception {
        return "";
    }

    public String getUri() {
        return Intrinsics.stringPlus(StringDeobfuscator.deobfuscate(new byte[]{-86, 61, Ascii.f55141FF, -53, 110, -44, -89, 73, 106, -87, -85, 16, 56, -49, -6, -36, 108}, -4685996733232977611L), mo171981b());
    }
}
