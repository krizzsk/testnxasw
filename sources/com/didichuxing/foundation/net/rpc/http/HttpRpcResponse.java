package com.didichuxing.foundation.net.rpc.http;

import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.foundation.net.rpc.http.HttpRpcMessage;
import com.didichuxing.foundation.rpc.RpcProtocol;
import com.didichuxing.foundation.rpc.RpcResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public final class HttpRpcResponse extends HttpRpcMessage implements RpcResponse {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final RpcProtocol f50167a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f50168b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f50169c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final HttpRpcRequest f50170d;

    private HttpRpcResponse(Builder builder) {
        super(builder);
        this.f50167a = builder.mProtocol;
        this.f50168b = builder.mStatus;
        this.f50169c = builder.mReason;
        this.f50170d = builder.mRequest;
    }

    public HttpRpcRequest getRequest() {
        return this.f50170d;
    }

    public int getStatus() {
        return this.f50168b;
    }

    public boolean isSuccessful() {
        int i = this.f50168b;
        return i >= 200 && i < 300;
    }

    public String getReason() {
        return this.f50169c;
    }

    public String getUrl() {
        return this.f50170d.getUrl();
    }

    public <T> T getContent() throws IOException {
        HttpEntity entity = getEntity();
        if (entity == null) {
            return null;
        }
        try {
            return mo123787a().deserialize(entity.getContent());
        } finally {
            entity.close();
        }
    }

    public HttpRpcClient getRpcClient() {
        return this.f50170d.getRpcClient();
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public void close() throws IOException {
        getEntity().close();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0059, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005f, code lost:
        throw new java.lang.IllegalArgumentException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r2 = r0.getConstructor(new java.lang.Class[]{java.lang.reflect.Type.class});
        r2.setAccessible(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0046, code lost:
        return (com.didichuxing.foundation.p188io.Deserializer) r2.newInstance(new java.lang.Object[]{r1});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r0 = r0.getConstructor(new java.lang.Class[0]);
        r0.setAccessible(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0058, code lost:
        return (com.didichuxing.foundation.p188io.Deserializer) r0.newInstance(new java.lang.Object[0]);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x002f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0047 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didichuxing.foundation.p188io.Deserializer<?> mo123787a() {
        /*
            r7 = this;
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r0 = r7.f50170d
            java.lang.Class r0 = r0.mo123759b()
            java.lang.reflect.Type r1 = r7.mo123789c()
            r2 = 2
            r3 = 0
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x002f }
            java.lang.Class<java.lang.reflect.Type> r6 = java.lang.reflect.Type.class
            r5[r3] = r6     // Catch:{ Exception -> 0x002f }
            java.lang.Class<java.util.Map> r6 = java.util.Map.class
            r5[r4] = r6     // Catch:{ Exception -> 0x002f }
            java.lang.reflect.Constructor r5 = r0.getConstructor(r5)     // Catch:{ Exception -> 0x002f }
            r5.setAccessible(r4)     // Catch:{ Exception -> 0x002f }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x002f }
            r2[r3] = r1     // Catch:{ Exception -> 0x002f }
            java.util.Map r6 = r7.mo123788b()     // Catch:{ Exception -> 0x002f }
            r2[r4] = r6     // Catch:{ Exception -> 0x002f }
            java.lang.Object r2 = r5.newInstance(r2)     // Catch:{ Exception -> 0x002f }
            com.didichuxing.foundation.io.Deserializer r2 = (com.didichuxing.foundation.p188io.Deserializer) r2     // Catch:{ Exception -> 0x002f }
            return r2
        L_0x002f:
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0047 }
            java.lang.Class<java.lang.reflect.Type> r5 = java.lang.reflect.Type.class
            r2[r3] = r5     // Catch:{ Exception -> 0x0047 }
            java.lang.reflect.Constructor r2 = r0.getConstructor(r2)     // Catch:{ Exception -> 0x0047 }
            r2.setAccessible(r4)     // Catch:{ Exception -> 0x0047 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0047 }
            r5[r3] = r1     // Catch:{ Exception -> 0x0047 }
            java.lang.Object r1 = r2.newInstance(r5)     // Catch:{ Exception -> 0x0047 }
            com.didichuxing.foundation.io.Deserializer r1 = (com.didichuxing.foundation.p188io.Deserializer) r1     // Catch:{ Exception -> 0x0047 }
            return r1
        L_0x0047:
            java.lang.Class[] r1 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0059 }
            java.lang.reflect.Constructor r0 = r0.getConstructor(r1)     // Catch:{ Exception -> 0x0059 }
            r0.setAccessible(r4)     // Catch:{ Exception -> 0x0059 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0059 }
            java.lang.Object r0 = r0.newInstance(r1)     // Catch:{ Exception -> 0x0059 }
            com.didichuxing.foundation.io.Deserializer r0 = (com.didichuxing.foundation.p188io.Deserializer) r0     // Catch:{ Exception -> 0x0059 }
            return r0
        L_0x0059:
            r0 = move-exception
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.foundation.net.rpc.http.HttpRpcResponse.mo123787a():com.didichuxing.foundation.io.Deserializer");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Map<String, String> mo123788b() {
        HashMap hashMap = new HashMap();
        for (HttpHeader next : getHeaders()) {
            String name = next.getName();
            if (hashMap.containsKey(name)) {
                hashMap.put(name, ((String) hashMap.get(name)) + "; " + next.getValue());
            } else {
                hashMap.put(name, next.getValue());
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Type mo123789c() {
        return this.f50170d.mo123760c();
    }

    public static final class Builder extends HttpRpcMessage.Builder<HttpRpcResponse> implements RpcResponse.Builder {
        /* access modifiers changed from: private */
        public RpcProtocol mProtocol;
        /* access modifiers changed from: private */
        public String mReason;
        /* access modifiers changed from: private */
        public HttpRpcRequest mRequest;
        /* access modifiers changed from: private */
        public int mStatus;

        public Builder() {
        }

        private Builder(HttpRpcResponse httpRpcResponse) {
            this.mProtocol = httpRpcResponse.f50167a;
            this.mStatus = httpRpcResponse.f50168b;
            this.mReason = httpRpcResponse.f50169c;
            this.mHeaders.addAll(httpRpcResponse.mHeaders);
            this.mEntity = httpRpcResponse.mEntity;
            this.mRequest = httpRpcResponse.f50170d;
        }

        public Builder addHeaders(Iterable<HttpHeader> iterable) {
            super.addHeaders(iterable);
            return this;
        }

        public Builder addHeaders(HttpHeader... httpHeaderArr) {
            super.addHeaders(httpHeaderArr);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            super.addHeader(str, str2);
            return this;
        }

        public Builder setEntity(HttpEntity httpEntity) {
            super.setEntity(httpEntity);
            return this;
        }

        public Builder setRequest(HttpRpcRequest httpRpcRequest) {
            this.mRequest = httpRpcRequest;
            return this;
        }

        public Builder setProtocol(RpcProtocol rpcProtocol) {
            this.mProtocol = rpcProtocol;
            return this;
        }

        public Builder setStatus(int i) {
            this.mStatus = i;
            return this;
        }

        public Builder setReason(String str) {
            this.mReason = str;
            return this;
        }

        public HttpRpcResponse build() {
            return new HttpRpcResponse(this);
        }
    }
}
