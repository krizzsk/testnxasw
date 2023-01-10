package com.didi.hawaii.mapsdkv2.widget;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Handler;
import android.widget.FrameLayout;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.map.outer.map.MapView;
import com.taxis99.R;

public class MapWidgets implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: n */
    private static final int[] f26399n = {Color.argb(255, 90, 90, 90), -1};

    /* renamed from: o */
    private static final int[] f26400o = {-1, Color.argb(255, 12, 12, 12)};

    /* renamed from: a */
    private final MapView f26401a;

    /* renamed from: b */
    private ScaleView f26402b;

    /* renamed from: c */
    private C10011a f26403c;

    /* renamed from: d */
    private GLBaseMapView f26404d;

    /* renamed from: e */
    private int f26405e = 20;

    /* renamed from: f */
    private int f26406f = 20;

    /* renamed from: g */
    private int f26407g = 12;

    /* renamed from: h */
    private int f26408h = 12;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f26409i = 5;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Handler f26410j;

    /* renamed from: k */
    private final float f26411k;

    /* renamed from: l */
    private int f26412l;

    /* renamed from: m */
    private ValueAnimator f26413m;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final Runnable f26414p = new Runnable() {
        public void run() {
            if (MapWidgets.this.f26409i == 4) {
                MapWidgets.this.m20917b(true);
                MapWidgets.this.m20913a(false);
            }
        }
    };

    /* renamed from: b */
    private static int m20914b(int i) {
        return (i == 9 || i == 11) ? R.drawable.didi_map_logo_night : R.drawable.didi_map_logo;
    }

    public MapWidgets(MapView mapView, GLBaseMapView gLBaseMapView) {
        this.f26412l = gLBaseMapView.getMapMode();
        this.f26401a = mapView;
        this.f26404d = gLBaseMapView;
        this.f26410j = gLBaseMapView.getMainHandler();
        this.f26411k = gLBaseMapView.getMapContext().getAndroidContext().getResources().getDisplayMetrics().density;
        m20909a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20913a(boolean z) {
        if (!z) {
            ScaleView scaleView = this.f26402b;
            if (scaleView != null) {
                scaleView.mo77318b();
                this.f26401a.removeView(this.f26402b);
                this.f26402b = null;
            }
        } else if (this.f26402b == null) {
            int[] c = m20919c(this.f26412l);
            this.f26402b = new ScaleView(this.f26401a.getContext(), this.f26404d, c[0], c[1]);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 83;
            layoutParams.leftMargin = this.f26405e;
            layoutParams.bottomMargin = this.f26406f;
            this.f26401a.addView(this.f26402b, layoutParams);
            this.f26402b.mo77316a();
        }
    }

    public void setScaleViewLeft(int i) {
        FrameLayout.LayoutParams layoutParams;
        this.f26405e = i;
        ScaleView scaleView = this.f26402b;
        if (scaleView != null && (layoutParams = (FrameLayout.LayoutParams) scaleView.getLayoutParams()) != null) {
            layoutParams.leftMargin = i;
            this.f26402b.setLayoutParams(layoutParams);
        }
    }

    public void setScaleViewBottom(int i) {
        FrameLayout.LayoutParams layoutParams;
        this.f26406f = i;
        ScaleView scaleView = this.f26402b;
        if (scaleView != null && (layoutParams = (FrameLayout.LayoutParams) scaleView.getLayoutParams()) != null) {
            layoutParams.bottomMargin = i;
            this.f26402b.setLayoutParams(layoutParams);
        }
    }

    public boolean isScaleViewVisible() {
        ScaleView scaleView = this.f26402b;
        if (scaleView != null && scaleView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void setLogoScaleShowMode(int i) {
        if ((i == 3 || i == 1 || i == 2 || i == 5 || i == 4) && this.f26409i != i) {
            this.f26409i = i;
            m20909a();
        }
    }

    /* renamed from: a */
    private void m20909a() {
        int i = this.f26409i;
        if (i == 1) {
            m20917b(true);
            m20913a(false);
            this.f26404d.setScaleRulerControl(new GLBaseMapView.ScaleRulerShowCallback() {
                public void onScaleChange() {
                }

                public void onMapModeChange(int i) {
                    MapWidgets.this.m20910a(i);
                }
            });
            this.f26410j.removeCallbacks(this.f26414p);
        } else if (i == 2) {
            m20917b(false);
            m20913a(true);
            this.f26404d.setScaleRulerControl(new GLBaseMapView.ScaleRulerShowCallback() {
                public void onScaleChange() {
                }

                public void onMapModeChange(int i) {
                    MapWidgets.this.m20910a(i);
                }
            });
            this.f26410j.removeCallbacks(this.f26414p);
        } else if (i == 3) {
            m20913a(true);
            m20917b(true);
            this.f26404d.setScaleRulerControl(new GLBaseMapView.ScaleRulerShowCallback() {
                public void onScaleChange() {
                }

                public void onMapModeChange(int i) {
                    MapWidgets.this.m20910a(i);
                }
            });
            this.f26410j.removeCallbacks(this.f26414p);
        } else if (i == 4) {
            m20917b(true);
            this.f26404d.setScaleRulerControl(new GLBaseMapView.ScaleRulerShowCallback() {
                public void onScaleChange() {
                    MapWidgets.this.m20913a(true);
                    MapWidgets.this.m20917b(false);
                    MapWidgets.this.f26410j.removeCallbacks(MapWidgets.this.f26414p);
                    MapWidgets.this.f26410j.postDelayed(MapWidgets.this.f26414p, 1000);
                }

                public void onMapModeChange(int i) {
                    MapWidgets.this.m20910a(i);
                }
            });
        } else if (i == 5) {
            m20917b(false);
            m20913a(false);
            this.f26404d.setScaleRulerControl((GLBaseMapView.ScaleRulerShowCallback) null);
            this.f26410j.removeCallbacks(this.f26414p);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20910a(int i) {
        this.f26412l = i;
        C10011a aVar = this.f26403c;
        if (aVar != null) {
            aVar.setImageResource(m20914b(i));
        }
        if (this.f26402b != null) {
            int[] c = m20919c(this.f26412l);
            this.f26402b.mo77317a(c[0], c[1]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20917b(boolean z) {
        if (z) {
            if (this.f26403c == null) {
                C10011a aVar = new C10011a(this.f26401a.getContext());
                this.f26403c = aVar;
                aVar.setAlpha(0);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 83;
                layoutParams.leftMargin = this.f26407g;
                layoutParams.bottomMargin = this.f26408h;
                this.f26403c.setImageResource(m20914b(this.f26412l));
                this.f26401a.addView(this.f26403c, layoutParams);
                ValueAnimator valueAnimator = this.f26413m;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.f26413m = null;
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 255});
                this.f26413m = ofInt;
                ofInt.addUpdateListener(this);
                this.f26413m.setDuration(600);
                this.f26413m.start();
            }
        } else if (this.f26403c != null) {
            ValueAnimator valueAnimator2 = this.f26413m;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.f26413m = null;
            }
            if (this.f26401a.indexOfChild(this.f26403c) != -1) {
                this.f26401a.removeView(this.f26403c);
            }
            this.f26403c = null;
        }
    }

    public void setLogoViewLeft(int i) {
        FrameLayout.LayoutParams layoutParams;
        this.f26407g = i - ((int) (((double) this.f26411k) * 3.5d));
        C10011a aVar = this.f26403c;
        if (aVar != null && (layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams()) != null) {
            layoutParams.leftMargin = this.f26407g;
            this.f26403c.setLayoutParams(layoutParams);
        }
    }

    public void setLogoViewBottom(int i) {
        FrameLayout.LayoutParams layoutParams;
        this.f26408h = i - ((int) (((double) this.f26411k) * 3.5d));
        C10011a aVar = this.f26403c;
        if (aVar != null && (layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams()) != null) {
            layoutParams.bottomMargin = this.f26408h;
            this.f26403c.setLayoutParams(layoutParams);
        }
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.f26403c != null) {
            this.f26403c.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: c */
    private static int[] m20919c(int i) {
        if (i == 9 || i == 11) {
            return f26400o;
        }
        return f26399n;
    }
}
