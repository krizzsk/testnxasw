package p218io.flutter.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import p218io.flutter.app.FlutterActivityDelegate;
import p218io.flutter.plugin.common.PluginRegistry;
import p218io.flutter.view.FlutterNativeView;
import p218io.flutter.view.FlutterView;

@Deprecated
/* renamed from: io.flutter.app.FlutterFragmentActivity */
public class FlutterFragmentActivity extends FragmentActivity implements FlutterActivityDelegate.ViewFactory, PluginRegistry, FlutterView.Provider {

    /* renamed from: a */
    private final FlutterActivityDelegate f60089a;

    /* renamed from: b */
    private final FlutterActivityEvents f60090b;

    /* renamed from: c */
    private final FlutterView.Provider f60091c;

    /* renamed from: d */
    private final PluginRegistry f60092d;

    public FlutterNativeView createFlutterNativeView() {
        return null;
    }

    public FlutterView createFlutterView(Context context) {
        return null;
    }

    public boolean retainFlutterNativeView() {
        return false;
    }

    public FlutterFragmentActivity() {
        FlutterActivityDelegate flutterActivityDelegate = new FlutterActivityDelegate(this, this);
        this.f60089a = flutterActivityDelegate;
        this.f60090b = flutterActivityDelegate;
        this.f60091c = flutterActivityDelegate;
        this.f60092d = flutterActivityDelegate;
    }

    public FlutterView getFlutterView() {
        return this.f60091c.getFlutterView();
    }

    public final boolean hasPlugin(String str) {
        return this.f60092d.hasPlugin(str);
    }

    public final <T> T valuePublishedByPlugin(String str) {
        return this.f60092d.valuePublishedByPlugin(str);
    }

    public final PluginRegistry.Registrar registrarFor(String str) {
        return this.f60092d.registrarFor(str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f60090b.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f60090b.onDestroy();
        super.onDestroy();
    }

    public void onBackPressed() {
        if (!this.f60090b.onBackPressed()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f60090b.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f60090b.onStop();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f60090b.onPause();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.f60090b.onPostResume();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f60090b.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.f60090b.onActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f60090b.onNewIntent(intent);
    }

    public void onUserLeaveHint() {
        this.f60090b.onUserLeaveHint();
    }

    public void onTrimMemory(int i) {
        this.f60090b.onTrimMemory(i);
    }

    public void onLowMemory() {
        this.f60090b.onLowMemory();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f60090b.onConfigurationChanged(configuration);
    }
}
