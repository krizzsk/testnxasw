package com.didi.rlab.uni_foundation.network;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.rlab.uni_foundation.network.NetworkReachabilityPlugin;
import java.util.HashMap;
import p218io.flutter.plugin.common.BasicMessageChannel;
import p218io.flutter.plugin.common.BinaryMessenger;
import p218io.flutter.plugin.common.StandardMessageCodec;

public class NetworkReachabilityPlugin {

    /* renamed from: a */
    private BinaryMessenger f36845a;

    public interface Result<T> {
        void result(T t);
    }

    public void setup(BinaryMessenger binaryMessenger) {
        this.f36845a = binaryMessenger;
        UniAPI.registerModule(this);
    }

    public void reachabilityChangeNotification(long j, Result<Void> result) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(this.f36845a, "com.didi.rlab.uni_api.NetworkReachabilityPlugin.reachabilityChangeNotification", new StandardMessageCodec());
        HashMap hashMap = new HashMap();
        hashMap.put("status", Long.valueOf(j));
        basicMessageChannel.send(hashMap, new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                NetworkReachabilityPlugin.Result.this.result(null);
            }
        });
    }
}
