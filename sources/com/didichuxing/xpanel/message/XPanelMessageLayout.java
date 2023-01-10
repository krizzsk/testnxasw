package com.didichuxing.xpanel.message;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class XPanelMessageLayout extends FrameLayout implements IXPanelMessageContainer {
    public static final String TAG = "XPanelMessageLayout";

    /* renamed from: a */
    static volatile boolean f52116a = false;

    /* renamed from: b */
    private static final int f52117b = 1;

    /* renamed from: c */
    private static final int f52118c = 2;

    /* renamed from: i */
    private static final int f52119i = 300;

    /* renamed from: d */
    private IMessageDataListener f52120d;

    /* renamed from: e */
    private IMessageAnimationListener f52121e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f52122f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f52123g = false;

    /* renamed from: h */
    private boolean f52124h = false;

    /* renamed from: j */
    private final int f52125j = 1000;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f52126k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public XPanelMessageItem f52127l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public XPanelMessageItem f52128m;

    /* renamed from: n */
    private View f52129n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Handler f52130o = new Handler(Looper.getMainLooper());

    /* renamed from: p */
    private AnimatorSet f52131p = new AnimatorSet();

    /* renamed from: q */
    private ValueAnimator f52132q;

    /* renamed from: r */
    private ValueAnimator f52133r;

    /* renamed from: s */
    private ValueAnimator f52134s;

    /* renamed from: t */
    private ValueAnimator f52135t;

    /* renamed from: u */
    private ValueAnimator f52136u;

    /* renamed from: v */
    private LinkedList<XPanelMessageItem> f52137v = new LinkedList<>();

    public interface IMessageAnimationListener {
        void messageAnimating();

        void messageAnimationEnd();
    }

    public View getView() {
        return this;
    }

    public XPanelMessageLayout(Context context) {
        super(context);
        setBackgroundResource(R.drawable.message_bg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addMessageItem(com.didichuxing.xpanel.message.XPanelMessageItem r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x0020
            android.view.View r0 = r2.getContentView()     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0020
            java.util.LinkedList<com.didichuxing.xpanel.message.XPanelMessageItem> r0 = r1.f52137v     // Catch:{ all -> 0x001d }
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0012
            goto L_0x0020
        L_0x0012:
            java.util.LinkedList<com.didichuxing.xpanel.message.XPanelMessageItem> r0 = r1.f52137v     // Catch:{ all -> 0x001d }
            r0.add(r2)     // Catch:{ all -> 0x001d }
            r2 = 1
            r1.m39219a((int) r2)     // Catch:{ all -> 0x001d }
            monitor-exit(r1)
            return
        L_0x001d:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0020:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.message.XPanelMessageLayout.addMessageItem(com.didichuxing.xpanel.message.XPanelMessageItem):void");
    }

    public void setMessageDataListener(IMessageDataListener iMessageDataListener) {
        this.f52120d = iMessageDataListener;
    }

    public synchronized void removeMessageItem(XPanelMessageItem xPanelMessageItem) {
        m39221a(xPanelMessageItem);
    }

    /* renamed from: a */
    private void m39221a(XPanelMessageItem xPanelMessageItem) {
        m39219a(2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39219a(int i) {
        if (this.f52122f || this.f52123g) {
            LogcatUtil.m39239i(TAG, "@doAction, waiting...mWait=" + this.f52122f + ", mIsAnimating=" + this.f52123g);
            return;
        }
        this.f52122f = true;
        if (i == 2) {
            if (this.f52127l != null) {
                XPanelMessageItem xPanelMessageItem = this.f52128m;
                if (xPanelMessageItem != null) {
                    m39229c(xPanelMessageItem);
                }
                m39225b(this.f52127l);
                m39220a(i, this.f52128m, this.f52127l);
            }
        } else if (i == 1) {
            ListIterator listIterator = ((LinkedList) this.f52137v.clone()).listIterator(0);
            if (listIterator.hasNext()) {
                XPanelMessageItem xPanelMessageItem2 = (XPanelMessageItem) listIterator.next();
                this.f52137v.remove(xPanelMessageItem2);
                this.f52128m = this.f52127l;
                this.f52127l = xPanelMessageItem2;
                m39229c(xPanelMessageItem2);
                m39220a(i, this.f52127l, this.f52128m);
                return;
            }
            LogcatUtil.m39238e(TAG, "队列里没有新消息...");
            this.f52122f = false;
        }
    }

    /* renamed from: a */
    private void m39220a(final int i, XPanelMessageItem xPanelMessageItem, XPanelMessageItem xPanelMessageItem2) {
        if (!this.f52124h) {
            m39218a();
        }
        if (xPanelMessageItem == null && xPanelMessageItem2 == null) {
            this.f52123g = false;
            return;
        }
        f52116a = false;
        this.f52123g = true;
        this.f52131p.removeAllListeners();
        this.f52131p.setDuration(300);
        this.f52131p.setInterpolator(new AccelerateInterpolator());
        this.f52131p.addListener(new C17374a() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                boolean unused = XPanelMessageLayout.this.f52123g = false;
                if (i == 2) {
                    XPanelMessageLayout xPanelMessageLayout = XPanelMessageLayout.this;
                    xPanelMessageLayout.removeView(xPanelMessageLayout.f52127l.getContentView());
                    XPanelMessageLayout xPanelMessageLayout2 = XPanelMessageLayout.this;
                    XPanelMessageItem unused2 = xPanelMessageLayout2.f52127l = xPanelMessageLayout2.f52128m;
                } else if (!(XPanelMessageLayout.this.f52128m == null || XPanelMessageLayout.this.f52128m.getContentView() == null)) {
                    XPanelMessageLayout xPanelMessageLayout3 = XPanelMessageLayout.this;
                    xPanelMessageLayout3.removeView(xPanelMessageLayout3.f52128m.getContentView());
                }
                if (XPanelMessageLayout.this.getChildCount() == 0) {
                    int unused3 = XPanelMessageLayout.this.f52126k = 0;
                }
                if (XPanelMessageLayout.this.f52127l != null) {
                    XPanelMessageLayout.this.f52127l.getContentView().setTranslationY(0.0f);
                    if (XPanelMessageLayout.f52116a && XPanelMessageLayout.this.f52127l.getContentView().getBackground() != null) {
                        XPanelMessageLayout.this.f52127l.getContentView().getBackground().setAlpha(255);
                    }
                }
                XPanelMessageLayout.this.f52130o.postDelayed(new Runnable() {
                    public void run() {
                        boolean unused = XPanelMessageLayout.this.f52122f = false;
                        XPanelMessageLayout.this.m39219a(1);
                    }
                }, 1000);
            }
        });
        int i2 = -1;
        int messageType = xPanelMessageItem == null ? -1 : xPanelMessageItem.getMessageType();
        if (xPanelMessageItem2 != null) {
            i2 = xPanelMessageItem2.getMessageType();
        }
        boolean z = xPanelMessageItem2 != null;
        if (i == 2) {
            ArrayList arrayList = new ArrayList();
            if (xPanelMessageItem != null) {
                this.f52133r.addListener(xPanelMessageItem.f52113a);
                this.f52133r.addUpdateListener(xPanelMessageItem.f52113a);
                arrayList.add(this.f52133r);
            }
            if (xPanelMessageItem2 != null) {
                this.f52132q.addListener(xPanelMessageItem2.f52113a);
                this.f52132q.addUpdateListener(xPanelMessageItem2.f52113a);
                arrayList.add(this.f52132q);
            }
            this.f52131p.playTogether(arrayList);
        } else if (i == 1) {
            this.f52133r.addListener(xPanelMessageItem.f52113a);
            this.f52133r.addUpdateListener(xPanelMessageItem.f52113a);
            C17377d dVar = new C17377d(xPanelMessageItem.getContentView());
            this.f52135t.addListener(dVar);
            this.f52135t.addUpdateListener(dVar);
            if (!z) {
                this.f52131p.play(this.f52133r);
            } else if (messageType == i2) {
                f52116a = true;
                if (xPanelMessageItem.getContentView().getBackground() != null) {
                    xPanelMessageItem.getContentView().getBackground().setAlpha(0);
                }
                this.f52134s.addUpdateListener(xPanelMessageItem2.f52113a);
                this.f52134s.addListener(xPanelMessageItem2.f52113a);
                C17377d dVar2 = new C17377d(xPanelMessageItem2.getContentView());
                this.f52136u.addListener(dVar2);
                this.f52136u.addUpdateListener(dVar2);
                this.f52131p.playTogether(new Animator[]{this.f52134s, this.f52133r, this.f52136u, this.f52135t});
            } else {
                this.f52132q.addListener(xPanelMessageItem2.f52113a);
                this.f52132q.addUpdateListener(xPanelMessageItem2.f52113a);
                this.f52131p.playTogether(new Animator[]{this.f52133r, this.f52132q});
            }
        }
        IMessageDataListener iMessageDataListener = this.f52120d;
        if (iMessageDataListener != null) {
            iMessageDataListener.notifyAdd();
        }
        this.f52131p.start();
    }

    /* renamed from: a */
    private void m39218a() {
        this.f52133r = ValueAnimator.ofFloat(new float[]{1.2f, 0.0f});
        this.f52134s = ValueAnimator.ofFloat(new float[]{0.2f, -1.0f});
        this.f52132q = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f52135t = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        this.f52136u = ValueAnimator.ofFloat(new float[]{1.0f, 0.8f});
    }

    /* renamed from: b */
    private synchronized void m39225b(XPanelMessageItem xPanelMessageItem) {
        if (this.f52120d != null) {
            this.f52120d.notifyRemove();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a5, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m39229c(com.didichuxing.xpanel.message.XPanelMessageItem r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "XPanelMessageLayout"
            java.lang.String r1 = "this.setVisibility(View.VISIBLE)...."
            com.didichuxing.xpanel.util.LogcatUtil.m39237d(r0, r1)     // Catch:{ all -> 0x00a6 }
            r0 = 0
            r4.setVisibility(r0)     // Catch:{ all -> 0x00a6 }
            android.view.View r1 = r5.getContentView()     // Catch:{ all -> 0x00a6 }
            r4.f52129n = r1     // Catch:{ all -> 0x00a6 }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0022
            java.lang.String r5 = "XPanelMessageLayout"
            java.lang.String r0 = "The specified child already has a parent."
            com.didichuxing.xpanel.util.LogcatUtil.m39238e(r5, r0)     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return
        L_0x0022:
            android.view.View r5 = r5.getContentView()     // Catch:{ all -> 0x00a6 }
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()     // Catch:{ all -> 0x00a6 }
            if (r5 != 0) goto L_0x0034
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x00a6 }
            r1 = -1
            r2 = -2
            r5.<init>(r1, r2)     // Catch:{ all -> 0x00a6 }
            goto L_0x003e
        L_0x0034:
            boolean r1 = r5 instanceof android.widget.FrameLayout.LayoutParams     // Catch:{ all -> 0x00a6 }
            if (r1 != 0) goto L_0x003e
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x00a6 }
            r1.<init>(r5)     // Catch:{ all -> 0x00a6 }
            r5 = r1
        L_0x003e:
            r1 = r5
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1     // Catch:{ all -> 0x00a6 }
            android.content.Context r2 = r4.getContext()     // Catch:{ all -> 0x00a6 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ all -> 0x00a6 }
            r3 = 2131165184(0x7f070000, float:1.7944578E38)
            int r2 = r2.getDimensionPixelSize(r3)     // Catch:{ all -> 0x00a6 }
            r1.leftMargin = r2     // Catch:{ all -> 0x00a6 }
            r1.rightMargin = r2     // Catch:{ all -> 0x00a6 }
            r1.topMargin = r2     // Catch:{ all -> 0x00a6 }
            r2 = 80
            r1.gravity = r2     // Catch:{ all -> 0x00a6 }
            android.view.View r1 = r4.f52129n     // Catch:{ all -> 0x00a6 }
            r4.addView(r1, r5)     // Catch:{ all -> 0x00a6 }
            int r5 = r4.getMeasuredWidth()     // Catch:{ all -> 0x00a6 }
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)     // Catch:{ all -> 0x00a6 }
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)     // Catch:{ all -> 0x00a6 }
            r4.measure(r5, r0)     // Catch:{ all -> 0x00a6 }
            int r5 = r4.getMeasuredHeight()     // Catch:{ all -> 0x00a6 }
            android.view.View r0 = r4.f52129n     // Catch:{ all -> 0x00a6 }
            int r0 = r0.getMeasuredHeight()     // Catch:{ all -> 0x00a6 }
            r4.f52126k = r0     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = "XPanelMessageLayout"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r1.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = "@doAddCurrent, 消息位高度："
            r1.append(r2)     // Catch:{ all -> 0x00a6 }
            r1.append(r5)     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = ", 新增消息位高度："
            r1.append(r5)     // Catch:{ all -> 0x00a6 }
            int r5 = r4.f52126k     // Catch:{ all -> 0x00a6 }
            r1.append(r5)     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x00a6 }
            com.didichuxing.xpanel.util.LogcatUtil.m39237d(r0, r5)     // Catch:{ all -> 0x00a6 }
            com.didichuxing.xpanel.message.IMessageDataListener r5 = r4.f52120d     // Catch:{ all -> 0x00a6 }
            if (r5 == 0) goto L_0x00a4
            com.didichuxing.xpanel.message.IMessageDataListener r5 = r4.f52120d     // Catch:{ all -> 0x00a6 }
            r5.notifyAdd()     // Catch:{ all -> 0x00a6 }
        L_0x00a4:
            monitor-exit(r4)
            return
        L_0x00a6:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.message.XPanelMessageLayout.m39229c(com.didichuxing.xpanel.message.XPanelMessageItem):void");
    }

    public int getCurrentHeight() {
        if (getChildCount() == 0) {
            return 0;
        }
        return this.f52129n.getMeasuredHeight();
    }

    /* renamed from: b */
    private void m39224b() {
        IMessageAnimationListener iMessageAnimationListener = this.f52121e;
        if (iMessageAnimationListener != null) {
            iMessageAnimationListener.messageAnimationEnd();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }
}
