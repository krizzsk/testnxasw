package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detectionjob;

import java.util.ArrayList;
import java.util.List;

public class DetectionJobs {

    /* renamed from: a */
    private int f50306a;

    /* renamed from: b */
    private List<DetectionJob> f50307b = new ArrayList();

    public int getErrorNo() {
        return this.f50306a;
    }

    public void setErrorNo(int i) {
        this.f50306a = i;
    }

    public List<DetectionJob> getCdnJobs() {
        return this.f50307b;
    }

    public void setCdnJobs(List<DetectionJob> list) {
        this.f50307b = list;
    }

    public void addDetectionJob(String str, String str2, String str3) {
        this.f50307b.add(new DetectionJob(str, str2, str3));
    }
}
