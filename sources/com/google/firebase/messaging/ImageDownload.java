package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_messaging.zzl;
import com.google.android.gms.internal.firebase_messaging.zzm;
import com.google.android.gms.internal.firebase_messaging.zzt;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
class ImageDownload implements Closeable {
    private volatile InputStream connectionInputStream;
    private Task<Bitmap> task;
    private final URL url;

    private ImageDownload(URL url2) {
        this.url = url2;
    }

    private byte[] blockingDownloadBytes() throws IOException {
        URLConnection openConnection = this.url.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                this.connectionInputStream = inputStream;
                byte[] zza = zzl.zza(zzl.zzb(inputStream, 1048577));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable(Constants.TAG, 2)) {
                    String valueOf = String.valueOf(this.url);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("Downloaded ");
                    sb.append(zza.length);
                    sb.append(" bytes from ");
                    sb.append(valueOf);
                    SystemUtils.log(2, Constants.TAG, sb.toString(), (Throwable) null, "com.google.firebase.messaging.ImageDownload", 9);
                }
                if (zza.length <= 1048576) {
                    return zza;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                zzt.zza(th, th);
            }
        } else {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        throw th;
    }

    public static ImageDownload create(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ImageDownload(new URL(str));
        } catch (MalformedURLException unused) {
            String valueOf = String.valueOf(str);
            SystemUtils.log(5, Constants.TAG, valueOf.length() != 0 ? "Not downloading image, bad URL: ".concat(valueOf) : new String("Not downloading image, bad URL: "), (Throwable) null, "com.google.firebase.messaging.ImageDownload", 3);
            return null;
        }
    }

    public Bitmap blockingDownload() throws IOException {
        String valueOf = String.valueOf(this.url);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Starting download of: ");
        sb.append(valueOf);
        SystemUtils.log(4, Constants.TAG, sb.toString(), (Throwable) null, "com.google.firebase.messaging.ImageDownload", 1);
        byte[] blockingDownloadBytes = blockingDownloadBytes();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(blockingDownloadBytes, 0, blockingDownloadBytes.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                String valueOf2 = String.valueOf(this.url);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 31);
                sb2.append("Successfully downloaded image: ");
                sb2.append(valueOf2);
                SystemUtils.log(3, Constants.TAG, sb2.toString(), (Throwable) null, "com.google.firebase.messaging.ImageDownload", 6);
            }
            return decodeByteArray;
        }
        String valueOf3 = String.valueOf(this.url);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 24);
        sb3.append("Failed to decode image: ");
        sb3.append(valueOf3);
        throw new IOException(sb3.toString());
    }

    public void close() {
        try {
            zzm.zza(this.connectionInputStream);
        } catch (NullPointerException e) {
            SystemUtils.log(6, Constants.TAG, "Failed to close the image download stream.", e, "com.google.firebase.messaging.ImageDownload", 2);
        }
    }

    public Task<Bitmap> getTask() {
        return (Task) Preconditions.checkNotNull(this.task);
    }

    public void start(Executor executor) {
        this.task = Tasks.call(executor, new ImageDownload$$Lambda$0(this));
    }
}
