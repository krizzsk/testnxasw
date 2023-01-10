package okhttp3.internal.http;

import com.koushikdutta.async.http.AsyncHttpHead;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.C3000Util;
import okio.Buffer;
import okio.ByteString;

public final class HttpHeaders {

    /* renamed from: a */
    private static final ByteString f7212a = ByteString.encodeUtf8("\"\\");

    /* renamed from: b */
    private static final ByteString f7213b = ByteString.encodeUtf8("\t ,=");

    private HttpHeaders() {
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static long contentLength(Headers headers) {
        return m6825a(headers.get(com.google.common.net.HttpHeaders.CONTENT_LENGTH));
    }

    /* renamed from: a */
    private static long m6825a(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String next : m6827a(response)) {
            if (!C3000Util.equal(headers.values(next), request.headers(next))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    public static boolean hasVaryAll(Headers headers) {
        return varyFields(headers).contains("*");
    }

    /* renamed from: a */
    private static Set<String> m6827a(Response response) {
        return varyFields(response.headers());
    }

    public static Set<String> varyFields(Headers headers) {
        Set<String> emptySet = Collections.emptySet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if (com.google.common.net.HttpHeaders.VARY.equalsIgnoreCase(headers.name(i))) {
                String value = headers.value(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : value.split(",")) {
                    emptySet.add(trim.trim());
                }
            }
        }
        return emptySet;
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        Set<String> varyFields = varyFields(headers2);
        if (varyFields.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            if (varyFields.contains(name)) {
                builder.add(name, headers.value(i));
            }
        }
        return builder.build();
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < headers.size(); i++) {
            if (str.equalsIgnoreCase(headers.name(i))) {
                m6828a((List<Challenge>) arrayList, new Buffer().writeUtf8(headers.value(i)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m6828a(List<Challenge> list, Buffer buffer) {
        String c;
        int a;
        String str;
        while (true) {
            String str2 = null;
            while (true) {
                if (str2 == null) {
                    m6829a(buffer);
                    str2 = m6831c(buffer);
                    if (str2 == null) {
                        return;
                    }
                }
                boolean a2 = m6829a(buffer);
                c = m6831c(buffer);
                if (c != null) {
                    a = m6824a(buffer, (byte) 61);
                    boolean a3 = m6829a(buffer);
                    if (a2 || (!a3 && !buffer.exhausted())) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        int a4 = a + m6824a(buffer, (byte) 61);
                        while (true) {
                            if (c == null) {
                                c = m6831c(buffer);
                                if (m6829a(buffer)) {
                                    continue;
                                    break;
                                }
                                a4 = m6824a(buffer, (byte) 61);
                            }
                            if (a4 == 0) {
                                continue;
                                break;
                            } else if (a4 <= 1 && !m6829a(buffer)) {
                                if (buffer.exhausted() || buffer.getByte(0) != 34) {
                                    str = m6831c(buffer);
                                } else {
                                    str = m6830b(buffer);
                                }
                                if (str == null || ((String) linkedHashMap.put(c, str)) != null) {
                                    return;
                                }
                                if (m6829a(buffer) || buffer.exhausted()) {
                                    c = null;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        list.add(new Challenge(str2, (Map<String, String>) linkedHashMap));
                        str2 = c;
                    }
                } else if (buffer.exhausted()) {
                    list.add(new Challenge(str2, (Map<String, String>) Collections.emptyMap()));
                    return;
                } else {
                    return;
                }
            }
            list.add(new Challenge(str2, (Map<String, String>) Collections.singletonMap((String) null, c + m6826a('=', a))));
        }
    }

    /* renamed from: a */
    private static boolean m6829a(Buffer buffer) {
        boolean z = false;
        while (!buffer.exhausted()) {
            byte b = buffer.getByte(0);
            if (b != 44) {
                if (b != 32 && b != 9) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    private static int m6824a(Buffer buffer, byte b) {
        int i = 0;
        while (!buffer.exhausted() && buffer.getByte(0) == b) {
            i++;
            buffer.readByte();
        }
        return i;
    }

    /* renamed from: b */
    private static String m6830b(Buffer buffer) {
        if (buffer.readByte() == 34) {
            Buffer buffer2 = new Buffer();
            while (true) {
                long indexOfElement = buffer.indexOfElement(f7212a);
                if (indexOfElement == -1) {
                    return null;
                }
                if (buffer.getByte(indexOfElement) == 34) {
                    buffer2.write(buffer, indexOfElement);
                    buffer.readByte();
                    return buffer2.readUtf8();
                } else if (buffer.size() == indexOfElement + 1) {
                    return null;
                } else {
                    buffer2.write(buffer, indexOfElement);
                    buffer.readByte();
                    buffer2.write(buffer, 1);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: c */
    private static String m6831c(Buffer buffer) {
        try {
            long indexOfElement = buffer.indexOfElement(f7213b);
            if (indexOfElement == -1) {
                indexOfElement = buffer.size();
            }
            if (indexOfElement != 0) {
                return buffer.readUtf8(indexOfElement);
            }
            return null;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private static String m6826a(char c, int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar != CookieJar.NO_COOKIES) {
            List<Cookie> parseAll = Cookie.parseAll(httpUrl, headers);
            if (!parseAll.isEmpty()) {
                cookieJar.saveFromResponse(httpUrl, parseAll);
            }
        }
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals(AsyncHttpHead.METHOD)) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header(com.google.common.net.HttpHeaders.TRANSFER_ENCODING))) {
            return false;
        }
        return true;
    }

    public static int skipUntil(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int skipWhitespace(String str, int i) {
        while (i < str.length() && ((r0 = str.charAt(i)) == ' ' || r0 == 9)) {
            i++;
        }
        return i;
    }

    public static int parseSeconds(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
