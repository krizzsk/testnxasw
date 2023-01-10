package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.AsyncNetUtils;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.hawaii.utils.DisplayUtils;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.google.android.material.badge.BadgeDrawable;

/* renamed from: com.didi.map.alpha.maps.internal.a */
/* compiled from: BlockBubbleDrawer */
class C10076a {

    /* renamed from: h */
    private static final String f26815h = "公里";

    /* renamed from: i */
    private static final String f26816i = "米";

    /* renamed from: j */
    private static final String f26817j = "小时";

    /* renamed from: k */
    private static final String f26818k = "分钟";

    /* renamed from: a */
    private LinearLayout f26819a;

    /* renamed from: b */
    private LinearLayout f26820b;

    /* renamed from: c */
    private LinearLayout f26821c;

    /* renamed from: d */
    private TextView f26822d;

    /* renamed from: e */
    private TextView f26823e;

    /* renamed from: f */
    private ImageView f26824f;

    /* renamed from: g */
    private TextView f26825g;

    C10076a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0139  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.widget.LinearLayout mo77846a(android.content.Context r18, com.didi.map.alpha.maps.internal.LableMarkerManager.BlockBubbleParams r19) {
        /*
            r17 = this;
            r8 = r17
            r0 = r18
            r1 = r19
            monitor-enter(r17)
            int r2 = r1.blockBubbleType     // Catch:{ all -> 0x019b }
            r3 = 5
            if (r2 != r3) goto L_0x0012
            android.widget.LinearLayout r0 = r17.m21184b(r18, r19)     // Catch:{ all -> 0x019b }
            monitor-exit(r17)
            return r0
        L_0x0012:
            java.lang.String r2 = r1.text     // Catch:{ all -> 0x019b }
            float r9 = r1.textSize     // Catch:{ all -> 0x019b }
            int[] r10 = r1.textColors     // Catch:{ all -> 0x019b }
            int r3 = r1.blockBubbleType     // Catch:{ all -> 0x019b }
            int[] r11 = r1.padding     // Catch:{ all -> 0x019b }
            java.lang.String r12 = r1.fileName     // Catch:{ all -> 0x019b }
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x019b }
            r4 = 0
            if (r1 == 0) goto L_0x0027
            monitor-exit(r17)
            return r4
        L_0x0027:
            java.lang.String r1 = "_"
            java.lang.String[] r13 = r2.split(r1)     // Catch:{ all -> 0x019b }
            int r1 = r13.length     // Catch:{ all -> 0x019b }
            r14 = 2
            if (r1 >= r14) goto L_0x003a
            java.lang.String r0 = "BlockLableBubble"
            java.lang.String r1 = "getRootLayoutView infoArray.length < 2"
            com.didi.hawaii.log.HWLog.m20433i(r0, r1)     // Catch:{ all -> 0x019b }
            monitor-exit(r17)
            return r4
        L_0x003a:
            android.widget.LinearLayout r1 = r8.f26819a     // Catch:{ all -> 0x019b }
            if (r1 != 0) goto L_0x0045
            android.widget.LinearLayout r1 = new android.widget.LinearLayout     // Catch:{ all -> 0x019b }
            r1.<init>(r0)     // Catch:{ all -> 0x019b }
            r8.f26819a = r1     // Catch:{ all -> 0x019b }
        L_0x0045:
            android.widget.LinearLayout r1 = r8.f26819a     // Catch:{ all -> 0x019b }
            r1.removeAllViews()     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f26819a     // Catch:{ all -> 0x019b }
            r15 = 1
            r1.setOrientation(r15)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f26819a     // Catch:{ all -> 0x019b }
            r1.setGravity(r15)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams     // Catch:{ all -> 0x019b }
            r7 = -2
            r1.<init>(r7, r7)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r2 = r8.f26819a     // Catch:{ all -> 0x019b }
            r2.setLayoutParams(r1)     // Catch:{ all -> 0x019b }
            r6 = 3
            r5 = 0
            if (r3 != r15) goto L_0x00d4
            int r1 = r13.length     // Catch:{ all -> 0x019b }
            if (r1 < r6) goto L_0x00d4
            r1 = r13[r14]     // Catch:{ all -> 0x019b }
            java.lang.String r2 = ","
            java.lang.String[] r1 = r1.split(r2)     // Catch:{ all -> 0x019b }
            int r2 = r1.length     // Catch:{ all -> 0x019b }
            if (r2 < r14) goto L_0x00cb
            r16 = r10[r15]     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r2 = r8.f26821c     // Catch:{ all -> 0x019b }
            if (r2 != 0) goto L_0x007f
            android.widget.LinearLayout r2 = new android.widget.LinearLayout     // Catch:{ all -> 0x019b }
            r2.<init>(r0)     // Catch:{ all -> 0x019b }
            r8.f26821c = r2     // Catch:{ all -> 0x019b }
        L_0x007f:
            android.widget.LinearLayout r2 = r8.f26821c     // Catch:{ all -> 0x019b }
            r2.removeAllViews()     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r2 = r8.f26821c     // Catch:{ all -> 0x019b }
            r2.setOrientation(r5)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams     // Catch:{ all -> 0x019b }
            r2.<init>(r7, r7)     // Catch:{ all -> 0x019b }
            r3 = r11[r5]     // Catch:{ all -> 0x019b }
            r4 = r11[r15]     // Catch:{ all -> 0x019b }
            r7 = r11[r14]     // Catch:{ all -> 0x019b }
            r14 = r11[r6]     // Catch:{ all -> 0x019b }
            r2.setMargins(r3, r4, r7, r14)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r3 = r8.f26819a     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r4 = r8.f26821c     // Catch:{ all -> 0x019b }
            r3.addView(r4, r2)     // Catch:{ all -> 0x019b }
            android.widget.TextView r3 = r8.f26825g     // Catch:{ all -> 0x019b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x019b }
            r2.<init>()     // Catch:{ all -> 0x019b }
            r4 = r1[r5]     // Catch:{ all -> 0x019b }
            r2.append(r4)     // Catch:{ all -> 0x019b }
            r1 = r1[r15]     // Catch:{ all -> 0x019b }
            r2.append(r1)     // Catch:{ all -> 0x019b }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x019b }
            r7 = 1
            r1 = r17
            r2 = r18
            r14 = 0
            r5 = r9
            r14 = 3
            r6 = r16
            android.widget.TextView r1 = r1.m21181a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x019b }
            r8.f26825g = r1     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r2 = r8.f26821c     // Catch:{ all -> 0x019b }
            r2.addView(r1)     // Catch:{ all -> 0x019b }
            goto L_0x00db
        L_0x00cb:
            r14 = 3
            java.lang.String r1 = "BlockLableBubble"
            java.lang.String r2 = "getTextLabels accidentInfo.length < 2"
            com.didi.hawaii.log.HWLog.m20433i(r1, r2)     // Catch:{ all -> 0x019b }
            goto L_0x00db
        L_0x00d4:
            r14 = 3
            if (r3 == r14) goto L_0x00de
            r1 = 4
            if (r3 != r1) goto L_0x00db
            goto L_0x00de
        L_0x00db:
            r1 = 0
            r14 = -2
            goto L_0x0133
        L_0x00de:
            int r1 = r13.length     // Catch:{ all -> 0x019b }
            if (r1 < r14) goto L_0x0131
            r1 = 2
            r4 = r13[r1]     // Catch:{ all -> 0x019b }
            r6 = r10[r15]     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f26821c     // Catch:{ all -> 0x019b }
            if (r1 != 0) goto L_0x00f1
            android.widget.LinearLayout r1 = new android.widget.LinearLayout     // Catch:{ all -> 0x019b }
            r1.<init>(r0)     // Catch:{ all -> 0x019b }
            r8.f26821c = r1     // Catch:{ all -> 0x019b }
        L_0x00f1:
            android.widget.LinearLayout r1 = r8.f26821c     // Catch:{ all -> 0x019b }
            r1.removeAllViews()     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f26821c     // Catch:{ all -> 0x019b }
            r2 = 0
            r1.setOrientation(r2)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams     // Catch:{ all -> 0x019b }
            r7 = -2
            r1.<init>(r7, r7)     // Catch:{ all -> 0x019b }
            r3 = r11[r2]     // Catch:{ all -> 0x019b }
            r2 = r11[r15]     // Catch:{ all -> 0x019b }
            r5 = 2
            r7 = r11[r5]     // Catch:{ all -> 0x019b }
            r5 = r11[r14]     // Catch:{ all -> 0x019b }
            r1.setMargins(r3, r2, r7, r5)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r2 = r8.f26819a     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r3 = r8.f26821c     // Catch:{ all -> 0x019b }
            r2.addView(r3, r1)     // Catch:{ all -> 0x019b }
            android.widget.TextView r3 = r8.f26825g     // Catch:{ all -> 0x019b }
            r7 = 1
            r1 = r17
            r2 = r18
            r5 = r9
            r14 = -2
            android.widget.TextView r1 = r1.m21181a(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x019b }
            r8.f26825g = r1     // Catch:{ all -> 0x019b }
            r2 = 17
            r1.setGravity(r2)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f26821c     // Catch:{ all -> 0x019b }
            android.widget.TextView r2 = r8.f26825g     // Catch:{ all -> 0x019b }
            r1.addView(r2)     // Catch:{ all -> 0x019b }
            goto L_0x0132
        L_0x0131:
            r14 = -2
        L_0x0132:
            r1 = 0
        L_0x0133:
            r2 = r10[r1]     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f26820b     // Catch:{ all -> 0x019b }
            if (r1 != 0) goto L_0x0140
            android.widget.LinearLayout r1 = new android.widget.LinearLayout     // Catch:{ all -> 0x019b }
            r1.<init>(r0)     // Catch:{ all -> 0x019b }
            r8.f26820b = r1     // Catch:{ all -> 0x019b }
        L_0x0140:
            android.widget.LinearLayout r1 = r8.f26820b     // Catch:{ all -> 0x019b }
            r1.removeAllViews()     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f26820b     // Catch:{ all -> 0x019b }
            r3 = 0
            r1.setOrientation(r3)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams     // Catch:{ all -> 0x019b }
            r1.<init>(r14, r14)     // Catch:{ all -> 0x019b }
            r4 = r11[r3]     // Catch:{ all -> 0x019b }
            r3 = r11[r15]     // Catch:{ all -> 0x019b }
            r5 = 2
            r5 = r11[r5]     // Catch:{ all -> 0x019b }
            r6 = 3
            r6 = r11[r6]     // Catch:{ all -> 0x019b }
            r1.setMargins(r4, r3, r5, r6)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r3 = r8.f26819a     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r4 = r8.f26820b     // Catch:{ all -> 0x019b }
            r3.addView(r4, r1)     // Catch:{ all -> 0x019b }
            r1 = 0
            r1 = r13[r1]     // Catch:{ all -> 0x019b }
            android.widget.TextView r1 = r8.m21182a(r0, r1, r9, r2)     // Catch:{ all -> 0x019b }
            r8.f26822d = r1     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r3 = r8.f26820b     // Catch:{ all -> 0x019b }
            r3.addView(r1)     // Catch:{ all -> 0x019b }
            r1 = r13[r15]     // Catch:{ all -> 0x019b }
            android.widget.TextView r1 = r8.m21185b(r0, r1, r9, r2)     // Catch:{ all -> 0x019b }
            r8.f26823e = r1     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams     // Catch:{ all -> 0x019b }
            r1.<init>(r14, r14)     // Catch:{ all -> 0x019b }
            r2 = 1093664768(0x41300000, float:11.0)
            int r2 = com.didi.hawaii.utils.DisplayUtils.dip2px(r0, r2)     // Catch:{ all -> 0x019b }
            r1.leftMargin = r2     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r2 = r8.f26820b     // Catch:{ all -> 0x019b }
            android.widget.TextView r3 = r8.f26823e     // Catch:{ all -> 0x019b }
            r2.addView(r3, r1)     // Catch:{ all -> 0x019b }
            android.graphics.drawable.NinePatchDrawable r0 = com.didi.hawaii.utils.BitmapUtil.getNinePatchDrawable(r0, r12)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r1 = r8.f26819a     // Catch:{ all -> 0x019b }
            r1.setBackgroundDrawable(r0)     // Catch:{ all -> 0x019b }
            android.widget.LinearLayout r0 = r8.f26819a     // Catch:{ all -> 0x019b }
            monitor-exit(r17)
            return r0
        L_0x019b:
            r0 = move-exception
            monitor-exit(r17)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.alpha.maps.internal.C10076a.mo77846a(android.content.Context, com.didi.map.alpha.maps.internal.LableMarkerManager$BlockBubbleParams):android.widget.LinearLayout");
    }

    /* renamed from: b */
    private LinearLayout m21184b(Context context, LableMarkerManager.BlockBubbleParams blockBubbleParams) {
        String str = blockBubbleParams.text;
        float f = blockBubbleParams.textSize;
        int[] iArr = blockBubbleParams.textColors;
        int i = blockBubbleParams.blockBubbleType;
        int[] iArr2 = blockBubbleParams.padding;
        String str2 = blockBubbleParams.fileName;
        String str3 = blockBubbleParams.thumbUrl;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            HWLog.m20433i("BlockLableBubble", "getHorizontalRootLayoutView text =" + str + ", thumbUrl = " + str3);
            return null;
        }
        String[] split = str.split("_");
        if (split.length < 2) {
            HWLog.m20433i("BlockLableBubble", "getHorizontalRootLayoutView infoArray.length < 2");
            return null;
        }
        Bitmap loadBitmapFromUrl = BitmapUtil.loadBitmapFromUrl(str3, (AsyncNetUtils.Callback) null);
        if (loadBitmapFromUrl == null) {
            HWLog.m20433i("BlockLableBubble", "bitmap can't be null");
            return null;
        }
        if (this.f26819a == null) {
            this.f26819a = new LinearLayout(context);
        }
        this.f26819a.removeAllViews();
        this.f26819a.setOrientation(0);
        this.f26819a.setGravity(16);
        this.f26819a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        if (this.f26824f == null) {
            this.f26824f = new BlockBubbleDrawer$1(this, context);
        }
        this.f26824f.setBackgroundColor(Color.parseColor("#B3FFFFFF"));
        this.f26824f.setPadding(1, 1, 1, 1);
        this.f26824f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f26824f.setImageBitmap(loadBitmapFromUrl);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(context, 46.0f), DisplayUtils.dip2px(context, 46.0f));
        int dip2px = DisplayUtils.dip2px(context, 4.5f);
        layoutParams.setMargins(dip2px, dip2px, 0, dip2px);
        this.f26819a.addView(this.f26824f, layoutParams);
        int i2 = iArr[0];
        if (this.f26820b == null) {
            this.f26820b = new LinearLayout(context);
        }
        this.f26820b.removeAllViews();
        this.f26820b.setOrientation(1);
        this.f26820b.setGravity(3);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(DisplayUtils.dip2px(context, 7.0f), iArr2[1], DisplayUtils.dip2px(context, 7.5f), iArr2[3]);
        this.f26819a.addView(this.f26820b, layoutParams2);
        this.f26822d = m21182a(context, split[0], f, i2);
        this.f26820b.addView(this.f26822d, new LinearLayout.LayoutParams(-2, -2));
        this.f26823e = m21185b(context, split[1], f, i2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = DisplayUtils.dip2px(context, 1.0f);
        this.f26820b.addView(this.f26823e, layoutParams3);
        this.f26819a.setBackgroundDrawable(BitmapUtil.getNinePatchDrawable(context, str2));
        return this.f26819a;
    }

