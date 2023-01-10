package com.didi.beatles.p101im.thirty.greenrobot.dao.async;

import com.didi.beatles.p101im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p101im.thirty.greenrobot.dao.DaoException;
import com.didi.beatles.p101im.thirty.greenrobot.dao.database.Database;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation */
public class AsyncOperation {
    public static final int FLAG_MERGE_TX = 1;
    public static final int FLAG_STOP_QUEUE_ON_EXCEPTION = 2;
    public static final int FLAG_TRACK_CREATOR_STACKTRACE = 4;

    /* renamed from: a */
    final OperationType f11498a;

    /* renamed from: b */
    final AbstractDao<Object, Object> f11499b;

    /* renamed from: c */
    final Object f11500c;

    /* renamed from: d */
    final int f11501d;

    /* renamed from: e */
    volatile long f11502e;

    /* renamed from: f */
    volatile long f11503f;

    /* renamed from: g */
    volatile Throwable f11504g;

    /* renamed from: h */
    final Exception f11505h;

    /* renamed from: i */
    volatile Object f11506i;

    /* renamed from: j */
    volatile int f11507j;

    /* renamed from: k */
    int f11508k;

    /* renamed from: l */
    private final Database f11509l;

    /* renamed from: m */
    private volatile boolean f11510m;

    /* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType */
    public enum OperationType {
        Insert,
        InsertInTxIterable,
        InsertInTxArray,
        InsertOrReplace,
        InsertOrReplaceInTxIterable,
        InsertOrReplaceInTxArray,
        Update,
        UpdateInTxIterable,
        UpdateInTxArray,
        Delete,
        DeleteInTxIterable,
        DeleteInTxArray,
        DeleteByKey,
        DeleteAll,
        TransactionRunnable,
        TransactionCallable,
        QueryList,
        QueryUnique,
        Load,
        LoadAll,
        Count,
        Refresh
    }

    AsyncOperation(OperationType operationType, AbstractDao<?, ?> abstractDao, Database database, Object obj, int i) {
        this.f11498a = operationType;
        this.f11501d = i;
        this.f11499b = abstractDao;
        this.f11509l = database;
        this.f11500c = obj;
        this.f11505h = (i & 4) != 0 ? new Exception("AsyncOperation was created here") : null;
    }

    public Throwable getThrowable() {
        return this.f11504g;
    }

    public void setThrowable(Throwable th) {
        this.f11504g = th;
    }

    public OperationType getType() {
        return this.f11498a;
    }

    public Object getParameter() {
        return this.f11500c;
    }

    public synchronized Object getResult() {
        if (!this.f11510m) {
            waitForCompletion();
        }
        if (this.f11504g == null) {
        } else {
            throw new AsyncDaoException(this, this.f11504g);
        }
        return this.f11506i;
    }

    public boolean isMergeTx() {
        return (this.f11501d & 1) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Database mo48372a() {
        Database database = this.f11509l;
        return database != null ? database : this.f11499b.getDatabase();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo48373a(AsyncOperation asyncOperation) {
        return asyncOperation != null && isMergeTx() && asyncOperation.isMergeTx() && mo48372a() == asyncOperation.mo48372a();
    }

    public long getTimeStarted() {
        return this.f11502e;
    }

    public long getTimeCompleted() {
        return this.f11503f;
    }

    public long getDuration() {
        if (this.f11503f != 0) {
            return this.f11503f - this.f11502e;
        }
        throw new DaoException("This operation did not yet complete");
    }

    public boolean isFailed() {
        return this.f11504g != null;
    }

    public boolean isCompleted() {
        return this.f11510m;
    }

    public synchronized Object waitForCompletion() {
        while (!this.f11510m) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new DaoException("Interrupted while waiting for operation to complete", e);
            }
        }
        return this.f11506i;
    }

    public synchronized boolean waitForCompletion(int i) {
        if (!this.f11510m) {
            try {
                wait((long) i);
            } catch (InterruptedException e) {
                throw new DaoException("Interrupted while waiting for operation to complete", e);
            }
        }
        return this.f11510m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo48374b() {
        this.f11510m = true;
        notifyAll();
    }

    public boolean isCompletedSucessfully() {
        return this.f11510m && this.f11504g == null;
    }

    public int getMergedOperationsCount() {
        return this.f11507j;
    }

    public int getSequenceNumber() {
        return this.f11508k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo48375c() {
        this.f11502e = 0;
        this.f11503f = 0;
        this.f11510m = false;
        this.f11504g = null;
        this.f11506i = null;
        this.f11507j = 0;
    }

    public Exception getCreatorStacktrace() {
        return this.f11505h;
    }
}
