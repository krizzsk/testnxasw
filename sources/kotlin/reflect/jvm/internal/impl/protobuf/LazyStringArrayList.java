package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends AbstractList<String> implements RandomAccess, LazyStringList {
    public static final LazyStringList EMPTY = new LazyStringArrayList().getUnmodifiableView();

    /* renamed from: a */
    private final List<Object> f5487a;

    public LazyStringArrayList() {
        this.f5487a = new ArrayList();
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.f5487a = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    public String get(int i) {
        Object obj = this.f5487a.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f5487a.set(i, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf82 = Internal.toStringUtf8(bArr);
        if (Internal.isValidUtf8(bArr)) {
            this.f5487a.set(i, stringUtf82);
        }
        return stringUtf82;
    }

    public int size() {
        return this.f5487a.size();
    }

    public String set(int i, String str) {
        return m4998a(this.f5487a.set(i, str));
    }

    public void add(int i, String str) {
        this.f5487a.add(i, str);
        this.modCount++;
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public boolean addAll(int i, Collection<? extends String> collection) {
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.f5487a.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public String remove(int i) {
        Object remove = this.f5487a.remove(i);
        this.modCount++;
        return m4998a(remove);
    }

    public void clear() {
        this.f5487a.clear();
        this.modCount++;
    }

    public void add(ByteString byteString) {
        this.f5487a.add(byteString);
        this.modCount++;
    }

    public ByteString getByteString(int i) {
        Object obj = this.f5487a.get(i);
        ByteString b = m4999b(obj);
        if (b != obj) {
            this.f5487a.set(i, b);
        }
        return b;
    }

    /* renamed from: a */
    private static String m4998a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).toStringUtf8();
        }
        return Internal.toStringUtf8((byte[]) obj);
    }

    /* renamed from: b */
    private static ByteString m4999b(Object obj) {
        if (obj instanceof ByteString) {
            return (ByteString) obj;
        }
        if (obj instanceof String) {
            return ByteString.copyFromUtf8((String) obj);
        }
        return ByteString.copyFrom((byte[]) obj);
    }

    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.f5487a);
    }

    public LazyStringList getUnmodifiableView() {
        return new UnmodifiableLazyStringList(this);
    }
}
