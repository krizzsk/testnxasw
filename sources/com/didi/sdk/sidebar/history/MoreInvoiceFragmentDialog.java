package com.didi.sdk.sidebar.history;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.fintech.cashier.core.ktx.StringKtxKt;
import com.taxis99.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoreInvoiceFragmentDialog extends DialogFragment {
    public static final int TYPE_INVALIDATE = 0;
    public static final int TYPE_VALIDATE = 1;

    /* renamed from: a */
    private TextView f40056a;

    /* renamed from: b */
    private View f40057b;

    /* renamed from: c */
    private View f40058c;

    /* renamed from: d */
    private View f40059d;

    /* renamed from: e */
    private TextView f40060e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public EditText f40061f;

    /* renamed from: g */
    private TextView f40062g;

    /* renamed from: h */
    private EditText f40063h;

    /* renamed from: i */
    private ImageView f40064i;

    /* renamed from: j */
    private TextView f40065j;

    /* renamed from: k */
    private Button f40066k;

    /* renamed from: l */
    private View.OnClickListener f40067l;

    /* renamed from: m */
    private View.OnClickListener f40068m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public View.OnClickListener f40069n;

    /* renamed from: o */
    private String f40070o;

    /* renamed from: p */
    private String f40071p;

    /* renamed from: q */
    private int f40072q;

    /* renamed from: r */
    private int f40073r;

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
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.global_more_invoice_dlg, (ViewGroup) null);
        this.f40056a = (TextView) inflate.findViewById(R.id.tv_invoice_title);
        this.f40061f = (EditText) inflate.findViewById(R.id.et_invoice_title);
        this.f40062g = (TextView) inflate.findViewById(R.id.tv_invoice_email);
        this.f40063h = (EditText) inflate.findViewById(R.id.et_invoice_email);
        this.f40059d = inflate.findViewById(R.id.v_invoice_title_line);
        this.f40057b = inflate.findViewById(R.id.ll_invoice_title);
        this.f40058c = inflate.findViewById(R.id.iv_invoice_title_clear);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_invoice_email_desc);
        this.f40060e = textView;
        textView.setText(m30224a(getContext().getString(R.string.global_invoice_email_desc), getContext().getResources().getColor(R.color.global_invoice_validate_desc), getContext().getResources().getColor(R.color.global_invoice_validate_status)));
        this.f40064i = (ImageView) inflate.findViewById(R.id.iv_invoice_email_edit);
        this.f40065j = (TextView) inflate.findViewById(R.id.cancel);
        Button button = (Button) inflate.findViewById(R.id.send);
        this.f40066k = button;
        button.setOnClickListener(this.f40067l);
        this.f40065j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (MoreInvoiceFragmentDialog.this.f40069n != null) {
                    MoreInvoiceFragmentDialog.this.f40069n.onClick(view);
                }
                MoreInvoiceFragmentDialog.this.dismiss();
            }
        });
        this.f40064i.setOnClickListener(this.f40068m);
        this.f40058c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MoreInvoiceFragmentDialog.this.f40061f.setText("");
            }
        });
        updateUI();
        return inflate;
    }

    public void updateUI() {
        EditText editText = this.f40061f;
        if (editText != null) {
            editText.setText(this.f40070o);
        }
        EditText editText2 = this.f40063h;
        if (editText2 != null) {
            editText2.setText(this.f40071p);
        }
        if (!(this.f40062g == null || getContext() == null)) {
            TextView textView = this.f40062g;
            Context context = getContext();
            textView.setText(context.getString(R.string.global_invoice_email_title, new Object[]{this.f40072q + ""}));
        }
        if (this.f40073r == 1) {
            m30225a((View) this.f40056a, 0);
            m30225a(this.f40057b, 0);
            m30225a((View) this.f40064i, 0);
            m30225a(this.f40059d, 0);
            m30225a((View) this.f40060e, 8);
            m30226a((TextView) this.f40066k, getContext().getString(R.string.global_invoice_send_email));
            return;
        }
        m30225a((View) this.f40056a, 8);
        m30225a(this.f40057b, 8);
        m30225a((View) this.f40064i, 8);
        m30225a(this.f40059d, 8);
        m30225a((View) this.f40060e, 0);
        m30226a((TextView) this.f40066k, getContext().getString(R.string.global_invoice_go_validate));
    }

    public void setUIData(String str, String str2, int i, int i2) {
        this.f40070o = str;
        this.f40071p = str2;
        this.f40072q = i;
        this.f40073r = i2;
    }

    /* renamed from: a */
    private void m30225a(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    /* renamed from: a */
    private void m30226a(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    public String getEmail() {
        return this.f40063h.getText().toString();
    }

    public String getTitle() {
        return this.f40061f.getText().toString();
    }

    public void setRightOnclickListener(View.OnClickListener onClickListener) {
        this.f40067l = onClickListener;
    }

    public void setOnCancelListener(View.OnClickListener onClickListener) {
        this.f40069n = onClickListener;
    }

    public void setEditListener(View.OnClickListener onClickListener) {
        this.f40068m = onClickListener;
    }

    /* renamed from: a */
    private CharSequence m30224a(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile(StringKtxKt.REGULAR_EXPRESSION).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.delete(matcher.start(), matcher.start() + 1);
        spannableStringBuilder.delete(matcher.end() - 2, matcher.end() - 1);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), matcher.start(), matcher.end() - 2, 18);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, matcher.start(), 18);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), matcher.end() - 2, spannableStringBuilder.length(), 18);
        return spannableStringBuilder;
    }
}
