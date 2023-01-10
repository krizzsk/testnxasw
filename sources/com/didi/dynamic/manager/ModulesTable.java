package com.didi.dynamic.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.dynamic.manager.utils.Log;
import com.didi.dynamic.manager.utils.SharedPreferencesWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ModulesTable {

    /* renamed from: a */
    protected static final String f21200a = "DM.ModulesTable";

    /* renamed from: b */
    protected static final String f21201b = ":";

    /* renamed from: c */
    protected static final String f21202c = "dynamic_modules";

    /* renamed from: d */
    protected static final String f21203d = "modules";

    /* renamed from: e */
    protected static final String f21204e = "url";

    /* renamed from: f */
    protected static final String f21205f = "launchType";

    /* renamed from: g */
    protected static final String f21206g = "downloaded";

    /* renamed from: h */
    protected static final String f21207h = "modulePath";

    /* renamed from: i */
    protected static final String f21208i = "moduleTempPath";

    /* renamed from: j */
    protected static final String f21209j = "appVersion";

    /* renamed from: k */
    protected static final String f21210k = "moduleType";

    /* renamed from: l */
    protected static final String f21211l = "moduleIsUseful";

    /* renamed from: m */
    protected static final String f21212m = "moduleExt";

    /* renamed from: n */
    protected Context f21213n;

    /* renamed from: o */
    protected final SharedPreferencesWrapper f21214o;

    interface Filter {
        boolean match(SharedPreferences sharedPreferences, String str, String str2);
    }

    /* renamed from: a */
    public static ModulesTable m17891a(Context context) {
        return new ModulesTable(context);
    }

    protected ModulesTable(Context context) {
        this.f21213n = context.getApplicationContext();
        this.f21214o = SharedPreferencesWrapper.m17955of(context, f21202c, 0);
    }

    /* renamed from: a */
    protected static String m17892a(Object... objArr) {
        return TextUtils.join(":", objArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo64037a(SharedPreferencesWrapper.Editor editor) {
        editor.commitNow();
    }

    /* renamed from: a */
    public boolean mo64042a(Module module) {
        boolean z;
        if (module == null) {
            return false;
        }
        HashSet<String> hashSet = new HashSet<>();
        synchronized (this.f21214o) {
            SharedPreferencesWrapper sharedPreferencesWrapper = this.f21214o;
            Set<String> stringSet = sharedPreferencesWrapper.getStringSet(module.moduleCode, (Set<String>) null);
            if (stringSet == null) {
                z = true;
            } else {
                z = true;
                for (String next : stringSet) {
                    boolean z2 = sharedPreferencesWrapper.getBoolean(m17892a(module.moduleCode, next, f21206g), false);
                    if (module.versionLong - Long.parseLong(next) == 0) {
                        module.f21199a = z2;
                        z = false;
                    } else {
                        hashSet.add(next);
                    }
                }
            }
            SharedPreferencesWrapper.Editor edit = sharedPreferencesWrapper.edit();
            Set<String> stringSet2 = sharedPreferencesWrapper.getStringSet(f21203d, Collections.emptySet());
            Set<String> stringSet3 = sharedPreferencesWrapper.getStringSet(module.moduleCode, Collections.emptySet());
            HashSet hashSet2 = new HashSet(stringSet2);
            HashSet hashSet3 = new HashSet(stringSet3);
            if (z) {
                Log.m17923d(f21200a, "add module:" + module.moduleCode + " v:" + module.version);
                mo64038a(edit, module, (Set<String>) hashSet2, (Set<String>) hashSet3);
            } else {
                Log.m17923d(f21200a, "update module:" + module.moduleCode + " v:" + module.version);
                mo64038a(edit, module, (Set<String>) hashSet2, (Set<String>) hashSet3);
            }
            for (String str : hashSet) {
                mo64039a(edit, module.moduleCode, str, false);
                Log.m17923d(f21200a, "delete reverted module:" + module.moduleCode + " v:" + str);
            }
            mo64037a(edit);
        }
        return true;
    }

    /* renamed from: b */
    public void mo64048b(Module module) {
        synchronized (this.f21214o) {
            SharedPreferencesWrapper sharedPreferencesWrapper = this.f21214o;
            SharedPreferencesWrapper.Editor edit = sharedPreferencesWrapper.edit();
            mo64038a(edit, module, (Set<String>) new HashSet(sharedPreferencesWrapper.getStringSet(f21203d, Collections.emptySet())), (Set<String>) new HashSet(sharedPreferencesWrapper.getStringSet(module.moduleCode, Collections.emptySet())));
            mo64037a(edit);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo64038a(SharedPreferencesWrapper.Editor editor, Module module, Set<String> set, Set<String> set2) {
        if (module != null) {
            String str = module.moduleCode;
            String str2 = module.version;
            set.add(str);
            set2.add(str2);
            editor.putStringSet(f21203d, (Set) set).putStringSet(str, (Set) set2).putString(m17892a(str, str2, "url"), module.url).putInt(m17892a(str, str2, f21205f), module.launchType).putBoolean(m17892a(str, str2, f21206g), module.f21199a).putString(m17892a(str, str2, f21207h), module.modulePath.getAbsolutePath()).putString(m17892a(str, str2, f21208i), module.moduleTempPath.getAbsolutePath()).putString(m17892a(str, str2, "appVersion"), module.appVersion).putString(m17892a(str, str2, f21212m), module.ext).putInt(m17892a(str, str2, f21210k), module.moduleType).putBoolean(m17892a(str, str2, f21211l), module.moduleIsUseful);
        }
    }

    /* renamed from: c */
    public void mo64049c(Module module) {
        if (module != null) {
            synchronized (this.f21214o) {
                if (this.f21214o.getStringSet(module.moduleCode, Collections.emptySet()).contains(module.version)) {
                    mo64048b(module);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo64039a(SharedPreferencesWrapper.Editor editor, String str, String str2, boolean z) {
        if (this.f21214o.getStringSet(str, Collections.emptySet()).contains(str2)) {
            editor.putBoolean(m17892a(str, str2, f21211l), z);
        }
    }

    /* renamed from: d */
    public boolean mo64051d(Module module) {
        boolean a;
        if (module == null) {
            return false;
        }
        synchronized (this.f21214o) {
            mo64052e(module);
            a = mo64044a(module.moduleCode, module.version);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo64044a(String str, String str2) {
        SharedPreferencesWrapper sharedPreferencesWrapper = this.f21214o;
        SharedPreferencesWrapper.Editor edit = sharedPreferencesWrapper.edit();
        SharedPreferencesWrapper.Editor editor = edit;
        String str3 = str;
        String str4 = str2;
        boolean a = mo64043a(editor, str3, str4, new HashSet(sharedPreferencesWrapper.getStringSet(f21203d, Collections.emptySet())), new HashSet(sharedPreferencesWrapper.getStringSet(str, Collections.emptySet())));
        mo64037a(edit);
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo64043a(SharedPreferencesWrapper.Editor editor, String str, String str2, Set<String> set, Set<String> set2) {
        if (!set2.remove(str2)) {
            return false;
        }
        if (set2.isEmpty()) {
            editor.remove(str);
            set.remove(str);
            editor.putStringSet(f21203d, (Set) set);
        } else {
            editor.putStringSet(str, (Set) set2);
        }
        editor.remove(m17892a(str, str2, "url")).remove(m17892a(str, str2, f21205f)).remove(m17892a(str, str2, f21212m)).remove(m17892a(str, str2, f21206g)).remove(m17892a(str, str2, f21207h)).remove(m17892a(str, str2, f21208i)).remove(m17892a(str, str2, "appVersion")).remove(m17892a(str, str2, f21210k)).remove(m17892a(str, str2, f21211l));
        return true;
    }

    /* renamed from: a */
    public void mo64041a(String str) {
        synchronized (this.f21214o) {
            mo64050c(str);
            mo64034a();
        }
    }

    /* renamed from: a */
    public void mo64035a(final int i) {
        synchronized (this.f21214o) {
            mo64036a((Filter) new Filter() {
                public boolean match(SharedPreferences sharedPreferences, String str, String str2) {
                    return i == sharedPreferences.getInt(ModulesTable.m17892a(str, str2, ModulesTable.f21210k), -1);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo64040a(Iterable<Module> iterable) {
        HashSet hashSet;
        SharedPreferencesWrapper sharedPreferencesWrapper = this.f21214o;
        SharedPreferencesWrapper.Editor edit = sharedPreferencesWrapper.edit();
        HashSet hashSet2 = new HashSet(sharedPreferencesWrapper.getStringSet(f21203d, Collections.emptySet()));
        HashMap hashMap = new HashMap();
        for (Module next : iterable) {
            String str = next.moduleCode;
            String str2 = next.version;
            Set set = (Set) hashMap.get(str);
            if (set == null) {
                HashSet hashSet3 = new HashSet(sharedPreferencesWrapper.getStringSet(str, Collections.emptySet()));
                hashMap.put(str, hashSet3);
                hashSet = hashSet3;
            } else {
                hashSet = set;
            }
            mo64043a(edit, str, str2, hashSet2, hashSet);
        }
        mo64037a(edit);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo64036a(Filter filter) {
        SharedPreferencesWrapper sharedPreferencesWrapper = this.f21214o;
        Set<String> stringSet = sharedPreferencesWrapper.getStringSet(f21203d, Collections.emptySet());
        HashSet hashSet = new HashSet(stringSet);
        SharedPreferencesWrapper.Editor edit = sharedPreferencesWrapper.edit();
        for (String next : stringSet) {
            Set<String> stringSet2 = sharedPreferencesWrapper.getStringSet(next, Collections.emptySet());
            HashSet hashSet2 = new HashSet(stringSet2);
            for (String next2 : stringSet2) {
                if (filter == null || filter.match(sharedPreferencesWrapper, next, next2)) {
                    mo64043a(edit, next, next2, hashSet, hashSet2);
                }
            }
        }
        mo64037a(edit);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List<Module> mo64046b(Filter filter) {
        ArrayList arrayList = new ArrayList();
        SharedPreferencesWrapper sharedPreferencesWrapper = this.f21214o;
        for (String next : sharedPreferencesWrapper.getStringSet(f21203d, Collections.emptySet())) {
            for (String next2 : sharedPreferencesWrapper.getStringSet(next, Collections.emptySet())) {
                if (filter == null || filter.match(sharedPreferencesWrapper, next, next2)) {
                    arrayList.add(mo64033a(sharedPreferencesWrapper, next, next2));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public Module mo64045b(final String str, final String str2) {
        synchronized (this.f21214o) {
            List<Module> b = mo64046b((Filter) new Filter() {
                public boolean match(SharedPreferences sharedPreferences, String str, String str2) {
                    return str.equals(str) && str2.equals(str2);
                }
            });
            if (b.size() != 1) {
                return null;
            }
            Module module = b.get(0);
            return module;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Module mo64033a(SharedPreferencesWrapper sharedPreferencesWrapper, String str, String str2) {
        Module module = new Module();
        module.moduleCode = str;
        module.version = str2;
        module.url = sharedPreferencesWrapper.getString(m17892a(str, str2, "url"), "");
        module.launchType = sharedPreferencesWrapper.getInt(m17892a(str, str2, f21205f), 0);
        module.ext = sharedPreferencesWrapper.getString(m17892a(str, str2, f21212m), "");
        module.f21199a = sharedPreferencesWrapper.getBoolean(m17892a(str, str2, f21206g), false);
        module.modulePath = new File(sharedPreferencesWrapper.getString(m17892a(str, str2, f21207h), ""));
        module.moduleTempPath = new File(sharedPreferencesWrapper.getString(m17892a(str, str2, f21208i), ""));
        module.appVersion = sharedPreferencesWrapper.getString(m17892a(str, str2, "appVersion"), "");
        module.moduleType = sharedPreferencesWrapper.getInt(m17892a(str, str2, f21210k), -1);
        module.versionLong = Long.parseLong(module.version);
        module.moduleIsUseful = sharedPreferencesWrapper.getBoolean(m17892a(str, str2, f21211l), false);
        return module;
    }

    /* renamed from: b */
    public Map<String, List<Module>> mo64047b(final String str) {
        HashMap hashMap = new HashMap();
        synchronized (this.f21214o) {
            for (Module next : mo64046b((Filter) new Filter() {
                public boolean match(SharedPreferences sharedPreferences, String str, String str2) {
                    if (!sharedPreferences.getBoolean(ModulesTable.m17892a(str, str2, ModulesTable.f21211l), false)) {
                        return false;
                    }
                    if (sharedPreferences.getString(ModulesTable.m17892a(str, str2, "appVersion"), "").equals(str)) {
                        return true;
                    }
                    return false;
                }
            })) {
                String str2 = next.moduleCode;
                List list = (List) hashMap.get(str2);
                if (list == null) {
                    list = new ArrayList();
                    hashMap.put(str2, list);
                }
                list.add(next);
            }
        }
        return hashMap;
    }

    /* renamed from: c */
    public void mo64050c(final String str) {
        synchronized (this.f21214o) {
            List<Module> b = mo64046b((Filter) new Filter() {
                public boolean match(SharedPreferences sharedPreferences, String str, String str2) {
                    return !sharedPreferences.getString(ModulesTable.m17892a(str, str2, "appVersion"), "").equals(str);
                }
            });
            for (Module e : b) {
                mo64052e(e);
            }
            mo64040a((Iterable<Module>) b);
        }
    }

    /* renamed from: a */
    public void mo64034a() {
        synchronized (this.f21214o) {
            List<Module> b = mo64046b((Filter) new Filter() {
                public boolean match(SharedPreferences sharedPreferences, String str, String str2) {
                    return !sharedPreferences.getBoolean(ModulesTable.m17892a(str, str2, ModulesTable.f21211l), false);
                }
            });
            for (Module e : b) {
                mo64052e(e);
            }
            mo64040a((Iterable<Module>) b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo64052e(Module module) {
        if (module.modulePath != null && module.modulePath.exists()) {
            module.modulePath.delete();
        }
        if (module.moduleTempPath != null && module.moduleTempPath.exists()) {
            module.moduleTempPath.delete();
        }
    }
}
