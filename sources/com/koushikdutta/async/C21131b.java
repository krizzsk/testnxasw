package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/* renamed from: com.koushikdutta.async.b */
/* compiled from: DatagramChannelWrapper */
class C21131b extends C21130a {

    /* renamed from: a */
    DatagramChannel f58085a;

    /* renamed from: b */
    InetSocketAddress f58086b;

    /* renamed from: a */
    public void mo173225a() {
    }

    /* renamed from: b */
    public void mo173226b() {
    }

    /* renamed from: d */
    public boolean mo173229d() {
        return true;
    }

    /* renamed from: f */
    public InetAddress mo173231f() {
        return this.f58085a.socket().getLocalAddress();
    }

    /* renamed from: e */
    public int mo173230e() {
        return this.f58085a.socket().getLocalPort();
    }

    /* renamed from: h */
    public InetSocketAddress mo173234h() {
        return this.f58086b;
    }

    /* renamed from: i */
    public void mo173235i() throws IOException {
        this.f58085a.disconnect();
    }

    C21131b(DatagramChannel datagramChannel) throws IOException {
        super(datagramChannel);
        this.f58085a = datagramChannel;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        if (!mo173227c()) {
            int position = byteBuffer.position();
            InetSocketAddress inetSocketAddress = (InetSocketAddress) this.f58085a.receive(byteBuffer);
            this.f58086b = inetSocketAddress;
            if (inetSocketAddress == null) {
                return -1;
            }
            return byteBuffer.position() - position;
        }
        this.f58086b = null;
        return this.f58085a.read(byteBuffer);
    }

    /* renamed from: c */
    public boolean mo173227c() {
        return this.f58085a.isConnected();
    }

    /* renamed from: a */
    public int mo173221a(ByteBuffer byteBuffer) throws IOException {
        return this.f58085a.write(byteBuffer);
    }

    /* renamed from: a */
    public int mo173222a(ByteBuffer[] byteBufferArr) throws IOException {
        return (int) this.f58085a.write(byteBufferArr);
    }

    /* renamed from: a */
    public SelectionKey mo173224a(Selector selector, int i) throws ClosedChannelException {
        return this.f58085a.register(selector, i);
    }

    /* renamed from: a */
    public SelectionKey mo173223a(Selector selector) throws ClosedChannelException {
        return mo173224a(selector, 1);
    }

    public long read(ByteBuffer[] byteBufferArr) throws IOException {
        return this.f58085a.read(byteBufferArr);
    }

    public long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
        return this.f58085a.read(byteBufferArr, i, i2);
    }

    /* renamed from: g */
    public Object mo173232g() {
        return this.f58085a.socket();
    }
}
