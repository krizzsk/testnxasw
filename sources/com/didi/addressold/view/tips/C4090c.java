package com.didi.addressold.view.tips;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.didi.addressold.view.tips.c */
/* compiled from: TipsWithLine */
class C4090c implements C4088a {

    /* renamed from: B */
    private static final String f9854B = "\\{[^}]*\\}";

    /* renamed from: A */
    private View.OnLayoutChangeListener f9855A = new TipsWithLine$2(this);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TipsView f9856a;

    /* renamed from: b */
    private TipsLineView f9857b;

    /* renamed from: c */
    private ImageView f9858c;

    /* renamed from: d */
    private View f9859d;

    /* renamed from: e */
    private Context f9860e;

    /* renamed from: f */
    private int f9861f;

    /* renamed from: g */
    private int f9862g;

    /* renamed from: h */
    private int f9863h;

    /* renamed from: i */
    private int f9864i;

    /* renamed from: j */
    private int f9865j;

    /* renamed from: k */
    private TipsContainer f9866k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f9867l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f9868m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f9869n = false;

    /* renamed from: o */
    private float f9870o;

    /* renamed from: p */
    private int f9871p;

    /* renamed from: q */
    private int f9872q;

    /* renamed from: r */
    private int f9873r;

    /* renamed from: s */
    private int f9874s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C4089b f9875t;

    /* renamed from: u */
    private long f9876u;

    /* renamed from: v */
    private String f9877v;

    /* renamed from: w */
    private CountDownTimer f9878w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public Point f9879x;

    /* renamed from: y */
    private boolean f9880y = false;

