package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.C20018a;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20068br;
import com.google.android.play.core.internal.C20079cb;
import com.google.android.play.core.internal.C20087cj;
import com.google.android.play.core.internal.C20088ck;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

/* renamed from: com.google.android.play.core.assetpacks.do */
final class C19984do {

    /* renamed from: a */
    private static final C20030ag f55969a = new C20030ag("PatchSliceTaskHandler");

    /* renamed from: b */
    private final C19917bb f55970b;

    /* renamed from: c */
    private final C20088ck<C20013w> f55971c;

    /* renamed from: d */
    private final C20018a f55972d;

    C19984do(C19917bb bbVar, C20088ck<C20013w> ckVar, C20018a aVar) {
        this.f55970b = bbVar;
        this.f55971c = ckVar;
        this.f55972d = aVar;
    }

    /* renamed from: a */
    public final void mo164200a(C19983dn dnVar) {
        InputStream inputStream;
        Throwable th;
        C19983dn dnVar2 = dnVar;
        File a = this.f55970b.mo164095a(dnVar2.f55886k, dnVar2.f55961a, dnVar2.f55962b);
        C19917bb bbVar = this.f55970b;
        String str = dnVar2.f55886k;
        int i = dnVar2.f55961a;
        long j = dnVar2.f55962b;
        File file = new File(bbVar.mo164102b(str, i, j), dnVar2.f55966f);
        try {
            inputStream = dnVar2.f55968h;
            if (dnVar2.f55965e == 2) {
                inputStream = new GZIPInputStream(inputStream, 8192);
            }
            C19920be beVar = new C19920be(a, file);
            if (this.f55972d.mo164251a()) {
                File a2 = this.f55970b.mo164096a(dnVar2.f55886k, dnVar2.f55963c, dnVar2.f55964d, dnVar2.f55966f);
                if (!a2.exists()) {
                    a2.mkdirs();
                }
                C19987dr drVar = new C19987dr(this.f55970b, dnVar2.f55886k, dnVar2.f55963c, dnVar2.f55964d, dnVar2.f55966f);
                C20068br.m42228a((C20079cb) beVar, inputStream, (OutputStream) new C19940by(a2, drVar), dnVar2.f55967g);
                drVar.mo164218b(0);
            } else {
                File file2 = new File(this.f55970b.mo164118f(dnVar2.f55886k, dnVar2.f55963c, dnVar2.f55964d, dnVar2.f55966f), "slice.zip.tmp");
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                C20068br.m42228a((C20079cb) beVar, inputStream, (OutputStream) new FileOutputStream(file2), dnVar2.f55967g);
                if (!file2.renameTo(this.f55970b.mo164115e(dnVar2.f55886k, dnVar2.f55963c, dnVar2.f55964d, dnVar2.f55966f))) {
                    throw new C19937bv(String.format("Error moving patch for slice %s of pack %s.", new Object[]{dnVar2.f55966f, dnVar2.f55886k}), dnVar2.f55885j);
                }
            }
            inputStream.close();
            if (this.f55972d.mo164251a()) {
                f55969a.mo164270c("Patching and extraction finished for slice %s of pack %s.", dnVar2.f55966f, dnVar2.f55886k);
            } else {
                f55969a.mo164270c("Patching finished for slice %s of pack %s.", dnVar2.f55966f, dnVar2.f55886k);
            }
            this.f55971c.mo164325a().mo164080a(dnVar2.f55885j, dnVar2.f55886k, dnVar2.f55966f, 0);
            try {
                dnVar2.f55968h.close();
                return;
            } catch (IOException unused) {
                f55969a.mo164271d("Could not close file for slice %s of pack %s.", dnVar2.f55966f, dnVar2.f55886k);
                return;
            }
        } catch (IOException e) {
            f55969a.mo164269b("IOException during patching %s.", e.getMessage());
            throw new C19937bv(String.format("Error patching slice %s of pack %s.", new Object[]{dnVar2.f55966f, dnVar2.f55886k}), e, dnVar2.f55885j);
        } catch (Throwable th2) {
            C20087cj.m42281a(th, th2);
        }
        throw th;
    }
}
