package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo148868d2 = {"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getRange", "()Lkotlin/ranges/IntRange;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: Regex.kt */
public final class MatchGroup {

    /* renamed from: a */
    private final String f5977a;

    /* renamed from: b */
    private final IntRange f5978b;

    public static /* synthetic */ MatchGroup copy$default(MatchGroup matchGroup, String str, IntRange intRange, int i, Object obj) {
        if ((i & 1) != 0) {
            str = matchGroup.f5977a;
        }
        if ((i & 2) != 0) {
            intRange = matchGroup.f5978b;
        }
        return matchGroup.copy(str, intRange);
    }

    public final String component1() {
        return this.f5977a;
    }

    public final IntRange component2() {
        return this.f5978b;
    }

    public final MatchGroup copy(String str, IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(intRange, "range");
        return new MatchGroup(str, intRange);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchGroup)) {
            return false;
        }
        MatchGroup matchGroup = (MatchGroup) obj;
        return Intrinsics.areEqual((Object) this.f5977a, (Object) matchGroup.f5977a) && Intrinsics.areEqual((Object) this.f5978b, (Object) matchGroup.f5978b);
    }

    public int hashCode() {
        String str = this.f5977a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        IntRange intRange = this.f5978b;
        if (intRange != null) {
            i = intRange.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "MatchGroup(value=" + this.f5977a + ", range=" + this.f5978b + ")";
    }

    public MatchGroup(String str, IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(intRange, "range");
        this.f5977a = str;
        this.f5978b = intRange;
    }

    public final IntRange getRange() {
        return this.f5978b;
    }

    public final String getValue() {
        return this.f5977a;
    }
}
