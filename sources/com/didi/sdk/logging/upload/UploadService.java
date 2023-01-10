package com.didi.sdk.logging.upload;

import android.content.Context;
import com.didi.sdk.logging.upload.persist.SliceRecord;
import com.didi.sdk.logging.upload.persist.SliceRecordDao;
import com.didi.sdk.logging.upload.persist.TaskRecord;
import com.didi.sdk.logging.upload.persist.UploadTaskDatabase;
import com.didi.sdk.logging.util.ArchTaskExecutor;
import com.didi.sdk.logging.util.Debug;
import com.didi.sdk.logging.util.LoggerUtils;
import com.didi.sdk.logging.util.ReportUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UploadService {

    /* renamed from: a */
    private static UploadService f39360a;

    /* renamed from: b */
    private Set<SliceRecord> f39361b = Collections.synchronizedSet(new HashSet());

    public static UploadService getInstance() {
        if (f39360a == null) {
            synchronized (UploadService.class) {
                if (f39360a == null) {
                    f39360a = new UploadService();
                }
            }
        }
        return f39360a;
    }

    private UploadService() {
    }

    public void start(final Context context) {
        ArchTaskExecutor.getInstance().executeOnDiskIO(new Runnable() {
            public void run() {
                try {
                    UploadService.this.m29664a(context);
                } catch (Exception e) {
                    Debug.logOrThrow("init err", e);
                    ReportUtils.reportProgramError("logging_upload_err", e);
                }
            }
        });
    }

    /* renamed from: a */
    private static void m29667a(String str) {
        Debug.m29707d("UploadService: " + str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29664a(Context context) {
        m29667a("resume upload task");
        List<TaskRecord> recordList = UploadTaskDatabase.getDatabase().getTaskRecordDao().getRecordList();
        if (recordList.isEmpty()) {
            m29667a("no pending task to upload");
        }
        for (TaskRecord a : recordList) {
            m29665a(context, a);
        }
    }

    /* renamed from: a */
    private void m29665a(Context context, TaskRecord taskRecord) {
        m29667a("start upload task: " + taskRecord);
        SliceRecordDao fileRecordDao = UploadTaskDatabase.getDatabase().getFileRecordDao();
        String taskId = taskRecord.getTaskId();
        if (!m29668a(context, fileRecordDao.getRecordsByTaskId(taskId))) {
            List<SliceRecord> recordsByTaskId = fileRecordDao.getRecordsByTaskId(taskId);
            if (recordsByTaskId.isEmpty()) {
                m29667a("task upload success: " + taskRecord);
                UploadTaskManager.getInstance().mo99073a(context, taskRecord.getTaskId());
                return;
            }
            m29667a("task upload stopped: " + taskRecord + "reminds slice records:" + recordsByTaskId);
        }
    }

    /* renamed from: a */
    private boolean m29668a(Context context, List<SliceRecord> list) {
        SliceRecordDao fileRecordDao = UploadTaskDatabase.getDatabase().getFileRecordDao();
        long a = m29662a(list);
        Iterator<SliceRecord> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SliceRecord next = it.next();
            m29667a("uploading slice:" + next);
            String taskId = next.getTaskId();
            if (this.f39361b.contains(next)) {
                m29667a("slice is uploading, stop:" + next);
                break;
            } else if (next.getUploadCount() >= 10) {
                m29667a("slice failed with count >=10:" + next);
                UploadTaskManager.getInstance().mo99074a(context, taskId, "文件分片" + next.getSliceId() + "/" + next.getSliceCount() + "超过重试次数");
                break;
            } else if (!new File(next.getFile()).exists()) {
                m29667a("slice failed file not exists:" + next);
            } else {
                this.f39361b.add(next);
                RequestResult<String> a2 = m29663a(context, next, a);
                this.f39361b.remove(next);
                if (a2.isSuccess()) {
                    m29667a("slice upload success:" + next);
                    fileRecordDao.delete(next);
                } else {
                    m29667a("slice upload failed:" + next);
                    if (a2.getCode() == -3) {
                        UploadTaskManager instance = UploadTaskManager.getInstance();
                        instance.mo99074a(context, taskId, "任务失败:" + a2.getMsg());
                        return true;
                    }
                    next.increaseUploadCount();
                    fileRecordDao.update(next);
                    UploadTaskManager.getInstance().mo99072a();
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private long m29662a(List<SliceRecord> list) {
        long j = 0;
        for (SliceRecord next : list) {
            File file = new File(next.getFile());
            if (!file.exists()) {
                m29667a("slice failed file not exists:" + next);
            } else {
                j += file.length();
            }
        }
        return j;
    }

    /* renamed from: a */
    private RequestResult<String> m29663a(Context context, SliceRecord sliceRecord, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("upload section record:");
        SliceRecord sliceRecord2 = sliceRecord;
        sb.append(sliceRecord);
        m29667a(sb.toString());
        int sliceId = sliceRecord.getSliceId() + 1;
        String taskId = sliceRecord.getTaskId();
        String formatFileSize = LoggerUtils.formatFileSize(sliceRecord.getFileSize());
        String str = "文件大小:" + formatFileSize + ",正在上传第" + sliceId + "/" + sliceRecord.getSliceCount() + "个分片";
        m29667a(str);
        C13234a.m29694a(taskId, 4, str);
        RequestResult<String> a = C13234a.m29693a(taskId, new File(sliceRecord.getFile()), LoggerUtils.getNetworkType(context), sliceRecord.getSliceId(), j);
        if (!a.isSuccess() && a.getCode() != -3) {
            C13234a.m29694a(taskId, 4, "文件大小:" + formatFileSize + ",第" + sliceId + "/" + sliceRecord.getSliceCount() + "个分片上传失败(" + a.getMsg() + "),即将进行第" + (sliceRecord.getUploadCount() + 1) + "次重试");
        }
        return a;
    }
}
