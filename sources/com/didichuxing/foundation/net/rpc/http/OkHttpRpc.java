package com.didichuxing.foundation.net.rpc.http;

import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.http.SimpleHttpHeader;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.Rpc;
import com.didichuxing.foundation.rpc.RpcClient;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.rpc.RpcProtocol;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponse;
import didihttp.Call;
import didihttp.Callback;
import didihttp.Headers;
import didihttp.Interceptor;
import didihttp.MediaType;
import didihttp.Protocol;
import didihttp.Request;
import didihttp.RequestBody;
import didihttp.Response;
import didihttp.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

class OkHttpRpc implements HttpRpc {

    /* renamed from: a */
    private final OkHttpRpcClient f50171a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final HttpRpcRequest f50172b;

    public OkHttpRpc(OkHttpRpcClient okHttpRpcClient, HttpRpcRequest httpRpcRequest) {
        this.f50171a = okHttpRpcClient;
        this.f50172b = httpRpcRequest;
    }

    public HttpRpcRequest getRequest() {
        return this.f50172b;
    }

    public Object getTag() {
        return this.f50172b.getTag();
    }

    public void cancel() {
        this.f50171a.cancel(getTag());
    }

    public RpcClient<HttpRpcRequest, HttpRpcResponse> getClient() {
        return this.f50171a;
    }

    /* renamed from: a */
    public HttpRpcResponse execute() throws IOException {
        return m37522a(this.f50172b, this.f50171a.mDelegate.newCall(m37524a(this.f50172b)).execute());
    }

    public Object enqueue(Rpc.Callback<HttpRpcRequest, HttpRpcResponse> callback) {
        return m37526a(callback);
    }

    public Object enqueue(HttpRpc.Callback callback) {
        return m37526a((Rpc.Callback<HttpRpcRequest, HttpRpcResponse>) callback);
    }

