package com.didi.component.service.activity.risk.dialog;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.view.dialog.ProgressDialogFragment;

public class LoadingDialog implements IDialog {

    /* renamed from: a */
    private int f17581a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FragmentActivity f17582b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CancelableProgressDialogFragment f17583c;

    /* renamed from: d */
    private boolean f17584d;

    private LoadingDialog(int i) {
        this.f17584d = false;
        this.f17581a = i;
    }

    public int getId() {
        return this.f17581a;
    }

    public void show() {
        FragmentActivity fragmentActivity = this.f17582b;
        if (fragmentActivity != null && fragmentActivity.getSupportFragmentManager() != null) {
            this.f17584d = true;
            CancelableProgressDialogFragment cancelableProgressDialogFragment = this.f17583c;
            FragmentManager supportFragmentManager = this.f17582b.getSupportFragmentManager();
            cancelableProgressDialogFragment.show(supportFragmentManager, this.f17581a + "");
        }
    }

    public boolean isShowing() {
        return this.f17584d;
    }

    public void dismiss() {
        this.f17584d = false;
        this.f17583c.dismissAllowingStateLoss();
    }

    public void update(DialogInfo dialogInfo) {
        if (dialogInfo instanceof LoadingDialogInfo) {
            LoadingDialogInfo loadingDialogInfo = (LoadingDialogInfo) dialogInfo;
            this.f17583c.setContent(loadingDialogInfo.getMessage(), loadingDialogInfo.cancelable);
        }
    }

    public boolean cancelable() {
        return this.f17583c.isCancelable();
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

    public static final class DialogBuilder {
        private FragmentActivity mContext;
        private LoadingDialogInfo mDialogInfo;
        private IDialog.DialogListener mListener;

        public DialogBuilder(FragmentActivity fragmentActivity) {
            this.mContext = fragmentActivity;
        }

        public void setDialogInfo(LoadingDialogInfo loadingDialogInfo) {
            this.mDialogInfo = loadingDialogInfo;
        }

        public void setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public LoadingDialog build() {
            LoadingDialog loadingDialog = new LoadingDialog(this.mDialogInfo.dialogId);
            FragmentActivity unused = loadingDialog.f17582b = this.mContext;
            CancelableProgressDialogFragment unused2 = loadingDialog.f17583c = new CancelableProgressDialogFragment();
            loadingDialog.f17583c.setContent(this.mDialogInfo.getMessage(), this.mDialogInfo.cancelable);
            loadingDialog.f17583c.setCancelable(this.mDialogInfo.cancelable);
            loadingDialog.f17583c.setDialogListener(this.mListener);
            return loadingDialog;
        }
    }
}
