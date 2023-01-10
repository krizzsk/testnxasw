package net.lingala.zip4j.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ZipModel implements Cloneable {

    /* renamed from: a */
    private List<LocalFileHeader> f6839a = new ArrayList();

    /* renamed from: b */
    private List<DataDescriptor> f6840b = new ArrayList();

    /* renamed from: c */
    private ArchiveExtraDataRecord f6841c = new ArchiveExtraDataRecord();

    /* renamed from: d */
    private CentralDirectory f6842d = new CentralDirectory();

    /* renamed from: e */
    private EndOfCentralDirectoryRecord f6843e = new EndOfCentralDirectoryRecord();

    /* renamed from: f */
    private Zip64EndOfCentralDirectoryLocator f6844f = new Zip64EndOfCentralDirectoryLocator();

    /* renamed from: g */
    private Zip64EndOfCentralDirectoryRecord f6845g = new Zip64EndOfCentralDirectoryRecord();

    /* renamed from: h */
    private boolean f6846h;

    /* renamed from: i */
    private long f6847i = -1;

    /* renamed from: j */
    private File f6848j;

    /* renamed from: k */
    private boolean f6849k = false;

    /* renamed from: l */
    private boolean f6850l;

    /* renamed from: m */
    private long f6851m;

    /* renamed from: n */
    private long f6852n;

    public List<LocalFileHeader> getLocalFileHeaders() {
        return this.f6839a;
    }

    public void setLocalFileHeaders(List<LocalFileHeader> list) {
        this.f6839a = list;
    }

    public List<DataDescriptor> getDataDescriptors() {
        return this.f6840b;
    }

    public void setDataDescriptors(List<DataDescriptor> list) {
        this.f6840b = list;
    }

    public CentralDirectory getCentralDirectory() {
        return this.f6842d;
    }

    public void setCentralDirectory(CentralDirectory centralDirectory) {
        this.f6842d = centralDirectory;
    }

    public EndOfCentralDirectoryRecord getEndOfCentralDirectoryRecord() {
        return this.f6843e;
    }

    public void setEndOfCentralDirectoryRecord(EndOfCentralDirectoryRecord endOfCentralDirectoryRecord) {
        this.f6843e = endOfCentralDirectoryRecord;
    }

    public ArchiveExtraDataRecord getArchiveExtraDataRecord() {
        return this.f6841c;
    }

    public void setArchiveExtraDataRecord(ArchiveExtraDataRecord archiveExtraDataRecord) {
        this.f6841c = archiveExtraDataRecord;
    }

    public boolean isSplitArchive() {
        return this.f6846h;
    }

    public void setSplitArchive(boolean z) {
        this.f6846h = z;
    }

    public File getZipFile() {
        return this.f6848j;
    }

    public void setZipFile(File file) {
        this.f6848j = file;
    }

    public Zip64EndOfCentralDirectoryLocator getZip64EndOfCentralDirectoryLocator() {
        return this.f6844f;
    }

    public void setZip64EndOfCentralDirectoryLocator(Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator) {
        this.f6844f = zip64EndOfCentralDirectoryLocator;
    }

    public Zip64EndOfCentralDirectoryRecord getZip64EndOfCentralDirectoryRecord() {
        return this.f6845g;
    }

    public void setZip64EndOfCentralDirectoryRecord(Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord) {
        this.f6845g = zip64EndOfCentralDirectoryRecord;
    }

    public boolean isZip64Format() {
        return this.f6849k;
    }

    public void setZip64Format(boolean z) {
        this.f6849k = z;
    }

    public boolean isNestedZipFile() {
        return this.f6850l;
    }

    public void setNestedZipFile(boolean z) {
        this.f6850l = z;
    }

    public long getStart() {
        return this.f6851m;
    }

    public void setStart(long j) {
        this.f6851m = j;
    }

    public long getEnd() {
        return this.f6852n;
    }

    public void setEnd(long j) {
        this.f6852n = j;
    }

    public long getSplitLength() {
        return this.f6847i;
    }

    public void setSplitLength(long j) {
        this.f6847i = j;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
