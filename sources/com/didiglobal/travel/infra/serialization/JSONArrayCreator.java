package com.didiglobal.travel.infra.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u000f*\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, mo148868d2 = {"Lcom/didiglobal/travel/infra/serialization/JSONArrayCreator;", "T", "", "json", "Lorg/json/JSONArray;", "constructor-impl", "(Lorg/json/JSONArray;)Lorg/json/JSONArray;", "equals", "", "other", "hashCode", "", "toString", "", "element", "", "element-impl", "(Lorg/json/JSONArray;Ljava/lang/String;Ljava/lang/Object;)V", "elementNotNull", "elementNotNull-impl", "lib-common_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
@JsonDslMarker
/* compiled from: JSON.kt */
public final class JSONArrayCreator<T> {

    /* renamed from: a */
    private final JSONArray f53982a;

    /* renamed from: constructor-impl  reason: not valid java name */
    public static JSONArray m47593constructorimpl(JSONArray jSONArray) {
        Intrinsics.checkParameterIsNotNull(jSONArray, "json");
        return jSONArray;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47596equalsimpl(JSONArray jSONArray, Object obj) {
        return (obj instanceof JSONArrayCreator) && Intrinsics.areEqual((Object) jSONArray, (Object) ((JSONArrayCreator) obj).m47600unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47597equalsimpl0(JSONArray jSONArray, JSONArray jSONArray2) {
        return Intrinsics.areEqual((Object) jSONArray, (Object) jSONArray2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47598hashCodeimpl(JSONArray jSONArray) {
        if (jSONArray != null) {
            return jSONArray.hashCode();
        }
        return 0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47599toStringimpl(JSONArray jSONArray) {
        return "JSONArrayCreator(json=" + jSONArray + ")";
    }

    public boolean equals(Object obj) {
        return m47596equalsimpl(this.f53982a, obj);
    }

    public int hashCode() {
        return m47598hashCodeimpl(this.f53982a);
    }

    public String toString() {
        return m47599toStringimpl(this.f53982a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ JSONArray m47600unboximpl() {
        return this.f53982a;
    }

    private /* synthetic */ JSONArrayCreator(JSONArray jSONArray) {
        Intrinsics.checkParameterIsNotNull(jSONArray, "json");
        this.f53982a = jSONArray;
    }

    /* renamed from: element-impl  reason: not valid java name */
    public static final void m47594elementimpl(JSONArray jSONArray, String str, T t) {
        Intrinsics.checkParameterIsNotNull(str, "$this$element");
        JSONKt.plus(jSONArray, t);
    }

    /* renamed from: elementNotNull-impl  reason: not valid java name */
    public static final void m47595elementNotNullimpl(JSONArray jSONArray, String str, T t) {
        Intrinsics.checkParameterIsNotNull(str, "$this$elementNotNull");
        if (t != null) {
            JSONKt.plus(jSONArray, t);
        }
    }
}
