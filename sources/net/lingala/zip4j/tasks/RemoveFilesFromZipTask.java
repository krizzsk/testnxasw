package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.p070io.outputstream.SplitOutputStream;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;

public class RemoveFilesFromZipTask extends C2964a<RemoveFilesFromZipTaskParameters> {

    /* renamed from: a */
    private ZipModel f6898a;

    /* renamed from: b */
    private HeaderWriter f6899b;

    public RemoveFilesFromZipTask(ZipModel zipModel, HeaderWriter headerWriter, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.f6898a = zipModel;
        this.f6899b = headerWriter;
    }

    /* access modifiers changed from: protected */
    public void executeTask(RemoveFilesFromZipTaskParameters removeFilesFromZipTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        Throwable th;
        List<FileHeader> list;
        RemoveFilesFromZipTaskParameters removeFilesFromZipTaskParameters2 = removeFilesFromZipTaskParameters;
        if (!this.f6898a.isSplitArchive()) {
            List<String> b = m6629b(removeFilesFromZipTaskParameters.filesToRemove);
            if (!b.isEmpty()) {
                File a = mo29759a(this.f6898a.getZipFile().getPath());
                boolean z = false;
                try {
                    SplitOutputStream splitOutputStream = new SplitOutputStream(a);
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f6898a.getZipFile(), RandomAccessFileMode.READ.getValue());
                        try {
                            List<FileHeader> a2 = mo29760a(this.f6898a.getCentralDirectory().getFileHeaders());
                            long j = 0;
                            for (FileHeader next : a2) {
                                long a3 = mo29758a(a2, next, this.f6898a) - splitOutputStream.getFilePointer();
                                if (m6628a(next, b)) {
                                    m6627a(a2, next, a3);
                                    if (this.f6898a.getCentralDirectory().getFileHeaders().remove(next)) {
                                        j += a3;
                                        list = a2;
                                    } else {
                                        throw new ZipException("Could not remove entry from list of central directory headers");
                                    }
                                } else {
                                    list = a2;
                                    j += super.mo29757a(randomAccessFile, splitOutputStream, j, a3, progressMonitor, removeFilesFromZipTaskParameters2.zip4jConfig.getBufferSize());
                                }
                                verifyIfTaskIsCancelled();
                                a2 = list;
                            }
                            this.f6899b.finalizeZipFile(this.f6898a, splitOutputStream, removeFilesFromZipTaskParameters2.zip4jConfig.getCharset());
                            z = true;
                            randomAccessFile.close();
                            splitOutputStream.close();
                            mo29762a(true, this.f6898a.getZipFile(), a);
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            randomAccessFile.close();
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    } finally {
                        th = th4;
                        try {
                        } catch (Throwable th5) {
                            Throwable th6 = th5;
                            splitOutputStream.close();
                            throw th6;
                        }
                    }
                } catch (Throwable th7) {
                    mo29762a(z, this.f6898a.getZipFile(), a);
                    throw th7;
                }
            }
        } else {
            throw new ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
    }

    /* access modifiers changed from: protected */
    public long calculateTotalWork(RemoveFilesFromZipTaskParameters removeFilesFromZipTaskParameters) {
        return this.f6898a.getZipFile().length();
    }

    /* renamed from: b */
    private List<String> m6629b(List<String> list) throws ZipException {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (HeaderUtil.getFileHeader(this.f6898a, next) != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private boolean m6628a(FileHeader fileHeader, List<String> list) {
        for (String startsWith : list) {
            if (fileHeader.getFileName().startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m6627a(List<FileHeader> list, FileHeader fileHeader, long j) throws ZipException {
        mo29761a(list, this.f6898a, fileHeader, m6626a(j));
        EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = this.f6898a.getEndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setOffsetOfStartOfCentralDirectory(endOfCentralDirectoryRecord.getOffsetOfStartOfCentralDirectory() - j);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(endOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectory() - 1);
        if (endOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() > 0) {
            endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(endOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() - 1);
        }
        if (this.f6898a.isZip64Format()) {
            this.f6898a.getZip64EndOfCentralDirectoryRecord().setOffsetStartCentralDirectoryWRTStartDiskNumber(this.f6898a.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber() - j);
            this.f6898a.getZip64EndOfCentralDirectoryRecord().setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(this.f6898a.getZip64EndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory() - 1);
            this.f6898a.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(this.f6898a.getZip64EndOfCentralDirectoryLocator().getOffsetZip64EndOfCentralDirectoryRecord() - j);
        }
    }

    /* renamed from: a */
    private long m6626a(long j) {
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        throw new ArithmeticException("long overflow");
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.REMOVE_ENTRY;
    }

    public static class RemoveFilesFromZipTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */
        public List<String> filesToRemove;

        public RemoveFilesFromZipTaskParameters(List<String> list, Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.filesToRemove = list;
        }
    }
}
