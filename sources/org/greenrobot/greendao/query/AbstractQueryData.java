package org.greenrobot.greendao.query;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.AbstractQuery;

abstract class AbstractQueryData<T, Q extends AbstractQuery<T>> {
    final AbstractDao<T, ?> dao;
    final String[] initialValues;
    final Map<Long, WeakReference<Q>> queriesForThreads = new HashMap();
    final String sql;

    /* access modifiers changed from: protected */
    public abstract Q createQuery();

    AbstractQueryData(AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        this.dao = abstractDao;
        this.sql = str;
        this.initialValues = strArr;
    }

    /* access modifiers changed from: package-private */
    public Q forCurrentThread(Q q) {
        if (Thread.currentThread() != q.ownerThread) {
            return forCurrentThread();
        }
        System.arraycopy(this.initialValues, 0, q.parameters, 0, this.initialValues.length);
        return q;
    }

    /* access modifiers changed from: package-private */
    public Q forCurrentThread() {
        Q q;
        long id = Thread.currentThread().getId();
        synchronized (this.queriesForThreads) {
            WeakReference weakReference = this.queriesForThreads.get(Long.valueOf(id));
            q = weakReference != null ? (AbstractQuery) weakReference.get() : null;
            if (q == null) {
                mo39079gc();
                q = createQuery();
                this.queriesForThreads.put(Long.valueOf(id), new WeakReference(q));
            } else {
                System.arraycopy(this.initialValues, 0, q.parameters, 0, this.initialValues.length);
            }
        }
        return q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: gc */
    public void mo39079gc() {
        synchronized (this.queriesForThreads) {
            Iterator<Map.Entry<Long, WeakReference<Q>>> it = this.queriesForThreads.entrySet().iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next().getValue()).get() == null) {
                    it.remove();
                }
            }
        }
    }
}
