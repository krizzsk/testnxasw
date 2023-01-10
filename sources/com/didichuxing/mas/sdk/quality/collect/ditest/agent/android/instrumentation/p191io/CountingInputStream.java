package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.Agent;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.io.CountingInputStream */
public final class CountingInputStream extends InputStream implements StreamCompleteListenerSource {

    /* renamed from: f */
    private static final AgentLog f50554f = AgentLogManager.getAgentLog();

    /* renamed from: a */
    private final InputStream f50555a;

    /* renamed from: b */
    private long f50556b;

    /* renamed from: c */
    private final C16577a f50557c = new C16577a();

    /* renamed from: d */
    private final ByteBuffer f50558d;

    /* renamed from: e */
    private boolean f50559e = false;

    public CountingInputStream(InputStream inputStream) {
        this.f50555a = inputStream;
        if (0 != 0) {
            this.f50558d = ByteBuffer.allocate(Agent.getResponseBodyLimit());
            fillBuffer();
            return;
        }
        this.f50558d = null;
    }

    public CountingInputStream(InputStream inputStream, boolean z) {
        this.f50555a = inputStream;
        this.f50559e = z;
        if (z) {
            this.f50558d = ByteBuffer.allocate(Agent.getResponseBodyLimit());
            fillBuffer();
            return;
        }
        this.f50558d = null;
    }

