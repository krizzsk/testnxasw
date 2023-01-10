package p218io.flutter.embedding.engine.systemchannels;

import java.util.HashMap;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.plugin.common.BasicMessageChannel;
import p218io.flutter.plugin.common.JSONMessageCodec;

/* renamed from: io.flutter.embedding.engine.systemchannels.SystemChannel */
public class SystemChannel {

    /* renamed from: a */
    private static final String f60507a = "SystemChannel";
    public final BasicMessageChannel<Object> channel;

    public SystemChannel(DartExecutor dartExecutor) {
        this.channel = new BasicMessageChannel<>(dartExecutor, "flutter/system", JSONMessageCodec.INSTANCE);
    }

    public void sendMemoryPressureWarning() {
        Log.m45259v(f60507a, "Sending memory pressure warning to Flutter.");
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "memoryPressure");
        this.channel.send(hashMap);
    }
}
