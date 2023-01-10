package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

public interface AesCtrHmacStreamingKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    AesCtrHmacStreamingParams getParams();

    int getVersion();

    boolean hasParams();
}
