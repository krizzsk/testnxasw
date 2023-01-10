package com.didi.rlab.uni_foundation.p144im;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.rlab.uni_foundation.p144im.IMServicePlugin;
import java.util.HashMap;
import p218io.flutter.plugin.common.BasicMessageChannel;
import p218io.flutter.plugin.common.BinaryMessenger;
import p218io.flutter.plugin.common.StandardMessageCodec;

/* renamed from: com.didi.rlab.uni_foundation.im.IMServicePlugin */
public class IMServicePlugin {

    /* renamed from: a */
    private BinaryMessenger f36817a;

    /* renamed from: com.didi.rlab.uni_foundation.im.IMServicePlugin$Result */
    public interface Result<T> {
        void result(T t);
    }

    public void setup(BinaryMessenger binaryMessenger) {
        this.f36817a = binaryMessenger;
        UniAPI.registerModule(this);
    }

    public void messageArrive(Result<Void> result) {
        new BasicMessageChannel(this.f36817a, "com.didi.rlab.uni_api.IMServicePlugin.messageArrive", new StandardMessageCodec()).send(new HashMap(), new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                IMServicePlugin.Result.this.result(null);
            }
        });
    }

    public void clearUnreadCount(Result<Void> result) {
        new BasicMessageChannel(this.f36817a, "com.didi.rlab.uni_api.IMServicePlugin.clearUnreadCount", new StandardMessageCodec()).send(new HashMap(), new BasicMessageChannel.Reply() {
            public final void reply(Object obj) {
                IMServicePlugin.Result.this.result(null);
            }
        });
    }
}
