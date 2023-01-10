package p218io.flutter.embedding.android.locale;

import android.content.Context;
import android.content.res.Configuration;
import p218io.flutter.embedding.android.NSkeletonFlutter;
import p218io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import p218io.flutter.plugin.localization.LocalizationPlugin;
import p218io.socket.engineio.parser.Packet;

/* renamed from: io.flutter.embedding.android.locale.NoopLocalizationPlugin */
public class NoopLocalizationPlugin extends LocalizationPlugin {
    public NoopLocalizationPlugin(Context context, LocalizationChannel localizationChannel) {
        super(context, localizationChannel);
    }

    public void sendLocalesToFlutter(Configuration configuration) {
        NSkeletonFlutter.log("sendLocalesToFlutter", Packet.NOOP);
    }
}
