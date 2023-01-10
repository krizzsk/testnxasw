package okhttp3;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.internal.C3000Util;

public final class Challenge {

    /* renamed from: a */
    private final String f6967a;

    /* renamed from: b */
    private final Map<String, String> f6968b;

    public Challenge(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        } else if (map != null) {
            this.f6967a = str;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put(next.getKey() == null ? null : ((String) next.getKey()).toLowerCase(Locale.US), next.getValue());
            }
            this.f6968b = Collections.unmodifiableMap(linkedHashMap);
        } else {
            throw new NullPointerException("authParams == null");
        }
    }

    public Challenge(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        } else if (str2 != null) {
            this.f6967a = str;
            this.f6968b = Collections.singletonMap("realm", str2);
        } else {
            throw new NullPointerException("realm == null");
        }
    }

    public Challenge withCharset(Charset charset) {
        if (charset != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.f6968b);
            linkedHashMap.put("charset", charset.name());
            return new Challenge(this.f6967a, (Map<String, String>) linkedHashMap);
        }
        throw new NullPointerException("charset == null");
    }

    public String scheme() {
        return this.f6967a;
    }

    public Map<String, String> authParams() {
        return this.f6968b;
    }

    public String realm() {
        return this.f6968b.get("realm");
    }

    public Charset charset() {
        String str = this.f6968b.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return C3000Util.ISO_8859_1;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            return challenge.f6967a.equals(this.f6967a) && challenge.f6968b.equals(this.f6968b);
        }
    }

    public int hashCode() {
        return ((899 + this.f6967a.hashCode()) * 31) + this.f6968b.hashCode();
    }

    public String toString() {
        return this.f6967a + " authParams=" + this.f6968b;
    }
}
