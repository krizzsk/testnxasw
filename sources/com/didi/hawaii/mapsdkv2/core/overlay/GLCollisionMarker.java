package com.didi.hawaii.mapsdkv2.core.overlay;

import android.graphics.PointF;
import com.didi.hawaii.mapsdkv2.core.AnchorTexture;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.IGLInfoWindow;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMarkerInfo;
import com.didi.hawaii.mapsdkv2.jni.DDMapPointArray;
import com.didi.hawaii.mapsdkv2.jni.HWBSManager;
import com.didi.hawaii.mapsdkv2.jni.MapEngineJNI;
import com.didi.hawaii.mapsdkv2.jni.MapOverlay;
import com.didi.hawaii.mapsdkv2.jni.MapOverlayRect;
import com.didi.hawaii.mapsdkv2.jni.MapOverlayRectArray;
import com.didi.hawaii.mapsdkv2.jni.MapPointArea;
import com.didi.hawaii.mapsdkv2.jni.MapPointSection;
import com.didi.hawaii.mapsdkv2.jni.MapPointSectionArray;
import com.didi.hawaii.mapsdkv2.jni.MapVisibleChangeAnimateAttrs;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public class GLCollisionMarker extends GLMarkerInfo {

    /* renamed from: a */
    private static final String f26328a = "GLCollisionMarker";

    /* renamed from: b */
    private static final int f26329b = -1;

    /* renamed from: c */
    private int f26330c = Option.NO_GROUP;
    protected int collisionType;

    /* renamed from: d */
    private boolean f26331d;

    /* renamed from: e */
    private int f26332e = -1;

    /* renamed from: f */
    private boolean f26333f = true;

    /* renamed from: g */
    private List<AnchorTexture> f26334g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public HWBSManager f26335h;

    /* renamed from: i */
    private float f26336i = -1.0f;

    /* renamed from: j */
    private int f26337j = -1;

    /* renamed from: k */
    private final Option.MarkerSection f26338k;

    /* renamed from: l */
    private MapVisibleChangeAnimateAttrs f26339l;

    /* renamed from: m */
    private boolean f26340m = false;
    protected int priority;
    protected int type;

    public GLCollisionMarker(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option);
        this.f26330c = option.groupId;
        this.priority = option.priority;
        this.collisionType = option.collisionType;
        this.f26338k = option.pointArea;
        this.type = option.type;
        this.f26334g = option.rects;
        this.f26339l = option.animateAttrs;
        this.f26333f = option.isInfoWindowCollied;
        if (this.f26334g.size() == 1) {
            this.anchorX = this.f26334g.get(0).anchorX;
            this.anchorY = this.f26334g.get(0).anchorY;
            this.texture = this.f26334g.get(0);
        }
    }

    public void attachCollisionEngine(HWBSManager hWBSManager) {
        this.f26335h = hWBSManager;
    }

    public int getCurShowTextureIndex() {
        return this.f26332e;
    }

    public boolean isTrueVisible() {
        return this.f26331d && this.visible;
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        if (m20800a()) {
            this.f26335h.addOverlay(m20806d());
            this.f26335h.handleCollision();
            m20805c();
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        if (m20800a()) {
            boolean removeOverlay = this.f26335h.removeOverlay(Long.valueOf(getId()).longValue());
            this.f26335h.handleCollision();
            if (removeOverlay) {
                this.mDisplayId = -2;
            }
            this.f26335h = null;
        }
        super.onRemove();
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null && !this.center.equalLatLng(latLng)) {
            this.center.set(latLng);
            this.infoWindowHolder.setPosition(latLng);
            set(new RenderTask() {
                public void run() {
                    if (GLCollisionMarker.this.m20800a()) {
                        GLCollisionMarker.this.f26335h.updateOverlayPosition(Long.valueOf(GLCollisionMarker.this.getId()).longValue(), GLCollisionMarker.this.center.getLongitude(), GLCollisionMarker.this.center.getLatitude());
                        GLCollisionMarker.this.f26335h.handleCollision();
                    }
                }
            });
        }
    }

    public void updateOption(GLMarkerInfo.Option option) {
        showInfoWindow(option.isVisible());
        setPosition(new LatLng(option.latitude, option.longitude));
        onUpdateOption(option);
    }

    public void onUpdateOption(GLOverlayView.Option option) {
        if (option instanceof Option) {
            update((Option) option);
            set(new RenderTask() {
                public void run() {
                    if (GLCollisionMarker.this.m20800a()) {
                        MapOverlay c = GLCollisionMarker.this.m20806d();
                        GLCollisionMarker.this.f26335h.updateOverlay(c);
                        if (GLCollisionMarker.this.getInfoWindowView() != null) {
                            GLCollisionMarker.this.getInfoWindowView().setCollisionOption(c);
                        }
                        GLCollisionMarker.this.f26335h.handleCollision();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void update(Option option) {
        super.update(option);
        this.f26330c = option.groupId;
        this.priority = option.priority;
        this.collisionType = option.collisionType;
        this.type = option.type;
        List<AnchorTexture> access$200 = option.rects;
        this.f26334g = access$200;
        if (access$200.size() == 1) {
            this.anchorX = this.f26334g.get(0).anchorX;
            this.anchorY = this.f26334g.get(0).anchorY;
            this.texture = this.f26334g.get(0);
        }
        this.zIndex = option.getzIndex();
        setZIndex(option.getzIndex());
    }

    public void setInfoWindowView(IGLInfoWindow iGLInfoWindow) {
        if (m20800a()) {
            if (this.f26333f) {
                iGLInfoWindow.attachCollisionEngine(this.f26335h, m20806d());
            }
            super.setInfoWindowView(iGLInfoWindow);
        }
    }

    public void setUpdateRealTime(boolean z) {
        attachToFrame(z);
    }

    public void onFrameFinish(boolean z) {
        if (m20800a()) {
            super.onFrameFinish(z);
            m20805c();
        }
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
        if (m20800a()) {
            this.f26335h.setOverlayVisible(Long.valueOf(getId()).longValue(), z);
            this.f26335h.handleCollision();
        }
    }

    public void onSetAlpha(float f) {
        if (m20800a()) {
            if (m20803b()) {
                super.onSetAlpha(f);
            } else {
                this.f26336i = f;
            }
        }
    }

    public void setZIndex(int i) {
        if (m20800a()) {
            if (m20803b()) {
                super.setZIndex(i);
            } else {
                this.f26337j = i;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m20800a() {
        return (this.f26335h == null || this.mDisplayId == -2) ? false : true;
    }

    /* renamed from: b */
    private boolean m20803b() {
        return this.mDisplayId > 0;
    }

    /* renamed from: c */
    private void m20805c() {
        if (this.mDisplayId != -2) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int[] iArr3 = new int[1];
            this.f26335h.getOverlayProperty(Long.parseLong(getId()), iArr, iArr2, iArr3);
            this.mDisplayId = iArr[0];
            this.f26331d = iArr2[0] == 1;
            this.f26332e = iArr3[0];
            this.anchorX = this.f26334g.get(iArr3[0]).anchorX;
            this.anchorY = this.f26334g.get(iArr3[0]).anchorY;
            this.texture = this.f26334g.get(iArr3[0]);
            if (!this.f26340m && this.mDisplayId > 0) {
                this.mViewManager.insertCollisionDisPlayId(this.mDisplayId, this);
                if (this.f26337j != -1) {
                    this.mMapCanvas.setZIndex(this.mDisplayId, calculateTrueZIndex(this.mLayer, this.f26337j));
                }
                if (this.f26336i != -1.0f) {
                    this.mMapCanvas.setMarkerAlpha(this.mDisplayId, this.f26336i);
                }
                this.f26340m = true;
            }
        }
    }

    public static class Option extends GLMarkerInfo.Option {
        public static int NO_GROUP = -1;
        /* access modifiers changed from: private */
        public MapVisibleChangeAnimateAttrs animateAttrs;
        protected int collisionType;
        /* access modifiers changed from: private */
        public int groupId = NO_GROUP;
        /* access modifiers changed from: private */
        public boolean isInfoWindowCollied = true;
        /* access modifiers changed from: private */
        public MarkerSection pointArea;
        protected int priority;
        /* access modifiers changed from: private */
        public List<AnchorTexture> rects;
        protected int type;

        public static class MarkerSection {
            public int[] endNums;
            public List<LatLng> points;
            public long routeID;
            public int sectionCount;
            public int[] startNums;
        }

        public void setType(int i) {
            this.type = i;
        }

        public void setCollisionType(int i) {
            this.collisionType = i;
        }

        public void setPointArea(MarkerSection markerSection) {
            this.pointArea = markerSection;
        }

        public void setPriority(int i) {
            this.priority = i;
        }

        public void setGroupId(int i) {
            this.groupId = i;
        }

        public void setInfoWindowCollied(boolean z) {
            this.isInfoWindowCollied = z;
        }

        public void setRects(List<AnchorTexture> list) {
            this.rects = list;
        }

        public void setAnimateAttrs(MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs) {
            this.animateAttrs = mapVisibleChangeAnimateAttrs;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public MapOverlay m20806d() {
        MapOverlay mapOverlay = new MapOverlay();
        mapOverlay.setOverlayId(Long.valueOf(getId()).longValue());
        mapOverlay.setType(this.type);
        mapOverlay.setGroupId(this.f26330c);
        mapOverlay.setCollisionType(this.collisionType);
        mapOverlay.setLongitude(this.center.getLongitude());
        mapOverlay.setLatitude(this.center.getLatitude());
        Option.MarkerSection markerSection = this.f26338k;
        if (!(markerSection == null || markerSection.points == null)) {
            MapPointArea mapPointArea = new MapPointArea();
            int size = this.f26338k.points.size();
            DDMapPointArray dDMapPointArray = new DDMapPointArray(size);
            for (int i = 0; i < size; i++) {
                dDMapPointArray.setitem(i, MapEngineJNI.DDMapPointForCoordinate(MapEngineJNI.DDLocationCoordinate2DMake(this.f26338k.points.get(i).longitude, this.f26338k.points.get(i).latitude)));
            }
            mapPointArea.setMapPoint(dDMapPointArray.cast());
            mapPointArea.setMapPointCount(size);
            mapPointArea.setRouteID(this.f26338k.routeID);
            MapPointSectionArray mapPointSectionArray = new MapPointSectionArray(32);
            for (int i2 = 0; i2 < this.f26338k.sectionCount; i2++) {
                MapPointSection mapPointSection = new MapPointSection();
                mapPointSection.setStartNum(this.f26338k.startNums[i2]);
                mapPointSection.setEndNum(this.f26338k.endNums[i2]);
                mapPointSectionArray.setitem(i2, mapPointSection);
            }
            mapPointArea.setSections(mapPointSectionArray.cast());
            mapPointArea.setSectionCount(this.f26338k.sectionCount);
            mapOverlay.setPointArea(mapPointArea);
        }
        mapOverlay.setScaleX(this.scaleX);
        mapOverlay.setScaleY(this.scaleY);
        mapOverlay.setFixPosX(this.fixPosX);
        mapOverlay.setFixPosY(this.fixPosY);
        mapOverlay.setAngle(this.angle);
        mapOverlay.setIsClockwise(this.isClockwise);
        mapOverlay.setIsFastLoad(this.isFastLoad);
        mapOverlay.setIsAvoidAnno(this.isAvoidAnno);
        mapOverlay.setIsOrthographicProject(this.isOrthographicProject);
        mapOverlay.setZIndex(this.zIndex);
        mapOverlay.setAlpha(this.alpha);
        mapOverlay.setVisible(this.visible);
        mapOverlay.setPriority(this.priority);
        mapOverlay.setRectCnt(this.f26334g.size());
        MapOverlayRectArray mapOverlayRectArray = new MapOverlayRectArray(4);
        String str = "" + this.f26334g.hashCode();
        int size2 = this.f26334g.size();
        for (int i3 = 0; i3 < size2; i3++) {
            AnchorTexture anchorTexture = this.f26334g.get(i3);
            MapOverlayRect mapOverlayRect = new MapOverlayRect();
            mapOverlayRect.setAnchorX(anchorTexture.anchorX);
            mapOverlayRect.setAnchorY(anchorTexture.anchorY);
            mapOverlayRect.setWidth(anchorTexture.width);
            mapOverlayRect.setHeight(anchorTexture.height);
            mapOverlayRect.setName(anchorTexture.getBitmapKey());
            mapOverlayRectArray.setitem(i3, mapOverlayRect);
            str = str + "|" + anchorTexture.getBitmapKey();
        }
        mapOverlay.setRects(mapOverlayRectArray.cast());
        mapOverlay.setShowInfo(f26328a + str);
        MapVisibleChangeAnimateAttrs mapVisibleChangeAnimateAttrs = this.f26339l;
        if (mapVisibleChangeAnimateAttrs != null) {
            mapOverlay.setVisibleChangeAnimateAttrs(mapVisibleChangeAnimateAttrs);
        }
        return mapOverlay;
    }

    public void setOffset(PointF pointF) {
        m20799a("setOffset");
    }

    public void setAnchor(float f, float f2) {
        m20799a("setAnchor");
    }

    public void setTexture(Texture texture) {
        m20799a("setTexture");
    }

    public void setGroundIcon(LatLngBounds latLngBounds, Texture texture) {
        m20799a("setGroundIcon");
    }

    /* renamed from: a */
    private void m20799a(String str) {
        SystemUtils.log(6, "mapsdk", "CollisionMarker can not support " + str + " when the inner marker in collision", (Throwable) null, "com.didi.hawaii.mapsdkv2.core.overlay.GLCollisionMarker", 433);
    }

    private static final class UnSupportMethodException extends RuntimeException {
        public UnSupportMethodException(String str) {
            super(str);
        }
    }
}
