package com.didi.app.nova.skeleton.repo;

import androidx.collection.ArrayMap;
import java.lang.reflect.Constructor;
import java.util.Iterator;

public final class RepoManager {

    /* renamed from: b */
    private static final Object f10347b = new Object();

    /* renamed from: a */
    private ArrayMap<Class<?>, Repo> f10348a;
    protected boolean logOpen;
    protected RepoMonitor monitor;

    public interface RepoMonitor {
        void onRepoCreate(Repo repo);

        void onRepoDestroy(Repo repo);
    }

    private RepoManager() {
        this.logOpen = false;
        this.f10348a = new ArrayMap<>();
    }

    public static class Builder {
        private RepoManager factory = new RepoManager();

        public Builder monitor(RepoMonitor repoMonitor) {
            this.factory.monitor = repoMonitor;
            return this;
        }

        public Builder log(boolean z) {
            this.factory.logOpen = z;
            return this;
        }

        public RepoManager build() {
            return this.factory;
        }
    }

    public <T extends Repo> T getRepo(Class<T> cls) {
        T t;
        synchronized (f10347b) {
            t = (Repo) this.f10348a.get(cls);
            if (t == null) {
                Constructor constructor = null;
                try {
                    Constructor[] declaredConstructors = cls.getDeclaredConstructors();
                    int length = declaredConstructors.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        Constructor constructor2 = declaredConstructors[i];
                        if (constructor2.getParameterTypes().length == 0) {
                            if (!constructor2.isAccessible()) {
                                constructor2.setAccessible(true);
                            }
                            constructor = constructor2;
                        } else {
                            i++;
                        }
                    }
                    T t2 = (Repo) constructor.newInstance(new Object[0]);
                    try {
                        if (this.monitor != null) {
                            this.monitor.onRepoCreate(t2);
                        }
                        this.f10348a.put(cls, t2);
                        t2.onCreate();
                        t = t2;
                    } catch (Exception e) {
                        e = e;
                        t = t2;
                        e.printStackTrace();
                        return t;
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return t;
                }
            }
        }
        return t;
    }

    public <T> T remove(Class<T> cls) {
        T t;
        synchronized (f10347b) {
            t = (Repo) this.f10348a.remove(cls);
            if (t != null) {
                this.monitor.onRepoDestroy(t);
                t.onDestroy();
            }
        }
        return t;
    }

    public void clear() {
        synchronized (f10347b) {
            for (Repo next : this.f10348a.values()) {
                this.monitor.onRepoDestroy(next);
                next.onDestroy();
            }
            this.f10348a.clear();
        }
    }

    public Iterator<Class<?>> keyIterator() {
        return this.f10348a.keySet().iterator();
    }
}
