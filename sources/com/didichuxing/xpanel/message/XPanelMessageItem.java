package com.didichuxing.xpanel.message;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class XPanelMessageItem {
    public static final int M_COMMON = 1;
    public static final int M_IMPORTANT = 2;

    /* renamed from: a */
    C17375b f52113a;

    /* renamed from: b */
    private View f52114b;

    /* renamed from: c */
    private int f52115c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessageType {
    }

    public XPanelMessageItem(View view, int i) {
        this.f52114b = view;
        this.f52115c = i;
        this.f52113a = new C17376c(view);
    }

    public View getContentView() {
        return this.f52114b;
    }

    public int getMessageType() {
        return this.f52115c;
    }
}