    /* renamed from: z */
    private ViewTreeObserver.OnGlobalLayoutListener f9881z = new TipsWithLine$1(this);

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m8592c() {
        if (this.f9859d != null && !this.f9880y) {
            this.f9880y = true;
            this.f9859d.getViewTreeObserver().addOnGlobalLayoutListener(this.f9881z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public synchronized void m8597d() {
        this.f9880y = false;
        if (this.f9859d != null) {
            this.f9859d.getViewTreeObserver().removeGlobalOnLayoutListener(this.f9881z);
        }
    }

    public C4090c(Context context, TipsContainer tipsContainer) {
        this.f9860e = context;
        this.f9866k = tipsContainer;
        this.f9870o = context.getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    public void mo44857a(View view, TipsView tipsView) {
        this.f9859d = view;
        this.f9856a = tipsView;
        Rect rect = new Rect();
        ((Activity) this.f9860e).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.f9875t = new C4089b(this.f9859d, rect.top);
    }

    /* renamed from: a */
    public void mo44861a(long j, String str) {
        this.f9876u = j;
        this.f9877v = str;
    }

    /* renamed from: a */
    public void mo44856a(int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6 = i3;
        this.f9867l = false;
        this.f9862g = i;
        this.f9861f = i2;
        this.f9863h = i4;
        this.f9864i = i5;
        this.f9865j = i6;
        this.f9869n = true;
        View view = this.f9859d;
        if (view != null) {
            view.addOnLayoutChangeListener(this.f9855A);
            this.f9855A.onLayoutChange(this.f9859d, 0, 0, 0, 0, 0, 0, 0, 0);
        }
        Point a = this.f9875t.mo44860a(i4, i5, 0, 0, (int) ((this.f9870o * 25.0f) + 0.5f), i, i2);
        float f = this.f9870o;
        this.f9871p = (int) ((5.0f * f) + 0.5f);
        int i7 = (int) ((((float) i6) * f) + 0.5f);
        this.f9872q = i7;
        int i8 = (int) ((f * 6.0f) + 0.5f);
        this.f9873r = i8;
        this.f9874s = i7 - i8;
        this.f9857b = new TipsLineView(this.f9860e);
        m8582a(a.x - (this.f9871p / 2), a.y - this.f9874s, this.f9871p, this.f9872q - this.f9873r);
        int i9 = (int) ((this.f9870o * 12.0f) + 0.5f);
        m8593c(a.x - (i9 / 2), a.y, i9, i9);
    }

    /* renamed from: a */
    public boolean mo44858a() {
        return this.f9867l;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m8598e() {
        Point a = this.f9875t.mo44860a(this.f9863h, this.f9864i, 0, 0, (int) ((this.f9870o * 25.0f) + 0.5f), this.f9862g, this.f9861f);
        Point point = this.f9879x;
        if (point != null && point.y == a.y && this.f9879x.x == a.x) {
            m8597d();
        }
        this.f9879x = a;
        m8583a(new Point(a.x - (this.f9871p / 2), a.y - this.f9874s));
        m8588b(new Point(a.x - (((int) ((this.f9870o * 12.0f) + 0.5f)) / 2), a.y));
        TipsView tipsView = this.f9856a;
        tipsView.measure(0, 0);
        Point a2 = this.f9875t.mo44860a(this.f9863h, this.f9873r + (this.f9864i - this.f9874s), tipsView.getMeasuredWidth(), tipsView.getMeasuredHeight(), 0, this.f9862g, this.f9861f);
        if (a2.x < 0) {
            a2.x = 0;
        }
        if (a2.y < 0) {
            a2.y = 0;
        }
        a2.x += this.f9856a.getLeftMargin();
        a2.y += this.f9856a.getTopMargin();
        m8594c(a2);
    }

    /* renamed from: a */
    private void m8583a(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f9857b.getLayoutParams();
        layoutParams.topMargin = point.y;
        layoutParams.leftMargin = point.x;
        this.f9857b.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m8588b(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f9858c.getLayoutParams();
        layoutParams.topMargin = point.y;
        layoutParams.leftMargin = point.x;
        this.f9858c.setLayoutParams(layoutParams);
    }

    /* renamed from: c */
    private void m8594c(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f9856a.getLayoutParams();
        layoutParams.topMargin = point.y;
        layoutParams.leftMargin = point.x;
        this.f9856a.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private void m8582a(int i, int i2, int i3, int i4) {
        TipsLineView tipsLineView = this.f9857b;
        tipsLineView.setEnterAnimatorListener(new TipsWithLine$3(this, tipsLineView));
        tipsLineView.setExitAnimatorLiener(new TipsWithLine$4(this));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.f9866k.addView((View) tipsLineView, layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m8600f() {
        TipsView tipsView = this.f9856a;
        tipsView.measure(0, 0);
        int measuredWidth = tipsView.getMeasuredWidth();
        int measuredHeight = tipsView.getMeasuredHeight();
        Point a = this.f9875t.mo44860a(this.f9863h, (this.f9864i - this.f9874s) + this.f9873r, measuredWidth, measuredHeight, 0, this.f9862g, this.f9861f);
        if (a.x < 0) {
            a.x = 0;
        }
        if (a.y < 0) {
            a.y = 0;
        }
        m8587b(a.x, a.y, measuredWidth, measuredHeight);
        tipsView.setPosGone();
        tipsView.attachContainer(this.f9866k);
        tipsView.showEnterAnim();
        m8604h();
    }

    /* renamed from: g */
    private boolean m8603g() {
        return this.f9876u > 0 && !TextUtil.isEmpty(this.f9877v);
    }

    /* renamed from: h */
    private void m8604h() {
        CountDownTimer countDownTimer = this.f9878w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (m8603g()) {
            TipsWithLine$5 tipsWithLine$5 = new TipsWithLine$5(this, 1000 * (this.f9876u + 1), 1000);
            this.f9878w = tipsWithLine$5;
            tipsWithLine$5.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8590b(String str) {
        try {
            if (this.f9856a != null && !TextUtil.isEmpty(this.f9877v)) {
                this.f9856a.updateContent(m8581a(this.f9877v.replace(InvitationTrackFragment.INVITE_DATE, str)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m8587b(int i, int i2, int i3, int i4) {
        TipsView tipsView = this.f9856a;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i + tipsView.getLeftMargin(), i2 + tipsView.getTopMargin(), tipsView.getRightMargin(), tipsView.getBottomMargin());
        this.f9866k.addView((View) tipsView, layoutParams);
    }

    /* renamed from: c */
    private void m8593c(int i, int i2, int i3, int i4) {
        ImageView imageView = new ImageView(this.f9860e);
        this.f9858c = imageView;
        imageView.setImageResource(R.drawable.tips_guide_ring);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.f9866k.addView((View) imageView, layoutParams);
    }

    /* renamed from: b */
    public void mo44859b() {
        if (!this.f9867l) {
            View view = this.f9859d;
            if (view != null) {
                view.removeOnLayoutChangeListener(this.f9855A);
            }
            m8597d();
            this.f9867l = true;
            TipsContainer tipsContainer = this.f9866k;
            if (tipsContainer != null) {
                tipsContainer.clear();
            }
            CountDownTimer countDownTimer = this.f9878w;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f9878w = null;
        }
    }

    /* renamed from: a */
    public static CharSequence m8581a(String str) {
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
