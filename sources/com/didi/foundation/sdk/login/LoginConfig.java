package com.didi.foundation.sdk.login;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.foundation.sdk.service.LocaleService;
import com.didi.unifylogin.api.LoginTextAdapter;
import com.didi.unifylogin.listener.LoginListeners;

public class LoginConfig {

    /* renamed from: a */
    private String f23080a;

    /* renamed from: b */
    private int f23081b;

    /* renamed from: c */
    private boolean f23082c;

    /* renamed from: d */
    private boolean f23083d;

    /* renamed from: e */
    private boolean f23084e;

    /* renamed from: f */
    private boolean f23085f;

    /* renamed from: g */
    private boolean f23086g;

    /* renamed from: h */
    private boolean f23087h;

    /* renamed from: i */
    private LoginListeners.LoginBaseActivityDelegate f23088i;

    /* renamed from: j */
    private LoginListeners.GuidePermissionsDelegate f23089j;

    /* renamed from: k */
    private boolean f23090k;

    /* renamed from: l */
    private int f23091l;

    /* renamed from: m */
    private boolean f23092m;

    /* renamed from: n */
    private boolean f23093n;

    /* renamed from: o */
    private boolean f23094o;

    /* renamed from: p */
    private FoundationLoginTextAdapter f23095p;

    public static class FoundationLoginTextAdapter extends LoginTextAdapter {
        public FoundationDialogText getResPwdWarnDialog(Context context) {
            return null;
        }
    }

