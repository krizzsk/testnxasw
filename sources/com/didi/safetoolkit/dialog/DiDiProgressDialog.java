package com.didi.safetoolkit.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;

public class DiDiProgressDialog extends Dialog {

    /* renamed from: a */
    private Context f37280a;

    /* renamed from: b */
    private TextView f37281b;

    public DiDiProgressDialog(Context context) {
        super(context, R.style.Dialog);
        this.f37280a = context;
        m28106a();
    }

    /* renamed from: a */
    private void m28106a() {
        View inflate = View.inflate(this.f37280a, R.layout.sf_progress_dialog_layout, (ViewGroup) null);
        super.setContentView(inflate);
        this.f37281b = (TextView) inflate.findViewById(R.id.loading_text);
    }

    public void showDialog(boolean z) {
        showDialog(z, SfStringGetter.getString(R.string.sf_loading));
    }

    public void showDialog(boolean z, String str) {
        if (!(getContext() instanceof Activity) || !((Activity) getContext()).isFinishing()) {
            try {
                setCancelable(z);
                this.f37281b.setText(str);
                super.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
