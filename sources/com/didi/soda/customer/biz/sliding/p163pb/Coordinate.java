package com.didi.soda.customer.biz.sliding.p163pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.soda.customer.biz.sliding.pb.Coordinate */
public final class Coordinate extends Message {
    public static final Integer DEFAULT_ANGLE = 0;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Double DEFAULT_X;
    public static final Double DEFAULT_Y;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer angle;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)

    /* renamed from: dx */
    public final Double f43130dx;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)

    /* renamed from: dy */
    public final Double f43131dy;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)

    /* renamed from: x */
    public final Double f43132x;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)

    /* renamed from: y */
    public final Double f43133y;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
    }

    public Coordinate(Double d, Double d2, CoordinateType coordinateType, Integer num, Double d3, Double d4, Integer num2) {
        this.f43132x = d;
        this.f43133y = d2;
        this.type = coordinateType;
        this.timestamp = num;
        this.f43130dx = d3;
        this.f43131dy = d4;
        this.angle = num2;
    }

    private Coordinate(Builder builder) {
        this(builder.f43136x, builder.f43137y, builder.type, builder.timestamp, builder.f43134dx, builder.f43135dy, builder.angle);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate coordinate = (Coordinate) obj;
        if (!equals((Object) this.f43132x, (Object) coordinate.f43132x) || !equals((Object) this.f43133y, (Object) coordinate.f43133y) || !equals((Object) this.type, (Object) coordinate.type) || !equals((Object) this.timestamp, (Object) coordinate.timestamp) || !equals((Object) this.f43130dx, (Object) coordinate.f43130dx) || !equals((Object) this.f43131dy, (Object) coordinate.f43131dy) || !equals((Object) this.angle, (Object) coordinate.angle)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.f43132x;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.f43133y;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        CoordinateType coordinateType = this.type;
        int hashCode3 = (hashCode2 + (coordinateType != null ? coordinateType.hashCode() : 0)) * 37;
        Integer num = this.timestamp;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Double d3 = this.f43130dx;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.f43131dy;
        int hashCode6 = (hashCode5 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Integer num2 = this.angle;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.soda.customer.biz.sliding.pb.Coordinate$Builder */
    public static final class Builder extends Message.Builder<Coordinate> {
        public Integer angle;

        /* renamed from: dx */
        public Double f43134dx;

        /* renamed from: dy */
        public Double f43135dy;
        public Integer timestamp;
        public CoordinateType type;

        /* renamed from: x */
        public Double f43136x;

        /* renamed from: y */
        public Double f43137y;

        public Builder() {
        }

        public Builder(Coordinate coordinate) {
            super(coordinate);
            if (coordinate != null) {
                this.f43136x = coordinate.f43132x;
                this.f43137y = coordinate.f43133y;
                this.type = coordinate.type;
                this.timestamp = coordinate.timestamp;
                this.f43134dx = coordinate.f43130dx;
                this.f43135dy = coordinate.f43131dy;
                this.angle = coordinate.angle;
            }
        }

        public Builder angle(Integer num) {
            this.angle = num;
            return this;
        }

        public Coordinate build() {
            checkRequiredFields();
            return new Coordinate(this);
        }

        public Builder type(CoordinateType coordinateType) {
            this.type = coordinateType;
            return this;
        }

        /* renamed from: x */
        public Builder mo108634x(Double d) {
            this.f43136x = d;
            return this;
        }

        /* renamed from: y */
        public Builder mo108635y(Double d) {
            this.f43137y = d;
            return this;
        }
    }
}
