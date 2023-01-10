package com.didi.drouter.router;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.ArraySet;
import com.didi.drouter.api.Extend;
import com.didi.drouter.remote.RemoteBridge;
import com.didi.drouter.store.RouterMeta;
import com.didi.drouter.store.RouterStore;
import com.didi.drouter.store.Statistics;
import com.didi.drouter.utils.RouterLogger;
import com.didi.drouter.utils.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class RouterLoader {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Request f21065a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RouterCallback f21066b;

    private RouterLoader() {
    }

    /* renamed from: a */
    static RouterLoader m17788a(Request request, RouterCallback routerCallback) {
        RouterLoader routerLoader = new RouterLoader();
        routerLoader.f21065a = request;
        routerLoader.f21066b = routerCallback;
        return routerLoader;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63824a() {
        boolean z = false;
        RouterLogger.getCoreLogger().mo63950d("---------------------------------------------------------------------------", new Object[0]);
        RouterLogger coreLogger = RouterLogger.getCoreLogger();
        Object[] objArr = new Object[3];
        objArr[0] = this.f21065a.getNumber();
        objArr[1] = this.f21065a.getUri();
        if (this.f21066b != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        coreLogger.mo63950d("primary request \"%s\", router uri \"%s\", need callback \"%s\"", objArr);
        if (TextUtils.isEmpty(this.f21065a.f21052c)) {
            m17790b();
        } else {
            m17793e();
        }
    }

    /* renamed from: b */
    private void m17790b() {
        Statistics.track("local_request");
        TextUtils.appendExtra(this.f21065a.getExtra(), TextUtils.getQuery(this.f21065a.getUri()));
        Map<Request, RouterMeta> c = m17791c();
        if (!c.isEmpty()) {
            final Result result = new Result(this.f21065a, c, this.f21066b);
            if (c.size() > 1) {
                RouterLogger.getCoreLogger().mo63952w("warning: request match %s targets", Integer.valueOf(c.size()));
            }
            ArrayList<Map.Entry> arrayList = new ArrayList<>(c.entrySet());
            Collections.sort(arrayList, new RouterComparator());
            final boolean[] zArr = {false};
            for (final Map.Entry entry : arrayList) {
                if (zArr[0]) {
                    C8531c.m17800a((Request) entry.getKey(), "stop_by_router_target");
                } else {
                    InterceptorHandler.m17781a((Request) entry.getKey(), (RouterMeta) entry.getValue(), new IInterceptor() {
                        public void onContinue() {
                            ((Request) entry.getKey()).f21057h = new IInterceptor() {
                                public void onContinue() {
                                }

                                public void onInterrupt() {
                                    RouterLogger.getCoreLogger().mo63952w("request \"%s\" stop all remains requests", ((Request) entry.getKey()).getNumber());
                                    zArr[0] = true;
                                }

                                public void onRedirect(String str, Bundle... bundleArr) {
                                    zArr[0] = true;
                                    RouterMonitor.handleRequest((Request) entry.getKey(), (RouterMeta) entry.getValue(), "redirect_by_router_target");
                                    RouterLoader.this.f21065a.rebuild(str, bundleArr);
                                    RouterLoader.this.mo63824a();
                                }
                            };
                            C8532d.m17808a((Request) entry.getKey(), (RouterMeta) entry.getValue(), result, RouterLoader.this.f21066b);
                            ((Request) entry.getKey()).f21057h = null;
                        }

                        public void onInterrupt() {
                            C8531c.m17800a((Request) entry.getKey(), "stop_by_interceptor");
                        }

                        public void onRedirect(String str, Bundle... bundleArr) {
                            RouterMonitor.handleRequest((Request) entry.getKey(), (RouterMeta) entry.getValue(), "redirect_by_interceptor");
                            RouterLoader.this.f21065a.rebuild(str, bundleArr);
                            RouterLoader.this.mo63824a();
                        }
                    });
                }
            }
            return;
        }
        RouterLogger.getCoreLogger().mo63952w("warning: there is no request target match", new Object[0]);
        new Result(this.f21065a, (Map<Request, RouterMeta>) null, this.f21066b);
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            this.f21065a.putExtra("stack_trace", Log.getStackTraceString(e));
            C8531c.m17800a(this.f21065a, "not_found");
        }
    }

    /* renamed from: c */
    private Map<Request, RouterMeta> m17791c() {
        HashMap hashMap = new HashMap();
        Parcelable parcelable = this.f21065a.getParcelable(Extend.START_ACTIVITY_VIA_INTENT);
        if (parcelable instanceof Intent) {
            this.f21065a.getExtra().remove(Extend.START_ACTIVITY_VIA_INTENT);
            Intent intent = (Intent) parcelable;
            RouterLogger.getCoreLogger().mo63950d("request %s, intent \"%s\"", this.f21065a.getNumber(), intent);
            List<ResolveInfo> queryIntentActivities = this.f21065a.getContext().getPackageManager().queryIntentActivities(intent, 65536);
            if (!queryIntentActivities.isEmpty()) {
                this.f21065a.f21053d = 1;
                RouterLogger.getCoreLogger().mo63950d("request \"%s\" find target class \"%s\", type \"%s\"", this.f21065a.getNumber(), queryIntentActivities.get(0).activityInfo.name, Integer.valueOf(this.f21065a.f21053d));
                hashMap.put(this.f21065a, RouterMeta.build(1).assembleRouter(intent));
            }
        } else {
            Set<RouterMeta> d = m17792d();
            int i = 0;
            for (RouterMeta next : d) {
                int i2 = i + 1;
                Request a = m17786a(this.f21065a, d.size() > 1, next.getRouterType(), i);
                RouterLogger.getCoreLogger().mo63950d("request \"%s\" find target class \"%s\", type \"%s\", priority \"%s\"", a.getNumber(), next.getSimpleClassName(), Integer.valueOf(next.getRouterType()), Integer.valueOf(next.getPriority()));
                hashMap.put(a, next);
                i = i2;
            }
        }
        return hashMap;
    }

    /* renamed from: d */
    private Set<RouterMeta> m17792d() {
        Set<RouterMeta> routerMetas = RouterStore.getRouterMetas(TextUtils.getUriKey(this.f21065a.getUri()));
        String string = this.f21065a.getString(Extend.START_ACTIVITY_WITH_DEFAULT_SCHEME_HOST);
        if (!TextUtils.isEmpty(string) && this.f21065a.getUri().toString().startsWith(string.toLowerCase())) {
            for (RouterMeta next : RouterStore.getRouterMetas(TextUtils.getUriKey(this.f21065a.getUri().getPath()))) {
                if (next.getRouterType() == 1) {
                    routerMetas.add(next);
                }
            }
        }
        SparseArray sparseArray = new SparseArray();
        ArraySet arraySet = new ArraySet();
        for (RouterMeta next2 : routerMetas) {
            if (next2.getRouterType() == 1) {
                if (sparseArray.get(0) != null) {
                    RouterLogger.getCoreLogger().mo63952w("warning: request match more than one activity and this \"%s\" will be ignored", next2.getSimpleClassName());
                } else {
                    sparseArray.put(0, next2);
                }
            } else if (next2.getRouterType() == 2) {
                if (sparseArray.get(1) != null) {
                    RouterLogger.getCoreLogger().mo63952w("warning: request match more than one fragment and this \"%s\" will be ignored", next2.getSimpleClassName());
                } else {
                    sparseArray.put(1, next2);
                }
            } else if (next2.getRouterType() == 3) {
                if (sparseArray.get(2) != null) {
                    RouterLogger.getCoreLogger().mo63952w("warning: request match more than one view and this \"%s\" will be ignored", next2.getSimpleClassName());
                } else {
                    sparseArray.put(2, next2);
                }
            } else if (next2.getRouterType() == 4) {
                arraySet.add(next2);
            }
        }
        if (sparseArray.get(0) != null) {
            arraySet.add(sparseArray.get(0));
        } else if (sparseArray.get(1) != null) {
            arraySet.add(sparseArray.get(1));
        } else if (sparseArray.get(2) != null) {
            arraySet.add(sparseArray.get(2));
        }
        return arraySet;
    }

    /* renamed from: e */
    private void m17793e() {
        Statistics.track("remote_request");
        HashMap hashMap = new HashMap();
        WeakReference weakReference = null;
        hashMap.put(this.f21065a, (Object) null);
        Result result = new Result(this.f21065a, hashMap, this.f21066b);
        String str = this.f21065a.f21052c;
        int i = this.f21065a.f21054e;
        if (this.f21065a.f21051b != null) {
            weakReference = new WeakReference(this.f21065a.f21051b);
        }
        RemoteBridge.load(str, i, weakReference).start(this.f21065a, result, this.f21066b);
    }

    /* renamed from: a */
    private static Request m17786a(Request request, boolean z, int i, int i2) {
        request.f21053d = z ? -1 : i;
        if (!z) {
            return request;
        }
        Request build = Request.build(request.getUri().toString());
        build.extra = request.extra;
        build.addition = request.addition;
        build.f21050a = request.f21050a;
        build.f21051b = request.f21051b;
        build.f21052c = request.f21052c;
        build.f21054e = request.f21054e;
        build.f21055f = request.f21055f;
        build.f21056g = request.getNumber() + "_" + i2;
        build.f21053d = i;
        return build;
    }

    private static class RouterComparator implements Comparator<Map.Entry<Request, RouterMeta>> {
        private RouterComparator() {
        }

        public int compare(Map.Entry<Request, RouterMeta> entry, Map.Entry<Request, RouterMeta> entry2) {
            return entry2.getValue().getPriority() - entry.getValue().getPriority();
        }
    }
}
