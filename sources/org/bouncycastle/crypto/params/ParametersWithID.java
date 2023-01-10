package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class ParametersWithID implements CipherParameters {

    /* renamed from: id */
    private byte[] f8041id;
    private CipherParameters parameters;

    public ParametersWithID(CipherParameters cipherParameters, byte[] bArr) {
        this.parameters = cipherParameters;
        this.f8041id = bArr;
    }

    public byte[] getID() {
        return this.f8041id;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
