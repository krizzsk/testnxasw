package p218io.flutter.app;

import android.app.Activity;
import android.app.Application;
import p218io.flutter.FlutterInjector;

/* renamed from: io.flutter.app.FlutterApplication */
public class FlutterApplication extends Application {

    /* renamed from: a */
    private Activity f60088a = null;

    public void onCreate() {
        super.onCreate();
        FlutterInjector.instance().flutterLoader().startInitialization(this);
    }

    public Activity getCurrentActivity() {
        return this.f60088a;
    }

    public void setCurrentActivity(Activity activity) {
        this.f60088a = activity;
    }
}
