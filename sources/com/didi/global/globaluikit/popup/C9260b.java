package com.didi.global.globaluikit.popup;

import android.view.View;
import com.didi.global.globaluikit.model.LEGOTextModel;
import com.didi.global.globaluikit.popup.model.LEGOBubbleArrow;
import com.didi.global.globaluikit.popup.model.LEGOBubbleBaseModel;

/* renamed from: com.didi.global.globaluikit.popup.b */
/* compiled from: LEGOPopupModel */
class C9260b {

    /* renamed from: a */
    public LEGOTextModel f24534a;

    /* renamed from: b */
    public String f24535b;

    /* renamed from: c */
    public int f24536c;

    /* renamed from: d */
    public String f24537d;

    /* renamed from: e */
    public String f24538e;

    /* renamed from: f */
    public LEGOBubbleArrow f24539f;

    /* renamed from: g */
    public View.OnClickListener f24540g;

    C9260b(LEGOBubbleBaseModel lEGOBubbleBaseModel, View.OnClickListener onClickListener) {
        this.f24534a = lEGOBubbleBaseModel.text;
        this.f24535b = lEGOBubbleBaseModel.icon;
        this.f24536c = lEGOBubbleBaseModel.cancelable;
        this.f24537d = lEGOBubbleBaseModel.background_color;
        this.f24538e = lEGOBubbleBaseModel.url;
        this.f24539f = lEGOBubbleBaseModel.arrow;
        this.f24540g = onClickListener;
    }
}
