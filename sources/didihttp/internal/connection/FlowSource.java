package didihttp.internal.connection;

import java.io.IOException;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

public class FlowSource implements Source {

    /* renamed from: a */
    private Source f59421a;

    /* renamed from: b */
    private Callback f59422b;

    /* renamed from: c */
    private long f59423c = 0;

    public interface Callback {
        void onClose(long j);
    }

    public FlowSource(Source source) {
        this.f59421a = source;
    }

    public void setCallback(Callback callback) {
        this.f59422b = callback;
    }

    public long getCount() {
        return this.f59423c;
    }

    public void reset() {
        this.f59423c = 0;
    }

    public long read(Buffer buffer, long j) throws IOException {
        try {
            long read = this.f59421a.read(buffer, j);
            if (read > 0) {
                this.f59423c += read;
            }
            return read;
        } catch (NullPointerException e) {
            throw new IOException(e);
        }
    }

    public Timeout timeout() {
        return this.f59421a.timeout();
    }

    public void close() throws IOException {
        try {
            this.f59421a.close();
        } finally {
            Callback callback = this.f59422b;
            if (callback != null) {
                callback.onClose(this.f59423c);
            }
        }
    }
}
