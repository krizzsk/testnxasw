package com.didi.map.global.flow.scene.order.serving.components.guideentrance;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.streetview.StreetVersion;
import com.didi.map.global.component.streetview.StreetViewComp;
import com.didi.map.global.component.streetview.StreetViewCompParams;
import com.didi.map.sdk.env.PaxEnvironment;

public class StreetViewEntranceManager {

    /* renamed from: a */
    private String f29397a = "StreetViewEntranceManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f29398b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public StreetViewComp f29399c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public StreetLoadCallback f29400d;

    /* renamed from: e */
    private Context f29401e;

    /* renamed from: f */
    private StreetVersion f29402f;

    /* renamed from: g */
    private String f29403g = "";

    /* renamed from: h */
    private String f29404h;

    /* renamed from: i */
    private String f29405i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f29406j = false;

    /* renamed from: k */
    private String f29407k = "";

    /* renamed from: l */
    private StreetViewComp.ILoadCallback f29408l = new StreetViewComp.ILoadCallback() {
        public void onSuccess() {
            boolean unused = StreetViewEntranceManager.this.f29406j = true;
            if (StreetViewEntranceManager.this.f29399c != null) {
                StreetViewEntranceManager streetViewEntranceManager = StreetViewEntranceManager.this;
                View unused2 = streetViewEntranceManager.f29398b = streetViewEntranceManager.f29399c.getTipsView();
            }
            if (StreetViewEntranceManager.this.f29400d != null) {
                StreetViewEntranceManager.this.f29400d.onStreetLoadSuccess();
            }
        }

        public void onFail() {
            boolean unused = StreetViewEntranceManager.this.f29406j = false;
            if (StreetViewEntranceManager.this.f29400d != null) {
                StreetViewEntranceManager.this.f29400d.onStreetLoadFails();
            }
        }

        public void onStreetViewInvalid() {
            boolean unused = StreetViewEntranceManager.this.f29406j = false;
            if (StreetViewEntranceManager.this.f29400d != null) {
                StreetViewEntranceManager.this.f29400d.onStreetInvalid();
            }
        }
    };

    public interface StreetLoadCallback {
        void onStreetInvalid();

        void onStreetLoadFails();

        void onStreetLoadSuccess();
    }

    public StreetViewEntranceManager(Context context, StreetVersion streetVersion, String str, String str2, String str3, String str4, StreetLoadCallback streetLoadCallback) {
        if (context != null) {
            this.f29401e = context;
            this.f29400d = streetLoadCallback;
            this.f29402f = streetVersion;
            this.f29404h = str2;
            this.f29405i = str3;
            this.f29407k = str4;
            this.f29403g = str;
            if (streetVersion != null) {
                m22796a();
                int i = C105012.f29409x1b7f6d62[streetVersion.ordinal()];
                if (i == 1) {
                    DLog.m10773d(this.f29397a, "快车预加载街景", new Object[0]);
                    StreetViewComp streetViewComp = this.f29399c;
                    if (streetViewComp != null) {
                        streetViewComp.load(this.f29408l);
                    }
                } else if (i == 2) {
                    DLog.m10773d(this.f29397a, "快车懒加载街景", new Object[0]);
                    StreetViewComp streetViewComp2 = this.f29399c;
                    if (streetViewComp2 != null) {
                        this.f29398b = streetViewComp2.getTipsView();
                    }
                } else if (i == 3) {
                    DLog.m10773d(this.f29397a, "小巴预加载街景", new Object[0]);
                    StreetViewComp streetViewComp3 = this.f29399c;
                    if (streetViewComp3 != null) {
                        this.f29398b = streetViewComp3.getTipsView();
                        this.f29399c.load(this.f29408l);
                    }
                }
            }
        }
    }

    /* renamed from: com.didi.map.global.flow.scene.order.serving.components.guideentrance.StreetViewEntranceManager$2 */
    static /* synthetic */ class C105012 {

        /* renamed from: $SwitchMap$com$didi$map$global$component$streetview$StreetVersion */
        static final /* synthetic */ int[] f29409x1b7f6d62;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.map.global.component.streetview.StreetVersion[] r0 = com.didi.map.global.component.streetview.StreetVersion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f29409x1b7f6d62 = r0
                com.didi.map.global.component.streetview.StreetVersion r1 = com.didi.map.global.component.streetview.StreetVersion.STREET_V1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29409x1b7f6d62     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.component.streetview.StreetVersion r1 = com.didi.map.global.component.streetview.StreetVersion.STREET_V2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f29409x1b7f6d62     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.component.streetview.StreetVersion r1 = com.didi.map.global.component.streetview.StreetVersion.STREET_V3     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.serving.components.guideentrance.StreetViewEntranceManager.C105012.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m22796a() {
        if (TextUtils.isEmpty(this.f29404h) || this.f29402f == null) {
            destroy();
            DLog.m10773d(this.f29397a, "input data is invalid", new Object[0]);
            return;
        }
        StreetViewComp streetViewComp = this.f29399c;
        if (streetViewComp != null) {
            streetViewComp.onDestroy();
            this.f29399c = null;
        }
        this.f29399c = new StreetViewComp(new StreetViewCompParams.Builder().activity((FragmentActivity) this.f29401e).uid(PaxEnvironment.getInstance().getUid()).tripId(this.f29405i).orderId(this.f29407k).streetViewUrl(this.f29404h).panningGesturesEnable(false).userNavigationEnabled(false).streetNamesEnabled(false).setStreetVersion(this.f29402f).setStreetHintContent(this.f29403g).build());
    }

    public void loadAndShowStreetView() {
        DLog.m10773d(this.f29397a, "点击后懒加载街景", new Object[0]);
        if (this.f29406j) {
            showBigStreet();
            return;
        }
        StreetViewComp streetViewComp = this.f29399c;
        if (streetViewComp != null) {
            streetViewComp.load(this.f29408l);
        }
    }

    public void destroy() {
        StreetViewComp streetViewComp = this.f29399c;
        if (streetViewComp != null) {
            streetViewComp.onDestroy();
            this.f29399c = null;
        }
    }

    public View getSmallStreetView() {
        return this.f29398b;
    }

    public void showBigStreet() {
        StreetViewComp streetViewComp = this.f29399c;
        if (streetViewComp != null) {
            streetViewComp.show();
        }
    }

    public void hideBigStreet() {
        StreetViewComp streetViewComp = this.f29399c;
        if (streetViewComp != null) {
            streetViewComp.hide();
        }
    }

    public boolean isStreetViewShow() {
        StreetViewComp streetViewComp = this.f29399c;
        if (streetViewComp != null) {
            return streetViewComp.isStreetViewDialogShow();
        }
        return false;
    }
}
