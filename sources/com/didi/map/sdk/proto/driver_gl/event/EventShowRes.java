package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class EventShowRes extends Message {
    public static final List<ShowEvent> DEFAULT_EVENTS = Collections.emptyList();
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShowEvent.class, tag = 3)
    public final List<ShowEvent> events;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;

    public EventShowRes(Integer num, String str, List<ShowEvent> list) {
        this.ret = num;
        this.msg = str;
        this.events = immutableCopyOf(list);
    }

    private EventShowRes(Builder builder) {
        this(builder.ret, builder.msg, builder.events);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventShowRes)) {
            return false;
        }
        EventShowRes eventShowRes = (EventShowRes) obj;
        if (!equals((Object) this.ret, (Object) eventShowRes.ret) || !equals((Object) this.msg, (Object) eventShowRes.msg) || !equals((List<?>) this.events, (List<?>) eventShowRes.events)) {
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
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<ShowEvent> list = this.events;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<EventShowRes> {
        public List<ShowEvent> events;
        public String msg;
        public Integer ret;

        public Builder() {
        }

        public Builder(EventShowRes eventShowRes) {
            super(eventShowRes);
            if (eventShowRes != null) {
                this.ret = eventShowRes.ret;
                this.msg = eventShowRes.msg;
                this.events = EventShowRes.copyOf(eventShowRes.events);
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

        public Builder events(List<ShowEvent> list) {
            this.events = checkForNulls(list);
            return this;
        }

        public EventShowRes build() {
            checkRequiredFields();
            return new EventShowRes(this);
        }
    }
}
