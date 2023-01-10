package com.didi.sdk.audiorecorder.service.multiprocess.socket;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.didi.sdk.audiorecorder.AudioRecordManager;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.utils.IOUtil;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import com.didi.sdk.audiorecorder.utils.TextUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

public class DataTransferServer implements Supporter.Pcm16kConsumer {

    /* renamed from: a */
    private static final String f38311a = "DataTransferServer -> ";

    /* renamed from: b */
    private static final String f38312b = "com.didi.sdk.DidiRecorder";

    /* renamed from: c */
    private static final int f38313c = 5;

    /* renamed from: d */
    private final ExecutorService f38314d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final LinkedBlockingQueue<Bytes> f38315e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Set<ClientConnection> f38316f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile Future<LocalServerSocket> f38317g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile boolean f38318h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile String f38319i;

    /* renamed from: j */
    private Supporter.Pcm16kProvider f38320j;

    public interface AcquireServerNameCallback {
        void onAcquired(String str);
    }

    public void onPcm16kFeed(byte[] bArr, int i) {
        this.f38315e.add(new Bytes(bArr));
    }

    public void setPcm16kProvider(Supporter.Pcm16kProvider pcm16kProvider) {
        this.f38320j = pcm16kProvider;
    }

    private static final class Singleton {
        /* access modifiers changed from: private */
        public static final DataTransferServer INSTANCE = new DataTransferServer();

        private Singleton() {
        }
    }

