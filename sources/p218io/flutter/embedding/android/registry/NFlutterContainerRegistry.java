package p218io.flutter.embedding.android.registry;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import p218io.flutter.embedding.android.BaseNachoSkeletonPage;

/* renamed from: io.flutter.embedding.android.registry.NFlutterContainerRegistry */
public class NFlutterContainerRegistry {

    /* renamed from: a */
    private static Map<String, WeakReference<BaseNachoSkeletonPage>> f60325a = new HashMap();

    public static void registerContainer(String str, BaseNachoSkeletonPage baseNachoSkeletonPage) {
        f60325a.put(str, new WeakReference(baseNachoSkeletonPage));
    }

    public static Map<String, WeakReference<BaseNachoSkeletonPage>> getPageRegistry() {
        return f60325a;
    }

    public static BaseNachoSkeletonPage getContainer(String str) {
        if (!f60325a.containsKey(str)) {
            return null;
        }
        return (BaseNachoSkeletonPage) f60325a.get(str).get();
    }

    public static BaseNachoSkeletonPage popContainer(String str) {
        if (!f60325a.containsKey(str)) {
            return null;
        }
        BaseNachoSkeletonPage baseNachoSkeletonPage = (BaseNachoSkeletonPage) f60325a.get(str).get();
        f60325a.remove(str);
        return baseNachoSkeletonPage;
    }

    public static boolean removeContainer(String str) {
        if (!f60325a.containsKey(str)) {
            return false;
        }
        f60325a.remove(str);
        return true;
    }
}
