package com.didi.component.service.activity.risk.dialog;

import android.graphics.drawable.Drawable;
import com.didi.sdk.view.dialog.AlertController;

public class NormalDialogInfo extends com.didi.component.common.dialog.NormalDialogInfo {

    /* renamed from: m */
    int f17590m;

    /* renamed from: n */
    Drawable f17591n;

    /* renamed from: o */
    AlertController.IconType f17592o;

    /* renamed from: p */
    CharSequence f17593p;

    /* renamed from: q */
    CharSequence f17594q;

    /* renamed from: r */
    CharSequence f17595r;

    /* renamed from: s */
    CharSequence f17596s;

    /* renamed from: t */
    CharSequence f17597t;

    /* renamed from: u */
    boolean f17598u = true;

    /* renamed from: v */
    boolean f17599v;

    /* renamed from: w */
    boolean f17600w = false;

    public NormalDialogInfo(int i) {
        super(i);
    }

    public NormalDialogInfo setIcon(int i) {
        this.f17590m = i;
        return this;
    }

    public NormalDialogInfo setIcon(Drawable drawable) {
        this.f17591n = drawable;
        return this;
    }

    public NormalDialogInfo setIcon(AlertController.IconType iconType) {
        this.f17592o = iconType;
        return this;
    }

    public NormalDialogInfo setTitle(CharSequence charSequence) {
        this.f17593p = charSequence;
        return this;
    }

    public NormalDialogInfo setMessage(CharSequence charSequence) {
        this.f17594q = charSequence;
        return this;
    }

    public NormalDialogInfo setPositiveText(CharSequence charSequence) {
        this.f17595r = charSequence;
        return this;
    }

    public NormalDialogInfo setNeutralText(CharSequence charSequence) {
        this.f17596s = charSequence;
        return this;
    }

    public NormalDialogInfo setNegativeText(CharSequence charSequence) {
        this.f17597t = charSequence;
        return this;
    }

    public NormalDialogInfo setCancelable(boolean z) {
        this.f17599v = z;
        return this;
    }

    public NormalDialogInfo setIconVisible(boolean z) {
        this.f17598u = z;
        return this;
    }

    public NormalDialogInfo setCloseVisible(boolean z) {
        this.f17600w = z;
        return this;
    }
}
