package com.didi.beatles.p101im.thirty.greenrobot.dao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.didi.beatles.p101im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p101im.thirty.greenrobot.dao.database.DatabaseStatement;
import com.didi.beatles.p101im.thirty.greenrobot.dao.identityscope.IdentityScope;
import com.didi.beatles.p101im.thirty.greenrobot.dao.identityscope.IdentityScopeLong;
import com.didi.beatles.p101im.thirty.greenrobot.dao.internal.DaoConfig;
import com.didi.beatles.p101im.thirty.greenrobot.dao.internal.FastCursor;
import com.didi.beatles.p101im.thirty.greenrobot.dao.internal.TableStatements;
import com.didi.beatles.p101im.thirty.greenrobot.dao.query.Query;
import com.didi.beatles.p101im.thirty.greenrobot.dao.query.QueryBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.AbstractDao */
public abstract class AbstractDao<T, K> {
    protected final DaoConfig config;

    /* renamed from: db */
    protected final Database f11492db;
    protected IdentityScope<K, T> identityScope;
    protected IdentityScopeLong<T> identityScopeLong;
    protected final int pkOrdinal;
    protected final AbstractDaoSession session;
    protected TableStatements statements;

    /* access modifiers changed from: protected */
    public void attachEntity(T t) {
    }

    /* access modifiers changed from: protected */
    public abstract void bindValues(DatabaseStatement databaseStatement, T t);

    /* access modifiers changed from: protected */
    public abstract K getKey(T t);

    /* access modifiers changed from: protected */
    public abstract boolean isEntityUpdateable();

    /* access modifiers changed from: protected */
    public abstract T readEntity(Cursor cursor, int i);

    /* access modifiers changed from: protected */
    public abstract void readEntity(Cursor cursor, T t, int i);

    /* access modifiers changed from: protected */
    public abstract K readKey(Cursor cursor, int i);

    /* access modifiers changed from: protected */
    public abstract K updateKeyAfterInsert(T t, long j);

    public AbstractDao(DaoConfig daoConfig) {
        this(daoConfig, (AbstractDaoSession) null);
    }

    public AbstractDao(DaoConfig daoConfig, AbstractDaoSession abstractDaoSession) {
        this.config = daoConfig;
        this.session = abstractDaoSession;
        this.f11492db = daoConfig.f11533db;
        IdentityScope<?, ?> identityScope2 = daoConfig.getIdentityScope();
        this.identityScope = identityScope2;
        if (identityScope2 instanceof IdentityScopeLong) {
            this.identityScopeLong = (IdentityScopeLong) identityScope2;
        }
        this.statements = daoConfig.statements;
        this.pkOrdinal = daoConfig.pkProperty != null ? daoConfig.pkProperty.ordinal : -1;
    }

    public AbstractDaoSession getSession() {
        return this.session;
    }

    /* access modifiers changed from: package-private */
    public TableStatements getStatements() {
        return this.config.statements;
    }

    public String getTablename() {
        return this.config.tablename;
    }

    public Property[] getProperties() {
        return this.config.properties;
    }

    public Property getPkProperty() {
        return this.config.pkProperty;
    }

    public String[] getAllColumns() {
        return this.config.allColumns;
    }

    public String[] getPkColumns() {
        return this.config.pkColumns;
    }

    public String[] getNonPkColumns() {
        return this.config.nonPkColumns;
    }

    public T load(K k) {
        T t;
        assertSinglePk();
        if (k == null) {
            return null;
        }
        IdentityScope<K, T> identityScope2 = this.identityScope;
        if (identityScope2 != null && (t = identityScope2.get(k)) != null) {
            return t;
        }
        return loadUniqueAndCloseCursor(this.f11492db.rawQuery(this.statements.getSelectByKey(), new String[]{k.toString()}));
    }

    public T loadByRowId(long j) {
        return loadUniqueAndCloseCursor(this.f11492db.rawQuery(this.statements.getSelectByRowId(), new String[]{Long.toString(j)}));
    }

    /* access modifiers changed from: protected */
    public T loadUniqueAndCloseCursor(Cursor cursor) {
        try {
            return loadUnique(cursor);
        } finally {
            cursor.close();
        }
    }

