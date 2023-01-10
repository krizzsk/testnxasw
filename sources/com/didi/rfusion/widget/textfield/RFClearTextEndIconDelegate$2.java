package com.didi.rfusion.widget.textfield;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

class RFClearTextEndIconDelegate$2 implements View.OnFocusChangeListener {
    final /* synthetic */ C12401a this$0;

    RFClearTextEndIconDelegate$2(C12401a aVar) {
        this.this$0 = aVar;
    }

    public void onFocusChange(View view, boolean z) {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(((EditText) view).getText());
        C12401a aVar = this.this$0;
        if (!z3 || !z) {
            z2 = false;
        }
        aVar.m27603a(z2);
    }
}
