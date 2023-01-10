package com.didi.component.openride.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;

public class QRCodeInputLayout extends FrameLayout implements TextWatcher, View.OnFocusChangeListener, View.OnKeyListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f16609a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText[] f16610b;

    /* renamed from: c */
    private State f16611c = State.INCOMPLETE;

    /* renamed from: d */
    private OnStateChangedListener f16612d;

    /* renamed from: e */
    private int f16613e;

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
        m13946a(context);
    }

    public QRCodeInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13946a(context);
    }

    public QRCodeInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13946a(context);
    }

    /* renamed from: a */
    private void m13946a(Context context) {
        this.f16609a = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        inflate(this.f16609a, R.layout.view_layout_global_qr_code_input, this);
    }

    public void initView(int i) {
        this.f16613e = i;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.inputContainer);
        linearLayout.removeAllViews();
        this.f16610b = new EditText[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f16610b[i2] = (EditText) LayoutInflater.from(getContext()).inflate(R.layout.view_layout_global_qr_input_edittext, linearLayout, false);
            this.f16610b[i2].setInputType(2);
            this.f16610b[i2].setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            this.f16610b[i2].addTextChangedListener(this);
            this.f16610b[i2].setOnFocusChangeListener(this);
            this.f16610b[i2].setOnKeyListener(this);
            this.f16610b[i2].setFocusable(true);
            this.f16610b[i2].setFitsSystemWindows(false);
            linearLayout.addView(this.f16610b[i2]);
            if (i2 < i - 1) {
                linearLayout.addView(LayoutInflater.from(getContext()).inflate(R.layout.view_layout_global_qr_input_line, linearLayout, false));
            }
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        m13945a();
    }

    /* renamed from: a */
    private void m13945a() {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                EditText editText = QRCodeInputLayout.this.f16610b[0];
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                ((InputMethodManager) QRCodeInputLayout.this.f16609a.getSystemService("input_method")).showSoftInput(editText, 0);
            }
        }, 200);
    }

    public void afterTextChanged(Editable editable) {
        if (editable != null && editable.length() > 0) {
            m13950b();
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (z && (view instanceof EditText)) {
            ((EditText) view).setText((CharSequence) null);
            m13950b();
        }
    }

    /* renamed from: b */
    private void m13950b() {
        boolean z = false;
        for (EditText editText : this.f16610b) {
            if (m13947a(editText) || z) {
                editText.setFocusable(false);
            } else {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                z = true;
            }
        }
        if (z) {
            m13951c();
            return;
        }
        for (EditText editText2 : this.f16610b) {
            editText2.setFocusable(true);
            editText2.setFocusableInTouchMode(true);
        }
        requestFocus();
        m13952d();
    }

    /* renamed from: a */
    private boolean m13947a(EditText editText) {
        return editText != null && editText.getText().length() > 0;
    }

    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f16609a.getSystemService("input_method");
        for (EditText windowToken : this.f16610b) {
            inputMethodManager.hideSoftInputFromWindow(windowToken.getWindowToken(), 2);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.f16613e > 0 && i == 67 && keyEvent.getAction() == 0) {
            for (int i2 = this.f16613e - 1; i2 > 0; i2--) {
                EditText[] editTextArr = this.f16610b;
                if (view == editTextArr[i2] && !m13947a(editTextArr[i2])) {
                    this.f16610b[i2 - 1].setText((CharSequence) null);
                    m13950b();
                }
            }
        }
        return false;
    }

    public State getState() {
        return this.f16611c;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.f16612d = onStateChangedListener;
    }

    /* renamed from: c */
    private void m13951c() {
        if (this.f16611c.equals(State.COMPLETE)) {
            this.f16611c = State.INCOMPLETE;
            m13953e();
        }
    }

    /* renamed from: d */
    private void m13952d() {
        if (this.f16611c.equals(State.INCOMPLETE)) {
            this.f16611c = State.COMPLETE;
            m13953e();
        }
    }

    /* renamed from: e */
    private void m13953e() {
        OnStateChangedListener onStateChangedListener = this.f16612d;
        if (onStateChangedListener != null) {
            onStateChangedListener.onStateChanged(this.f16611c);
        }
    }

    public String getPin() {
        if (this.f16611c != State.COMPLETE) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (EditText text : this.f16610b) {
            sb.append(text.getText());
        }
        return sb.toString();
    }

    public void clearPin() {
        for (EditText text : this.f16610b) {
            text.getText().clear();
        }
        m13945a();
    }

    public boolean isCompleted() {
        return this.f16611c.equals(State.COMPLETE);
    }
}
