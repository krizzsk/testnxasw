package p068me.dm7.barcodescanner.zbar;

/* renamed from: me.dm7.barcodescanner.zbar.Result */
public class Result {

    /* renamed from: a */
    private String f6626a;

    /* renamed from: b */
    private BarcodeFormat f6627b;

    public void setContents(String str) {
        this.f6626a = str;
    }

    public void setBarcodeFormat(BarcodeFormat barcodeFormat) {
        this.f6627b = barcodeFormat;
    }

    public BarcodeFormat getBarcodeFormat() {
        return this.f6627b;
    }

    public String getContents() {
        return this.f6626a;
    }
}
