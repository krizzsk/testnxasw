package p218io.socket.backo;

import java.math.BigDecimal;
import java.math.BigInteger;

/* renamed from: io.socket.backo.Backoff */
public class Backoff {

    /* renamed from: a */
    private long f62259a = 100;

    /* renamed from: b */
    private long f62260b = 10000;

    /* renamed from: c */
    private int f62261c = 2;

    /* renamed from: d */
    private double f62262d;

    /* renamed from: e */
    private int f62263e;

    public long duration() {
        BigInteger valueOf = BigInteger.valueOf(this.f62259a);
        BigInteger valueOf2 = BigInteger.valueOf((long) this.f62261c);
        int i = this.f62263e;
        this.f62263e = i + 1;
        BigInteger multiply = valueOf.multiply(valueOf2.pow(i));
        if (this.f62262d != 0.0d) {
            double random = Math.random();
            BigInteger bigInteger = BigDecimal.valueOf(random).multiply(BigDecimal.valueOf(this.f62262d)).multiply(new BigDecimal(multiply)).toBigInteger();
            multiply = (((int) Math.floor(random * 10.0d)) & 1) == 0 ? multiply.subtract(bigInteger) : multiply.add(bigInteger);
        }
        return multiply.min(BigInteger.valueOf(this.f62260b)).longValue();
    }

    public void reset() {
        this.f62263e = 0;
    }

    public Backoff setMin(long j) {
        this.f62259a = j;
        return this;
    }

    public Backoff setMax(long j) {
        this.f62260b = j;
        return this;
    }

    public Backoff setFactor(int i) {
        this.f62261c = i;
        return this;
    }

    public Backoff setJitter(double d) {
        this.f62262d = d;
        return this;
    }

    public int getAttempts() {
        return this.f62263e;
    }
}
