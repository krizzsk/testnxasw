package com.didi.map.global.flow.scene.order.serving.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import com.didi.common.map.Map;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.LatLng;
import com.didi.trackupload.sdk.Constants;

public class SensingCirclesV1 {

    /* renamed from: a */
    private static final int f29335a = 32;

    /* renamed from: b */
    private static Handler f29336b;

    /* renamed from: c */
    private Context f29337c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Map f29338d;

    /* renamed from: e */
    private SensingCircle[] f29339e;

    /* renamed from: f */
    private boolean f29340f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LatLng f29341g;

    /* renamed from: h */
    private long f29342h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f29343i;

    /* renamed from: j */
    private Runnable f29344j = new Runnable() {
        public void run() {
            SensingCirclesV1.this.m22755a();
        }
    };

    public SensingCirclesV1(Context context, Map map, SensingCircleParam sensingCircleParam) {
        this.f29337c = context.getApplicationContext();
        this.f29338d = map;
        this.f29339e = new SensingCircle[2];
        if (f29336b == null) {
            f29336b = new Handler(Looper.getMainLooper());
        }
        m22756a(sensingCircleParam.colorInt);
        this.f29342h = sensingCircleParam.loopTimeMillis / 32;
        this.f29343i = TypedValue.applyDimension(1, sensingCircleParam.maxRadiusDip, context.getResources().getDisplayMetrics());
    }

    /* renamed from: a */
    private void m22756a(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        paint.setAlpha(76);
        this.f29339e[0] = new SensingCircle(new Paint(paint), new CircleActionMeta().setFrames(0));
        this.f29339e[1] = new SensingCircle(new Paint(paint), new Circle2ActionMeta().setFrames(0));
    }

