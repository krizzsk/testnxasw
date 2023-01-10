package com.didi.hawaii.mapsdkv2.core.overlay;

import android.text.TextUtils;
import com.didi.hawaii.mapsdkv2.core.GLOverlayLayer;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.MapPack;
import com.didi.hawaii.mapsdkv2.core.RouteName;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.jni.HWBSRAManager;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.outer.model.LatLng;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.concurrent.Callable;

@GLViewDebug.ExportClass(name = "Route")
public class GLRoute extends GLOverlayView {
    public static final int ARROW_TYPE_CIRCLE = 5;
    public static final int ARROW_TYPE_LEFT = 2;
    public static final int ARROW_TYPE_RIGHT = 3;
    public static final int ARROW_TYPE_STRAIGHT = 1;
    public static final int ARROW_TYPE_TURNAROUND = 4;
    public static final int TYPE_COLOR_LINE = 0;
    public static final int TYPE_LINE_ANIMATION = 5;
    public static final int TYPE_REPEAT_TEXTURE = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final LatLng[] f26375a;
    @GLViewDebug.ExportField(name = "points")

    /* renamed from: b */
    private LatLng[] f26376b;
    @GLViewDebug.ExportField(name = "width")

    /* renamed from: c */
    private float f26377c;

    /* renamed from: d */
    private boolean f26378d;

    /* renamed from: e */
    private String f26379e;

    /* renamed from: f */
    private boolean f26380f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f26381g = false;

    /* renamed from: h */
    private int f26382h;

    /* renamed from: i */
    private int f26383i;

