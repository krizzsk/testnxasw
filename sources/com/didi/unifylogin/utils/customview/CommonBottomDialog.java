package com.didi.unifylogin.utils.customview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class CommonBottomDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    private TextView f47631a;

    /* renamed from: b */
    private TextView f47632b;

    /* renamed from: c */
    private Button f47633c;

    /* renamed from: d */
    private Button f47634d;

    /* renamed from: e */
    private View f47635e;

    /* renamed from: f */
    private String f47636f;

    /* renamed from: g */
    private String f47637g;

    /* renamed from: h */
    private String f47638h;

    /* renamed from: i */
    private String f47639i;

    /* renamed from: j */
    private ImageView f47640j;

    /* renamed from: k */
    private BottomDialogInterface f47641k;

    public static abstract class BottomDialogInterface {
        public abstract void onCancelClicked(CommonBottomDialog commonBottomDialog);

        public void onCloseDialog(CommonBottomDialog commonBottomDialog) {
        }

        public abstract void onConfirmClicked(CommonBottomDialog commonBottomDialog);
    }

    public CommonBottomDialog(Context context) {
        super(context, R.style.CustomDialog);
        init();
    }

    public void show(String str, String str2, String str3, View view, BottomDialogInterface bottomDialogInterface) {
        show(str, str2, str3, (String) null, view, bottomDialogInterface);
    }

    public void show(String str, String str2, String str3, String str4, View view, BottomDialogInterface bottomDialogInterface) {
        this.f47636f = str;
        this.f47637g = str2;
        this.f47638h = str3;
        this.f47639i = str4;
        this.f47641k = bottomDialogInterface;
        this.f47635e = view;
        m35729b();
        m35727a();
    }

    public void setCloseDialogIconVisible() {
        this.f47640j.setVisibility(0);
    }

    public void setConfirmBtnEnabled(boolean z) {
        this.f47633c.setEnabled(z);
    }

    /* renamed from: a */
    private void m35727a() {
        if (!(getContext() instanceof Activity) || !m35728a((Activity) getContext())) {
            try {
                super.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    /* renamed from: a */
    private static boolean m35728a(Activity activity) {
        if (Build.VERSION.SDK_INT < 17) {
            return activity.isFinishing();
        }
        return activity.isFinishing() || activity.isDestroyed();
    }

    /* access modifiers changed from: protected */
    public void init() {
        setContentView(R.layout.login_sdk_common_bottom_dialog);
        this.f47631a = (TextView) findViewById(R.id.title);
        this.f47640j = (ImageView) findViewById(R.id.close_dialog);
        this.f47632b = (TextView) findViewById(R.id.content);
        this.f47633c = (Button) findViewById(R.id.confirm_btn);
        this.f47634d = (Button) findViewById(R.id.cancel_btn);
        this.f47633c.setOnClickListener(this);
        this.f47634d.setOnClickListener(this);
        this.f47640j.setOnClickListener(this);
    }

    /* renamed from: b */
    private void m35729b() {
        this.f47631a.setText(this.f47636f);
        this.f47632b.setText(this.f47637g);
        if (!TextUtils.isEmpty(this.f47638h)) {
            this.f47633c.setText(this.f47638h);
        } else {
            this.f47633c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f47639i)) {
            this.f47634d.setText(this.f47639i);
        } else {
            this.f47634d.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.extra_content);
        if (this.f47635e != null) {
            updateExtraLayout(linearLayout);
        } else {
            linearLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        getWindow().setLayout(-1, -2);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 80;
        getWindow().setAttributes(attributes);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.f47641k == null) {
            dismiss();
        } else if (view.getId() == R.id.confirm_btn) {
            this.f47641k.onConfirmClicked(this);
        } else if (view.getId() == R.id.cancel_btn) {
            this.f47641k.onCancelClicked(this);
        } else if (view.getId() == R.id.close_dialog) {
            this.f47641k.onCloseDialog(this);
        }
    }

    /* access modifiers changed from: protected */
    public void updateExtraLayout(LinearLayout linearLayout) {
        linearLayout.setVisibility(0);
        linearLayout.addView(this.f47635e);
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }
}
