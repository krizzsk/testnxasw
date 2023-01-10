package com.didi.hawaii.mapsdkv2.core;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class GLViewDebug {

    /* renamed from: a */
    private static final String f26189a = ".mapdump";

    /* renamed from: b */
    private static final String f26190b = ".mapdump_temp";

    /* renamed from: c */
    private static final byte f26191c = 5;

    /* renamed from: d */
    private static final byte f26192d = 8;

    /* renamed from: e */
    private static final int f26193e = 1;

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExportClass {
        String name();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExportField {
        String name();
    }

    private GLViewDebug() {
    }

    /* renamed from: a */
    static File m20683a(GLViewRootImpl gLViewRootImpl, Bitmap bitmap, File file) throws IOException {
        return new DumpProcess(file, gLViewRootImpl.getMapContext().getAndroidContext()).dump(gLViewRootImpl, bitmap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m20692b(GLView gLView, DataOutputStream dataOutputStream) throws IOException {
        ExportClass exportClass;
        if (gLView != null && (exportClass = (ExportClass) gLView.getClass().getAnnotation(ExportClass.class)) != null) {
            dataOutputStream.writeInt(1);
            m20689a(exportClass.name() + "@" + gLView.mID, dataOutputStream);
            try {
                m20694c(gLView, dataOutputStream);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            dataOutputStream.flush();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m20693b(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(5);
        dataOutputStream.writeByte(8);
        dataOutputStream.writeInt(1);
    }

    /* renamed from: c */
    private static void m20694c(GLView gLView, DataOutputStream dataOutputStream) throws IOException, IllegalAccessException {
        List<Field> a = m20685a(gLView.getClass());
        dataOutputStream.writeInt(a.size());
        for (Field next : a) {
            next.setAccessible(true);
            m20690a(next, gLView, dataOutputStream);
        }
    }

    /* renamed from: a */
    private static void m20690a(Field field, GLView gLView, DataOutputStream dataOutputStream) throws IllegalAccessException, IOException {
        String str;
        String str2;
        ExportField exportField = (ExportField) field.getAnnotation(ExportField.class);
        if (exportField == null) {
            return;
        }
        if (GLView.class.isAssignableFrom(field.getType())) {
            String name = exportField.name();
            GLView gLView2 = (GLView) field.get(gLView);
            ExportClass exportClass = (ExportClass) gLView2.getClass().getAnnotation(ExportClass.class);
            if (exportClass != null) {
                str2 = exportClass.name();
            } else {
                str2 = gLView2.toString();
            }
            m20689a(name, dataOutputStream);
            m20689a(str2 + "@" + gLView2.mID, dataOutputStream);
            return;
        }
        String name2 = exportField.name();
        Object obj = field.get(gLView);
        if (obj == null || !obj.getClass().isArray()) {
            str = String.valueOf(obj);
        } else {
            str = m20684a(obj);
        }
        m20689a(name2, dataOutputStream);
        m20689a(str, dataOutputStream);
    }

    /* renamed from: a */
    private static void m20689a(String str, DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(str.getBytes().length);
        dataOutputStream.writeBytes(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m20691b(Bitmap bitmap, DataOutputStream dataOutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getWidth() * bitmap.getHeight() * 2);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        dataOutputStream.writeInt(byteArrayOutputStream.size());
        byteArrayOutputStream.writeTo(dataOutputStream);
        dataOutputStream.flush();
    }

    static class DumpProcess {
        private DataOutputStream bytesOut;
        private File dumpFile;
        private final String fileNamePrefix;
        private FileOutputStream fileOut;
        private File outputDir;

        DumpProcess(File file, Context context) throws IOException {
            if (!file.exists() && !file.mkdirs()) {
                throw new IOException("Can't create " + file.toString());
            } else if (!file.isDirectory()) {
                throw new IOException("Output dir must be a directory.");
            } else if (file.exists() || file.mkdirs()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault());
                this.fileNamePrefix = simpleDateFormat.format(new Date()) + "_" + context.getPackageName();
                this.outputDir = file;
                File file2 = new File(file, this.fileNamePrefix + GLViewDebug.f26190b);
                this.dumpFile = file2;
                if (file2.createNewFile()) {
                    this.fileOut = new FileOutputStream(this.dumpFile);
                    this.bytesOut = new DataOutputStream(this.fileOut);
                    return;
                }
                throw new IOException(this.dumpFile.toString() + " can't be created!");
            } else {
                throw new IOException("Output dir dose not exist!");
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public File dump(GLViewRootImpl gLViewRootImpl, Bitmap bitmap) throws IOException {
            GLViewDebug.m20693b(this.bytesOut);
            GLViewDebug.m20691b(bitmap, this.bytesOut);
            for (GLView a : gLViewRootImpl.mo76052b()) {
                GLViewDebug.m20692b(a, this.bytesOut);
            }
            this.bytesOut.flush();
            try {
                this.bytesOut.close();
                this.fileOut.close();
                File file = new File(this.outputDir, this.fileNamePrefix + GLViewDebug.f26189a);
                if (this.dumpFile.renameTo(file)) {
                    return file;
                }
                return this.dumpFile;
            } catch (Throwable th) {
                this.fileOut.close();
                throw th;
            }
        }
    }

    /* renamed from: a */
    private static String m20684a(Object obj) {
        if (obj instanceof Object[]) {
            return Arrays.toString((Object[]) obj);
        }
        if (obj instanceof int[]) {
            return Arrays.toString((int[]) obj);
        }
        if (obj instanceof char[]) {
            return Arrays.toString((char[]) obj);
        }
        if (obj instanceof short[]) {
            return Arrays.toString((short[]) obj);
        }
        if (obj instanceof long[]) {
            return Arrays.toString((long[]) obj);
        }
        if (obj instanceof float[]) {
            return Arrays.toString((float[]) obj);
        }
        if (obj instanceof double[]) {
            return Arrays.toString((double[]) obj);
        }
        if (obj instanceof boolean[]) {
            return Arrays.toString((boolean[]) obj);
        }
        if (obj instanceof byte[]) {
            return Arrays.toString((byte[]) obj);
        }
        throw new IllegalArgumentException(obj + " must be an array!");
    }

    /* renamed from: a */
    private static List<Field> m20685a(Class<?> cls) {
        Class<? super Object> superclass;
        ArrayList arrayList = new ArrayList();
        Class<? super Object> cls2 = cls;
        do {
            for (Field field : cls2.getDeclaredFields()) {
                if (field.getAnnotation(ExportField.class) != null) {
                    arrayList.add(field);
                }
            }
            superclass = cls2.getSuperclass();
            cls2 = superclass;
        } while (superclass != null);
        return arrayList;
    }
}
