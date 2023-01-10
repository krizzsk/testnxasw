package com.didi.dqr.task.base;

import java.util.Deque;
import java.util.LinkedList;

public class TaskExecutor {

    /* renamed from: a */
    private Deque<DqrTask> f20980a = new LinkedList();

    public TaskExecutor addTask(DqrTask dqrTask) {
        this.f20980a.add(dqrTask);
        return this;
    }

    public DqrTaskData run(DqrTaskData dqrTaskData) {
        DqrTask poll = this.f20980a.poll();
        DqrTaskData dqrTaskData2 = null;
        while (poll != null) {
            poll.setExecutor(this);
            try {
                dqrTaskData2 = poll.run(dqrTaskData);
            } catch (Exception unused) {
            }
            if (dqrTaskData2 == null) {
                return null;
            }
            dqrTaskData2.fromTask = poll.getTaskType();
            if (dqrTaskData2.isFinished()) {
                return dqrTaskData2;
            }
            poll = this.f20980a.poll();
            dqrTaskData = dqrTaskData2;
        }
        return dqrTaskData2;
    }
}
