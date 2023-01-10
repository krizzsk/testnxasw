package com.didi.component.common.dialog;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.app.BusinessContext;

public class BlockDialog implements IDialog {

    /* renamed from: a */
    private final int f13358a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BusinessContext f13359b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public BlockAlertDialogFragment f13360c;

    /* renamed from: d */
    private boolean f13361d;

    public boolean cancelable() {
        return false;
    }

    private BlockDialog(int i) {
        this.f13358a = i;
    }

    public int getId() {
        return this.f13358a;
    }

    public void show() {
        this.f13361d = true;
        this.f13359b.getNavigation().showDialog(this.f13360c);
    }

    public boolean isShowing() {
        return this.f13361d;
    }

    public void dismiss() {
        this.f13359b.getNavigation().dismissDialog(this.f13360c);
        this.f13361d = false;
    }

    public void update(DialogInfo dialogInfo) {
        this.f13360c.updateView((BlockDialogInfo) dialogInfo);
    }

    public static final class DialogBuilder {
        private BusinessContext mBizCtx;
        private BlockDialogInfo mDialogInfo;
        /* access modifiers changed from: private */
        public IDialog.DialogListener mListener;

        public DialogBuilder(BusinessContext businessContext) {
            this.mBizCtx = businessContext;
        }

        public void setDialogInfo(BlockDialogInfo blockDialogInfo) {
            this.mDialogInfo = blockDialogInfo;
        }

        public void setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public BlockDialog build() {
            BlockDialog blockDialog = new BlockDialog(this.mDialogInfo.dialogId);
            BusinessContext unused = blockDialog.f13359b = this.mBizCtx;
            BlockAlertDialogFragment blockAlertDialogFragment = new BlockAlertDialogFragment();
            blockAlertDialogFragment.setCancelable(this.mDialogInfo.cancelable);
            blockAlertDialogFragment.setNegativeClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DialogBuilder.this.mListener.onAction(1);
                }
            });
            blockAlertDialogFragment.setPositiveClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DialogBuilder.this.mListener.onAction(2);
                }
            });
            blockAlertDialogFragment.setDialogInfo(this.mDialogInfo);
            BlockAlertDialogFragment unused2 = blockDialog.f13360c = blockAlertDialogFragment;
            return blockDialog;
        }
    }
}
