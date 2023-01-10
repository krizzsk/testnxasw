package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class TransBackendRsp extends Message {
    public static final ByteString DEFAULT_COMPRESSED_PACK = ByteString.EMPTY;
    public static final String DEFAULT_MSG = "";
    public static final Long DEFAULT_SC = 0L;
    public static final Long DEFAULT_SEQID = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.BYTES)
    public final ByteString compressed_pack;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT64)

    /* renamed from: sc */
    public final Long f39771sc;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long seqid;

    public TransBackendRsp(Long l, Long l2, String str, ByteString byteString) {
        this.seqid = l;
        this.f39771sc = l2;
        this.msg = str;
        this.compressed_pack = byteString;
    }

    private TransBackendRsp(Builder builder) {
        this(builder.seqid, builder.f39772sc, builder.msg, builder.compressed_pack);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransBackendRsp)) {
            return false;
        }
        TransBackendRsp transBackendRsp = (TransBackendRsp) obj;
        if (!equals((Object) this.seqid, (Object) transBackendRsp.seqid) || !equals((Object) this.f39771sc, (Object) transBackendRsp.f39771sc) || !equals((Object) this.msg, (Object) transBackendRsp.msg) || !equals((Object) this.compressed_pack, (Object) transBackendRsp.compressed_pack)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.seqid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.f39771sc;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.msg;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        ByteString byteString = this.compressed_pack;
        if (byteString != null) {
            i2 = byteString.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TransBackendRsp> {
        public ByteString compressed_pack;
        public String msg;

        /* renamed from: sc */
        public Long f39772sc;
        public Long seqid;

        public Builder() {
        }

        public Builder(TransBackendRsp transBackendRsp) {
            super(transBackendRsp);
            if (transBackendRsp != null) {
                this.seqid = transBackendRsp.seqid;
                this.f39772sc = transBackendRsp.f39771sc;
                this.msg = transBackendRsp.msg;
                this.compressed_pack = transBackendRsp.compressed_pack;
            }
        }

        public Builder seqid(Long l) {
            this.seqid = l;
            return this;
        }

        /* renamed from: sc */
        public Builder mo101652sc(Long l) {
            this.f39772sc = l;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder compressed_pack(ByteString byteString) {
            this.compressed_pack = byteString;
            return this;
        }

        public TransBackendRsp build() {
            checkRequiredFields();
            return new TransBackendRsp(this);
        }
    }
}
