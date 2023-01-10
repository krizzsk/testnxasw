package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "", "it", "Lkshark/HeapValue;", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: AndroidResourceIdNames.kt */
final class AndroidResourceIdNames$Companion$readFromHeap$1$1$1$names$1 extends Lambda implements Function1<HeapValue, String> {
    public static final AndroidResourceIdNames$Companion$readFromHeap$1$1$1$names$1 INSTANCE = new AndroidResourceIdNames$Companion$readFromHeap$1$1$1$names$1();

    AndroidResourceIdNames$Companion$readFromHeap$1$1$1$names$1() {
        super(1);
    }

    public final String invoke(HeapValue heapValue) {
        Intrinsics.checkParameterIsNotNull(heapValue, "it");
        String readAsJavaString = heapValue.readAsJavaString();
        if (readAsJavaString == null) {
            Intrinsics.throwNpe();
        }
        return readAsJavaString;
    }
}
