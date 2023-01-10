package com.didi.dimina.container.secondparty.permission;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class DiminaPermissionRejectConfirmDialog extends AlertDialog {

    /* renamed from: a */
    private String f19201a = "";

    /* renamed from: b */
    private String f19202b = "确定";

    /* renamed from: c */
    private TextView f19203c;

    /* renamed from: d */
    private TextView f19204d;

    /* renamed from: e */
    private TextView f19205e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CallBack f19206f;

    public interface CallBack {
        void cancel();

        void confirm();
    }

    public DiminaPermissionRejectConfirmDialog(Context context) {
        super(context, R.style.ThemeHalfTransparentDialog);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutInflater().inflate(R.layout.dimina_dialog_permission_rejected_confirm, (ViewGroup) null));
        this.f19203c = (TextView) findViewById(R.id.dimina_rejected_permission_desc_content);
        if (!TextUtils.isEmpty(this.f19201a)) {
            this.f19203c.setText(this.f19201a);
        }
        this.f19204d = (TextView) findViewById(R.id.dimina_rejected_permission_desc_cancel);
        this.f19205e = (TextView) findViewById(R.id.dimina_rejected_permission_desc_confirm);
        this.f19204d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiminaPermissionRejectConfirmDialog.this.dismiss();
                if (DiminaPermissionRejectConfirmDialog.this.f19206f != null) {
                    DiminaPermissionRejectConfirmDialog.this.f19206f.cancel();
                }
            }
        });
        this.f19205e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiminaPermissionRejectConfirmDialog.this.dismiss();
                if (DiminaPermissionRejectConfirmDialog.this.f19206f != null) {
                    DiminaPermissionRejectConfirmDialog.this.f19206f.confirm();
                }
            }
        });
        this.f19205e.setText(this.f19202b);
        m16306a();
    }

    /* renamed from: a */
    private void m16306a() {
        Window window = getWindow();
        setCancelable(false);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.gravity = 17;
        attributes.dimAmount = 0.4f;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    public void setContent(String str) {
        this.f19201a = str;
    }

    public void setConfirmText(String str) {
        this.f19202b = str;
    }

    public void setCallBack(CallBack callBack) {
        this.f19206f = callBack;
    }

    public void show() {
        try {
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class DiminaBuilder {
        private CallBack callBack;
        private String mConfirmText = "确定";
        private String mContent = "";

        public DiminaBuilder setContent(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mContent = str;
            }
            return this;
        }

        public DiminaBuilder setCallBack(CallBack callBack2) {
            this.callBack = callBack2;
            return this;
        }

        public DiminaBuilder setConfirmText(String str) {
            this.mConfirmText = str;
            return this;
        }

        public DiminaPermissionRejectConfirmDialog build(Context context) {
            DiminaPermissionRejectConfirmDialog diminaPermissionRejectConfirmDialog = new DiminaPermissionRejectConfirmDialog(context);
            diminaPermissionRejectConfirmDialog.setContent(this.mContent);
            diminaPermissionRejectConfirmDialog.setConfirmText(this.mConfirmText);
            diminaPermissionRejectConfirmDialog.setCallBack(this.callBack);
            return diminaPermissionRejectConfirmDialog;
        }
    }
}
