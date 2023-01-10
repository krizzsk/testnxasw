package com.didi.soda.customer.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import com.didi.soda.customer.foundation.util.CustomerFixLineHeightSpan;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;

public class CustomerFixLineHeightTextView extends CustomerAppCompatTextView {

    /* renamed from: a */
    private int f44078a;

    public CustomerFixLineHeightTextView(Context context) {
        super(context);
    }

    public CustomerFixLineHeightTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomerFixLineHeightTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setCustomText(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder;
        if (charSequence != null) {
            int textSize = ((int) getTextSize()) + this.f44078a;
            if (charSequence instanceof SpannableStringBuilder) {
                spannableStringBuilder = (SpannableStringBuilder) charSequence;
                spannableStringBuilder.setSpan(new CustomerFixLineHeightSpan(textSize), 0, charSequence.length(), 33);
            } else {
                spannableStringBuilder = new SpannableStringBuilder(charSequence);
                spannableStringBuilder.setSpan(new CustomerFixLineHeightSpan(textSize), 0, charSequence.length(), 33);
            }
            setText(spannableStringBuilder);
        }
    }

    public void setLineSpacingExtra(int i) {
        this.f44078a = i;
    }
}
