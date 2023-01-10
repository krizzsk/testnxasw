package kshark;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\u0007\b¨\u0006\t"}, mo148868d2 = {"Lkshark/ReferenceMatcher;", "", "()V", "pattern", "Lkshark/ReferencePattern;", "getPattern", "()Lkshark/ReferencePattern;", "Lkshark/LibraryLeakReferenceMatcher;", "Lkshark/IgnoredReferenceMatcher;", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: ReferenceMatcher.kt */
public abstract class ReferenceMatcher {
    public abstract ReferencePattern getPattern();

    private ReferenceMatcher() {
    }

    public /* synthetic */ ReferenceMatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
