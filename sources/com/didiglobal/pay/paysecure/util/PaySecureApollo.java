package com.didiglobal.pay.paysecure.util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.google.gson.Gson;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/util/PaySecureApollo;", "", "()V", "ibt_wallet_tmx_api_list_toggle", "", "getTMXApolloApis", "", "getTMXHost", "isOpenTMX", "", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: PaySecureApollo.kt */
public final class PaySecureApollo {
    public static final PaySecureApollo INSTANCE = new PaySecureApollo();

    /* renamed from: a */
    private static final String f52994a = "wallet_ln_session_id_list";

    private PaySecureApollo() {
    }

    public final List<String> getTMXApolloApis() {
        boolean z = false;
        IToggle toggle = Apollo.getToggle(f52994a, false);
        if (!toggle.allow()) {
            return CollectionsKt.emptyList();
        }
        Intrinsics.checkExpressionValueIsNotNull(toggle, "toggle");
        String str = (String) toggle.getExperiment().getParam("list", "");
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            z = true;
        }
        if (z) {
            return CollectionsKt.emptyList();
        }
        try {
            List<String> lists = ((ApiListModel) new Gson().fromJson(str, ApiListModel.class)).getLists();
            if (lists != null) {
                return lists;
            }
            return CollectionsKt.emptyList();
        } catch (Throwable unused) {
            return CollectionsKt.emptyList();
        }
    }

    public final String getTMXHost() {
        IToggle toggle = Apollo.getToggle(f52994a, false);
        if (!toggle.allow()) {
            return "";
        }
        Intrinsics.checkExpressionValueIsNotNull(toggle, "toggle");
        Object param = toggle.getExperiment().getParam("host", "");
        Intrinsics.checkExpressionValueIsNotNull(param, "toggle.experiment.getParam(\"host\", \"\")");
        return (String) param;
    }

    public final boolean isOpenTMX() {
        return Apollo.getToggle(f52994a, false).allow();
    }
}
