package com.didi.sdk.view.tips;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.didi.sdk.view.tips.c */
/* compiled from: TipsWithLine */
class C14097c implements C14095a {

    /* renamed from: B */
    private static final String f40987B = "\\{[^}]*\\}";

    /* renamed from: A */
    private View.OnLayoutChangeListener f40988A = new TipsWithLine$2(this);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TipsView f40989a;

    /* renamed from: b */
    private TipsLineView f40990b;

    /* renamed from: c */
    private ImageView f40991c;

    /* renamed from: d */
    private View f40992d;

    /* renamed from: e */
    private Context f40993e;

    /* renamed from: f */
    private int f40994f;

    /* renamed from: g */
    private int f40995g;

    /* renamed from: h */
    private int f40996h;

    /* renamed from: i */
    private int f40997i;

    /* renamed from: j */
    private int f40998j;

    /* renamed from: k */
    private TipsContainer f40999k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f41000l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f41001m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f41002n = false;

    /* renamed from: o */
    private float f41003o;

    /* renamed from: p */
    private int f41004p;

    /* renamed from: q */
    private int f41005q;

    /* renamed from: r */
    private int f41006r;

    /* renamed from: s */
    private int f41007s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C14096b f41008t;

    /* renamed from: u */
    private long f41009u;

    /* renamed from: v */
    private String f41010v;

    /* renamed from: w */
    private CountDownTimer f41011w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public Point f41012x;

    /* renamed from: y */
    private boolean f41013y = false;

