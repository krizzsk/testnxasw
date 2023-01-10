package kotlin.comparisons;

import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\"\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004¨\u0006\u000b"}, mo148868d2 = {"Lkotlin/comparisons/NaturalOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "reversed", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.comparisons.d */
/* compiled from: Comparisons.kt */
final class C2382d implements Comparator<Comparable<? super Object>> {

    /* renamed from: a */
    public static final C2382d f4572a = new C2382d();

    private C2382d() {
    }

    /* renamed from: a */
    public int compare(Comparable<Object> comparable, Comparable<Object> comparable2) {
        Intrinsics.checkNotNullParameter(comparable, Constants.FILE_ANR_KEY);
        Intrinsics.checkNotNullParameter(comparable2, "b");
        return comparable.compareTo(comparable2);
    }

    public final Comparator<Comparable<Object>> reversed() {
        return C2383e.f4573a;
    }
}
