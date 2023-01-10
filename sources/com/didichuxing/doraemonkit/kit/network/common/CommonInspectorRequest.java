package com.didichuxing.doraemonkit.kit.network.common;

import android.text.TextUtils;
import com.didichuxing.doraemonkit.kit.network.core.NetworkInterpreter;
import java.util.List;

public class CommonInspectorRequest implements NetworkInterpreter.InspectorRequest {

    /* renamed from: a */
    private final int f50112a;

    /* renamed from: b */
    private final String f50113b;

    /* renamed from: c */
    private final String f50114c;

    /* renamed from: d */
    private final String f50115d;

    /* renamed from: e */
    private final CommonHeaders f50116e;

    public CommonInspectorRequest(int i, String str, String str2, String str3, CommonHeaders commonHeaders) {
        this.f50112a = i;
        this.f50113b = str;
        this.f50114c = str2;
        this.f50115d = str3;
        this.f50116e = commonHeaders;
    }

    /* renamed from: id */
    public int mo123615id() {
        return this.f50112a;
    }

    public String url() {
        return this.f50113b;
    }

    public String method() {
        return this.f50114c;
    }

    public byte[] body() {
        if (TextUtils.isEmpty(this.f50115d)) {
            return null;
        }
        return this.f50115d.getBytes();
    }

    public int headerCount() {
        CommonHeaders commonHeaders = this.f50116e;
        if (commonHeaders != null) {
            return commonHeaders.size();
        }
        return 0;
    }

    public String headerName(int i) {
        CommonHeaders commonHeaders = this.f50116e;
        if (commonHeaders != null) {
            return commonHeaders.name(i);
        }
        return null;
    }

    public String headerValue(int i) {
        CommonHeaders commonHeaders = this.f50116e;
        if (commonHeaders != null) {
            return commonHeaders.value(i);
        }
        return null;
    }

    public String firstHeaderValue(String str) {
        List<String> values;
        CommonHeaders commonHeaders = this.f50116e;
        if (commonHeaders == null || (values = commonHeaders.values(str)) == null || values.size() <= 0) {
            return null;
        }
        return values.get(0);
    }
}
