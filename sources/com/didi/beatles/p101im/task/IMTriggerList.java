package com.didi.beatles.p101im.task;

import com.didi.beatles.p101im.utils.IMLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.didi.beatles.im.task.IMTriggerList */
public class IMTriggerList<T> implements IMBaseTriggerList<T> {

    /* renamed from: a */
    private List<IMTriggerList<T>.IMTriggerEntity<T>> f11483a = new ArrayList();

    /* renamed from: b */
    private long f11484b = 2000;

    /* renamed from: c */
    private Timer f11485c = new Timer();

    /* renamed from: d */
    private IMTriggerListener f11486d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f11487e;

    /* renamed from: com.didi.beatles.im.task.IMTriggerList$IMTriggerListener */
    public interface IMTriggerListener<T> {
        boolean onTrigger(List<T> list, boolean z);
    }

    public boolean add(T t) {
        synchronized (this.f11483a) {
            if (this.f11483a == null) {
                return false;
            }
            if (this.f11483a.size() == 0) {
                m9903a();
            }
            this.f11483a.add(new IMTriggerEntity(t));
            return true;
        }
    }

    public void addAll(List<T> list) {
        if (list != null && list.size() != 0) {
            synchronized (this.f11483a) {
                if (this.f11483a.size() == 0) {
                    m9903a();
                }
                for (T iMTriggerEntity : list) {
                    this.f11483a.add(new IMTriggerEntity(iMTriggerEntity));
                }
            }
        }
    }

    /* renamed from: a */
    private void m9903a() {
        if (!this.f11487e) {
            this.f11487e = true;
            this.f11485c.schedule(new TimerTask() {
                public void run() {
                    if (IMTriggerList.this.f11487e) {
                        IMTriggerList.this.m9907c();
                    }
                }
            }, this.f11484b);
        }
    }

    /* renamed from: b */
    private void m9905b() {
        this.f11487e = false;
    }

    public boolean remove(T t) {
        if (t == null) {
            return false;
        }
        synchronized (this.f11483a) {
            int size = this.f11483a.size();
            for (int i = 0; i < size; i++) {
                if (t.equals(this.f11483a.get(i).entity)) {
                    this.f11483a.remove(new IMTriggerEntity(t));
                    return true;
                }
            }
            return false;
        }
    }

    public void removeAll(List<T> list) {
        if (list != null && list.size() != 0) {
            synchronized (this.f11483a) {
                for (T remove : list) {
                    remove(remove);
                }
            }
            if (this.f11483a.size() == 0) {
                IMLog.m10024i("IMMessageReadStatusManager", "list is null after remove,stop timer");
                m9905b();
            }
        }
    }

    public void addTriggerListener(IMTriggerListener<T> iMTriggerListener) {
        this.f11486d = iMTriggerListener;
    }

    public void removeHasExecuted() {
        if (this.f11483a.size() != 0) {
            synchronized (this.f11483a) {
                int size = this.f11483a.size();
                int i = 0;
                while (i < size) {
                    IMTriggerEntity iMTriggerEntity = this.f11483a.get(i);
                    if (iMTriggerEntity.hasExecuted) {
                        this.f11483a.remove(iMTriggerEntity);
                        size--;
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    public boolean ExecuteAll(boolean z) {
        m9907c();
        if (!z) {
            return true;
        }
        removeHasExecuted();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9907c() {
        List<IMTriggerList<T>.IMTriggerEntity<T>> list = this.f11483a;
        if (list != null && list.size() != 0 && this.f11486d != null) {
            synchronized (this.f11483a) {
                boolean isAllExecuted = isAllExecuted();
                ArrayList arrayList = new ArrayList();
                for (IMTriggerEntity next : this.f11483a) {
                    next.hasExecuted = true;
                    arrayList.add(next.entity);
                }
                if (this.f11486d.onTrigger(arrayList, isAllExecuted)) {
                    removeHasExecuted();
                }
                m9905b();
                m9903a();
            }
        }
    }

    public void setTriggerTime(long j) {
        this.f11484b = j;
    }

    public void clear() {
        this.f11483a.clear();
    }

    public boolean isAllExecuted() {
        List<IMTriggerList<T>.IMTriggerEntity<T>> list = this.f11483a;
        if (!(list == null || list.size() == 0)) {
            for (IMTriggerList<T>.IMTriggerEntity<T> iMTriggerEntity : this.f11483a) {
                if (!iMTriggerEntity.hasExecuted) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isRunning() {
        return this.f11487e;
    }

    /* renamed from: com.didi.beatles.im.task.IMTriggerList$IMTriggerEntity */
    private class IMTriggerEntity<T> {
        public T entity;
        public boolean hasExecuted;
        public int priority;

        public IMTriggerEntity(T t) {
            this.entity = t;
        }

        public boolean equals(Object obj) {
            T t;
            T t2;
            if (!(obj instanceof IMTriggerEntity) || (t = ((IMTriggerEntity) obj).entity) == null || (t2 = this.entity) == null) {
                return false;
            }
            return t.equals(t2);
        }
    }
}
