package com.didi.beatles.p101im.thirty.greenrobot.dao.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.beatles.p101im.thirty.greenrobot.dao.DaoException;
import com.didi.beatles.p101im.thirty.greenrobot.dao.DaoLog;
import com.didi.beatles.p101im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p101im.thirty.greenrobot.dao.query.Query;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.async.a */
/* compiled from: AsyncOperationExecutor */
class C4777a implements Handler.Callback, Runnable {

    /* renamed from: a */
    private static ExecutorService f11515a = Executors.newCachedThreadPool();

    /* renamed from: b */
    private final BlockingQueue<AsyncOperation> f11516b = new LinkedBlockingQueue();

    /* renamed from: c */
    private volatile boolean f11517c;

    /* renamed from: d */
    private volatile int f11518d = 50;

    /* renamed from: e */
    private volatile AsyncOperationListener f11519e;

    /* renamed from: f */
    private volatile AsyncOperationListener f11520f;

    /* renamed from: g */
    private volatile int f11521g = 50;

    /* renamed from: h */
    private int f11522h;

    /* renamed from: i */
    private int f11523i;

    /* renamed from: j */
    private Handler f11524j;

    /* renamed from: k */
    private int f11525k;

    C4777a() {
    }

    /* renamed from: a */
    public void mo48453a(AsyncOperation asyncOperation) {
        synchronized (this) {
            int i = this.f11525k + 1;
            this.f11525k = i;
            asyncOperation.f11508k = i;
            this.f11516b.add(asyncOperation);
            this.f11522h++;
            if (!this.f11517c) {
                this.f11517c = true;
                f11515a.execute(this);
            }
        }
    }

    /* renamed from: a */
    public int mo48451a() {
        return this.f11518d;
    }

    /* renamed from: a */
    public void mo48452a(int i) {
        this.f11518d = i;
    }

    /* renamed from: b */
    public int mo48455b() {
        return this.f11521g;
    }

    /* renamed from: b */
    public void mo48456b(int i) {
        this.f11521g = i;
    }

    /* renamed from: c */
    public AsyncOperationListener mo48458c() {
        return this.f11519e;
    }

    /* renamed from: a */
    public void mo48454a(AsyncOperationListener asyncOperationListener) {
        this.f11519e = asyncOperationListener;
    }

    /* renamed from: d */
    public AsyncOperationListener mo48460d() {
        return this.f11520f;
    }

    /* renamed from: b */
    public void mo48457b(AsyncOperationListener asyncOperationListener) {
        this.f11520f = asyncOperationListener;
    }

    /* renamed from: e */
    public synchronized boolean mo48461e() {
        return this.f11522h == this.f11523i;
    }

