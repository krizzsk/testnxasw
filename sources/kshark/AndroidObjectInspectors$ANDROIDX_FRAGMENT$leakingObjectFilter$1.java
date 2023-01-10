package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "", "heapObject", "Lkshark/HeapObject;", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: AndroidObjectInspectors.kt */
final class AndroidObjectInspectors$ANDROIDX_FRAGMENT$leakingObjectFilter$1 extends Lambda implements Function1<HeapObject, Boolean> {
    public static final AndroidObjectInspectors$ANDROIDX_FRAGMENT$leakingObjectFilter$1 INSTANCE = new AndroidObjectInspectors$ANDROIDX_FRAGMENT$leakingObjectFilter$1();

    AndroidObjectInspectors$ANDROIDX_FRAGMENT$leakingObjectFilter$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((HeapObject) obj));
    }

    public final boolean invoke(HeapObject heapObject) {
        Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
        if (heapObject instanceof HeapObject.HeapInstance) {
            HeapObject.HeapInstance heapInstance = (HeapObject.HeapInstance) heapObject;
            if (heapInstance.instanceOf("androidx.fragment.app.Fragment")) {
                HeapField heapField = heapInstance.get("androidx.fragment.app.Fragment", "mFragmentManager");
                if (heapField == null) {
                    Intrinsics.throwNpe();
                }
                if (heapField.getValue().isNullReference()) {
                    return true;
                }
            }
        }
        return false;
    }
}
