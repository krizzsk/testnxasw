package p218io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

/* renamed from: io.flutter.embedding.engine.FlutterEngineCache */
public class FlutterEngineCache {

    /* renamed from: a */
    private static FlutterEngineCache f60347a;

    /* renamed from: b */
    private final Map<String, FlutterEngine> f60348b = new HashMap();

    public static FlutterEngineCache getInstance() {
        if (f60347a == null) {
            f60347a = new FlutterEngineCache();
        }
        return f60347a;
    }

    FlutterEngineCache() {
    }

    public boolean contains(String str) {
        return this.f60348b.containsKey(str);
    }

    public FlutterEngine get(String str) {
        return this.f60348b.get(str);
    }

    public void put(String str, FlutterEngine flutterEngine) {
        if (flutterEngine != null) {
            this.f60348b.put(str, flutterEngine);
        } else {
            this.f60348b.remove(str);
        }
    }

    public void remove(String str) {
        put(str, (FlutterEngine) null);
    }

    public void clear() {
        this.f60348b.clear();
    }
}
