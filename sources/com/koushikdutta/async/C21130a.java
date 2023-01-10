package com.koushikdutta.async;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectableChannel;

/* renamed from: com.koushikdutta.async.a */
/* compiled from: ChannelWrapper */
abstract class C21130a implements ReadableByteChannel, ScatteringByteChannel {

    /* renamed from: a */
    private AbstractSelectableChannel f58084a;

    /* renamed from: a */
    public abstract int mo173221a(ByteBuffer byteBuffer) throws IOException;

    /* renamed from: a */
    public abstract int mo173222a(ByteBuffer[] byteBufferArr) throws IOException;

    /* renamed from: a */
    public abstract SelectionKey mo173223a(Selector selector) throws ClosedChannelException;

    /* renamed from: a */
    public abstract void mo173225a();

    /* renamed from: b */
    public abstract void mo173226b();

    /* renamed from: c */
    public abstract boolean mo173227c();

    /* renamed from: d */
    public boolean mo173229d() {
        return false;
    }

    /* renamed from: e */
    public abstract int mo173230e();

    /* renamed from: f */
    public abstract InetAddress mo173231f();

    /* renamed from: g */
    public abstract Object mo173232g();

    C21130a(AbstractSelectableChannel abstractSelectableChannel) throws IOException {
        abstractSelectableChannel.configureBlocking(false);
        this.f58084a = abstractSelectableChannel;
    }

    /* renamed from: a */
    public SelectionKey mo173224a(Selector selector, int i) throws ClosedChannelException {
        return this.f58084a.register(selector, i);
    }

    public boolean isOpen() {
        return this.f58084a.isOpen();
    }

    public void close() throws IOException {
        this.f58084a.close();
    }
}
