package com.didi.sdk.sidebar.history;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.config.commonconfig.p150sp.CommonConfigSp;
import com.taxis99.R;

public class InvoiceFragmentDialog extends DialogFragment {

    /* renamed from: a */
    private TextView f40050a;

    /* renamed from: b */
    private EditText f40051b;

    /* renamed from: c */
    private TextView f40052c;

    /* renamed from: d */
    private Button f40053d;

    /* renamed from: e */
    private View.OnClickListener f40054e;

    /* renamed from: f */
    private Spanned f40055f;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 16973939);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.guarana_invoice_dlg, (ViewGroup) null);
        this.f40050a = (TextView) inflate.findViewById(R.id.content);
        EditText editText = (EditText) inflate.findViewById(R.id.email);
        this.f40051b = editText;
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(128)});
        this.f40050a.setText(this.f40055f);
        TextView textView = (TextView) inflate.findViewById(R.id.cancel);
        this.f40052c = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                InvoiceFragmentDialog.this.dismiss();
            }
        });
        Button button = (Button) inflate.findViewById(R.id.send);
        this.f40053d = button;
        button.setOnClickListener(this.f40054e);
        this.f40051b.setText(CommonConfigSp.getInstance().get(CommonConfigSp.KEY_COMMON_LASTEMAIL, ""));
        return inflate;
    }

    public void setContent(String str) {
        Spanned fromHtml = Html.fromHtml(str);
        this.f40055f = fromHtml;
        TextView textView = this.f40050a;
        if (textView != null) {
            textView.setText(fromHtml);
        }
    }

    public String getEmail() {
        return this.f40051b.getText().toString();
    }

    public void setRightOnclickListener(View.OnClickListener onClickListener) {
        this.f40054e = onClickListener;
    }
}
