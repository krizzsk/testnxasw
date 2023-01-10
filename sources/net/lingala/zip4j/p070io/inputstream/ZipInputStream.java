package net.lingala.zip4j.p070io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.CRC32;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderReader;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.DataDescriptor;
import net.lingala.zip4j.model.ExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

/* renamed from: net.lingala.zip4j.io.inputstream.ZipInputStream */
public class ZipInputStream extends InputStream {

    /* renamed from: a */
    private PushbackInputStream f6703a;

    /* renamed from: b */
    private C2953c f6704b;

    /* renamed from: c */
    private HeaderReader f6705c;

    /* renamed from: d */
    private char[] f6706d;

    /* renamed from: e */
    private LocalFileHeader f6707e;

    /* renamed from: f */
    private CRC32 f6708f;

    /* renamed from: g */
    private byte[] f6709g;

    /* renamed from: h */
    private boolean f6710h;

    /* renamed from: i */
    private Zip4jConfig f6711i;

    public ZipInputStream(InputStream inputStream) {
        this(inputStream, (char[]) null, (Charset) null);
    }

    public ZipInputStream(InputStream inputStream, Charset charset) {
        this(inputStream, (char[]) null, charset);
    }

    public ZipInputStream(InputStream inputStream, char[] cArr) {
        this(inputStream, cArr, (Charset) null);
    }

    public ZipInputStream(InputStream inputStream, char[] cArr, Charset charset) {
        this(inputStream, cArr, new Zip4jConfig(charset, 4096));
    }

    public ZipInputStream(InputStream inputStream, char[] cArr, Zip4jConfig zip4jConfig) {
        this.f6705c = new HeaderReader();
        this.f6708f = new CRC32();
        this.f6710h = false;
        if (zip4jConfig.getBufferSize() >= 512) {
            this.f6703a = new PushbackInputStream(inputStream, zip4jConfig.getBufferSize());
            this.f6706d = cArr;
            this.f6711i = zip4jConfig;
            return;
        }
        throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
    }

    public LocalFileHeader getNextEntry() throws IOException {
        return getNextEntry((FileHeader) null);
    }

