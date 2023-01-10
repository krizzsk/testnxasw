package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class FeedCard extends Message {
    public static final List<ButtonInfo> DEFAULT_BTN = Collections.emptyList();
    public static final Integer DEFAULT_CARDTYPE = 0;
    public static final String DEFAULT_SECONDARY = "";
    public static final String DEFAULT_SUBTITLE = "";
    public static final String DEFAULT_TITLE = "";
    @ProtoField(label = Message.Label.REPEATED, messageType = ButtonInfo.class, tag = 3)
    public final List<ButtonInfo> btn;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer cardType;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String secondary;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String subTitle;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String title;

    public FeedCard(String str, String str2, List<ButtonInfo> list, Integer num, String str3) {
        this.title = str;
        this.subTitle = str2;
        this.btn = immutableCopyOf(list);
        this.cardType = num;
        this.secondary = str3;
    }

    private FeedCard(Builder builder) {
        this(builder.title, builder.subTitle, builder.btn, builder.cardType, builder.secondary);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedCard)) {
            return false;
        }
        FeedCard feedCard = (FeedCard) obj;
        if (!equals((Object) this.title, (Object) feedCard.title) || !equals((Object) this.subTitle, (Object) feedCard.subTitle) || !equals((List<?>) this.btn, (List<?>) feedCard.btn) || !equals((Object) this.cardType, (Object) feedCard.cardType) || !equals((Object) this.secondary, (Object) feedCard.secondary)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.subTitle;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<ButtonInfo> list = this.btn;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.cardType;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.secondary;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FeedCard> {
        public List<ButtonInfo> btn;
        public Integer cardType;
        public String secondary;
        public String subTitle;
        public String title;

        public Builder() {
        }

        public Builder(FeedCard feedCard) {
            super(feedCard);
            if (feedCard != null) {
                this.title = feedCard.title;
                this.subTitle = feedCard.subTitle;
                this.btn = FeedCard.copyOf(feedCard.btn);
                this.cardType = feedCard.cardType;
                this.secondary = feedCard.secondary;
            }
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder subTitle(String str) {
            this.subTitle = str;
            return this;
        }

        public Builder btn(List<ButtonInfo> list) {
            this.btn = checkForNulls(list);
            return this;
        }

        public Builder cardType(Integer num) {
            this.cardType = num;
            return this;
        }

        public Builder secondary(String str) {
            this.secondary = str;
            return this;
        }

        public FeedCard build() {
            return new FeedCard(this);
        }
    }
}