    LoginConfig(final Builder builder) {
        this.f23080a = builder.mLawUrl;
        this.f23081b = builder.mLawHintResId;
        this.f23082c = builder.mCanSwitchCountry;
        this.f23083d = builder.mCanHomeBack;
        this.f23084e = builder.mIsSupportJump;
        this.f23085f = builder.mNeedPrePage;
        this.f23086g = builder.mIsDefLawSelected;
        this.f23087h = builder.mIsAutoFullCode;
        this.f23093n = builder.mDeleteAccountPageUseTextStyle;
        this.f23094o = builder.mUsePassengerUIStyle;
        this.f23088i = new LoginListeners.LoginBaseActivityDelegate() {
            public Context getAttachBaseContext(Context context, FragmentActivity fragmentActivity) {
                if (builder.mLoginBaseActivityDelegate != null) {
                    return LocaleService.getInstance().attachBaseContext(builder.mLoginBaseActivityDelegate.getAttachBaseContext(context, fragmentActivity));
                }
                return LocaleService.getInstance().attachBaseContext(context);
            }

            public void onCreate(Bundle bundle, FragmentActivity fragmentActivity) {
                if (builder.mLoginBaseActivityDelegate != null) {
                    builder.mLoginBaseActivityDelegate.onCreate(bundle, fragmentActivity);
                }
            }

            public void onRestart(FragmentActivity fragmentActivity) {
                if (builder.mLoginBaseActivityDelegate != null) {
                    builder.mLoginBaseActivityDelegate.onRestart(fragmentActivity);
                }
            }

            public void onResume(FragmentActivity fragmentActivity) {
                if (builder.mLoginBaseActivityDelegate != null) {
                    builder.mLoginBaseActivityDelegate.onResume(fragmentActivity);
                }
            }

            public void onActivityResult(FragmentActivity fragmentActivity) {
                if (builder.mLoginBaseActivityDelegate != null) {
                    builder.mLoginBaseActivityDelegate.onActivityResult(fragmentActivity);
                }
            }
        };
        this.f23089j = builder.mGuidePermissionsDelegate;
        this.f23090k = builder.mIsExchangeNamePosition;
        this.f23091l = builder.mTheme;
        this.f23092m = builder.mIsUnifyPwd;
        this.f23095p = builder.mLoginTextAdapter;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo68117a() {
        return this.f23093n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo68118b() {
        return this.f23094o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo68119c() {
        return this.f23080a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo68120d() {
        return this.f23081b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo68121e() {
        return this.f23082c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo68122f() {
        return this.f23083d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo68123g() {
        return this.f23084e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo68125h() {
        return this.f23085f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo68126i() {
        return this.f23086g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public boolean mo68127j() {
        return this.f23087h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public LoginListeners.LoginBaseActivityDelegate mo68128k() {
        return this.f23088i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public LoginListeners.GuidePermissionsDelegate mo68129l() {
        return this.f23089j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo68130m() {
        return this.f23090k;
    }

    public int getTheme() {
        return this.f23091l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo68131n() {
        return this.f23092m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public FoundationLoginTextAdapter mo68132o() {
        return this.f23095p;
    }

    public static class FoundationDialogText extends LoginTextAdapter.DialogText {
        public FoundationDialogText(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean mCanHomeBack;
        /* access modifiers changed from: private */
        public boolean mCanSwitchCountry;
        /* access modifiers changed from: private */
        public boolean mDeleteAccountPageUseTextStyle;
        /* access modifiers changed from: private */
        public LoginListeners.GuidePermissionsDelegate mGuidePermissionsDelegate;
        /* access modifiers changed from: private */
        public boolean mIsAutoFullCode;
        /* access modifiers changed from: private */
        public boolean mIsDefLawSelected;
        /* access modifiers changed from: private */
        public boolean mIsExchangeNamePosition;
        /* access modifiers changed from: private */
        public boolean mIsSupportJump;
        /* access modifiers changed from: private */
        public boolean mIsUnifyPwd;
        /* access modifiers changed from: private */
        public int mLawHintResId;
        /* access modifiers changed from: private */
        public String mLawUrl;
        /* access modifiers changed from: private */
        public LoginListeners.LoginBaseActivityDelegate mLoginBaseActivityDelegate;
        /* access modifiers changed from: private */
        public FoundationLoginTextAdapter mLoginTextAdapter;
        /* access modifiers changed from: private */
        public boolean mNeedPrePage;
        /* access modifiers changed from: private */
        public int mTheme;
        /* access modifiers changed from: private */
        public boolean mUsePassengerUIStyle;

        public Builder setLawUrl(String str) {
            this.mLawUrl = str;
            return this;
        }

        public Builder setLawHintResId(int i) {
            this.mLawHintResId = i;
            return this;
        }

        public Builder setCanSwitchCountry(boolean z) {
            this.mCanSwitchCountry = z;
            return this;
        }

        public Builder setCanHomeBack(boolean z) {
            this.mCanHomeBack = z;
            return this;
        }

        public Builder setSupportJump(boolean z) {
            this.mIsSupportJump = z;
            return this;
        }

        public Builder setNeedPrePage(boolean z) {
            this.mNeedPrePage = z;
            return this;
        }

        public Builder setDefLawSelected(boolean z) {
            this.mIsDefLawSelected = z;
            return this;
        }

        public Builder setAutoFullCode(boolean z) {
            this.mIsAutoFullCode = z;
            return this;
        }

        public Builder setLoginBaseActivityDelegate(LoginListeners.LoginBaseActivityDelegate loginBaseActivityDelegate) {
            this.mLoginBaseActivityDelegate = loginBaseActivityDelegate;
            return this;
        }

        public Builder setGuidePermissionsDelegate(LoginListeners.GuidePermissionsDelegate guidePermissionsDelegate) {
            this.mGuidePermissionsDelegate = guidePermissionsDelegate;
            return this;
        }

        public Builder setExchangeNamePosition(boolean z) {
            this.mIsExchangeNamePosition = z;
            return this;
        }

        public Builder setTheme(int i) {
            this.mTheme = i;
            return this;
        }

        public Builder setUnifyPwd(boolean z) {
            this.mIsUnifyPwd = z;
            return this;
        }

        public Builder setLoginTextAdapter(FoundationLoginTextAdapter foundationLoginTextAdapter) {
            this.mLoginTextAdapter = foundationLoginTextAdapter;
            return this;
        }

        public Builder setDeleteAccountPageUseTextStyle(boolean z) {
            this.mDeleteAccountPageUseTextStyle = z;
            return this;
        }

        public Builder setUsePassengerUIStyle(boolean z) {
            this.mUsePassengerUIStyle = z;
            return this;
        }

        public LoginConfig build() {
            return new LoginConfig(this);
        }
    }
}