    public LocalFileHeader getNextEntry(FileHeader fileHeader) throws IOException {
        if (this.f6707e != null) {
            m6526e();
        }
        LocalFileHeader readLocalFileHeader = this.f6705c.readLocalFileHeader(this.f6703a, this.f6711i.getCharset());
        this.f6707e = readLocalFileHeader;
        if (readLocalFileHeader == null) {
            return null;
        }
        m6521b(readLocalFileHeader);
        this.f6708f.reset();
        if (fileHeader != null) {
            this.f6707e.setCrc(fileHeader.getCrc());
            this.f6707e.setCompressedSize(fileHeader.getCompressedSize());
            this.f6707e.setUncompressedSize(fileHeader.getUncompressedSize());
            this.f6707e.setDirectory(fileHeader.isDirectory());
            this.f6710h = true;
        } else {
            this.f6710h = false;
        }
        this.f6704b = m6516a(this.f6707e);
        return this.f6707e;
    }

    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative read length");
        } else if (i2 == 0) {
            return 0;
        } else {
            if (this.f6707e == null) {
                return -1;
            }
            try {
                int read = this.f6704b.read(bArr, i, i2);
                if (read == -1) {
                    m6517a();
                } else {
                    this.f6708f.update(bArr, i, read);
                }
                return read;
            } catch (IOException e) {
                if (m6527e(this.f6707e)) {
                    throw new ZipException(e.getMessage(), e.getCause(), ZipException.Type.WRONG_PASSWORD);
                }
                throw e;
            }
        }
    }

    public void close() throws IOException {
        C2953c cVar = this.f6704b;
        if (cVar != null) {
            cVar.close();
        }
    }

    /* renamed from: a */
    private void m6517a() throws IOException {
        this.f6704b.pushBackInputStreamIfNecessary(this.f6703a);
        this.f6704b.endOfEntryReached(this.f6703a);
        m6520b();
        m6523c();
        m6525d();
    }

    /* renamed from: a */
    private C2953c m6516a(LocalFileHeader localFileHeader) throws IOException {
        return m6515a(m6514a(new C2955e(this.f6703a, m6522c(localFileHeader)), localFileHeader), localFileHeader);
    }

    /* renamed from: a */
    private C2952b m6514a(C2955e eVar, LocalFileHeader localFileHeader) throws IOException {
        if (!localFileHeader.isEncrypted()) {
            return new NoCipherInputStream(eVar, localFileHeader, this.f6706d, this.f6711i.getBufferSize());
        }
        if (localFileHeader.getEncryptionMethod() == EncryptionMethod.AES) {
            return new C2951a(eVar, localFileHeader, this.f6706d, this.f6711i.getBufferSize());
        }
        if (localFileHeader.getEncryptionMethod() == EncryptionMethod.ZIP_STANDARD) {
            return new C2956f(eVar, localFileHeader, this.f6706d, this.f6711i.getBufferSize());
        }
        throw new ZipException(String.format("Entry [%s] Strong Encryption not supported", new Object[]{localFileHeader.getFileName()}), ZipException.Type.UNSUPPORTED_ENCRYPTION);
    }

    /* renamed from: a */
    private C2953c m6515a(C2952b bVar, LocalFileHeader localFileHeader) {
        if (Zip4jUtil.getCompressionMethod(localFileHeader) == CompressionMethod.DEFLATE) {
            return new InflaterInputStream(bVar, this.f6711i.getBufferSize());
        }
        return new C2954d(bVar);
    }

    /* renamed from: b */
    private void m6520b() throws IOException {
        if (this.f6707e.isDataDescriptorExists() && !this.f6710h) {
            DataDescriptor readDataDescriptor = this.f6705c.readDataDescriptor(this.f6703a, m6519a(this.f6707e.getExtraDataRecords()));
            this.f6707e.setCompressedSize(readDataDescriptor.getCompressedSize());
            this.f6707e.setUncompressedSize(readDataDescriptor.getUncompressedSize());
            this.f6707e.setCrc(readDataDescriptor.getCrc());
        }
    }

    /* renamed from: b */
    private void m6521b(LocalFileHeader localFileHeader) throws IOException {
        if (!m6518a(localFileHeader.getFileName()) && localFileHeader.getCompressionMethod() == CompressionMethod.STORE && localFileHeader.getUncompressedSize() < 0) {
            throw new IOException("Invalid local file header for: " + localFileHeader.getFileName() + ". Uncompressed size has to be set for entry of compression type store which is not a directory");
        }
    }

    /* renamed from: a */
    private boolean m6519a(List<ExtraDataRecord> list) {
        if (list == null) {
            return false;
        }
        for (ExtraDataRecord header : list) {
            if (header.getHeader() == HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m6523c() throws IOException {
        if ((this.f6707e.getEncryptionMethod() != EncryptionMethod.AES || !this.f6707e.getAesExtraDataRecord().getAesVersion().equals(AesVersion.TWO)) && this.f6707e.getCrc() != this.f6708f.getValue()) {
            ZipException.Type type = ZipException.Type.CHECKSUM_MISMATCH;
            if (m6527e(this.f6707e)) {
                type = ZipException.Type.WRONG_PASSWORD;
            }
            throw new ZipException("Reached end of entry, but crc verification failed for " + this.f6707e.getFileName(), type);
        }
    }

    /* renamed from: d */
    private void m6525d() {
        this.f6707e = null;
        this.f6708f.reset();
    }

    /* renamed from: a */
    private boolean m6518a(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    /* renamed from: c */
    private long m6522c(LocalFileHeader localFileHeader) {
        if (Zip4jUtil.getCompressionMethod(localFileHeader).equals(CompressionMethod.STORE)) {
            return localFileHeader.getUncompressedSize();
        }
        if (!localFileHeader.isDataDescriptorExists() || this.f6710h) {
            return localFileHeader.getCompressedSize() - ((long) m6524d(localFileHeader));
        }
        return -1;
    }

    /* renamed from: d */
    private int m6524d(LocalFileHeader localFileHeader) {
        if (!localFileHeader.isEncrypted()) {
            return 0;
        }
        if (localFileHeader.getEncryptionMethod().equals(EncryptionMethod.AES)) {
            return localFileHeader.getAesExtraDataRecord().getAesKeyStrength().getSaltLength() + 12;
        }
        if (localFileHeader.getEncryptionMethod().equals(EncryptionMethod.ZIP_STANDARD)) {
            return 12;
        }
        return 0;
    }

    /* renamed from: e */
    private void m6526e() throws IOException {
        if (this.f6707e.isDirectory()) {
            return;
        }
        if (this.f6707e.getCompressedSize() != 0 || this.f6707e.isDataDescriptorExists()) {
            if (this.f6709g == null) {
                this.f6709g = new byte[512];
            }
            do {
            } while (read(this.f6709g) != -1);
        }
    }

    /* renamed from: e */
    private boolean m6527e(LocalFileHeader localFileHeader) {
        return localFileHeader.isEncrypted() && EncryptionMethod.ZIP_STANDARD.equals(localFileHeader.getEncryptionMethod());
    }
}
