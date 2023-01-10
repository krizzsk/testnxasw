package okhttp3;

import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.AsyncHttpDelete;
import com.koushikdutta.async.http.AsyncHttpHead;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.C3000Util;
import okhttp3.internal.http.HttpMethod;

public final class Request {

    /* renamed from: a */
    final HttpUrl f7089a;

    /* renamed from: b */
    final String f7090b;

    /* renamed from: c */
    final Headers f7091c;
    @Nullable

    /* renamed from: d */
    final RequestBody f7092d;

    /* renamed from: e */
    final Map<Class<?>, Object> f7093e;
    @Nullable

    /* renamed from: f */
    private volatile CacheControl f7094f;

    Request(Builder builder) {
        this.f7089a = builder.url;
        this.f7090b = builder.method;
        this.f7091c = builder.headers.build();
        this.f7092d = builder.body;
        this.f7093e = C3000Util.immutableMap(builder.tags);
    }

    public HttpUrl url() {
        return this.f7089a;
    }

    public String method() {
        return this.f7090b;
    }

    public Headers headers() {
        return this.f7091c;
    }

    @Nullable
    public String header(String str) {
        return this.f7091c.get(str);
    }

    public List<String> headers(String str) {
        return this.f7091c.values(str);
    }

    @Nullable
    public RequestBody body() {
        return this.f7092d;
    }

    @Nullable
    public Object tag() {
        return tag(Object.class);
    }

    @Nullable
    public <T> T tag(Class<? extends T> cls) {
        return cls.cast(this.f7093e.get(cls));
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f7094f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f7091c);
        this.f7094f = parse;
        return parse;
    }

    public boolean isHttps() {
        return this.f7089a.isHttps();
    }

    public String toString() {
        return "Request{method=" + this.f7090b + ", url=" + this.f7089a + ", tags=" + this.f7093e + '}';
    }

    public static class Builder {
        @Nullable
        RequestBody body;
        Headers.Builder headers;
        String method;
        Map<Class<?>, Object> tags;
        @Nullable
        HttpUrl url;

        public Builder() {
            this.tags = Collections.emptyMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        Builder(Request request) {
            Map<Class<?>, Object> map;
            this.tags = Collections.emptyMap();
            this.url = request.f7089a;
            this.method = request.f7090b;
            this.body = request.f7092d;
            if (request.f7093e.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = new LinkedHashMap<>(request.f7093e);
            }
            this.tags = map;
            this.headers = request.f7091c.newBuilder();
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.url = httpUrl;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public Builder url(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                return url(HttpUrl.get(str));
            }
            throw new NullPointerException("url == null");
        }

        public Builder url(URL url2) {
            if (url2 != null) {
                return url(HttpUrl.get(url2.toString()));
            }
            throw new NullPointerException("url == null");
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

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            if (cacheControl2.isEmpty()) {
                return removeHeader(HttpHeaders.CACHE_CONTROL);
            }
            return header(HttpHeaders.CACHE_CONTROL, cacheControl2);
        }

        public Builder get() {
            return method("GET", (RequestBody) null);
        }

        public Builder head() {
            return method(AsyncHttpHead.METHOD, (RequestBody) null);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder delete(@Nullable RequestBody requestBody) {
            return method(AsyncHttpDelete.METHOD, requestBody);
        }

        public Builder delete() {
            return delete(C3000Util.EMPTY_REQUEST);
        }

        public Builder put(RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder method(String str, @Nullable RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (requestBody != null || !HttpMethod.requiresRequestBody(str)) {
                this.method = str;
                this.body = requestBody;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public Builder tag(@Nullable Object obj) {
            return tag(Object.class, obj);
        }

        public <T> Builder tag(Class<? super T> cls, @Nullable T t) {
            if (cls != null) {
                if (t == null) {
                    this.tags.remove(cls);
                } else {
                    if (this.tags.isEmpty()) {
                        this.tags = new LinkedHashMap();
                    }
                    this.tags.put(cls, cls.cast(t));
                }
                return this;
            }
            throw new NullPointerException("type == null");
        }

        public Request build() {
            if (this.url != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }
    }
}
