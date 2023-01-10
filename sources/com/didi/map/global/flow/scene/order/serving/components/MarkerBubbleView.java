package com.didi.map.global.flow.scene.order.serving.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.map.global.component.markers.view.ILabelView;
import com.didi.map.global.flow.scene.order.serving.components.LabelMarker;
import com.taxis99.R;

public class MarkerBubbleView implements ILabelView {

    /* renamed from: a */
    private Context f29291a;

    /* renamed from: b */
    private LabelMarker.ILabelRule f29292b;

    /* renamed from: c */
    private String f29293c;

    /* renamed from: d */
    private int f29294d = -1;

    /* renamed from: e */
    private BitmapDescriptor f29295e;

    public /* synthetic */ View getView(Context context, String str) {
        return ILabelView.CC.$default$getView(this, context, str);
    }

    public /* synthetic */ View getView(Context context, String str, int i, boolean z) {
        return ILabelView.CC.$default$getView(this, context, str, i, z);
    }

    public MarkerBubbleView(Context context) {
        this.f29291a = context;
    }

    public void setLabel(String str) {
        this.f29293c = str;
    }

    public void setLabelRule(LabelMarker.ILabelRule iLabelRule) {
        this.f29292b = iLabelRule;
    }

    public void setLabelColorResId(int i) {
        this.f29294d = i;
    }

    public void setLabelAnchorIcon(BitmapDescriptor bitmapDescriptor) {
        this.f29295e = bitmapDescriptor;
    }

    public View getView(Context context, String str, int i) {
        int i2 = R.layout.label_marker_left;
        if (i != 16 && i == 1) {
            i2 = R.layout.label_marker_right;
        }
        View inflate = LayoutInflater.from(this.f29291a).inflate(i2, (ViewGroup) null);
        MapStrokeTextView mapStrokeTextView = (MapStrokeTextView) inflate.findViewById(R.id.label_marker_text);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.label_marker_anchor);
        if (!TextUtils.isEmpty(this.f29293c)) {
            mapStrokeTextView.setText(this.f29292b.applyLabelRule(mapStrokeTextView, this.f29293c));
        }
        if (this.f29294d != -1) {
            mapStrokeTextView.setTextColor(this.f29291a.getResources().getColor(this.f29294d));
        }
        BitmapDescriptor bitmapDescriptor = this.f29295e;
        if (bitmapDescriptor != null) {
            Bitmap bitmap = bitmapDescriptor.getBitmap();
            imageView.setImageBitmap(bitmap);
            bitmap.getWidth();
            int textSize = (int) (((mapStrokeTextView.getTextSize() + mapStrokeTextView.getStrokeWidth()) / 2.0f) - (((float) bitmap.getHeight()) / 2.0f));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, textSize, marginLayoutParams.rightMargin, 0);
            imageView.setLayoutParams(marginLayoutParams);
        }
        return inflate;
    }
}
