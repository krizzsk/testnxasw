package com.didi.unifylogin.utils.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.didi.passenger.C11267R;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.unifylogin.utils.LoginDisplayMetrics;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.UiUtils;
import com.didi.unifylogin.utils.customview.CodeInputEditText;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CodeInputView extends LinearLayout {

    /* renamed from: a */
    private static final String f47620a = "CodeInputView";

    /* renamed from: b */
    private static final int f47621b = 4;

    /* renamed from: c */
    private int f47622c;

    /* renamed from: d */
    private int f47623d;

    /* renamed from: e */
    private int f47624e;

    /* renamed from: f */
    private int f47625f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<CodeInputEditText> f47626g;

    /* renamed from: h */
    private Context f47627h;

    /* renamed from: i */
    private AttributeSet f47628i;

    /* renamed from: j */
    private InputCompleteListener f47629j;

    /* renamed from: k */
    private ClearCodeListener f47630k;

    public interface ClearCodeListener {
        void onClearCode();
    }

    public interface InputCompleteListener {
        void onInputComplete(String str);
    }

    public CodeInputView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CodeInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f47627h = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.MyCoedEdit);
        this.f47622c = obtainStyledAttributes.getInt(0, 4);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C11267R.styleable.CodeInputView);
        this.f47623d = obtainStyledAttributes2.getInt(0, -1);
        obtainStyledAttributes2.recycle();
    }

    /* renamed from: a */
    private void m35721a(int i) {
        if (i > 0) {
            for (CodeInputEditText inputType : this.f47626g) {
                inputType.setInputType(i);
            }
        }
    }

    /* renamed from: a */
    private void m35722a(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.login_unify_view_code_input, this).findViewById(R.id.ll_code_layout);
        int width = (int) (((float) LoginDisplayMetrics.getWidth(context)) - (LoginDisplayMetrics.getDensity(context) * 40.0f));
        this.f47624e = UiUtils.dip2px(context, 48.0f);
        int dip2px = UiUtils.dip2px(context, 32.0f);
        this.f47625f = dip2px;
        int i = this.f47624e;
        int i2 = this.f47622c;
        int i3 = (i * i2) + (dip2px * (i2 - 1));
        if (i3 > width) {
            int dip2px2 = UiUtils.dip2px(context, 10.0f);
            while (true) {
                int i4 = this.f47625f;
                if (i4 >= dip2px2 && i3 > width) {
                    int i5 = i4 - 10;
                    this.f47625f = i5;
                    int i6 = this.f47624e;
                    int i7 = this.f47622c;
                    i3 = (i6 * i7) + (i5 * (i7 - 1));
                }
            }
            if (this.f47625f < dip2px2) {
                this.f47625f = dip2px2;
                int i8 = this.f47624e;
                int i9 = this.f47622c;
                int i10 = (i8 * i9) + (dip2px2 * (i9 - 1));
                while (true) {
                    int i11 = this.f47624e;
                    if (i11 <= 0 || i10 <= width) {
                        break;
                    }
                    int i12 = i11 - 10;
                    this.f47624e = i12;
                    int i13 = this.f47622c;
                    i10 = (i12 * i13) + (this.f47625f * (i13 - 1));
                }
            }
        }
        LoginLog.write("CodeInputView width:" + width);
        LoginLog.write("CodeInputView boxw :" + this.f47624e);
        LoginLog.write("CodeInputView margin:" + this.f47625f);
        if (this.f47624e > 0) {
            this.f47626g = new ArrayList();
            for (int i14 = 0; i14 < this.f47622c; i14++) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.login_unify_code_edit, (ViewGroup) null);
                CodeInputEditText codeInputEditText = (CodeInputEditText) inflate.findViewById(R.id.small_login_cod);
                codeInputEditText.setContentDescription(RavenKey.STACK + i14);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) codeInputEditText.getLayoutParams();
                layoutParams.height = this.f47624e;
                layoutParams.width = this.f47624e;
                layoutParams.weight = 1.0f;
                if (i14 == this.f47622c - 1) {
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.setMargins(0, 0, this.f47625f, 0);
                    layoutParams.setMarginEnd(this.f47625f);
                }
                codeInputEditText.setVisibility(0);
                this.f47626g.add(codeInputEditText);
                linearLayout.addView(inflate);
            }
            CodeFocusChangeListener codeFocusChangeListener = new CodeFocusChangeListener();
            for (CodeInputEditText next : this.f47626g) {
                next.setOnFocusChangeListener(codeFocusChangeListener);
                next.addTextChangedListener(new CodeTextChangedListener(this.f47626g.indexOf(next)));
                next.setDelKeyEventListener(new CodeInputEditText.OnDelKeyEventListener() {
                    public void onDeleteClick(CodeInputEditText codeInputEditText) {
                        if (TextUtils.isEmpty(codeInputEditText.getText().toString())) {
                            CodeInputView.this.m35725b((EditText) codeInputEditText);
                        }
                    }
                });
            }
        }
    }

    public void setCode(final String str) {
        SystemUtils.log(3, f47620a, "[setCode] " + str, (Throwable) null, "com.didi.unifylogin.utils.customview.CodeInputView", 153);
        if (!TextUtils.isEmpty(str) && str.length() == this.f47626g.size()) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    int i = 0;
                    while (i < CodeInputView.this.f47626g.size() && i < str.length()) {
                        int i2 = i + 1;
                        ((CodeInputEditText) CodeInputView.this.f47626g.get(i)).setText(str.substring(i, i2));
                        i = i2;
                    }
                }
            });
        }
    }

    public String getCode() {
        StringBuilder sb = new StringBuilder();
        for (CodeInputEditText text : this.f47626g) {
            sb.append(text.getText().toString());
        }
        return sb.toString();
    }

    /* renamed from: a */
    private boolean m35724a(EditText editText) {
        return !TextUtils.isEmpty(editText.getText().toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35720a() {
        for (CodeInputEditText a : this.f47626g) {
            if (!m35724a((EditText) a)) {
                return;
            }
        }
        SystemUtils.log(4, f47620a, "checkComplete: ", (Throwable) null, "com.didi.unifylogin.utils.customview.CodeInputView", 186);
        InputCompleteListener inputCompleteListener = this.f47629j;
        if (inputCompleteListener != null) {
            inputCompleteListener.onInputComplete(getCode());
        }
    }

    public void clearCode() {
        for (CodeInputEditText text : this.f47626g) {
            text.setText("");
        }
        this.f47626g.get(0).requestFocus();
        ClearCodeListener clearCodeListener = this.f47630k;
        if (clearCodeListener != null) {
            clearCodeListener.onClearCode();
        }
    }

    public EditText getCodeView(int i) {
        List<CodeInputEditText> list = this.f47626g;
        if (list != null && i < list.size()) {
            return this.f47626g.get(0);
        }
        return null;
    }

    class CodeFocusChangeListener implements View.OnFocusChangeListener {
        CodeFocusChangeListener() {
        }

        public void onFocusChange(View view, boolean z) {
            SystemUtils.log(3, "tom", "onFocusChange viewId: " + view.getId() + " focus: " + z, (Throwable) null, "com.didi.unifylogin.utils.customview.CodeInputView$CodeFocusChangeListener", 216);
        }
    }

    class CodeTextChangedListener extends LoginTextWatcher {
        int index = 0;

        public CodeTextChangedListener(int i) {
            this.index = i;
        }

        public void afterTextChanged(Editable editable) {
            int i;
            SystemUtils.log(3, CodeInputView.f47620a, "afterTextChanged: " + editable.toString(), (Throwable) null, "com.didi.unifylogin.utils.customview.CodeInputView$CodeTextChangedListener", 238);
            int i2 = this.index;
            if (i2 >= 0 && i2 <= CodeInputView.this.f47626g.size() && !TextUtil.isEmpty(editable.toString())) {
                boolean z = ((CodeInputEditText) CodeInputView.this.f47626g.get(this.index)).getSelectionStart() == 1;
                if (editable.length() > 1) {
                    int length = editable.length();
                    String obj = editable.toString();
                    if (z) {
                        i = 0;
                    } else {
                        i = editable.length() - 1;
                    }
                    editable.replace(0, length, obj, i, z ? 1 : editable.length());
                    return;
                }
                if (this.index + 1 < CodeInputView.this.f47626g.size()) {
                    ((CodeInputEditText) CodeInputView.this.f47626g.get(this.index + 1)).requestFocus();
                }
                CodeInputView.this.m35720a();
            }
        }
    }

    public void setInputCompleteListener(InputCompleteListener inputCompleteListener) {
        this.f47629j = inputCompleteListener;
    }

    public void setClearCodeListener(ClearCodeListener clearCodeListener) {
        this.f47630k = clearCodeListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m35725b(EditText editText) {
        int indexOf = this.f47626g.indexOf(editText);
        if (indexOf > 0) {
            int i = indexOf - 1;
            this.f47626g.get(i).setText("");
            this.f47626g.get(i).requestFocus();
        }
    }

    public CodeInputView setCodeLength(int i) {
        if (i > 0) {
            this.f47622c = i;
        }
        return this;
    }

    public CodeInputView setInputyType(int i) {
        this.f47623d = i;
        return this;
    }

    public void build() {
        m35722a(this.f47627h);
        m35721a(this.f47623d);
    }
}
