package com.didi.app.nova.support.view.recyclerview.view.layoutmanager;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.taxis99.R;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.app.nova.support.view.recyclerview.view.layoutmanager.b */
/* compiled from: StickyHeaderPositioner */
final class C4347b {

    /* renamed from: a */
    static final int f10485a = -1;

    /* renamed from: b */
    static final int f10486b = 5;

    /* renamed from: c */
    private static final int f10487c = -1;

    /* renamed from: d */
    private final NovaRecyclerView f10488d;

    /* renamed from: e */
    private final boolean f10489e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FrameLayout f10490f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public View f10491g;

    /* renamed from: h */
    private int f10492h = -1;

    /* renamed from: i */
    private List<Integer> f10493i;

    /* renamed from: j */
    private int f10494j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f10495k;

    /* renamed from: l */
    private float f10496l = -1.0f;

    /* renamed from: m */
    private int f10497m = -1;

    /* renamed from: n */
    private RecyclerView.ViewHolder f10498n;

    C4347b(RecyclerView recyclerView) {
        this.f10488d = (NovaRecyclerView) recyclerView;
        this.f10489e = m9182j();
        this.f10490f = (FrameLayout) m9183k().findViewById(R.id.header_container);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo46305a(List<Integer> list) {
        this.f10493i = list;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo46303a(int i, Map<Integer, View> map, ViewRetriever viewRetriever) {
        int a = m9156a(i, map.get(Integer.valueOf(i)));
        View view = map.get(Integer.valueOf(a));
        if (a != this.f10492h) {
            if (a == -1 || (this.f10489e && m9173e(view))) {
                this.f10495k = true;
                m9184l();
                this.f10492h = -1;
            } else {
                this.f10492h = a;
                mo46304a(viewRetriever.getViewHolderForPosition(a), a);
            }
        } else if (this.f10489e && m9173e(view)) {
            m9181i();
            this.f10492h = -1;
        }
        mo46306a(map);
        this.f10488d.post(new StickyHeaderPositioner$1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo46306a(Map<Integer, View> map) {
        boolean z;
        View view = this.f10491g;
        if (view != null) {
            if (view.getHeight() == 0) {
                m9163b(map);
                return;
            }
            Iterator<Map.Entry<Integer, View>> it = map.entrySet().iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (((Integer) next.getKey()).intValue() > this.f10492h) {
                    if (m9155a((View) next.getValue()) != -1.0f) {
                        z = false;
                    }
                }
            }
            if (z) {
                m9162b();
            }
            this.f10491g.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo46302a(int i) {
        if (i != -1) {
            this.f10497m = i;
            return;
        }
        this.f10496l = -1.0f;
        this.f10497m = -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo46307b(int i) {
        this.f10494j = i;
        this.f10492h = -1;
        this.f10495k = true;
        m9184l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo46301a() {
        m9181i();
    }

    /* renamed from: a */
    private float m9155a(View view) {
        if (!m9164b(view)) {
            return -1.0f;
        }
        if (this.f10494j == 1) {
            float f = -(((float) this.f10491g.getHeight()) - view.getY());
            this.f10491g.setTranslationY(f);
            return f;
        }
        float f2 = -(((float) this.f10491g.getWidth()) - view.getX());
        this.f10491g.setTranslationX(f2);
        return f2;
    }

    /* renamed from: b */
    private boolean m9164b(View view) {
        if (this.f10494j == 1) {
            if (view.getY() < ((float) this.f10491g.getHeight())) {
                return true;
            }
            return false;
        } else if (view.getX() < ((float) this.f10491g.getWidth())) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    private void m9162b() {
        if (this.f10494j == 1) {
            this.f10491g.setTranslationY(0.0f);
        } else {
            this.f10491g.setTranslationX(0.0f);
        }
    }

    /* renamed from: a */
    private int m9156a(int i, View view) {
        int indexOf;
        if (m9168c(view) && (indexOf = this.f10493i.indexOf(Integer.valueOf(i))) > 0) {
            return this.f10493i.get(indexOf - 1).intValue();
        }
        int i2 = -1;
        for (Integer next : this.f10493i) {
            if (next.intValue() > i) {
                break;
            }
            i2 = next.intValue();
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m9168c(android.view.View r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x001b
            int r1 = r4.f10494j
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x0012
            float r5 = r5.getY()
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x001b
            goto L_0x001a
        L_0x0012:
            float r5 = r5.getX()
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x001b
        L_0x001a:
            r0 = 1
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.app.nova.support.view.recyclerview.view.layoutmanager.C4347b.m9168c(android.view.View):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo46304a(RecyclerView.ViewHolder viewHolder, int i) {
        if (this.f10498n == viewHolder) {
            this.f10488d.getAdapter().onBindViewHolder(this.f10498n, i);
            this.f10498n.itemView.requestLayout();
            m9172e();
            this.f10495k = false;
            return;
        }
        m9181i();
        this.f10498n = viewHolder;
        this.f10488d.getAdapter().onBindViewHolder(this.f10498n, i);
        View view = this.f10498n.itemView;
        this.f10491g = view;
        m9157a(view.getContext());
        this.f10491g.setVisibility(4);
        this.f10491g.setId(R.id.header_view);
        if (this.f10490f == null) {
            FrameLayout frameLayout = new FrameLayout(this.f10488d.getContext());
            this.f10490f = frameLayout;
            frameLayout.setId(R.id.header_container);
            m9183k().addView(this.f10490f, new ViewGroup.LayoutParams(-1, -2));
        }
        this.f10490f.addView(this.f10491g);
        if (this.f10489e) {
            m9170d(this.f10491g);
        }
        this.f10495k = false;
        this.f10490f.post(new StickyHeaderPositioner$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m9165c() {
        View view = this.f10491g;
        if (view == null) {
            return 0;
        }
        if (this.f10494j == 1) {
            return view.getHeight();
        }
        return view.getWidth();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m9171d() {
        View view = this.f10491g;
        if (view == null) {
            return false;
        }
        if (this.f10494j == 1) {
            if (view.getTranslationY() < 0.0f) {
                return true;
            }
            return false;
        } else if (view.getTranslationX() < 0.0f) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9167c(int i) {
        View view = this.f10491g;
        if (view != null) {
            if (this.f10494j == 1) {
                view.setTranslationY(view.getTranslationY() + ((float) i));
            } else {
                view.setTranslationX(view.getTranslationX() + ((float) i));
            }
        }
    }

    /* renamed from: e */
    private void m9172e() {
        View view = this.f10491g;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new StickyHeaderPositioner$3(this, view));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m9176f() {
        View view;
        if (this.f10496l != -1.0f && (view = this.f10491g) != null) {
            if ((this.f10494j == 1 && view.getTranslationY() == 0.0f) || (this.f10494j == 0 && this.f10491g.getTranslationX() == 0.0f)) {
                m9177g();
            } else {
                m9179h();
            }
        }
    }

    /* renamed from: g */
    private void m9177g() {
        if (Build.VERSION.SDK_INT >= 21 && this.f10491g.getTag() == null) {
            this.f10491g.setTag(true);
            this.f10491g.animate().z(this.f10496l);
        }
    }

    /* renamed from: h */
    private void m9179h() {
        if (Build.VERSION.SDK_INT >= 21 && this.f10491g.getTag() != null) {
            this.f10491g.setTag((Object) null);
            this.f10491g.animate().z(0.0f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m9181i() {
        FrameLayout frameLayout;
        View view = this.f10491g;
        if (view != null && (frameLayout = this.f10490f) != null) {
            frameLayout.removeView(view);
            this.f10491g = null;
            this.f10498n = null;
        }
    }

    /* renamed from: d */
    private void m9170d(View view) {
        m9158a((ViewGroup.MarginLayoutParams) view.getLayoutParams());
    }

    /* renamed from: a */
    private void m9158a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        int i;
        int paddingLeft = this.f10494j == 1 ? this.f10488d.getPaddingLeft() : 0;
        if (this.f10494j == 1) {
            i = 0;
        } else {
            i = this.f10488d.getPaddingTop();
        }
        marginLayoutParams.setMargins(paddingLeft, i, this.f10494j == 1 ? this.f10488d.getPaddingRight() : 0, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m9173e(android.view.View r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x001b
            int r1 = r4.f10494j
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x0012
            float r5 = r5.getY()
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x001b
            goto L_0x001a
        L_0x0012:
            float r5 = r5.getX()
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x001b
        L_0x001a:
            r0 = 1
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.app.nova.support.view.recyclerview.view.layoutmanager.C4347b.m9173e(android.view.View):boolean");
    }

    /* renamed from: j */
    private boolean m9182j() {
        return this.f10488d.getPaddingLeft() > 0 || this.f10488d.getPaddingRight() > 0 || this.f10488d.getPaddingTop() > 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public ViewGroup m9183k() {
        return (ViewGroup) this.f10488d.getParent();
    }

    /* renamed from: b */
    private void m9163b(Map<Integer, View> map) {
        View view = this.f10491g;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new StickyHeaderPositioner$4(this, view, map));
        }
    }

    /* renamed from: l */
    private void m9184l() {
        if (m9183k() != null) {
            m9183k().post(new StickyHeaderPositioner$5(this));
        }
    }

    /* renamed from: a */
    private void m9157a(Context context) {
        int i = this.f10497m;
        if (i != -1 && this.f10496l == -1.0f) {
            this.f10496l = m9154a(context, i);
        }
    }

    /* renamed from: a */
    private float m9154a(Context context, int i) {
        return ((float) i) * context.getResources().getDisplayMetrics().density;
    }
}
