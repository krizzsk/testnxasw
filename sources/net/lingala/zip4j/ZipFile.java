package net.lingala.zip4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.p070io.inputstream.NumberedSplitRandomAccessFile;
import net.lingala.zip4j.p070io.inputstream.ZipInputStream;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AddFilesToZipTask;
import net.lingala.zip4j.tasks.AddFolderToZipTask;
import net.lingala.zip4j.tasks.AddStreamToZipTask;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.tasks.ExtractAllFilesTask;
import net.lingala.zip4j.tasks.ExtractFileTask;
import net.lingala.zip4j.tasks.MergeSplitZipFileTask;
import net.lingala.zip4j.tasks.RemoveFilesFromZipTask;
import net.lingala.zip4j.tasks.RenameFilesTask;
import net.lingala.zip4j.tasks.SetCommentTask;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.UnzipUtil;
import net.lingala.zip4j.util.Zip4jUtil;

public class ZipFile {

    /* renamed from: a */
    private File f6634a;

    /* renamed from: b */
    private ZipModel f6635b;

    /* renamed from: c */
    private boolean f6636c;

    /* renamed from: d */
    private ProgressMonitor f6637d;

    /* renamed from: e */
    private boolean f6638e;

    /* renamed from: f */
    private char[] f6639f;

    /* renamed from: g */
    private HeaderWriter f6640g;

    /* renamed from: h */
    private Charset f6641h;

    /* renamed from: i */
    private ThreadFactory f6642i;

    /* renamed from: j */
    private ExecutorService f6643j;

    /* renamed from: k */
    private int f6644k;

    public ZipFile(String str) {
        this(new File(str), (char[]) null);
    }

    public ZipFile(String str, char[] cArr) {
        this(new File(str), cArr);
    }

    public ZipFile(File file) {
        this(file, (char[]) null);
    }

    public ZipFile(File file, char[] cArr) {
        this.f6640g = new HeaderWriter();
        this.f6641h = null;
        this.f6644k = 4096;
        if (file != null) {
            this.f6634a = file;
            this.f6639f = cArr;
            this.f6638e = false;
            this.f6637d = new ProgressMonitor();
            return;
        }
        throw new IllegalArgumentException("input zip file parameter is null");
    }

    public void createSplitZipFile(List<File> list, ZipParameters zipParameters, boolean z, long j) throws ZipException {
        if (this.f6634a.exists()) {
            throw new ZipException("zip file: " + this.f6634a + " already exists. To add files to existing zip file use addFile method");
        } else if (list == null || list.size() == 0) {
            throw new ZipException("input file List is null, cannot create zip file");
        } else {
            m6440b();
            this.f6635b.setSplitArchive(z);
            this.f6635b.setSplitLength(j);
            new AddFilesToZipTask(this.f6635b, this.f6639f, this.f6640g, m6442d()).execute(new AddFilesToZipTask.AddFilesToZipTaskParameters(list, zipParameters, m6443e()));
        }
    }

    public void createSplitZipFileFromFolder(File file, ZipParameters zipParameters, boolean z, long j) throws ZipException {
        if (file == null) {
            throw new ZipException("folderToAdd is null, cannot create zip file from folder");
        } else if (zipParameters == null) {
            throw new ZipException("input parameters are null, cannot create zip file from folder");
        } else if (!this.f6634a.exists()) {
            m6440b();
            this.f6635b.setSplitArchive(z);
            if (z) {
                this.f6635b.setSplitLength(j);
            }
            m6438a(file, zipParameters, false);
        } else {
            throw new ZipException("zip file: " + this.f6634a + " already exists. To add files to existing zip file use addFolder method");
        }
    }

    public void addFile(String str) throws ZipException {
        addFile(str, new ZipParameters());
    }

