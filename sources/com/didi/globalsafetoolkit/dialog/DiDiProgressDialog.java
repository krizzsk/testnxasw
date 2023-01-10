package com.didi.globalsafetoolkit.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.globalsafetoolkit.util.SfStringGetter;
import com.taxis99.R;

public class DiDiProgressDialog extends Dialog {

    /* renamed from: a */
    private Context f25170a;

    /* renamed from: b */
    private TextView f25171b;

    public DiDiProgressDialog(Context context) {
        super(context, R.style.Dialog);
        this.f25170a = context;
        m20119a();
    }

    /* renamed from: a */
    private void m20119a() {
        View inflate = View.inflate(this.f25170a, R.layout.sf_progress_dialog_layout, (ViewGroup) null);
        super.setContentView(inflate);
        this.f25171b = (TextView) inflate.findViewById(R.id.loading_text);
    }

    public void showDialog(boolean z) {
        showDialog(z, SfStringGetter.getString(R.string.sf_loading));
    }

    public void showDialog(boolean z, String str) {
        if (!(getContext() instanceof Activity) || !((Activity) getContext()).isFinishing()) {
            try {
                setCancelable(z);
                this.f25171b.setText(str);
                super.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