    public void showAt(LatLng latLng) {
        if (!this.f29340f && this.f29341g != latLng) {
            this.f29340f = true;
            this.f29341g = latLng;
            CircleOptions circleOptions = (CircleOptions) new CircleOptions().center(latLng).radius(0.0d).strokeColor(this.f29339e[0].getPaint().getColor()).strokeWidth(0.1f).zIndex(-100);
            Circle addCircle = this.f29338d.addCircle(circleOptions);
            this.f29339e[0].setCircle(circleOptions);
            this.f29339e[0].setCircle(addCircle);
            CircleOptions circleOptions2 = (CircleOptions) new CircleOptions().center(latLng).radius(0.0d).strokeColor(this.f29339e[1].getPaint().getColor()).strokeWidth(0.1f).zIndex(-99);
            Circle addCircle2 = this.f29338d.addCircle(circleOptions2);
            this.f29339e[1].setCircle(circleOptions2);
            this.f29339e[1].setCircle(addCircle2);
            f29336b.postDelayed(new Runnable() {
                public void run() {
                    SensingCirclesV1.this.m22755a();
                }
            }, Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
        }
    }

    public void hide() {
        if (this.f29340f) {
            this.f29340f = false;
            for (SensingCircle sensingCircle : this.f29339e) {
                if (sensingCircle != null) {
                    sensingCircle.reset();
                    sensingCircle.removeCircle();
                }
            }
        }
    }

    public boolean isShow() {
        return this.f29340f;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22755a() {
        if (this.f29340f) {
            for (SensingCircle sensingCircle : this.f29339e) {
                if (sensingCircle != null) {
                    sensingCircle.doAction();
                }
            }
            f29336b.postDelayed(this.f29344j, this.f29342h);
        }
    }

    public static class SensingCircleParam {
        public int colorInt = Color.parseColor("#FF7F41");
        public long loopTimeMillis = 1800;
        public float maxRadiusDip = 10.0f;

        public SensingCircleParam color(int i) {
            this.colorInt = i;
            return this;
        }

        public SensingCircleParam loopTimeMillis(long j) {
            this.loopTimeMillis = j;
            return this;
        }

        public SensingCircleParam maxRadiusDip(float f) {
            this.maxRadiusDip = f;
            return this;
        }
    }

    private final class Circle2ActionMeta extends ActionMeta {
        private Circle2ActionMeta() {
            super();
        }

        /* access modifiers changed from: protected */
        public float getRadius() {
            float b;
            float f;
            if (this.frames >= 0 && this.frames <= 8) {
                b = SensingCirclesV1.this.f29343i;
                f = 4.0f;
            } else if (this.frames <= 8 || this.frames > 32) {
                return 0.0f;
            } else {
                b = SensingCirclesV1.this.f29343i * ((float) (this.frames - 8));
                f = 24.0f;
            }
            return b / f;
        }

        /* access modifiers changed from: protected */
        public int getAlpha() {
            if (this.frames >= 0 && this.frames <= 8) {
                return 0;
            }
            if (this.frames <= 8 || this.frames > 32) {
                return 255;
            }
            return (int) ((32.0f - ((float) this.frames)) * 255.0f * this.alphaPer);
        }
    }

    private final class CircleActionMeta extends ActionMeta {
        private CircleActionMeta() {
            super();
        }

        /* access modifiers changed from: protected */
        public float getRadius() {
            if (this.frames < 0 || this.frames > 24) {
                return 0.0f;
            }
            return (SensingCirclesV1.this.f29343i * ((float) this.frames)) / 24.0f;
        }

        /* access modifiers changed from: protected */
        public int getAlpha() {
            if (this.frames < 0 || this.frames > 24) {
                return 0;
            }
            return (int) ((24.0f - ((float) this.frames)) * 255.0f * this.alphaPer);
        }
    }

    private class ActionMeta {
        protected float alphaPer;
        protected int frames;
        protected float per;

        /* access modifiers changed from: protected */
        public int getAlpha() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public float getRadius() {
            return 0.0f;
        }

        private ActionMeta() {
            this.frames = 0;
            this.per = 1.75f;
            this.alphaPer = 0.025f;
        }

        /* access modifiers changed from: protected */
        public void nextFrame() {
            if (this.frames > 32) {
                this.frames = 0;
            }
            this.frames++;
        }

        public int getFrames() {
            return this.frames;
        }

        public ActionMeta setFrames(int i) {
            this.frames = i;
            return this;
        }

        public float getPer() {
            return this.per;
        }

        public ActionMeta setPer(float f) {
            this.per = f;
            return this;
        }

        public float getAlphaPer() {
            return this.alphaPer;
        }

        public ActionMeta setAlphaPer(float f) {
            this.alphaPer = f;
            return this;
        }
    }

    private class SensingCircle {
        private ActionMeta action;
        private Circle circle;
        private CircleOptions circleOptions;
        private Object lock = new Object();
        private Paint paint;
        private float radius;
        private String tag;

        public SensingCircle(Paint paint2, ActionMeta actionMeta) {
            this.paint = paint2;
            this.action = actionMeta;
        }

        public void setCircle(Circle circle2) {
            this.circle = circle2;
        }

        /* access modifiers changed from: private */
        public void doAction() {
            synchronized (this.lock) {
                if (!(this.circle == null || this.paint == null || this.action == null || SensingCirclesV1.this.f29341g == null)) {
                    if (SensingCirclesV1.this.f29338d != null) {
                        try {
                            this.action.nextFrame();
                            this.radius = this.action.getRadius();
                            this.paint.setAlpha(this.action.getAlpha());
                            updateCircle(((double) this.radius) * 2.0d * SensingCirclesV1.m22758b(SensingCirclesV1.this.f29338d, SensingCirclesV1.this.f29341g.latitude), this.paint.getColor(), this.paint.getColor());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private void updateCircle(double d, int i, int i2) {
            this.circle.setRadius(d);
            this.circle.setFillColor(i);
            this.circle.setStrokeColor(i2);
        }

        /* access modifiers changed from: private */
        public void reset() {
            this.action.setFrames(0);
        }

        public Paint getPaint() {
            return this.paint;
        }

        public SensingCircle setPaint(Paint paint2) {
            this.paint = paint2;
            return this;
        }

        public float getRadius() {
            return this.radius;
        }

        public SensingCircle setRadius(float f) {
            this.radius = f;
            return this;
        }

        public ActionMeta getAction() {
            return this.action;
        }

        public SensingCircle setAction(ActionMeta actionMeta) {
            this.action = actionMeta;
            return this;
        }

        public CircleOptions getCircle() {
            return this.circleOptions;
        }

        public SensingCircle setCircle(CircleOptions circleOptions2) {
            this.circleOptions = circleOptions2;
            return this;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public SensingCircle removeCircle() {
            reset();
            synchronized (this.lock) {
                if (this.circle != null) {
                    SensingCirclesV1.this.f29338d.remove(this.circle);
                    this.circle = null;
                }
            }
            return this;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static double m22758b(Map map, double d) {
        if (map.getProjection() != null) {
            return map.getProjection().metersPerPixel(d);
        }
        return 0.0d;
    }
}
