package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiFailDriverInfo extends Message {
    public static final Integer DEFAULT_BUFF = 0;
    public static final String DEFAULT_DRIVERNAME = "";
    public static final Integer DEFAULT_LENG = 0;
    public static final String DEFAULT_LICENSE = "";
    public static final Integer DEFAULT_MULTI = 0;
    public static final Integer DEFAULT_PK_VALUE = 0;
    public static final String DEFAULT_RANK = "";
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer buff;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String driverName;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer leng;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String license;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer multi;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer pk_value;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String rank;

    public TaxiFailDriverInfo(Integer num, Integer num2, Integer num3, String str, String str2, String str3, Integer num4) {
        this.multi = num;
        this.leng = num2;
        this.buff = num3;
        this.driverName = str;
        this.license = str2;
        this.rank = str3;
        this.pk_value = num4;
    }

    private TaxiFailDriverInfo(Builder builder) {
        this(builder.multi, builder.leng, builder.buff, builder.driverName, builder.license, builder.rank, builder.pk_value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiFailDriverInfo)) {
            return false;
        }
        TaxiFailDriverInfo taxiFailDriverInfo = (TaxiFailDriverInfo) obj;
        if (!equals((Object) this.multi, (Object) taxiFailDriverInfo.multi) || !equals((Object) this.leng, (Object) taxiFailDriverInfo.leng) || !equals((Object) this.buff, (Object) taxiFailDriverInfo.buff) || !equals((Object) this.driverName, (Object) taxiFailDriverInfo.driverName) || !equals((Object) this.license, (Object) taxiFailDriverInfo.license) || !equals((Object) this.rank, (Object) taxiFailDriverInfo.rank) || !equals((Object) this.pk_value, (Object) taxiFailDriverInfo.pk_value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.multi;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.leng;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.buff;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.driverName;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.license;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.rank;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num4 = this.pk_value;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiFailDriverInfo> {
        public Integer buff;
        public String driverName;
        public Integer leng;
        public String license;
        public Integer multi;
        public Integer pk_value;
        public String rank;

        public Builder() {
        }

        public Builder(TaxiFailDriverInfo taxiFailDriverInfo) {
            super(taxiFailDriverInfo);
            if (taxiFailDriverInfo != null) {
                this.multi = taxiFailDriverInfo.multi;
                this.leng = taxiFailDriverInfo.leng;
                this.buff = taxiFailDriverInfo.buff;
                this.driverName = taxiFailDriverInfo.driverName;
                this.license = taxiFailDriverInfo.license;
                this.rank = taxiFailDriverInfo.rank;
                this.pk_value = taxiFailDriverInfo.pk_value;
            }
        }

        public Builder multi(Integer num) {
            this.multi = num;
            return this;
        }

        public Builder leng(Integer num) {
            this.leng = num;
            return this;
        }

        public Builder buff(Integer num) {
            this.buff = num;
            return this;
        }

        public Builder driverName(String str) {
            this.driverName = str;
            return this;
        }

        public Builder license(String str) {
            this.license = str;
            return this;
        }

        public Builder rank(String str) {
            this.rank = str;
            return this;
        }

        public Builder pk_value(Integer num) {
            this.pk_value = num;
            return this;
        }

        public TaxiFailDriverInfo build() {
            return new TaxiFailDriverInfo(this);
        }
    }
}
