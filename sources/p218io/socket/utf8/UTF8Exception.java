package p218io.socket.utf8;

import java.io.IOException;

/* renamed from: io.socket.utf8.UTF8Exception */
public class UTF8Exception extends IOException {
    public UTF8Exception() {
    }

    public UTF8Exception(String str) {
        super(str);
    }

    public UTF8Exception(String str, Throwable th) {
        super(str, th);
    }

    public UTF8Exception(Throwable th) {
        super(th);
    }
}
