package com.didi.reactive.tracker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class EventTracker {

    /* renamed from: C */
    private static boolean f35889C = false;

    /* renamed from: D */
    private static Initializer f35890D = null;
    public static final int MODE_DEV = 0;
    public static final int MODE_ONLINE = 10;

    /* renamed from: a */
    private static final String f35891a = "EventTracker";

    /* renamed from: b */
    private static final long f35892b = 300;

    /* renamed from: c */
    private static EvictingQueue f35893c = new EvictingQueue(256);

    /* renamed from: d */
    private static final int f35894d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static WeakHashMap<Context, Context> f35895e = new WeakHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final WeakHashMap<View, EventTracker> f35896f = new WeakHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final WeakHashMap<View, EventTracker> f35897g = new WeakHashMap<>();

    /* renamed from: h */
    private static final Handler f35898h = new Handler(Looper.getMainLooper());

    /* renamed from: i */
    private static InnerTracker[] f35899i;

    /* renamed from: j */
    private static AttrsGetter f35900j;

    /* renamed from: k */
    private static int f35901k = 10;

    /* renamed from: z */
    private static WeakReference<View> f35902z;

    /* renamed from: A */
    private WeakReference<Object> f35903A;

    /* renamed from: B */
    private long f35904B;

    /* renamed from: l */
    private String f35905l;

    /* renamed from: m */
    private boolean f35906m;

    /* renamed from: n */
    private WeakReference<Object> f35907n;

    /* renamed from: o */
    private int f35908o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f35909p = -1;

    /* renamed from: q */
    private int f35910q = -1;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f35911r = false;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public WeakReference<View> f35912s;

    /* renamed from: t */
    private long f35913t;

    /* renamed from: u */
    private ViewTreeObserver.OnGlobalLayoutListener f35914u;

    /* renamed from: v */
    private Filter f35915v;

    /* renamed from: w */
    private AttrsGetter f35916w;

    /* renamed from: x */
    private Assertor f35917x;

    /* renamed from: y */
    private boolean f35918y = true;

    public interface Initializer {
        AttrsGetter createCommonAttrsGetter();

        InnerTracker[] createInnerTracker();

        int currentModel();

        boolean isEnabled();
    }

    public static boolean isInitialized() {
        return f35889C;
    }

    public static void init(Initializer initializer) {
        f35890D = initializer;
        f35899i = initializer.createInnerTracker();
        f35900j = initializer.createCommonAttrsGetter();
        f35901k = initializer.currentModel();
        f35889C = true;
    }

    private EventTracker(View view) {
        this.f35912s = new WeakReference<>(view);
        if (view != null) {
            this.f35914u = new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (EventTracker.this.f35909p == 1) {
                        EventTracker eventTracker = EventTracker.this;
                        if (!eventTracker.isAttachedToWindow((View) eventTracker.f35912s.get())) {
                            EventTracker.this.m27064a(0);
                        }
                    }
                }
            };
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f35914u);
        }
    }

    public EventTracker() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27064a(int i) {
        if (i == 0 && this.f35909p == 1) {
            this.f35913t = SystemClock.elapsedRealtime();
            this.f35907n = null;
        }
        this.f35909p = i;
    }

    public boolean isAttachedToWindow(View view) {
        if (view == null) {
            return false;
        }
        return ViewCompat.isAttachedToWindow(view);
    }

    /* renamed from: a */
    private static View m27062a(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() <= 0) {
            return null;
        }
        View childAt = viewGroup.getChildAt(0);
        if (m27076c(childAt)) {
            return childAt;
        }
        return m27062a(childAt);
    }

    public static void trackEvent(String str) {
        trackEvent(str, (Map) null);
    }

    public static void trackEvent(String str, Map map) {
        trackEvent(str, map, true);
    }

    public static void trackEvent(String str, Map map, boolean z) {
        trackEvent(str, map, z, (Assertor) null);
    }

    public static boolean hasPreEvents(String str, long j) {
        return f35893c.containsEvent(str, j);
    }

    public static boolean hasPreEvents(String str) {
        return f35893c.containsEvent(str, 0);
    }

    /* renamed from: b */
    private void m27073b(View view) {
        if (view != null) {
            final Context context = view.getContext();
            if (f35895e.get(context) == null) {
                if (context instanceof FragmentActivity) {
                    final FragmentActivity fragmentActivity = (FragmentActivity) context;
                    fragmentActivity.getLifecycle().addObserver(new LifecycleObserver() {
                        /* access modifiers changed from: package-private */
                        @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
                        public void onAny(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                            if (event == Lifecycle.Event.ON_RESUME) {
                                EventTracker.m27074b(fragmentActivity.getSupportFragmentManager());
                            } else if (event == Lifecycle.Event.ON_DESTROY) {
                                lifecycleOwner.getLifecycle().removeObserver(this);
                                EventTracker.f35895e.remove(context);
                                Iterator it = EventTracker.f35896f.entrySet().iterator();
                                while (it.hasNext()) {
                                    Map.Entry entry = (Map.Entry) it.next();
                                    EventTracker eventTracker = (EventTracker) entry.getValue();
                                    Context context = ((View) entry.getKey()).getContext();
                                    if ((context instanceof LifecycleOwner) && context == lifecycleOwner) {
                                        eventTracker.unbind();
                                        it.remove();
                                        EventTracker.f35897g.remove(entry.getKey());
                                    }
                                }
                            }
                        }
                    });
                    if (this.f35911r) {
                        fragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
                            public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
                                try {
                                    EventTracker.this.m27066a(fragment);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    EventTracker.trackEvent("rx_track_error", new Attrs().attr(NotificationCompat.CATEGORY_ERROR, "onFragmentViewDestroyed").attr("ex", th), false);
                                }
                            }

                            public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
                                try {
                                    fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    EventTracker.trackEvent("rx_track_error", new Attrs().attr(NotificationCompat.CATEGORY_ERROR, "onFragmentDestroyed").attr("ex", th), false);
                                }
                            }
                        }, true);
                    }
                }
                f35895e.put(context, context);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27066a(Fragment fragment) {
        WeakReference<View> weakReference = f35902z;
        if (weakReference != null && weakReference.get() == fragment.getView()) {
            f35902z = null;
        }
        Iterator<Map.Entry<View, EventTracker>> it = f35897g.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (fragment.getContext() == ((View) next.getKey()).getContext()) {
                EventTracker eventTracker = (EventTracker) next.getValue();
                if (m27083f((View) next.getKey()).contains(fragment.getView())) {
                    eventTracker.unbind();
                    it.remove();
                    f35896f.remove(next.getKey());
                }
            }
        }
    }

    public void unbind() {
        View view;
        WeakReference<View> weakReference = this.f35912s;
        if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
            view.setTag(R.id.event_tracker_tag, (Object) null);
            if (view.getViewTreeObserver().isAlive() && this.f35914u != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f35914u);
            }
        }
        this.f35914u = null;
        this.f35916w = null;
        this.f35915v = null;
        this.f35917x = null;
    }

    public static boolean isBound(View view) {
        return view.getTag(R.id.event_tracker_tag) instanceof EventTracker;
    }

    public static EventTracker bind(View view) {
        if (view == null) {
            return new EventTracker((View) null);
        }
        if (!f35890D.isEnabled()) {
            return new EventTracker((View) null);
        }
        if (view.getTag(R.id.event_tracker_tag) instanceof EventTracker) {
            return (EventTracker) view.getTag(R.id.event_tracker_tag);
        }
        EventTracker eventTracker = new EventTracker(view);
        view.setTag(R.id.event_tracker_tag, eventTracker);
        if (!m27076c(view)) {
            View a = m27062a(view);
            if (a == null || a.getTag(R.id.event_tracker_tag) != null) {
                System.err.println("=========empty view group is not support yet=========");
            } else {
                a.setTag(R.id.event_tracker_tag, eventTracker);
                f35896f.put(a, eventTracker);
            }
        }
        f35896f.put(view, eventTracker);
        return eventTracker;
    }

    /* renamed from: c */
    private static boolean m27076c(View view) {
        if (view != null) {
            try {
                if (view.getClass().getDeclaredMethod("onVisibilityChanged", new Class[]{View.class, Integer.TYPE}) != null) {
                    return true;
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public void trackOnShow(boolean z, String str) {
        trackOnShow(z, str, (AttrsGetter) null);
    }

    public void trackOnShow(final boolean z, final String str, final AttrsGetter attrsGetter) {
        View view;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            f35898h.post(new Runnable() {
                public void run() {
                    EventTracker.this.trackOnShow(z, str, attrsGetter);
                }
            });
            return;
        }
        this.f35911r = z;
        WeakReference<View> weakReference = this.f35912s;
        if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
            if (z) {
                f35897g.put(view, this);
            }
            this.f35906m = true;
            this.f35916w = attrsGetter;
            m27073b(view);
        }
        this.f35905l = str;
    }

    public static void _aop_onVisibilityChanged(View view, View view2, int i) {
        if (view2 != null) {
            try {
                Object tag = view.getTag(R.id.event_tracker_tag);
                if (tag instanceof EventTracker) {
                    ((EventTracker) tag).m27065a(view2, i);
                }
            } catch (Exception e) {
                e.printStackTrace();
                trackEvent("rx_track_error", new Attrs().attr(NotificationCompat.CATEGORY_ERROR, "_aop_onVisibilityChanged").attr("ex", e), false);
            }
        }
    }

    public static void _aop_onFragmentsChanged(final FragmentManager fragmentManager) {
        f35898h.post(new Runnable() {
            public void run() {
                try {
                    EventTracker.m27074b(fragmentManager);
                    for (Map.Entry value : EventTracker.f35897g.entrySet()) {
                        EventTracker eventTracker = (EventTracker) value.getValue();
                        if (eventTracker.f35911r) {
                            eventTracker.m27078d();
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    EventTracker.trackEvent("rx_track_error", new Attrs().attr(NotificationCompat.CATEGORY_ERROR, "_aop_onFragmentsChanged").attr("ex", th), false);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m27074b(FragmentManager fragmentManager) {
        Fragment fragment;
        List<Fragment> fragments = fragmentManager.getFragments();
        WeakHashMap weakHashMap = new WeakHashMap();
        int size = fragments.size();
        while (true) {
            size--;
            if (size < 0) {
                fragment = null;
                break;
            }
            fragment = fragments.get(size);
            View view = fragment.getView();
            if (view != null) {
                weakHashMap.put(view, fragment);
                if (fragment.isVisible() && fragment.getUserVisibleHint()) {
                    break;
                }
            }
        }
        if (fragment == null) {
            f35902z = null;
        } else {
            f35902z = new WeakReference<>(fragment.getView());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m27078d() {
        int i;
        View view = (View) this.f35912s.get();
        if (view != null) {
            int i2 = this.f35910q;
            boolean d = m27080d(view);
            this.f35910q = d ? 1 : 0;
            if (!d) {
                this.f35907n = null;
            }
            if (this.f35906m && i2 != (i = this.f35910q) && i == 1 && view.getVisibility() == 0 && isAttachedToWindow(view)) {
                m27084f();
            }
        }
    }

    /* renamed from: d */
    private boolean m27080d(View view) {
        WeakReference<View> weakReference;
        if (view == null || (weakReference = f35902z) == null || weakReference.get() == null) {
            return false;
        }
        Set<View> f = m27083f(view);
        if (f.size() == 0) {
            return false;
        }
        return f.contains(f35902z.get());
    }

    /* renamed from: a */
    private void m27065a(View view, int i) {
        View view2 = (View) this.f35912s.get();
        if (view2 != null) {
            int i2 = 0;
            if (i == 0 || !m27082e(view)) {
                if (view2 == view) {
                    if (i == 0) {
                        i2 = 1;
                    }
                    m27064a(i2);
                } else if (m27070a(view2, view)) {
                    if (view2.getVisibility() == 0 && i == 0) {
                        i2 = 1;
                    }
                    m27064a(i2);
                } else {
                    if (view2.getVisibility() == 0) {
                        i2 = 1;
                    }
                    m27064a(i2);
                }
                if (this.f35911r) {
                    if (this.f35906m && this.f35909p == 1 && isAttachedToWindow(view2) && m27081e() && m27080d(view2)) {
                        m27084f();
                    }
                } else if (this.f35906m && this.f35909p == 1 && isAttachedToWindow(view2) && m27081e()) {
                    m27084f();
                }
            } else {
                m27064a(0);
            }
        }
    }

    /* renamed from: e */
    private boolean m27082e(View view) {
        return view != null && isAttachedToWindow(view) && m27083f(view).size() == 0;
    }

    /* renamed from: e */
    private boolean m27081e() {
        Object obj;
        WeakReference<Object> weakReference;
        Object obj2;
        AttrsGetter attrsGetter = this.f35916w;
        if (attrsGetter instanceof ShowEventAttrGetter) {
            obj = ((ShowEventAttrGetter) attrsGetter).getShowTag((View) this.f35912s.get());
            if (obj != null) {
                this.f35903A = new WeakReference<>(obj);
            }
        } else {
            obj = null;
        }
        if (this.f35908o <= 0 || obj == null || (weakReference = this.f35907n) == null || (obj2 = weakReference.get()) == null) {
            return true;
        }
        return !obj2.equals(obj);
    }

    /* renamed from: a */
    private boolean m27070a(View view, View view2) {
        if (view == view2) {
            return false;
        }
        while (view.getParent() != null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
            if (view == view2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    private void m27084f() {
        if (SystemClock.elapsedRealtime() - this.f35913t >= 300 && SystemClock.elapsedRealtime() - this.f35904B >= 300) {
            this.f35904B = SystemClock.elapsedRealtime();
            m27085g();
        }
    }

    /* renamed from: g */
    private void m27085g() {
        AttrsGetter attrsGetter = this.f35916w;
        Map attrs = attrsGetter != null ? attrsGetter.getAttrs() : null;
        Filter filter = this.f35915v;
        if (filter == null || filter.needTrack(this, this.f35905l, attrs)) {
            this.f35907n = this.f35903A;
            this.f35908o++;
            trackEvent(this.f35905l, attrs, this.f35918y, this.f35917x);
        }
    }

    public static void trackEvent(String str, Map map, boolean z, Assertor assertor) {
        AssertResult assertEvent;
        Map commonAttrs;
        if (f35899i == null) {
            SystemUtils.log(6, f35891a, "no innerTrackers", (Throwable) null, "com.didi.reactive.tracker.EventTracker", 617);
            return;
        }
        if (z && (commonAttrs = getCommonAttrs()) != null) {
            HashMap hashMap = new HashMap(commonAttrs);
            if (map != null) {
                hashMap.putAll(map);
            }
            map = hashMap;
        }
        if (f35901k < 10 && assertor != null && (assertEvent = assertor.assertEvent(map)) != null && !assertEvent.isPass()) {
            SystemUtils.log(6, f35891a, assertEvent.getMessage(), new RuntimeException(assertEvent.getMessage()), "com.didi.reactive.tracker.EventTracker", 634);
        }
        f35893c.add(new TrackedEvent(str));
        int length = f35899i.length;
        for (int i = 0; i < length; i++) {
            try {
                f35899i[i].track(str, map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Map getCommonAttrs() {
        AttrsGetter attrsGetter = f35900j;
        if (attrsGetter != null) {
            return attrsGetter.getAttrs();
        }
        return null;
    }

    /* renamed from: f */
    private static Set<View> m27083f(View view) {
        HashSet hashSet = new HashSet();
        while (view != null && view.getParent() != null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
            if (view.getId() == 16908290) {
                break;
            }
            hashSet.add(view);
        }
        return hashSet;
    }

    public EventTracker filter(Filter filter) {
        this.f35915v = filter;
        return this;
    }

    public EventTracker withCommonAttrs(boolean z) {
        this.f35918y = z;
        return this;
    }

    public EventTracker assertEvent(Assertor assertor) {
        this.f35917x = assertor;
        return this;
    }

    public static class TrackedEvent {
        private String eventId;
        private long time = SystemClock.elapsedRealtime();

        public TrackedEvent(String str) {
            this.eventId = str;
        }

        public long getTime() {
            return this.time;
        }

        public String getEventId() {
            return this.eventId;
        }
    }
}
