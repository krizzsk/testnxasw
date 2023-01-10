package didihttp.internal.huc;

import didihttp.internal.http.UnrepeatableRequestBody;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Pipe;

/* renamed from: didihttp.internal.huc.d */
/* compiled from: StreamedRequestBody */
final class C21781d extends C21780c implements UnrepeatableRequestBody {

    /* renamed from: a */
    private final Pipe f59639a;

    C21781d(long j) {
        Pipe pipe = new Pipe(8192);
        this.f59639a = pipe;
        mo180112a(Okio.buffer(pipe.sink()), j);
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Buffer buffer = new Buffer();
        while (this.f59639a.source().read(buffer, 8192) != -1) {
            bufferedSink.write(buffer, buffer.size());
        }
    }
}
