package com.didi.map.global.component.dropoff.data;

import com.didi.map.global.component.dropoff.data.IDropOffDataTask;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.sdk.poibase.CallFrom;

public class DropOffDataTaskParam {

    /* renamed from: a */
    private int f27781a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CallFrom f27782b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DropOffLocationInfo f27783c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f27784d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f27785e;

    /* renamed from: f */
    private IDropOffDataTask.TaskCallback f27786f;

    private DropOffDataTaskParam(int i, IDropOffDataTask.TaskCallback taskCallback) {
        this.f27781a = i;
        this.f27786f = taskCallback;
    }

    public int getId() {
        return this.f27781a;
    }

    public CallFrom getReqCallerId() {
        return this.f27782b;
    }

    public DropOffLocationInfo getLocationInfo() {
        return this.f27783c;
    }

    public String getMapType() {
        return this.f27784d;
    }

    public String getUserOperationType() {
        return this.f27785e;
    }

    public IDropOffDataTask.TaskCallback getTaskCallback() {
        return this.f27786f;
    }

    public static class Builder {
        private DropOffDataTaskParam dataTaskParam;

        public Builder(int i, IDropOffDataTask.TaskCallback taskCallback) {
            this.dataTaskParam = new DropOffDataTaskParam(i, taskCallback);
        }

        public Builder reqCallerId(CallFrom callFrom) {
            CallFrom unused = this.dataTaskParam.f27782b = callFrom;
            return this;
        }

        public Builder locationInfo(DropOffLocationInfo dropOffLocationInfo) {
            DropOffLocationInfo unused = this.dataTaskParam.f27783c = dropOffLocationInfo;
            return this;
        }

        public Builder mapType(String str) {
            String unused = this.dataTaskParam.f27784d = str;
            return this;
        }

        public Builder userOperationType(String str) {
            String unused = this.dataTaskParam.f27785e = str;
            return this;
        }

        public DropOffDataTaskParam build() {
            return this.dataTaskParam;
        }
    }
}