    /* access modifiers changed from: protected */
    public T loadUnique(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return null;
        }
        if (cursor.isLast()) {
            return loadCurrent(cursor, 0, true);
        }
        throw new DaoException("Expected unique result, but count was " + cursor.getCount());
    }

    public List<T> loadAll() {
        return loadAllAndCloseCursor(this.f11492db.rawQuery(this.statements.getSelectAll(), (String[]) null));
    }

    public boolean detach(T t) {
        if (this.identityScope == null) {
            return false;
        }
        return this.identityScope.detach(getKeyVerified(t), t);
    }

    /* access modifiers changed from: protected */
    public List<T> loadAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }

    public void insertInTx(Iterable<T> iterable) {
        insertInTx(iterable, isEntityUpdateable());
    }

    public void insertInTx(T... tArr) {
        insertInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    public void insertInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertStatement(), iterable, z);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertOrReplaceStatement(), iterable, z);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable) {
        insertOrReplaceInTx(iterable, isEntityUpdateable());
    }

    public void insertOrReplaceInTx(T... tArr) {
        insertOrReplaceInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    private void executeInsertInTx(DatabaseStatement databaseStatement, Iterable<T> iterable, boolean z) {
        this.f11492db.beginTransaction();
        try {
            synchronized (databaseStatement) {
                if (this.identityScope != null) {
                    this.identityScope.lock();
                }
                try {
                    for (T next : iterable) {
                        bindValues(databaseStatement, next);
                        if (z) {
                            updateKeyAfterInsertAndAttach(next, databaseStatement.executeInsert(), false);
                        } else {
                            databaseStatement.execute();
                        }
                    }
                } finally {
                    if (this.identityScope != null) {
                        this.identityScope.unlock();
                    }
                }
            }
            this.f11492db.setTransactionSuccessful();
        } finally {
            this.f11492db.endTransaction();
        }
    }

    public long insert(T t) {
        return executeInsert(t, this.statements.getInsertStatement());
    }

    public long insertWithoutSettingPk(T t) {
        long j;
        DatabaseStatement insertStatement = this.statements.getInsertStatement();
        if (this.f11492db.isDbLockedByCurrentThread()) {
            synchronized (insertStatement) {
                bindValues(insertStatement, t);
                j = insertStatement.executeInsert();
            }
        } else {
            this.f11492db.beginTransaction();
            try {
                synchronized (insertStatement) {
                    bindValues(insertStatement, t);
                    j = insertStatement.executeInsert();
                }
                this.f11492db.setTransactionSuccessful();
                this.f11492db.endTransaction();
            } catch (Throwable th) {
                this.f11492db.endTransaction();
                throw th;
            }
        }
        return j;
    }

    public long insertOrReplace(T t) {
        return executeInsert(t, this.statements.getInsertOrReplaceStatement());
    }

    private long executeInsert(T t, DatabaseStatement databaseStatement) {
        long j;
        if (this.f11492db.isDbLockedByCurrentThread()) {
            synchronized (databaseStatement) {
                bindValues(databaseStatement, t);
                j = databaseStatement.executeInsert();
            }
        } else {
            this.f11492db.beginTransaction();
            try {
                synchronized (databaseStatement) {
                    bindValues(databaseStatement, t);
                    j = databaseStatement.executeInsert();
                }
                this.f11492db.setTransactionSuccessful();
                this.f11492db.endTransaction();
            } catch (Throwable th) {
                this.f11492db.endTransaction();
                throw th;
            }
        }
        updateKeyAfterInsertAndAttach(t, j, true);
        return j;
    }

    /* access modifiers changed from: protected */
    public void updateKeyAfterInsertAndAttach(T t, long j, boolean z) {
        if (j != -1) {
            attachEntity(updateKeyAfterInsert(t, j), t, z);
        } else {
            DaoLog.m9921w("Could not insert row (executeInsert returned -1)");
        }
    }

    /* access modifiers changed from: protected */
    public List<T> loadAllFromCursor(Cursor cursor) {
        CursorWindow window;
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList(count);
        if ((cursor instanceof CrossProcessCursor) && (window = ((CrossProcessCursor) cursor).getWindow()) != null) {
            if (window.getNumRows() == count) {
                cursor = new FastCursor(window);
            } else {
                DaoLog.m9913d("Window vs. result size: " + window.getNumRows() + "/" + count);
            }
        }
        if (cursor.moveToFirst()) {
            IdentityScope<K, T> identityScope2 = this.identityScope;
            if (identityScope2 != null) {
                identityScope2.lock();
                this.identityScope.reserveRoom(count);
            }
            do {
                try {
                    arrayList.add(loadCurrent(cursor, 0, false));
                } finally {
                    IdentityScope<K, T> identityScope3 = this.identityScope;
                    if (identityScope3 != null) {
                        identityScope3.unlock();
                    }
                }
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public final T loadCurrent(Cursor cursor, int i, boolean z) {
        if (this.identityScopeLong != null) {
            if (i != 0 && cursor.isNull(this.pkOrdinal + i)) {
                return null;
            }
            long j = cursor.getLong(this.pkOrdinal + i);
            IdentityScopeLong<T> identityScopeLong2 = this.identityScopeLong;
            T r2 = z ? identityScopeLong2.get2(j) : identityScopeLong2.get2NoLock(j);
            if (r2 != null) {
                return r2;
            }
            T readEntity = readEntity(cursor, i);
            attachEntity(readEntity);
            if (z) {
                this.identityScopeLong.put2(j, readEntity);
            } else {
                this.identityScopeLong.put2NoLock(j, readEntity);
            }
            return readEntity;
        } else if (this.identityScope != null) {
            Object readKey = readKey(cursor, i);
            if (i != 0 && readKey == null) {
                return null;
            }
            IdentityScope<K, T> identityScope2 = this.identityScope;
            T noLock = z ? identityScope2.get(readKey) : identityScope2.getNoLock(readKey);
            if (noLock != null) {
                return noLock;
            }
            T readEntity2 = readEntity(cursor, i);
            attachEntity(readKey, readEntity2, z);
            return readEntity2;
        } else if (i != 0 && readKey(cursor, i) == null) {
            return null;
        } else {
            T readEntity3 = readEntity(cursor, i);
            attachEntity(readEntity3);
            return readEntity3;
        }
    }

    /* access modifiers changed from: protected */
    public final <O> O loadCurrentOther(AbstractDao<O, ?> abstractDao, Cursor cursor, int i) {
        return abstractDao.loadCurrent(cursor, i, true);
    }

    public List<T> queryRaw(String str, String... strArr) {
        Database database = this.f11492db;
        return loadAllAndCloseCursor(database.rawQuery(this.statements.getSelectAll() + str, strArr));
    }

    public Query<T> queryRawCreate(String str, Object... objArr) {
        return queryRawCreateListArgs(str, Arrays.asList(objArr));
    }

    public Query<T> queryRawCreateListArgs(String str, Collection<Object> collection) {
        return Query.internalCreate(this, this.statements.getSelectAll() + str, collection.toArray());
    }

    public void deleteAll() {
        Database database = this.f11492db;
        database.execSQL("DELETE FROM '" + this.config.tablename + "'");
        IdentityScope<K, T> identityScope2 = this.identityScope;
        if (identityScope2 != null) {
            identityScope2.clear();
        }
    }

    public void delete(T t) {
        assertSinglePk();
        deleteByKey(getKeyVerified(t));
    }

    public void deleteByKey(K k) {
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        if (this.f11492db.isDbLockedByCurrentThread()) {
            synchronized (deleteStatement) {
                deleteByKeyInsideSynchronized(k, deleteStatement);
            }
        } else {
            this.f11492db.beginTransaction();
            try {
                synchronized (deleteStatement) {
                    deleteByKeyInsideSynchronized(k, deleteStatement);
                }
                this.f11492db.setTransactionSuccessful();
                this.f11492db.endTransaction();
            } catch (Throwable th) {
                this.f11492db.endTransaction();
                throw th;
            }
        }
        IdentityScope<K, T> identityScope2 = this.identityScope;
        if (identityScope2 != null) {
            identityScope2.remove(k);
        }
    }

    private void deleteByKeyInsideSynchronized(K k, DatabaseStatement databaseStatement) {
        if (k instanceof Long) {
            databaseStatement.bindLong(1, ((Long) k).longValue());
        } else if (k != null) {
            databaseStatement.bindString(1, k.toString());
        } else {
            throw new DaoException("Cannot delete entity, key is null");
        }
        databaseStatement.execute();
    }

    private void deleteInTxInternal(Iterable<T> iterable, Iterable<K> iterable2) {
        ArrayList arrayList;
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        this.f11492db.beginTransaction();
        try {
            synchronized (deleteStatement) {
                if (this.identityScope != null) {
                    this.identityScope.lock();
                    arrayList = new ArrayList();
                } else {
                    arrayList = null;
                }
                if (iterable != null) {
                    try {
                        for (T keyVerified : iterable) {
                            Object keyVerified2 = getKeyVerified(keyVerified);
                            deleteByKeyInsideSynchronized(keyVerified2, deleteStatement);
                            if (arrayList != null) {
                                arrayList.add(keyVerified2);
                            }
                        }
                    } finally {
                        if (this.identityScope != null) {
                            this.identityScope.unlock();
                        }
                    }
                }
                if (iterable2 != null) {
                    for (K next : iterable2) {
                        deleteByKeyInsideSynchronized(next, deleteStatement);
                        if (arrayList != null) {
                            arrayList.add(next);
                        }
                    }
                }
                if (this.identityScope != null) {
                    this.identityScope.unlock();
                }
            }
            this.f11492db.setTransactionSuccessful();
            if (!(arrayList == null || this.identityScope == null)) {
                this.identityScope.remove(arrayList);
            }
        } finally {
            this.f11492db.endTransaction();
        }
    }

    public void deleteInTx(Iterable<T> iterable) {
        deleteInTxInternal(iterable, (Iterable) null);
    }

    public void deleteInTx(T... tArr) {
        deleteInTxInternal(Arrays.asList(tArr), (Iterable) null);
    }

    public void deleteByKeyInTx(Iterable<K> iterable) {
        deleteInTxInternal((Iterable) null, iterable);
    }

    public void deleteByKeyInTx(K... kArr) {
        deleteInTxInternal((Iterable) null, Arrays.asList(kArr));
    }

    public void refresh(T t) {
        assertSinglePk();
        Object keyVerified = getKeyVerified(t);
        Cursor rawQuery = this.f11492db.rawQuery(this.statements.getSelectByKey(), new String[]{keyVerified.toString()});
        try {
            if (!rawQuery.moveToFirst()) {
                throw new DaoException("Entity does not exist in the database anymore: " + t.getClass() + " with key " + keyVerified);
            } else if (rawQuery.isLast()) {
                readEntity(rawQuery, t, 0);
                attachEntity(keyVerified, t, true);
            } else {
                throw new DaoException("Expected unique result, but count was " + rawQuery.getCount());
            }
        } finally {
            rawQuery.close();
        }
    }

    public void update(T t) {
        assertSinglePk();
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        if (this.f11492db.isDbLockedByCurrentThread()) {
            synchronized (updateStatement) {
                updateInsideSynchronized(t, updateStatement, true);
            }
            return;
        }
        this.f11492db.beginTransaction();
        try {
            synchronized (updateStatement) {
                updateInsideSynchronized(t, updateStatement, true);
            }
            this.f11492db.setTransactionSuccessful();
            this.f11492db.endTransaction();
        } catch (Throwable th) {
            this.f11492db.endTransaction();
            throw th;
        }
    }

    public QueryBuilder<T> queryBuilder() {
        return QueryBuilder.internalCreate(this);
    }

    /* access modifiers changed from: protected */
    public void updateInsideSynchronized(T t, DatabaseStatement databaseStatement, boolean z) {
        bindValues(databaseStatement, t);
        int length = this.config.allColumns.length + 1;
        Object key = getKey(t);
        if (key instanceof Long) {
            databaseStatement.bindLong(length, ((Long) key).longValue());
        } else if (key != null) {
            databaseStatement.bindString(length, key.toString());
        } else {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        }
        databaseStatement.execute();
        attachEntity(key, t, z);
    }

    /* access modifiers changed from: protected */
    public final void attachEntity(K k, T t, boolean z) {
        attachEntity(t);
        IdentityScope<K, T> identityScope2 = this.identityScope;
        if (identityScope2 != null && k != null) {
            if (z) {
                identityScope2.put(k, t);
            } else {
                identityScope2.putNoLock(k, t);
            }
        }
    }

    public void updateInTx(Iterable<T> iterable) {
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        this.f11492db.beginTransaction();
        try {
            synchronized (updateStatement) {
                if (this.identityScope != null) {
                    this.identityScope.lock();
                }
                try {
                    for (T updateInsideSynchronized : iterable) {
                        updateInsideSynchronized(updateInsideSynchronized, updateStatement, false);
                    }
                } finally {
                    if (this.identityScope != null) {
                        this.identityScope.unlock();
                    }
                }
            }
            this.f11492db.setTransactionSuccessful();
            try {
                this.f11492db.endTransaction();
            } catch (RuntimeException e) {
                throw e;
            }
        } catch (RuntimeException e2) {
            try {
                this.f11492db.endTransaction();
            } catch (RuntimeException e3) {
                DaoLog.m9922w("Could not end transaction (rethrowing initial exception)", e3);
                throw e2;
            }
        } catch (Throwable th) {
            try {
                this.f11492db.endTransaction();
                throw th;
            } catch (RuntimeException e4) {
                throw e4;
            }
        }
    }

    public void updateInTx(T... tArr) {
        updateInTx(Arrays.asList(tArr));
    }

    /* access modifiers changed from: protected */
    public void assertSinglePk() {
        if (this.config.pkColumns.length != 1) {
            throw new DaoException(this + " (" + this.config.tablename + ") does not have a single-column primary key");
        }
    }

    public long count() {
        return DatabaseUtils.queryNumEntries((SQLiteDatabase) this.f11492db.getRawDatabase(), '\'' + this.config.tablename + '\'');
    }

    /* access modifiers changed from: protected */
    public K getKeyVerified(T t) {
        K key = getKey(t);
        if (key != null) {
            return key;
        }
        if (t == null) {
            throw new NullPointerException("Entity may not be null");
        }
        throw new DaoException("Entity has no key");
    }

    public Database getDatabase() {
        return this.f11492db;
    }
}
