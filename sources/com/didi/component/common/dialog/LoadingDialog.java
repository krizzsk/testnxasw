package com.didi.component.common.dialog;

import android.content.DialogInterface;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.view.dialog.ProgressDialogFragment;

class LoadingDialog implements IDialog {

    /* renamed from: a */
    private int f13405a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BusinessContext f13406b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CancelableProgressDialogFragment f13407c;

    /* renamed from: d */
    private boolean f13408d;

    private LoadingDialog(int i) {
        this.f13408d = false;
        this.f13405a = i;
    }

    public int getId() {
        return this.f13405a;
    }

    public void show() {
        this.f13408d = true;
        this.f13406b.getNavigation().showDialog(this.f13407c);
    }

    public boolean isShowing() {
        return this.f13408d;
    }

    public void dismiss() {
        this.f13406b.getNavigation().dismissDialog(this.f13407c);
        this.f13408d = false;
    }

    public void update(DialogInfo dialogInfo) {
        if (dialogInfo instanceof LoadingDialogInfo) {
            LoadingDialogInfo loadingDialogInfo = (LoadingDialogInfo) dialogInfo;
            this.f13407c.setContent(loadingDialogInfo.f13409a, loadingDialogInfo.cancelable);
        }
    }

    public boolean cancelable() {
        return this.f13407c.isCancelable();
    }

    public static final class DialogBuilder {
        private BusinessContext mBizCtx;
        private LoadingDialogInfo mDialogInfo;
        private IDialog.DialogListener mListener;

        public DialogBuilder(BusinessContext businessContext) {
            this.mBizCtx = businessContext;
        }

        public void setDialogInfo(LoadingDialogInfo loadingDialogInfo) {
            this.mDialogInfo = loadingDialogInfo;
        }

        public void setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public LoadingDialog build() {
            LoadingDialog loadingDialog = new LoadingDialog(this.mDialogInfo.dialogId);
            BusinessContext unused = loadingDialog.f13406b = this.mBizCtx;
            CancelableProgressDialogFragment unused2 = loadingDialog.f13407c = new CancelableProgressDialogFragment();
            loadingDialog.f13407c.setContent(this.mDialogInfo.f13409a, this.mDialogInfo.cancelable);
            loadingDialog.f13407c.setCancelable(this.mDialogInfo.cancelable);
            loadingDialog.f13407c.setDialogListener(this.mListener);
            return loadingDialog;
        }
    }

    public static class CancelableProgressDialogFragment extends ProgressDialogFragment {
        private IDialog.DialogListener mListener;

        public void setDialogListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public void onCancel(DialogInterface dialogInterface) {
            IDialog.DialogListener dialogListener = this.mListener;
            if (dialogListener != null) {
                dialogListener.onAction(1);
            }
        }
    }
}
