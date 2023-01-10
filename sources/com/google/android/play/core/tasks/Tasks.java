package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.C20046aw;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
    private Tasks() {
    }

    /* renamed from: a */
    public static <ResultT> Task<ResultT> m42595a(Exception exc) {
        C20241m mVar = new C20241m();
        mVar.mo164560a(exc);
        return mVar;
    }

    /* renamed from: a */
    public static <ResultT> Task<ResultT> m42596a(ResultT resultt) {
        C20241m mVar = new C20241m();
        mVar.mo164561a(resultt);
        return mVar;
    }

    /* renamed from: a */
    private static <ResultT> ResultT m42597a(Task<ResultT> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    /* renamed from: a */
    private static void m42598a(Task<?> task, C20242n nVar) {
        task.addOnSuccessListener(TaskExecutors.f56350a, nVar);
        task.addOnFailureListener(TaskExecutors.f56350a, nVar);
    }

    public static <ResultT> ResultT await(Task<ResultT> task) throws ExecutionException, InterruptedException {
        C20046aw.m42172a(task, (Object) "Task must not be null");
        if (task.isComplete()) {
            return m42597a(task);
        }
        C20242n nVar = new C20242n((byte[]) null);
        m42598a(task, nVar);
        nVar.mo164564a();
        return m42597a(task);
    }

    public static <ResultT> ResultT await(Task<ResultT> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        C20046aw.m42172a(task, (Object) "Task must not be null");
        C20046aw.m42172a(timeUnit, (Object) "TimeUnit must not be null");
        if (task.isComplete()) {
            return m42597a(task);
        }
        C20242n nVar = new C20242n((byte[]) null);
        m42598a(task, nVar);
        if (nVar.mo164565a(j, timeUnit)) {
            return m42597a(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
