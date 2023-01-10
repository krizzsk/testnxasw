package net.lingala.zip4j.model;

public class DigitalSignature extends ZipHeader {

    /* renamed from: a */
    private int f6794a;

    /* renamed from: b */
    private String f6795b;

    public int getSizeOfData() {
        return this.f6794a;
    }

    public void setSizeOfData(int i) {
        this.f6794a = i;
    }

    public String getSignatureData() {
        return this.f6795b;
    }

    public void setSignatureData(String str) {
        this.f6795b = str;
    }
}
