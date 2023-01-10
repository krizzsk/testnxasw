package com.didi.sdk.p151db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.didi.sdk.component.search.city.p149db.DIDIDbTables;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

/* renamed from: com.didi.sdk.db.DIDISQLiteOpenHelper */
public class DIDISQLiteOpenHelper extends SQLiteOpenHelper {

    /* renamed from: b */
    private static final int f38549b = 9;

    /* renamed from: c */
    private static final String f38550c = "DIDI_DATABASE";

    /* renamed from: a */
    private Logger f38551a = LoggerFactory.getLogger("DIDISQLiteOpenHelper");

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public DIDISQLiteOpenHelper(Context context) {
        super(context, f38550c, (SQLiteDatabase.CursorFactory) null, 9);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m29073a(sQLiteDatabase, DIDIDbTables.SideBarReddotColumn.TABLE_NAME);
        m29073a(sQLiteDatabase, DIDIDbTables.SideBarFireTorchColumn.TABLE_NAME);
    }

    /* renamed from: a */
    private void m29073a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("create table IF NOT EXISTS " + str + "(" + "endTime" + " long," + DIDIDbTables.BaseSideBarNewColumn.START_TIME + " long," + "id" + " long," + DIDIDbTables.BaseSideBarNewColumn.COMPONENT_ID + " long," + "page" + " varchar(30)," + "level" + " varchar(10)," + DIDIDbTables.BaseSideBarNewColumn.IS_CLICKED + " int)");
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS  side_bar_red_dot;");
        } catch (Exception unused) {
            this.f38551a.info("DROP TABLE IF EXISTS  side_bar_red_dot  error", new Object[0]);
        }
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS side_bar_fire_torch;");
            onCreate(sQLiteDatabase);
        } catch (Exception unused2) {
            this.f38551a.info("DROP TABLE IF EXISTS  side_bar_fire_torch  error", new Object[0]);
        }
    }
}
