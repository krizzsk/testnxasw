package p218io.reactivex.internal.fuseable;

/* renamed from: io.reactivex.internal.fuseable.QueueFuseable */
public interface QueueFuseable<T> extends SimpleQueue<T> {
    public static final int ANY = 3;
    public static final int ASYNC = 2;
    public static final int BOUNDARY = 4;
    public static final int NONE = 0;
    public static final int SYNC = 1;

    int requestFusion(int i);
}