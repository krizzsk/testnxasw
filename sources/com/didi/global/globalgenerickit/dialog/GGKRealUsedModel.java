package com.didi.global.globalgenerickit.dialog;

import android.graphics.Typeface;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.callback.GGKImgModel;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import java.util.List;

class GGKRealUsedModel {

    /* renamed from: a */
    TextWidgetModel f24003a;

    /* renamed from: b */
    TextWidgetModel f24004b;

    /* renamed from: c */
    TextWidgetModel f24005c;

    /* renamed from: d */
    TextWatcher f24006d;

    /* renamed from: e */
    String f24007e;

    /* renamed from: f */
    CompoundButton.OnCheckedChangeListener f24008f;

    /* renamed from: g */
    List<GGKBtnTextAndCallback> f24009g;

    /* renamed from: h */
    TextWidgetModel f24010h;

    /* renamed from: i */
    GGKOnAntiShakeClickListener f24011i;

    /* renamed from: j */
    GGKImgModel f24012j;

    /* renamed from: k */
    TextWidgetModel f24013k;

    /* renamed from: l */
    List<TextWidgetModel> f24014l;

    GGKRealUsedModel() {
    }

    static class TextWidgetModel {
        int fontColor;
        float fontSize;
        boolean isBold = false;
        String text;

        TextWidgetModel() {
        }

        /* access modifiers changed from: package-private */
        public void bind(TextView textView) {
            if (textView != null) {
                String str = this.text;
                if (str != null) {
                    textView.setText(str);
                }
                int i = this.fontColor;
                if (i != 0) {
                    textView.setTextColor(i);
                }
                float f = this.fontSize;
                if (f != 0.0f) {
                    textView.setTextSize(f);
                }
                if (this.isBold) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                }
            }
        }
    }
}
