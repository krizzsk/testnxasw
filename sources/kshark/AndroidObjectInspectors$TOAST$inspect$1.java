package kshark;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "Lkshark/ObjectReporter;", "instance", "Lkshark/HeapObject$HeapInstance;", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: AndroidObjectInspectors.kt */
final class AndroidObjectInspectors$TOAST$inspect$1 extends Lambda implements Function2<ObjectReporter, HeapObject.HeapInstance, Unit> {
    public static final AndroidObjectInspectors$TOAST$inspect$1 INSTANCE = new AndroidObjectInspectors$TOAST$inspect$1();

    AndroidObjectInspectors$TOAST$inspect$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ObjectReporter objectReporter, HeapObject.HeapInstance heapInstance) {
        Intrinsics.checkParameterIsNotNull(objectReporter, "$receiver");
        Intrinsics.checkParameterIsNotNull(heapInstance, "instance");
        HeapField heapField = heapInstance.get("android.widget.Toast", "mTN");
        if (heapField == null) {
            Intrinsics.throwNpe();
        }
        HeapObject asObject = heapField.getValue().getAsObject();
        if (asObject == null) {
            Intrinsics.throwNpe();
        }
        HeapObject.HeapInstance asInstance = asObject.getAsInstance();
        if (asInstance == null) {
            Intrinsics.throwNpe();
        }
        HeapField heapField2 = asInstance.get("android.widget.Toast$TN", "mWM");
        if (heapField2 == null) {
            Intrinsics.throwNpe();
        }
        if (heapField2.getValue().isNonNullReference()) {
            HeapField heapField3 = asInstance.get("android.widget.Toast$TN", "mView");
            if (heapField3 == null) {
                Intrinsics.throwNpe();
            }
            if (heapField3.getValue().isNullReference()) {
                objectReporter.getLeakingReasons().add("This toast is done showing (Toast.mTN.mWM != null && Toast.mTN.mView == null)");
            } else {
                objectReporter.getNotLeakingReasons().add("This toast is showing (Toast.mTN.mWM != null && Toast.mTN.mView != null)");
            }
        }
    }
}