    /* renamed from: f */
    public synchronized void mo48462f() {
        while (!mo48461e()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e);
            }
        }
    }

    /* renamed from: c */
    public synchronized boolean mo48459c(int i) {
        if (!mo48461e()) {
            try {
                wait((long) i);
            } catch (InterruptedException e) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e);
            }
        }
        return mo48461e();
    }

    public void run() {
        AsyncOperation poll;
        while (true) {
            try {
                AsyncOperation poll2 = this.f11516b.poll(1, TimeUnit.SECONDS);
                if (poll2 == null) {
                    synchronized (this) {
                        poll2 = (AsyncOperation) this.f11516b.poll();
                        if (poll2 == null) {
                            this.f11517c = false;
                            this.f11517c = false;
                            return;
                        }
                    }
                }
                if (!poll2.isMergeTx() || (poll = this.f11516b.poll((long) this.f11521g, TimeUnit.MILLISECONDS)) == null) {
                    m9940c(poll2);
                } else if (poll2.mo48373a(poll)) {
                    m9938a(poll2, poll);
                } else {
                    m9940c(poll2);
                    m9940c(poll);
                }
            } catch (InterruptedException e) {
                try {
                    DaoLog.m9922w(Thread.currentThread().getName() + " was interruppted", e);
                    return;
                } finally {
                    this.f11517c = false;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        r4 = false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9938a(com.didi.beatles.p101im.thirty.greenrobot.dao.async.AsyncOperation r8, com.didi.beatles.p101im.thirty.greenrobot.dao.async.AsyncOperation r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Async transaction could not be ended, success so far was: "
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.add(r8)
            r1.add(r9)
            com.didi.beatles.im.thirty.greenrobot.dao.database.Database r8 = r8.mo48372a()
            r8.beginTransaction()
            r9 = 0
            r2 = 0
        L_0x0016:
            int r3 = r1.size()     // Catch:{ all -> 0x00b5 }
            r4 = 1
            if (r2 >= r3) goto L_0x0063
            java.lang.Object r3 = r1.get(r2)     // Catch:{ all -> 0x00b5 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation r3 = (com.didi.beatles.p101im.thirty.greenrobot.dao.async.AsyncOperation) r3     // Catch:{ all -> 0x00b5 }
            r7.m9941d(r3)     // Catch:{ all -> 0x00b5 }
            boolean r5 = r3.isFailed()     // Catch:{ all -> 0x00b5 }
            if (r5 == 0) goto L_0x002d
            goto L_0x0063
        L_0x002d:
            int r5 = r1.size()     // Catch:{ all -> 0x00b5 }
            int r5 = r5 - r4
            if (r2 != r5) goto L_0x0060
            java.util.concurrent.BlockingQueue<com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation> r5 = r7.f11516b     // Catch:{ all -> 0x00b5 }
            java.lang.Object r5 = r5.peek()     // Catch:{ all -> 0x00b5 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation r5 = (com.didi.beatles.p101im.thirty.greenrobot.dao.async.AsyncOperation) r5     // Catch:{ all -> 0x00b5 }
            int r6 = r7.f11518d     // Catch:{ all -> 0x00b5 }
            if (r2 >= r6) goto L_0x005c
            boolean r3 = r3.mo48373a(r5)     // Catch:{ all -> 0x00b5 }
            if (r3 == 0) goto L_0x005c
            java.util.concurrent.BlockingQueue<com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation> r3 = r7.f11516b     // Catch:{ all -> 0x00b5 }
            java.lang.Object r3 = r3.remove()     // Catch:{ all -> 0x00b5 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation r3 = (com.didi.beatles.p101im.thirty.greenrobot.dao.async.AsyncOperation) r3     // Catch:{ all -> 0x00b5 }
            if (r3 != r5) goto L_0x0054
            r1.add(r3)     // Catch:{ all -> 0x00b5 }
            goto L_0x0060
        L_0x0054:
            com.didi.beatles.im.thirty.greenrobot.dao.DaoException r1 = new com.didi.beatles.im.thirty.greenrobot.dao.DaoException     // Catch:{ all -> 0x00b5 }
            java.lang.String r2 = "Internal error: peeked op did not match removed op"
            r1.<init>((java.lang.String) r2)     // Catch:{ all -> 0x00b5 }
            throw r1     // Catch:{ all -> 0x00b5 }
        L_0x005c:
            r8.setTransactionSuccessful()     // Catch:{ all -> 0x00b5 }
            goto L_0x0064
        L_0x0060:
            int r2 = r2 + 1
            goto L_0x0016
        L_0x0063:
            r4 = 0
        L_0x0064:
            r8.endTransaction()     // Catch:{ RuntimeException -> 0x0069 }
            r9 = r4
            goto L_0x007c
        L_0x0069:
            r8 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r4)
            java.lang.String r0 = r2.toString()
            com.didi.beatles.p101im.thirty.greenrobot.dao.DaoLog.m9918i(r0, r8)
        L_0x007c:
            if (r9 == 0) goto L_0x0098
            int r8 = r1.size()
            java.util.Iterator r9 = r1.iterator()
        L_0x0086:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x00b4
            java.lang.Object r0 = r9.next()
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation r0 = (com.didi.beatles.p101im.thirty.greenrobot.dao.async.AsyncOperation) r0
            r0.f11507j = r8
            r7.m9939b((com.didi.beatles.p101im.thirty.greenrobot.dao.async.AsyncOperation) r0)
            goto L_0x0086
        L_0x0098:
            java.lang.String r8 = "Reverted merged transaction because one of the operations failed. Executing operations one by one instead..."
            com.didi.beatles.p101im.thirty.greenrobot.dao.DaoLog.m9917i(r8)
            java.util.Iterator r8 = r1.iterator()
        L_0x00a1:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00b4
            java.lang.Object r9 = r8.next()
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation r9 = (com.didi.beatles.p101im.thirty.greenrobot.dao.async.AsyncOperation) r9
            r9.mo48375c()
            r7.m9940c((com.didi.beatles.p101im.thirty.greenrobot.dao.async.AsyncOperation) r9)
            goto L_0x00a1
        L_0x00b4:
            return
        L_0x00b5:
            r1 = move-exception
            r8.endTransaction()     // Catch:{ RuntimeException -> 0x00ba }
            goto L_0x00cd
        L_0x00ba:
            r8 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            com.didi.beatles.p101im.thirty.greenrobot.dao.DaoLog.m9918i(r9, r8)
        L_0x00cd:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.thirty.greenrobot.dao.async.C4777a.m9938a(com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation, com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation):void");
    }

    /* renamed from: b */
    private void m9939b(AsyncOperation asyncOperation) {
        asyncOperation.mo48374b();
        AsyncOperationListener asyncOperationListener = this.f11519e;
        if (asyncOperationListener != null) {
            asyncOperationListener.onAsyncOperationCompleted(asyncOperation);
        }
        if (this.f11520f != null) {
            if (this.f11524j == null) {
                this.f11524j = new Handler(Looper.getMainLooper(), this);
            }
            this.f11524j.sendMessage(this.f11524j.obtainMessage(1, asyncOperation));
        }
        synchronized (this) {
            int i = this.f11523i + 1;
            this.f11523i = i;
            if (i == this.f11522h) {
                notifyAll();
            }
        }
    }

    /* renamed from: c */
    private void m9940c(AsyncOperation asyncOperation) {
        m9941d(asyncOperation);
        m9939b(asyncOperation);
    }

    /* renamed from: d */
    private void m9941d(AsyncOperation asyncOperation) {
        asyncOperation.f11502e = System.currentTimeMillis();
        try {
            switch (AsyncOperationExecutor$1.f11511xb6843a26[asyncOperation.f11498a.ordinal()]) {
                case 1:
                    asyncOperation.f11499b.delete(asyncOperation.f11500c);
                    break;
                case 2:
                    asyncOperation.f11499b.deleteInTx((Iterable) asyncOperation.f11500c);
                    break;
                case 3:
                    asyncOperation.f11499b.deleteInTx((T[]) (Object[]) asyncOperation.f11500c);
                    break;
                case 4:
                    asyncOperation.f11499b.insert(asyncOperation.f11500c);
                    break;
                case 5:
                    asyncOperation.f11499b.insertInTx((Iterable) asyncOperation.f11500c);
                    break;
                case 6:
                    asyncOperation.f11499b.insertInTx((T[]) (Object[]) asyncOperation.f11500c);
                    break;
                case 7:
                    asyncOperation.f11499b.insertOrReplace(asyncOperation.f11500c);
                    break;
                case 8:
                    asyncOperation.f11499b.insertOrReplaceInTx((Iterable) asyncOperation.f11500c);
                    break;
                case 9:
                    asyncOperation.f11499b.insertOrReplaceInTx((T[]) (Object[]) asyncOperation.f11500c);
                    break;
                case 10:
                    asyncOperation.f11499b.update(asyncOperation.f11500c);
                    break;
                case 11:
                    asyncOperation.f11499b.updateInTx((Iterable) asyncOperation.f11500c);
                    break;
                case 12:
                    asyncOperation.f11499b.updateInTx((T[]) (Object[]) asyncOperation.f11500c);
                    break;
                case 13:
                    m9942e(asyncOperation);
                    break;
                case 14:
                    m9943f(asyncOperation);
                    break;
                case 15:
                    asyncOperation.f11506i = ((Query) asyncOperation.f11500c).forCurrentThread().list();
                    break;
                case 16:
                    asyncOperation.f11506i = ((Query) asyncOperation.f11500c).forCurrentThread().unique();
                    break;
                case 17:
                    asyncOperation.f11499b.deleteByKey(asyncOperation.f11500c);
                    break;
                case 18:
                    asyncOperation.f11499b.deleteAll();
                    break;
                case 19:
                    asyncOperation.f11506i = asyncOperation.f11499b.load(asyncOperation.f11500c);
                    break;
                case 20:
                    asyncOperation.f11506i = asyncOperation.f11499b.loadAll();
                    break;
                case 21:
                    asyncOperation.f11506i = Long.valueOf(asyncOperation.f11499b.count());
                    break;
                case 22:
                    asyncOperation.f11499b.refresh(asyncOperation.f11500c);
                    break;
                default:
                    throw new DaoException("Unsupported operation: " + asyncOperation.f11498a);
            }
        } catch (Throwable th) {
            asyncOperation.f11504g = th;
        }
        asyncOperation.f11503f = System.currentTimeMillis();
    }

    /* renamed from: e */
    private void m9942e(AsyncOperation asyncOperation) {
        Database a = asyncOperation.mo48372a();
        a.beginTransaction();
        try {
            ((Runnable) asyncOperation.f11500c).run();
            a.setTransactionSuccessful();
        } finally {
            a.endTransaction();
        }
    }

    /* renamed from: f */
    private void m9943f(AsyncOperation asyncOperation) throws Exception {
        Database a = asyncOperation.mo48372a();
        a.beginTransaction();
        try {
            asyncOperation.f11506i = ((Callable) asyncOperation.f11500c).call();
            a.setTransactionSuccessful();
        } finally {
            a.endTransaction();
        }
    }

    public boolean handleMessage(Message message) {
        AsyncOperationListener asyncOperationListener = this.f11520f;
        if (asyncOperationListener == null) {
            return false;
        }
        asyncOperationListener.onAsyncOperationCompleted((AsyncOperation) message.obj);
        return false;
    }
}
