package com.didi.beatles.p101im.thirty.greenrobot.dao;

import android.database.Cursor;
import com.didi.beatles.p101im.thirty.greenrobot.dao.internal.TableStatements;
import java.util.List;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.InternalQueryDaoAccess */
public final class InternalQueryDaoAccess<T> {

    /* renamed from: a */
    private final AbstractDao<T, ?> f11497a;

    public InternalQueryDaoAccess(AbstractDao<T, ?> abstractDao) {
        this.f11497a = abstractDao;
    }

    public T loadCurrent(Cursor cursor, int i, boolean z) {
        return this.f11497a.loadCurrent(cursor, i, z);
    }

    public List<T> loadAllAndCloseCursor(Cursor cursor) {
        return this.f11497a.loadAllAndCloseCursor(cursor);
    }

    public T loadUniqueAndCloseCursor(Cursor cursor) {
        return this.f11497a.loadUniqueAndCloseCursor(cursor);
    }

    public TableStatements getStatements() {
        return this.f11497a.getStatements();
    }

    public static <T2> TableStatements getStatements(AbstractDao<T2, ?> abstractDao) {
        return abstractDao.getStatements();
    }
}
