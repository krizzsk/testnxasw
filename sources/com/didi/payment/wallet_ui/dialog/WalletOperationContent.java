package com.didi.payment.wallet_ui.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.payment.base.utils.GlideUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001dB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ6\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/dialog/WalletOperationContent;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mIvClose", "Landroid/widget/ImageView;", "getMIvClose", "()Landroid/widget/ImageView;", "mIvImage", "getMIvImage", "mVClose", "Landroid/view/View;", "getMVClose", "()Landroid/view/View;", "config", "", "dialog", "Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "imageUrl", "", "imageClickListener", "Landroid/view/View$OnClickListener;", "onCloseClick", "Builder", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletOperationContent.kt */
public final class WalletOperationContent extends ConstraintLayout {

    /* renamed from: a */
    private final View f35514a;

    /* renamed from: b */
    private final ImageView f35515b;

    /* renamed from: c */
    private final ImageView f35516c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletOperationContent(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletOperationContent(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletOperationContent(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletOperationContent(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletOperationContent(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_dialog_operation, this);
        View findViewById = findViewById(R.id.iv_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_image)");
        this.f35516c = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.iv_close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_close)");
        this.f35515b = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.v_close);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.v_close)");
        this.f35514a = findViewById3;
    }

    public final View getMVClose() {
        return this.f35514a;
    }

    public final ImageView getMIvClose() {
        return this.f35515b;
    }

    public final ImageView getMIvImage() {
        return this.f35516c;
    }

    public static /* synthetic */ void config$default(WalletOperationContent walletOperationContent, WalletDialog walletDialog, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, int i, Object obj) {
        if ((i & 1) != 0) {
            walletDialog = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            onClickListener = null;
        }
        if ((i & 8) != 0) {
            onClickListener2 = null;
        }
        walletOperationContent.config(walletDialog, str, onClickListener, onClickListener2);
    }

    public final void config(WalletDialog walletDialog, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f35514a.setOnClickListener(new View.OnClickListener(walletDialog) {
            public final /* synthetic */ WalletDialog f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                WalletOperationContent.m26885a(View.OnClickListener.this, this.f$1, view);
            }
        });
        GlideUtils.with2load2into(getContext(), str, this.f35516c);
        this.f35516c.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26885a(View.OnClickListener onClickListener, WalletDialog walletDialog, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        if (walletDialog != null) {
            walletDialog.dismiss();
        }
    }

    @Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u001c"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/dialog/WalletOperationContent$Builder;", "", "()V", "dialog", "Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "getDialog", "()Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "setDialog", "(Lcom/didi/payment/wallet_ui/dialog/WalletDialog;)V", "imageClickListener", "Landroid/view/View$OnClickListener;", "getImageClickListener", "()Landroid/view/View$OnClickListener;", "setImageClickListener", "(Landroid/view/View$OnClickListener;)V", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "onCloseClick", "getOnCloseClick", "setOnCloseClick", "build", "Lcom/didi/payment/wallet_ui/dialog/WalletOperationContent;", "context", "Landroid/content/Context;", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletOperationContent.kt */
    public static final class Builder {
        private WalletDialog dialog;
        private View.OnClickListener imageClickListener;
        private String imageUrl;
        private View.OnClickListener onCloseClick;

        public final WalletDialog getDialog() {
            return this.dialog;
        }

        public final void setDialog(WalletDialog walletDialog) {
            this.dialog = walletDialog;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public final View.OnClickListener getOnCloseClick() {
            return this.onCloseClick;
        }

        public final void setOnCloseClick(View.OnClickListener onClickListener) {
            this.onCloseClick = onClickListener;
        }

        public final View.OnClickListener getImageClickListener() {
            return this.imageClickListener;
        }

        public final void setImageClickListener(View.OnClickListener onClickListener) {
            this.imageClickListener = onClickListener;
        }

        public final WalletOperationContent build(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WalletOperationContent walletOperationContent = new WalletOperationContent(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
            walletOperationContent.config(getDialog(), getImageUrl(), getImageClickListener(), getOnCloseClick());
            return walletOperationContent;
        }
    }
}
