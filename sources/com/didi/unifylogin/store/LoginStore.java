package com.didi.unifylogin.store;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.net.pojo.response.BaseLoginSuccessResponse;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.utils.LoginLog;

public class LoginStore extends BaseStore {
    public static final String CACHE_KEY_UID = "uid";
    public static final int NEW_USER = 1;

    /* renamed from: a */
    private static final String f47526a = "LoginStore";

    /* renamed from: b */
    private static final String f47527b = "role";

    /* renamed from: c */
    private static final String f47528c = "appId";

    /* renamed from: d */
    private static final String f47529d = "Token";

    /* renamed from: e */
    private static final String f47530e = "phone";

    /* renamed from: f */
    private static final String f47531f = "hide_email";

    /* renamed from: g */
    private static final String f47532g = "plain_text_email";

    /* renamed from: h */
    private static final String f47533h = "credential";

    /* renamed from: i */
    private static final String f47534i = "countryId";
    public static boolean isDebug = false;

    /* renamed from: j */
    private static final String f47535j = "token_refresh_time";

    /* renamed from: k */
    private static final String f47536k = "double_identity";

    /* renamed from: l */
    private static final String f47537l = "is_law_checked";

    /* renamed from: m */
    private static final String f47538m = "is_data_migration";

    /* renamed from: n */
    private static final String f47539n = "finish_input_info";

    /* renamed from: o */
    private static Context f47540o;

    /* renamed from: p */
    private static volatile LoginStore f47541p;

    /* renamed from: A */
    private int f47542A = 0;

    /* renamed from: B */
    private String f47543B;

    /* renamed from: q */
    private int f47544q = -1;

    /* renamed from: r */
    private int f47545r = -1;

    /* renamed from: s */
    private String f47546s;

    /* renamed from: t */
    private String f47547t;

    /* renamed from: u */
    private String f47548u;

    /* renamed from: v */
    private String f47549v;

    /* renamed from: w */
    private String f47550w;

    /* renamed from: x */
    private long f47551x = -1;

    /* renamed from: y */
    private int f47552y = -1;

    /* renamed from: z */
    private int f47553z = -1;

    private LoginStore() {
        super("com.didi.sdk.login.c.j");
    }

    public static LoginStore getInstance() {
        if (f47541p == null) {
            synchronized (LoginStore.class) {
                if (f47541p == null) {
                    f47541p = new LoginStore();
                }
            }
        }
        return f47541p;
    }

