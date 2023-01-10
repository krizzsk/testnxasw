package com.didi.entrega.customer.foundation.rpc.net;

import android.app.Application;
import androidx.collection.ArrayMap;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.swarm.launcher.SwarmLauncher;
import com.didichuxing.swarm.launcher.util.SwarmServices;
import org.osgi.framework.launch.Framework;

public final class SFRpcServiceFactory {

    /* renamed from: a */
    private static Object f21874a = new Object();

    /* renamed from: b */
    private static volatile SFRpcServiceFactory f21875b = null;

    /* renamed from: c */
    private RpcServiceFactory f21876c = new RpcServiceFactory(GlobalContext.getContext());

    /* renamed from: d */
    private ArrayMap<Class<?>, RpcService> f21877d = new ArrayMap<>();

    private SFRpcServiceFactory() {
        if (SwarmServices.lookup(Application.class) == null) {
            Framework framework = SwarmLauncher.getInstance().getFramework();
            int i = 0;
            OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create("swarm_application_crash").addEventParam("phone", LoginUtil.getPhone()).addEventParam("framework", Integer.valueOf(framework == null ? 0 : 1));
            if (framework != null) {
                addEventParam.addEventParam("context", Integer.valueOf(framework.getBundleContext() != null ? 1 : i));
            }
            addEventParam.build().track();
        }
    }

    public static <T extends RpcService> T getRpcService(Class<T> cls, String str) {
        T t = (RpcService) m18206a().f21877d.get(cls);
        if (t == null) {
            synchronized (cls) {
                t = m18206a().f21876c.newRpcService(cls, str);
                m18206a().f21877d.put(cls, t);
            }
        }
        return t;
    }

    public static void clearCache() {
        m18206a().f21877d.clear();
    }

    /* renamed from: a */
    private static SFRpcServiceFactory m18206a() {
        if (f21875b == null) {
            synchronized (f21874a) {
                f21875b = new SFRpcServiceFactory();
            }
        }
        return f21875b;
    }
}
