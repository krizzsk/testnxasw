package didihttp;

import com.google.common.net.HttpHeaders;
import didihttp.Headers;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import okio.Buffer;
import okio.BufferedSource;

public final class Response implements Closeable {

    /* renamed from: a */
    final Request f59260a;

    /* renamed from: b */
    final Protocol f59261b;

    /* renamed from: c */
    final int f59262c;

    /* renamed from: d */
    final String f59263d;

    /* renamed from: e */
    final Handshake f59264e;

    /* renamed from: f */
    final Headers f59265f;

    /* renamed from: g */
    final ResponseBody f59266g;

    /* renamed from: h */
    final Response f59267h;

    /* renamed from: i */
    final Response f59268i;

    /* renamed from: j */
    final Response f59269j;

    /* renamed from: k */
    final long f59270k;

    /* renamed from: l */
    final long f59271l;

    /* renamed from: m */
    private volatile CacheControl f59272m;

    Response(Builder builder) {
        this.f59260a = builder.request;
        this.f59261b = builder.protocol;
        this.f59262c = builder.code;
        this.f59263d = builder.message;
        this.f59264e = builder.handshake;
        this.f59265f = builder.headers.build();
        this.f59266g = builder.body;
        this.f59267h = builder.networkResponse;
        this.f59268i = builder.cacheResponse;
        this.f59269j = builder.priorResponse;
        this.f59270k = builder.sentRequestAtMillis;
        this.f59271l = builder.receivedResponseAtMillis;
    }

    public Request request() {
        return this.f59260a;
    }

    public Protocol protocol() {
        return this.f59261b;
    }

    public int code() {
        return this.f59262c;
    }

    public boolean isSuccessful() {
        int i = this.f59262c;
        return i >= 200 && i < 300;
    }

    public String message() {
        return this.f59263d;
    }

    public Handshake handshake() {
        return this.f59264e;
    }

    public List<String> headers(String str) {
        return this.f59265f.values(str);
    }

    public String header(String str) {
        return header(str, (String) null);
    }

    public String header(String str, String str2) {
        String str3 = this.f59265f.get(str);
        return str3 != null ? str3 : str2;
    }

    public Headers headers() {
        return this.f59265f;
    }

    public ResponseBody peekBody(long j) throws IOException {
        BufferedSource source = this.f59266g.source();
        source.request(j);
        Buffer clone = source.buffer().clone();
        if (clone.size() > j) {
            Buffer buffer = new Buffer();
            buffer.write(clone, j);
            clone.clear();
            clone = buffer;
        }
        return ResponseBody.create(this.f59266g.contentType(), clone.size(), clone);
    }

    public ResponseBody body() {
        return this.f59266g;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public boolean isRedirect() {
        int i = this.f59262c;
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

    public Response networkResponse() {
        return this.f59267h;
    }

    public Response cacheResponse() {
        return this.f59268i;
    }

    public Response priorResponse() {
        return this.f59269j;
    }

    public List<Challenge> challenges() {
        String str;
        int i = this.f59262c;
        if (i == 401) {
            str = HttpHeaders.WWW_AUTHENTICATE;
        } else if (i != 407) {
            return Collections.emptyList();
        } else {
            str = HttpHeaders.PROXY_AUTHENTICATE;
        }
        return didihttp.internal.http.HttpHeaders.parseChallenges(headers(), str);
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f59272m;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f59265f);
        this.f59272m = parse;
        return parse;
    }

    public long sentRequestAtMillis() {
        return this.f59270k;
    }

    public long receivedResponseAtMillis() {
        return this.f59271l;
    }

    public void close() {
        this.f59266g.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f59261b + ", code=" + this.f59262c + ", message=" + this.f59263d + ", url=" + this.f59260a.url() + '}';
    }

    public static class Builder {
        ResponseBody body;
        Response cacheResponse;
        int code;
        Handshake handshake;
        Headers.Builder headers;
        String message;
        Response networkResponse;
        Response priorResponse;
        Protocol protocol;
        long receivedResponseAtMillis;
        Request request;
        long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        Builder(Response response) {
            this.code = -1;
            this.request = response.f59260a;
            this.protocol = response.f59261b;
            this.code = response.f59262c;
            this.message = response.f59263d;
            this.handshake = response.f59264e;
            this.headers = response.f59265f.newBuilder();
            this.body = response.f59266g;
            this.networkResponse = response.f59267h;
            this.cacheResponse = response.f59268i;
            this.priorResponse = response.f59269j;
            this.sentRequestAtMillis = response.f59270k;
            this.receivedResponseAtMillis = response.f59271l;
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

        public Builder handshake(Handshake handshake2) {
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

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Builder networkResponse(Response response) {
            if (response != null) {
                checkSupportResponse("networkResponse", response);
            }
            this.networkResponse = response;
            return this;
        }

        public Builder cacheResponse(Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.cacheResponse = response;
            return this;
        }

        private void checkSupportResponse(String str, Response response) {
            if (response.f59266g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (response.f59267h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (response.f59268i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (response.f59269j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public Builder priorResponse(Response response) {
            if (response != null) {
                checkPriorResponse(response);
            }
            this.priorResponse = response;
            return this;
        }

        private void checkPriorResponse(Response response) {
            if (response.f59266g != null) {
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
            } else if (this.code >= 0) {
                return new Response(this);
            } else {
                throw new IllegalStateException("code < 0: " + this.code);
            }
        }
    }
}
