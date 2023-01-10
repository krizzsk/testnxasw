package net.lingala.zip4j.model;

public class ArchiveExtraDataRecord extends ZipHeader {

    /* renamed from: a */
    private int f6787a;

    /* renamed from: b */
    private String f6788b;

    public int getExtraFieldLength() {
        return this.f6787a;
    }

    public void setExtraFieldLength(int i) {
        this.f6787a = i;
    }

    public String getExtraFieldData() {
        return this.f6788b;
    }

    public void setExtraFieldData(String str) {
        this.f6788b = str;
    }
}
