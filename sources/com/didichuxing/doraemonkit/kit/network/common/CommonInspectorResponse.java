package com.didichuxing.doraemonkit.kit.network.common;

import com.didichuxing.doraemonkit.kit.network.core.NetworkInterpreter;
import java.util.List;

public class CommonInspectorResponse implements NetworkInterpreter.InspectorResponse {

    /* renamed from: a */
    private final int f50117a;

    /* renamed from: b */
    private final String f50118b;

    /* renamed from: c */
    private final int f50119c;

    /* renamed from: d */
    private final CommonHeaders f50120d;

    public CommonInspectorResponse(int i, String str, int i2, CommonHeaders commonHeaders) {
        this.f50117a = i;
        this.f50118b = str;
        this.f50119c = i2;
        this.f50120d = commonHeaders;
    }

    public int requestId() {
        return this.f50117a;
    }

    public String url() {
        return this.f50118b;
    }

    public int statusCode() {
        return this.f50119c;
    }

    public int headerCount() {
        CommonHeaders commonHeaders = this.f50120d;
        if (commonHeaders != null) {
            return commonHeaders.size();
        }
        return 0;
    }

    public String headerName(int i) {
        CommonHeaders commonHeaders = this.f50120d;
        if (commonHeaders != null) {
            return commonHeaders.name(i);
        }
        return null;
    }

    public String headerValue(int i) {
        CommonHeaders commonHeaders = this.f50120d;
        if (commonHeaders != null) {
            return commonHeaders.value(i);
        }
        return null;
    }

    public String firstHeaderValue(String str) {
        List<String> values;
        CommonHeaders commonHeaders = this.f50120d;
        if (commonHeaders == null || (values = commonHeaders.values(str)) == null || values.size() <= 0) {
            return null;
        }
        return values.get(0);
    }
}
