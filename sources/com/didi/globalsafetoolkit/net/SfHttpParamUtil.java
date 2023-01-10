package com.didi.globalsafetoolkit.net;

import android.os.Build;
import android.text.TextUtils;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didi.globalsafetoolkit.util.SfLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.text.Typography;

public final class SfHttpParamUtil {
    /* renamed from: b */
    private static Map<String, Object> m20131b(Map<String, Object> map) {
        return map;
    }

    public static String createHttpGetUrl(String str, Map<String, Object> map) {
        try {
            StringBuilder sb = new StringBuilder(1300);
            sb.append(str);
            sb.append('?');
            if (map != null && !map.isEmpty()) {
                boolean z = true;
                for (Map.Entry next : map.entrySet()) {
                    String a = m20129a((String) next.getKey());
                    String str2 = (String) next.getValue();
                    if (!TextUtils.isEmpty(str2)) {
                        String a2 = m20129a(str2);
                        if (!z) {
                            sb.append(Typography.amp);
                        }
                        sb.append(a);
                        sb.append('=');
                        sb.append(a2);
                        z = false;
                    }
                }
            }
            return sb.toString();
        } catch (Exception e) {
            SfLog.m20150e((Throwable) e);
            return str;
        }
    }

    public static String jointParams(String str, Map<String, Object> map) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str.contains("#/")) {
            int indexOf = str.indexOf("#/");
            str2 = str.substring(indexOf);
            sb.append(str.substring(0, indexOf));
        } else {
            sb.append(str);
            str2 = "";
        }
        if (!str.contains("?")) {
            sb.append("?");
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                String a = m20129a((String) next.getKey());
                if (next.getValue() instanceof Integer) {
                    str3 = next.getValue() + "";
                } else {
                    str3 = m20129a((String) next.getValue());
                }
                if (!TextUtils.isEmpty(a)) {
                    if (sb.toString().endsWith("?")) {
                        sb.append(a);
                        sb.append('=');
                        sb.append(str3);
                    } else {
                        sb.append(Typography.amp);
                        sb.append(a);
                        sb.append('=');
                        sb.append(str3);
                    }
                }
            }
        }
        sb.append(str2);
        SfLog.m20144d(sb.toString());
        return sb.toString();
    }

    public static Map<String, Object> createCommonParams(Map<String, Object> map) {
        m20130a(map);
        m20131b(map);
        return map;
    }

    /* renamed from: a */
    private static Map<String, Object> m20130a(Map<String, Object> map) {
        map.put("os", Build.VERSION.RELEASE);
        map.putAll(GlobalSfBusinessInterface.getBaseHttpParams(SfContextHelper.getContext()));
        return map;
    }

    public static void put(Map<String, Object> map, String str, Object obj) {
        if (obj != null) {
            String valueOf = String.valueOf(obj);
            if (!TextUtils.isEmpty(valueOf)) {
                map.put(str, valueOf.trim());
            }
        }
    }

    /* renamed from: a */
    private static String m20129a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            SfLog.m20150e((Throwable) e);
            return str;
        } catch (OutOfMemoryError unused) {
            return str;
        } catch (Exception e2) {
            SfLog.m20150e((Throwable) e2);
            return str;
        }
    }
}
