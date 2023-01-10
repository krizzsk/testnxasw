package com.didi.flutter.nacho.p115ui.blur;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.didi.flutter.nacho.p115ui.SnapshotFetcher;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.flutter.nacho.ui.blur.BlurDialogEngine */
public class BlurDialogEngine {

    /* renamed from: a */
    static final float f22975a = 4.0f;

    /* renamed from: b */
    static final int f22976b = 8;

    /* renamed from: c */
    static final boolean f22977c = false;

    /* renamed from: d */
    static final boolean f22978d = false;

    /* renamed from: e */
    static final boolean f22979e = false;

    /* renamed from: f */
    static final boolean f22980f = false;

    /* renamed from: g */
    private static final String f22981g = BlurDialogEngine.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImageView f22982h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public FrameLayout.LayoutParams f22983i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public BlurAsyncTask f22984j;

    /* renamed from: k */
    private boolean f22985k = false;

    /* renamed from: l */
    private float f22986l = 4.0f;

    /* renamed from: m */
    private int f22987m = 8;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Activity f22988n;

    /* renamed from: o */
    private Toolbar f22989o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f22990p;

    /* renamed from: q */
    private boolean f22991q;

    /* renamed from: r */
    private boolean f22992r;

    public BlurDialogEngine(Activity activity) {
        this.f22988n = activity;
        this.f22990p = activity.getResources().getInteger(R.integer.blur_dialog_animation_duration);
    }

    public void onAttach(Activity activity) {
        this.f22988n = activity;
    }

