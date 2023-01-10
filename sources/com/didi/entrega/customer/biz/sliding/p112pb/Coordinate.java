package com.didi.entrega.customer.biz.sliding.p112pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.entrega.customer.biz.sliding.pb.Coordinate */
public final class Coordinate extends Message {
    public static final Integer DEFAULT_ANGLE = 0;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Double DEFAULT_X;
    public static final Double DEFAULT_Y;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer angle;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)

    /* renamed from: dx */
    public final Double f21696dx;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)

    /* renamed from: dy */
    public final Double f21697dy;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)

    /* renamed from: x */
    public final Double f21698x;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)

    /* renamed from: y */
    public final Double f21699y;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
    }

    public Coordinate(Double d, Double d2, CoordinateType coordinateType, Integer num, Double d3, Double d4, Integer num2) {
        this.f21698x = d;
        this.f21699y = d2;
        this.type = coordinateType;
        this.timestamp = num;
        this.f21696dx = d3;
        this.f21697dy = d4;
        this.angle = num2;
    }

    private Coordinate(Builder builder) {
        this(builder.f21702x, builder.f21703y, builder.type, builder.timestamp, builder.f21700dx, builder.f21701dy, builder.angle);
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
        if (!equals((Object) this.f21698x, (Object) coordinate.f21698x) || !equals((Object) this.f21699y, (Object) coordinate.f21699y) || !equals((Object) this.type, (Object) coordinate.type) || !equals((Object) this.timestamp, (Object) coordinate.timestamp) || !equals((Object) this.f21696dx, (Object) coordinate.f21696dx) || !equals((Object) this.f21697dy, (Object) coordinate.f21697dy) || !equals((Object) this.angle, (Object) coordinate.angle)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.f21698x;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.f21699y;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        CoordinateType coordinateType = this.type;
        int hashCode3 = (hashCode2 + (coordinateType != null ? coordinateType.hashCode() : 0)) * 37;
        Integer num = this.timestamp;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Double d3 = this.f21696dx;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.f21697dy;
        int hashCode6 = (hashCode5 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Integer num2 = this.angle;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.entrega.customer.biz.sliding.pb.Coordinate$Builder */
    public static final class Builder extends Message.Builder<Coordinate> {
        public Integer angle;

        /* renamed from: dx */
        public Double f21700dx;

        /* renamed from: dy */
        public Double f21701dy;
        public Integer timestamp;
        public CoordinateType type;

        /* renamed from: x */
        public Double f21702x;

        /* renamed from: y */
        public Double f21703y;

        public Builder() {
        }

        public Builder(Coordinate coordinate) {
            super(coordinate);
            if (coordinate != null) {
                this.f21702x = coordinate.f21698x;
                this.f21703y = coordinate.f21699y;
                this.type = coordinate.type;
                this.timestamp = coordinate.timestamp;
                this.f21700dx = coordinate.f21696dx;
                this.f21701dy = coordinate.f21697dy;
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
        public Builder mo64697x(Double d) {
            this.f21702x = d;
            return this;
        }

        /* renamed from: y */
        public Builder mo64698y(Double d) {
            this.f21703y = d;
            return this;
        }
    }
}
