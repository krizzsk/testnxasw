package com.xiaojuchefu.prism.monitor;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import com.taxis99.R;
import com.xiaojuchefu.prism.monitor.core.GlobalWindowManager;
import com.xiaojuchefu.prism.monitor.core.WindowCallbacks;
import com.xiaojuchefu.prism.monitor.core.WindowObserver;
import com.xiaojuchefu.prism.monitor.event.ActivityLifecycleCallbacks;
import com.xiaojuchefu.prism.monitor.event.PrismMonitorWindowCallbacks;
import com.xiaojuchefu.prism.monitor.event.ScreenObserver;
import com.xiaojuchefu.prism.monitor.handler.IPrismApolloService;
import com.xiaojuchefu.prism.monitor.handler.IViewContainerHandler;
import com.xiaojuchefu.prism.monitor.handler.IViewContentHandler;
import com.xiaojuchefu.prism.monitor.handler.IViewTagHandler;
import com.xiaojuchefu.prism.monitor.model.EventData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class PrismMonitor {

    /* renamed from: a */
    private static PrismMonitor f58844a = null;

    /* renamed from: b */
    private static final AtomicBoolean f58845b = new AtomicBoolean(false);

    /* renamed from: c */
    private static final AtomicBoolean f58846c = new AtomicBoolean(false);

    /* renamed from: d */
    private static final AtomicBoolean f58847d = new AtomicBoolean(false);
    public static int sTouchSlop = -1;

    /* renamed from: e */
    private boolean f58848e;

    /* renamed from: f */
    private boolean f58849f;

    /* renamed from: g */
    private List<OnPrismMonitorListener> f58850g;

    /* renamed from: h */
    private List<OnPrismKeyMonitorListener> f58851h;

    /* renamed from: i */
    private ActivityLifecycleCallbacks f58852i;

    /* renamed from: j */
    private WindowObserver.WindowObserverListener f58853j;

    /* renamed from: k */
    private IViewContainerHandler f58854k;

    /* renamed from: l */
    private IViewContentHandler f58855l;

    /* renamed from: m */
    private IViewTagHandler f58856m;
    public Application mApplication;

    /* renamed from: n */
    private IPrismApolloService f58857n;

    /* renamed from: o */
    private String f58858o = "";

    /* renamed from: p */
    private String f58859p = "";

    /* renamed from: q */
    private String f58860q = "";

    /* renamed from: r */
    private long f58861r;

    public interface OnPrismKeyMonitorListener {
        void onEvent(int i);
    }

    public interface OnPrismMonitorListener {
        void onEvent(EventData eventData);
    }

    private PrismMonitor() {
    }

    public static PrismMonitor getInstance() {
        if (f58844a == null) {
            synchronized (PrismMonitor.class) {
                if (f58844a == null) {
                    f58844a = new PrismMonitor();
                }
            }
        }
        return f58844a;
    }

    public boolean isMonitoring() {
        return f58847d.get();
    }

    public boolean isTest() {
        return this.f58848e;
    }

    public void setTest(boolean z) {
        this.f58848e = z;
    }

    public void setKeepMonitoring(boolean z) {
        this.f58849f = z;
    }

    public void init(Application application) {
        if (f58845b.compareAndSet(false, true)) {
            this.mApplication = application;
            this.f58850g = new ArrayList();
            this.f58851h = new ArrayList();
            Context applicationContext = application.getApplicationContext();
            sTouchSlop = ViewConfiguration.get(applicationContext).getScaledTouchSlop();
            ScreenObserver screenObserver = new ScreenObserver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            try {
                applicationContext.registerReceiver(screenObserver, intentFilter);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
            GlobalWindowManager.getInstance().init(applicationContext);
            this.f58852i = new ActivityLifecycleCallbacks();
            this.f58853j = new WindowObserver.WindowObserverListener() {
                public void remove(Window window) {
                }

                public void add(Window window) {
                    PrismMonitor.this.m44504a(window);
                }
            };
            f58846c.set(true);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.view.Window} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
            r5 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = f58845b
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x0061
            java.util.concurrent.atomic.AtomicBoolean r0 = f58846c
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0011
            goto L_0x0061
        L_0x0011:
            java.util.concurrent.atomic.AtomicBoolean r0 = f58847d
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 != 0) goto L_0x001c
            return
        L_0x001c:
            android.app.Application r0 = r5.mApplication
            com.xiaojuchefu.prism.monitor.event.ActivityLifecycleCallbacks r2 = r5.f58852i
            r0.registerActivityLifecycleCallbacks(r2)
            com.xiaojuchefu.prism.monitor.core.GlobalWindowManager r0 = com.xiaojuchefu.prism.monitor.core.GlobalWindowManager.getInstance()
            com.xiaojuchefu.prism.monitor.core.WindowObserver r0 = r0.getWindowObserver()
            com.xiaojuchefu.prism.monitor.core.WindowObserver$WindowObserverListener r2 = r5.f58853j
            r0.addWindowObserverListener(r2)
        L_0x0030:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x0061
            java.lang.Object r2 = r0.get(r1)
            android.view.View r2 = (android.view.View) r2
            r3 = 2131433527(0x7f0b1837, float:1.8488842E38)
            java.lang.Object r4 = r2.getTag(r3)
            android.view.Window r4 = (android.view.Window) r4
            if (r4 != 0) goto L_0x0051
            r0.bindWindow(r2)
            java.lang.Object r2 = r2.getTag(r3)
            r4 = r2
            android.view.Window r4 = (android.view.Window) r4
        L_0x0051:
            if (r4 == 0) goto L_0x005e
            android.view.Window$Callback r2 = r4.getCallback()
            boolean r2 = r2 instanceof com.xiaojuchefu.prism.monitor.core.WindowCallbacks
            if (r2 != 0) goto L_0x005e
            r5.m44504a(r4)
        L_0x005e:
            int r1 = r1 + 1
            goto L_0x0030
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaojuchefu.prism.monitor.PrismMonitor.start():void");
    }

    public void stop() {
        if (f58845b.get() && !this.f58849f) {
            if (f58847d.compareAndSet(true, false)) {
                this.mApplication.unregisterActivityLifecycleCallbacks(this.f58852i);
                WindowObserver windowObserver = GlobalWindowManager.getInstance().getWindowObserver();
                windowObserver.removeWindowObserverListener(this.f58853j);
                for (int i = 0; i < windowObserver.size(); i++) {
                    Window window = (Window) ((View) windowObserver.get(i)).getTag(R.id.prism_window);
                    if (window != null && (window.getCallback() instanceof WindowCallbacks)) {
                        window.setCallback(((WindowCallbacks) window.getCallback()).getCallBack());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m44504a(Window window) {
        if (window != null && !(window.getCallback() instanceof WindowCallbacks)) {
            window.setCallback(new PrismMonitorWindowCallbacks(window));
        }
    }

    public void post(int i) {
        post(new EventData(i));
    }

    public void post(EventData eventData) {
        if (f58845b.get() && f58847d.get()) {
            for (int i = 0; i < this.f58850g.size(); i++) {
                OnPrismMonitorListener onPrismMonitorListener = this.f58850g.get(i);
                if (onPrismMonitorListener != null) {
                    onPrismMonitorListener.onEvent(eventData);
                }
            }
        }
    }

    public void postKeyMonitor(int i) {
        if (f58845b.get() && f58847d.get()) {
            for (int i2 = 0; i2 < this.f58851h.size(); i2++) {
                OnPrismKeyMonitorListener onPrismKeyMonitorListener = this.f58851h.get(i2);
                if (onPrismKeyMonitorListener != null) {
                    onPrismKeyMonitorListener.onEvent(i);
                }
            }
        }
    }

    public IViewContainerHandler getViewContainerHandler() {
        return this.f58854k;
    }

    public void setViewContainerHandler(IViewContainerHandler iViewContainerHandler) {
        this.f58854k = iViewContainerHandler;
    }

    public IViewContentHandler getViewContentHandler() {
        return this.f58855l;
    }

    public void setViewContentHandler(IViewContentHandler iViewContentHandler) {
        this.f58855l = iViewContentHandler;
    }

    public IViewTagHandler getViewTagHandler() {
        return this.f58856m;
    }

    public void setViewTagHandler(IViewTagHandler iViewTagHandler) {
        this.f58856m = iViewTagHandler;
    }

    public void setBlackPhoneToggle(String str) {
        this.f58858o = str;
    }

    public String getBlackPhoneToggle() {
        return this.f58858o;
    }

    public void setPhoneBrand(String str) {
        this.f58859p = str;
    }

    public String getPhoneBrand() {
        return this.f58859p;
    }

    public void setPhoneModel(String str) {
        this.f58860q = str;
    }

    public String getPhoneModel() {
        return this.f58860q;
    }

    public void setTotalMem(long j) {
        this.f58861r = j;
    }

    public long getTotalMem() {
        return this.f58861r;
    }

    public void setApolloService(IPrismApolloService iPrismApolloService) {
        this.f58857n = iPrismApolloService;
    }

    public boolean allow(String str) {
        IPrismApolloService iPrismApolloService = this.f58857n;
        if (iPrismApolloService == null) {
            return false;
        }
        return iPrismApolloService.allow(str);
    }

    public <T> T getParams(String str, String str2, T t) {
        IPrismApolloService iPrismApolloService = this.f58857n;
        if (iPrismApolloService == null) {
            return t;
        }
        return iPrismApolloService.getParams(str, str2, t);
    }

    public void addOnPrismMonitorListener(OnPrismMonitorListener onPrismMonitorListener) {
        if (f58845b.get()) {
            this.f58850g.add(onPrismMonitorListener);
        }
    }

    public void removeOnPrismMonitorListener(OnPrismMonitorListener onPrismMonitorListener) {
        if (f58845b.get()) {
            this.f58850g.remove(onPrismMonitorListener);
        }
    }

    public void addOnPrismKeyMonitorListener(OnPrismKeyMonitorListener onPrismKeyMonitorListener) {
        if (f58845b.get()) {
            this.f58851h.add(onPrismKeyMonitorListener);
        }
    }

    public void removeOnPrismKeyMonitorListener(OnPrismKeyMonitorListener onPrismKeyMonitorListener) {
        if (f58845b.get()) {
            this.f58851h.remove(onPrismKeyMonitorListener);
        }
    }
}
