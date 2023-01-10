package p218io.flutter.plugin.common;

import p218io.flutter.Log;
import p218io.flutter.plugin.common.MethodChannel;

/* renamed from: io.flutter.plugin.common.ErrorLogResult */
public class ErrorLogResult implements MethodChannel.Result {

    /* renamed from: a */
    private String f60517a;

    /* renamed from: b */
    private int f60518b;

    public void success(Object obj) {
    }

    public ErrorLogResult(String str) {
        this(str, Log.WARN);
    }

    public ErrorLogResult(String str, int i) {
        this.f60517a = str;
        this.f60518b = i;
    }

    public void error(String str, String str2, Object obj) {
        String str3;
        if (obj != null) {
            str3 = " details: " + obj;
        } else {
            str3 = "";
        }
        if (this.f60518b >= Log.WARN) {
            Log.println(this.f60518b, this.f60517a, str2 + str3);
        }
    }

    public void notImplemented() {
        if (this.f60518b >= Log.WARN) {
            Log.println(this.f60518b, this.f60517a, "method not implemented");
        }
    }
}
