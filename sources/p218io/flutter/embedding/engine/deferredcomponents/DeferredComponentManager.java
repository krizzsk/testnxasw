package p218io.flutter.embedding.engine.deferredcomponents;

import p218io.flutter.embedding.engine.FlutterJNI;
import p218io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;

/* renamed from: io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager */
public interface DeferredComponentManager {
    void destroy();

    String getDeferredComponentInstallState(int i, String str);

    void installDeferredComponent(int i, String str);

    void loadAssets(int i, String str);

    void loadDartLibrary(int i, String str);

    void setDeferredComponentChannel(DeferredComponentChannel deferredComponentChannel);

    void setJNI(FlutterJNI flutterJNI);

    boolean uninstallDeferredComponent(int i, String str);
}
