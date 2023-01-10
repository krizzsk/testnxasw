package didihttp;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import didihttp.internal.C21750Util;

public final class Challenge {

    /* renamed from: a */
    private final String f59112a;

    /* renamed from: b */
    private final String f59113b;

    public Challenge(String str, String str2) {
        this.f59112a = str;
        this.f59113b = str2;
    }

    public String scheme() {
        return this.f59112a;
    }

    public String realm() {
        return this.f59113b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            return C21750Util.equal(this.f59112a, challenge.f59112a) && C21750Util.equal(this.f59113b, challenge.f59113b);
        }
    }

    public int hashCode() {
        String str = this.f59113b;
        int i = 0;
        int hashCode = (899 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f59112a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return this.f59112a + " realm=\"" + this.f59113b + Const.jsQuote;
    }
}
