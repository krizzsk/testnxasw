package com.didi.aoe.library.core;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.didi.aoe.library.api.interpreter.InterpreterInitResult;
import com.didi.aoe.library.api.interpreter.OnInterpreterInitListener;
import com.didi.aoe.library.core.p100io.AoeParcelImpl;
import com.didi.aoe.library.core.pojos.Message;
import com.didi.aoe.library.core.service.IAoeProcessService;
import com.didi.aoe.library.lang.AoeRemoteException;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AoeProcessService extends Service {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f10015a = LoggerFactory.getLogger("AoeProcessService");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<String, C4160f> f10016b = new HashMap();

    /* renamed from: c */
    private final IAoeProcessService.Stub f10017c = new IAoeProcessService.Stub() {
        public int init(String str, Message message) throws RemoteException {
            byte[] data = message.getData();
            Context applicationContext = AoeProcessService.this.getApplicationContext();
            Object byte2Obj = C4157c.m8700c(AoeParcelImpl.class.getName()).byte2Obj(data);
            if (byte2Obj instanceof RemoteOptions) {
                RemoteOptions remoteOptions = (RemoteOptions) byte2Obj;
                C4158d dVar = new C4158d(applicationContext, remoteOptions.getClientOptions());
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final AtomicInteger atomicInteger = new AtomicInteger(-2);
                dVar.init(applicationContext, remoteOptions.getModelOptions(), new OnInterpreterInitListener() {
                    public void onInitResult(InterpreterInitResult interpreterInitResult) {
                        atomicInteger.set(interpreterInitResult.getCode());
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    AoeProcessService.this.f10015a.warn("InterruptedException: ", (Throwable) e);
                }
                Logger a = AoeProcessService.this.f10015a;
                a.debug("init: " + atomicInteger.get() + ", clientId: " + str, new Object[0]);
                if (atomicInteger.get() == 0) {
                    AoeProcessService.this.f10016b.put(str, new C4160f(dVar));
                }
                return atomicInteger.get();
            }
            Logger a2 = AoeProcessService.this.f10015a;
            a2.error("parse init options " + str + ": " + byte2Obj, new Object[0]);
            throw new AoeRemoteException("parse init options " + str + ": " + byte2Obj);
        }

        public Message process(String str, Message message) throws RemoteException {
            C4160f fVar = (C4160f) AoeProcessService.this.f10016b.get(str);
            if (fVar != null) {
                byte[] a = fVar.mo45121a().mo45120a(message);
                if (a == null || a.length <= 0) {
                    return null;
                }
                if (fVar.getParcelComponent() != null) {
                    Object run = fVar.getInterpreterComponent().run(fVar.getParcelComponent().byte2Obj(a));
                    if (run != null) {
                        return new Message(1, 0, fVar.getParcelComponent().obj2Byte(run));
                    }
                    return null;
                }
                throw new AoeRemoteException("Process error, ParcelComponent is NULL");
            }
            throw new AoeRemoteException("Process error, can't found processor for client: " + str);
        }

        public void release(String str) throws RemoteException {
            C4160f fVar = (C4160f) AoeProcessService.this.f10016b.get(str);
            if (fVar != null) {
                fVar.getInterpreterComponent().release();
                AoeProcessService.this.f10016b.remove(str);
                return;
            }
            throw new AoeRemoteException("Release error, can't found processor for client: " + str);
        }
    };

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public IBinder onBind(Intent intent) {
        return this.f10017c;
    }
}
