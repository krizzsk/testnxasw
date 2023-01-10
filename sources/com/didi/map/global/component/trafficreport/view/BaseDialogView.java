package com.didi.map.global.component.trafficreport.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public abstract class BaseDialogView implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    protected BottomSheetDialog mBottomSheetDialog;
    protected View mContentView;
    protected final Context mContext;

    public void hideDelayed(long j) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
    }

    public void onShow(DialogInterface dialogInterface) {
    }

    public BaseDialogView(Context context) {
        this.mContext = context;
    }

    public void show() {
        BottomSheetDialog bottomSheetDialog = this.mBottomSheetDialog;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.hide();
        } else {
            BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(this.mContext);
            this.mBottomSheetDialog = bottomSheetDialog2;
            bottomSheetDialog2.setContentView(this.mContentView);
            if (this.mBottomSheetDialog.getBehavior() != null) {
                this.mBottomSheetDialog.getBehavior().setState(3);
            }
            ((View) this.mContentView.getParent()).setBackgroundColor(this.mContext.getResources().getColor(17170445));
            this.mBottomSheetDialog.setOnShowListener(this);
            this.mBottomSheetDialog.setOnDismissListener(this);
        }
        SystemUtils.showDialog(this.mBottomSheetDialog);
    }

    public void hide() {
        SystemUtils.log(3, "BaseDialogView", " hide: hide: ", (Throwable) null, "com.didi.map.global.component.trafficreport.view.BaseDialogView", 46);
        try {
            if (this.mBottomSheetDialog != null) {
                this.mBottomSheetDialog.dismiss();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isShowing() {
        BottomSheetDialog bottomSheetDialog = this.mBottomSheetDialog;
        return bottomSheetDialog != null && bottomSheetDialog.isShowing();
    }

    public Dialog getDialog() {
        return this.mBottomSheetDialog;
    }
}
