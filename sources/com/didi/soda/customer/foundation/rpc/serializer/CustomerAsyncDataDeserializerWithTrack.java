package com.didi.soda.customer.foundation.rpc.serializer;

import com.didi.soda.customer.foundation.tracker.LaunchAppTracker;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class CustomerAsyncDataDeserializerWithTrack extends CustomerAsyncDataDeserializer {
    public CustomerAsyncDataDeserializerWithTrack(Type type) {
        super(type);
    }

    public Object deserialize(InputStream inputStream) throws IOException {
        LaunchAppTracker.Companion.beginTrace("ToJSON");
        Object deserialize = super.deserialize(inputStream);
        LaunchAppTracker.Companion.endTrace("ToJSON");
        return deserialize;
    }
}
