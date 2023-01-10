package com.didi.soda.customer.base.lazycomponent;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.Component;
import com.didi.soda.customer.base.lazycomponent.ILazyPresenter;
import com.didi.soda.customer.base.lazycomponent.ILazyView;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public class LazyComponent<V extends ILazyView<P>, P extends ILazyPresenter<V>> extends Component {

    /* renamed from: a */
    static boolean f42921a = false;

    /* renamed from: b */
    private P f42922b;

    /* renamed from: c */
    private V f42923c;

    /* renamed from: d */
    private ComponentEvent f42924d;

    /* renamed from: e */
    private boolean f42925e = false;

    /* renamed from: f */
    private InitializedCallback f42926f = new InitializedCallback() {
        public final void onInitialized() {
            LazyComponent.this.m32091j();
        }
    };

    private enum ComponentEvent {
        CREATE,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY
    }

    interface InitializedCallback {
        void onInitialized();
    }

    /* access modifiers changed from: protected */
    public P onCreatePresenter() {
        return null;
    }

    /* access modifiers changed from: protected */
    public V onCreateView() {
        return null;
    }

    public static void log(String str) {
        if (f42921a) {
            LogUtil.m32584d("LazyComponent", str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void m32091j() {
        if (!this.f42925e) {
            this.f42925e = true;
            m32084c();
            return;
        }
        throw new IllegalArgumentException(">>>>>>懒加载Component发生重复初始化异常 <<<<<<");
    }

    public void load() {
        V v = this.f42923c;
        if (v != null) {
            v.load();
        }
    }

    public LazyComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* renamed from: com.didi.soda.customer.base.lazycomponent.LazyComponent$1 */
    static /* synthetic */ class C144021 {

        /* renamed from: $SwitchMap$com$didi$soda$customer$base$lazycomponent$LazyComponent$ComponentEvent */
        static final /* synthetic */ int[] f42927xcb1f9794;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent[] r0 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f42927xcb1f9794 = r0
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent r1 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.CREATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f42927xcb1f9794     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent r1 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f42927xcb1f9794     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent r1 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.RESUME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f42927xcb1f9794     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent r1 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.PAUSE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f42927xcb1f9794     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent r1 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.STOP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f42927xcb1f9794     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.soda.customer.base.lazycomponent.LazyComponent$ComponentEvent r1 = com.didi.soda.customer.base.lazycomponent.LazyComponent.ComponentEvent.DESTROY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.base.lazycomponent.LazyComponent.C144021.<clinit>():void");
        }
    }

    /* renamed from: c */
    private void m32084c() {
        int i = C144021.f42927xcb1f9794[this.f42924d.ordinal()];
        if (i == 1) {
            m32085d();
        } else if (i == 2) {
            m32085d();
            m32086e();
        } else if (i == 3) {
            m32085d();
            m32086e();
            m32087f();
        } else if (i == 4) {
            m32085d();
            m32086e();
        } else if (i == 5) {
            m32085d();
        }
    }

    public final V getLogicView() {
        return this.f42923c;
    }

    public final P getPresenter() {
        return this.f42922b;
    }

    /* access modifiers changed from: protected */
    public void onAttach() {
        super.onAttach();
        if (this.f42923c == null) {
            this.f42923c = onCreateView();
        }
        if (this.f42922b == null) {
            this.f42922b = onCreatePresenter();
        }
        this.f42922b.setInitCallback(this.f42926f);
        P p = this.f42922b;
        if (p != null) {
            p.attachView(this.f42923c);
            this.f42922b.innerAttach(this.mScopeContext);
        }
        V v = this.f42923c;
        if (v != null) {
            v.attachPresenter(this.f42922b);
            this.f42923c.innerAttach(getContainer());
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        this.f42924d = ComponentEvent.CREATE;
        super.onCreate();
        if (this.f42925e) {
            m32085d();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.f42924d = ComponentEvent.START;
        super.onStart();
        if (this.f42925e) {
            m32086e();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.f42924d = ComponentEvent.RESUME;
        super.onResume();
        if (this.f42925e) {
            m32087f();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f42924d = ComponentEvent.PAUSE;
        super.onPause();
        if (this.f42925e) {
            m32088g();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f42924d = ComponentEvent.STOP;
        super.onStop();
        if (this.f42925e) {
            m32089h();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
        super.onDetach();
        V v = this.f42923c;
        if (v != null) {
            v.innerDetach();
        }
        P p = this.f42922b;
        if (p != null) {
            p.innerDetach();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f42924d = ComponentEvent.DESTROY;
        super.onDestroy();
        if (this.f42925e) {
            m32090i();
        }
    }

    /* renamed from: d */
    private void m32085d() {
        V v = this.f42923c;
        if (v != null) {
            v.onCreate();
        }
        P p = this.f42922b;
        if (p != null) {
            p.onCreate();
        }
    }

    /* renamed from: e */
    private void m32086e() {
        V v = this.f42923c;
        if (v != null) {
            v.onStart();
        }
        P p = this.f42922b;
        if (p != null) {
            p.onStart();
        }
    }

    /* renamed from: f */
    private void m32087f() {
        V v = this.f42923c;
        if (v != null) {
            v.onResume();
        }
        P p = this.f42922b;
        if (p != null) {
            p.onResume();
        }
    }

    /* renamed from: g */
    private void m32088g() {
        V v = this.f42923c;
        if (v != null) {
            v.onPause();
        }
        P p = this.f42922b;
        if (p != null) {
            p.onPause();
        }
    }

    /* renamed from: h */
    private void m32089h() {
        V v = this.f42923c;
        if (v != null) {
            v.onStop();
        }
        P p = this.f42922b;
        if (p != null) {
            p.onStop();
        }
    }

    /* renamed from: i */
    private void m32090i() {
        P p = this.f42922b;
        if (p != null) {
            p.onDestroy();
        }
        V v = this.f42923c;
        if (v != null) {
            v.onDestroy();
        }
    }
}
