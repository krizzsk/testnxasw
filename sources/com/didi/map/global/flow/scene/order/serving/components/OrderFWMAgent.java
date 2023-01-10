package com.didi.map.global.flow.scene.order.serving.components;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.floatingwindow.FWController;
import com.didi.map.global.component.floatingwindow.IFWController;
import com.didi.map.global.flow.scene.order.serving.param.OrderState;
import com.didi.map.global.flow.scene.order.serving.param.PageSceneID;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.utils.CheckPermissionUtil;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import com.didi.map.global.sctx.work.core.PeriodicWorkRequest;
import com.didi.map.global.sctx.work.core.WorkManager;
import com.didi.map.global.sctx.work.core.Worker;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

class OrderFWMAgent implements IOrderFloatWindow {

    /* renamed from: a */
    private static final String f29301a = "OrderFloatWindow";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WeakReference<Context> f29302b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IFWController f29303c;

    /* renamed from: d */
    private float f29304d = 0.0f;

    /* renamed from: e */
    private float f29305e = 0.0f;

    /* renamed from: f */
    private String f29306f = "";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WorkManager f29307g = new WorkManager();

    /* renamed from: h */
    private ViewHodler f29308h = new ViewHodler(this, (C104911) null);

    /* renamed from: i */
    private int f29309i = MapFlowApolloUtils.getFarNearDistance();

    /* renamed from: j */
    private View.OnClickListener f29310j;

    /* renamed from: k */
    private String f29311k = "";

    /* renamed from: l */
    private TimeWorker f29312l;

    /* renamed from: m */
    private boolean f29313m;

    /* renamed from: n */
    private SctxOraService f29314n;

    /* renamed from: o */
    private ServingParam f29315o;

    /* renamed from: p */
    private StageManager f29316p = new StageManager(this, (C104911) null);

    public void setProductId(String str) {
    }

    protected OrderFWMAgent() {
    }

    public void setLicensePlate(String str) {
        DLog.m10773d(f29301a, "licensePlate:" + str, new Object[0]);
        this.f29306f = str;
    }

    public void setModelBitmap(Bitmap bitmap) {
        if (this.f29303c != null) {
            DLog.m10773d(f29301a, "modelBitmap:" + bitmap, new Object[0]);
            this.f29303c.setCarBitmap(bitmap);
        }
    }

    public void setOrderId(String str) {
        this.f29311k = str;
        if (str == null) {
            this.f29311k = "";
        }
        this.f29316p.setOrderId(this.f29311k);
    }

    public void setServingParam(ServingParam servingParam) {
        SctxOraService sctxOraService = this.f29314n;
        if (sctxOraService != null) {
            this.f29315o = servingParam;
            sctxOraService.setServingParam(servingParam);
        }
    }

    public void setMapSdkType(String str) {
        SctxOraService sctxOraService = this.f29314n;
        if (sctxOraService != null) {
            sctxOraService.setMapSdkType(str);
        }
    }

    public void setTripStage(int i) {
        SctxOraService sctxOraService;
        if (!(i == 3 || (sctxOraService = this.f29314n) == null)) {
            sctxOraService.setServingParam((ServingParam) null);
            this.f29314n.stop();
        }
        SctxOraService sctxOraService2 = this.f29314n;
        if (sctxOraService2 != null) {
            sctxOraService2.setTripState(i);
        }
    }

    public void updateEtaEda(int i, int i2) {
        DLog.m10773d(f29301a, "eta:" + i + ",eda:" + i2, new Object[0]);
        if (i <= 0 || i2 <= 0) {
            DLog.m10773d(f29301a, "update eda eta failure, eta < 0 or eda < 0", new Object[0]);
            return;
        }
        float f = (float) i;
        if (f == this.f29304d && ((float) i2) == this.f29305e) {
            DLog.m10773d(f29301a, "same eda, eta", new Object[0]);
        } else if (this.f29305e == 0.0f && this.f29304d == 0.0f) {
            this.f29304d = f;
            this.f29305e = (float) i2;
            if (i2 < this.f29309i) {
                this.f29313m = true;
                m22733a(this.f29316p.getOrderState());
            }
            m22734a(false, this.f29316p.getOrderState());
        } else {
            float f2 = this.f29305e;
            if (f2 > 0.0f) {
                int i3 = this.f29309i;
                if (f2 > ((float) i3) && i2 <= i3) {
                    DLog.m10773d(f29301a, "far distance change to near distance", new Object[0]);
                    this.f29304d = f;
                    this.f29305e = (float) i2;
                    this.f29313m = true;
                    m22733a(this.f29316p.getOrderState());
                    m22734a(false, this.f29316p.getOrderState());
                    IFWController iFWController = this.f29303c;
                    if (iFWController != null && iFWController.isShow() && !this.f29303c.isOpen()) {
                        this.f29303c.open();
                        return;
                    }
                    return;
                }
            }
            this.f29304d = f;
            this.f29305e = (float) i2;
            m22734a(false, this.f29316p.getOrderState());
        }
    }

