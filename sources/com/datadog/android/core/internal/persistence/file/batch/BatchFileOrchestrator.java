package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.log.Logger;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;

@Metadata(mo148867d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 &2\u00020\u0001:\u0002%&B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0016J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\rH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020 H\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, mo148868d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileOrchestrator;", "Lcom/datadog/android/core/internal/persistence/file/FileOrchestrator;", "rootDir", "Ljava/io/File;", "config", "Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "internalLogger", "Lcom/datadog/android/log/Logger;", "(Ljava/io/File;Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;Lcom/datadog/android/log/Logger;)V", "fileFilter", "Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileOrchestrator$BatchFileFilter;", "previousFile", "previousFileItemCount", "", "recentReadDelayMs", "", "recentWriteDelayMs", "createNewFile", "deleteObsoleteFiles", "", "freeSpaceIfNeeded", "getAllFiles", "", "getFlushableFiles", "getReadableFile", "excludeFiles", "", "getReusableWritableFile", "dataSize", "getRootDir", "getWritableFile", "isFileRecent", "", "file", "delayMs", "isRootDirValid", "listSortedBatchFiles", "BatchFileFilter", "Companion", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BatchFileOrchestrator.kt */
public final class BatchFileOrchestrator implements FileOrchestrator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERROR_CANT_CREATE_ROOT = "The provided root file can't be created: %s";
    public static final String ERROR_DISK_FULL = "Too much disk space used (%d/%d): cleaning up to free %d bytes…";
    public static final String ERROR_LARGE_DATA = "Can't write data with size %d (max item size is %d)";
    public static final String ERROR_ROOT_NOT_DIR = "The provided root file is not a directory: %s";
    public static final String ERROR_ROOT_NOT_WRITABLE = "The provided root dir is not writable: %s";
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Regex f3558i = new Regex("\\d+");

    /* renamed from: a */
    private final File f3559a;

    /* renamed from: b */
    private final FilePersistenceConfig f3560b;

    /* renamed from: c */
    private final Logger f3561c;

    /* renamed from: d */
    private final BatchFileFilter f3562d = new BatchFileFilter();

    /* renamed from: e */
    private final long f3563e = ((long) (((double) this.f3560b.getRecentDelayMs()) * 1.05d));

    /* renamed from: f */
    private final long f3564f = ((long) (((double) this.f3560b.getRecentDelayMs()) * 0.95d));

    /* renamed from: g */
    private File f3565g;

    /* renamed from: h */
    private int f3566h;

    public BatchFileOrchestrator(File file, FilePersistenceConfig filePersistenceConfig, Logger logger) {
        Intrinsics.checkNotNullParameter(file, "rootDir");
        Intrinsics.checkNotNullParameter(filePersistenceConfig, "config");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
        this.f3559a = file;
        this.f3560b = filePersistenceConfig;
        this.f3561c = logger;
    }

    public File getWritableFile(int i) {
        if (!m2356a()) {
            return null;
        }
        if (((long) i) > this.f3560b.getMaxItemSize()) {
            Logger logger = this.f3561c;
            String format = String.format(Locale.US, ERROR_LARGE_DATA, Arrays.copyOf(new Object[]{Integer.valueOf(i), Long.valueOf(this.f3560b.getMaxItemSize())}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
            Logger.e$default(logger, format, (Throwable) null, (Map) null, 6, (Object) null);
            return null;
        }
        m2359c();
        m2360d();
        File a = m2355a(i);
        return a == null ? m2358b() : a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.File} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.File getReadableFile(java.util.Set<? extends java.io.File> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "excludeFiles"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r6.m2356a()
            r1 = 0
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            r6.m2359c()
            java.util.List r0 = r6.m2361e()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x001a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x003b
            java.lang.Object r2 = r0.next()
            r3 = r2
            java.io.File r3 = (java.io.File) r3
            boolean r4 = r7.contains(r3)
            if (r4 != 0) goto L_0x0037
            long r4 = r6.f3563e
            boolean r3 = r6.m2357a(r3, r4)
            if (r3 != 0) goto L_0x0037
            r3 = 1
            goto L_0x0038
        L_0x0037:
            r3 = 0
        L_0x0038:
            if (r3 == 0) goto L_0x001a
            r1 = r2
        L_0x003b:
            java.io.File r1 = (java.io.File) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator.getReadableFile(java.util.Set):java.io.File");
    }

    public List<File> getAllFiles() {
        if (!m2356a()) {
            return CollectionsKt.emptyList();
        }
        return m2361e();
    }

    public List<File> getFlushableFiles() {
        return getAllFiles();
    }

    public File getRootDir() {
        if (!m2356a()) {
            return null;
        }
        return this.f3559a;
    }

    /* renamed from: a */
    private final boolean m2356a() {
        if (FileExtKt.existsSafe(this.f3559a)) {
            if (!this.f3559a.isDirectory()) {
                Logger logger = this.f3561c;
                String format = String.format(Locale.US, ERROR_ROOT_NOT_DIR, Arrays.copyOf(new Object[]{this.f3559a.getPath()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
                Logger.e$default(logger, format, (Throwable) null, (Map) null, 6, (Object) null);
                return false;
            } else if (FileExtKt.canWriteSafe(this.f3559a)) {
                return true;
            } else {
                Logger logger2 = this.f3561c;
                String format2 = String.format(Locale.US, ERROR_ROOT_NOT_WRITABLE, Arrays.copyOf(new Object[]{this.f3559a.getPath()}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, this, *args)");
                Logger.e$default(logger2, format2, (Throwable) null, (Map) null, 6, (Object) null);
                return false;
            }
        } else if (FileExtKt.mkdirsSafe(this.f3559a)) {
            return true;
        } else {
            Logger logger3 = this.f3561c;
            String format3 = String.format(Locale.US, ERROR_CANT_CREATE_ROOT, Arrays.copyOf(new Object[]{this.f3559a.getPath()}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(locale, this, *args)");
            Logger.e$default(logger3, format3, (Throwable) null, (Map) null, 6, (Object) null);
            return false;
        }
    }

    /* renamed from: b */
    private final File m2358b() {
        File file = new File(this.f3559a, String.valueOf(System.currentTimeMillis()));
        this.f3565g = file;
        this.f3566h = 1;
        return file;
    }

    /* renamed from: a */
    private final File m2355a(int i) {
        File file = (File) CollectionsKt.lastOrNull(m2361e());
        if (file == null) {
            return null;
        }
        File file2 = this.f3565g;
        int i2 = this.f3566h;
        if (!Intrinsics.areEqual((Object) file2, (Object) file)) {
            return null;
        }
        boolean a = m2357a(file, this.f3564f);
        long lengthSafe = FileExtKt.lengthSafe(file) + ((long) i);
        boolean z = false;
        boolean z2 = lengthSafe < this.f3560b.getMaxBatchSize();
        if (i2 < this.f3560b.getMaxItemsPerBatch()) {
            z = true;
        }
        if (!a || !z2 || !z) {
            return null;
        }
        this.f3566h = i2 + 1;
        return file;
    }

    /* renamed from: a */
    private final boolean m2357a(File file, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        return Long.parseLong(name) >= currentTimeMillis - j;
    }

    /* renamed from: c */
    private final void m2359c() {
        for (File delete : SequencesKt.filter(CollectionsKt.asSequence(m2361e()), new BatchFileOrchestrator$deleteObsoleteFiles$1(System.currentTimeMillis() - this.f3560b.getOldFileThreshold()))) {
            delete.delete();
        }
    }

    /* renamed from: d */
    private final void m2360d() {
        Iterable<File> e = m2361e();
        long j = 0;
        for (File lengthSafe : e) {
            j += FileExtKt.lengthSafe(lengthSafe);
        }
        long maxDiskSpace = this.f3560b.getMaxDiskSpace();
        long j2 = j - maxDiskSpace;
        if (j2 > 0) {
            Logger logger = this.f3561c;
            String format = String.format(Locale.US, ERROR_DISK_FULL, Arrays.copyOf(new Object[]{Long.valueOf(j), Long.valueOf(maxDiskSpace), Long.valueOf(j2)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, this, *args)");
            Logger.e$default(logger, format, (Throwable) null, (Map) null, 6, (Object) null);
            for (File file : e) {
                if (j2 > 0) {
                    long lengthSafe2 = FileExtKt.lengthSafe(file);
                    if (FileExtKt.deleteSafe(file)) {
                        j2 -= lengthSafe2;
                    }
                }
            }
        }
    }

    /* renamed from: e */
    private final List<File> m2361e() {
        File[] listFilesSafe = FileExtKt.listFilesSafe(this.f3559a, (FileFilter) this.f3562d);
        if (listFilesSafe == null) {
            listFilesSafe = new File[0];
        }
        return ArraysKt.sorted((T[]) (Comparable[]) listFilesSafe);
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, mo148868d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileOrchestrator$BatchFileFilter;", "Ljava/io/FileFilter;", "()V", "accept", "", "file", "Ljava/io/File;", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: BatchFileOrchestrator.kt */
    public static final class BatchFileFilter implements FileFilter {
        public boolean accept(File file) {
            if (file != null && FileExtKt.isFileSafe(file)) {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "file.name");
                if (BatchFileOrchestrator.f3558i.matches(name)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lcom/datadog/android/core/internal/persistence/file/batch/BatchFileOrchestrator$Companion;", "", "()V", "ERROR_CANT_CREATE_ROOT", "", "ERROR_DISK_FULL", "ERROR_LARGE_DATA", "ERROR_ROOT_NOT_DIR", "ERROR_ROOT_NOT_WRITABLE", "batchFileNameRegex", "Lkotlin/text/Regex;", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: BatchFileOrchestrator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
