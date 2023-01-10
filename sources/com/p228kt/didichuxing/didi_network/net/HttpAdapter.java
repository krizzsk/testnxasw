package com.p228kt.didichuxing.didi_network.net;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.rpc.http.FormSerializer;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.ByteArrayDeserializer;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.Rpc;
import com.didichuxing.foundation.rpc.RpcClient;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.util.TypeResolver;
import com.p228kt.didichuxing.didi_network.DidiNetworkPlugin;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;
import okio.Buffer;

/* renamed from: com.kt.didichuxing.didi_network.net.HttpAdapter */
public class HttpAdapter {

    /* renamed from: b */
    private static final HttpAdapter f58323b = new HttpAdapter();

    /* renamed from: a */
    final RpcClient<HttpRpcRequest, HttpRpcResponse> f58324a = new RpcServiceFactory(DidiNetworkPlugin.mContext).getRpcClient("http");

    public boolean cancel(Object obj) {
        return false;
    }

    public boolean cancelAll() {
        return false;
    }

    private HttpAdapter() {
    }

    public static HttpAdapter getInstance() {
        return f58323b;
    }

    public <T> Object sendRequest(NetParam netParam, ResponseListener<T> responseListener) {
        if (netParam == null) {
            return null;
        }
        RpcClient.Builder<HttpRpcRequest, HttpRpcResponse> newBuilder = this.f58324a.newBuilder();
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        m44208a(netParam, builder);
        HttpRpcRequest build = builder.build();
        newBuilder.build().newRpc(build).enqueue(m44205a(netParam, responseListener));
        return build.getTag();
    }

