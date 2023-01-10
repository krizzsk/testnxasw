package didihttp.internal.http;

import didihttp.Headers;
import didihttp.MediaType;
import didihttp.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {

    /* renamed from: a */
    private final Headers f59481a;

    /* renamed from: b */
    private final BufferedSource f59482b;

    public RealResponseBody(Headers headers, BufferedSource bufferedSource) {
        this.f59481a = headers;
        this.f59482b = bufferedSource;
    }

    public MediaType contentType() {
        String str = this.f59481a.get("Content-Type");
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    public long contentLength() {
        return HttpHeaders.contentLength(this.f59481a);
    }

    public BufferedSource source() {
        return this.f59482b;
    }
}
