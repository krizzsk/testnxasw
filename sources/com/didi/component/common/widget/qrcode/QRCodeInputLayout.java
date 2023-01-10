package com.didi.component.common.widget.qrcode;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;

public class QRCodeInputLayout extends FrameLayout implements TextWatcher, View.OnFocusChangeListener, View.OnKeyListener {

    /* renamed from: b */
    private static final int f13923b = 8;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f13924a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText[] f13925c;

    /* renamed from: d */
    private int[] f13926d = {R.id.oc_pin_input_edit_text_1, R.id.oc_pin_input_edit_text_2, R.id.oc_pin_input_edit_text_3, R.id.oc_pin_input_edit_text_4, R.id.oc_pin_input_edit_text_5, R.id.oc_pin_input_edit_text_6, R.id.oc_pin_input_edit_text_7, R.id.oc_pin_input_edit_text_8};

    /* renamed from: e */
    private State f13927e = State.INCOMPLETE;

    /* renamed from: f */
    private OnStateChangedListener f13928f;

    public interface OnStateChangedListener {
        void onStateChanged(State state);
    }

    public enum State {
        INCOMPLETE,
        COMPLETE
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public QRCodeInputLayout(Context context) {
        super(context);
        m11527a(context);
    }

    public QRCodeInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11527a(context);
    }

    public QRCodeInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11527a(context);
    }

    /* renamed from: a */
    private void m11527a(Context context) {
        this.f13924a = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        inflate(this.f13924a, R.layout.global_qr_code_input_layout, this);
        this.f13925c = new EditText[8];
        for (int i = 0; i < 8; i++) {
            this.f13925c[i] = (EditText) findViewById(this.f13926d[i]);
            this.f13925c[i].setInputType(2);
            this.f13925c[i].setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            this.f13925c[i].addTextChangedListener(this);
            this.f13925c[i].setOnFocusChangeListener(this);
            this.f13925c[i].setOnKeyListener(this);
            this.f13925c[i].setFocusable(true);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        m11526a();
    }

    /* renamed from: a */
    private void m11526a() {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                EditText editText = QRCodeInputLayout.this.f13925c[0];
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                ((InputMethodManager) QRCodeInputLayout.this.f13924a.getSystemService("input_method")).showSoftInput(editText, 0);
            }
        }, 200);
    }

    public void afterTextChanged(Editable editable) {
        if (editable != null && editable.length() > 0) {
            m11531b();
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (z && (view instanceof EditText)) {
            ((EditText) view).setText((CharSequence) null);
            m11531b();
        }
    }

    /* renamed from: b */
    private void m11531b() {
        boolean z = false;
        for (EditText editText : this.f13925c) {
            if (m11528a(editText) || z) {
                editText.setFocusable(false);
            } else {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                z = true;
            }
        }
        if (z) {
            m11532c();
            return;
        }
        for (EditText editText2 : this.f13925c) {
            editText2.setFocusable(true);
            editText2.setFocusableInTouchMode(true);
        }
        requestFocus();
        m11533d();
    }

    /* renamed from: a */
    private boolean m11528a(EditText editText) {
        return editText != null && editText.getText().length() > 0;
    }

    public void hideSoftKeyboard() {
        ((InputMethodManager) this.f13924a.getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 67 || keyEvent.getAction() != 0) {
            return false;
        }
        for (int i2 = 7; i2 > 0; i2--) {
            EditText[] editTextArr = this.f13925c;
            if (view == editTextArr[i2] && !m11528a(editTextArr[i2])) {
                this.f13925c[i2 - 1].setText((CharSequence) null);
                m11531b();
            }
        }
        return false;
    }

    public State getState() {
        return this.f13927e;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.f13928f = onStateChangedListener;
    }

    /* renamed from: c */
    private void m11532c() {
        if (this.f13927e.equals(State.COMPLETE)) {
            this.f13927e = State.INCOMPLETE;
            m11534e();
        }
    }

    /* renamed from: d */
    private void m11533d() {
        if (this.f13927e.equals(State.INCOMPLETE)) {
            this.f13927e = State.COMPLETE;
            m11534e();
        }
    }

    /* renamed from: e */
    private void m11534e() {
        OnStateChangedListener onStateChangedListener = this.f13928f;
        if (onStateChangedListener != null) {
            onStateChangedListener.onStateChanged(this.f13927e);
        }
    }

    public String getPin() {
        if (this.f13927e != State.COMPLETE) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (EditText text : this.f13925c) {
            sb.append(text.getText());
        }
        return sb.toString();
    }

    public void clearPin() {
        for (EditText text : this.f13925c) {
            text.getText().clear();
        }
        m11526a();
    }

    public boolean isCompleted() {
        return this.f13927e.equals(State.COMPLETE);
    }
}
