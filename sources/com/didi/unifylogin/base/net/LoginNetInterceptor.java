package com.didi.unifylogin.base.net;

import android.text.TextUtils;
import com.didi.unifylogin.base.log.TraceLogBiz;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.StringUtil;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpcInterceptor;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.Streams;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import okio.Buffer;

@ServiceProvider({RpcInterceptor.class})
public class LoginNetInterceptor implements HttpRpcInterceptor {

    /* renamed from: a */
    private static final String f47343a = " url:";

    /* renamed from: b */
    private static final String f47344b = ", body:";

    /* renamed from: c */
    private static final String f47345c = ", response:";

    /* renamed from: d */
    private static final String f47346d = "passport";

    /* renamed from: e */
    private static final String f47347e = "\"uid\":";

    /* renamed from: f */
    private static final String f47348f = "\"ticket\":";

    /* renamed from: g */
    private static final String f47349g = "\"password\":";

    /* renamed from: h */
    private static final String f47350h = "\"new_password\":";

    /* renamed from: i */
    private static final String f47351i = "LoginSDK";

    /* renamed from: j */
    private static final String f47352j = "\"didi\"";

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        HttpRpcResponse proceed = rpcChain.proceed(request);
        if (!m35217b(request)) {
            return proceed;
        }
        m35216a(request);
        return m35213a(proceed);
    }

    /* renamed from: a */
    private HttpRpcResponse m35213a(final HttpRpcResponse httpRpcResponse) throws IOException {
        try {
            final Buffer buffer = new Buffer();
            buffer.readFrom(httpRpcResponse.getEntity().getContent());
            buffer.request(Long.MAX_VALUE);
            String deserialize = new StringDeserializer().deserialize(buffer.clone().inputStream());
            TraceLogBiz instance = TraceLogBiz.getInstance();
            instance.addLogWithTab(f47343a + httpRpcResponse.getUrl() + f47345c + m35214a(deserialize));
            return httpRpcResponse.newBuilder().setEntity((HttpEntity) new HttpBody() {
                public void close() throws IOException {
                    buffer.close();
                }

                public MimeType getContentType() {
                    return httpRpcResponse.getEntity().getContentType();
                }

                public InputStream getContent() throws IOException {
                    return buffer.inputStream();
                }
            }).build();
        } catch (Exception e) {
            e.printStackTrace();
            return httpRpcResponse;
        }
    }

    /* renamed from: a */
    private void m35216a(HttpRpcRequest httpRpcRequest) throws IOException {
        try {
            if (httpRpcRequest.getEntity() != null) {
                String readFully = Streams.readFully((Reader) new InputStreamReader(httpRpcRequest.getEntity().getContent()));
                TraceLogBiz instance = TraceLogBiz.getInstance();
                instance.addLogWithTab(f47343a + httpRpcRequest.getUrl() + f47344b + m35214a(readFully));
                LoginOmegaUtil loginOmegaUtil = new LoginOmegaUtil("tech_passport_net_request_sw");
                loginOmegaUtil.add("path", StringUtil.getPath(httpRpcRequest.getUrl()));
                loginOmegaUtil.add("is_release", Integer.valueOf(LoginStore.isDebug ? 0 : 1));
                loginOmegaUtil.add("base_url", StringUtil.getBaseUrl(httpRpcRequest.getUrl()));
                loginOmegaUtil.send();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private String m35214a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(f47347e);
        arrayList.add(f47348f);
        arrayList.add(f47349g);
        arrayList.add(f47350h);
        String a = m35215a(str, arrayList);
        if (a.endsWith("}")) {
            return a;
        }
        return a + "}";
    }

    /* renamed from: b */
    private boolean m35217b(HttpRpcRequest httpRpcRequest) {
        try {
            if (new URI(httpRpcRequest.getUrl()).getHost().contains(f47346d)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private String m35215a(String str, List<String> list) {
        for (String next : list) {
            if (str.contains(next)) {
                String[] split = str.split(next);
                if (split[1] != null) {
                    str = str.replace(split[1].split(",")[0], f47352j);
                }
            }
        }
        return str;
    }
}
