package com.didi.rfusion.widget.textfield;

import android.text.Editable;
import android.text.TextWatcher;

class RFClearTextEndIconDelegate$1 implements TextWatcher {
    final /* synthetic */ C12401a this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    RFClearTextEndIconDelegate$1(C12401a aVar) {
        this.this$0 = aVar;
    }

    public void afterTextChanged(Editable editable) {
        this.this$0.m27603a(C12401a.m27606b(editable));
    }
}
