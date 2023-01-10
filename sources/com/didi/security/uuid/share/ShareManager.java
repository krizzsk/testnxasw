package com.didi.security.uuid.share;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.didi.hawaii.basic.HWSupportedAppVersion;
import java.util.ArrayList;

public class ShareManager {

    /* renamed from: a */
    private SQLiteDatabase f41272a;

    /* renamed from: b */
    private Context f41273b;

    /* renamed from: c */
    private ArrayList<String> f41274c;

    /* renamed from: d */
    private String f41275d;

    private static class SingletonInstance {
        /* access modifiers changed from: private */
        public static final ShareManager INSTANCE = new ShareManager();

        private SingletonInstance() {
        }
    }

    public static ShareManager getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public void init(Context context) {
        this.f41273b = context;
        try {
            this.f41272a = new ShareDBHelper(this.f41273b.getApplicationContext()).getWritableDatabase();
        } catch (Throwable unused) {
        }
        this.f41275d = this.f41273b.getPackageName();
        m30983a();
    }

    public SQLiteDatabase getDB() {
        return this.f41272a;
    }

    public void setToken(String str) {
        if (this.f41272a != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(ShareDBHelper.ID_NAME, 1);
                contentValues.put("data", str);
                this.f41272a.insertWithOnConflict("token", (String) null, contentValues, 5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m30983a() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f41274c = arrayList;
        arrayList.add("com.didiglobal.fleet");
        this.f41274c.add("com.didiglobal.driver");
        this.f41274c.add("com.app99.driver");
        this.f41274c.add("com.didiglobal.driver.au");
        this.f41274c.add("com.didiglobal.passenger");
        this.f41274c.add("com.taxis99");
        this.f41274c.add(HWSupportedAppVersion.DRIVER_HK_PACKAGE_NAME);
        this.f41274c.add("com.sdu.didi.gsui.tw");
        this.f41274c.add("com.sdu.didi.gsui.jp");
        this.f41274c.add("com.xiaojukeji.didi.global.customer");
        this.f41274c.add("com.xiaojukeji.didi.global.merchant");
        this.f41274c.add("com.didi.global.rider");
        this.f41274c.add("com.xiaojukeji.didi.global.bd");
        this.f41274c.add("com.didi.brazil.rider");
        this.f41274c.add("com.xiaojukeji.didi.brazil.customer");
        this.f41274c.add("com.xiaojukeji.didi.brazil.merchant");
    }

    public String getToken() {
        for (int i = 0; i < this.f41274c.size(); i++) {
            String str = this.f41274c.get(i);
            if (!str.equals(this.f41275d)) {
                try {
                    Cursor query = this.f41273b.getContentResolver().query(Uri.parse("content://" + str + ".share/"), (String[]) null, (String) null, (String[]) null, (String) null);
                    if (query != null) {
                        while (query.moveToNext()) {
                            int i2 = query.getInt(query.getColumnIndex(ShareDBHelper.ID_NAME));
                            String string = query.getString(query.getColumnIndex("data"));
                            if (i2 == 1) {
                                query.close();
                                return string;
                            }
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
