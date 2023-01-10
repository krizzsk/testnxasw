package p095switch;

/* renamed from: switch.class */
/* compiled from: Throttler */
public class C3665class<T> {

    /* renamed from: a */
    private T f8778a = null;

    /* renamed from: b */
    private long f8779b = -1;

    /* renamed from: c */
    private final long f8780c;

    public C3665class(long j) {
        this.f8780c = j;
    }

    /* renamed from: do */
    public T mo43495do() {
        return this.f8778a;
    }

    /* renamed from: if */
    public T mo43497if(T t) {
        if ((this.f8779b != -1 && System.currentTimeMillis() - this.f8779b < this.f8780c) || t == this.f8778a) {
            return this.f8778a;
        }
        this.f8778a = t;
        this.f8779b = System.currentTimeMillis();
        return t;
    }

    /* renamed from: do */
    public void mo43496do(T t) {
        this.f8778a = t;
        this.f8779b = System.currentTimeMillis();
    }
}
