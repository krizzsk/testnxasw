package com.didi.sdk.p151db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.didi.sdk.db.ContentResolverWrapper */
public class ContentResolverWrapper {

    /* renamed from: a */
    private static Logger f38543a = LoggerFactory.getLogger("ContentResolverWrapper");

    /* renamed from: b */
    private static boolean f38544b;

    public static int delete(ContentResolver contentResolver, Uri uri, String str, String[] strArr) {
        if (!m29069a(contentResolver, uri)) {
            return 0;
        }
        return contentResolver.delete(uri, str, strArr);
    }

    public static int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (!m29069a(contentResolver, uri)) {
            return 0;
        }
        return contentResolver.update(uri, contentValues, str, strArr);
    }

    public static int bulkInsert(ContentResolver contentResolver, Uri uri, ContentValues[] contentValuesArr) {
        if (!m29069a(contentResolver, uri)) {
            return 0;
        }
        return contentResolver.bulkInsert(uri, contentValuesArr);
    }

    public static Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        if (!m29069a(contentResolver, uri)) {
            return null;
        }
        return contentResolver.insert(uri, contentValues);
    }

    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!m29069a(contentResolver, uri)) {
            return null;
        }
        return contentResolver.query(uri, strArr, str, strArr2, str2);
    }

    /* renamed from: a */
    private static boolean m29069a(ContentResolver contentResolver, Uri uri) {
        if (contentResolver == null) {
            throw new IllegalArgumentException("contentResolver is null");
        } else if (uri == null) {
            throw new IllegalArgumentException("uri is null");
        } else if (f38544b) {
            f38543a.debug("already hasContentProvider", new Object[0]);
            return true;
        } else {
            synchronized (f38543a) {
                if (f38544b) {
                    f38543a.debug("already hasContentProvider", new Object[0]);
                    return true;
                }
                try {
                    if (Class.forName("android.content.ContentResolver").getMethod("acquireProvider", new Class[]{Uri.class}).invoke(contentResolver, new Object[]{uri}) != null) {
                        f38543a.debug("hasContentProvider", new Object[0]);
                        f38544b = true;
                        return true;
                    }
                    f38543a.debug("no ContentProvider", new Object[0]);
                } catch (ClassNotFoundException e) {
                    f38543a.debug("ClassNotFoundException", (Throwable) e);
                } catch (NoSuchMethodException e2) {
                    f38543a.debug("NoSuchMethodException", (Throwable) e2);
                } catch (InvocationTargetException e3) {
                    f38543a.debug("InvocationTargetException", (Throwable) e3);
                } catch (IllegalAccessException e4) {
                    f38543a.debug("IllegalAccessException", (Throwable) e4);
                }
            }
        }
        return false;
    }
}
