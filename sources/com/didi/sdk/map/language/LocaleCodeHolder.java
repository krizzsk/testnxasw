package com.didi.sdk.map.language;

public class LocaleCodeHolder {

    /* renamed from: a */
    private LocaleCodeListener f39525a;

    public static LocaleCodeHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getCurrentLang() {
        LocaleCodeListener localeCodeListener = this.f39525a;
        return localeCodeListener != null ? localeCodeListener.getLocaleCode() : "";
    }

    public void setCurrentLang(LocaleCodeListener localeCodeListener) {
        this.f39525a = localeCodeListener;
    }

    private static final class SingletonHolder {
        /* access modifiers changed from: private */
        public static final LocaleCodeHolder INSTANCE = new LocaleCodeHolder();

        private SingletonHolder() {
        }
    }
}
