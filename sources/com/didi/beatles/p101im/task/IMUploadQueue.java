package com.didi.beatles.p101im.task;

import com.didi.beatles.p101im.api.entity.GiftUploadResponse;
import com.didi.beatles.p101im.module.entity.IMMessage;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.didi.beatles.im.task.IMUploadQueue */
public class IMUploadQueue {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11488a = IMUploadQueue.class.getSimpleName();

    /* renamed from: d */
    private static IMUploadQueue f11489d;

    /* renamed from: b */
    private Queue<TaskItem> f11490b = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f11491c = false;

    /* renamed from: com.didi.beatles.im.task.IMUploadQueue$UploadCallback */
    public interface UploadCallback {
        void uploadFail(IMMessage iMMessage);

        void uploadSuccess(GiftUploadResponse giftUploadResponse, IMMessage iMMessage);
    }

    public static IMUploadQueue getInstance() {
        if (f11489d == null) {
            synchronized (IMUploadQueue.class) {
                if (f11489d == null) {
                    f11489d = new IMUploadQueue();
                }
            }
        }
        return f11489d;
    }

    private IMUploadQueue() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean offer(com.didi.beatles.p101im.module.entity.IMMessage r3, com.didi.beatles.p101im.task.IMUploadQueue.UploadCallback r4) {
        /*
            r2 = this;
            java.util.Queue<com.didi.beatles.im.task.IMUploadQueue$TaskItem> r0 = r2.f11490b
            monitor-enter(r0)
            com.didi.beatles.im.task.IMUploadQueue$TaskItem r1 = new com.didi.beatles.im.task.IMUploadQueue$TaskItem     // Catch:{ all -> 0x0021 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0021 }
            java.util.Queue<com.didi.beatles.im.task.IMUploadQueue$TaskItem> r3 = r2.f11490b     // Catch:{ all -> 0x0021 }
            boolean r3 = r3.offer(r1)     // Catch:{ all -> 0x0021 }
            if (r3 == 0) goto L_0x001e
            java.util.Queue<com.didi.beatles.im.task.IMUploadQueue$TaskItem> r3 = r2.f11490b     // Catch:{ all -> 0x0021 }
            int r3 = r3.size()     // Catch:{ all -> 0x0021 }
            r4 = 1
            if (r3 != r4) goto L_0x001c
            r2.m9912c()     // Catch:{ all -> 0x0021 }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return r4
        L_0x001e:
            r3 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return r3
        L_0x0021:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.task.IMUploadQueue.offer(com.didi.beatles.im.module.entity.IMMessage, com.didi.beatles.im.task.IMUploadQueue$UploadCallback):boolean");
    }

    /* renamed from: b */
    private TaskItem m9911b() {
        TaskItem poll;
        synchronized (this.f11490b) {
            poll = this.f11490b.poll();
        }
        return poll;
    }

    public boolean isEmpty() {
        return this.f11490b.isEmpty();
    }

    public void destory() {
        Queue<TaskItem> queue = this.f11490b;
        if (queue != null) {
            queue.clear();
            this.f11490b = null;
        }
        if (f11489d != null) {
            f11489d = null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m9912c() {
        /*
            r5 = this;
            java.util.Queue<com.didi.beatles.im.task.IMUploadQueue$TaskItem> r0 = r5.f11490b
            monitor-enter(r0)
            boolean r1 = r5.f11491c     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x0010
            java.lang.String r1 = f11488a     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "loop is running,return"
            com.didi.beatles.p101im.utils.IMLog.m10020d(r1, r2)     // Catch:{ all -> 0x004d }
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x0010:
            com.didi.beatles.im.task.IMUploadQueue$TaskItem r1 = r5.m9911b()     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x0048
            java.lang.String r2 = f11488a     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r3.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "start upload file "
            r3.append(r4)     // Catch:{ all -> 0x004d }
            com.didi.beatles.im.module.entity.IMMessage r4 = r1.message     // Catch:{ all -> 0x004d }
            java.lang.String r4 = r4.getFile_name()     // Catch:{ all -> 0x004d }
            r3.append(r4)     // Catch:{ all -> 0x004d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x004d }
            com.didi.beatles.p101im.utils.IMLog.m10020d(r2, r3)     // Catch:{ all -> 0x004d }
            r2 = 1
            r5.f11491c = r2     // Catch:{ all -> 0x004d }
            com.didi.beatles.im.net.IMHttpManager r2 = com.didi.beatles.p101im.net.IMHttpManager.getInstance()     // Catch:{ all -> 0x004d }
            com.didi.beatles.im.module.entity.IMMessage r3 = r1.message     // Catch:{ all -> 0x004d }
            java.lang.String r3 = r3.getFile_name()     // Catch:{ all -> 0x004d }
            com.didi.beatles.im.task.IMUploadQueue$1 r4 = new com.didi.beatles.im.task.IMUploadQueue$1     // Catch:{ all -> 0x004d }
            r4.<init>(r1)     // Catch:{ all -> 0x004d }
            r2.upLoadImage(r3, r4)     // Catch:{ all -> 0x004d }
            goto L_0x004b
        L_0x0048:
            r1 = 0
            r5.f11491c = r1     // Catch:{ all -> 0x004d }
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x004d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.task.IMUploadQueue.m9912c():void");
    }

    /* renamed from: com.didi.beatles.im.task.IMUploadQueue$TaskItem */
    public class TaskItem {
        UploadCallback callback;
        IMMessage message;

        public TaskItem(IMMessage iMMessage, UploadCallback uploadCallback) {
            this.message = iMMessage;
            this.callback = uploadCallback;
        }
    }
}
