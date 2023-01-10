package com.didi.entrega.customer.repo;

import com.didi.app.nova.skeleton.repo.Action1;
import java.util.ArrayList;
import java.util.Iterator;

public class CustomerFragmentInitRepo {

    /* renamed from: a */
    private static CustomerFragmentInitRepo f22080a;

    /* renamed from: b */
    private boolean f22081b;

    /* renamed from: c */
    private ArrayList<Action1<Boolean>> f22082c = new ArrayList<>();

    public static CustomerFragmentInitRepo getInstance() {
        if (f22080a == null) {
            f22080a = new CustomerFragmentInitRepo();
        }
        return f22080a;
    }

    public void setValue(boolean z) {
        this.f22081b = z;
        Iterator<Action1<Boolean>> it = this.f22082c.iterator();
        while (it.hasNext()) {
            it.next().call(Boolean.valueOf(z));
        }
    }

    public void subscribe(Action1<Boolean> action1) {
        this.f22082c.add(action1);
        Iterator<Action1<Boolean>> it = this.f22082c.iterator();
        while (it.hasNext()) {
            it.next().call(Boolean.valueOf(this.f22081b));
        }
    }

    public void remove(Action1<Boolean> action1) {
        if (this.f22082c.contains(action1)) {
            this.f22082c.remove(action1);
        }
    }

    public void clear() {
        this.f22081b = false;
        this.f22082c.clear();
    }
}
