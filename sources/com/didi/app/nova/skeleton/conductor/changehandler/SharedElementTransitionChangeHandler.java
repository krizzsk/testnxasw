package com.didi.app.nova.skeleton.conductor.changehandler;

import android.app.SharedElementCallback;
import android.graphics.Rect;
import android.transition.Transition;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.TransitionChangeHandler;
import com.didi.app.nova.skeleton.conductor.internal.TransitionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class SharedElementTransitionChangeHandler extends TransitionChangeHandler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ArrayMap<String, String> f10205a = new ArrayMap<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final List<String> f10206b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final List<ViewVisibilityPair> f10207c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Transition f10208d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Transition f10209e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Transition f10210f;

    /* renamed from: g */
    private SharedElementCallback f10211g;

    /* renamed from: h */
    private SharedElementCallback f10212h;

    public boolean allowTransitionOverlap(boolean z) {
        return true;
    }

    public abstract void configureSharedElements(ViewGroup viewGroup, View view, View view2, boolean z);

    public abstract Transition getEnterTransition(ViewGroup viewGroup, View view, View view2, boolean z);

    public SharedElementCallback getEnterTransitionCallback(ViewGroup viewGroup, View view, View view2, boolean z) {
        return null;
    }

    public abstract Transition getExitTransition(ViewGroup viewGroup, View view, View view2, boolean z);

    public SharedElementCallback getExitTransitionCallback(ViewGroup viewGroup, View view, View view2, boolean z) {
        return null;
    }

    public abstract Transition getSharedElementTransition(ViewGroup viewGroup, View view, View view2, boolean z);

    /* access modifiers changed from: protected */
    public final Transition getTransition(ViewGroup viewGroup, View view, View view2, boolean z) {
        this.f10208d = getExitTransition(viewGroup, view, view2, z);
        this.f10209e = getEnterTransition(viewGroup, view, view2, z);
        this.f10210f = getSharedElementTransition(viewGroup, view, view2, z);
        this.f10211g = getExitTransitionCallback(viewGroup, view, view2, z);
        this.f10212h = getEnterTransitionCallback(viewGroup, view, view2, z);
        if (this.f10209e != null || this.f10210f != null || this.f10208d != null) {
            return m8952a(z);
        }
        throw new IllegalStateException("SharedElementTransitionChangeHandler must have at least one transaction.");
    }

    public void prepareForTransition(ViewGroup viewGroup, View view, View view2, Transition transition, boolean z, TransitionChangeHandler.OnTransitionPreparedListener onTransitionPreparedListener) {
        final ViewGroup viewGroup2 = viewGroup;
        final View view3 = view;
        final View view4 = view2;
        final Transition transition2 = transition;
        final boolean z2 = z;
        final TransitionChangeHandler.OnTransitionPreparedListener onTransitionPreparedListener2 = onTransitionPreparedListener;
        C42571 r0 = new TransitionChangeHandler.OnTransitionPreparedListener() {
            public void onPrepared() {
                SharedElementTransitionChangeHandler.this.m8967a(viewGroup2, view3, view4, transition2, z2);
                onTransitionPreparedListener2.onPrepared();
            }
        };
        if (view2 == null || view2.getParent() != null || this.f10206b.size() <= 0) {
            r0.onPrepared();
            return;
        }
        m8964a(view2, (TransitionChangeHandler.OnTransitionPreparedListener) r0);
        viewGroup.addView(view2);
    }

    public final void executePropertyChanges(ViewGroup viewGroup, View view, View view2, Transition transition, boolean z) {
        if (view2 != null && this.f10207c.size() > 0) {
            view2.setVisibility(0);
            for (ViewVisibilityPair next : this.f10207c) {
                next.view.setVisibility(next.visibility);
            }
            this.f10207c.clear();
        }
        super.executePropertyChanges(viewGroup, view, view2, transition, z);
    }

    public void onAbortPush(ControllerChangeHandler controllerChangeHandler, Controller controller) {
        super.onAbortPush(controllerChangeHandler, controller);
        this.f10207c.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8967a(ViewGroup viewGroup, View view, View view2, Transition transition, boolean z) {
        ViewGroup viewGroup2 = viewGroup;
        View view3 = view;
        boolean z2 = z;
        configureSharedElements(viewGroup2, view3, view2, z2);
        View view4 = new View(viewGroup.getContext());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        m8968a(viewGroup, view4, view2, view, z2, (List<View>) arrayList, (List<View>) arrayList2);
        Transition transition2 = this.f10208d;
        List<View> a = transition2 != null ? m8959a(transition2, view3, (List<View>) arrayList, view4) : null;
        if (a == null || a.isEmpty()) {
            this.f10208d = null;
        }
        Transition transition3 = this.f10209e;
        if (transition3 != null) {
            transition3.addTarget(view4);
        }
        ArrayList arrayList3 = new ArrayList();
        m8962a(transition, this.f10209e, (List<View>) arrayList3, this.f10208d, a, this.f10210f, (List<View>) arrayList2);
        m8969a(viewGroup, view2, view4, (List<View>) arrayList2, (List<View>) arrayList3, a);
        m8965a((View) viewGroup2, (List<View>) arrayList2);
        m8970a(viewGroup2, (List<View>) arrayList2);
    }

    /* renamed from: a */
    private void m8964a(final View view, final TransitionChangeHandler.OnTransitionPreparedListener onTransitionPreparedListener) {
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            boolean addedSubviewListeners;

            public boolean onPreDraw() {
                boolean z;
                ArrayList arrayList = new ArrayList();
                Iterator it = SharedElementTransitionChangeHandler.this.f10206b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    String str = (String) it.next();
                    if (TransitionUtils.findNamedView(view, str) == null) {
                        z = false;
                        break;
                    }
                    arrayList.add(TransitionUtils.findNamedView(view, str));
                }
                if (z && !this.addedSubviewListeners) {
                    this.addedSubviewListeners = true;
                    SharedElementTransitionChangeHandler.this.m8966a(view, (List<View>) arrayList, (ViewTreeObserver.OnPreDrawListener) this, onTransitionPreparedListener);
                }
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8966a(View view, List<View> list, ViewTreeObserver.OnPreDrawListener onPreDrawListener, TransitionChangeHandler.OnTransitionPreparedListener onTransitionPreparedListener) {
        for (View next : list) {
            final View view2 = next;
            final View view3 = view;
            final ViewTreeObserver.OnPreDrawListener onPreDrawListener2 = onPreDrawListener;
            final TransitionChangeHandler.OnTransitionPreparedListener onTransitionPreparedListener2 = onTransitionPreparedListener;
            OneShotPreDrawListener.add(true, next, new Runnable() {
                public void run() {
                    SharedElementTransitionChangeHandler.this.f10206b.remove(view2.getTransitionName());
                    List b = SharedElementTransitionChangeHandler.this.f10207c;
                    View view = view2;
                    b.add(new ViewVisibilityPair(view, view.getVisibility()));
                    view2.setVisibility(8);
                    if (SharedElementTransitionChangeHandler.this.f10206b.size() == 0) {
                        view3.getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener2);
                        view3.setVisibility(4);
                        onTransitionPreparedListener2.onPrepared();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m8969a(ViewGroup viewGroup, View view, View view2, List<View> list, List<View> list2, List<View> list3) {
        final View view3 = view2;
        final View view4 = view;
        final List<View> list4 = list;
        final List<View> list5 = list2;
        final List<View> list6 = list3;
        OneShotPreDrawListener.add(true, viewGroup, new Runnable() {
            public void run() {
                if (SharedElementTransitionChangeHandler.this.f10209e != null) {
                    SharedElementTransitionChangeHandler.this.f10209e.removeTarget(view3);
                    SharedElementTransitionChangeHandler sharedElementTransitionChangeHandler = SharedElementTransitionChangeHandler.this;
                    list5.addAll(sharedElementTransitionChangeHandler.m8959a(sharedElementTransitionChangeHandler.f10209e, view4, (List<View>) list4, view3));
                }
                if (list6 != null) {
                    if (SharedElementTransitionChangeHandler.this.f10208d != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view3);
                        TransitionUtils.replaceTargets(SharedElementTransitionChangeHandler.this.f10208d, list6, arrayList);
                    }
                    list6.clear();
                    list6.add(view3);
                }
            }
        });
    }

    /* renamed from: a */
    private Transition m8952a(boolean z) {
        if (this.f10209e == null || this.f10208d == null || allowTransitionOverlap(z)) {
            return TransitionUtils.mergeTransitions(0, this.f10208d, this.f10209e, this.f10210f);
        }
        return TransitionUtils.mergeTransitions(0, TransitionUtils.mergeTransitions(1, this.f10208d, this.f10209e), this.f10210f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<View> m8959a(Transition transition, View view, List<View> list, View view2) {
        ArrayList arrayList = new ArrayList();
        if (view != null) {
            m8974a((List<View>) arrayList, view);
        }
        arrayList.removeAll(list);
        if (!arrayList.isEmpty()) {
            arrayList.add(view2);
            TransitionUtils.addTargets(transition, arrayList);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m8968a(ViewGroup viewGroup, View view, View view2, View view3, boolean z, List<View> list, List<View> list2) {
        final Rect rect;
        View view4 = view3;
        List<View> list3 = list;
        if (view2 != null && view4 != null) {
            ArrayMap<String, View> b = m8975b(view3, z);
            if (this.f10205a.isEmpty()) {
                this.f10210f = null;
            } else if (b != null) {
                list3.addAll(b.values());
            }
            if (this.f10209e != null || this.f10208d != null || this.f10210f != null) {
                m8963a(b, true);
                if (this.f10210f != null) {
                    final Rect rect2 = new Rect();
                    View view5 = view;
                    TransitionUtils.setTargets(this.f10210f, view, list3);
                    m8977b(b);
                    Transition transition = this.f10209e;
                    if (transition != null) {
                        transition.setEpicenterCallback(new Transition.EpicenterCallback() {
                            public Rect onGetEpicenter(Transition transition) {
                                if (rect2.isEmpty()) {
                                    return null;
                                }
                                return rect2;
                            }
                        });
                    }
                    rect = rect2;
                } else {
                    View view6 = view;
                    rect = null;
                }
                final View view7 = view2;
                final boolean z2 = z;
                final List<View> list4 = list2;
                final View view8 = view;
                final List<View> list5 = list;
                ViewGroup viewGroup2 = viewGroup;
                OneShotPreDrawListener.add(true, viewGroup, new Runnable() {
                    public void run() {
                        Rect rect;
                        ArrayMap a = SharedElementTransitionChangeHandler.this.m8953a(view7, z2);
                        if (a != null) {
                            list4.addAll(a.values());
                            list4.add(view8);
                        }
                        SharedElementTransitionChangeHandler.this.m8963a((ArrayMap<String, View>) a, false);
                        if (SharedElementTransitionChangeHandler.this.f10210f != null) {
                            SharedElementTransitionChangeHandler.this.f10210f.getTargets().clear();
                            SharedElementTransitionChangeHandler.this.f10210f.getTargets().addAll(list4);
                            TransitionUtils.replaceTargets(SharedElementTransitionChangeHandler.this.f10210f, list5, list4);
                            View a2 = SharedElementTransitionChangeHandler.this.m8955a((ArrayMap<String, View>) a);
                            if (a2 != null && (rect = rect) != null) {
                                TransitionUtils.getBoundsOnScreen(a2, rect);
                            }
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m8955a(ArrayMap<String, View> arrayMap) {
        if (this.f10209e == null || this.f10205a.size() <= 0 || arrayMap == null) {
            return null;
        }
        return arrayMap.get(this.f10205a.valueAt(0));
    }

    /* renamed from: b */
    private void m8977b(ArrayMap<String, View> arrayMap) {
        if (this.f10205a.size() > 0 && arrayMap != null) {
            View view = arrayMap.get(this.f10205a.keyAt(0));
            Transition transition = this.f10210f;
            if (transition != null) {
                TransitionUtils.setEpicenter(transition, view);
            }
            Transition transition2 = this.f10208d;
            if (transition2 != null) {
                TransitionUtils.setEpicenter(transition2, view);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ArrayMap<String, View> m8953a(View view, boolean z) {
        String a;
        if (this.f10205a.isEmpty() || this.f10210f == null || view == null) {
            this.f10205a.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap = new ArrayMap<>();
        TransitionUtils.findNamedViews(arrayMap, view);
        for (ViewVisibilityPair next : this.f10207c) {
            arrayMap.put(next.view.getTransitionName(), next.view);
        }
        ArrayList arrayList = new ArrayList(this.f10205a.values());
        arrayMap.retainAll(arrayList);
        SharedElementCallback sharedElementCallback = this.f10212h;
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view2 = arrayMap.get(str);
                if (view2 == null) {
                    String a2 = m8957a(this.f10205a, str);
                    if (a2 != null) {
                        this.f10205a.remove(a2);
                    }
                } else if (!str.equals(view2.getTransitionName()) && (a = m8957a(this.f10205a, str)) != null) {
                    this.f10205a.put(a, view2.getTransitionName());
                }
            }
        } else {
            for (int size2 = this.f10205a.size() - 1; size2 >= 0; size2--) {
                if (!arrayMap.containsKey(this.f10205a.valueAt(size2))) {
                    this.f10205a.removeAt(size2);
                }
            }
        }
        return arrayMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m8957a(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.valueAt(i))) {
                return arrayMap.keyAt(i);
            }
        }
        return null;
    }

    /* renamed from: b */
    private ArrayMap<String, View> m8975b(View view, boolean z) {
        if (this.f10205a.isEmpty() || this.f10210f == null) {
            this.f10205a.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap = new ArrayMap<>();
        TransitionUtils.findNamedViews(arrayMap, view);
        ArrayList arrayList = new ArrayList(this.f10205a.keySet());
        arrayMap.retainAll(arrayList);
        SharedElementCallback sharedElementCallback = this.f10211g;
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view2 = arrayMap.get(str);
                if (view2 == null) {
                    this.f10205a.remove(str);
                } else if (!str.equals(view2.getTransitionName())) {
                    this.f10205a.put(view2.getTransitionName(), this.f10205a.remove(str));
                }
            }
        } else {
            this.f10205a.retainAll(arrayMap.keySet());
        }
        return arrayMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8963a(ArrayMap<String, View> arrayMap, boolean z) {
        int i;
        if (this.f10212h != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (arrayMap == null) {
                i = 0;
            } else {
                i = arrayMap.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(arrayMap.keyAt(i2));
                arrayList.add(arrayMap.valueAt(i2));
            }
            if (z) {
                this.f10212h.onSharedElementStart(arrayList2, arrayList, (List) null);
            } else {
                this.f10212h.onSharedElementEnd(arrayList2, arrayList, (List) null);
            }
        }
    }

    /* renamed from: a */
    private void m8974a(List<View> list, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                list.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m8974a(list, viewGroup.getChildAt(i));
            }
            return;
        }
        list.add(view);
    }

    /* renamed from: a */
    private void m8962a(Transition transition, Transition transition2, List<View> list, Transition transition3, List<View> list2, Transition transition4, List<View> list3) {
        final Transition transition5 = transition2;
        final List<View> list4 = list;
        final Transition transition6 = transition3;
        final List<View> list5 = list2;
        final Transition transition7 = transition4;
        final List<View> list6 = list3;
        Transition transition8 = transition;
        transition.addListener(new Transition.TransitionListener() {
            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionEnd(Transition transition) {
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
            }

            public void onTransitionStart(Transition transition) {
                List list;
                List list2;
                List list3;
                Transition transition2 = transition5;
                if (!(transition2 == null || (list3 = list4) == null)) {
                    TransitionUtils.replaceTargets(transition2, list3, (List<View>) null);
                }
                Transition transition3 = transition6;
                if (!(transition3 == null || (list2 = list5) == null)) {
                    TransitionUtils.replaceTargets(transition3, list2, (List<View>) null);
                }
                Transition transition4 = transition7;
                if (transition4 != null && (list = list6) != null) {
                    TransitionUtils.replaceTargets(transition4, list, (List<View>) null);
                }
            }
        });
    }

    /* renamed from: a */
    private void m8965a(View view, final List<View> list) {
        OneShotPreDrawListener.add(true, view, new Runnable() {
            public void run() {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) list.get(i);
                    String transitionName = view.getTransitionName();
                    if (transitionName != null) {
                        SharedElementTransitionChangeHandler sharedElementTransitionChangeHandler = SharedElementTransitionChangeHandler.this;
                        view.setTransitionName(sharedElementTransitionChangeHandler.m8957a((ArrayMap<String, String>) sharedElementTransitionChangeHandler.f10205a, transitionName));
                    }
                }
            }
        });
    }

    /* renamed from: a */
    private void m8970a(ViewGroup viewGroup, final List<View> list) {
        OneShotPreDrawListener.add(true, viewGroup, new Runnable() {
            public void run() {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) list.get(i);
                    view.setTransitionName((String) SharedElementTransitionChangeHandler.this.f10205a.get(view.getTransitionName()));
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void addSharedElement(String str) {
        this.f10205a.put(str, str);
    }

    /* access modifiers changed from: protected */
    public final void addSharedElement(String str, String str2) {
        this.f10205a.put(str, str2);
    }

    /* access modifiers changed from: protected */
    public final void addSharedElement(View view, String str) {
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            this.f10205a.put(transitionName, str);
            return;
        }
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
    }

    /* access modifiers changed from: protected */
    public final void waitOnSharedElementNamed(String str) {
        if (this.f10205a.values().contains(str)) {
            this.f10206b.add(str);
            return;
        }
        throw new IllegalStateException("Can't wait on a shared element that hasn't been registered using addSharedElement");
    }

    private static class OneShotPreDrawListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
        private final boolean preDrawReturnValue;
        private final Runnable runnable;
        private final View view;
        private ViewTreeObserver viewTreeObserver;

        private OneShotPreDrawListener(boolean z, View view2, Runnable runnable2) {
            this.preDrawReturnValue = z;
            this.view = view2;
            this.viewTreeObserver = view2.getViewTreeObserver();
            this.runnable = runnable2;
        }

        public static OneShotPreDrawListener add(boolean z, View view2, Runnable runnable2) {
            OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(z, view2, runnable2);
            view2.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
            view2.addOnAttachStateChangeListener(oneShotPreDrawListener);
            return oneShotPreDrawListener;
        }

        public boolean onPreDraw() {
            removeListener();
            this.runnable.run();
            return this.preDrawReturnValue;
        }

        private void removeListener() {
            if (this.viewTreeObserver.isAlive()) {
                this.viewTreeObserver.removeOnPreDrawListener(this);
            } else {
                this.view.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            this.view.removeOnAttachStateChangeListener(this);
        }

        public void onViewAttachedToWindow(View view2) {
            this.viewTreeObserver = view2.getViewTreeObserver();
        }

        public void onViewDetachedFromWindow(View view2) {
            removeListener();
        }
    }

    private static class ViewVisibilityPair {
        final View view;
        final int visibility;

        ViewVisibilityPair(View view2, int i) {
            this.view = view2;
            this.visibility = i;
        }
    }
}
