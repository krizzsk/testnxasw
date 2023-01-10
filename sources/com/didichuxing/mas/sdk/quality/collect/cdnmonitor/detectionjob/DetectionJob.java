package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detectionjob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectionJob {

    /* renamed from: a */
    private String f50303a;

    /* renamed from: b */
    private String f50304b;

    /* renamed from: c */
    private List<String> f50305c;

    DetectionJob(String str, String str2, String str3) {
        this.f50303a = str;
        this.f50304b = str2;
        if (str3 == null || str3.equals("")) {
            this.f50305c = new ArrayList();
        } else {
            this.f50305c = Arrays.asList(str3.trim().toUpperCase().split(","));
        }
    }

    public String getUrl() {
        return this.f50303a;
    }

    public void setUrl(String str) {
        this.f50303a = str;
    }

    public String getMd5() {
        return this.f50304b;
    }

    public void setMd5(String str) {
        this.f50304b = str;
    }

    public List<String> getCcc() {
        return this.f50305c;
    }

    public void setCcc(List<String> list) {
        this.f50305c = list;
    }
}
