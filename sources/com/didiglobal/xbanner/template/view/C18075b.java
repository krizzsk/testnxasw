package com.didiglobal.xbanner.template.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.didi.global.xbanner.utils.DisplayUtils;
import com.didiglobal.xbanner.util.CenterAlignImageSpan;
import com.taxis99.R;

/* renamed from: com.didiglobal.xbanner.template.view.b */
/* compiled from: XBTemplateUtil */
class C18075b {

    /* renamed from: a */
    private static final String f54042a = "[a]";

    /* renamed from: b */
    private static final String f54043b = "[D]";

    /* renamed from: a */
    public static boolean m40286a(int i) {
        return (i & 1) == 1;
    }

    /* renamed from: b */
    public static boolean m40288b(int i) {
        return (i & 2) == 2;
    }

    /* renamed from: c */
    public static boolean m40289c(int i) {
        return (i & 4) == 4;
    }

    C18075b() {
    }

    /* renamed from: a */
    public static SpannableString m40284a(Context context, String str, int i, int i2) {
        return m40285a(context, str, i, i2, 1);
    }

    /* renamed from: a */
    public static SpannableString m40285a(Context context, String str, int i, int i2, int i3) {
        if (str == null) {
            return new SpannableString("");
        }
        int i4 = i3 == 1 ? 22 : 44;
        if (str.length() > i4) {
            str = str.substring(0, i4 - 3) + "…" + f54043b;
        }
        if (!m40286a(i2)) {
            i = -1;
        }
        return m40283a(context, str, i);
    }

    /* renamed from: b */
    public static SpannableString m40287b(Context context, String str, int i, int i2) {
        if (!m40288b(i2)) {
            i = -1;
        }
        if (str.length() > 56) {
            str = str.substring(0, 53) + "…" + f54043b;
        }
        return m40283a(context, str, i);
    }

    /* renamed from: a */
    public static SpannableString m40283a(Context context, String str, int i) {
        if (i != -1) {
            Drawable a = m40282a(context, i);
            a.setBounds(0, 0, DisplayUtils.dip2px(context, 10.0f), DisplayUtils.dip2px(context, 10.0f));
            SpannableString spannableString = new SpannableString(str + f54042a);
            spannableString.setSpan(new CenterAlignImageSpan(a, DisplayUtils.dip2px(context, 4.0f)), str.contains(f54043b) ? str.length() - 3 : str.length(), str.length() + 3, 18);
            return spannableString;
        }
        if (str.contains(f54043b)) {
            str = str.replace(f54043b, "");
        }
        return new SpannableString(str);
    }

    /* renamed from: a */
    public static Drawable m40282a(Context context, int i) {
        return context.getResources().getDrawable(i == 1 ? R.mipmap.com_icon_arrow_light : R.mipmap.com_icon_arrow_lightgray);
    }
}
