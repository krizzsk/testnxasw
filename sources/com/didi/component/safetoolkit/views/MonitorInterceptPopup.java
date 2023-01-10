package com.didi.component.safetoolkit.views;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.didi.component.common.model.SafeToolkitBean;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class MonitorInterceptPopup extends SimplePopupBase {

    /* renamed from: a */
    private TextView f17312a;

    /* renamed from: b */
    private Button f17313b;

    /* renamed from: c */
    private Button f17314c;

    /* renamed from: d */
    private View.OnClickListener f17315d;

    /* renamed from: e */
    private String f17316e;

    /* renamed from: f */
    private String f17317f;

    /* renamed from: g */
    private String f17318g;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.sf_safe_toolkit_risk_dialog_layout;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCanceledOnTouchOutside(false);
        return onCreateDialog;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        if (this.mRootView != null) {
            this.f17312a = (TextView) this.mRootView.findViewById(R.id.risk_dialog_content_tv);
            this.f17313b = (Button) this.mRootView.findViewById(R.id.risk_dialog_ok_btn);
            this.f17314c = (Button) this.mRootView.findViewById(R.id.risk_dialog_danger_btn);
            this.f17313b.setOnClickListener(this.f17315d);
            this.f17314c.setOnClickListener(this.f17315d);
            this.f17312a.setText(this.f17316e);
            this.f17313b.setText(this.f17317f);
            this.f17314c.setText(this.f17318g);
        }
    }

    public static MonitorInterceptPopup newInstance() {
        MonitorInterceptPopup monitorInterceptPopup = new MonitorInterceptPopup();
        monitorInterceptPopup.setArguments(new Bundle());
        return monitorInterceptPopup;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.f17315d = onClickListener;
    }

    public void setContent(String str) {
        this.f17316e = str;
    }

    public void setOkText(String str) {
        this.f17317f = str;
    }

    public void setDangerText(String str) {
        this.f17318g = str;
    }

    public void updateContent(SafeToolkitBean safeToolkitBean) {
        TextView textView;
        if (safeToolkitBean != null && safeToolkitBean.monitorMenuModel != null && (textView = this.f17312a) != null && this.f17313b != null && this.f17314c != null) {
            textView.setText(safeToolkitBean.monitorMenuModel.alertTile);
            this.f17313b.setText(safeToolkitBean.monitorMenuModel.btnOkText);
            this.f17314c.setText(safeToolkitBean.monitorMenuModel.btnJumpText);
        }
    }
}
