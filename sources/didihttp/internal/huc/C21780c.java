package didihttp.internal.huc;

import didihttp.MediaType;
import didihttp.Request;
import didihttp.RequestBody;
import java.io.IOException;
import java.io.OutputStream;
import okio.BufferedSink;
import okio.Timeout;

/* renamed from: didihttp.internal.huc.c */
/* compiled from: OutputStreamRequestBody */
abstract class C21780c extends RequestBody {

    /* renamed from: a */
    private Timeout f59635a;

    /* renamed from: b */
    private long f59636b;

    /* renamed from: c */
    boolean f59637c;

    /* renamed from: d */
    private OutputStream f59638d;

    /* renamed from: a */
    public Request mo180110a(Request request) throws IOException {
        return request;
    }

    public final MediaType contentType() {
        return null;
    }

    C21780c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo180112a(BufferedSink bufferedSink, long j) {
        this.f59635a = bufferedSink.timeout();
        this.f59636b = j;
        this.f59638d = new OutputStreamRequestBody$1(this, j, bufferedSink);
    }

    /* renamed from: a */
    public final OutputStream mo180111a() {
        return this.f59638d;
    }

    /* renamed from: b */
    public final Timeout mo180113b() {
        return this.f59635a;
    }

    /* renamed from: c */
    public final boolean mo180114c() {
        return this.f59637c;
    }

    public long contentLength() throws IOException {
        return this.f59636b;
    }
}
