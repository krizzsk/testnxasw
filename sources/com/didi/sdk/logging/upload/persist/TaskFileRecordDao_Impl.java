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
import java.util.ArrayList;
import java.util.List;

public final class TaskFileRecordDao_Impl implements TaskFileRecordDao {

    /* renamed from: a */
    private final RoomDatabase f39398a;

    /* renamed from: b */
    private final EntityInsertionAdapter<TaskFileRecord> f39399b;

    /* renamed from: c */
    private final EntityDeletionOrUpdateAdapter<TaskFileRecord> f39400c;

    /* renamed from: d */
    private final EntityDeletionOrUpdateAdapter<TaskFileRecord> f39401d;

    /* renamed from: e */
    private final SharedSQLiteStatement f39402e;

    public TaskFileRecordDao_Impl(RoomDatabase roomDatabase) {
        this.f39398a = roomDatabase;
        this.f39399b = new EntityInsertionAdapter<TaskFileRecord>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `TaskFileRecord` (`taskId`,`file`) VALUES (?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, TaskFileRecord taskFileRecord) {
                if (taskFileRecord.getTaskId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, taskFileRecord.getTaskId());
                }
                if (taskFileRecord.getFile() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, taskFileRecord.getFile());
                }
            }
        };
        this.f39400c = new EntityDeletionOrUpdateAdapter<TaskFileRecord>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `TaskFileRecord` WHERE `taskId` = ? AND `file` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, TaskFileRecord taskFileRecord) {
                if (taskFileRecord.getTaskId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, taskFileRecord.getTaskId());
                }
                if (taskFileRecord.getFile() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, taskFileRecord.getFile());
                }
            }
        };
        this.f39401d = new EntityDeletionOrUpdateAdapter<TaskFileRecord>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `TaskFileRecord` SET `taskId` = ?,`file` = ? WHERE `taskId` = ? AND `file` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, TaskFileRecord taskFileRecord) {
                if (taskFileRecord.getTaskId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, taskFileRecord.getTaskId());
                }
                if (taskFileRecord.getFile() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, taskFileRecord.getFile());
                }
                if (taskFileRecord.getTaskId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, taskFileRecord.getTaskId());
                }
                if (taskFileRecord.getFile() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, taskFileRecord.getFile());
                }
            }
        };
        this.f39402e = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM TaskFileRecord WHERE taskId = ?";
            }
        };
    }

    public void add(TaskFileRecord taskFileRecord) {
        this.f39398a.assertNotSuspendingTransaction();
        this.f39398a.beginTransaction();
        try {
            this.f39399b.insert(taskFileRecord);
            this.f39398a.setTransactionSuccessful();
        } finally {
            this.f39398a.endTransaction();
        }
    }

    public void addAll(List<TaskFileRecord> list) {
        this.f39398a.assertNotSuspendingTransaction();
        this.f39398a.beginTransaction();
        try {
            this.f39399b.insert(list);
            this.f39398a.setTransactionSuccessful();
        } finally {
            this.f39398a.endTransaction();
        }
    }

    public void delete(TaskFileRecord taskFileRecord) {
        this.f39398a.assertNotSuspendingTransaction();
        this.f39398a.beginTransaction();
        try {
            this.f39400c.handle(taskFileRecord);
            this.f39398a.setTransactionSuccessful();
        } finally {
            this.f39398a.endTransaction();
        }
    }

    public void update(TaskFileRecord taskFileRecord) {
        this.f39398a.assertNotSuspendingTransaction();
        this.f39398a.beginTransaction();
        try {
            this.f39401d.handle(taskFileRecord);
            this.f39398a.setTransactionSuccessful();
        } finally {
            this.f39398a.endTransaction();
        }
    }

    public void deleteByTaskId(String str) {
        this.f39398a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f39402e.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f39398a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f39398a.setTransactionSuccessful();
        } finally {
            this.f39398a.endTransaction();
            this.f39402e.release(acquire);
        }
    }

    public List<TaskFileRecord> getRecordsByTaskId(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM TaskFileRecord WHERE taskId = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f39398a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f39398a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, DMWebSocketListener.KEY_TASK_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "file");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new TaskFileRecord(query.getString(columnIndexOrThrow), query.getString(columnIndexOrThrow2)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
