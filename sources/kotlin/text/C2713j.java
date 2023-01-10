package kotlin.text;

import java.util.Set;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\b¨\u0006\u0007"}, mo148868d2 = {"toRegex", "Lkotlin/text/Regex;", "", "options", "", "Lkotlin/text/RegexOption;", "option", "kotlin-stdlib"}, mo148869k = 5, mo148870mv = {1, 5, 1}, mo148872xi = 1, mo148873xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.j */
/* compiled from: RegexExtensions.kt */
class C2713j extends C2712i {
    /* renamed from: a */
    private static final Regex m5407a(String str) {
        return new Regex(str);
    }

    /* renamed from: a */
    private static final Regex m5409a(String str, RegexOption regexOption) {
        return new Regex(str, regexOption);
    }

    /* renamed from: a */
    private static final Regex m5408a(String str, Set<? extends RegexOption> set) {
        return new Regex(str, set);
    }
}
