package com.didichuxing.diface.appeal.mexico.toolkit;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Counter<T> {

    /* renamed from: a */
    private final Runnable f49742a;

    /* renamed from: b */
    private HashSet f49743b;

    public Counter(Collection<? extends T> collection, Runnable runnable) {
        this.f49743b = new HashSet(collection);
        this.f49742a = runnable;
    }

    public int residue() {
        return this.f49743b.size();
    }

    public void remove(T t) {
        Runnable runnable;
        Iterator it = this.f49743b.iterator();
        while (true) {
            if (it.hasNext()) {
                if (t.equals(it.next())) {
                    it.remove();
                    break;
                }
            } else {
                break;
            }
        }
        if (this.f49743b.size() == 0 && (runnable = this.f49742a) != null) {
            runnable.run();
        }
    }
}
