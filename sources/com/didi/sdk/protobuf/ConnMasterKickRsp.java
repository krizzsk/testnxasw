package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnMasterKickRsp extends Message {
    public static final Integer DEFAULT_RC = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)

    /* renamed from: rc */
    public final Integer f39751rc;

    public ConnMasterKickRsp(Integer num) {
        this.f39751rc = num;
    }

    private ConnMasterKickRsp(Builder builder) {
        this(builder.f39752rc);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnMasterKickRsp)) {
            return false;
        }
        return equals((Object) this.f39751rc, (Object) ((ConnMasterKickRsp) obj).f39751rc);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.f39751rc;
            i = num != null ? num.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ConnMasterKickRsp> {

        /* renamed from: rc */
        public Integer f39752rc;

        public Builder() {
        }

        public Builder(ConnMasterKickRsp connMasterKickRsp) {
            super(connMasterKickRsp);
            if (connMasterKickRsp != null) {
                this.f39752rc = connMasterKickRsp.f39751rc;
            }
        }

        /* renamed from: rc */
        public Builder mo100904rc(Integer num) {
            this.f39752rc = num;
            return this;
        }

        public ConnMasterKickRsp build() {
            checkRequiredFields();
            return new ConnMasterKickRsp(this);
        }
    }
}