    /* renamed from: z */
    private ViewTreeObserver.OnGlobalLayoutListener f41014z = new TipsWithLine$1(this);

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m30732c() {
        if (this.f40992d != null && !this.f41013y) {
            this.f41013y = true;
            this.f40992d.getViewTreeObserver().addOnGlobalLayoutListener(this.f41014z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public synchronized void m30737d() {
        this.f41013y = false;
        if (this.f40992d != null) {
            this.f40992d.getViewTreeObserver().removeGlobalOnLayoutListener(this.f41014z);
        }
    }

    public C14097c(Context context, TipsContainer tipsContainer) {
        this.f40993e = context;
        this.f40999k = tipsContainer;
        this.f41003o = context.getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    public void mo104337a(View view, TipsView tipsView) {
        this.f40992d = view;
        this.f40989a = tipsView;
        Rect rect = new Rect();
        ((Activity) this.f40993e).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.f41008t = new C14096b(this.f40992d, rect.top);
    }

    /* renamed from: a */
    public void mo104341a(long j, String str) {
        this.f41009u = j;
        this.f41010v = str;
    }

    /* renamed from: a */
    public void mo104336a(int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6 = i3;
        this.f41000l = false;
        this.f40995g = i;
        this.f40994f = i2;
        this.f40996h = i4;
        this.f40997i = i5;
        this.f40998j = i6;
        this.f41002n = true;
        View view = this.f40992d;
        if (view != null) {
            view.addOnLayoutChangeListener(this.f40988A);
            this.f40988A.onLayoutChange(this.f40992d, 0, 0, 0, 0, 0, 0, 0, 0);
        }
        Point a = this.f41008t.mo104340a(i4, i5, 0, 0, (int) ((this.f41003o * 25.0f) + 0.5f), i, i2);
        float f = this.f41003o;
        this.f41004p = (int) ((5.0f * f) + 0.5f);
        int i7 = (int) ((((float) i6) * f) + 0.5f);
        this.f41005q = i7;
        int i8 = (int) ((f * 6.0f) + 0.5f);
        this.f41006r = i8;
        this.f41007s = i7 - i8;
        this.f40990b = new TipsLineView(this.f40993e);
        m30722a(a.x - (this.f41004p / 2), a.y - this.f41007s, this.f41004p, this.f41005q - this.f41006r);
        int i9 = (int) ((this.f41003o * 12.0f) + 0.5f);
        m30733c(a.x - (i9 / 2), a.y, i9, i9);
    }

    /* renamed from: a */
    public boolean mo104338a() {
        return this.f41000l;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m30738e() {
        Point a = this.f41008t.mo104340a(this.f40996h, this.f40997i, 0, 0, (int) ((this.f41003o * 25.0f) + 0.5f), this.f40995g, this.f40994f);
        Point point = this.f41012x;
        if (point != null && point.y == a.y && this.f41012x.x == a.x) {
            m30737d();
        }
        this.f41012x = a;
        m30723a(new Point(a.x - (this.f41004p / 2), a.y - this.f41007s));
        m30728b(new Point(a.x - (((int) ((this.f41003o * 12.0f) + 0.5f)) / 2), a.y));
        TipsView tipsView = this.f40989a;
        tipsView.measure(0, 0);
        Point a2 = this.f41008t.mo104340a(this.f40996h, this.f41006r + (this.f40997i - this.f41007s), tipsView.getMeasuredWidth(), tipsView.getMeasuredHeight(), 0, this.f40995g, this.f40994f);
        if (a2.x < 0) {
            a2.x = 0;
        }
        if (a2.y < 0) {
            a2.y = 0;
        }
        a2.x += this.f40989a.getLeftMargin();
        a2.y += this.f40989a.getTopMargin();
        m30734c(a2);
    }

    /* renamed from: a */
    private void m30723a(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f40990b.getLayoutParams();
        layoutParams.topMargin = point.y;
        layoutParams.leftMargin = point.x;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
        }
        this.f40990b.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m30728b(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f40991c.getLayoutParams();
        layoutParams.topMargin = point.y;
        layoutParams.leftMargin = point.x;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
        }
        this.f40991c.setLayoutParams(layoutParams);
    }

    /* renamed from: c */
    private void m30734c(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f40989a.getLayoutParams();
        layoutParams.topMargin = point.y;
        layoutParams.leftMargin = point.x;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
        }
        this.f40989a.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private void m30722a(int i, int i2, int i3, int i4) {
        TipsLineView tipsLineView = this.f40990b;
        tipsLineView.setEnterAnimatorListener(new TipsWithLine$3(this, tipsLineView));
        tipsLineView.setExitAnimatorLiener(new TipsWithLine$4(this));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        this.f40999k.addView((View) tipsLineView, (ViewGroup.LayoutParams) layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m30740f() {
        TipsView tipsView = this.f40989a;
        tipsView.measure(0, 0);
        int measuredWidth = tipsView.getMeasuredWidth();
        int measuredHeight = tipsView.getMeasuredHeight();
        Point a = this.f41008t.mo104340a(this.f40996h, (this.f40997i - this.f41007s) + this.f41006r, measuredWidth, measuredHeight, 0, this.f40995g, this.f40994f);
        if (a.x < 0) {
            a.x = 0;
        }
        if (a.y < 0) {
            a.y = 0;
        }
        m30727b(a.x, a.y, measuredWidth, measuredHeight);
        tipsView.setPosGone();
        tipsView.attachContainer(this.f40999k);
        tipsView.showEnterAnim();
        m30744h();
    }

    /* renamed from: g */
    private boolean m30743g() {
        return this.f41009u > 0 && !TextUtil.isEmpty(this.f41010v);
    }

    /* renamed from: h */
    private void m30744h() {
        CountDownTimer countDownTimer = this.f41011w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (m30743g()) {
            TipsWithLine$5 tipsWithLine$5 = new TipsWithLine$5(this, 1000 * (this.f41009u + 1), 1000);
            this.f41011w = tipsWithLine$5;
            tipsWithLine$5.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m30730b(String str) {
        try {
            if (this.f40989a != null && !TextUtil.isEmpty(this.f41010v)) {
                this.f40989a.updateContent(m30721a(this.f41010v.replace(InvitationTrackFragment.INVITE_DATE, str)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m30727b(int i, int i2, int i3, int i4) {
        TipsView tipsView = this.f40989a;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i + tipsView.getLeftMargin(), i2 + tipsView.getTopMargin(), tipsView.getRightMargin(), tipsView.getBottomMargin());
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        this.f40999k.addView((View) tipsView, (ViewGroup.LayoutParams) layoutParams);
    }

    /* renamed from: c */
    private void m30733c(int i, int i2, int i3, int i4) {
        ImageView imageView = new ImageView(this.f40993e);
        this.f40991c = imageView;
        imageView.setImageResource(R.drawable.tips_guide_ring);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        this.f40999k.addView((View) imageView, (ViewGroup.LayoutParams) layoutParams);
    }

    /* renamed from: b */
    public void mo104339b() {
        if (!this.f41000l) {
            View view = this.f40992d;
            if (view != null) {
                view.removeOnLayoutChangeListener(this.f40988A);
            }
            m30737d();
            this.f41000l = true;
            TipsContainer tipsContainer = this.f40999k;
            if (tipsContainer != null) {
                tipsContainer.clear();
            }
            CountDownTimer countDownTimer = this.f41011w;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f41011w = null;
        }
    }

    /* renamed from: a */
    public static CharSequence m30721a(String str) {
        Matcher matcher = Pattern.compile("\\{[^}]*\\}").matcher(str);
        Stack stack = new Stack();
        while (matcher.find()) {
            stack.push(new Point(matcher.start(), matcher.end()));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int parseColor = Color.parseColor("#FC9153");
        while (stack.size() > 0) {
            Point point = (Point) stack.pop();
            spannableStringBuilder.delete(point.x, point.x + 1);
            spannableStringBuilder.delete(point.y - 2, point.y - 1);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), point.x, point.y - 2, 18);
        }
        return spannableStringBuilder;
    }
}
