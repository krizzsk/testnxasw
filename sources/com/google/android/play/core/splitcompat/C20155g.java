package com.google.android.play.core.splitcompat;

import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.internal.C20087cj;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.g */
final class C20155g implements C20157i {

    /* renamed from: a */
    final /* synthetic */ Set f56175a;

    /* renamed from: b */
    final /* synthetic */ C20165q f56176b;

    /* renamed from: c */
    final /* synthetic */ ZipFile f56177c;

    C20155g(Set set, C20165q qVar, ZipFile zipFile) {
        this.f56175a = set;
        this.f56176b = qVar;
        this.f56177c = zipFile;
    }

    /* renamed from: a */
    public final void mo164446a(C20158j jVar, File file, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        this.f56175a.add(file);
        if (!z) {
            SystemUtils.log(4, "SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", new Object[]{this.f56176b.mo164455b(), jVar.f56178a, this.f56176b.mo164454a().getAbsolutePath(), jVar.f56179b.getName(), file.getAbsolutePath()}), (Throwable) null, "com.google.android.play.core.splitcompat.g", -1);
            ZipFile zipFile = this.f56177c;
            ZipEntry zipEntry = jVar.f56179b;
            int i = C20159k.f56180a;
            byte[] bArr = new byte[4096];
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        C20087cj.m42281a(th, th2);
                    }
                }
                throw th;
            }
        } else {
            return;
        }
        throw th;
    }
}
