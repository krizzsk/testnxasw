package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0015\u0010\u000b\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u0007J\u001b\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, mo148868d2 = {"Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "mark", "adjustment", "Lkotlin/time/Duration;", "(Lkotlin/time/TimeMark;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdjustment-UwyO8pc", "()J", "J", "getMark", "()Lkotlin/time/TimeMark;", "elapsedNow", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.time.a */
/* compiled from: TimeSource.kt */
final class C2723a extends TimeMark {

    /* renamed from: a */
    private final TimeMark f6003a;

    /* renamed from: b */
    private final long f6004b;

    private C2723a(TimeMark timeMark, long j) {
        this.f6003a = timeMark;
        this.f6004b = j;
    }

    public /* synthetic */ C2723a(TimeMark timeMark, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(timeMark, j);
    }

    /* renamed from: a */
    public final TimeMark mo27494a() {
        return this.f6003a;
    }

    /* renamed from: b */
    public final long mo27495b() {
        return this.f6004b;
    }

    /* renamed from: elapsedNow-UwyO8pc  reason: not valid java name */
    public long m46536elapsedNowUwyO8pc() {
        return Duration.m46480minusLRDsOJo(this.f6003a.m46529elapsedNowUwyO8pc(), this.f6004b);
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public TimeMark m46537plusLRDsOJo(long j) {
        return new C2723a(this.f6003a, Duration.m46481plusLRDsOJo(this.f6004b, j));
    }
}
