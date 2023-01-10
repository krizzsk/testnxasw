package com.didi.app.nova.support.view.edittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.passenger.C11267R;
import java.lang.reflect.Field;

public class EditTextCompat extends AppCompatEditText {
    public EditTextCompat(Context context) {
        super(context);
    }

    public EditTextCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9079a(context, attributeSet);
    }

    public EditTextCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9079a(context, attributeSet);
    }

    /* renamed from: a */
    private void m9079a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.NovaSupportEditText);
        m9078a(obtainStyledAttributes.getResourceId(0, 0));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m9078a(int i) {
        if (i != 0) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this, Integer.valueOf(i));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }
}
