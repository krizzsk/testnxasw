package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;

public class BufferedDataSink implements DataSink {

    /* renamed from: g */
    static final /* synthetic */ boolean f58036g = (!BufferedDataSink.class.desiredAssertionStatus());

    /* renamed from: a */
    DataSink f58037a;

    /* renamed from: b */
    boolean f58038b;

    /* renamed from: c */
    final ByteBufferList f58039c = new ByteBufferList();

    /* renamed from: d */
    WritableCallback f58040d;

    /* renamed from: e */
    int f58041e = Integer.MAX_VALUE;

    /* renamed from: f */
    boolean f58042f;

    /* access modifiers changed from: protected */
    public void onDataAccepted(ByteBufferList byteBufferList) {
    }

    public BufferedDataSink(DataSink dataSink) {
        setDataSink(dataSink);
    }

    public boolean isBuffering() {
        return this.f58039c.hasRemaining() || this.f58038b;
    }

    public boolean isWritable() {
        boolean z;
        synchronized (this.f58039c) {
            z = this.f58039c.remaining() < this.f58041e;
        }
        return z;
    }

    public DataSink getDataSink() {
        return this.f58037a;
    }

    public void forceBuffering(boolean z) {
        this.f58038b = z;
        if (!z) {
            m43915a();
        }
    }

    public void setDataSink(DataSink dataSink) {
        this.f58037a = dataSink;
        dataSink.setWriteableCallback(new WritableCallback() {
            public final void onWriteable() {
                BufferedDataSink.this.m43915a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m43915a() {
        boolean isEmpty;
        WritableCallback writableCallback;
        if (!this.f58038b) {
            synchronized (this.f58039c) {
                this.f58037a.write(this.f58039c);
                isEmpty = this.f58039c.isEmpty();
            }
            if (isEmpty && this.f58042f) {
                this.f58037a.end();
            }
            if (isEmpty && (writableCallback = this.f58040d) != null) {
                writableCallback.onWriteable();
            }
        }
    }

    public void write(ByteBufferList byteBufferList) {
        if (getServer().getAffinity() != Thread.currentThread()) {
            synchronized (this.f58039c) {
                if (this.f58039c.remaining() < this.f58041e) {
                    onDataAccepted(byteBufferList);
                    byteBufferList.get(this.f58039c);
                    getServer().post(new Runnable() {
                        public final void run() {
                            BufferedDataSink.this.m43915a();
                        }
                    });
                    return;
                }
                return;
            }
        }
        onDataAccepted(byteBufferList);
        if (!isBuffering()) {
            this.f58037a.write(byteBufferList);
        }
        synchronized (this.f58039c) {
            byteBufferList.get(this.f58039c);
        }
    }

    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f58040d = writableCallback;
    }

    public WritableCallback getWriteableCallback() {
        return this.f58040d;
    }

    public int remaining() {
        return this.f58039c.remaining();
    }

    public int getMaxBuffer() {
        return this.f58041e;
    }

    public void setMaxBuffer(int i) {
        if (f58036g || i >= 0) {
            this.f58041e = i;
            return;
        }
        throw new AssertionError();
    }

    public boolean isOpen() {
        return this.f58037a.isOpen();
    }

    public void end() {
        if (getServer().getAffinity() != Thread.currentThread()) {
            getServer().post(new Runnable() {
                public final void run() {
                    BufferedDataSink.this.end();
                }
            });
            return;
        }
        synchronized (this.f58039c) {
            if (this.f58039c.hasRemaining()) {
                this.f58042f = true;
            } else {
                this.f58037a.end();
            }
        }
    }

    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f58037a.setClosedCallback(completedCallback);
    }

    public CompletedCallback getClosedCallback() {
        return this.f58037a.getClosedCallback();
    }

    public AsyncServer getServer() {
        return this.f58037a.getServer();
    }
}
