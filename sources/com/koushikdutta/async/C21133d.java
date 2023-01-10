package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/* renamed from: com.koushikdutta.async.d */
/* compiled from: ServerSocketChannelWrapper */
class C21133d extends C21130a {

    /* renamed from: b */
    static final /* synthetic */ boolean f58090b = (!C21133d.class.desiredAssertionStatus());

    /* renamed from: a */
    ServerSocketChannel f58091a;

    /* renamed from: a */
    public void mo173225a() {
    }

    /* renamed from: b */
    public void mo173226b() {
    }

    /* renamed from: f */
    public InetAddress mo173231f() {
        return this.f58091a.socket().getInetAddress();
    }

    /* renamed from: e */
    public int mo173230e() {
        return this.f58091a.socket().getLocalPort();
    }

    C21133d(ServerSocketChannel serverSocketChannel) throws IOException {
        super(serverSocketChannel);
        this.f58091a = serverSocketChannel;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        if (!f58090b) {
            throw new AssertionError();
        }
        throw new IOException("Can't read ServerSocketChannel");
    }

    /* renamed from: c */
    public boolean mo173227c() {
        if (f58090b) {
            return false;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public int mo173221a(ByteBuffer byteBuffer) throws IOException {
        if (!f58090b) {
            throw new AssertionError();
        }
        throw new IOException("Can't write ServerSocketChannel");
    }

    /* renamed from: a */
    public SelectionKey mo173223a(Selector selector) throws ClosedChannelException {
        return this.f58091a.register(selector, 16);
    }

    /* renamed from: a */
    public int mo173222a(ByteBuffer[] byteBufferArr) throws IOException {
        if (!f58090b) {
            throw new AssertionError();
        }
        throw new IOException("Can't write ServerSocketChannel");
    }

    public long read(ByteBuffer[] byteBufferArr) throws IOException {
        if (!f58090b) {
            throw new AssertionError();
        }
        throw new IOException("Can't read ServerSocketChannel");
    }

    public long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
        if (!f58090b) {
            throw new AssertionError();
        }
        throw new IOException("Can't read ServerSocketChannel");
    }

    /* renamed from: g */
    public Object mo173232g() {
        return this.f58091a.socket();
    }
}
