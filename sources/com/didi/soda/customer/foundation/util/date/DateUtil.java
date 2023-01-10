package com.didi.soda.customer.foundation.util.date;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class DateUtil {

    /* renamed from: AM */
    public static final String f43859AM = "AM";
    public static final long ONE_HOUR = 3600000;
    public static final int ONE_MINUTES = 60000;
    public static final int ONE_SECOND = 1000;

    /* renamed from: PM */
    public static final String f43860PM = "PM";
    public static final int SECONDS_PER_DAY = 86400;

    private DateUtil() throws Exception {
        throw new Exception("");
    }

    public static String getSysYear() {
        return String.valueOf(Calendar.getInstance().get(1));
    }

    public static long getTimeFromStr(String str, SimpleDateFormat simpleDateFormat) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return simpleDateFormat.parse(str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
