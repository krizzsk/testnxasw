package didihttp.internal.http2;

import com.google.common.net.HttpHeaders;
import didihttp.DidiHttpClient;
import didihttp.Headers;
import didihttp.Protocol;
import didihttp.Request;
import didihttp.Response;
import didihttp.ResponseBody;
import didihttp.internal.C21750Util;
import didihttp.internal.Internal;
import didihttp.internal.connection.StreamAllocation;
import didihttp.internal.http.HttpCodec;
import didihttp.internal.http.RealResponseBody;
import didihttp.internal.http.RequestLine;
import didihttp.internal.http.StatusLine;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Http2Codec implements HttpCodec {

    /* renamed from: b */
    private static final ByteString f59534b = ByteString.encodeUtf8("connection");

    /* renamed from: c */
    private static final ByteString f59535c = ByteString.encodeUtf8("host");

    /* renamed from: d */
    private static final ByteString f59536d = ByteString.encodeUtf8("keep-alive");

    /* renamed from: e */
    private static final ByteString f59537e = ByteString.encodeUtf8("proxy-connection");

    /* renamed from: f */
    private static final ByteString f59538f = ByteString.encodeUtf8("transfer-encoding");

    /* renamed from: g */
    private static final ByteString f59539g = ByteString.encodeUtf8("te");

    /* renamed from: h */
    private static final ByteString f59540h = ByteString.encodeUtf8("encoding");

    /* renamed from: i */
    private static final ByteString f59541i;

    /* renamed from: j */
    private static final List<ByteString> f59542j;

    /* renamed from: k */
    private static final List<ByteString> f59543k = C21750Util.immutableList((T[]) new ByteString[]{f59534b, f59535c, f59536d, f59537e, f59539g, f59538f, f59540h, f59541i});

    /* renamed from: a */
    final StreamAllocation f59544a;

    /* renamed from: l */
    private final DidiHttpClient f59545l;

    /* renamed from: m */
    private final Http2Connection f59546m;

    /* renamed from: n */
    private Http2Stream f59547n;

    /* renamed from: o */
    private int f59548o;

    /* renamed from: p */
    private int f59549p;

    static {
        ByteString encodeUtf8 = ByteString.encodeUtf8("upgrade");
        f59541i = encodeUtf8;
        f59542j = C21750Util.immutableList((T[]) new ByteString[]{f59534b, f59535c, f59536d, f59537e, f59539g, f59538f, f59540h, encodeUtf8, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY});
    }

    public Http2Codec(DidiHttpClient didiHttpClient, StreamAllocation streamAllocation, Http2Connection http2Connection, int i, int i2) {
        this.f59545l = didiHttpClient;
        this.f59544a = streamAllocation;
        this.f59546m = http2Connection;
        this.f59548o = i;
        this.f59549p = i2;
    }

    public Sink createRequestBody(Request request, long j) {
        return this.f59547n.getSink();
    }

    public void writeRequestHeaders(Request request) throws IOException {
        if (this.f59547n == null) {
            Http2Stream newStream = this.f59546m.newStream(http2HeadersList(request), request.body() != null);
            this.f59547n = newStream;
            newStream.readTimeout().timeout((long) this.f59548o, TimeUnit.MILLISECONDS);
            this.f59547n.writeTimeout().timeout((long) this.f59549p, TimeUnit.MILLISECONDS);
        }
    }

    public void flushRequest() throws IOException {
        this.f59546m.flush();
    }

    public void finishRequest() throws IOException {
        this.f59547n.getSink().close();
    }

    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.f59547n.takeResponseHeaders());
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
            if (!f59542j.contains(encodeUtf8)) {
                arrayList.add(new Header(encodeUtf8, headers.value(i)));
            }
        }
        return arrayList;
    }

    public static Response.Builder readHttp2HeadersList(List<Header> list) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        StatusLine statusLine = null;
        for (int i = 0; i < size; i++) {
            Header header = list.get(i);
            if (header != null) {
                ByteString byteString = header.name;
                String utf8 = header.value.utf8();
                if (byteString.equals(Header.RESPONSE_STATUS)) {
                    statusLine = StatusLine.parse("HTTP/1.1 " + utf8);
                } else if (!f59543k.contains(byteString)) {
                    Internal.instance.addLenient(builder, byteString.utf8(), utf8);
                }
            } else if (statusLine != null && statusLine.code == 100) {
                builder = new Headers.Builder();
                statusLine = null;
            }
        }
        if (statusLine != null) {
            return new Response.Builder().protocol(Protocol.HTTP_2).code(statusLine.code).message(statusLine.message).headers(builder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        return new RealResponseBody(response.headers(), Okio.buffer((Source) new StreamFinishingSource(this.f59547n.getSource())));
    }

    public void cancel() {
        Http2Stream http2Stream = this.f59547n;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    class StreamFinishingSource extends ForwardingSource {
        public StreamFinishingSource(Source source) {
            super(source);
        }

        public void close() throws IOException {
            Http2Codec.this.f59544a.streamFinished(false, Http2Codec.this);
            super.close();
        }
    }
}
