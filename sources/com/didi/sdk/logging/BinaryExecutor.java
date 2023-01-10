package com.didi.sdk.logging;

import com.didi.sdk.logging.model.AbstractLog;
import com.didi.sdk.logging.util.Debug;
import com.didi.sdk.logging.util.LoggerUtils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

class BinaryExecutor {

    /* renamed from: a */
    private static final int f39235a = 1024;

    /* renamed from: b */
    private static final Map<String, BinaryExecutor> f39236b = Collections.synchronizedMap(new HashMap());

    /* renamed from: c */
    private final C13214a f39237c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final BlockingQueue<AbstractLog> f39238d;

    /* renamed from: e */
    private final Worker f39239e;

    /* renamed from: f */
    private final Object f39240f = new Object();

    /* renamed from: g */
    private File f39241g;

    /* renamed from: h */
    private OutputStream f39242h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final AtomicBoolean f39243i = new AtomicBoolean(false);

    /* renamed from: a */
    public static BinaryExecutor m29577a(String str) {
        BinaryExecutor binaryExecutor = f39236b.get(str);
        if (binaryExecutor == null) {
            synchronized (f39236b) {
                if (binaryExecutor == null) {
                    binaryExecutor = new BinaryExecutor(str);
                    f39236b.put(str, binaryExecutor);
                }
            }
        }
        return binaryExecutor;
    }

    private BinaryExecutor(String str) {
        this.f39239e = new Worker("logger-binary-" + str);
        this.f39238d = new ArrayBlockingQueue(1024);
        this.f39237c = new C13226g(Type.BINARY, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo98928a(AbstractLog abstractLog) {
        if (abstractLog != null) {
            if (this.f39243i.compareAndSet(false, true)) {
                m29579a();
            }
            if (LoggerUtils.isMainThread()) {
                this.f39238d.offer(abstractLog);
                return;
            }
            try {
                this.f39238d.put(abstractLog);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* renamed from: a */
    private void m29579a() {
        this.f39237c.mo99014a(System.currentTimeMillis());
        File file = new File(this.f39237c.mo99016b());
        this.f39241g = file;
        try {
            m29581a(file);
        } catch (IOException e) {
            Debug.logOrThrow("start work thread openFile IOException ", e);
        }
        m29584b();
    }

    /* renamed from: b */
    private void m29584b() {
        this.f39239e.setDaemon(true);
        this.f39239e.start();
    }

    class Worker extends Thread {
        Worker(String str) {
            super(str);
        }

        public void run() {
            while (BinaryExecutor.this.f39243i.get()) {
                try {
                    AbstractLog abstractLog = (AbstractLog) BinaryExecutor.this.f39238d.take();
                    if (abstractLog != null) {
                        try {
                            BinaryExecutor.this.m29582a(abstractLog.getData());
                        } catch (IOException e) {
                            Debug.m29708e("writeToFile failed e = " + e);
                        }
                    }
                } catch (InterruptedException e2) {
                    Debug.m29708e("writeToFile failed e = " + e2);
                }
            }
        }
    }

    /* renamed from: c */
    private void m29585c() {
        synchronized (this.f39240f) {
            m29586d();
            this.f39237c.mo99013a();
            File file = new File(this.f39237c.mo99016b());
            this.f39241g = file;
            try {
                m29581a(file);
            } catch (IOException e) {
                Debug.m29708e("rollover openFile IOException e = " + e);
            }
        }
    }

    /* renamed from: a */
    private void m29581a(File file) throws IOException {
        synchronized (this.f39240f) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            this.f39242h = new C13225f(file, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29582a(byte[] bArr) throws IOException {
        if (this.f39237c.mo99015a(this.f39241g)) {
            m29585c();
        }
        OutputStream outputStream = this.f39242h;
        if (outputStream != null && bArr != null && bArr.length != 0) {
            outputStream.write(bArr);
            this.f39242h.flush();
        }
    }

    /* renamed from: d */
    private void m29586d() {
        OutputStream outputStream = this.f39242h;
        if (outputStream != null) {
            try {
                outputStream.close();
                this.f39242h = null;
            } catch (IOException unused) {
            }
        }
    }
}
