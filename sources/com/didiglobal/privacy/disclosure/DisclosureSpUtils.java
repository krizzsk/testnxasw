package com.didiglobal.privacy.disclosure;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class DisclosureSpUtils {

    /* renamed from: a */
    private static final String f53001a = "privacy_disclosure_share_data";

    /* renamed from: b */
    private static final String f53002b = "has_agreed_for_";

    /* renamed from: c */
    private static final String f53003c = "disclosure_times_for_";

    /* renamed from: d */
    private static final String f53004d = "apollo_enable_for_";

    /* renamed from: e */
    private static final String f53005e = "apollo_most_disclosure_times";

    /* renamed from: f */
    private static final String f53006f = "need_extra_upload";

    /* renamed from: g */
    private static final String f53007g = "upload_info_appid";

    /* renamed from: h */
    private static final String f53008h = "upload_info_permission_type";

    /* renamed from: i */
    private static final String f53009i = "upload_info_current_permission_status";

    /* renamed from: j */
    private static final String f53010j = "upload_info_pop_content";

    /* renamed from: k */
    private static final String f53011k = "upload_info_user_action";

    /* renamed from: l */
    private static final String f53012l = "upload_info_pop_time";

    /* renamed from: m */
    private static final String f53013m = "upload_info_click_time";

    /* renamed from: c */
    private static String m39716c(Context context) {
        return f53005e;
    }

    /* renamed from: a */
    static boolean m39711a(Context context, IPrivacyType iPrivacyType) {
        return ((Boolean) get(context, m39707a(iPrivacyType), false)).booleanValue();
    }

    /* renamed from: b */
    static int m39712b(Context context, IPrivacyType iPrivacyType) {
        return ((Integer) get(context, m39714b(iPrivacyType), 0)).intValue();
    }

    /* renamed from: a */
    static void m39709a(Context context, IPrivacyType iPrivacyType, boolean z) {
        put(context, m39707a(iPrivacyType), Boolean.valueOf(z));
    }

    /* renamed from: c */
    static void m39718c(Context context, IPrivacyType iPrivacyType) {
        put(context, m39714b(iPrivacyType), Integer.valueOf(m39712b(context, iPrivacyType) + 1));
    }

    /* renamed from: a */
    private static String m39707a(IPrivacyType iPrivacyType) {
        return f53002b + iPrivacyType.getTypeId();
    }

    /* renamed from: b */
    private static String m39714b(IPrivacyType iPrivacyType) {
        return f53003c + iPrivacyType.getTypeId();
    }

    /* renamed from: d */
    static boolean m39720d(Context context, IPrivacyType iPrivacyType) {
        Map<String, Boolean> privacyTypeIdApolloEnableDefautValue = PrivacyDisclosureManager.getInitParam().getPrivacyTypeIdApolloEnableDefautValue();
        return ((Boolean) get(context, m39717c(iPrivacyType), Boolean.valueOf(privacyTypeIdApolloEnableDefautValue.containsKey(iPrivacyType.getTypeId()) ? privacyTypeIdApolloEnableDefautValue.get(iPrivacyType.getTypeId()).booleanValue() : false))).booleanValue();
    }

    /* renamed from: b */
    static void m39715b(Context context, IPrivacyType iPrivacyType, boolean z) {
        put(context, m39717c(iPrivacyType), Boolean.valueOf(z));
    }

    /* renamed from: a */
    static int m39706a(Context context) {
        return ((Integer) get(context, m39716c(context), -1)).intValue();
    }

    /* renamed from: a */
    static void m39708a(Context context, int i) {
        put(context, m39716c(context), Integer.valueOf(i));
    }

    /* renamed from: c */
    private static String m39717c(IPrivacyType iPrivacyType) {
        return f53004d + iPrivacyType.getTypeId();
    }

    /* renamed from: a */
    static void m39710a(Context context, boolean z) {
        put(context, f53006f, Boolean.valueOf(z));
    }

    /* renamed from: d */
    private static boolean m39719d(Context context) {
        return ((Boolean) get(context, f53006f, false)).booleanValue();
    }

    public static void setKeyUploadInfo(Context context, UploadParam uploadParam) {
        if (uploadParam != null) {
            put(context, f53007g, Integer.valueOf(uploadParam.getAppId()));
            put(context, f53008h, uploadParam.getPermissionType());
            put(context, f53009i, Integer.valueOf(uploadParam.getCurrentPermissionStatus()));
            put(context, f53010j, uploadParam.getPopContent());
            put(context, f53011k, Integer.valueOf(uploadParam.getUserAction()));
            put(context, f53012l, Long.valueOf(uploadParam.getPopTime()));
            put(context, f53013m, Long.valueOf(uploadParam.getClickTime()));
            m39710a(context, true);
        }
    }

    /* renamed from: b */
    static UploadParam m39713b(Context context) {
        if (!m39719d(context)) {
            return null;
        }
        UploadParam uploadParam = new UploadParam();
        try {
            uploadParam.setAppId(((Integer) get(context, f53007g, 0)).intValue());
            uploadParam.setPermissionType(((String) get(context, f53008h, "")) + "ExtraUploaded");
            uploadParam.setCurrentPermissionStatus(((Integer) get(context, f53009i, 0)).intValue());
            uploadParam.setPopContent((String) get(context, f53010j, ""));
            uploadParam.setUserAction(((Integer) get(context, f53011k, 0)).intValue());
            uploadParam.setPopTime(((Long) get(context, f53012l, 0L)).longValue());
            uploadParam.setClickTime(((Long) get(context, f53013m, 0L)).longValue());
            return uploadParam;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean put(Context context, String str, Object obj) {
        if (obj == null || str == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(f53001a, 0).edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else {
            edit.putString(str, obj.toString());
        }
        SharedPreferencesCompat.apply(edit);
        return true;
    }

    public static Object get(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f53001a, 0);
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) null);
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public static void remove(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f53001a, 0).edit();
        edit.remove(str);
        SharedPreferencesCompat.apply(edit);
    }

    public static void clear(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f53001a, 0).edit();
        edit.clear();
        SharedPreferencesCompat.apply(edit);
    }

    public static boolean contains(Context context, String str) {
        return context.getSharedPreferences(f53001a, 0).contains(str);
    }

    public static Map<String, ?> getAll(Context context) {
        return context.getSharedPreferences(f53001a, 0).getAll();
    }

    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        private SharedPreferencesCompat() {
        }

        private static Method findApplyMethod() {
            try {
                return SharedPreferences.Editor.class.getMethod(PrepaidConstant.SCENE_APPLY, new Class[0]);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }

        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor, new Object[0]);
                    return;
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
            editor.apply();
        }
    }
}
