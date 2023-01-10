package com.didi.zxing.client;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.didi.dqr.DecodeHintType;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class DecodeHintManager {

    /* renamed from: a */
    private static final String f48135a = "DecodeHintManager";

    /* renamed from: b */
    private static final Pattern f48136b = Pattern.compile(",");

    private DecodeHintManager() {
    }

    /* renamed from: a */
    private static Map<String, String> m36101a(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                break;
            } else if (str.charAt(i) == '&') {
                i++;
            } else {
                int indexOf = str.indexOf(38, i);
                int indexOf2 = str.indexOf(61, i);
                String str3 = "";
                if (indexOf < 0) {
                    if (indexOf2 < 0) {
                        str2 = Uri.decode(str.substring(i).replace('+', ' '));
                    } else {
                        String decode = Uri.decode(str.substring(i, indexOf2).replace('+', ' '));
                        str3 = Uri.decode(str.substring(indexOf2 + 1).replace('+', ' '));
                        str2 = decode;
                    }
                    if (!hashMap.containsKey(str2)) {
                        hashMap.put(str2, str3);
                    }
                } else {
                    if (indexOf2 < 0 || indexOf2 > indexOf) {
                        String decode2 = Uri.decode(str.substring(i, indexOf).replace('+', ' '));
                        if (!hashMap.containsKey(decode2)) {
                            hashMap.put(decode2, str3);
                        }
                    } else {
                        String decode3 = Uri.decode(str.substring(i, indexOf2).replace('+', ' '));
                        String decode4 = Uri.decode(str.substring(indexOf2 + 1, indexOf).replace('+', ' '));
                        if (!hashMap.containsKey(decode3)) {
                            hashMap.put(decode3, decode4);
                        }
                    }
                    i = indexOf + 1;
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    static Map<DecodeHintType, ?> m36100a(Uri uri) {
        String str;
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null || encodedQuery.isEmpty()) {
            return null;
        }
        Map<String, String> a = m36101a(encodedQuery);
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        for (DecodeHintType decodeHintType : DecodeHintType.values()) {
            if (!(decodeHintType == DecodeHintType.CHARACTER_SET || decodeHintType == DecodeHintType.POSSIBLE_FORMATS || (str = a.get(decodeHintType.name())) == null)) {
                if (decodeHintType.getValueType().equals(Object.class)) {
                    enumMap.put(decodeHintType, str);
                } else if (decodeHintType.getValueType().equals(Void.class)) {
                    enumMap.put(decodeHintType, Boolean.TRUE);
                } else if (decodeHintType.getValueType().equals(String.class)) {
                    enumMap.put(decodeHintType, str);
                } else if (decodeHintType.getValueType().equals(Boolean.class)) {
                    if (str.isEmpty()) {
                        enumMap.put(decodeHintType, Boolean.TRUE);
                    } else if ("0".equals(str) || SDKConsts.BOOLEAN_FALSE.equalsIgnoreCase(str) || "no".equalsIgnoreCase(str)) {
                        enumMap.put(decodeHintType, Boolean.FALSE);
                    } else {
                        enumMap.put(decodeHintType, Boolean.TRUE);
                    }
                } else if (decodeHintType.getValueType().equals(int[].class)) {
                    if (!str.isEmpty() && str.charAt(str.length() - 1) == ',') {
                        str = str.substring(0, str.length() - 1);
                    }
                    String[] split = f48136b.split(str);
                    int[] iArr = new int[split.length];
                    int i = 0;
                    while (i < split.length) {
                        try {
                            iArr[i] = Integer.parseInt(split[i]);
                            i++;
                        } catch (NumberFormatException unused) {
                            SystemUtils.log(5, f48135a, "Skipping array of integers hint " + decodeHintType + " due to invalid numeric value: '" + split[i] + '\'', (Throwable) null, "com.didi.zxing.client.DecodeHintManager", 184);
                            iArr = null;
                        }
                    }
                    if (iArr != null) {
                        enumMap.put(decodeHintType, iArr);
                    }
                } else {
                    SystemUtils.log(5, f48135a, "Unsupported hint type '" + decodeHintType + "' of type " + decodeHintType.getValueType(), (Throwable) null, "com.didi.zxing.client.DecodeHintManager", 194);
                }
            }
        }
        SystemUtils.log(4, f48135a, "Hints from the URI: " + enumMap, (Throwable) null, "com.didi.zxing.client.DecodeHintManager", 197);
        return enumMap;
    }

    public static Map<DecodeHintType, Object> parseDecodeHints(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        for (DecodeHintType decodeHintType : DecodeHintType.values()) {
            if (!(decodeHintType == DecodeHintType.CHARACTER_SET || decodeHintType == DecodeHintType.POSSIBLE_FORMATS)) {
                String name = decodeHintType.name();
                if (extras.containsKey(name)) {
                    if (decodeHintType.getValueType().equals(Void.class)) {
                        enumMap.put(decodeHintType, Boolean.TRUE);
                    } else {
                        Object obj = extras.get(name);
                        if (decodeHintType.getValueType().isInstance(obj)) {
                            enumMap.put(decodeHintType, obj);
                        } else {
                            SystemUtils.log(5, f48135a, "Ignoring hint " + decodeHintType + " because it is not assignable from " + obj, (Throwable) null, "com.didi.zxing.client.DecodeHintManager", 225);
                        }
                    }
                }
            }
        }
        SystemUtils.log(4, f48135a, "Hints from the Intent: " + enumMap, (Throwable) null, "com.didi.zxing.client.DecodeHintManager", 231);
        return enumMap;
    }
}
