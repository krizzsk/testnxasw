package com.didichuxing.cardscan.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.cardscan.CardScanCallback;
import com.didichuxing.cardscan.CardScanResult;
import com.didichuxing.cardscan.DidiCardScanner;
import com.didichuxing.cardscan.p176a.C16000d;
import com.didichuxing.xpanel.agent.NetworkCheck;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import p218io.card.payment.DetectionInfo;

public class OverlayView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a */
    private static final String f48860a = OverlayView.class.getSimpleName();

    /* renamed from: b */
    private static final GradientDrawable.Orientation[] f48861b = {GradientDrawable.Orientation.TOP_BOTTOM, GradientDrawable.Orientation.LEFT_RIGHT, GradientDrawable.Orientation.BOTTOM_TOP, GradientDrawable.Orientation.RIGHT_LEFT};

    /* renamed from: c */
    private WeakReference<CardScanActivity> f48862c;

    /* renamed from: d */
    private DetectionInfo f48863d;

    /* renamed from: e */
    private Rect f48864e;

    /* renamed from: f */
    private int f48865f;

    /* renamed from: g */
    private int f48866g;

    /* renamed from: h */
    private GradientDrawable f48867h;

    /* renamed from: i */
    private Paint f48868i;

    /* renamed from: j */
    private Paint f48869j;

    /* renamed from: k */
    private Paint f48870k;

    /* renamed from: l */
    private Path f48871l;

    /* renamed from: m */
    private Rect f48872m;

    /* renamed from: n */
    private C16005b f48873n;

    /* renamed from: o */
    private Rect f48874o;

    /* renamed from: p */
    private boolean f48875p;

    /* renamed from: q */
    private int f48876q;

    /* renamed from: r */
    private float f48877r;

    /* renamed from: s */
    private long f48878s;

    /* renamed from: t */
    private long f48879t;

    /* renamed from: u */
    private TextView f48880u;

    public OverlayView(Context context) {
        super(context);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private Rect m36679a(int i, int i2, int i3, int i4) {
        int i5 = (int) ((this.f48877r * 5.0f) / 2.0f);
        Rect rect = new Rect();
        rect.left = Math.min(i, i3) - i5;
        rect.right = Math.max(i, i3) + i5;
        rect.top = Math.min(i2, i4) - i5;
        rect.bottom = Math.max(i2, i4) + i5;
        return rect;
    }

    /* renamed from: a */
    public void mo121461a(Rect rect, int i) {
        this.f48865f = i;
        this.f48864e = rect;
        invalidate();
        this.f48876q = this.f48865f % 180 != 0 ? -1 : 1;
        if (this.f48872m != null) {
            Point point = new Point((this.f48872m.left + this.f48872m.right) / 2, (int) (((float) rect.bottom) + (this.f48877r * 60.0f)));
            float f = this.f48877r;
            this.f48874o = C16000d.m36657a(point, (int) (80.0f * f), (int) (f * 50.0f));
            GradientDrawable gradientDrawable = new GradientDrawable(f48861b[(this.f48865f / 90) % 4], new int[]{-1, -16777216});
            this.f48867h = gradientDrawable;
            gradientDrawable.setGradientType(0);
            this.f48867h.setBounds(this.f48864e);
            this.f48867h.setAlpha(50);
            Path path = new Path();
            this.f48871l = path;
            path.addRect(new RectF(this.f48872m), Path.Direction.CW);
            this.f48871l.addRect(new RectF(this.f48864e), Path.Direction.CCW);
        }
    }

    /* renamed from: a */
    public void mo121462a(CardScanActivity cardScanActivity) {
        this.f48879t = System.currentTimeMillis();
        findViewById(R.id.left_top_btn).setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.bottom_btn);
        this.f48880u = textView;
        textView.setOnClickListener(this);
        this.f48880u.setText(DidiCardScanner.getInstance().getButtonText());
        this.f48862c = new WeakReference<>(cardScanActivity);
        this.f48876q = 1;
        this.f48877r = getResources().getDisplayMetrics().density;
        this.f48868i = new Paint(1);
        Paint paint = new Paint();
        this.f48869j = paint;
        paint.setColor(-1);
        this.f48869j.setTextSize(TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics()));
        this.f48869j.setTextAlign(Paint.Align.CENTER);
        Paint paint2 = new Paint(1);
        this.f48870k = paint2;
        paint2.clearShadowLayer();
        this.f48870k.setStyle(Paint.Style.FILL);
        this.f48870k.setColor(1711276032);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.left_top_btn) {
            CardScanCallback cardScanCallback = DidiCardScanner.getInstance().getCardScanCallback();
            if (cardScanCallback != null) {
                cardScanCallback.onLeftTopBackBtnClick();
            }
        } else if (id == R.id.bottom_btn) {
            CardScanCallback cardScanCallback2 = DidiCardScanner.getInstance().getCardScanCallback();
            if (cardScanCallback2 != null) {
                cardScanCallback2.onBottomBackBtnClick();
                CardScanResult cardScanResult = new CardScanResult();
                cardScanResult.resultCode = 7;
                cardScanResult.requestCode = DidiCardScanner.getInstance().getRequestCode();
                cardScanResult.duration = System.currentTimeMillis() - this.f48879t;
                cardScanCallback2.onScanResult(cardScanResult);
                DidiCardScanner.getInstance().setScanCallback((CardScanCallback) null);
            }
        } else {
            return;
        }
        ((CardScanActivity) this.f48862c.get()).finish();
    }

    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        if (this.f48864e != null && this.f48872m != null) {
            canvas.save();
            int i3 = this.f48865f;
            if (i3 == 0 || i3 == 180) {
                i2 = this.f48864e.bottom;
                i = this.f48864e.top;
            } else {
                i2 = this.f48864e.right;
                i = this.f48864e.left;
            }
            int i4 = (int) (((double) (i2 - i)) * 0.1318d);
            if (this.f48878s == 0 && this.f48863d.numVisibleEdges() == 4) {
                this.f48878s = System.currentTimeMillis();
                postInvalidateDelayed(NetworkCheck.DURATION_TIME);
            }
            canvas.drawPath(this.f48871l, this.f48870k);
            this.f48868i.clearShadowLayer();
            this.f48868i.setStyle(Paint.Style.FILL);
            this.f48868i.setColor(this.f48866g);
            canvas.drawRect(m36679a(this.f48864e.left, this.f48864e.top, this.f48864e.left + i4, this.f48864e.top), this.f48868i);
            canvas.drawRect(m36679a(this.f48864e.left, this.f48864e.top, this.f48864e.left, this.f48864e.top + i4), this.f48868i);
            canvas.drawRect(m36679a(this.f48864e.right, this.f48864e.top, this.f48864e.right - i4, this.f48864e.top), this.f48868i);
            canvas.drawRect(m36679a(this.f48864e.right, this.f48864e.top, this.f48864e.right, this.f48864e.top + i4), this.f48868i);
            canvas.drawRect(m36679a(this.f48864e.left, this.f48864e.bottom, this.f48864e.left + i4, this.f48864e.bottom), this.f48868i);
            canvas.drawRect(m36679a(this.f48864e.left, this.f48864e.bottom, this.f48864e.left, this.f48864e.bottom - i4), this.f48868i);
            canvas.drawRect(m36679a(this.f48864e.right, this.f48864e.bottom, this.f48864e.right - i4, this.f48864e.bottom), this.f48868i);
            canvas.drawRect(m36679a(this.f48864e.right, this.f48864e.bottom, this.f48864e.right, this.f48864e.bottom - i4), this.f48868i);
            String smallText = DidiCardScanner.getInstance().getSmallText();
            if (!TextUtils.isEmpty(smallText)) {
                canvas.drawText(smallText, (float) (getWidth() / 2), ((float) this.f48864e.bottom) + (this.f48877r * 35.0f), this.f48869j);
            }
            DetectionInfo detectionInfo = this.f48863d;
            if (detectionInfo != null) {
                if (detectionInfo.topEdge) {
                    canvas.drawRect(m36679a(this.f48864e.left, this.f48864e.top, this.f48864e.right, this.f48864e.top), this.f48868i);
                }
                if (this.f48863d.bottomEdge) {
                    canvas.drawRect(m36679a(this.f48864e.left, this.f48864e.bottom, this.f48864e.right, this.f48864e.bottom), this.f48868i);
                }
                if (this.f48863d.leftEdge) {
                    canvas.drawRect(m36679a(this.f48864e.left, this.f48864e.top, this.f48864e.left, this.f48864e.bottom), this.f48868i);
                }
                if (this.f48863d.rightEdge) {
                    canvas.drawRect(m36679a(this.f48864e.right, this.f48864e.top, this.f48864e.right, this.f48864e.bottom), this.f48868i);
                }
                if (this.f48863d.numVisibleEdges() < 3) {
                    float f = this.f48877r;
                    float f2 = 24.0f * f;
                    float f3 = f * 16.0f;
                    C16000d.m36658a(this.f48868i);
                    this.f48868i.setTextAlign(Paint.Align.CENTER);
                    this.f48868i.setTextSize(f3);
                    canvas.translate((float) (this.f48864e.left + (this.f48864e.width() / 2)), (float) (this.f48864e.top + (this.f48864e.height() / 2)));
                    canvas.rotate((float) (this.f48876q * this.f48865f));
                    String centerText = DidiCardScanner.getInstance().getCenterText();
                    if (!TextUtils.isEmpty(centerText)) {
                        String[] split = centerText.split("\n");
                        float f4 = (-(((((float) (split.length - 1)) * f2) - f3) / 2.0f)) - 3.0f;
                        for (String drawText : split) {
                            canvas.drawText(drawText, 0.0f, f4, this.f48868i);
                            f4 += f2;
                        }
                    }
                }
            }
            canvas.restore();
            if (this.f48875p) {
                canvas.save();
                canvas.translate(this.f48874o.exactCenterX(), this.f48874o.exactCenterY());
                canvas.rotate((float) (this.f48876q * this.f48865f));
                this.f48873n.mo121475a(canvas);
                canvas.restore();
            }
            if (this.f48878s > 0 && System.currentTimeMillis() - this.f48878s > 10000) {
                this.f48880u.setTextColor(-1);
                this.f48880u.setBackgroundResource(R.drawable.cardscan_bottom_btn_bg_highlight);
                this.f48878s = -1;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if ((motionEvent.getAction() & 255) != 0) {
                return false;
            }
            ((CardScanActivity) this.f48862c.get()).mo121452b();
            return false;
        } catch (NullPointerException unused) {
            SystemUtils.log(3, f48860a, "NullPointerException caught in onTouchEvent method", (Throwable) null, "com.didichuxing.cardscan.view.OverlayView", -1);
            return false;
        }
    }

    public void setCameraPreviewRect(Rect rect) {
        this.f48872m = rect;
    }

    public void setDetectionInfo(DetectionInfo detectionInfo) {
        DetectionInfo detectionInfo2 = this.f48863d;
        if (detectionInfo2 != null && !detectionInfo2.sameEdgesAs(detectionInfo)) {
            invalidate();
        }
        this.f48863d = detectionInfo;
    }

    public void setGuideColor(int i) {
        this.f48866g = i;
    }

    public void setTorchEnabled(boolean z) {
        C16005b bVar;
        this.f48875p = z;
        if (z && this.f48873n == null) {
            float f = this.f48877r;
            bVar = new C16005b(80.0f * f, f * 50.0f);
        } else if (this.f48873n != null) {
            bVar = null;
        } else {
            return;
        }
        this.f48873n = bVar;
    }

    public void setTorchOn(boolean z) {
        if (this.f48875p) {
            this.f48873n.mo121476a(z);
            invalidate();
        }
    }
}
