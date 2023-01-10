package p218io.flutter.embedding.engine.dart;

import android.os.Handler;
import android.os.Looper;
import p218io.flutter.embedding.engine.dart.DartMessenger;

/* renamed from: io.flutter.embedding.engine.dart.PlatformTaskQueue */
public class PlatformTaskQueue implements DartMessenger.DartMessengerTaskQueue {

    /* renamed from: a */
    private final Handler f60389a = new Handler(Looper.getMainLooper());

    public void dispatch(Runnable runnable) {
        this.f60389a.post(runnable);
    }
}
