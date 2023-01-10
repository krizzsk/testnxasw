package com.didi.hawaii.log;

import com.didi.hawaii.utils.OmegaUtils;
import com.didi.hawaii.utils.StorageUtils;
import java.io.File;

public class DelOldLogHandler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long f25699a = 0;

    public void startDelOldLog() {
        new DelOldLogThread().start();
    }

    private class DelOldLogThread extends Thread {
        DelOldLogThread() {
            super("DelOldLogThread");
        }

        public void run() {
            String sDRootPath = StorageUtils.getSDRootPath();
            String str = sDRootPath + LogConstant.LOG_ROOT;
            long unused = DelOldLogHandler.this.f25699a = 0;
            DelOldLogHandler.this.m20425a(str);
            DelOldLogHandler.this.m20425a(sDRootPath + LogConstant.LOG_ROOT_BAMAI);
            StringBuilder sb = new StringBuilder();
            sb.append(DelOldLogHandler.this.f25699a);
            OmegaUtils.trackDelOldLogFilesNum(sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20425a(String str) {
        if (str != null && str.length() != 0) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    m20424a(file);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m20424a(File file) {
        if (!file.getName().equals(".") && !file.getName().equals("..")) {
            if (file.isFile()) {
                this.f25699a++;
                file.delete();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    file.delete();
                    return;
                }
                for (File a : listFiles) {
                    m20424a(a);
                }
                file.delete();
            }
        }
    }
}
