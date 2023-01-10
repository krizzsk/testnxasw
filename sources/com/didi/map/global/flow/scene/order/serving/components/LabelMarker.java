package com.didi.map.global.flow.scene.order.serving.components;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.common.map.MapView;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.flow.utils.ZIndexUtil;
import com.taxis99.R;

public class LabelMarker {
    public static final BitmapDescriptor DEFAULT_ANCHOR_ICON;
    public static final int DEFAULT_COLOR = R.color.label_marker_text;
    public static final ILabelRule DEFAULT_LABEL_RULE = new DefaultLabelRule();
    public static final int LABEL_DIRECTION_LEFT = 1;
    public static final int LABEL_DIRECTION_RIGHT = 2;

    /* renamed from: a */
    private static final Bitmap f29276a;

    /* renamed from: b */
    private MapView f29277b;

    /* renamed from: c */
    private Marker f29278c;

    /* renamed from: d */
    private LatLng f29279d;

    /* renamed from: e */
    private String f29280e;

    /* renamed from: f */
    private int f29281f;

    /* renamed from: g */
    private int f29282g;

    /* renamed from: h */
    private BitmapDescriptor f29283h;

    /* renamed from: i */
    private ILabelRule f29284i = DEFAULT_LABEL_RULE;

    /* renamed from: j */
    private int f29285j = ZIndexUtil.getZIndex(6);

    public interface ILabelRule {
        String applyLabelRule(TextView textView, String str);
    }

    static {
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
        f29276a = createBitmap;
        DEFAULT_ANCHOR_ICON = BitmapDescriptorFactory.fromBitmap(createBitmap);
    }

    public LabelMarker(MapView mapView) {
        this.f29277b = mapView;
        this.f29280e = "";
        this.f29281f = DEFAULT_COLOR;
        this.f29282g = 2;
        this.f29283h = DEFAULT_ANCHOR_ICON;
    }

    public LabelMarker position(LatLng latLng) {
        setPosition(latLng);
        return this;
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            this.f29279d = latLng;
        }
    }

    public LabelMarker label(String str) {
        setLabel(str);
        return this;
    }

    public void setLabel(String str) {
        this.f29280e = str;
    }

    public LabelMarker labelColor(int i) {
        setLabelColor(i);
        return this;
    }

    public void setLabelColor(int i) {
        this.f29281f = i;
    }

    public LabelMarker labelDirection(int i) {
        setLabelDirection(i);
        return this;
    }

    public void setLabelDirection(int i) {
        if (i == 1 || i == 2) {
            this.f29282g = i;
        }
    }

    public LabelMarker anchorIcon(BitmapDescriptor bitmapDescriptor) {
        setAnchorIcon(bitmapDescriptor);
        return this;
    }

    public void setAnchorIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null && bitmapDescriptor.getBitmap() != null) {
            this.f29283h = bitmapDescriptor;
        }
    }

    public LabelMarker labelRule(ILabelRule iLabelRule) {
        setLabelRule(iLabelRule);
        return this;
    }

    public void setLabelRule(ILabelRule iLabelRule) {
        if (iLabelRule != null) {
            this.f29284i = iLabelRule;
        }
    }

    public LabelMarker zIndex(int i) {
        setZIndex(i);
        return this;
    }

    public void setZIndex(int i) {
        this.f29285j = i;
    }

    public Marker getMarker() {
        return this.f29278c;
    }

    public LabelMarker create() {
        m22721b();
        return this;
    }

    public void destroy() {
        m22722c();
    }

    public void update() {
        destroy();
        create();
    }

    /* renamed from: a */
    private boolean m22720a() {
        return this.f29282g == 1;
    }

    /* renamed from: b */
    private void m22721b() {
        MapView mapView = this.f29277b;
        if (mapView != null && mapView.getMap() != null && this.f29277b.getContext() != null) {
            View inflate = LayoutInflater.from(this.f29277b.getContext()).inflate(m22720a() ? R.layout.label_marker_left : R.layout.label_marker_right, (ViewGroup) null);
            MapStrokeTextView mapStrokeTextView = (MapStrokeTextView) inflate.findViewById(R.id.label_marker_text);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.label_marker_anchor);
            if (!TextUtils.isEmpty(this.f29280e)) {
                mapStrokeTextView.setText(this.f29284i.applyLabelRule(mapStrokeTextView, this.f29280e));
            }
            if (this.f29281f != 0) {
                mapStrokeTextView.setTextColor(this.f29277b.getContext().getResources().getColor(this.f29281f));
            }
            BitmapDescriptor bitmapDescriptor = this.f29283h;
            if (bitmapDescriptor != null) {
                Bitmap bitmap = bitmapDescriptor.getBitmap();
                imageView.setImageBitmap(bitmap);
                float width = ((float) bitmap.getWidth()) / 2.0f;
                float height = ((float) bitmap.getHeight()) / 2.0f;
                int textSize = (int) (((mapStrokeTextView.getTextSize() + mapStrokeTextView.getStrokeWidth()) / 2.0f) - height);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, textSize, marginLayoutParams.rightMargin, 0);
                imageView.setLayoutParams(marginLayoutParams);
                Bitmap a = m22719a(inflate);
                if (a != null) {
                    float width2 = (width * 1.0f) / ((float) a.getWidth());
                    float dp2px = (((height + ((float) textSize)) + ((float) DisplayUtils.dp2px(this.f29277b.getContext(), 1.0f))) * 1.0f) / ((float) a.getHeight());
                    if (m22720a()) {
                        width2 = 1.0f - width2;
                    }
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(this.f29279d).icon(BitmapDescriptorFactory.fromBitmap(a));
                    markerOptions.anchor(width2, dp2px);
                    markerOptions.zIndex(this.f29285j);
                    markerOptions.clickable(true);
                    Marker addMarker = this.f29277b.getMap().addMarker(markerOptions);
                    this.f29278c = addMarker;
                    if (addMarker != null) {
                        addMarker.hideInfoWindow();
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private void m22722c() {
        if (this.f29278c != null) {
            this.f29277b.getMap().remove(this.f29278c);
            this.f29278c = null;
        }
    }

    private static class DefaultLabelRule implements ILabelRule {
        private DefaultLabelRule() {
        }

        public String applyLabelRule(TextView textView, String str) {
            int[] iArr = {0};
            textView.setGravity(iArr[0] > 1 ? 3 : 17);
            return LabelMarkerTextRules.rule(str, iArr);
        }
    }

    /* renamed from: a */
    private static Bitmap m22719a(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }
}
