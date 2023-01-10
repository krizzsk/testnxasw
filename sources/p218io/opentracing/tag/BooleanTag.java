package p218io.opentracing.tag;

import p218io.opentracing.Span;

/* renamed from: io.opentracing.tag.BooleanTag */
public class BooleanTag extends AbstractTag<Boolean> {
    public BooleanTag(String str) {
        super(str);
    }

    public void set(Span span, Boolean bool) {
        span.setTag(this.key, bool.booleanValue());
    }
}
