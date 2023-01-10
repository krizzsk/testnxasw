package com.didi.sdk.global.cardexpire;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class CardExpireInterceptDialog {

    /* renamed from: a */
    private final Context f38855a;

    /* renamed from: b */
    private final String f38856b;

    /* renamed from: c */
    private final String f38857c;

    /* renamed from: d */
    private final View.OnClickListener f38858d;

    /* renamed from: e */
    private final View.OnClickListener f38859e;

    /* renamed from: f */
    private Dialog f38860f;

    CardExpireInterceptDialog(Context context, String str, String str2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f38855a = context;
        this.f38856b = str;
        this.f38857c = str2;
        this.f38858d = onClickListener;
        this.f38859e = onClickListener2;
        m29229a();
    }

    /* renamed from: a */
    private void m29229a() {
        View inflate = LayoutInflater.from(this.f38855a).inflate(R.layout.card_expire_intercept_dialog, (ViewGroup) null, false);
        GlideUtils.with2load2into(this.f38855a, this.f38856b, (ImageView) mo98436a(inflate, R.id.iv_card_icon));
        ((TextView) mo98436a(inflate, R.id.tv_card_no)).setText(this.f38857c);
        m29230a(inflate);
        mo98436a(inflate, R.id.tv_update_card).setOnClickListener(new ClickDialogDismissWrap(this.f38860f, this.f38858d));
        mo98436a(inflate, R.id.tv_change_payment_method).setOnClickListener(new ClickDialogDismissWrap(this.f38860f, this.f38859e));
    }

    private static class ClickDialogDismissWrap implements View.OnClickListener {
        private final View.OnClickListener clickListener;
        private final Dialog dialog;

        public ClickDialogDismissWrap(Dialog dialog2, View.OnClickListener onClickListener) {
            this.dialog = dialog2;
            this.clickListener = onClickListener;
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            Dialog dialog2 = this.dialog;
            if (dialog2 != null) {
                dialog2.dismiss();
            }
            View.OnClickListener onClickListener = this.clickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* renamed from: a */
    private void m29230a(View view) {
        AlertDialog create = new AlertDialog.Builder(this.f38855a).setCancelable(false).setView(view).create();
        this.f38860f = create;
        Window window = create.getWindow();
        window.setGravity(80);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setWindowAnimations(R.style.drawer_dialog_slide_animation);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.alpha = 1.0f;
        attributes.dimAmount = 0.2f;
        window.setBackgroundDrawable((Drawable) null);
        window.setAttributes(attributes);
    }

    public void show() {
        SystemUtils.showDialog(this.f38860f);
    }

    public void dismiss() {
        this.f38860f.dismiss();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <T extends View> T mo98436a(View view, int i) {
        return view.findViewById(i);
    }

    public static final class Builder {
        private String cardNo;
        private View.OnClickListener changePaymentMethodListener;
        private final Context context;
        private String icon;
        private View.OnClickListener updateCardListener;

        public Builder(Context context2) {
            this.context = context2;
        }

        public Builder setIcon(String str) {
            this.icon = str;
            return this;
        }

        public Builder setCardNo(String str) {
            this.cardNo = str;
            return this;
        }

        public Builder setUpdateCardListener(View.OnClickListener onClickListener) {
            this.updateCardListener = onClickListener;
            return this;
        }

        public Builder setChangePaymentMethodListener(View.OnClickListener onClickListener) {
            this.changePaymentMethodListener = onClickListener;
            return this;
        }

        public CardExpireInterceptDialog builder() {
            return new CardExpireInterceptDialog(this.context, this.icon, this.cardNo, this.updateCardListener, this.changePaymentMethodListener);
        }
    }
}
