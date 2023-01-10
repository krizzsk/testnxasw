package com.didi.sdk.common;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.ArrayDeque;

public class TaskSchedulerImpl extends TaskScheduler {

    /* renamed from: a */
    private Logger f38394a = LoggerFactory.getLogger("TaskScheduler");

    /* renamed from: b */
    private final SparseArray<ArrayDeque<TaskInfo>> f38395b = new SparseArray<>();

    /* renamed from: c */
    private final Handler f38396c = new Handler(Looper.getMainLooper());

    TaskSchedulerImpl() {
    }

    public void scheduleUiTask(Runnable runnable, int i) {
        Logger logger = this.f38394a;
        logger.debug("scheduleUiTask when " + i, new Object[0]);
        m28964a(new TaskInfo(runnable, i, true));
    }

    public void scheduleBkgTask(Runnable runnable, int i) {
        Logger logger = this.f38394a;
        logger.debug("scheduleBkgTask when " + i, new Object[0]);
        m28964a(new TaskInfo(runnable, i, false));
    }

    /* renamed from: a */
    private synchronized void m28964a(TaskInfo taskInfo) {
        if ((this.mWhenFlag & taskInfo.f38391b) == 0) {
            this.f38394a.debug("add task to pending queue", new Object[0]);
            m28963a(taskInfo.f38391b).offerLast(taskInfo);
        } else {
            m28966b(taskInfo);
        }
    }

    public synchronized void notify(int i) {
        Logger logger = this.f38394a;
        logger.debug("notify when " + i, new Object[0]);
        if ((this.mWhenFlag & i) != 0) {
            Logger logger2 = this.f38394a;
            logger2.error(i + " has been notified before!", new Object[0]);
        }
        ArrayDeque<TaskInfo> b = m28965b(i);
        if (b != null) {
            while (!b.isEmpty()) {
                m28966b(b.pollFirst());
            }
        }
        this.mWhenFlag = i | this.mWhenFlag;
    }

    public synchronized void clear() {
        this.f38394a.debug("clear", new Object[0]);
        this.f38395b.clear();
        this.f38396c.removeCallbacks((Runnable) null);
        resetWhenFlag();
    }

    /* renamed from: b */
    private void m28966b(TaskInfo taskInfo) {
        if (taskInfo.f38392c) {
            this.f38394a.debug("post ui task", new Object[0]);
            this.f38396c.post(taskInfo.f38390a);
            return;
        }
        this.f38394a.debug("addBkgTask", new Object[0]);
        DDThreadPool.getInstance().addBkgTask(taskInfo.f38390a);
    }

    /* renamed from: a */
    private ArrayDeque<TaskInfo> m28963a(int i) {
        ArrayDeque<TaskInfo> arrayDeque = this.f38395b.get(i);
        if (arrayDeque != null) {
            return arrayDeque;
        }
        ArrayDeque<TaskInfo> arrayDeque2 = new ArrayDeque<>();
        this.f38395b.put(i, arrayDeque2);
        return arrayDeque2;
    }

    /* renamed from: b */
    private ArrayDeque<TaskInfo> m28965b(int i) {
        try {
            return this.f38395b.get(i);
        } finally {
            this.f38395b.remove(i);
        }
    }
}
