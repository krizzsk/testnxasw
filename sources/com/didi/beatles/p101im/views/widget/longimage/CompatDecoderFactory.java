package com.didi.beatles.p101im.views.widget.longimage;

/* renamed from: com.didi.beatles.im.views.widget.longimage.CompatDecoderFactory */
public class CompatDecoderFactory<T> implements DecoderFactory<T> {

    /* renamed from: a */
    private Class<? extends T> f12353a;

    public CompatDecoderFactory(Class<? extends T> cls) {
        this.f12353a = cls;
    }

    public T make() throws IllegalAccessException, InstantiationException {
        return this.f12353a.newInstance();
    }
}
