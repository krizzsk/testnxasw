package net.lingala.zip4j.model;

import java.util.ArrayList;
import java.util.List;

public class CentralDirectory {

    /* renamed from: a */
    private List<FileHeader> f6789a = new ArrayList();

    /* renamed from: b */
    private DigitalSignature f6790b = new DigitalSignature();

    public List<FileHeader> getFileHeaders() {
        return this.f6789a;
    }

    public void setFileHeaders(List<FileHeader> list) {
        this.f6789a = list;
    }

    public DigitalSignature getDigitalSignature() {
        return this.f6790b;
    }

    public void setDigitalSignature(DigitalSignature digitalSignature) {
        this.f6790b = digitalSignature;
    }
}
