package com.didi.component.common.pininput.dialog;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.component.common.widget.pin.PinShowLayout;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class ShowPinDialog {
    public static final int ACTION_CLOSE = 4;
    public static final int ACTION_NEGATIVE = 1;
    public static final int ACTION_NEUTRAL = 3;
    public static final int ACTION_POSITIVE = 2;

    /* renamed from: a */
    private final int f13510a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BusinessContext f13511b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AlertDialogFragment f13512c;

    /* renamed from: d */
    private boolean f13513d;

    public interface DialogListener {
        void onAction(int i);
    }

    public boolean cancelable() {
        return false;
    }

    public ShowPinDialog(int i) {
        this.f13510a = i;
    }

    public int getId() {
        return this.f13510a;
    }

    public void show() {
        this.f13513d = true;
        this.f13511b.getNavigation().showDialog(this.f13512c);
    }

    public boolean isShowing() {
        return this.f13513d;
    }

    public void dismiss() {
        this.f13511b.getNavigation().dismissDialog(this.f13512c);
        this.f13513d = false;
    }

    public void update(ShowPinDialogInfo showPinDialogInfo) {
        if (showPinDialogInfo != null) {
            m11292a(showPinDialogInfo, this.f13512c.getView());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11292a(ShowPinDialogInfo showPinDialogInfo, View view) {
        if (view != null) {
            ((PinShowLayout) view.findViewById(R.id.dialog_pin_show_layout)).showPin(showPinDialogInfo.getPin());
            ((TextView) view.findViewById(R.id.dialog_title)).setText(showPinDialogInfo.getTitle());
        }
    }

    public static final class DialogBuilder {
        private BusinessContext mBizCtx;
        private ShowPinDialogInfo mDialogInfo;
        /* access modifiers changed from: private */
        public DialogListener mListener;

        public DialogBuilder(BusinessContext businessContext) {
            this.mBizCtx = businessContext;
        }

        public DialogBuilder setDialogInfo(ShowPinDialogInfo showPinDialogInfo) {
            this.mDialogInfo = showPinDialogInfo;
            return this;
        }

        public DialogBuilder setListener(DialogListener dialogListener) {
            this.mListener = dialogListener;
            return this;
        }

        public ShowPinDialog build() {
            ShowPinDialog showPinDialog = new ShowPinDialog(this.mDialogInfo.getDialogId());
            BusinessContext unused = showPinDialog.f13511b = this.mBizCtx;
            View inflate = LayoutInflater.from(this.mBizCtx.getContext()).inflate(R.layout.global_dialog_show_pin, (ViewGroup) null);
            AlertDialogFragment unused2 = showPinDialog.f13512c = new AlertDialogFragment.Builder(this.mBizCtx.getContext()).setContentView(inflate).setPositiveButton((CharSequence) getButtonString(), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    DialogBuilder.this.mListener.onAction(4);
                }
            }).setCancelable(this.mDialogInfo.isCancelable()).create();
            showPinDialog.m11292a(this.mDialogInfo, inflate);
            return showPinDialog;
        }

        private SpannableString getButtonString() {
            SpannableString spannableString = new SpannableString(this.mDialogInfo.getButton());
            spannableString.setSpan(new ForegroundColorSpan(this.mBizCtx.getContext().getResources().getColor(R.color.color_FEA330)), 0, this.mDialogInfo.getButton().length(), 33);
            return spannableString;
        }
    }
}
