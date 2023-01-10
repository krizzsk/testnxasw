package com.didi.rfusion.widget.textfield;

import android.widget.EditText;
import com.didi.rfusion.widget.textfield.RFTextInputLayout;

class RFClearTextEndIconDelegate$3 implements RFTextInputLayout.OnEditTextAttachedListener {
    final /* synthetic */ C12401a this$0;

    RFClearTextEndIconDelegate$3(C12401a aVar) {
        this.this$0 = aVar;
    }

    public void onEditTextAttached(RFTextInputLayout rFTextInputLayout) {
        EditText editText = rFTextInputLayout.getEditText();
        rFTextInputLayout.setClearIconVisible(editText.hasFocus() && C12401a.m27606b(editText.getText()));
        rFTextInputLayout.setClearIconCheckable(false);
        editText.setOnFocusChangeListener(this.this$0.f36642g);
        editText.removeTextChangedListener(this.this$0.f36641f);
        editText.addTextChangedListener(this.this$0.f36641f);
    }
}
