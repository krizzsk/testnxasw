package com.didi.map.setting.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.didi.map.setting.common.utils.DisplayUtil;

public class SimpleDialog extends Dialog {

    /* renamed from: a */
    private int f31477a;

    public SimpleDialog(Context context) {
        this(context, 80);
    }

    public SimpleDialog(Context context, int i) {
        super(context, 2132017510);
        this.f31477a = i;
    }

    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = DisplayUtil.getScreenWidth(getContext());
            attributes.height = -2;
            attributes.gravity = this.f31477a;
            if (this.f31477a == 80) {
                window.setWindowAnimations(2132017509);
            }
            window.setAttributes(attributes);
        }
    }
}
