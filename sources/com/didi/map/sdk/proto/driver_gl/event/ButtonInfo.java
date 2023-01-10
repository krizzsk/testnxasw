package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ButtonInfo extends Message {
    public static final Integer DEFAULT_BUTTONINDEX = 0;
    public static final String DEFAULT_BUTTONTITLE = "";
    public static final Integer DEFAULT_BUTTONVALUE = 0;
    public static final Integer DEFAULT_CATECODE = 0;
    public static final List<ButtonModeInfo> DEFAULT_MODEINFO = Collections.emptyList();
    public static final List<ButtonInfo> DEFAULT_SECONDARY = Collections.emptyList();
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer buttonIndex;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String buttonTitle;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer buttonValue;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer cateCode;
    @ProtoField(label = Message.Label.REPEATED, messageType = ButtonModeInfo.class, tag = 2)
    public final List<ButtonModeInfo> modeInfo;
    @ProtoField(label = Message.Label.REPEATED, messageType = ButtonInfo.class, tag = 6)
    public final List<ButtonInfo> secondary;

    public ButtonInfo(String str, List<ButtonModeInfo> list, Integer num, Integer num2, Integer num3, List<ButtonInfo> list2) {
        this.buttonTitle = str;
        this.modeInfo = immutableCopyOf(list);
        this.buttonValue = num;
        this.buttonIndex = num2;
        this.cateCode = num3;
        this.secondary = immutableCopyOf(list2);
    }

    private ButtonInfo(Builder builder) {
        this(builder.buttonTitle, builder.modeInfo, builder.buttonValue, builder.buttonIndex, builder.cateCode, builder.secondary);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ButtonInfo)) {
            return false;
        }
        ButtonInfo buttonInfo = (ButtonInfo) obj;
        if (!equals((Object) this.buttonTitle, (Object) buttonInfo.buttonTitle) || !equals((List<?>) this.modeInfo, (List<?>) buttonInfo.modeInfo) || !equals((Object) this.buttonValue, (Object) buttonInfo.buttonValue) || !equals((Object) this.buttonIndex, (Object) buttonInfo.buttonIndex) || !equals((Object) this.cateCode, (Object) buttonInfo.cateCode) || !equals((List<?>) this.secondary, (List<?>) buttonInfo.secondary)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.buttonTitle;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<ButtonModeInfo> list = this.modeInfo;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.buttonValue;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.buttonIndex;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.cateCode;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i4 = (hashCode4 + i2) * 37;
        List<ButtonInfo> list2 = this.secondary;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ButtonInfo> {
        public Integer buttonIndex;
        public String buttonTitle;
        public Integer buttonValue;
        public Integer cateCode;
        public List<ButtonModeInfo> modeInfo;
        public List<ButtonInfo> secondary;

        public Builder() {
        }

        public Builder(ButtonInfo buttonInfo) {
            super(buttonInfo);
            if (buttonInfo != null) {
                this.buttonTitle = buttonInfo.buttonTitle;
                this.modeInfo = ButtonInfo.copyOf(buttonInfo.modeInfo);
                this.buttonValue = buttonInfo.buttonValue;
                this.buttonIndex = buttonInfo.buttonIndex;
                this.cateCode = buttonInfo.cateCode;
                this.secondary = ButtonInfo.copyOf(buttonInfo.secondary);
            }
        }

        public Builder buttonTitle(String str) {
            this.buttonTitle = str;
            return this;
        }

        public Builder modeInfo(List<ButtonModeInfo> list) {
            this.modeInfo = checkForNulls(list);
            return this;
        }

        public Builder buttonValue(Integer num) {
            this.buttonValue = num;
            return this;
        }

        public Builder buttonIndex(Integer num) {
            this.buttonIndex = num;
            return this;
        }

        public Builder cateCode(Integer num) {
            this.cateCode = num;
            return this;
        }

        public Builder secondary(List<ButtonInfo> list) {
            this.secondary = checkForNulls(list);
            return this;
        }

        public ButtonInfo build() {
            checkRequiredFields();
            return new ButtonInfo(this);
        }
    }
}
