package com.koushikdutta.async;

import com.koushikdutta.async.callback.DataCallback;

public class DataEmitterReader implements DataCallback {

    /* renamed from: d */
    static final /* synthetic */ boolean f58052d = (!DataEmitterReader.class.desiredAssertionStatus());

    /* renamed from: a */
    DataCallback f58053a;

    /* renamed from: b */
    int f58054b;

    /* renamed from: c */
    ByteBufferList f58055c = new ByteBufferList();

    public void read(int i, DataCallback dataCallback) {
        if (f58052d || this.f58053a == null) {
            this.f58054b = i;
            this.f58053a = dataCallback;
            if (f58052d || !this.f58055c.hasRemaining()) {
                this.f58055c.recycle();
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private boolean m43920a(DataEmitter dataEmitter) {
        if (this.f58054b > this.f58055c.remaining()) {
            return false;
        }
        DataCallback dataCallback = this.f58053a;
        this.f58053a = null;
        dataCallback.onDataAvailable(dataEmitter, this.f58055c);
        if (f58052d || !this.f58055c.hasRemaining()) {
            return true;
        }
        throw new AssertionError();
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        if (f58052d || this.f58053a != null) {
            do {
                byteBufferList.get(this.f58055c, Math.min(byteBufferList.remaining(), this.f58054b - this.f58055c.remaining()));
                byteBufferList.remaining();
                if (!m43920a(dataEmitter) || this.f58053a == null) {
                    byteBufferList.remaining();
                }
                byteBufferList.get(this.f58055c, Math.min(byteBufferList.remaining(), this.f58054b - this.f58055c.remaining()));
                byteBufferList.remaining();
                break;
            } while (this.f58053a == null);
            byteBufferList.remaining();
            return;
        }
        throw new AssertionError();
    }
}
