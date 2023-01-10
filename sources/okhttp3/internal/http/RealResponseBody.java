package okhttp3.internal.http;

import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {
    @Nullable

    /* renamed from: a */
    private final String f7226a;

    /* renamed from: b */
    private final long f7227b;

    /* renamed from: c */
    private final BufferedSource f7228c;

    public RealResponseBody(@Nullable String str, long j, BufferedSource bufferedSource) {
        this.f7226a = str;
        this.f7227b = j;
        this.f7228c = bufferedSource;
    }

    public MediaType contentType() {
        String str = this.f7226a;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    public long contentLength() {
        return this.f7227b;
    }

    public BufferedSource source() {
        return this.f7228c;
    }
}
