package com.didi.aoe.library.core;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.AoeProcessor;
import com.didi.aoe.library.api.interpreter.InterpreterInitResult;
import com.didi.aoe.library.api.interpreter.OnInterpreterInitListener;
import com.didi.aoe.library.core.AoeClient;
import com.didi.aoe.library.core.p100io.AoeParcelImpl;
import com.didi.aoe.library.core.pojos.Message;
import com.didi.aoe.library.core.service.IAoeProcessService;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.didi.aoe.library.core.g */
/* compiled from: RemoteProcessorWrapper */
final class C4161g extends C4155a {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Logger f10033b = LoggerFactory.getLogger("RemoteProcessorWrapper");

    /* renamed from: c */
    private final AoeClient.Options f10034c;

    /* renamed from: d */
    private final AoeProcessor.ParcelComponent f10035d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final AtomicBoolean f10036e = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f10037f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<AoeModelOption> f10038g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IAoeProcessService f10039h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnInterpreterInitListener f10040i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f10041j = -1;

    /* renamed from: k */
    private final ServiceConnection f10042k = new RemoteProcessorWrapper$1(this);

    public C4161g(Context context, AoeClient.Options options) {
        super(context, options);
        this.f10035d = C4157c.m8700c(options.parcelerClassName);
        this.f10034c = options;
        if (!m8708a()) {
            m8711b();
        }
    }

    public void init(Context context, List<AoeModelOption> list, OnInterpreterInitListener onInterpreterInitListener) {
        this.f10038g = list;
        this.f10040i = onInterpreterInitListener;
        if (m8708a()) {
            InterpreterInitResult a = m8705a(this.f10037f, this.f10038g);
            if (onInterpreterInitListener != null) {
                onInterpreterInitListener.onInitResult(a);
                return;
            }
            return;
        }
        m8711b();
        if (-1 == this.f10041j) {
            this.f10041j = 2;
        }
        if (onInterpreterInitListener != null) {
            onInterpreterInitListener.onInitResult(InterpreterInitResult.create(this.f10041j));
        }
    }

    public Object run(Object obj) {
        if (m8708a()) {
            m8705a(this.f10037f, this.f10038g);
            byte[] obj2Byte = getParcelComponent().obj2Byte(obj);
            if (obj2Byte == null || obj2Byte.length <= 0) {
                return null;
            }
            try {
                byte[] a = m8709a(obj2Byte);
                if (a == null || a.length <= 0) {
                    return null;
                }
                return getParcelComponent().byte2Obj(a);
            } catch (RemoteException e) {
                this.f10033b.error("process error: ", (Throwable) e);
                return null;
            }
        } else {
            m8711b();
            return null;
        }
    }

    /* renamed from: a */
    private byte[] m8709a(byte[] bArr) throws RemoteException {
        for (Message process : C4159e.m8701a(bArr)) {
            Message process2 = this.f10039h.process(this.f10037f, process);
            if (process2 != null) {
                return process2.getData();
            }
        }
        return new byte[0];
    }

    public void release() {
        if (m8708a()) {
            try {
                this.f10039h.release(this.f10037f);
            } catch (RemoteException e) {
                this.f10033b.error("release error: ", (Throwable) e);
            }
        }
        if (this.f10036e.getAndSet(false)) {
            m8713c();
        }
        this.f10041j = -1;
    }

    public boolean isReady() {
        return this.f10041j == 0;
    }

    public AoeProcessor.ParcelComponent getParcelComponent() {
        return this.f10035d;
    }

    /* renamed from: a */
    private boolean m8708a() {
        IAoeProcessService iAoeProcessService = this.f10039h;
        return (iAoeProcessService == null || iAoeProcessService.asBinder() == null || !this.f10039h.asBinder().isBinderAlive()) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public InterpreterInitResult m8705a(String str, List<AoeModelOption> list) {
        if (isReady()) {
            return InterpreterInitResult.create(0);
        }
        if (m8708a()) {
            try {
                RemoteOptions remoteOptions = new RemoteOptions();
                remoteOptions.setClientOptions(this.f10034c);
                remoteOptions.setModelOptions(list);
                int init = this.f10039h.init(str, new Message(C4157c.m8700c(AoeParcelImpl.class.getName()).obj2Byte(remoteOptions)));
                Logger logger = this.f10033b;
                logger.debug("tryInitIfNeeded: " + init, new Object[0]);
                this.f10041j = init;
                return InterpreterInitResult.create(init);
            } catch (RemoteException e) {
                this.f10033b.error("tryInitIfNeeded error", (Throwable) e);
            }
        }
        return InterpreterInitResult.create(2, "RemoteService not active.");
    }

    /* renamed from: b */
    private void m8711b() {
        this.f10018a.bindService(new Intent(this.f10018a, AoeProcessService.class), this.f10042k, 1);
    }

    /* renamed from: c */
    private void m8713c() {
        this.f10018a.unbindService(this.f10042k);
    }

    public void setId(String str) {
        this.f10037f = str;
    }
}
