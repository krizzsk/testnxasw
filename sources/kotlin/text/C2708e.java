package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;

@Metadata(mo148867d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, mo148868d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.text.e */
/* compiled from: Regex.kt */
final class C2708e implements MatchResult {

    /* renamed from: a */
    private final MatchGroupCollection f5984a = new MatcherMatchResult$groups$1(this);

    /* renamed from: b */
    private List<String> f5985b;

    /* renamed from: c */
    private final Matcher f5986c;

    /* renamed from: d */
    private final CharSequence f5987d;

    public C2708e(Matcher matcher, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        this.f5986c = matcher;
        this.f5987d = charSequence;
    }

    public MatchResult.Destructured getDestructured() {
        return MatchResult.DefaultImpls.getDestructured(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final java.util.regex.MatchResult m5398a() {
        return this.f5986c;
    }

    public IntRange getRange() {
        return RegexKt.m5368a(m5398a());
    }

    public String getValue() {
        String group = m5398a().group();
        Intrinsics.checkNotNullExpressionValue(group, "matchResult.group()");
        return group;
    }

    public MatchGroupCollection getGroups() {
        return this.f5984a;
    }

    public List<String> getGroupValues() {
        if (this.f5985b == null) {
            this.f5985b = new MatcherMatchResult$groupValues$1(this);
        }
        List<String> list = this.f5985b;
        Intrinsics.checkNotNull(list);
        return list;
    }

    public MatchResult next() {
        int end = m5398a().end() + (m5398a().end() == m5398a().start() ? 1 : 0);
        if (end > this.f5987d.length()) {
            return null;
        }
        Matcher matcher = this.f5986c.pattern().matcher(this.f5987d);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher.pattern().matcher(input)");
        return RegexKt.m5370a(matcher, end, this.f5987d);
    }
}
