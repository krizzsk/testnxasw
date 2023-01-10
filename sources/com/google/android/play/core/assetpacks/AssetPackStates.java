package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AssetPackStates {
    /* renamed from: a */
    public static AssetPackStates m41804a(long j, Map<String, AssetPackState> map) {
        return new C19924bi(j, map);
    }

    /* renamed from: a */
    public static AssetPackStates m41805a(Bundle bundle, C19941bz bzVar) {
        return m41807a(bundle, bzVar, (List<String>) new ArrayList());
    }

    /* renamed from: a */
    public static AssetPackStates m41806a(Bundle bundle, C19941bz bzVar, C19914az azVar) {
        return m41808a(bundle, bzVar, new ArrayList(), azVar);
    }

    /* renamed from: a */
    public static AssetPackStates m41807a(Bundle bundle, C19941bz bzVar, List<String> list) {
        return m41808a(bundle, bzVar, list, C19916ba.f55727a);
    }

    /* renamed from: a */
    private static AssetPackStates m41808a(Bundle bundle, C19941bz bzVar, List<String> list, C19914az azVar) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        HashMap hashMap = new HashMap();
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            String str = stringArrayList.get(i);
            hashMap.put(str, AssetPackState.m41801a(bundle, str, bzVar, azVar));
        }
        for (String next : list) {
            hashMap.put(next, AssetPackState.m41802a(next, 4, 0, 0, 0, 0.0d, 1));
        }
        return m41804a(bundle.getLong("total_bytes_to_download"), (Map<String, AssetPackState>) hashMap);
    }

    public abstract Map<String, AssetPackState> packStates();

    public abstract long totalBytes();
}
