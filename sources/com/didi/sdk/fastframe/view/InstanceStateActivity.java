package com.didi.sdk.fastframe.view;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.map.base.bubble.BaseBubbleBitmapLoader;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fastframe.util.CollectionUtil;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InstanceStateActivity extends AppCompatActivity {

    /* renamed from: a */
    private static final String f38674a = "savedData";

    /* renamed from: b */
    private static final String f38675b = "int";

    /* renamed from: c */
    private static final String f38676c = "long";

    /* renamed from: d */
    private static final String f38677d = "double";

    /* renamed from: e */
    private static final String f38678e = "float";

    /* renamed from: f */
    private static final String f38679f = "boolean";

    /* renamed from: g */
    private static final String f38680g = "serializable";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m29154b(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        m29154b(bundle);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m29149a(bundle);
    }

    /* renamed from: a */
    private void m29149a(Bundle bundle) {
        HashMap<String, Object> a = m29148a((Class) getClass(), (HashMap<String, Object>) new HashMap());
        if (!CollectionUtil.isEmpty((Map) a)) {
            for (Map.Entry next : a.entrySet()) {
                m29150a(bundle, (String) next.getKey(), next.getValue());
            }
        }
        if (a != null) {
            bundle.putCharSequenceArrayList(f38674a, new ArrayList(a.keySet()));
        }
    }

    /* renamed from: b */
    private void m29154b(Bundle bundle) {
        if (bundle != null) {
            ArrayList<CharSequence> charSequenceArrayList = bundle.getCharSequenceArrayList(f38674a);
            if (!CollectionUtil.isEmpty((Collection) charSequenceArrayList)) {
                Iterator<CharSequence> it = charSequenceArrayList.iterator();
                while (it.hasNext()) {
                    CharSequence next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        m29151a(next, bundle.get((String) next));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private HashMap<String, Object> m29148a(Class cls, HashMap<String, Object> hashMap) {
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
                if (m29152a(field)) {
                    String a = m29146a(cls, field);
                    Object b = m29153b(field);
                    if (!TextUtils.isEmpty(a) && b != null) {
                        hashMap.put(a, b);
                    }
                }
            }
        }
        return m29148a(cls.getSuperclass(), hashMap);
    }

    /* renamed from: a */
    private void m29150a(Bundle bundle, String str, Object obj) {
        String a = m29147a(str);
        if (bundle == null) {
            return;
        }
        if (f38675b.equals(a)) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (f38676c.equals(a)) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if ("float".equals(a)) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (f38677d.equals(a)) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if ("boolean".equals(a)) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (f38680g.equals(a)) {
            bundle.putSerializable(str, (Serializable) obj);
        } else {
            SystemUtils.log(6, "InstanceStateActivity", "不支持存储类型：" + str, (Throwable) null, "com.didi.sdk.fastframe.view.InstanceStateActivity", 184);
        }
    }

    /* renamed from: a */
    private boolean m29152a(Field field) {
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
        if (Serializable.class.isAssignableFrom(cls) || cls.getSimpleName().equals(f38675b) || cls.getSimpleName().equals("java.lang.Integer") || cls.getSimpleName().equals(f38676c) || cls.getSimpleName().equals("java.lang.Long") || cls.getSimpleName().equals(f38677d) || cls.getSimpleName().equals("java.lang.Double") || cls.getSimpleName().equals("float") || cls.getSimpleName().equals("java.lang.Float") || cls.getSimpleName().equals("boolean") || cls.getSimpleName().equals("java.lang.Boolean")) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private String m29146a(Class cls, Field field) {
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
        return cls.getName() + "|" + field.getName() + "|" + "java.io.Serializable";
    }

    /* renamed from: a */
    private String m29147a(String str) {
        String str2 = String.valueOf(str).split(BaseBubbleBitmapLoader.FILE_SPLIT_FLAG)[2];
        String str3 = f38675b;
        if (!str3.equals(str2) && !"java.lang.Integer".equals(str2)) {
            str3 = f38676c;
            if (!str3.equals(str2) && !"java.lang.Long".equals(str2)) {
                str3 = f38677d;
                if (!str3.equals(str2) && !"java.lang.Double".equals(str2)) {
                    str3 = "float";
                    if (!str3.equals(str2) && !"java.lang.Float".equals(str2)) {
                        str3 = "boolean";
                        if (!str3.equals(str2) && !"java.lang.Boolean".equals(str2)) {
                            if ("java.io.Serializable".equals(str2)) {
                                return f38680g;
                            }
                            return null;
                        }
                    }
                }
            }
        }
        return str3;
    }

    /* renamed from: b */
    private Object m29153b(Field field) {
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
    private void m29151a(CharSequence charSequence, Object obj) {
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
