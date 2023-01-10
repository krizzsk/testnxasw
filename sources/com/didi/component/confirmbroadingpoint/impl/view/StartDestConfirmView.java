package com.didi.component.confirmbroadingpoint.impl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.UIUtils;
import com.didi.travel.psnger.model.response.StationModel;
import com.taxis99.R;
import java.util.List;

public class StartDestConfirmView extends LinearLayout {

    /* renamed from: a */
    private static final String f14536a = "DepartureDestConfirmCar";

    /* renamed from: b */
    private LinearLayout f14537b;

    /* renamed from: c */
    private List<StationModel> f14538c;

    /* renamed from: d */
    private Context f14539d;

    /* renamed from: e */
    private Paint f14540e;

    /* renamed from: f */
    private Paint f14541f;

    public StartDestConfirmView(Context context) {
        super(context);
        m12024a();
    }

    public StartDestConfirmView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12024a();
    }

    public StartDestConfirmView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12024a();
    }

    /* renamed from: a */
    private void m12024a() {
        this.f14539d = getContext();
        Paint paint = new Paint(1);
        this.f14540e = paint;
        paint.setStrokeWidth((float) UiUtils.dip2px(this.f14539d, 3.0f));
        Paint paint2 = new Paint(1);
        this.f14541f = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f14541f.setStrokeWidth((float) UiUtils.dip2px(this.f14539d, 3.0f));
        this.f14541f.setPathEffect(new DashPathEffect(new float[]{0.1f, (float) UiUtils.dip2px(this.f14539d, 6.0f)}, 0.0f));
        this.f14541f.setStrokeCap(Paint.Cap.ROUND);
        setOrientation(1);
        setWillNotDraw(false);
    }

    public void setData(List<StationModel> list) {
        StationModel stationModel;
        this.f14538c = list;
        if (list != null && list.size() != 0) {
            int i = 0;
            while (i < this.f14538c.size() && (stationModel = this.f14538c.get(i)) != null) {
                View inflate = LayoutInflater.from(this.f14539d).inflate(R.layout.g_station_point_item_layout, this, false);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.station_img);
                if (stationModel.lineConfig != null) {
                    if (stationModel.lineConfig.markSize != null) {
                        imageView.getLayoutParams().height = UiUtils.dip2px(this.f14539d, (float) (stationModel.lineConfig.markSize.height / 2));
                        imageView.getLayoutParams().width = UiUtils.dip2px(this.f14539d, (float) (stationModel.lineConfig.markSize.width / 2));
                    }
                    if (!TextUtils.isEmpty(stationModel.lineConfig.markImg)) {
                        Glide.with(this.f14539d).load(stationModel.lineConfig.markImg).into(imageView);
                    }
                }
                TextView textView = (TextView) inflate.findViewById(R.id.station_name);
                if (i == 0 || i == this.f14538c.size() - 1) {
                    textView.setMaxLines(2);
                }
                if (stationModel.displayName != null) {
                    stationModel.displayName.bindTextView(textView);
                }
                if (i != 0) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                    layoutParams.topMargin = (int) UIUtils.dip2px(this.f14539d, 20.0f);
                    inflate.setLayoutParams(layoutParams);
                }
                addView(inflate);
                i++;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        List<StationModel> list = this.f14538c;
        if (list != null && list.size() != 0) {
            int i = 0;
            while (i < this.f14538c.size()) {
                StationModel stationModel = this.f14538c.get(i);
                int i2 = stationModel.lineConfig.lineType;
                String str = stationModel.lineConfig.lineColor;
                View childAt = getChildAt(i);
                i++;
                View childAt2 = getChildAt(i);
                if (childAt2 != null) {
                    int top = childAt.getTop();
                    int height = top + (childAt.getHeight() / 2);
                    int top2 = childAt2.getTop() + (childAt2.getHeight() / 2);
                    int dip2px = UiUtils.dip2px(this.f14539d, (float) (stationModel.lineConfig.markSize.width / 2)) / 2;
                    GLog.m11354d(f14536a, "top = " + top + "startY = " + height + ", toY = " + top2 + ", startX = " + dip2px);
                    if (i2 != 1) {
                        if (i2 != 2) {
                            break;
                        }
                        m12027b(canvas, str, dip2px, height + (UiUtils.dip2px(this.f14539d, (float) (stationModel.lineConfig.markSize.height / 2)) / 2), top2 - (UiUtils.dip2px(this.f14539d, (float) (stationModel.lineConfig.markSize.height / 2)) / 2));
                    } else {
                        m12026a(canvas, str, dip2px, height, top2);
                    }
                } else {
                    return;
                }
            }
            super.onDraw(canvas);
        }
    }

    /* renamed from: a */
    private void m12026a(Canvas canvas, String str, int i, int i2, int i3) {
        this.f14540e.setColor(Color.parseColor(str));
        float f = (float) i;
        canvas.drawLine(f, (float) i2, f, (float) i3, this.f14540e);
    }

    /* renamed from: b */
    private void m12027b(Canvas canvas, String str, int i, int i2, int i3) {
        Path path = new Path();
        float f = (float) i;
        path.moveTo(f, (float) i2);
        path.lineTo(f, (float) i3);
        m12025a(canvas, Color.parseColor(str), path);
    }

    /* renamed from: a */
    private void m12025a(Canvas canvas, int i, Path path) {
        this.f14541f.setColor(i);
        canvas.drawPath(path, this.f14541f);
    }
}
