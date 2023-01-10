package com.didi.component.common.widget.pin;

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
import android.widget.RelativeLayout;
import com.taxis99.R;

public class PinInputLayout extends FrameLayout implements TextWatcher, View.OnFocusChangeListener, View.OnKeyListener {

    /* renamed from: a */
    private Context f13907a;

    /* renamed from: b */
    private RelativeLayout f13908b;

    /* renamed from: c */
    private RelativeLayout f13909c;

    /* renamed from: d */
    private RelativeLayout f13910d;

    /* renamed from: e */
    private EditText f13911e;

    /* renamed from: f */
    private EditText f13912f;

    /* renamed from: g */
    private EditText f13913g;

    /* renamed from: h */
    private boolean f13914h = true;

    /* renamed from: i */
    private State f13915i = State.INCOMPLETE;

    /* renamed from: j */
    private OnStateChangedListener f13916j;

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

    public PinInputLayout(Context context) {
        super(context);
        m11519a(context);
    }

    public PinInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11519a(context);
    }

    public PinInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11519a(context);
    }

    /* renamed from: a */
    private void m11519a(Context context) {
        this.f13907a = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        inflate(this.f13907a, R.layout.global_pin_input_layout, this);
        this.f13908b = (RelativeLayout) findViewById(R.id.oc_pin_input_edit_text_bg_layout_1);
        this.f13909c = (RelativeLayout) findViewById(R.id.oc_pin_input_edit_text_bg_layout_2);
        this.f13910d = (RelativeLayout) findViewById(R.id.oc_pin_input_edit_text_bg_layout_3);
        this.f13911e = (EditText) findViewById(R.id.oc_pin_input_edit_text_1);
        this.f13912f = (EditText) findViewById(R.id.oc_pin_input_edit_text_2);
        this.f13913g = (EditText) findViewById(R.id.oc_pin_input_edit_text_3);
        this.f13911e.setInputType(2);
        this.f13911e.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        this.f13911e.addTextChangedListener(this);
        this.f13911e.setOnFocusChangeListener(this);
        this.f13911e.setOnKeyListener(this);
        this.f13911e.setFocusable(true);
        this.f13912f.setInputType(2);
        this.f13912f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        this.f13912f.addTextChangedListener(this);
        this.f13912f.setOnFocusChangeListener(this);
        this.f13912f.setOnKeyListener(this);
        this.f13912f.setFocusable(false);
        this.f13913g.setInputType(2);
        this.f13913g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        this.f13913g.addTextChangedListener(this);
        this.f13913g.setOnFocusChangeListener(this);
        this.f13913g.setOnKeyListener(this);
        this.f13913g.setFocusable(false);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void afterTextChanged(Editable editable) {
        if (editable != null && editable.length() > 0) {
            m11518a();
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (z && (view instanceof EditText)) {
            ((EditText) view).setText((CharSequence) null);
            m11518a();
        }
    }

    /* renamed from: a */
    private void m11518a() {
        if (!m11520a(this.f13911e)) {
            this.f13911e.setFocusable(true);
            this.f13911e.setFocusableInTouchMode(true);
            this.f13911e.requestFocus();
            this.f13912f.setFocusable(false);
            this.f13913g.setFocusable(false);
            m11522c();
        } else if (!m11520a(this.f13912f)) {
            this.f13912f.setFocusable(true);
            this.f13912f.setFocusableInTouchMode(true);
            this.f13912f.requestFocus();
            this.f13911e.setFocusable(false);
            this.f13913g.setFocusable(false);
            m11522c();
        } else if (!m11520a(this.f13913g)) {
            this.f13913g.setFocusable(true);
            this.f13913g.setFocusableInTouchMode(true);
            this.f13913g.requestFocus();
            this.f13911e.setFocusable(false);
            this.f13912f.setFocusable(false);
            m11522c();
        } else {
            this.f13911e.setFocusable(true);
            this.f13911e.setFocusableInTouchMode(true);
            this.f13912f.setFocusable(true);
            this.f13912f.setFocusableInTouchMode(true);
            this.f13913g.setFocusable(true);
            this.f13913g.setFocusableInTouchMode(true);
            requestFocus();
            m11521b();
            m11523d();
        }
    }

    /* renamed from: a */
    private boolean m11520a(EditText editText) {
        return editText != null && editText.getText().length() > 0;
    }

    /* renamed from: b */
    private void m11521b() {
        ((InputMethodManager) this.f13907a.getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 67 || keyEvent.getAction() != 0) {
            return false;
        }
        EditText editText = this.f13913g;
        if (view != editText || m11520a(editText)) {
            EditText editText2 = this.f13912f;
            if (view != editText2 || m11520a(editText2)) {
                return false;
            }
            this.f13911e.setText((CharSequence) null);
            m11518a();
            return false;
        }
        this.f13912f.setText((CharSequence) null);
        m11518a();
        return false;
    }

    public State getState() {
        return this.f13915i;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.f13916j = onStateChangedListener;
    }

    /* renamed from: c */
    private void m11522c() {
        if (this.f13915i.equals(State.COMPLETE)) {
            this.f13915i = State.INCOMPLETE;
            m11524e();
        }
    }

    /* renamed from: d */
    private void m11523d() {
        if (this.f13915i.equals(State.INCOMPLETE)) {
            this.f13915i = State.COMPLETE;
            m11524e();
        }
    }

    /* renamed from: e */
    private void m11524e() {
        OnStateChangedListener onStateChangedListener = this.f13916j;
        if (onStateChangedListener != null) {
            onStateChangedListener.onStateChanged(this.f13915i);
        }
    }

    public String getPin() {
        if (this.f13915i != State.COMPLETE) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13911e.getText());
        sb.append(this.f13912f.getText());
        sb.append(this.f13913g.getText());
        return sb.toString();
    }

    public void setEditable(boolean z) {
        if (z) {
            this.f13908b.setBackgroundResource(R.drawable.pin_input_layout_edit_text_editable_bg);
            this.f13909c.setBackgroundResource(R.drawable.pin_input_layout_edit_text_editable_bg);
            this.f13910d.setBackgroundResource(R.drawable.pin_input_layout_edit_text_editable_bg);
            this.f13911e.setEnabled(true);
            this.f13912f.setEnabled(true);
            this.f13913g.setEnabled(true);
        } else {
            this.f13908b.setBackgroundResource(R.drawable.pin_input_layout_edit_text_uneditable_bg);
            this.f13909c.setBackgroundResource(R.drawable.pin_input_layout_edit_text_uneditable_bg);
            this.f13910d.setBackgroundResource(R.drawable.pin_input_layout_edit_text_uneditable_bg);
            this.f13911e.setEnabled(false);
            this.f13912f.setEnabled(false);
            this.f13913g.setEnabled(false);
        }
        this.f13914h = z;
    }

    public boolean isEditable() {
        return this.f13914h;
    }

    public boolean isCompleted() {
        return this.f13915i.equals(State.COMPLETE);
    }
}
