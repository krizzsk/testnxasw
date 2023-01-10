package p218io.flutter.view;

import p218io.flutter.embedding.engine.FlutterJNI;

/* renamed from: io.flutter.view.FlutterCallbackInformation */
public final class FlutterCallbackInformation {
    public final String callbackClassName;
    public final String callbackLibraryPath;
    public final String callbackName;

    public static FlutterCallbackInformation lookupCallbackInformation(long j) {
        return FlutterJNI.nativeLookupCallbackInformation(j);
    }

    private FlutterCallbackInformation(String str, String str2, String str3) {
        this.callbackName = str;
        this.callbackClassName = str2;
        this.callbackLibraryPath = str3;
    }
}
