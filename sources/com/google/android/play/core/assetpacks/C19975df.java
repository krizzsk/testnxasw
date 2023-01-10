package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C20030ag;
import java.io.File;
import java.io.IOException;

/* renamed from: com.google.android.play.core.assetpacks.df */
final class C19975df {

    /* renamed from: a */
    private static final C20030ag f55941a = new C20030ag("MergeSliceTaskHandler");

    /* renamed from: b */
    private final C19917bb f55942b;

    C19975df(C19917bb bbVar) {
        this.f55942b = bbVar;
    }

    /* renamed from: a */
    private static void m42026a(File file, File file2) {
        if (file.isDirectory()) {
            file2.mkdirs();
            for (File file3 : file.listFiles()) {
                m42026a(file3, new File(file2, file3.getName()));
            }
            if (!file.delete()) {
                String valueOf = String.valueOf(file);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
                sb.append("Unable to delete directory: ");
                sb.append(valueOf);
                throw new C19937bv(sb.toString());
            }
        } else if (file2.exists()) {
            String valueOf2 = String.valueOf(file2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 51);
            sb2.append("File clashing with existing file from other slice: ");
            sb2.append(valueOf2);
            throw new C19937bv(sb2.toString());
        } else if (!file.renameTo(file2)) {
            String valueOf3 = String.valueOf(file);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 21);
            sb3.append("Unable to move file: ");
            sb3.append(valueOf3);
            throw new C19937bv(sb3.toString());
        }
    }

    /* renamed from: a */
    public final void mo164196a(C19974de deVar) {
        File b = this.f55942b.mo164103b(deVar.f55886k, deVar.f55938a, deVar.f55939b, deVar.f55940c);
        if (b.exists()) {
            File c = this.f55942b.mo164105c(deVar.f55886k, deVar.f55938a, deVar.f55939b);
            if (!c.exists()) {
                c.mkdirs();
            }
            m42026a(b, c);
            try {
                this.f55942b.mo164098a(deVar.f55886k, deVar.f55938a, deVar.f55939b, this.f55942b.mo164109d(deVar.f55886k, deVar.f55938a, deVar.f55939b) + 1);
            } catch (IOException e) {
                f55941a.mo164269b("Writing merge checkpoint failed with %s.", e.getMessage());
                throw new C19937bv("Writing merge checkpoint failed.", e, deVar.f55885j);
            }
        } else {
            throw new C19937bv(String.format("Cannot find verified files for slice %s.", new Object[]{deVar.f55940c}), deVar.f55885j);
        }
    }
}
