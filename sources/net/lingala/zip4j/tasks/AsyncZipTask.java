package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

public abstract class AsyncZipTask<T> {

    /* renamed from: a */
    private ProgressMonitor f6889a;

    /* renamed from: b */
    private boolean f6890b;

    /* renamed from: c */
    private ExecutorService f6891c;

    /* access modifiers changed from: protected */
    public abstract long calculateTotalWork(T t) throws ZipException;

    /* access modifiers changed from: protected */
    public abstract void executeTask(T t, ProgressMonitor progressMonitor) throws IOException;

    /* access modifiers changed from: protected */
    public abstract ProgressMonitor.Task getTask();

    public AsyncZipTask(AsyncTaskParameters asyncTaskParameters) {
        this.f6889a = asyncTaskParameters.progressMonitor;
        this.f6890b = asyncTaskParameters.runInThread;
        this.f6891c = asyncTaskParameters.executorService;
    }

    public void execute(T t) throws ZipException {
        this.f6889a.fullReset();
        this.f6889a.setState(ProgressMonitor.State.BUSY);
        this.f6889a.setCurrentTask(getTask());
        if (this.f6890b) {
            this.f6889a.setTotalWork(calculateTotalWork(t));
            this.f6891c.execute(new Runnable(t) {
                public final /* synthetic */ Object f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    AsyncZipTask.this.m6611a(this.f$1);
                }
            });
            return;
        }
        m6612a(t, this.f6889a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m6611a(Object obj) {
        try {
            m6612a(obj, this.f6889a);
        } catch (ZipException unused) {
        } catch (Throwable th) {
            this.f6891c.shutdown();
            throw th;
        }
        this.f6891c.shutdown();
    }

    /* renamed from: a */
    private void m6612a(T t, ProgressMonitor progressMonitor) throws ZipException {
        try {
            executeTask(t, progressMonitor);
            progressMonitor.endProgressMonitor();
        } catch (ZipException e) {
            progressMonitor.endProgressMonitor(e);
            throw e;
        } catch (Exception e2) {
            progressMonitor.endProgressMonitor(e2);
            throw new ZipException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void verifyIfTaskIsCancelled() throws ZipException {
        if (this.f6889a.isCancelAllTasks()) {
            this.f6889a.setResult(ProgressMonitor.Result.CANCELLED);
            this.f6889a.setState(ProgressMonitor.State.READY);
            throw new ZipException("Task cancelled", ZipException.Type.TASK_CANCELLED_EXCEPTION);
        }
    }

    public static class AsyncTaskParameters {
        /* access modifiers changed from: private */
        public ExecutorService executorService;
        /* access modifiers changed from: private */
        public ProgressMonitor progressMonitor;
        /* access modifiers changed from: private */
        public boolean runInThread;

        public AsyncTaskParameters(ExecutorService executorService2, boolean z, ProgressMonitor progressMonitor2) {
            this.executorService = executorService2;
            this.runInThread = z;
            this.progressMonitor = progressMonitor2;
        }
    }
}
