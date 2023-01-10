package com.google.android.play.core.common;

import android.os.Bundle;
import com.didi.soda.customer.app.constant.StringConst;
import com.google.android.play.core.internal.C20030ag;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PlayCoreVersion {

    /* renamed from: a */
    private static final Set<String> f56047a = new HashSet(Arrays.asList(new String[]{"review"}));

    /* renamed from: b */
    private static final Set<String> f56048b = new HashSet(Arrays.asList(new String[]{"native", "unity"}));

    /* renamed from: c */
    private static final Map<String, Map<String, Integer>> f56049c = new HashMap();

    /* renamed from: d */
    private static final C20030ag f56050d = new C20030ag("PlayCoreVersion");

    private PlayCoreVersion() {
    }

    /* renamed from: a */
    public static Bundle m42109a() {
        Bundle bundle = new Bundle();
        Map<String, Integer> a = m42110a("review");
        bundle.putInt("playcore_version_code", a.get(StringConst.JAVA).intValue());
        if (a.containsKey("native")) {
            bundle.putInt("playcore_native_version", a.get("native").intValue());
        }
        if (a.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", a.get("unity").intValue());
        }
        return bundle;
    }

    /* renamed from: a */
    public static synchronized Map<String, Integer> m42110a(String str) {
        Map<String, Integer> map;
        synchronized (PlayCoreVersion.class) {
            if (!f56049c.containsKey(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put(StringConst.JAVA, 10802);
                f56049c.put(str, hashMap);
            }
            map = f56049c.get(str);
        }
        return map;
    }

    public static synchronized void addVersion(String str, String str2, int i) {
        synchronized (PlayCoreVersion.class) {
            if (!f56047a.contains(str)) {
                f56050d.mo164271d("Illegal module name: %s", str);
            } else if (!f56048b.contains(str2)) {
                f56050d.mo164271d("Illegal platform name: %s", str2);
            } else {
                m42110a(str).put(str2, Integer.valueOf(i));
            }
        }
    }
}