    public void onResume(boolean z) {
        if (this.f22982h != null && !z) {
            return;
        }
        if (this.f22988n.getWindow().getDecorView().isShown()) {
            BlurAsyncTask blurAsyncTask = new BlurAsyncTask();
            this.f22984j = blurAsyncTask;
            blurAsyncTask.execute(new Void[0]);
            return;
        }
        this.f22988n.getWindow().getDecorView().getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                if (BlurDialogEngine.this.f22988n == null) {
                    return true;
                }
                BlurDialogEngine.this.f22988n.getWindow().getDecorView().getViewTreeObserver().removeOnPreDrawListener(this);
                BlurAsyncTask unused = BlurDialogEngine.this.f22984j = new BlurAsyncTask();
                BlurDialogEngine.this.f22984j.execute(new Void[0]);
                return true;
            }
        });
    }

    public void onDismiss() {
        BlurAsyncTask blurAsyncTask = this.f22984j;
        if (blurAsyncTask != null) {
            blurAsyncTask.cancel(true);
        }
        if (this.f22982h == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            this.f22982h.animate().alpha(0.0f).setDuration((long) this.f22990p).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    BlurDialogEngine.this.m18967e();
                }

                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    BlurDialogEngine.this.m18967e();
                }
            }).start();
        } else {
            m18967e();
        }
    }

    public void onDetach() {
        BlurAsyncTask blurAsyncTask = this.f22984j;
        if (blurAsyncTask != null) {
            blurAsyncTask.cancel(true);
        }
        this.f22984j = null;
        this.f22988n = null;
    }

    public void debug(boolean z) {
        this.f22985k = z;
    }

    public void setDownScaleFactor(float f) {
        if (f >= 1.0f) {
            this.f22986l = f;
        } else {
            this.f22986l = 1.0f;
        }
    }

    public void setBlurRadius(int i) {
        if (i >= 0) {
            this.f22987m = i;
        } else {
            this.f22987m = 0;
        }
    }

    public void setUseRenderScript(boolean z) {
        this.f22992r = z;
    }

    public void setBlurActionBar(boolean z) {
        this.f22991q = z;
    }

    public void setToolbar(Toolbar toolbar) {
        this.f22989o = toolbar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18958a(Bitmap bitmap, View view) {
        int i;
        int i2;
        Bitmap bitmap2;
        Bitmap bitmap3;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        this.f22983i = new FrameLayout.LayoutParams(-1, -1);
        if (this.f22991q) {
            i = 0;
        } else {
            i = m18955a();
        }
        int b = (this.f22988n.getWindow().getAttributes().flags & 1024) == 0 ? m18960b() : 0;
        if (Build.VERSION.SDK_INT >= 19 && m18965d()) {
            b = 0;
        }
        int i3 = b + i;
        int c = m18962c();
        if (this.f22988n.getResources().getBoolean(R.bool.blur_dialog_has_bottom_navigation_bar)) {
            i2 = c;
            c = 0;
        } else {
            i2 = 0;
        }
        Rect rect = new Rect(0, i3, bitmap.getWidth() - c, bitmap.getHeight() - i2);
        double ceil = Math.ceil((double) (((float) ((view.getHeight() - i3) - i2)) / this.f22986l));
        double ceil2 = Math.ceil((((double) (view.getWidth() - c)) * ceil) / ((double) ((view.getHeight() - i3) - i2)));
        if (this.f22992r) {
            bitmap2 = Bitmap.createBitmap((int) ceil2, (int) ceil, Bitmap.Config.ARGB_8888);
        } else {
            bitmap2 = Bitmap.createBitmap((int) ceil2, (int) ceil, Bitmap.Config.RGB_565);
        }
        try {
            if (Build.VERSION.SDK_INT < 11 || (this.f22988n instanceof AppCompatActivity)) {
                this.f22983i.setMargins(0, i, 0, 0);
                this.f22983i.gravity = 48;
            }
        } catch (NoClassDefFoundError unused) {
            this.f22983i.setMargins(0, 0, 0, 0);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, rect, new RectF(0.0f, 0.0f, (float) bitmap2.getWidth(), (float) bitmap2.getHeight()), paint);
        if (this.f22992r) {
            bitmap3 = C8876b.m18971a(bitmap2, this.f22987m, true, this.f22988n);
        } else {
            bitmap3 = C8875a.m18969a(bitmap2, this.f22987m, true);
        }
        if (this.f22985k) {
            String str2 = (System.currentTimeMillis() - currentTimeMillis) + " ms";
            String str3 = f22981g;
            StringBuilder sb = new StringBuilder();
            sb.append("Blur method : ");
            sb.append(this.f22992r ? "RenderScript" : "FastBlur");
            SystemUtils.log(3, str3, sb.toString(), (Throwable) null, "com.didi.flutter.nacho.ui.blur.BlurDialogEngine", 430);
            SystemUtils.log(3, f22981g, "Radius : " + this.f22987m, (Throwable) null, "com.didi.flutter.nacho.ui.blur.BlurDialogEngine", 431);
            SystemUtils.log(3, f22981g, "Down Scale Factor : " + this.f22986l, (Throwable) null, "com.didi.flutter.nacho.ui.blur.BlurDialogEngine", 432);
            SystemUtils.log(3, f22981g, "Blurred achieved in : " + str2, (Throwable) null, "com.didi.flutter.nacho.ui.blur.BlurDialogEngine", 433);
            String str4 = f22981g;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Allocation : ");
            sb2.append(bitmap.getRowBytes());
            sb2.append("ko (screen capture) + ");
            sb2.append(bitmap3.getRowBytes());
            sb2.append("ko (blurred bitmap)");
            if (!this.f22992r) {
                str = " + temp buff " + bitmap3.getRowBytes() + "ko.";
            } else {
                str = ".";
            }
            sb2.append(str);
            SystemUtils.log(3, str4, sb2.toString(), (Throwable) null, "com.didi.flutter.nacho.ui.blur.BlurDialogEngine", 434);
            Rect rect2 = new Rect();
            Canvas canvas2 = new Canvas(bitmap3);
            paint.setColor(-16777216);
            paint.setAntiAlias(true);
            paint.setTextSize(20.0f);
            paint.getTextBounds(str2, 0, str2.length(), rect2);
            canvas2.drawText(str2, 2.0f, (float) rect2.height(), paint);
        }
        ImageView imageView = new ImageView(this.f22988n);
        this.f22982h = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f22982h.setImageDrawable(new BitmapDrawable(this.f22988n.getResources(), bitmap3));
    }

    /* renamed from: a */
    private int m18955a() {
        ActionBar actionBar;
        ActionBar actionBar2;
        int height;
        try {
            if (this.f22989o != null) {
                height = this.f22989o.getHeight();
            } else if (this.f22988n instanceof AppCompatActivity) {
                androidx.appcompat.app.ActionBar supportActionBar = ((AppCompatActivity) this.f22988n).getSupportActionBar();
                if (supportActionBar != null) {
                    return supportActionBar.getHeight();
                }
                return 0;
            } else if (Build.VERSION.SDK_INT < 11 || (actionBar2 = this.f22988n.getActionBar()) == null) {
                return 0;
            } else {
                height = actionBar2.getHeight();
            }
            return height;
        } catch (NoClassDefFoundError unused) {
            if (Build.VERSION.SDK_INT < 11 || (actionBar = this.f22988n.getActionBar()) == null) {
                return 0;
            }
            return actionBar.getHeight();
        }
    }

    /* renamed from: b */
    private int m18960b() {
        int identifier = this.f22988n.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.f22988n.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: c */
    private int m18962c() {
        int identifier;
        Resources resources = this.f22988n.getResources();
        if (Build.VERSION.SDK_INT < 21 || (identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    /* renamed from: d */
    private boolean m18965d() {
        int[] iArr = {16843759};
        TypedArray obtainStyledAttributes = this.f22988n.obtainStyledAttributes(new TypedValue().resourceId, iArr);
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m18967e() {
        ImageView imageView = this.f22982h;
        if (imageView != null) {
            ViewGroup viewGroup = (ViewGroup) imageView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f22982h);
            }
            this.f22982h = null;
        }
    }

    /* renamed from: com.didi.flutter.nacho.ui.blur.BlurDialogEngine$BlurAsyncTask */
    private class BlurAsyncTask extends AsyncTask<Void, Void, Void> {
        private Bitmap mBackground;
        private View mBackgroundView;

        private BlurAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.mBackgroundView = BlurDialogEngine.this.f22988n.getWindow().getDecorView();
            Rect rect = new Rect();
            this.mBackgroundView.setDrawingCacheBackgroundColor(0);
            this.mBackgroundView.getWindowVisibleDisplayFrame(rect);
            this.mBackgroundView.destroyDrawingCache();
            this.mBackgroundView.setDrawingCacheEnabled(true);
            this.mBackgroundView.buildDrawingCache(true);
            Bitmap drawingCache = this.mBackgroundView.getDrawingCache(true);
            this.mBackground = drawingCache;
            if (drawingCache != null) {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(drawingCache.getWidth(), this.mBackground.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas();
                    canvas.setBitmap(createBitmap);
                    this.mBackgroundView.draw(canvas);
                    canvas.setBitmap((Bitmap) null);
                    this.mBackground = createBitmap;
                } catch (Error e) {
                    e.printStackTrace();
                }
            }
            if (this.mBackground == null) {
                this.mBackgroundView.measure(View.MeasureSpec.makeMeasureSpec(rect.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(rect.height(), 1073741824));
                View view = this.mBackgroundView;
                view.layout(0, 0, view.getMeasuredWidth(), this.mBackgroundView.getMeasuredHeight());
                this.mBackgroundView.destroyDrawingCache();
                this.mBackgroundView.setDrawingCacheEnabled(true);
                this.mBackgroundView.buildDrawingCache(true);
                this.mBackground = this.mBackgroundView.getDrawingCache(true);
            }
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            if (!isCancelled()) {
                Bitmap mapSnapshot = SnapshotFetcher.getInstance().getMapSnapshot(BlurDialogEngine.this.f22988n);
                if (mapSnapshot != null) {
                    Bitmap createBitmap = Bitmap.createBitmap(this.mBackground.getWidth(), this.mBackground.getHeight(), this.mBackground.getConfig());
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawBitmap(Bitmap.createScaledBitmap(mapSnapshot, mapSnapshot.getWidth(), mapSnapshot.getHeight(), false), 0.0f, 0.0f, (Paint) null);
                    canvas.drawBitmap(this.mBackground, 0.0f, 0.0f, (Paint) null);
                    canvas.save();
                    canvas.restore();
                    this.mBackground = createBitmap;
                }
                BlurDialogEngine.this.m18958a(this.mBackground, this.mBackgroundView);
                this.mBackground.recycle();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
            this.mBackgroundView.destroyDrawingCache();
            this.mBackgroundView.setDrawingCacheEnabled(false);
            BlurDialogEngine.this.f22988n.getWindow().addContentView(BlurDialogEngine.this.f22982h, BlurDialogEngine.this.f22983i);
            if (Build.VERSION.SDK_INT >= 12) {
                BlurDialogEngine.this.f22982h.setAlpha(0.0f);
                BlurDialogEngine.this.f22982h.animate().alpha(1.0f).setDuration((long) BlurDialogEngine.this.f22990p).setInterpolator(new LinearInterpolator()).start();
            }
            this.mBackgroundView = null;
            this.mBackground = null;
        }
    }
}
