package com.jumio.core;

import com.jumio.core.enums.MRZFormat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010)\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\"\u0010-\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\"\u00101\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001c\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 ¨\u00064"}, mo148868d2 = {"Lcom/jumio/core/JumioMrzData;", "Ljava/io/Serializable;", "", "a", "Ljava/lang/String;", "getMrzLine1", "()Ljava/lang/String;", "setMrzLine1", "(Ljava/lang/String;)V", "mrzLine1", "b", "getMrzLine2", "setMrzLine2", "mrzLine2", "c", "getMrzLine3", "setMrzLine3", "mrzLine3", "Lcom/jumio/core/enums/MRZFormat;", "d", "Lcom/jumio/core/enums/MRZFormat;", "getFormat", "()Lcom/jumio/core/enums/MRZFormat;", "setFormat", "(Lcom/jumio/core/enums/MRZFormat;)V", "format", "", "e", "Z", "getDobValid", "()Z", "setDobValid", "(Z)V", "dobValid", "f", "getIdNumberValid", "setIdNumberValid", "idNumberValid", "g", "getExpiryDateValid", "setExpiryDateValid", "expiryDateValid", "h", "getPersonalNumberValid", "setPersonalNumberValid", "personalNumberValid", "i", "getCompositeValid", "setCompositeValid", "compositeValid", "<init>", "()V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: JumioMrzData.kt */
public final class JumioMrzData implements Serializable {

    /* renamed from: a */
    public String f57450a;

    /* renamed from: b */
    public String f57451b;

    /* renamed from: c */
    public String f57452c;

    /* renamed from: d */
    public MRZFormat f57453d = MRZFormat.MRP;

    /* renamed from: e */
    public boolean f57454e;

    /* renamed from: f */
    public boolean f57455f;

    /* renamed from: g */
    public boolean f57456g;

    /* renamed from: h */
    public boolean f57457h = true;

    /* renamed from: i */
    public boolean f57458i;

    public final boolean getCompositeValid() {
        return this.f57458i;
    }

    public final boolean getDobValid() {
        return this.f57454e;
    }

    public final boolean getExpiryDateValid() {
        return this.f57456g;
    }

    public final MRZFormat getFormat() {
        return this.f57453d;
    }

    public final boolean getIdNumberValid() {
        return this.f57455f;
    }

    public final String getMrzLine1() {
        return this.f57450a;
    }

    public final String getMrzLine2() {
        return this.f57451b;
    }

    public final String getMrzLine3() {
        return this.f57452c;
    }

    public final boolean getPersonalNumberValid() {
        return this.f57457h;
    }

    public final void setCompositeValid(boolean z) {
        this.f57458i = z;
    }

    public final void setDobValid(boolean z) {
        this.f57454e = z;
    }

    public final void setExpiryDateValid(boolean z) {
        this.f57456g = z;
    }

    public final void setFormat(MRZFormat mRZFormat) {
        Intrinsics.checkNotNullParameter(mRZFormat, "<set-?>");
        this.f57453d = mRZFormat;
    }

    public final void setIdNumberValid(boolean z) {
        this.f57455f = z;
    }

    public final void setMrzLine1(String str) {
        this.f57450a = str;
    }

    public final void setMrzLine2(String str) {
        this.f57451b = str;
    }

    public final void setMrzLine3(String str) {
        this.f57452c = str;
    }

    public final void setPersonalNumberValid(boolean z) {
        this.f57457h = z;
    }
}
