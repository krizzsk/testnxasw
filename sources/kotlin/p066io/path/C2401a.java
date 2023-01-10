package kotlin.p066io.path;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo148868d2 = {"Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.io.path.a */
/* compiled from: PathUtils.kt */
final class C2401a {

    /* renamed from: a */
    public static final C2401a f4600a = new C2401a();

    /* renamed from: b */
    private static final Path f4601b = Paths.get("", new String[0]);

    /* renamed from: c */
    private static final Path f4602c = Paths.get("..", new String[0]);

    private C2401a() {
    }

    /* renamed from: a */
    public final Path mo23749a(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(path2, "base");
        Path normalize = path2.normalize();
        Path normalize2 = path.normalize();
        Path relativize = normalize.relativize(normalize2);
        Intrinsics.checkNotNullExpressionValue(normalize, "bn");
        int nameCount = normalize.getNameCount();
        Intrinsics.checkNotNullExpressionValue(normalize2, "pn");
        int min = Math.min(nameCount, normalize2.getNameCount());
        int i = 0;
        while (i < min && !(!Intrinsics.areEqual((Object) normalize.getName(i), (Object) f4602c))) {
            if (!(!Intrinsics.areEqual((Object) normalize2.getName(i), (Object) f4602c))) {
                i++;
            } else {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (!(!Intrinsics.areEqual((Object) normalize2, (Object) normalize)) || !Intrinsics.areEqual((Object) normalize, (Object) f4601b)) {
            String obj = relativize.toString();
            Intrinsics.checkNotNullExpressionValue(relativize, "rn");
            FileSystem fileSystem = relativize.getFileSystem();
            Intrinsics.checkNotNullExpressionValue(fileSystem, "rn.fileSystem");
            String separator = fileSystem.getSeparator();
            Intrinsics.checkNotNullExpressionValue(separator, "rn.fileSystem.separator");
            if (StringsKt.endsWith$default(obj, separator, false, 2, (Object) null)) {
                FileSystem fileSystem2 = relativize.getFileSystem();
                FileSystem fileSystem3 = relativize.getFileSystem();
                Intrinsics.checkNotNullExpressionValue(fileSystem3, "rn.fileSystem");
                normalize2 = fileSystem2.getPath(StringsKt.dropLast(obj, fileSystem3.getSeparator().length()), new String[0]);
            } else {
                normalize2 = relativize;
            }
        }
        Intrinsics.checkNotNullExpressionValue(normalize2, "r");
        return normalize2;
    }
}
