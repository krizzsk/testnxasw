package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C20030ag;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.play.core.assetpacks.dv */
final class C19991dv {

    /* renamed from: a */
    private static final C20030ag f55995a = new C20030ag("VerifySliceTaskHandler");

    /* renamed from: b */
    private final C19917bb f55996b;

    C19991dv(C19917bb bbVar) {
        this.f55996b = bbVar;
    }

    /* renamed from: a */
    private final void m42058a(C19990du duVar, File file) {
        try {
            File f = this.f55996b.mo164118f(duVar.f55886k, duVar.f55991a, duVar.f55992b, duVar.f55993c);
            if (f.exists()) {
                try {
                    if (C19971db.m42013a(C19989dt.m42056a(file, f)).equals(duVar.f55994d)) {
                        f55995a.mo164270c("Verification of slice %s of pack %s successful.", duVar.f55993c, duVar.f55886k);
                        return;
                    }
                    throw new C19937bv(String.format("Verification failed for slice %s.", new Object[]{duVar.f55993c}), duVar.f55885j);
                } catch (NoSuchAlgorithmException e) {
                    throw new C19937bv("SHA256 algorithm not supported.", e, duVar.f55885j);
                } catch (IOException e2) {
                    throw new C19937bv(String.format("Could not digest file during verification for slice %s.", new Object[]{duVar.f55993c}), e2, duVar.f55885j);
                }
            } else {
                throw new C19937bv(String.format("Cannot find metadata files for slice %s.", new Object[]{duVar.f55993c}), duVar.f55885j);
            }
        } catch (IOException e3) {
            throw new C19937bv(String.format("Could not reconstruct slice archive during verification for slice %s.", new Object[]{duVar.f55993c}), e3, duVar.f55885j);
        }
    }

    /* renamed from: a */
    public final void mo164223a(C19990du duVar) {
        File a = this.f55996b.mo164096a(duVar.f55886k, duVar.f55991a, duVar.f55992b, duVar.f55993c);
        if (a.exists()) {
            m42058a(duVar, a);
            File b = this.f55996b.mo164103b(duVar.f55886k, duVar.f55991a, duVar.f55992b, duVar.f55993c);
            if (!b.exists()) {
                b.mkdirs();
            }
            if (!a.renameTo(b)) {
                throw new C19937bv(String.format("Failed to move slice %s after verification.", new Object[]{duVar.f55993c}), duVar.f55885j);
            }
            return;
        }
        throw new C19937bv(String.format("Cannot find unverified files for slice %s.", new Object[]{duVar.f55993c}), duVar.f55885j);
    }
}
