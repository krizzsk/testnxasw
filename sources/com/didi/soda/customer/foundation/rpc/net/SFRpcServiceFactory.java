package com.didi.soda.customer.foundation.rpc.net;

import android.app.Application;
import androidx.collection.ArrayMap;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.swarm.launcher.SwarmLauncher;
import com.didichuxing.swarm.launcher.util.SwarmServices;
import org.osgi.framework.launch.Framework;

public final class SFRpcServiceFactory {

    /* renamed from: a */
    private static Object f43646a = new Object();

    /* renamed from: b */
    private static volatile SFRpcServiceFactory f43647b = null;

    /* renamed from: c */
    private RpcServiceFactory f43648c = new RpcServiceFactory(GlobalContext.getContext());

    /* renamed from: d */
    private ArrayMap<Class<?>, RpcService> f43649d = new ArrayMap<>();

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
        T t = (RpcService) m32616a().f43649d.get(cls);
        if (t == null) {
            synchronized (cls) {
                t = m32616a().f43648c.newRpcService(cls, str);
                m32616a().f43649d.put(cls, t);
            }
        }
        return t;
    }

    public static void clearCache() {
        m32616a().f43649d.clear();
    }

    /* renamed from: a */
    private static SFRpcServiceFactory m32616a() {
        if (f43647b == null) {
            synchronized (f43646a) {
                f43647b = new SFRpcServiceFactory();
            }
        }
        return f43647b;
    }
}
