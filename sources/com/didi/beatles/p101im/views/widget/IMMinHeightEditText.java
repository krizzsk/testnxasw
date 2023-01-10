package com.didi.beatles.p101im.views.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import com.didi.beatles.p101im.utils.IMLog;

/* renamed from: com.didi.beatles.im.views.widget.IMMinHeightEditText */
public class IMMinHeightEditText extends EditText {

    /* renamed from: a */
    private static final String f12324a = IMMinHeightEditText.class.getSimpleName();

    public IMMinHeightEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMMinHeightEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMMinHeightEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (suggestedMinimumHeight > 0 && measuredHeight < suggestedMinimumHeight) {
            setMeasuredDimension(getMeasuredWidth(), suggestedMinimumHeight);
            String str = f12324a;
            IMLog.m10020d(str, "[onMeasure] Fix height. mMeasuredHeight=" + measuredHeight + " |mSuggestedMinimumHeight=" + suggestedMinimumHeight);
        }
    }
}
