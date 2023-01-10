package kshark;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo148868d2 = {"Lkshark/IgnoredReferenceMatcher;", "Lkshark/ReferenceMatcher;", "pattern", "Lkshark/ReferencePattern;", "(Lkshark/ReferencePattern;)V", "getPattern", "()Lkshark/ReferencePattern;", "toString", "", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: ReferenceMatcher.kt */
public final class IgnoredReferenceMatcher extends ReferenceMatcher {

    /* renamed from: a */
    private final ReferencePattern f6454a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IgnoredReferenceMatcher(ReferencePattern referencePattern) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkParameterIsNotNull(referencePattern, "pattern");
        this.f6454a = referencePattern;
    }

    public ReferencePattern getPattern() {
        return this.f6454a;
    }

    public String toString() {
        return "ignored ref: " + getPattern();
    }
}
