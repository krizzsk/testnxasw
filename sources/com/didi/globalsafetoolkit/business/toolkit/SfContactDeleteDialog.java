package com.didi.globalsafetoolkit.business.toolkit;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.android.didi.safetoolkit.fragment.BaseDialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didi.globalsafetoolkit.util.SfStringGetter;
import com.didi.globalsafetoolkit.util.SfViewUtils;
import com.taxis99.R;

@Deprecated
public class SfContactDeleteDialog extends BaseDialogFragment {

    /* renamed from: a */
    private TextView f25113a;

    /* renamed from: b */
    private TextView f25114b;

    /* renamed from: c */
    private TextView f25115c;

    /* renamed from: d */
    private TextView f25116d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Callback f25117e;

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
        this.f25117e = callback;
        return this;
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f25113a = (TextView) findViewById(R.id.sf_delete_dialog_title);
        this.f25114b = (TextView) findViewById(R.id.sf_delete_dialog_intro);
        this.f25115c = (TextView) findViewById(R.id.sf_delete_dialog_cancel);
        this.f25116d = (TextView) findViewById(R.id.sf_delete_dialog_confirm);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        this.f25113a.setText(SfStringGetter.getString(R.string.sf_you_sure));
        String string = getArguments().getString("deleteContact");
        TextView textView = this.f25114b;
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append(" ");
        sb.append(SfStringGetter.getString(R.string.sf_no_longer_show));
        textView.setText(sb);
        this.f25116d.setText(SfStringGetter.getString(R.string.sf_remove));
        this.f25115c.setText(SfStringGetter.getString(R.string.sf_cancel));
        setDialogSizeExactly(SfViewUtils.dp2px(SfContextHelper.getContext(), 267.0f), -2);
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f25115c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfContactDeleteDialog.this.f25117e.clickCancel();
                SfContactDeleteDialog.this.dismiss();
            }
        });
        this.f25116d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfContactDeleteDialog.this.f25117e.clickPerform();
                SfContactDeleteDialog.this.dismiss();
            }
        });
    }
}
