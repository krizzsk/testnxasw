package p218io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import p218io.flutter.app.FlutterActivityDelegate;
import p218io.flutter.plugin.common.PluginRegistry;
import p218io.flutter.view.FlutterNativeView;
import p218io.flutter.view.FlutterView;

@Deprecated
/* renamed from: io.flutter.app.FlutterActivity */
public class FlutterActivity extends Activity implements FlutterActivityDelegate.ViewFactory, PluginRegistry, FlutterView.Provider {

    /* renamed from: a */
    private static final String f60076a = "FlutterActivity";

    /* renamed from: b */
    private final FlutterActivityDelegate f60077b;

    /* renamed from: c */
    private final FlutterActivityEvents f60078c;

    /* renamed from: d */
    private final FlutterView.Provider f60079d;

    /* renamed from: e */
    private final PluginRegistry f60080e;

    public FlutterNativeView createFlutterNativeView() {
        return null;
    }

    public FlutterView createFlutterView(Context context) {
        return null;
    }

    public boolean retainFlutterNativeView() {
        return false;
    }

    public FlutterActivity() {
        FlutterActivityDelegate flutterActivityDelegate = new FlutterActivityDelegate(this, this);
        this.f60077b = flutterActivityDelegate;
        this.f60078c = flutterActivityDelegate;
        this.f60079d = flutterActivityDelegate;
        this.f60080e = flutterActivityDelegate;
    }

    public FlutterView getFlutterView() {
        return this.f60079d.getFlutterView();
    }

    public final boolean hasPlugin(String str) {
        return this.f60080e.hasPlugin(str);
    }

    public final <T> T valuePublishedByPlugin(String str) {
        return this.f60080e.valuePublishedByPlugin(str);
    }

    public final PluginRegistry.Registrar registrarFor(String str) {
        return this.f60080e.registrarFor(str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f60078c.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f60078c.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f60078c.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f60078c.onDestroy();
        super.onDestroy();
    }

    public void onBackPressed() {
        if (!this.f60078c.onBackPressed()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f60078c.onStop();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f60078c.onPause();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.f60078c.onPostResume();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f60078c.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.f60078c.onActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        this.f60078c.onNewIntent(intent);
    }

    public void onUserLeaveHint() {
        this.f60078c.onUserLeaveHint();
    }

    public void onTrimMemory(int i) {
        this.f60078c.onTrimMemory(i);
    }

    public void onLowMemory() {
        this.f60078c.onLowMemory();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f60078c.onConfigurationChanged(configuration);
    }
}
