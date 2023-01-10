package com.didi.component.common.dialog;

import android.content.DialogInterface;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.common.dialog.ToastDialogInfo;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;

public class ToastDialog implements IDialog {

    /* renamed from: a */
    private int f13429a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CustomToastDialog f13430b;

    private ToastDialog(int i) {
        this.f13429a = i;
    }

    public int getId() {
        return this.f13429a;
    }

    public void show() {
        CustomToastDialog customToastDialog = this.f13430b;
        if (customToastDialog != null && !customToastDialog.isShowing()) {
            SystemUtils.showDialog(this.f13430b);
        }
    }

    public boolean isShowing() {
        CustomToastDialog customToastDialog = this.f13430b;
        return customToastDialog != null && customToastDialog.isShowing();
    }

    public void dismiss() {
        CustomToastDialog customToastDialog = this.f13430b;
        if (customToastDialog != null && customToastDialog.isShowing()) {
            this.f13430b.dismiss();
        }
    }

    public void update(DialogInfo dialogInfo) {
        if (dialogInfo instanceof ToastDialogInfo) {
            ToastDialogInfo toastDialogInfo = (ToastDialogInfo) dialogInfo;
            this.f13430b.setCancelable(toastDialogInfo.cancelable);
            this.f13430b.setCanceledOnTouchOutside(toastDialogInfo.cancelable);
            if (toastDialogInfo.f13431a != null) {
                this.f13430b.setIcon(toastDialogInfo.f13431a);
            } else {
                ToastDialogInfo.IconType iconType = toastDialogInfo.f13432b;
            }
            this.f13430b.setMessage(toastDialogInfo.f13433c);
        }
    }

    public boolean cancelable() {
        return this.f13430b.isCancelable();
    }

    public static class DialogBuilder {
        private BusinessContext mBizCtx;
        private ToastDialogInfo mDialogInfo;
        /* access modifiers changed from: private */
        public IDialog.DialogListener mListener;

        public DialogBuilder(BusinessContext businessContext) {
            this.mBizCtx = businessContext;
        }

        public void setDialogInfo(ToastDialogInfo toastDialogInfo) {
            this.mDialogInfo = toastDialogInfo;
        }

        public void setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public ToastDialog build() {
            ToastDialog toastDialog = new ToastDialog(this.mDialogInfo.dialogId);
            CustomToastDialog unused = toastDialog.f13430b = new CustomToastDialog(this.mBizCtx.getContext());
            toastDialog.f13430b.setCancelable(this.mDialogInfo.cancelable);
            toastDialog.f13430b.setCanceledOnTouchOutside(this.mDialogInfo.cancelable);
            toastDialog.f13430b.setMessage(this.mDialogInfo.f13433c);
            toastDialog.f13430b.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (DialogBuilder.this.mListener != null) {
                        DialogBuilder.this.mListener.onAction(-1);
                    }
                }
            });
            return toastDialog;
        }
    }
}
