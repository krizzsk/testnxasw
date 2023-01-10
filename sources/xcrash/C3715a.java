package xcrash;

import android.app.Activity;
import android.app.Application;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: xcrash.a */
/* compiled from: ActivityMonitor */
class C3715a {

    /* renamed from: a */
    private static final C3715a f8903a = new C3715a();

    /* renamed from: d */
    private static final int f8904d = 100;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LinkedList<Activity> f8905b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f8906c = false;

    private C3715a() {
    }

    /* renamed from: a */
    static C3715a m7594a() {
        return f8903a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo43675a(Application application) {
        this.f8905b = new LinkedList<>();
        application.registerActivityLifecycleCallbacks(new ActivityMonitor$1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo43676b() {
        LinkedList<Activity> linkedList = this.f8905b;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((Activity) it.next()).finish();
            }
            this.f8905b.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo43677c() {
        return this.f8906c;
    }
}