    private DataTransferServer() {
        this.f38315e = new LinkedBlockingQueue<>();
        this.f38316f = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f38314d = Executors.newCachedThreadPool(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "didi-recorder-data-transfer-server");
            }
        });
    }

    public static DataTransferServer getInstance() {
        return Singleton.INSTANCE;
    }

    public synchronized DataTransferServer startServer() {
        if (!this.f38318h) {
            this.f38318h = true;
            this.f38317g = this.f38314d.submit(new EstablishServerSocketTask());
            this.f38314d.submit(new ClientAcceptTask(this.f38317g));
            this.f38314d.submit(new DispatchDataTask());
        }
        return this;
    }

    public void acquireServerName(final AcquireServerNameCallback acquireServerNameCallback) {
        if (!this.f38318h) {
            acquireServerNameCallback.onAcquired((String) null);
        } else if (!TextUtil.isEmpty(this.f38319i)) {
            acquireServerNameCallback.onAcquired(this.f38319i);
        } else {
            this.f38314d.submit(new Runnable() {
                public void run() {
                    String unused = DataTransferServer.this.f38319i = getServerName();
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            acquireServerNameCallback.onAcquired(DataTransferServer.this.f38319i);
                        }
                    });
                }

                private String getServerName() {
                    if (DataTransferServer.this.f38317g == null) {
                        return null;
                    }
                    try {
                        return ((LocalServerSocket) DataTransferServer.this.f38317g.get()).getLocalSocketAddress().getName();
                    } catch (Exception e) {
                        LogUtil.log(DataTransferServer.f38311a, "Failed to acquire server name!" + e.getMessage());
                        return null;
                    }
                }
            });
        }
    }

    public void writeData(byte[] bArr) {
        writeData(bArr, 0, bArr.length);
    }

    public void writeData(byte[] bArr, int i, int i2) {
        if (this.f38316f.size() != 0 && bArr != null && bArr.length > 0 && i >= 0 && i2 > 0) {
            try {
                this.f38315e.put(new Bytes(bArr, i, i2));
            } catch (Exception unused) {
            }
        }
    }

    public void clearTtsDataCache() {
        AudioRecordManager.get().clearTTSData();
    }

    public void stopServer() {
        if (this.f38318h) {
            this.f38318h = false;
            this.f38319i = null;
            if (this.f38317g != null) {
                try {
                    this.f38317g.get().close();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.f38317g = null;
                    throw th;
                }
                this.f38317g = null;
            }
            for (ClientConnection close : this.f38316f) {
                close.close();
            }
            this.f38316f.clear();
            this.f38315e.clear();
        }
    }

    private class ClientConnection {
        private int mFailCount;
        private InputStream mInputStream;
        private OutputStream mOutputStream;
        private LocalSocket mSocket;

        ClientConnection(LocalSocket localSocket) throws IOException {
            this.mSocket = localSocket;
            this.mInputStream = localSocket.getInputStream();
            this.mOutputStream = localSocket.getOutputStream();
        }

        public boolean isConnected() {
            return (this.mSocket == null || this.mInputStream == null || this.mOutputStream == null) ? false : true;
        }

        public int hashCode() {
            return this.mSocket.hashCode();
        }

        public boolean equals(Object obj) {
            return obj != null && obj.hashCode() == hashCode();
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean sendData(com.didi.sdk.audiorecorder.service.multiprocess.socket.DataTransferServer.Bytes r8) {
            /*
                r7 = this;
                r0 = 1
                r1 = 5
                r2 = 0
                java.io.OutputStream r3 = r7.mOutputStream     // Catch:{ IOException -> 0x001d }
                byte[] r4 = r8.data     // Catch:{ IOException -> 0x001d }
                int r5 = r8.offset     // Catch:{ IOException -> 0x001d }
                int r6 = r8.len     // Catch:{ IOException -> 0x001d }
                r3.write(r4, r5, r6)     // Catch:{ IOException -> 0x001d }
                r7.mFailCount = r2     // Catch:{ IOException -> 0x0018 }
                if (r2 < r1) goto L_0x004d
                r7.mFailCount = r2
                r7.close()
                goto L_0x004d
            L_0x0018:
                r3 = move-exception
                r4 = 1
                goto L_0x001f
            L_0x001b:
                r8 = move-exception
                goto L_0x004e
            L_0x001d:
                r3 = move-exception
                r4 = 0
            L_0x001f:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x001b }
                r5.<init>()     // Catch:{ all -> 0x001b }
                java.lang.String r6 = "DataTransferServer -> sendData failed. len = "
                r5.append(r6)     // Catch:{ all -> 0x001b }
                byte[] r8 = r8.data     // Catch:{ all -> 0x001b }
                int r8 = r8.length     // Catch:{ all -> 0x001b }
                r5.append(r8)     // Catch:{ all -> 0x001b }
                java.lang.String r8 = ", mFailCount = "
                r5.append(r8)     // Catch:{ all -> 0x001b }
                int r8 = r7.mFailCount     // Catch:{ all -> 0x001b }
                r5.append(r8)     // Catch:{ all -> 0x001b }
                java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x001b }
                com.didi.sdk.audiorecorder.utils.LogUtil.log(r8, r3)     // Catch:{ all -> 0x001b }
                int r8 = r7.mFailCount     // Catch:{ all -> 0x001b }
                int r8 = r8 + r0
                r7.mFailCount = r8     // Catch:{ all -> 0x001b }
                if (r8 < r1) goto L_0x004c
                r7.mFailCount = r2
                r7.close()
            L_0x004c:
                r0 = r4
            L_0x004d:
                return r0
            L_0x004e:
                int r0 = r7.mFailCount
                if (r0 < r1) goto L_0x0057
                r7.mFailCount = r2
                r7.close()
            L_0x0057:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.service.multiprocess.socket.DataTransferServer.ClientConnection.sendData(com.didi.sdk.audiorecorder.service.multiprocess.socket.DataTransferServer$Bytes):boolean");
        }

        public void close() {
            LogUtil.log(DataTransferServer.f38311a, "close");
            try {
                this.mSocket.close();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.mSocket = null;
                throw th;
            }
            this.mSocket = null;
            IOUtil.closeQuitely(this.mInputStream);
            this.mInputStream = null;
            IOUtil.closeQuitely(this.mOutputStream);
            this.mOutputStream = null;
        }
    }

    private class EstablishServerSocketTask implements Callable<LocalServerSocket> {
        private EstablishServerSocketTask() {
        }

        public LocalServerSocket call() {
            int myPid = Process.myPid();
            LocalServerSocket localServerSocket = null;
            while (localServerSocket == null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(DataTransferServer.f38312b);
                    myPid++;
                    sb.append(myPid);
                    localServerSocket = new LocalServerSocket(sb.toString());
                } catch (IOException unused) {
                    LogUtil.log(DataTransferServer.f38311a, "Failed to generate server socket. magicNum = " + myPid);
                }
            }
            LogUtil.log(DataTransferServer.f38311a, "Succeed in generating server socket: ", localServerSocket.getLocalSocketAddress().getName());
            return localServerSocket;
        }
    }

    private class ClientAcceptTask implements Runnable {
        private Future<LocalServerSocket> mSocketFuture;

        ClientAcceptTask(Future<LocalServerSocket> future) {
            this.mSocketFuture = future;
        }

        public void run() {
            try {
                LocalServerSocket localServerSocket = this.mSocketFuture.get();
                while (localServerSocket != null) {
                    DataTransferServer.this.f38316f.add(new ClientConnection(localServerSocket.accept()));
                    LogUtil.log(DataTransferServer.f38311a, "Succeed in accepting client... " + DataTransferServer.this.f38316f.size());
                }
            } catch (Exception unused) {
                LogUtil.log(DataTransferServer.f38311a, "failed to accept client!");
                DataTransferServer.this.stopServer();
            }
        }
    }

    private class DispatchDataTask implements Runnable {
        private DispatchDataTask() {
        }

        public void run() {
            while (DataTransferServer.this.f38318h) {
                Bytes takeBytes = takeBytes();
                if (DataTransferServer.this.f38318h && takeBytes != null) {
                    dispatch(takeBytes);
                }
            }
        }

        private Bytes takeBytes() {
            try {
                return (Bytes) DataTransferServer.this.f38315e.take();
            } catch (InterruptedException unused) {
                return null;
            }
        }

        private void dispatch(Bytes bytes) {
            Iterator it = DataTransferServer.this.f38316f.iterator();
            while (it.hasNext()) {
                ClientConnection clientConnection = (ClientConnection) it.next();
                if (clientConnection == null || !clientConnection.isConnected()) {
                    it.remove();
                } else if (!clientConnection.sendData(bytes)) {
                    it.remove();
                }
            }
        }
    }

    private static class Bytes {
        byte[] data;
        int len;
        int offset;

        Bytes(byte[] bArr) {
            int i;
            this.data = bArr;
            if (bArr == null) {
                i = 0;
            } else {
                i = bArr.length;
            }
            this.len = i;
        }

        Bytes(byte[] bArr, int i, int i2) {
            this.data = bArr;
            this.len = i2;
            this.offset = i;
        }
    }
}
