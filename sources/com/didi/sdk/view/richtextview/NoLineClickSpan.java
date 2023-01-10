package com.didi.sdk.view.richtextview;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.log.Logger;
import com.didi.sdk.util.TextUtil;
import java.util.regex.Pattern;

public class NoLineClickSpan extends ClickableSpan {

    /* renamed from: a */
    private String f40887a = "";

    /* renamed from: b */
    private String f40888b = "";

    /* renamed from: c */
    private String f40889c = "";

    /* renamed from: d */
    private String f40890d = "";

    /* renamed from: a */
    private String m30653a(String str) {
        return null;
    }

    /* renamed from: b */
    private void m30655b(String str) {
    }

    public NoLineClickSpan(String str, String str2, String str3, String str4) {
        this.f40887a = str;
        this.f40888b = str2;
        this.f40889c = str3;
        this.f40890d = str4;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(Color.parseColor(this.f40887a));
        textPaint.setUnderlineText(false);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Logger.m29536d("Span OnClick Key: " + this.f40888b + " mLink:" + this.f40889c + " mTitle:" + this.f40890d, new Object[0]);
        if (!TextUtil.isEmpty(this.f40888b)) {
            if (!TextUtil.isEmpty(this.f40889c)) {
                m30654a(this.f40889c, this.f40890d);
            } else if (!isNumber(this.f40888b)) {
            } else {
                if (this.f40888b.length() >= 11) {
                    m30655b(this.f40888b);
                } else {
                    view.performClick();
                }
            }
        }
    }

    /* renamed from: a */
    private void m30654a(String str, String str2) {
        Logger.m29536d("Basespan webview:" + str + " mTitle:" + str2, new Object[0]);
    }

    public boolean isNumber(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }
}
