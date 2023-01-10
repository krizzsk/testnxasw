package com.didi.dimina.container.p065ui.dialog;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;

/* renamed from: com.didi.dimina.container.ui.dialog.SingleMediaScanner */
public class SingleMediaScanner implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a */
    private final MediaScannerConnection f19459a;

    /* renamed from: b */
    private final String f19460b;

    /* renamed from: c */
    private final ScanListener f19461c;

    /* renamed from: com.didi.dimina.container.ui.dialog.SingleMediaScanner$ScanListener */
    public interface ScanListener {
        void onScanFinish();
    }

    public SingleMediaScanner(Context context, String str, ScanListener scanListener) {
        this.f19460b = str;
        this.f19461c = scanListener;
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context, this);
        this.f19459a = mediaScannerConnection;
        mediaScannerConnection.connect();
    }

    public void onMediaScannerConnected() {
        this.f19459a.scanFile(this.f19460b, (String) null);
    }

    public void onScanCompleted(String str, Uri uri) {
        this.f19459a.disconnect();
        ScanListener scanListener = this.f19461c;
        if (scanListener != null) {
            scanListener.onScanFinish();
        }
    }
}
