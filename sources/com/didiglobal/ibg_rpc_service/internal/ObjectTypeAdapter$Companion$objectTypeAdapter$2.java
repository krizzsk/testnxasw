package com.didiglobal.ibg_rpc_service.internal;

import com.google.gson.TypeAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n"}, mo148868d2 = {"<anonymous>", "Lcom/google/gson/TypeAdapter;", "", "kotlin.jvm.PlatformType"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ObjectTypeAdapter.kt */
final class ObjectTypeAdapter$Companion$objectTypeAdapter$2 extends Lambda implements Function0<TypeAdapter<Object>> {
    public static final ObjectTypeAdapter$Companion$objectTypeAdapter$2 INSTANCE = new ObjectTypeAdapter$Companion$objectTypeAdapter$2();

    ObjectTypeAdapter$Companion$objectTypeAdapter$2() {
        super(0);
    }

    public final TypeAdapter<Object> invoke() {
        return ObjectTypeAdapter.Companion.getGson().getAdapter(Object.class);
    }
}
