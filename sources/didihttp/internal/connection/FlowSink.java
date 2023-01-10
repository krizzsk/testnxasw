package didihttp.internal.connection;

import java.io.IOException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

public class FlowSink implements Sink {

    /* renamed from: a */
    private Sink f59418a;

    /* renamed from: b */
    private Callback f59419b;

    /* renamed from: c */
    private long f59420c = 0;

    public interface Callback {
        void onClose(long j);

        void onFlush(long j);
    }

    public FlowSink(Sink sink) {
        this.f59418a = sink;
    }

    public void setCallback(Callback callback) {
        this.f59419b = callback;
    }

    public long getCount() {
        return this.f59420c;
    }

    public void reset() {
        this.f59420c = 0;
    }

    public void write(Buffer buffer, long j) throws IOException {
        try {
            this.f59418a.write(buffer, j);
            this.f59420c += j;
        } catch (NullPointerException e) {
            throw new IOException(e);
        }
    }

    public void flush() throws IOException {
        try {
            this.f59418a.flush();
        } finally {
            Callback callback = this.f59419b;
            if (callback != null) {
                callback.onFlush(this.f59420c);
            }
        }
    }

    public Timeout timeout() {
        return this.f59418a.timeout();
    }

    public void close() throws IOException {
        try {
            this.f59418a.close();
        } finally {
            Callback callback = this.f59419b;
            if (callback != null) {
                callback.onClose(this.f59420c);
            }
        }
    }
}
