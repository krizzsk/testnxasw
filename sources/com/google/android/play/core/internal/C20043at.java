package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.splitcompat.C20151c;
import com.google.android.play.core.splitcompat.C20164p;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.C20194d;
import com.google.android.play.core.splitinstall.C20196f;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.internal.at */
public final class C20043at implements C20196f {

    /* renamed from: a */
    private final Context f56087a;

    /* renamed from: b */
    private final C20151c f56088b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C20044au f56089c;

    /* renamed from: d */
    private final Executor f56090d;

    /* renamed from: e */
    private final C20164p f56091e;

    public C20043at(Context context, Executor executor, C20044au auVar, C20151c cVar, C20164p pVar) {
        this.f56087a = context;
        this.f56088b = cVar;
        this.f56089c = auVar;
        this.f56090d = executor;
        this.f56091e = pVar;
    }

    /* renamed from: a */
    private final Integer m42161a(List<Intent> list) {
        FileChannel channel;
        FileLock fileLock;
        Exception exc;
        String str;
        String str2;
        int i;
        String str3;
        FileOutputStream fileOutputStream;
        try {
            channel = new RandomAccessFile(this.f56088b.mo164436b(), "rw").getChannel();
            Integer num = null;
            try {
                fileLock = channel.tryLock();
            } catch (OverlappingFileLockException unused) {
                fileLock = null;
            }
            if (fileLock != null) {
                int i2 = 0;
                try {
                    SystemUtils.log(4, "SplitCompat", "Copying splits.", (Throwable) null, "com.google.android.play.core.internal.at", -1);
                    for (Intent next : list) {
                        String stringExtra = next.getStringExtra("split_id");
                        AssetFileDescriptor openAssetFileDescriptor = this.f56087a.getContentResolver().openAssetFileDescriptor(next.getData(), "r");
                        File a = this.f56088b.mo164433a(stringExtra);
                        if (!a.exists() || a.length() == openAssetFileDescriptor.getLength()) {
                            if (a.exists()) {
                            }
                        }
                        if (!this.f56088b.mo164437b(stringExtra).exists()) {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(openAssetFileDescriptor.createInputStream());
                            try {
                                fileOutputStream = new FileOutputStream(a);
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileOutputStream.close();
                                bufferedInputStream.close();
                            } catch (Throwable th) {
                                bufferedInputStream.close();
                                throw th;
                            }
                        }
                    }
                    SystemUtils.log(4, "SplitCompat", "Splits copied.", (Throwable) null, "com.google.android.play.core.internal.at", -1);
                    try {
                        if (!this.f56089c.mo164284a()) {
                            str = "SplitCompat";
                            str2 = "Split verification failed.";
                            i = 6;
                            exc = null;
                            str3 = "com.google.android.play.core.internal.at";
                            SystemUtils.log(i, str, str2, exc, str3, -1);
                            i2 = -11;
                            num = Integer.valueOf(i2);
                            fileLock.release();
                        } else {
                            SystemUtils.log(4, "SplitCompat", "Splits verified.", (Throwable) null, "com.google.android.play.core.internal.at", -1);
                            num = Integer.valueOf(i2);
                            fileLock.release();
                        }
                    } catch (Exception e) {
                        exc = e;
                        str = "SplitCompat";
                        str2 = "Error verifying splits.";
                        i = 6;
                        str3 = "com.google.android.play.core.internal.at";
                    }
                } catch (Exception e2) {
                    SystemUtils.log(6, "SplitCompat", "Error copying splits.", e2, "com.google.android.play.core.internal.at", -1);
                    i2 = -13;
                } catch (Throwable th2) {
                    C20087cj.m42281a(th, th2);
                }
            }
            if (channel != null) {
                channel.close();
            }
            return num;
            throw th;
            throw th;
        } catch (Exception e3) {
            SystemUtils.log(6, "SplitCompat", "Error locking files.", e3, "com.google.android.play.core.internal.at", -1);
            return -13;
        } catch (Throwable th3) {
            C20087cj.m42281a(th, th3);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m42162a(C20043at atVar, C20194d dVar) {
        try {
            if (!SplitCompat.m42406a(C20164p.m42450a(atVar.f56087a))) {
                SystemUtils.log(6, "SplitCompat", "Emulating splits failed.", (Throwable) null, "com.google.android.play.core.internal.at", -1);
                dVar.mo164509a(-12);
                return;
            }
            SystemUtils.log(4, "SplitCompat", "Splits installed.", (Throwable) null, "com.google.android.play.core.internal.at", -1);
            dVar.mo164508a();
        } catch (Exception e) {
            SystemUtils.log(6, "SplitCompat", "Error emulating splits.", e, "com.google.android.play.core.internal.at", -1);
            dVar.mo164509a(-12);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m42163a(C20043at atVar, List list, C20194d dVar) {
        Integer a = atVar.m42161a((List<Intent>) list);
        if (a != null) {
            if (a.intValue() == 0) {
                dVar.mo164510b();
            } else {
                dVar.mo164509a(a.intValue());
            }
        }
    }

    /* renamed from: a */
    public final void mo164283a(List<Intent> list, C20194d dVar) {
        if (SplitCompat.m42405a()) {
            this.f56090d.execute(new C20042as(this, list, dVar));
            return;
        }
        throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
    }
}
