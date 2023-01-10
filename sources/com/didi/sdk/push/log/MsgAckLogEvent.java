package com.didi.sdk.push.log;

import com.didi.sdk.push.log.LogEvent;
import java.util.HashMap;
import java.util.Map;

public class MsgAckLogEvent extends LogEvent {
    private long duration;

    /* renamed from: ip */
    private String f39796ip;
    private int msgCode;
    private int msgSubType;
    private int msgType;

    public MsgAckLogEvent(Builder builder) {
        this.duration = builder.duration;
        this.msgType = builder.msgType;
        this.msgSubType = builder.msgSubType;
        this.msgCode = builder.msgCode;
        this.f39796ip = builder.f39797ip;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(this.duration));
        hashMap.put("msg_type", Integer.valueOf(this.msgType));
        hashMap.put("msg_sub_type", Integer.valueOf(this.msgSubType));
        hashMap.put("msg_code", Integer.valueOf(this.msgCode));
        hashMap.put("puship", this.f39796ip);
        return hashMap;
    }

    public static class Builder implements LogEvent.Builder<MsgAckLogEvent> {
        /* access modifiers changed from: private */
        public long duration;
        /* access modifiers changed from: private */

        /* renamed from: ip */
        public String f39797ip;
        /* access modifiers changed from: private */
        public int msgCode;
        /* access modifiers changed from: private */
        public int msgSubType;
        /* access modifiers changed from: private */
        public int msgType;

        public Builder duration(long j) {
            this.duration = j;
            return this;
        }

        public Builder msgType(int i) {
            this.msgType = i;
            return this;
        }

        public Builder msgSubType(int i) {
            this.msgSubType = i;
            return this;
        }

        public Builder msgCode(int i) {
            this.msgCode = i;
            return this;
        }

        /* renamed from: ip */
        public Builder mo102127ip(String str) {
            this.f39797ip = str;
            return this;
        }

        public MsgAckLogEvent build() {
            return new MsgAckLogEvent(this);
        }
    }
}
