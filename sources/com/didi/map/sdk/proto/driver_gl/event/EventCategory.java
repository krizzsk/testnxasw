package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class EventCategory extends Message {
    public static final Integer DEFAULT_CATECODE = 0;
    public static final String DEFAULT_CATENAME = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer cateCode;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String cateName;

    public EventCategory(Integer num, String str) {
        this.cateCode = num;
        this.cateName = str;
    }

    private EventCategory(Builder builder) {
        this(builder.cateCode, builder.cateName);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventCategory)) {
            return false;
        }
        EventCategory eventCategory = (EventCategory) obj;
        if (!equals((Object) this.cateCode, (Object) eventCategory.cateCode) || !equals((Object) this.cateName, (Object) eventCategory.cateName)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.cateCode;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.cateName;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventCategory> {
        public Integer cateCode;
        public String cateName;

        public Builder() {
        }

        public Builder(EventCategory eventCategory) {
            super(eventCategory);
            if (eventCategory != null) {
                this.cateCode = eventCategory.cateCode;
                this.cateName = eventCategory.cateName;
            }
        }

        public Builder cateCode(Integer num) {
            this.cateCode = num;
            return this;
        }

        public Builder cateName(String str) {
            this.cateName = str;
            return this;
        }

        public EventCategory build() {
            return new EventCategory(this);
        }
    }
}
