package com.didi.app.nova.skeleton.support.rui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.app.nova.skeleton.dialog.VerticalTransformAnimation;
import rui.widget.popup.PopupView;
import rui.widget.popup.base.BasePopupModel;

public class Popup extends Dialog {

    /* renamed from: a */
    private Context f10349a;

    /* renamed from: b */
    private PopupView f10350b;

    public void onDestroy() {
    }

    public void onDismiss() {
    }

    public void onShow() {
    }

    public Popup(Context context) {
        this.f10349a = context;
        this.f10350b = new PopupView(context);
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f10350b.setLayoutParams(layoutParams);
        return this.f10350b;
    }

    @Deprecated
    public void update(BasePopupModel basePopupModel) {
        this.f10350b.update(basePopupModel);
    }

    public void init(BasePopupModel basePopupModel) {
        this.f10350b.init(basePopupModel);
    }

    public TransformAnimation getEnterAnimation() {
        return new VerticalTransformAnimation();
    }

    public TransformAnimation getExitAnimation() {
        return new VerticalTransformAnimation();
    }
}
