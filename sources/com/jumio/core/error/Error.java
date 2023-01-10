package com.jumio.core.error;

import android.content.Context;
import com.jumio.core.enums.ErrorCase;
import com.jumio.sdk.error.JumioError;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B%\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003R\u0013\u0010\n\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0010\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0018"}, mo148868d2 = {"Lcom/jumio/core/error/Error;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Landroid/content/Context;", "context", "", "getMessage", "Lcom/jumio/sdk/error/JumioError;", "getJumioError", "", "isRetryable", "()Z", "getDomain", "()Ljava/lang/String;", "domain", "getCode", "code", "Lcom/jumio/core/enums/ErrorCase;", "errorCase", "", "call", "detailCode", "<init>", "(Lcom/jumio/core/enums/ErrorCase;II)V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: Error.kt */
public final class Error extends Exception {

    /* renamed from: a */
    public final ErrorCase f57554a;

    /* renamed from: b */
    public final int f57555b;

    /* renamed from: c */
    public final int f57556c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Error(ErrorCase errorCase) {
        this(errorCase, 0, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(errorCase, "errorCase");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Error(ErrorCase errorCase, int i) {
        this(errorCase, i, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(errorCase, "errorCase");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Error(ErrorCase errorCase, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(errorCase, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }

    public final String getCode() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.ENGLISH, "%s%d%04d", Arrays.copyOf(new Object[]{this.f57554a.getDomain(), Integer.valueOf(this.f57555b), Integer.valueOf(this.f57556c)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public final String getDomain() {
        return this.f57554a.getDomain();
    }

    public final JumioError getJumioError(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean isRetryable = isRetryable();
        String domain = getDomain();
        String code = getCode();
        String string = context.getString(this.f57554a.getMessage());
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(errorCase.message)");
        return new JumioError(isRetryable, domain, code, string);
    }

    public final String getMessage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getString(this.f57554a.getMessage()) + ' ' + getCode();
    }

    public final boolean isRetryable() {
        return this.f57554a.getRetry();
    }

    public Error(ErrorCase errorCase, int i, int i2) {
        Intrinsics.checkNotNullParameter(errorCase, "errorCase");
        this.f57554a = errorCase;
        this.f57555b = i;
        this.f57556c = i2;
    }
}