    public static void setContext(Context context) {
        f47540o = context.getApplicationContext();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            isDebug = (applicationInfo.flags & 2) != 0;
        }
    }

    public static Context getContext() {
        return f47540o;
    }

    public String getToken() {
        if (f47540o == null) {
            SystemUtils.log(5, f47526a, "context is null, failed to get token", (Throwable) null, "com.didi.unifylogin.store.LoginStore", 176);
            return "";
        }
        if (this.f47549v == null) {
            this.f47549v = m35680a(f47529d);
        }
        return this.f47549v;
    }

    public long getUid() {
        if (this.f47551x <= 0) {
            this.f47551x = m35679a("uid", -1);
        }
        return this.f47551x;
    }

    public String getPhone() {
        if (this.f47546s == null) {
            this.f47546s = m35680a("phone");
        }
        return this.f47546s;
    }

    public int getRole() {
        if (this.f47544q == -1) {
            this.f47544q = m35678a("role", -1);
        }
        return this.f47544q;
    }

    public int getAppId() {
        if (this.f47545r < 0) {
            this.f47545r = m35678a("appId", -1);
        }
        return this.f47545r;
    }

    public int getCountryId() {
        if (this.f47552y <= 0) {
            this.f47552y = m35678a("countryId", -1);
        }
        return this.f47552y;
    }

    public void setAndSaveCountryId(int i) {
        if (i >= 0) {
            this.f47552y = i;
            putAndSave(f47540o, "countryId", String.valueOf(i));
        }
    }

    public int getDefCountryId() {
        return this.f47553z;
    }

    public void setDefCountryId(int i) {
        if (i > 0) {
            this.f47553z = i;
        }
    }

    public boolean isDoubleId() {
        return m35683a(f47536k, false);
    }

    public int getUserType() {
        return this.f47542A;
    }

    public boolean isLawChecked() {
        return m35683a(f47537l, false);
    }

    public void setTemporaryToken(String str) {
        this.f47550w = str;
    }

    public String getTemporaryToken() {
        return this.f47550w;
    }

    public void setToken(String str) {
        this.f47549v = str;
    }

    public void setAndsaveToken(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f47549v = str;
            putAndSave(f47540o, f47529d, str);
            saveTokenRefreshTime();
            LoginLog.write("LoginStore saveToken()");
        }
    }

    public void setAndSaceUid(long j) {
        this.f47551x = j;
        putAndSave(f47540o, "uid", String.valueOf(j));
    }

    public void setAndSaveRole(int i) {
        if (i >= 0) {
            this.f47544q = i;
            putAndSave(f47540o, "role", String.valueOf(i));
        }
    }

    public void setAndSaveAppId(int i) {
        this.f47545r = i;
        putAndSave(f47540o, "appId", (long) i);
    }

    public void setAppId(int i) {
        this.f47545r = i;
    }

    public void setAndSavePhone(String str) {
        this.f47546s = str;
        putAndSave(f47540o, "phone", str);
    }

    public void setAndSaveHideEmail(String str) {
        this.f47547t = str;
        if (TextUtils.isEmpty(str)) {
            clearAll(f47531f);
        } else {
            putAndSave(f47540o, f47531f, str);
        }
    }

    public void setAndSavePlainTextEmail(String str) {
        this.f47548u = str;
        if (TextUtils.isEmpty(str)) {
            clearAll(f47532g);
        } else {
            putAndSave(f47540o, f47532g, this.f47548u);
        }
    }

    public String getPlainTextEmail() {
        if (TextUtils.isEmpty(this.f47548u)) {
            this.f47548u = m35680a(f47532g);
        }
        return this.f47548u;
    }

    public String getHideEmail() {
        if (TextUtils.isEmpty(this.f47547t)) {
            this.f47547t = m35680a(f47531f);
        }
        return this.f47547t;
    }

    public String getCredential() {
        if (TextUtils.isEmpty(this.f47543B)) {
            this.f47543B = m35680a(f47533h);
        }
        return this.f47543B;
    }

    public void setAndSaveCredential(String str) {
        this.f47543B = str;
        if (TextUtils.isEmpty(str)) {
            clearAll(f47533h);
        } else {
            putAndSave(f47540o, f47533h, str);
        }
    }

    public void setAndSaveDoubleId(boolean z) {
        putAndSave(f47540o, f47536k, String.valueOf(z));
    }

    public void setUserType(int i) {
        if (i > -1) {
            this.f47542A = i;
        }
    }

    public void setLawChecked(boolean z) {
        putAndSave(f47540o, f47537l, String.valueOf(z));
    }

    public void saveTokenRefreshTime() {
        putAndSave(f47540o, f47535j, String.valueOf(System.currentTimeMillis()));
    }

    public Long getTokenRefreshTime() {
        String a = getInstance().m35680a(f47535j);
        if (TextUtils.isEmpty(a)) {
            return 0L;
        }
        try {
            return Long.valueOf(Long.parseLong(a));
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public void loginOutClean() {
        this.f47549v = null;
        this.f47551x = -1;
        this.f47544q = -1;
        this.f47550w = null;
        this.f47547t = null;
        this.f47543B = null;
        clearAll(f47529d);
        clearAll("uid");
        clearAll("role");
        clearAll(f47531f);
        clearAll(f47533h);
        clearAll(f47539n);
        LoginLog.write("LoginStore loginOutClean() ");
    }

    public void cleanPhone() {
        this.f47546s = null;
        clearAll("phone");
        LoginLog.write("LoginStorecleanPhone()");
    }

    /* renamed from: a */
    private void m35682a(String str, String str2, long j, int i) {
        LoginLog.write("LoginStore saveLoginInfo() token:" + str + " ,phone:" + str2 + " ,uid:" + j + " ,countryId:" + i);
        if (!TextUtil.isEmpty(str)) {
            setTemporaryToken(str);
            setAndsaveToken(str);
        }
        if (!TextUtil.isEmpty(str2)) {
            setAndSavePhone(str2);
        }
        if (j > 0) {
            setAndSaceUid(j);
        }
        if (i > 0) {
            setAndSaveCountryId(i);
            CountryManager.getIns().saveOldCountry(f47540o, i);
        }
    }

    /* renamed from: a */
    private void m35681a(BaseLoginSuccessResponse baseLoginSuccessResponse) {
        if (baseLoginSuccessResponse != null) {
            String str = baseLoginSuccessResponse.emailPlainText;
            if (!TextUtils.isEmpty(str)) {
                setAndSavePlainTextEmail(str);
            } else {
                setAndSavePlainTextEmail("");
            }
        }
    }

    public void saveLoginInfo(BaseLoginSuccessResponse baseLoginSuccessResponse, FragmentMessenger fragmentMessenger) {
        if (baseLoginSuccessResponse != null) {
            if (fragmentMessenger != null) {
                setAndSaveHideEmail(fragmentMessenger.getHideEmail());
                setAndSaveCredential(fragmentMessenger.getCredential());
            }
            m35682a(baseLoginSuccessResponse.ticket, baseLoginSuccessResponse.cell, baseLoginSuccessResponse.uid, baseLoginSuccessResponse.countryId);
            m35681a(baseLoginSuccessResponse);
        }
    }

    public void updateLoginInfo(BaseLoginSuccessResponse baseLoginSuccessResponse) {
        if (TextUtils.isEmpty(baseLoginSuccessResponse.cell)) {
            getInstance().setAndSavePhone("");
        } else {
            getInstance().setAndSavePhone(baseLoginSuccessResponse.cell);
        }
    }

    public void dataMigration(String str, String str2, long j, int i) {
        if (!m35683a(f47538m, false)) {
            LoginLog.write("LoginStore dataMigration() token:*** ,phone:" + str2 + ",uid:" + j + ",countryId:" + i);
            m35682a(str, str2, j, i);
            setAndsaveToken(getTemporaryToken());
            putAndSave(f47540o, f47538m, String.valueOf(true));
        }
    }

    public void setFinishInputInfo(boolean z) {
        putAndSave(f47540o, f47539n, String.valueOf(z));
    }

    public boolean getFinishInputInfo() {
        return m35683a(f47539n, true);
    }

    /* renamed from: a */
    private String m35680a(String str) {
        Context context = f47540o;
        if (context == null) {
            return "";
        }
        Object inner = getInner(context, str);
        return inner instanceof byte[] ? new String((byte[]) inner) : (String) inner;
    }

    /* renamed from: a */
    private int m35678a(String str, int i) {
        try {
            String a = m35680a(str);
            if (!TextUtil.isEmpty(a)) {
                return Integer.parseInt(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /* renamed from: a */
    private long m35679a(String str, long j) {
        try {
            String a = m35680a(str);
            if (!TextUtil.isEmpty(a)) {
                return Long.parseLong(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    /* renamed from: a */
    private boolean m35683a(String str, boolean z) {
        try {
            String a = m35680a(str);
            if (!TextUtil.isEmpty(a)) {
                return Boolean.parseBoolean(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }
}
