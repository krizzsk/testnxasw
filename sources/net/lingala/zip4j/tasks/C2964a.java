package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.FileUtils;

/* renamed from: net.lingala.zip4j.tasks.a */
/* compiled from: AbstractModifyFileTask */
abstract class C2964a<T> extends AsyncZipTask<T> {
    C2964a(AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public File mo29759a(String str) {
        Random random = new Random();
        File file = new File(str + random.nextInt(10000));
        while (file.exists()) {
            file = new File(str + random.nextInt(10000));
        }
        return file;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29761a(List<FileHeader> list, ZipModel zipModel, FileHeader fileHeader, long j) throws ZipException {
        int a = m6635a(list, fileHeader);
        if (a != -1) {
            while (true) {
                a++;
                if (a < list.size()) {
                    FileHeader fileHeader2 = list.get(a);
                    fileHeader2.setOffsetLocalHeader(fileHeader2.getOffsetLocalHeader() + j);
                    if (!(!zipModel.isZip64Format() || fileHeader2.getZip64ExtendedInfo() == null || fileHeader2.getZip64ExtendedInfo().getOffsetLocalHeader() == -1)) {
                        fileHeader2.getZip64ExtendedInfo().setOffsetLocalHeader(fileHeader2.getZip64ExtendedInfo().getOffsetLocalHeader() + j);
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new ZipException("Could not locate modified file header in zipModel");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29762a(boolean z, File file, File file2) throws ZipException {
        if (z) {
            m6637a(file, file2);
        } else if (!file2.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo29757a(RandomAccessFile randomAccessFile, OutputStream outputStream, long j, long j2, ProgressMonitor progressMonitor, int i) throws IOException {
        FileUtils.copyFile(randomAccessFile, outputStream, j, j + j2, progressMonitor, i);
        return j2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<FileHeader> mo29760a(List<FileHeader> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, $$Lambda$a$ziUIGSxpJesZ92kF7bWtjyiOjE.INSTANCE);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ int m6636a(FileHeader fileHeader, FileHeader fileHeader2) {
        if (fileHeader.getFileName().equals(fileHeader2.getFileName())) {
            return 0;
        }
        return fileHeader.getOffsetLocalHeader() < fileHeader2.getOffsetLocalHeader() ? -1 : 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo29758a(List<FileHeader> list, FileHeader fileHeader, ZipModel zipModel) throws ZipException {
        int a = m6635a(list, fileHeader);
        if (a == list.size() - 1) {
            return HeaderUtil.getOffsetStartOfCentralDirectory(zipModel);
        }
        return list.get(a + 1).getOffsetLocalHeader();
    }

    /* renamed from: a */
    private void m6637a(File file, File file2) throws ZipException {
        if (!file.delete()) {
            throw new ZipException("cannot delete old zip file");
        } else if (!file2.renameTo(file)) {
            throw new ZipException("cannot rename modified zip file");
        }
    }

    /* renamed from: a */
    private int m6635a(List<FileHeader> list, FileHeader fileHeader) throws ZipException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(fileHeader)) {
                return i;
            }
        }
        throw new ZipException("Could not find file header in list of central directory file headers");
    }
}
