package com.didiglobal.pay.paysecure.prepaidcard;

import com.didiglobal.pay.paysecure.util.CipherUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u000e\u0010\u0012\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/EncryptPassword;", "", "()V", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "encryptKey", "getEncryptKey", "setEncryptKey", "encryptedPwdString", "getEncryptedPwdString", "setEncryptedPwdString", "iv", "getIv", "setIv", "publicKey", "prepareEncrypt", "", "pwd", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: EncryptPassword.kt */
public final class EncryptPassword {

    /* renamed from: a */
    private String f52889a;

    /* renamed from: b */
    private String f52890b;

    /* renamed from: c */
    private String f52891c;

    /* renamed from: d */
    private String f52892d;

    /* renamed from: e */
    private final String f52893e = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDC4hfVVnxS7jU8nop/u4uO+RlQu4QhBgs9VnAwIIk3lsmLkrdOO1tfCkm+JCTbkifjxGevVND69CuunKj0woTIveXfe/C/d1AUzdYDIgUDUeW5g/tOneSyMk/j4eYCn+1IxftO8IL3y/IdjVeGWZS7jdydwZz422ed8YWNZ2EEcwIDAQAB";

    public final String getAesKey() {
        return this.f52889a;
    }

    public final void setAesKey(String str) {
        this.f52889a = str;
    }

    public final String getIv() {
        return this.f52890b;
    }

    public final void setIv(String str) {
        this.f52890b = str;
    }

    public final String getEncryptedPwdString() {
        return this.f52891c;
    }

    public final void setEncryptedPwdString(String str) {
        this.f52891c = str;
    }

    public final String getEncryptKey() {
        return this.f52892d;
    }

    public final void setEncryptKey(String str) {
        this.f52892d = str;
    }

    public final void prepareEncrypt(String str) {
        Intrinsics.checkParameterIsNotNull(str, "pwd");
        this.f52889a = CipherUtil.INSTANCE.getAESKey();
        this.f52890b = CipherUtil.INSTANCE.getAESIv();
        CipherUtil cipherUtil = CipherUtil.INSTANCE;
        String str2 = this.f52889a;
        if (str2 == null) {
            Intrinsics.throwNpe();
        }
        this.f52891c = cipherUtil.aesEncrypt(str, str2);
        CipherUtil cipherUtil2 = CipherUtil.INSTANCE;
        String str3 = this.f52889a;
        if (str3 == null) {
            Intrinsics.throwNpe();
        }
        this.f52892d = cipherUtil2.encryptRSAToString(str3, this.f52893e);
    }
}
