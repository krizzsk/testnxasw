package com.didi.soda.business.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.CenterImageSpan;
import com.taxis99.R;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 02\u00020\u0001:\u00010B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J*\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J \u0010 \u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u000e\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0007J\u000e\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0007J\u001a\u0010,\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0015H\u0002R\u0016\u0010\t\u001a\u00020\u00078BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00078BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00078BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, mo148868d2 = {"Lcom/didi/soda/business/widget/TailIconTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconSize", "getIconSize", "()I", "imageHeight", "getImageHeight", "imageWidth", "getImageWidth", "isTailShowed", "", "tailDrawable", "Landroid/graphics/drawable/Drawable;", "textContent", "", "composeTextSSB", "Landroid/text/SpannableStringBuilder;", "widthSize", "mustShowText", "", "lineStartIndex", "lineEndIndex", "createTextSSB", "lastLineText", "iconDrawable", "isImageInSingleLine", "getLineText", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setIconSize", "size", "setImageHeight", "h", "setImageWidth", "w", "setTextTail", "text", "trimText", "content", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TailIconTextView.kt */
public final class TailIconTextView extends AppCompatTextView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: g */
    private static final float f42443g = 4.0f;

    /* renamed from: h */
    private static final float f42444h = 24.0f;

    /* renamed from: a */
    private String f42445a;

    /* renamed from: b */
    private Drawable f42446b;

    /* renamed from: c */
    private boolean f42447c;

    /* renamed from: d */
    private int f42448d;

    /* renamed from: e */
    private int f42449e;

    /* renamed from: f */
    private int f42450f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TailIconTextView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TailIconTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TailIconTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TailIconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f42445a = "";
        this.f42450f = DisplayUtils.dip2px(context, f42444h);
    }

    private final int getImageWidth() {
        int i = this.f42448d;
        return i == 0 ? getIconSize() : i;
    }

    private final int getImageHeight() {
        int i = this.f42449e;
        return i == 0 ? getIconSize() : i;
    }

    private final int getIconSize() {
        int i = this.f42450f;
        return i == 0 ? DisplayUtils.dip2px(getContext(), f42444h) : i;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        SpannableStringBuilder spannableStringBuilder;
        super.onMeasure(i, i2);
        if (this.f42446b != null && !this.f42447c) {
            int lineCount = getLineCount();
            Layout layout = getLayout();
            int maxLines = getMaxLines();
            int size = View.MeasureSpec.getSize(i);
            if (maxLines != 0) {
                if (!(this.f42445a.length() == 0)) {
                    CharSequence charSequence = "";
                    if (lineCount < maxLines) {
                        int i3 = lineCount - 1;
                        spannableStringBuilder = m31925a((CharSequence) this.f42445a, (CharSequence) "", this.f42446b, m31928a(size, layout.getLineStart(i3), layout.getLineEnd(i3)));
                    } else if (lineCount == maxLines) {
                        int i4 = maxLines - 1;
                        int lineStart = layout.getLineStart(i4);
                        int lineEnd = layout.getLineEnd(i4);
                        if (maxLines == 1) {
                            charSequence = "";
                        } else if (maxLines >= 2) {
                            charSequence = this.f42445a.subSequence(0, lineStart);
                        }
                        spannableStringBuilder = m31924a(size, charSequence, lineStart, lineEnd);
                    } else {
                        int i5 = maxLines - 1;
                        int lineStart2 = layout.getLineStart(i5);
                        spannableStringBuilder = m31924a(size, this.f42445a.subSequence(0, lineStart2), lineStart2, layout.getLineEnd(i5));
                    }
                    setText(spannableStringBuilder);
                    this.f42447c = true;
                }
            }
        }
    }

    public final void setImageHeight(int i) {
        this.f42449e = i;
    }

    public final void setImageWidth(int i) {
        this.f42448d = i;
    }

    public final void setIconSize(int i) {
        this.f42450f = i;
    }

    /* renamed from: a */
    private final SpannableStringBuilder m31924a(int i, CharSequence charSequence, int i2, int i3) {
        CharSequence a = m31926a(i2, i3);
        float measureText = getPaint().measureText(a.toString());
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        int dip2px = DisplayUtils.dip2px(getContext(), 4.0f);
        if (((float) paddingLeft) >= measureText + ((float) dip2px) + ((float) getImageWidth())) {
            return m31925a(charSequence, a, this.f42446b, false);
        }
        CharSequence ellipsize = TextUtils.ellipsize(a, getPaint(), (float) ((paddingLeft - dip2px) - getImageWidth()), TextUtils.TruncateAt.END);
        Intrinsics.checkNotNullExpressionValue(ellipsize, "ellipsizeLastLineText");
        return m31925a(charSequence, ellipsize, this.f42446b, false);
    }

    /* renamed from: a */
    private final SpannableStringBuilder m31925a(CharSequence charSequence, CharSequence charSequence2, Drawable drawable, boolean z) {
        if (drawable != null) {
            drawable.setBounds(0, 0, getImageWidth(), getImageHeight());
        }
        CenterImageSpan centerImageSpan = new CenterImageSpan(drawable);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int length = charSequence.length() + charSequence2.length();
        if (z) {
            spannableStringBuilder.append(charSequence2).append("\n").append("/");
        } else {
            ColorDrawable colorDrawable = new ColorDrawable(getContext().getResources().getColor(R.color.transparent));
            colorDrawable.setBounds(0, 0, DisplayUtils.dip2px(getContext(), 4.0f), getImageHeight());
            CenterImageSpan centerImageSpan2 = new CenterImageSpan(colorDrawable);
            spannableStringBuilder.append(charSequence2).append("/").append("/");
            spannableStringBuilder.setSpan(centerImageSpan2, length, length + 1, 17);
        }
        spannableStringBuilder.setSpan(centerImageSpan, length + 1, length + 2, 17);
        return spannableStringBuilder;
    }

    public final void setTextTail(String str, Drawable drawable) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            this.f42446b = drawable;
            String a = m31927a(str);
            this.f42445a = a;
            this.f42447c = false;
            setText(a);
        }
    }

    /* renamed from: a */
    private final String m31927a(String str) {
        String replaceAll = Pattern.compile("(\\n)+").matcher(str).replaceAll("\n");
        Intrinsics.checkNotNullExpressionValue(replaceAll, "trimText");
        return StringsKt.endsWith$default(replaceAll, "\n", false, 2, (Object) null) ? (String) replaceAll.subSequence(0, replaceAll.length() - 1) : replaceAll;
    }

    /* renamed from: a */
    private final boolean m31928a(int i, int i2, int i3) {
        return ((float) ((i - getPaddingLeft()) - getPaddingRight())) < (getPaint().measureText(m31926a(i2, i3).toString()) + ((float) DisplayUtils.dip2px(getContext(), 4.0f))) + ((float) getImageWidth());
    }

    /* renamed from: a */
    private final CharSequence m31926a(int i, int i2) {
        return getText().subSequence(i, i2);
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/soda/business/widget/TailIconTextView$Companion;", "", "()V", "DEFAULT_ICON_SIZE", "", "MARGIN_BETWEEN", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: TailIconTextView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
