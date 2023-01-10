package com.didi.sdk.view.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.taxis99.R;

public class LongPressDialog extends AlertDialogBase {

    /* renamed from: a */
    private View f40692a;

    /* renamed from: b */
    private Button f40693b;

    /* renamed from: c */
    private String f40694c;

    /* renamed from: d */
    private View.OnClickListener f40695d;

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.view_long_press_dialog_btn, viewGroup);
        this.f40692a = inflate;
        Button button = (Button) inflate.findViewById(R.id.button);
        this.f40693b = button;
        button.setText(this.f40694c);
        this.f40693b.setOnClickListener(this.f40695d);
        return this.f40692a;
    }

    public void setupButton(String str, View.OnClickListener onClickListener) {
        this.f40694c = str;
        this.f40695d = onClickListener;
    }
}
