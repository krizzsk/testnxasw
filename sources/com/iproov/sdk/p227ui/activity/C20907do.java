package com.iproov.sdk.p227ui.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.iproov.sdk.IProov;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.C20873if;
import com.iproov.sdk.graphics.iproov.OpenGLRenderer;
import com.iproov.sdk.p227ui.views.C20915do;
import com.iproov.sdk.p227ui.views.LivenessDebugOverlay;
import com.iproov.sdk.p227ui.views.OverlayView;
import com.iproov.sdk.p227ui.views.ProgressView;
import com.iproov.sdk.p227ui.views.ReticleView;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import p069native.C2947if;
import p092return.C3566do;
import p095switch.C3666const;
import p095switch.C3670final;
import p095switch.C3677super;
import p098try.C3688do;
import p098try.C3690if;
import p237final.C21834for;
import p237final.C21838new;
import p242if.C21998do;

/* renamed from: com.iproov.sdk.ui.activity.do */
/* compiled from: IProovActivity */
public class C20907do extends Activity implements C3566do, C3690if.C3699this {

    /* renamed from: A */
    private C21998do f57228A;

    /* renamed from: B */
    private AccessibilityManager f57229B;

    /* renamed from: a */
    private OverlayView f57230a;

    /* renamed from: b */
    private ReticleView f57231b;

    /* renamed from: c */
    private ImageView f57232c;

    /* renamed from: d */
    private ImageView f57233d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f57234e;

    /* renamed from: f */
    private TextView f57235f;

    /* renamed from: g */
    private TextView f57236g;

    /* renamed from: h */
    private TextView f57237h;

    /* renamed from: i */
    private TextView f57238i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ProgressView f57239j;

    /* renamed from: k */
    private LivenessDebugOverlay f57240k;

    /* renamed from: l */
    private SwitchCompat f57241l;

    /* renamed from: m */
    private View f57242m;

    /* renamed from: n */
    private C21834for f57243n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C20873if f57244o;

    /* renamed from: p */
    private C21838new f57245p;

    /* renamed from: q */
    private IProov.Options f57246q;

    /* renamed from: r */
    private boolean f57247r = false;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public CountDownTimer f57248s;

    /* renamed from: t */
    private C2947if f57249t;

    /* renamed from: u */
    private GestureDetector f57250u;

    /* renamed from: v */
    private C3670final f57251v;

    /* renamed from: w */
    private C3670final f57252w;

    /* renamed from: x */
    private Animation f57253x;

    /* renamed from: y */
    private OpenGLRenderer f57254y;

    /* renamed from: z */
    private C20909for f57255z;

    /* renamed from: com.iproov.sdk.ui.activity.do$do */
    /* compiled from: IProovActivity */
    class C20908do extends CountDownTimer {

        /* renamed from: do */
        int f57256do = 2;

        C20908do(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            C20907do.this.f57248s.cancel();
            CountDownTimer unused = C20907do.this.f57248s = null;
            C20907do.this.f57239j.mo171612do();
            C20907do.this.f57239j.setProgress(33);
            C20907do.this.f57244o.m48125import();
        }

        public void onTick(long j) {
            int i = this.f57256do;
            this.f57256do = i - 1;
            C20907do.this.f57234e.announceForAccessibility(Integer.toString(i));
        }
    }

    /* renamed from: com.iproov.sdk.ui.activity.do$for */
    /* compiled from: IProovActivity */
    private enum C20909for {
        GPA_INIT_NO_SUPPLEMENTARY,
        GPA_INIT_SUPPLEMENTARY,
        GPA_SUPPLEMENTARY_FRAME,
        GPA_FACE,
        GPA_NO_FACE,
        GPA_FLASHING_STARTING,
        LIVENESS_SUPPLEMENTARY_FRAME,
        LIVENESS_SCAN,
        LIVENESS_STOP_SCAN,
        LIVENESS_FINISH,
        LIVENESS_INIT
    }

