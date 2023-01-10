package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public class EndOfCentralDirectoryRecord extends ZipHeader {

    /* renamed from: a */
    private int f6796a;

    /* renamed from: b */
    private int f6797b;

    /* renamed from: c */
    private int f6798c;

    /* renamed from: d */
    private int f6799d;

    /* renamed from: e */
    private int f6800e;

    /* renamed from: f */
    private long f6801f;

    /* renamed from: g */
    private long f6802g;

    /* renamed from: h */
    private String f6803h = "";

    public EndOfCentralDirectoryRecord() {
        setSignature(HeaderSignature.END_OF_CENTRAL_DIRECTORY);
    }

    public int getNumberOfThisDisk() {
        return this.f6796a;
    }

    public void setNumberOfThisDisk(int i) {
        this.f6796a = i;
    }

    public int getNumberOfThisDiskStartOfCentralDir() {
        return this.f6797b;
    }

    public void setNumberOfThisDiskStartOfCentralDir(int i) {
        this.f6797b = i;
    }

    public int getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() {
        return this.f6798c;
    }

    public void setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(int i) {
        this.f6798c = i;
    }

    public int getTotalNumberOfEntriesInCentralDirectory() {
        return this.f6799d;
    }

    public void setTotalNumberOfEntriesInCentralDirectory(int i) {
        this.f6799d = i;
    }

    public int getSizeOfCentralDirectory() {
        return this.f6800e;
    }

    public void setSizeOfCentralDirectory(int i) {
        this.f6800e = i;
    }

    public long getOffsetOfStartOfCentralDirectory() {
        return this.f6801f;
    }

    public void setOffsetOfStartOfCentralDirectory(long j) {
        this.f6801f = j;
    }

    public long getOffsetOfEndOfCentralDirectory() {
        return this.f6802g;
    }

    public void setOffsetOfEndOfCentralDirectory(long j) {
        this.f6802g = j;
    }

    public String getComment() {
        return this.f6803h;
    }

    public void setComment(String str) {
        if (str != null) {
            this.f6803h = str;
        }
    }
}
