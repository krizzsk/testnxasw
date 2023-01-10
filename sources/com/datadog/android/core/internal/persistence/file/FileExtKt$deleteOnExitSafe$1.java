package com.datadog.android.core.internal.persistence.file;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo148868d2 = {"<anonymous>", "", "Ljava/io/File;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FileExt.kt */
final class FileExtKt$deleteOnExitSafe$1 extends Lambda implements Function1<File, Unit> {
    public static final FileExtKt$deleteOnExitSafe$1 INSTANCE = new FileExtKt$deleteOnExitSafe$1();

    FileExtKt$deleteOnExitSafe$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((File) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(File file) {
        Intrinsics.checkNotNullParameter(file, "$this$safeCall");
        file.deleteOnExit();
    }
}
