package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* renamed from: com.koushikdutta.async.e */
/* compiled from: SocketChannelWrapper */
class C21136e extends C21130a {

    /* renamed from: a */
    SocketChannel f58092a;

    /* renamed from: f */
    public InetAddress mo173231f() {
        return this.f58092a.socket().getLocalAddress();
    }

    /* renamed from: e */
    public int mo173230e() {
        return this.f58092a.socket().getLocalPort();
    }

    C21136e(SocketChannel socketChannel) throws IOException {
        super(socketChannel);
        this.f58092a = socketChannel;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        return this.f58092a.read(byteBuffer);
    }

    /* renamed from: c */
    public boolean mo173227c() {
        return this.f58092a.isConnected();
    }

    /* renamed from: a */
    public int mo173221a(ByteBuffer byteBuffer) throws IOException {
        return this.f58092a.write(byteBuffer);
    }

    /* renamed from: a */
    public int mo173222a(ByteBuffer[] byteBufferArr) throws IOException {
        return (int) this.f58092a.write(byteBufferArr);
    }

    /* renamed from: a */
    public SelectionKey mo173223a(Selector selector) throws ClosedChannelException {
        return mo173224a(selector, 8);
    }

    /* renamed from: b */
    public void mo173226b() {
        try {
            this.f58092a.socket().shutdownOutput();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void mo173225a() {
        try {
            this.f58092a.socket().shutdownInput();
        } catch (Exception unused) {
        }
    }

    public long read(ByteBuffer[] byteBufferArr) throws IOException {
        return this.f58092a.read(byteBufferArr);
    }

    public long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
        return this.f58092a.read(byteBufferArr, i, i2);
    }

    /* renamed from: g */
    public Object mo173232g() {
        return this.f58092a.socket();
    }
}
