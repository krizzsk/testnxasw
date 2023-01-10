package jumio.core;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.google.common.net.HttpHeaders;
import com.jumio.ale.swig.ALECore;
import com.jumio.ale.swig.ALEHeader;
import com.jumio.ale.swig.ALEInputStream;
import com.jumio.ale.swig.ALEOutputStream;
import com.jumio.ale.swig.ALERequest;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.IOUtils;
import com.jumio.core.network.C20982b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/* renamed from: jumio.core.c */
/* compiled from: AleEncryptionProvider */
public class C19466c implements C20982b {

    /* renamed from: a */
    public final String f55331a;

    /* renamed from: b */
    public final ALECore f55332b;

    /* renamed from: c */
    public ALERequest f55333c;

    public C19466c(ALECore aLECore, String str) {
        this.f55331a = str;
        this.f55332b = aLECore;
    }

    /* renamed from: a */
    public OutputStream mo148605a(OutputStream outputStream, int i, String str) throws Exception {
        try {
            this.f55333c = this.f55332b.createRequest();
            Log.m43645d("AleEncryptionProvider", "encrypting plaintext");
            ALEHeader aLEHeader = new ALEHeader();
            if (str != null) {
                aLEHeader.add("Content-Type", "multipart/form-data; boundary=" + str);
            } else {
                aLEHeader.add("Content-Type", "application/json");
            }
            aLEHeader.add(HttpHeaders.AUTHORIZATION, this.f55331a);
            return new ALEOutputStream(new BufferedOutputStream(outputStream), this.f55333c, aLEHeader, i);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    public String mo148607b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[1024];
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    inputStream.close();
                    return stringWriter.toString();
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public String mo148606a(InputStream inputStream) throws C19463a0, C19504s0 {
        String str;
        Log.m43645d("AleEncryptionProvider", "decrypting response stream");
        ALEInputStream aLEInputStream = new ALEInputStream(new BufferedInputStream(inputStream), this.f55333c);
        try {
            str = mo148607b(aLEInputStream);
            StringBuilder sb = new StringBuilder();
            sb.append("Response ");
            sb.append(this.f55333c.isVerified() ? "valid" : "invalid");
            Log.m43660v("Network/ALE", sb.toString());
            Log.m43660v("Network/ALE", "Errorcode " + this.f55333c.getErrorCode());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("KeyUpdate ");
            sb2.append(this.f55333c.isKeyUpdate() ? "true" : SDKConsts.BOOLEAN_FALSE);
            Log.m43660v("Network/ALE", sb2.toString());
            IOUtils.closeQuietly(aLEInputStream);
        } catch (IOException unused) {
            IOUtils.closeQuietly(aLEInputStream);
            str = null;
        } catch (Throwable th) {
            IOUtils.closeQuietly(aLEInputStream);
            throw th;
        }
        try {
            if (!this.f55333c.isVerified()) {
                if (this.f55333c.getErrorCode() != 0) {
                    throw new C19504s0(this.f55333c.getErrorCode(), "Response returned " + this.f55333c.getErrorCode());
                }
                throw new C19504s0(0, "Response not verified");
            } else if (!this.f55333c.isKeyUpdate()) {
                return str;
            } else {
                throw new C19469d("keyupdate - re-execute call!");
            }
        } finally {
            this.f55332b.destroyRequest(this.f55333c);
            this.f55333c = null;
        }
    }
}
