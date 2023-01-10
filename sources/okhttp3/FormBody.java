package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.C3000Util;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody extends RequestBody {

    /* renamed from: a */
    private static final MediaType f7007a = MediaType.get("application/x-www-form-urlencoded");

    /* renamed from: b */
    private final List<String> f7008b;

    /* renamed from: c */
    private final List<String> f7009c;

    FormBody(List<String> list, List<String> list2) {
        this.f7008b = C3000Util.immutableList(list);
        this.f7009c = C3000Util.immutableList(list2);
    }

    public int size() {
        return this.f7008b.size();
    }

    public String encodedName(int i) {
        return this.f7008b.get(i);
    }

    public String name(int i) {
        return HttpUrl.m6752a(encodedName(i), true);
    }

    public String encodedValue(int i) {
        return this.f7009c.get(i);
    }

    public String value(int i) {
        return HttpUrl.m6752a(encodedValue(i), true);
    }

    public MediaType contentType() {
        return f7007a;
    }

    public long contentLength() {
        return m6742a((BufferedSink) null, true);
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        m6742a(bufferedSink, false);
    }

    /* renamed from: a */
    private long m6742a(@Nullable BufferedSink bufferedSink, boolean z) {
        Buffer buffer;
        if (z) {
            buffer = new Buffer();
        } else {
            buffer = bufferedSink.buffer();
        }
        int size = this.f7008b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.f7008b.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.f7009c.get(i));
        }
        if (!z) {
            return 0;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this((Charset) null);
        }

        public Builder(Charset charset2) {
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = charset2;
        }

        public Builder add(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                this.names.add(HttpUrl.m6751a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                this.values.add(HttpUrl.m6751a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public Builder addEncoded(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                this.names.add(HttpUrl.m6751a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                this.values.add(HttpUrl.m6751a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }
    }
}
