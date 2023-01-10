package com.didi.sdk.logging.net;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.C3000Util;
import okio.Buffer;
import okio.BufferedSink;

public class FileRequestBody extends RequestBody {

    /* renamed from: a */
    private static final MediaType f39351a = MediaType.parse("multipart/form-data");

    /* renamed from: b */
    private final MediaType f39352b;

    /* renamed from: c */
    private final File f39353c;

    /* renamed from: d */
    private final long f39354d;

    /* renamed from: e */
    private final long f39355e;

    public FileRequestBody(MediaType mediaType, File file, long j, long j2) {
        this.f39352b = mediaType;
        this.f39353c = file;
        this.f39354d = j;
        this.f39355e = j2;
    }

    public MediaType contentType() {
        return this.f39352b;
    }

    public long contentLength() {
        return this.f39355e;
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Buffer buffer = new Buffer();
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.f39353c, "r");
            try {
                randomAccessFile2.seek(this.f39354d);
                byte[] bArr = new byte[((int) this.f39355e)];
                randomAccessFile2.read(bArr);
                buffer.write(bArr);
                bufferedSink.write(buffer, this.f39355e);
                C3000Util.closeQuietly((Closeable) randomAccessFile2);
                C3000Util.closeQuietly((Closeable) buffer);
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                C3000Util.closeQuietly((Closeable) randomAccessFile);
                C3000Util.closeQuietly((Closeable) buffer);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            C3000Util.closeQuietly((Closeable) randomAccessFile);
            C3000Util.closeQuietly((Closeable) buffer);
            throw th;
        }
    }

    public static FileRequestBody create(MediaType mediaType, File file, long j, long j2) {
        if (file != null) {
            return new FileRequestBody(mediaType, file, j, j2);
        }
        throw new NullPointerException("content == null");
    }

    public static FileRequestBody create(File file, long j, long j2) {
        if (file != null) {
            return new FileRequestBody(f39351a, file, j, j2);
        }
        throw new NullPointerException("content == null");
    }

    public static FileRequestBody create(File file) {
        if (file != null) {
            return new FileRequestBody(f39351a, file, 0, file.length());
        }
        throw new NullPointerException("content == null");
    }
}
