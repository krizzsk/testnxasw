package com.didi.nova.assembly.p128ui.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sofa.utils.UiUtils;
import com.taxis99.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.nova.assembly.ui.banner.Banner */
public class Banner extends RelativeLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: c */
    private static final String f31680c = "Banner";

    /* renamed from: d */
    private static final int f31681d = 800;

    /* renamed from: e */
    private static final long f31682e = 4000;

    /* renamed from: a */
    OnBannerClickListener f31683a;

    /* renamed from: b */
    ViewPager.OnPageChangeListener f31684b;

    /* renamed from: f */
    private Context f31685f;

    /* renamed from: g */
    private C11096a f31686g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ViewPager f31687h;

    /* renamed from: i */
    private LinearLayout f31688i;

    /* renamed from: j */
    private List<ImageView> f31689j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f31690k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f31691l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f31692m;

    /* renamed from: n */
    private List<String> f31693n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f31694o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public long f31695p;

    /* renamed from: q */
    private boolean f31696q;

    /* renamed from: r */
    private int f31697r;

    /* renamed from: s */
    private int f31698s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f31699t;

    /* renamed from: u */
    private int f31700u;

    /* renamed from: v */
    private FitType f31701v;

    /* renamed from: w */
    private int f31702w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final Runnable f31703x;

    public Banner(Context context) {
        this(context, (AttributeSet) null);
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f31689j = new ArrayList();
        this.f31690k = new Handler(Looper.getMainLooper());
        this.f31693n = new ArrayList();
        this.f31694o = true;
        this.f31695p = 4000;
        this.f31696q = true;
        this.f31697r = 0;
        this.f31698s = 0;
        this.f31699t = true;
        this.f31700u = 0;
        this.f31701v = FitType.FIT_None;
        this.f31703x = new Runnable() {
            public void run() {
                int i;
                if (Banner.this.f31692m > 1 && Banner.this.f31687h != null) {
                    if (Banner.this.f31699t) {
                        i = (Banner.this.f31691l + 1) % (Banner.this.f31692m + 2);
                    } else {
                        i = (Banner.this.f31691l + 1) % Banner.this.f31692m;
                    }
                    SystemUtils.log(3, Banner.f31680c, "autoplay, setCurrentItem = " + i, (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner$1", 138);
                    Banner.this.f31687h.setCurrentItem(i, true);
                }
                if (Banner.this.f31694o) {
                    Banner.this.f31690k.postDelayed(Banner.this.f31703x, Banner.this.f31695p);
                }
            }
        };
        this.f31685f = context;
        m24224a(context, attributeSet);
        m24223a(context);
    }

    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.f31684b;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        m24222a(this.f31691l, i);
        this.f31691l = i;
        ViewPager.OnPageChangeListener onPageChangeListener = this.f31684b;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(m24219a(i));
        }
        SystemUtils.log(3, f31680c, "current index = " + i, (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 176);
    }

    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            setCheatCurrentItem(this.f31691l);
        } else if (i == 1) {
            setCheatCurrentItem(this.f31691l);
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f31684b;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f31694o) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                start();
            } else if (action == 0) {
                stop();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        SystemUtils.log(3, f31680c, "onDetachedFromWindow", (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 215);
        stop();
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    private void m24223a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_banner, this, true);
        ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.banner_viewpager);
        this.f31687h = viewPager;
        viewPager.setOnPageChangeListener(this);
        this.f31687h.setPageMargin(this.f31700u);
        this.f31687h.setOffscreenPageLimit(3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(this.f31697r, 0, this.f31698s, 0);
        this.f31687h.setLayoutParams(layoutParams);
        m24221a();
        this.f31688i = (LinearLayout) inflate.findViewById(R.id.banner_indicator_ll);
    }

    /* renamed from: a */
    private void m24224a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.Banner);
        this.f31696q = obtainStyledAttributes.getBoolean(3, true);
        this.f31697r = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.f31698s = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.f31699t = obtainStyledAttributes.getBoolean(4, true);
        this.f31700u = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.f31694o = obtainStyledAttributes.getBoolean(0, false);
        this.f31701v = FitType.values()[obtainStyledAttributes.getInt(2, 0)];
        this.f31702w = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m24221a() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.f31687h, new C11097b(this.f31685f, 800));
        } catch (Exception e) {
            SystemUtils.log(6, f31680c, e.getMessage(), (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 260);
        }
    }

    public void setDatas(List<String> list) {
        if (list != null && !list.isEmpty() && !list.isEmpty()) {
            if (this.f31693n.isEmpty() || m24225a(this.f31693n, list)) {
                this.f31693n.clear();
                this.f31693n.addAll(list);
                this.f31692m = list.size();
                C11096a aVar = new C11096a(this, list, this.f31699t);
                this.f31686g = aVar;
                aVar.f31704a = this.f31702w;
                this.f31686g.f31705b = this.f31701v;
                this.f31687h.setAdapter(this.f31686g);
                m24227b();
                if (this.f31692m <= 1 || !this.f31699t) {
                    this.f31691l = 0;
                } else {
                    this.f31687h.setCurrentItem(1, false);
                    this.f31691l = 1;
                }
                start();
                return;
            }
            SystemUtils.log(3, f31680c, "The data list is not changed.", (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 279);
            this.f31687h.requestLayout();
            start();
        }
    }

    /* renamed from: b */
    private void m24227b() {
        this.f31689j.clear();
        this.f31688i.removeAllViews();
        if (this.f31692m <= 1 || !this.f31696q) {
            this.f31688i.setVisibility(8);
            return;
        }
        this.f31688i.setVisibility(0);
        m24228c();
    }

    /* renamed from: c */
    private void m24228c() {
        for (int i = 0; i < this.f31692m; i++) {
            ImageView imageView = new ImageView(this.f31685f);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            int dip2px = UiUtils.dip2px(this.f31685f, 7.0f);
            int dip2px2 = UiUtils.dip2px(this.f31685f, 7.0f);
            int dip2px3 = UiUtils.dip2px(this.f31685f, 5.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px2);
            layoutParams.leftMargin = dip2px3;
            layoutParams.rightMargin = dip2px3;
            if (i == 0) {
                imageView.setImageResource(R.drawable.banner_indicator_gray_dot);
            } else {
                imageView.setImageResource(R.drawable.banner_indicator_white_dot);
            }
            this.f31688i.addView(imageView, layoutParams);
            this.f31689j.add(imageView);
        }
    }

    /* renamed from: a */
    private void m24222a(int i, int i2) {
        if (this.f31688i.getVisibility() == 0) {
            List<ImageView> list = this.f31689j;
            int i3 = this.f31692m;
            list.get(((i + i3) - 1) % i3).setImageResource(R.drawable.banner_indicator_white_dot);
            List<ImageView> list2 = this.f31689j;
            int i4 = this.f31692m;
            list2.get(((i2 + i4) - 1) % i4).setImageResource(R.drawable.banner_indicator_gray_dot);
        }
    }

    public void setBannerClickListener(OnBannerClickListener onBannerClickListener) {
        this.f31683a = onBannerClickListener;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f31684b = onPageChangeListener;
    }

    public int getCurrentPageIndex() {
        return m24219a(this.f31691l);
    }

    public void start() {
        SystemUtils.log(3, f31680c, "start", (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 383);
        this.f31690k.removeCallbacks(this.f31703x);
        if (this.f31694o) {
            this.f31690k.postDelayed(this.f31703x, this.f31695p);
        }
    }

    public void stop() {
        SystemUtils.log(3, f31680c, "stop", (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 394);
        this.f31690k.removeCallbacks(this.f31703x);
    }

    private void setCheatCurrentItem(int i) {
        if (this.f31699t) {
            if (i == 0) {
                this.f31687h.setCurrentItem(this.f31692m, false);
            } else if (i == this.f31692m + 1) {
                this.f31687h.setCurrentItem(1, false);
            }
        }
    }

    /* renamed from: d */
    private void m24231d() {
        SystemUtils.log(3, f31680c, "release", (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 416);
        stop();
        this.f31683a = null;
        this.f31684b = null;
        this.f31689j.clear();
        this.f31688i.removeAllViews();
    }

    /* renamed from: a */
    private boolean m24225a(List<String> list, List<String> list2) {
        if (list.size() != list2.size()) {
            return true;
        }
        for (String indexOf : list) {
            if (list2.indexOf(indexOf) == -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private int m24219a(int i) {
        if (!this.f31699t) {
            return i;
        }
        if (this.f31693n.size() <= 1) {
            return 0;
        }
        int i2 = this.f31692m;
        return ((i + i2) - 1) % i2;
    }

    public void setDefaultDrawable(int i) {
        C11096a aVar = this.f31686g;
        if (aVar != null) {
            aVar.mo86159a(i);
        }
    }
}
