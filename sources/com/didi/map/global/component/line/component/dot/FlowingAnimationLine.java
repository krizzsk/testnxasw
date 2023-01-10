package com.didi.map.global.component.line.component.dot;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineClickListener;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.utils.DouglasUtil;
import com.didi.map.global.component.line.utils.LineUtils;
import com.didi.trackupload.sdk.Constants;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FlowingAnimationLine implements ICompLineContract {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f27980a = FlowingAnimationLine.class.getSimpleName();

    /* renamed from: m */
    private static final long f27981m = 50;

    /* renamed from: n */
    private static final long f27982n = 500;

    /* renamed from: b */
    private LineParams f27983b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f27984c;

    /* renamed from: d */
    private Context f27985d;

    /* renamed from: e */
    private List<Marker> f27986e = new ArrayList();

    /* renamed from: f */
    private double f27987f;

    /* renamed from: g */
    private boolean f27988g = true;

    /* renamed from: h */
    private List<LatLng> f27989h;

    /* renamed from: i */
    private OnLineDrawStatusListener f27990i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f27991j;

    /* renamed from: k */
    private boolean f27992k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f27993l = false;

    /* renamed from: o */
    private long f27994o;

    /* renamed from: p */
    private OnCameraChangeListener f27995p;

    /* renamed from: q */
    private OnMapGestureListener f27996q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public double f27997r;

    /* renamed from: s */
    private Handler f27998s = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 13) {
                DLog.m10773d(FlowingAnimationLine.f27980a, "handleMessage:MSG_SHOW", new Object[0]);
                if (FlowingAnimationLine.this.f27984c != null && Math.abs(FlowingAnimationLine.this.f27997r - FlowingAnimationLine.this.f27984c.getCameraPosition().zoom) > 0.5d) {
                    FlowingAnimationLine flowingAnimationLine = FlowingAnimationLine.this;
                    double unused = flowingAnimationLine.f27997r = flowingAnimationLine.f27984c.getCameraPosition().zoom;
                    if (!FlowingAnimationLine.this.f27991j) {
                        boolean unused2 = FlowingAnimationLine.this.f27993l = true;
                        FlowingAnimationLine.this.start();
                        boolean unused3 = FlowingAnimationLine.this.f27993l = false;
                    }
                }
            }
        }
    };

    public void onMapVisible(boolean z) {
    }

    public void stop() {
    }

    public void create(Context context, Map map) {
        this.f27984c = map;
        this.f27985d = context;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null) {
            this.f27983b = lineParams;
            this.f27989h = lineParams.getLinePoints();
            this.f27987f = (double) DisplayUtils.dp2px(this.f27985d, lineParams.getDotSpace());
            if (!this.f27992k && lineParams.getExParam() != null && lineParams.getExParam().isHasDotLineZoomListener()) {
                this.f27992k = true;
                m22043b();
            }
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmpty((Collection<?>) this.f27986e)) {
            for (Marker next : this.f27986e) {
                if (next.isVisible()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f27990i = onLineDrawStatusListener;
    }

    public void setLineVisible(boolean z) {
        this.f27988g = z;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f27986e)) {
            for (Marker next : this.f27986e) {
                if (next != null) {
                    next.setVisible(z);
                }
            }
        }
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        Map map = this.f27984c;
        if (map != null && onLineClickListener != null) {
            map.addOnMarkerClickListener(new OnMarkerClickListener(onLineClickListener) {
                public final /* synthetic */ OnLineClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean onMarkerClick(Marker marker) {
                    return FlowingAnimationLine.this.m22040a(this.f$1, marker);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m22040a(OnLineClickListener onLineClickListener, Marker marker) {
        if (CollectionUtil.isEmpty((Collection<?>) this.f27986e)) {
            return false;
        }
        for (Marker marker2 : this.f27986e) {
            if (marker2 == marker) {
                onLineClickListener.onLineClick(this);
                return true;
            }
        }
        return false;
    }

    public void start() {
        BitmapDescriptor bitmapDescriptor;
        OnLineDrawStatusListener onLineDrawStatusListener;
        if (LineUtils.INSTANCE.isMainThread()) {
            if (this.f27984c == null || this.f27985d == null || CollectionUtil.isEmpty((Collection<?>) this.f27989h) || this.f27986e == null) {
                DLog.m10773d(f27980a, "showFlowingAnimation:return2", new Object[0]);
                return;
            }
            if (this.f27997r == 0.0d) {
                this.f27997r = this.f27984c.getCameraPosition().zoom;
            }
            clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(this.f27989h);
            DouglasUtil douglasUtil = new DouglasUtil(this.f27984c.getProjection());
            douglasUtil.setThreshold(5);
            arrayList2.addAll(douglasUtil.getDouglasOptimiseLatLngs(arrayList));
            List<LatLng> a = m22035a((List<LatLng>) arrayList2);
            DLog.m10773d(f27980a, "originalRoutes:%d, douglasRoutes:%d, fillRoutes:%d", Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(a.size()));
            LineParams lineParams = this.f27983b;
            if (lineParams == null || lineParams.getDottedIconRes() == 0) {
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(this.f27985d, R.drawable.blue_dot);
            } else {
                bitmapDescriptor = BitmapDescriptorFactory.fromResource(this.f27985d, this.f27983b.getDottedIconRes());
            }
            for (int i = 0; i < a.size(); i++) {
                MarkerOptions markerOptions = new MarkerOptions();
                if (this.f27983b.isClickable()) {
                    markerOptions.clickable(this.f27983b.isClickable());
                }
                markerOptions.position(a.get(i));
                markerOptions.icon(bitmapDescriptor);
                markerOptions.draggable(false);
                markerOptions.anchor(0.5f, 0.5f);
                Marker addMarker = this.f27984c.addMarker(markerOptions);
                if (addMarker != null) {
                    addMarker.setVisible(this.f27988g);
                    this.f27986e.add(addMarker);
                }
            }
            for (int i2 = 0; i2 < this.f27986e.size(); i2++) {
                m22039a(a, i2, this.f27986e.get(i2), this.f27983b.getExParam() != null ? (long) this.f27983b.getExParam().getPulseAnimDuration() : Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
            }
            if (!this.f27993l && (onLineDrawStatusListener = this.f27990i) != null) {
                onLineDrawStatusListener.onLineDrawFinished();
                return;
            }
            return;
        }
        throw new RuntimeException("don't run main thread.");
    }

    public void updateLinePoints(List<LatLng> list) {
        this.f27989h = list;
        start();
    }

    public List<LatLng> getAllLinePoints() {
        return this.f27989h;
    }

    /* renamed from: a */
    private List<LatLng> m22035a(List<LatLng> list) {
        Map map;
        List<LatLng> list2 = list;
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            arrayList.add(list2.get(0));
            if (list.size() > 1) {
                LatLng latLng = null;
                int i = 0;
                for (int i2 = 1; i < list.size() - i2; i2 = 1) {
                    LatLng latLng2 = list2.get(i);
                    int i3 = i + 1;
                    LatLng latLng3 = list2.get(i3);
                    double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng2, latLng3);
                    double d = (latLng3.latitude - latLng2.latitude) / computeDistanceBetween;
                    double d2 = (latLng3.longitude - latLng2.longitude) / computeDistanceBetween;
                    int i4 = i3;
                    latLng = latLng;
                    int i5 = 0;
                    while (true) {
                        double d3 = (double) i5;
                        if (d3 >= computeDistanceBetween) {
                            break;
                        }
                        double d4 = computeDistanceBetween;
                        double d5 = d;
                        LatLng latLng4 = new LatLng(latLng2.latitude + (d * d3), latLng2.longitude + (d3 * d2));
                        if (!(latLng == null || (map = this.f27984c) == null || map.getProjection() == null)) {
                            if (DouglasUtil.distance(this.f27984c.getProjection().toScreenLocation(latLng), this.f27984c.getProjection().toScreenLocation(latLng4)) < this.f27987f) {
                                i5++;
                                computeDistanceBetween = d4;
                                d = d5;
                            } else {
                                arrayList.add(latLng4);
                            }
                        }
                        latLng = latLng4;
                        i5++;
                        computeDistanceBetween = d4;
                        d = d5;
                    }
                    i = i4;
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22039a(List<LatLng> list, int i, Marker marker, long j) {
        if (this.f27986e.size() != 0 && list.size() > 1) {
            if (i == list.size() - 1) {
                i %= list.size() - 1;
            }
            final int i2 = i;
            LatLng latLng = list.get(i2);
            LatLng latLng2 = list.get(i2 + 1);
            marker.setRotation((float) DDSphericalUtil.computeHeading(latLng, latLng2));
            ValueAnimator ofObject = ValueAnimator.ofObject(new LatLngTypeEvaluator(), new Object[]{latLng, latLng2});
            ofObject.setDuration(j);
            ofObject.setInterpolator(new LinearInterpolator());
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FlowingAnimationLine.m22037a(Marker.this, valueAnimator);
                }
            });
            final Marker marker2 = marker;
            final List<LatLng> list2 = list;
            final long j2 = j;
            ofObject.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    Marker marker = marker2;
                    if (marker != null) {
                        FlowingAnimationLine.this.m22039a(list2, i2 + 1, marker, j2);
                    }
                }
            });
            ofObject.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m22037a(Marker marker, ValueAnimator valueAnimator) {
        LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
        if (marker != null) {
            marker.setPosition(latLng);
        }
    }

    public void clear() {
        List<Marker> list;
        String str = f27980a;
        DLog.m10773d(str, this + " : stopFlowingAnimation", new Object[0]);
        if (this.f27984c != null && (list = this.f27986e) != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            for (int i = 0; i < this.f27986e.size(); i++) {
                if (this.f27986e.get(i) != null) {
                    this.f27984c.remove(this.f27986e.get(i));
                }
            }
            this.f27986e.clear();
        }
    }

    public void destroy() {
        OnCameraChangeListener onCameraChangeListener;
        this.f27991j = true;
        Map map = this.f27984c;
        if (!(map == null || (onCameraChangeListener = this.f27995p) == null || this.f27996q == null)) {
            map.removeOnCameraChangeListener(onCameraChangeListener);
            this.f27984c.removeOnMapGestureListener(this.f27996q);
        }
        clear();
    }

    private class LatLngTypeEvaluator implements TypeEvaluator<LatLng> {
        private LatLngTypeEvaluator() {
        }

        public LatLng evaluate(float f, LatLng latLng, LatLng latLng2) {
            double d = (double) f;
            return new LatLng(((latLng2.latitude - latLng.latitude) * d) + latLng.latitude, ((latLng2.longitude - latLng.longitude) * d) + latLng.longitude);
        }
    }

    /* renamed from: b */
    private void m22043b() {
        this.f27995p = new OnCameraChangeListener() {
            public final void onCameraChange(CameraPosition cameraPosition) {
                FlowingAnimationLine.this.m22036a(cameraPosition);
            }
        };
        this.f27996q = new OnMapGestureListener() {
            public boolean onDoubleTap(float f, float f2) {
                return false;
            }

            public boolean onDown(float f, float f2) {
                return false;
            }

            public boolean onFling(float f, float f2) {
                return false;
            }

            public boolean onLongPress(float f, float f2) {
                return false;
            }

            public boolean onScroll(float f, float f2) {
                return false;
            }

            public boolean onSingleTap(float f, float f2) {
                return false;
            }

            public void onMapStable() {
                FlowingAnimationLine.this.m22044c();
            }

            public boolean onUp(float f, float f2) {
                FlowingAnimationLine.this.m22044c();
                return false;
            }
        };
        Map map = this.f27984c;
        if (map != null) {
            map.addOnCameraChangeListener(this.f27995p);
            this.f27984c.addOnMapGestureListener(this.f27996q);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22036a(CameraPosition cameraPosition) {
        if (System.currentTimeMillis() - this.f27994o > 50) {
            this.f27994o = System.currentTimeMillis();
            m22044c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m22044c() {
        Handler handler = this.f27998s;
        if (handler != null) {
            handler.removeMessages(13);
            Message obtainMessage = this.f27998s.obtainMessage();
            obtainMessage.what = 13;
            this.f27998s.sendMessageDelayed(obtainMessage, 500);
            DLog.m10773d(f27980a, "：sendShowMessage", new Object[0]);
        }
    }
}