    /* renamed from: j */
    private final int f26384j;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "texture")

    /* renamed from: k */
    public Texture f26385k;
    @GLViewDebug.ExportField(name = "colors")

    /* renamed from: l */
    private int[] f26386l;
    @GLViewDebug.ExportField(name = "color_indexes")

    /* renamed from: m */
    private int[] f26387m;

    /* renamed from: n */
    private final TurnArrow f26388n;
    @GLViewDebug.ExportField(name = "route_names")

    /* renamed from: o */
    private RouteName[] f26389o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public long f26390p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f26391q;

    /* renamed from: r */
    private boolean f26392r = false;

    /* renamed from: s */
    private boolean f26393s = false;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public HWBSRAManager f26394t = null;

    /* renamed from: u */
    private LatLng f26395u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public LatLng f26396v = new LatLng(0.0d, 0.0d);

    @Retention(RetentionPolicy.SOURCE)
    public @interface ArrowType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    /* renamed from: a */
    private static void m20878a(int[] iArr, int[] iArr2, LatLng[] latLngArr, Texture texture) {
    }

    public void setZIndex(int i) {
    }

    public GLRoute(GLViewManager gLViewManager, Option option) {
        super(gLViewManager, option, GLOverlayLayer.ROUTE, false);
        this.f26376b = option.pts;
        if (option.originPts != null) {
            this.f26375a = (LatLng[]) Arrays.copyOf(option.originPts, option.originPts.length);
        } else {
            this.f26375a = (LatLng[]) Arrays.copyOf(option.pts, option.pts.length);
        }
        this.f26377c = option.width;
        this.f26392r = option.animateEnable;
        this.f26393s = option.isCollision;
        this.f26378d = option.showArrow;
        this.f26379e = option.arrowTextureName;
        this.f26380f = option.drawCap;
        this.f26381g = option.erase;
        this.f26384j = option.lineType;
        this.f26388n = option.turnArrow;
        this.f26382h = -1;
        this.f26390p = option.routeNameKey;
        this.f26389o = option.routeNames;
        this.f26391q = option.isMainRoute;
        m20877a(option.texture, option.segIndexes, option.segColors, true);
    }

    public void setRouteNameKey(final long j) {
        if (this.f26390p != j) {
            this.f26390p = j;
            set(new RenderTask() {
                public void run() {
                    GLRoute.this.mMapCanvas.setRouteNameKey(GLRoute.this.mDisplayId, j, GLRoute.this.f26391q);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onSetVisible(boolean z) {
        this.mMapCanvas.setRouteVisible(this.mDisplayId, z);
    }

    /* access modifiers changed from: protected */
    public void onSetAlpha(float f) {
        RouteName[] routeNameArr;
        this.mMapCanvas.setRouteAlpha(this.mDisplayId, f);
        if (this.f26390p != 0 && f > 0.0f && (routeNameArr = this.f26389o) != null && routeNameArr.length > 0) {
            this.mMapCanvas.addRouteNames(this.mDisplayId, this.f26390p, this.f26389o, this.f26375a, this.f26391q);
        }
        if (this.f26390p != 0 && f <= 0.0f) {
            this.mMapCanvas.clearRouteNames(this.f26390p);
        }
        this.alpha = f;
    }

    public void setWidth(final float f) {
        if (this.f26377c != f) {
            this.f26377c = f;
            set(new RenderTask() {
                public void run() {
                    GLRoute.this.mMapCanvas.setRouteWidth(GLRoute.this.mDisplayId, f);
                }
            });
        }
    }

    public float getWidth() {
        return this.f26377c;
    }

    public void setDrawCap(final boolean z) {
        if (this.f26380f != z) {
            this.f26380f = z;
            set(new RenderTask() {
                public void run() {
                    GLRoute.this.mMapCanvas.setRouteDrawCap(GLRoute.this.mDisplayId, z);
                }
            });
        }
    }

    public boolean isDrawCap() {
        return this.f26380f;
    }

    public void setTexture(final Texture texture) {
        this.f26385k = texture;
        set(new RenderTask() {
            public void run() {
                GLRoute.this.mMapCanvas.setRouteTexture(GLRoute.this.mDisplayId, texture.getBitmapKey());
            }
        });
    }

    public void setPercent(final float f) {
        if (this.f26394t != null) {
            set(new RenderTask() {
                public void run() {
                    if (GLRoute.this.alpha < 1.0f) {
                        GLRoute.this.mMapCanvas.setRouteAlpha(GLRoute.this.mDisplayId, 1.0f);
                        float unused = GLRoute.this.alpha = 1.0f;
                    }
                    float f = 1.0f - f;
                    if (f <= 0.0f) {
                        f = 0.0f;
                    }
                    GLRoute.this.mMapCanvas.setRoutePercent(GLRoute.this.mDisplayId, GLRoute.this.f26385k.getBitmapKey(), f, GLRoute.this.f26394t);
                }
            });
        }
    }

    public void setPulsePercent(final float f) {
        set(new RenderTask() {
            public void run() {
                GLRoute.this.mMapCanvas.setRoutePercent(GLRoute.this.mDisplayId, f);
            }
        });
    }

    public void setPulseCustomColor(final int i) {
        set(new RenderTask() {
            public void run() {
                GLRoute.this.mMapCanvas.setRoutePulseCustomColor(GLRoute.this.mDisplayId, i);
            }
        });
    }

    public void setPulseTexture(final Texture texture) {
        set(new RenderTask() {
            public void run() {
                GLRoute.this.mMapCanvas.setRoutePulseTexture(GLRoute.this.mDisplayId, texture.getBitmapKey());
            }
        });
    }

    public void setPts(LatLng[] latLngArr, int[] iArr, int[] iArr2) {
        setPts(latLngArr, iArr, iArr2, this.f26385k);
    }

    public void setPts(LatLng[] latLngArr, int[] iArr, int[] iArr2, Texture texture) {
        m20877a(texture, iArr, iArr2, false);
        this.f26376b = latLngArr;
        final LatLng[] latLngArr2 = latLngArr;
        final int[] iArr3 = iArr2;
        final int[] iArr4 = iArr;
        final Texture texture2 = texture;
        set(new RenderTask() {
            public void run() {
                GLRoute.this.mMapCanvas.setRoutePoints(GLRoute.this.mDisplayId, latLngArr2, iArr3, iArr4, texture2.getBitmapKey());
            }
        });
    }

    public LatLng[] getPts() {
        return this.f26376b;
    }

    public LatLng[] getOriginPts() {
        return this.f26375a;
    }

    public void setArrow(final boolean z) {
        if (this.f26378d != z) {
            this.f26378d = z;
            set(new RenderTask() {
                public void run() {
                    GLRoute.this.mMapCanvas.setRouteArrow(GLRoute.this.mDisplayId, z);
                }
            });
        }
    }

    public boolean hasArrow() {
        return this.f26378d;
    }

    public void setClearPoints(final int i, int i2, final LatLng latLng) {
        if (latLng != null) {
            this.f26382h = i;
            this.f26383i = i2;
            this.f26395u = latLng;
            this.f26396v.longitude = latLng.longitude;
            this.f26396v.latitude = latLng.latitude;
            set(new RenderTask() {
                public void run() {
                    if (GLRoute.this.f26381g) {
                        GLRoute.this.mMapCanvas.setRouteClearPointErase(GLRoute.this.mDisplayId, i, latLng, GLRoute.this.f26390p, GLRoute.this.f26391q);
                    } else {
                        GLRoute.this.mMapCanvas.setRouteClearPointGrey(GLRoute.this.mDisplayId, i, latLng, GLRoute.this.f26390p, GLRoute.this.f26391q);
                    }
                    GLRoute.this.mMapCanvas.getMapRouteTrueClearPoint_Wrap(GLRoute.this.mDisplayId, GLRoute.this.f26396v);
                }
            });
        }
    }

    public int getClearIndex() {
        return this.f26382h;
    }

    public void setEraseWhenClear(boolean z) {
        this.f26381g = z;
        LatLng latLng = this.f26395u;
        if (latLng != null) {
            setClearPoints(this.f26382h, this.f26383i, latLng);
        }
    }

    public boolean isEraseWhenClear() {
        return this.f26381g;
    }

    public void addTurnArrow(final int i, final int i2, final int i3) {
        int unused = this.f26388n.pointIndex = i;
        int unused2 = this.f26388n.actionLength = i2;
        int unused3 = this.f26388n.maxActionLength = i2;
        int unused4 = this.f26388n.arrowType = i3;
        set(new RenderTask() {
            public void run() {
                GLRoute.this.mMapCanvas.setRouteTurnArrow(GLRoute.this.mDisplayId, i, i2, i3);
            }
        });
    }

    public void addTurnArrow(int i, int i2, int i3, int i4) {
        int unused = this.f26388n.pointIndex = i;
        int unused2 = this.f26388n.actionLength = i2;
        final int i5 = i3 < i2 ? i2 : i3;
        int unused3 = this.f26388n.maxActionLength = i5;
        int unused4 = this.f26388n.arrowType = i4;
        final int i6 = i;
        final int i7 = i2;
        final int i8 = i4;
        set(new RenderTask() {
            public void run() {
                GLRoute.this.mMapCanvas.setRouteTurnArrow(GLRoute.this.mDisplayId, i6, i7, i5, i8);
            }
        });
    }

    public void clearTurnArrow() {
        addTurnArrow(-1, 0, 1);
    }

    public void setColors(int[] iArr, int[] iArr2) {
        setPts(this.f26376b, iArr, iArr2);
    }

    public int[] getColorIndexes() {
        return this.f26387m;
    }

    public int[] getColors() {
        return this.f26386l;
    }

    public void setRoadNames(final RouteName[] routeNameArr, final long j) {
        this.f26390p = j;
        if (routeNameArr.length > 0) {
            this.f26389o = routeNameArr;
            set(new RenderTask() {
                public void run() {
                    RouteName[] routeNameArr;
                    if (j != 0 && GLRoute.this.alpha > 0.0f && (routeNameArr = routeNameArr) != null && routeNameArr.length > 0) {
                        GLRoute.this.mMapCanvas.addRouteNames(GLRoute.this.mDisplayId, j, routeNameArr, GLRoute.this.f26375a, GLRoute.this.f26391q);
                    }
                }
            });
        }
    }

    public RouteName[] getRouteNames() {
        return this.f26389o;
    }

    public LatLng getTrueClearPoint() {
        return this.f26396v;
    }

    public void clearRoadNames() {
        this.f26389o = null;
        set(new RenderTask() {
            public void run() {
                GLRoute.this.mMapCanvas.clearRouteNames(GLRoute.this.f26390p);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onUpdateOption(GLOverlayView.Option option) {
        super.onUpdateOption(option);
        if (option instanceof Option) {
            Option option2 = (Option) option;
            setArrow(option2.showArrow);
            setWidth(option2.width);
            setDrawCap(option2.drawCap);
            int[] access$1600 = option2.segColors;
            int[] access$1500 = option2.segIndexes;
            Texture access$1400 = option2.texture;
            LatLng[] access$000 = option2.pts;
            if (access$1600 == null || access$1500 == null || access$1400 == null) {
                int[] iArr = {0};
                int[] iArr2 = {0, option2.pts.length - 1};
                m20878a(iArr, iArr2, option2.pts, this.f26385k);
                setPts(access$000, iArr2, iArr);
                return;
            }
            m20878a(access$1600, access$1500, option2.pts, access$1400);
            setPts(access$000, access$1500, access$1600, access$1400);
        }
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        RouteName[] routeNameArr;
        super.onAdded();
        if (this.f26392r) {
            this.f26394t = new HWBSRAManager();
        }
        this.mDisplayId = this.mMapCanvas.addRoute(this.f26376b, this.f26386l, this.f26387m, this.f26385k.getBitmapKey(), this.f26377c, calculateTrueZIndex(this.mLayer, this.zIndex), this.alpha, this.f26378d, this.f26380f, this.f26384j, this.f26390p, this.f26391q, this.f26394t, this.f26393s);
        if (this.f26390p != 0 && this.alpha > 0.0f && (routeNameArr = this.f26389o) != null && routeNameArr.length > 0) {
            this.mMapCanvas.addRouteNames(this.mDisplayId, this.f26390p, this.f26389o, this.f26375a, this.f26391q);
        }
        if (!TextUtils.isEmpty(this.f26379e)) {
            this.mMapCanvas.setPolylineArrowTextureName(this.mDisplayId, this.f26379e);
        }
        if (this.f26388n.pointIndex != -1) {
            this.mMapCanvas.setRouteTurnArrow(this.mDisplayId, this.f26388n.pointIndex, this.f26388n.actionLength, this.f26388n.arrowType);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        if (this.f26390p != 0) {
            this.mMapCanvas.clearRouteNames(this.f26390p);
        }
        int i = this.mDisplayId;
        this.mDisplayId = -2;
        this.mMapCanvas.removeRoute(i);
    }

    public void addViolationParkingSection(int i, int i2, float f, int i3, float f2) {
        final int i4 = i;
        final int i5 = i2;
        final float f3 = f;
        final int i6 = i3;
        final float f4 = f2;
        set(new RenderTask() {
            public void run() {
                GLRoute.this.mMapCanvas.addViolationParkingSection(GLRoute.this.mDisplayId, i4, i5, f3, i6, f4);
            }
        });
    }

    public LatLng queryViolationParkingIconPosition(final int i, final int i2, final LatLng latLng) {
        return (LatLng) futureGet(getParent().postToRenderThread(new Callable<LatLng>() {
            public LatLng call() {
                return GLRoute.this.mMapCanvas.queryViolationParkingIconPosition(GLRoute.this.mDisplayId, i, i2, latLng);
            }
        }));
    }

    public void flashViolationParkingSection(final int i, final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLRoute.this.mMapCanvas.flashViolationParkingSection(GLRoute.this.mDisplayId, i, z);
            }
        });
    }

    public void removeViolationParkingSection(final int i) {
        set(new RenderTask() {
            public void run() {
                GLRoute.this.mMapCanvas.removeViolationParkingSection(GLRoute.this.mDisplayId, i);
            }
        });
    }

    public static final class Option extends GLOverlayView.Option {
        /* access modifiers changed from: private */
        public boolean animateEnable = false;
        /* access modifiers changed from: private */
        public String arrowTextureName;
        /* access modifiers changed from: private */
        public boolean drawCap = true;
        /* access modifiers changed from: private */
        public boolean erase = false;
        /* access modifiers changed from: private */
        public boolean isCollision = false;
        /* access modifiers changed from: private */
        public boolean isMainRoute;
        /* access modifiers changed from: private */
        public int lineType;
        /* access modifiers changed from: private */
        public LatLng[] originPts;
        /* access modifiers changed from: private */
        public LatLng[] pts = new LatLng[0];
        /* access modifiers changed from: private */
        public long routeNameKey;
        /* access modifiers changed from: private */
        public RouteName[] routeNames;
        /* access modifiers changed from: private */
        public int[] segColors;
        /* access modifiers changed from: private */
        public int[] segIndexes;
        /* access modifiers changed from: private */
        public boolean showArrow;
        /* access modifiers changed from: private */
        public Texture texture;
        /* access modifiers changed from: private */
        public final TurnArrow turnArrow = new TurnArrow();
        /* access modifiers changed from: private */
        public float width;

        public void setPts(LatLng[] latLngArr) {
            this.pts = latLngArr;
        }

        public void setOriginPts(LatLng[] latLngArr) {
            this.originPts = latLngArr;
        }

        public void setAnimateEnable(boolean z) {
            this.animateEnable = z;
        }

        public void setCollisionEnable(boolean z) {
            this.isCollision = z;
        }

        public void setWidth(float f) {
            this.width = f;
        }

        public void setShowArrow(boolean z) {
            this.showArrow = z;
        }

        public void setArrowTextureName(String str) {
            this.arrowTextureName = str;
        }

        public void setDrawCap(boolean z) {
            this.drawCap = z;
        }

        public void setErase(boolean z) {
            this.erase = z;
        }

        public void setTexture(int[] iArr, int[] iArr2, Texture texture2) {
            this.texture = texture2;
            this.segColors = iArr2;
            this.segIndexes = iArr;
        }

        public void setLineType(int i) {
            this.lineType = i;
        }

        public void setRouteNames(RouteName[] routeNameArr) {
            this.routeNames = routeNameArr;
        }

        public void setRouteNameKey(long j) {
            this.routeNameKey = j;
        }

        public void setIsMainRoute(boolean z) {
            this.isMainRoute = z;
        }
    }

    private static class TurnArrow {
        /* access modifiers changed from: private */
        public int actionLength;
        /* access modifiers changed from: private */
        public int arrowType;
        /* access modifiers changed from: private */
        public int maxActionLength;
        /* access modifiers changed from: private */
        public int pointIndex;

        private TurnArrow() {
            this.pointIndex = -1;
        }
    }

    /* renamed from: a */
    private void m20877a(Texture texture, int[] iArr, int[] iArr2, boolean z) {
        if (texture == null || iArr == null || iArr2 == null) {
            this.f26386l = new int[]{0};
            this.f26387m = new int[]{0, this.f26376b.length - 1};
            this.f26385k = MapPack.POLYLINE_RAINBOW_TEXTURE;
            return;
        }
        m20878a(iArr2, iArr, this.f26376b, this.f26385k);
        if (z) {
            this.f26387m = Arrays.copyOf(iArr, iArr.length);
            this.f26386l = Arrays.copyOf(iArr2, iArr2.length);
        } else {
            this.f26387m = iArr;
            this.f26386l = iArr2;
        }
        this.f26385k = texture;
    }
}
