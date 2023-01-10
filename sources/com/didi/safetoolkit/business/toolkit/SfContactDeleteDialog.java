package com.didi.safetoolkit.business.toolkit;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.android.didi.safetoolkit.fragment.BaseDialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.util.SfContextHelper;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didi.safetoolkit.util.SfViewUtils;
import com.taxis99.R;

@Deprecated
public class SfContactDeleteDialog extends BaseDialogFragment {

    /* renamed from: a */
    private TextView f37214a;

    /* renamed from: b */
    private TextView f37215b;

    /* renamed from: c */
    private TextView f37216c;

    /* renamed from: d */
    private TextView f37217d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Callback f37218e;

    public interface Callback {
        void clickCancel();

        void clickPerform();
    }

    /* access modifiers changed from: protected */
    public int getLayoutRes() {
        return R.layout.sf_contact_delete_dialog;
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
    }

    public SfContactDeleteDialog setCallback(Callback callback) {
        this.f37218e = callback;
        return this;
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f37214a = (TextView) findViewById(R.id.sf_delete_dialog_title);
        this.f37215b = (TextView) findViewById(R.id.sf_delete_dialog_intro);
        this.f37216c = (TextView) findViewById(R.id.sf_delete_dialog_cancel);
        this.f37217d = (TextView) findViewById(R.id.sf_delete_dialog_confirm);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        this.f37214a.setText(SfStringGetter.getString(R.string.sf_you_sure));
        String string = getArguments().getString("deleteContact");
        TextView textView = this.f37215b;
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append(" ");
        sb.append(SfStringGetter.getString(R.string.sf_no_longer_show));
        textView.setText(sb);
        this.f37217d.setText(SfStringGetter.getString(R.string.sf_remove));
        this.f37216c.setText(SfStringGetter.getString(R.string.sf_cancel));
        setDialogSizeExactly(SfViewUtils.dp2px(SfContextHelper.getContext(), 267.0f), -2);
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f37216c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfContactDeleteDialog.this.f37218e.clickCancel();
                SfContactDeleteDialog.this.dismiss();
            }
        });
        this.f37217d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfContactDeleteDialog.this.f37218e.clickPerform();
                SfContactDeleteDialog.this.dismiss();
            }
        });
    }
}
