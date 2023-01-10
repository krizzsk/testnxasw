package com.didi.beatles.p101im.views.richtextview;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.utils.IMTextUtil;
import java.util.regex.Pattern;

/* renamed from: com.didi.beatles.im.views.richtextview.IMNoLineClickSpan */
public class IMNoLineClickSpan extends ClickableSpan {

    /* renamed from: a */
    private String f12276a = "";

    /* renamed from: b */
    private String f12277b = "";

    /* renamed from: c */
    private String f12278c = "";

    /* renamed from: d */
    private String f12279d = "";

    /* renamed from: a */
    private String m10487a(String str) {
        return null;
    }

    /* renamed from: a */
    private void m10488a(String str, String str2) {
    }

    /* renamed from: b */
    private void m10489b(String str) {
    }

    public IMNoLineClickSpan(String str, String str2, String str3, String str4) {
        this.f12276a = str;
        this.f12277b = str2;
        this.f12278c = str3;
        this.f12279d = str4;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(Color.parseColor(this.f12276a));
        textPaint.setUnderlineText(false);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!IMTextUtil.isEmpty(this.f12277b)) {
            if (!IMTextUtil.isEmpty(this.f12278c)) {
                m10488a(this.f12278c, this.f12279d);
            } else if (!isNumber(this.f12277b)) {
            } else {
                if (this.f12277b.length() >= 11) {
                    m10489b(this.f12277b);
                } else {
                    view.performClick();
                }
            }
        }
    }

    public boolean isNumber(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }
}
