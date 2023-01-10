package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.taxis99.R;

public class FaceNotifyDialog {

    /* renamed from: a */
    private Context f49878a;

    /* renamed from: b */
    private int f49879b;

    /* renamed from: c */
    private CharSequence f49880c;

    /* renamed from: d */
    private final BottomSheetDialog f49881d;

    /* renamed from: e */
    private int f49882e;

    /* renamed from: f */
    private View.OnClickListener f49883f;

    /* renamed from: g */
    private int f49884g;

    /* renamed from: h */
    private View.OnClickListener f49885h;

    public FaceNotifyDialog(Context context, int i, String str) {
        this.f49878a = context;
        this.f49879b = i;
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.MyDialogStyle);
        this.f49881d = bottomSheetDialog;
        bottomSheetDialog.setContentView((int) R.layout.diface_notify_dialog_layout);
        this.f49881d.setCancelable(false);
    }

    public FaceNotifyDialog setMsg(CharSequence charSequence) {
        this.f49880c = charSequence;
        return this;
    }

    public FaceNotifyDialog setMsg(int i) {
        this.f49880c = this.f49878a.getString(i);
        return this;
    }

    public FaceNotifyDialog setMainBtnInfo(int i, View.OnClickListener onClickListener) {
        this.f49882e = i;
        this.f49883f = onClickListener;
        return this;
    }

    public FaceNotifyDialog setSecondaryBtnInfo(int i, View.OnClickListener onClickListener) {
        this.f49884g = i;
        this.f49885h = onClickListener;
        return this;
    }

    public void show() {
        SystemUtils.showDialog(this.f49881d);
        ((TextView) this.f49881d.findViewById(R.id.dialog_title)).setText(this.f49879b);
        TextView textView = (TextView) this.f49881d.findViewById(R.id.dialog_msg);
        if (!TextUtils.isEmpty(this.f49880c)) {
            textView.setText(this.f49880c);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        Button button = (Button) this.f49881d.findViewById(R.id.main_btn);
        int i = this.f49882e;
        if (i != 0) {
            button.setText(i);
            button.setOnClickListener(this.f49883f);
        }
        Button button2 = (Button) this.f49881d.findViewById(R.id.secondary_btn);
        int i2 = this.f49884g;
        if (i2 != 0) {
            button2.setText(i2);
            button2.setVisibility(0);
            button2.setOnClickListener(this.f49885h);
            return;
        }
        button2.setVisibility(8);
    }

    public void dismiss() {
        this.f49881d.dismiss();
    }
}
