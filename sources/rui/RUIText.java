package rui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import com.didi.passenger.C11267R;
import java.util.Arrays;
import rui.support.TextLengthFilter;
import rui.util.FontUtil;

@Deprecated
public class RUIText extends TextView {
    protected static final int RUI_VIEW_HIERARCHY = 1;

    /* renamed from: a */
    private int f8577a = -1;

    /* renamed from: b */
    private int f8578b = 0;

    /* renamed from: c */
    private TextLengthFilter f8579c;

    /* renamed from: d */
    private InputFilter[] f8580d;

    public interface TypefaceType {
        public static final int ICON = 2;
        public static final int NONE = 0;
        public static final int PROTRUDE_NUMBER = 1;
    }

    public RUIText(Context context) {
        super(context);
        m7229a(context, (AttributeSet) null);
    }

    public RUIText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7229a(context, attributeSet);
    }

    public RUIText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7229a(context, attributeSet);
    }

    /* renamed from: a */
    private void m7229a(Context context, AttributeSet attributeSet) {
        this.f8580d = getFilters();
        setAllCaps(false);
        m7230b(context, attributeSet);
    }

    /* renamed from: b */
    private void m7230b(Context context, AttributeSet attributeSet) {
        int i = this.f8577a;
        int i2 = this.f8578b;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.RUIText);
            i = obtainStyledAttributes.getColor(0, i);
            i2 = obtainStyledAttributes.getInt(1, i2);
            obtainStyledAttributes.recycle();
        }
        setTypefaceType(i2);
        setMaxTextLength(i);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.f8580d = inputFilterArr;
        if (this.f8579c != null) {
            InputFilter[] inputFilterArr2 = (InputFilter[]) Arrays.copyOf(inputFilterArr, inputFilterArr.length + 1);
            inputFilterArr2[inputFilterArr.length] = this.f8579c;
            super.setFilters(inputFilterArr2);
            return;
        }
        super.setFilters(inputFilterArr);
    }

    public void setMaxTextLength(int i) {
        if (this.f8577a != i) {
            this.f8577a = i;
            if (i == -1) {
                this.f8579c = null;
            } else {
                this.f8579c = new TextLengthFilter(i);
            }
            setFilters(this.f8580d);
            setText(getText());
        }
    }

    public void setTypefaceType(int i) {
        if (this.f8578b != i) {
            this.f8578b = i;
            if (i == 0) {
                setTypeface((Typeface) null);
            } else if (i == 2) {
                setTypeface(FontUtil.getIconTypeface(getContext()));
            }
        }
    }
}
