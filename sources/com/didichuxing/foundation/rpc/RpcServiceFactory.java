package com.didichuxing.foundation.rpc;

import android.content.Context;
import android.net.Uri;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didichuxing.foundation.net.UnsupportedSchemeException;
import java.lang.reflect.Proxy;

public class RpcServiceFactory {
    public static final String DISABLE_CERTIFICATE_VERIFICATION = "disable";
    public static final String PROPERTY_CERTIFICATE_VERIFICATION = "rpc.certificate.verification";

    /* renamed from: a */
    final C16383b f50185a;

    /* renamed from: b */
    private final Context f50186b;

    public RpcServiceFactory(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f50186b = applicationContext;
        this.f50185a = new C16383b(applicationContext);
    }

    public Context getContext() {
        return this.f50186b;
    }

    public <T extends RpcClient<? extends RpcRequest, ? extends RpcResponse>> T getRpcClient(String str) throws UnsupportedSchemeException {
        return this.f50185a.mo123874a(Uri.parse(str + HWMapConstant.HTTP.SEPARATOR));
    }

    public <T extends RpcService> T newRpcService(Class<T> cls, String str) {
        return mo123845a(cls, Uri.parse(str), (Object) null);
    }

    public <T extends RpcService> T newRpcService(Class<T> cls, Uri uri) {
        return mo123845a(cls, uri, (Object) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <T extends RpcService> T mo123845a(Class<T> cls, Uri uri, Object obj) {
        return (RpcService) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C16384c(this, cls, uri, obj));
    }
}
