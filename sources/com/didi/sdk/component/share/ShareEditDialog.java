package com.didi.sdk.component.share;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.component.share.ShareView;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ShareEditDialog extends Dialog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ShareEditDialogListener f38424a;

    /* renamed from: b */
    private View f38425b;

    /* renamed from: c */
    private ImageView f38426c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public EditText f38427d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f38428e;

    /* renamed from: f */
    private Button f38429f;

    /* renamed from: g */
    private Button f38430g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ShareView.ShareModel f38431h;

    /* renamed from: i */
    private View.OnClickListener f38432i = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            ShareEditDialog.this.dismiss();
            if (ShareEditDialog.this.f38424a != null) {
                ShareEditDialog.this.f38424a.cancel();
            }
        }
    };

    /* renamed from: j */
    private View.OnClickListener f38433j = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (TextUtils.isEmpty(ShareEditDialog.this.getEditContent())) {
                ToastHelper.showShortError(ShareEditDialog.this.getContext(), (int) R.string.share_content_empty);
                return;
            }
            ShareEditDialog.this.f38431h.content = ShareEditDialog.this.getEditContent();
            ShareEditDialog.this.dismiss();
            if (ShareEditDialog.this.f38424a != null) {
                ShareEditDialog.this.f38424a.submit();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k */
    public TextWatcher f38434k = new TextWatcher() {
        private int count;
        private int editEnd;
        private int editStart;
        private CharSequence tempInput;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.tempInput = charSequence;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.count = i2 + i3;
            String obj = ShareEditDialog.this.f38427d.getText().toString();
            String stringFilter = ShareEditDialog.stringFilter(obj);
            if (!obj.equals(stringFilter)) {
                ShareEditDialog.this.f38427d.setText(stringFilter);
            }
            this.count = ShareEditDialog.this.f38427d.length();
            ShareEditDialog.this.f38428e.setText(String.valueOf(140 - this.count));
        }

        public void afterTextChanged(Editable editable) {
            ShareEditDialog.this.f38427d.removeTextChangedListener(ShareEditDialog.this.f38434k);
            this.editStart = ShareEditDialog.this.f38427d.getSelectionStart();
            this.editEnd = ShareEditDialog.this.f38427d.getSelectionEnd();
            if (this.tempInput.length() > 140) {
                editable.delete(this.editStart - 1, this.editEnd);
                int i = this.editStart;
                ShareEditDialog.this.f38427d.setText(editable);
                ShareEditDialog.this.f38427d.setSelection(i);
            }
            ShareEditDialog.this.f38427d.addTextChangedListener(ShareEditDialog.this.f38434k);
        }
    };

    public interface ShareEditDialogListener {
        void cancel();

        void submit();
    }

    public ShareEditDialog(Context context) {
        super(context);
        m28982a();
    }

    public ShareEditDialog(Context context, int i) {
        super(context, i);
        m28982a();
    }

    protected ShareEditDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        m28982a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f38425b);
    }

    /* renamed from: a */
    private void m28982a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.v_share_edit_dialog, (ViewGroup) null);
        this.f38425b = inflate;
        this.f38429f = (Button) inflate.findViewById(R.id.btn_cancel);
        this.f38430g = (Button) this.f38425b.findViewById(R.id.btn_share);
        this.f38426c = (ImageView) this.f38425b.findViewById(R.id.img_logo);
        EditText editText = (EditText) this.f38425b.findViewById(R.id.dialog_edit_content);
        this.f38427d = editText;
        editText.addTextChangedListener(this.f38434k);
        this.f38428e = (TextView) this.f38425b.findViewById(R.id.dialog_txt_count);
        this.f38429f.setOnClickListener(this.f38432i);
        this.f38430g.setOnClickListener(this.f38433j);
    }

    public void setDialog(ShareView.ShareModel shareModel) {
        this.f38431h = shareModel;
        if (TextUtils.isEmpty(shareModel.content)) {
            this.f38431h.content = "";
        } else {
            ShareView.ShareModel shareModel2 = this.f38431h;
            shareModel2.content = this.f38431h.content + this.f38431h.url;
        }
        if (!TextUtils.isEmpty(this.f38431h.imageUrl)) {
            Glide.with(getContext()).load(this.f38431h.imageUrl).placeholder(R.drawable.hongbao_share).into(this.f38426c);
        }
        this.f38427d.setText(this.f38431h.content);
        if (!TextUtils.isEmpty(this.f38431h.content)) {
            if (this.f38431h.content.length() <= 140) {
                this.f38427d.setSelection(this.f38431h.content.length());
                this.f38428e.setText(String.valueOf(140 - this.f38431h.content.length()));
            } else {
                this.f38427d.setSelection(140);
                this.f38428e.setText("0");
            }
        }
        requestWindowFeature(1);
    }

    public void setListener(ShareEditDialogListener shareEditDialogListener) {
        this.f38424a = shareEditDialogListener;
    }

    public String getEditContent() {
        return this.f38427d.getText().toString();
    }

    public static String stringFilter(String str) throws PatternSyntaxException {
        return Pattern.compile("[\t]").matcher(str).replaceAll("");
    }
}
