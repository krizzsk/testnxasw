package com.didi.addressold.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.addressold.util.CollectionUtil;
import com.didi.addressold.util.SavedInstance;
import com.didi.global.loading.app.AbsLoadingActivity;
import com.didi.map.base.bubble.BaseBubbleBitmapLoader;
import com.didi.sdk.apm.SystemUtils;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InstanceStateActivity extends AbsLoadingActivity {

    /* renamed from: a */
    private static final String f9749a = "savedData";

    /* renamed from: b */
    private static final String f9750b = "int";

    /* renamed from: c */
    private static final String f9751c = "long";

    /* renamed from: d */
    private static final String f9752d = "double";

    /* renamed from: e */
    private static final String f9753e = "float";

    /* renamed from: f */
    private static final String f9754f = "boolean";

    /* renamed from: g */
    private static final String f9755g = "serializable";

    public View getFallbackView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m8493b(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        m8493b(bundle);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m8488a(bundle);
    }

    /* renamed from: a */
    private void m8488a(Bundle bundle) {
        HashMap<String, Object> a = m8487a((Class) getClass(), (HashMap<String, Object>) new HashMap());
        if (!CollectionUtil.isEmpty((Map) a)) {
            for (Map.Entry next : a.entrySet()) {
                m8489a(bundle, (String) next.getKey(), next.getValue());
            }
        }
        if (a != null) {
            bundle.putCharSequenceArrayList(f9749a, new ArrayList(a.keySet()));
        }
    }

    /* renamed from: b */
    private void m8493b(Bundle bundle) {
        if (bundle != null) {
            ArrayList<CharSequence> charSequenceArrayList = bundle.getCharSequenceArrayList(f9749a);
            if (!CollectionUtil.isEmpty((Collection) charSequenceArrayList)) {
                Iterator<CharSequence> it = charSequenceArrayList.iterator();
                while (it.hasNext()) {
                    CharSequence next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        m8490a(next, bundle.get((String) next));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private HashMap<String, Object> m8487a(Class cls, HashMap<String, Object> hashMap) {
        if (cls == null) {
            return null;
        }
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        if (cls == InstanceStateActivity.class) {
            return hashMap;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        if (!CollectionUtil.isEmpty((Object[]) declaredFields)) {
            for (Field field : declaredFields) {
                if (m8491a(field)) {
                    String a = m8485a(cls, field);
                    Object b = m8492b(field);
                    if (!TextUtils.isEmpty(a) && b != null) {
                        hashMap.put(a, b);
                    }
                }
            }
        }
        return m8487a(cls.getSuperclass(), hashMap);
    }

    /* renamed from: a */
    private void m8489a(Bundle bundle, String str, Object obj) {
        String a = m8486a(str);
        if (bundle == null) {
            return;
        }
        if (f9750b.equals(a)) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (f9751c.equals(a)) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if ("float".equals(a)) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (f9752d.equals(a)) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if ("boolean".equals(a)) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (f9755g.equals(a)) {
            bundle.putSerializable(str, (Serializable) obj);
        } else {
            SystemUtils.log(6, "InstanceStateActivity", "不支持存储类型：" + str, (Throwable) null, "com.didi.addressold.view.InstanceStateActivity", 133);
        }
    }

    /* renamed from: a */
    private boolean m8491a(Field field) {
        if (field == null) {
            return false;
        }
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            genericType = ((ParameterizedType) genericType).getRawType();
        }
        if (!(genericType instanceof Class)) {
            return false;
        }
        Class cls = (Class) genericType;
        if (!field.isAnnotationPresent(SavedInstance.class)) {
            return false;
        }
        if (Serializable.class.isAssignableFrom(cls) || cls.getSimpleName().equals(f9750b) || cls.getSimpleName().equals("java.lang.Integer") || cls.getSimpleName().equals(f9751c) || cls.getSimpleName().equals("java.lang.Long") || cls.getSimpleName().equals(f9752d) || cls.getSimpleName().equals("java.lang.Double") || cls.getSimpleName().equals("float") || cls.getSimpleName().equals("java.lang.Float") || cls.getSimpleName().equals("boolean") || cls.getSimpleName().equals("java.lang.Boolean")) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private String m8485a(Class cls, Field field) {
        if (cls == null || field == null) {
            return null;
        }
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            genericType = ((ParameterizedType) genericType).getRawType();
        }
        if (!(genericType instanceof Class) || !Serializable.class.isAssignableFrom((Class) genericType)) {
            return cls.getName() + "|" + field.getName() + "|" + genericType;
        }
        return cls.getName() + "|" + field.getName() + "|java.io.Serializable";
    }

    /* renamed from: a */
    private String m8486a(String str) {
        String str2 = String.valueOf(str).split(BaseBubbleBitmapLoader.FILE_SPLIT_FLAG)[2];
        if (f9750b.equals(str2) || "java.lang.Integer".equals(str2)) {
            return f9750b;
        }
        if (f9751c.equals(str2) || "java.lang.Long".equals(str2)) {
            return f9751c;
        }
        if (f9752d.equals(str2) || "java.lang.Double".equals(str2)) {
            return f9752d;
        }
        if ("float".equals(str2) || "java.lang.Float".equals(str2)) {
            return "float";
        }
        if ("boolean".equals(str2) || "java.lang.Boolean".equals(str2)) {
            return "boolean";
        }
        if ("java.io.Serializable".equals(str2)) {
            return f9755g;
        }
        return null;
    }

    /* renamed from: b */
    private Object m8492b(Field field) {
        Object obj = null;
        if (field != null) {
            field.setAccessible(true);
            try {
                obj = field.get(this);
            } catch (IllegalAccessException unused) {
            }
            field.setAccessible(false);
        }
        return obj;
    }

    /* renamed from: a */
    private void m8490a(CharSequence charSequence, Object obj) {
        String[] split = String.valueOf(charSequence).split(BaseBubbleBitmapLoader.FILE_SPLIT_FLAG);
        String str = split[0];
        try {
            Field declaredField = Class.forName(str).getDeclaredField(split[1]);
            declaredField.setAccessible(true);
            declaredField.set(this, obj);
            declaredField.setAccessible(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }
}
