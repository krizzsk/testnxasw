package com.didi.drouter.remote;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.lifecycle.LifecycleOwner;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.remote.IClientService;
import com.didi.drouter.remote.IHostService;
import com.didi.drouter.remote.RemoteProvider;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.drouter.router.RouterHelper;
import com.didi.drouter.utils.RouterLogger;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RemoteBridge {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Map<String, Set<RemoteCommand>> f21002e = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Map<String, IHostService> f21003f = new ConcurrentHashMap();

    /* renamed from: g */
    private static final Map<String, String> f21004g = new ConcurrentHashMap();

    /* renamed from: a */
    private String f21005a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f21006b;

    /* renamed from: c */
    private boolean f21007c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WeakReference<LifecycleOwner> f21008d;

    private RemoteBridge() {
    }

    public static RemoteBridge load(String str, int i, WeakReference<LifecycleOwner> weakReference) {
        RemoteBridge remoteBridge = new RemoteBridge();
        remoteBridge.f21005a = str;
        remoteBridge.f21006b = i;
        remoteBridge.f21008d = weakReference;
        return remoteBridge;
    }

    public void start(final Request request, final Result result, RouterCallback routerCallback) {
        RouterLogger.getCoreLogger().mo63950d("[Client] request \"%s\" start IPC", request.getNumber());
        final RemoteCommand remoteCommand = new RemoteCommand(0);
        remoteCommand.f21014f = this;
        remoteCommand.f21013e = this.f21006b;
        remoteCommand.f21015g = this.f21008d;
        remoteCommand.f21016h = request.getUri().toString();
        remoteCommand.f21020l = request.getExtra();
        remoteCommand.f21021m = request.getAddition();
        if (routerCallback != null) {
            remoteCommand.f21017i = new IClientService.Stub() {
                public RemoteResult callback(RemoteCommand remoteCommand) throws RemoteException {
                    RouterLogger.getCoreLogger().mo63952w("[Client] command \"%s\" callback success", remoteCommand);
                    result.extra = remoteCommand.f21020l;
                    result.addition = remoteCommand.f21021m;
                    RouterHelper.release(request);
                    return null;
                }
            };
        } else {
            RouterLogger.getCoreLogger().mo63950d("[Client] request \"%s\" complete ahead of time", request.getNumber());
            RouterHelper.release(request);
        }
        m17761a(remoteCommand);
    }

    public <T> T getService(Class<T> cls, String str, Object obj, Object... objArr) {
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls}, new RemoteHandler(cls, str, obj, objArr));
    }

    private class RemoteHandler implements InvocationHandler {
        private final String alias;
        private final Object[] constructor;
        private final Object feature;
        private final Class<?> serviceClass;

        RemoteHandler(Class<?> cls, String str, Object obj, Object... objArr) {
            this.serviceClass = cls;
            this.alias = str;
            this.feature = obj;
            this.constructor = objArr;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            RemoteCommand remoteCommand = new RemoteCommand(2);
            remoteCommand.f21014f = RemoteBridge.this;
            remoteCommand.f21015g = RemoteBridge.this.f21008d;
            remoteCommand.f21013e = RemoteBridge.this.f21006b;
            remoteCommand.f21022n = this.serviceClass;
            remoteCommand.f21023o = this.alias;
            remoteCommand.f21024p = this.feature;
            remoteCommand.f21026r = this.constructor;
            remoteCommand.f21025q = method.getName();
            remoteCommand.f21027s = objArr;
            RouterLogger.getCoreLogger().mo63950d("[Client] command: \"%s\" start IPC", remoteCommand);
            RemoteResult a = RemoteBridge.this.m17761a(remoteCommand);
            if (a != null && "success".equals(a.f21039d)) {
                return a.f21040e;
            }
            Class<?> returnType = method.getReturnType();
            if (!returnType.isPrimitive()) {
                return null;
            }
            if (returnType == Boolean.TYPE) {
                return false;
            }
            if (returnType == Character.TYPE) {
                return '0';
            }
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public RemoteResult m17761a(RemoteCommand remoteCommand) {
        RouterLogger.getCoreLogger().mo63950d("[Client] execute command start, authority \"%s\", reTry:%s", this.f21005a, Boolean.valueOf(this.f21007c));
        IHostService d = m17770d(this.f21005a);
        RemoteResult remoteResult = null;
        if (d != null) {
            try {
                m17767b(remoteCommand);
                remoteResult = d.execute(remoteCommand);
                if (remoteResult == null) {
                    RouterLogger.getCoreLogger().mo63951e("[Client] command \"%s\" remote inner error with early termination", remoteCommand);
                } else if ("success".equals(remoteResult.f21039d)) {
                    RouterLogger.getCoreLogger().mo63950d("[Client] command \"%s\" return and state success", remoteCommand);
                } else {
                    RouterLogger.getCoreLogger().mo63951e("[Client] command \"%s\" return and state fail", remoteCommand);
                }
            } catch (RemoteException e) {
                RouterLogger.getCoreLogger().mo63951e("[Client] remote exception: %s", e);
                if (!this.f21007c) {
                    this.f21007c = true;
                    f21003f.remove(this.f21005a);
                    return m17761a(remoteCommand);
                }
            } catch (RuntimeException e2) {
                RouterLogger.getCoreLogger().mo63951e("[Client] remote exception: %s", e2);
            }
        }
        RouterLogger.getCoreLogger().mo63950d("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", new Object[0]);
        return remoteResult;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r2 = (androidx.lifecycle.LifecycleOwner) r9.f21015g.get();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m17767b(final com.didi.drouter.remote.RemoteCommand r9) {
        /*
            r8 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = f21004g
            java.lang.String r1 = r8.f21005a
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            if (r0 != 0) goto L_0x0019
            com.didi.drouter.utils.RouterLogger r9 = com.didi.drouter.utils.RouterLogger.getCoreLogger()
            java.lang.String r0 = "[Client] add resend command fail, for process is null"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r9.mo63951e(r0, r1)
            return
        L_0x0019:
            java.lang.ref.WeakReference<androidx.lifecycle.LifecycleOwner> r2 = r9.f21015g
            r3 = 0
            if (r2 == 0) goto L_0x002d
            java.lang.ref.WeakReference<androidx.lifecycle.LifecycleOwner> r2 = r9.f21015g
            java.lang.Object r2 = r2.get()
            androidx.lifecycle.LifecycleOwner r2 = (androidx.lifecycle.LifecycleOwner) r2
            if (r2 == 0) goto L_0x002d
            androidx.lifecycle.Lifecycle r2 = r2.getLifecycle()
            goto L_0x002e
        L_0x002d:
            r2 = r3
        L_0x002e:
            int r4 = r9.f21013e
            r5 = 1
            if (r4 != r5) goto L_0x00a8
            if (r2 == 0) goto L_0x0049
            androidx.lifecycle.Lifecycle$State r4 = r2.getCurrentState()
            androidx.lifecycle.Lifecycle$State r6 = androidx.lifecycle.Lifecycle.State.DESTROYED
            if (r4 != r6) goto L_0x0049
            com.didi.drouter.utils.RouterLogger r9 = com.didi.drouter.utils.RouterLogger.getCoreLogger()
            java.lang.String r0 = "[Client] add resend command fail, for lifecycle is destroyed"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r9.mo63951e(r0, r1)
            return
        L_0x0049:
            java.util.Map<java.lang.String, java.util.Set<com.didi.drouter.remote.RemoteCommand>> r4 = f21002e
            java.lang.Object r4 = r4.get(r0)
            java.util.Set r4 = (java.util.Set) r4
            if (r4 != 0) goto L_0x0073
            java.lang.Class<com.didi.drouter.service.ServiceLoader> r6 = com.didi.drouter.service.ServiceLoader.class
            monitor-enter(r6)
            java.util.Map<java.lang.String, java.util.Set<com.didi.drouter.remote.RemoteCommand>> r4 = f21002e     // Catch:{ all -> 0x0070 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ all -> 0x0070 }
            java.util.Set r4 = (java.util.Set) r4     // Catch:{ all -> 0x0070 }
            if (r4 != 0) goto L_0x006e
            java.util.concurrent.ConcurrentHashMap r4 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x0070 }
            r4.<init>()     // Catch:{ all -> 0x0070 }
            java.util.Set r4 = java.util.Collections.newSetFromMap(r4)     // Catch:{ all -> 0x0070 }
            java.util.Map<java.lang.String, java.util.Set<com.didi.drouter.remote.RemoteCommand>> r7 = f21002e     // Catch:{ all -> 0x0070 }
            r7.put(r0, r4)     // Catch:{ all -> 0x0070 }
        L_0x006e:
            monitor-exit(r6)     // Catch:{ all -> 0x0070 }
            goto L_0x0073
        L_0x0070:
            r9 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0070 }
            throw r9
        L_0x0073:
            boolean r6 = r4.contains(r9)
            if (r6 != 0) goto L_0x00a8
            monitor-enter(r8)
            boolean r6 = r4.contains(r9)     // Catch:{ all -> 0x00a5 }
            if (r6 != 0) goto L_0x008d
            r4.add(r9)     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x008d
            com.didi.drouter.remote.RemoteBridge$2 r4 = new com.didi.drouter.remote.RemoteBridge$2     // Catch:{ all -> 0x00a5 }
            r4.<init>(r0, r9, r2)     // Catch:{ all -> 0x00a5 }
            r2.addObserver(r4)     // Catch:{ all -> 0x00a5 }
        L_0x008d:
            monitor-exit(r8)     // Catch:{ all -> 0x00a5 }
            com.didi.drouter.utils.RouterLogger r0 = com.didi.drouter.utils.RouterLogger.getCoreLogger()
            java.lang.String r4 = "[Client] add resend command: \"%s\", with current lifecycle: %s"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r1] = r9
            if (r2 == 0) goto L_0x009f
            androidx.lifecycle.Lifecycle$State r3 = r2.getCurrentState()
        L_0x009f:
            r6[r5] = r3
            r0.mo63952w(r4, r6)
            goto L_0x00a8
        L_0x00a5:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00a5 }
            throw r9
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.drouter.remote.RemoteBridge.m17767b(com.didi.drouter.remote.RemoteCommand):void");
    }

    /* renamed from: b */
    private static void m17768b(String str) {
        C85103 r0 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent.getStringExtra("field_remote_launch_action");
                RouterLogger.getCoreLogger().mo63952w("receive broadcast remote app launcher process: \"%s\"", stringExtra);
                RemoteBridge.m17769c(stringExtra);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("drouter.process.action." + str);
        try {
            DRouter.getContext().registerReceiver(r0, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m17769c(String str) {
        Set<RemoteCommand> set = f21002e.get(str);
        if (set != null) {
            for (RemoteCommand remoteCommand : set) {
                RouterLogger.getCoreLogger().mo63952w("execute resend command: \"%s\"", remoteCommand);
                remoteCommand.f21014f.m17761a(remoteCommand);
            }
        }
    }

    /* renamed from: d */
    private static IHostService m17770d(final String str) {
        boolean z;
        String str2;
        boolean z2;
        String str3;
        IHostService iHostService = f21003f.get(str);
        if (iHostService != null) {
            return iHostService;
        }
        try {
            synchronized (RemoteCommand.class) {
                IHostService iHostService2 = f21003f.get(str);
                if (iHostService2 != null) {
                    RouterLogger.getCoreLogger().mo63950d("[Client] getHostService get binder with cache", new Object[0]);
                    return iHostService2;
                }
                Bundle bundle = null;
                int i = 0;
                while (true) {
                    if (i >= 3) {
                        break;
                    }
                    try {
                        ContentResolver contentResolver = DRouter.getContext().getContentResolver();
                        if (str.startsWith("content://")) {
                            str3 = str;
                        } else {
                            str3 = "content://" + str;
                        }
                        bundle = contentResolver.call(Uri.parse(str3), "", "", (Bundle) null);
                    } catch (RuntimeException e) {
                        RouterLogger.getCoreLogger().mo63951e("[Client] getHostService call provider, try time %s, exception: %s", Integer.valueOf(i), e.getMessage());
                    }
                    if (bundle != null) {
                        break;
                    }
                    i++;
                }
                if (bundle != null) {
                    bundle.setClassLoader(RemoteBridge.class.getClassLoader());
                    RemoteProvider.BinderParcel binderParcel = (RemoteProvider.BinderParcel) bundle.getParcelable("field_remote_binder");
                    str2 = bundle.getString("field_remote_process");
                    if (binderParcel != null) {
                        iHostService2 = IHostService.Stub.asInterface(binderParcel.getBinder());
                        iHostService2.asBinder().linkToDeath(new IBinder.DeathRecipient() {
                            public void binderDied() {
                                RemoteBridge.f21003f.remove(str);
                                RouterLogger.getCoreLogger().mo63951e("[Client] linkToDeath: remote \"%s\" is died", str);
                            }
                        }, 0);
                        f21003f.put(str, iHostService2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (str2 == null || f21004g.containsKey(str)) {
                        z = false;
                    } else {
                        f21004g.put(str, str2);
                        m17768b(str2);
                        z = true;
                    }
                } else {
                    str2 = "";
                    z = false;
                    z2 = false;
                }
                RouterLogger.getCoreLogger().mo63950d("[Client] getHostService get binder: %s, process: \"%s\", register broadcast: %s", Boolean.valueOf(z2), str2, Boolean.valueOf(z));
                return iHostService2;
            }
        } catch (RemoteException e2) {
            RouterLogger.getCoreLogger().mo63951e("[Client] getHostService remote exception: %s", e2);
            return null;
        }
    }

    public static IBinder getHostBinder(String str) {
        IHostService iHostService = f21003f.get(str);
        if (iHostService != null) {
            return iHostService.asBinder();
        }
        return null;
    }
}
