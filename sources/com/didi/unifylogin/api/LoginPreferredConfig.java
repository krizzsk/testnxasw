package com.didi.unifylogin.api;

import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.store.LoginStore;
import java.util.List;

public class LoginPreferredConfig {

    /* renamed from: A */
    private static int f47283A = -1;

    /* renamed from: B */
    private static boolean f47284B = false;
    public static final int GRAY_BUTTON = 0;
    public static final int ORANGE_BUTTON = 1;
    public static final int ORANGE_GRADUAL_BUTTON = 2;

    /* renamed from: a */
    private static int f47285a = 0;

    /* renamed from: b */
    private static String f47286b = null;
    public static String brand = "DiDi";

    /* renamed from: c */
    private static String f47287c = null;

    /* renamed from: d */
    private static boolean f47288d = true;

    /* renamed from: e */
    private static boolean f47289e = false;

    /* renamed from: f */
    private static boolean f47290f = true;

    /* renamed from: g */
    private static boolean f47291g = true;

    /* renamed from: h */
    private static boolean f47292h = false;

    /* renamed from: i */
    private static boolean f47293i = false;

    /* renamed from: j */
    private static boolean f47294j = false;

    /* renamed from: k */
    private static int f47295k = 2132017648;

    /* renamed from: l */
    private static int f47296l = 0;

    /* renamed from: m */
    private static boolean f47297m = false;

    /* renamed from: n */
    private static boolean f47298n = true;

    /* renamed from: o */
    private static boolean f47299o = false;

    /* renamed from: p */
    private static List<String> f47300p = null;

    /* renamed from: q */
    private static boolean f47301q = false;

    /* renamed from: r */
    private static boolean f47302r = false;

    /* renamed from: s */
    private static boolean f47303s = false;

    /* renamed from: t */
    private static LoginTextAdapter f47304t = new LoginTextAdapter();

    /* renamed from: u */
    private static int f47305u = -1;

    /* renamed from: v */
    private static boolean f47306v = true;

    /* renamed from: w */
    private static boolean f47307w = false;

    /* renamed from: x */
    private static boolean f47308x = false;

    /* renamed from: y */
    private static boolean f47309y = false;

    /* renamed from: z */
    private static boolean f47310z = false;

    public static String getLawHint() {
        return f47286b;
    }

    public static String getLawUrl() {
        return f47287c;
    }

    public static boolean isCanSwitchCountry() {
        return f47288d;
    }

    public static boolean isHomeCanBacke() {
        return f47289e;
    }

    public static int getButtonStyle() {
        return f47285a;
    }

    public static boolean getIsLawCbUseCache() {
        return f47306v;
    }

    public static void setIsLawCbUseCache(boolean z) {
        f47306v = z;
    }

    public static boolean isDefLawSelected() {
        return f47292h;
    }

    public static void setDefLawSelected(boolean z) {
        f47292h = z;
        if (isDefLawSelected()) {
            LoginStore.getInstance().setLawChecked(true);
        }
    }

    public static void setButtonStyle(int i) {
        f47285a = i;
    }

    public static void setLawHint(String str) {
        f47286b = str;
    }

    public static void setLawUrl(String str) {
        f47287c = str;
    }

    public static void setCanSwitchCountry(boolean z) {
        f47288d = z;
    }

    public static void setHomeCanBacke(boolean z) {
        f47289e = z;
    }

    public static boolean isNeedPrePage() {
        return f47290f;
    }

    public static void setNeedPrePage(boolean z) {
        f47290f = z;
    }

    public static boolean isCloseRetrieve() {
        return f47291g;
    }

    public static void setCloseRetrieve(boolean z) {
        f47291g = z;
    }

    public static void setSupportJump(boolean z) {
        f47293i = z;
    }

    public static boolean isSupportJump() {
        return f47293i;
    }

    public static void setAutoFullCode(boolean z) {
        f47294j = z;
    }

    public static boolean isAutoFullCode() {
        return f47294j;
    }

    public static int getThemeResInt() {
        return f47295k;
    }

    public static void setThemeResInt(int i) {
        f47295k = i;
    }

    public static boolean isExchangeNamePosition() {
        return f47297m;
    }

    public static void setExchangeNamePosition(boolean z) {
        f47297m = z;
    }

    public static boolean isUnifyPwd() {
        return f47298n;
    }

    public static void setUnifyPwd(boolean z) {
        f47298n = z;
    }

    public static void setCancelDescribes(List<String> list) {
        f47300p = list;
    }

    public static List<String> getCancelDescribes() {
        return f47300p;
    }

    public static boolean isAllowOptLoginByCode() {
        return f47299o;
    }

    public static void setAllowOptLoginByCode(boolean z) {
        f47299o = z;
    }

    public static void setUseWeakPwd(boolean z) {
        f47301q = z;
    }

    public static boolean isUseWeakPwd() {
        return f47301q;
    }

    public static boolean isDeleteAccountPageUseTextStyle() {
        return f47302r;
    }

    public static void setDeleteAccountPageUseTextStyle(boolean z) {
        f47302r = z;
    }

    public static boolean isUsePassengerUIStyle() {
        return f47303s;
    }

    public static void setUsePassengerUIStyle(boolean z) {
        f47303s = z;
    }

    public static void setTextAdapter(LoginTextAdapter loginTextAdapter) {
        f47304t = loginTextAdapter;
    }

    public static LoginTextAdapter getTextAdapter(FragmentMessenger fragmentMessenger) {
        if (f47304t == null) {
            f47304t = new LoginTextAdapter();
        }
        f47304t.setMessage(fragmentMessenger);
        return f47304t;
    }

    public static int getCodeReducedTime() {
        return f47305u;
    }

    public static void setCodeReducedTime(int i) {
        f47305u = i;
    }

    public static void setShowEmailLoginEntrance(boolean z) {
        f47308x = z;
    }

    public static boolean getShowEmailEntrance() {
        return f47308x;
    }

    public static boolean isIsShowChangePhoneByIDEntrance() {
        return f47307w;
    }

    public static void setIsShowChangePhoneByIDEntrance(boolean z) {
        f47307w = z;
    }

    public static void setOptionalEmail(boolean z) {
        f47309y = z;
    }

    public static boolean isOptionalEmail() {
        return f47309y;
    }

    public static void setNewUserCpfIntercept(boolean z) {
        f47310z = z;
    }

    public static boolean isNewUserCpfIntercept() {
        return f47310z;
    }

    public static int getDefCountryOldId() {
        return f47283A;
    }

    public static void setDefCountryByOldId(int i) {
        f47283A = i;
    }

    public static String getBrand() {
        return brand;
    }

    public static void setBrand(String str) {
        brand = str;
    }

    public static boolean isPasswordEncrypt() {
        return f47284B;
    }

    public static void setIsPasswordEncrypt(boolean z) {
        f47284B = z;
    }

    public static int getThemeColor() {
        return f47296l;
    }

    public static void setThemeColor(int i) {
        f47296l = i;
    }
}
