package com.didi.payment.wallet_ui.loading;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import com.didi.payment.wallet_ui.UiUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/loading/WalletLoadingDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "progressBarGravity", "", "marginWithGravity", "", "cancelOnBack", "", "cancelOnTouchOutside", "(Landroid/content/Context;IFZZ)V", "walletLoadingProgressBar", "Lcom/didi/payment/wallet_ui/loading/WalletLoadingProgressBar;", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "show", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletLoadingDialog.kt */
public final class WalletLoadingDialog extends AppCompatDialog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private int f35643a;

    /* renamed from: b */
    private float f35644b;

    /* renamed from: c */
    private boolean f35645c;

    /* renamed from: d */
    private boolean f35646d;

    /* renamed from: e */
    private WalletLoadingProgressBar f35647e;

    public /* synthetic */ WalletLoadingDialog(Context context, int i, float f, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, f, z, z2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ WalletLoadingDialog(Context context, int i, float f, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 48 : i, (i2 & 4) != 0 ? 0.0f : f, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2);
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bJ\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bJ,\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b¨\u0006\u000e"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/loading/WalletLoadingDialog$Companion;", "", "()V", "createBottom", "Lcom/didi/payment/wallet_ui/loading/WalletLoadingDialog;", "context", "Landroid/content/Context;", "cancelOnBack", "", "cancelOnTouchOutside", "createTop", "createTopMargin", "margin", "", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletLoadingDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ WalletLoadingDialog createTopMargin$default(Companion companion, Context context, float f, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                f = TypedValue.applyDimension(1, 52.0f, Resources.getSystem().getDisplayMetrics());
            }
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                z2 = false;
            }
            return companion.createTopMargin(context, f, z, z2);
        }

        public final WalletLoadingDialog createTopMargin(Context context, float f, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new WalletLoadingDialog(context, 0, f, z, z2, 2, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ WalletLoadingDialog createTop$default(Companion companion, Context context, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return companion.createTop(context, z, z2);
        }

        public final WalletLoadingDialog createTop(Context context, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new WalletLoadingDialog(context, 0, 0.0f, z, z2, 6, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ WalletLoadingDialog createBottom$default(Companion companion, Context context, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return companion.createBottom(context, z, z2);
        }

        public final WalletLoadingDialog createBottom(Context context, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new WalletLoadingDialog(context, 80, 0.0f, z, z2, (DefaultConstructorMarker) null);
        }
    }

    private WalletLoadingDialog(Context context, int i, float f, boolean z, boolean z2) {
        super(context, R.style.WalletLoadingDialog);
        this.f35643a = i;
        this.f35644b = f;
        this.f35645c = z;
        this.f35646d = z2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        WindowManager.LayoutParams attributes;
        super.onCreate(bundle);
        setCancelable(this.f35645c);
        setCanceledOnTouchOutside(this.f35646d);
        Window window = getWindow();
        if (!(window == null || (attributes = window.getAttributes()) == null)) {
            attributes.width = WalletLoadingProgressBar.Companion.getMaxWidth();
            attributes.height = WalletLoadingProgressBar.Companion.getMaxHeight();
            attributes.gravity = this.f35643a;
            attributes.verticalMargin = this.f35644b / ((float) UiUtils.Companion.getScreenHeight());
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        WalletLoadingProgressBar walletLoadingProgressBar = new WalletLoadingProgressBar(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.f35647e = walletLoadingProgressBar;
        setContentView((View) walletLoadingProgressBar);
    }

    public void show() {
        super.show();
        WalletLoadingProgressBar walletLoadingProgressBar = this.f35647e;
        if (walletLoadingProgressBar != null) {
            walletLoadingProgressBar.start();
        }
    }

    public void dismiss() {
        super.dismiss();
        WalletLoadingProgressBar walletLoadingProgressBar = this.f35647e;
        if (walletLoadingProgressBar != null) {
            walletLoadingProgressBar.stop();
        }
    }
}
