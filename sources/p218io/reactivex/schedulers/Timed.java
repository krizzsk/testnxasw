package p218io.reactivex.schedulers;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.concurrent.TimeUnit;
import p218io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.schedulers.Timed */
public final class Timed<T> {

    /* renamed from: a */
    final T f62182a;

    /* renamed from: b */
    final long f62183b;

    /* renamed from: c */
    final TimeUnit f62184c;

    public Timed(T t, long j, TimeUnit timeUnit) {
        this.f62182a = t;
        this.f62183b = j;
        this.f62184c = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
    }

    public T value() {
        return this.f62182a;
    }

    public TimeUnit unit() {
        return this.f62184c;
    }

    public long time() {
        return this.f62183b;
    }

    public long time(TimeUnit timeUnit) {
        return timeUnit.convert(this.f62183b, this.f62184c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        if (!ObjectHelper.equals(this.f62182a, timed.f62182a) || this.f62183b != timed.f62183b || !ObjectHelper.equals(this.f62184c, timed.f62184c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t = this.f62182a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.f62183b;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.f62184c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f62183b + ", unit=" + this.f62184c + ", value=" + this.f62182a + Const.jaRight;
    }
}