    public void addStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.f50557c.mo124755a(streamCompleteListener);
    }

    public void removeStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.f50557c.mo124758b(streamCompleteListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read() throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r6.f50559e
            r1 = 1
            if (r0 == 0) goto L_0x0021
            java.nio.ByteBuffer r0 = r6.f50558d
            monitor-enter(r0)
            boolean r3 = r6.m37697a((long) r1)     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x001c
            int r3 = r6.m37693a()     // Catch:{ all -> 0x001e }
            if (r3 < 0) goto L_0x001a
            long r4 = r6.f50556b     // Catch:{ all -> 0x001e }
            long r4 = r4 + r1
            r6.f50556b = r4     // Catch:{ all -> 0x001e }
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return r3
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            goto L_0x0021
        L_0x001e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r1
        L_0x0021:
            java.io.InputStream r0 = r6.f50555a     // Catch:{ IOException -> 0x0033 }
            int r0 = r0.read()     // Catch:{ IOException -> 0x0033 }
            if (r0 < 0) goto L_0x002f
            long r3 = r6.f50556b     // Catch:{ IOException -> 0x0033 }
            long r3 = r3 + r1
            r6.f50556b = r3     // Catch:{ IOException -> 0x0033 }
            goto L_0x0032
        L_0x002f:
            r6.m37699c()     // Catch:{ IOException -> 0x0033 }
        L_0x0032:
            return r0
        L_0x0033:
            r0 = move-exception
            r6.m37696a((java.lang.Exception) r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io.CountingInputStream.read():int");
    }

    public int read(byte[] bArr) throws IOException {
        int length = bArr.length;
        int i = 0;
        if (this.f50559e) {
            synchronized (this.f50558d) {
                if (m37697a((long) length)) {
                    int a = m37694a(bArr);
                    if (a >= 0) {
                        this.f50556b += (long) a;
                        return a;
                    }
                    throw new IOException("readBufferBytes failed");
                }
                int remaining = this.f50558d.remaining();
                if (remaining > 0) {
                    i = m37695a(bArr, 0, remaining);
                    if (i >= 0) {
                        length -= i;
                        this.f50556b += (long) i;
                    } else {
                        throw new IOException("partial read from buffer failed");
                    }
                }
            }
        }
        try {
            int read = this.f50555a.read(bArr, i, length);
            if (read >= 0) {
                this.f50556b += (long) read;
                return read + i;
            } else if (i > 0) {
                return i;
            } else {
                m37699c();
                return read;
            }
        } catch (IOException e) {
            f50554f.error(e.toString());
            System.out.println("NOTIFY STREAM ERROR: " + e);
            e.printStackTrace();
            m37696a((Exception) e);
            throw e;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (this.f50559e) {
            synchronized (this.f50558d) {
                if (m37697a((long) i2)) {
                    int a = m37695a(bArr, i, i2);
                    if (a >= 0) {
                        this.f50556b += (long) a;
                        return a;
                    }
                    throw new IOException("readBufferBytes failed");
                }
                int remaining = this.f50558d.remaining();
                if (remaining > 0) {
                    i3 = m37695a(bArr, i, remaining);
                    if (i3 >= 0) {
                        i2 -= i3;
                        this.f50556b += (long) i3;
                    } else {
                        throw new IOException("partial read from buffer failed");
                    }
                }
            }
        }
        try {
            int read = this.f50555a.read(bArr, i + i3, i2);
            if (read >= 0) {
                this.f50556b += (long) read;
                return read + i3;
            } else if (i3 > 0) {
                return i3;
            } else {
                m37699c();
                return read;
            }
        } catch (IOException e) {
            m37696a((Exception) e);
            throw e;
        }
    }

    public long skip(long j) throws IOException {
        if (this.f50559e) {
            synchronized (this.f50558d) {
                if (m37697a(j)) {
                    this.f50558d.position((int) j);
                    this.f50556b += j;
                    return j;
                }
                j -= (long) this.f50558d.remaining();
                if (j > 0) {
                    this.f50558d.position(this.f50558d.remaining());
                } else {
                    throw new IOException("partial read from buffer (skip) failed");
                }
            }
        }
        try {
            long skip = this.f50555a.skip(j);
            this.f50556b += skip;
            return skip;
        } catch (IOException e) {
            m37696a((Exception) e);
            throw e;
        }
    }

    public int available() throws IOException {
        try {
            return (this.f50559e ? this.f50558d.remaining() : 0) + this.f50555a.available();
        } catch (IOException e) {
            m37696a((Exception) e);
            throw e;
        }
    }

    public void close() throws IOException {
        try {
            this.f50555a.close();
            m37699c();
        } catch (IOException e) {
            m37696a((Exception) e);
            throw e;
        }
    }

    public void mark(int i) {
        if (markSupported()) {
            this.f50555a.mark(i);
        }
    }

    public boolean markSupported() {
        return this.f50555a.markSupported();
    }

    public void reset() throws IOException {
        if (markSupported()) {
            try {
                this.f50555a.reset();
            } catch (IOException e) {
                m37696a((Exception) e);
                throw e;
            }
        }
    }

    /* renamed from: a */
    private int m37693a() {
        if (m37698b()) {
            return -1;
        }
        return this.f50558d.get();
    }

    /* renamed from: a */
    private int m37694a(byte[] bArr) {
        return m37695a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    private int m37695a(byte[] bArr, int i, int i2) {
        if (m37698b()) {
            return -1;
        }
        int remaining = this.f50558d.remaining();
        this.f50558d.get(bArr, i, i2);
        return remaining - this.f50558d.remaining();
    }

    /* renamed from: a */
    private boolean m37697a(long j) {
        return ((long) this.f50558d.remaining()) >= j;
    }

    /* renamed from: b */
    private boolean m37698b() {
        return !this.f50558d.hasRemaining();
    }

    public void fillBuffer() {
        int i;
        ByteBuffer byteBuffer = this.f50558d;
        if (byteBuffer != null && byteBuffer.hasArray()) {
            synchronized (this.f50558d) {
                try {
                    i = this.f50555a.read(this.f50558d.array(), 0, this.f50558d.capacity());
                } catch (IOException e) {
                    f50554f.error(e.toString());
                    i = 0;
                }
                if (i <= 0) {
                    this.f50558d.limit(0);
                } else if (i < this.f50558d.capacity()) {
                    this.f50558d.limit(i);
                }
            }
        }
    }

    /* renamed from: c */
    private void m37699c() {
        if (!this.f50557c.mo124756a()) {
            this.f50557c.mo124754a(new StreamCompleteEvent(this, this.f50556b));
        }
    }

    /* renamed from: a */
    private void m37696a(Exception exc) {
        if (!this.f50557c.mo124756a()) {
            this.f50557c.mo124757b(new StreamCompleteEvent(this, this.f50556b, exc));
        }
    }

    public void setBufferingEnabled(boolean z) {
        this.f50559e = z;
    }

    public String getBufferAsString() {
        String str;
        ByteBuffer byteBuffer = this.f50558d;
        if (byteBuffer == null) {
            return "";
        }
        synchronized (byteBuffer) {
            byte[] bArr = new byte[this.f50558d.limit()];
            for (int i = 0; i < this.f50558d.limit(); i++) {
                bArr[i] = this.f50558d.get(i);
            }
            str = new String(bArr);
        }
        return str;
    }
}
