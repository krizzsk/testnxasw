package kshark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kshark.HeapObject;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, mo148868d2 = {"Lkshark/HeapField;", "", "declaringClass", "Lkshark/HeapObject$HeapClass;", "name", "", "value", "Lkshark/HeapValue;", "(Lkshark/HeapObject$HeapClass;Ljava/lang/String;Lkshark/HeapValue;)V", "getDeclaringClass", "()Lkshark/HeapObject$HeapClass;", "getName", "()Ljava/lang/String;", "getValue", "()Lkshark/HeapValue;", "valueAsClass", "getValueAsClass", "valueAsInstance", "Lkshark/HeapObject$HeapInstance;", "getValueAsInstance", "()Lkshark/HeapObject$HeapInstance;", "valueAsObjectArray", "Lkshark/HeapObject$HeapObjectArray;", "getValueAsObjectArray", "()Lkshark/HeapObject$HeapObjectArray;", "valueAsPrimitiveArray", "Lkshark/HeapObject$HeapPrimitiveArray;", "getValueAsPrimitiveArray", "()Lkshark/HeapObject$HeapPrimitiveArray;", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: HeapField.kt */
public final class HeapField {

    /* renamed from: a */
    private final HeapObject.HeapClass f6392a;

    /* renamed from: b */
    private final String f6393b;

    /* renamed from: c */
    private final HeapValue f6394c;

    public HeapField(HeapObject.HeapClass heapClass, String str, HeapValue heapValue) {
        Intrinsics.checkParameterIsNotNull(heapClass, "declaringClass");
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(heapValue, "value");
        this.f6392a = heapClass;
        this.f6393b = str;
        this.f6394c = heapValue;
    }

    public final HeapObject.HeapClass getDeclaringClass() {
        return this.f6392a;
    }

    public final String getName() {
        return this.f6393b;
    }

    public final HeapValue getValue() {
        return this.f6394c;
    }

    public final HeapObject.HeapClass getValueAsClass() {
        HeapObject asObject = this.f6394c.getAsObject();
        if (asObject != null) {
            return asObject.getAsClass();
        }
        return null;
    }

    public final HeapObject.HeapInstance getValueAsInstance() {
        HeapObject asObject = this.f6394c.getAsObject();
        if (asObject != null) {
            return asObject.getAsInstance();
        }
        return null;
    }

    public final HeapObject.HeapObjectArray getValueAsObjectArray() {
        HeapObject asObject = this.f6394c.getAsObject();
        if (asObject != null) {
            return asObject.getAsObjectArray();
        }
        return null;
    }

    public final HeapObject.HeapPrimitiveArray getValueAsPrimitiveArray() {
        HeapObject asObject = this.f6394c.getAsObject();
        if (asObject != null) {
            return asObject.getAsPrimitiveArray();
        }
        return null;
    }
}