    /* renamed from: a */
    private <T> Rpc.Callback<HttpRpcRequest, HttpRpcResponse> m44205a(final NetParam netParam, final ResponseListener<T> responseListener) {
        return new Rpc.Callback<HttpRpcRequest, HttpRpcResponse>() {
            public void onSuccess(HttpRpcResponse httpRpcResponse) {
                HttpAdapter.this.m44209a(responseListener, httpRpcResponse, netParam);
            }

            public void onFailure(HttpRpcRequest httpRpcRequest, IOException iOException) {
                ResponseListener responseListener = responseListener;
                if (responseListener != null) {
                    responseListener.onReceiveError("Connection error");
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public <T> void m44209a(ResponseListener<T> responseListener, HttpRpcResponse httpRpcResponse, NetParam netParam) {
        Object obj;
        if (responseListener != null) {
            Type genericTypeParameter = TypeResolver.getGenericTypeParameter((Object) responseListener);
            Class<?> rawType = TypeResolver.getRawType(genericTypeParameter);
            try {
                if (rawType.isArray() && Byte.TYPE.equals(rawType.getComponentType())) {
                    obj = new ByteArrayDeserializer().deserialize(httpRpcResponse.getEntity().getContent());
                } else if (rawType.isAssignableFrom(String.class)) {
                    obj = new StringDeserializer().deserialize(httpRpcResponse.getEntity().getContent());
                } else {
                    Buffer buffer = new Buffer();
                    buffer.readFrom(httpRpcResponse.getEntity().getContent());
                    buffer.request(Long.MAX_VALUE);
                    obj = new GsonDeserializer<T>(genericTypeParameter) {
                    }.deserialize(buffer.clone().inputStream());
                    new StringDeserializer().deserialize(buffer.inputStream());
                    buffer.close();
                }
                m44210a(responseListener, netParam, obj);
            } catch (Exception e) {
                e.printStackTrace();
                if (responseListener != null) {
                    responseListener.onReceiveError("Exception ： data error");
                }
            }
        }
    }

    /* renamed from: a */
    private <T> void m44210a(ResponseListener<T> responseListener, NetParam netParam, Object obj) {
        if (responseListener != null) {
            if (responseListener != null) {
                responseListener.onReceiveResponse(obj);
                return;
            }
            throw new IllegalArgumentException("NResponseListener<Object> tempCallback param is not null");
        }
    }

    /* renamed from: a */
    private void m44208a(NetParam netParam, HttpRpcRequest.Builder builder) {
        m44212b(netParam);
        m44213b(netParam, builder);
        m44214c(netParam, builder);
    }

    /* renamed from: b */
    private void m44213b(NetParam netParam, HttpRpcRequest.Builder builder) {
        if (netParam.mHeadParams != null && !netParam.mHeadParams.isEmpty()) {
            for (Map.Entry next : netParam.mHeadParams.entrySet()) {
                builder.addHeader((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    /* renamed from: com.kt.didichuxing.didi_network.net.HttpAdapter$4 */
    static /* synthetic */ class C212624 {
        static final /* synthetic */ int[] $SwitchMap$com$kt$didichuxing$didi_network$net$RequestType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.kt.didichuxing.didi_network.net.RequestType[] r0 = com.p228kt.didichuxing.didi_network.net.RequestType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$kt$didichuxing$didi_network$net$RequestType = r0
                com.kt.didichuxing.didi_network.net.RequestType r1 = com.p228kt.didichuxing.didi_network.net.RequestType.REQUEST_TYPE_GET     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$kt$didichuxing$didi_network$net$RequestType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.kt.didichuxing.didi_network.net.RequestType r1 = com.p228kt.didichuxing.didi_network.net.RequestType.REQUEST_TYPE_POST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p228kt.didichuxing.didi_network.net.HttpAdapter.C212624.<clinit>():void");
        }
    }

    /* renamed from: c */
    private void m44214c(NetParam netParam, HttpRpcRequest.Builder builder) {
        int i = C212624.$SwitchMap$com$kt$didichuxing$didi_network$net$RequestType[netParam.getRequestType().ordinal()];
        if (i == 1) {
            builder.get(m44206a(netParam));
        } else if (i == 2) {
            if (!(netParam.mPostGetParams == null || netParam.mPostGetParams.size() == 0)) {
                builder.post(netParam.mUrl + m44211b(netParam.mPostGetParams), m44204a(netParam.mQueryParams));
            }
            builder.post(netParam.mUrl, m44204a(netParam.mQueryParams));
        }
    }

    /* renamed from: a */
    private HttpBody m44204a(final Map<String, Object> map) {
        final FormSerializer formSerializer = new FormSerializer();
        return new HttpBody() {
            public void close() throws IOException {
            }

            public MimeType getContentType() {
                return MimeType.parse("application/x-www-form-urlencoded");
            }

            public InputStream getContent() throws IOException {
                return formSerializer.serialize(map);
            }
        };
    }

    /* renamed from: a */
    private String m44206a(NetParam netParam) {
        if (netParam == null) {
            return null;
        }
        String str = netParam.mUrl;
        if (TextUtils.isEmpty(str)) {
            new Throwable("Request Url is not null");
        }
        String b = m44211b(netParam.mQueryParams);
        if (TextUtils.isEmpty(b)) {
            return str;
        }
        return str + "?" + b;
    }

    /* renamed from: b */
    private String m44211b(Map<String, Object> map) {
        if (map == null || map.size() < 1) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String next : map.keySet()) {
            stringBuffer.append(next);
            stringBuffer.append("=");
            stringBuffer.append(map.get(next));
            stringBuffer.append(ParamKeys.SIGN_AND);
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.substring(0, stringBuffer2.length() - 1);
    }

    /* renamed from: b */
    private void m44212b(NetParam netParam) {
        if (netParam != null) {
            SystemUtils.log(6, " didiNetWork ", "request type = " + netParam.mRequestType + " URL= " + netParam.mUrl + "\nparams = " + netParam.mQueryParams, (Throwable) null, "com.kt.didichuxing.didi_network.net.HttpAdapter", 278);
        }
    }
}
