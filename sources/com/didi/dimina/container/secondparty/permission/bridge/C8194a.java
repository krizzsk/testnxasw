package com.didi.dimina.container.secondparty.permission.bridge;

import com.didi.dimina.container.secondparty.permission.bridge.Messenger;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.didi.dimina.container.secondparty.permission.bridge.a */
/* compiled from: RequestExecutor */
final class C8194a extends Thread implements Messenger.Callback {

    /* renamed from: a */
    private final BlockingQueue<BridgeRequest> f19233a;

    /* renamed from: b */
    private BridgeRequest f19234b;

    /* renamed from: c */
    private Messenger f19235c;

    public C8194a(BlockingQueue<BridgeRequest> blockingQueue) {
        this.f19233a = blockingQueue;
    }

    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    this.f19234b = this.f19233a.take();
                    try {
                        Messenger messenger = new Messenger(this.f19234b.getSource().getContext(), this);
                        this.f19235c = messenger;
                        messenger.mo60854a();
                        m16327a();
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
    private void m16327a() {
        switch (this.f19234b.getType()) {
            case 1:
                BridgeActivity.m16316a(this.f19234b.getSource());
                return;
            case 2:
                BridgeActivity.m16317a(this.f19234b.getSource(), this.f19234b.getPermissions());
                return;
            case 3:
                BridgeActivity.m16318b(this.f19234b.getSource());
                return;
            case 4:
                BridgeActivity.m16319c(this.f19234b.getSource());
                return;
            case 5:
                BridgeActivity.m16320d(this.f19234b.getSource());
                return;
            case 6:
                BridgeActivity.m16321e(this.f19234b.getSource());
                return;
            case 7:
                BridgeActivity.m16322f(this.f19234b.getSource());
                return;
            case 8:
                BridgeActivity.m16323g(this.f19234b.getSource());
                return;
            default:
                return;
        }
    }

    public void onCallback() {
        synchronized (this) {
            this.f19235c.mo60855b();
            this.f19234b.getCallback().onCallback();
            notify();
        }
    }
}
