package com.didi.map.sdk.proto.driver_gl.event;

import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ShowEvent extends Message {
    public static final List<FeedCard> DEFAULT_CARD = Collections.emptyList();
    public static final Long DEFAULT_EVENTID = 0L;
    public static final Integer DEFAULT_EVENTOPER = 0;
    public static final String DEFAULT_EVENTTITLE = "";
    public static final Integer DEFAULT_EVENTTYPE = 0;
    public static final Long DEFAULT_LINKID = 0L;
    public static final List<ButtonModeInfo> DEFAULT_MODEINFO = Collections.emptyList();
    public static final Long DEFAULT_REPORTTIME = 0L;
    @ProtoField(label = Message.Label.REPEATED, messageType = FeedCard.class, tag = 7)
    public final List<FeedCard> card;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long eventId;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer eventOper;
    @ProtoField(tag = 5)
    public final DoublePoint eventPoint;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String eventTitle;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer eventType;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long linkId;
    @ProtoField(label = Message.Label.REPEATED, messageType = ButtonModeInfo.class, tag = 2)
    public final List<ButtonModeInfo> modeInfo;
    @ProtoField(tag = 9, type = Message.Datatype.UINT64)
    public final Long reportTime;

    public ShowEvent(Long l, List<ButtonModeInfo> list, String str, Integer num, DoublePoint doublePoint, Long l2, List<FeedCard> list2, Integer num2, Long l3) {
        this.eventId = l;
        this.modeInfo = immutableCopyOf(list);
        this.eventTitle = str;
        this.eventType = num;
        this.eventPoint = doublePoint;
        this.linkId = l2;
        this.card = immutableCopyOf(list2);
        this.eventOper = num2;
        this.reportTime = l3;
    }

    private ShowEvent(Builder builder) {
        this(builder.eventId, builder.modeInfo, builder.eventTitle, builder.eventType, builder.eventPoint, builder.linkId, builder.card, builder.eventOper, builder.reportTime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShowEvent)) {
            return false;
        }
        ShowEvent showEvent = (ShowEvent) obj;
        if (!equals((Object) this.eventId, (Object) showEvent.eventId) || !equals((List<?>) this.modeInfo, (List<?>) showEvent.modeInfo) || !equals((Object) this.eventTitle, (Object) showEvent.eventTitle) || !equals((Object) this.eventType, (Object) showEvent.eventType) || !equals((Object) this.eventPoint, (Object) showEvent.eventPoint) || !equals((Object) this.linkId, (Object) showEvent.linkId) || !equals((List<?>) this.card, (List<?>) showEvent.card) || !equals((Object) this.eventOper, (Object) showEvent.eventOper) || !equals((Object) this.reportTime, (Object) showEvent.reportTime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.eventId;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        List<ButtonModeInfo> list = this.modeInfo;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.eventTitle;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.eventType;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.eventPoint;
        int hashCode5 = (hashCode4 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        Long l2 = this.linkId;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        List<FeedCard> list2 = this.card;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode6 + i3) * 37;
        Integer num2 = this.eventOper;
        int hashCode7 = (i4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l3 = this.reportTime;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i5 = hashCode7 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ShowEvent> {
        public List<FeedCard> card;
        public Long eventId;
        public Integer eventOper;
        public DoublePoint eventPoint;
        public String eventTitle;
        public Integer eventType;
        public Long linkId;
        public List<ButtonModeInfo> modeInfo;
        public Long reportTime;

        public Builder() {
        }

        public Builder(ShowEvent showEvent) {
            super(showEvent);
            if (showEvent != null) {
                this.eventId = showEvent.eventId;
                this.modeInfo = ShowEvent.copyOf(showEvent.modeInfo);
                this.eventTitle = showEvent.eventTitle;
                this.eventType = showEvent.eventType;
                this.eventPoint = showEvent.eventPoint;
                this.linkId = showEvent.linkId;
                this.card = ShowEvent.copyOf(showEvent.card);
                this.eventOper = showEvent.eventOper;
                this.reportTime = showEvent.reportTime;
            }
        }

        public Builder eventId(Long l) {
            this.eventId = l;
            return this;
        }

        public Builder modeInfo(List<ButtonModeInfo> list) {
            this.modeInfo = checkForNulls(list);
            return this;
        }

        public Builder eventTitle(String str) {
            this.eventTitle = str;
            return this;
        }

        public Builder eventType(Integer num) {
            this.eventType = num;
            return this;
        }

        public Builder eventPoint(DoublePoint doublePoint) {
            this.eventPoint = doublePoint;
            return this;
        }

        public Builder linkId(Long l) {
            this.linkId = l;
            return this;
        }

        public Builder card(List<FeedCard> list) {
            this.card = checkForNulls(list);
            return this;
        }

        public Builder eventOper(Integer num) {
            this.eventOper = num;
            return this;
        }

        public Builder reportTime(Long l) {
            this.reportTime = l;
            return this;
        }

        public ShowEvent build() {
            return new ShowEvent(this);
        }
    }
}
