package com.didi.dimina.container.p065ui.webview;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.PixUtil;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.ui.webview.DMWebViewScrollClient */
public class DMWebViewScrollClient {

    /* renamed from: a */
    private long f19729a = 0;

    /* renamed from: b */
    private int f19730b = 0;

    /* renamed from: c */
    private int[] f19731c;

    /* renamed from: d */
    private boolean f19732d = false;

    /* renamed from: e */
    private final DMMina f19733e;

    public DMWebViewScrollClient(DMMina dMMina) {
        this.f19733e = dMMina;
    }

    public void setOnPageScrollEmitToEngine(boolean z) {
        this.f19732d = z;
    }

    public void setOnPageScrollThrottle(int i) {
        this.f19730b = i;
    }

    public void setOnPageScrollTopKeys(int[] iArr) {
        this.f19731c = iArr;
        if (iArr != null) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                this.f19731c[i] = PixUtil.dip2px(Dimina.getConfig().getApp(), (float) this.f19731c[i]);
            }
        }
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.f19732d) {
            long currentTimeMillis = System.currentTimeMillis();
            int[] iArr = this.f19731c;
            if (iArr != null && iArr.length > 0) {
                for (int i5 : iArr) {
                    if (i2 == i5) {
                        this.f19729a = currentTimeMillis;
                        m16799a(i2);
                        return;
                    }
                }
            }
            int i6 = this.f19730b;
            if (i6 <= 0 || currentTimeMillis - this.f19729a >= ((long) i6)) {
                this.f19729a = currentTimeMillis;
                m16799a(i2);
            }
        }
    }

    /* renamed from: a */
    private void m16799a(int i) {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "scrollTop", PixUtil.px2dip(Dimina.getConfig().getApp(), (float) i));
        this.f19733e.getMessageTransfer().sendMessageToServiceFromNative("onPageScroll", new MessageWrapperBuilder().data(jSONObject).build());
    }
}
