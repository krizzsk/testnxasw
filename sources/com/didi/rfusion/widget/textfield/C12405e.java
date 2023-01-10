package com.didi.rfusion.widget.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.didi.rfusion.material.internal.RFCheckableIconButton;
import com.didi.rfusion.widget.textfield.RFTextInputLayout;
import com.taxis99.R;

/* renamed from: com.didi.rfusion.widget.textfield.e */
/* compiled from: RFPasswordToggleEndIconDelegate */
class C12405e extends C12402b {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RFCheckableIconButton f36687c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final TextWatcher f36688d = new RFPasswordToggleEndIconDelegate$1(this);

    /* renamed from: e */
    private final RFTextInputLayout.OnEditTextAttachedListener f36689e = new RFPasswordToggleEndIconDelegate$2(this);

    /* renamed from: f */
    private final RFTextInputLayout.OnEndIconChangedListener f36690f = new RFPasswordToggleEndIconDelegate$3(this);

    C12405e(RFTextInputLayout rFTextInputLayout) {
        super(rFTextInputLayout);
        this.f36687c = rFTextInputLayout.getInnerEndIconView();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94806a() {
        this.f36687c.setIcon(this.f36648b.getString(R.string.rf_icon_filled_hide), this.f36648b.getString(R.string.rf_icon_filled_see));
        this.f36687c.setTextColor(this.f36648b.getResources().getColor(R.color.rf_color_gery_1_0_000000));
        this.f36647a.setInnerEndIconOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                C12405e.this.m27666a(view);
            }
        });
        this.f36647a.addOnEditTextAttachedListener(this.f36689e);
        this.f36647a.mo94694a(this.f36690f);
        EditText editText = this.f36647a.getEditText();
        if (m27667a(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27666a(View view) {
        EditText editText = this.f36647a.getEditText();
        if (editText != null) {
            int selectionEnd = editText.getSelectionEnd();
            if (m27670b()) {
                editText.setTransformationMethod((TransformationMethod) null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            int length = editText.getText().length();
            if (selectionEnd >= 0 && selectionEnd <= length) {
                editText.setSelection(selectionEnd);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m27670b() {
        EditText editText = this.f36647a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    /* renamed from: a */
    private static boolean m27667a(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }
}
