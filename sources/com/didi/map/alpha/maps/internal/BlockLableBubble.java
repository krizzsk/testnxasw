package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.AsyncNetUtils;
import com.didi.hawaii.utils.BitmapUtil;
import com.didi.hawaii.utils.DisplayUtils;
import com.didi.map.alpha.maps.internal.LableMarkerManager;

public class BlockLableBubble implements ILableBubble {

    /* renamed from: a */
    private static final String f26725a = "map/new_left_bottom_block_bubble_3x.9.png";

    /* renamed from: b */
    private static final String f26726b = "map/new_right_bottom_block_bubble_3x.9.png";

    /* renamed from: c */
    private static final String f26727c = "map/new_left_bottom_block_bubble_double_line_3x.9.png";

    /* renamed from: d */
    private static final String f26728d = "map/new_right_bottom_block_bubble_double_line_3x.9.png";

    /* renamed from: e */
    private static final String f26729e = "map/new_left_top_block_bubble_double_line_3x.9.png";

    /* renamed from: f */
    private static final String f26730f = "map/new_right_top_block_bubble_double_line_3x.9.png";

    /* renamed from: g */
    private static final String f26731g = "map/new_left_bottom_image_bubble_3x.9.png";

    /* renamed from: h */
    private static final String f26732h = "map/new_right_bottom_image_bubble_3x.9.png";

    /* renamed from: k */
    private static final String f26733k = "公里";

    /* renamed from: l */
    private static final String f26734l = "米";

    /* renamed from: m */
    private static final String f26735m = "小时";

    /* renamed from: n */
    private static final String f26736n = "分钟";

    /* renamed from: i */
    private final boolean f26737i = false;

    /* renamed from: j */
    private final C10076a f26738j;

    /* renamed from: a */
    private int m21169a(int i) {
        return i == 1 ? 0 : 2;
    }

    public String getIconFileName(boolean z, String str) {
        return "";
    }

    public String getMarkerFileName(boolean z, String str, int i, int i2) {
        if (i == 2) {
            return i2 == 0 ? f26726b : i2 == 5 ? f26732h : f26728d;
        }
        if (i != 3) {
            if (i != 4) {
                return i2 == 0 ? f26725a : i2 == 5 ? f26731g : f26727c;
            }
            if (i2 == 0 || i2 == 5) {
                return null;
            }
            return f26730f;
        } else if (i2 == 0 || i2 == 5) {
            return null;
        } else {
            return f26729e;
        }
    }

    public BlockLableBubble() {
        HWLog.m20433i("BlockLableBubble", "useCacheDrawer = false");
        this.f26738j = new C10076a();
    }

    public int getTextColor(boolean z, String str) {
        return getTextColors(0)[0];
    }

    public int[] getTextColors(int i) {
        return new int[]{Color.parseColor("#FFFFFF"), Color.parseColor("#FF5500")};
    }

    public String getMarkerFileName(boolean z, String str, int i) {
        return getMarkerFileName(z, str, i, 0);
    }

    public int[] getBitmapWh(Context context, int i, LableMarkerManager.BlockBubbleParams blockBubbleParams) {
        if (context == null) {
            return null;
        }
        int a = m21169a(i);
        int i2 = blockBubbleParams.blockBubbleType;
        int[] a2 = m21173a(context, a, i2);
        blockBubbleParams.textSize = 18.0f;
        blockBubbleParams.textColors = getTextColors(i2);
        blockBubbleParams.padding = a2;
        LinearLayout a3 = m21170a(context, blockBubbleParams);
        int[] iArr = new int[2];
        if (a3 == null) {
            return iArr;
        }
        a3.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        a3.layout(0, 0, a3.getMeasuredWidth(), a3.getMeasuredHeight());
        iArr[0] = a3.getMeasuredWidth();
        iArr[1] = a3.getMeasuredHeight();
        return iArr;
    }

