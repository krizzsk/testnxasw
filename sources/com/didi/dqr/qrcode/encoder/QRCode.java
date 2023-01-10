package com.didi.dqr.qrcode.encoder;

import com.didi.dqr.qrcode.decoder.ErrorCorrectionLevel;
import com.didi.dqr.qrcode.decoder.Mode;
import com.didi.dqr.qrcode.decoder.Version;

public final class QRCode {
    public static final int NUM_MASK_PATTERNS = 8;

    /* renamed from: a */
    private Mode f20956a;

    /* renamed from: b */
    private ErrorCorrectionLevel f20957b;

    /* renamed from: c */
    private Version f20958c;

    /* renamed from: d */
    private int f20959d = -1;

    /* renamed from: e */
    private ByteMatrix f20960e;

    public static boolean isValidMaskPattern(int i) {
        return i >= 0 && i < 8;
    }

    public Mode getMode() {
        return this.f20956a;
    }

    public ErrorCorrectionLevel getECLevel() {
        return this.f20957b;
    }

    public Version getVersion() {
        return this.f20958c;
    }

    public int getMaskPattern() {
        return this.f20959d;
    }

    public ByteMatrix getMatrix() {
        return this.f20960e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f20956a);
        sb.append("\n ecLevel: ");
        sb.append(this.f20957b);
        sb.append("\n version: ");
        sb.append(this.f20958c);
        sb.append("\n maskPattern: ");
        sb.append(this.f20959d);
        if (this.f20960e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f20960e);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    public void setMode(Mode mode) {
        this.f20956a = mode;
    }

    public void setECLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f20957b = errorCorrectionLevel;
    }

    public void setVersion(Version version) {
        this.f20958c = version;
    }

    public void setMaskPattern(int i) {
        this.f20959d = i;
    }

    public void setMatrix(ByteMatrix byteMatrix) {
        this.f20960e = byteMatrix;
    }
}
