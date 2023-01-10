package com.global.didi.elvish.language;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo148868d2 = {"Lcom/global/didi/elvish/language/LanguageConfigItemModel;", "Ljava/io/Serializable;", "()V", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "locale", "getLocale", "setLocale", "elvish_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: LanguageConfigItemModel.kt */
public final class LanguageConfigItemModel implements Serializable {
    @SerializedName("lang")
    private String lang = "";
    @SerializedName("locale")
    private String locale = "";

    public final String getLang() {
        return this.lang;
    }

    public final void setLang(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.lang = str;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final void setLocale(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.locale = str;
    }
}
