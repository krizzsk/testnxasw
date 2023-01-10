package p218io.flutter.plugin.platform;

import android.content.Context;
import p218io.flutter.plugin.common.MessageCodec;

/* renamed from: io.flutter.plugin.platform.PlatformViewFactory */
public abstract class PlatformViewFactory {

    /* renamed from: a */
    private final MessageCodec<Object> f60625a;

    public abstract PlatformView create(Context context, int i, Object obj);

    public PlatformViewFactory(MessageCodec<Object> messageCodec) {
        this.f60625a = messageCodec;
    }

    public final MessageCodec<Object> getCreateArgsCodec() {
        return this.f60625a;
    }
}
