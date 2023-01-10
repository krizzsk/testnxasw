package com.didi.hawaii.p120ar.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.view.CustomToast */
public class CustomToast {

    /* renamed from: a */
    private Context f25653a;

    /* renamed from: b */
    private Dialog f25654b;

    /* renamed from: c */
    private TextView f25655c;

    /* renamed from: d */
    private int f25656d;

    /* renamed from: e */
    private int f25657e;

    public CustomToast(Context context) {
        this.f25653a = context;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f25656d = windowManager.getDefaultDisplay().getWidth();
        this.f25657e = windowManager.getDefaultDisplay().getHeight();
    }

    public CustomToast builder() {
        Button button = new Button(this.f25653a);
        this.f25655c = button;
        button.setBackgroundResource(R.mipmap.toast_bg);
        Dialog dialog = new Dialog(this.f25653a, R.style.ActionSheetDialogStyle);
        this.f25654b = dialog;
        dialog.setContentView(this.f25655c);
        Window window = this.f25654b.getWindow();
        window.setGravity(81);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 100;
        window.setAttributes(attributes);
        this.f25654b.setCancelable(false);
        return this;
    }

    public CustomToast setMsg(String str) {
        this.f25655c.setVisibility(0);
        this.f25655c.setText(str);
        return this;
    }

    public void show() {
        Dialog dialog = this.f25654b;
        if (dialog != null) {
            SystemUtils.showDialog(dialog);
        }
    }

    public void dismiss() {
        this.f25654b.dismiss();
    }
}
