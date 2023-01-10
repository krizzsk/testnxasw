package com.didi.hawaii.mapsdkv2.core.overlay;

import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.IGLInfoWindow;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMarker;
import com.didi.hawaii.mapsdkv2.jni.HWBSManager;
import com.didi.hawaii.mapsdkv2.jni.MapOverlay;
import com.didi.hawaii.mapsdkv2.jni.MapOverlayRect;
import com.didi.hawaii.mapsdkv2.jni.MapOverlayRectArray;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;

public final class GLMarkerInfoWindow extends GLMarker implements IGLInfoWindow {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public HWBSManager f26358a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MapOverlay f26359b;

    /* renamed from: c */
    private boolean f26360c;

    /* renamed from: d */
    private boolean f26361d = false;

    public GLMarkerInfoWindow(GLViewManager gLViewManager, GLMarker.Option option) {
        super(gLViewManager, option);
    }

    public int[] getTextureWH() {
        Texture texture = getTexture();
        if (texture == null) {
            return new int[]{0, 0};
        }
        return new int[]{texture.getBitmap().getWidth(), texture.getBitmap().getHeight()};
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        HWBSManager hWBSManager = this.f26358a;
        if (hWBSManager != null) {
            hWBSManager.addOverlay(this.f26359b);
            this.f26358a.handleCollision();
            m20817b();
            return;
        }
        super.onAdded();
    }

    public void setTexture(Texture texture) {
        if (this.f26358a == null || texture == null) {
            super.setTexture(texture);
            return;
        }
        this.texture = texture;
        set(new RenderTask() {
            public void run() {
                if (GLMarkerInfoWindow.this.m20814a()) {
                    MapOverlayRectArray mapOverlayRectArray = new MapOverlayRectArray(4);
                    MapOverlayRect mapOverlayRect = new MapOverlayRect();
                    mapOverlayRect.setAnchorX(GLMarkerInfoWindow.this.anchorX);
                    mapOverlayRect.setAnchorY(GLMarkerInfoWindow.this.anchorY);
                    mapOverlayRect.setWidth(GLMarkerInfoWindow.this.texture.getBitmap().getWidth());
                    mapOverlayRect.setHeight(GLMarkerInfoWindow.this.texture.getBitmap().getHeight());
                    mapOverlayRect.setName(GLMarkerInfoWindow.this.texture.getBitmapKey());
                    GLMarkerInfoWindow.this.f26359b.setShowInfo(GLMarkerInfoWindow.this.texture.getBitmapKey());
                    mapOverlayRectArray.setitem(0, mapOverlayRect);
                    GLMarkerInfoWindow.this.f26359b.setRects(mapOverlayRectArray.cast());
                    GLMarkerInfoWindow.this.f26358a.updateOverlay(GLMarkerInfoWindow.this.f26359b);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        if (this.f26358a != null) {
            if (this.mDisplayId != -2 && this.f26358a.removeOverlay(Long.valueOf(getId()).longValue())) {
                this.mDisplayId = -2;
            }
            this.f26358a = null;
        }
        super.onRemove();
    }

    public void setPosition(LatLng latLng) {
        if (this.f26358a == null) {
            super.setPosition(latLng);
        } else if (latLng != null && !this.center.equalLatLng(latLng)) {
            this.center.set(latLng);
            set(new RenderTask() {
                public void run() {
                    if (GLMarkerInfoWindow.this.m20814a()) {
                        GLMarkerInfoWindow.this.f26359b.setLatitude(GLMarkerInfoWindow.this.center.getLatitude());
                        GLMarkerInfoWindow.this.f26359b.setLongitude(GLMarkerInfoWindow.this.center.getLongitude());
                        GLMarkerInfoWindow.this.f26358a.updateOverlayPosition(Long.valueOf(GLMarkerInfoWindow.this.getId()).longValue(), GLMarkerInfoWindow.this.center.getLongitude(), GLMarkerInfoWindow.this.center.getLatitude());
                    }
                }
            });
        }
    }

    public void attachCollisionEngine(HWBSManager hWBSManager, MapOverlay mapOverlay) {
        this.f26358a = hWBSManager;
        this.f26359b = m20813a(mapOverlay);
        attachToFrame(true);
    }

    public void setCollisionOption(MapOverlay mapOverlay) {
        if (this.f26358a != null && mapOverlay != null) {
            this.f26359b = m20813a(mapOverlay);
            if (m20814a()) {
                this.f26358a.updateOverlay(this.f26359b);
            }
        }
    }

    public void onFrameFinish(boolean z) {
        super.onFrameFinish(z);
        m20817b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m20814a() {
        return (this.f26358a == null || this.mDisplayId == -2) ? false : true;
    }

    /* renamed from: b */
    private void m20817b() {
        HWBSManager hWBSManager = this.f26358a;
        if (hWBSManager != null && !this.f26361d) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            hWBSManager.getOverlayProperty(Long.parseLong(getId()), iArr, iArr2, new int[1]);
            boolean z = false;
            this.mDisplayId = iArr[0];
            if (iArr2[0] == 1) {
                z = true;
            }
            this.f26360c = z;
            if (this.mDisplayId > 0) {
                this.mViewManager.insertCollisionDisPlayId(this.mDisplayId, this);
                this.f26361d = true;
            }
        }
    }

    /* renamed from: a */
    private MapOverlay m20813a(MapOverlay mapOverlay) {
        MapOverlay mapOverlay2 = new MapOverlay();
        mapOverlay2.setOverlayId(Long.valueOf(getId()).longValue());
        mapOverlay2.setType(0);
        mapOverlay2.setGroupId(mapOverlay.getGroupId());
        mapOverlay2.setCollisionType(0);
        mapOverlay2.setLongitude(this.center.getLongitude());
        mapOverlay2.setLatitude(this.center.getLatitude());
        mapOverlay2.setScaleX(this.scaleX);
        mapOverlay2.setScaleY(this.scaleY);
        mapOverlay2.setFixPosX(this.fixPosX);
        mapOverlay2.setFixPosY(this.fixPosY);
        mapOverlay2.setAngle(this.angle);
        mapOverlay2.setIsClockwise(this.isClockwise);
        mapOverlay2.setIsFastLoad(this.isFastLoad);
        mapOverlay2.setIsAvoidAnno(this.isAvoidAnno);
        mapOverlay2.setIsOrthographicProject(this.isOrthographicProject);
        mapOverlay2.setZIndex(calculateTrueZIndex(this.mLayer, this.zIndex));
        mapOverlay2.setAlpha(this.alpha);
        mapOverlay2.setVisible(this.visible);
        mapOverlay2.setPriority(mapOverlay.getPriority());
        mapOverlay2.setShowInfo(this.texture.getBitmapKey());
        mapOverlay2.setRectCnt(1);
        MapOverlayRectArray mapOverlayRectArray = new MapOverlayRectArray(4);
        MapOverlayRect mapOverlayRect = new MapOverlayRect();
        mapOverlayRect.setAnchorX(this.anchorX);
        mapOverlayRect.setAnchorY(this.anchorY);
        mapOverlayRect.setWidth(this.texture.getBitmap().getWidth());
        mapOverlayRect.setHeight(this.texture.getBitmap().getHeight());
        mapOverlayRect.setName(this.texture.getBitmapKey());
        mapOverlayRectArray.setitem(0, mapOverlayRect);
        mapOverlay2.setRects(mapOverlayRectArray.cast());
        return mapOverlay2;
    }
}
