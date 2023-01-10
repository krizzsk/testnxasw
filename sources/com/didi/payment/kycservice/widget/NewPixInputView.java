package com.didi.payment.kycservice.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 P2\u00020\u0001:\u0001PB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0015J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u001aJ\u0006\u0010&\u001a\u00020\u001aJ\u001e\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tJ&\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020$J\u0018\u0010'\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0002J\b\u0010-\u001a\u00020\u001aH\u0002J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020/J\u000e\u00101\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J-\u00102\u001a\u00020\u001a2%\u00103\u001a!\u0012\u0015\u0012\u0013\u0018\u000105¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u001a\u0018\u000104J\u000e\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020$J\u000e\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020/J\u000e\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020?J\u000e\u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020/J\u000e\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020DJ\u000e\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020$J\u000e\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020IJ\u0006\u0010J\u001a\u00020\u001aJ\u000e\u0010K\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020$J\u0016\u0010M\u001a\u00020\u001a2\u0006\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020/R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006Q"}, mo148868d2 = {"Lcom/didi/payment/kycservice/widget/NewPixInputView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBottomLine", "Landroid/view/View;", "mCheckBox", "Landroid/widget/CheckBox;", "mCheckBoxTitle", "Landroid/widget/TextView;", "mDeleteBtn", "Landroid/widget/ImageView;", "mErrorTv", "mInputEt", "Landroid/widget/EditText;", "mMaxSize", "mTitleTv", "onLoseFocus", "Lkotlin/Function0;", "", "getOnLoseFocus", "()Lkotlin/jvm/functions/Function0;", "setOnLoseFocus", "(Lkotlin/jvm/functions/Function0;)V", "addTextChangeListener", "textWatcher", "Landroid/text/TextWatcher;", "getEditText", "getInputStr", "", "hideCheckBox", "hideErrorInfo", "initData", "titleText", "", "maxSize", "inputType", "hintText", "initListener", "isCheckBoxChecked", "", "isInputNotBlank", "removeTextChangeListener", "setAfterTextChangedListener", "afterTextChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "Lkotlin/ParameterName;", "name", "s", "setCheckBoxTitle", "string", "setCheckedState", "state", "setEditTextClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "setEditViewEnabled", "enabled", "setFilter", "filter", "Landroid/text/InputFilter;", "setInputStr", "text", "setOnCheckBoxCheckedChange", "listener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "showCheckBox", "showErrorInfo", "errorInfo", "updateKeyboardChange", "isShow", "isValidData", "Companion", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: NewPixInputView.kt */
public final class NewPixInputView extends RelativeLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: j */
    private static final int f33486j = 1;

    /* renamed from: k */
    private static final int f33487k = 0;

    /* renamed from: a */
    private TextView f33488a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f33489b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f33490c;

    /* renamed from: d */
    private View f33491d;

    /* renamed from: e */
    private int f33492e;

    /* renamed from: f */
    private TextView f33493f;

    /* renamed from: g */
    private CheckBox f33494g;

    /* renamed from: h */
    private TextView f33495h;

    /* renamed from: i */
    private Function0<Unit> f33496i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewPixInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.KycPixInputView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.KycPixInputView)");
        if (obtainStyledAttributes.getInt(0, 1) == 1) {
            LayoutInflater.from(context).inflate(R.layout.kyc_input_view_with_title, this, true);
            this.f33488a = (TextView) findViewById(R.id.pix_input_view_title);
            this.f33493f = (TextView) findViewById(R.id.input_view_error_info);
            this.f33494g = (CheckBox) findViewById(R.id.input_check_box);
            this.f33495h = (TextView) findViewById(R.id.input_check_box_title);
        } else {
            LayoutInflater.from(context).inflate(R.layout.kyc_input_view_without_title, this, true);
        }
        View findViewById = findViewById(R.id.pix_input_view_et);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.pix_input_view_et)");
        this.f33489b = (EditText) findViewById;
        View findViewById2 = findViewById(R.id.pix_input_view_delete_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.pix_input_view_delete_btn)");
        this.f33490c = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.pix_input_view_bottom_line);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.pix_input_view_bottom_line)");
        this.f33491d = findViewById3;
        m25417a();
    }

    public final Function0<Unit> getOnLoseFocus() {
        return this.f33496i;
    }

    public final void setOnLoseFocus(Function0<Unit> function0) {
        this.f33496i = function0;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/payment/kycservice/widget/NewPixInputView$Companion;", "", "()V", "WITHOUT_TITLE", "", "WITH_TITLE", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: NewPixInputView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NewPixInputView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NewPixInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a */
    private final void m25417a() {
        this.f33489b.addTextChangedListener(new C11582xbcdc2b75(this));
        this.f33489b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                NewPixInputView.m25420a(NewPixInputView.this, view, z);
            }
        });
        this.f33490c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NewPixInputView.m25419a(NewPixInputView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25420a(NewPixInputView newPixInputView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(newPixInputView, "this$0");
        if (!z) {
            newPixInputView.f33490c.setVisibility(8);
            Function0<Unit> onLoseFocus = newPixInputView.getOnLoseFocus();
            if (onLoseFocus != null) {
                onLoseFocus.invoke();
            }
        } else if (!TextUtils.isEmpty(newPixInputView.f33489b.getText().toString())) {
            newPixInputView.f33490c.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25419a(NewPixInputView newPixInputView, View view) {
        Intrinsics.checkNotNullParameter(newPixInputView, "this$0");
        newPixInputView.f33489b.setText("");
    }

    /* renamed from: a */
    private final void m25418a(int i, int i2) {
        this.f33489b.setInputType(i2);
        this.f33489b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        this.f33492e = i;
    }

    public final void initData(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "titleText");
        TextView textView = this.f33488a;
        if (textView != null) {
            textView.setText(charSequence);
        }
        m25418a(i, i2);
    }

    public final void initData(CharSequence charSequence, int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(charSequence, "titleText");
        Intrinsics.checkNotNullParameter(str, "hintText");
        this.f33489b.setHint(str);
        initData(charSequence, i, i2);
    }

    public final String getInputStr() {
        return this.f33489b.getText().toString();
    }

    public final void setInputStr(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.f33489b.setText(str);
    }

    public final void addTextChangeListener(TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "textWatcher");
        this.f33489b.addTextChangedListener(textWatcher);
    }

    public final void removeTextChangeListener(TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "textWatcher");
        this.f33489b.removeTextChangedListener(textWatcher);
    }

    public final void setFilter(InputFilter inputFilter) {
        Intrinsics.checkNotNullParameter(inputFilter, "filter");
        this.f33489b.setFilters(new InputFilter[]{inputFilter, new InputFilter.LengthFilter(this.f33492e)});
    }

    public final void updateKeyboardChange(boolean z, boolean z2) {
        if (!z) {
            this.f33489b.clearFocus();
            this.f33490c.setVisibility(8);
            if (!z2) {
                EditText editText = this.f33489b;
                Context context = getContext();
                Intrinsics.checkNotNull(context);
                editText.setTextColor(ContextCompat.getColor(context, R.color.wallet_color_FF525D));
                return;
            }
            return;
        }
        this.f33490c.setVisibility(0);
        this.f33489b.requestFocus();
    }

    public final void setEditViewEnabled(boolean z) {
        this.f33489b.setEnabled(z);
    }

    public final void setEditTextClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
        this.f33489b.setOnClickListener(onClickListener);
    }

    public final void showErrorInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "errorInfo");
        TextView textView = this.f33493f;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.f33493f;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    public final void hideErrorInfo() {
        TextView textView = this.f33493f;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void showCheckBox() {
        CheckBox checkBox = this.f33494g;
        if (checkBox != null) {
            checkBox.setVisibility(0);
        }
        TextView textView = this.f33495h;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public final void hideCheckBox() {
        CheckBox checkBox = this.f33494g;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        TextView textView = this.f33495h;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void setCheckBoxTitle(String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        CheckBox checkBox = this.f33494g;
        if (checkBox != null) {
            checkBox.setVisibility(0);
        }
        TextView textView = this.f33495h;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.f33495h;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    public final boolean isCheckBoxChecked() {
        CheckBox checkBox = this.f33494g;
        if (checkBox == null) {
            return false;
        }
        return checkBox.isChecked();
    }

    public final void setCheckedState(boolean z) {
        CheckBox checkBox = this.f33494g;
        if (checkBox != null) {
            checkBox.setChecked(z);
        }
    }

    public final void setOnCheckBoxCheckedChange(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Intrinsics.checkNotNullParameter(onCheckedChangeListener, "listener");
        CheckBox checkBox = this.f33494g;
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public final void setAfterTextChangedListener(Function1<? super Editable, Unit> function1) {
        this.f33489b.addTextChangedListener(new NewPixInputView$setAfterTextChangedListener$1(function1));
    }

    public final EditText getEditText() {
        return this.f33489b;
    }

    public final boolean isInputNotBlank() {
        return !StringsKt.isBlank(getInputStr());
    }
}
