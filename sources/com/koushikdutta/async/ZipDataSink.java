package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDataSink extends FilteredDataSink {

    /* renamed from: h */
    ByteArrayOutputStream f58082h = new ByteArrayOutputStream();

    /* renamed from: i */
    ZipOutputStream f58083i = new ZipOutputStream(this.f58082h);

    public ZipDataSink(DataSink dataSink) {
        super(dataSink);
    }

    public void putNextEntry(ZipEntry zipEntry) throws IOException {
        this.f58083i.putNextEntry(zipEntry);
    }

    public void closeEntry() throws IOException {
        this.f58083i.closeEntry();
    }

    /* access modifiers changed from: protected */
    public void report(Exception exc) {
        CompletedCallback closedCallback = getClosedCallback();
        if (closedCallback != null) {
            closedCallback.onCompleted(exc);
        }
    }

    public void end() {
        try {
            this.f58083i.close();
            setMaxBuffer(Integer.MAX_VALUE);
            write(new ByteBufferList());
            super.end();
        } catch (IOException e) {
            report(e);
        }
    }

    public ByteBufferList filter(ByteBufferList byteBufferList) {
        if (byteBufferList != null) {
            while (byteBufferList.size() > 0) {
                try {
                    ByteBuffer remove = byteBufferList.remove();
                    ByteBufferList.writeOutputStream(this.f58083i, remove);
                    ByteBufferList.reclaim(remove);
                } catch (IOException e) {
                    report(e);
                    if (byteBufferList != null) {
                        byteBufferList.recycle();
                    }
                    return null;
                } catch (Throwable th) {
                    if (byteBufferList != null) {
                        byteBufferList.recycle();
                    }
                    throw th;
                }
            }
        }
        ByteBufferList byteBufferList2 = new ByteBufferList(this.f58082h.toByteArray());
        this.f58082h.reset();
        if (byteBufferList != null) {
            byteBufferList.recycle();
        }
        return byteBufferList2;
    }
}
