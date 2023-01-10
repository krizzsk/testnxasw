package com.yanzhenjie.permission.bridge;

import com.yanzhenjie.permission.bridge.Messenger;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.yanzhenjie.permission.bridge.a */
/* compiled from: RequestExecutor */
final class C21691a extends Thread implements Messenger.Callback {

    /* renamed from: a */
    private final BlockingQueue<BridgeRequest> f58937a;

    /* renamed from: b */
    private BridgeRequest f58938b;

    /* renamed from: c */
    private Messenger f58939c;

    public C21691a(BlockingQueue<BridgeRequest> blockingQueue) {
        this.f58937a = blockingQueue;
    }

    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    this.f58938b = this.f58937a.take();
                    try {
                        Messenger messenger = new Messenger(this.f58938b.getSource().getContext(), this);
                        this.f58939c = messenger;
                        messenger.mo178859a();
                        m44546a();
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* renamed from: a */
    private void m44546a() {
        switch (this.f58938b.getType()) {
            case 1:
                BridgeActivity.m44535a(this.f58938b.getSource());
                return;
            case 2:
                BridgeActivity.m44536a(this.f58938b.getSource(), this.f58938b.getPermissions());
                return;
            case 3:
                BridgeActivity.m44537b(this.f58938b.getSource());
                return;
            case 4:
                BridgeActivity.m44538c(this.f58938b.getSource());
                return;
            case 5:
                BridgeActivity.m44539d(this.f58938b.getSource());
                return;
            case 6:
                BridgeActivity.m44540e(this.f58938b.getSource());
                return;
            case 7:
                BridgeActivity.m44541f(this.f58938b.getSource());
                return;
            case 8:
                BridgeActivity.m44542g(this.f58938b.getSource());
                return;
            default:
                return;
        }
    }

    public void onCallback() {
        synchronized (this) {
            this.f58939c.mo178860b();
            this.f58938b.getCallback().onCallback();
            notify();
        }
    }
}
