package didihttp;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaType {

    /* renamed from: a */
    private static final String f59230a = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    /* renamed from: b */
    private static final String f59231b = "\"([^\"]*)\"";

    /* renamed from: c */
    private static final Pattern f59232c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d */
    private static final Pattern f59233d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: e */
    private final String f59234e;

    /* renamed from: f */
    private final String f59235f;

    /* renamed from: g */
    private final String f59236g;

    /* renamed from: h */
    private final String f59237h;

    private MediaType(String str, String str2, String str3, String str4) {
        this.f59234e = str;
        this.f59235f = str2;
        this.f59236g = str3;
        this.f59237h = str4;
    }

    public static MediaType parse(String str) {
        Matcher matcher = f59232c.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f59233d.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                String group2 = matcher2.group(2);
                if (group2 == null) {
                    group2 = matcher2.group(3);
                } else if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                    group2 = group2.substring(1, group2.length() - 1);
                }
                if (str2 == null || group2.equalsIgnoreCase(str2)) {
                    str2 = group2;
                } else {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            }
        }
        return new MediaType(str, lowerCase, lowerCase2, str2);
    }

    public String type() {
        return this.f59235f;
    }

    public String subtype() {
        return this.f59236g;
    }

    public Charset charset() {
        String str = this.f59237h;
        if (str != null) {
            return Charset.forName(str);
        }
        return null;
    }

    public Charset charset(Charset charset) {
        String str = this.f59237h;
        return str != null ? Charset.forName(str) : charset;
    }

    public String toString() {
        return this.f59234e;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f59234e.equals(this.f59234e);
    }

    public int hashCode() {
        return this.f59234e.hashCode();
    }
}
