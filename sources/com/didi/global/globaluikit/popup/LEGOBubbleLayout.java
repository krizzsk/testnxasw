package com.didi.global.globaluikit.popup;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.taxis99.R;

public class LEGOBubbleLayout extends LinearLayout {

    /* renamed from: a */
    private static final String f24510a = "[arrow]";

    /* renamed from: d */
    private static final int f24511d = 2;

    /* renamed from: s */
    private static final int f24512s = 5;

    /* renamed from: b */
    private Context f24513b;

    /* renamed from: c */
    private int f24514c;

    /* renamed from: e */
    private int f24515e;

    /* renamed from: f */
    private Point f24516f;

    /* renamed from: g */
    private int f24517g;

    /* renamed from: h */
    private int f24518h;

    /* renamed from: i */
    private int f24519i;

    /* renamed from: j */
    private Paint f24520j;

    /* renamed from: k */
    private Path f24521k;

    /* renamed from: l */
    private RectF f24522l;

    /* renamed from: m */
    private TextView f24523m;
    public String mDirection;

    /* renamed from: n */
    private ImageView f24524n;

    /* renamed from: o */
    private FrameLayout f24525o;

    /* renamed from: p */
    private int f24526p = 0;

    /* renamed from: q */
    private int f24527q = 0;

    /* renamed from: r */
    private int f24528r = 0;

    /* renamed from: t */
    private float f24529t;

    /* renamed from: u */
    private float f24530u;

    public @interface Direction {
    }

    /* renamed from: c */
    private boolean m19689c(int i, int i2) {
        return i <= i2 + 5;
    }

    public LEGOBubbleLayout(Context context) {
        super(context);
        this.f24513b = context;
        this.f24514c = context.getResources().getDimensionPixelOffset(R.dimen.lego_bubble_default_offset);
        this.f24517g = context.getResources().getDimensionPixelOffset(R.dimen.lego_bubble_triangle_width);
        this.f24518h = context.getResources().getDimensionPixelOffset(R.dimen.lego_bubble_triangle_height);
        this.f24515e = context.getResources().getDimensionPixelOffset(R.dimen.lego_bubble_default_radius);
        m19683a();
    }

    /* access modifiers changed from: package-private */
    public void setCloseBtnVisible(boolean z) {
        this.f24524n.setVisibility(z ? 0 : 8);
    }

    /* renamed from: a */
    private void m19683a() {
        Paint paint = new Paint();
        this.f24520j = paint;
        paint.setAntiAlias(true);
        this.f24521k = new Path();
        this.f24522l = new RectF();
        this.f24516f = new Point();
        setWillNotDraw(false);
        inflate(this.f24513b, R.layout.lego_layout_bubble, this);
        this.f24523m = (TextView) findViewById(R.id.center_text);
        this.f24524n = (ImageView) findViewById(R.id.close_btn);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.left_icon);
        this.f24525o = frameLayout;
        frameLayout.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void setCloseClickListener(View.OnClickListener onClickListener) {
        this.f24524n.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    public void setText(String str) {
        this.f24523m.setText(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72256a(int i, int i2, int i3) {
        if (i > 0) {
            this.f24523m.setTextSize(2, (float) i);
        }
        if ((i2 & i3) == 1) {
            this.f24523m.setTypeface(Typeface.SANS_SERIF, 3);
        } else if (i2 == 1) {
            this.f24523m.setTypeface(Typeface.SANS_SERIF, 1);
        } else if (i3 == 1) {
            this.f24523m.setTypeface(Typeface.SANS_SERIF, 2);
        }
    }

    /* access modifiers changed from: package-private */
    public void setTypeface(int i) {
        this.f24523m.setTypeface(Typeface.SANS_SERIF, i);
    }

    /* access modifiers changed from: package-private */
    public void setMaxLines(int i) {
        this.f24526p = i;
        this.f24523m.setMaxLines(i);
        this.f24523m.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    }

    /* access modifiers changed from: package-private */
    public void setLeftDrawable(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f24525o.getChildCount() > 0) {
                this.f24525o.removeAllViews();
            }
            this.f24525o.setVisibility(0);
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f24525o.addView(imageView);
            Context context = this.f24513b;
            if (context instanceof FragmentActivity) {
                if (((FragmentActivity) context).isDestroyed()) {
                    return;
                }
            } else if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
                return;
            }
            Glide.with(this.f24513b).load(str).into(imageView);
        }
    }