    /* renamed from: a */
    private synchronized Object m37526a(final Rpc.Callback<HttpRpcRequest, HttpRpcResponse> callback) {
        this.f50171a.mDelegate.newCall(m37524a(this.f50172b)).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                Rpc.Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(OkHttpRpc.this.f50172b, iOException);
                }
            }

            public void onResponse(Call call, Response response) throws IOException {
                try {
                    if (callback != null) {
                        callback.onSuccess(OkHttpRpc.m37522a(OkHttpRpc.this.f50172b, response));
                    }
                } catch (IOException e) {
                    callback.onFailure(OkHttpRpc.this.f50172b, e);
                } catch (Throwable th) {
                    response.close();
                    throw th;
                }
                response.close();
            }
        });
        return this.f50172b.getTag();
    }

    /* renamed from: a */
    static HttpRpcResponse m37522a(HttpRpcRequest httpRpcRequest, Response response) throws IOException {
        return new HttpRpcResponse.Builder().setProtocol((RpcProtocol) HttpRpcProtocol.parse(response.protocol().toString())).setStatus(response.code()).setReason(response.message()).addHeaders((Iterable) m37527a(response.headers())).setEntity(m37519a(response)).setRequest(httpRpcRequest).build();
    }

    /* renamed from: a */
    static Response m37525a(HttpRpcResponse httpRpcResponse) throws IOException {
        C163682 r0;
        final HttpEntity entity = httpRpcResponse.getEntity();
        Response.Builder headers = new Response.Builder().request(m37524a(httpRpcResponse.getRequest())).protocol(Protocol.get(httpRpcResponse.getProtocol().toString().toLowerCase())).code(httpRpcResponse.getStatus()).message(httpRpcResponse.getReason()).headers(m37523a(httpRpcResponse.getHeaders()));
        if (entity == null) {
            r0 = null;
        } else {
            r0 = new ResponseBody() {
                final long mContentLength = HttpEntity.this.getContentLength();
                final MediaType mContentType = MediaType.parse(String.valueOf(HttpEntity.this.getContentType()));
                final BufferedSource mSource = Okio.buffer(Okio.source(HttpEntity.this.getContent()));

                public BufferedSource source() {
                    return this.mSource;
                }

                public MediaType contentType() {
                    return this.mContentType;
                }

                public long contentLength() {
                    return this.mContentLength;
                }
            };
        }
        return headers.body(r0).build();
    }

    /* renamed from: a */
    static HttpEntity m37519a(Response response) throws IOException {
        final ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        final MimeType parse = MimeType.parse(String.valueOf(body.contentType()));
        return new HttpBody() {
            public MimeType getContentType() {
                return MimeType.this;
            }

            public InputStream getContent() throws IOException {
                return body.byteStream();
            }

            public long getContentLength() throws IOException {
                return body.contentLength();
            }

            public void close() throws IOException {
                body.close();
            }
        };
    }

    /* renamed from: a */
    static List<HttpHeader> m37527a(Headers headers) {
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new SimpleHttpHeader(headers.name(i), headers.value(i)));
        }
        return arrayList;
    }

    /* renamed from: a */
    static Headers m37523a(List<HttpHeader> list) {
        Headers.Builder builder = new Headers.Builder();
        for (HttpHeader next : list) {
            builder.add(next.getName(), next.getValue());
        }
        return builder.build();
    }

    /* renamed from: a */
    static Request m37524a(HttpRpcRequest httpRpcRequest) {
        return new Request.Builder().url(httpRpcRequest.getUrl()).headers(m37523a(httpRpcRequest.getHeaders())).method(httpRpcRequest.getMethod().name(), m37528b(httpRpcRequest)).tag(httpRpcRequest.getTag()).build();
    }

    /* renamed from: a */
    static HttpRpcRequest m37521a(RpcClient<?, ?> rpcClient, Request request) throws IOException {
        return new HttpRpcRequest.Builder().setProtocol((RpcProtocol) HttpRpcProtocol.HTTP_1_1).setUrl(request.url().toString()).addHeaders((Iterable) m37527a(request.headers())).setMethod(HttpMethod.valueOf(request.method()), m37518a(request)).setRpcClient((RpcClient<? extends RpcRequest, ? extends RpcResponse>) rpcClient).setTag(request.tag()).build();
    }

    /* renamed from: a */
    private static HttpEntity m37518a(final Request request) throws IOException {
        final RequestBody body = request.body();
        if (body == null) {
            return null;
        }
        return new HttpBody() {
            final Buffer mBuffer = new Buffer();

            public MimeType getContentType() {
                MediaType contentType = RequestBody.this.contentType();
                if (contentType != null) {
                    return MimeType.parse(contentType.toString());
                }
                if (request.header("Content-Type") != null) {
                    return MimeType.parse(request.header("Content-Type"));
                }
                return null;
            }

            public long getContentLength() throws IOException {
                return RequestBody.this.contentLength();
            }

            public InputStream getContent() throws IOException {
                InputStream inputStream;
                synchronized (this.mBuffer) {
                    this.mBuffer.clear();
                    RequestBody.this.writeTo(this.mBuffer);
                    inputStream = this.mBuffer.inputStream();
                }
                return inputStream;
            }

            public void close() throws IOException {
                synchronized (this.mBuffer) {
                    this.mBuffer.close();
                }
            }
        };
    }

    /* renamed from: b */
    static RequestBody m37528b(HttpRpcRequest httpRpcRequest) {
        final HttpEntity entity = httpRpcRequest.getEntity();
        if (entity == null) {
            return null;
        }
        return new RequestBody() {
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                HttpEntity.this.writeTo(bufferedSink.outputStream());
            }

            public MediaType contentType() {
                MimeType contentType = HttpEntity.this.getContentType();
                if (contentType != null) {
                    return MediaType.parse(contentType.toString());
                }
                return null;
            }

            public long contentLength() throws IOException {
                return HttpEntity.this.getContentLength();
            }
        };
    }

    static final class OkHttpRpcInterceptor implements Interceptor {
        RpcClient<?, ?> mClient;
        final RpcInterceptor<HttpRpcRequest, HttpRpcResponse> mInterceptor;

        public OkHttpRpcInterceptor(RpcInterceptor<HttpRpcRequest, HttpRpcResponse> rpcInterceptor) {
            this.mInterceptor = rpcInterceptor;
        }

        public OkHttpRpcInterceptor(RpcInterceptor<HttpRpcRequest, HttpRpcResponse> rpcInterceptor, RpcClient<?, ?> rpcClient) {
            this(rpcInterceptor);
            this.mClient = rpcClient;
        }

        public Response intercept(final Interceptor.Chain chain) throws IOException {
            final HttpRpcRequest a = OkHttpRpc.m37521a(this.mClient, chain.request());
            return OkHttpRpc.m37525a(this.mInterceptor.intercept(new RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse>() {
                public HttpRpcResponse proceed(HttpRpcRequest httpRpcRequest) throws IOException {
                    return OkHttpRpc.m37522a(httpRpcRequest, chain.proceed(OkHttpRpc.m37524a(httpRpcRequest)));
                }

                public HttpRpcRequest getRequest() {
                    return a;
                }
            }));
        }

        public String toString() {
            RpcInterceptor<HttpRpcRequest, HttpRpcResponse> rpcInterceptor = this.mInterceptor;
            if (rpcInterceptor != null) {
                return rpcInterceptor.getClass().getSimpleName();
            }
            return super.toString();
        }
    }
}
