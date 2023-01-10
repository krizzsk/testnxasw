package com.didi.map.global.flow.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.map.global.flow.scene.order.serving.components.MapStrokeTextView;
import com.didi.map.global.flow.utils.ZIndexUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import org.osgi.framework.VersionRange;

public class AddressNameMarkerWrapper {

    /* renamed from: a */
    private static final char[] f29821a = {VersionRange.LEFT_OPEN, VersionRange.LEFT_CLOSED, 65288};

    /* renamed from: b */
    private static final char[] f29822b = {VersionRange.RIGHT_OPEN, VersionRange.RIGHT_CLOSED, 65289};

    /* renamed from: c */
    private Context f29823c;

    /* renamed from: d */
    private LatLng f29824d;

    /* renamed from: e */
    private String f29825e;

    /* renamed from: f */
    private Marker f29826f;

    /* renamed from: g */
    private Marker f29827g;

    public AddressNameMarkerWrapper(Context context, LatLng latLng, String str) {
        this.f29823c = context;
        this.f29824d = latLng;
        this.f29825e = str;
    }

    public List<IMapElement> getMapElements() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f29826f;
        if (marker != null) {
            arrayList.add(marker);
        }
        Marker marker2 = this.f29827g;
        if (marker2 != null) {
            arrayList.add(marker2);
        }
        return arrayList;
    }

    public void addToMap(Map map) {
        this.f29827g = m23103b(map);
    }

    public void removeFromMap(Map map) {
        if (map != null) {
            Marker marker = this.f29826f;
            if (marker != null) {
                map.remove(marker);
                this.f29826f = null;
            }
            Marker marker2 = this.f29827g;
            if (marker2 != null) {
                map.remove(marker2);
                this.f29827g = null;
            }
        }
    }

    /* renamed from: a */
    private Marker m23098a(Map map) {
        MarkerOptions markerOptions = new MarkerOptions();
        Bitmap a = m23097a(LayoutInflater.from(this.f29823c).inflate(R.layout.mfv_address_name_dot, (ViewGroup) null));
        if (a == null) {
            return null;
        }
        markerOptions.position(this.f29824d).anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromBitmap(a)).draggable(false).dodgeAnnotation(true).zIndex(ZIndexUtil.getZIndex(9));
        return map.addMarker(markerOptions);
    }

    /* renamed from: b */
    private Marker m23103b(Map map) {
        if (TextUtils.isEmpty(this.f29825e)) {
            return null;
        }
        String str = this.f29825e;
        MarkerOptions markerOptions = new MarkerOptions();
        View inflate = LayoutInflater.from(this.f29823c).inflate(R.layout.mfv_address_name_text, (ViewGroup) null);
        MapStrokeTextView mapStrokeTextView = (MapStrokeTextView) inflate.findViewById(R.id.tv_address_name);
        mapStrokeTextView.setText(str);
        mapStrokeTextView.getPaint().setFakeBoldText(true);
        Bitmap a = m23097a(inflate);
        if (a == null) {
            return null;
        }
        markerOptions.position(this.f29824d).anchor(0.0f, 0.0f).icon(BitmapDescriptorFactory.fromBitmap(a)).draggable(false).dodgeAnnotation(true).zIndex(ZIndexUtil.getZIndex(9));
        return map.addMarker(markerOptions);
    }

    /* renamed from: a */
    private String m23099a(String str) {
        int length = str.length();
        if (length > 14) {
            String substring = str.substring(0, 6);
            String substring2 = str.substring(length - 6, length);
            return substring + "..." + "\n" + "..." + substring2;
        } else if (length < 8) {
            return str;
        } else {
            if (length > 10) {
                if (m23101a(str.charAt(6))) {
                    return m23100a(str, 6);
                }
                if (m23104b(str.charAt(7))) {
                    return m23100a(str, 8);
                }
                return m23100a(str, 7);
            } else if (m23101a(str.charAt(5))) {
                if (!m23104b(str.charAt(7))) {
                    return m23100a(str, 7);
                }
                if (length == 8) {
                    return str;
                }
                return m23100a(str, 8);
            } else if (m23104b(str.charAt(6))) {
                return m23100a(str, 7);
            } else {
                return m23100a(str, 6);
            }
        }
    }

    /* renamed from: a */
    private boolean m23101a(char c) {
        return m23102a(f29821a, c);
    }

    /* renamed from: b */
    private boolean m23104b(char c) {
        return m23102a(f29822b, c);
    }

    /* renamed from: a */
    private boolean m23102a(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private String m23100a(String str, int i) {
        String substring = str.substring(0, i);
        String substring2 = str.substring(i, str.length());
        return substring + "\n" + substring2;
    }

    /* renamed from: a */
    private Bitmap m23097a(View view) {
        try {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            return view.getDrawingCache();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getTextWidth() {
        return this.f29827g.getMarkerSize().width;
    }

    public Marker getMarker() {
        return this.f29827g;
    }
}
