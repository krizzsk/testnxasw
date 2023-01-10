package p218io.flutter.embedding.engine.systemchannels;

import p218io.flutter.Log;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.plugin.common.BasicMessageChannel;
import p218io.flutter.plugin.common.StringCodec;

/* renamed from: io.flutter.embedding.engine.systemchannels.LifecycleChannel */
public class LifecycleChannel {

    /* renamed from: a */
    private static final String f60478a = "LifecycleChannel";
    public final BasicMessageChannel<String> channel;

    public LifecycleChannel(DartExecutor dartExecutor) {
        this.channel = new BasicMessageChannel<>(dartExecutor, "flutter/lifecycle", StringCodec.INSTANCE);
    }

    public void appIsInactive() {
        Log.m45259v(f60478a, "Sending AppLifecycleState.inactive message.");
        this.channel.send("AppLifecycleState.inactive");
    }

    public void appIsResumed() {
        Log.m45259v(f60478a, "Sending AppLifecycleState.resumed message.");
        this.channel.send("AppLifecycleState.resumed");
    }

    public void appIsPaused() {
        Log.m45259v(f60478a, "Sending AppLifecycleState.paused message.");
        this.channel.send("AppLifecycleState.paused");
    }

    public void appIsDetached() {
        Log.m45259v(f60478a, "Sending AppLifecycleState.detached message.");
        this.channel.send("AppLifecycleState.detached");
    }
}
