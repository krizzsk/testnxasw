package com.didi.entrega.customer.repo;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.RepoManager;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

public final class RepoFactory {

    /* renamed from: a */
    private static final String f22083a = "Repo";

    /* renamed from: b */
    private static volatile RepoManager f22084b;

    private RepoFactory() {
    }

    public static void clearAll() {
        if (f22084b != null) {
            Iterator<Class<?>> keyIterator = f22084b.keyIterator();
            ArrayList arrayList = new ArrayList();
            while (keyIterator.hasNext()) {
                Class next = keyIterator.next();
                boolean isAnnotationPresent = next.isAnnotationPresent(GlobalCache.class);
                LogUtil.m18185i(f22083a, next.getCanonicalName() + " : isGlobal=" + isAnnotationPresent);
                if (!isAnnotationPresent) {
                    arrayList.add(next);
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                f22084b.remove((Class) arrayList.get(i));
            }
            f22084b.clear();
            f22084b = null;
        }
    }

    public static void clearRepo(Class<?> cls) {
        if (f22084b != null) {
            f22084b.remove(cls);
        }
    }

    public static <T extends Repo> T getRepo(Class<T> cls) {
        return m18299a().getRepo(cls);
    }

    /* renamed from: a */
    private static RepoManager m18299a() {
        if (f22084b == null) {
            synchronized (RepoManager.class) {
                RepoManager.Builder builder = new RepoManager.Builder();
                builder.monitor(new RepoManager.RepoMonitor() {
                    public void onRepoCreate(Repo repo) {
                    }

                    public void onRepoDestroy(Repo repo) {
                    }
                });
                builder.log(true);
                f22084b = builder.build();
            }
        }
        return f22084b;
    }
}
