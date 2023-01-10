package com.didi.hawaii.mapsdkv2.core.overlay;

import android.graphics.Rect;
import com.didi.hawaii.mapsdkv2.core.GLOverlayGroup;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.jni.DDMapPointArray;
import com.didi.hawaii.mapsdkv2.jni.DMapLine;
import com.didi.hawaii.mapsdkv2.jni.HWBSManager;
import com.didi.hawaii.mapsdkv2.jni.MapEngineJNI;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.outer.model.LatLng;
import java.util.List;

public class GLCollisionGroup extends GLOverlayGroup {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HWBSManager f26324a;

    /* renamed from: b */
    private int f26325b;

    /* renamed from: c */
    private int f26326c;

    /* renamed from: d */
    private final Rect f26327d;

    public GLCollisionGroup(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f26327d = option.padding;
        HWBSManager hWBSManager = new HWBSManager();
        this.f26324a = hWBSManager;
        Rect rect = this.f26327d;
        if (rect != null) {
            hWBSManager.setPadding(rect.left, this.f26327d.right, this.f26327d.top, this.f26327d.bottom);
        }
        this.f26324a.setIsAreaBubbleEnable(true);
        this.f26324a.setMultiBubbleSelectPointEnable(true);
        this.f26324a.setAnimateEnable(ApolloHawaii.OPEN_ANIMATE, ApolloHawaii.OPEN_ANIMATE_HAS_DEL_ANIMATE);
        setIgnoreGroupAttrs(true);
        attachToFrame(true);
    }

    public void onFrameFinish(boolean z) {
        super.onFrameFinish(z);
        HWBSManager hWBSManager = this.f26324a;
        if (hWBSManager != null) {
            hWBSManager.drawAnimation();
        }
    }

    public void addView(GLOverlayView gLOverlayView) {
        if (gLOverlayView instanceof GLCollisionMarker) {
            ((GLCollisionMarker) gLOverlayView).attachCollisionEngine(this.f26324a);
        }
        if (gLOverlayView instanceof GLCollisionStub) {
            ((GLCollisionStub) gLOverlayView).attachCollisionEngine(this.f26324a);
        }
        super.addView(gLOverlayView);
    }

    public void addRoute4Collision(final List<LatLng> list) {
        set(new RenderTask() {
            public void run() {
                List list = list;
                if (list != null && list.size() >= 2) {
                    DMapLine dMapLine = new DMapLine();
                    DDMapPointArray dDMapPointArray = new DDMapPointArray(list.size());
                    for (int i = 0; i < list.size(); i++) {
                        dDMapPointArray.setitem(i, MapEngineJNI.DDMapPointForCoordinate(MapEngineJNI.DDLocationCoordinate2DMake(((LatLng) list.get(i)).longitude, ((LatLng) list.get(i)).latitude)));
                    }
                    dMapLine.setSize(list.size());
                    dMapLine.setPoints(dDMapPointArray.cast());
                    GLCollisionGroup.this.f26324a.addRoute4Collision(dMapLine);
                }
            }
        });
    }

    public void clearRoute4Collision() {
        set(new RenderTask() {
            public void run() {
                GLCollisionGroup.this.f26324a.clearRoute4Collision();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        HWBSManager.destroy(this.f26324a);
    }

    public void setPadding(final Rect rect) {
        set(new RenderTask() {
            public void run() {
                GLCollisionGroup.this.f26324a.setPadding(rect.left, rect.right, rect.top, rect.bottom);
            }
        });
    }

    public void checkCollision() {
        set(new RenderTask() {
            public void run() {
                GLCollisionGroup.this.f26324a.handleCollision();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        super.onAdded();
        this.mMapCanvas.attachMapEngine(this.f26324a);
    }

    /* access modifiers changed from: protected */
    public void onHostSizeChanged(int i, int i2) {
        super.onHostSizeChanged(i, i2);
        if (this.f26326c != i2 || this.f26325b != i) {
            this.f26326c = i2;
            this.f26325b = i;
            this.f26324a.initCollisionRect(0, 0, i, i2);
        }
    }

    public static class Option extends GLOverlayGroup.Option {
        /* access modifiers changed from: private */
        public Rect padding;

        public void setPadding(Rect rect) {
            this.padding = rect;
        }
    }
}
