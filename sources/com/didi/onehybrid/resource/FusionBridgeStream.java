package com.didi.onehybrid.resource;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class FusionBridgeStream extends InputStream {

    /* renamed from: a */
    private BufferedInputStream f32126a;

    /* renamed from: b */
    private boolean f32127b = false;

    /* renamed from: c */
    private ByteArrayOutputStream f32128c;

    /* renamed from: d */
    private WeakReference<OnCloseListener> f32129d;

    public interface OnCloseListener {
        void onClose(boolean z, ByteArrayOutputStream byteArrayOutputStream);
    }

    public FusionBridgeStream(BufferedInputStream bufferedInputStream) {
        this.f32126a = bufferedInputStream;
        this.f32128c = new ByteArrayOutputStream();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.f32129d = new WeakReference<>(onCloseListener);
    }

    public int read() throws IOException {
        int read = this.f32126a.read();
        if (read != -1) {
            this.f32128c.write(read);
        } else {
            this.f32127b = true;
        }
        return read;
    }

    public void close() throws IOException {
        OnCloseListener onCloseListener;
        this.f32126a.close();
        WeakReference<OnCloseListener> weakReference = this.f32129d;
        if (!(weakReference == null || (onCloseListener = (OnCloseListener) weakReference.get()) == null)) {
            onCloseListener.onClose(this.f32127b, this.f32128c);
        }
        this.f32128c = null;
    }
}
