package com.didi.sdk.logging.upload.persist;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p008db.SupportSQLiteStatement;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.sdk.component.search.city.p149db.DIDIDbTables;
import java.util.ArrayList;
import java.util.List;

public final class TaskRecordDao_Impl implements TaskRecordDao {

    /* renamed from: a */
    private final RoomDatabase f39403a;

    /* renamed from: b */
    private final EntityInsertionAdapter<TaskRecord> f39404b;

    /* renamed from: c */
    private final EntityDeletionOrUpdateAdapter<TaskRecord> f39405c;

    /* renamed from: d */
    private final SharedSQLiteStatement f39406d;

    public TaskRecordDao_Impl(RoomDatabase roomDatabase) {
        this.f39403a = roomDatabase;
        this.f39404b = new EntityInsertionAdapter<TaskRecord>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `TaskRecord` (`taskId`,`logPath`,`startTime`,`endTime`,`buffers`,`startTimestamp`,`endTimestamp`) VALUES (?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, TaskRecord taskRecord) {
                if (taskRecord.getTaskId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, taskRecord.getTaskId());
                }
                if (taskRecord.getLogPath() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, taskRecord.getLogPath());
                }
                if (taskRecord.getStartTime() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, taskRecord.getStartTime());
                }
                if (taskRecord.getEndTime() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, taskRecord.getEndTime());
                }
                if (taskRecord.getBuffers() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, taskRecord.getBuffers());
                }
                supportSQLiteStatement.bindLong(6, taskRecord.getStartTimestamp());
                supportSQLiteStatement.bindLong(7, taskRecord.getEndTimestamp());
            }
        };
        this.f39405c = new EntityDeletionOrUpdateAdapter<TaskRecord>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `TaskRecord` WHERE `taskId` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, TaskRecord taskRecord) {
                if (taskRecord.getTaskId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, taskRecord.getTaskId());
                }
            }
        };
        this.f39406d = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM TaskRecord WHERE taskId = ?";
            }
        };
    }

    public void add(TaskRecord taskRecord) {
        this.f39403a.assertNotSuspendingTransaction();
        this.f39403a.beginTransaction();
        try {
            this.f39404b.insert(taskRecord);
            this.f39403a.setTransactionSuccessful();
        } finally {
            this.f39403a.endTransaction();
        }
    }

    public void delete(TaskRecord taskRecord) {
        this.f39403a.assertNotSuspendingTransaction();
        this.f39403a.beginTransaction();
        try {
            this.f39405c.handle(taskRecord);
            this.f39403a.setTransactionSuccessful();
        } finally {
            this.f39403a.endTransaction();
        }
    }

    public void deleteByTaskId(String str) {
        this.f39403a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f39406d.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f39403a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f39403a.setTransactionSuccessful();
        } finally {
            this.f39403a.endTransaction();
            this.f39406d.release(acquire);
        }
    }

    public List<TaskRecord> getRecordList() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("select * FROM TaskRecord", 0);
        this.f39403a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f39403a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, DMWebSocketListener.KEY_TASK_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "logPath");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DIDIDbTables.BaseSideBarNewColumn.START_TIME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "buffers");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "startTimestamp");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "endTimestamp");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                TaskRecord taskRecord = new TaskRecord(query.getString(columnIndexOrThrow));
                taskRecord.setLogPath(query.getString(columnIndexOrThrow2));
                taskRecord.setStartTime(query.getString(columnIndexOrThrow3));
                taskRecord.setEndTime(query.getString(columnIndexOrThrow4));
                taskRecord.setBuffers(query.getString(columnIndexOrThrow5));
                taskRecord.setStartTimestamp(query.getLong(columnIndexOrThrow6));
                taskRecord.setEndTimestamp(query.getLong(columnIndexOrThrow7));
                arrayList.add(taskRecord);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public TaskRecord getRecordsByTaskId(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("select * FROM TaskRecord WHERE taskId = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f39403a.assertNotSuspendingTransaction();
        TaskRecord taskRecord = null;
        Cursor query = DBUtil.query(this.f39403a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, DMWebSocketListener.KEY_TASK_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "logPath");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, DIDIDbTables.BaseSideBarNewColumn.START_TIME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "endTime");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "buffers");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "startTimestamp");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "endTimestamp");
            if (query.moveToFirst()) {
                taskRecord = new TaskRecord(query.getString(columnIndexOrThrow));
                taskRecord.setLogPath(query.getString(columnIndexOrThrow2));
                taskRecord.setStartTime(query.getString(columnIndexOrThrow3));
                taskRecord.setEndTime(query.getString(columnIndexOrThrow4));
                taskRecord.setBuffers(query.getString(columnIndexOrThrow5));
                taskRecord.setStartTimestamp(query.getLong(columnIndexOrThrow6));
                taskRecord.setEndTimestamp(query.getLong(columnIndexOrThrow7));
            }
            return taskRecord;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
