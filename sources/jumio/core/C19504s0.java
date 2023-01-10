package jumio.core;

import java.io.IOException;

/* renamed from: jumio.core.s0 */
/* compiled from: UnexpectedResponseException */
public class C19504s0 extends IOException {

    /* renamed from: a */
    public int f55403a = 0;

    /* renamed from: b */
    public String f55404b = "";

    public C19504s0(int i, String str) {
        this.f55403a = i;
        this.f55404b = str;
    }

    /* renamed from: a */
    public int mo148730a() {
        return this.f55403a;
    }

    public String getMessage() {
        return this.f55404b;
    }

    /* renamed from: a */
    public void mo148731a(int i) {
        this.f55403a = i;
    }
}
