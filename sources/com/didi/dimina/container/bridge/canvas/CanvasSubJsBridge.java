package com.didi.dimina.container.bridge.canvas;

import android.text.TextUtils;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.p065ui.canvas.CanvasView;
import com.didi.dimina.container.p065ui.custom.SameLayerRenderingUtil;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class CanvasSubJsBridge {

    /* renamed from: a */
    private final CanvasViewManager f18592a = CanvasViewManager.getCanvasViewManager();

    /* renamed from: b */
    private final DMSandboxHelper f18593b;

    /* renamed from: c */
    private final Map<String, List<Runnable>> f18594c;

    /* renamed from: d */
    private final CanvasDefaultParams f18595d;

    /* renamed from: e */
    private final Map<String, Object> f18596e;

    public CanvasSubJsBridge(DMConfig dMConfig) {
        LogUtil.m16841i("CanvasSubJsBridge init");
        this.f18593b = new DMSandboxHelper(dMConfig);
        this.f18595d = new CanvasDefaultParams();
        this.f18594c = new HashMap();
        this.f18596e = new HashMap();
    }

    public void setCreate(String str) {
        LogUtil.m16841i("CanvasSubJsBridge setCreate");
        if (this.f18594c.get(str) != null) {
            for (Runnable run : this.f18594c.get(str)) {
                run.run();
            }
        }
    }

    /* renamed from: a */
    private void m15778a(String str, Runnable runnable) {
        if (this.f18594c.get(str) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(runnable);
            this.f18594c.put(str, linkedList);
            return;
        }
        this.f18594c.get(str).add(runnable);
    }

    public void removeCanvasList(String str) {
        this.f18594c.remove(str);
    }

    public JSONObject getContext(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge getContext");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "canvasId", (Object) optString);
        return jSONObject2;
    }

    public void width(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge width");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has("width")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject.optDouble("width");
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15816h(this.f$1, this.f$2);
                        }
                    });
                } else {
                    canvasView.width(optDouble);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m15816h(String str, float f) {
        this.f18592a.getCanvasView(str).width(f);
    }

    public void height(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge height");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has("height")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject.optDouble("height");
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15813g(this.f$1, this.f$2);
                        }
                    });
                } else {
                    canvasView.height(optDouble);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m15813g(String str, float f) {
        this.f18592a.getCanvasView(str).height(f);
    }

    public void clearRect(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge clearRect");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has("x") && jSONObject.has(SameLayerRenderingUtil.KEY_COMP_Y) && jSONObject.has("width") && jSONObject.has("height")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                int optInt = jSONObject.optInt("x");
                int optInt2 = jSONObject.optInt(SameLayerRenderingUtil.KEY_COMP_Y);
                int optInt3 = jSONObject.optInt("width");
                int optInt4 = jSONObject.optInt("height");
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optInt, optInt2, optInt3, optInt4) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ int f$2;
                        public final /* synthetic */ int f$3;
                        public final /* synthetic */ int f$4;
                        public final /* synthetic */ int f$5;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                            this.f$5 = r6;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15777a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                        }
                    });
                } else {
                    canvasView.clearRect(optInt, optInt2, optInt3, optInt4);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15777a(String str, int i, int i2, int i3, int i4) {
        this.f18592a.getCanvasView(str).clearRect(i, i2, i3, i4);
    }

    public void fillRect(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge fillRect");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has("x") && jSONObject.has(SameLayerRenderingUtil.KEY_COMP_Y) && jSONObject.has("width") && jSONObject.has("height")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject.optDouble("x");
                float optDouble2 = (float) jSONObject.optDouble(SameLayerRenderingUtil.KEY_COMP_Y);
                float optDouble3 = (float) jSONObject.optDouble("width");
                float optDouble4 = (float) jSONObject.optDouble("height");
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble, optDouble2, optDouble3, optDouble4) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ float f$3;
                        public final /* synthetic */ float f$4;
                        public final /* synthetic */ float f$5;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                            this.f$5 = r6;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15803d(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                        }
                    });
                } else {
                    canvasView.fillRect(optDouble, optDouble2, optDouble3, optDouble4);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m15803d(String str, float f, float f2, float f3, float f4) {
        this.f18592a.getCanvasView(str).fillRect(f, f2, f3, f4);
    }

    public void strokeRect(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge strokeRect");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has("x") && jSONObject.has(SameLayerRenderingUtil.KEY_COMP_Y) && jSONObject.has("width") && jSONObject.has("height")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject.optDouble("x");
                float optDouble2 = (float) jSONObject.optDouble(SameLayerRenderingUtil.KEY_COMP_Y);
                float optDouble3 = (float) jSONObject.optDouble("width");
                float optDouble4 = (float) jSONObject.optDouble("height");
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble, optDouble2, optDouble3, optDouble4) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ float f$3;
                        public final /* synthetic */ float f$4;
                        public final /* synthetic */ float f$5;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                            this.f$5 = r6;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15796c(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                        }
                    });
                } else {
                    canvasView.strokeRect(optDouble, optDouble2, optDouble3, optDouble4);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m15796c(String str, float f, float f2, float f3, float f4) {
        this.f18592a.getCanvasView(str).strokeRect(f, f2, f3, f4);
    }

    public void fillText(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge fillText");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has("x") && jSONObject.has(SameLayerRenderingUtil.KEY_COMP_Y) && jSONObject.has("text")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject.optDouble("x");
                float optDouble2 = (float) jSONObject.optDouble(SameLayerRenderingUtil.KEY_COMP_Y);
                String optString2 = jSONObject.optString("text");
                float optDouble3 = (float) jSONObject.optDouble(Const.YogaConst.MAX_WIDTH);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optString2, optDouble, optDouble2, optDouble3) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ String f$2;
                        public final /* synthetic */ float f$3;
                        public final /* synthetic */ float f$4;
                        public final /* synthetic */ float f$5;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                            this.f$5 = r6;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15791b(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                        }
                    });
                } else {
                    canvasView.fillText(optString2, optDouble, optDouble2, optDouble3);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15791b(String str, String str2, float f, float f2, float f3) {
        this.f18592a.getCanvasView(str).fillText(str2, f, f2, f3);
    }

    public void strokeText(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge strokeText");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has("x") && jSONObject.has(SameLayerRenderingUtil.KEY_COMP_Y) && jSONObject.has("text")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject.optDouble("x");
                float optDouble2 = (float) jSONObject.optDouble(SameLayerRenderingUtil.KEY_COMP_Y);
                String optString2 = jSONObject.optString("text");
                float optDouble3 = (float) jSONObject.optDouble(Const.YogaConst.MAX_WIDTH);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optString2, optDouble, optDouble2, optDouble3) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ String f$2;
                        public final /* synthetic */ float f$3;
                        public final /* synthetic */ float f$4;
                        public final /* synthetic */ float f$5;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                            this.f$5 = r6;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15780a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                        }
                    });
                } else {
                    canvasView.strokeText(optString2, optDouble, optDouble2, optDouble3);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15780a(String str, String str2, float f, float f2, float f3) {
        this.f18592a.getCanvasView(str).strokeText(str2, f, f2, f3);
    }

    /* renamed from: a */
    private float m15769a(float f) {
        if (!Float.isNaN(f)) {
            return f;
        }
        return this.f18595d.getStrokeLineWidth();
    }

    public Object lineWidth(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge lineWidth");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        float optDouble = (float) jSONObject.optDouble("lineWidth");
        if (canvasView != null) {
            return canvasView.lineWidth(optDouble);
        }
        m15778a(optString, (Runnable) new Runnable(optString, optDouble) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ float f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CanvasSubJsBridge.this.m15810f(this.f$1, this.f$2);
            }
        });
        return Float.valueOf(m15769a(optDouble));
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m15810f(String str, float f) {
        this.f18592a.getCanvasView(str).lineWidth(f);
    }

    /* renamed from: b */
    private float m15784b(float f) {
        if (!Float.isNaN(f)) {
            return f;
        }
        return this.f18595d.getStrokeMiterLimit();
    }

    public Object miterLimit(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge miterLimit");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        float optDouble = (float) jSONObject.optDouble("miterLimit");
        if (canvasView != null) {
            return canvasView.miterLimit(optDouble);
        }
        m15778a(optString, (Runnable) new Runnable(optString, optDouble) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ float f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CanvasSubJsBridge.this.m15807e(this.f$1, this.f$2);
            }
        });
        return Float.valueOf(m15784b(optDouble));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m15807e(String str, float f) {
        this.f18592a.getCanvasView(str).miterLimit(f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m15770a(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -894674659(0xffffffffcaac591d, float:-5647502.5)
            java.lang.String r2 = "butt"
            java.lang.String r3 = "square"
            r4 = 1
            if (r0 == r1) goto L_0x001c
            r1 = 3035667(0x2e5213, float:4.253876E-39)
            if (r0 == r1) goto L_0x0014
            goto L_0x0024
        L_0x0014:
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0024
            r6 = 1
            goto L_0x0025
        L_0x001c:
            boolean r6 = r6.equals(r3)
            if (r6 == 0) goto L_0x0024
            r6 = 0
            goto L_0x0025
        L_0x0024:
            r6 = -1
        L_0x0025:
            if (r6 == 0) goto L_0x002c
            if (r6 == r4) goto L_0x002d
            java.lang.String r2 = "round"
            goto L_0x002d
        L_0x002c:
            r2 = r3
        L_0x002d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.canvas.CanvasSubJsBridge.m15770a(java.lang.String):java.lang.String");
    }

    public Object lineCap(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge lineCap");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        String optString2 = jSONObject.optString("lineCap");
        if (canvasView != null) {
            return canvasView.lineCap(optString2);
        }
        m15778a(optString, (Runnable) new Runnable(optString, optString2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CanvasSubJsBridge.this.m15814g(this.f$1, this.f$2);
            }
        });
        return m15770a(optString2);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m15814g(String str, String str2) {
        this.f18592a.getCanvasView(str).lineCap(str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m15785b(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 93630586(0x594b07a, float:1.398268E-35)
            java.lang.String r2 = "miter"
            java.lang.String r3 = "bevel"
            r4 = 1
            if (r0 == r1) goto L_0x001c
            r1 = 103906565(0x6317d05, float:3.338185E-35)
            if (r0 == r1) goto L_0x0014
            goto L_0x0024
        L_0x0014:
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0024
            r6 = 1
            goto L_0x0025
        L_0x001c:
            boolean r6 = r6.equals(r3)
            if (r6 == 0) goto L_0x0024
            r6 = 0
            goto L_0x0025
        L_0x0024:
            r6 = -1
        L_0x0025:
            if (r6 == 0) goto L_0x002c
            if (r6 == r4) goto L_0x002d
            java.lang.String r2 = "round"
            goto L_0x002d
        L_0x002c:
            r2 = r3
        L_0x002d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.canvas.CanvasSubJsBridge.m15785b(java.lang.String):java.lang.String");
    }

    public Object lineJoin(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge lineJoin");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        String optString2 = jSONObject.optString("lineJoin");
        if (canvasView != null) {
            return canvasView.lineJoin(optString2);
        }
        m15778a(optString, (Runnable) new Runnable(optString, optString2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CanvasSubJsBridge.this.m15811f(this.f$1, this.f$2);
            }
        });
        return m15785b(optString2);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m15811f(String str, String str2) {
        this.f18592a.getCanvasView(str).lineJoin(str2);
    }

    /* renamed from: c */
    private String m15793c(String str) {
        if (str.charAt(0) == '#') {
            return str;
        }
        return this.f18595d.getShadowLayerColor();
    }

    public Object fillStyle(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge fillStyle");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        String optString2 = jSONObject.optString("fillStyle");
        if (canvasView != null) {
            return canvasView.fillStyle(optString2);
        }
        m15778a(optString, (Runnable) new Runnable(optString, optString2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CanvasSubJsBridge.this.m15808e(this.f$1, this.f$2);
            }
        });
        return m15793c(optString2);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m15808e(String str, String str2) {
        this.f18592a.getCanvasView(str).fillStyle(str2);
    }

    /* renamed from: d */
    private String m15800d(String str) {
        if (str.charAt(0) == '#') {
            return str;
        }
        return this.f18595d.getShadowLayerColor();
    }

    public Object strokeStyle(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge strokeStyle");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        String optString2 = jSONObject.optString("strokeStyle");
        if (canvasView != null) {
            return canvasView.strokeStyle(optString2);
        }
        m15778a(optString, (Runnable) new Runnable(optString, optString2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CanvasSubJsBridge.this.m15804d(this.f$1, this.f$2);
            }
        });
        return m15800d(optString2);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m15804d(String str, String str2) {
        this.f18592a.getCanvasView(str).strokeStyle(str2);
    }

    /* renamed from: e */
    private String m15806e(String str) {
        if (str.charAt(0) == '#') {
            return str;
        }
        return this.f18595d.getShadowLayerColor();
    }

    public Object shadowColor(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge shadowColor");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        String optString2 = jSONObject.optString("shadowColor");
        if (canvasView != null) {
            return canvasView.shadowColor(optString2);
        }
        m15778a(optString, (Runnable) new Runnable(optString, optString2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CanvasSubJsBridge.this.m15798c(this.f$1, this.f$2);
            }
        });
        return m15806e(optString2);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m15798c(String str, String str2) {
        this.f18592a.getCanvasView(str).shadowColor(str2);
    }

    /* renamed from: c */
    private float m15792c(float f) {
        if (!Float.isNaN(f)) {
            return f;
        }
        return this.f18595d.getShadowLayerRadius();
    }

    public Object shadowBlur(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge shadowBlur");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        float optDouble = (float) jSONObject.optDouble("shadowBlur");
        if (canvasView != null) {
            return Float.valueOf(canvasView.shadowBlur(optDouble));
        }
        m15778a(optString, (Runnable) new Runnable(optString, optDouble) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ float f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CanvasSubJsBridge.this.m15801d(this.f$1, this.f$2);
            }
        });
        return Float.valueOf(m15792c(optDouble));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m15801d(String str, float f) {
        this.f18592a.getCanvasView(str).shadowBlur(f);
    }

    /* renamed from: d */
    private float m15799d(float f) {
        if (!Float.isNaN(f)) {
            return f;
        }
        return this.f18595d.getShadowLayerDx();
    }

    public Object shadowOffsetX(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge shadowOffsetX");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        float optDouble = (float) jSONObject.optDouble("shadowOffsetX");
        if (canvasView != null) {
            return Float.valueOf(canvasView.shadowOffsetX(optDouble));
        }
        m15778a(optString, (Runnable) new Runnable(optString, optDouble) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ float f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CanvasSubJsBridge.this.m15794c(this.f$1, this.f$2);
            }
        });
        return Float.valueOf(m15799d(optDouble));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m15794c(String str, float f) {
        this.f18592a.getCanvasView(str).shadowOffsetX(f);
    }

    /* renamed from: e */
    private float m15805e(float f) {
        if (!Float.isNaN(f)) {
            return f;
        }
        return this.f18595d.getShadowLayerDy();
    }

    public Object shadowOffsetY(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge shadowOffsetY");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        float optDouble = (float) jSONObject.optDouble("shadowOffsetY");
        if (canvasView != null) {
            return Float.valueOf(canvasView.shadowOffsetY(optDouble));
        }
        m15778a(optString, (Runnable) new Runnable(optString, optDouble) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ float f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CanvasSubJsBridge.this.m15786b(this.f$1, this.f$2);
            }
        });
        return Float.valueOf(m15805e(optDouble));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15786b(String str, float f) {
        this.f18592a.getCanvasView(str).shadowOffsetY(f);
    }

    public void closePath(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge closePath");
        if (jSONObject != null && jSONObject.has("canvasId")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString) {
                        public final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15821m(this.f$1);
                        }
                    });
                } else {
                    canvasView.closePath();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void m15821m(String str) {
        this.f18592a.getCanvasView(str).closePath();
    }

    public void moveTo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge moveTo");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has("x") && jSONObject.has(SameLayerRenderingUtil.KEY_COMP_Y)) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject.optDouble("x");
                float optDouble2 = (float) jSONObject.optDouble(SameLayerRenderingUtil.KEY_COMP_Y);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble, optDouble2) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ float f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15802d(this.f$1, this.f$2, this.f$3);
                        }
                    });
                } else {
                    canvasView.moveTo(optDouble, optDouble2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m15802d(String str, float f, float f2) {
        this.f18592a.getCanvasView(str).moveTo(f, f2);
    }

    public void lineTo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge lineTo");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has("x") && jSONObject.has(SameLayerRenderingUtil.KEY_COMP_Y)) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject.optDouble("x");
                float optDouble2 = (float) jSONObject.optDouble(SameLayerRenderingUtil.KEY_COMP_Y);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble, optDouble2) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ float f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15795c(this.f$1, this.f$2, this.f$3);
                        }
                    });
                } else {
                    canvasView.lineTo(optDouble, optDouble2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m15795c(String str, float f, float f2) {
        this.f18592a.getCanvasView(str).lineTo(f, f2);
    }

    public void bezierCurveTo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = jSONObject;
        LogUtil.m16841i("CanvasSubJsBridge bezierCurveTo");
        if (jSONObject2 != null && jSONObject2.has("canvasId") && jSONObject2.has("cp1x") && jSONObject2.has("cp1y") && jSONObject2.has("cp2x") && jSONObject2.has("cp2y") && jSONObject2.has("x") && jSONObject2.has(SameLayerRenderingUtil.KEY_COMP_Y)) {
            String optString = jSONObject2.optString("canvasId");
            if (!optString.isEmpty()) {
                float optDouble = (float) jSONObject2.optDouble("x");
                float optDouble2 = (float) jSONObject2.optDouble(SameLayerRenderingUtil.KEY_COMP_Y);
                float optDouble3 = (float) jSONObject2.optDouble("cp1x");
                float optDouble4 = (float) jSONObject2.optDouble("cp1y");
                float optDouble5 = (float) jSONObject2.optDouble("cp2x");
                float optDouble6 = (float) jSONObject2.optDouble("cp2y");
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble3, optDouble4, optDouble5, optDouble6, optDouble, optDouble2) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ float f$3;
                        public final /* synthetic */ float f$4;
                        public final /* synthetic */ float f$5;
                        public final /* synthetic */ float f$6;
                        public final /* synthetic */ float f$7;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                            this.f$5 = r6;
                            this.f$6 = r7;
                            this.f$7 = r8;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15797c(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
                        }
                    });
                } else {
                    canvasView.bezierCurveTo(optDouble3, optDouble4, optDouble5, optDouble6, optDouble, optDouble2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m15797c(String str, float f, float f2, float f3, float f4, float f5, float f6) {
        this.f18592a.getCanvasView(str).bezierCurveTo(f, f2, f3, f4, f5, f6);
    }

    public void quadraticCurveTo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge quadraticCurveTo");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has("cpx") && jSONObject.has("cpy") && jSONObject.has("x") && jSONObject.has(SameLayerRenderingUtil.KEY_COMP_Y)) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                float optDouble = (float) jSONObject.optDouble("x");
                float optDouble2 = (float) jSONObject.optDouble(SameLayerRenderingUtil.KEY_COMP_Y);
                float optDouble3 = (float) jSONObject.optDouble("cpx");
                float optDouble4 = (float) jSONObject.optDouble("cpy");
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble3, optDouble4, optDouble, optDouble2) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ float f$3;
                        public final /* synthetic */ float f$4;
                        public final /* synthetic */ float f$5;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                            this.f$5 = r6;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15788b(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                        }
                    });
                } else {
                    canvasView.quadraticCurveTo(optDouble3, optDouble4, optDouble, optDouble2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15788b(String str, float f, float f2, float f3, float f4) {
        this.f18592a.getCanvasView(str).quadraticCurveTo(f, f2, f3, f4);
    }

    public void arc(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = jSONObject;
        LogUtil.m16841i("CanvasSubJsBridge arc");
        if (jSONObject2 != null && jSONObject2.has("canvasId") && jSONObject2.has("startAngle") && jSONObject2.has(SameLayerRenderingUtil.KEY_COMP_Y) && jSONObject2.has("x") && jSONObject2.has("radius") && jSONObject2.has("endAngle")) {
            String optString = jSONObject2.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject2.optDouble("x");
                float optDouble2 = (float) jSONObject2.optDouble(SameLayerRenderingUtil.KEY_COMP_Y);
                float optDouble3 = (float) jSONObject2.optDouble("startAngle");
                float optDouble4 = (float) jSONObject2.optDouble("endAngle");
                float optDouble5 = (float) jSONObject2.optDouble("radius");
                boolean optBoolean = jSONObject2.optBoolean("counterclockwise", false);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble, optDouble2, optDouble5, optDouble3, optDouble4, optBoolean) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ float f$3;
                        public final /* synthetic */ float f$4;
                        public final /* synthetic */ float f$5;
                        public final /* synthetic */ float f$6;
                        public final /* synthetic */ boolean f$7;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                            this.f$5 = r6;
                            this.f$6 = r7;
                            this.f$7 = r8;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15775a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
                        }
                    });
                } else {
                    canvasView.arc(optDouble, optDouble2, optDouble5, optDouble3, optDouble4, optBoolean);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15775a(String str, float f, float f2, float f3, float f4, float f5, boolean z) {
        this.f18592a.getCanvasView(str).arc(f, f2, f3, f4, f5, z);
    }

    public void rect(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge rect");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has("x") && jSONObject.has(SameLayerRenderingUtil.KEY_COMP_Y) && jSONObject.has("width") && jSONObject.has("height")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject.optDouble("x");
                float optDouble2 = (float) jSONObject.optDouble(SameLayerRenderingUtil.KEY_COMP_Y);
                float optDouble3 = (float) jSONObject.optDouble("width");
                float optDouble4 = (float) jSONObject.optDouble("height");
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble, optDouble2, optDouble3, optDouble4) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ float f$3;
                        public final /* synthetic */ float f$4;
                        public final /* synthetic */ float f$5;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                            this.f$5 = r6;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15773a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                        }
                    });
                } else {
                    canvasView.rect(optDouble, optDouble2, optDouble3, optDouble4);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15773a(String str, float f, float f2, float f3, float f4) {
        this.f18592a.getCanvasView(str).rect(f, f2, f3, f4);
    }

    public void fill(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge fill");
        if (jSONObject != null && jSONObject.has("canvasId")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString) {
                        public final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15820l(this.f$1);
                        }
                    });
                } else {
                    canvasView.fill();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m15820l(String str) {
        this.f18592a.getCanvasView(str).fill();
    }

    public void stroke(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge stroke");
        if (jSONObject != null && jSONObject.has("canvasId")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString) {
                        public final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15819k(this.f$1);
                        }
                    });
                } else {
                    canvasView.stroke();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void m15819k(String str) {
        this.f18592a.getCanvasView(str).stroke();
    }

    public void clip(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge clip");
        if (jSONObject != null && jSONObject.has("canvasId")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString) {
                        public final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15818j(this.f$1);
                        }
                    });
                } else {
                    canvasView.clip();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void m15818j(String str) {
        this.f18592a.getCanvasView(str).clip();
    }

    public Object isPointInPath(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge isPointInPath");
        if (jSONObject == null || !jSONObject.has("canvasId") || !jSONObject.has("x") || !jSONObject.has(SameLayerRenderingUtil.KEY_COMP_Y)) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        int optInt = jSONObject.optInt("x");
        int optInt2 = jSONObject.optInt(SameLayerRenderingUtil.KEY_COMP_Y);
        if (canvasView != null) {
            return Boolean.valueOf(canvasView.isPointInPath(optInt, optInt2));
        }
        m15778a(optString, (Runnable) new Runnable(optString, optInt, optInt2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ int f$2;
            public final /* synthetic */ int f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                CanvasSubJsBridge.this.m15776a(this.f$1, this.f$2, this.f$3);
            }
        });
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15776a(String str, int i, int i2) {
        this.f18592a.getCanvasView(str).isPointInPath(i, i2);
    }

    public void scale(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge scale");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has("x") && jSONObject.has(SameLayerRenderingUtil.KEY_COMP_Y)) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject.optDouble("x");
                float optDouble2 = (float) jSONObject.optDouble(SameLayerRenderingUtil.KEY_COMP_Y);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble, optDouble2) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ float f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15787b(this.f$1, this.f$2, this.f$3);
                        }
                    });
                } else {
                    canvasView.scale(optDouble, optDouble2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15787b(String str, float f, float f2) {
        this.f18592a.getCanvasView(str).scale(f, f2);
    }

    public void rotate(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge rotate");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has(BlocksConst.WIDGET_PARAMS_ANGLE)) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject.optDouble(BlocksConst.WIDGET_PARAMS_ANGLE);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15771a(this.f$1, this.f$2);
                        }
                    });
                } else {
                    canvasView.rotate(optDouble);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15771a(String str, float f) {
        this.f18592a.getCanvasView(str).rotate(f);
    }

    public void translate(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge translate");
        if (jSONObject != null && jSONObject.has("canvasId") && jSONObject.has("x") && jSONObject.has(SameLayerRenderingUtil.KEY_COMP_Y)) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject.optDouble("x");
                float optDouble2 = (float) jSONObject.optDouble(SameLayerRenderingUtil.KEY_COMP_Y);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble, optDouble2) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ float f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15772a(this.f$1, this.f$2, this.f$3);
                        }
                    });
                } else {
                    canvasView.translate(optDouble, optDouble2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15772a(String str, float f, float f2) {
        this.f18592a.getCanvasView(str).translate(f, f2);
    }

    public void transform(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = jSONObject;
        LogUtil.m16841i("CanvasSubJsBridge transform");
        if (jSONObject2 != null && jSONObject2.has("canvasId") && jSONObject2.has(Constants.FILE_ANR_KEY) && jSONObject2.has("b") && jSONObject2.has("c") && jSONObject2.has("d") && jSONObject2.has("e") && jSONObject2.has("f")) {
            String optString = jSONObject2.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                float optDouble = (float) jSONObject2.optDouble(Constants.FILE_ANR_KEY);
                float optDouble2 = (float) jSONObject2.optDouble("b");
                float optDouble3 = (float) jSONObject2.optDouble("c");
                float optDouble4 = (float) jSONObject2.optDouble("d");
                float optDouble5 = (float) jSONObject2.optDouble("e");
                float optDouble6 = (float) jSONObject2.optDouble("f");
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString, optDouble, optDouble2, optDouble3, optDouble4, optDouble5, optDouble6) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ float f$3;
                        public final /* synthetic */ float f$4;
                        public final /* synthetic */ float f$5;
                        public final /* synthetic */ float f$6;
                        public final /* synthetic */ float f$7;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                            this.f$5 = r6;
                            this.f$6 = r7;
                            this.f$7 = r8;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15789b(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
                        }
                    });
                    return;
                }
                canvasView.transform(optDouble, optDouble2, optDouble3, optDouble4, optDouble5, optDouble6);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15789b(String str, float f, float f2, float f3, float f4, float f5, float f6) {
        this.f18592a.getCanvasView(str).transform(f, f2, f3, f4, f5, f6);
    }

    public void setTransform(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = jSONObject;
        LogUtil.m16841i("CanvasSubJsBridge setTransform");
        if (jSONObject2 != null && jSONObject2.has("canvasId") && jSONObject2.has(Constants.FILE_ANR_KEY) && jSONObject2.has("b") && jSONObject2.has("c") && jSONObject2.has("d") && jSONObject2.has("e") && jSONObject2.has("f")) {
            String optString = jSONObject2.optString("canvasId");
            if (!optString.isEmpty()) {
                float optDouble = (float) jSONObject2.optDouble(Constants.FILE_ANR_KEY);
                float optDouble2 = (float) jSONObject2.optDouble("b");
                float optDouble3 = (float) jSONObject2.optDouble("c");
                float optDouble4 = (float) jSONObject2.optDouble("d");
                float optDouble5 = (float) jSONObject2.optDouble("e");
                float optDouble6 = (float) jSONObject2.optDouble("f");
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                if (canvasView == null) {
                    $$Lambda$CanvasSubJsBridge$urdYndUmLS3AVCDOdbEwYVCa1Tc r12 = r0;
                    $$Lambda$CanvasSubJsBridge$urdYndUmLS3AVCDOdbEwYVCa1Tc r0 = new Runnable(optString, optDouble, optDouble2, optDouble3, optDouble4, optDouble5, optDouble6) {
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ float f$2;
                        public final /* synthetic */ float f$3;
                        public final /* synthetic */ float f$4;
                        public final /* synthetic */ float f$5;
                        public final /* synthetic */ float f$6;
                        public final /* synthetic */ float f$7;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                            this.f$5 = r6;
                            this.f$6 = r7;
                            this.f$7 = r8;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15774a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
                        }
                    };
                    m15778a(optString, (Runnable) r12);
                    return;
                }
                canvasView.setTransform(optDouble, optDouble2, optDouble3, optDouble4, optDouble5, optDouble6);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15774a(String str, float f, float f2, float f3, float f4, float f5, float f6) {
        this.f18592a.getCanvasView(str).setTransform(f, f2, f3, f4, f5, f6);
    }

    public void drawImage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = jSONObject;
        LogUtil.m16841i("CanvasSubJsBridge drawImage");
        if (jSONObject2 != null && jSONObject2.has("canvasId") && jSONObject2.has(Const.BlockParamConst.SRC) && jSONObject2.has("dx") && jSONObject2.has("dy")) {
            String optString = jSONObject2.optString("canvasId");
            String optString2 = jSONObject2.optString(Const.BlockParamConst.SRC);
            int optInt = jSONObject2.optInt("dx");
            int optInt2 = jSONObject2.optInt("dy");
            if (!optString.isEmpty() && !TextUtils.isEmpty(optString2) && optString2.startsWith(DMSandboxHelper.VIRTUAL_DOMAIN_URL)) {
                String url2filepath = this.f18593b.url2filepath(optString2);
                if (FileUtil.exists(1, url2filepath)) {
                    CanvasView canvasView = this.f18592a.getCanvasView(optString);
                    int optInt3 = jSONObject2.optInt("dWidth");
                    int optInt4 = jSONObject2.optInt("dHeight");
                    int optInt5 = jSONObject2.optInt("sx");
                    int optInt6 = jSONObject2.optInt("sy");
                    int optInt7 = jSONObject2.optInt("sWidth");
                    int optInt8 = jSONObject2.optInt("sHeight");
                    if (!jSONObject2.has("dWidth") || !jSONObject2.has("dHeight")) {
                        if (canvasView == null) {
                            m15778a(optString, (Runnable) new Runnable(optString, url2filepath, optInt, optInt2) {
                                public final /* synthetic */ String f$1;
                                public final /* synthetic */ String f$2;
                                public final /* synthetic */ int f$3;
                                public final /* synthetic */ int f$4;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                    this.f$3 = r4;
                                    this.f$4 = r5;
                                }

                                public final void run() {
                                    CanvasSubJsBridge.this.m15781a(this.f$1, this.f$2, this.f$3, this.f$4);
                                }
                            });
                        } else {
                            canvasView.drawImage(url2filepath, optInt, optInt2);
                        }
                    } else if (jSONObject2.has("sx")) {
                        if (canvasView == null) {
                            m15778a(optString, (Runnable) new Runnable(optString, url2filepath, optInt5, optInt6, optInt7, optInt8, optInt, optInt2, optInt3, optInt4) {
                                public final /* synthetic */ String f$1;
                                public final /* synthetic */ int f$10;
                                public final /* synthetic */ String f$2;
                                public final /* synthetic */ int f$3;
                                public final /* synthetic */ int f$4;
                                public final /* synthetic */ int f$5;
                                public final /* synthetic */ int f$6;
                                public final /* synthetic */ int f$7;
                                public final /* synthetic */ int f$8;
                                public final /* synthetic */ int f$9;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                    this.f$3 = r4;
                                    this.f$4 = r5;
                                    this.f$5 = r6;
                                    this.f$6 = r7;
                                    this.f$7 = r8;
                                    this.f$8 = r9;
                                    this.f$9 = r10;
                                    this.f$10 = r11;
                                }

                                public final void run() {
                                    CanvasSubJsBridge.this.m15783a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10);
                                }
                            });
                        } else {
                            canvasView.drawImage(url2filepath, optInt5, optInt6, optInt7, optInt8, optInt, optInt2, optInt3, optInt4);
                        }
                    } else if (canvasView == null) {
                        m15778a(optString, (Runnable) new Runnable(optString, url2filepath, optInt, optInt2, optInt3, optInt4) {
                            public final /* synthetic */ String f$1;
                            public final /* synthetic */ String f$2;
                            public final /* synthetic */ int f$3;
                            public final /* synthetic */ int f$4;
                            public final /* synthetic */ int f$5;
                            public final /* synthetic */ int f$6;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                                this.f$3 = r4;
                                this.f$4 = r5;
                                this.f$5 = r6;
                                this.f$6 = r7;
                            }

                            public final void run() {
                                CanvasSubJsBridge.this.m15782a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
                            }
                        });
                    } else {
                        canvasView.drawImage(url2filepath, optInt, optInt2, optInt3, optInt4);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15783a(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        String str3 = str;
        this.f18592a.getCanvasView(str).drawImage(str2, i, i2, i3, i4, i5, i6, i7, i8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15782a(String str, String str2, int i, int i2, int i3, int i4) {
        this.f18592a.getCanvasView(str).drawImage(str2, i, i2, i3, i4);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15781a(String str, String str2, int i, int i2) {
        this.f18592a.getCanvasView(str).drawImage(str2, i, i2);
    }

    public void save(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge save");
        if (jSONObject != null && jSONObject.has("canvasId")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString) {
                        public final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15817i(this.f$1);
                        }
                    });
                } else {
                    canvasView.save();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void m15817i(String str) {
        this.f18592a.getCanvasView(str).save();
    }

    public void restore(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge restore");
        if (jSONObject != null && jSONObject.has("canvasId")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString) {
                        public final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15815h(this.f$1);
                        }
                    });
                } else {
                    canvasView.restore();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m15815h(String str) {
        this.f18592a.getCanvasView(str).restore();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m15809f(java.lang.String r10) {
        /*
            r9 = this;
            int r0 = r10.hashCode()
            java.lang.String r1 = "start"
            java.lang.String r2 = "right"
            java.lang.String r3 = "left"
            java.lang.String r4 = "end"
            java.lang.String r5 = "center"
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r0) {
                case -1364013995: goto L_0x0035;
                case 100571: goto L_0x002d;
                case 3317767: goto L_0x0025;
                case 108511772: goto L_0x001d;
                case 109757538: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x003d
        L_0x0015:
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x003d
            r10 = 3
            goto L_0x003e
        L_0x001d:
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x003d
            r10 = 2
            goto L_0x003e
        L_0x0025:
            boolean r10 = r10.equals(r3)
            if (r10 == 0) goto L_0x003d
            r10 = 4
            goto L_0x003e
        L_0x002d:
            boolean r10 = r10.equals(r4)
            if (r10 == 0) goto L_0x003d
            r10 = 1
            goto L_0x003e
        L_0x0035:
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto L_0x003d
            r10 = 0
            goto L_0x003e
        L_0x003d:
            r10 = -1
        L_0x003e:
            if (r10 == 0) goto L_0x004c
            if (r10 == r8) goto L_0x004a
            if (r10 == r7) goto L_0x0048
            if (r10 == r6) goto L_0x004d
            r1 = r3
            goto L_0x004d
        L_0x0048:
            r1 = r2
            goto L_0x004d
        L_0x004a:
            r1 = r4
            goto L_0x004d
        L_0x004c:
            r1 = r5
        L_0x004d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.bridge.canvas.CanvasSubJsBridge.m15809f(java.lang.String):java.lang.String");
    }

    public Object textAlign(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge textAlign");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        String optString2 = jSONObject.optString(Const.BlockParamConst.TEXT_ALIGN);
        if (canvasView != null) {
            return canvasView.textAlign(optString2);
        }
        m15778a(optString, (Runnable) new Runnable(optString, optString2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CanvasSubJsBridge.this.m15790b(this.f$1, this.f$2);
            }
        });
        return m15809f(optString2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15790b(String str, String str2) {
        this.f18592a.getCanvasView(str).textAlign(str2);
    }

    public Object font(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge font");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        if (optString.isEmpty()) {
            return null;
        }
        String optString2 = jSONObject.optString("font");
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        if (canvasView != null) {
            return canvasView.font(optString2);
        }
        m15778a(optString, (Runnable) new Runnable(optString, optString2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CanvasSubJsBridge.this.m15779a(this.f$1, this.f$2);
            }
        });
        return optString2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15779a(String str, String str2) {
        this.f18592a.getCanvasView(str).font(str2);
    }

    public void beginPath(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m16841i("CanvasSubJsBridge beginPath");
        if (jSONObject != null && jSONObject.has("canvasId")) {
            String optString = jSONObject.optString("canvasId");
            if (!optString.isEmpty()) {
                CanvasView canvasView = this.f18592a.getCanvasView(optString);
                if (canvasView == null) {
                    m15778a(optString, (Runnable) new Runnable(optString) {
                        public final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            CanvasSubJsBridge.this.m15812g(this.f$1);
                        }
                    });
                } else {
                    canvasView.beginPath();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m15812g(String str) {
        this.f18592a.getCanvasView(str).beginPath();
    }

    public Object toDataURL(JSONObject jSONObject) {
        LogUtil.m16841i("CanvasSubJsBridge toDataURL");
        if (jSONObject == null || !jSONObject.has("canvasId")) {
            return null;
        }
        String optString = jSONObject.optString("canvasId");
        String optString2 = jSONObject.optString("type", "image/png");
        double optDouble = jSONObject.optDouble("encoderOptions", 0.92d);
        if (optString.isEmpty()) {
            return null;
        }
        CanvasView canvasView = this.f18592a.getCanvasView(optString);
        if (canvasView == null) {
            long currentTimeMillis = System.currentTimeMillis();
            do {
                long currentTimeMillis2 = System.currentTimeMillis();
                canvasView = this.f18592a.getCanvasView(optString);
                if (currentTimeMillis2 - currentTimeMillis <= 5000) {
                    break;
                    break;
                }
                break;
            } while (canvasView == null);
        }
        if (canvasView != null) {
            return canvasView.toDataURL(optString2, optDouble);
        }
        return null;
    }
}
