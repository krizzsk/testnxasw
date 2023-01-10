package com.didi.sdk.audiorecorder.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectUtil {
    public static Object getInstance(String str, Object... objArr) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        }
        try {
            Class<?> cls = Class.forName(str);
            if (objArr != null) {
                int length = objArr.length;
                Class[] clsArr = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr[i] = objArr[i].getClass();
                }
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(objArr);
            }
            Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor2.setAccessible(true);
            return declaredConstructor2.newInstance(new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object invoke(String str, Object obj, String str2, Object... objArr) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        } else if (str2 == null || str2.equals("")) {
            throw new IllegalArgumentException("methodName不能为空");
        } else {
            try {
                Class<?> cls = Class.forName(str);
                if (objArr != null) {
                    int length = objArr.length;
                    Class[] clsArr = new Class[length];
                    for (int i = 0; i < length; i++) {
                        clsArr[i] = objArr[i].getClass();
                    }
                    Method declaredMethod = cls.getDeclaredMethod(str2, clsArr);
                    declaredMethod.setAccessible(true);
                    return declaredMethod.invoke(obj, objArr);
                }
                Method declaredMethod2 = cls.getDeclaredMethod(str2, new Class[0]);
                declaredMethod2.setAccessible(true);
                return declaredMethod2.invoke(obj, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static Object invokeMethod(Object obj, Method method, Object... objArr) {
        if (method != null) {
            method.setAccessible(true);
            try {
                return method.invoke(obj, objArr);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            throw new IllegalArgumentException("method 不能为空");
        }
    }

    public static Object getField(String str, Object obj, String str2) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        } else if (str2 == null || str2.equals("")) {
            throw new IllegalArgumentException("fieldName 不能为空");
        } else {
            try {
                Field declaredField = Class.forName(str).getDeclaredField(str2);
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void setField(String str, Object obj, String str2, Object obj2) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        } else if (str2 == null || str2.equals("")) {
            throw new IllegalArgumentException("fieldName 不能为空");
        } else {
            try {
                Field declaredField = Class.forName(str).getDeclaredField(str2);
                declaredField.setAccessible(true);
                declaredField.set(obj, obj2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Method getMethod(String str, String str2, Class... clsArr) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("className 不能为空");
        } else if (str2 == null || str2.equals("")) {
            throw new IllegalArgumentException("methodName不能为空");
        } else {
            try {
                return Class.forName(str).getDeclaredMethod(str2, clsArr);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
