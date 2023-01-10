package p218io.reactivex.internal.util;

import java.util.concurrent.CountDownLatch;
import p218io.reactivex.functions.Action;
import p218io.reactivex.functions.Consumer;

/* renamed from: io.reactivex.internal.util.BlockingIgnoringReceiver */
public final class BlockingIgnoringReceiver extends CountDownLatch implements Action, Consumer<Throwable> {
    public Throwable error;

    public BlockingIgnoringReceiver() {
        super(1);
    }

    public void accept(Throwable th) {
        this.error = th;
        countDown();
    }

    public void run() {
        countDown();
    }
}
