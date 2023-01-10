package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class EventFeedbackRes extends Message {
    public static final String DEFAULT_DEBUGINFO = "";
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debugInfo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;

    public EventFeedbackRes(Integer num, String str, String str2) {
        this.ret = num;
        this.msg = str;
        this.debugInfo = str2;
    }

    private EventFeedbackRes(Builder builder) {
        this(builder.ret, builder.msg, builder.debugInfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventFeedbackRes)) {
            return false;
        }
        EventFeedbackRes eventFeedbackRes = (EventFeedbackRes) obj;
        if (!equals((Object) this.ret, (Object) eventFeedbackRes.ret) || !equals((Object) this.msg, (Object) eventFeedbackRes.msg) || !equals((Object) this.debugInfo, (Object) eventFeedbackRes.debugInfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.ret;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.msg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.debugInfo;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventFeedbackRes> {
        public String debugInfo;
        public String msg;
        public Integer ret;

        public Builder() {
        }

        public Builder(EventFeedbackRes eventFeedbackRes) {
            super(eventFeedbackRes);
            if (eventFeedbackRes != null) {
                this.ret = eventFeedbackRes.ret;
                this.msg = eventFeedbackRes.msg;
                this.debugInfo = eventFeedbackRes.debugInfo;
            }
        }

        public Builder ret(Integer num) {
            this.ret = num;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder debugInfo(String str) {
            this.debugInfo = str;
            return this;
        }

        public EventFeedbackRes build() {
            checkRequiredFields();
            return new EventFeedbackRes(this);
        }
    }
}
