package com.didi.hawaii.mapsdkv2.core;

import android.animation.FloatEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.location.Location;
import android.view.animation.LinearInterpolator;
import com.didi.hawaii.mapsdkv2.common.MapTransform;
import com.didi.hawaii.mapsdkv2.common.Tranform2Piex20Utils;
import com.didi.hawaii.mapsdkv2.common.evaluator.AngleEvaluator;
import com.didi.hawaii.mapsdkv2.common.evaluator.CameraEvaluator;
import com.didi.hawaii.mapsdkv2.common.evaluator.LatLngEvaluator;
import com.didi.hawaii.mapsdkv2.core.GLViewDebug;
import com.didi.hawaii.mapsdkv2.core.IGLInfoWindow;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.blocks.BlocksConst;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GLViewDebug.ExportClass(name = "Locator")
public class GLLocator extends GLView implements IGLInfoWindow.Host {

    /* renamed from: w */
    private static final long f26154w = 1000;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final GLBaseMapView f26155a;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "position")

    /* renamed from: b */
    public final LatLng f26156b = new LatLng(0.0d, 0.0d);

    /* renamed from: c */
    private Texture f26157c;

    /* renamed from: d */
    private Texture f26158d;

    /* renamed from: e */
    private Texture f26159e;

    /* renamed from: f */
    private Texture f26160f;

    /* renamed from: g */
    private Texture f26161g;

    /* renamed from: h */
    private Texture f26162h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f26163i;
    @GLViewDebug.ExportField(name = "visible")

    /* renamed from: j */
    private boolean f26164j = false;

    /* renamed from: k */
    private boolean f26165k = false;

    /* renamed from: l */
    private boolean f26166l = false;

    /* renamed from: m */
    private boolean f26167m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f26168n;
    @GLViewDebug.ExportField(name = "navigation_mode")

    /* renamed from: o */
    private int f26169o;
    /* access modifiers changed from: private */
    @GLViewDebug.ExportField(name = "heading")

    /* renamed from: p */
    public float f26170p;

    /* renamed from: q */
    private int f26171q;

    /* renamed from: r */
    private MapEngine f26172r;

    /* renamed from: s */
    private OnNaviModeChangeListener f26173s;

    /* renamed from: t */
    private final IGLInfoWindow.Holder f26174t;

    /* renamed from: u */
    private final RectF f26175u = new RectF();
    /* access modifiers changed from: private */

    /* renamed from: v */
    public final float[] f26176v = new float[4];

    public interface OnNaviModeChangeListener {
        void onChange(int i);
    }

    public RectF getInfoWindowScreenRect() {
        return null;
    }

    public void removeInfoWindow() {
    }

    GLLocator(GLViewManager gLViewManager, MapEngine mapEngine) {
        super(gLViewManager, GLOverlayLayer.LOCATOR);
        this.f26155a = gLViewManager.getBaseMap();
        this.f26172r = mapEngine;
        this.f26174t = new IGLInfoWindow.Holder(gLViewManager, this);
    }

    /* access modifiers changed from: protected */
    public void onAdded() {
        this.mMapCanvas.setLocatorCarVisible(this.f26165k);
        this.mMapCanvas.setLocatorCompassVisible(this.f26165k);
        this.mMapCanvas.setLocatorAccuracyVisible(this.f26165k);
        if (!(this.f26158d == null || this.f26159e == null || this.f26160f == null || this.f26161g == null || this.f26162h == null)) {
            this.mMapCanvas.setLocatorCompassImage(this.f26158d.getBitmapKey(), this.f26159e.getBitmapKey(), this.f26160f.getBitmapKey(), this.f26161g.getBitmapKey(), this.f26162h.getBitmapKey(), 0.5f, 0.5f);
        }
        if (this.f26157c != null) {
            this.mMapCanvas.setLocatorCarImage(this.f26157c.getBitmapKey(), 0.5f, 0.5f);
        }
        this.mMapCanvas.setLocatorInfo(this.f26156b, this.f26170p, this.f26155a.getCamera().getRotate(), this.f26163i, false, false);
        this.f26168n = this.mMapCanvas.getLocatorId();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        this.f26167m = false;
        this.f26166l = false;
        this.f26165k = false;
        this.mMapCanvas.setLocatorCarVisible(false);
        this.mMapCanvas.setLocatorCompassVisible(false);
        this.mMapCanvas.setLocatorAccuracyVisible(false);
        this.f26168n = -1;
    }

    public void setCarVisible(final boolean z) {
        if (this.f26165k != z) {
            this.f26165k = z;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorCarVisible(z);
                }
            });
        }
    }

    public void setCompassVisible(final boolean z) {
        if (this.f26166l != z) {
            this.f26166l = z;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorCompassVisible(z);
                }
            });
        }
    }

    public void setAccuracyVisible(final boolean z) {
        if (this.f26167m != z) {
            this.f26167m = z;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorAccuracyVisible(z);
                }
            });
        }
    }

    public boolean isCarVisible() {
        return this.f26165k;
    }

    public boolean isCompassVisible() {
        return this.f26166l;
    }

    public boolean isAccuracyVisible() {
        return this.f26167m;
    }

    public void setVisible(final boolean z) {
        if (this.f26164j != z) {
            this.f26164j = z;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorVisible(z);
                }
            });
        }
    }

    public boolean isVisible() {
        return this.f26164j;
    }

    public void setAccuracy(final float f) {
        if (this.f26163i != f) {
            this.f26163i = f;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorInfo(GLLocator.this.f26156b, GLLocator.this.f26170p, GLLocator.this.f26155a.getCamera().getRotate(), f, false, false);
                }
            });
        }
    }

    public void setGuideLineDestination(final LatLng latLng) {
        set(new RenderTask() {
            public void run() {
                GLLocator.this.mMapCanvas.setLocatorDestination(latLng);
                GLLocator.this.mMapCanvas.setLocatorInfo(GLLocator.this.f26156b, GLLocator.this.f26170p, GLLocator.this.f26155a.getCamera().getRotate(), GLLocator.this.f26163i, false, false);
            }
        });
    }

    public void showGuideLine(final boolean z) {
        set(new RenderTask() {
            public void run() {
                GLLocator.this.mMapCanvas.showLocatorGuideLine(z, GLLocator.this.f26156b);
            }
        });
    }

    public void setZIndex(int i) {
        if (this.f26171q != i) {
            this.f26171q = i;
            final int zIndexStart = GLOverlayLayer.getZIndexStart(GLOverlayLayer.OVERLAY) + i;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorZIndex(zIndexStart);
                }
            });
        }
    }

    public LatLng getPosition() {
        return new LatLng(this.f26156b);
    }

    public boolean isInfoWindowShow() {
        return this.f26174t.isShow();
    }

    public LatLngBounds getInfoWindowGeoBound() {
        return this.f26174t.getInfoWindowGeoBound();
    }

    public float getAngle() {
        return this.f26170p;
    }

    public void setPositionAndAngle(LatLng latLng, float f) {
        setPositionAndAngle(latLng, f, this.f26155a.f26140e.getRotate());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20669a(LatLng latLng, float f, float f2, float f3, float f4) {
        LatLng latLng2 = latLng;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        if (Float.isNaN(f3)) {
            SystemUtils.log(5, "GLLocator", "setPositionAngleSkewScale: mapScale is NaN", (Throwable) null, "com.didi.hawaii.mapsdkv2.core.GLLocator", 295);
        } else if (f7 <= this.f26155a.f26142g && f7 >= this.f26155a.f26143h && f8 <= 35.0f && f8 >= 0.0f) {
            Camera camera = this.f26155a.f26140e;
            if (this.f26170p != f5 || !this.f26156b.equals(latLng) || camera.getRotate() != f6 || camera.getScale() != f7 || camera.getSkew() != f8) {
                this.f26156b.longitude = latLng2.longitude;
                this.f26156b.latitude = latLng2.latitude;
                this.f26170p = f5;
                boolean isCarFollowMode = isCarFollowMode();
                final boolean isCarUpAndFollowMode = isCarUpAndFollowMode();
                boolean z = isCarFollowMode || isCarUpAndFollowMode;
                if (z) {
                    this.f26155a.f26140e.setCenter(latLng);
                }
                if (isCarUpAndFollowMode) {
                    this.f26155a.f26140e.setRotate(f2);
                }
                this.f26155a.f26140e.setScale(f7);
                this.f26155a.f26140e.setSkew(f8);
                final LatLng latLng3 = latLng;
                final float f9 = f;
                final float f10 = f2;
                final float f11 = f3;
                final float f12 = f4;
                final boolean z2 = z;
                set(new RenderTask() {
                    public void run() {
                        GLLocator.this.mMapCanvas.setLocatorInfoWithSkewAndScale(latLng3, f9, f10, GLLocator.this.f26163i, f11, f12, z2, isCarUpAndFollowMode);
                    }
                });
                if (z) {
                    this.f26155a.mo75585f();
                }
            }
        }
    }

    public void setPositionAndAngle(LatLng latLng, float f, float f2) {
        if (this.f26170p != f || !this.f26156b.equals(latLng) || this.f26155a.f26140e.getRotate() != f2) {
            this.f26156b.longitude = latLng.longitude;
            this.f26156b.latitude = latLng.latitude;
            this.f26170p = f;
            boolean isCarFollowMode = isCarFollowMode();
            final boolean isCarUpAndFollowMode = isCarUpAndFollowMode();
            boolean z = isCarFollowMode || isCarUpAndFollowMode;
            if (z) {
                this.f26155a.f26140e.setCenter(latLng);
            }
            if (isCarUpAndFollowMode) {
                this.f26155a.f26140e.setRotate(f2);
            }
            final LatLng latLng2 = latLng;
            final float f3 = f;
            final float f4 = f2;
            final boolean z2 = z;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorInfo(latLng2, f3, f4, GLLocator.this.f26163i, z2, isCarUpAndFollowMode);
                }
            });
            if (z) {
                this.f26155a.mo75585f();
            }
        }
    }

    public void setNaviMode(int i) {
        if (this.f26169o != i) {
            stopAnimation();
            this.f26169o = i;
            m20667a(i);
            OnNaviModeChangeListener onNaviModeChangeListener = this.f26173s;
            if (onNaviModeChangeListener != null) {
                onNaviModeChangeListener.onChange(i);
            }
        }
    }

    /* renamed from: a */
    private void m20667a(int i) {
        attachToFrame(true);
    }

    public boolean isCarFollowMode() {
        return (this.f26169o & 2) != 0;
    }

    public boolean isCarUpAndFollowMode() {
        return (this.f26169o & 1) != 0;
    }

    public int getNaviMode() {
        return this.f26169o;
    }

    public void setCarTexture(final Texture texture) {
        if (!texture.equals(this.f26157c)) {
            this.f26157c = texture;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorCarImage(texture.getBitmapKey(), 0.5f, 0.5f);
                }
            });
        }
    }

    public RectF getPiexBound(float f) {
        DoublePoint latlng2PixelStandardScaleLevel = Tranform2Piex20Utils.latlng2PixelStandardScaleLevel(getPosition(), (DoublePoint) null);
        Bitmap bitmap = this.f26157c.getBitmap();
        RectF rectF = new RectF();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = ((float) latlng2PixelStandardScaleLevel.f27004x) * f;
        float f3 = ((float) latlng2PixelStandardScaleLevel.f27005y) * f;
        rectF.left = f2;
        float f4 = (float) width;
        rectF.right = f2 + f4;
        float f5 = (float) height;
        rectF.top = f3 - f5;
        rectF.bottom = f3;
        float f6 = (float) ((int) (f4 * 0.5f));
        rectF.left -= f6;
        rectF.right -= f6;
        float f7 = (float) ((int) (f5 * 0.5f));
        rectF.top += f7;
        rectF.bottom += f7;
        return rectF;
    }

    public void setCompassTexture(Texture texture, Texture texture2, Texture texture3, Texture texture4, Texture texture5) {
        if (!texture.equals(this.f26158d)) {
            this.f26158d = texture;
            this.f26159e = texture2;
            this.f26160f = texture3;
            this.f26161g = texture4;
            this.f26162h = texture5;
            final Texture texture6 = texture;
            final Texture texture7 = texture2;
            final Texture texture8 = texture3;
            final Texture texture9 = texture4;
            final Texture texture10 = texture5;
            set(new RenderTask() {
                public void run() {
                    GLLocator.this.mMapCanvas.setLocatorCompassImage(texture6.getBitmapKey(), texture7.getBitmapKey(), texture8.getBitmapKey(), texture9.getBitmapKey(), texture10.getBitmapKey(), 0.5f, 0.5f);
                }
            });
        }
    }

    public void setOnNaviModeChangeListener(OnNaviModeChangeListener onNaviModeChangeListener) {
        this.f26173s = onNaviModeChangeListener;
    }

    public LatLngBounds getGeoBound() {
        Future future = get(new Callable<LatLngBounds>() {
            public LatLngBounds call() {
                return GLLocator.this.mMapCanvas.calculateLocatorGeoBound(GLLocator.this.f26168n);
            }
        });
        if (future == null) {
            return null;
        }
        try {
            return (LatLngBounds) future.get(800, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        } catch (TimeoutException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public RectF getScreenBound() {
        if (isAddToFrameCallback()) {
            return this.f26175u;
        }
        Future future = get(new Callable<RectF>() {
            public RectF call() {
                GLLocator.this.mMapCanvas.calculateLocatorScreenBound(GLLocator.this.f26168n, GLLocator.this.f26176v);
                return new RectF(GLLocator.this.f26176v[0], GLLocator.this.f26176v[1], GLLocator.this.f26176v[2], GLLocator.this.f26176v[3]);
            }
        });
        if (future == null) {
            return null;
        }
        try {
            return (RectF) future.get(800, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        } catch (TimeoutException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void onFrameFinish(boolean z) {
        this.mMapCanvas.calculateLocatorScreenBound(this.f26168n, this.f26176v);
        synchronized (this.f26175u) {
            this.f26175u.set(this.f26176v[0], this.f26176v[1], this.f26176v[2], this.f26176v[3]);
        }
    }

    public void showInfoWindow(boolean z) {
        this.f26174t.show(z);
    }

    public IGLInfoWindow getInfoWindowView() {
        return this.f26174t.get();
    }

    public void setInfoWindowView(IGLInfoWindow iGLInfoWindow) {
        this.f26174t.set(iGLInfoWindow);
    }

    public boolean navigateToPosition(boolean z, LatLng latLng, float f, float f2, int i, int i2, boolean z2, long j, long j2) {
        if (z2) {
            this.mViewManager.setFps(1);
        }
        stopAnimation();
        return m20670a(latLng, f, i, i2, j, j2, z2);
    }

    /* renamed from: a */
    private boolean m20670a(LatLng latLng, float f, int i, int i2, long j, long j2, boolean z) {
        LatLng latLng2 = latLng;
        float f2 = f;
        if (z) {
            this.f26156b.latitude = latLng2.latitude;
            this.f26156b.longitude = latLng2.longitude;
            this.f26170p = f2;
            this.f26155a.f26140e.setCenter(latLng);
            this.f26155a.f26140e.setRotate(-f2);
        }
        final LatLng latLng3 = latLng;
        final int i3 = i;
        final int i4 = i2;
        final long j3 = j;
        final long j4 = j2;
        Future future = get(new Callable<Boolean>() {
            public Boolean call() {
                return Boolean.valueOf(GLLocator.this.mMapCanvas.setMJOLocatorInfo(latLng3, i3, i4, j3, j4));
            }
        });
        if (future == null) {
            return false;
        }
        try {
            return ((Boolean) future.get(500, TimeUnit.MILLISECONDS)).booleanValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return false;
        } catch (TimeoutException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public void navigateToPosition(boolean z, LatLng latLng, float f) {
        if (z) {
            PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject("locator", new LatLngEvaluator(), new Object[]{getPosition(), latLng});
            PropertyValuesHolder ofObject2 = PropertyValuesHolder.ofObject(BlocksConst.WIDGET_PARAMS_ANGLE, AngleEvaluator.INSTANCE, new Object[]{Float.valueOf(this.f26170p), Float.valueOf(f)});
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.mo75552a(this.mViewManager.getFps());
            gLAnimator.setValues(new PropertyValuesHolder[]{ofObject, ofObject2});
            gLAnimator.setDuration(1000);
            gLAnimator.setInterpolator(new LinearInterpolator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue(BlocksConst.WIDGET_PARAMS_ANGLE)).floatValue();
                    GLLocator.this.setPositionAndAngle((LatLng) valueAnimator.getAnimatedValue("locator"), floatValue);
                }
            });
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        stopAnimation();
        setPositionAndAngle(latLng, f);
    }

    public void navigateToPosition(boolean z, LatLng latLng, float f, float f2, float f3, float f4) {
        float normalizeRotate = MapTransform.normalizeRotate(-f2);
        if (z) {
            m20666a(f4, normalizeRotate);
            Camera camera = new Camera(this.f26155a.getCenter(), f4, this.f26155a.getRotate(), f3);
            Camera camera2 = this.f26155a.getCamera();
            PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject("camera", new CameraEvaluator(true), new Object[]{camera2, camera});
            PropertyValuesHolder ofObject2 = PropertyValuesHolder.ofObject("locator", new LatLngEvaluator(), new Object[]{getPosition(), latLng});
            PropertyValuesHolder ofObject3 = PropertyValuesHolder.ofObject(BlocksConst.WIDGET_PARAMS_ANGLE, AngleEvaluator.INSTANCE, new Object[]{Float.valueOf(getAngle()), Float.valueOf(f)});
            PropertyValuesHolder ofObject4 = PropertyValuesHolder.ofObject("mapAngle", AngleEvaluator.INSTANCE, new Object[]{Float.valueOf(camera2.getRotate()), Float.valueOf(normalizeRotate)});
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setValues(new PropertyValuesHolder[]{ofObject, ofObject2, ofObject3, ofObject4});
            gLAnimator.mo75552a(this.mViewManager.getFps());
            gLAnimator.setDuration(1000);
            gLAnimator.setInterpolator(new LinearInterpolator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Camera camera = (Camera) valueAnimator.getAnimatedValue("camera");
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue("locator");
                    float floatValue = ((Float) valueAnimator.getAnimatedValue(BlocksConst.WIDGET_PARAMS_ANGLE)).floatValue();
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue("mapAngle")).floatValue();
                    if (GLLocator.this.isCarUpAndFollowMode()) {
                        GLLocator.this.m20669a(latLng, floatValue, floatValue2, camera.getScale(), camera.getSkew());
                    } else {
                        GLLocator.this.setPositionAndAngle(latLng, floatValue, floatValue2);
                    }
                }
            });
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        if (isCarUpAndFollowMode()) {
            this.f26155a.mo75557a(f3, f4);
        }
        setPositionAndAngle(latLng, f, normalizeRotate);
    }

    public void navigateToPosition(boolean z, List<LatLng> list, float f, float f2, float f3, float f4, float f5) {
        float normalizeRotate = MapTransform.normalizeRotate(-f2);
        if (z) {
            m20666a(f3, normalizeRotate);
            Camera camera = new Camera(this.f26155a.getCenter(), f3, this.f26155a.getRotate(), f4);
            Camera camera2 = this.f26155a.getCamera();
            PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject("camera", new CameraEvaluator(true), new Object[]{camera2, camera});
            list.add(0, getPosition());
            PropertyValuesHolder ofObject2 = PropertyValuesHolder.ofObject("locator", new LatLngEvaluator(), list.toArray());
            PropertyValuesHolder ofObject3 = PropertyValuesHolder.ofObject(BlocksConst.WIDGET_PARAMS_ANGLE, AngleEvaluator.INSTANCE, m20665a(f, list).toArray());
            PropertyValuesHolder ofObject4 = PropertyValuesHolder.ofObject("mapAngle", AngleEvaluator.INSTANCE, new Object[]{Float.valueOf(camera2.getRotate()), Float.valueOf(normalizeRotate)});
            PropertyValuesHolder ofObject5 = PropertyValuesHolder.ofObject("offsetX", new FloatEvaluator(), new Object[]{Float.valueOf(this.f26155a.getCenterOffsetX()), Float.valueOf(f5)});
            GLAnimator gLAnimator = new GLAnimator();
            gLAnimator.setValues(new PropertyValuesHolder[]{ofObject, ofObject2, ofObject3, ofObject5, ofObject4});
            gLAnimator.mo75552a(this.mViewManager.getFps());
            gLAnimator.setDuration(1000);
            gLAnimator.setInterpolator(new LinearInterpolator());
            gLAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Camera camera = (Camera) valueAnimator.getAnimatedValue("camera");
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue("locator");
                    float floatValue = ((Float) valueAnimator.getAnimatedValue(BlocksConst.WIDGET_PARAMS_ANGLE)).floatValue();
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue("offsetX")).floatValue();
                    float floatValue3 = ((Float) valueAnimator.getAnimatedValue("mapAngle")).floatValue();
                    if (GLLocator.this.isCarUpAndFollowMode()) {
                        GLLocator.this.f26155a.mo75558a(camera.getSkew(), camera.getScale(), floatValue2);
                    }
                    GLLocator.this.setPositionAndAngle(latLng, floatValue, floatValue3);
                }
            });
            setAnimator(gLAnimator);
            startAnimator();
            return;
        }
        if (isCarUpAndFollowMode()) {
            this.f26155a.mo75558a(f4, f3, f5);
        }
        setPositionAndAngle(list.get(0), f, normalizeRotate);
    }

    /* renamed from: a */
    private List<Float> m20665a(float f, List<LatLng> list) {
        List<LatLng> list2 = list;
        int size = list.size() - 1;
        ArrayList arrayList = new ArrayList(size);
        float[] fArr = new float[2];
        int i = 0;
        while (i < size) {
            LatLng latLng = list2.get(i);
            int i2 = i + 1;
            LatLng latLng2 = list2.get(i2);
            if (!latLng.equals(latLng2)) {
                Location.distanceBetween(latLng.latitude, latLng.longitude, latLng2.latitude, latLng2.longitude, fArr);
                arrayList.add(Float.valueOf(fArr[1]));
            }
            i = i2;
        }
        if (arrayList.size() < 2) {
            arrayList.clear();
            arrayList.add(Float.valueOf(this.f26170p));
        }
        arrayList.add(Float.valueOf(f));
        return arrayList;
    }

    /* renamed from: a */
    private void m20666a(float f, float f2) {
        if (ApolloHawaii.IS_RENDER_DROP_FRAME) {
            float f3 = ApolloHawaii.SCALE_DELTA;
            float rotate = f2 - this.f26155a.getRotate();
            if (rotate > 180.0f) {
                rotate -= 360.0f;
            } else if (rotate < -180.0f) {
                rotate += 360.0f;
            }
            if (f - this.f26155a.getScale() >= f3 || Math.abs(rotate) >= ApolloHawaii.ROTATE_DELTA) {
                this.mViewManager.setFps(2);
            } else {
                this.mViewManager.setFps(6);
            }
        }
    }
}
