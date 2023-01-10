package com.didi.sdk.push.log;

import java.util.HashMap;
import java.util.Map;

public class TransactionEvent extends LogEvent {
    private long down;
    private int msgType;
    private long seqId;
    private long time;
    private int tls;

    /* renamed from: up */
    private long f39800up;

    public TransactionEvent(Builder builder) {
        this.seqId = builder.seqId;
        this.msgType = builder.msgType;
        this.f39800up = builder.f39801up;
        this.down = builder.down;
        this.time = builder.time;
        this.tls = builder.tls;
    }

    public long getSeqId() {
        return this.seqId;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public long getUp() {
        return this.f39800up;
    }

    public long getDown() {
        return this.down;
    }

    public long getTime() {
        return this.time;
    }

    public int getTls() {
        return this.tls;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("seqid", Long.valueOf(this.seqId));
        hashMap.put("up", Long.valueOf(this.f39800up));
        hashMap.put("down", Long.valueOf(this.down));
        hashMap.put("time", Long.valueOf(this.time));
        hashMap.put("type", Integer.valueOf(this.msgType));
        hashMap.put("tls", Integer.valueOf(this.tls));
        return hashMap;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public long down;
        /* access modifiers changed from: private */
        public int msgType;
        /* access modifiers changed from: private */
        public long seqId;
        /* access modifiers changed from: private */
        public long time;
        /* access modifiers changed from: private */
        public int tls;
        /* access modifiers changed from: private */

        /* renamed from: up */
        public long f39801up;

        public Builder seqId(long j) {
            this.seqId = j;
            return this;
        }

        public Builder msgType(int i) {
            this.msgType = i;
            return this;
        }

        /* renamed from: up */
        public Builder mo102159up(long j) {
            this.f39801up = j;
            return this;
        }

        public Builder down(long j) {
            this.down = j;
            return this;
        }

        public Builder time(long j) {
            this.time = j;
            return this;
        }

        public Builder tls(int i) {
            this.tls = i;
            return this;
        }

        public TransactionEvent build() {
            return new TransactionEvent(this);
        }
    }
}
