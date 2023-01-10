package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class EventShowReq extends Message {
    public static final Long DEFAULT_CURROUTEID = 0L;
    public static final String DEFAULT_DIDIVERSION = "";
    public static final String DEFAULT_LANG = "";
    public static final String DEFAULT_ORDERID = "";
    public static final Integer DEFAULT_SOURCE = 0;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_USERID = 0L;
    @ProtoField(tag = 8, type = Message.Datatype.UINT64)
    public final Long curRouteId;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String lang;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer source;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT64)
    public final Long userId;

    public EventShowReq(Long l, Integer num, Long l2, String str, String str2, String str3, String str4, Long l3) {
        this.timestamp = l;
        this.source = num;
        this.userId = l2;
        this.didiVersion = str;
        this.token = str2;
        this.lang = str3;
        this.orderId = str4;
        this.curRouteId = l3;
    }

    private EventShowReq(Builder builder) {
        this(builder.timestamp, builder.source, builder.userId, builder.didiVersion, builder.token, builder.lang, builder.orderId, builder.curRouteId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventShowReq)) {
            return false;
        }
        EventShowReq eventShowReq = (EventShowReq) obj;
        if (!equals((Object) this.timestamp, (Object) eventShowReq.timestamp) || !equals((Object) this.source, (Object) eventShowReq.source) || !equals((Object) this.userId, (Object) eventShowReq.userId) || !equals((Object) this.didiVersion, (Object) eventShowReq.didiVersion) || !equals((Object) this.token, (Object) eventShowReq.token) || !equals((Object) this.lang, (Object) eventShowReq.lang) || !equals((Object) this.orderId, (Object) eventShowReq.orderId) || !equals((Object) this.curRouteId, (Object) eventShowReq.curRouteId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.timestamp;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.source;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.userId;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.didiVersion;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.lang;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.orderId;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Long l3 = this.curRouteId;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventShowReq> {
        public Long curRouteId;
        public String didiVersion;
        public String lang;
        public String orderId;
        public Integer source;
        public Long timestamp;
        public String token;
        public Long userId;

        public Builder() {
        }

        public Builder(EventShowReq eventShowReq) {
            super(eventShowReq);
            if (eventShowReq != null) {
                this.timestamp = eventShowReq.timestamp;
                this.source = eventShowReq.source;
                this.userId = eventShowReq.userId;
                this.didiVersion = eventShowReq.didiVersion;
                this.token = eventShowReq.token;
                this.lang = eventShowReq.lang;
                this.orderId = eventShowReq.orderId;
                this.curRouteId = eventShowReq.curRouteId;
            }
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public Builder userId(Long l) {
            this.userId = l;
            return this;
        }

        public Builder didiVersion(String str) {
            this.didiVersion = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder lang(String str) {
            this.lang = str;
            return this;
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder curRouteId(Long l) {
            this.curRouteId = l;
            return this;
        }

        public EventShowReq build() {
            checkRequiredFields();
            return new EventShowReq(this);
        }
    }
}
