package com.iproov.sdk.crypto;

import android.content.Context;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;

public class KeyPair {
    private final C20899if keyStoreManager;

    /* renamed from: com.iproov.sdk.crypto.KeyPair$do */
    public enum C20896do {
        SOFTWARE,
        TEE,
        STRONG_BOX
    }

    public KeyPair(Context context) throws IProovException {
        try {
            this.keyStoreManager = C20899if.m43463do(context);
        } catch (C20898for e) {
            e.printStackTrace();
            throw new UnexpectedErrorException(context, (Exception) e);
        }
    }

    public C20896do getKeyStorageType() {
        if (!this.keyStoreManager.m48138break()) {
            return C20896do.SOFTWARE;
        }
        return this.keyStoreManager.m48141this() ? C20896do.STRONG_BOX : C20896do.TEE;
    }

    public PublicKey getPublicKey() {
        return this.keyStoreManager.m48139else();
    }

    public byte[] sign(byte[] bArr) throws IProovException {
        try {
            return this.keyStoreManager.mo171529do(bArr);
        } catch (C20898for e) {
            e.printStackTrace();
            throw new UnexpectedErrorException(this.keyStoreManager.m48142try(), (Exception) e);
        }
    }
}
