package p218io.opentracing.tag;

import p218io.opentracing.Span;

/* renamed from: io.opentracing.tag.IntOrStringTag */
public class IntOrStringTag extends IntTag {
    public IntOrStringTag(String str) {
        super(str);
    }

    public void set(Span span, String str) {
        span.setTag(this.key, str);
    }
}
