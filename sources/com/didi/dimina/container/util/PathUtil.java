package com.didi.dimina.container.util;

import android.text.TextUtils;
import com.didi.dimina.container.bean.JSAppConfig;
import java.io.File;
import java.io.IOException;

public class PathUtil {
    public static String APP_SERVICE_PATH_FOR_UNWIND_STACK = "https://usr/app/app-service.js";
    public static String DM_SERVICE_PATH_FOR_UNWIND_STACK = "https://lib/dm-service.js";

    public static String resolveCanonicalPath(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str);
            if (!str.endsWith("/")) {
                file = file.getParentFile();
            }
            try {
                return new File(file, str2).getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String resolveRelativePath(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int min = Math.min(str.length(), str2.length());
        int i = 0;
        while (i < min && charArray[i] == charArray2[i]) {
            i++;
        }
        String substring = str.substring(i);
        String substring2 = str2.substring(i);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < substring.split(File.separator).length - 1; i2++) {
            sb.append("../");
        }
        sb.append(substring2);
        return sb.toString();
    }

    public static String getJSFileForStackUnwind(JSAppConfig jSAppConfig, String str, String str2) {
        StringBuilder sb = new StringBuilder("https://usr/");
        sb.append(jSAppConfig.getSubpackagesDirKeyInAppConfig(str));
        if (!str2.startsWith("/")) {
            sb.append("/");
        }
        sb.append(str2);
        return sb.toString();
    }
}
