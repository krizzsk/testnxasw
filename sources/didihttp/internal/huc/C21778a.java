package didihttp.internal.huc;

import com.google.common.net.HttpHeaders;
import didihttp.Request;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;

/* renamed from: didihttp.internal.huc.a */
/* compiled from: BufferedRequestBody */
final class C21778a extends C21780c {

    /* renamed from: a */
    final Buffer f59632a;

    /* renamed from: b */
    long f59633b = -1;

    C21778a(long j) {
        Buffer buffer = new Buffer();
        this.f59632a = buffer;
        mo180112a(buffer, j);
    }

    public long contentLength() throws IOException {
        return this.f59633b;
    }

    /* renamed from: a */
    public Request mo180110a(Request request) throws IOException {
        if (request.header(HttpHeaders.CONTENT_LENGTH) != null) {
            return request;
        }
        mo180111a().close();
        this.f59633b = this.f59632a.size();
        return request.newBuilder().removeHeader(HttpHeaders.TRANSFER_ENCODING).header(HttpHeaders.CONTENT_LENGTH, Long.toString(this.f59632a.size())).build();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        this.f59632a.copyTo(bufferedSink.buffer(), 0, this.f59632a.size());
    }
}
