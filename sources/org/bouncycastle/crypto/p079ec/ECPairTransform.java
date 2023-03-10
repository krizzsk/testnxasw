package org.bouncycastle.crypto.p079ec;

import org.bouncycastle.crypto.CipherParameters;

/* renamed from: org.bouncycastle.crypto.ec.ECPairTransform */
public interface ECPairTransform {
    void init(CipherParameters cipherParameters);

    ECPair transform(ECPair eCPair);
}
