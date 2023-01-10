package jumio.core;

/* renamed from: jumio.core.u0 */
/* compiled from: Version */
public class C19509u0 implements Comparable<C19509u0> {

    /* renamed from: a */
    public final String f55408a;

    public C19509u0(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Version can not be null");
        } else if (str.matches("[0-9]+(\\.[0-9]+)*")) {
            this.f55408a = str;
        } else {
            throw new IllegalArgumentException("Invalid version format");
        }
    }

    /* renamed from: a */
    public final String mo148743a() {
        return this.f55408a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C19509u0.class == obj.getClass() && compareTo((C19509u0) obj) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public int compareTo(C19509u0 u0Var) {
        if (u0Var == null) {
            return 1;
        }
        String[] split = mo148743a().split("\\.");
        String[] split2 = u0Var.mo148743a().split("\\.");
        int max = Math.max(split.length, split2.length);
        int i = 0;
        while (i < max) {
            int parseInt = i < split.length ? Integer.parseInt(split[i]) : 0;
            int parseInt2 = i < split2.length ? Integer.parseInt(split2[i]) : 0;
            if (parseInt < parseInt2) {
                return -1;
            }
            if (parseInt > parseInt2) {
                return 1;
            }
            i++;
        }
        return 0;
    }
}
