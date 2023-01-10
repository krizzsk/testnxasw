package com.didi.component.service.activity.risk.dialog;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.view.dialog.AlertDialogFragment;

public class NormalDialog implements IDialog {

    /* renamed from: a */
    private int f17586a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AlertDialogFragment f17587b;

    /* renamed from: c */
    private FragmentActivity f17588c;

    /* renamed from: d */
    private boolean f17589d;

    public void update(DialogInfo dialogInfo) {
    }

    private NormalDialog(FragmentActivity fragmentActivity, int i) {
        this.f17589d = false;
        this.f17586a = i;
        this.f17588c = fragmentActivity;
    }

    public int getId() {
        return this.f17586a;
    }

    public void show() {
        FragmentActivity fragmentActivity = this.f17588c;
        if (fragmentActivity != null && fragmentActivity.getSupportFragmentManager() != null) {
            this.f17589d = true;
            AlertDialogFragment alertDialogFragment = this.f17587b;
            FragmentManager supportFragmentManager = this.f17588c.getSupportFragmentManager();
            alertDialogFragment.show(supportFragmentManager, this.f17586a + "");
        }
    }

    public boolean isShowing() {
        return this.f17589d;
    }

    public void dismiss() {
        this.f17589d = false;
        this.f17587b.dismissAllowingStateLoss();
    }

    public boolean cancelable() {
        return this.f17587b.isCancelable();
    }

    public static class DialogBuilder {
        /* access modifiers changed from: private */
        public Integer mActionHappend;
        private FragmentActivity mContext;
        private NormalDialogInfo mDialogInfo;
        private AlertDialogFragment.OnDismissListener mDismissListener = new AlertDialogFragment.OnDismissListener() {
            public void onDismiss(AlertDialogFragment alertDialogFragment) {
                if (DialogBuilder.this.mActionHappend == null) {
                    DialogBuilder.this.handleOnClick(alertDialogFragment, 4);
                }
            }
        };
        private IDialog.DialogListener mListener;
        private AlertDialogFragment.OnClickListener mNegativeListener = new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DialogBuilder.this.handleOnClick(alertDialogFragment, 1);
            }
        };
        private AlertDialogFragment.OnClickListener mNeutralListener = new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DialogBuilder.this.handleOnClick(alertDialogFragment, 3);
            }
        };
        private AlertDialogFragment.OnClickListener mPositiveListener = new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DialogBuilder.this.handleOnClick(alertDialogFragment, 2);
            }
        };

        public DialogBuilder(FragmentActivity fragmentActivity) {
            this.mContext = fragmentActivity;
        }

        public DialogBuilder setDialogInfo(NormalDialogInfo normalDialogInfo) {
            this.mDialogInfo = normalDialogInfo;
            return this;
        }

        public DialogBuilder setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
            return this;
        }

        public NormalDialog build() {
            NormalDialog normalDialog = new NormalDialog(this.mContext, this.mDialogInfo.dialogId);
            AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this.mContext);
            builder.setCancelable(this.mDialogInfo.f17599v);
            builder.setIconVisible(this.mDialogInfo.f17598u);
            builder.setCloseVisible(this.mDialogInfo.f17600w);
            builder.setOnDismissListener(this.mDismissListener);
            if (this.mDialogInfo.f17590m != 0) {
                builder.setIcon(this.mDialogInfo.f17590m);
            }
            if (this.mDialogInfo.f17591n != null) {
                builder.setIcon(this.mDialogInfo.f17591n);
            }
            if (this.mDialogInfo.f17592o != null) {
                builder.setIcon(this.mDialogInfo.f17592o);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f17593p)) {
                builder.setTitle(this.mDialogInfo.f17593p);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f17594q)) {
                builder.setMessage(this.mDialogInfo.f17594q);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f17595r)) {
                builder.setPositiveButton(this.mDialogInfo.f17595r, this.mPositiveListener);
                builder.setPositiveButtonDefault();
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f17597t)) {
                builder.setNegativeButton(this.mDialogInfo.f17597t, this.mNegativeListener);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f17596s)) {
                builder.setNeutralButton(this.mDialogInfo.f17596s, this.mNeutralListener);
            }
            AlertDialogFragment unused = normalDialog.f17587b = builder.create();
            return normalDialog;
        }

        /* access modifiers changed from: private */
        public void handleOnClick(AlertDialogFragment alertDialogFragment, int i) {
            IDialog.DialogListener dialogListener = this.mListener;
            if (dialogListener != null) {
                dialogListener.onAction(i);
            }
            try {
                alertDialogFragment.dismissAllowingStateLoss();
            } catch (Exception unused) {
            }
        }
    }
}