    /* renamed from: a */
    private LinearLayout m21170a(Context context, LableMarkerManager.BlockBubbleParams blockBubbleParams) {
        String str;
        int i;
        char c;
        int i2;
        Context context2 = context;
        LableMarkerManager.BlockBubbleParams blockBubbleParams2 = blockBubbleParams;
        if (blockBubbleParams2.blockBubbleType == 5) {
            return m21174b(context, blockBubbleParams);
        }
        String str2 = blockBubbleParams2.text;
        float f = blockBubbleParams2.textSize;
        int[] iArr = blockBubbleParams2.textColors;
        int i3 = blockBubbleParams2.blockBubbleType;
        int[] iArr2 = blockBubbleParams2.padding;
        String str3 = blockBubbleParams2.fileName;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] split = str2.split("_");
        if (split.length < 2) {
            HWLog.m20433i("BlockLableBubble", "getRootLayoutView infoArray.length < 2");
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(context2);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        if (i3 != 1 || split.length < 3) {
            str = str3;
            c = 3;
            if (i3 == 3 || i3 == 4) {
                if (split.length >= 3) {
                    String str4 = split[2];
                    int i4 = iArr[1];
                    LinearLayout linearLayout2 = new LinearLayout(context2);
                    linearLayout2.setOrientation(0);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
                    linearLayout.addView(linearLayout2, layoutParams);
                    i = -2;
                    TextView a = m21172a(context, str4, f, i4, true);
                    a.setGravity(17);
                    linearLayout2.addView(a);
                } else {
                    i = -2;
                }
                i2 = 0;
                int i5 = iArr[i2];
                LinearLayout linearLayout3 = new LinearLayout(context2);
                linearLayout3.setOrientation(i2);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i);
                layoutParams2.setMargins(iArr2[i2], iArr2[1], iArr2[2], iArr2[c]);
                linearLayout.addView(linearLayout3, layoutParams2);
                linearLayout3.addView(m21171a(context2, split[i2], f, i5));
                TextView b = m21175b(context2, split[1], f, i5);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i, i);
                layoutParams3.leftMargin = DisplayUtils.dip2px(context2, 11.0f);
                linearLayout3.addView(b, layoutParams3);
                linearLayout.setBackgroundDrawable(BitmapUtil.getNinePatchDrawable(context2, str));
                return linearLayout;
            }
        } else {
            String[] split2 = split[2].split(",");
            if (split2.length >= 2) {
                int i6 = iArr[1];
                LinearLayout linearLayout4 = new LinearLayout(context2);
                linearLayout4.setOrientation(0);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams4.setMargins(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
                linearLayout.addView(linearLayout4, layoutParams4);
                LinearLayout linearLayout5 = linearLayout4;
                Context context3 = context;
                float f2 = f;
                str = str3;
                c = 3;
                int i7 = i6;
                linearLayout5.addView(m21172a(context3, split2[0], f2, i7, true));
                linearLayout5.addView(m21172a(context3, split2[1], f2, i7, true));
            } else {
                str = str3;
                c = 3;
                HWLog.m20433i("BlockLableBubble", "getTextLabels accidentInfo.length < 2");
            }
        }
        i2 = 0;
        i = -2;
        int i52 = iArr[i2];
        LinearLayout linearLayout32 = new LinearLayout(context2);
        linearLayout32.setOrientation(i2);
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(i, i);
        layoutParams22.setMargins(iArr2[i2], iArr2[1], iArr2[2], iArr2[c]);
        linearLayout.addView(linearLayout32, layoutParams22);
        linearLayout32.addView(m21171a(context2, split[i2], f, i52));
        TextView b2 = m21175b(context2, split[1], f, i52);
        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(i, i);
        layoutParams32.leftMargin = DisplayUtils.dip2px(context2, 11.0f);
        linearLayout32.addView(b2, layoutParams32);
        linearLayout.setBackgroundDrawable(BitmapUtil.getNinePatchDrawable(context2, str));
        return linearLayout;
    }

    /* renamed from: b */
    private LinearLayout m21174b(Context context, LableMarkerManager.BlockBubbleParams blockBubbleParams) {
        Context context2 = context;
        LableMarkerManager.BlockBubbleParams blockBubbleParams2 = blockBubbleParams;
        String str = blockBubbleParams2.text;
        float f = blockBubbleParams2.textSize;
        int[] iArr = blockBubbleParams2.textColors;
        int i = blockBubbleParams2.blockBubbleType;
        int[] iArr2 = blockBubbleParams2.padding;
        String str2 = blockBubbleParams2.fileName;
        String str3 = blockBubbleParams2.thumbUrl;
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
        LinearLayout linearLayout = new LinearLayout(context2);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        C100691 r10 = new AppCompatImageView(context2) {
            final Path path = new Path();
            final float radius = ((float) DisplayUtils.dip2px(getContext(), 4.0f));

            public void draw(Canvas canvas) {
                canvas.save();
                this.path.reset();
                if (Build.VERSION.SDK_INT >= 21) {
                    float f = this.radius;
                    this.path.addRoundRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), f, f, Path.Direction.CW);
                } else {
                    this.path.addRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), Path.Direction.CW);
                }
                canvas.clipPath(this.path);
                super.draw(canvas);
                canvas.restore();
            }

            /* access modifiers changed from: protected */
            public void onDraw(Canvas canvas) {
                canvas.save();
                this.path.reset();
                if (Build.VERSION.SDK_INT >= 21) {
                    float f = this.radius;
                    this.path.addRoundRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getMeasuredWidth() - getPaddingRight()), (float) (getMeasuredHeight() - getPaddingBottom()), f, f, Path.Direction.CW);
                } else {
                    this.path.addRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getMeasuredWidth() - getPaddingRight()), (float) (getMeasuredHeight() - getPaddingBottom()), Path.Direction.CW);
                }
                canvas.clipPath(this.path);
                super.onDraw(canvas);
                canvas.restore();
            }
        };
        r10.setBackgroundColor(Color.parseColor("#B3FFFFFF"));
        r10.setPadding(1, 1, 1, 1);
        r10.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r10.setImageBitmap(loadBitmapFromUrl);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DisplayUtils.dip2px(context2, 46.0f), DisplayUtils.dip2px(context2, 46.0f));
        int dip2px = DisplayUtils.dip2px(context2, 4.5f);
        layoutParams.setMargins(dip2px, dip2px, 0, dip2px);
        linearLayout.addView(r10, layoutParams);
        int i2 = iArr[0];
        LinearLayout linearLayout2 = new LinearLayout(context2);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(3);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(DisplayUtils.dip2px(context2, 7.0f), iArr2[1], DisplayUtils.dip2px(context2, 7.5f), iArr2[3]);
        linearLayout.addView(linearLayout2, layoutParams2);
        linearLayout2.addView(m21171a(context2, split[0], f, i2), new LinearLayout.LayoutParams(-2, -2));
        TextView b = m21175b(context2, split[1], f, i2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = DisplayUtils.dip2px(context2, 1.0f);
        linearLayout2.addView(b, layoutParams3);
        linearLayout.setBackgroundDrawable(BitmapUtil.getNinePatchDrawable(context2, str2));
        return linearLayout;
    }

    /* renamed from: a */
    private TextView m21171a(Context context, String str, float f, int i) {
        StringBuilder sb;
        String str2;
        int parseInt = Integer.parseInt(str);
        String b = m21176b(parseInt);
        if (parseInt < 1000) {
            sb = new StringBuilder();
            sb.append(b);
            str2 = f26734l;
        } else {
            sb = new StringBuilder();
            sb.append(b);
            str2 = f26733k;
        }
        sb.append(str2);
        return m21172a(context, sb.toString(), f, i, true);
    }

    /* renamed from: b */
    private TextView m21175b(Context context, String str, float f, int i) {
        String[] c = m21177c(Integer.parseInt(str));
        char c2 = 1;
        char c3 = c[1].length() > 0 ? (char) 1 : 0;
        if (c[3].length() <= 0) {
            c2 = 0;
        }
        String str2 = "";
        if (c3 > 0) {
            str2 = str2 + c[0] + f26735m;
        }
        if (c2 > 0) {
            str2 = str2 + c[2] + f26736n;
        }
        return m21172a(context, str2, f, i, true);
    }

    /* renamed from: a */
    private TextView m21172a(Context context, String str, float f, int i, boolean z) {
        TextView textView = new TextView(context);
        textView.setTextSize(1, f);
        textView.getPaint().setFakeBoldText(z);
        textView.setText(str);
        textView.setTextColor(i);
        textView.setSingleLine();
        textView.setHorizontallyScrolling(false);
        return textView;
    }

    /* renamed from: a */
    private int[] m21173a(Context context, int i, int i2) {
        return new int[]{DisplayUtils.dip2px(context, 5.5f), DisplayUtils.dip2px(context, 3.0f), DisplayUtils.dip2px(context, 5.5f), DisplayUtils.dip2px(context, 3.0f)};
    }

    public Bitmap getMarkerBitmap(Context context, String str, int i, String str2, String str3, boolean z, int i2) {
        LableMarkerManager.BlockBubbleParams blockBubbleParams = new LableMarkerManager.BlockBubbleParams();
        blockBubbleParams.text = str;
        blockBubbleParams.fileName = str2;
        blockBubbleParams.blockBubbleType = 0;
        return getMarkerBitmap(context, i2, blockBubbleParams);
    }

    public Bitmap getMarkerBitmap(Context context, int i, LableMarkerManager.BlockBubbleParams blockBubbleParams) {
        if (context == null) {
            return null;
        }
        int a = m21169a(i);
        int i2 = blockBubbleParams.blockBubbleType;
        int[] a2 = m21173a(context, a, i2);
        blockBubbleParams.textSize = 18.0f;
        blockBubbleParams.textColors = getTextColors(i2);
        blockBubbleParams.padding = a2;
        blockBubbleParams.blockBubbleType = i2;
        return BitmapUtil.convertViewToBitmap(m21170a(context, blockBubbleParams));
    }

    /* renamed from: b */
    private String m21176b(int i) {
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

    /* renamed from: c */
    private String[] m21177c(int i) {
        String[] strArr = new String[4];
        int i2 = i / 3600;
        if (i2 > 0) {
            strArr[0] = "" + i2;
            strArr[1] = f26735m;
        } else {
            strArr[0] = "";
            strArr[1] = "";
        }
        int i3 = i - (i2 * 3600);
        if (i3 < 60) {
            strArr[2] = "1";
            strArr[3] = f26736n;
            return strArr;
        } else if (i3 <= 60 || i3 > 120) {
            int i4 = i3 / 30;
            if (i4 % 2 == 0) {
                strArr[2] = "" + (i4 / 2);
                strArr[3] = f26736n;
            } else {
                strArr[2] = "" + ((i4 / 2) + 1);
                strArr[3] = f26736n;
            }
            return strArr;
        } else {
            strArr[2] = "2";
            strArr[3] = f26736n;
            return strArr;
        }
    }
}
