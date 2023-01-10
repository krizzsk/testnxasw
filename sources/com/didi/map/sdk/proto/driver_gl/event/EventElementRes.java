package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class EventElementRes extends Message {
    public static final List<ButtonInfo> DEFAULT_BTNS = Collections.emptyList();
    public static final List<EventCategory> DEFAULT_CATES = Collections.emptyList();
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ButtonInfo.class, tag = 3)
    public final List<ButtonInfo> btns;
    @ProtoField(label = Message.Label.REPEATED, messageType = EventCategory.class, tag = 4)
    public final List<EventCategory> cates;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;

    public EventElementRes(Integer num, String str, List<ButtonInfo> list, List<EventCategory> list2) {
        this.ret = num;
        this.msg = str;
        this.btns = immutableCopyOf(list);
        this.cates = immutableCopyOf(list2);
    }

    private EventElementRes(Builder builder) {
        this(builder.ret, builder.msg, builder.btns, builder.cates);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventElementRes)) {
            return false;
        }
        EventElementRes eventElementRes = (EventElementRes) obj;
        if (!equals((Object) this.ret, (Object) eventElementRes.ret) || !equals((Object) this.msg, (Object) eventElementRes.msg) || !equals((List<?>) this.btns, (List<?>) eventElementRes.btns) || !equals((List<?>) this.cates, (List<?>) eventElementRes.cates)) {
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
        List<ButtonInfo> list = this.btns;
        int i4 = 1;
        int hashCode2 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<EventCategory> list2 = this.cates;
        if (list2 != null) {
            i4 = list2.hashCode();
        }
        int i5 = hashCode2 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<EventElementRes> {
        public List<ButtonInfo> btns;
        public List<EventCategory> cates;
        public String msg;
        public Integer ret;

        public Builder() {
        }

        public Builder(EventElementRes eventElementRes) {
            super(eventElementRes);
            if (eventElementRes != null) {
                this.ret = eventElementRes.ret;
                this.msg = eventElementRes.msg;
                this.btns = EventElementRes.copyOf(eventElementRes.btns);
                this.cates = EventElementRes.copyOf(eventElementRes.cates);
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

        public Builder btns(List<ButtonInfo> list) {
            this.btns = checkForNulls(list);
            return this;
        }

        public Builder cates(List<EventCategory> list) {
            this.cates = checkForNulls(list);
            return this;
        }

        public EventElementRes build() {
            checkRequiredFields();
            return new EventElementRes(this);
        }
    }
}
