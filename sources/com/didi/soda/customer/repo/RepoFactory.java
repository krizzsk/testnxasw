package com.didi.soda.customer.repo;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.RepoManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

public final class RepoFactory {

    /* renamed from: a */
    private static final String f43995a = "Repo";

    /* renamed from: b */
    private static volatile RepoManager f43996b;

    private RepoFactory() {
    }

    public static void clearAll() {
        if (f43996b != null) {
            Iterator<Class<?>> keyIterator = f43996b.keyIterator();
            ArrayList arrayList = new ArrayList();
            while (keyIterator.hasNext()) {
                Class next = keyIterator.next();
                boolean isAnnotationPresent = next.isAnnotationPresent(GlobalCache.class);
                LogUtil.m32588i(f43995a, next.getCanonicalName() + " : isGlobal=" + isAnnotationPresent);
                if (!isAnnotationPresent) {
                    arrayList.add(next);
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                f43996b.remove((Class) arrayList.get(i));
            }
            f43996b.clear();
            f43996b = null;
        }
    }

    public static void clearRepo(Class<?> cls) {
        if (f43996b != null) {
            f43996b.remove(cls);
        }
    }

    public static <T extends Repo> T getRepo(Class<T> cls) {
        return m32808a().getRepo(cls);
    }

    /* renamed from: a */
    private static RepoManager m32808a() {
        if (f43996b == null) {
            synchronized (RepoManager.class) {
                RepoManager.Builder builder = new RepoManager.Builder();
                builder.monitor(new RepoManager.RepoMonitor() {
                    public void onRepoCreate(Repo repo) {
                    }

                    public void onRepoDestroy(Repo repo) {
                    }
                });
                builder.log(true);
                f43996b = builder.build();
            }
        }
        return f43996b;
    }
}
