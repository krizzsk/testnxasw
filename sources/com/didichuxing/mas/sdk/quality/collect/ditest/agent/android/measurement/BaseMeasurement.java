package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;

public class BaseMeasurement implements Measurement {

    /* renamed from: a */
    private static final AgentLog f50570a = AgentLogManager.getAgentLog();

    /* renamed from: b */
    private MeasurementType f50571b;

    /* renamed from: c */
    private String f50572c;

    /* renamed from: d */
    private long f50573d;

    /* renamed from: e */
    private long f50574e;

    /* renamed from: f */
    private long f50575f;

    /* renamed from: g */
    private boolean f50576g;

    public BaseMeasurement(MeasurementType measurementType) {
        mo124768a(measurementType);
    }

    public BaseMeasurement(Measurement measurement) {
        mo124768a(measurement.getType());
        setName(measurement.getName());
        setStartTime(measurement.getStartTime());
        setEndTime(measurement.getEndTime());
        setExclusiveTime(measurement.getExclusiveTime());
        this.f50576g = measurement.isFinished();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo124768a(MeasurementType measurementType) {
        m37710a();
        this.f50571b = measurementType;
    }

    public void setName(String str) {
        m37710a();
        this.f50572c = str;
    }

    public void setStartTime(long j) {
        m37710a();
        this.f50573d = j;
    }

    public void setEndTime(long j) {
        m37710a();
        if (j < this.f50573d) {
            AgentLog agentLog = f50570a;
            agentLog.error("Measurement end time must not precede start time - startTime: " + this.f50573d + " endTime: " + j);
            return;
        }
        this.f50574e = j;
    }

    public void setExclusiveTime(long j) {
        m37710a();
        this.f50575f = j;
    }

    public MeasurementType getType() {
        return this.f50571b;
    }

    public String getName() {
        return this.f50572c;
    }

    public long getStartTime() {
        return this.f50573d;
    }

    public double getStartTimeInSeconds() {
        return ((double) this.f50573d) / 1000.0d;
    }

    public long getEndTime() {
        return this.f50574e;
    }

    public double getEndTimeInSeconds() {
        return ((double) this.f50574e) / 1000.0d;
    }

    public long getExclusiveTime() {
        return this.f50575f;
    }

    public double getExclusiveTimeInSeconds() {
        return ((double) this.f50575f) / 1000.0d;
    }

    public void finish() {
        if (!this.f50576g) {
            this.f50576g = true;
            return;
        }
        throw new MeasurementException("Finish called on already finished Measurement");
    }

    public boolean isFinished() {
        return this.f50576g;
    }

    /* renamed from: a */
    private void m37710a() {
        if (this.f50576g) {
            throw new MeasurementException("Attempted to modify finished Measurement");
        }
    }

    public String toString() {
        return "BaseMeasurement{type=" + this.f50571b + ", name='" + this.f50572c + '\'' + ", startTime=" + this.f50573d + ", endTime=" + this.f50574e + ", exclusiveTime=" + this.f50575f + ", finished=" + this.f50576g + '}';
    }
}
