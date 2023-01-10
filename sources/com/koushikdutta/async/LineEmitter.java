package com.koushikdutta.async;

import com.koushikdutta.async.callback.DataCallback;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class LineEmitter implements DataCallback {

    /* renamed from: d */
    static final /* synthetic */ boolean f58063d = (!LineEmitter.class.desiredAssertionStatus());

    /* renamed from: a */
    Charset f58064a;

    /* renamed from: b */
    ByteBufferList f58065b;

    /* renamed from: c */
    StringCallback f58066c;

    public interface StringCallback {
        void onStringAvailable(String str);
    }

    public LineEmitter() {
        this((Charset) null);
    }

    public LineEmitter(Charset charset) {
        this.f58065b = new ByteBufferList();
        this.f58064a = charset;
    }

    public void setLineCallback(StringCallback stringCallback) {
        this.f58066c = stringCallback;
    }

    public StringCallback getLineCallback() {
        return this.f58066c;
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBufferList.remaining());
        while (byteBufferList.remaining() > 0) {
            byte b = byteBufferList.get();
            if (b != 10) {
                allocate.put(b);
            } else if (f58063d || this.f58066c != null) {
                allocate.flip();
                this.f58065b.add(allocate);
                this.f58066c.onStringAvailable(this.f58065b.readString(this.f58064a));
                this.f58065b = new ByteBufferList();
                return;
            } else {
                throw new AssertionError();
            }
        }
        allocate.flip();
        this.f58065b.add(allocate);
    }
}
