package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TransRsp extends Message {
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final RspMsg rsp_msg;

    public TransRsp(RspMsg rspMsg) {
        this.rsp_msg = rspMsg;
    }

    private TransRsp(Builder builder) {
        this(builder.rsp_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransRsp)) {
            return false;
        }
        return equals((Object) this.rsp_msg, (Object) ((TransRsp) obj).rsp_msg);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            RspMsg rspMsg = this.rsp_msg;
            i = rspMsg != null ? rspMsg.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<TransRsp> {
        public RspMsg rsp_msg;

        public Builder() {
        }

        public Builder(TransRsp transRsp) {
            super(transRsp);
            if (transRsp != null) {
                this.rsp_msg = transRsp.rsp_msg;
            }
        }

        public Builder rsp_msg(RspMsg rspMsg) {
            this.rsp_msg = rspMsg;
            return this;
        }

        public TransRsp build() {
            checkRequiredFields();
            return new TransRsp(this);
        }
    }
}
