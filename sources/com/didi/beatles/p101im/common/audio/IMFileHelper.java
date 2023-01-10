package com.didi.beatles.p101im.common.audio;

import android.text.TextUtils;
import com.didi.beatles.p101im.utils.IMFileUtils;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didi.beatles.p101im.utils.MD5;
import java.io.File;

/* renamed from: com.didi.beatles.im.common.audio.IMFileHelper */
public class IMFileHelper {

    /* renamed from: a */
    private static final String f10987a = (IMFileUtils.getAppPath() + "audio/");

    public static String getAudioFilePath(String str) {
        String str2 = f10987a;
        return str2 + MD5.toMD5(str);
    }

    public static File getAudioFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(getAudioFilePath(str));
    }

    public static void deleteAudioFile(String str) {
        if (!TextUtils.isEmpty(str)) {
            String audioFilePath = getAudioFilePath(str);
            if (!TextUtils.isEmpty(audioFilePath)) {
                delete(audioFilePath);
            }
        }
    }

    public static boolean delete(String str) {
        if (m9601a(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m9601a(String str) {
        return IMTextUtil.isEmpty(str);
    }

    public static boolean renameAudioFile(String str, String str2) {
        return getAudioFile(str).renameTo(getAudioFile(str2));
    }

    public static boolean isAuioFileExist(String str) {
        return getAudioFile(str).exists();
    }
}
