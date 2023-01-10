package rui.support;

import android.text.InputFilter;
import android.text.Spanned;

public final class TextLengthFilter implements InputFilter {
    public static final int NO_FILTER_TEXT_LENGTH = -1;

    /* renamed from: b */
    private static final String f8656b = "...";

    /* renamed from: a */
    private MaxTextLengthCallback f8657a;

    /* renamed from: c */
    private int f8658c;

    /* renamed from: d */
    private boolean f8659d = true;

    public interface MaxTextLengthCallback {
        void onMaxTextLength(int i);
    }

    public TextLengthFilter(int i) {
        this.f8658c = i;
    }

    public void setMaxLengthCallback(MaxTextLengthCallback maxTextLengthCallback) {
        this.f8657a = maxTextLengthCallback;
    }

    public void disableShowCutOffHint() {
        this.f8659d = false;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = this.f8658c;
        if (i5 == -1) {
            return null;
        }
        int i6 = i4 - i3;
        int length = i5 - (spanned.length() - i6);
        if (length <= 0) {
            return "";
        }
        if (length >= i2 - i) {
            return null;
        }
        MaxTextLengthCallback maxTextLengthCallback = this.f8657a;
        if (maxTextLengthCallback != null) {
            maxTextLengthCallback.onMaxTextLength(this.f8658c);
        }
        CharSequence subSequence = charSequence.subSequence(i, length + i);
        if (!this.f8659d || i6 != 0) {
            return subSequence;
        }
        return subSequence + f8656b;
    }
}
