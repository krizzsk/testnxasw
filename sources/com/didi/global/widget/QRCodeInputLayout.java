package com.didi.global.widget;

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
    public Context f24850a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText[] f24851b;

    /* renamed from: c */
    private State f24852c = State.INCOMPLETE;

    /* renamed from: d */
    private OnStateChangedListener f24853d;

    /* renamed from: e */
    private int f24854e;

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
        m19933a(context);
    }

    public QRCodeInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19933a(context);
    }

    public QRCodeInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19933a(context);
    }

    /* renamed from: a */
    private void m19933a(Context context) {
        this.f24850a = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        inflate(this.f24850a, R.layout.global_qr_code_input_layout_new, this);
    }

    public void initView(int i) {
        this.f24854e = i;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.inputContainer);
        linearLayout.removeAllViews();
        this.f24851b = new EditText[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.f24851b[i2] = (EditText) LayoutInflater.from(getContext()).inflate(R.layout.global_qr_input_edittext_new, linearLayout, false);
            this.f24851b[i2].setInputType(2);
            this.f24851b[i2].setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            this.f24851b[i2].addTextChangedListener(this);
            this.f24851b[i2].setOnFocusChangeListener(this);
            this.f24851b[i2].setOnKeyListener(this);
            this.f24851b[i2].setFocusable(true);
            this.f24851b[i2].setFitsSystemWindows(false);
            linearLayout.addView(this.f24851b[i2]);
            if (i2 < i - 1) {
                linearLayout.addView(LayoutInflater.from(getContext()).inflate(R.layout.global_qr_input_line_new, linearLayout, false));
            }
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        m19932a();
    }

    /* renamed from: a */
    private void m19932a() {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                EditText editText = QRCodeInputLayout.this.f24851b[0];
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                ((InputMethodManager) QRCodeInputLayout.this.f24850a.getSystemService("input_method")).showSoftInput(editText, 0);
            }
        }, 200);
    }

    public void afterTextChanged(Editable editable) {
        if (editable != null && editable.length() > 0) {
            m19937b();
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (z && (view instanceof EditText)) {
            ((EditText) view).setText((CharSequence) null);
            m19937b();
        }
    }

    /* renamed from: b */
    private void m19937b() {
        boolean z = false;
        for (EditText editText : this.f24851b) {
            if (m19934a(editText) || z) {
                editText.setFocusable(false);
            } else {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                z = true;
            }
        }
        if (z) {
            m19938c();
            return;
        }
        for (EditText editText2 : this.f24851b) {
            editText2.setFocusable(true);
            editText2.setFocusableInTouchMode(true);
        }
        requestFocus();
        m19939d();
    }

    /* renamed from: a */
    private boolean m19934a(EditText editText) {
        return editText != null && editText.getText().length() > 0;
    }

    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f24850a.getSystemService("input_method");
        for (EditText windowToken : this.f24851b) {
            inputMethodManager.hideSoftInputFromWindow(windowToken.getWindowToken(), 2);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.f24854e > 0 && i == 67 && keyEvent.getAction() == 0) {
            for (int i2 = this.f24854e - 1; i2 > 0; i2--) {
                EditText[] editTextArr = this.f24851b;
                if (view == editTextArr[i2] && !m19934a(editTextArr[i2])) {
                    this.f24851b[i2 - 1].setText((CharSequence) null);
                    m19937b();
                }
            }
        }
        return false;
    }

    public State getState() {
        return this.f24852c;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.f24853d = onStateChangedListener;
    }

    /* renamed from: c */
    private void m19938c() {
        if (this.f24852c.equals(State.COMPLETE)) {
            this.f24852c = State.INCOMPLETE;
            m19940e();
        }
    }

    /* renamed from: d */
    private void m19939d() {
        if (this.f24852c.equals(State.INCOMPLETE)) {
            this.f24852c = State.COMPLETE;
            m19940e();
        }
    }

    /* renamed from: e */
    private void m19940e() {
        OnStateChangedListener onStateChangedListener = this.f24853d;
        if (onStateChangedListener != null) {
            onStateChangedListener.onStateChanged(this.f24852c);
        }
    }

    public String getPin() {
        if (this.f24852c != State.COMPLETE) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (EditText text : this.f24851b) {
            sb.append(text.getText());
        }
        return sb.toString();
    }

    public void clearPin() {
        for (EditText text : this.f24851b) {
            text.getText().clear();
        }
        m19932a();
    }

    public boolean isCompleted() {
        return this.f24852c.equals(State.COMPLETE);
    }
}
