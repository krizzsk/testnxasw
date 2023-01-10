package com.didi.flutter.nacho2.p116v2;

import android.content.Context;
import android.text.TextUtils;
import com.didi.flutter.nacho2.p116v2.NachoEngineCreator;
import com.didi.flutter.nacho2.p116v2.callback.NachoEngineCallback;
import com.didi.flutter.nacho2.p116v2.callback.NachoRouterCallback;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.plugin.common.MethodChannel;

/* renamed from: com.didi.flutter.nacho2.v2.NachoAction */
public class NachoAction {

    /* renamed from: a */
    private Context f22994a;

    /* renamed from: b */
    private String f22995b;

    /* renamed from: c */
    private FlutterEngine f22996c;

    /* renamed from: d */
    private String f22997d;

    /* renamed from: e */
    private String f22998e;

    /* renamed from: f */
    private List<String> f22999f;

    /* renamed from: g */
    private Map<String, MethodChannel> f23000g;

    /* renamed from: h */
    private NachoRouterCallback f23001h;

    /* renamed from: i */
    private NachoEngineCallback f23002i;

    /* renamed from: j */
    private NachoEngineCreator.EngineCreateMode f23003j;

    private NachoAction(Builder builder) {
        this.f22994a = builder.context;
        this.f22995b = builder.engineId;
        this.f22997d = builder.entrypoint;
        this.f22998e = builder.dartEntrypointLibrary;
        this.f22999f = builder.dartEntrypointArgs;
        this.f23001h = builder.onRouteCallback;
        this.f23002i = builder.onEngineCallback;
        this.f23003j = builder.engineCreateMode;
        this.f23000g = new HashMap();
    }

    /* renamed from: com.didi.flutter.nacho2.v2.NachoAction$Builder */
    public static class Builder {
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public List<String> dartEntrypointArgs;
        /* access modifiers changed from: private */
        public String dartEntrypointLibrary;
        /* access modifiers changed from: private */
        public NachoEngineCreator.EngineCreateMode engineCreateMode;
        /* access modifiers changed from: private */
        public String engineId;
        /* access modifiers changed from: private */
        public String entrypoint;
        /* access modifiers changed from: private */
        public NachoEngineCallback onEngineCallback;
        /* access modifiers changed from: private */
        public NachoRouterCallback onRouteCallback;

        public Builder(Context context2) {
            this.context = context2;
        }

        public Builder engineId(String str) {
            this.engineId = str;
            return this;
        }

        @Deprecated
        public Builder entrypoint(String str) {
            this.entrypoint = str;
            return this;
        }

        @Deprecated
        public Builder dartEntrypointLibrary(String str) {
            this.dartEntrypointLibrary = str;
            return this;
        }

        public Builder routeCallback(NachoRouterCallback nachoRouterCallback) {
            this.onRouteCallback = nachoRouterCallback;
            return this;
        }

        public Builder engineCallback(NachoEngineCallback nachoEngineCallback) {
            this.onEngineCallback = nachoEngineCallback;
            return this;
        }

        public Builder engineCreateMode(NachoEngineCreator.EngineCreateMode engineCreateMode2) {
            this.engineCreateMode = engineCreateMode2;
            return this;
        }

        public Builder dartEntrypointArgs(List<String> list) {
            this.dartEntrypointArgs = list;
            return this;
        }

        public NachoAction build() {
            return new NachoAction(this);
        }
    }

    public Context getContext() {
        return this.f22994a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67888a(Context context) {
        this.f22994a = context;
    }

    public String getEngineId() {
        return this.f22995b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67891a(String str) {
        this.f22995b = str;
    }

    public FlutterEngine getEngine() {
        return this.f22996c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67890a(FlutterEngine flutterEngine) {
        this.f22996c = flutterEngine;
    }

    public String getEntrypoint() {
        return this.f22997d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo67892b(String str) {
        this.f22997d = str;
    }

    public String getDartEntrypointLibrary() {
        return this.f22998e;
    }

    public void setDartEntrypointLibrary(String str) {
        this.f22998e = str;
    }

    public NachoRouterCallback getOnRouteCallback() {
        return this.f23001h;
    }

    public void setOnRouteCallback(NachoRouterCallback nachoRouterCallback) {
        this.f23001h = nachoRouterCallback;
    }

    public NachoEngineCallback getOnEngineCallback() {
        return this.f23002i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67889a(NachoEngineCallback nachoEngineCallback) {
        this.f23002i = nachoEngineCallback;
    }

    public NachoEngineCreator.EngineCreateMode getEngineCreateMode() {
        return this.f23003j;
    }

    public List<String> getDartEntrypointArgs() {
        return this.f22999f;
    }

    public void setDartEntrypointArgs(List<String> list) {
        this.f22999f = list;
    }

    public void registerChannel(String str, MethodChannel methodChannel) {
        if (!TextUtils.isEmpty(str) && methodChannel != null) {
            this.f23000g.put(str, methodChannel);
        }
    }

    public MethodChannel getChannel(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f23000g.get(str);
        }
        return null;
    }

    public void openPage(String str, String str2, HashMap<String, Object> hashMap) {
        NachoRouterCallback nachoRouterCallback = this.f23001h;
        if (nachoRouterCallback != null) {
            nachoRouterCallback.onPageOpen(str, str2, hashMap);
        }
    }
}
