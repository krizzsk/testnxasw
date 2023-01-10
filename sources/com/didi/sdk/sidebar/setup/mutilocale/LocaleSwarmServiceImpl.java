package com.didi.sdk.sidebar.setup.mutilocale;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.swarm.toolkit.LanguageService;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LocaleSwarmServiceImpl implements LocaleChangeListener, LanguageService {

    /* renamed from: a */
    private static final String f40143a = "multilocale-debug";

    /* renamed from: b */
    private static Logger f40144b = LoggerFactory.getLogger("LocaleSwarmServiceImpl");

    /* renamed from: c */
    private LinkedList<LanguageService.OnLanguageChangedListener> f40145c = new LinkedList<>();

    public LocaleSwarmServiceImpl() {
        MultiLocaleStore.getInstance().addLocaleChangeListener(this);
    }

    public String getLanguage() {
        String localeCode = MultiLocaleStore.getInstance().getLocaleCode();
        Logger logger = f40144b;
        logger.infoEvent(f40143a, f40143a, "getLanguage localeCode = " + localeCode);
        return localeCode;
    }

    public void addOnLanguageChangedListener(LanguageService.OnLanguageChangedListener onLanguageChangedListener) {
        if (onLanguageChangedListener == null) {
            f40144b.infoEvent(f40143a, f40143a, "addOnLanguageChangedListener listeners is null");
            return;
        }
        f40144b.infoEvent(f40143a, f40143a, "addOnLanguageChangedListener...");
        this.f40145c.add(onLanguageChangedListener);
    }

    public void removeOnLanguageChangedListener(LanguageService.OnLanguageChangedListener onLanguageChangedListener) {
        if (onLanguageChangedListener == null) {
            f40144b.infoEvent(f40143a, f40143a, "removeOnLanguageChangedListener listeners is null");
            return;
        }
        f40144b.infoEvent(f40143a, f40143a, "removeOnLanguageChangedListener...");
        this.f40145c.remove(onLanguageChangedListener);
    }

    public List<LanguageService.OnLanguageChangedListener> getOnLanguageChangedListeners() {
        return this.f40145c;
    }

    public void onLocaleChange(String str, String str2) {
        f40144b.infoEvent(f40143a, f40143a, "onLocaleChange...");
        LinkedList<LanguageService.OnLanguageChangedListener> linkedList = this.f40145c;
        if (linkedList == null) {
            f40144b.infoEvent(f40143a, f40143a, "onLocaleChange listeners is null");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((LanguageService.OnLanguageChangedListener) it.next()).onLanguageChanged(str, str2);
        }
    }
}
