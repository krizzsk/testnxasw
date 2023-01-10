package net.lingala.zip4j.p070io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.FileHeaderFactory;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.RawIO;

/* renamed from: net.lingala.zip4j.io.outputstream.ZipOutputStream */
public class ZipOutputStream extends OutputStream {

    /* renamed from: a */
    private CountingOutputStream f6741a;

    /* renamed from: b */
    private char[] f6742b;

    /* renamed from: c */
    private ZipModel f6743c;

    /* renamed from: d */
    private C2959c f6744d;

    /* renamed from: e */
    private FileHeader f6745e;

    /* renamed from: f */
    private LocalFileHeader f6746f;

    /* renamed from: g */
    private FileHeaderFactory f6747g;

    /* renamed from: h */
    private HeaderWriter f6748h;

    /* renamed from: i */
    private CRC32 f6749i;

    /* renamed from: j */
    private RawIO f6750j;

    /* renamed from: k */
    private long f6751k;

    /* renamed from: l */
    private Zip4jConfig f6752l;

    /* renamed from: m */
    private boolean f6753m;

    public ZipOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, (char[]) null, (Charset) null);
    }

    public ZipOutputStream(OutputStream outputStream, Charset charset) throws IOException {
        this(outputStream, (char[]) null, charset);
    }

    public ZipOutputStream(OutputStream outputStream, char[] cArr) throws IOException {
        this(outputStream, cArr, (Charset) null);
    }

    public ZipOutputStream(OutputStream outputStream, char[] cArr, Charset charset) throws IOException {
        this(outputStream, cArr, new Zip4jConfig(charset, 4096), new ZipModel());
    }

    public ZipOutputStream(OutputStream outputStream, char[] cArr, Zip4jConfig zip4jConfig, ZipModel zipModel) throws IOException {
        this.f6747g = new FileHeaderFactory();
        this.f6748h = new HeaderWriter();
        this.f6749i = new CRC32();
        this.f6750j = new RawIO();
        this.f6751k = 0;
        if (zip4jConfig.getBufferSize() >= 512) {
            CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
            this.f6741a = countingOutputStream;
            this.f6742b = cArr;
            this.f6752l = zip4jConfig;
            this.f6743c = m6559a(zipModel, countingOutputStream);
            this.f6753m = false;
            m6566c();
            return;
        }
        throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
    }

    public void putNextEntry(ZipParameters zipParameters) throws IOException {
        m6567c(zipParameters);
        m6561a(zipParameters);
        this.f6744d = m6564b(zipParameters);
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        m6560a();
        this.f6749i.update(bArr, i, i2);
        this.f6744d.write(bArr, i, i2);
        this.f6751k += (long) i2;
    }

    public FileHeader closeEntry() throws IOException {
        this.f6744d.mo29455a();
        long b = this.f6744d.mo29456b();
        this.f6745e.setCompressedSize(b);
        this.f6746f.setCompressedSize(b);
        this.f6745e.setUncompressedSize(this.f6751k);
        this.f6746f.setUncompressedSize(this.f6751k);
        if (m6563a(this.f6745e)) {
            this.f6745e.setCrc(this.f6749i.getValue());
            this.f6746f.setCrc(this.f6749i.getValue());
        }
        this.f6743c.getLocalFileHeaders().add(this.f6746f);
        this.f6743c.getCentralDirectory().getFileHeaders().add(this.f6745e);
        if (this.f6746f.isDataDescriptorExists()) {
            this.f6748h.writeExtendedLocalHeader(this.f6746f, this.f6741a);
        }
        m6565b();
        return this.f6745e;
    }

    public void close() throws IOException {
        this.f6743c.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(this.f6741a.getNumberOfBytesWritten());
        this.f6748h.finalizeZipFile(this.f6743c, this.f6741a, this.f6752l.getCharset());
        this.f6741a.close();
        this.f6753m = true;
    }

    public void setComment(String str) throws IOException {
        m6560a();
        this.f6743c.getEndOfCentralDirectoryRecord().setComment(str);
    }

    /* renamed from: a */
    private void m6560a() throws IOException {
        if (this.f6753m) {
            throw new IOException("Stream is closed");
        }
    }

    /* renamed from: a */
    private ZipModel m6559a(ZipModel zipModel, CountingOutputStream countingOutputStream) {
        if (zipModel == null) {
            zipModel = new ZipModel();
        }
        if (countingOutputStream.isSplitZipFile()) {
            zipModel.setSplitArchive(true);
            zipModel.setSplitLength(countingOutputStream.getSplitLength());
        }
        return zipModel;
    }

    /* renamed from: a */
    private void m6561a(ZipParameters zipParameters) throws IOException {
        FileHeader generateFileHeader = this.f6747g.generateFileHeader(zipParameters, this.f6741a.isSplitZipFile(), this.f6741a.getCurrentSplitFileCounter(), this.f6752l.getCharset(), this.f6750j);
        this.f6745e = generateFileHeader;
        generateFileHeader.setOffsetLocalHeader(this.f6741a.getOffsetForNextEntry());
        LocalFileHeader generateLocalFileHeader = this.f6747g.generateLocalFileHeader(this.f6745e);
        this.f6746f = generateLocalFileHeader;
        this.f6748h.writeLocalFileHeader(this.f6743c, generateLocalFileHeader, this.f6741a, this.f6752l.getCharset());
    }

    /* renamed from: b */
    private void m6565b() throws IOException {
        this.f6751k = 0;
        this.f6749i.reset();
        this.f6744d.close();
    }

    /* renamed from: c */
    private void m6566c() throws IOException {
        if (this.f6741a.isSplitZipFile()) {
            this.f6750j.writeIntLittleEndian(this.f6741a, (int) HeaderSignature.SPLIT_ZIP.getValue());
        }
    }

    /* renamed from: b */
    private C2959c m6564b(ZipParameters zipParameters) throws IOException {
        return m6558a(m6557a(new C2962f(this.f6741a), zipParameters), zipParameters);
    }

    /* renamed from: a */
    private C2958b m6557a(C2962f fVar, ZipParameters zipParameters) throws IOException {
        if (!zipParameters.isEncryptFiles()) {
            return new NoCipherOutputStream(fVar, zipParameters, (char[]) null);
        }
        char[] cArr = this.f6742b;
        if (cArr == null || cArr.length == 0) {
            throw new ZipException("password not set");
        } else if (zipParameters.getEncryptionMethod() == EncryptionMethod.AES) {
            return new C2957a(fVar, zipParameters, this.f6742b);
        } else {
            if (zipParameters.getEncryptionMethod() == EncryptionMethod.ZIP_STANDARD) {
                return new C2963g(fVar, zipParameters, this.f6742b);
            }
            if (zipParameters.getEncryptionMethod() == EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG) {
                throw new ZipException(EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG + " encryption method is not supported");
            }
            throw new ZipException("Invalid encryption method");
        }
    }

    /* renamed from: a */
    private C2959c m6558a(C2958b bVar, ZipParameters zipParameters) {
        if (zipParameters.getCompressionMethod() == CompressionMethod.DEFLATE) {
            return new C2960d(bVar, zipParameters.getCompressionLevel(), this.f6752l.getBufferSize());
        }
        return new C2961e(bVar);
    }

    /* renamed from: c */
    private void m6567c(ZipParameters zipParameters) {
        if (zipParameters.getCompressionMethod() == CompressionMethod.STORE && zipParameters.getEntrySize() < 0 && !m6562a(zipParameters.getFileNameInZip()) && zipParameters.isWriteExtendedLocalFileHeader()) {
            throw new IllegalArgumentException("uncompressed size should be set for zip entries of compression type store");
        }
    }

    /* renamed from: a */
    private boolean m6563a(FileHeader fileHeader) {
        if (!(fileHeader.isEncrypted() && fileHeader.getEncryptionMethod().equals(EncryptionMethod.AES))) {
            return true;
        }
        return fileHeader.getAesExtraDataRecord().getAesVersion().equals(AesVersion.ONE);
    }

    /* renamed from: a */
    private boolean m6562a(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }
}
