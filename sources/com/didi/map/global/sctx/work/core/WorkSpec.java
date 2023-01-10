package com.didi.map.global.sctx.work.core;

public class WorkSpec {

    /* renamed from: id */
    public String f30165id;
    public long initialDelay;
    public long intervalDuration;
    public Worker worker;
    public String workerClassName;

    public WorkSpec(String str, String str2) {
        this.f30165id = str;
        this.workerClassName = str2;
    }

    public WorkSpec(WorkSpec workSpec) {
        this.f30165id = workSpec.f30165id;
        this.workerClassName = workSpec.workerClassName;
        this.initialDelay = workSpec.initialDelay;
        this.intervalDuration = workSpec.intervalDuration;
        this.worker = workSpec.worker;
    }

    public void setPeriodic(long j) {
        this.intervalDuration = j;
    }

    public void setWorker(Worker worker2) {
        this.worker = worker2;
    }

    public void setInitialDelay(long j) {
        this.initialDelay = j;
    }
}
