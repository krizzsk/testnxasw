package com.didi.soda.customer.blocks;

import com.didi.soda.blocks.parse.NodeBuilderOld;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000¨\u0006\u0002"}, mo148868d2 = {"filterInvalidValue", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 2, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BlockExtension.kt */
public final class BlockExtensionKt {
    public static final Object filterInvalidValue(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        boolean z = obj instanceof String;
        if (z) {
            String str = (String) obj;
            if (StringsKt.startsWith$default(str, NodeBuilderOld.PROPS_NATIVE_SPLIT_START, false, 2, (Object) null) && StringsKt.endsWith$default(str, "}", false, 2, (Object) null)) {
                return null;
            }
        }
        if (z) {
            String str2 = (String) obj;
            if (!StringsKt.startsWith$default(str2, "{{$invoke.", false, 2, (Object) null) || !StringsKt.endsWith$default(str2, "}}", false, 2, (Object) null)) {
                return obj;
            }
            return null;
        }
        return obj;
    }
}
