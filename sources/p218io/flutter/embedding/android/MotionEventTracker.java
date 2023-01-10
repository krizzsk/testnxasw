package p218io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: io.flutter.embedding.android.MotionEventTracker */
public final class MotionEventTracker {

    /* renamed from: c */
    private static MotionEventTracker f60319c;

    /* renamed from: a */
    private final LongSparseArray<MotionEvent> f60320a = new LongSparseArray<>();

    /* renamed from: b */
    private final PriorityQueue<Long> f60321b = new PriorityQueue<>();

    /* renamed from: io.flutter.embedding.android.MotionEventTracker$MotionEventId */
    public static class MotionEventId {
        private static final AtomicLong ID_COUNTER = new AtomicLong(0);
        /* access modifiers changed from: private */

        /* renamed from: id */
        public final long f60322id;

        private MotionEventId(long j) {
            this.f60322id = j;
        }

        public static MotionEventId from(long j) {
            return new MotionEventId(j);
        }

        public static MotionEventId createUnique() {
            return from(ID_COUNTER.incrementAndGet());
        }

        public long getId() {
            return this.f60322id;
        }
    }

    public static MotionEventTracker getInstance() {
        if (f60319c == null) {
            f60319c = new MotionEventTracker();
        }
        return f60319c;
    }

    private MotionEventTracker() {
    }

    public MotionEventId track(MotionEvent motionEvent) {
        MotionEventId createUnique = MotionEventId.createUnique();
        this.f60320a.put(createUnique.f60322id, MotionEvent.obtain(motionEvent));
        this.f60321b.add(Long.valueOf(createUnique.f60322id));
        return createUnique;
    }

    public MotionEvent pop(MotionEventId motionEventId) {
        while (!this.f60321b.isEmpty() && this.f60321b.peek().longValue() < motionEventId.f60322id) {
            this.f60320a.remove(this.f60321b.poll().longValue());
        }
        if (!this.f60321b.isEmpty() && this.f60321b.peek().longValue() == motionEventId.f60322id) {
            this.f60321b.poll();
        }
        MotionEvent motionEvent = this.f60320a.get(motionEventId.f60322id);
        this.f60320a.remove(motionEventId.f60322id);
        return motionEvent;
    }
}
