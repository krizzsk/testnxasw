package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CdntSvrUpReq extends Message {
    public static final Double DEFAULT_DX;
    public static final Double DEFAULT_DY;
    public static final Boolean DEFAULT_PULL_PEER = false;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final CoordinateType DEFAULT_TYPE = CoordinateType.BD_09;
    public static final Double DEFAULT_X;
    public static final Double DEFAULT_Y;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)

    /* renamed from: dx */
    public final Double f39743dx;
    @ProtoField(tag = 7, type = Message.Datatype.DOUBLE)

    /* renamed from: dy */
    public final Double f39744dy;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean pull_peer;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)

    /* renamed from: x */
    public final Double f39745x;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)

    /* renamed from: y */
    public final Double f39746y;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
        DEFAULT_DX = valueOf;
        DEFAULT_DY = valueOf;
    }

    public CdntSvrUpReq(Double d, Double d2, CoordinateType coordinateType, Integer num, Boolean bool, Double d3, Double d4) {
        this.f39745x = d;
        this.f39746y = d2;
        this.type = coordinateType;
        this.timestamp = num;
        this.pull_peer = bool;
        this.f39743dx = d3;
        this.f39744dy = d4;
    }

    private CdntSvrUpReq(Builder builder) {
        this(builder.f39749x, builder.f39750y, builder.type, builder.timestamp, builder.pull_peer, builder.f39747dx, builder.f39748dy);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CdntSvrUpReq)) {
            return false;
        }
        CdntSvrUpReq cdntSvrUpReq = (CdntSvrUpReq) obj;
        if (!equals((Object) this.f39745x, (Object) cdntSvrUpReq.f39745x) || !equals((Object) this.f39746y, (Object) cdntSvrUpReq.f39746y) || !equals((Object) this.type, (Object) cdntSvrUpReq.type) || !equals((Object) this.timestamp, (Object) cdntSvrUpReq.timestamp) || !equals((Object) this.pull_peer, (Object) cdntSvrUpReq.pull_peer) || !equals((Object) this.f39743dx, (Object) cdntSvrUpReq.f39743dx) || !equals((Object) this.f39744dy, (Object) cdntSvrUpReq.f39744dy)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.f39745x;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.f39746y;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        CoordinateType coordinateType = this.type;
        int hashCode3 = (hashCode2 + (coordinateType != null ? coordinateType.hashCode() : 0)) * 37;
        Integer num = this.timestamp;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.pull_peer;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Double d3 = this.f39743dx;
        int hashCode6 = (hashCode5 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.f39744dy;
        if (d4 != null) {
            i2 = d4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CdntSvrUpReq> {

        /* renamed from: dx */
        public Double f39747dx;

        /* renamed from: dy */
        public Double f39748dy;
        public Boolean pull_peer;
        public Integer timestamp;
        public CoordinateType type;

        /* renamed from: x */
        public Double f39749x;

        /* renamed from: y */
        public Double f39750y;

        public Builder() {
        }

        public Builder(CdntSvrUpReq cdntSvrUpReq) {
            super(cdntSvrUpReq);
            if (cdntSvrUpReq != null) {
                this.f39749x = cdntSvrUpReq.f39745x;
                this.f39750y = cdntSvrUpReq.f39746y;
                this.type = cdntSvrUpReq.type;
                this.timestamp = cdntSvrUpReq.timestamp;
                this.pull_peer = cdntSvrUpReq.pull_peer;
                this.f39747dx = cdntSvrUpReq.f39743dx;
                this.f39748dy = cdntSvrUpReq.f39744dy;
            }
        }

        /* renamed from: x */
        public Builder mo100843x(Double d) {
            this.f39749x = d;
            return this;
        }

        /* renamed from: y */
        public Builder mo100844y(Double d) {
            this.f39750y = d;
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

        public Builder pull_peer(Boolean bool) {
            this.pull_peer = bool;
            return this;
        }

        /* renamed from: dx */
        public Builder mo100838dx(Double d) {
            this.f39747dx = d;
            return this;
        }

        /* renamed from: dy */
        public Builder mo100839dy(Double d) {
            this.f39748dy = d;
            return this;
        }

        public CdntSvrUpReq build() {
            checkRequiredFields();
            return new CdntSvrUpReq(this);
        }
    }
}
