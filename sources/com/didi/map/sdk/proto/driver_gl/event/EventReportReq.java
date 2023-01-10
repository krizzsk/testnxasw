package com.didi.map.sdk.proto.driver_gl.event;

import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class EventReportReq extends Message {
    public static final Integer DEFAULT_CITYID = 0;
    public static final String DEFAULT_COUNTRYID = "";
    public static final Long DEFAULT_CURROUTEID = 0L;
    public static final String DEFAULT_DIDIVERSION = "";
    public static final Integer DEFAULT_EVENTTYPE = 0;
    public static final String DEFAULT_LANG = "";
    public static final Integer DEFAULT_LOCTYPE = 0;
    public static final String DEFAULT_ORDERID = "";
    public static final String DEFAULT_REMARK = "";
    public static final String DEFAULT_REPORTLOCNAME = "";
    public static final Integer DEFAULT_SOURCE = 0;
    public static final Integer DEFAULT_SOURCETYPE = 0;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TRUSTTYPE = 0;
    public static final Long DEFAULT_USERID = 0L;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer cityId;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String countryId;
    @ProtoField(tag = 17, type = Message.Datatype.INT64)
    public final Long curRouteId;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6)
    public final DoublePoint eventPoint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer eventType;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String lang;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer locType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String remark;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String reportLocName;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer source;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer sourceType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer trustType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.UINT64)
    public final Long userId;

    public EventReportReq(String str, Integer num, Integer num2, Integer num3, Long l, DoublePoint doublePoint, Long l2, String str2, String str3, String str4, Integer num4, String str5, String str6, Integer num5, String str7, Integer num6, Long l3) {
        this.orderId = str;
        this.source = num;
        this.sourceType = num2;
        this.eventType = num3;
        this.timestamp = l;
        this.eventPoint = doublePoint;
        this.userId = l2;
        this.didiVersion = str2;
        this.token = str3;
        this.countryId = str4;
        this.cityId = num4;
        this.lang = str5;
        this.reportLocName = str6;
        this.locType = num5;
        this.remark = str7;
        this.trustType = num6;
        this.curRouteId = l3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private EventReportReq(com.didi.map.sdk.proto.driver_gl.event.EventReportReq.Builder r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            java.lang.String r2 = r0.orderId
            java.lang.Integer r3 = r0.source
            java.lang.Integer r4 = r0.sourceType
            java.lang.Integer r5 = r0.eventType
            java.lang.Long r6 = r0.timestamp
            com.didi.map.sdk.proto.driver_gl.DoublePoint r7 = r0.eventPoint
            java.lang.Long r8 = r0.userId
            java.lang.String r9 = r0.didiVersion
            java.lang.String r10 = r0.token
            java.lang.String r11 = r0.countryId
            java.lang.Integer r12 = r0.cityId
            java.lang.String r13 = r0.lang
            java.lang.String r14 = r0.reportLocName
            java.lang.Integer r15 = r0.locType
            r19 = r1
            java.lang.String r1 = r0.remark
            r16 = r1
            java.lang.Integer r1 = r0.trustType
            r17 = r1
            java.lang.Long r1 = r0.curRouteId
            r18 = r1
            r1 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r20.setBuilder(r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.driver_gl.event.EventReportReq.<init>(com.didi.map.sdk.proto.driver_gl.event.EventReportReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventReportReq)) {
            return false;
        }
        EventReportReq eventReportReq = (EventReportReq) obj;
        if (!equals((Object) this.orderId, (Object) eventReportReq.orderId) || !equals((Object) this.source, (Object) eventReportReq.source) || !equals((Object) this.sourceType, (Object) eventReportReq.sourceType) || !equals((Object) this.eventType, (Object) eventReportReq.eventType) || !equals((Object) this.timestamp, (Object) eventReportReq.timestamp) || !equals((Object) this.eventPoint, (Object) eventReportReq.eventPoint) || !equals((Object) this.userId, (Object) eventReportReq.userId) || !equals((Object) this.didiVersion, (Object) eventReportReq.didiVersion) || !equals((Object) this.token, (Object) eventReportReq.token) || !equals((Object) this.countryId, (Object) eventReportReq.countryId) || !equals((Object) this.cityId, (Object) eventReportReq.cityId) || !equals((Object) this.lang, (Object) eventReportReq.lang) || !equals((Object) this.reportLocName, (Object) eventReportReq.reportLocName) || !equals((Object) this.locType, (Object) eventReportReq.locType) || !equals((Object) this.remark, (Object) eventReportReq.remark) || !equals((Object) this.trustType, (Object) eventReportReq.trustType) || !equals((Object) this.curRouteId, (Object) eventReportReq.curRouteId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.orderId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.source;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.sourceType;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.eventType;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.timestamp;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.eventPoint;
        int hashCode6 = (hashCode5 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        Long l2 = this.userId;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str2 = this.didiVersion;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.token;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.countryId;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num4 = this.cityId;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str5 = this.lang;
        int hashCode12 = (hashCode11 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.reportLocName;
        int hashCode13 = (hashCode12 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num5 = this.locType;
        int hashCode14 = (hashCode13 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str7 = this.remark;
        int hashCode15 = (hashCode14 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num6 = this.trustType;
        int hashCode16 = (hashCode15 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l3 = this.curRouteId;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode16 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventReportReq> {
        public Integer cityId;
        public String countryId;
        public Long curRouteId;
        public String didiVersion;
        public DoublePoint eventPoint;
        public Integer eventType;
        public String lang;
        public Integer locType;
        public String orderId;
        public String remark;
        public String reportLocName;
        public Integer source;
        public Integer sourceType;
        public Long timestamp;
        public String token;
        public Integer trustType;
        public Long userId;

        public Builder() {
        }

        public Builder(EventReportReq eventReportReq) {
            super(eventReportReq);
            if (eventReportReq != null) {
                this.orderId = eventReportReq.orderId;
                this.source = eventReportReq.source;
                this.sourceType = eventReportReq.sourceType;
                this.eventType = eventReportReq.eventType;
                this.timestamp = eventReportReq.timestamp;
                this.eventPoint = eventReportReq.eventPoint;
                this.userId = eventReportReq.userId;
                this.didiVersion = eventReportReq.didiVersion;
                this.token = eventReportReq.token;
                this.countryId = eventReportReq.countryId;
                this.cityId = eventReportReq.cityId;
                this.lang = eventReportReq.lang;
                this.reportLocName = eventReportReq.reportLocName;
                this.locType = eventReportReq.locType;
                this.remark = eventReportReq.remark;
                this.trustType = eventReportReq.trustType;
                this.curRouteId = eventReportReq.curRouteId;
            }
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public Builder sourceType(Integer num) {
            this.sourceType = num;
            return this;
        }

        public Builder eventType(Integer num) {
            this.eventType = num;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder eventPoint(DoublePoint doublePoint) {
            this.eventPoint = doublePoint;
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

        public Builder countryId(String str) {
            this.countryId = str;
            return this;
        }

        public Builder cityId(Integer num) {
            this.cityId = num;
            return this;
        }

        public Builder lang(String str) {
            this.lang = str;
            return this;
        }

        public Builder reportLocName(String str) {
            this.reportLocName = str;
            return this;
        }

        public Builder locType(Integer num) {
            this.locType = num;
            return this;
        }

        public Builder remark(String str) {
            this.remark = str;
            return this;
        }

        public Builder trustType(Integer num) {
            this.trustType = num;
            return this;
        }

        public Builder curRouteId(Long l) {
            this.curRouteId = l;
            return this;
        }

        public EventReportReq build() {
            checkRequiredFields();
            return new EventReportReq(this);
        }
    }
}
