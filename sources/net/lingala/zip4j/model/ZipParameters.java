package net.lingala.zip4j.model;

import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;

public class ZipParameters {

    /* renamed from: a */
    private CompressionMethod f6853a = CompressionMethod.DEFLATE;

    /* renamed from: b */
    private CompressionLevel f6854b = CompressionLevel.NORMAL;

    /* renamed from: c */
    private boolean f6855c = false;

    /* renamed from: d */
    private EncryptionMethod f6856d = EncryptionMethod.NONE;

    /* renamed from: e */
    private boolean f6857e = true;

    /* renamed from: f */
    private boolean f6858f = true;

    /* renamed from: g */
    private AesKeyStrength f6859g = AesKeyStrength.KEY_STRENGTH_256;

    /* renamed from: h */
    private AesVersion f6860h = AesVersion.TWO;

    /* renamed from: i */
    private boolean f6861i = true;

    /* renamed from: j */
    private long f6862j;

    /* renamed from: k */
    private String f6863k;

    /* renamed from: l */
    private String f6864l;

    /* renamed from: m */
    private long f6865m = System.currentTimeMillis();

    /* renamed from: n */
    private long f6866n = -1;

    /* renamed from: o */
    private boolean f6867o = true;

    /* renamed from: p */
    private boolean f6868p = true;

    /* renamed from: q */
    private String f6869q;

    /* renamed from: r */
    private String f6870r;

    /* renamed from: s */
    private SymbolicLinkAction f6871s = SymbolicLinkAction.INCLUDE_LINKED_FILE_ONLY;

    /* renamed from: t */
    private ExcludeFileFilter f6872t;

    /* renamed from: u */
    private boolean f6873u;

    public enum SymbolicLinkAction {
        INCLUDE_LINK_ONLY,
        INCLUDE_LINKED_FILE_ONLY,
        INCLUDE_LINK_AND_LINKED_FILE
    }

    public ZipParameters() {
    }

    public ZipParameters(ZipParameters zipParameters) {
        this.f6853a = zipParameters.getCompressionMethod();
        this.f6854b = zipParameters.getCompressionLevel();
        this.f6855c = zipParameters.isEncryptFiles();
        this.f6856d = zipParameters.getEncryptionMethod();
        this.f6857e = zipParameters.isReadHiddenFiles();
        this.f6858f = zipParameters.isReadHiddenFolders();
        this.f6859g = zipParameters.getAesKeyStrength();
        this.f6860h = zipParameters.getAesVersion();
        this.f6861i = zipParameters.isIncludeRootFolder();
        this.f6862j = zipParameters.getEntryCRC();
        this.f6863k = zipParameters.getDefaultFolderPath();
        this.f6864l = zipParameters.getFileNameInZip();
        this.f6865m = zipParameters.getLastModifiedFileTime();
        this.f6866n = zipParameters.getEntrySize();
        this.f6867o = zipParameters.isWriteExtendedLocalFileHeader();
        this.f6868p = zipParameters.isOverrideExistingFilesInZip();
        this.f6869q = zipParameters.getRootFolderNameInZip();
        this.f6870r = zipParameters.getFileComment();
        this.f6871s = zipParameters.getSymbolicLinkAction();
        this.f6872t = zipParameters.getExcludeFileFilter();
        this.f6873u = zipParameters.isUnixMode();
    }

    public CompressionMethod getCompressionMethod() {
        return this.f6853a;
    }

    public void setCompressionMethod(CompressionMethod compressionMethod) {
        this.f6853a = compressionMethod;
    }

    public boolean isEncryptFiles() {
        return this.f6855c;
    }

    public void setEncryptFiles(boolean z) {
        this.f6855c = z;
    }

    public EncryptionMethod getEncryptionMethod() {
        return this.f6856d;
    }

    public void setEncryptionMethod(EncryptionMethod encryptionMethod) {
        this.f6856d = encryptionMethod;
    }

    public CompressionLevel getCompressionLevel() {
        return this.f6854b;
    }

    public void setCompressionLevel(CompressionLevel compressionLevel) {
        this.f6854b = compressionLevel;
    }

    public boolean isReadHiddenFiles() {
        return this.f6857e;
    }

    public void setReadHiddenFiles(boolean z) {
        this.f6857e = z;
    }

    public boolean isReadHiddenFolders() {
        return this.f6858f;
    }

    public void setReadHiddenFolders(boolean z) {
        this.f6858f = z;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public AesKeyStrength getAesKeyStrength() {
        return this.f6859g;
    }

    public void setAesKeyStrength(AesKeyStrength aesKeyStrength) {
        this.f6859g = aesKeyStrength;
    }

    public AesVersion getAesVersion() {
        return this.f6860h;
    }

    public void setAesVersion(AesVersion aesVersion) {
        this.f6860h = aesVersion;
    }

    public boolean isIncludeRootFolder() {
        return this.f6861i;
    }

    public void setIncludeRootFolder(boolean z) {
        this.f6861i = z;
    }

    public long getEntryCRC() {
        return this.f6862j;
    }

    public void setEntryCRC(long j) {
        this.f6862j = j;
    }

    public String getDefaultFolderPath() {
        return this.f6863k;
    }

    public void setDefaultFolderPath(String str) {
        this.f6863k = str;
    }

    public String getFileNameInZip() {
        return this.f6864l;
    }

    public void setFileNameInZip(String str) {
        this.f6864l = str;
    }

    public long getLastModifiedFileTime() {
        return this.f6865m;
    }

    public void setLastModifiedFileTime(long j) {
        if (j > 0) {
            this.f6865m = j;
        }
    }

    public long getEntrySize() {
        return this.f6866n;
    }

    public void setEntrySize(long j) {
        this.f6866n = j;
    }

    public boolean isWriteExtendedLocalFileHeader() {
        return this.f6867o;
    }

    public void setWriteExtendedLocalFileHeader(boolean z) {
        this.f6867o = z;
    }

    public boolean isOverrideExistingFilesInZip() {
        return this.f6868p;
    }

    public void setOverrideExistingFilesInZip(boolean z) {
        this.f6868p = z;
    }

    public String getRootFolderNameInZip() {
        return this.f6869q;
    }

    public void setRootFolderNameInZip(String str) {
        this.f6869q = str;
    }

    public String getFileComment() {
        return this.f6870r;
    }

    public void setFileComment(String str) {
        this.f6870r = str;
    }

    public SymbolicLinkAction getSymbolicLinkAction() {
        return this.f6871s;
    }

    public void setSymbolicLinkAction(SymbolicLinkAction symbolicLinkAction) {
        this.f6871s = symbolicLinkAction;
    }

    public ExcludeFileFilter getExcludeFileFilter() {
        return this.f6872t;
    }

    public void setExcludeFileFilter(ExcludeFileFilter excludeFileFilter) {
        this.f6872t = excludeFileFilter;
    }

    public boolean isUnixMode() {
        return this.f6873u;
    }

    public void setUnixMode(boolean z) {
        this.f6873u = z;
    }
}
