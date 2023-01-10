package com.kwai.koom.javaoom.analysis;

import com.kwai.koom.javaoom.common.KLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.sequences.Sequence;
import kshark.HeapObject;

class ClassHierarchyFetcher {

    /* renamed from: a */
    private static final String f58369a = "ClassHierarchyFetcher";

    /* renamed from: c */
    private static ClassHierarchyFetcher f58370c;

    /* renamed from: b */
    private Map<Long, List<ClassGeneration>> f58371b = new HashMap();

    /* renamed from: d */
    private Set<Integer> f58372d;

    /* renamed from: a */
    private static ClassHierarchyFetcher m44258a() {
        ClassHierarchyFetcher classHierarchyFetcher = f58370c;
        if (classHierarchyFetcher != null) {
            return classHierarchyFetcher;
        }
        ClassHierarchyFetcher classHierarchyFetcher2 = new ClassHierarchyFetcher();
        f58370c = classHierarchyFetcher2;
        return classHierarchyFetcher2;
    }

    /* renamed from: b */
    private static Map<Long, List<ClassGeneration>> m44262b() {
        return m44258a().f58371b;
    }

    /* renamed from: a */
    public static void m44260a(Set<Integer> set) {
        KLog.m44291i(f58369a, "initComputeGenerations " + m44261b(set));
        m44258a().f58372d = set;
    }

    /* renamed from: b */
    private static String m44261b(Set<Integer> set) {
        String str = "";
        for (Integer num : set) {
            str = str + num + ",";
        }
        return str;
    }

    /* renamed from: c */
    private static Set<Integer> m44263c() {
        return m44258a().f58372d;
    }

    /* renamed from: a */
    public static void m44259a(long j, Sequence<HeapObject.HeapClass> sequence) {
        if (m44262b().get(Long.valueOf(j)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<HeapObject.HeapClass> it = sequence.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                it.next();
                i2++;
            }
            Set<Integer> c = m44263c();
            for (HeapObject.HeapClass next : sequence) {
                i++;
                for (Integer next2 : c) {
                    if (i == i2 - next2.intValue()) {
                        ClassGeneration classGeneration = new ClassGeneration();
                        classGeneration.f58373id = next.getObjectId();
                        classGeneration.generation = next2.intValue();
                        arrayList.add(classGeneration);
                    }
                }
            }
            m44262b().put(Long.valueOf(j), arrayList);
        }
    }

    /* renamed from: a */
    public static long m44257a(long j, int i) {
        List<ClassGeneration> list = m44262b().get(Long.valueOf(j));
        if (list == null) {
            return 0;
        }
        for (ClassGeneration classGeneration : list) {
            if (classGeneration.generation == i) {
                return classGeneration.f58373id;
            }
        }
        return 0;
    }

    static class ClassGeneration {
        int generation;

        /* renamed from: id */
        long f58373id;

        ClassGeneration() {
        }
    }
}
