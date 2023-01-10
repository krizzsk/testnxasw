package com.didi.payment.wallet_ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import com.didi.payment.wallet_ui.UiUtils;
import com.didi.payment.wallet_ui.dialog.WalletDrawerContent;
import com.didi.payment.wallet_ui.dialog.WalletOperationContent;
import com.didi.payment.wallet_ui.dialog.WalletSystemContent;
import com.didi.payment.wallet_ui.wheel.OptionLinkWheelBuilder;
import com.didi.payment.wallet_ui.wheel.OptionWheelBuilder;
import com.didi.payment.wallet_ui.wheel.TimeWheelBuilder;
import com.didi.payment.wallet_ui.wheel.WalletWheel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B_\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0003\u0010\f\u001a\u00020\u0005\u0012\b\b\u0003\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "contentWidth", "", "contentHeight", "contentGravity", "isAnimation", "", "cancelOnBack", "cancelOnTouchOutside", "windowAnimStyleRes", "themeResId", "(Landroid/content/Context;IIIZZZII)V", "getWindowAnimStyleRes", "()I", "setWindowAnimStyleRes", "(I)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletDialog.kt */
public class WalletDialog extends AppCompatDialog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final float f35490h = UiUtils.Companion.floatSize(40);

    /* renamed from: a */
    private int f35491a;

    /* renamed from: b */
    private int f35492b;

    /* renamed from: c */
    private int f35493c;

    /* renamed from: d */
    private boolean f35494d;

    /* renamed from: e */
    private boolean f35495e;

    /* renamed from: f */
    private boolean f35496f;

    /* renamed from: g */
    private int f35497g;

    public /* synthetic */ WalletDialog(Context context, int i, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, i2, i3, z, z2, z3, i4, i5);
    }

    @JvmStatic
    public static final WalletDialog configCustomView(Context context, Function1<? super Context, ? extends View> function1, int i, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5) {
        return Companion.configCustomView(context, function1, i, i2, i3, z, z2, z3, i4, i5);
    }

    @JvmStatic
    public static final WalletDialog configDrawer(Context context, WalletDrawerContent.Builder builder) {
        return Companion.configDrawer(context, builder);
    }

    @JvmStatic
    public static final WalletDialog configDrawer(Context context, WalletDrawerContent.Builder builder, boolean z) {
        return Companion.configDrawer(context, builder, z);
    }

    @JvmStatic
    public static final WalletDialog configDrawer(Context context, WalletDrawerContent.Builder builder, boolean z, boolean z2) {
        return Companion.configDrawer(context, builder, z, z2);
    }

    @JvmStatic
    public static final WalletDialog configOperation(Context context, WalletOperationContent.Builder builder) {
        return Companion.configOperation(context, builder);
    }

    @JvmStatic
    public static final WalletDialog configSystem(Context context, WalletSystemContent.Builder builder, boolean z, boolean z2) {
        return Companion.configSystem(context, builder, z, z2);
    }

    @JvmStatic
    public static final WalletDialog create(Context context, int i, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5) {
        return Companion.create(context, i, i2, i3, z, z2, z3, i4, i5);
    }

    @JvmStatic
    public static final WalletDialog createDrawer(Context context) {
        return Companion.createDrawer(context);
    }

    @JvmStatic
    public static final WalletDialog createDrawer(Context context, boolean z) {
        return Companion.createDrawer(context, z);
    }

    @JvmStatic
    public static final WalletDialog createDrawer(Context context, boolean z, boolean z2) {
        return Companion.createDrawer(context, z, z2);
    }

    @JvmStatic
    public static final WalletDialog createOperation(Context context) {
        return Companion.createOperation(context);
    }

    @JvmStatic
    public static final WalletDialog createSystem(Context context, boolean z, boolean z2) {
        return Companion.createSystem(context, z, z2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ WalletDialog(android.content.Context r9, int r10, int r11, int r12, boolean r13, boolean r14, boolean r15, int r16, int r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r8 = this;
            r0 = r18
            r1 = r0 & 2
            r2 = -2
            if (r1 == 0) goto L_0x0009
            r1 = -2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r2 = r11
        L_0x0010:
            r3 = r0 & 8
            if (r3 == 0) goto L_0x0017
            r3 = 17
            goto L_0x0018
        L_0x0017:
            r3 = r12
        L_0x0018:
            r4 = r0 & 16
            r5 = 1
            if (r4 == 0) goto L_0x001f
            r4 = 1
            goto L_0x0020
        L_0x001f:
            r4 = r13
        L_0x0020:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0026
            r6 = 1
            goto L_0x0027
        L_0x0026:
            r6 = r14
        L_0x0027:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r5 = r15
        L_0x002d:
            r7 = r0 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0035
            r7 = 2132018116(0x7f1403c4, float:1.967453E38)
            goto L_0x0037
        L_0x0035:
            r7 = r16
        L_0x0037:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x003f
            r0 = 2132018114(0x7f1403c2, float:1.9674526E38)
            goto L_0x0041
        L_0x003f:
            r0 = r17
        L_0x0041:
            r10 = r8
            r11 = r9
            r12 = r1
            r13 = r2
            r14 = r3
            r15 = r4
            r16 = r6
            r17 = r5
            r18 = r7
            r19 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet_ui.dialog.WalletDialog.<init>(android.content.Context, int, int, int, boolean, boolean, boolean, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getWindowAnimStyleRes() {
        return this.f35497g;
    }

    public final void setWindowAnimStyleRes(int i) {
        this.f35497g = i;
    }

    @Metadata(mo148867d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000f0\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0003\u0010\u0018\u001a\u00020\u00112\b\b\u0003\u0010\u0019\u001a\u00020\u0011H\u0007J*\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015J,\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001e2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015H\u0007J*\u0010\u001f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020 2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\"H\u0007J*\u0010#\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020$2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015J,\u0010%\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020&2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015H\u0007J`\u0010'\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0003\u0010\u0018\u001a\u00020\u00112\b\b\u0003\u0010\u0019\u001a\u00020\u0011H\u0007J$\u0010(\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015H\u0007J\u0010\u0010)\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J$\u0010*\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015H\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006+"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/dialog/WalletDialog$Companion;", "", "()V", "radius", "", "getRadius", "()F", "configCustomView", "Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "context", "Landroid/content/Context;", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Landroid/view/View;", "contentWidth", "", "contentHeight", "contentGravity", "isAnimation", "", "cancelOnBack", "cancelOnTouchOutside", "windowAnimStyleRes", "themeResId", "configDateWheel", "builder", "Lcom/didi/payment/wallet_ui/wheel/TimeWheelBuilder;", "configDrawer", "Lcom/didi/payment/wallet_ui/dialog/WalletDrawerContent$Builder;", "configLinkageOptionWheel", "Lcom/didi/payment/wallet_ui/wheel/OptionLinkWheelBuilder;", "configOperation", "Lcom/didi/payment/wallet_ui/dialog/WalletOperationContent$Builder;", "configOptionWheel", "Lcom/didi/payment/wallet_ui/wheel/OptionWheelBuilder;", "configSystem", "Lcom/didi/payment/wallet_ui/dialog/WalletSystemContent$Builder;", "create", "createDrawer", "createOperation", "createSystem", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final WalletDialog configDrawer(Context context, WalletDrawerContent.Builder builder) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(builder, "builder");
            return configDrawer$default(this, context, builder, false, false, 12, (Object) null);
        }

        @JvmStatic
        public final WalletDialog configDrawer(Context context, WalletDrawerContent.Builder builder, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(builder, "builder");
            return configDrawer$default(this, context, builder, z, false, 8, (Object) null);
        }

        @JvmStatic
        public final WalletDialog createDrawer(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return createDrawer$default(this, context, false, false, 6, (Object) null);
        }

        @JvmStatic
        public final WalletDialog createDrawer(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            return createDrawer$default(this, context, z, false, 4, (Object) null);
        }

        private Companion() {
        }

        public final float getRadius() {
            return WalletDialog.f35490h;
        }

        public static /* synthetic */ WalletDialog createSystem$default(Companion companion, Context context, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                z2 = true;
            }
            return companion.createSystem(context, z, z2);
        }

        @JvmStatic
        public final WalletDialog createSystem(Context context, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            return create$default(this, context, UiUtils.Companion.intSize(560), 0, 0, false, z, z2, 0, 0, 412, (Object) null);
        }

        public static /* synthetic */ WalletDialog createDrawer$default(Companion companion, Context context, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                z2 = true;
            }
            return companion.createDrawer(context, z, z2);
        }

        @JvmStatic
        public final WalletDialog createDrawer(Context context, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            return create$default(this, context, -1, 0, 80, false, z, z2, R.style.WalletDialogTranslateAlphaAnim, 0, 276, (Object) null);
        }

        @JvmStatic
        public final WalletDialog createOperation(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return create$default(this, context, UiUtils.Companion.intSize(560), 0, 0, false, false, false, 0, 0, 444, (Object) null);
        }

        public static /* synthetic */ WalletDialog create$default(Companion companion, Context context, int i, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5, int i6, Object obj) {
            int i7 = i6;
            int i8 = -2;
            int i9 = (i7 & 2) != 0 ? -2 : i;
            if ((i7 & 4) == 0) {
                i8 = i2;
            }
            int i10 = (i7 & 8) != 0 ? 17 : i3;
            boolean z4 = true;
            boolean z5 = (i7 & 16) != 0 ? true : z;
            boolean z6 = (i7 & 32) != 0 ? true : z2;
            if ((i7 & 64) == 0) {
                z4 = z3;
            }
            return companion.create(context, i9, i8, i10, z5, z6, z4, (i7 & 128) != 0 ? R.style.WalletDialogScaleAlphaAnim : i4, (i7 & 256) != 0 ? R.style.WalletDialog : i5);
        }

        @JvmStatic
        public final WalletDialog create(Context context, int i, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new WalletDialog(context, i, i2, i3, z, z2, z3, i4, i5, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ WalletDialog configSystem$default(Companion companion, Context context, WalletSystemContent.Builder builder, boolean z, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            if ((i & 8) != 0) {
                z2 = true;
            }
            return companion.configSystem(context, builder, z, z2);
        }

        @JvmStatic
        public final WalletDialog configSystem(Context context, WalletSystemContent.Builder builder, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(builder, "builder");
            WalletDialog createSystem = createSystem(context, z, z2);
            createSystem.setContentView((View) builder.build(context));
            return createSystem;
        }

        public static /* synthetic */ WalletDialog configDrawer$default(Companion companion, Context context, WalletDrawerContent.Builder builder, boolean z, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            if ((i & 8) != 0) {
                z2 = true;
            }
            return companion.configDrawer(context, builder, z, z2);
        }

        @JvmStatic
        public final WalletDialog configDrawer(Context context, WalletDrawerContent.Builder builder, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(builder, "builder");
            WalletDialog createDrawer = createDrawer(context, z, z2);
            createDrawer.setContentView((View) builder.build(context));
            return createDrawer;
        }

        @JvmStatic
        public final WalletDialog configOperation(Context context, WalletOperationContent.Builder builder) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(builder, "builder");
            WalletDialog createOperation = createOperation(context);
            createOperation.setContentView((View) builder.build(context));
            return createOperation;
        }

        public static /* synthetic */ WalletDialog configCustomView$default(Companion companion, Context context, Function1 function1, int i, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5, int i6, Object obj) {
            int i7 = i6;
            return companion.configCustomView(context, function1, (i7 & 4) != 0 ? -2 : i, (i7 & 8) != 0 ? -2 : i2, (i7 & 16) != 0 ? 17 : i3, (i7 & 32) != 0 ? true : z, (i7 & 64) != 0 ? true : z2, (i7 & 128) != 0 ? true : z3, (i7 & 256) != 0 ? R.style.WalletDialogScaleAlphaAnim : i4, (i7 & 512) != 0 ? R.style.WalletDialog : i5);
        }

        @JvmStatic
        public final WalletDialog configCustomView(Context context, Function1<? super Context, ? extends View> function1, int i, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5) {
            Context context2 = context;
            Function1<? super Context, ? extends View> function12 = function1;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(function1, "block");
            WalletDialog create = create(context, i, i2, i3, z, z2, z3, i4, i5);
            create.setContentView((View) function1.invoke(context));
            return create;
        }

        public static /* synthetic */ WalletDialog configDateWheel$default(Companion companion, Context context, TimeWheelBuilder timeWheelBuilder, boolean z, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            if ((i & 8) != 0) {
                z2 = true;
            }
            return companion.configDateWheel(context, timeWheelBuilder, z, z2);
        }

        public final WalletDialog configDateWheel(Context context, TimeWheelBuilder timeWheelBuilder, boolean z, boolean z2) {
            Context context2 = context;
            TimeWheelBuilder timeWheelBuilder2 = timeWheelBuilder;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(timeWheelBuilder2, "builder");
            WalletDialog create$default = create$default(this, context, -1, 0, 80, false, z, z2, R.style.WalletDialogTranslateAlphaAnim, 0, 276, (Object) null);
            timeWheelBuilder2.setDialog(create$default);
            WalletWheel build = timeWheelBuilder2.build(context);
            if (build != null) {
                create$default.setContentView((View) build);
            }
            return create$default;
        }

        public static /* synthetic */ WalletDialog configOptionWheel$default(Companion companion, Context context, OptionWheelBuilder optionWheelBuilder, boolean z, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            if ((i & 8) != 0) {
                z2 = true;
            }
            return companion.configOptionWheel(context, optionWheelBuilder, z, z2);
        }

        public final WalletDialog configOptionWheel(Context context, OptionWheelBuilder optionWheelBuilder, boolean z, boolean z2) {
            Context context2 = context;
            OptionWheelBuilder optionWheelBuilder2 = optionWheelBuilder;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(optionWheelBuilder2, "builder");
            WalletDialog create$default = create$default(this, context, -1, 0, 80, false, z, z2, R.style.WalletDialogTranslateAlphaAnim, 0, 276, (Object) null);
            optionWheelBuilder2.setDialog(create$default);
            WalletWheel build = optionWheelBuilder2.build(context);
            if (build != null) {
                create$default.setContentView((View) build);
            }
            return create$default;
        }

        public static /* synthetic */ WalletDialog configLinkageOptionWheel$default(Companion companion, Context context, OptionLinkWheelBuilder optionLinkWheelBuilder, boolean z, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            if ((i & 8) != 0) {
                z2 = true;
            }
            return companion.configLinkageOptionWheel(context, optionLinkWheelBuilder, z, z2);
        }

        public final WalletDialog configLinkageOptionWheel(Context context, OptionLinkWheelBuilder optionLinkWheelBuilder, boolean z, boolean z2) {
            Context context2 = context;
            OptionLinkWheelBuilder optionLinkWheelBuilder2 = optionLinkWheelBuilder;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(optionLinkWheelBuilder2, "builder");
            WalletDialog create$default = create$default(this, context, -1, 0, 80, false, z, z2, R.style.WalletDialogTranslateAlphaAnim, 0, 276, (Object) null);
            optionLinkWheelBuilder2.setDialog(create$default);
            WalletWheel build = optionLinkWheelBuilder2.build(context);
            if (build != null) {
                create$default.setContentView((View) build);
            }
            return create$default;
        }
    }

    private WalletDialog(Context context, int i, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, int i5) {
        super(context, i5);
        this.f35491a = i;
        this.f35492b = i2;
        this.f35493c = i3;
        this.f35494d = z;
        this.f35495e = z2;
        this.f35496f = z3;
        this.f35497g = i4;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        WindowManager.LayoutParams attributes;
        super.onCreate(bundle);
        setCancelable(this.f35495e);
        setCanceledOnTouchOutside(this.f35496f);
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.width = this.f35491a;
            attributes.height = this.f35492b;
            if (this.f35494d) {
                attributes.windowAnimations = getWindowAnimStyleRes();
            }
            attributes.gravity = this.f35493c;
        }
    }
}