    /* access modifiers changed from: package-private */
    public void setLeftView(View view) {
        if (view != null) {
            if (this.f24525o.getChildCount() > 0) {
                this.f24525o.removeAllViews();
            }
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f24525o.addView(view);
            this.f24525o.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72257a(View view, int i, int i2) {
        if (view != null && i > -2 && i2 > -2) {
            if (this.f24525o.getChildCount() > 0) {
                this.f24525o.removeAllViews();
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24525o.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.f24525o.setLayoutParams(layoutParams);
            this.f24525o.requestLayout();
            this.f24525o.addView(view);
            this.f24525o.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void setLeftDrawable(int i) {
        try {
            if (this.f24525o.getChildCount() > 0) {
                this.f24525o.removeAllViews();
            }
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f24525o.addView(imageView);
            imageView.setImageDrawable(getResources().getDrawable(i));
            this.f24525o.setVisibility(0);
        } catch (Exception e) {
            e.printStackTrace();
            this.f24525o.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72255a(int i, int i2) {
        this.f24527q = i;
        this.f24528r = i2;
        setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
    }

    public void setBubbleBackgroundColor(int i) {
        this.f24520j.setColor(i);
    }

    public void setBubbleBackgroundColor(String str) {
        try {
            this.f24520j.setColor(Color.parseColor(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72258a(String str, int i) {
        DRtlToolkit dRtlToolkit = DRtlToolkit.INSTANCE;
        if (DRtlToolkit.rtl()) {
            if (str.contains("left")) {
                str = str.replace("left", "right");
            } else if (str.contains("right")) {
                str = str.replace("right", "left");
            }
        }
        this.mDirection = str;
        this.f24519i = i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0063, code lost:
        r3 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009a, code lost:
        r3 = (float) (-r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b4, code lost:
        r3 = ((float) r3) / 2.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b6, code lost:
        m19684a(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b9, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setPivot(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            switch(r0) {
                case -1699597560: goto L_0x0052;
                case -1383228885: goto L_0x0048;
                case -966253391: goto L_0x003d;
                case -609197669: goto L_0x0033;
                case 115029: goto L_0x0028;
                case 3317767: goto L_0x001e;
                case 108511772: goto L_0x0013;
                case 116576946: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x005c
        L_0x0008:
            java.lang.String r0 = "top_right"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 5
            goto L_0x005d
        L_0x0013:
            java.lang.String r0 = "right"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 2
            goto L_0x005d
        L_0x001e:
            java.lang.String r0 = "left"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 0
            goto L_0x005d
        L_0x0028:
            java.lang.String r0 = "top"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 1
            goto L_0x005d
        L_0x0033:
            java.lang.String r0 = "bottom_left"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 6
            goto L_0x005d
        L_0x003d:
            java.lang.String r0 = "top_left"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 4
            goto L_0x005d
        L_0x0048:
            java.lang.String r0 = "bottom"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 3
            goto L_0x005d
        L_0x0052:
            java.lang.String r0 = "bottom_right"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x005c
            r3 = 7
            goto L_0x005d
        L_0x005c:
            r3 = -1
        L_0x005d:
            r0 = 0
            r1 = 1073741824(0x40000000, float:2.0)
            switch(r3) {
                case 0: goto L_0x00b0;
                case 1: goto L_0x00a8;
                case 2: goto L_0x009d;
                case 3: goto L_0x008f;
                case 4: goto L_0x0087;
                case 5: goto L_0x007a;
                case 6: goto L_0x0072;
                case 7: goto L_0x0065;
                default: goto L_0x0063;
            }
        L_0x0063:
            r3 = 0
            goto L_0x00b6
        L_0x0065:
            int r3 = r2.getLayoutWidth()
            int r0 = r2.f24514c
            int r3 = r3 - r0
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x009a
        L_0x0072:
            int r3 = r2.f24514c
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x009a
        L_0x007a:
            int r3 = r2.getLayoutWidth()
            int r0 = r2.f24514c
            int r3 = r3 - r0
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x00b4
        L_0x0087:
            int r3 = r2.f24514c
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x00b4
        L_0x008f:
            int r3 = r2.getWidth()
            float r3 = (float) r3
            float r0 = r3 / r1
            int r3 = r2.getLayoutHeight()
        L_0x009a:
            int r3 = -r3
            float r3 = (float) r3
            goto L_0x00b6
        L_0x009d:
            int r3 = r2.getLayoutWidth()
            int r3 = -r3
            float r0 = (float) r3
            int r3 = r2.getLayoutHeight()
            goto L_0x00b4
        L_0x00a8:
            int r3 = r2.getLayoutWidth()
            float r3 = (float) r3
            float r3 = r3 / r1
            r0 = r3
            goto L_0x0063
        L_0x00b0:
            int r3 = r2.getLayoutHeight()
        L_0x00b4:
            float r3 = (float) r3
            float r3 = r3 / r1
        L_0x00b6:
            r2.m19684a((float) r0, (float) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globaluikit.popup.LEGOBubbleLayout.setPivot(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0074, code lost:
        m19687b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
        m19687b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007a, code lost:
        m19690d(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007d, code lost:
        m19690d(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008d, code lost:
        m19691e(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r4) {
        /*
            r3 = this;
            super.onDraw(r4)
            android.graphics.Point r0 = r3.f24516f
            int r0 = r0.x
            if (r0 <= 0) goto L_0x0090
            android.graphics.Point r0 = r3.f24516f
            int r0 = r0.y
            if (r0 <= 0) goto L_0x0090
            java.lang.String r0 = r3.mDirection
            r1 = -1
            int r2 = r0.hashCode()
            switch(r2) {
                case -1699597560: goto L_0x0064;
                case -1383228885: goto L_0x005a;
                case -966253391: goto L_0x004f;
                case -609197669: goto L_0x0045;
                case 115029: goto L_0x003a;
                case 3317767: goto L_0x0030;
                case 108511772: goto L_0x0025;
                case 116576946: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x006d
        L_0x001a:
            java.lang.String r2 = "top_right"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 5
            goto L_0x006d
        L_0x0025:
            java.lang.String r2 = "right"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 2
            goto L_0x006d
        L_0x0030:
            java.lang.String r2 = "left"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 0
            goto L_0x006d
        L_0x003a:
            java.lang.String r2 = "top"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 1
            goto L_0x006d
        L_0x0045:
            java.lang.String r2 = "bottom_left"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 6
            goto L_0x006d
        L_0x004f:
            java.lang.String r2 = "top_left"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 4
            goto L_0x006d
        L_0x005a:
            java.lang.String r2 = "bottom"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 3
            goto L_0x006d
        L_0x0064:
            java.lang.String r2 = "bottom_right"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x006d
            r1 = 7
        L_0x006d:
            switch(r1) {
                case 0: goto L_0x0089;
                case 1: goto L_0x0085;
                case 2: goto L_0x0081;
                case 3: goto L_0x0071;
                case 4: goto L_0x0074;
                case 5: goto L_0x0077;
                case 6: goto L_0x007a;
                case 7: goto L_0x007d;
                default: goto L_0x0070;
            }
        L_0x0070:
            goto L_0x008d
        L_0x0071:
            r3.m19690d(r4)
        L_0x0074:
            r3.m19687b(r4)
        L_0x0077:
            r3.m19687b(r4)
        L_0x007a:
            r3.m19690d(r4)
        L_0x007d:
            r3.m19690d(r4)
            goto L_0x008d
        L_0x0081:
            r3.m19688c(r4)
            goto L_0x0090
        L_0x0085:
            r3.m19687b(r4)
            goto L_0x0090
        L_0x0089:
            r3.m19685a(r4)
            goto L_0x0090
        L_0x008d:
            r3.m19691e(r4)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globaluikit.popup.LEGOBubbleLayout.onDraw(android.graphics.Canvas):void");
    }

    /* renamed from: a */
    private void m19684a(float f, float f2) {
        this.f24529t = f;
        this.f24530u = f2;
    }

    /* renamed from: a */
    private void m19685a(Canvas canvas) {
        Path path = this.f24521k;
        RectF rectF = this.f24522l;
        int i = this.f24515e;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
        this.f24521k.moveTo((float) (this.f24516f.x + 2), ((float) this.f24516f.y) - (((float) this.f24517g) / 2.0f));
        this.f24521k.lineTo(((float) this.f24516f.x) - (((float) this.f24518h) / 2.0f), (float) this.f24516f.y);
        this.f24521k.lineTo((float) (this.f24516f.x + 2), ((float) this.f24516f.y) + (((float) this.f24517g) / 2.0f));
        this.f24521k.close();
        canvas.drawPath(this.f24521k, this.f24520j);
    }

    /* renamed from: b */
    private void m19687b(Canvas canvas) {
        Path path = this.f24521k;
        RectF rectF = this.f24522l;
        int i = this.f24515e;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
        this.f24521k.moveTo(((float) this.f24516f.x) + (((float) this.f24518h) / 2.0f), (float) this.f24516f.y);
        this.f24521k.lineTo((float) this.f24516f.x, ((float) this.f24516f.y) - (((float) this.f24517g) / 2.0f));
        this.f24521k.lineTo(((float) this.f24516f.x) - (((float) this.f24518h) / 2.0f), (float) this.f24516f.y);
        this.f24521k.close();
        canvas.drawPath(this.f24521k, this.f24520j);
    }

    /* renamed from: c */
    private void m19688c(Canvas canvas) {
        Path path = this.f24521k;
        RectF rectF = this.f24522l;
        int i = this.f24515e;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CW);
        this.f24521k.moveTo((float) (this.f24516f.x - 2), ((float) this.f24516f.y) - (((float) this.f24517g) / 2.0f));
        this.f24521k.lineTo(((float) this.f24516f.x) + (((float) this.f24517g) / 2.0f), (float) this.f24516f.y);
        this.f24521k.lineTo((float) (this.f24516f.x - 2), ((float) this.f24516f.y) + (((float) this.f24517g) / 2.0f));
        this.f24521k.close();
        canvas.drawPath(this.f24521k, this.f24520j);
    }

    /* renamed from: d */
    private void m19690d(Canvas canvas) {
        Path path = this.f24521k;
        RectF rectF = this.f24522l;
        int i = this.f24515e;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
        this.f24521k.moveTo(((float) this.f24516f.x) + (((float) this.f24518h) / 2.0f), (float) this.f24516f.y);
        this.f24521k.lineTo((float) this.f24516f.x, ((float) this.f24516f.y) + (((float) this.f24517g) / 2.0f));
        this.f24521k.lineTo(((float) this.f24516f.x) - (((float) this.f24518h) / 2.0f), (float) this.f24516f.y);
        this.f24521k.close();
        canvas.drawPath(this.f24521k, this.f24520j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo72259b(int i, int i2) {
        this.f24518h = i2;
        this.f24517g = i;
    }

    /* renamed from: e */
    private void m19691e(Canvas canvas) {
        if (getPaddingBottom() != 0) {
            Path path = this.f24521k;
            RectF rectF = this.f24522l;
            int i = this.f24515e;
            path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
            this.f24521k.close();
            canvas.drawPath(this.f24521k, this.f24520j);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSizeChanged(int r2, int r3, int r4, int r5) {
        /*
            r1 = this;
            super.onSizeChanged(r2, r3, r4, r5)
            android.graphics.RectF r4 = r1.f24522l
            int r5 = r1.getPaddingLeft()
            float r5 = (float) r5
            r4.left = r5
            android.graphics.RectF r4 = r1.f24522l
            int r5 = r1.getPaddingTop()
            float r5 = (float) r5
            r4.top = r5
            android.graphics.RectF r4 = r1.f24522l
            int r5 = r1.getPaddingRight()
            int r5 = r2 - r5
            float r5 = (float) r5
            r4.right = r5
            android.graphics.RectF r4 = r1.f24522l
            int r5 = r1.getPaddingBottom()
            int r5 = r3 - r5
            float r5 = (float) r5
            r4.bottom = r5
            java.lang.String r4 = r1.mDirection
            int r5 = r4.hashCode()
            r0 = 2
            switch(r5) {
                case -1699597560: goto L_0x0080;
                case -1383228885: goto L_0x0076;
                case -966253391: goto L_0x006b;
                case -609197669: goto L_0x0061;
                case 115029: goto L_0x0056;
                case 3317767: goto L_0x004c;
                case 108511772: goto L_0x0041;
                case 116576946: goto L_0x0036;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x008a
        L_0x0036:
            java.lang.String r5 = "top_right"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 5
            goto L_0x008b
        L_0x0041:
            java.lang.String r5 = "right"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 2
            goto L_0x008b
        L_0x004c:
            java.lang.String r5 = "left"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 0
            goto L_0x008b
        L_0x0056:
            java.lang.String r5 = "top"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 1
            goto L_0x008b
        L_0x0061:
            java.lang.String r5 = "bottom_left"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 6
            goto L_0x008b
        L_0x006b:
            java.lang.String r5 = "top_left"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 4
            goto L_0x008b
        L_0x0076:
            java.lang.String r5 = "bottom"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 3
            goto L_0x008b
        L_0x0080:
            java.lang.String r5 = "bottom_right"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x008a
            r4 = 7
            goto L_0x008b
        L_0x008a:
            r4 = -1
        L_0x008b:
            switch(r4) {
                case 0: goto L_0x00fc;
                case 1: goto L_0x00ee;
                case 2: goto L_0x00df;
                case 3: goto L_0x00d0;
                case 4: goto L_0x00c1;
                case 5: goto L_0x00b1;
                case 6: goto L_0x00a1;
                case 7: goto L_0x0090;
                default: goto L_0x008e;
            }
        L_0x008e:
            goto L_0x0109
        L_0x0090:
            android.graphics.Point r4 = r1.f24516f
            int r5 = r1.f24514c
            int r2 = r2 - r5
            r4.x = r2
            android.graphics.Point r2 = r1.f24516f
            int r4 = r1.getPaddingBottom()
            int r3 = r3 - r4
            r2.y = r3
            goto L_0x0109
        L_0x00a1:
            android.graphics.Point r2 = r1.f24516f
            int r4 = r1.f24514c
            r2.x = r4
            android.graphics.Point r2 = r1.f24516f
            int r4 = r1.getPaddingBottom()
            int r3 = r3 - r4
            r2.y = r3
            goto L_0x0109
        L_0x00b1:
            android.graphics.Point r3 = r1.f24516f
            int r4 = r1.f24514c
            int r2 = r2 - r4
            r3.x = r2
            android.graphics.Point r2 = r1.f24516f
            int r3 = r1.getPaddingTop()
            r2.y = r3
            goto L_0x0109
        L_0x00c1:
            android.graphics.Point r2 = r1.f24516f
            int r3 = r1.f24514c
            r2.x = r3
            android.graphics.Point r2 = r1.f24516f
            int r3 = r1.getPaddingTop()
            r2.y = r3
            goto L_0x0109
        L_0x00d0:
            android.graphics.Point r4 = r1.f24516f
            int r2 = r2 / r0
            r4.x = r2
            android.graphics.Point r2 = r1.f24516f
            int r4 = r1.getPaddingBottom()
            int r3 = r3 - r4
            r2.y = r3
            goto L_0x0109
        L_0x00df:
            android.graphics.Point r4 = r1.f24516f
            int r5 = r1.getPaddingRight()
            int r2 = r2 - r5
            r4.x = r2
            android.graphics.Point r2 = r1.f24516f
            int r3 = r3 / r0
            r2.y = r3
            goto L_0x0109
        L_0x00ee:
            android.graphics.Point r3 = r1.f24516f
            int r2 = r2 / r0
            r3.x = r2
            android.graphics.Point r2 = r1.f24516f
            int r3 = r1.getPaddingTop()
            r2.y = r3
            goto L_0x0109
        L_0x00fc:
            android.graphics.Point r2 = r1.f24516f
            int r4 = r1.getPaddingLeft()
            r2.x = r4
            android.graphics.Point r2 = r1.f24516f
            int r3 = r3 / r0
            r2.y = r3
        L_0x0109:
            int r2 = r1.f24519i
            if (r2 == 0) goto L_0x0110
            r1.m19686b()
        L_0x0110:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globaluikit.popup.LEGOBubbleLayout.onSizeChanged(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public int getLayoutWidth() {
        int dip2px = UiUtils.dip2px(this.f24513b, 27.0f);
        if (this.f24525o.getVisibility() == 0) {
            dip2px += UiUtils.dip2px(this.f24513b, 24.0f);
        }
        if (this.f24524n.getVisibility() == 0) {
            dip2px += UiUtils.dip2px(this.f24513b, 25.0f);
        }
        int textSize = (int) (((float) dip2px) + (this.f24523m.getTextSize() * ((float) this.f24523m.getText().length())));
        String name = LEGOBubbleLayout.class.getName();
        SystemUtils.log(6, name, "getLayoutWidth: " + textSize, (Throwable) null, "com.didi.global.globaluikit.popup.LEGOBubbleLayout", 464);
        return textSize;
    }

    /* access modifiers changed from: package-private */
    public int getLayoutHeight() {
        int dip2px = (int) (((float) (UiUtils.dip2px(this.f24513b, 11.0f) * 2)) + this.f24523m.getTextSize());
        String name = LEGOBubbleLayout.class.getName();
        SystemUtils.log(6, name, "getLayoutWidth: " + dip2px, (Throwable) null, "com.didi.global.globaluikit.popup.LEGOBubbleLayout", 470);
        return dip2px;
    }

    /* access modifiers changed from: package-private */
    public int[] getMeasureWidthAndHeight() {
        int i;
        int[] iArr = new int[2];
        int i2 = this.f24527q;
        if (i2 <= 0 || (i = this.f24528r) <= 0) {
            measure(0, 0);
            int measuredWidth = getMeasuredWidth();
            int i3 = getResources().getDisplayMetrics().widthPixels;
            if (measuredWidth > i3) {
                measuredWidth = i3;
            }
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth >= i3) {
                int i4 = (i3 / measuredWidth) + (i3 % measuredWidth) > 0 ? 1 : 0;
                int i5 = this.f24526p;
                if (i5 > 0 && i5 < i4) {
                    i4 = i5;
                }
                measuredHeight *= i4;
            }
            int measuredHeight2 = this.f24525o.getMeasuredHeight();
            int measuredHeight3 = this.f24523m.getMeasuredHeight();
            int measuredHeight4 = this.f24524n.getMeasuredHeight();
            if (m19689c(measuredHeight2, measuredHeight3) && m19689c(measuredHeight4, measuredHeight3)) {
                measuredHeight += UiUtils.dip2px(this.f24513b, 10.0f) * 2;
            }
            iArr[0] = measuredWidth;
            iArr[1] = measuredHeight;
            return iArr;
        }
        iArr[0] = i2;
        iArr[1] = i;
        return iArr;
    }

    public void setTriangleOffset(int i) {
        this.f24519i = i;
        m19686b();
        invalidate();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m19686b() {
        /*
            r3 = this;
            java.lang.String r0 = r3.mDirection
            int r1 = r0.hashCode()
            switch(r1) {
                case -1699597560: goto L_0x0054;
                case -1383228885: goto L_0x004a;
                case -966253391: goto L_0x003f;
                case -609197669: goto L_0x0035;
                case 115029: goto L_0x002a;
                case 3317767: goto L_0x0020;
                case 108511772: goto L_0x0015;
                case 116576946: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x005e
        L_0x000a:
            java.lang.String r1 = "top_right"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 5
            goto L_0x005f
        L_0x0015:
            java.lang.String r1 = "right"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 1
            goto L_0x005f
        L_0x0020:
            java.lang.String r1 = "left"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 0
            goto L_0x005f
        L_0x002a:
            java.lang.String r1 = "top"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 2
            goto L_0x005f
        L_0x0035:
            java.lang.String r1 = "bottom_left"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 6
            goto L_0x005f
        L_0x003f:
            java.lang.String r1 = "top_left"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 4
            goto L_0x005f
        L_0x004a:
            java.lang.String r1 = "bottom"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 3
            goto L_0x005f
        L_0x0054:
            java.lang.String r1 = "bottom_right"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005e
            r0 = 7
            goto L_0x005f
        L_0x005e:
            r0 = -1
        L_0x005f:
            switch(r0) {
                case 0: goto L_0x006d;
                case 1: goto L_0x006d;
                case 2: goto L_0x0063;
                case 3: goto L_0x0063;
                case 4: goto L_0x0063;
                case 5: goto L_0x0063;
                case 6: goto L_0x0063;
                case 7: goto L_0x0063;
                default: goto L_0x0062;
            }
        L_0x0062:
            goto L_0x0076
        L_0x0063:
            android.graphics.Point r0 = r3.f24516f
            int r1 = r0.x
            int r2 = r3.f24519i
            int r1 = r1 + r2
            r0.x = r1
            goto L_0x0076
        L_0x006d:
            android.graphics.Point r0 = r3.f24516f
            int r1 = r0.y
            int r2 = r3.f24519i
            int r1 = r1 + r2
            r0.y = r1
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globaluikit.popup.LEGOBubbleLayout.m19686b():void");
    }

    /* access modifiers changed from: package-private */
    public float[] getPivot() {
        return new float[]{this.f24529t, this.f24530u};
    }
}
