package com.koushikdutta.async.stream;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import java.io.InputStream;

public class InputStreamDataEmitter implements DataEmitter {

    /* renamed from: a */
    AsyncServer f58284a;

    /* renamed from: b */
    InputStream f58285b;

    /* renamed from: c */
    DataCallback f58286c;

    /* renamed from: d */
    boolean f58287d;

    /* renamed from: e */
    int f58288e = 0;

    /* renamed from: f */
    ByteBufferList f58289f = new ByteBufferList();

    /* renamed from: g */
    Runnable f58290g = new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:10:0x004d A[Catch:{ Exception -> 0x007e }] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0046 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.ByteBufferList r0 = r0.f58289f     // Catch:{ Exception -> 0x007e }
                boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x007e }
                if (r0 != 0) goto L_0x0023
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.AsyncServer r0 = r0.getServer()     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.stream.InputStreamDataEmitter$2$1 r1 = new com.koushikdutta.async.stream.InputStreamDataEmitter$2$1     // Catch:{ Exception -> 0x007e }
                r1.<init>()     // Catch:{ Exception -> 0x007e }
                r0.run(r1)     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.ByteBufferList r0 = r0.f58289f     // Catch:{ Exception -> 0x007e }
                boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x007e }
                if (r0 != 0) goto L_0x0023
                return
            L_0x0023:
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                int r0 = r0.f58288e     // Catch:{ Exception -> 0x007e }
                r1 = 4096(0x1000, float:5.74E-42)
                int r0 = java.lang.Math.max(r0, r1)     // Catch:{ Exception -> 0x007e }
                r1 = 262144(0x40000, float:3.67342E-40)
                int r0 = java.lang.Math.min(r0, r1)     // Catch:{ Exception -> 0x007e }
                java.nio.ByteBuffer r0 = com.koushikdutta.async.ByteBufferList.obtain(r0)     // Catch:{ Exception -> 0x007e }
                r1 = -1
                com.koushikdutta.async.stream.InputStreamDataEmitter r2 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                java.io.InputStream r2 = r2.f58285b     // Catch:{ Exception -> 0x007e }
                byte[] r3 = r0.array()     // Catch:{ Exception -> 0x007e }
                int r2 = r2.read(r3)     // Catch:{ Exception -> 0x007e }
                if (r1 != r2) goto L_0x004d
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                r1 = 0
                r0.m44193a(r1)     // Catch:{ Exception -> 0x007e }
                return
            L_0x004d:
                com.koushikdutta.async.stream.InputStreamDataEmitter r1 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                int r3 = r2 * 2
                r1.f58288e = r3     // Catch:{ Exception -> 0x007e }
                r0.limit(r2)     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.stream.InputStreamDataEmitter r1 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.ByteBufferList r1 = r1.f58289f     // Catch:{ Exception -> 0x007e }
                r1.add((java.nio.ByteBuffer) r0)     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.AsyncServer r0 = r0.getServer()     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.stream.InputStreamDataEmitter$2$2 r1 = new com.koushikdutta.async.stream.InputStreamDataEmitter$2$2     // Catch:{ Exception -> 0x007e }
                r1.<init>()     // Catch:{ Exception -> 0x007e }
                r0.run(r1)     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.ByteBufferList r0 = r0.f58289f     // Catch:{ Exception -> 0x007e }
                int r0 = r0.remaining()     // Catch:{ Exception -> 0x007e }
                if (r0 != 0) goto L_0x0084
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                boolean r0 = r0.isPaused()     // Catch:{ Exception -> 0x007e }
                if (r0 == 0) goto L_0x0023
                goto L_0x0084
            L_0x007e:
                r0 = move-exception
                com.koushikdutta.async.stream.InputStreamDataEmitter r1 = com.koushikdutta.async.stream.InputStreamDataEmitter.this
                r1.m44193a(r0)
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.stream.InputStreamDataEmitter.C212382.run():void");
        }
    };

    /* renamed from: h */
    CompletedCallback f58291h;

    public String charset() {
        return null;
    }

    public boolean isChunked() {
        return false;
    }

    public InputStreamDataEmitter(AsyncServer asyncServer, InputStream inputStream) {
        this.f58284a = asyncServer;
        this.f58285b = inputStream;
        m44191a();
    }

    public void setDataCallback(DataCallback dataCallback) {
        this.f58286c = dataCallback;
    }

    public DataCallback getDataCallback() {
        return this.f58286c;
    }

    public void pause() {
        this.f58287d = true;
    }

    public void resume() {
        this.f58287d = false;
        m44191a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m44193a(final Exception exc) {
        getServer().post(new Runnable() {
            public void run() {
                Exception e = exc;
                try {
                    InputStreamDataEmitter.this.f58285b.close();
                } catch (Exception e2) {
                    e = e2;
                }
                if (InputStreamDataEmitter.this.f58291h != null) {
                    InputStreamDataEmitter.this.f58291h.onCompleted(e);
                }
            }
        });
    }

    /* renamed from: a */
    private void m44191a() {
        new Thread(this.f58290g).start();
    }

    public boolean isPaused() {
        return this.f58287d;
    }

    public void setEndCallback(CompletedCallback completedCallback) {
        this.f58291h = completedCallback;
    }

    public CompletedCallback getEndCallback() {
        return this.f58291h;
    }

    public AsyncServer getServer() {
        return this.f58284a;
    }

    public void close() {
        m44193a((Exception) null);
        try {
            this.f58285b.close();
        } catch (Exception unused) {
        }
    }
}
