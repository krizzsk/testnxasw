package com.didi.hawaii.mapsdkv2.core.overlay;

import android.graphics.Rect;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLPrimaryShape;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.jni.HWBSManager;
import com.didi.hawaii.mapsdkv2.jni.MapOverlay;
import com.didi.hawaii.mapsdkv2.jni.MapOverlayRect;
import com.didi.hawaii.mapsdkv2.jni.MapOverlayRectArray;

public class GLCollisionStub extends GLPrimaryShape {

    /* renamed from: a */
    private Rect f26341a;

    /* renamed from: b */
    private int f26342b;

    /* renamed from: c */
    private int f26343c = Integer.MAX_VALUE;
    protected int collisionType;

    /* renamed from: d */
    private HWBSManager f26344d;

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
    }

    public void setZIndex(int i) {
    }

    public GLCollisionStub(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.collisionType = option.collisionType;
        this.f26343c = option.priority;
        this.f26342b = option.type;
        this.f26341a = new Rect(option.virtualPosition);
    }

    public void attachCollisionEngine(HWBSManager hWBSManager) {
        this.f26344d = hWBSManager;
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        HWBSManager hWBSManager = this.f26344d;
        if (hWBSManager != null && this.f26341a != null) {
            hWBSManager.addOverlay(m20807a());
            this.f26344d.handleCollision();
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        if (this.f26344d != null && this.mDisplayId != -2) {
            this.f26344d.removeOverlay(Long.valueOf(getId()).longValue());
            this.f26344d.handleCollision();
            this.f26344d = null;
            this.mDisplayId = -2;
        }
    }

    public static class Option extends GLOverlayView.Option {
        protected int collisionType;
        /* access modifiers changed from: private */
        public int priority = Integer.MAX_VALUE;
        protected int type;
        /* access modifiers changed from: private */
        public Rect virtualPosition;

        public void setCollisionType(int i) {
            this.collisionType = i;
        }

        public void setPriority(int i) {
            this.priority = i;
        }

        public void setVirtualPosition(Rect rect) {
            this.virtualPosition = rect;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    /* renamed from: a */
    private MapOverlay m20807a() {
        MapOverlay mapOverlay = new MapOverlay();
        mapOverlay.setOverlayId(Long.valueOf(getId()).longValue());
        mapOverlay.setType(this.f26342b);
        mapOverlay.setGroupId(-1);
        mapOverlay.setCollisionType(this.collisionType);
        mapOverlay.setLongitude((double) this.f26341a.right);
        mapOverlay.setLatitude((double) this.f26341a.bottom);
        mapOverlay.setScaleX(1.0f);
        mapOverlay.setScaleY(1.0f);
        mapOverlay.setFixPosX(0);
        mapOverlay.setFixPosY(0);
        mapOverlay.setAngle(0.0f);
        mapOverlay.setIsClockwise(false);
        mapOverlay.setIsFastLoad(false);
        mapOverlay.setIsAvoidAnno(false);
        mapOverlay.setIsVirtualScreenOverlay(true);
        mapOverlay.setIsOrthographicProject(false);
        mapOverlay.setZIndex(calculateTrueZIndex(this.mLayer, this.zIndex));
        mapOverlay.setAlpha(this.alpha);
        mapOverlay.setVisible(this.visible);
        mapOverlay.setPriority(this.f26343c);
        mapOverlay.setShowInfo("virtual");
        mapOverlay.setRectCnt(1);
        MapOverlayRectArray mapOverlayRectArray = new MapOverlayRectArray(4);
        MapOverlayRect mapOverlayRect = new MapOverlayRect();
        mapOverlayRect.setAnchorX(1.0f);
        mapOverlayRect.setAnchorY(1.0f);
        int abs = Math.abs(this.f26341a.right - this.f26341a.left);
        int abs2 = Math.abs(this.f26341a.bottom - this.f26341a.top);
        mapOverlayRect.setWidth(abs);
        mapOverlayRect.setHeight(abs2);
        mapOverlayRect.setName("virtual");
        mapOverlayRectArray.setitem(0, mapOverlayRect);
        mapOverlay.setRects(mapOverlayRectArray.cast());
        return mapOverlay;
    }
}
