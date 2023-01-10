package com.didi.beatles.p101im.thirty.greenrobot.dao.query;

import com.didi.beatles.p101im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p101im.thirty.greenrobot.dao.database.Database;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.DeleteQuery */
public class DeleteQuery<T> extends C4782a<T> {

    /* renamed from: a */
    private final QueryData<T> f11556a;

    public /* bridge */ /* synthetic */ void setParameter(int i, Object obj) {
        super.setParameter(i, obj);
    }

    /* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.DeleteQuery$QueryData */
    private static final class QueryData<T2> extends C4783b<T2, DeleteQuery<T2>> {
        private QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr) {
            super(abstractDao, str, strArr);
        }

        /* access modifiers changed from: protected */
        public DeleteQuery<T2> createQuery() {
            return new DeleteQuery(this, this.dao, this.sql, (String[]) this.initialValues.clone());
        }
    }

    /* renamed from: a */
    static <T2> DeleteQuery<T2> m9959a(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return (DeleteQuery) new QueryData(abstractDao, str, toStringArray(objArr)).forCurrentThread();
    }

    private DeleteQuery(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        super(abstractDao, str, strArr);
        this.f11556a = queryData;
    }

    public DeleteQuery<T> forCurrentThread() {
        return (DeleteQuery) this.f11556a.forCurrentThread(this);
    }

    public void executeDeleteWithoutDetachingEntities() {
        checkThread();
        Database database = this.dao.getDatabase();
        if (database.isDbLockedByCurrentThread()) {
            this.dao.getDatabase().execSQL(this.sql, this.parameters);
            return;
        }
        database.beginTransaction();
        try {
            this.dao.getDatabase().execSQL(this.sql, this.parameters);
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }
}
