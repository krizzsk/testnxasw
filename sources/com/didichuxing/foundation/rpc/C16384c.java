package com.didichuxing.foundation.rpc;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.net.DnsResolver;
import com.didichuxing.foundation.net.Transporter;
import com.didichuxing.foundation.net.X509CertificateTransporter;
import com.didichuxing.foundation.p188io.Streams;
import com.didichuxing.foundation.rpc.RpcClient;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.DnsResolution;
import com.didichuxing.foundation.rpc.annotation.InnerRetry;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Retry;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import com.didichuxing.foundation.rpc.annotation.Transportation;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: com.didichuxing.foundation.rpc.c */
/* compiled from: RpcServiceProxy */
class C16384c implements InvocationHandler {

    /* renamed from: h */
    private static final String f50196h = "RpcServiceProxy";

    /* renamed from: i */
    private static final Set<Method> f50197i = Collections.unmodifiableSet(new HashSet(Arrays.asList(Object.class.getMethods())));

    /* renamed from: j */
    private static final Map<String, Transporter> f50198j = new HashMap();

    /* renamed from: a */
    final RpcServiceFactory f50199a;

    /* renamed from: b */
    final Class<? extends RpcService> f50200b;

    /* renamed from: c */
    final Uri f50201c;

    /* renamed from: d */
    final Set<Method> f50202d = Collections.unmodifiableSet(new HashSet(Arrays.asList(this.f50200b.getMethods())));

    /* renamed from: e */
    final Object f50203e;

    /* renamed from: f */
    final Transporter f50204f;

    /* renamed from: g */
    final Handler f50205g;

    C16384c(RpcServiceFactory rpcServiceFactory, Class<? extends RpcService> cls, Uri uri, Object obj) {
        this.f50199a = rpcServiceFactory;
        this.f50200b = cls;
        this.f50201c = uri;
        this.f50203e = obj;
        this.f50204f = m37533a(cls);
        this.f50205g = new Handler(Looper.getMainLooper());
    }

