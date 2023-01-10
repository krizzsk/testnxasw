package com.didi.component.business.util;

public class UserGuideExclusionUtil {

    /* renamed from: a */
    private static volatile UserGuideExclusionUtil f13238a;

    /* renamed from: b */
    private int f13239b;

    private UserGuideExclusionUtil() {
    }

    public static UserGuideExclusionUtil getInstance() {
        if (f13238a == null) {
            synchronized (UserGuideExclusionUtil.class) {
                if (f13238a == null) {
                    f13238a = new UserGuideExclusionUtil();
                }
            }
        }
        return f13238a;
    }

    public int getUserPayingGuideStatus() {
        return this.f13239b;
    }

    public void setUserPayingGuideStatus(int i) {
        this.f13239b = i;
    }
}
