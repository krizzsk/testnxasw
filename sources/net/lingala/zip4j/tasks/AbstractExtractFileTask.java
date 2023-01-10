package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.p070io.inputstream.ZipInputStream;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.BitUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.UnzipUtil;
import net.lingala.zip4j.util.Zip4jUtil;

public abstract class AbstractExtractFileTask<T> extends AsyncZipTask<T> {

    /* renamed from: a */
    private ZipModel f6887a;

    /* renamed from: b */
    private UnzipParameters f6888b;

    public AbstractExtractFileTask(ZipModel zipModel, UnzipParameters unzipParameters, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.f6887a = zipModel;
        this.f6888b = unzipParameters;
    }

    /* access modifiers changed from: protected */
    public void extractFile(ZipInputStream zipInputStream, FileHeader fileHeader, String str, String str2, ProgressMonitor progressMonitor, byte[] bArr) throws IOException {
        if (!m6606a(fileHeader) || this.f6888b.isExtractSymbolicLinks()) {
            if (!str.endsWith(InternalZipConstants.FILE_SEPARATOR)) {
                str = str + InternalZipConstants.FILE_SEPARATOR;
            }
            File a = m6600a(fileHeader, str, str2);
            progressMonitor.setFileName(a.getAbsolutePath());
            if (a.getCanonicalPath().startsWith(new File(str).getCanonicalPath() + File.separator)) {
                m6604a(zipInputStream, fileHeader);
                if (fileHeader.isDirectory()) {
                    if (!a.exists() && !a.mkdirs()) {
                        throw new ZipException("Could not create directory: " + a);
                    }
                } else if (m6606a(fileHeader)) {
                    m6605a(zipInputStream, fileHeader, a, progressMonitor);
                } else {
                    m6602a(a);
                    m6603a(zipInputStream, a, progressMonitor, bArr);
                }
                UnzipUtil.applyFileAttributes(fileHeader, a);
                return;
            }
            throw new ZipException("illegal file name that breaks out of the target directory: " + fileHeader.getFileName());
        }
    }

