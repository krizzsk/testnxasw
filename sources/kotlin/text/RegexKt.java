package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(mo148867d1 = {"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014"}, mo148868d2 = {"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, mo148869k = 2, mo148870mv = {1, 5, 1})
/* compiled from: Regex.kt */
public final class RegexKt {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final /* synthetic */ <T extends Enum<T> & C2707d> Set<T> m5367a(int i) {
        Intrinsics.reifiedOperationMarker(4, "T");
        EnumSet<E> allOf = EnumSet.allOf(Enum.class);
        CollectionsKt.retainAll(allOf, new RegexKt$fromInt$$inlined$apply$lambda$1(i));
        Set<T> unmodifiableSet = Collections.unmodifiableSet(allOf);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        return unmodifiableSet;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final MatchResult m5370a(Matcher matcher, int i, CharSequence charSequence) {
        if (!matcher.find(i)) {
            return null;
        }
        return new C2708e(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final MatchResult m5371a(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new C2708e(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final IntRange m5368a(MatchResult matchResult) {
        return RangesKt.until(matchResult.start(), matchResult.end());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final IntRange m5369a(MatchResult matchResult, int i) {
        return RangesKt.until(matchResult.start(i), matchResult.end(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final int m5366a(Iterable<? extends C2707d> iterable) {
        int i = 0;
        for (C2707d value : iterable) {
            i |= value.getValue();
        }
        return i;
    }
}
