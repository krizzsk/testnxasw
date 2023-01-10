package didihttp;

import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.AsyncHttpDelete;
import com.koushikdutta.async.http.AsyncHttpHead;
import didihttp.Headers;
import didihttp.internal.C21750Util;
import didihttp.internal.http.HttpMethod;
import java.net.URL;
import java.util.List;

public final class Request {

    /* renamed from: a */
    final HttpUrl f59254a;

    /* renamed from: b */
    final String f59255b;

    /* renamed from: c */
    final Headers f59256c;

    /* renamed from: d */
    final RequestBody f59257d;

    /* renamed from: e */
    final Object f59258e;

    /* renamed from: f */
    private volatile CacheControl f59259f;

    Request(Builder builder) {
        this.f59254a = builder.url;
        this.f59255b = builder.method;
        this.f59256c = builder.headers.build();
        this.f59257d = builder.body;
        this.f59258e = builder.tag != null ? builder.tag : this;
    }

    public HttpUrl url() {
        return this.f59254a;
    }

    public String method() {
        return this.f59255b;
    }

    public Headers headers() {
        return this.f59256c;
    }

    public String header(String str) {
        return this.f59256c.get(str);
    }

    public List<String> headers(String str) {
        return this.f59256c.values(str);
    }

    public RequestBody body() {
        return this.f59257d;
    }

    public Object tag() {
        return this.f59258e;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.f59259f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f59256c);
        this.f59259f = parse;
        return parse;
    }

    public boolean isHttps() {
        return this.f59254a.isHttps();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f59255b);
        sb.append(", url=");
        sb.append(this.f59254a);
        sb.append(", tag=");
        Object obj = this.f59258e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {
        RequestBody body;
        Headers.Builder headers;
        String method;
        Object tag;
        HttpUrl url;

        public Builder() {
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        Builder(Request request) {
            this.url = request.f59254a;
            this.method = request.f59255b;
            this.body = request.f59257d;
            this.tag = request.f59258e;
            this.headers = request.f59256c.newBuilder();
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
                HttpUrl parse = HttpUrl.parse(str);
                if (parse != null) {
                    return url(parse);
                }
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            throw new NullPointerException("url == null");
        }

        public Builder url(URL url2) {
            if (url2 != null) {
                HttpUrl httpUrl = HttpUrl.get(url2);
                if (httpUrl != null) {
                    return url(httpUrl);
                }
                throw new IllegalArgumentException("unexpected url: " + url2);
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

        public Builder delete(RequestBody requestBody) {
            return method(AsyncHttpDelete.METHOD, requestBody);
        }

        public Builder delete() {
            return delete(C21750Util.EMPTY_REQUEST);
        }

        public Builder put(RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder method(String str, RequestBody requestBody) {
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

        public Builder tag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Request build() {
            if (this.url != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }
    }
}
