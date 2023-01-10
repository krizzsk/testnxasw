package p091public;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: public.try */
/* compiled from: SensorDataStorage */
public class C3565try {

    /* renamed from: a */
    private final int f8575a;

    /* renamed from: b */
    private final LinkedList<C3561for> f8576b = new LinkedList<>();

    public C3565try(int i) {
        this.f8575a = i;
    }

    /* renamed from: do */
    public void mo43311do(C3561for forR) {
        if (this.f8576b.size() == this.f8575a) {
            this.f8576b.removeFirst();
        }
        this.f8576b.add(forR);
    }

    /* renamed from: do */
    public List<C3561for> mo43310do() {
        ArrayList arrayList = new ArrayList(this.f8576b);
        this.f8576b.clear();
        return arrayList;
    }
}
