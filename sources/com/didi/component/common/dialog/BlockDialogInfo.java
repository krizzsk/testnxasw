package com.didi.component.common.dialog;

public class BlockDialogInfo extends DialogInfo {

    /* renamed from: a */
    String f13362a;

    /* renamed from: b */
    String f13363b;

    /* renamed from: c */
    String f13364c;

    /* renamed from: d */
    String f13365d;

    public BlockDialogInfo(int i) {
        super(i);
    }

    public BlockDialogInfo setTitle(String str) {
        this.f13362a = str;
        return this;
    }

    public void setContent(String str) {
        this.f13363b = str;
    }

    public void setNegativeButton(String str) {
        this.f13364c = str;
    }

    public void setPositiveButton(String str) {
        this.f13365d = str;
    }
}
