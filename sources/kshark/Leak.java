package kshark;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\tH\u0016R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0001\u0002\u0014\u0015¨\u0006\u0016"}, mo148868d2 = {"Lkshark/Leak;", "Ljava/io/Serializable;", "()V", "leakTraces", "", "Lkshark/LeakTrace;", "getLeakTraces", "()Ljava/util/List;", "shortDescription", "", "getShortDescription", "()Ljava/lang/String;", "signature", "getSignature", "totalRetainedHeapByteSize", "", "getTotalRetainedHeapByteSize", "()Ljava/lang/Integer;", "toString", "Companion", "Lkshark/LibraryLeak;", "Lkshark/ApplicationLeak;", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: HeapAnalysis.kt */
public abstract class Leak implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -2287572510360910916L;

    public abstract List<LeakTrace> getLeakTraces();

    public abstract String getShortDescription();

    public abstract String getSignature();

    private Leak() {
    }

    public /* synthetic */ Leak(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Integer getTotalRetainedHeapByteSize() {
        if (((LeakTrace) CollectionsKt.first(getLeakTraces())).getRetainedHeapByteSize() == null) {
            return null;
        }
        int i = 0;
        for (LeakTrace retainedHeapByteSize : getLeakTraces()) {
            Integer retainedHeapByteSize2 = retainedHeapByteSize.getRetainedHeapByteSize();
            if (retainedHeapByteSize2 == null) {
                Intrinsics.throwNpe();
            }
            i += retainedHeapByteSize2.intValue();
        }
        return Integer.valueOf(i);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (getTotalRetainedHeapByteSize() != null) {
            str = getTotalRetainedHeapByteSize() + " bytes retained by leaking objects\n";
        } else {
            str = str2;
        }
        sb.append(str);
        if (getLeakTraces().size() > 1) {
            str2 = "Displaying only 1 leak trace out of " + getLeakTraces().size() + " with the same signature\n";
        }
        sb.append(str2);
        sb.append("Signature: ");
        sb.append(getSignature());
        sb.append(10);
        sb.append((LeakTrace) CollectionsKt.first(getLeakTraces()));
        return sb.toString();
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lkshark/Leak$Companion;", "", "()V", "serialVersionUID", "", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
    /* compiled from: HeapAnalysis.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
