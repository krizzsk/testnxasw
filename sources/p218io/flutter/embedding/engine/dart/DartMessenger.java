package p218io.flutter.embedding.engine.dart;

import androidx.tracing.Trace;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import p218io.flutter.FlutterInjector;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.FlutterJNI;
import p218io.flutter.embedding.engine.dart.DartMessenger;
import p218io.flutter.plugin.common.BinaryMessenger;

/* renamed from: io.flutter.embedding.engine.dart.DartMessenger */
class DartMessenger implements PlatformMessageHandler, BinaryMessenger {

    /* renamed from: a */
    private static final String f60378a = "DartMessenger";

    /* renamed from: b */
    private final FlutterJNI f60379b;

    /* renamed from: c */
    private final Map<String, HandlerInfo> f60380c;

    /* renamed from: d */
    private Map<String, List<BufferedMessageInfo>> f60381d;

    /* renamed from: e */
    private final Object f60382e;

    /* renamed from: f */
    private final AtomicBoolean f60383f;

    /* renamed from: g */
    private final Map<Integer, BinaryMessenger.BinaryReply> f60384g;

    /* renamed from: h */
    private int f60385h;

    /* renamed from: i */
    private final DartMessengerTaskQueue f60386i;

    /* renamed from: j */
    private WeakHashMap<BinaryMessenger.TaskQueue, DartMessengerTaskQueue> f60387j;

    /* renamed from: k */
    private TaskQueueFactory f60388k;

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$DartMessengerTaskQueue */
    interface DartMessengerTaskQueue {
        void dispatch(Runnable runnable);
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$TaskQueueFactory */
    interface TaskQueueFactory {
        DartMessengerTaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions);
    }

