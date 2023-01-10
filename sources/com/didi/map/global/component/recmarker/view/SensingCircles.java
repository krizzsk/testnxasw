package com.didi.map.global.component.recmarker.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import com.didi.common.map.Map;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.LatLng;
import com.taxis99.R;

public class SensingCircles {
    public static final int BIG_RADIUS = 48;
    public static final int SMALL_RADIUS = 12;
    public static float TIME_PERIOD = 1200.0f;
    public static float TIME_TRANSIEN_PERIOD = 800.0f;

    /* renamed from: a */
    private Handler f28387a;

    /* renamed from: b */
    private Context f28388b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f28389c;

    /* renamed from: d */
    private final int f28390d;

    /* renamed from: e */
    private final float f28391e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile boolean f28392f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LatLng f28393g;

    /* renamed from: h */
    private SensingCircle[] f28394h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f28395i;

    /* renamed from: j */
    private final int f28396j;

    /* renamed from: k */
    private final int f28397k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f28398l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f28399m;

    /* renamed from: n */
    private int f28400n;

    /* renamed from: o */
    private Runnable f28401o;

    public SensingCircles(Context context, Map map) {
        this(context, map, (int) R.color.map_departure_sensing_circle, TIME_PERIOD, 12.0f);
    }

    public void setmZindex(int i) {
        this.f28400n = i;
    }

    public SensingCircles(Context context, Map map, int i) {
        this(context, map, i, 1200.0f, 90.0f);
    }

    public SensingCircles(Context context, Map map, String str) {
        this(context, map, str, 1200.0f, 90.0f);
    }

    public SensingCircles(Context context, Map map, int i, float f, float f2) {
        this.f28390d = 255;
        this.f28391e = 0.6f;
        this.f28394h = new SensingCircle[2];
        this.f28396j = -1;
        this.f28397k = 50;
        this.f28398l = TIME_PERIOD;
        this.f28399m = 8;
        this.f28401o = new Runnable() {
            public void run() {
                SensingCircles.this.m22218a();
            }
        };
        this.f28388b = context.getApplicationContext();
        this.f28389c = map;
        if (this.f28387a == null) {
            this.f28387a = new Handler(Looper.getMainLooper());
        }
        m22219a(i, f, f2);
    }

    public SensingCircles(Context context, Map map, String str, float f, float f2) {
        this.f28390d = 255;
        this.f28391e = 0.6f;
        this.f28394h = new SensingCircle[2];
        this.f28396j = -1;
        this.f28397k = 50;
        this.f28398l = TIME_PERIOD;
        this.f28399m = 8;
        this.f28401o = new Runnable() {
            public void run() {
                SensingCircles.this.m22218a();
            }
        };
        this.f28388b = context.getApplicationContext();
        this.f28389c = map;
        if (this.f28387a == null) {
            this.f28387a = new Handler(Looper.getMainLooper());
        }
        m22221a(str, f, f2);
    }

    /* renamed from: a */
    private void m22219a(int i, float f, float f2) {
        Resources resources;
        Context context = this.f28388b;
        if (context != null && (resources = context.getResources()) != null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            if (-1 != i) {
                paint.setColor(resources.getColor(i));
            } else {
                paint.setColor(resources.getColor(R.color.map_departure_sensing_circle));
            }
            paint.setAlpha(102);
            this.f28398l = f;
            this.f28395i = (float) dip2px(this.f28388b, f2);
            this.f28394h[0] = new SensingCircle(new Paint(paint), new CircleActionMeta().setFrames(0));
            this.f28394h[1] = new SensingCircle(new Paint(paint), new Circle2ActionMeta().setFrames(0));
        }
    }

    public int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    private void m22221a(String str, float f, float f2) {
        Resources resources;
        Context context = this.f28388b;
        if (context != null && (resources = context.getResources()) != null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            if (str != null) {
                paint.setColor(Color.parseColor(str));
            } else {
                paint.setColor(resources.getColor(R.color.map_departure_sensing_circle));
            }
            paint.setAlpha(76);
            this.f28398l = f;
            this.f28395i = f2;
            this.f28394h[0] = new SensingCircle(new Paint(paint), new CircleActionMeta().setFrames(0));
            this.f28394h[1] = new SensingCircle(new Paint(paint), new Circle2ActionMeta().setFrames(0));
        }
    }