    /* renamed from: com.iproov.sdk.ui.activity.do$if */
    /* compiled from: IProovActivity */
    static /* synthetic */ class C20910if {

        /* renamed from: do */
        static final /* synthetic */ int[] f57260do;

        /* renamed from: for  reason: not valid java name */
        static final /* synthetic */ int[] f62436for;

        /* renamed from: if */
        static final /* synthetic */ int[] f57261if;

        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(61:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(63:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(64:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(66:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(67:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(68:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(70:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(72:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|79|80|81|82|84) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x009f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00a9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00b3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00bd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00c7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00db */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00e5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00ef */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00f9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0105 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0111 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x011d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0129 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0146 */
        static {
            /*
                com.iproov.sdk.ui.activity.do$for[] r0 = com.iproov.sdk.p227ui.activity.C20907do.C20909for.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f62436for = r0
                r1 = 1
                com.iproov.sdk.ui.activity.do$for r2 = com.iproov.sdk.p227ui.activity.C20907do.C20909for.GPA_INIT_NO_SUPPLEMENTARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f62436for     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.ui.activity.do$for r3 = com.iproov.sdk.p227ui.activity.C20907do.C20909for.GPA_INIT_SUPPLEMENTARY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f62436for     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.ui.activity.do$for r4 = com.iproov.sdk.p227ui.activity.C20907do.C20909for.GPA_SUPPLEMENTARY_FRAME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f62436for     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.iproov.sdk.ui.activity.do$for r5 = com.iproov.sdk.p227ui.activity.C20907do.C20909for.GPA_FACE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f62436for     // Catch:{ NoSuchFieldError -> 0x003e }
                com.iproov.sdk.ui.activity.do$for r6 = com.iproov.sdk.p227ui.activity.C20907do.C20909for.GPA_NO_FACE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f62436for     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.iproov.sdk.ui.activity.do$for r7 = com.iproov.sdk.p227ui.activity.C20907do.C20909for.GPA_FLASHING_STARTING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f62436for     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.iproov.sdk.ui.activity.do$for r8 = com.iproov.sdk.p227ui.activity.C20907do.C20909for.LIVENESS_INIT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = f62436for     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.iproov.sdk.ui.activity.do$for r9 = com.iproov.sdk.p227ui.activity.C20907do.C20909for.LIVENESS_SUPPLEMENTARY_FRAME     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = f62436for     // Catch:{ NoSuchFieldError -> 0x006c }
                com.iproov.sdk.ui.activity.do$for r10 = com.iproov.sdk.p227ui.activity.C20907do.C20909for.LIVENESS_SCAN     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                r9 = 10
                int[] r10 = f62436for     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.iproov.sdk.ui.activity.do$for r11 = com.iproov.sdk.p227ui.activity.C20907do.C20909for.LIVENESS_STOP_SCAN     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r10[r11] = r9     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                r10 = 11
                int[] r11 = f62436for     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.iproov.sdk.ui.activity.do$for r12 = com.iproov.sdk.p227ui.activity.C20907do.C20909for.LIVENESS_FINISH     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r11[r12] = r10     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                try.do[] r11 = p098try.C3688do.values()
                int r11 = r11.length
                int[] r11 = new int[r11]
                f57261if = r11
                try.do r12 = p098try.C3688do.END_FACE_PATH     // Catch:{ NoSuchFieldError -> 0x0095 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0095 }
                r11[r12] = r1     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r11 = f57261if     // Catch:{ NoSuchFieldError -> 0x009f }
                try.do r12 = p098try.C3688do.READY     // Catch:{ NoSuchFieldError -> 0x009f }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r11[r12] = r0     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                int[] r11 = f57261if     // Catch:{ NoSuchFieldError -> 0x00a9 }
                try.do r12 = p098try.C3688do.FACE_PATH     // Catch:{ NoSuchFieldError -> 0x00a9 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a9 }
                r11[r12] = r2     // Catch:{ NoSuchFieldError -> 0x00a9 }
            L_0x00a9:
                int[] r2 = f57261if     // Catch:{ NoSuchFieldError -> 0x00b3 }
                try.do r11 = p098try.C3688do.NO_FACE_PATH     // Catch:{ NoSuchFieldError -> 0x00b3 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b3 }
                r2[r11] = r3     // Catch:{ NoSuchFieldError -> 0x00b3 }
            L_0x00b3:
                int[] r2 = f57261if     // Catch:{ NoSuchFieldError -> 0x00bd }
                try.do r3 = p098try.C3688do.TOO_FAR_FACE_PATH     // Catch:{ NoSuchFieldError -> 0x00bd }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bd }
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00bd }
            L_0x00bd:
                int[] r2 = f57261if     // Catch:{ NoSuchFieldError -> 0x00c7 }
                try.do r3 = p098try.C3688do.TOO_CLOSE_FACE_PATH     // Catch:{ NoSuchFieldError -> 0x00c7 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c7 }
                r2[r3] = r5     // Catch:{ NoSuchFieldError -> 0x00c7 }
            L_0x00c7:
                int[] r2 = f57261if     // Catch:{ NoSuchFieldError -> 0x00d1 }
                try.do r3 = p098try.C3688do.NO_FACE     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r2[r3] = r6     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                int[] r2 = f57261if     // Catch:{ NoSuchFieldError -> 0x00db }
                try.do r3 = p098try.C3688do.TOO_FAR     // Catch:{ NoSuchFieldError -> 0x00db }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00db }
                r2[r3] = r7     // Catch:{ NoSuchFieldError -> 0x00db }
            L_0x00db:
                int[] r2 = f57261if     // Catch:{ NoSuchFieldError -> 0x00e5 }
                try.do r3 = p098try.C3688do.TOO_CLOSE     // Catch:{ NoSuchFieldError -> 0x00e5 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e5 }
                r2[r3] = r8     // Catch:{ NoSuchFieldError -> 0x00e5 }
            L_0x00e5:
                int[] r2 = f57261if     // Catch:{ NoSuchFieldError -> 0x00ef }
                try.do r3 = p098try.C3688do.TOO_BRIGHT     // Catch:{ NoSuchFieldError -> 0x00ef }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ef }
                r2[r3] = r9     // Catch:{ NoSuchFieldError -> 0x00ef }
            L_0x00ef:
                int[] r2 = f57261if     // Catch:{ NoSuchFieldError -> 0x00f9 }
                try.do r3 = p098try.C3688do.ROLL_TOO_HIGH     // Catch:{ NoSuchFieldError -> 0x00f9 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f9 }
                r2[r3] = r10     // Catch:{ NoSuchFieldError -> 0x00f9 }
            L_0x00f9:
                int[] r2 = f57261if     // Catch:{ NoSuchFieldError -> 0x0105 }
                try.do r3 = p098try.C3688do.ROLL_TOO_LOW     // Catch:{ NoSuchFieldError -> 0x0105 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0105 }
                r4 = 12
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0105 }
            L_0x0105:
                int[] r2 = f57261if     // Catch:{ NoSuchFieldError -> 0x0111 }
                try.do r3 = p098try.C3688do.YAW_TOO_HIGH     // Catch:{ NoSuchFieldError -> 0x0111 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0111 }
                r4 = 13
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0111 }
            L_0x0111:
                int[] r2 = f57261if     // Catch:{ NoSuchFieldError -> 0x011d }
                try.do r3 = p098try.C3688do.YAW_TOO_LOW     // Catch:{ NoSuchFieldError -> 0x011d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x011d }
                r4 = 14
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x011d }
            L_0x011d:
                int[] r2 = f57261if     // Catch:{ NoSuchFieldError -> 0x0129 }
                try.do r3 = p098try.C3688do.PITCH_TOO_LOW     // Catch:{ NoSuchFieldError -> 0x0129 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0129 }
                r4 = 15
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0129 }
            L_0x0129:
                int[] r2 = f57261if     // Catch:{ NoSuchFieldError -> 0x0135 }
                try.do r3 = p098try.C3688do.PITCH_TOO_HIGH     // Catch:{ NoSuchFieldError -> 0x0135 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0135 }
                r4 = 16
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0135 }
            L_0x0135:
                if.do[] r2 = p242if.C21998do.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f57260do = r2
                if.do r3 = p242if.C21998do.GENUINE_PRESENCE_ASSURANCE     // Catch:{ NoSuchFieldError -> 0x0146 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0146 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0146 }
            L_0x0146:
                int[] r1 = f57260do     // Catch:{ NoSuchFieldError -> 0x0150 }
                if.do r2 = p242if.C21998do.LIVENESS     // Catch:{ NoSuchFieldError -> 0x0150 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0150 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0150 }
            L_0x0150:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p227ui.activity.C20907do.C20910if.<clinit>():void");
        }
    }

    /* renamed from: com.iproov.sdk.ui.activity.do$new */
    /* compiled from: IProovActivity */
    private class C20911new extends GestureDetector.SimpleOnGestureListener {
        private C20911new() {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            C20907do.this.m43520m();
            C20907do.this.f57244o.m48125import();
            return true;
        }

        /* synthetic */ C20911new(C20907do doVar, C20908do doVar2) {
            this();
        }
    }

    /* renamed from: d */
    private void m43510d() {
        this.f57230a.m48155for();
        this.f57231b.m48158try();
    }

    /* renamed from: e */
    private void m43511e() {
        this.f57243n.m48238for(C21834for.C21835do.COMPLETED);
    }

    /* renamed from: f */
    private void m43513f() {
        this.f57245p = new C21838new(getWindow());
        this.f57243n = new C21834for(this);
        if (!this.f57246q.f56836ui.enableScreenshots) {
            getWindow().setFlags(8192, 8192);
        }
        this.f57245p.mo180482do(true);
        this.f57245p.mo180483if(true);
    }

    /* renamed from: g */
    private void m43514g() {
        this.f57237h.setTextColor(this.f57246q.f56836ui.headerTextColor);
        this.f57242m.setBackgroundColor(this.f57246q.f56836ui.headerBackgroundColor);
        this.f57234e.setTextColor(this.f57246q.f56836ui.getPromptTextColor());
        ProgressView progressView = this.f57239j;
        IProov.Options.C20735UI ui = this.f57246q.f56836ui;
        progressView.setProgressDrawable(C3677super.m7431do(ui.footerBackgroundColor, ui.genuinePresenceAssurance.progressBarColor));
        if (this.f57246q.f56836ui.floatingPromptEnabled) {
            PaintDrawable paintDrawable = new PaintDrawable();
            paintDrawable.setCornerRadius(getResources().getDimension(R.dimen.iproov__prompt_text_corner_radius));
            this.f57236g.setBackground(paintDrawable);
        }
    }

    /* renamed from: h */
    private void m43515h() {
        this.f57231b = (ReticleView) findViewById(R.id.iproov__reticleView);
        this.f57230a = (OverlayView) findViewById(R.id.iproov__ovalView);
        this.f57254y = (OpenGLRenderer) findViewById(R.id.iproov__rendererView);
        this.f57238i = (TextView) findViewById(R.id.iproov__textViewDebug);
        this.f57232c = (ImageView) findViewById(R.id.iproov__imageHistogramPreView);
        this.f57239j = (ProgressView) findViewById(R.id.iproov__progressBarCaptureBottom);
        this.f57233d = (ImageView) findViewById(R.id.iproov__logoImageView);
        this.f57237h = (TextView) findViewById(R.id.iproov__titleTextView);
        this.f57235f = (TextView) findViewById(R.id.iproov__promptTextView);
        this.f57236g = (TextView) findViewById(R.id.iproov__floatingPromptTextView);
        this.f57240k = (LivenessDebugOverlay) findViewById(R.id.iproov__liveness_debug_overlay);
        this.f57241l = (SwitchCompat) findViewById(R.id.iproov__debugOverlaySwitch);
        this.f57242m = findViewById(R.id.iproov__header);
        if (this.f57246q.f56836ui.floatingPromptEnabled) {
            this.f57236g.setVisibility(0);
            this.f57235f.setVisibility(8);
            this.f57234e = this.f57236g;
        } else {
            this.f57234e = this.f57235f;
        }
        m43501a(this.f57234e, -1);
    }

    /* renamed from: i */
    private void m43516i() {
        int i = 0;
        this.f57238i.setVisibility(this.f57249t.m46613const() ? 0 : 4);
        ImageView imageView = this.f57232c;
        if (!this.f57249t.m46613const()) {
            i = 4;
        }
        imageView.setVisibility(i);
    }

    /* renamed from: j */
    private void m43517j() {
        if (!this.f57246q.f56836ui.orientation.isPortrait()) {
            this.f57237h.setMaxLines(1);
        }
        int i = 0;
        this.f57232c.setVisibility(this.f57249t.m46612class() ? 0 : 4);
        this.f57241l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C20907do.this.m43500a(compoundButton, z);
            }
        });
        this.f57241l.setChecked(this.f57249t.m46613const());
        SwitchCompat switchCompat = this.f57241l;
        if (!this.f57249t.m46612class()) {
            i = 8;
        }
        switchCompat.setVisibility(i);
        m43516i();
    }

    /* renamed from: k */
    private void m43518k() {
        Typeface typeface;
        IProov.Options.C20735UI ui = this.f57246q.f56836ui;
        int i = ui.fontResource;
        if (i != -1) {
            typeface = C3666const.m7410do((Context) this, i);
        } else {
            String str = ui.fontPath;
            typeface = (str == null || str.isEmpty()) ? null : C3666const.m7411do((Context) this, this.f57246q.f56836ui.fontPath);
        }
        if (typeface != null) {
            C3666const.m7412do(this.f57234e, typeface);
            C3666const.m7412do(this.f57237h, typeface);
        }
    }

    /* renamed from: l */
    private void m43519l() {
        m43527t();
        this.f57234e.announceForAccessibility(Integer.toString(3));
        this.f57248s = new C20908do(2000, 1000).start();
        this.f57239j.mo171613do(33, 2000);
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m43520m() {
        CountDownTimer countDownTimer = this.f57248s;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f57248s = null;
        }
        m43527t();
    }

    /* renamed from: n */
    private void m43521n() {
        this.f57239j.mo171613do(0, 100);
    }

    /* renamed from: o */
    private void m43522o() {
        this.f57243n.m48238for(C21834for.C21835do.START_FLASHING);
        m43506b((int) R.string.iproov__prompt_scanning);
        mo171574do(C20909for.GPA_FLASHING_STARTING);
        mo171571b();
        ((View) this.f57237h.getParent()).setVisibility(4);
        this.f57236g.setTextColor(0);
        this.f57236g.setBackgroundColor(0);
        this.f57236g.setVisibility(8);
    }

    /* renamed from: p */
    private void m43523p() {
        mo171570a();
        mo171571b();
        this.f57251v = new C3670final(1000, false, new Runnable() {
            public final void run() {
                C20907do.this.m43529v();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m43524q() {
        this.f57252w.mo43498do();
        m43525r();
        this.f57252w = new C3670final(2000, true, new Runnable() {
            public final void run() {
                C20907do.this.m43525r();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m43525r() {
        if (this.f57253x == null) {
            this.f57253x = AnimationUtils.loadAnimation(this, this.f57246q.f56836ui.floatingPromptEnabled ? R.anim.iproov__pop : R.anim.iproov__wiggle);
        }
        this.f57234e.startAnimation(this.f57253x);
    }

    /* renamed from: s */
    private void m43526s() {
        this.f57229B = (AccessibilityManager) getSystemService("accessibility");
    }

    /* renamed from: t */
    private void m43527t() {
        if (this.f57229B == null) {
            m43526s();
        }
        AccessibilityManager accessibilityManager = this.f57229B;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            this.f57229B.interrupt();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void m43528u() {
        this.f57230a.setScanLineType(C20915do.INSIDE_OVAL_ONLY);
        this.f57230a.mo171602if(true, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void m43529v() {
        mo171574do(C20909for.LIVENESS_STOP_SCAN);
        mo171572c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171570a() {
        C3670final finalR = this.f57251v;
        if (finalR != null) {
            finalR.mo43498do();
            this.f57251v = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo171571b() {
        C3670final finalR = this.f57252w;
        if (finalR != null) {
            finalR.mo43498do();
            this.f57252w = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo171572c() {
        mo171571b();
        boolean z = this.f57244o.m48126new() == C21998do.LIVENESS;
        if (!this.f57246q.f56836ui.floatingPromptEnabled && !z) {
            return;
        }
        if (z) {
            this.f57252w = new C3670final(Const.DELAY_TIME4LAST_GPS_TASK, false, new Runnable() {
                public final void run() {
                    C20907do.this.m43524q();
                }
            });
            return;
        }
        m43525r();
        this.f57252w = new C3670final(2000, true, new Runnable() {
            public final void run() {
                C20907do.this.m43525r();
            }
        });
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f57250u.onTouchEvent(motionEvent) || super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: do */
    public void mo43573do(C3690if ifVar) {
    }

    public void finish() {
        mo171570a();
        mo171571b();
        m43520m();
        this.f57244o.mo171499do((C3566do) null);
        super.finish();
    }

    public void onBackPressed() {
        this.f57244o.m48124class();
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        C20873if captureManager = IProov.getCaptureManager();
        this.f57244o = captureManager;
        if (captureManager != null) {
            this.f57246q = captureManager.m48129try();
            super.onCreate(bundle);
            this.f57249t = new C2947if(this);
            this.f57250u = new GestureDetector(this, new C20911new(this, (C20908do) null));
            setContentView(R.layout.iproov__activity_iproov);
            m43515h();
            this.f57244o.mo171499do((C3566do) this);
            m43517j();
            m43518k();
            m43513f();
            m43514g();
            this.f57244o.mo171498do(this.f57254y);
            this.f57254y.setBackgroundColor(this.f57246q.f56836ui.backgroundColor);
            m43526s();
            return;
        }
        throw new IllegalStateException("Error launching iProov. A common cause of this error is launching iProov from an Activity with android:launchMode=\"singleInstance\". Please either change the launchMode in AndroidManifest.xml, or consider using Option.ui.activityCompatibilityRequestCode and read the FAQ (https://github.com/iProov/android/wiki/Frequently-Asked-Questions).");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f57244o.mo171499do((C3566do) null);
        m43510d();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (!isFinishing() && !this.f57247r) {
            this.f57244o.m48124class();
        }
        this.f57247r = false;
        super.onPause();
        this.f57254y.onPause();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 2001 && iArr.length > 0) {
            if (iArr[0] == 0) {
                this.f57244o.m48123catch();
            } else {
                this.f57244o.m48122break();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f57254y.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f57245p.mo180483if(false);
        this.f57245p.mo180482do(false);
        super.onStop();
    }

    /* renamed from: a */
    private void m43498a(int i) {
        PaintDrawable paintDrawable = (PaintDrawable) this.f57236g.getBackground();
        if (paintDrawable != null) {
            paintDrawable.getPaint().setColor(i);
        }
    }

    /* renamed from: b */
    private void m43506b(int i) {
        m43499a(i, true);
    }

    /* renamed from: new  reason: not valid java name */
    public Orientation m48150new() {
        return Orientation.findByDegrees(getWindowManager().getDefaultDisplay().getRotation() * 90);
    }

    /* renamed from: try  reason: not valid java name */
    public void m48151try() {
        int i = C20910if.f57260do[this.f57228A.ordinal()];
        if (i == 1) {
            mo171574do(C20909for.GPA_SUPPLEMENTARY_FRAME);
        } else if (i == 2) {
            mo171574do(C20909for.LIVENESS_SUPPLEMENTARY_FRAME);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m43500a(CompoundButton compoundButton, boolean z) {
        this.f57249t.mo29249do(z);
        this.f57244o.m48127static();
        m43516i();
    }

    /* renamed from: for  reason: not valid java name */
    public void m48149for() {
        this.f57243n.m48238for(C21834for.C21835do.FACE_FOUND);
    }

    /* renamed from: a */
    private void m43503a(String str) {
        this.f57237h.setVisibility(0);
        if (!str.equals(this.f57237h.getText().toString())) {
            this.f57237h.announceForAccessibility(str);
        }
        this.f57237h.setText(str);
    }

    /* renamed from: a */
    private void m43501a(TextView textView, int i) {
        if (i == -1) {
            textView.setText("");
            textView.setVisibility(4);
            return;
        }
        textView.setText(i);
        textView.setVisibility(0);
    }

    /* renamed from: a */
    private void m43499a(int i, boolean z) {
        String string = i != -1 ? getString(i) : "";
        boolean z2 = true;
        boolean z3 = !string.equals(this.f57234e.getText().toString());
        if (i == -1) {
            z2 = false;
        }
        if (z3) {
            if (z && z2) {
                m43527t();
                this.f57234e.announceForAccessibility(string);
            }
            m43501a(this.f57234e, i);
            if (z2) {
                mo171572c();
            }
        }
    }

    /* renamed from: if */
    public LivenessDebugOverlay mo43319if() {
        return this.f57240k;
    }

    /* renamed from: a */
    private void m43502a(IProov.Options.C20735UI ui) {
        if (ui.logoImageResource != -1) {
            this.f57233d.setImageResource(this.f57246q.f56836ui.logoImageResource);
        } else if (ui.logoImageDrawable != null) {
            this.f57233d.setImageDrawable(this.f57246q.f56836ui.logoImageDrawable);
        }
    }

    /* renamed from: do */
    public void mo43316do(String str) {
        if (this.f57249t.m46613const()) {
            this.f57238i.setText(str);
        }
    }

    /* renamed from: do */
    public void mo43314do(Bitmap bitmap) {
        if (bitmap == null) {
            this.f57232c.setVisibility(4);
            return;
        }
        this.f57232c.setVisibility(0);
        this.f57232c.setImageBitmap(bitmap);
        this.f57232c.destroyDrawingCache();
    }

    /* renamed from: do */
    public void mo43312do() {
        if (ContextCompat.checkSelfPermission(this, Permission.CAMERA) != 0) {
            this.f57247r = true;
        }
        ActivityCompat.requestPermissions(this, new String[]{Permission.CAMERA}, 2001);
    }

    /* renamed from: do */
    public void mo43313do(double d) {
        this.f57245p.mo180481do((float) d);
    }

    /* renamed from: do */
    public void mo43315do(C21998do doVar, boolean z) {
        this.f57228A = doVar;
        if (doVar == C21998do.GENUINE_PRESENCE_ASSURANCE) {
            if (z) {
                mo171574do(C20909for.GPA_INIT_SUPPLEMENTARY);
            } else {
                mo171574do(C20909for.GPA_INIT_NO_SUPPLEMENTARY);
            }
        }
        if (doVar == C21998do.LIVENESS) {
            mo171574do(C20909for.LIVENESS_INIT);
        }
    }

    /* renamed from: do */
    public void mo43317do(boolean z) {
        if (z) {
            mo171570a();
            mo171574do(C20909for.LIVENESS_FINISH);
            m43511e();
            return;
        }
        m43523p();
        mo171574do(C20909for.LIVENESS_SCAN);
    }

    /* renamed from: do */
    public void mo43571do(C3690if.C3698new newR) {
        this.f57237h.setVisibility(8);
        m43506b((int) R.string.iproov__prompt_connecting);
    }

    /* renamed from: do */
    public void mo43569do(C3690if.C3695for forR) {
        String str = forR.m46693new();
        if (str != null) {
            m43503a(str);
        }
        m43502a(this.f57246q.f56836ui);
    }

    /* renamed from: do */
    public void mo43570do(C3690if.C3697if ifVar) {
        C3688do doVar = ifVar.m46695new();
        int[] iArr = C20910if.f57261if;
        switch (iArr[doVar.ordinal()]) {
            case 1:
                mo171574do(C20909for.LIVENESS_FINISH);
                this.f57230a.mo171599do(new Runnable() {
                    public final void run() {
                        C20907do.this.finish();
                    }
                }, 600, 400);
                this.f57231b.mo171615do(600, 400);
                break;
            case 2:
                if (!this.f57246q.f56836ui.genuinePresenceAssurance.autoStartDisabled && this.f57248s == null) {
                    m43519l();
                }
                mo171574do(C20909for.GPA_FACE);
                this.f57243n.m48238for(C21834for.C21835do.FACE_FOUND);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                if (this.f57248s != null) {
                    m43520m();
                }
                m43521n();
                mo171574do(C20909for.GPA_NO_FACE);
                break;
        }
        switch (iArr[doVar.ordinal()]) {
            case 1:
                m43506b((int) R.string.iproov__prompt_liveness_scan_completed);
                return;
            case 2:
                if (this.f57246q.f56836ui.genuinePresenceAssurance.autoStartDisabled) {
                    m43506b((int) R.string.iproov__prompt_tap_to_begin);
                    return;
                } else {
                    m43499a((int) R.string.iproov__prompt_get_ready, false);
                    return;
                }
            case 3:
                m43506b((int) R.string.iproov__prompt_liveness_align_face);
                return;
            case 4:
                m43506b((int) R.string.iproov__prompt_liveness_no_target);
                return;
            case 5:
                m43506b((int) R.string.iproov__prompt_too_far);
                return;
            case 6:
                m43506b((int) R.string.iproov__prompt_too_close);
                return;
            case 7:
                m43506b((int) R.string.iproov__prompt_genuine_presence_align_face);
                return;
            case 8:
                m43506b((int) R.string.iproov__prompt_too_far);
                return;
            case 9:
                m43506b((int) R.string.iproov__prompt_too_close);
                return;
            case 10:
                m43506b((int) R.string.iproov__prompt_too_bright);
                return;
            case 11:
                m43506b((int) R.string.iproov__prompt_roll_too_high);
                return;
            case 12:
                m43506b((int) R.string.iproov__prompt_roll_too_low);
                return;
            case 13:
                m43506b((int) R.string.iproov__prompt_yaw_too_high);
                return;
            case 14:
                m43506b((int) R.string.iproov__prompt_yaw_too_low);
                return;
            case 15:
                m43506b((int) R.string.iproov__prompt_pitch_too_low);
                return;
            case 16:
                m43506b((int) R.string.iproov__prompt_pitch_too_high);
                return;
            default:
                return;
        }
    }

    /* renamed from: do */
    public void mo43568do(C3690if.C3694else elseR) {
        if (elseR.m46690else()) {
            m43522o();
            return;
        }
        this.f57239j.mo171613do((int) ((((double) elseR.m46689case()) * 66.6d) + 33.3d), (long) elseR.m46691new());
    }

    /* renamed from: do */
    public void mo43565do(C3690if.C3691break breakR) {
        if (this.f57244o.m48126new() == C21998do.GENUINE_PRESENCE_ASSURANCE) {
            finish();
        }
    }

    /* renamed from: do */
    public void mo43566do(C3690if.C3692case caseR) {
        finish();
    }

    /* renamed from: do */
    public void mo43572do(C3690if.C3700try tryR) {
        finish();
    }

    /* renamed from: do */
    public void mo43567do(C3690if.C3693do doVar) {
        finish();
    }

    /* renamed from: do */
    public void mo171574do(C20909for forR) {
        C20909for forR2 = this.f57255z;
        if (forR2 != forR) {
            if (forR != C20909for.LIVENESS_SUPPLEMENTARY_FRAME || (forR2 != C20909for.LIVENESS_SCAN && forR2 != C20909for.LIVENESS_STOP_SCAN && forR2 != C20909for.LIVENESS_FINISH)) {
                switch (C20910if.f62436for[forR.ordinal()]) {
                    case 1:
                        m43508c(this.f57246q.f56836ui.genuinePresenceAssurance.notReadyTintColor);
                        this.f57230a.setBGColor(this.f57246q.f56836ui.genuinePresenceAssurance.notReadyTintColor);
                        this.f57230a.setOvalVisible(true);
                        this.f57231b.setReticleVisible(true);
                        m43504a(false, false);
                        this.f57230a.mo171602if(false, false);
                        break;
                    case 2:
                        m43508c(this.f57246q.f56836ui.genuinePresenceAssurance.notReadyTintColor);
                        this.f57230a.setBGColor(this.f57246q.f56836ui.genuinePresenceAssurance.notReadyTintColor);
                        break;
                    case 3:
                        this.f57230a.setScanLineType(C20915do.OUTSIDE_OVAL_ONLY);
                        this.f57230a.setOvalVisible(true);
                        this.f57231b.setReticleVisible(true);
                        m43504a(false, false);
                        this.f57230a.mo171602if(true, true);
                        break;
                    case 4:
                        m43508c(this.f57246q.f56836ui.genuinePresenceAssurance.readyTintColor);
                        this.f57230a.setBGColor(this.f57246q.f56836ui.genuinePresenceAssurance.readyTintColor);
                        this.f57231b.m48157for();
                        break;
                    case 5:
                        m43508c(this.f57246q.f56836ui.genuinePresenceAssurance.notReadyTintColor);
                        this.f57230a.setBGColor(this.f57246q.f56836ui.genuinePresenceAssurance.notReadyTintColor);
                        this.f57231b.m48156case();
                        break;
                    case 6:
                        m43508c(ContextCompat.getColor(this, R.color.iproov__white));
                        this.f57236g.setVisibility(4);
                        this.f57230a.setBGColor(ContextCompat.getColor(this, 17170445));
                        this.f57230a.mo171602if(false, true);
                        this.f57230a.setAlpha(0.5f);
                        this.f57231b.setReticleVisible(false);
                        break;
                    case 7:
                        m43508c(this.f57246q.f56836ui.livenessAssurance.primaryTintColor);
                        this.f57231b.setReticleVisible(true);
                        break;
                    case 8:
                        m43508c(this.f57246q.f56836ui.livenessAssurance.primaryTintColor);
                        this.f57230a.setBGColor(this.f57246q.f56836ui.livenessAssurance.secondaryTintColor);
                        this.f57230a.setScanLineType(C20915do.FULLSCREEN);
                        this.f57230a.setOvalVisible(false);
                        this.f57230a.mo171602if(true, true);
                        m43504a(false, false);
                        break;
                    case 9:
                        m43508c(this.f57246q.f56836ui.livenessAssurance.primaryTintColor);
                        this.f57230a.setBGColor(this.f57246q.f56836ui.livenessAssurance.secondaryTintColor);
                        m43504a(false, true);
                        this.f57230a.mo171598do(new Runnable() {
                            public final void run() {
                                C20907do.this.m43528u();
                            }
                        });
                        break;
                    case 10:
                        m43508c(this.f57246q.f56836ui.livenessAssurance.primaryTintColor);
                        this.f57230a.setBGColor(this.f57246q.f56836ui.livenessAssurance.secondaryTintColor);
                        this.f57230a.mo171602if(false, true);
                        m43504a(true, true);
                        break;
                    case 11:
                        m43508c(this.f57246q.f56836ui.livenessAssurance.primaryTintColor);
                        this.f57230a.setBGColor(this.f57246q.f56836ui.livenessAssurance.primaryTintColor);
                        this.f57230a.mo171602if(false, false);
                        m43504a(false, false);
                        this.f57231b.m48157for();
                        break;
                }
                this.f57255z = forR;
            }
        }
    }

    /* renamed from: c */
    private void m43508c(int i) {
        this.f57230a.setFGColor(i);
        this.f57231b.setColor(i);
        m43498a(i);
    }

    /* renamed from: a */
    private void m43504a(boolean z, boolean z2) {
        this.f57230a.mo171600do(z, z2);
        this.f57231b.mo171616do(z, z2);
    }
}
