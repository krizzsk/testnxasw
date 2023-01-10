package com.koushikdutta.async.stream;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class OutputStreamDataSink implements DataSink {

    /* renamed from: b */
    AsyncServer f58292b;

    /* renamed from: c */
    OutputStream f58293c;

    /* renamed from: d */
    WritableCallback f58294d;

    /* renamed from: e */
    boolean f58295e;

    /* renamed from: f */
    Exception f58296f;

    /* renamed from: g */
    CompletedCallback f58297g;

    /* renamed from: h */
    WritableCallback f58298h;

    public OutputStreamDataSink(AsyncServer asyncServer) {
        this(asyncServer, (OutputStream) null);
    }

    public void end() {
        try {
            if (this.f58293c != null) {
                this.f58293c.close();
            }
            reportClose((Exception) null);
        } catch (IOException e) {
            reportClose(e);
        }
    }

    public OutputStreamDataSink(AsyncServer asyncServer, OutputStream outputStream) {
        this.f58292b = asyncServer;
        setOutputStream(outputStream);
    }

    public void setOutputStream(OutputStream outputStream) {
        this.f58293c = outputStream;
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f58293c;
    }

    public void write(ByteBufferList byteBufferList) {
        while (byteBufferList.size() > 0) {
            try {
                ByteBuffer remove = byteBufferList.remove();
                getOutputStream().write(remove.array(), remove.arrayOffset() + remove.position(), remove.remaining());
                ByteBufferList.reclaim(remove);
            } catch (IOException e) {
                reportClose(e);
            } catch (Throwable th) {
                byteBufferList.recycle();
                throw th;
            }
        }
        byteBufferList.recycle();
    }

    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f58294d = writableCallback;
    }

    public WritableCallback getWriteableCallback() {
        return this.f58294d;
    }

    public boolean isOpen() {
        return this.f58295e;
    }

    public void reportClose(Exception exc) {
        if (!this.f58295e) {
            this.f58295e = true;
            this.f58296f = exc;
            CompletedCallback completedCallback = this.f58297g;
            if (completedCallback != null) {
                completedCallback.onCompleted(exc);
            }
        }
    }

    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f58297g = completedCallback;
    }

    public CompletedCallback getClosedCallback() {
        return this.f58297g;
    }

    public AsyncServer getServer() {
        return this.f58292b;
    }

    public void setOutputStreamWritableCallback(WritableCallback writableCallback) {
        this.f58298h = writableCallback;
    }
}
