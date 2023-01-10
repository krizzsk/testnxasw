package com.koushikdutta.async.future;

import android.text.TextUtils;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.future.Converter;
import java.io.InvalidObjectException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONObject;

public class Converter<R> {
    public static final ConverterEntries Converters = new ConverterEntries();

    /* renamed from: d */
    private static final String f58099d = "*/*";

    /* renamed from: a */
    Converters<Object, Object> f58100a;

    /* renamed from: b */
    MultiFuture<R> f58101b = new MultiFuture<>();

    /* renamed from: c */
    String f58102c;

    public static <T> Converter<T> convert(Future<T> future, String str) {
        return new Converter<>(future, str);
    }

    public static <T> Converter<T> convert(Future<T> future) {
        return convert(future, (String) null);
    }

    static class MimedData<T> {
        T data;
        String mime;

        public MimedData(T t, String str) {
            this.data = t;
            this.mime = str;
        }
    }

    static class MultiTransformer<T, F> extends MultiTransformFuture<MimedData<Future<T>>, MimedData<Future<F>>> {
        TypeConverter<T, F> converter;
        String converterMime;
        int distance;

        public MultiTransformer(TypeConverter<T, F> typeConverter, String str, int i) {
            this.converter = typeConverter;
            this.converterMime = str;
            this.distance = i;
        }

        /* access modifiers changed from: protected */
        public void transform(MimedData<Future<F>> mimedData) {
            String str = mimedData.mime;
            MultiFuture multiFuture = new MultiFuture();
            setComplete(new MimedData(multiFuture, Converter.m43997a(str, this.converterMime)));
            ((Future) mimedData.data).thenConvert(new ThenCallback(str) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final Object then(Object obj) {
                    return Converter.MultiTransformer.this.lambda$transform$0$Converter$MultiTransformer(this.f$1, obj);
                }
            }).setCallback(new FutureCallback() {
                public final void onCompleted(Exception exc, Object obj) {
                    Converter.MultiTransformer.lambda$transform$1(MultiFuture.this, exc, (Future) obj);
                }
            });
        }

        public /* synthetic */ Future lambda$transform$0$Converter$MultiTransformer(String str, Object obj) throws Exception {
            return this.converter.convert(obj, str);
        }

