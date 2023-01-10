package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo148868d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: TimeSources.kt */
public final class TestTimeSource extends AbstractLongTimeSource {

    /* renamed from: a */
    private long f6000a;

    public TestTimeSource() {
        super(TimeUnit.NANOSECONDS);
    }

    /* access modifiers changed from: protected */
    public long read() {
        return this.f6000a;
    }

    /* renamed from: plusAssign-LRDsOJo  reason: not valid java name */
    public final void m46528plusAssignLRDsOJo(long j) {
        long j2;
        long r0 = Duration.m46491toLongimpl(j, getUnit());
        if (r0 == Long.MIN_VALUE || r0 == Long.MAX_VALUE) {
            double r6 = ((double) this.f6000a) + Duration.m46488toDoubleimpl(j, getUnit());
            if (r6 > ((double) Long.MAX_VALUE) || r6 < ((double) Long.MIN_VALUE)) {
                m5614a(j);
            }
            j2 = (long) r6;
        } else {
            long j3 = this.f6000a;
            j2 = j3 + r0;
            if ((r0 ^ j3) >= 0 && (j3 ^ j2) < 0) {
                m5614a(j);
            }
        }
        this.f6000a = j2;
    }

    /* renamed from: a */
    private final void m5614a(long j) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.f6000a + "ns is advanced by " + Duration.m46494toStringimpl(j) + '.');
    }
}