    /* renamed from: c */
    private boolean m22739c() {
        float f = this.f29305e;
        return f <= ((float) this.f29309i) && f > 0.0f;
    }

    public void updateOrderState(OrderState orderState) {
        if (!this.f29316p.acceptOrderState(orderState)) {
            DLog.m10773d(f29301a, "order state is error, not accept", new Object[0]);
        } else if (isVisible()) {
            switch (C104911.f29317x89c9a454[orderState.ordinal()]) {
                case 1:
                    m22733a(orderState);
                    m22734a(false, orderState);
                    SctxOraService sctxOraService = this.f29314n;
                    if (sctxOraService != null && !sctxOraService.isRunning() && this.f29303c.isShow()) {
                        this.f29314n.start();
                        return;
                    }
                    return;
                case 2:
                    m22733a(orderState);
                    m22734a(false, orderState);
                    setServingParam((ServingParam) null);
                    this.f29316p.resetState();
                    SctxOraService sctxOraService2 = this.f29314n;
                    if (sctxOraService2 != null && sctxOraService2.isRunning()) {
                        this.f29314n.stop();
                        return;
                    }
                    return;
                case 3:
                case 4:
                case 5:
                    m22733a(orderState);
                    m22734a(false, orderState);
                    setServingParam((ServingParam) null);
                    SctxOraService sctxOraService3 = this.f29314n;
                    if (sctxOraService3 != null && sctxOraService3.isRunning()) {
                        this.f29314n.stop();
                        return;
                    }
                    return;
                case 6:
                    m22733a(orderState);
                    m22734a(false, orderState);
                    mo81054b();
                    MapFlowOmegaUtil.trackFloatWindow(this.f29311k, 2);
                    setServingParam((ServingParam) null);
                    this.f29316p.resetState();
                    SctxOraService sctxOraService4 = this.f29314n;
                    if (sctxOraService4 != null && sctxOraService4.isRunning()) {
                        this.f29314n.stop();
                        return;
                    }
                    return;
                case 7:
                    m22733a(orderState);
                    m22734a(false, orderState);
                    mo81054b();
                    MapFlowOmegaUtil.trackFloatWindow(this.f29311k, 3);
                    setServingParam((ServingParam) null);
                    SctxOraService sctxOraService5 = this.f29314n;
                    if (sctxOraService5 != null) {
                        sctxOraService5.stop();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            int i = C104911.f29317x89c9a454[orderState.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    if (i != 6) {
                        if (i != 7) {
                            return;
                        }
                    }
                }
                setServingParam((ServingParam) null);
                SctxOraService sctxOraService6 = this.f29314n;
                if (sctxOraService6 != null) {
                    sctxOraService6.stop();
                    return;
                }
                return;
            }
            setServingParam((ServingParam) null);
            this.f29316p.resetState();
            SctxOraService sctxOraService7 = this.f29314n;
            if (sctxOraService7 != null) {
                sctxOraService7.stop();
            }
        }
    }

    /* renamed from: com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$1 */
    static /* synthetic */ class C104911 {

        /* renamed from: $SwitchMap$com$didi$map$global$flow$scene$order$serving$param$OrderState */
        static final /* synthetic */ int[] f29317x89c9a454;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.map.global.flow.scene.order.serving.param.OrderState[] r0 = com.didi.map.global.flow.scene.order.serving.param.OrderState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f29317x89c9a454 = r0
                com.didi.map.global.flow.scene.order.serving.param.OrderState r1 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_PICKUP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29317x89c9a454     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.flow.scene.order.serving.param.OrderState r1 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_CANCEL_REASSIGNMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f29317x89c9a454     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.flow.scene.order.serving.param.OrderState r1 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_CALLING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f29317x89c9a454     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.global.flow.scene.order.serving.param.OrderState r1 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_ARRIVED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f29317x89c9a454     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.map.global.flow.scene.order.serving.param.OrderState r1 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_PASSENGER_LATE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f29317x89c9a454     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.map.global.flow.scene.order.serving.param.OrderState r1 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_CANCEL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f29317x89c9a454     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.map.global.flow.scene.order.serving.param.OrderState r1 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_PASSENGER_BOARDED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent.C104911.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m22733a(OrderState orderState) {
        if (this.f29303c == null) {
            return;
        }
        if (orderState == OrderState.STATE_CALLING || orderState == OrderState.STATE_CANCEL_REASSIGNMENT) {
            this.f29303c.setStyle(IFWController.Style.Grey);
            DLog.m10773d(f29301a, "calling, style grey", new Object[0]);
        } else if (orderState == OrderState.STATE_PASSENGER_LATE) {
            this.f29303c.setStyle(IFWController.Style.Orange);
            DLog.m10773d(f29301a, "passenger late, style orange", new Object[0]);
        } else if (orderState != OrderState.STATE_PICKUP) {
            DLog.m10773d(f29301a, "other, style gradient", new Object[0]);
            this.f29303c.setStyle(IFWController.Style.Gradient);
        } else if (this.f29313m) {
            DLog.m10773d(f29301a, "pickup near, style gradient", new Object[0]);
            this.f29303c.setStyle(IFWController.Style.Gradient);
        } else {
            DLog.m10773d(f29301a, "pickup far, style grey", new Object[0]);
            this.f29303c.setStyle(IFWController.Style.Grey);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.didi.common.map.util.DLog.m10773d(f29301a, "distance format failure", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        com.didi.common.map.util.DLog.m10773d(f29301a, "distance format failure", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0059 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x009c */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0047=Splitter:B:15:0x0047, B:21:0x008a=Splitter:B:21:0x008a} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m22734a(boolean r13, com.didi.map.global.flow.scene.order.serving.param.OrderState r14) {
        /*
            r12 = this;
            java.lang.String r0 = "OrderFloatWindow"
            r1 = 0
            if (r13 != 0) goto L_0x000b
            boolean r13 = r12.isVisible()     // Catch:{ Exception -> 0x0220 }
            if (r13 == 0) goto L_0x022c
        L_0x000b:
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$StageManager r13 = r12.f29316p     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.param.OrderState r13 = r13.getOrderState()     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.param.OrderState r2 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_CALLING     // Catch:{ Exception -> 0x0220 }
            r3 = 2131953116(0x7f1305dc, float:1.9542694E38)
            if (r13 != r2) goto L_0x002f
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r14 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r2 = 2131953125(0x7f1305e5, float:1.9542712E38)
            r14.<init>(r2)     // Catch:{ Exception -> 0x0220 }
            r13.mainTitleRes = r14     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r14 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r14.<init>(r3)     // Catch:{ Exception -> 0x0220 }
            r13.subTitleRes = r14     // Catch:{ Exception -> 0x0220 }
            goto L_0x01a7
        L_0x002f:
            com.didi.map.global.flow.scene.order.serving.param.OrderState r13 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_PICKUP     // Catch:{ Exception -> 0x0220 }
            r2 = 1
            if (r14 != r13) goto L_0x00c7
            boolean r13 = r12.f29313m     // Catch:{ Exception -> 0x0220 }
            r14 = 2
            java.lang.String r3 = "distance format failure"
            if (r13 == 0) goto L_0x0084
            java.lang.String[] r13 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0220 }
            java.lang.String r4 = r12.f29306f     // Catch:{ Exception -> 0x0220 }
            r13[r1] = r4     // Catch:{ Exception -> 0x0220 }
            float r4 = r12.f29305e     // Catch:{ Exception -> 0x0220 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0220 }
            com.global.didi.elvish.Elvish$Companion r5 = com.global.didi.elvish.Elvish.Companion     // Catch:{ Exception -> 0x0059 }
            com.global.didi.elvish.Elvish r6 = r5.getInstance()     // Catch:{ Exception -> 0x0059 }
            float r5 = r12.f29305e     // Catch:{ Exception -> 0x0059 }
            double r7 = (double) r5     // Catch:{ Exception -> 0x0059 }
            com.global.didi.elvish.DistanceStyle r9 = com.global.didi.elvish.DistanceStyle.KM     // Catch:{ Exception -> 0x0059 }
            r10 = 2
            r11 = 0
            java.lang.String r4 = r6.formatDistance(r7, r9, r10, r11)     // Catch:{ Exception -> 0x0059 }
            goto L_0x005e
        L_0x0059:
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0220 }
            com.didi.common.map.util.DLog.m10773d(r0, r3, r5)     // Catch:{ Exception -> 0x0220 }
        L_0x005e:
            java.lang.String[] r14 = new java.lang.String[r14]     // Catch:{ Exception -> 0x0220 }
            float r3 = r12.f29304d     // Catch:{ Exception -> 0x0220 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0220 }
            r14[r1] = r3     // Catch:{ Exception -> 0x0220 }
            r14[r2] = r4     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r2 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r3 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r4 = 2131953126(0x7f1305e6, float:1.9542714E38)
            r3.<init>(r4, r13)     // Catch:{ Exception -> 0x0220 }
            r2.mainTitleRes = r3     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r2 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r3 = 2131953117(0x7f1305dd, float:1.9542696E38)
            r2.<init>(r3, r14)     // Catch:{ Exception -> 0x0220 }
            r13.subTitleRes = r2     // Catch:{ Exception -> 0x0220 }
            goto L_0x01a7
        L_0x0084:
            float r13 = r12.f29305e     // Catch:{ Exception -> 0x0220 }
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x0220 }
            com.global.didi.elvish.Elvish$Companion r4 = com.global.didi.elvish.Elvish.Companion     // Catch:{ Exception -> 0x009c }
            com.global.didi.elvish.Elvish r5 = r4.getInstance()     // Catch:{ Exception -> 0x009c }
            float r4 = r12.f29305e     // Catch:{ Exception -> 0x009c }
            double r6 = (double) r4     // Catch:{ Exception -> 0x009c }
            com.global.didi.elvish.DistanceStyle r8 = com.global.didi.elvish.DistanceStyle.KM     // Catch:{ Exception -> 0x009c }
            r9 = 2
            r10 = 0
            java.lang.String r13 = r5.formatDistance(r6, r8, r9, r10)     // Catch:{ Exception -> 0x009c }
            goto L_0x00a1
        L_0x009c:
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0220 }
            com.didi.common.map.util.DLog.m10773d(r0, r3, r4)     // Catch:{ Exception -> 0x0220 }
        L_0x00a1:
            java.lang.String[] r14 = new java.lang.String[r14]     // Catch:{ Exception -> 0x0220 }
            float r3 = r12.f29304d     // Catch:{ Exception -> 0x0220 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0220 }
            r14[r1] = r3     // Catch:{ Exception -> 0x0220 }
            r14[r2] = r13     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r2 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r3 = 2131953115(0x7f1305db, float:1.9542692E38)
            r2.<init>(r3, r14)     // Catch:{ Exception -> 0x0220 }
            r13.mainTitleRes = r2     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r14 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r2 = 2131953121(0x7f1305e1, float:1.9542704E38)
            r14.<init>(r2)     // Catch:{ Exception -> 0x0220 }
            r13.subTitleRes = r14     // Catch:{ Exception -> 0x0220 }
            goto L_0x01a7
        L_0x00c7:
            com.didi.map.global.flow.scene.order.serving.param.OrderState r13 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_ARRIVED     // Catch:{ Exception -> 0x0220 }
            if (r14 != r13) goto L_0x00eb
            java.lang.String[] r13 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0220 }
            java.lang.String r14 = r12.f29306f     // Catch:{ Exception -> 0x0220 }
            r13[r1] = r14     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r14 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r2 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r3 = 2131953124(0x7f1305e4, float:1.954271E38)
            r2.<init>(r3, r13)     // Catch:{ Exception -> 0x0220 }
            r14.mainTitleRes = r2     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r14 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r2 = 2131953123(0x7f1305e3, float:1.9542708E38)
            r14.<init>(r2)     // Catch:{ Exception -> 0x0220 }
            r13.subTitleRes = r14     // Catch:{ Exception -> 0x0220 }
            goto L_0x01a7
        L_0x00eb:
            com.didi.map.global.flow.scene.order.serving.param.OrderState r13 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_PASSENGER_BOARDED     // Catch:{ Exception -> 0x0220 }
            r4 = 2131953119(0x7f1305df, float:1.95427E38)
            r5 = 5
            if (r14 != r13) goto L_0x010f
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r14 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r14.<init>(r1)     // Catch:{ Exception -> 0x0220 }
            r13.mainTitleRes = r14     // Catch:{ Exception -> 0x0220 }
            java.lang.String[] r13 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0220 }
            java.lang.String r14 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0220 }
            r13[r1] = r14     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r14 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r2 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r2.<init>(r4, r13)     // Catch:{ Exception -> 0x0220 }
            r14.subTitleRes = r2     // Catch:{ Exception -> 0x0220 }
            goto L_0x01a7
        L_0x010f:
            com.didi.map.global.flow.scene.order.serving.param.OrderState r13 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_PASSENGER_LATE     // Catch:{ Exception -> 0x0220 }
            if (r14 != r13) goto L_0x0133
            java.lang.String[] r13 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0220 }
            java.lang.String r14 = r12.f29306f     // Catch:{ Exception -> 0x0220 }
            r13[r1] = r14     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r14 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r2 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r3 = 2131953114(0x7f1305da, float:1.954269E38)
            r2.<init>(r3, r13)     // Catch:{ Exception -> 0x0220 }
            r14.mainTitleRes = r2     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r14 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r2 = 2131953120(0x7f1305e0, float:1.9542702E38)
            r14.<init>(r2)     // Catch:{ Exception -> 0x0220 }
            r13.subTitleRes = r14     // Catch:{ Exception -> 0x0220 }
            goto L_0x01a7
        L_0x0133:
            com.didi.map.global.flow.scene.order.serving.param.OrderState r13 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_CANCEL_REASSIGNMENT     // Catch:{ Exception -> 0x0220 }
            r6 = 2131953118(0x7f1305de, float:1.9542698E38)
            if (r14 != r13) goto L_0x0167
            boolean r13 = r12.f29313m     // Catch:{ Exception -> 0x0220 }
            r14 = 2131953122(0x7f1305e2, float:1.9542706E38)
            if (r13 == 0) goto L_0x0154
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r2 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r2.<init>(r14)     // Catch:{ Exception -> 0x0220 }
            r13.mainTitleRes = r2     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r14 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r14.<init>(r3)     // Catch:{ Exception -> 0x0220 }
            r13.subTitleRes = r14     // Catch:{ Exception -> 0x0220 }
            goto L_0x01a7
        L_0x0154:
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r2 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0220 }
            r13.mainTitleRes = r2     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r2 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r2.<init>(r14)     // Catch:{ Exception -> 0x0220 }
            r13.subTitleRes = r2     // Catch:{ Exception -> 0x0220 }
            goto L_0x01a7
        L_0x0167:
            com.didi.map.global.flow.scene.order.serving.param.OrderState r13 = com.didi.map.global.flow.scene.order.serving.param.OrderState.STATE_CANCEL     // Catch:{ Exception -> 0x0220 }
            if (r14 != r13) goto L_0x01a7
            boolean r13 = r12.f29313m     // Catch:{ Exception -> 0x0220 }
            if (r13 == 0) goto L_0x018a
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r14 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r14.<init>(r6)     // Catch:{ Exception -> 0x0220 }
            r13.mainTitleRes = r14     // Catch:{ Exception -> 0x0220 }
            java.lang.String[] r13 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0220 }
            java.lang.String r14 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0220 }
            r13[r1] = r14     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r14 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r2 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r2.<init>(r4, r13)     // Catch:{ Exception -> 0x0220 }
            r14.subTitleRes = r2     // Catch:{ Exception -> 0x0220 }
            goto L_0x01a7
        L_0x018a:
            java.lang.String[] r13 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0220 }
            java.lang.String r14 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0220 }
            r13[r1] = r14     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r14 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r2 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r3 = 2131953113(0x7f1305d9, float:1.9542688E38)
            r2.<init>(r3)     // Catch:{ Exception -> 0x0220 }
            r14.mainTitleRes = r2     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r14 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r2 = new com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam     // Catch:{ Exception -> 0x0220 }
            r2.<init>(r4, r13)     // Catch:{ Exception -> 0x0220 }
            r14.subTitleRes = r2     // Catch:{ Exception -> 0x0220 }
        L_0x01a7:
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r13 = r13.mainTitleRes     // Catch:{ Exception -> 0x0220 }
            if (r13 == 0) goto L_0x01e3
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r13 = r13.mainTitleRes     // Catch:{ Exception -> 0x0220 }
            int r13 = r13.resId     // Catch:{ Exception -> 0x0220 }
            if (r13 <= 0) goto L_0x01e3
            java.lang.ref.WeakReference<android.content.Context> r13 = r12.f29302b     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r14 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r14 = r14.mainTitleRes     // Catch:{ Exception -> 0x0220 }
            int r14 = r14.resId     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r2 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r2 = r2.mainTitleRes     // Catch:{ Exception -> 0x0220 }
            java.lang.Object[] r2 = r2.param     // Catch:{ Exception -> 0x0220 }
            java.lang.String r13 = m22737b(r13, r14, r2)     // Catch:{ Exception -> 0x0220 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0220 }
            r14.<init>()     // Catch:{ Exception -> 0x0220 }
            java.lang.String r2 = "update title:"
            r14.append(r2)     // Catch:{ Exception -> 0x0220 }
            r14.append(r13)     // Catch:{ Exception -> 0x0220 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0220 }
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0220 }
            com.didi.common.map.util.DLog.m10773d(r0, r14, r2)     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.component.floatingwindow.IFWController r14 = r12.f29303c     // Catch:{ Exception -> 0x0220 }
            r14.setMainTitle(r13)     // Catch:{ Exception -> 0x0220 }
        L_0x01e3:
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r13 = r13.subTitleRes     // Catch:{ Exception -> 0x0220 }
            if (r13 == 0) goto L_0x022c
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r13 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r13 = r13.subTitleRes     // Catch:{ Exception -> 0x0220 }
            int r13 = r13.resId     // Catch:{ Exception -> 0x0220 }
            if (r13 <= 0) goto L_0x022c
            java.lang.ref.WeakReference<android.content.Context> r13 = r12.f29302b     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r14 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r14 = r14.subTitleRes     // Catch:{ Exception -> 0x0220 }
            int r14 = r14.resId     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ViewHodler r2 = r12.f29308h     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent$ResourceParam r2 = r2.subTitleRes     // Catch:{ Exception -> 0x0220 }
            java.lang.Object[] r2 = r2.param     // Catch:{ Exception -> 0x0220 }
            java.lang.String r13 = m22737b(r13, r14, r2)     // Catch:{ Exception -> 0x0220 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0220 }
            r14.<init>()     // Catch:{ Exception -> 0x0220 }
            java.lang.String r2 = "update subTitle:"
            r14.append(r2)     // Catch:{ Exception -> 0x0220 }
            r14.append(r13)     // Catch:{ Exception -> 0x0220 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0220 }
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0220 }
            com.didi.common.map.util.DLog.m10773d(r0, r14, r2)     // Catch:{ Exception -> 0x0220 }
            com.didi.map.global.component.floatingwindow.IFWController r14 = r12.f29303c     // Catch:{ Exception -> 0x0220 }
            r14.setSubTitle(r13)     // Catch:{ Exception -> 0x0220 }
            goto L_0x022c
        L_0x0220:
            r13 = move-exception
            r13.printStackTrace()
            java.lang.Object[] r13 = new java.lang.Object[r1]
            java.lang.String r14 = "updateFloatView error"
            com.didi.common.map.util.DLog.m10773d(r0, r14, r13)
        L_0x022c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.serving.components.OrderFWMAgent.m22734a(boolean, com.didi.map.global.flow.scene.order.serving.param.OrderState):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m22737b(WeakReference<Context> weakReference, int i, Object... objArr) {
        if (weakReference == null) {
            return "";
        }
        try {
            Context context = (Context) weakReference.get();
            if (context == null || i == 0) {
                return "";
            }
            if (objArr == null) {
                return context.getString(i);
            }
            return context.getString(i, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean isVisible() {
        IFWController iFWController = this.f29303c;
        if (iFWController != null) {
            return iFWController.isShow();
        }
        return false;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f29310j = onClickListener;
        IFWController iFWController = this.f29303c;
        if (iFWController != null) {
            iFWController.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: a */
    public static boolean m22735a() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public boolean hasPermission(Context context) {
        if (context == null) {
            return false;
        }
        return CheckPermissionUtil.hasPermission(context);
    }

    public void requestPermission(Activity activity, int i) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + activity.getPackageName()));
        activity.startActivityForResult(intent, i);
    }

    public void appTurnIntoForeground() {
        DLog.m10773d(f29301a, "appTurnIntoForeground()", new Object[0]);
        hidden();
    }

    public void appTurnIntoBackGround() {
        Context context;
        DLog.m10773d(f29301a, "appTurnIntoBackGround()", new Object[0]);
        show();
        WeakReference<Context> weakReference = this.f29302b;
        if (weakReference != null && (context = (Context) weakReference.get()) != null && hasPermission(context) && this.f29316p.hasOrderInNoPickupScene()) {
            MapFlowOmegaUtil.trackFloatWindowNoShow(this.f29311k);
        }
    }

    public void setContext(Context context) {
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.f29302b = weakReference;
        this.f29314n = new SctxOraService(weakReference);
    }

    public void resetState() {
        this.f29316p.resetState();
    }

    public void show() {
        SctxOraService sctxOraService;
        WeakReference<Context> weakReference = this.f29302b;
        if (weakReference == null) {
            DLog.m10773d(f29301a, "context ref is null", new Object[0]);
            return;
        }
        Context context = (Context) weakReference.get();
        if (context == null) {
            DLog.m10773d(f29301a, "context is null", new Object[0]);
        } else if (this.f29316p.getOrderState() == null) {
            DLog.m10773d(f29301a, "current order state is null", new Object[0]);
        } else if (this.f29316p.getOrderState() == OrderState.STATE_PICKUP && this.f29315o == null) {
            DLog.m10773d(f29301a, "pickup state, serving param is null", new Object[0]);
        } else if (!hasPermission(context)) {
            DLog.m10773d(f29301a, "no float window permission", new Object[0]);
            MapFlowOmegaUtil.trackFloatWindowNoPermission(this.f29311k);
        } else if (!this.f29316p.support()) {
            DLog.m10773d(f29301a, "只在等待应答和行程中显示", new Object[0]);
        } else {
            DLog.m10773d(f29301a, "show float window", new Object[0]);
            if (this.f29303c == null) {
                FWController fWController = new FWController(this.f29302b);
                this.f29303c = fWController;
                View.OnClickListener onClickListener = this.f29310j;
                if (onClickListener != null) {
                    fWController.setOnClickListener(onClickListener);
                }
            }
            if (!this.f29303c.isShow()) {
                this.f29313m = m22739c();
                m22734a(true, this.f29316p.getOrderState());
                m22733a(this.f29316p.getOrderState());
                this.f29303c.show();
                this.f29303c.open();
                if (this.f29316p.getOrderState() == OrderState.STATE_PICKUP && (sctxOraService = this.f29314n) != null && !sctxOraService.isRunning()) {
                    this.f29314n.start();
                }
            }
            MapFlowOmegaUtil.trackFloatWindow(this.f29311k, 1);
        }
    }

    /* renamed from: b */
    public void mo81054b() {
        DLog.m10773d(f29301a, "hiddenDelay", new Object[0]);
        m22740d();
        this.f29307g.cancelAllWork();
        TimeWorker timeWorker = new TimeWorker(5);
        this.f29312l = timeWorker;
        this.f29307g.enqueue((PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder(timeWorker, 1, TimeUnit.SECONDS).setInitialDelay(1, TimeUnit.SECONDS)).build());
    }

    public void hidden() {
        DLog.m10773d(f29301a, "hidden", new Object[0]);
        m22740d();
        if (this.f29303c != null) {
            this.f29307g.cancelAllWork();
            this.f29303c.close();
            this.f29303c.hidden();
            SctxOraService sctxOraService = this.f29314n;
            if (sctxOraService != null) {
                sctxOraService.stop();
            }
            if (this.f29316p.support()) {
                MapFlowOmegaUtil.trackFloatWindow(this.f29311k, 4);
            }
        }
    }

    public void setPageScene(PageSceneID pageSceneID) {
        this.f29316p.setPageScene(pageSceneID);
    }

    /* renamed from: d */
    private void m22740d() {
        this.f29305e = 0.0f;
        this.f29304d = 0.0f;
        this.f29313m = false;
    }

    private class ViewHodler {
        ResourceParam mainTitleRes;
        ResourceParam subTitleRes;

        private ViewHodler() {
        }

        /* synthetic */ ViewHodler(OrderFWMAgent orderFWMAgent, C104911 r2) {
            this();
        }
    }

    private class StageManager {
        private OrderState mCurOrderState;
        private boolean mEnable;
        private String mOrderId;
        private PageSceneID mPageSceneID;

        private StageManager() {
            this.mCurOrderState = OrderState.STATE_NONE;
            this.mPageSceneID = PageSceneID.PAGE_NONE;
        }

        /* synthetic */ StageManager(OrderFWMAgent orderFWMAgent, C104911 r2) {
            this();
        }

        public void setOrderId(String str) {
            String str2;
            if (TextUtils.isEmpty(this.mOrderId) || ((str2 = this.mOrderId) != null && !str2.equals(str))) {
                DLog.m10773d(OrderFWMAgent.f29301a, "orderId:" + str, new Object[0]);
                this.mOrderId = str;
            }
        }

        public void resetState() {
            this.mOrderId = "";
            this.mCurOrderState = OrderState.STATE_NONE;
        }

        public OrderState getOrderState() {
            return this.mCurOrderState;
        }

        public void setPageScene(PageSceneID pageSceneID) {
            this.mPageSceneID = pageSceneID;
            if (pageSceneID == null) {
                this.mEnable = false;
            } else if (pageSceneID != PageSceneID.PAGE_CALLING && pageSceneID != PageSceneID.PAGE_PICKUP) {
                this.mEnable = false;
            } else if (this.mCurOrderState == OrderState.STATE_CALLING || this.mCurOrderState == OrderState.STATE_PICKUP || this.mCurOrderState == OrderState.STATE_ARRIVED || this.mCurOrderState == OrderState.STATE_PASSENGER_LATE) {
                this.mEnable = true;
            } else {
                this.mEnable = false;
            }
        }

        public boolean acceptOrderState(OrderState orderState) {
            DLog.m10773d(OrderFWMAgent.f29301a, "order state:" + orderState, new Object[0]);
            if (orderState == null) {
                DLog.m10773d(OrderFWMAgent.f29301a, "state is null", new Object[0]);
                return false;
            } else if (this.mCurOrderState == orderState) {
                DLog.m10773d(OrderFWMAgent.f29301a, "set same state", new Object[0]);
                return false;
            } else if (orderState != OrderState.STATE_CALLING && orderState.order() < this.mCurOrderState.order()) {
                return false;
            } else {
                this.mCurOrderState = orderState;
                switch (C104911.f29317x89c9a454[orderState.ordinal()]) {
                    case 1:
                    case 4:
                    case 5:
                        if (this.mPageSceneID == PageSceneID.PAGE_PICKUP) {
                            this.mEnable = true;
                            break;
                        }
                        break;
                    case 2:
                    case 6:
                    case 7:
                        this.mCurOrderState = OrderState.STATE_NONE;
                        this.mEnable = false;
                        break;
                    case 3:
                        if (this.mPageSceneID == PageSceneID.PAGE_CALLING) {
                            this.mEnable = true;
                            break;
                        }
                        break;
                }
                return true;
            }
        }

        public boolean support() {
            return this.mEnable;
        }

        public boolean hasOrderInNoPickupScene() {
            return !TextUtils.isEmpty(this.mOrderId) && this.mPageSceneID != PageSceneID.PAGE_PICKUP;
        }
    }

    private class ResourceParam {
        Object[] param;
        int resId;

        ResourceParam(int i) {
            this.resId = i;
        }

        ResourceParam(int i, Object[] objArr) {
            this.resId = i;
            this.param = objArr;
        }
    }

    private class TimeWorker implements Worker {
        private int mTime;

        public TimeWorker(int i) {
            this.mTime = i;
        }

        public void onRun() {
            DLog.m10773d(OrderFWMAgent.f29301a, "worker is run, mTime:" + this.mTime, new Object[0]);
            int i = this.mTime - 1;
            this.mTime = i;
            if (i < 0) {
                if (OrderFWMAgent.this.f29307g != null) {
                    OrderFWMAgent.this.f29307g.cancelAllWork();
                }
                if (OrderFWMAgent.this.f29303c != null) {
                    OrderFWMAgent.this.f29303c.hidden();
                }
            } else if (OrderFWMAgent.this.f29302b != null) {
                Context context = (Context) OrderFWMAgent.this.f29302b.get();
                if (OrderFWMAgent.this.f29303c != null && context != null) {
                    OrderFWMAgent.this.f29303c.setSubTitle(OrderFWMAgent.m22737b(OrderFWMAgent.this.f29302b, R.string.GRider_window__eCrK, String.valueOf(this.mTime)));
                }
            }
        }
    }
}
