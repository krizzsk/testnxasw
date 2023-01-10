package com.didi.dimina.webview.resource;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class FusionBridgeStream extends InputStream {

    /* renamed from: a */
    private final BufferedInputStream f20190a;

    /* renamed from: b */
    private boolean f20191b = false;

    /* renamed from: c */
    private ByteArrayOutputStream f20192c;

    /* renamed from: d */
    private WeakReference<OnCloseListener> f20193d;

    public interface OnCloseListener {
        void onClose(boolean z, ByteArrayOutputStream byteArrayOutputStream);
    }

    public FusionBridgeStream(BufferedInputStream bufferedInputStream) {
        this.f20190a = bufferedInputStream;
        this.f20192c = new ByteArrayOutputStream();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.f20193d = new WeakReference<>(onCloseListener);
    }

    public int read() throws IOException {
        int read = this.f20190a.read();
        if (read != -1) {
            this.f20192c.write(read);
        } else {
            this.f20191b = true;
        }
        return read;
    }

    public void close() throws IOException {
        OnCloseListener onCloseListener;
        this.f20190a.close();
        WeakReference<OnCloseListener> weakReference = this.f20193d;
        if (!(weakReference == null || (onCloseListener = (OnCloseListener) weakReference.get()) == null)) {
            onCloseListener.onClose(this.f20191b, this.f20192c);
        }
        this.f20192c = null;
    }
}
