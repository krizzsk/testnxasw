package com.didi.global.ninja.strategy;

import android.content.Context;
import android.text.TextUtils;
import com.didi.global.ninja.utils.Utils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StrategyManager {

    /* renamed from: a */
    private static final String f24795a = "StrategyManager";

    /* renamed from: b */
    private static final String f24796b = "ninja";

    /* renamed from: f */
    private static volatile StrategyManager f24797f;

    /* renamed from: c */
    private final Map<String, List<IStrategy>> f24798c = new HashMap();

    /* renamed from: d */
    private final Map<String, IStrategy> f24799d = new HashMap();

    /* renamed from: e */
    private final Map<String, Set<String>> f24800e = new HashMap();

    /* renamed from: g */
    private final Context f24801g;

    private StrategyManager(Context context) {
        this.f24801g = context.getApplicationContext();
    }

    public static StrategyManager getInstance(Context context) {
        if (f24797f == null) {
            synchronized (StrategyManager.class) {
                if (f24797f == null) {
                    f24797f = new StrategyManager(context);
                }
            }
        }
        return f24797f;
    }

    public void init() {
        try {
            for (String str : this.f24801g.getResources().getAssets().list(f24796b)) {
                Context context = this.f24801g;
                m19881a(Utils.readAssetFile(context, f24796b + File.separator + str));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processConfigData() {
        String[] strArr = {StrategyConfigs.FACE_SHARE_CONFIG, StrategyConfigs.SHARE_CONFIG, StrategyConfigs.FACEBOOK_LOGIN_CONFIG, StrategyConfigs.GOOGLE_LOGIN_CONFIG, StrategyConfigs.NINJA_DEMO};
        for (int i = 0; i < 5; i++) {
            m19881a(strArr[i]);
        }
    }

    /* renamed from: a */
    private void m19881a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                if (optJSONArray != null) {
                    HashSet hashSet = new HashSet();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String obj = optJSONArray.get(i).toString();
                        if (!TextUtils.isEmpty(obj)) {
                            hashSet.add(obj);
                        }
                    }
                    this.f24800e.put(next, hashSet);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            SystemUtils.log(6, f24795a, "read file init fail", (Throwable) null, "com.didi.global.ninja.strategy.StrategyManager", 110);
        } catch (Exception e2) {
            e2.printStackTrace();
            SystemUtils.log(6, f24795a, "processConfig fail", (Throwable) null, "com.didi.global.ninja.strategy.StrategyManager", 113);
        }
    }

    public void registerException(String str, IStrategy iStrategy) throws Exception {
        List list;
        if (!this.f24799d.containsKey(iStrategy.getName()) || this.f24799d.get(iStrategy.getName()).equals(iStrategy)) {
            if (this.f24798c.containsKey(str)) {
                list = this.f24798c.get(str);
            } else {
                list = new ArrayList();
            }
            list.add(iStrategy);
            this.f24798c.put(str, list);
            this.f24799d.put(iStrategy.getName(), iStrategy);
            return;
        }
        throw new Exception("Duplicate strategy name");
    }

    public void filterException(StackTraceElement[] stackTraceElementArr) {
        if (this.f24800e.size() > 0) {
            for (Map.Entry next : this.f24800e.entrySet()) {
                for (StackTraceElement className : stackTraceElementArr) {
                    if (((Set) next.getValue()).contains(className.getClassName())) {
                        for (IStrategy filter : this.f24798c.get(next.getKey())) {
                            filter.filter();
                        }
                    }
                }
            }
        }
    }

    public boolean isHit(String str) {
        IStrategy iStrategy = this.f24799d.get(str);
        if (iStrategy == null || !iStrategy.init()) {
            return false;
        }
        return iStrategy.isHit();
    }

    public boolean isApolloHit(String str, String str2, boolean z) {
        IToggle toggle = Apollo.getToggle(str);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam(str2, 1)).intValue() == 0;
        }
        return z;
    }
}
