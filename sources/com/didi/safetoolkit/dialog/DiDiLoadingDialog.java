package com.didi.safetoolkit.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;

public class DiDiLoadingDialog {

    /* renamed from: a */
    private Context f37276a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f37277b = false;

    /* renamed from: c */
    private DiDiProgressDialog f37278c;

    /* renamed from: d */
    private DialogInterface.OnCancelListener f37279d = new DialogInterface.OnCancelListener() {
        public void onCancel(DialogInterface dialogInterface) {
            boolean unused = DiDiLoadingDialog.this.f37277b = false;
        }
    };

    public DiDiLoadingDialog(Context context) {
        this.f37276a = context;
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
            if (this.f37278c != null) {
                this.f37278c.dismiss();
                this.f37278c = null;
            }
            DiDiProgressDialog diDiProgressDialog = new DiDiProgressDialog(this.f37276a);
            this.f37278c = diDiProgressDialog;
            diDiProgressDialog.setOnCancelListener(this.f37279d);
            this.f37278c.showDialog(z, str);
            this.f37277b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeLoadingDialog() {
        try {
            if (this.f37278c != null) {
                this.f37278c.dismiss();
                this.f37278c = null;
                this.f37276a = null;
            }
        } catch (Exception unused) {
        }
        this.f37278c = null;
        this.f37277b = false;
    }

    public boolean isLoading() {
        return this.f37277b;
    }
}