        static /* synthetic */ void lambda$transform$1(MultiFuture multiFuture, Exception exc, Future future) {
            if (exc != null) {
                multiFuture.setComplete(exc);
            } else {
                multiFuture.setComplete(future);
            }
        }
    }

    static abstract class EnsureHashMap<K, V> extends LinkedHashMap<K, V> {
        /* access modifiers changed from: protected */
        public abstract V makeDefault();

        EnsureHashMap() {
        }

        /* access modifiers changed from: package-private */
        public synchronized V ensure(K k) {
            if (!containsKey(k)) {
                put(k, makeDefault());
            }
            return get(k);
        }
    }

    static class MimedType<T> {
        String mime;
        Class<T> type;

        MimedType(Class<T> cls, String str) {
            this.type = cls;
            this.mime = str;
        }

        public int hashCode() {
            return this.type.hashCode() ^ this.mime.hashCode();
        }

        public boolean equals(Object obj) {
            MimedType mimedType = (MimedType) obj;
            return this.type.equals(mimedType.type) && this.mime.equals(mimedType.mime);
        }

        public boolean isTypeOf(MimedType mimedType) {
            if (!this.type.isAssignableFrom(mimedType.type)) {
                return false;
            }
            return isTypeOf(mimedType.mime);
        }

        public String primary() {
            return this.mime.split("/")[0];
        }

        public String secondary() {
            return this.mime.split("/")[1];
        }

        public boolean isTypeOf(String str) {
            String[] split = str.split("/");
            String[] split2 = this.mime.split("/");
            if (!"*".equals(split2[0]) && !split[0].equals(split2[0])) {
                return false;
            }
            if ("*".equals(split2[1]) || split[1].equals(split2[1])) {
                return true;
            }
            return false;
        }

        public String toString() {
            return this.type.getSimpleName() + " " + this.mime;
        }
    }

    static class ConverterTransformers<F, T> extends LinkedHashMap<MimedType<T>, MultiTransformer<T, F>> {
        ConverterTransformers() {
        }
    }

    static class Converters<F, T> extends EnsureHashMap<MimedType<F>, ConverterTransformers<F, T>> {
        Converters() {
        }

        /* access modifiers changed from: protected */
        public ConverterTransformers makeDefault() {
            return new ConverterTransformers();
        }

        private static <F, T> void add(ConverterTransformers<F, T> converterTransformers, ConverterTransformers<F, T> converterTransformers2) {
            if (converterTransformers2 != null) {
                converterTransformers.putAll(converterTransformers2);
            }
        }

        public ConverterTransformers<F, T> getAll(MimedType<T> mimedType) {
            ConverterTransformers<F, T> converterTransformers = new ConverterTransformers<>();
            for (MimedType mimedType2 : keySet()) {
                if (mimedType2.isTypeOf((MimedType) mimedType)) {
                    add(converterTransformers, (ConverterTransformers) get(mimedType2));
                }
            }
            return converterTransformers;
        }
    }

    /* access modifiers changed from: protected */
    public ConverterEntries getConverters() {
        return new ConverterEntries(Converters);
    }

    protected Converter(Future future, String str) {
        this.f58102c = TextUtils.isEmpty(str) ? "*/*" : str;
        this.f58101b.setComplete(future);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final synchronized <T> Future<T> m43992a(Object obj, Class<T> cls, String str) {
        if (cls.isInstance(obj)) {
            return new SimpleFuture(obj);
        }
        return m43991a((Class) obj.getClass(), cls, str);
    }

    /* renamed from: a */
    private final synchronized <T> Future<T> m43991a(Class cls, Class<T> cls2, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "*/*";
        }
        if (this.f58100a == null) {
            this.f58100a = new Converters<>();
            Iterator<ConverterEntry> it = getConverters().list.iterator();
            while (it.hasNext()) {
                ConverterEntry next = it.next();
                ((ConverterTransformers) this.f58100a.ensure(next.from)).put(next.f58103to, new MultiTransformer(next.typeConverter, next.f58103to.mime, next.distance));
            }
        }
        MimedType mimedType = new MimedType(cls2, str);
        ArrayDeque arrayDeque = new ArrayDeque();
        if (m43998a(mimedType, arrayDeque, new ArrayDeque(), new MimedType(cls, this.f58102c), new HashSet())) {
            PathInfo pathInfo = (PathInfo) arrayDeque.removeFirst();
            new SimpleFuture(new MimedData(this.f58101b, this.f58102c)).setCallback(pathInfo.transformer);
            while (!arrayDeque.isEmpty()) {
                PathInfo pathInfo2 = (PathInfo) arrayDeque.removeFirst();
                pathInfo.transformer.setCallback(pathInfo2.transformer);
                pathInfo = pathInfo2;
            }
            return pathInfo.transformer.then($$Lambda$Converter$vJ94n0oS3xhBS8XBTpYLjs5BcA4.INSTANCE);
        }
        return new SimpleFuture((Exception) new InvalidObjectException("unable to find converter"));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ Future m43990a(MimedData mimedData) throws Exception {
        return (Future) mimedData.data;
    }

    static class PathInfo {
        MimedType candidate;
        String mime;
        MultiTransformer<Object, Object> transformer;

        PathInfo() {
        }

        static int distance(ArrayDeque<PathInfo> arrayDeque) {
            Iterator<PathInfo> it = arrayDeque.iterator();
            int i = 0;
            while (it.hasNext()) {
                i += it.next().transformer.distance;
            }
            return i;
        }
    }

    /* renamed from: a */
    static String m43997a(String str, String str2) {
        String[] split = str2.split("/");
        String[] split2 = str.split("/");
        String str3 = !"*".equals(split[0]) ? split[0] : split2[0];
        String str4 = !"*".equals(split[1]) ? split[1] : split2[1];
        return str3 + "/" + str4;
    }

    /* renamed from: to */
    public final <T> Future<T> mo173282to(Class<T> cls) {
        return mo173283to(cls, (String) null);
    }

    /* renamed from: a */
    private <T> boolean m43998a(MimedType<T> mimedType, ArrayDeque<PathInfo> arrayDeque, ArrayDeque<PathInfo> arrayDeque2, MimedType mimedType2, HashSet<MimedType> hashSet) {
        if (mimedType.isTypeOf(mimedType2)) {
            arrayDeque.clear();
            arrayDeque.addAll(arrayDeque2);
            return true;
        }
        boolean z = false;
        if ((!arrayDeque.isEmpty() && PathInfo.distance(arrayDeque2) >= PathInfo.distance(arrayDeque)) || hashSet.contains(mimedType2)) {
            return false;
        }
        hashSet.add(mimedType2);
        ConverterTransformers<Object, Object> all = this.f58100a.getAll(mimedType2);
        for (MimedType mimedType3 : all.keySet()) {
            MimedType mimedType4 = new MimedType(mimedType3.type, m43997a(mimedType2.mime, mimedType3.mime));
            PathInfo pathInfo = new PathInfo();
            pathInfo.transformer = (MultiTransformer) all.get(mimedType3);
            pathInfo.mime = mimedType4.mime;
            pathInfo.candidate = mimedType3;
            arrayDeque2.addLast(pathInfo);
            try {
                z |= m43998a(mimedType, arrayDeque, arrayDeque2, mimedType4, hashSet);
            } finally {
                arrayDeque2.removeLast();
            }
        }
        if (z) {
            hashSet.remove(mimedType2);
        }
        return z;
    }

    /* renamed from: to */
    public <T> Future<T> mo173283to(Class<T> cls, String str) {
        return this.f58101b.then(new ThenFutureCallback(cls, str) {
            public final /* synthetic */ Class f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Future then(Object obj) {
                return Converter.this.m43992a(this.f$1, this.f$2, obj);
            }
        });
    }

    static class ConverterEntry<F, T> {
        int distance;
        MimedType<F> from;

        /* renamed from: to */
        MimedType<T> f58103to;
        TypeConverter<T, F> typeConverter;

        ConverterEntry(Class<F> cls, String str, Class<T> cls2, String str2, int i, TypeConverter<T, F> typeConverter2) {
            this.from = new MimedType<>(cls, str);
            this.f58103to = new MimedType<>(cls2, str2);
            this.distance = i;
            this.typeConverter = typeConverter2;
        }

        public int hashCode() {
            return this.from.hashCode() ^ this.f58103to.hashCode();
        }

        public boolean equals(Object obj) {
            ConverterEntry converterEntry = (ConverterEntry) obj;
            return this.from.equals(converterEntry.from) && this.f58103to.equals(converterEntry.f58103to);
        }
    }

    public static class ConverterEntries {
        public ArrayList<ConverterEntry> list;

        public ConverterEntries() {
            this.list = new ArrayList<>();
        }

        public ConverterEntries(ConverterEntries converterEntries) {
            ArrayList<ConverterEntry> arrayList = new ArrayList<>();
            this.list = arrayList;
            arrayList.addAll(converterEntries.list);
        }

        public synchronized <F, T> void addConverter(Class<F> cls, String str, Class<T> cls2, String str2, TypeConverter<T, F> typeConverter) {
            addConverter(cls, str, cls2, str2, 1, typeConverter);
        }

        public synchronized <F, T> void addConverter(Class<F> cls, String str, Class<T> cls2, String str2, int i, TypeConverter<T, F> typeConverter) {
            if (TextUtils.isEmpty(str)) {
                str = "*/*";
            }
            String str3 = str;
            if (TextUtils.isEmpty(str2)) {
                str2 = "*/*";
            }
            this.list.add(new ConverterEntry(cls, str3, cls2, str2, i, typeConverter));
        }

        public synchronized boolean removeConverter(TypeConverter typeConverter) {
            Iterator<ConverterEntry> it = this.list.iterator();
            while (it.hasNext()) {
                ConverterEntry next = it.next();
                if (next.typeConverter == typeConverter) {
                    return this.list.remove(next);
                }
            }
            return false;
        }
    }

    static {
        $$Lambda$Converter$PSM9vBlB5RU4miagFHVbadxz_o r6 = $$Lambda$Converter$PSM9vBlB5RU4miagFHVbadxz_o.INSTANCE;
        $$Lambda$Converter$dA1QLYpuF5cEVbnH1PJqNSMSJc r7 = $$Lambda$Converter$dA1QLYpuF5cEVbnH1PJqNSMSJc.INSTANCE;
        $$Lambda$Converter$jgolez7oZyo_aXXA9RQ47VZJSaw r8 = $$Lambda$Converter$jgolez7oZyo_aXXA9RQ47VZJSaw.INSTANCE;
        $$Lambda$Converter$J1qCrN1FCSaedsKAKXgjY9yZg r9 = $$Lambda$Converter$J1qCrN1FCSaedsKAKXgjY9yZg.INSTANCE;
        $$Lambda$Converter$jkQ5F6jnFZPZiL4rD7ZWunZbiK0 r10 = $$Lambda$Converter$jkQ5F6jnFZPZiL4rD7ZWunZbiK0.INSTANCE;
        $$Lambda$Converter$zJINkLwfvPTp1n_mypQ137M_Ik r5 = $$Lambda$Converter$zJINkLwfvPTp1n_mypQ137M_Ik.INSTANCE;
        $$Lambda$Converter$nVixs9Abph8AkndXp0MmHk272Xk r16 = $$Lambda$Converter$nVixs9Abph8AkndXp0MmHk272Xk.INSTANCE;
        $$Lambda$Converter$9zCOJxPf9UE_A4Hs70EiWrVlw r22 = $$Lambda$Converter$9zCOJxPf9UE_A4Hs70EiWrVlw.INSTANCE;
        $$Lambda$Converter$w1qR7gHzbsmmd9tVoQWiCkOAz6I r28 = $$Lambda$Converter$w1qR7gHzbsmmd9tVoQWiCkOAz6I.INSTANCE;
        $$Lambda$Converter$kmEt0qxBhOU5aDzTvKIRRrLTmeE r34 = $$Lambda$Converter$kmEt0qxBhOU5aDzTvKIRRrLTmeE.INSTANCE;
        Converters.addConverter(ByteBuffer.class, (String) null, ByteBufferList.class, (String) null, r5);
        Converters.addConverter(String.class, (String) null, byte[].class, "text/plain", r16);
        Converters.addConverter(byte[].class, (String) null, ByteBufferList.class, (String) null, r6);
        Converters.addConverter(ByteBufferList.class, (String) null, byte[].class, (String) null, r7);
        Converters.addConverter(ByteBufferList.class, (String) null, ByteBuffer.class, (String) null, r8);
        Converters.addConverter(ByteBufferList.class, "text/plain", String.class, (String) null, r9);
        Converters.addConverter(byte[].class, (String) null, ByteBuffer.class, (String) null, r10);
        Converters.addConverter(String.class, "application/json", JSONObject.class, (String) null, r22);
        Converters.addConverter(JSONObject.class, (String) null, String.class, "application/json", r28);
        Converters.addConverter(byte[].class, "text/plain", String.class, (String) null, r34);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ Future m44004c(byte[] bArr, String str) throws Exception {
        return new SimpleFuture(new ByteBufferList(ByteBufferList.deepCopy(ByteBuffer.wrap(bArr))));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ Future m44002c(ByteBufferList byteBufferList, String str) throws Exception {
        return new SimpleFuture(byteBufferList.getAllByteArray());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ Future m43999b(ByteBufferList byteBufferList, String str) throws Exception {
        return new SimpleFuture(byteBufferList.getAll());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ Future m43989a(ByteBufferList byteBufferList, String str) throws Exception {
        return new SimpleFuture(byteBufferList.peekString());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ Future m44001b(byte[] bArr, String str) throws Exception {
        return new SimpleFuture(ByteBufferList.deepCopy(ByteBuffer.wrap(bArr)));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ Future m43994a(ByteBuffer byteBuffer, String str) throws Exception {
        return new SimpleFuture(new ByteBufferList(ByteBufferList.deepCopy(byteBuffer)));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ Future m44003c(String str, String str2) throws Exception {
        return new SimpleFuture(str.getBytes());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ Future m43996a(byte[] bArr, String str) throws Exception {
        return new SimpleFuture(new String(bArr));
    }
}
