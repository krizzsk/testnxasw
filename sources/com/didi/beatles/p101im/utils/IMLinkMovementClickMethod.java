package com.didi.beatles.p101im.utils;

import android.content.ActivityNotFoundException;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* renamed from: com.didi.beatles.im.utils.IMLinkMovementClickMethod */
public class IMLinkMovementClickMethod extends LinkMovementMethod {

    /* renamed from: b */
    private static final long f11607b = 500;

    /* renamed from: c */
    private static IMLinkMovementClickMethod f11608c;

    /* renamed from: a */
    private long f11609a;

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            int scrollY = y + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                if (action == 1) {
                    if (System.currentTimeMillis() - this.f11609a < 500) {
                        try {
                            clickableSpanArr[0].onClick(textView);
                        } catch (ActivityNotFoundException unused) {
                            IMLog.m10021e("activity not found! ", new Object[0]);
                        }
                    }
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                    this.f11609a = System.currentTimeMillis();
                }
                return true;
            }
            Selection.removeSelection(spannable);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    public static IMLinkMovementClickMethod getInstance() {
        if (f11608c == null) {
            f11608c = new IMLinkMovementClickMethod();
        }
        return f11608c;
    }
}
