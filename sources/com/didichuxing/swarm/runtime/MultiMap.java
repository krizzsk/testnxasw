package com.didichuxing.swarm.runtime;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MultiMap<K, V> implements Map<K, List<V>> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HashMap<K, List<V>> f51780a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final LinkedHashSet<V> f51781b;

    /* renamed from: c */
    private final Comparator<V> f51782c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f51783d;

    public MultiMap() {
        this.f51781b = new LinkedHashSet<>();
        this.f51783d = false;
        this.f51780a = new HashMap<>();
        this.f51782c = null;
    }

    public MultiMap(int i) {
        this.f51781b = new LinkedHashSet<>();
        this.f51783d = false;
        this.f51780a = new HashMap<>(i);
        this.f51782c = null;
    }

    public MultiMap(MultiMap<K, ? extends V> multiMap) {
        this();
        mo127759a(multiMap);
    }

    public MultiMap(Comparator<V> comparator) {
        this.f51781b = new LinkedHashSet<>();
        this.f51783d = false;
        this.f51780a = new HashMap<>();
        this.f51782c = comparator;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HashMap<K, List<V>> mo127757a() {
        return this.f51780a;
    }

    /* renamed from: a */
    public void mo127761a(K k, V v) {
        List list = this.f51780a.get(k);
        if (list == null) {
            list = new ArrayList();
            this.f51780a.put(k, list);
        }
        list.add(v);
        Comparator<V> comparator = this.f51782c;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
        if (!this.f51783d) {
            this.f51781b.add(v);
        }
    }

    /* renamed from: a */
    public void mo127760a(K k) {
        if (this.f51780a.get(k) == null) {
            this.f51780a.put(k, new ArrayList());
        }
    }

    /* renamed from: b */
    public void mo127766b(K k, V v) {
        List list = this.f51780a.get(k);
        if (list == null) {
            list = new ArrayList();
            this.f51780a.put(k, list);
        }
        if (!list.contains(v)) {
            list.add(v);
            Comparator<V> comparator = this.f51782c;
            if (comparator != null) {
                Collections.sort(list, comparator);
            }
            if (!this.f51783d) {
                this.f51781b.add(v);
            }
        }
    }

    /* renamed from: a */
    public void mo127762a(K k, Collection<? extends V> collection) {
        List list = this.f51780a.get(k);
        if (list == null) {
            list = new ArrayList();
            this.f51780a.put(k, list);
        }
        list.addAll(collection);
        Comparator<V> comparator = this.f51782c;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
        if (!this.f51783d) {
            this.f51781b.addAll(collection);
        }
    }

    /* renamed from: a */
    public void mo127759a(MultiMap<K, ? extends V> multiMap) {
        for (K next : multiMap.keySet()) {
            mo127762a(next, multiMap.get((Object) next));
        }
    }

    /* renamed from: b */
    public List<V> get(Object obj) {
        return this.f51780a.get(obj);
    }

    /* renamed from: c */
    public int mo127767c(K k, V v) {
        List b = get((Object) k);
        if (b == null) {
            return -1;
        }
        return b.indexOf(v);
    }

    public boolean remove(Object obj, Object obj2) {
        List b = get(obj);
        if (b == null) {
            return false;
        }
        boolean remove = b.remove(obj2);
        if (remove) {
            this.f51783d = true;
        }
        return remove;
    }

    /* renamed from: c */
    public List<V> remove(Object obj) {
        List<V> remove = this.f51780a.remove(obj);
        if (remove == null) {
            return null;
        }
        this.f51783d = true;
        return remove;
    }

    /* renamed from: d */
    public List<V> mo127773d(K k) {
        List<V> b = get((Object) k);
        return b == null ? Collections.emptyList() : b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo127765b() {
        this.f51781b.clear();
        for (List addAll : values()) {
            this.f51781b.addAll(addAll);
        }
        this.f51783d = false;
    }

    /* renamed from: c */
    public List<V> mo127768c() {
        if (this.f51783d) {
            mo127765b();
        }
        return new ArrayList(this.f51781b);
    }

    /* renamed from: a */
    public void mo127763a(K[] kArr, V v) {
        for (K b : kArr) {
            List b2 = get((Object) b);
            if (b2 != null) {
                b2.remove(v);
            }
        }
        this.f51783d = true;
    }

    public Set<K> keySet() {
        return new KeySet();
    }

    public String toString() {
        return "MultiMap " + this.f51780a.toString();
    }

    private final class KeySet extends AbstractSet<K> {
        private final Set<K> keySet;

        protected KeySet() {
            this.keySet = MultiMap.this.f51780a.keySet();
        }

        public Iterator<K> iterator() {
            final Iterator<K> it = this.keySet.iterator();
            return new Iterator<K>() {
                private K element;

                public boolean hasNext() {
                    return it.hasNext();
                }

                public K next() {
                    K next = it.next();
                    this.element = next;
                    return next;
                }

                public void remove() {
                    MultiMap.this.remove((Object) this.element);
                }
            };
        }

        public int size() {
            return MultiMap.this.f51780a.size();
        }

        public boolean contains(Object obj) {
            return MultiMap.this.containsKey(obj);
        }

        public boolean remove(Object obj) {
            boolean z = MultiMap.this.remove(obj) != null;
            if (z) {
                boolean unused = MultiMap.this.f51783d = true;
            }
            return z;
        }

        public void clear() {
            MultiMap.this.clear();
            MultiMap.this.f51781b.clear();
            boolean unused = MultiMap.this.f51783d = false;
        }
    }

    public int size() {
        return this.f51780a.size();
    }

    public boolean isEmpty() {
        return this.f51780a.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.f51780a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        if (this.f51783d) {
            mo127765b();
        }
        return this.f51781b.contains(obj);
    }

    /* renamed from: a */
    public List<V> put(K k, List<V> list) {
        throw new UnsupportedOperationException("put");
    }

    public void putAll(Map<? extends K, ? extends List<V>> map) {
        throw new UnsupportedOperationException("putAll");
    }

    public void clear() {
        this.f51780a.clear();
        this.f51781b.clear();
        this.f51783d = false;
    }

    public Collection<List<V>> values() {
        return this.f51780a.values();
    }

    public Set<Map.Entry<K, List<V>>> entrySet() {
        return this.f51780a.entrySet();
    }
}
