package com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj;

import com.threatmetrix.TrustDefender.TMXProfilingConnections.wkxmhskygjuiolj.kkhhhh;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.annotation.Nullable;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.osgi.framework.VersionRange;

public class hhhkhh extends SSLSocketFactory {
    public static int b006C006C006C006Cll = 2;
    public static int b006Cl006C006Cll = bllll006Cl();
    public static int bl006C006C006Cll = 1;
    public static int bll006C006Cll = bllll006Cl();
    private static final String bt007400740074tt;
    private SSLSocketFactory b0074007400740074tt;

    static {
        try {
            bt007400740074tt = kkhhhh.bj006A006A006Ajj(hhhkhh.class);
            int i = bll006C006Cll;
            if ((i * (bl006C006C006Cll + i)) % b006C006C006C006Cll != 0) {
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public hhhkhh() {
        try {
            SSLContext instance = SSLContext.getInstance(kkhhkh.bj006A006A006A006A006A("B;C", 'y', 1));
            instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
            this.b0074007400740074tt = instance.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            kkhhhh.hhkhhh.b007400740074t00740074(bt007400740074tt, kkhhkh.b006Aj006A006A006A006A("Zxxho!h`q\u001djj\u001aMDJ", 211, VersionRange.LEFT_CLOSED, 2));
        }
    }

    public static int b006Cl006Cl006Cl() {
        return 2;
    }

    @Nullable
    private Socket bjjjj006A006A(@Nullable Socket socket) {
        if (socket instanceof SSLSocket) {
            int i = 5;
            try {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{kkhhkh.bj006A006A006A006A006A(")\"*N\n\b\r", 211, 0)});
                while (true) {
                    try {
                        i /= 0;
                    } catch (Exception unused) {
                        bll006C006Cll = 90;
                        while (true) {
                            try {
                                i /= 0;
                            } catch (Exception unused2) {
                                bll006C006Cll = 77;
                                while (true) {
                                    String str = null;
                                    try {
                                        str.length();
                                    } catch (Exception unused3) {
                                        bll006C006Cll = 86;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (IllegalArgumentException unused4) {
                kkhhhh.hhkhhh.bj006A006Ajjj(bt007400740074tt, kkhhkh.bj006A006A006A006A006A(".'/S\u000f\r\u0011\r\u0002708\\\u0018\u0016\u001b\nL^R\u000e]_e\u0012fieffjm__", 'l', 5));
            }
        }
        return socket;
    }

    public static int bl006C006Cl006Cl() {
        return 1;
    }

    public static int bllll006Cl() {
        return 80;
    }

    @Nullable
    public Socket createSocket(String str, int i) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.b0074007400740074tt;
        int i2 = bll006C006Cll;
        if (((bl006C006C006Cll + i2) * i2) % b006C006C006C006Cll != b006Cl006C006Cll) {
            bll006C006Cll = 72;
            b006Cl006C006Cll = bllll006Cl();
        }
        return bjjjj006A006A(sSLSocketFactory.createSocket(str, i));
    }

    @Nullable
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        try {
            try {
                return bjjjj006A006A(this.b0074007400740074tt.createSocket(str, i, inetAddress, i2));
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Nullable
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        int i2 = bll006C006Cll;
        if ((i2 * (bl006C006Cl006Cl() + i2)) % b006C006C006C006Cll != 0) {
            bll006C006Cll = 48;
            b006Cl006C006Cll = bllll006Cl();
        }
        try {
            try {
                return bjjjj006A006A(this.b0074007400740074tt.createSocket(inetAddress, i));
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Nullable
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        int i3 = bll006C006Cll;
        if (((bl006C006C006Cll + i3) * i3) % b006C006C006C006Cll != b006Cl006C006Cll) {
            bll006C006Cll = 68;
            b006Cl006C006Cll = bllll006Cl();
        }
        return bjjjj006A006A(this.b0074007400740074tt.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Nullable
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        try {
            SSLSocketFactory sSLSocketFactory = this.b0074007400740074tt;
            int i2 = bll006C006Cll;
            if (((bl006C006C006Cll + i2) * i2) % b006Cl006Cl006Cl() != b006Cl006C006Cll) {
                bll006C006Cll = bllll006Cl();
                b006Cl006C006Cll = bllll006Cl();
            }
            try {
                return bjjjj006A006A(sSLSocketFactory.createSocket(socket, str, i, z));
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String[] getDefaultCipherSuites() {
        SSLSocketFactory sSLSocketFactory = this.b0074007400740074tt;
        int i = bll006C006Cll;
        if (((bl006C006C006Cll + i) * i) % b006C006C006C006Cll != b006Cl006C006Cll) {
            bll006C006Cll = 38;
            b006Cl006C006Cll = bllll006Cl();
        }
        return sSLSocketFactory.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.b0074007400740074tt.getSupportedCipherSuites();
    }
}