    /* renamed from: a */
    private TextView m21182a(Context context, String str, float f, int i) {
        StringBuilder sb;
        String str2;
        int parseInt = Integer.parseInt(str);
        String a = m21183a(parseInt);
        if (parseInt < 1000) {
            sb = new StringBuilder();
            sb.append(a);
            str2 = f26816i;
        } else {
            sb = new StringBuilder();
            sb.append(a);
            str2 = f26815h;
        }
        sb.append(str2);
        return m21181a(context, this.f26822d, sb.toString(), f, i, true);
    }

    /* renamed from: b */
    private TextView m21185b(Context context, String str, float f, int i) {
        String[] b = m21186b(Integer.parseInt(str));
        char c = 1;
        char c2 = b[1].length() > 0 ? (char) 1 : 0;
        if (b[3].length() <= 0) {
            c = 0;
        }
        String str2 = "";
        if (c2 > 0) {
            str2 = str2 + b[0] + f26817j;
        }
        if (c > 0) {
            str2 = str2 + b[2] + f26818k;
        }
        return m21181a(context, this.f26823e, str2, f, i, true);
    }

    /* renamed from: a */
    private TextView m21181a(Context context, TextView textView, String str, float f, int i, boolean z) {
        if (textView == null) {
            textView = new TextView(context);
        }
        textView.setTextSize(1, f);
        textView.getPaint().setFakeBoldText(z);
        textView.setText(str);
        textView.setGravity(BadgeDrawable.TOP_START);
        textView.setTextColor(i);
        textView.setSingleLine();
        textView.setHorizontallyScrolling(false);
        return textView;
    }

