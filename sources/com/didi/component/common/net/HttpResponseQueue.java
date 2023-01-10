package com.didi.component.common.net;

import java.util.LinkedList;
import java.util.Queue;

public class HttpResponseQueue<E> {

    /* renamed from: a */
    private Queue<E> f13488a = new LinkedList();

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addHttpResponse(E r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Queue<E> r0 = r1.f13488a     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0015
            java.util.Queue<E> r0 = r1.f13488a     // Catch:{ all -> 0x0017 }
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x000e
            goto L_0x0015
        L_0x000e:
            java.util.Queue<E> r0 = r1.f13488a     // Catch:{ all -> 0x0017 }
            r0.offer(r2)     // Catch:{ all -> 0x0017 }
            monitor-exit(r1)
            return
        L_0x0015:
            monitor-exit(r1)
            return
        L_0x0017:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.common.net.HttpResponseQueue.addHttpResponse(java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void removeHeadHttpResponse() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Queue<E> r0 = r1.f13488a     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0015
            java.util.Queue<E> r0 = r1.f13488a     // Catch:{ all -> 0x0017 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x000e
            goto L_0x0015
        L_0x000e:
            java.util.Queue<E> r0 = r1.f13488a     // Catch:{ all -> 0x0017 }
            r0.poll()     // Catch:{ all -> 0x0017 }
            monitor-exit(r1)
            return
        L_0x0015:
            monitor-exit(r1)
            return
        L_0x0017:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.common.net.HttpResponseQueue.removeHeadHttpResponse():void");
    }

    public synchronized boolean containsHttpResponse(E e) {
        if (this.f13488a != null) {
            if (!this.f13488a.isEmpty()) {
                return this.f13488a.contains(e);
            }
        }
        return false;
    }

    public synchronized boolean isEmpty() {
        if (this.f13488a == null || this.f13488a.isEmpty()) {
            return true;
        }
        return false;
    }
}
