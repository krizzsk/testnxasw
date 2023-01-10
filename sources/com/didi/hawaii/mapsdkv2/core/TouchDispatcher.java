package com.didi.hawaii.mapsdkv2.core;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import com.didi.hawaii.mapsdk.gesture.AndroidGestureOption;
import com.didi.hawaii.mapsdk.gesture.AndroidGesturesManager;
import com.didi.hawaii.mapsdk.gesture.Constants;
import com.didi.hawaii.mapsdk.gesture.MoveGestureDetector;
import com.didi.hawaii.mapsdk.gesture.MultiFingerTapGestureDetector;
import com.didi.hawaii.mapsdk.gesture.RotateGestureDetector;
import com.didi.hawaii.mapsdk.gesture.ShoveGestureDetector;
import com.didi.hawaii.mapsdk.gesture.StandardGestureDetector;
import com.didi.hawaii.mapsdk.gesture.StandardScaleGestureDetector;
import com.didi.hawaii.mapsdkv2.common.MapLog;
import com.didi.hawaii.mapsdkv2.core.MapEngine;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.outer.model.LatLng;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class TouchDispatcher {

    /* renamed from: a */
    private static final String f26252a = "TouchDispatcher";

    /* renamed from: b */
    private static final boolean f26253b = ApolloHawaii.isUseNewGesture();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AndroidGesturesManager f26254c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final GLViewRootImpl f26255d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final MapEngine f26256e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final GLBaseMapView f26257f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final GLUiSetting f26258g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<Runnable> f26259h = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f26260i;

    /* renamed from: j */
    private final Handler f26261j;

    public TouchDispatcher(GLViewRootImpl gLViewRootImpl, MapEngine mapEngine) {
        this.f26255d = gLViewRootImpl;
        this.f26256e = mapEngine;
        Context androidContext = gLViewRootImpl.getMapContext().getAndroidContext();
        AndroidGestureOption androidGestureOption = new AndroidGestureOption();
        androidGestureOption.applyDefaultThresholds = true;
        androidGestureOption.useNNClassfy = f26253b;
        this.f26254c = new AndroidGesturesManager(androidContext, androidGestureOption);
        GLBaseMapView baseMap = gLViewRootImpl.getBaseMap();
        this.f26257f = baseMap;
        this.f26258g = baseMap.getUiSetting();
        this.f26261j = gLViewRootImpl.getMainHandler();
        m20744a();
        m20747b();
    }

    /* renamed from: a */
    private void m20744a() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        hashSet.add(13);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(3);
        hashSet2.add(1);
        HashSet hashSet3 = new HashSet();
        hashSet3.add(3);
        hashSet3.add(2);
        HashSet hashSet4 = new HashSet();
        hashSet4.add(1);
        hashSet4.add(6);
        this.f26254c.setMutuallyExclusiveGestures((Set<Integer>[]) new Set[]{hashSet, hashSet2, hashSet3, hashSet4});
    }

    /* renamed from: b */
    private void m20747b() {
        this.f26254c.setStandardGestureListener(new StandardGestureListener());
        this.f26254c.setMoveGestureListener(new MoveGestureListener());
        this.f26254c.setRotateGestureListener(new RotateGestureListener());
        this.f26254c.setStandardScaleGestureListener(new ScaleGestureListener());
        this.f26254c.setShoveGestureListener(new ShoveGestureListener());
        this.f26254c.setMultiFingerTapGestureListener(new TapGestureListener());
    }

    private class StandardGestureListener extends StandardGestureDetector.SimpleStandardOnGestureListener {
        private StandardGestureListener() {
        }

        public boolean onSingleTapConfirmed(final MotionEvent motionEvent) {
            Future postToRenderThread = TouchDispatcher.this.f26255d.postToRenderThread(new Callable<MapEngine.TapItem>() {
                public MapEngine.TapItem call() throws Exception {
                    MapEngine.TapItem tapItem = new MapEngine.TapItem();
                    if (TouchDispatcher.this.f26256e.tap((int) motionEvent.getX(), (int) motionEvent.getY(), tapItem)) {
                        return tapItem;
                    }
                    LatLng fromScreenLocation = TouchDispatcher.this.f26256e.fromScreenLocation(motionEvent.getX(), motionEvent.getY());
                    tapItem.type = 0;
                    tapItem.geo.latitude = fromScreenLocation.latitude;
                    tapItem.geo.longitude = fromScreenLocation.longitude;
                    return tapItem;
                }
            });
            if (postToRenderThread == null) {
                return false;
            }
            try {
                MapEngine.TapItem tapItem = (MapEngine.TapItem) postToRenderThread.get(500, TimeUnit.MILLISECONDS);
                if (tapItem == null) {
                    return false;
                }
                GLOverlayView a = TouchDispatcher.this.f26255d.mo76046a(tapItem.displayId);
                if (a == null && tapItem.bubbleId > 0) {
                    a = TouchDispatcher.this.f26255d.mo76051b((int) tapItem.bubbleId);
                }
                if (a != null && tapItem.updateZIndex) {
                    a.setZIndex(tapItem.zIndex);
                }
                Gesture.m20720a(motionEvent.getX(), motionEvent.getY(), 17, tapItem.geo);
                Gesture a2 = Gesture.m20720a(motionEvent.getX(), motionEvent.getY(), 17, tapItem);
                a2.setGlOverlayView(a);
                boolean dispatchGestureEvent = TouchDispatcher.this.f26257f.dispatchGestureEvent(a2);
                if (a != null && a.isAdded()) {
                    a.dispatchGestureEvent(a2);
                    a2.mo76066a();
                }
                a2.mo76066a();
                return dispatchGestureEvent;
            } catch (InterruptedException e) {
                MapLog.m20588e(TouchDispatcher.f26252a, e.getMessage(), e);
                Thread.currentThread().interrupt();
                return false;
            } catch (ExecutionException | TimeoutException e2) {
                MapLog.m20588e(TouchDispatcher.f26252a, e2.getMessage(), e2);
                return false;
            }
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            Gesture a = Gesture.m20720a(motionEvent.getX(), motionEvent.getY(), 23, (Object) null);
            boolean dispatchGestureEvent = TouchDispatcher.this.f26257f.dispatchGestureEvent(a);
            a.mo76066a();
            return dispatchGestureEvent;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                boolean unused = TouchDispatcher.this.f26260i = true;
            }
            if (motionEvent.getActionMasked() != 1) {
                return super.onDoubleTapEvent(motionEvent);
            }
            if (!TouchDispatcher.this.f26258g.isZoomGesturesEnabled() || !TouchDispatcher.this.f26260i) {
                return false;
            }
            Gesture a = Gesture.m20720a(motionEvent.getX(), motionEvent.getY(), 32, (Object) null);
            boolean dispatchGestureEvent = TouchDispatcher.this.f26257f.dispatchGestureEvent(a);
            a.mo76066a();
            return dispatchGestureEvent;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return super.onDown(motionEvent);
        }

        public void onShowPress(MotionEvent motionEvent) {
            super.onShowPress(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return super.onSingleTapUp(motionEvent);
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f == 0.0f && f2 == 0.0f) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            Gesture a = Gesture.m20720a(f, f2, 8, (Object) null);
            boolean dispatchGestureEvent = TouchDispatcher.this.f26257f.dispatchGestureEvent(a);
            a.mo76066a();
            return dispatchGestureEvent;
        }

        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
            Gesture a = Gesture.m20720a(motionEvent.getX(), motionEvent.getY(), 18, TouchDispatcher.this.f26257f.getProjection().fromScreen(motionEvent.getX(), motionEvent.getY()));
            TouchDispatcher.this.f26257f.dispatchGestureEvent(a);
            a.mo76066a();
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!TouchDispatcher.this.f26258g.isScrollGesturesEnabled() || Math.max(Math.abs(f), Math.abs(f2)) <= 512.0f) {
                return false;
            }
            Gesture a = Gesture.m20720a(f, f2, 19, (Object) null);
            boolean dispatchGestureEvent = TouchDispatcher.this.f26257f.dispatchGestureEvent(a);
            a.mo76066a();
            return dispatchGestureEvent;
        }
    }

    private class MoveGestureListener extends MoveGestureDetector.SimpleOnMoveGestureListener {
        private MoveGestureListener() {
        }

        public boolean onMoveBegin(MoveGestureDetector moveGestureDetector) {
            if (!TouchDispatcher.this.f26258g.isScrollGesturesEnabled()) {
                return false;
            }
            if (TouchDispatcher.this.f26258g.mo75961c()) {
                TouchDispatcher.this.f26254c.getRotateGestureDetector().setAngleThresholdWhenMove(Constants.ROTATION_THRESHOLD_INCREASE_WHEN_MULTI_MOVE);
                TouchDispatcher.this.f26254c.getStandardScaleGestureDetector().setSpanSinceStartThreshold((float) Constants.MINI_SAPN_SCALE_WHEN_MULTI_MOVE);
            }
            return super.onMoveBegin(moveGestureDetector);
        }

        public boolean onMove(MoveGestureDetector moveGestureDetector, float f, float f2) {
            if (f == 0.0f && f2 == 0.0f) {
                return true;
            }
            Gesture a = Gesture.m20720a(f, f2, 8, (Object) null);
            boolean dispatchGestureEvent = TouchDispatcher.this.f26257f.dispatchGestureEvent(a);
            a.mo76066a();
            return dispatchGestureEvent;
        }

        public void onMoveEnd(MoveGestureDetector moveGestureDetector, float f, float f2) {
            if (TouchDispatcher.this.f26258g.isScrollGesturesEnabled()) {
                if (TouchDispatcher.this.f26258g.mo75961c()) {
                    TouchDispatcher.this.f26254c.getRotateGestureDetector().setAngleThreshold(Constants.DEFAULT_ROTATE_ANGLE_THRESHOLD);
                    TouchDispatcher.this.f26254c.getStandardScaleGestureDetector().setSpanSinceStartThreshold((float) Constants.DEFAULT_SCALE_SPAN_START);
                }
                if (Math.max(Math.abs(f), Math.abs(f2)) > 512.0f) {
                    Gesture a = Gesture.m20720a(f, f2, 19, (Object) null);
                    TouchDispatcher.this.f26257f.dispatchGestureEvent(a);
                    a.mo76066a();
                }
            }
        }
    }

    private final class RotateGestureListener extends RotateGestureDetector.SimpleOnRotateGestureListener {
        private boolean allowRotateGesture() {
            return true;
        }

        private RotateGestureListener() {
        }

        public boolean onRotateBegin(RotateGestureDetector rotateGestureDetector) {
            if (!TouchDispatcher.this.f26258g.isRotateGesturesEnabled() || !allowRotateGesture()) {
                return false;
            }
            if (TouchDispatcher.this.f26258g.mo75960b()) {
                TouchDispatcher.this.f26254c.getStandardScaleGestureDetector().setSpanSinceStartThreshold((float) Constants.MINI_SAPN_SCALE_WHEN_ROTATE);
                TouchDispatcher.this.f26254c.getStandardScaleGestureDetector().interrupt();
            }
            return super.onRotateBegin(rotateGestureDetector);
        }

        public boolean onRotate(RotateGestureDetector rotateGestureDetector, float f) {
            Gesture a = Gesture.m20720a(rotateGestureDetector.getFocalPoint().x, rotateGestureDetector.getFocalPoint().y, 21, Float.valueOf(-f));
            boolean dispatchGestureEvent = TouchDispatcher.this.f26257f.dispatchGestureEvent(a);
            a.mo76066a();
            return dispatchGestureEvent;
        }

        public void onRotateEnd(RotateGestureDetector rotateGestureDetector, float f, float f2, float f3) {
            super.onRotateEnd(rotateGestureDetector, f, f2, f3);
            if (TouchDispatcher.this.f26258g.mo75960b()) {
                TouchDispatcher.this.f26254c.getStandardScaleGestureDetector().setSpanSinceStartThreshold((float) Constants.DEFAULT_SCALE_SPAN_START);
            }
            final float f4 = f;
            final float f5 = f2;
            final float f6 = f3;
            final RotateGestureDetector rotateGestureDetector2 = rotateGestureDetector;
            TouchDispatcher.this.f26259h.add(new Runnable() {
                public void run() {
                    if (f4 == 0.0f && f5 == 0.0f) {
                        TouchDispatcher.this.f26257f.stopAnimation();
                        return;
                    }
                    float min = Math.min(20.0f, Math.max((float) Math.pow((double) f6, 2.0d), 1.5f));
                    long log = (long) (Math.log((double) (1.0f + min)) * 500.0d);
                    if (f6 > 0.0f) {
                        min = -min;
                    }
                    TouchDispatcher.this.f26257f.mo75568b(min, log, rotateGestureDetector2.getFocalPoint());
                }
            });
        }
    }

    private final class ScaleGestureListener extends StandardScaleGestureDetector.SimpleStandardOnScaleGestureListener {
        private boolean quickZoom;

        private ScaleGestureListener() {
        }

        public boolean onScaleBegin(StandardScaleGestureDetector standardScaleGestureDetector) {
            if (!TouchDispatcher.this.f26258g.isZoomGesturesEnabled()) {
                return false;
            }
            boolean z = true;
            if (standardScaleGestureDetector.getPointersCount() != 1) {
                z = false;
            }
            this.quickZoom = z;
            if (z) {
                boolean unused = TouchDispatcher.this.f26260i = false;
                TouchDispatcher.this.f26254c.getMoveGestureDetector().setEnabled(false);
            }
            if (TouchDispatcher.this.f26258g.mo75959a()) {
                TouchDispatcher.this.f26254c.getRotateGestureDetector().setAngleThreshold((float) Constants.ROTATION_THRESHOLD_INCREASE_WHEN_SCALING);
            }
            return super.onScaleBegin(standardScaleGestureDetector);
        }

        public boolean onScale(StandardScaleGestureDetector standardScaleGestureDetector) {
            Gesture gesture;
            float scaleFactor = standardScaleGestureDetector.getScaleFactor();
            if (this.quickZoom) {
                gesture = Gesture.m20721a(35, Float.valueOf(getNewFactor(scaleFactor)));
            } else {
                gesture = Gesture.m20720a(standardScaleGestureDetector.getFocalPoint().x, standardScaleGestureDetector.getFocalPoint().y, 22, Float.valueOf(scaleFactor));
            }
            boolean dispatchGestureEvent = TouchDispatcher.this.f26257f.dispatchGestureEvent(gesture);
            gesture.mo76066a();
            return dispatchGestureEvent;
        }

        private float getNewFactor(float f) {
            return Math.min(1.2f, Math.max(f, 0.8f));
        }

        public void onScaleEnd(final StandardScaleGestureDetector standardScaleGestureDetector, final float f, final float f2) {
            if (this.quickZoom) {
                TouchDispatcher.this.f26254c.getMoveGestureDetector().setEnabled(true);
            }
            if (TouchDispatcher.this.f26258g.mo75959a()) {
                TouchDispatcher.this.f26254c.getRotateGestureDetector().setAngleThreshold(Constants.DEFAULT_ROTATE_ANGLE_THRESHOLD);
            }
            TouchDispatcher.this.f26259h.add(new Runnable() {
                public void run() {
                    float abs = Math.abs(f) + Math.abs(f2);
                    boolean z = false;
                    boolean z2 = abs != 0.0f;
                    if (abs >= 800.0f) {
                        z = z2;
                    } else if (standardScaleGestureDetector.getMoveVelocityAverage() >= 5.0f ? !(standardScaleGestureDetector.getCustomComputeVelocity() <= 4.5f || abs <= standardScaleGestureDetector.getMoveVelocityAverage()) : standardScaleGestureDetector.getCustomComputeVelocity() > 4.5f) {
                        z = true;
                    }
                    if (!z) {
                        TouchDispatcher.this.f26257f.stopAnimation();
                        return;
                    }
                    double access$1300 = ScaleGestureListener.this.calculateScale((double) abs, standardScaleGestureDetector.isScalingOut());
                    TouchDispatcher.this.f26257f.mo75559a((float) access$1300, ((long) ((Math.abs(access$1300) * 400.0d) / 4.0d)) + 150, standardScaleGestureDetector.getFocalPoint());
                }
            });
        }

        /* access modifiers changed from: private */
        public double calculateScale(double d, boolean z) {
            double log = (double) ((float) Math.log((d / 400.0d) + 3.5d));
            return z ? -log : log;
        }
    }

    private final class ShoveGestureListener extends ShoveGestureDetector.SimpleOnShoveGestureListener {
        private ShoveGestureListener() {
        }

        public boolean onShoveBegin(ShoveGestureDetector shoveGestureDetector) {
            if (!TouchDispatcher.this.f26258g.isTiltGesturesEnabled()) {
                return false;
            }
            TouchDispatcher.this.f26254c.getMoveGestureDetector().setEnabled(false);
            TouchDispatcher.this.f26254c.getStandardScaleGestureDetector().setEnabled(false);
            TouchDispatcher.this.f26254c.getRotateGestureDetector().setEnabled(false);
            return super.onShoveBegin(shoveGestureDetector);
        }

        public boolean onShove(ShoveGestureDetector shoveGestureDetector, float f, float f2) {
            Gesture a = Gesture.m20720a(0.0f, -0.1f * f, 20, Float.valueOf(f));
            boolean dispatchGestureEvent = TouchDispatcher.this.f26257f.dispatchGestureEvent(a);
            a.mo76066a();
            return dispatchGestureEvent;
        }

        public void onShoveEnd(ShoveGestureDetector shoveGestureDetector, float f, float f2) {
            TouchDispatcher.this.f26254c.getMoveGestureDetector().setEnabled(true);
            TouchDispatcher.this.f26254c.getStandardScaleGestureDetector().setEnabled(true);
            TouchDispatcher.this.f26254c.getRotateGestureDetector().setEnabled(true);
            super.onShoveEnd(shoveGestureDetector, f, f2);
        }
    }

    private final class TapGestureListener implements MultiFingerTapGestureDetector.OnMultiFingerTapGestureListener {
        private TapGestureListener() {
        }

        public boolean onMultiFingerDown(MotionEvent motionEvent) {
            Gesture a = Gesture.m20720a(motionEvent.getX(), motionEvent.getY(), 5, (Object) null);
            TouchDispatcher.this.f26257f.dispatchGestureEvent(a);
            a.mo76066a();
            return true;
        }

        public boolean onMultiFingerUp(MotionEvent motionEvent) {
            Gesture a = Gesture.m20720a(motionEvent.getX(), motionEvent.getY(), 6, (Object) null);
            TouchDispatcher.this.f26257f.dispatchGestureEvent(a);
            a.mo76066a();
            return true;
        }

        public boolean onMultiFingerTap(MultiFingerTapGestureDetector multiFingerTapGestureDetector, int i) {
            if (!TouchDispatcher.this.f26258g.isZoomGesturesEnabled() || i != 2) {
                return false;
            }
            Gesture a = Gesture.m20721a(36, multiFingerTapGestureDetector.getFocalPoint());
            boolean dispatchGestureEvent = TouchDispatcher.this.f26257f.dispatchGestureEvent(a);
            a.mo76066a();
            return dispatchGestureEvent;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo76388a(MotionEvent motionEvent) {
        if (!this.f26258g.isAllGestureEnabled()) {
            return false;
        }
        boolean onTouchEvent = this.f26254c.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m20749c();
            Gesture a = Gesture.m20720a(motionEvent.getX(), motionEvent.getY(), 0, (Object) null);
            this.f26257f.dispatchGestureEvent(a);
            a.mo76066a();
        } else if (actionMasked == 1) {
            if (!this.f26259h.isEmpty()) {
                for (Runnable post : this.f26259h) {
                    this.f26261j.post(post);
                }
                this.f26259h.clear();
            }
            Gesture a2 = Gesture.m20720a(motionEvent.getX(), motionEvent.getY(), 1, (Object) null);
            this.f26257f.dispatchGestureEvent(a2);
            a2.mo76066a();
        } else if (actionMasked == 2) {
            Gesture a3 = Gesture.m20720a(motionEvent.getX(), motionEvent.getY(), 2, (Object) null);
            this.f26257f.dispatchGestureEvent(a3);
            a3.mo76066a();
        } else if (actionMasked == 3) {
            this.f26259h.clear();
        }
        return onTouchEvent;
    }

    /* renamed from: c */
    private void m20749c() {
        this.f26259h.clear();
        this.f26257f.stopAnimation();
    }
}
