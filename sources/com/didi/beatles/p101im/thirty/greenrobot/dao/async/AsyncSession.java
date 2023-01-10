package com.didi.beatles.p101im.thirty.greenrobot.dao.async;

import com.didi.beatles.p101im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p101im.thirty.greenrobot.dao.AbstractDaoSession;
import com.didi.beatles.p101im.thirty.greenrobot.dao.async.AsyncOperation;
import com.didi.beatles.p101im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p101im.thirty.greenrobot.dao.query.Query;
import java.util.concurrent.Callable;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncSession */
public class AsyncSession {

    /* renamed from: a */
    private final AbstractDaoSession f11512a;

    /* renamed from: b */
    private final C4777a f11513b = new C4777a();

    /* renamed from: c */
    private int f11514c;

    public AsyncSession(AbstractDaoSession abstractDaoSession) {
        this.f11512a = abstractDaoSession;
    }

    public int getMaxOperationCountToMerge() {
        return this.f11513b.mo48451a();
    }

    public void setMaxOperationCountToMerge(int i) {
        this.f11513b.mo48452a(i);
    }

    public int getWaitForMergeMillis() {
        return this.f11513b.mo48455b();
    }

    public void setWaitForMergeMillis(int i) {
        this.f11513b.mo48456b(i);
    }

    public AsyncOperationListener getListener() {
        return this.f11513b.mo48458c();
    }

    public void setListener(AsyncOperationListener asyncOperationListener) {
        this.f11513b.mo48454a(asyncOperationListener);
    }

    public AsyncOperationListener getListenerMainThread() {
        return this.f11513b.mo48460d();
    }

    public void setListenerMainThread(AsyncOperationListener asyncOperationListener) {
        this.f11513b.mo48457b(asyncOperationListener);
    }

    public boolean isCompleted() {
        return this.f11513b.mo48461e();
    }

    public void waitForCompletion() {
        this.f11513b.mo48462f();
    }

    public boolean waitForCompletion(int i) {
        return this.f11513b.mo48459c(i);
    }

    public AsyncOperation insert(Object obj) {
        return insert(obj, 0);
    }

    public AsyncOperation insert(Object obj, int i) {
        return m9937b(AsyncOperation.OperationType.Insert, obj, i);
    }

    public <E> AsyncOperation insertInTx(Class<E> cls, E... eArr) {
        return insertInTx(cls, 0, eArr);
    }

    public <E> AsyncOperation insertInTx(Class<E> cls, int i, E... eArr) {
        return m9935a(AsyncOperation.OperationType.InsertInTxArray, cls, eArr, i);
    }

    public <E> AsyncOperation insertInTx(Class<E> cls, Iterable<E> iterable) {
        return insertInTx(cls, iterable, 0);
    }

    public <E> AsyncOperation insertInTx(Class<E> cls, Iterable<E> iterable, int i) {
        return m9935a(AsyncOperation.OperationType.InsertInTxIterable, cls, iterable, i);
    }

    public AsyncOperation insertOrReplace(Object obj) {
        return insertOrReplace(obj, 0);
    }

    public AsyncOperation insertOrReplace(Object obj, int i) {
        return m9937b(AsyncOperation.OperationType.InsertOrReplace, obj, i);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> cls, E... eArr) {
        return insertOrReplaceInTx(cls, 0, eArr);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> cls, int i, E... eArr) {
        return m9935a(AsyncOperation.OperationType.InsertOrReplaceInTxArray, cls, eArr, i);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> cls, Iterable<E> iterable) {
        return insertOrReplaceInTx(cls, iterable, 0);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> cls, Iterable<E> iterable, int i) {
        return m9935a(AsyncOperation.OperationType.InsertOrReplaceInTxIterable, cls, iterable, i);
    }

    public AsyncOperation update(Object obj) {
        return update(obj, 0);
    }

    public AsyncOperation update(Object obj, int i) {
        return m9937b(AsyncOperation.OperationType.Update, obj, i);
    }

    public <E> AsyncOperation updateInTx(Class<E> cls, E... eArr) {
        return updateInTx(cls, 0, eArr);
    }

    public <E> AsyncOperation updateInTx(Class<E> cls, int i, E... eArr) {
        return m9935a(AsyncOperation.OperationType.UpdateInTxArray, cls, eArr, i);
    }

    public <E> AsyncOperation updateInTx(Class<E> cls, Iterable<E> iterable) {
        return updateInTx(cls, iterable, 0);
    }

    public <E> AsyncOperation updateInTx(Class<E> cls, Iterable<E> iterable, int i) {
        return m9935a(AsyncOperation.OperationType.UpdateInTxIterable, cls, iterable, i);
    }

