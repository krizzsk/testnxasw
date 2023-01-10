package p218io.flutter.plugin.platform;

import java.util.HashMap;
import java.util.Map;

/* renamed from: io.flutter.plugin.platform.b */
/* compiled from: PlatformViewRegistryImpl */
class C22123b implements PlatformViewRegistry {

    /* renamed from: a */
    private final Map<String, PlatformViewFactory> f60656a = new HashMap();

    C22123b() {
    }

    public boolean registerViewFactory(String str, PlatformViewFactory platformViewFactory) {
        if (this.f60656a.containsKey(str)) {
            return false;
        }
        this.f60656a.put(str, platformViewFactory);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PlatformViewFactory mo182689a(String str) {
        return this.f60656a.get(str);
    }
}
