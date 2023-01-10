package com.didi.app.nova.skeleton.conductor;

import android.os.Bundle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public final class Backstack implements Iterable<RouterTransaction> {

    /* renamed from: a */
    private static final String f10111a = "Backstack.entries";

    /* renamed from: b */
    private final Deque<RouterTransaction> f10112b = new ArrayDeque();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo45449a() {
        return this.f10112b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo45450b() {
        return this.f10112b.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public RouterTransaction mo45453c() {
        if (this.f10112b.size() > 0) {
            return this.f10112b.getLast();
        }
        return null;
    }

    public Iterator<RouterTransaction> iterator() {
        return this.f10112b.iterator();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Iterator<RouterTransaction> mo45455d() {
        return this.f10112b.descendingIterator();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<RouterTransaction> mo45446a(RouterTransaction routerTransaction) {
        ArrayList arrayList = new ArrayList();
        if (this.f10112b.contains(routerTransaction)) {
            while (this.f10112b.peek() != routerTransaction) {
                arrayList.add(mo45457e());
            }
            return arrayList;
        }
        throw new RuntimeException("Tried to pop to a transaction that was not on the back stack");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public RouterTransaction mo45457e() {
        RouterTransaction pop = this.f10112b.pop();
        pop.f10182a.mo45486d();
        return pop;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public RouterTransaction mo45458f() {
        return this.f10112b.peek();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo45452b(RouterTransaction routerTransaction) {
        this.f10112b.removeFirstOccurrence(routerTransaction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo45454c(RouterTransaction routerTransaction) {
        this.f10112b.push(routerTransaction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public List<RouterTransaction> mo45459g() {
        ArrayList arrayList = new ArrayList();
        while (!mo45449a()) {
            arrayList.add(mo45457e());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45448a(List<RouterTransaction> list) {
        boolean z;
        for (RouterTransaction next : this.f10112b) {
            Iterator<RouterTransaction> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (next.f10182a == it.next().f10182a) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                if (next.f10182a.isAttached()) {
                    if (!(next.f10182a.getRouter() == null || next.f10182a.getView() == null || next.f10182a.getRouter().f10169d == null)) {
                        next.f10182a.getRouter().f10169d.removeView(next.f10182a.getView());
                    }
                    next.f10182a.mo45471a(next.f10182a.getView(), true, false);
                }
                next.f10182a.mo45486d();
            }
        }
        this.f10112b.clear();
        for (RouterTransaction push : list) {
            this.f10112b.push(push);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo45456d(RouterTransaction routerTransaction) {
        return this.f10112b.contains(routerTransaction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo45447a(Bundle bundle) {
        ArrayList arrayList = new ArrayList(this.f10112b.size());
        for (RouterTransaction saveInstanceState : this.f10112b) {
            arrayList.add(saveInstanceState.saveInstanceState());
        }
        bundle.putParcelableArrayList(f10111a, arrayList);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo45451b(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f10111a);
        if (parcelableArrayList != null) {
            Collections.reverse(parcelableArrayList);
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                this.f10112b.push(new RouterTransaction((Bundle) it.next()));
            }
        }
    }
}
