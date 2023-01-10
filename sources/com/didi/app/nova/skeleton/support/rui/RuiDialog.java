package com.didi.app.nova.skeleton.support.rui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.FadeTransformAnimation;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import rui.util.ViewUtils;
import rui.widget.dialog.DialogModel;
import rui.widget.dialog.DialogView;

public class RuiDialog extends Dialog {

    /* renamed from: a */
    private Context f10351a;

    /* renamed from: b */
    private DialogView f10352b;

    public void onDestroy() {
    }

    public void onDismiss() {
    }

    public void onShow() {
    }

    public RuiDialog(Context context) {
        this.f10351a = context;
        this.f10352b = new DialogView(context);
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) ViewUtils.m7249dp(this.f10351a, 50.0f);
        layoutParams.rightMargin = (int) ViewUtils.m7249dp(this.f10351a, 50.0f);
        this.f10352b.setLayoutParams(layoutParams);
        return this.f10352b;
    }

    public void init(DialogModel dialogModel) {
        this.f10352b.init(dialogModel);
    }

    public TransformAnimation getEnterAnimation() {
        return new FadeTransformAnimation();
    }

    public TransformAnimation getExitAnimation() {
        return new FadeTransformAnimation();
    }
}
