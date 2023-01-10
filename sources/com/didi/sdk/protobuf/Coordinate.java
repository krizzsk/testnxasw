package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Coordinate extends Message {
    public static final Integer DEFAULT_ANGLE = 0;
    public static final Double DEFAULT_DX;
    public static final Double DEFAULT_DY;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final CoordinateType DEFAULT_TYPE = CoordinateType.BD_09;
    public static final Double DEFAULT_X;
    public static final Double DEFAULT_Y;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer angle;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)

    /* renamed from: dx */
    public final Double f39753dx;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)

    /* renamed from: dy */
    public final Double f39754dy;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)

    /* renamed from: x */
    public final Double f39755x;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)

    /* renamed from: y */
    public final Double f39756y;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
        DEFAULT_DX = valueOf;
        DEFAULT_DY = valueOf;
    }

    public Coordinate(Double d, Double d2, CoordinateType coordinateType, Integer num, Double d3, Double d4, Integer num2) {
        this.f39755x = d;
        this.f39756y = d2;
        this.type = coordinateType;
        this.timestamp = num;
        this.f39753dx = d3;
        this.f39754dy = d4;
        this.angle = num2;
    }

    private Coordinate(Builder builder) {
        this(builder.f39759x, builder.f39760y, builder.type, builder.timestamp, builder.f39757dx, builder.f39758dy, builder.angle);
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
        if (!equals((Object) this.f39755x, (Object) coordinate.f39755x) || !equals((Object) this.f39756y, (Object) coordinate.f39756y) || !equals((Object) this.type, (Object) coordinate.type) || !equals((Object) this.timestamp, (Object) coordinate.timestamp) || !equals((Object) this.f39753dx, (Object) coordinate.f39753dx) || !equals((Object) this.f39754dy, (Object) coordinate.f39754dy) || !equals((Object) this.angle, (Object) coordinate.angle)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.f39755x;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.f39756y;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        CoordinateType coordinateType = this.type;
        int hashCode3 = (hashCode2 + (coordinateType != null ? coordinateType.hashCode() : 0)) * 37;
        Integer num = this.timestamp;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Double d3 = this.f39753dx;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.f39754dy;
        int hashCode6 = (hashCode5 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Integer num2 = this.angle;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Coordinate> {
        public Integer angle;

        /* renamed from: dx */
        public Double f39757dx;

        /* renamed from: dy */
        public Double f39758dy;
        public Integer timestamp;
        public CoordinateType type;

        /* renamed from: x */
        public Double f39759x;

        /* renamed from: y */
        public Double f39760y;

        public Builder() {
        }

        public Builder(Coordinate coordinate) {
            super(coordinate);
            if (coordinate != null) {
                this.f39759x = coordinate.f39755x;
                this.f39760y = coordinate.f39756y;
                this.type = coordinate.type;
                this.timestamp = coordinate.timestamp;
                this.f39757dx = coordinate.f39753dx;
                this.f39758dy = coordinate.f39754dy;
                this.angle = coordinate.angle;
            }
        }

        /* renamed from: x */
        public Builder mo100962x(Double d) {
            this.f39759x = d;
            return this;
        }

        /* renamed from: y */
        public Builder mo100963y(Double d) {
            this.f39760y = d;
            return this;
        }

        public Builder type(CoordinateType coordinateType) {
            this.type = coordinateType;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        /* renamed from: dx */
        public Builder mo100958dx(Double d) {
            this.f39757dx = d;
            return this;
        }

        /* renamed from: dy */
        public Builder mo100959dy(Double d) {
            this.f39758dy = d;
            return this;
        }

        public Builder angle(Integer num) {
            this.angle = num;
            return this;
        }

        public Coordinate build() {
            checkRequiredFields();
            return new Coordinate(this);
        }
    }
}
