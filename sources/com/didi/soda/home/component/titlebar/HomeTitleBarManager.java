package com.didi.soda.home.component.titlebar;

import android.view.ViewGroup;

public class HomeTitleBarManager {

    /* renamed from: a */
    private static HomeTitleBarManager f45100a = new HomeTitleBarManager();

    /* renamed from: b */
    private ViewGroup f45101b;

    public static HomeTitleBarManager getManager() {
        return f45100a;
    }

    public void bindTitleBar(ViewGroup viewGroup) {
        this.f45101b = viewGroup;
    }

    public void hideTitleBar() {
        ViewGroup viewGroup = this.f45101b;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void showTitleBar() {
        ViewGroup viewGroup = this.f45101b;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public boolean isShow() {
        ViewGroup viewGroup = this.f45101b;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }
}
