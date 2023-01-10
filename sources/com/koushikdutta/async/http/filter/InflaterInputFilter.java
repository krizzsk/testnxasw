package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.C21121Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import java.nio.ByteBuffer;
import java.util.zip.Inflater;

public class InflaterInputFilter extends FilteredDataEmitter {

    /* renamed from: c */
    static final /* synthetic */ boolean f58262c = (!InflaterInputFilter.class.desiredAssertionStatus());

    /* renamed from: a */
    private Inflater f58263a;

    /* renamed from: b */
    ByteBufferList f58264b;

    /* access modifiers changed from: protected */
    public void report(Exception exc) {
        this.f58263a.end();
        if (exc != null && this.f58263a.getRemaining() > 0) {
            exc = new DataRemainingException("data still remaining in inflater", exc);
        }
        super.report(exc);
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        try {
            ByteBuffer obtain = ByteBufferList.obtain(byteBufferList.remaining() * 2);
            while (byteBufferList.size() > 0) {
                ByteBuffer remove = byteBufferList.remove();
                if (remove.hasRemaining()) {
                    int remaining = remove.remaining();
                    this.f58263a.setInput(remove.array(), remove.arrayOffset() + remove.position(), remove.remaining());
                    do {
                        obtain.position(obtain.position() + this.f58263a.inflate(obtain.array(), obtain.arrayOffset() + obtain.position(), obtain.remaining()));
                        if (!obtain.hasRemaining()) {
                            obtain.flip();
                            this.f58264b.add(obtain);
                            if (!f58262c) {
                                if (remaining == 0) {
                                    throw new AssertionError();
                                }
                            }
                            obtain = ByteBufferList.obtain(obtain.capacity() * 2);
                        }
                        if (this.f58263a.needsInput()) {
                            break;
                        }
                    } while (this.f58263a.finished());
                }
                ByteBufferList.reclaim(remove);
            }
            obtain.flip();
            this.f58264b.add(obtain);
            C21121Util.emitAllData(this, this.f58264b);
        } catch (Exception e) {
            report(e);
        }
    }

    public InflaterInputFilter() {
        this(new Inflater());
    }

    public InflaterInputFilter(Inflater inflater) {
        this.f58264b = new ByteBufferList();
        this.f58263a = inflater;
    }
}