    /* renamed from: a */
    private Transporter m37533a(Class<? extends RpcService> cls) {
        if (!cls.isAnnotationPresent(Transportation.class)) {
            return null;
        }
        try {
            Transportation transportation = (Transportation) cls.getAnnotation(Transportation.class);
            return m37534a(transportation.cert(), (Class<? extends Transporter>[]) transportation.value());
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (this.f50202d.contains(method)) {
            Class[] exceptionTypes = method.getExceptionTypes();
            try {
                return m37538a(obj, method, objArr);
            } catch (RuntimeException e) {
                throw e;
            } catch (Throwable th) {
                int length = exceptionTypes.length;
                int i = 0;
                while (i < length) {
                    if (!exceptionTypes[i].isAssignableFrom(th.getClass())) {
                        i++;
                    } else {
                        throw th;
                    }
                }
                throw new RuntimeException(th);
            }
        } else if (f50197i.contains(method)) {
            return method.invoke(this, objArr);
        } else {
            throw new NoSuchMethodException(method.toGenericString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16384c)) {
            return false;
        }
        C16384c cVar = (C16384c) obj;
        if (!this.f50200b.equals(cVar.f50200b) || !this.f50201c.equals(cVar.f50201c) || !this.f50202d.equals(cVar.f50202d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((16337 + this.f50200b.hashCode()) * 31) + this.f50201c.hashCode()) * 31) + this.f50202d.hashCode();
    }

    public String toString() {
        return "Proxy for " + this.f50200b.getName();
    }

    /* renamed from: a */
    private Object m37538a(Object obj, Method method, Object[] objArr) throws Throwable {
        Object obj2;
        Class<?> returnType = method.getReturnType();
        RpcClient.Builder newBuilder = this.f50199a.getRpcClient(this.f50201c.getScheme()).newBuilder();
        m37544d(method, newBuilder);
        m37543c(method, newBuilder);
        m37542b(method, newBuilder);
        m37541a(method, newBuilder);
        RpcClient build = newBuilder.build();
        Rpc newRpc = build.newRpc(build.newRequestBuilder().setUrl(this.f50201c.toString()).setRpcClient(build).setRpcService(this.f50200b, method, objArr).build());
        if (objArr != null && objArr.length > 0 && ((objArr[objArr.length - 1] instanceof RpcService.Callback) || (objArr[objArr.length - 1] instanceof RpcService.CallbackV2))) {
            RpcService.Callback callback = objArr[objArr.length - 1];
            ThreadType a = m37535a(method, objArr);
            if (callback instanceof RpcService.Callback) {
                obj2 = m37536a((Rpc<RpcRequest, RpcResponse>) newRpc, a, (RpcService.Callback<Object>) callback);
            } else {
                obj2 = m37537a((Rpc<RpcRequest, RpcResponse>) newRpc, a, (RpcService.CallbackV2<Object>) (RpcService.CallbackV2) callback);
            }
            if (Rpc.class.isAssignableFrom(returnType)) {
                return newRpc;
            }
        } else {
            obj2 = newRpc.execute().getContent();
        }
        if (Void.TYPE.equals(returnType) || Void.class.equals(returnType)) {
            return null;
        }
        return obj2;
    }

    /* renamed from: a */
    private Object m37536a(Rpc<RpcRequest, RpcResponse> rpc, ThreadType threadType, RpcService.Callback<Object> callback) {
        return rpc.enqueue(new RpcServiceProxy$1(this, threadType, callback));
    }

    /* renamed from: a */
    private Object m37537a(Rpc<RpcRequest, RpcResponse> rpc, ThreadType threadType, RpcService.CallbackV2<Object> callbackV2) {
        return rpc.enqueue(new RpcServiceProxy$2(this, threadType, callbackV2));
    }

    /* renamed from: a */
    private void m37541a(Method method, RpcClient.Builder builder) throws Throwable {
        Transportation transportation = (Transportation) method.getAnnotation(Transportation.class);
        Transporter a = transportation != null ? m37534a(transportation.cert().trim(), (Class<? extends Transporter>[]) transportation.value()) : this.f50204f;
        if (a != null) {
            SocketFactory socketFactory = a.getSocketFactory();
            if (socketFactory != null) {
                builder.setSocketFactory(socketFactory);
            }
            SSLSocketFactory sslSocketFactory = a.getSslSocketFactory();
            TrustManager trustManager = a.getTrustManager();
            if (!(sslSocketFactory == null || trustManager == null)) {
                builder.setSSLSocketFactory(sslSocketFactory, trustManager);
            }
            HostnameVerifier hostnameVerifier = a.getHostnameVerifier();
            if (hostnameVerifier != null) {
                builder.setHostnameVerifier(hostnameVerifier);
            }
        }
    }

    /* renamed from: a */
    private Transporter m37534a(String str, Class<? extends Transporter>[] clsArr) throws KeyManagementException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if ("file".equals(scheme) || "content".equals(scheme) || UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
                InputStream openInputStream = this.f50199a.getContext().getContentResolver().openInputStream(parse);
                try {
                    return new X509CertificateTransporter(openInputStream);
                } finally {
                    Streams.closeQuietly(openInputStream);
                }
            } else if (!str.startsWith("asset://")) {
                return new X509CertificateTransporter(str.getBytes());
            } else {
                InputStream open = this.f50199a.getContext().getResources().getAssets().open(str.substring(8));
                try {
                    return new X509CertificateTransporter(open);
                } finally {
                    Streams.closeQuietly(open);
                }
            }
        } else if (clsArr != null && clsArr.length > 0) {
            return (Transporter) clsArr[0].newInstance();
        } else {
            throw new IllegalArgumentException("cert and value cannot be empty at the same time");
        }
    }

    /* renamed from: b */
    private void m37542b(Method method, RpcClient.Builder builder) throws Throwable {
        ArrayList arrayList = new ArrayList();
        Iterator<S> it = ServiceLoader.load(DnsResolver.class).iterator();
        while (it.hasNext()) {
            arrayList.add((DnsResolver) it.next());
        }
        if (method.isAnnotationPresent(DnsResolution.class)) {
            arrayList.add(((DnsResolution) method.getAnnotation(DnsResolution.class)).value().newInstance());
        }
        if (this.f50200b.isAnnotationPresent(DnsResolution.class)) {
            arrayList.add(((DnsResolution) this.f50200b.getAnnotation(DnsResolution.class)).value().newInstance());
        }
        int size = arrayList.size();
        if (size == 1) {
            builder.setDnsResolver((DnsResolver) arrayList.get(0));
        } else if (size > 1) {
            builder.setDnsResolver(new RpcServiceProxy$3(this, arrayList));
        }
    }

    /* renamed from: c */
    private void m37543c(Method method, RpcClient.Builder builder) {
        Retry retry;
        InnerRetry innerRetry;
        Timeout timeout;
        if (method.isAnnotationPresent(Retry.class)) {
            retry = (Retry) method.getAnnotation(Retry.class);
        } else {
            retry = (Retry) this.f50200b.getAnnotation(Retry.class);
        }
        if (retry != null && retry.value() > 0) {
            builder.addInterceptor(new RpcServiceProxy$4(this, Math.min(retry.value(), 10)));
        }
        if (method.isAnnotationPresent(InnerRetry.class)) {
            innerRetry = (InnerRetry) method.getAnnotation(InnerRetry.class);
        } else {
            innerRetry = (InnerRetry) this.f50200b.getAnnotation(InnerRetry.class);
        }
        if (innerRetry != null) {
            builder.setInnerRetryOnConnectionFailure(innerRetry.value());
        }
        if (method.isAnnotationPresent(Timeout.class)) {
            timeout = (Timeout) method.getAnnotation(Timeout.class);
        } else {
            timeout = (Timeout) this.f50200b.getAnnotation(Timeout.class);
        }
        if (timeout != null) {
            builder.setConnectTimeout(timeout.connectTimeout());
            builder.setReadTimeout(timeout.readTimeout());
            builder.setWriteTimeout(timeout.writeTimeout());
        }
    }

    /* renamed from: d */
    private void m37544d(Method method, RpcClient.Builder builder) throws InstantiationException, IllegalAccessException {
        Class[] value;
        Class[] value2;
        if (this.f50200b.isAnnotationPresent(Interception.class) && (value2 = ((Interception) this.f50200b.getAnnotation(Interception.class)).value()) != null) {
            for (Class newInstance : value2) {
                builder.addInterceptor((RpcInterceptor) newInstance.newInstance());
            }
        }
        if (method.isAnnotationPresent(Interception.class) && (value = ((Interception) method.getAnnotation(Interception.class)).value()) != null) {
            for (Class newInstance2 : value) {
                builder.addInterceptor((RpcInterceptor) newInstance2.newInstance());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37539a(RpcRequest rpcRequest, RpcService.Callback<Object> callback, IOException iOException) {
        if (C16382a.f50187a) {
            SystemUtils.log(6, f50196h, rpcRequest.getUrl(), iOException, "com.didichuxing.foundation.rpc.RpcServiceProxy", 481);
        }
        callback.onFailure(iOException);
    }

    /* renamed from: a */
    private ThreadType m37535a(Method method, Object... objArr) {
        for (Annotation annotation : method.getParameterAnnotations()[objArr.length - 1]) {
            if (TargetThread.class.equals(annotation.annotationType())) {
                return ((TargetThread) annotation).value();
            }
        }
        return ThreadType.MAIN;
    }
}
