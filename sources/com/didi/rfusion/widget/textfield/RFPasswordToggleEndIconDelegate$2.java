package com.didi.rfusion.widget.textfield;

import android.widget.EditText;
import com.didi.rfusion.widget.textfield.RFTextInputLayout;

class RFPasswordToggleEndIconDelegate$2 implements RFTextInputLayout.OnEditTextAttachedListener {
    final /* synthetic */ C12405e this$0;

    RFPasswordToggleEndIconDelegate$2(C12405e eVar) {
        this.this$0 = eVar;
    }

    public void onEditTextAttached(RFTextInputLayout rFTextInputLayout) {
        EditText editText = rFTextInputLayout.getEditText();
        rFTextInputLayout.setInnerEndIconVisible(true);
        rFTextInputLayout.setInnerEndIconCheckable(true);
        this.this$0.f36687c.setChecked(true ^ this.this$0.m27670b());
        editText.removeTextChangedListener(this.this$0.f36688d);
        editText.addTextChangedListener(this.this$0.f36688d);
    }
}
