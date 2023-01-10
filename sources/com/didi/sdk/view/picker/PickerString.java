package com.didi.sdk.view.picker;

public class PickerString implements IPickerData {

    /* renamed from: a */
    private String f40828a;

    public PickerString(String str) {
        this.f40828a = str;
    }

    public String getSimpleData() {
        return this.f40828a;
    }

    public String toString() {
        return this.f40828a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            return this.f40828a.equals(((PickerString) obj).getSimpleData());
        } catch (Exception unused) {
            return false;
        }
    }
}
