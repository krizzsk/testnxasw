package com.didi.dimina.container.jsengine.web;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.didi.dimina.container.jsengine.method.JSCallback;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.JSONUtil;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.jsengine.web.a */
/* compiled from: WebJSCallback */
class C8094a {

    /* renamed from: a */
    public static final String f18742a = "__WebJSEngine__";

    /* renamed from: b */
    private final String f18743b;

    /* renamed from: c */
    private final String f18744c;

    /* renamed from: d */
    private final JSCallback f18745d;

    C8094a(String str, JSCallback jSCallback) {
        this.f18743b = "";
        this.f18744c = str;
        this.f18745d = jSCallback;
    }

    C8094a(String str, String str2, JSCallback jSCallback) {
        this.f18743b = str;
        this.f18744c = str2;
        this.f18745d = jSCallback;
    }

    /* renamed from: a */
    public void mo59960a(boolean z, WebView webView, IDMCommonAction<Void> iDMCommonAction) {
        StringBuilder sb = new StringBuilder();
        if (z && !TextUtils.isEmpty(this.f18743b)) {
            sb.append("var " + this.f18743b + " = {}\n");
        }
        if (!TextUtils.isEmpty(this.f18743b)) {
            sb.append(this.f18743b + ".");
        }
        sb.append(this.f18744c + "= function() {\n    var args = [].slice.call(arguments);\n    let req = JSON.stringify(args);\n    let resp = " + f18742a + ".invoke('" + this.f18744c + "', req);\n    if (resp && typeof(resp)=='string' && resp.startsWith('__parse_mark__')) {\n        return JSON.parse(resp.slice('__parse_mark__'.length));\n    } else {\n        return resp;\n    }\n}");
        webView.evaluateJavascript(sb.toString(), new ValueCallback() {
            public final void onReceiveValue(Object obj) {
                C8094a.m15912b(IDMCommonAction.this, (String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m15912b(IDMCommonAction iDMCommonAction, String str) {
        if (iDMCommonAction != null) {
            iDMCommonAction.callback(null);
        }
    }

    /* renamed from: a */
    public void mo59959a(WebView webView, IDMCommonAction<Void> iDMCommonAction) {
        webView.evaluateJavascript("function " + this.f18744c + "() {\n    var args = [].slice.call(arguments);\n    let req = JSON.stringify(args);\n    let resp = " + f18742a + ".invoke('" + this.f18744c + "', req);\n    if (resp && typeof(resp)=='string' && resp.startsWith('__parse_mark__')) {\n        return JSON.parse(resp.slice('__parse_mark__'.length));\n    } else {\n        return resp;\n    }\n}", new ValueCallback() {
            public final void onReceiveValue(Object obj) {
                C8094a.m15911a(IDMCommonAction.this, (String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m15911a(IDMCommonAction iDMCommonAction, String str) {
        if (iDMCommonAction != null) {
            iDMCommonAction.callback(null);
        }
    }

    /* renamed from: a */
    public Object mo59958a(String str) {
        try {
            return m15910a(this.f18745d.callback(new WebJSArray(new JSONArray(str), str)));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private Object m15910a(Object obj) {
        if (obj instanceof Map) {
            return "__parse_mark__" + JSONUtil.toJson(obj);
        } else if (obj instanceof List) {
            return "__parse_mark__" + JSONUtil.toJson(obj);
        } else if (obj instanceof JSONObject) {
            return "__parse_mark__" + ((JSONObject) obj).toString();
        } else if (!(obj instanceof JSONArray)) {
            return obj;
        } else {
            return "__parse_mark__" + ((JSONArray) obj).toString();
        }
    }
}
