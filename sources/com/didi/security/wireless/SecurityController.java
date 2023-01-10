package com.didi.security.wireless;

import android.content.Context;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SecurityController {

    /* renamed from: h */
    private static boolean f41283h = false;

    /* renamed from: a */
    private Context f41284a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ReentrantLock f41285b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Condition f41286c;

    /* renamed from: d */
    private Thread f41287d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f41288e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Queue<SecurityMessage> f41289f = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Queue<Runnable> f41290g = new LinkedList();

    /* renamed from: i */
    private Runnable f41291i = new Runnable() {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Runnable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.didi.security.wireless.SecurityMessage} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Runnable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.didi.security.wireless.SecurityMessage} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Runnable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.didi.security.wireless.SecurityMessage} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Runnable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Runnable} */
        /* JADX WARNING: type inference failed for: r1v24, types: [com.didi.security.wireless.SecurityMessage] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
            L_0x0000:
                com.didi.security.wireless.SecurityController r0 = com.didi.security.wireless.SecurityController.this
                boolean r0 = r0.f41288e
                if (r0 != 0) goto L_0x00a7
                com.didi.security.wireless.SecurityController r0 = com.didi.security.wireless.SecurityController.this
                java.util.concurrent.locks.ReentrantLock r0 = r0.f41285b
                r0.lock()
            L_0x0011:
                r0 = 0
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                boolean r1 = r1.f41288e     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                if (r1 != 0) goto L_0x003c
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.Queue r1 = r1.f41289f     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                boolean r1 = r1.isEmpty()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                if (r1 == 0) goto L_0x003c
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.Queue r1 = r1.f41290g     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                boolean r1 = r1.isEmpty()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                if (r1 == 0) goto L_0x003c
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.concurrent.locks.Condition r1 = r1.f41286c     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                r1.await()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                goto L_0x0011
            L_0x003c:
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.Queue r1 = r1.f41289f     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                boolean r1 = r1.isEmpty()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                if (r1 != 0) goto L_0x0058
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.Queue r1 = r1.f41289f     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.lang.Object r1 = r1.poll()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                com.didi.security.wireless.SecurityMessage r1 = (com.didi.security.wireless.SecurityMessage) r1     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                r3 = r1
                r1 = r0
                r0 = r3
                goto L_0x0072
            L_0x0058:
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.Queue r1 = r1.f41290g     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                boolean r1 = r1.isEmpty()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                if (r1 != 0) goto L_0x0071
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.Queue r1 = r1.f41290g     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.lang.Object r1 = r1.poll()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                goto L_0x0072
            L_0x0071:
                r1 = r0
            L_0x0072:
                com.didi.security.wireless.SecurityController r2 = com.didi.security.wireless.SecurityController.this
                java.util.concurrent.locks.ReentrantLock r2 = r2.f41285b
                r2.unlock()
                r3 = r1
                r1 = r0
                r0 = r3
                goto L_0x0094
            L_0x007f:
                r0 = move-exception
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this
                java.util.concurrent.locks.ReentrantLock r1 = r1.f41285b
                r1.unlock()
                throw r0
            L_0x008a:
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this
                java.util.concurrent.locks.ReentrantLock r1 = r1.f41285b
                r1.unlock()
                r1 = r0
            L_0x0094:
                if (r0 == 0) goto L_0x009e
                r0.run()     // Catch:{ Exception -> 0x009b }
                goto L_0x0000
            L_0x009b:
                goto L_0x0000
            L_0x009e:
                if (r1 == 0) goto L_0x0000
                com.didi.security.wireless.SecurityController r0 = com.didi.security.wireless.SecurityController.this     // Catch:{ Exception -> 0x009b }
                r0.m30993a((com.didi.security.wireless.SecurityMessage) r1)     // Catch:{ Exception -> 0x009b }
                goto L_0x0000
            L_0x00a7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.security.wireless.SecurityController.C141661.run():void");
        }
    };

    public SecurityController() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f41285b = reentrantLock;
        this.f41286c = reentrantLock.newCondition();
    }

    private static class SingletonClassInstance {
        /* access modifiers changed from: private */
        public static final SecurityController INSTANCE = new SecurityController();

        private SingletonClassInstance() {
        }
    }

    public void init(Context context) {
        if (this.f41284a == null) {
            this.f41284a = context;
            m30991a();
        }
    }

    public static SecurityController getInstance() {
        return SingletonClassInstance.INSTANCE;
    }

    public static void setPriorityOn(boolean z) {
        f41283h = z;
    }

    /* renamed from: a */
    private void m30991a() {
        if (this.f41287d == null) {
            this.f41288e = false;
            Thread thread = new Thread(this.f41291i);
            this.f41287d = thread;
            thread.setName("WSGController");
            if (f41283h) {
                this.f41287d.setPriority(10);
            }
            this.f41287d.start();
            Logger.m30990i("Controller", "start only Once");
        }
    }

    /* renamed from: b */
    private void m30996b() {
        if (this.f41287d != null) {
            this.f41288e = true;
            this.f41285b.lock();
            this.f41286c.signal();
            this.f41285b.unlock();
            this.f41289f.clear();
            this.f41290g.clear();
            this.f41287d = null;
        }
    }

    public void post(SecurityMessage securityMessage) {
        if (this.f41287d != null) {
            this.f41285b.lock();
            this.f41289f.add(securityMessage);
            this.f41286c.signal();
            this.f41285b.unlock();
        }
    }

    public void post(Runnable runnable) {
        if (this.f41287d != null) {
            this.f41285b.lock();
            this.f41290g.add(runnable);
            this.f41286c.signal();
            this.f41285b.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30993a(SecurityMessage securityMessage) {
        SecurityLib.report(securityMessage.msgType, securityMessage.eventType, securityMessage.eventData);
    }
}
