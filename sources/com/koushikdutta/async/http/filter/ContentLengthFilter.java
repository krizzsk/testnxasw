package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;

public class ContentLengthFilter extends FilteredDataEmitter {

    /* renamed from: d */
    static final /* synthetic */ boolean f58253d = (!ContentLengthFilter.class.desiredAssertionStatus());

    /* renamed from: a */
    long f58254a;

    /* renamed from: b */
    long f58255b;

    /* renamed from: c */
    ByteBufferList f58256c = new ByteBufferList();

    public ContentLengthFilter(long j) {
        this.f58254a = j;
    }

    /* access modifiers changed from: protected */
    public void report(Exception exc) {
        if (exc == null && this.f58255b != this.f58254a) {
            exc = new PrematureDataEndException("End of data reached before content length was read: " + this.f58255b + "/" + this.f58254a + " Paused: " + isPaused());
        }
        super.report(exc);
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        if (f58253d || this.f58255b < this.f58254a) {
            byteBufferList.get(this.f58256c, (int) Math.min(this.f58254a - this.f58255b, (long) byteBufferList.remaining()));
            int remaining = this.f58256c.remaining();
            super.onDataAvailable(dataEmitter, this.f58256c);
            this.f58255b += (long) (remaining - this.f58256c.remaining());
            this.f58256c.get(byteBufferList);
            if (this.f58255b == this.f58254a) {
                report((Exception) null);
                return;
            }
            return;
        }
        throw new AssertionError();
    }
}