    public AsyncOperation delete(Object obj) {
        return delete(obj, 0);
    }

    public AsyncOperation delete(Object obj, int i) {
        return m9937b(AsyncOperation.OperationType.Delete, obj, i);
    }

    public AsyncOperation deleteByKey(Object obj) {
        return deleteByKey(obj, 0);
    }

    public AsyncOperation deleteByKey(Object obj, int i) {
        return m9937b(AsyncOperation.OperationType.DeleteByKey, obj, i);
    }

    public <E> AsyncOperation deleteInTx(Class<E> cls, E... eArr) {
        return deleteInTx(cls, 0, eArr);
    }

    public <E> AsyncOperation deleteInTx(Class<E> cls, int i, E... eArr) {
        return m9935a(AsyncOperation.OperationType.DeleteInTxArray, cls, eArr, i);
    }

    public <E> AsyncOperation deleteInTx(Class<E> cls, Iterable<E> iterable) {
        return deleteInTx(cls, iterable, 0);
    }

    public <E> AsyncOperation deleteInTx(Class<E> cls, Iterable<E> iterable, int i) {
        return m9935a(AsyncOperation.OperationType.DeleteInTxIterable, cls, iterable, i);
    }

    public <E> AsyncOperation deleteAll(Class<E> cls) {
        return deleteAll(cls, 0);
    }

    public <E> AsyncOperation deleteAll(Class<E> cls, int i) {
        return m9935a(AsyncOperation.OperationType.DeleteAll, cls, (Object) null, i);
    }

    public AsyncOperation runInTx(Runnable runnable) {
        return runInTx(runnable, 0);
    }

    public AsyncOperation runInTx(Runnable runnable, int i) {
        return m9936a(AsyncOperation.OperationType.TransactionRunnable, runnable, i);
    }

    public AsyncOperation callInTx(Callable<?> callable) {
        return callInTx(callable, 0);
    }

    public AsyncOperation callInTx(Callable<?> callable, int i) {
        return m9936a(AsyncOperation.OperationType.TransactionCallable, callable, i);
    }

    public AsyncOperation queryList(Query<?> query) {
        return queryList(query, 0);
    }

    public AsyncOperation queryList(Query<?> query, int i) {
        return m9936a(AsyncOperation.OperationType.QueryList, query, i);
    }

    public AsyncOperation queryUnique(Query<?> query) {
        return queryUnique(query, 0);
    }

    public AsyncOperation queryUnique(Query<?> query, int i) {
        return m9936a(AsyncOperation.OperationType.QueryUnique, query, i);
    }

    public AsyncOperation load(Class<?> cls, Object obj) {
        return load(cls, obj, 0);
    }

    public AsyncOperation load(Class<?> cls, Object obj, int i) {
        return m9935a(AsyncOperation.OperationType.Load, cls, obj, i);
    }

    public AsyncOperation loadAll(Class<?> cls) {
        return loadAll(cls, 0);
    }

    public AsyncOperation loadAll(Class<?> cls, int i) {
        return m9935a(AsyncOperation.OperationType.LoadAll, cls, (Object) null, i);
    }

    public AsyncOperation count(Class<?> cls) {
        return count(cls, 0);
    }

    public AsyncOperation count(Class<?> cls, int i) {
        return m9935a(AsyncOperation.OperationType.Count, cls, (Object) null, i);
    }

    public AsyncOperation refresh(Object obj) {
        return refresh(obj, 0);
    }

    public AsyncOperation refresh(Object obj, int i) {
        return m9937b(AsyncOperation.OperationType.Refresh, obj, i);
    }

    /* renamed from: a */
    private AsyncOperation m9936a(AsyncOperation.OperationType operationType, Object obj, int i) {
        AsyncOperation asyncOperation = new AsyncOperation(operationType, (AbstractDao<?, ?>) null, this.f11512a.getDatabase(), obj, i | this.f11514c);
        this.f11513b.mo48453a(asyncOperation);
        return asyncOperation;
    }

    /* renamed from: b */
    private AsyncOperation m9937b(AsyncOperation.OperationType operationType, Object obj, int i) {
        return m9935a(operationType, obj.getClass(), obj, i);
    }

    /* renamed from: a */
    private <E> AsyncOperation m9935a(AsyncOperation.OperationType operationType, Class<E> cls, Object obj, int i) {
        AsyncOperation asyncOperation = new AsyncOperation(operationType, this.f11512a.getDao(cls), (Database) null, obj, i | this.f11514c);
        this.f11513b.mo48453a(asyncOperation);
        return asyncOperation;
    }

    public int getSessionFlags() {
        return this.f11514c;
    }

    public void setSessionFlags(int i) {
        this.f11514c = i;
    }
}
