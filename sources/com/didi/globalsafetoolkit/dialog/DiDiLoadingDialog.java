package com.didi.globalsafetoolkit.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.didi.globalsafetoolkit.util.SfStringGetter;
import com.taxis99.R;

public class DiDiLoadingDialog {

    /* renamed from: a */
    private Context f25166a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f25167b = false;

    /* renamed from: c */
    private DiDiProgressDialog f25168c;

    /* renamed from: d */
    private DialogInterface.OnCancelListener f25169d = new DialogInterface.OnCancelListener() {
        public void onCancel(DialogInterface dialogInterface) {
            boolean unused = DiDiLoadingDialog.this.f25167b = false;
        }
    };

    public DiDiLoadingDialog(Context context) {
        this.f25166a = context;
    }

    public void showLoadingDialog(boolean z) {
        try {
            showLoadingDialog(z, SfStringGetter.getString(R.string.sf_loading));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showLoadingDialog(boolean z, String str) {
        try {
            if (this.f25168c != null) {
                this.f25168c.dismiss();
                this.f25168c = null;
            }
            DiDiProgressDialog diDiProgressDialog = new DiDiProgressDialog(this.f25166a);
            this.f25168c = diDiProgressDialog;
            diDiProgressDialog.setOnCancelListener(this.f25169d);
            this.f25168c.showDialog(z, str);
            this.f25167b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeLoadingDialog() {
        try {
            if (this.f25168c != null) {
                this.f25168c.dismiss();
                this.f25168c = null;
                this.f25166a = null;
            }
        } catch (Exception unused) {
        }
        this.f25168c = null;
        this.f25167b = false;
    }

    public boolean isLoading() {
        return this.f25167b;
    }
}
