package com.didi.sdk.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.aspect.NetworkChangedReceiverAspect;
import com.didi.sdk.apm.model.AsyncReceiverModel;
import com.didi.sdk.apm.service.NetworkChangedService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.runtime.reflect.Factory;

public class NetworkChangedReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static /* synthetic */ JoinPoint.StaticPart f38517a;

    static {
        m29047a();
    }

    /* renamed from: a */
    private static /* synthetic */ void m29047a() {
        Factory factory = new Factory("NetworkChangedReceiver.java", NetworkChangedReceiver.class);
        f38517a = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("1", "onReceive", "com.didi.sdk.connectivity.NetworkChangedReceiver", "android.content.Context:android.content.Intent", "context:intent", "", "void"), 16);
    }

    public void onReceive(Context context, Intent intent) {
        JoinPoint makeJP = Factory.makeJP(f38517a, this, this, context, intent);
        m29046a(this, context, intent, makeJP, NetworkChangedReceiverAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    /* renamed from: a */
    private static final /* synthetic */ void m29048a(NetworkChangedReceiver networkChangedReceiver, Context context, Intent intent, JoinPoint joinPoint) {
        try {
            if (C12995f.m29068d(context)) {
                NetworkChangeHandler.m29035a().mo97879b(context);
            } else {
                NetworkChangeHandler.m29035a().mo97881c(context);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private static final /* synthetic */ Object m29046a(NetworkChangedReceiver networkChangedReceiver, Context context, Intent intent, JoinPoint joinPoint, NetworkChangedReceiverAspect networkChangedReceiverAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Context context2;
        int i;
        SystemUtils.log(2, "NetworkChangedReceiverAspect", "before onReceive when network changed!", (Throwable) null, "com.didi.sdk.connectivity.NetworkChangedReceiver", 36);
        try {
            boolean isNetworkChangedByAsyncExecute = SystemUtils.isNetworkChangedByAsyncExecute();
            SystemUtils.log(2, "NetworkChangedReceiverAspect", "is Async :" + isNetworkChangedByAsyncExecute, (Throwable) null, "com.didi.sdk.connectivity.NetworkChangedReceiver", 42);
            Object[] args = proceedingJoinPoint.getArgs();
            if (args != null) {
                context2 = null;
                i = 0;
                for (Object obj : args) {
                    if (obj instanceof Intent) {
                        i = ((Intent) obj).getIntExtra(AsyncReceiverModel.EXTRA_MARKUP_FLAG, 0);
                    } else if (obj instanceof Context) {
                        context2 = (Context) obj;
                    }
                }
            } else {
                context2 = null;
                i = 0;
            }
            if (!isNetworkChangedByAsyncExecute || context2 == null || i == 1) {
                SystemUtils.log(2, "NetworkChangedReceiverAspect", "NetworkChangedReceiver#onReceive origin executed", (Throwable) null, "com.didi.sdk.connectivity.NetworkChangedReceiver", 74);
                m29048a(networkChangedReceiver, (Context) args[0], (Intent) args[1], proceedingJoinPoint);
            } else {
                SystemUtils.log(2, "NetworkChangedReceiverAspect", "NetworkChangedReceiver#onReceive hooked executed", (Throwable) null, "com.didi.sdk.connectivity.NetworkChangedReceiver", 63);
                NetworkChangedService.sAsyncReceiverModel = new AsyncReceiverModel(((MethodSignature) proceedingJoinPoint.getSignature()).getMethod(), proceedingJoinPoint.getTarget(), proceedingJoinPoint.getArgs());
                NetworkChangedService.enqueueWork(context2, new Intent(NetworkChangedService.WORK_ACTION));
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