    public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        return BinaryMessenger.CC.$default$makeBackgroundTaskQueue(this);
    }

    DartMessenger(FlutterJNI flutterJNI, TaskQueueFactory taskQueueFactory) {
        this.f60380c = new HashMap();
        this.f60381d = new HashMap();
        this.f60382e = new Object();
        this.f60383f = new AtomicBoolean(false);
        this.f60384g = new HashMap();
        this.f60385h = 1;
        this.f60386i = new PlatformTaskQueue();
        this.f60387j = new WeakHashMap<>();
        this.f60379b = flutterJNI;
        this.f60388k = taskQueueFactory;
    }

    DartMessenger(FlutterJNI flutterJNI) {
        this(flutterJNI, new DefaultTaskQueueFactory());
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$TaskQueueToken */
    private static class TaskQueueToken implements BinaryMessenger.TaskQueue {
        private TaskQueueToken() {
        }
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$DefaultTaskQueueFactory */
    private static class DefaultTaskQueueFactory implements TaskQueueFactory {
        ExecutorService executorService = FlutterInjector.instance().executorService();

        DefaultTaskQueueFactory() {
        }

        public DartMessengerTaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
            if (taskQueueOptions.getIsSerial()) {
                return new SerialTaskQueue(this.executorService);
            }
            return new ConcurrentTaskQueue(this.executorService);
        }
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo */
    private static class HandlerInfo {
        public final BinaryMessenger.BinaryMessageHandler handler;
        public final DartMessengerTaskQueue taskQueue;

        HandlerInfo(BinaryMessenger.BinaryMessageHandler binaryMessageHandler, DartMessengerTaskQueue dartMessengerTaskQueue) {
            this.handler = binaryMessageHandler;
            this.taskQueue = dartMessengerTaskQueue;
        }
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$BufferedMessageInfo */
    private static class BufferedMessageInfo {
        public final ByteBuffer message;
        long messageData;
        int replyId;

        BufferedMessageInfo(ByteBuffer byteBuffer, int i, long j) {
            this.message = byteBuffer;
            this.replyId = i;
            this.messageData = j;
        }
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$ConcurrentTaskQueue */
    static class ConcurrentTaskQueue implements DartMessengerTaskQueue {
        private final ExecutorService executor;

        ConcurrentTaskQueue(ExecutorService executorService) {
            this.executor = executorService;
        }

        public void dispatch(Runnable runnable) {
            this.executor.execute(runnable);
        }
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$SerialTaskQueue */
    static class SerialTaskQueue implements DartMessengerTaskQueue {
        private final ExecutorService executor;
        private final AtomicBoolean isRunning = new AtomicBoolean(false);
        private final ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();

        SerialTaskQueue(ExecutorService executorService) {
            this.executor = executorService;
        }

        public void dispatch(Runnable runnable) {
            this.queue.add(runnable);
            this.executor.execute(new Runnable() {
                public final void run() {
                    DartMessenger.SerialTaskQueue.this.lambda$dispatch$0$DartMessenger$SerialTaskQueue();
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: flush */
        public void lambda$flush$1$DartMessenger$SerialTaskQueue() {
            if (this.isRunning.compareAndSet(false, true)) {
                try {
                    Runnable poll = this.queue.poll();
                    if (poll != null) {
                        poll.run();
                    }
                } finally {
                    this.isRunning.set(false);
                    if (!this.queue.isEmpty()) {
                        this.executor.execute(new Runnable() {
                            public final void run() {
                                DartMessenger.SerialTaskQueue.this.lambda$flush$1$DartMessenger$SerialTaskQueue();
                            }
                        });
                    }
                }
            }
        }
    }

    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        DartMessengerTaskQueue makeBackgroundTaskQueue = this.f60388k.makeBackgroundTaskQueue(taskQueueOptions);
        TaskQueueToken taskQueueToken = new TaskQueueToken();
        this.f60387j.put(taskQueueToken, makeBackgroundTaskQueue);
        return taskQueueToken;
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        setMessageHandler(str, binaryMessageHandler, (BinaryMessenger.TaskQueue) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
        r10 = r10.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007e, code lost:
        if (r10.hasNext() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
        r11 = (p218io.flutter.embedding.engine.dart.DartMessenger.BufferedMessageInfo) r10.next();
        m45552a(r9, r8.f60380c.get(r9), r11.message, r11.replyId, r11.messageData);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setMessageHandler(java.lang.String r9, p218io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler r10, p218io.flutter.plugin.common.BinaryMessenger.TaskQueue r11) {
        /*
            r8 = this;
            if (r10 != 0) goto L_0x002a
            java.lang.String r10 = "DartMessenger"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Removing handler for channel '"
            r11.append(r0)
            r11.append(r9)
            java.lang.String r0 = "'"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            p218io.flutter.Log.m45259v(r10, r11)
            java.lang.Object r0 = r8.f60382e
            monitor-enter(r0)
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r10 = r8.f60380c     // Catch:{ all -> 0x0027 }
            r10.remove(r9)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r9
        L_0x002a:
            r0 = 0
            if (r11 == 0) goto L_0x0041
            java.util.WeakHashMap<io.flutter.plugin.common.BinaryMessenger$TaskQueue, io.flutter.embedding.engine.dart.DartMessenger$DartMessengerTaskQueue> r0 = r8.f60387j
            java.lang.Object r11 = r0.get(r11)
            r0 = r11
            io.flutter.embedding.engine.dart.DartMessenger$DartMessengerTaskQueue r0 = (p218io.flutter.embedding.engine.dart.DartMessenger.DartMessengerTaskQueue) r0
            if (r0 == 0) goto L_0x0039
            goto L_0x0041
        L_0x0039:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue)."
            r9.<init>(r10)
            throw r9
        L_0x0041:
            java.lang.String r11 = "DartMessenger"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Setting handler for channel '"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = "'"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            p218io.flutter.Log.m45259v(r11, r1)
            java.lang.Object r11 = r8.f60382e
            monitor-enter(r11)
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r1 = r8.f60380c     // Catch:{ all -> 0x009c }
            io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo r2 = new io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo     // Catch:{ all -> 0x009c }
            r2.<init>(r10, r0)     // Catch:{ all -> 0x009c }
            r1.put(r9, r2)     // Catch:{ all -> 0x009c }
            java.util.Map<java.lang.String, java.util.List<io.flutter.embedding.engine.dart.DartMessenger$BufferedMessageInfo>> r10 = r8.f60381d     // Catch:{ all -> 0x009c }
            java.lang.Object r10 = r10.remove(r9)     // Catch:{ all -> 0x009c }
            java.util.List r10 = (java.util.List) r10     // Catch:{ all -> 0x009c }
            if (r10 != 0) goto L_0x0075
            monitor-exit(r11)     // Catch:{ all -> 0x009c }
            return
        L_0x0075:
            monitor-exit(r11)     // Catch:{ all -> 0x009c }
            java.util.Iterator r10 = r10.iterator()
        L_0x007a:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x009b
            java.lang.Object r11 = r10.next()
            io.flutter.embedding.engine.dart.DartMessenger$BufferedMessageInfo r11 = (p218io.flutter.embedding.engine.dart.DartMessenger.BufferedMessageInfo) r11
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r0 = r8.f60380c
            java.lang.Object r0 = r0.get(r9)
            r3 = r0
            io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo r3 = (p218io.flutter.embedding.engine.dart.DartMessenger.HandlerInfo) r3
            java.nio.ByteBuffer r4 = r11.message
            int r5 = r11.replyId
            long r6 = r11.messageData
            r1 = r8
            r2 = r9
            r1.m45552a(r2, r3, r4, r5, r6)
            goto L_0x007a
        L_0x009b:
            return
        L_0x009c:
            r9 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x009c }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.embedding.engine.dart.DartMessenger.setMessageHandler(java.lang.String, io.flutter.plugin.common.BinaryMessenger$BinaryMessageHandler, io.flutter.plugin.common.BinaryMessenger$TaskQueue):void");
    }

    public void enableBufferingIncomingMessages() {
        this.f60383f.set(true);
    }

    public void disableBufferingIncomingMessages() {
        Map<String, List<BufferedMessageInfo>> map;
        synchronized (this.f60382e) {
            this.f60383f.set(false);
            map = this.f60381d;
            this.f60381d = new HashMap();
        }
        for (Map.Entry next : map.entrySet()) {
            for (BufferedMessageInfo bufferedMessageInfo : (List) next.getValue()) {
                m45552a((String) next.getKey(), (HandlerInfo) null, bufferedMessageInfo.message, bufferedMessageInfo.replyId, bufferedMessageInfo.messageData);
            }
        }
    }

    public void send(String str, ByteBuffer byteBuffer) {
        Log.m45259v(f60378a, "Sending message over channel '" + str + "'");
        send(str, byteBuffer, (BinaryMessenger.BinaryReply) null);
    }

    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        Trace.beginSection("DartMessenger#send on " + str);
        Log.m45259v(f60378a, "Sending message with callback over channel '" + str + "'");
        try {
            int i = this.f60385h;
            this.f60385h = i + 1;
            if (binaryReply != null) {
                this.f60384g.put(Integer.valueOf(i), binaryReply);
            }
            if (byteBuffer == null) {
                this.f60379b.dispatchEmptyPlatformMessage(str, i);
            } else {
                this.f60379b.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i);
            }
        } finally {
            Trace.endSection();
        }
    }

    /* renamed from: a */
    private void m45550a(HandlerInfo handlerInfo, ByteBuffer byteBuffer, int i) {
        if (handlerInfo != null) {
            try {
                Log.m45259v(f60378a, "Deferring to registered handler to process message.");
                handlerInfo.handler.onMessage(byteBuffer, new Reply(this.f60379b, i));
            } catch (Exception e) {
                Log.m45256e(f60378a, "Uncaught exception in binary message listener", e);
                this.f60379b.invokePlatformMessageEmptyResponseCallback(i);
            } catch (Error e2) {
                m45551a(e2);
            }
        } else {
            Log.m45259v(f60378a, "No registered handler for message. Responding to Dart with empty reply message.");
            this.f60379b.invokePlatformMessageEmptyResponseCallback(i);
        }
    }

    /* renamed from: a */
    private void m45552a(String str, HandlerInfo handlerInfo, ByteBuffer byteBuffer, int i, long j) {
        HandlerInfo handlerInfo2 = handlerInfo;
        DartMessengerTaskQueue dartMessengerTaskQueue = handlerInfo2 != null ? handlerInfo2.taskQueue : null;
        $$Lambda$DartMessenger$3kX_ohgxwecVw1YG60ZOf3NN9OM r0 = new Runnable(str, handlerInfo, byteBuffer, i, j) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ DartMessenger.HandlerInfo f$2;
            public final /* synthetic */ ByteBuffer f$3;
            public final /* synthetic */ int f$4;
            public final /* synthetic */ long f$5;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void run() {
                DartMessenger.this.m45553b(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
            }
        };
        if (dartMessengerTaskQueue == null) {
            dartMessengerTaskQueue = this.f60386i;
        }
        dartMessengerTaskQueue.dispatch(r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m45553b(String str, HandlerInfo handlerInfo, ByteBuffer byteBuffer, int i, long j) {
        Trace.beginSection("DartMessenger#handleMessageFromDart on " + str);
        try {
            m45550a(handlerInfo, byteBuffer, i);
            if (byteBuffer != null && byteBuffer.isDirect()) {
                byteBuffer.limit(0);
            }
        } finally {
            this.f60379b.cleanupMessageData(j);
            Trace.endSection();
        }
    }

    public void handleMessageFromDart(String str, ByteBuffer byteBuffer, int i, long j) {
        HandlerInfo handlerInfo;
        boolean z;
        Log.m45259v(f60378a, "Received message from Dart over channel '" + str + "'");
        synchronized (this.f60382e) {
            handlerInfo = this.f60380c.get(str);
            z = this.f60383f.get() && handlerInfo == null;
            if (z) {
                if (!this.f60381d.containsKey(str)) {
                    this.f60381d.put(str, new LinkedList());
                }
                this.f60381d.get(str).add(new BufferedMessageInfo(byteBuffer, i, j));
            }
        }
        if (!z) {
            m45552a(str, handlerInfo, byteBuffer, i, j);
        }
    }

    public void handlePlatformMessageResponse(int i, ByteBuffer byteBuffer) {
        Log.m45259v(f60378a, "Received message reply from Dart.");
        BinaryMessenger.BinaryReply remove = this.f60384g.remove(Integer.valueOf(i));
        if (remove != null) {
            try {
                Log.m45259v(f60378a, "Invoking registered callback for reply from Dart.");
                remove.reply(byteBuffer);
                if (byteBuffer != null && byteBuffer.isDirect()) {
                    byteBuffer.limit(0);
                }
            } catch (Exception e) {
                Log.m45256e(f60378a, "Uncaught exception in binary message reply handler", e);
            } catch (Error e2) {
                m45551a(e2);
            }
        }
    }

    /* renamed from: a */
    public int mo182310a() {
        return this.f60384g.size();
    }

    /* renamed from: a */
    private static void m45551a(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() != null) {
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
            return;
        }
        throw error;
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$Reply */
    static class Reply implements BinaryMessenger.BinaryReply {
        private final AtomicBoolean done = new AtomicBoolean(false);
        private final FlutterJNI flutterJNI;
        private final int replyId;

        Reply(FlutterJNI flutterJNI2, int i) {
            this.flutterJNI = flutterJNI2;
            this.replyId = i;
        }

        public void reply(ByteBuffer byteBuffer) {
            if (this.done.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            } else if (byteBuffer == null) {
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(this.replyId);
            } else {
                this.flutterJNI.invokePlatformMessageResponseCallback(this.replyId, byteBuffer, byteBuffer.position());
            }
        }
    }
}
