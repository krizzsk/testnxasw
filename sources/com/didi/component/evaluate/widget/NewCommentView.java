package com.didi.component.evaluate.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class NewCommentView extends FrameLayout implements TextWatcher, View.OnFocusChangeListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f15311a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f15312b;

    /* renamed from: c */
    private InputMethodManager f15313c;

    /* renamed from: d */
    private boolean f15314d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LinearLayout f15315e;

    /* renamed from: f */
    private View f15316f;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public boolean checkInputConnectionProxy(View view) {
        return true;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public NewCommentView(Context context) {
        super(context);
        m12612a();
    }

    public NewCommentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12612a();
    }

    public NewCommentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12612a();
    }

    /* renamed from: a */
    private void m12612a() {
        this.f15313c = (InputMethodManager) getContext().getSystemService("input_method");
        LayoutInflater.from(getContext()).inflate(R.layout.global_new_evaluate_comment_input_view, this);
        EditText editText = (EditText) findViewById(R.id.oc_evaluate_comment_view);
        this.f15311a = editText;
        editText.setOnFocusChangeListener(this);
        this.f15311a.addTextChangedListener(this);
        this.f15315e = (LinearLayout) findViewById(R.id.evaluate_comment_layout);
        View findViewById = findViewById(R.id.evaluate_comment_empty_view);
        this.f15316f = findViewById;
        findViewById.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                NewCommentView.this.hideSoftInput();
                return true;
            }
        });
        TextView textView = (TextView) findViewById(R.id.evaluate_comment_hint);
        this.f15312b = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NewCommentView.this.f15312b.setVisibility(8);
                NewCommentView.this.f15315e.setVisibility(0);
                NewCommentView.this.f15311a.requestFocus();
                NewCommentView newCommentView = NewCommentView.this;
                newCommentView.showSoftInput(newCommentView.f15311a);
            }
        });
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f15314d = true;
            return;
        }
        this.f15314d = false;
        hideSoftInput();
        m12616c();
    }

    public void showSoftInput(View view) {
        this.f15313c.showSoftInput(view, 0);
    }

    public void hideSoftInput() {
        this.f15313c.hideSoftInputFromWindow(this.f15311a.getWindowToken(), 0);
    }

    public String getText() {
        return this.f15311a.getText().toString().trim();
    }

    /* renamed from: b */
    private void m12614b() {
        this.f15315e.setVisibility(0);
        this.f15312b.setVisibility(8);
    }

    /* renamed from: c */
    private void m12616c() {
        this.f15315e.setVisibility(8);
        this.f15312b.setVisibility(0);
        this.f15312b.setText(this.f15311a.getText());
    }

    public void clearFocus() {
        super.clearFocus();
        this.f15311a.clearFocus();
    }

    public boolean isFocused() {
        return this.f15311a.isFocused();
    }

    public void setContent(String str) {
        this.f15311a.setVisibility(8);
    }

    public int onKeyboardHeightChange(int i) {
        if (i <= 0 || !this.f15314d) {
            return 0;
        }
        m12614b();
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void setEnable(boolean z) {
        this.f15311a.setEnabled(z);
    }
}
