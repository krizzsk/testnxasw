package okhttp3.internal.http2;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.C3000Util;
import okhttp3.internal.Internal;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Http2Codec implements HttpCodec {

    /* renamed from: b */
    private static final String f7279b = "connection";

    /* renamed from: c */
    private static final String f7280c = "host";

    /* renamed from: d */
    private static final String f7281d = "keep-alive";

    /* renamed from: e */
    private static final String f7282e = "proxy-connection";

    /* renamed from: f */
    private static final String f7283f = "transfer-encoding";

    /* renamed from: g */
    private static final String f7284g = "te";

    /* renamed from: h */
    private static final String f7285h = "encoding";

    /* renamed from: i */
    private static final String f7286i = "upgrade";

    /* renamed from: j */
    private static final List<String> f7287j = C3000Util.immutableList((T[]) new String[]{f7279b, "host", f7281d, f7282e, f7284g, f7283f, f7285h, "upgrade", Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8});

    /* renamed from: k */
    private static final List<String> f7288k = C3000Util.immutableList((T[]) new String[]{f7279b, "host", f7281d, f7282e, f7284g, f7283f, f7285h, "upgrade"});

    /* renamed from: a */
    final StreamAllocation f7289a;

    /* renamed from: l */
    private final Interceptor.Chain f7290l;

    /* renamed from: m */
    private final Http2Connection f7291m;

    /* renamed from: n */
    private Http2Stream f7292n;

    /* renamed from: o */
    private final Protocol f7293o;

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        Protocol protocol;
        this.f7290l = chain;
        this.f7289a = streamAllocation;
        this.f7291m = http2Connection;
        if (okHttpClient.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        } else {
            protocol = Protocol.HTTP_2;
        }
        this.f7293o = protocol;
    }

    public Sink createRequestBody(Request request, long j) {
        return this.f7292n.getSink();
    }

    public void writeRequestHeaders(Request request) throws IOException {
        if (this.f7292n == null) {
            Http2Stream newStream = this.f7291m.newStream(http2HeadersList(request), request.body() != null);
            this.f7292n = newStream;
            newStream.readTimeout().timeout((long) this.f7290l.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.f7292n.writeTimeout().timeout((long) this.f7290l.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public void flushRequest() throws IOException {
        this.f7291m.flush();
    }

    public void finishRequest() throws IOException {
        this.f7292n.getSink().close();
    }

    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.f7292n.takeHeaders(), this.f7293o);
        if (!z || Internal.instance.code(readHttp2HeadersList) != 100) {
            return readHttp2HeadersList;
        }
        return null;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        String header = request.header(HttpHeaders.HOST);
        if (header != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!f7287j.contains(encodeUtf8.utf8())) {
                arrayList.add(new Header(encodeUtf8, headers.value(i)));
            }
        }
        return arrayList;
    }

    public static Response.Builder readHttp2HeadersList(Headers headers, Protocol protocol) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        StatusLine statusLine = null;
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if (name.equals(Header.RESPONSE_STATUS_UTF8)) {
                statusLine = StatusLine.parse("HTTP/1.1 " + value);
            } else if (!f7288k.contains(name)) {
                Internal.instance.addLenient(builder, name, value);
            }
        }
        if (statusLine != null) {
            return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        this.f7289a.eventListener.responseBodyStart(this.f7289a.call);
        return new RealResponseBody(response.header("Content-Type"), okhttp3.internal.http.HttpHeaders.contentLength(response), Okio.buffer((Source) new StreamFinishingSource(this.f7292n.getSource())));
    }

    public void cancel() {
        Http2Stream http2Stream = this.f7292n;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    class StreamFinishingSource extends ForwardingSource {
        long bytesRead = 0;
        boolean completed = false;

        StreamFinishingSource(Source source) {
            super(source);
        }

        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = delegate().read(buffer, j);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e) {
                endOfInput(e);
                throw e;
            }
        }

        public void close() throws IOException {
            super.close();
            endOfInput((IOException) null);
        }

        private void endOfInput(IOException iOException) {
            if (!this.completed) {
                this.completed = true;
                Http2Codec.this.f7289a.streamFinished(false, Http2Codec.this, this.bytesRead, iOException);
            }
        }
    }
}
