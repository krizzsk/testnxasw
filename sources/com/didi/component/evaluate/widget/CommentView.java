package com.didi.component.evaluate.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.taxis99.R;

public class CommentView extends FrameLayout implements TextWatcher, View.OnFocusChangeListener {

    /* renamed from: b */
    private static final int f15277b = 140;

    /* renamed from: c */
    private static final int f15278c = 4;

    /* renamed from: d */
    private static final int f15279d = 3;

    /* renamed from: e */
    private static final int f15280e = 6;

    /* renamed from: f */
    private static final String f15281f = "comment";

    /* renamed from: a */
    boolean f15282a = false;

    /* renamed from: g */
    private EditText f15283g;

    /* renamed from: h */
    private TextView f15284h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f15285i = 1;

    /* renamed from: j */
    private EditTextHeightAnimator f15286j;

    /* renamed from: k */
    private RelativeLayout f15287k;

    /* renamed from: l */
    private TextView f15288l;

    /* renamed from: m */
    private OnContentChangeListener f15289m;
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());

    public interface OnContentChangeListener {
        void onContentChange(CharSequence charSequence);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public boolean checkInputConnectionProxy(View view) {
        return true;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public CommentView(Context context) {
        super(context);
        m12594a();
    }

    public CommentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12594a();
    }

    public CommentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12594a();
    }

    public CommentView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m12594a();
    }

    /* renamed from: a */
    private void m12594a() {
        LayoutInflater.from(getContext()).inflate(R.layout.global_evaluate_comment_input_view, this);
        EditText editText = (EditText) findViewById(R.id.oc_evaluate_comment_view);
        this.f15283g = editText;
        editText.setOnFocusChangeListener(this);
        this.f15283g.addTextChangedListener(this);
        TextView textView = (TextView) findViewById(R.id.oc_evaluate_comment_text_limit_view);
        this.f15284h = textView;
        textView.setText(String.valueOf(140));
        this.f15287k = (RelativeLayout) findViewById(R.id.rly_content_container);
        this.f15288l = (TextView) findViewById(R.id.oc_evaluate_comment_content_view);
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f15282a = true;
            this.f15284h.setVisibility(0);
            return;
        }
        this.f15282a = false;
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f15283g.getWindowToken(), 0);
        m12598d();
        this.f15284h.setVisibility(8);
    }

    public String getText() {
        return this.f15283g.getText().toString().trim();
    }

    public void afterTextChanged(Editable editable) {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < editable.length(); i3++) {
            if (editable.charAt(i3) == 10) {
                i2++;
            }
        }
        if (i2 > 3) {
            editable.delete(editable.length() - 1, editable.length());
        }
        if (editable.length() <= 140) {
            m12596b();
        }
        int length = 140 - editable.length();
        TextView textView = this.f15284h;
        StringBuilder sb = new StringBuilder();
        if (length >= 0) {
            i = length;
        }
        sb.append(i);
        sb.append("");
        textView.setText(sb.toString());
        OnContentChangeListener onContentChangeListener = this.f15289m;
        if (onContentChangeListener != null) {
            onContentChangeListener.onContentChange(editable.toString());
        }
    }

    /* renamed from: b */
    private void m12596b() {
        this.mLogger.info("update height on focus", new Object[0]);
        EditTextHeightAnimator editTextHeightAnimator = this.f15286j;
        if (editTextHeightAnimator != null && editTextHeightAnimator.isStarted() && this.f15286j.isRunning()) {
            this.f15286j.end();
        }
        int max = Math.max(m12597c(), 4);
        if (max != this.f15285i) {
            m12595a(max);
        }
    }

    /* renamed from: c */
    private int m12597c() {
        int lineCount = this.f15283g.getLineCount();
        if (lineCount >= 4) {
            return 4;
        }
        return lineCount;
    }

    /* renamed from: d */
    private void m12598d() {
        EditTextHeightAnimator editTextHeightAnimator = this.f15286j;
        if (editTextHeightAnimator != null && editTextHeightAnimator.isStarted() && this.f15286j.isRunning()) {
            this.f15286j.end();
        }
        int i = 4;
        if (this.f15283g.getLineCount() <= 4) {
            i = this.f15283g.getLineCount();
        }
        m12595a(i);
    }

    /* renamed from: a */
    private void m12595a(final int i) {
        EditTextHeightAnimator editTextHeightAnimator = new EditTextHeightAnimator(this.f15283g, this.f15285i, i);
        this.f15286j = editTextHeightAnimator;
        editTextHeightAnimator.setOnFinishListener(new EditTextHeightAnimator.OnFinishListener() {
            public void onFinish() {
                int unused = CommentView.this.f15285i = i;
            }
        });
        this.f15286j.start();
    }

    public void clearFocus() {
        super.clearFocus();
        this.f15283g.clearFocus();
    }

    public boolean isFocused() {
        return this.f15283g.isFocused();
    }

    public void setContent(String str) {
        this.f15283g.setVisibility(8);
        this.f15284h.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.f15287k.setVisibility(0);
            this.f15288l.setText(str);
        }
    }

    public int onKeyboardHeightChange(int i) {
        EditTextHeightAnimator editTextHeightAnimator;
        if (i > 0 && this.f15282a) {
            m12596b();
        }
        if (Math.max(m12597c(), 4) == this.f15285i || (editTextHeightAnimator = this.f15286j) == null) {
            return 0;
        }
        return editTextHeightAnimator.mDeltaHeight;
    }

    public int getFullHeight() {
        EditTextHeightAnimator editTextHeightAnimator = this.f15286j;
        if (editTextHeightAnimator != null) {
            return editTextHeightAnimator.getTargetHeight();
        }
        return this.f15288l.getLineHeight() * 2;
    }

    public void setOnContentChangeListener(OnContentChangeListener onContentChangeListener) {
        this.f15289m = onContentChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    static class EditTextHeightAnimator extends ValueAnimator implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        /* access modifiers changed from: private */
        public int mDeltaHeight;
        private OnFinishListener mEndListener;
        private int mOriginalHeight;
        private EditText mView;

        public interface OnFinishListener {
            void onFinish();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public EditTextHeightAnimator(EditText editText, int i, int i2) {
            this.mView = editText;
            int lineHeight = editText.getLineHeight() + (Build.VERSION.SDK_INT >= 16 ? (int) editText.getLineSpacingExtra() : 0);
            this.mDeltaHeight = (i2 - i) * lineHeight;
            this.mOriginalHeight = (i * lineHeight) + this.mView.getPaddingBottom() + this.mView.getPaddingTop();
        }

        public void start() {
            setIntValues(new int[]{0, this.mDeltaHeight});
            setDuration((long) (Math.abs(this.mDeltaHeight) * 2));
            setInterpolator(new LinearInterpolator());
            addUpdateListener(this);
            addListener(this);
            super.start();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.mView.setHeight(this.mOriginalHeight + ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }

        public void setOnFinishListener(OnFinishListener onFinishListener) {
            this.mEndListener = onFinishListener;
        }

        public void onAnimationEnd(Animator animator) {
            OnFinishListener onFinishListener = this.mEndListener;
            if (onFinishListener != null) {
                onFinishListener.onFinish();
                if (this.mView.getLineCount() < 4) {
                    this.mView.setMaxLines(4);
                } else {
                    this.mView.setMaxLines(6);
                }
                this.mView.requestLayout();
            }
        }

        public void end() {
            super.end();
        }

        public int getTargetHeight() {
            return this.mDeltaHeight;
        }
    }
}
