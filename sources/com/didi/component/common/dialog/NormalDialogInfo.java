package com.didi.component.common.dialog;

import android.graphics.drawable.Drawable;
import com.didi.sdk.view.dialog.AlertController;

public class NormalDialogInfo extends DialogInfo {

    /* renamed from: a */
    int f13417a;

    /* renamed from: b */
    Drawable f13418b;

    /* renamed from: c */
    AlertController.IconType f13419c;

    /* renamed from: d */
    CharSequence f13420d;

    /* renamed from: e */
    CharSequence f13421e;

    /* renamed from: f */
    CharSequence f13422f;

    /* renamed from: g */
    CharSequence f13423g;

    /* renamed from: h */
    CharSequence f13424h;

    /* renamed from: i */
    boolean f13425i = true;

    /* renamed from: j */
    boolean f13426j;

    /* renamed from: k */
    boolean f13427k = false;

    /* renamed from: l */
    boolean f13428l = false;

    public void setSupportMultiLine(boolean z) {
        this.f13428l = z;
    }

    public NormalDialogInfo(int i) {
        super(i);
    }

    public NormalDialogInfo setIcon(int i) {
        this.f13417a = i;
        return this;
    }

    public NormalDialogInfo setIcon(Drawable drawable) {
        this.f13418b = drawable;
        return this;
    }

    public NormalDialogInfo setIcon(AlertController.IconType iconType) {
        this.f13419c = iconType;
        return this;
    }

    public NormalDialogInfo setTitle(CharSequence charSequence) {
        this.f13420d = charSequence;
        return this;
    }

    public NormalDialogInfo setMessage(CharSequence charSequence) {
        this.f13421e = charSequence;
        return this;
    }

    public NormalDialogInfo setPositiveText(CharSequence charSequence) {
        this.f13422f = charSequence;
        return this;
    }

    public NormalDialogInfo setNeutralText(CharSequence charSequence) {
        this.f13423g = charSequence;
        return this;
    }

    public NormalDialogInfo setNegativeText(CharSequence charSequence) {
        this.f13424h = charSequence;
        return this;
    }

    public NormalDialogInfo setCancelable(boolean z) {
        this.f13426j = z;
        return this;
    }

    public NormalDialogInfo setIconVisible(boolean z) {
        this.f13425i = z;
        return this;
    }

    public NormalDialogInfo setCloseVisible(boolean z) {
        this.f13427k = z;
        return this;
    }
}
