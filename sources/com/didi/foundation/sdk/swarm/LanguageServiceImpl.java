package com.didi.foundation.sdk.swarm;

import com.didi.foundation.sdk.service.LocaleService;
import com.didi.foundation.sdk.service.LocaleServiceProvider;
import com.didi.foundation.sdk.utils.LocaleUtils;
import com.didichuxing.swarm.toolkit.LanguageService;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LanguageServiceImpl implements LanguageService {

    /* renamed from: a */
    private final LocaleServiceProvider f23201a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<LanguageService.OnLanguageChangedListener> f23202b = new ArrayList();

    public LanguageServiceImpl() {
        LocaleService instance = LocaleService.getInstance();
        this.f23201a = instance;
        instance.addOnLocaleChangedListener(new LocaleServiceProvider.OnLocaleChangedListener() {
            public void onLocaleChanged(Locale locale, Locale locale2) {
                if (LanguageServiceImpl.this.f23202b != null && !LanguageServiceImpl.this.f23202b.isEmpty()) {
                    for (LanguageService.OnLanguageChangedListener onLanguageChanged : LanguageServiceImpl.this.f23202b) {
                        onLanguageChanged.onLanguageChanged(LocaleUtils.localeToTag(locale), LocaleUtils.localeToTag(locale2));
                    }
                }
            }
        });
    }

    public String getLanguage() {
        return LocaleUtils.localeToTag(this.f23201a.getCurrentLang());
    }

    public void addOnLanguageChangedListener(LanguageService.OnLanguageChangedListener onLanguageChangedListener) {
        if (!this.f23202b.contains(onLanguageChangedListener)) {
            this.f23202b.add(onLanguageChangedListener);
        }
    }

    public void removeOnLanguageChangedListener(LanguageService.OnLanguageChangedListener onLanguageChangedListener) {
        this.f23202b.remove(onLanguageChangedListener);
    }

    public List<LanguageService.OnLanguageChangedListener> getOnLanguageChangedListeners() {
        return this.f23202b;
    }
}
