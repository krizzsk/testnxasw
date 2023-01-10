package com.didi.map.sdk.sharetrack.common;

import android.content.Context;
import com.didi.map.certificateencryption.CertificateEncryptionUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.ByteArrayDeserializer;
import com.didichuxing.foundation.rpc.RpcServiceFactory;

public class NetUtils {

    /* renamed from: a */
    private static HttpRpcClient f31069a = null;

    /* renamed from: b */
    private static final String f31070b = "global_net_transform_ssl_toggle";

    public static void init(Context context) {
        f31069a = (HttpRpcClient) new RpcServiceFactory(context).getRpcClient("http");
    }

    public static byte[] doPost(String str, byte[] bArr) throws Exception {
        if (Apollo.getToggle(f31070b).allow()) {
            return doPostEx(str, bArr);
        }
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.POST, HttpBody.newInstance(MimeType.APPLICATION_OCTET_STREAM, bArr));
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) CertificateEncryptionUtils.addSslSocketFactoryForBuilder(f31069a.newBuilder()).build().newRpc(builder.build()).execute()).getEntity().getContent());
    }

    public static byte[] doGet(String str) throws Exception {
        if (Apollo.getToggle(f31070b).allow()) {
            return doGetEx(str);
        }
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.GET, (HttpEntity) null);
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) CertificateEncryptionUtils.addSslSocketFactoryForBuilder(f31069a.newBuilder()).build().newRpc(builder.build()).execute()).getEntity().getContent());
    }

    public static byte[] doPostEx(String str, byte[] bArr) throws Exception {
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.POST, HttpBody.newInstance(MimeType.APPLICATION_OCTET_STREAM, bArr));
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) f31069a.newRpc(builder.build()).execute()).getEntity().getContent());
    }

    public static byte[] doGetEx(String str) throws Exception {
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.GET, (HttpEntity) null);
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) f31069a.newRpc(builder.build()).execute()).getEntity().getContent());
    }
}
