package com.didichuxing.mlcp.drtc.p192a;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.mlcp.drtc.enums.DrtcMessageType;
import com.didichuxing.mlcp.drtc.enums.DrtcSupportedPlugins;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16697g;
import com.didichuxing.mlcp.drtc.interfaces.p193f.C16699i;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didichuxing.mlcp.drtc.a.d */
/* compiled from: DrtcSendPluginMessageTransaction */
class C16677d implements C16699i {

    /* renamed from: a */
    private final C16697g f50867a;

    /* renamed from: com.didichuxing.mlcp.drtc.a.d$a */
    /* compiled from: DrtcSendPluginMessageTransaction */
    static /* synthetic */ class C16678a {

        /* renamed from: a */
        static final /* synthetic */ int[] f50868a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType[] r0 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50868a = r0
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.success     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50868a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didichuxing.mlcp.drtc.enums.DrtcMessageType r1 = com.didichuxing.mlcp.drtc.enums.DrtcMessageType.ack     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mlcp.drtc.p192a.C16677d.C16678a.<clinit>():void");
        }
    }

    public C16677d(C16697g gVar) {
        this.f50867a = gVar;
    }

    /* renamed from: a */
    public void mo125394a(JSONObject jSONObject) {
        try {
            int i = C16678a.f50868a[DrtcMessageType.fromString(jSONObject.getString(SDKConsts.getSysConfig().f50902c)).ordinal()];
            if (i == 1) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(SDKConsts.MSG_TAG_PLUGIND);
                DrtcSupportedPlugins fromString = DrtcSupportedPlugins.fromString(jSONObject2.getString(SDKConsts.MSG_TAG_PLUGIN));
                JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                if (fromString == DrtcSupportedPlugins.SATURN_NONE) {
                    C16697g gVar = this.f50867a;
                    gVar.mo125407c("unexpected message: \n\t" + jSONObject.toString());
                    return;
                }
                this.f50867a.mo125422d(jSONObject3);
            } else if (i != 2) {
                this.f50867a.mo125407c(jSONObject.getJSONObject("error").getString("reason"));
            } else {
                this.f50867a.mo125424l();
            }
        } catch (JSONException e) {
            this.f50867a.mo125407c(e.getMessage());
        }
    }
}
