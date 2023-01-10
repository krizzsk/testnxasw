package com.didiglobal.pay.paysecure.p204ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.net.pojo.response.Button;
import com.didiglobal.pay.paysecure.net.pojo.response.ErrorData;
import com.didiglobal.pay.paysecure.omega.OmegaUtil;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0014J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u001c\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/ui/view/ErrorDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "errorData", "Lcom/didiglobal/pay/paysecure/net/pojo/response/ErrorData;", "sourcePageId", "", "(Landroid/content/Context;Lcom/didiglobal/pay/paysecure/net/pojo/response/ErrorData;I)V", "listener", "Lcom/didiglobal/pay/paysecure/ui/view/ErrorDialogCallback;", "mBody", "Landroid/widget/TextView;", "mCancelBtn", "mClose", "Landroid/view/View;", "mConfirmBtn", "mTitle", "getSourcePageId", "()I", "dismiss", "", "init", "onStart", "setCancelable", "flag", "", "show", "showDialog", "Companion", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.view.ErrorDialog */
/* compiled from: ErrorDialog.kt */
public final class ErrorDialog extends Dialog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f52969a;

    /* renamed from: b */
    private TextView f52970b;

    /* renamed from: c */
    private TextView f52971c;

    /* renamed from: d */
    private TextView f52972d;

    /* renamed from: e */
    private View f52973e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ErrorDialogCallback f52974f;

    /* renamed from: g */
    private final ErrorData f52975g;

    /* renamed from: h */
    private final int f52976h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ErrorDialog(Context context, ErrorData errorData, int i) {
        super(context, R.style.CustomDialog);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(errorData, "errorData");
        this.f52975g = errorData;
        this.f52976h = i;
        m39691b();
    }

    public final int getSourcePageId() {
        return this.f52976h;
    }

    public final void show(ErrorDialogCallback errorDialogCallback) {
        Intrinsics.checkParameterIsNotNull(errorDialogCallback, "listener");
        this.f52974f = errorDialogCallback;
        m39690a();
    }

    /* renamed from: a */
    private final void m39690a() {
        if (getContext() instanceof Activity) {
            Companion companion = Companion;
            Context context = getContext();
            if (context == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
            } else if (companion.isDestroyed((Activity) context)) {
                return;
            }
        }
        try {
            super.show();
            if (!TextUtils.isEmpty(this.f52975g.getEventId())) {
                new OmegaUtil(this.f52975g.getEventId()).add(OmegaUtilKt.ENTRANCE_PAGE_ID, Integer.valueOf(this.f52976h)).send();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    /* renamed from: b */
    private final void m39691b() {
        setContentView(R.layout.dialog_pay_secure_error);
        this.f52969a = (TextView) findViewById(R.id.tv_pay_secure_dialog_title);
        this.f52970b = (TextView) findViewById(R.id.tv_pay_secure_dialog_body);
        this.f52971c = (TextView) findViewById(R.id.btn_pay_secure_positive);
        this.f52972d = (TextView) findViewById(R.id.btn_pay_secure_negative);
        TextView textView = this.f52971c;
        if (textView != null) {
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            textView.setBackground(ResourcesCompat.getDrawable(context.getResources(), PaySecure.INSTANCE.getConfig().getTheme().getPositiveBtnBg(), (Resources.Theme) null));
        }
        TextView textView2 = this.f52971c;
        if (textView2 != null) {
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            textView2.setTextColor(ResourcesCompat.getColor(context2.getResources(), PaySecure.INSTANCE.getConfig().getTheme().getPositiveBtnTextColor(), (Resources.Theme) null));
        }
        TextView textView3 = this.f52972d;
        if (textView3 != null) {
            Context context3 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context3, "context");
            textView3.setBackground(ResourcesCompat.getDrawable(context3.getResources(), PaySecure.INSTANCE.getConfig().getTheme().getNegativeBtnBg(), (Resources.Theme) null));
        }
        TextView textView4 = this.f52972d;
        if (textView4 != null) {
            Context context4 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context4, "context");
            textView4.setTextColor(ResourcesCompat.getColor(context4.getResources(), PaySecure.INSTANCE.getConfig().getTheme().getNegativeBtnTextColor(), (Resources.Theme) null));
        }
        View view = this.f52973e;
        if (view != null) {
            view.setOnClickListener(new ErrorDialog$init$1(this));
        }
        TextView textView5 = this.f52969a;
        if (textView5 != null) {
            textView5.setText(this.f52975g.getTitle());
        }
        if (!TextUtils.isEmpty(this.f52975g.getBody())) {
            TextView textView6 = this.f52970b;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            TextView textView7 = this.f52970b;
            if (textView7 != null) {
                textView7.setText(this.f52975g.getBody());
            }
        }
        if (this.f52975g.getButtons() != null) {
            Button[] buttons = this.f52975g.getButtons();
            if (buttons == null) {
                buttons = new Button[0];
            }
            for (Button button : buttons) {
                if (Intrinsics.areEqual((Object) button.getButtonType(), (Object) "positive")) {
                    TextView textView8 = this.f52971c;
                    if (textView8 != null) {
                        textView8.setText(button.getText());
                    }
                    TextView textView9 = this.f52971c;
                    if (textView9 != null) {
                        textView9.setOnClickListener(new ErrorDialog$init$2(this, button));
                    }
                } else if (Intrinsics.areEqual((Object) button.getButtonType(), (Object) "negative")) {
                    TextView textView10 = this.f52972d;
                    if (textView10 != null) {
                        textView10.setText(button.getText());
                    }
                    TextView textView11 = this.f52972d;
                    if (textView11 != null) {
                        textView11.setVisibility(0);
                    }
                    TextView textView12 = this.f52972d;
                    if (textView12 != null) {
                        textView12.setOnClickListener(new ErrorDialog$init$3(this, button));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window == null) {
            Intrinsics.throwNpe();
        }
        window.setLayout(-1, -2);
        Window window2 = getWindow();
        if (window2 == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(window2, "window!!");
        WindowManager.LayoutParams attributes = window2.getAttributes();
        attributes.gravity = 80;
        Window window3 = getWindow();
        if (window3 == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(window3, "window!!");
        window3.setAttributes(attributes);
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/ui/view/ErrorDialog$Companion;", "", "()V", "isDestroyed", "", "activity", "Landroid/app/Activity;", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* renamed from: com.didiglobal.pay.paysecure.ui.view.ErrorDialog$Companion */
    /* compiled from: ErrorDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean isDestroyed(Activity activity) {
            return activity.isFinishing() || activity.isDestroyed();
        }
    }
}
