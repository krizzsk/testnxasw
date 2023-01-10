package com.didi.map.global.flow.scene.minibus.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class JumpNavErrorHintDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    private TextView f28877a;

    /* renamed from: b */
    private TextView f28878b;

    public JumpNavErrorHintDialog(Context context) {
        this(context, R.style.popupDialog);
    }

    public JumpNavErrorHintDialog(Context context, int i) {
        super(context, i);
        m22492a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.addFlags(2);
        attributes.dimAmount = 0.5f;
        window.setAttributes(attributes);
    }

    /* renamed from: a */
    private void m22492a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.jump_nav_error_hint_dialog_layout, (ViewGroup) null);
        this.f28877a = (TextView) inflate.findViewById(R.id.dialog_title);
        this.f28878b = (TextView) inflate.findViewById(R.id.dialog_subtitle);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_close);
        try {
            textView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.jump_nav_confirm_btn_bg));
            textView.setTextColor(Color.parseColor("#ffffff"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        inflate.findViewById(R.id.dialog_close).setOnClickListener(this);
        setContentView(inflate);
    }

    public void setTitle(String str) {
        if (this.f28877a != null && !TextUtils.isEmpty(str)) {
            this.f28877a.setText(str);
        }
    }

    public void setSubTitle(String str) {
        if (this.f28878b != null && !TextUtils.isEmpty(str)) {
            this.f28878b.setText(str);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.dialog_close) {
            dismiss();
        }
    }
}
