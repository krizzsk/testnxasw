package com.didi.payment.pix.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0019J\u0016\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020&R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, mo148868d2 = {"Lcom/didi/payment/pix/widget/PixInputView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBottomLine", "Landroid/view/View;", "mDeleteBtn", "Landroid/widget/ImageView;", "mInputEt", "Landroid/widget/EditText;", "mMaxSize", "mTitleTv", "Landroid/widget/TextView;", "addTextChangeListener", "", "textWatcher", "Landroid/text/TextWatcher;", "getInputStr", "", "initData", "titleText", "", "maxSize", "inputType", "initListener", "removeTextChangeListener", "setEditTextClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "setEditViewEnabled", "enabled", "", "setFilter", "filter", "Landroid/text/InputFilter;", "setInputStr", "text", "updateKeyboardChange", "isShow", "isValidData", "Companion", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixInputView.kt */
public final class PixInputView extends RelativeLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: f */
    private static final int f33824f = 1;

    /* renamed from: g */
    private static final int f33825g = 0;

    /* renamed from: a */
    private TextView f33826a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f33827b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f33828c;

    /* renamed from: d */
    private View f33829d;

    /* renamed from: e */
    private int f33830e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.PixInputView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.PixInputView)");
        if (obtainStyledAttributes.getInt(0, 1) == 1) {
            LayoutInflater.from(context).inflate(R.layout.pix_input_view_with_title, this, true);
            this.f33826a = (TextView) findViewById(R.id.pix_input_view_title);
        } else {
            LayoutInflater.from(context).inflate(R.layout.pix_input_view_without_title, this, true);
        }
        View findViewById = findViewById(R.id.pix_input_view_et);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.pix_input_view_et)");
        this.f33827b = (EditText) findViewById;
        View findViewById2 = findViewById(R.id.pix_input_view_delete_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.pix_input_view_delete_btn)");
        this.f33828c = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.pix_input_view_bottom_line);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.pix_input_view_bottom_line)");
        this.f33829d = findViewById3;
        m25684a();
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/payment/pix/widget/PixInputView$Companion;", "", "()V", "WITHOUT_TITLE", "", "WITH_TITLE", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PixInputView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PixInputView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PixInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a */
    private final void m25684a() {
        this.f33827b.addTextChangedListener(new C11688x7c30ccf5(this));
        this.f33827b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                PixInputView.m25687a(PixInputView.this, view, z);
            }
        });
        this.f33828c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixInputView.m25686a(PixInputView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25687a(PixInputView pixInputView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(pixInputView, "this$0");
        if (!z) {
            pixInputView.f33828c.setVisibility(8);
        } else if (!TextUtils.isEmpty(pixInputView.f33827b.getText().toString())) {
            pixInputView.f33828c.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25686a(PixInputView pixInputView, View view) {
        Intrinsics.checkNotNullParameter(pixInputView, "this$0");
        pixInputView.f33827b.setText("");
    }

    /* renamed from: a */
    private final void m25685a(int i, int i2) {
        this.f33827b.setInputType(i2);
        this.f33827b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        this.f33830e = i;
    }

    public final void initData(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "titleText");
        TextView textView = this.f33826a;
        if (textView != null) {
            textView.setText(charSequence);
        }
        m25685a(i, i2);
    }

    public final String getInputStr() {
        return this.f33827b.getText().toString();
    }

    public final void setInputStr(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.f33827b.setText(str);
    }

    public final void addTextChangeListener(TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "textWatcher");
        this.f33827b.addTextChangedListener(textWatcher);
    }

    public final void removeTextChangeListener(TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "textWatcher");
        this.f33827b.removeTextChangedListener(textWatcher);
    }

    public final void setFilter(InputFilter inputFilter) {
        Intrinsics.checkNotNullParameter(inputFilter, "filter");
        this.f33827b.setFilters(new InputFilter[]{inputFilter, new InputFilter.LengthFilter(this.f33830e)});
    }

    public final void updateKeyboardChange(boolean z, boolean z2) {
        if (!z) {
            this.f33827b.clearFocus();
            this.f33828c.setVisibility(8);
            if (!z2) {
                EditText editText = this.f33827b;
                Context context = getContext();
                Intrinsics.checkNotNull(context);
                editText.setTextColor(ContextCompat.getColor(context, R.color.wallet_color_FF525D));
                return;
            }
            return;
        }
        this.f33828c.setVisibility(0);
        this.f33827b.requestFocus();
    }

    public final void setEditViewEnabled(boolean z) {
        this.f33827b.setEnabled(z);
    }

    public final void setEditTextClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
        this.f33827b.setFocusable(false);
        this.f33827b.setOnClickListener(onClickListener);
    }
}
