package com.dmap.apollo;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.HashMap;

public class ApolloDelegate {

    /* renamed from: a */
    private static final IApolloDelegate f54271a = new ApolloDelegateImpl();

    /* renamed from: b */
    private static HashMap<String, IToggle> f54272b = null;

    /* renamed from: c */
    private HashMap<String, Boolean> f54273c = new HashMap<>();

    /* renamed from: d */
    private Logger f54274d;

    public interface Logger {
        void log(String str, String str2);
    }

    public void setPrintLogger(Logger logger) {
        this.f54274d = logger;
    }

    public IToggle getToggleCache(String str) {
        return m40440a(str, false, true);
    }

    public IToggle getToggle(String str) {
        return getToggle(str, false);
    }

    public IToggle getToggle(String str, boolean z) {
        return m40440a(str, z, false);
    }

    /* renamed from: a */
    private IToggle m40440a(String str, boolean z, boolean z2) {
        String str2;
        if (f54272b == null) {
            f54272b = new HashMap<>();
        }
        IToggle iToggle = null;
        if (z2) {
            iToggle = f54272b.get(str);
            str2 = "[cache]";
        } else {
            str2 = "";
        }
        if (iToggle == null) {
            iToggle = f54271a.getToggle(str, z);
            if (z2) {
                f54272b.put(str, iToggle);
            }
            str2 = "[apollo]";
        }
        if (this.f54274d != null && iToggle != null && !TextUtils.isEmpty(str) && this.f54273c.get(str) == null) {
            this.f54273c.put(str, true);
            Logger logger = this.f54274d;
            logger.log(str, str2 + iToggle.toJsonObject().toString());
        }
        return iToggle;
    }
}
