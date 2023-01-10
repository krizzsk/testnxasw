package p218io.flutter.embedding.engine;

import android.view.Surface;

/* renamed from: io.flutter.embedding.engine.FlutterOverlaySurface */
public class FlutterOverlaySurface {

    /* renamed from: id */
    private final int f60367id;
    private final Surface surface;

    public FlutterOverlaySurface(int i, Surface surface2) {
        this.f60367id = i;
        this.surface = surface2;
    }

    public int getId() {
        return this.f60367id;
    }

    public Surface getSurface() {
        return this.surface;
    }
}
