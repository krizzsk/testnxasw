package com.didi.component.comp_travel_detail_new.view.widget;

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
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.travel.psnger.model.response.StationModel;
import com.taxis99.R;
import java.util.List;

public class RouteCardAddressView extends LinearLayout {

    /* renamed from: a */
    private static final String f14345a = "TravelDetailView";

    /* renamed from: b */
    private List<StationModel> f14346b;

    /* renamed from: c */
    private Context f14347c;

    /* renamed from: d */
    private Paint f14348d;

    /* renamed from: e */
    private Paint f14349e;

    /* renamed from: f */
    private Callback f14350f;

    /* renamed from: g */
    private boolean f14351g;

    public interface Callback {
        void onCallback(int i, int i2);
    }

    public RouteCardAddressView(Context context) {
        super(context);
        m11879a();
    }

    public RouteCardAddressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11879a();
    }

    public RouteCardAddressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11879a();
    }

    /* renamed from: a */
    private void m11879a() {
        this.f14347c = getContext();
        Paint paint = new Paint(1);
        this.f14348d = paint;
        paint.setStrokeWidth((float) UiUtils.dip2px(this.f14347c, 2.0f));
        Paint paint2 = new Paint(1);
        this.f14349e = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f14349e.setStrokeWidth((float) UiUtils.dip2px(this.f14347c, 3.0f));
        this.f14349e.setPathEffect(new DashPathEffect(new float[]{0.1f, (float) UiUtils.dip2px(this.f14347c, 6.0f)}, 0.0f));
        this.f14349e.setStrokeCap(Paint.Cap.ROUND);
        setOrientation(1);
        setWillNotDraw(false);
    }

    public void setCallback(Callback callback) {
        this.f14350f = callback;
    }

    public void setData(List<StationModel> list, boolean z) {
        if (list != null && list.size() != 0) {
            this.f14351g = z;
            this.f14346b = list;
            removeAllViews();
            if (z) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMarginStart(UiUtils.dip2px(this.f14347c, 2.5f));
                setLayoutParams(layoutParams);
            }
            for (int i = 0; i < this.f14346b.size(); i++) {
                StationModel stationModel = this.f14346b.get(i);
                if (stationModel != null) {
                    View inflate = LayoutInflater.from(this.f14347c).inflate(R.layout.g_travel_detail_station_point_item, this, false);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.station_img);
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.station_lottie);
                    if (stationModel.lineConfig != null) {
                        if (stationModel.lineConfig.markSize != null) {
                            imageView.getLayoutParams().height = UiUtils.dip2px(this.f14347c, (float) (stationModel.lineConfig.markSize.height / 2));
                            imageView.getLayoutParams().width = UiUtils.dip2px(this.f14347c, (float) (stationModel.lineConfig.markSize.width / 2));
                        }
                        if (!TextUtils.isEmpty(stationModel.lineConfig.markImg)) {
                            Glide.with(this.f14347c).load(stationModel.lineConfig.markImg).into(imageView);
                        }
                        String str = stationModel.lineConfig.lottieUrl;
                        if (TextUtils.isEmpty(str)) {
                            lottieAnimationView.setVisibility(4);
                        } else {
                            lottieAnimationView.setVisibility(0);
                            lottieAnimationView.setAnimationFromUrl(str);
                            lottieAnimationView.setRepeatCount(-1);
                            lottieAnimationView.playAnimation();
                        }
                    }
                    TextView textView = (TextView) inflate.findViewById(R.id.station_name);
                    if (stationModel.displayName != null) {
                        stationModel.displayName.bindTextView(textView);
                    }
                    if (i != 0) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) inflate.getLayoutParams();
                        layoutParams2.topMargin = (int) UIUtils.dip2px(this.f14347c, 15.0f);
                        inflate.setLayoutParams(layoutParams2);
                    }
                    addView(inflate);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        Callback callback;
        List<StationModel> list = this.f14346b;
        if (list != null && list.size() != 0) {
            int i2 = 0;
            while (i2 < this.f14346b.size()) {
                StationModel stationModel = this.f14346b.get(i2);
                int i3 = stationModel.lineConfig.lineType;
                String str = stationModel.lineConfig.lineColor;
                View childAt = getChildAt(i2);
                int i4 = i2 + 1;
                View childAt2 = getChildAt(i4);
                if (childAt2 != null) {
                    int top = childAt.getTop();
                    int height = childAt.getHeight() / 2;
                    int i5 = top + height;
                    int top2 = childAt2.getTop();
                    int height2 = childAt2.getHeight() / 2;
                    int i6 = top2 + height2;
                    if (childAt instanceof ViewGroup) {
                        i = ((ViewGroup) childAt).getChildAt(0).getWidth();
                    } else {
                        i = UiUtils.dip2px(this.f14347c, 27.0f);
                    }
                    int i7 = i / 2;
                    if (i3 == 1) {
                        m11881a(canvas, str, i7, i5, i6);
                    } else if (i3 == 2) {
                        m11882b(canvas, str, i7, height + i5 + (UiUtils.dip2px(this.f14347c, 6.0f) / 2), i6 - height2);
                    }
                    if (!TextUtils.isEmpty(stationModel.guideImg) && (callback = this.f14350f) != null && this.f14351g) {
                        callback.onCallback(i2, (i5 + i6) / 2);
                    }
                    i2 = i4;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m11881a(Canvas canvas, String str, int i, int i2, int i3) {
        this.f14348d.setColor(Color.parseColor(str));
        float f = (float) i;
        canvas.drawLine(f, (float) i2, f, (float) i3, this.f14348d);
    }

    /* renamed from: b */
    private void m11882b(Canvas canvas, String str, int i, int i2, int i3) {
        Path path = new Path();
        float f = (float) i;
        path.moveTo(f, (float) i2);
        path.lineTo(f, (float) i3);
        m11880a(canvas, Color.parseColor(str), path);
    }

    /* renamed from: a */
    private void m11880a(Canvas canvas, int i, Path path) {
        this.f14349e.setColor(i);
        canvas.drawPath(path, this.f14349e);
    }
}
