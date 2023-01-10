package com.didi.drouter.remote;

import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.utils.ReflectUtil;
import com.didi.drouter.utils.RouterExecutor;
import com.didi.drouter.utils.RouterLogger;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.didi.drouter.remote.a */
/* compiled from: RemoteDispatcher */
class C8523a {

    /* renamed from: a */
    private static final AtomicInteger f21041a = new AtomicInteger(0);

    /* renamed from: b */
    private final RemoteResult f21042b = new RemoteResult("executing");

    C8523a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public RemoteResult mo63761a(RemoteCommand remoteCommand) {
        f21041a.incrementAndGet();
        RouterLogger.getCoreLogger().mo63950d("[Service] command \"%s\" start, thread count %s", remoteCommand, Integer.valueOf(f21041a.get()));
        if (f21041a.get() >= 16) {
            RouterLogger.getCoreLogger().mo63951e("[Service] binder thread pool is exploding", remoteCommand, Integer.valueOf(f21041a.get()));
        }
        if (remoteCommand.f21016h != null) {
            if (f21041a.get() >= 16) {
                RouterExecutor.submit(new RemoteDispatcher$1(this, remoteCommand));
            } else {
                m17778b(remoteCommand);
            }
        } else if (remoteCommand.f21022n != null) {
            m17779c(remoteCommand);
        }
        f21041a.decrementAndGet();
        return this.f21042b;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17778b(RemoteCommand remoteCommand) {
        Request build = DRouter.build(remoteCommand.f21016h);
        if (remoteCommand.f21020l != null) {
            build.extra = remoteCommand.f21020l;
        }
        if (remoteCommand.f21021m != null) {
            build.addition = remoteCommand.f21021m;
        }
        build.start(DRouter.getContext(), new RemoteDispatcher$2(this, remoteCommand));
        this.f21042b.f21039d = "success";
    }

    /* renamed from: c */
    private void m17779c(RemoteCommand remoteCommand) {
        Object service = DRouter.build(remoteCommand.f21022n).setAlias(remoteCommand.f21023o).setFeature(remoteCommand.f21024p).getService(remoteCommand.f21026r);
        RouterLogger coreLogger = RouterLogger.getCoreLogger();
        Object[] objArr = new Object[2];
        objArr[0] = service != null ? service.getClass().getSimpleName() : null;
        objArr[1] = remoteCommand.f21025q;
        coreLogger.mo63950d("[Service] use drouter to build new service \"%s\", and start invoke method \"%s\"", objArr);
        if (service != null) {
            try {
                this.f21042b.f21040e = ReflectUtil.invokeMethod(service, remoteCommand.f21025q, remoteCommand.f21027s);
                this.f21042b.f21039d = "success";
                return;
            } catch (Exception e) {
                RouterLogger.getCoreLogger().mo63951e("[Service] invoke Exception %s", e);
            }
        }
        this.f21042b.f21039d = "fail";
    }
}
