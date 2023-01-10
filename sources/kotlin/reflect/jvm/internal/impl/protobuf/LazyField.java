package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map;

public class LazyField extends LazyFieldLite {

    /* renamed from: a */
    private final MessageLite f5483a;

    public MessageLite getValue() {
        return getValue(this.f5483a);
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public boolean equals(Object obj) {
        return getValue().equals(obj);
    }

    public String toString() {
        return getValue().toString();
    }

    static class LazyEntry<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, LazyField> entry;

        private LazyEntry(Map.Entry<K, LazyField> entry2) {
            this.entry = entry2;
        }

        public K getKey() {
            return this.entry.getKey();
        }

        public Object getValue() {
            LazyField value = this.entry.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue();
        }

        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return this.entry.getValue().setValue((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> iterator;

        public LazyIterator(Iterator<Map.Entry<K, Object>> it) {
            this.iterator = it;
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.iterator.next();
            return next.getValue() instanceof LazyField ? new LazyEntry(next) : next;
        }

        public void remove() {
            this.iterator.remove();
        }
    }
}
