package com.didi.sdk.audiorecorder.service.multiprocess.socket;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.text.TextUtils;
import com.didi.sdk.audiorecorder.utils.ByteArrayAllocator;
import com.didi.sdk.audiorecorder.utils.IOUtil;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataTransferClient {

    /* renamed from: a */
    private static final String f38303a = "DataTransferClient -> ";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Set<DataReceivedListener> f38304b = Collections.newSetFromMap(new HashMap());

    /* renamed from: c */
    private String f38305c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f38306d;

    /* renamed from: e */
    private LocalSocket f38307e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public InputStream f38308f;

    /* renamed from: g */
    private Thread f38309g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f38310h;

    public interface DataReceivedListener {
        void onReceived(byte[] bArr, int i);
    }

    public DataTransferClient(String str, int i) {
        this.f38305c = str;
        this.f38306d = i;
        LogUtil.log(f38303a, "setup. server = ", str, ", mReadBuffSize = " + i);
    }

    public void addDataReceivedListener(DataReceivedListener dataReceivedListener) {
        this.f38304b.add(dataReceivedListener);
    }

    public void removeDataReceivedListener(DataReceivedListener dataReceivedListener) {
        this.f38304b.remove(dataReceivedListener);
    }

    public void updateServerName(String str) {
        if (!m28885a(str)) {
            this.f38305c = str;
            if (this.f38307e != null) {
                disconnect();
                connect();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r2 = r1.f38307e;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m28885a(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = r1.f38305c
            boolean r2 = android.text.TextUtils.equals(r0, r2)
            if (r2 == 0) goto L_0x0014
            android.net.LocalSocket r2 = r1.f38307e
            if (r2 == 0) goto L_0x0014
            boolean r2 = r2.isConnected()
            if (r2 == 0) goto L_0x0014
            r2 = 1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.service.multiprocess.socket.DataTransferClient.m28885a(java.lang.String):boolean");
    }

    public void connect() {
        if (!this.f38310h && !TextUtils.isEmpty(this.f38305c)) {
            LocalSocket localSocket = this.f38307e;
            if (localSocket == null || !localSocket.isConnected()) {
                try {
                    LocalSocket localSocket2 = new LocalSocket();
                    this.f38307e = localSocket2;
                    localSocket2.connect(new LocalSocketAddress(this.f38305c));
                    this.f38308f = this.f38307e.getInputStream();
                    this.f38310h = true;
                    LogUtil.log(f38303a, "connect to server: " + this.f38305c);
                    if (this.f38308f != null) {
                        ReceiveDataThread receiveDataThread = new ReceiveDataThread();
                        this.f38309g = receiveDataThread;
                        receiveDataThread.start();
                    }
                } catch (Exception e) {
                    LogUtil.log("DataTransferClient -> failed to connect server: " + this.f38305c, e);
                }
            }
        }
    }

    public void disconnect() {
        if (this.f38310h) {
            this.f38310h = false;
            LocalSocket localSocket = this.f38307e;
            if (localSocket != null) {
                try {
                    localSocket.close();
                } catch (IOException unused) {
                }
                this.f38307e = null;
            }
            InputStream inputStream = this.f38308f;
            if (inputStream != null) {
                IOUtil.close(inputStream);
                this.f38308f = null;
            }
            Thread thread = this.f38309g;
            if (thread != null) {
                thread.interrupt();
                this.f38309g = null;
            }
            LogUtil.log(f38303a, "disconnect from server: " + this.f38305c);
        }
    }

    private class ReceiveDataThread extends Thread {
        private final byte[] buffer = new byte[DataTransferClient.this.f38306d];

        public ReceiveDataThread() {
            super("didi-recorder-data-transfer-client");
            setPriority(1);
        }

        public void run() {
            InputStream c;
            int i;
            byte[] allocate;
            super.run();
            LogUtil.log(DataTransferClient.f38303a, "start receive server data.");
            while (DataTransferClient.this.f38310h && (c = DataTransferClient.this.f38308f) != null) {
                try {
                    i = c.read(this.buffer);
                } catch (IOException unused) {
                    i = 0;
                }
                if (i <= 0 || (allocate = ByteArrayAllocator.allocate(i)) == null) {
                    break;
                }
                try {
                    System.arraycopy(this.buffer, 0, allocate, 0, i);
                    dispatch(allocate, i);
                } catch (Exception e) {
                    LogUtil.log("DataTransferClient -> Failed to dispatch server data. ", e);
                }
            }
            LogUtil.log(DataTransferClient.f38303a, "stop receive server data.");
        }

        private void dispatch(byte[] bArr, int i) {
            Iterator it = DataTransferClient.this.f38304b.iterator();
            while (it.hasNext()) {
                DataReceivedListener dataReceivedListener = (DataReceivedListener) it.next();
                if (dataReceivedListener == null) {
                    it.remove();
                } else {
                    dataReceivedListener.onReceived(bArr, i);
                }
            }
        }
    }
}