    /* renamed from: a */
    private boolean m6606a(FileHeader fileHeader) {
        byte[] externalFileAttributes = fileHeader.getExternalFileAttributes();
        if (externalFileAttributes == null || externalFileAttributes.length < 4) {
            return false;
        }
        return BitUtils.isBitSet(externalFileAttributes[3], 5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        throw r6;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6603a(net.lingala.zip4j.p070io.inputstream.ZipInputStream r4, java.io.File r5, net.lingala.zip4j.progress.ProgressMonitor r6, byte[] r7) throws java.io.IOException {
        /*
            r3 = this;
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0028 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0028 }
        L_0x0005:
            int r1 = r4.read(r7)     // Catch:{ all -> 0x001c }
            r2 = -1
            if (r1 == r2) goto L_0x0018
            r2 = 0
            r0.write(r7, r2, r1)     // Catch:{ all -> 0x001c }
            long r1 = (long) r1     // Catch:{ all -> 0x001c }
            r6.updateWorkCompleted(r1)     // Catch:{ all -> 0x001c }
            r3.verifyIfTaskIsCancelled()     // Catch:{ all -> 0x001c }
            goto L_0x0005
        L_0x0018:
            r0.close()     // Catch:{ Exception -> 0x0028 }
            return
        L_0x001c:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x001e }
        L_0x001e:
            r6 = move-exception
            r0.close()     // Catch:{ all -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r7 = move-exception
            r4.addSuppressed(r7)     // Catch:{ Exception -> 0x0028 }
        L_0x0027:
            throw r6     // Catch:{ Exception -> 0x0028 }
        L_0x0028:
            r4 = move-exception
            boolean r6 = r5.exists()
            if (r6 == 0) goto L_0x0032
            r5.delete()
        L_0x0032:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.tasks.AbstractExtractFileTask.m6603a(net.lingala.zip4j.io.inputstream.ZipInputStream, java.io.File, net.lingala.zip4j.progress.ProgressMonitor, byte[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        r3.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        throw r4;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6605a(net.lingala.zip4j.p070io.inputstream.ZipInputStream r2, net.lingala.zip4j.model.FileHeader r3, java.io.File r4, net.lingala.zip4j.progress.ProgressMonitor r5) throws java.io.IOException {
        /*
            r1 = this;
            java.lang.String r0 = new java.lang.String
            byte[] r2 = r1.m6607a((net.lingala.zip4j.p070io.inputstream.ZipInputStream) r2, (net.lingala.zip4j.model.FileHeader) r3, (net.lingala.zip4j.progress.ProgressMonitor) r5)
            r0.<init>(r2)
            java.io.File r2 = r4.getParentFile()
            boolean r2 = r2.exists()
            if (r2 != 0) goto L_0x0026
            java.io.File r2 = r4.getParentFile()
            boolean r2 = r2.mkdirs()
            if (r2 == 0) goto L_0x001e
            goto L_0x0026
        L_0x001e:
            net.lingala.zip4j.exception.ZipException r2 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r3 = "Could not create parent directories"
            r2.<init>((java.lang.String) r3)
            throw r2
        L_0x0026:
            r2 = 0
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ NoSuchMethodError -> 0x0037 }
            java.nio.file.Path r3 = java.nio.file.Paths.get(r0, r3)     // Catch:{ NoSuchMethodError -> 0x0037 }
            java.nio.file.Path r5 = r4.toPath()     // Catch:{ NoSuchMethodError -> 0x0037 }
            java.nio.file.attribute.FileAttribute[] r2 = new java.nio.file.attribute.FileAttribute[r2]     // Catch:{ NoSuchMethodError -> 0x0037 }
            java.nio.file.Files.createSymbolicLink(r5, r3, r2)     // Catch:{ NoSuchMethodError -> 0x0037 }
            goto L_0x0046
        L_0x0037:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream
            r2.<init>(r4)
            byte[] r3 = r0.getBytes()     // Catch:{ all -> 0x0047 }
            r2.write(r3)     // Catch:{ all -> 0x0047 }
            r2.close()
        L_0x0046:
            return
        L_0x0047:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r4 = move-exception
            r2.close()     // Catch:{ all -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r2 = move-exception
            r3.addSuppressed(r2)
        L_0x0052:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.tasks.AbstractExtractFileTask.m6605a(net.lingala.zip4j.io.inputstream.ZipInputStream, net.lingala.zip4j.model.FileHeader, java.io.File, net.lingala.zip4j.progress.ProgressMonitor):void");
    }

    /* renamed from: a */
    private byte[] m6607a(ZipInputStream zipInputStream, FileHeader fileHeader, ProgressMonitor progressMonitor) throws IOException {
        int uncompressedSize = (int) fileHeader.getUncompressedSize();
        byte[] bArr = new byte[uncompressedSize];
        if (zipInputStream.read(bArr) == uncompressedSize) {
            progressMonitor.updateWorkCompleted((long) uncompressedSize);
            return bArr;
        }
        throw new ZipException("Could not read complete entry");
    }

    /* renamed from: a */
    private void m6604a(ZipInputStream zipInputStream, FileHeader fileHeader) throws IOException {
        if (!BitUtils.isBitSet(fileHeader.getGeneralPurposeFlag()[0], 6)) {
            LocalFileHeader nextEntry = zipInputStream.getNextEntry(fileHeader);
            if (nextEntry == null) {
                throw new ZipException("Could not read corresponding local file header for file header: " + fileHeader.getFileName());
            } else if (!fileHeader.getFileName().equals(nextEntry.getFileName())) {
                throw new ZipException("File header and local file header mismatch");
            }
        } else {
            throw new ZipException("Entry with name " + fileHeader.getFileName() + " is encrypted with Strong Encryption. Zip4j does not support Strong Encryption, as this is patented.");
        }
    }

    /* renamed from: a */
    private void m6602a(File file) throws ZipException {
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            throw new ZipException("Unable to create parent directories: " + file.getParentFile());
        }
    }

    /* renamed from: a */
    private File m6600a(FileHeader fileHeader, String str, String str2) {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            str2 = m6601a(fileHeader.getFileName());
        }
        return new File(str + InternalZipConstants.FILE_SEPARATOR + str2);
    }

    /* renamed from: a */
    private String m6601a(String str) {
        return str.replaceAll("[/\\\\]", Matcher.quoteReplacement(InternalZipConstants.FILE_SEPARATOR));
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.EXTRACT_ENTRY;
    }

    public ZipModel getZipModel() {
        return this.f6887a;
    }
}
