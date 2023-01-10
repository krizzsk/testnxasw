package com.didi.beatles.p101im.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.passenger.C11267R;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.IMFolderTextView */
public class IMFolderTextView extends TextView {

    /* renamed from: a */
    private static final String f11709a = "...";

    /* renamed from: b */
    private String f11710b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f11711c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f11712d;

    /* renamed from: e */
    private boolean f11713e;

    /* renamed from: f */
    private int f11714f;

    /* renamed from: g */
    private String f11715g;

    /* renamed from: h */
    private float f11716h;

    /* renamed from: i */
    private float f11717i;

    public IMFolderTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMFolderTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMFolderTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11711c = false;
        this.f11712d = false;
        this.f11713e = false;
        this.f11714f = 2;
        this.f11716h = 1.0f;
        this.f11717i = 0.0f;
        this.f11710b = IMResource.getString(R.string.im_arrow_details);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C11267R.styleable.IMFolderTextView);
        this.f11714f = obtainStyledAttributes.getInt(0, 2);
        obtainStyledAttributes.recycle();
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMFolderTextView iMFolderTextView = IMFolderTextView.this;
                boolean unused = iMFolderTextView.f11711c = !iMFolderTextView.f11711c;
                boolean unused2 = IMFolderTextView.this.f11712d = false;
                IMFolderTextView.this.invalidate();
            }
        });
    }

    private void setUpdateText(CharSequence charSequence) {
        this.f11713e = true;
        setText(charSequence);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (TextUtils.isEmpty(this.f11715g) || !this.f11713e) {
            this.f11712d = false;
            this.f11715g = String.valueOf(charSequence);
        }
        super.setText(charSequence, bufferType);
    }

    public void setLineSpacing(float f, float f2) {
        this.f11717i = f;
        this.f11716h = f2;
        super.setLineSpacing(f, f2);
    }

    public int getFoldLine() {
        return this.f11714f;
    }

    public void setFoldLine(int i) {
        this.f11714f = i;
    }

    /* renamed from: a */
    private Layout m10064a(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.f11716h, this.f11717i, false);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.f11712d) {
            m10065a();
        }
        super.onDraw(canvas);
        this.f11712d = true;
        this.f11713e = false;
    }

    /* renamed from: a */
    private void m10065a() {
        String str = this.f11715g;
        if (this.f11711c) {
            setUpdateText(str);
        } else if (!m10072e(str)) {
            setUpdateText(str);
        } else {
            setUpdateText(m10070c(m10073f(str)));
        }
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* renamed from: b */
    private SpannableString m10068b(String str) {
        String str2 = str + this.f11710b;
        int length = str2.length() - this.f11710b.length();
        int length2 = str2.length();
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan((Object) null, length, length2, 33);
        return spannableString;
    }

    /* renamed from: c */
    private SpannableString m10070c(String str) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        int length = str.length() - this.f11710b.length();
        int length2 = str.length();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(IMResource.getColor(R.color.im_nomix_orange)), length, length2, 33);
        return spannableString;
    }

    /* renamed from: d */
    private String m10071d(String str) {
        if (m10064a(str).getLineCount() <= getFoldLine()) {
            return str;
        }
        return m10073f(str);
    }

    /* renamed from: e */
    private boolean m10072e(String str) {
        return m10064a(str).getLineCount() > getFoldLine();
    }

    /* renamed from: f */
    private String m10073f(String str) {
        String str2 = str + f11709a + this.f11710b;
        Layout a = m10064a(str2);
        if (a.getLineCount() <= getFoldLine()) {
            return str2;
        }
        int lineEnd = a.getLineEnd(getFoldLine());
        if (str.length() < lineEnd) {
            lineEnd = str.length();
        }
        return m10073f(str.substring(0, lineEnd - 1));
    }
}
