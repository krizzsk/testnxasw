package com.didi.beatles.p101im.service;

import com.didi.beatles.p101im.utils.IMEncryptionUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.soda.blocks.constant.Const;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* renamed from: com.didi.beatles.im.service.IMFileManager */
public class IMFileManager extends IMBaseProvider {
    public static final String TAG = "IMInit";
    public static final int TYPE_AUDIO = 101;
    public static final int TYPE_FILE = 103;
    public static final int TYPE_IMAGE = 102;

    /* renamed from: a */
    private String f11428a;

    /* renamed from: b */
    private String f11429b;

    /* renamed from: c */
    private String f11430c;

    protected IMFileManager(IMServiceProvider iMServiceProvider) {
        super(iMServiceProvider);
    }

    /* access modifiers changed from: protected */
    public void init(long j) {
        if (j != 0) {
            String str = "" + j;
            this.f11428a = str;
            this.f11429b = IMEncryptionUtil.encrypt(str);
            this.f11430c = "1.0/" + this.f11429b + "/Message";
            return;
        }
        IMLog.m10021e("IMInit", "init imFile failed while userID is 0");
        throw new IllegalArgumentException("userId 0");
    }

    public String getCurrentUserId() {
        String str = this.f11428a;
        if (str != null) {
            return str;
        }
        IMLog.m10021e("IMInit", "getCurrentUserId failed because IMConfigManager not init");
        throw new IllegalArgumentException("IMConfigManager 没有初始化");
    }

    public String getCurrentUserMd5() {
        if (this.f11428a != null) {
            return this.f11429b;
        }
        throw new IllegalArgumentException("IMConfigManager 没有初始化");
    }

    public String getRelativePath() {
        if (this.f11428a != null) {
            return this.f11430c;
        }
        throw new IllegalArgumentException("IMConfigManager 没有初始化");
    }

    public String getFileFolder(long j, int i) {
        String str;
        String str2 = getDefaultPath() + "/" + this.f11430c + "/" + IMEncryptionUtil.encrypt(j) + "/";
        switch (i) {
            case 101:
                str = str2 + "Audio";
                break;
            case 102:
                str = str2 + Const.BlockNameConst.BLOCK_NAME_IMAGE;
                break;
            case 103:
                str = str2 + "File";
                break;
            default:
                str = str2 + "Unknown";
                break;
        }
        String str3 = str + "/";
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str3;
    }

    public String getFileRootFolder(long j) {
        String str = getDefaultPath() + "/" + this.f11430c + "/" + IMEncryptionUtil.encrypt(j) + "/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public String getFilePath(long j, String str, int i) {
        return getFileFolder(j, i) + IMEncryptionUtil.encrypt(str);
    }

    public String saveFile(File file, long j, String str, int i) {
        File file2 = new File(getFilePath(j, str, i));
        if (file.renameTo(file2)) {
            return file2.getAbsolutePath();
        }
        return null;
    }

    public boolean removeSession(long j) {
        return m9877a(new File(getFileRootFolder(j)));
    }

    /* renamed from: a */
    private static boolean m9877a(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!m9877a(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public void testSaveFile(String str, long j, String str2, int i) throws IOException {
        String filePath = getFilePath(j, str2, i);
        new File(filePath).exists();
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(str);
        fileWriter.close();
    }

    public String getDefaultPath() {
        return this.mContext.getFilesDir().getAbsolutePath() + "/im";
    }

    public String getTmpPath() {
        return getDefaultPath() + "/tmp";
    }
}
