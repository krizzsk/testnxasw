package com.koushikdutta.async;

import com.didi.sdk.apm.SystemUtils;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.util.Allocator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class AsyncNetworkSocket implements AsyncSocket {

    /* renamed from: j */
    static final /* synthetic */ boolean f57980j = (!AsyncNetworkSocket.class.desiredAssertionStatus());

    /* renamed from: a */
    InetSocketAddress f57981a;

    /* renamed from: b */
    Allocator f57982b;

    /* renamed from: c */
    boolean f57983c;

    /* renamed from: d */
    WritableCallback f57984d;

    /* renamed from: e */
    DataCallback f57985e;

    /* renamed from: f */
    CompletedCallback f57986f;

    /* renamed from: g */
    boolean f57987g;

    /* renamed from: h */
    Exception f57988h;

    /* renamed from: i */
    boolean f57989i = false;

    /* renamed from: k */
    private C21130a f57990k;

    /* renamed from: l */
    private SelectionKey f57991l;

    /* renamed from: m */
    private AsyncServer f57992m;

    /* renamed from: n */
    private ByteBufferList f57993n = new ByteBufferList();

    /* renamed from: o */
    private CompletedCallback f57994o;

    public String charset() {
        return null;
    }

    AsyncNetworkSocket() {
    }

    public void end() {
        this.f57990k.mo173226b();
    }

    public boolean isChunked() {
        return this.f57990k.mo173229d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo173023a(SocketChannel socketChannel, InetSocketAddress inetSocketAddress) throws IOException {
        this.f57981a = inetSocketAddress;
        this.f57982b = new Allocator();
        this.f57990k = new C21136e(socketChannel);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo173022a(DatagramChannel datagramChannel) throws IOException {
        this.f57990k = new C21131b(datagramChannel);
        this.f57982b = new Allocator(8192);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C21130a mo173019a() {
        return this.f57990k;
    }

    public void onDataWritable() {
        if (!this.f57990k.mo173229d()) {
            SelectionKey selectionKey = this.f57991l;
            selectionKey.interestOps(selectionKey.interestOps() & -5);
        }
        WritableCallback writableCallback = this.f57984d;
        if (writableCallback != null) {
            writableCallback.onWriteable();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo173020a(AsyncServer asyncServer, SelectionKey selectionKey) {
        this.f57992m = asyncServer;
        this.f57991l = selectionKey;
    }

    public void write(final ByteBufferList byteBufferList) {
        if (this.f57992m.getAffinity() != Thread.currentThread()) {
            this.f57992m.run(new Runnable() {
                public void run() {
                    AsyncNetworkSocket.this.write(byteBufferList);
                }
            });
        } else if (this.f57990k.mo173227c()) {
            try {
                int remaining = byteBufferList.remaining();
                ByteBuffer[] allArray = byteBufferList.getAllArray();
                this.f57990k.mo173222a(allArray);
                byteBufferList.addAll(allArray);
                m43866a(byteBufferList.remaining());
                this.f57992m.onDataSent(remaining - byteBufferList.remaining());
            } catch (IOException e) {
                m43867c();
                mo173025b(e);
                reportClose(e);
            }
        } else if (!f57980j && this.f57990k.mo173229d()) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private void m43866a(int i) throws IOException {
        if (!this.f57991l.isValid()) {
            throw new IOException(new CancelledKeyException());
        } else if (i <= 0) {
            SelectionKey selectionKey = this.f57991l;
            selectionKey.interestOps(selectionKey.interestOps() & -5);
        } else if (f57980j || !this.f57990k.mo173229d()) {
            SelectionKey selectionKey2 = this.f57991l;
            selectionKey2.interestOps(selectionKey2.interestOps() | 4);
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo173024b() {
        long j;
        int i;
        m43868d();
        boolean z = false;
        if (this.f57989i) {
            return 0;
        }
        ByteBuffer allocate = this.f57982b.allocate();
        try {
            j = (long) this.f57990k.read(allocate);
        } catch (Exception e) {
            m43867c();
            mo173025b(e);
            reportClose(e);
            j = -1;
        }
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            m43867c();
            z = true;
            i = 0;
        } else {
            i = (int) (((long) 0) + j);
        }
        if (i2 > 0) {
            this.f57982b.track(j);
            allocate.flip();
            this.f57993n.add(allocate);
            C21121Util.emitAllData(this, this.f57993n);
        } else {
            ByteBufferList.reclaim(allocate);
        }
        if (z) {
            mo173025b((Exception) null);
            reportClose((Exception) null);
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public void reportClose(Exception exc) {
        if (!this.f57983c) {
            this.f57983c = true;
            CompletedCallback completedCallback = this.f57986f;
            if (completedCallback != null) {
                completedCallback.onCompleted(exc);
                this.f57986f = null;
            }
        }
    }

    public void close() {
        m43867c();
        reportClose((Exception) null);
    }

    /* renamed from: c */
    private void m43867c() {
        this.f57991l.cancel();
        try {
            this.f57990k.close();
        } catch (IOException unused) {
        }
    }

    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f57984d = writableCallback;
    }

    public void setDataCallback(DataCallback dataCallback) {
        this.f57985e = dataCallback;
    }

    public DataCallback getDataCallback() {
        return this.f57985e;
    }

    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f57986f = completedCallback;
    }

    public CompletedCallback getClosedCallback() {
        return this.f57986f;
    }

    public WritableCallback getWriteableCallback() {
        return this.f57984d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo173021a(Exception exc) {
        if (!this.f57987g) {
            this.f57987g = true;
            CompletedCallback completedCallback = this.f57994o;
            if (completedCallback != null) {
                completedCallback.onCompleted(exc);
            } else if (exc != null) {
                SystemUtils.log(6, AsyncServer.LOGTAG, "Unhandled exception", exc, "com.koushikdutta.async.AsyncNetworkSocket", 243);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo173025b(Exception exc) {
        if (this.f57993n.hasRemaining()) {
            this.f57988h = exc;
        } else {
            mo173021a(exc);
        }
    }

    public void setEndCallback(CompletedCallback completedCallback) {
        this.f57994o = completedCallback;
    }

    public CompletedCallback getEndCallback() {
        return this.f57994o;
    }

    public boolean isOpen() {
        return this.f57990k.mo173227c() && this.f57991l.isValid();
    }

    public void pause() {
        if (this.f57992m.getAffinity() != Thread.currentThread()) {
            this.f57992m.run(new Runnable() {
                public void run() {
                    AsyncNetworkSocket.this.pause();
                }
            });
        } else if (!this.f57989i) {
            this.f57989i = true;
            try {
                this.f57991l.interestOps(this.f57991l.interestOps() & -2);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: d */
    private void m43868d() {
        if (this.f57993n.hasRemaining()) {
            C21121Util.emitAllData(this, this.f57993n);
        }
    }

    public void resume() {
        if (this.f57992m.getAffinity() != Thread.currentThread()) {
            this.f57992m.run(new Runnable() {
                public void run() {
                    AsyncNetworkSocket.this.resume();
                }
            });
        } else if (this.f57989i) {
            this.f57989i = false;
            try {
                this.f57991l.interestOps(this.f57991l.interestOps() | 1);
            } catch (Exception unused) {
            }
            m43868d();
            if (!isOpen()) {
                mo173025b(this.f57988h);
            }
        }
    }

    public boolean isPaused() {
        return this.f57989i;
    }

    public AsyncServer getServer() {
        return this.f57992m;
    }

    public InetSocketAddress getRemoteAddress() {
        return this.f57981a;
    }

    public InetAddress getLocalAddress() {
        return this.f57990k.mo173231f();
    }

    public int getLocalPort() {
        return this.f57990k.mo173230e();
    }

    public Object getSocket() {
        return mo173019a().mo173232g();
    }
}