    /* renamed from: a */
    private String m21183a(int i) {
        if (i < 1000) {
            return String.valueOf(i);
        }
        StringBuilder sb = new StringBuilder();
        int i2 = i / 1000;
        int i3 = (i / 100) % 10;
        if (i3 > 0) {
            sb.append(i2);
            sb.append(".");
            sb.append(i3);
        } else {
            sb.append(i2);
        }
        return sb.toString();
    }

    /* renamed from: b */
    private String[] m21186b(int i) {
        String[] strArr = new String[4];
        int i2 = i / 3600;
        if (i2 > 0) {
            strArr[0] = "" + i2;
            strArr[1] = f26817j;
        } else {
            strArr[0] = "";
            strArr[1] = "";
        }
        int i3 = i - (i2 * 3600);
        if (i3 < 60) {
            strArr[2] = "1";
            strArr[3] = f26818k;
            return strArr;
        } else if (i3 <= 60 || i3 > 120) {
            int i4 = i3 / 30;
            if (i4 % 2 == 0) {
                strArr[2] = "" + (i4 / 2);
                strArr[3] = f26818k;
            } else {
                strArr[2] = "" + ((i4 / 2) + 1);
                strArr[3] = f26818k;
            }
            return strArr;
        } else {
            strArr[2] = "2";
            strArr[3] = f26818k;
            return strArr;
        }
    }
}
