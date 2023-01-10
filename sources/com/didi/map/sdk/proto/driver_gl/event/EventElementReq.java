package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class EventElementReq extends Message {
    public static final String DEFAULT_DIDIVERSION = "";
    public static final String DEFAULT_LANG = "";
    public static final Integer DEFAULT_SOURCE = 0;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_USERID = 0L;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String lang;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer source;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT64)
    public final Long userId;

    public EventElementReq(Long l, Integer num, Long l2, String str, String str2, String str3) {
        this.timestamp = l;
        this.source = num;
        this.userId = l2;
        this.didiVersion = str;
        this.token = str2;
        this.lang = str3;
    }

    private EventElementReq(Builder builder) {
        this(builder.timestamp, builder.source, builder.userId, builder.didiVersion, builder.token, builder.lang);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventElementReq)) {
            return false;
        }
        EventElementReq eventElementReq = (EventElementReq) obj;
        if (!equals((Object) this.timestamp, (Object) eventElementReq.timestamp) || !equals((Object) this.source, (Object) eventElementReq.source) || !equals((Object) this.userId, (Object) eventElementReq.userId) || !equals((Object) this.didiVersion, (Object) eventElementReq.didiVersion) || !equals((Object) this.token, (Object) eventElementReq.token) || !equals((Object) this.lang, (Object) eventElementReq.lang)) {
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
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventElementReq> {
        public String didiVersion;
        public String lang;
        public Integer source;
        public Long timestamp;
        public String token;
        public Long userId;

        public Builder() {
        }

        public Builder(EventElementReq eventElementReq) {
            super(eventElementReq);
            if (eventElementReq != null) {
                this.timestamp = eventElementReq.timestamp;
                this.source = eventElementReq.source;
                this.userId = eventElementReq.userId;
                this.didiVersion = eventElementReq.didiVersion;
                this.token = eventElementReq.token;
                this.lang = eventElementReq.lang;
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

        public EventElementReq build() {
            checkRequiredFields();
            return new EventElementReq(this);
        }
    }
}