    public void show(LatLng latLng) {
        if (!this.f28392f && this.f28393g != latLng) {
            this.f28392f = true;
            this.f28393g = latLng;
            CircleOptions circleOptions = new CircleOptions();
            circleOptions.center(latLng).radius(0.0d).strokeColor(this.f28394h[0].getPaint().getColor()).strokeWidth(0.1f).zIndex(this.f28400n);
            this.f28394h[0].setCircle(this.f28389c.addCircle(circleOptions));
            CircleOptions circleOptions2 = new CircleOptions();
            circleOptions2.center(latLng).radius(0.0d).strokeColor(this.f28394h[1].getPaint().getColor()).strokeWidth(0.1f).zIndex(this.f28400n);
            this.f28394h[1].setCircle(this.f28389c.addCircle(circleOptions2));
            m22218a();
        }
    }

    public void showTransientCircles(LatLng latLng) {
        if (!this.f28392f && this.f28393g != latLng) {
            this.f28392f = true;
            this.f28393g = latLng;
            CircleOptions circleOptions = new CircleOptions();
            circleOptions.center(latLng).radius(0.0d).strokeColor(this.f28394h[0].getPaint().getColor()).strokeWidth(0.1f).zIndex(this.f28400n);
            this.f28394h[0].setCircle(this.f28389c.addCircle(circleOptions));
            this.f28394h[0].setAction(new CircleTransientActionMeta().setFrames(0));
            this.f28394h[1] = null;
            m22218a();
            Handler handler = this.f28387a;
            if (handler != null) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        SensingCircles.this.hide();
                    }
                }, (long) TIME_TRANSIEN_PERIOD);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22218a() {
        if (this.f28392f) {
            for (SensingCircle sensingCircle : this.f28394h) {
                if (sensingCircle != null) {
                    sensingCircle.doAction();
                }
            }
            Handler handler = this.f28387a;
            if (handler != null) {
                handler.postDelayed(this.f28401o, 50);
            }
        }
    }

    public void updatePosition(LatLng latLng) {
        SensingCircle[] sensingCircleArr = this.f28394h;
        if (sensingCircleArr != null && sensingCircleArr.length > 0) {
            int length = sensingCircleArr.length;
            for (int i = 0; i < length; i++) {
                this.f28394h[i].updatePosition(latLng);
            }
        }
    }

    public void hide() {
        if (this.f28392f) {
            this.f28392f = false;
            for (SensingCircle sensingCircle : this.f28394h) {
                if (sensingCircle != null) {
                    sensingCircle.reset();
                    sensingCircle.removeCircle();
                }
            }
            Handler handler = this.f28387a;
            if (handler != null) {
                handler.removeCallbacks(this.f28401o);
                this.f28387a = null;
            }
        }
    }

    private class SensingCircle {
        private ActionMeta action;
        private Circle circle;
        private Object lock = new Object();
        private Paint paint;
        private float radius;

        public SensingCircle(Paint paint2, ActionMeta actionMeta) {
            this.paint = paint2;
            this.action = actionMeta;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0082, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void doAction() {
            /*
                r8 = this;
                java.lang.Object r0 = r8.lock
                monitor-enter(r0)
                com.didi.common.map.model.Circle r1 = r8.circle     // Catch:{ all -> 0x0085 }
                if (r1 == 0) goto L_0x0083
                android.graphics.Paint r1 = r8.paint     // Catch:{ all -> 0x0085 }
                if (r1 == 0) goto L_0x0083
                com.didi.map.global.component.recmarker.view.SensingCircles$ActionMeta r1 = r8.action     // Catch:{ all -> 0x0085 }
                if (r1 == 0) goto L_0x0083
                com.didi.map.global.component.recmarker.view.SensingCircles r1 = com.didi.map.global.component.recmarker.view.SensingCircles.this     // Catch:{ all -> 0x0085 }
                com.didi.common.map.model.LatLng r1 = r1.f28393g     // Catch:{ all -> 0x0085 }
                if (r1 != 0) goto L_0x0018
                goto L_0x0083
            L_0x0018:
                com.didi.map.global.component.recmarker.view.SensingCircles r1 = com.didi.map.global.component.recmarker.view.SensingCircles.this     // Catch:{ all -> 0x0085 }
                boolean r1 = r1.f28392f     // Catch:{ all -> 0x0085 }
                if (r1 != 0) goto L_0x0022
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                return
            L_0x0022:
                com.didi.map.global.component.recmarker.view.SensingCircles r1 = com.didi.map.global.component.recmarker.view.SensingCircles.this     // Catch:{ all -> 0x0085 }
                com.didi.common.map.Map r1 = r1.f28389c     // Catch:{ all -> 0x0085 }
                if (r1 == 0) goto L_0x0081
                com.didi.map.global.component.recmarker.view.SensingCircles r1 = com.didi.map.global.component.recmarker.view.SensingCircles.this     // Catch:{ all -> 0x0085 }
                com.didi.common.map.Map r1 = r1.f28389c     // Catch:{ all -> 0x0085 }
                com.didi.common.map.Projection r1 = r1.getProjection()     // Catch:{ all -> 0x0085 }
                if (r1 != 0) goto L_0x0037
                goto L_0x0081
            L_0x0037:
                com.didi.map.global.component.recmarker.view.SensingCircles$ActionMeta r2 = r8.action     // Catch:{ all -> 0x0085 }
                r2.nextFrame()     // Catch:{ all -> 0x0085 }
                com.didi.map.global.component.recmarker.view.SensingCircles$ActionMeta r2 = r8.action     // Catch:{ all -> 0x0085 }
                float r2 = r2.getRadius()     // Catch:{ all -> 0x0085 }
                r8.radius = r2     // Catch:{ all -> 0x0085 }
                com.didi.common.map.model.Circle r3 = r8.circle     // Catch:{ Exception -> 0x007b }
                double r4 = (double) r2     // Catch:{ Exception -> 0x007b }
                com.didi.map.global.component.recmarker.view.SensingCircles r2 = com.didi.map.global.component.recmarker.view.SensingCircles.this     // Catch:{ Exception -> 0x007b }
                com.didi.common.map.model.LatLng r2 = r2.f28393g     // Catch:{ Exception -> 0x007b }
                double r6 = r2.latitude     // Catch:{ Exception -> 0x007b }
                double r1 = r1.metersPerPixel(r6)     // Catch:{ Exception -> 0x007b }
                double r4 = r4 * r1
                r3.setRadius(r4)     // Catch:{ Exception -> 0x007b }
                android.graphics.Paint r1 = r8.paint     // Catch:{ all -> 0x0085 }
                com.didi.map.global.component.recmarker.view.SensingCircles$ActionMeta r2 = r8.action     // Catch:{ all -> 0x0085 }
                int r2 = r2.getAlpha()     // Catch:{ all -> 0x0085 }
                r1.setAlpha(r2)     // Catch:{ all -> 0x0085 }
                com.didi.common.map.model.Circle r1 = r8.circle     // Catch:{ all -> 0x0085 }
                android.graphics.Paint r2 = r8.paint     // Catch:{ all -> 0x0085 }
                int r2 = r2.getColor()     // Catch:{ all -> 0x0085 }
                r1.setFillColor(r2)     // Catch:{ all -> 0x0085 }
                com.didi.common.map.model.Circle r1 = r8.circle     // Catch:{ all -> 0x0085 }
                android.graphics.Paint r2 = r8.paint     // Catch:{ all -> 0x0085 }
                int r2 = r2.getColor()     // Catch:{ all -> 0x0085 }
                r1.setStrokeColor(r2)     // Catch:{ all -> 0x0085 }
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                return
            L_0x007b:
                r1 = move-exception
                r1.printStackTrace()     // Catch:{ all -> 0x0085 }
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                return
            L_0x0081:
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                return
            L_0x0083:
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                return
            L_0x0085:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.recmarker.view.SensingCircles.SensingCircle.doAction():void");
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

        public SensingCircle setZIndex(float f) {
            synchronized (this.lock) {
                if (this.circle != null) {
                    this.circle.setZIndex((int) f);
                }
            }
            return this;
        }

        public Circle getCircle() {
            return this.circle;
        }

        public SensingCircle setCircle(Circle circle2) {
            this.circle = circle2;
            return this;
        }

        public SensingCircle removeCircle() {
            reset();
            synchronized (this.lock) {
                if (this.circle != null) {
                    if (SensingCircles.this.f28389c != null) {
                        SensingCircles.this.f28389c.remove(this.circle);
                    }
                    this.circle = null;
                }
            }
            return this;
        }

        /* access modifiers changed from: private */
        public void updatePosition(LatLng latLng) {
            Circle circle2 = this.circle;
            if (circle2 != null) {
                circle2.setCenter(latLng);
            }
        }
    }

    private class ActionMeta {
        protected float alphaPer;
        protected int direction;
        protected int frames;
        protected float per;
        protected float total_frames;

        /* access modifiers changed from: protected */
        public int getAlpha() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public float getRadius() {
            return 0.0f;
        }

        private ActionMeta() {
            this.direction = 1;
            this.frames = 0;
            this.total_frames = SensingCircles.this.f28398l / 50.0f;
            float f = SensingCircles.this.f28395i;
            float f2 = this.total_frames;
            this.per = f / f2;
            this.alphaPer = 0.6f / f2;
        }

        /* access modifiers changed from: protected */
        public void nextFrame() {
            if (((float) this.frames) > this.total_frames + ((float) SensingCircles.this.f28399m)) {
                this.frames = 0;
            }
            this.frames = this.direction + this.frames;
        }

        public int getDirection() {
            return this.direction;
        }

        public ActionMeta setDirection(int i) {
            this.direction = i;
            return this;
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

    private class CircleActionMeta extends ActionMeta {
        private CircleActionMeta() {
            super();
        }

        /* access modifiers changed from: protected */
        public float getRadius() {
            if (this.frames < 0 || ((float) this.frames) > this.total_frames) {
                return 0.0f;
            }
            return this.per * ((float) this.frames);
        }

        /* access modifiers changed from: protected */
        public int getAlpha() {
            if (this.frames < 0 || ((float) this.frames) > this.total_frames) {
                return 0;
            }
            return (int) ((this.total_frames - ((float) this.frames)) * 255.0f * this.alphaPer);
        }
    }

    private class Circle2ActionMeta extends ActionMeta {
        private Circle2ActionMeta() {
            super();
        }

        /* access modifiers changed from: protected */
        public float getRadius() {
            if (this.frames >= 0 && this.frames <= SensingCircles.this.f28399m) {
                return (float) SensingCircles.this.f28399m;
            }
            if (this.frames <= SensingCircles.this.f28399m || ((float) this.frames) > this.total_frames + ((float) SensingCircles.this.f28399m)) {
                return 0.0f;
            }
            return this.per * (((float) this.frames) - ((float) SensingCircles.this.f28399m));
        }

        /* access modifiers changed from: protected */
        public int getAlpha() {
            if (this.frames >= 0 && this.frames <= SensingCircles.this.f28399m) {
                return 0;
            }
            if (this.frames <= SensingCircles.this.f28399m || ((float) this.frames) > this.total_frames + ((float) SensingCircles.this.f28399m)) {
                return 255;
            }
            return (int) (((this.total_frames + ((float) SensingCircles.this.f28399m)) - ((float) this.frames)) * 255.0f * this.alphaPer);
        }
    }

    private class CircleTransientActionMeta extends ActionMeta {
        private CircleTransientActionMeta() {
            super();
        }

        /* access modifiers changed from: protected */
        public float getRadius() {
            if (this.frames < 0 || ((float) this.frames) > this.total_frames) {
                return 0.0f;
            }
            return this.per * ((float) this.frames);
        }

        /* access modifiers changed from: protected */
        public int getAlpha() {
            if (this.frames < 0 || ((float) this.frames) > this.total_frames) {
                return 0;
            }
            return (int) ((this.total_frames - ((float) this.frames)) * 255.0f * this.alphaPer);
        }
    }

    public boolean isShow() {
        return this.f28392f;
    }
}