    public void addFile(String str, ZipParameters zipParameters) throws ZipException {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            addFiles(Collections.singletonList(new File(str)), zipParameters);
            return;
        }
        throw new ZipException("file to add is null or empty");
    }

    public void addFile(File file) throws ZipException {
        addFiles(Collections.singletonList(file), new ZipParameters());
    }

    public void addFile(File file, ZipParameters zipParameters) throws ZipException {
        addFiles(Collections.singletonList(file), zipParameters);
    }

    public void addFiles(List<File> list) throws ZipException {
        addFiles(list, new ZipParameters());
    }

    public void addFiles(List<File> list, ZipParameters zipParameters) throws ZipException {
        if (list == null || list.size() == 0) {
            throw new ZipException("input file List is null or empty");
        } else if (zipParameters == null) {
            throw new ZipException("input parameters are null");
        } else if (this.f6637d.getState() != ProgressMonitor.State.BUSY) {
            m6437a();
            if (this.f6635b == null) {
                throw new ZipException("internal error: zip model is null");
            } else if (!this.f6634a.exists() || !this.f6635b.isSplitArchive()) {
                new AddFilesToZipTask(this.f6635b, this.f6639f, this.f6640g, m6442d()).execute(new AddFilesToZipTask.AddFilesToZipTaskParameters(list, zipParameters, m6443e()));
            } else {
                throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
            }
        } else {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
    }

    public void addFolder(File file) throws ZipException {
        addFolder(file, new ZipParameters());
    }

    public void addFolder(File file, ZipParameters zipParameters) throws ZipException {
        if (file == null) {
            throw new ZipException("input path is null, cannot add folder to zip file");
        } else if (!file.exists()) {
            throw new ZipException("folder does not exist");
        } else if (!file.isDirectory()) {
            throw new ZipException("input folder is not a directory");
        } else if (!file.canRead()) {
            throw new ZipException("cannot read input folder");
        } else if (zipParameters != null) {
            m6438a(file, zipParameters, true);
        } else {
            throw new ZipException("input parameters are null, cannot add folder to zip file");
        }
    }

    /* renamed from: a */
    private void m6438a(File file, ZipParameters zipParameters, boolean z) throws ZipException {
        m6437a();
        ZipModel zipModel = this.f6635b;
        if (zipModel == null) {
            throw new ZipException("internal error: zip model is null");
        } else if (!z || !zipModel.isSplitArchive()) {
            new AddFolderToZipTask(this.f6635b, this.f6639f, this.f6640g, m6442d()).execute(new AddFolderToZipTask.AddFolderToZipTaskParameters(file, zipParameters, m6443e()));
        } else {
            throw new ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
    }

    public void addStream(InputStream inputStream, ZipParameters zipParameters) throws ZipException {
        if (inputStream == null) {
            throw new ZipException("inputstream is null, cannot add file to zip");
        } else if (zipParameters != null) {
            setRunInThread(false);
            m6437a();
            if (this.f6635b == null) {
                throw new ZipException("internal error: zip model is null");
            } else if (!this.f6634a.exists() || !this.f6635b.isSplitArchive()) {
                new AddStreamToZipTask(this.f6635b, this.f6639f, this.f6640g, m6442d()).execute(new AddStreamToZipTask.AddStreamToZipTaskParameters(inputStream, zipParameters, m6443e()));
            } else {
                throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
            }
        } else {
            throw new ZipException("zip parameters are null");
        }
    }

    public void extractAll(String str) throws ZipException {
        extractAll(str, new UnzipParameters());
    }

    public void extractAll(String str, UnzipParameters unzipParameters) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("output path is null or invalid");
        } else if (Zip4jUtil.createDirectoryIfNotExists(new File(str))) {
            if (this.f6635b == null) {
                m6437a();
            }
            if (this.f6635b == null) {
                throw new ZipException("Internal error occurred when extracting zip file");
            } else if (this.f6637d.getState() != ProgressMonitor.State.BUSY) {
                new ExtractAllFilesTask(this.f6635b, this.f6639f, unzipParameters, m6442d()).execute(new ExtractAllFilesTask.ExtractAllFilesTaskParameters(str, m6443e()));
            } else {
                throw new ZipException("invalid operation - Zip4j is in busy state");
            }
        } else {
            throw new ZipException("invalid output path");
        }
    }

    public void extractFile(FileHeader fileHeader, String str) throws ZipException {
        extractFile(fileHeader, str, (String) null, new UnzipParameters());
    }

    public void extractFile(FileHeader fileHeader, String str, UnzipParameters unzipParameters) throws ZipException {
        extractFile(fileHeader, str, (String) null, unzipParameters);
    }

    public void extractFile(String str, String str2) throws ZipException {
        extractFile(str, str2, (String) null, new UnzipParameters());
    }

    public void extractFile(String str, String str2, UnzipParameters unzipParameters) throws ZipException {
        extractFile(str, str2, (String) null, unzipParameters);
    }

    public void extractFile(String str, String str2, String str3) throws ZipException {
        extractFile(str, str2, str3, new UnzipParameters());
    }

    public void extractFile(FileHeader fileHeader, String str, String str2) throws ZipException {
        extractFile(fileHeader, str, str2, new UnzipParameters());
    }

    public void extractFile(String str, String str2, String str3, UnzipParameters unzipParameters) throws ZipException {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            m6437a();
            FileHeader fileHeader = HeaderUtil.getFileHeader(this.f6635b, str);
            if (fileHeader != null) {
                extractFile(fileHeader, str2, str3, unzipParameters);
                return;
            }
            throw new ZipException("No file found with name " + str + " in zip file", ZipException.Type.FILE_NOT_FOUND);
        }
        throw new ZipException("file to extract is null or empty, cannot extract file");
    }

    public void extractFile(FileHeader fileHeader, String str, String str2, UnzipParameters unzipParameters) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("input file header is null, cannot extract file");
        } else if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("destination path is empty or null, cannot extract file");
        } else if (this.f6637d.getState() != ProgressMonitor.State.BUSY) {
            if (unzipParameters == null) {
                unzipParameters = new UnzipParameters();
            }
            m6437a();
            new ExtractFileTask(this.f6635b, this.f6639f, unzipParameters, m6442d()).execute(new ExtractFileTask.ExtractFileTaskParameters(str, fileHeader, str2, m6443e()));
        } else {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
    }

    public List<FileHeader> getFileHeaders() throws ZipException {
        m6437a();
        ZipModel zipModel = this.f6635b;
        if (zipModel == null || zipModel.getCentralDirectory() == null) {
            return Collections.emptyList();
        }
        return this.f6635b.getCentralDirectory().getFileHeaders();
    }

    public FileHeader getFileHeader(String str) throws ZipException {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            m6437a();
            ZipModel zipModel = this.f6635b;
            if (zipModel == null || zipModel.getCentralDirectory() == null) {
                return null;
            }
            return HeaderUtil.getFileHeader(this.f6635b, str);
        }
        throw new ZipException("input file name is emtpy or null, cannot get FileHeader");
    }

    public boolean isEncrypted() throws ZipException {
        if (this.f6635b == null) {
            m6437a();
            if (this.f6635b == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        if (this.f6635b.getCentralDirectory() == null || this.f6635b.getCentralDirectory().getFileHeaders() == null) {
            throw new ZipException("invalid zip file");
        }
        Iterator<FileHeader> it = this.f6635b.getCentralDirectory().getFileHeaders().iterator();
        while (true) {
            if (it.hasNext()) {
                FileHeader next = it.next();
                if (next != null && next.isEncrypted()) {
                    this.f6636c = true;
                    break;
                }
            } else {
                break;
            }
        }
        return this.f6636c;
    }

    public boolean isSplitArchive() throws ZipException {
        if (this.f6635b == null) {
            m6437a();
            if (this.f6635b == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        return this.f6635b.isSplitArchive();
    }

    public void removeFile(FileHeader fileHeader) throws ZipException {
        if (fileHeader != null) {
            removeFile(fileHeader.getFileName());
            return;
        }
        throw new ZipException("input file header is null, cannot remove file");
    }

    public void removeFile(String str) throws ZipException {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            removeFiles(Collections.singletonList(str));
            return;
        }
        throw new ZipException("file name is empty or null, cannot remove file");
    }

    public void removeFiles(List<String> list) throws ZipException {
        if (list == null) {
            throw new ZipException("fileNames list is null");
        } else if (!list.isEmpty()) {
            if (this.f6635b == null) {
                m6437a();
            }
            if (!this.f6635b.isSplitArchive()) {
                new RemoveFilesFromZipTask(this.f6635b, this.f6640g, m6442d()).execute(new RemoveFilesFromZipTask.RemoveFilesFromZipTaskParameters(list, m6443e()));
                return;
            }
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        }
    }

    public void renameFile(FileHeader fileHeader, String str) throws ZipException {
        if (fileHeader != null) {
            renameFile(fileHeader.getFileName(), str);
            return;
        }
        throw new ZipException("File header is null");
    }

    public void renameFile(String str, String str2) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("file name to be changed is null or empty");
        } else if (Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            renameFiles(Collections.singletonMap(str, str2));
        } else {
            throw new ZipException("newFileName is null or empty");
        }
    }

    public void renameFiles(Map<String, String> map) throws ZipException {
        if (map == null) {
            throw new ZipException("fileNamesMap is null");
        } else if (map.size() != 0) {
            m6437a();
            if (!this.f6635b.isSplitArchive()) {
                new RenameFilesTask(this.f6635b, this.f6640g, new RawIO(), m6442d()).execute(new RenameFilesTask.RenameFilesTaskParameters(map, m6443e()));
                return;
            }
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        }
    }

    public void mergeSplitFiles(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("outputZipFile is null, cannot merge split files");
        } else if (!file.exists()) {
            m6437a();
            ZipModel zipModel = this.f6635b;
            if (zipModel != null) {
                new MergeSplitZipFileTask(zipModel, m6442d()).execute(new MergeSplitZipFileTask.MergeSplitZipFileTaskParameters(file, m6443e()));
                return;
            }
            throw new ZipException("zip model is null, corrupt zip file?");
        } else {
            throw new ZipException("output Zip File already exists");
        }
    }

    public void setComment(String str) throws ZipException {
        if (str == null) {
            throw new ZipException("input comment is null, cannot update zip file");
        } else if (this.f6634a.exists()) {
            m6437a();
            ZipModel zipModel = this.f6635b;
            if (zipModel == null) {
                throw new ZipException("zipModel is null, cannot update zip file");
            } else if (zipModel.getEndOfCentralDirectoryRecord() != null) {
                new SetCommentTask(this.f6635b, m6442d()).execute(new SetCommentTask.SetCommentTaskTaskParameters(str, m6443e()));
            } else {
                throw new ZipException("end of central directory is null, cannot set comment");
            }
        } else {
            throw new ZipException("zip file does not exist, cannot set comment for zip file");
        }
    }

    public String getComment() throws ZipException {
        if (this.f6634a.exists()) {
            m6437a();
            ZipModel zipModel = this.f6635b;
            if (zipModel == null) {
                throw new ZipException("zip model is null, cannot read comment");
            } else if (zipModel.getEndOfCentralDirectoryRecord() != null) {
                return this.f6635b.getEndOfCentralDirectoryRecord().getComment();
            } else {
                throw new ZipException("end of central directory record is null, cannot read comment");
            }
        } else {
            throw new ZipException("zip file does not exist, cannot read comment");
        }
    }

    public ZipInputStream getInputStream(FileHeader fileHeader) throws IOException {
        if (fileHeader != null) {
            m6437a();
            ZipModel zipModel = this.f6635b;
            if (zipModel != null) {
                return UnzipUtil.createZipInputStream(zipModel, fileHeader, this.f6639f);
            }
            throw new ZipException("zip model is null, cannot get inputstream");
        }
        throw new ZipException("FileHeader is null, cannot get InputStream");
    }

    public boolean isValidZipFile() {
        if (!this.f6634a.exists()) {
            return false;
        }
        try {
            m6437a();
            if (!this.f6635b.isSplitArchive() || m6439a(getSplitZipFiles())) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public List<File> getSplitZipFiles() throws ZipException {
        m6437a();
        return FileUtils.getSplitZipFiles(this.f6635b);
    }

    public void setPassword(char[] cArr) {
        this.f6639f = cArr;
    }

    public int getBufferSize() {
        return this.f6644k;
    }

    public void setBufferSize(int i) {
        if (i >= 512) {
            this.f6644k = i;
            return;
        }
        throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r0 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
        throw r2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6437a() throws net.lingala.zip4j.exception.ZipException {
        /*
            r3 = this;
            net.lingala.zip4j.model.ZipModel r0 = r3.f6635b
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.io.File r0 = r3.f6634a
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0011
            r3.m6440b()
            return
        L_0x0011:
            java.io.File r0 = r3.f6634a
            boolean r0 = r0.canRead()
            if (r0 == 0) goto L_0x004e
            java.io.RandomAccessFile r0 = r3.m6441c()     // Catch:{ ZipException -> 0x004c, IOException -> 0x0045 }
            net.lingala.zip4j.headers.HeaderReader r1 = new net.lingala.zip4j.headers.HeaderReader     // Catch:{ all -> 0x0037 }
            r1.<init>()     // Catch:{ all -> 0x0037 }
            net.lingala.zip4j.model.Zip4jConfig r2 = r3.m6443e()     // Catch:{ all -> 0x0037 }
            net.lingala.zip4j.model.ZipModel r1 = r1.readAllHeaders(r0, r2)     // Catch:{ all -> 0x0037 }
            r3.f6635b = r1     // Catch:{ all -> 0x0037 }
            java.io.File r2 = r3.f6634a     // Catch:{ all -> 0x0037 }
            r1.setZipFile(r2)     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0036
            r0.close()     // Catch:{ ZipException -> 0x004c, IOException -> 0x0045 }
        L_0x0036:
            return
        L_0x0037:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r2 = move-exception
            if (r0 == 0) goto L_0x0044
            r0.close()     // Catch:{ all -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ ZipException -> 0x004c, IOException -> 0x0045 }
        L_0x0044:
            throw r2     // Catch:{ ZipException -> 0x004c, IOException -> 0x0045 }
        L_0x0045:
            r0 = move-exception
            net.lingala.zip4j.exception.ZipException r1 = new net.lingala.zip4j.exception.ZipException
            r1.<init>((java.lang.Exception) r0)
            throw r1
        L_0x004c:
            r0 = move-exception
            throw r0
        L_0x004e:
            net.lingala.zip4j.exception.ZipException r0 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r1 = "no read access for the input zip file"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.ZipFile.m6437a():void");
    }

    /* renamed from: b */
    private void m6440b() {
        ZipModel zipModel = new ZipModel();
        this.f6635b = zipModel;
        zipModel.setZipFile(this.f6634a);
    }

    /* renamed from: c */
    private RandomAccessFile m6441c() throws IOException {
        if (!FileUtils.isNumberedSplitFile(this.f6634a)) {
            return new RandomAccessFile(this.f6634a, RandomAccessFileMode.READ.getValue());
        }
        NumberedSplitRandomAccessFile numberedSplitRandomAccessFile = new NumberedSplitRandomAccessFile(this.f6634a, RandomAccessFileMode.READ.getValue(), FileUtils.getAllSortedNumberedSplitFiles(this.f6634a));
        numberedSplitRandomAccessFile.openLastSplitFileForReading();
        return numberedSplitRandomAccessFile;
    }

    /* renamed from: d */
    private AsyncZipTask.AsyncTaskParameters m6442d() {
        if (this.f6638e) {
            if (this.f6642i == null) {
                this.f6642i = Executors.defaultThreadFactory();
            }
            this.f6643j = Executors.newSingleThreadExecutor(this.f6642i);
        }
        return new AsyncZipTask.AsyncTaskParameters(this.f6643j, this.f6638e, this.f6637d);
    }

    /* renamed from: a */
    private boolean m6439a(List<File> list) {
        for (File exists : list) {
            if (!exists.exists()) {
                return false;
            }
        }
        return true;
    }

    public ProgressMonitor getProgressMonitor() {
        return this.f6637d;
    }

    public boolean isRunInThread() {
        return this.f6638e;
    }

    public void setRunInThread(boolean z) {
        this.f6638e = z;
    }

    public File getFile() {
        return this.f6634a;
    }

    public Charset getCharset() {
        Charset charset = this.f6641h;
        return charset == null ? InternalZipConstants.CHARSET_UTF_8 : charset;
    }

    public void setCharset(Charset charset) throws IllegalArgumentException {
        if (charset != null) {
            this.f6641h = charset;
            return;
        }
        throw new IllegalArgumentException("charset cannot be null");
    }

    public void setThreadFactory(ThreadFactory threadFactory) {
        this.f6642i = threadFactory;
    }

    public ExecutorService getExecutorService() {
        return this.f6643j;
    }

    public String toString() {
        return this.f6634a.toString();
    }

    /* renamed from: e */
    private Zip4jConfig m6443e() {
        return new Zip4jConfig(this.f6641h, this.f6644k);
    }
}
