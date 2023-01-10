package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C20079cb;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: com.google.android.play.core.assetpacks.be */
final class C19920be extends C20079cb {

    /* renamed from: a */
    private final File f55737a;

    /* renamed from: b */
    private final File f55738b;

    /* renamed from: c */
    private final NavigableMap<Long, File> f55739c = new TreeMap();

    C19920be(File file, File file2) throws IOException {
        this.f55737a = file;
        this.f55738b = file2;
        List<File> a = C19989dt.m42056a(this.f55737a, this.f55738b);
        if (!a.isEmpty()) {
            long j = 0;
            for (File next : a) {
                this.f55739c.put(Long.valueOf(j), next);
                j += next.length();
            }
            return;
        }
        throw new C19937bv(String.format("Virtualized slice archive empty for %s, %s", new Object[]{this.f55737a, this.f55738b}));
    }

    /* renamed from: a */
    private final InputStream m41920a(long j, Long l) throws IOException {
        FileInputStream fileInputStream = new FileInputStream((File) this.f55739c.get(l));
        if (fileInputStream.skip(j - l.longValue()) == j - l.longValue()) {
            return fileInputStream;
        }
        throw new C19937bv(String.format("Virtualized slice archive corrupt, could not skip in file with key %s", new Object[]{l}));
    }

    /* renamed from: a */
    public final long mo164124a() {
        Map.Entry<Long, File> lastEntry = this.f55739c.lastEntry();
        return lastEntry.getKey().longValue() + lastEntry.getValue().length();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final InputStream mo164125a(long j, long j2) throws IOException {
        if (j < 0 || j2 < 0) {
            throw new C19937bv(String.format("Invalid input parameters %s, %s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j3 = j + j2;
        if (j3 <= mo164124a()) {
            Long floorKey = this.f55739c.floorKey(Long.valueOf(j));
            Long floorKey2 = this.f55739c.floorKey(Long.valueOf(j3));
            if (floorKey.equals(floorKey2)) {
                return new C19919bd(m41920a(j, floorKey), j2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(m41920a(j, floorKey));
            Collection values = this.f55739c.subMap(floorKey, false, floorKey2, false).values();
            if (!values.isEmpty()) {
                arrayList.add(new C19972dc(Collections.enumeration(values)));
            }
            arrayList.add(new C19919bd(new FileInputStream((File) this.f55739c.get(floorKey2)), j2 - (floorKey2.longValue() - j)));
            return new SequenceInputStream(Collections.enumeration(arrayList));
        }
        throw new C19937bv(String.format("Trying to access archive out of bounds. Archive ends at: %s. Tried accessing: %s", new Object[]{Long.valueOf(mo164124a()), Long.valueOf(j3)}));
    }

    public final void close() {
    }
}
