package com.didi.component.common.dialog;

import android.text.TextUtils;
import android.view.View;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.view.dialog.AlertDialogFragment;

class NormalDialog implements IDialog {

    /* renamed from: a */
    private int f13413a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AlertDialogFragment f13414b;

    /* renamed from: c */
    private BusinessContext f13415c;

    /* renamed from: d */
    private boolean f13416d;

    public void update(DialogInfo dialogInfo) {
    }

    private NormalDialog(BusinessContext businessContext, int i) {
        this.f13416d = false;
        this.f13413a = i;
        this.f13415c = businessContext;
    }

    public int getId() {
        return this.f13413a;
    }

    public void show() {
        this.f13416d = true;
        this.f13415c.getNavigation().showDialog(this.f13414b);
    }

    public boolean isShowing() {
        return this.f13416d;
    }

    public void dismiss() {
        this.f13415c.getNavigation().dismissDialog(this.f13414b);
        this.f13416d = false;
    }

    public boolean cancelable() {
        return this.f13414b.isCancelable();
    }

    public static class DialogBuilder {
        /* access modifiers changed from: private */
        public Integer mActionHappend;
        private BusinessContext mBizCtx;
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

        public DialogBuilder(BusinessContext businessContext) {
            this.mBizCtx = businessContext;
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
            NormalDialog normalDialog = new NormalDialog(this.mBizCtx, this.mDialogInfo.dialogId);
            AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this.mBizCtx.getContext());
            builder.setCancelable(this.mDialogInfo.f13426j);
            builder.setIconVisible(this.mDialogInfo.f13425i);
            builder.setCloseVisible(this.mDialogInfo.f13427k);
            builder.setOnDismissListener(this.mDismissListener);
            builder.setSupprtMullineTitle(this.mDialogInfo.f13428l);
            if (this.mDialogInfo.f13417a != 0) {
                builder.setIcon(this.mDialogInfo.f13417a);
            }
            if (this.mDialogInfo.f13418b != null) {
                builder.setIcon(this.mDialogInfo.f13418b);
            }
            if (this.mDialogInfo.f13419c != null) {
                builder.setIcon(this.mDialogInfo.f13419c);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f13420d)) {
                builder.setTitle(this.mDialogInfo.f13420d);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f13421e)) {
                builder.setMessage(this.mDialogInfo.f13421e);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f13422f)) {
                builder.setPositiveButton(this.mDialogInfo.f13422f, this.mPositiveListener);
                builder.setPositiveButtonDefault();
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f13424h)) {
                builder.setNegativeButton(this.mDialogInfo.f13424h, this.mNegativeListener);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f13423g)) {
                builder.setNeutralButton(this.mDialogInfo.f13423g, this.mNeutralListener);
            }
            AlertDialogFragment unused = normalDialog.f13414b = builder.create();
            return normalDialog;
        }

        /* access modifiers changed from: private */
        public void handleOnClick(AlertDialogFragment alertDialogFragment, int i) {
            this.mActionHappend = Integer.valueOf(i);
            IDialog.DialogListener dialogListener = this.mListener;
            if (dialogListener != null) {
                dialogListener.onAction(i);
            }
            if (alertDialogFragment != null && alertDialogFragment.isAdded()) {
                this.mBizCtx.getNavigation().dismissDialog(alertDialogFragment);
            }
        }
    }
}
