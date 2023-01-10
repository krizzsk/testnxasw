package com.didi.beatles.p101im.thirty.greenrobot.dao;

import com.didi.beatles.p101im.thirty.greenrobot.dao.async.AsyncSession;
import com.didi.beatles.p101im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p101im.thirty.greenrobot.dao.query.QueryBuilder;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.AbstractDaoSession */
public class AbstractDaoSession {

    /* renamed from: a */
    private final Database f11494a;

    /* renamed from: b */
    private final Map<Class<?>, AbstractDao<?, ?>> f11495b = new HashMap();

    public AbstractDaoSession(Database database) {
        this.f11494a = database;
    }

    /* access modifiers changed from: protected */
    public <T> void registerDao(Class<T> cls, AbstractDao<T, ?> abstractDao) {
        this.f11495b.put(cls, abstractDao);
    }

    public <T> long insert(T t) {
        return getDao(t.getClass()).insert(t);
    }

    public <T> long insertOrReplace(T t) {
        return getDao(t.getClass()).insertOrReplace(t);
    }

    public <T> void refresh(T t) {
        getDao(t.getClass()).refresh(t);
    }

    public <T> void update(T t) {
        getDao(t.getClass()).update(t);
    }

    public <T> void delete(T t) {
        getDao(t.getClass()).delete(t);
    }

    public <T> void deleteAll(Class<T> cls) {
        getDao(cls).deleteAll();
    }

    public <T, K> T load(Class<T> cls, K k) {
        return getDao(cls).load(k);
    }

    public <T, K> List<T> loadAll(Class<T> cls) {
        return getDao(cls).loadAll();
    }

    public <T, K> List<T> queryRaw(Class<T> cls, String str, String... strArr) {
        return getDao(cls).queryRaw(str, strArr);
    }

    public <T> QueryBuilder<T> queryBuilder(Class<T> cls) {
        return getDao(cls).queryBuilder();
    }

    public AbstractDao<?, ?> getDao(Class<? extends Object> cls) {
        AbstractDao<?, ?> abstractDao = this.f11495b.get(cls);
        if (abstractDao != null) {
            return abstractDao;
        }
        throw new DaoException("No DAO registered for " + cls);
    }

    public void runInTx(Runnable runnable) {
        this.f11494a.beginTransaction();
        try {
            runnable.run();
            this.f11494a.setTransactionSuccessful();
        } finally {
            this.f11494a.endTransaction();
        }
    }

    public <V> V callInTx(Callable<V> callable) throws Exception {
        this.f11494a.beginTransaction();
        try {
            V call = callable.call();
            this.f11494a.setTransactionSuccessful();
            return call;
        } finally {
            this.f11494a.endTransaction();
        }
    }

    public <V> V callInTxNoException(Callable<V> callable) {
        this.f11494a.beginTransaction();
        try {
            V call = callable.call();
            this.f11494a.setTransactionSuccessful();
            this.f11494a.endTransaction();
            return call;
        } catch (Exception e) {
            throw new DaoException("Callable failed", e);
        } catch (Throwable th) {
            this.f11494a.endTransaction();
            throw th;
        }
    }

    public Database getDatabase() {
        return this.f11494a;
    }

    public Collection<AbstractDao<?, ?>> getAllDaos() {
        return Collections.unmodifiableCollection(this.f11495b.values());
    }

    public AsyncSession startAsyncSession() {
        return new AsyncSession(this);
    }
}
