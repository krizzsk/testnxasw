package okhttp3;

import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okio.Buffer;
import okio.BufferedSource;

public final class Response implements Closeable {

    /* renamed from: a */
    final Request f7095a;

    /* renamed from: b */
    final Protocol f7096b;

    /* renamed from: c */
    final int f7097c;

    /* renamed from: d */
    final String f7098d;
    @Nullable

    /* renamed from: e */
    final Handshake f7099e;

    /* renamed from: f */
    final Headers f7100f;
    @Nullable

    /* renamed from: g */
    final ResponseBody f7101g;
    @Nullable

    /* renamed from: h */
    final Response f7102h;
    @Nullable

    /* renamed from: i */
    final Response f7103i;
    @Nullable

    /* renamed from: j */
    final Response f7104j;

    /* renamed from: k */
    final long f7105k;

    /* renamed from: l */
    final long f7106l;
    @Nullable

    /* renamed from: m */
    private volatile CacheControl f7107m;

    Response(Builder builder) {
        this.f7095a = builder.request;
        this.f7096b = builder.protocol;
        this.f7097c = builder.code;
        this.f7098d = builder.message;
        this.f7099e = builder.handshake;
        this.f7100f = builder.headers.build();
        this.f7101g = builder.body;
        this.f7102h = builder.networkResponse;
        this.f7103i = builder.cacheResponse;
        this.f7104j = builder.priorResponse;
        this.f7105k = builder.sentRequestAtMillis;
        this.f7106l = builder.receivedResponseAtMillis;
    }

    public Request request() {
        return this.f7095a;
    }

    public Protocol protocol() {
        return this.f7096b;
    }

    public int code() {
        return this.f7097c;
    }

    public boolean isSuccessful() {
        int i = this.f7097c;
        return i >= 200 && i < 300;
    }

    public String message() {
        return this.f7098d;
    }

    @Nullable
    public Handshake handshake() {
        return this.f7099e;
    }

    public List<String> headers(String str) {
        return this.f7100f.values(str);
    }

    @Nullable
    public String header(String str) {
        return header(str, (String) null);
    }

    @Nullable
    public String header(String str, @Nullable String str2) {
        String str3 = this.f7100f.get(str);
        return str3 != null ? str3 : str2;
    }

    public Headers headers() {
        return this.f7100f;
    }

    public ResponseBody peekBody(long j) throws IOException {
        BufferedSource source = this.f7101g.source();
        source.request(j);
        Buffer clone = source.buffer().clone();
        if (clone.size() > j) {
            Buffer buffer = new Buffer();
            buffer.write(clone, j);
            clone.clear();
            clone = buffer;
        }
        return ResponseBody.create(this.f7101g.contentType(), clone.size(), clone);
    }

    @Nullable
    public ResponseBody body() {
        return this.f7101g;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public boolean isRedirect() {
        int i = this.f7097c;
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    @Nullable
    public Response networkResponse() {
        return this.f7102h;
    }

    @Nullable
    public Response cacheResponse() {
        return this.f7103i;
    }

    @Nullable
    public Response priorResponse() {
        return this.f7104j;
    }

    public List<Challenge> challenges() {
        String str;
        int i = this.f7097c;
        if (i == 401) {
            str = HttpHeaders.WWW_AUTHENTICATE;
        } else if (i != 407) {
            return Collections.emptyList();
        } else {
            str = HttpHeaders.PROXY_AUTHENTICATE;
        }
        return okhttp3.internal.http.HttpHeaders.parseChallenges(headers(), str);
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f7107m;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f7100f);
        this.f7107m = parse;
        return parse;
    }

    public long sentRequestAtMillis() {
        return this.f7105k;
    }

    public long receivedResponseAtMillis() {
        return this.f7106l;
    }

    public void close() {
        ResponseBody responseBody = this.f7101g;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public String toString() {
        return "Response{protocol=" + this.f7096b + ", code=" + this.f7097c + ", message=" + this.f7098d + ", url=" + this.f7095a.url() + '}';
    }

    public static class Builder {
        @Nullable
        ResponseBody body;
        @Nullable
        Response cacheResponse;
        int code;
        @Nullable
        Handshake handshake;
        Headers.Builder headers;
        String message;
        @Nullable
        Response networkResponse;
        @Nullable
        Response priorResponse;
        @Nullable
        Protocol protocol;
        long receivedResponseAtMillis;
        @Nullable
        Request request;
        long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        Builder(Response response) {
            this.code = -1;
            this.request = response.f7095a;
            this.protocol = response.f7096b;
            this.code = response.f7097c;
            this.message = response.f7098d;
            this.handshake = response.f7099e;
            this.headers = response.f7100f.newBuilder();
            this.body = response.f7101g;
            this.networkResponse = response.f7102h;
            this.cacheResponse = response.f7103i;
            this.priorResponse = response.f7104j;
            this.sentRequestAtMillis = response.f7105k;
            this.receivedResponseAtMillis = response.f7106l;
        }

        public Builder request(Request request2) {
            this.request = request2;
            return this;
        }

        public Builder protocol(Protocol protocol2) {
            this.protocol = protocol2;
            return this;
        }

        public Builder code(int i) {
            this.code = i;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder handshake(@Nullable Handshake handshake2) {
            this.handshake = handshake2;
            return this;
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder headers(Headers headers2) {
            this.headers = headers2.newBuilder();
            return this;
        }

        public Builder body(@Nullable ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Builder networkResponse(@Nullable Response response) {
            if (response != null) {
                checkSupportResponse("networkResponse", response);
            }
            this.networkResponse = response;
            return this;
        }

        public Builder cacheResponse(@Nullable Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.cacheResponse = response;
            return this;
        }

        private void checkSupportResponse(String str, Response response) {
            if (response.f7101g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (response.f7102h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (response.f7103i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (response.f7104j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public Builder priorResponse(@Nullable Response response) {
            if (response != null) {
                checkPriorResponse(response);
            }
            this.priorResponse = response;
            return this;
        }

        private void checkPriorResponse(Response response) {
            if (response.f7101g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public Builder sentRequestAtMillis(long j) {
            this.sentRequestAtMillis = j;
            return this;
        }

        public Builder receivedResponseAtMillis(long j) {
            this.receivedResponseAtMillis = j;
            return this;
        }

        public Response build() {
            if (this.request == null) {
                throw new IllegalStateException("request == null");
            } else if (this.protocol == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.code < 0) {
                throw new IllegalStateException("code < 0: " + this.code);
            } else if (this.message != null) {
                return new Response(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }
    }
}
