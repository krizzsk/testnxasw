package didihttp.internal.trace;

import android.util.Log;
import com.didi.beatles.p101im.views.bottombar.IMSkinTextView;
import com.didi.raven.config.RavenKey;
import didihttp.internal.C21750Util;
import didinet.ApolloAPI;
import didinet.Logger;
import didinet.NetEngine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class IcpStatStrategy {

    /* renamed from: a */
    private static final String f59671a = "IcpStatStrategy";

    /* renamed from: b */
    private static final int f59672b = 200;

    /* renamed from: c */
    private boolean f59673c;

    /* renamed from: d */
    private Map<String, Integer> f59674d;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static IcpStatStrategy INSTANCE = new IcpStatStrategy();

        private SingletonHolder() {
        }
    }

    /* renamed from: a */
    static IcpStatStrategy m44971a() {
        return SingletonHolder.INSTANCE;
    }

    private IcpStatStrategy() {
        this.f59673c = false;
        this.f59674d = new HashMap();
        m44973c();
    }

    /* renamed from: c */
    private void m44973c() {
        ApolloAPI apolloAPI = NetEngine.getInstance().getApolloAPI();
        boolean allow = apolloAPI.getToggle("icp_conf").allow();
        this.f59673c = allow;
        if (allow) {
            ApolloAPI.Experiment experiment = apolloAPI.getToggle("icp_conf").getExperiment();
            if (((Integer) experiment.getParam(RavenKey.VERSION, 0)).intValue() == 1) {
                m44972a(experiment);
            } else {
                this.f59673c = false;
            }
        }
    }

    /* renamed from: a */
    private void m44972a(ApolloAPI.Experiment experiment) {
        String str = (String) experiment.getParam("l", "");
        try {
            this.f59674d.clear();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.f59674d.put(next, Integer.valueOf(jSONObject.optInt(next)));
            }
        } catch (JSONException e) {
            Logger.m45047d(f59671a, "parseParam: " + Log.getStackTraceString(e));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo180163a(Tree tree) {
        if (tree == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Node next : tree.transformToList()) {
            String fixClassName = C21750Util.fixClassName(next.value.toString());
            int i = 200;
            if (this.f59674d.containsKey(fixClassName)) {
                i = this.f59674d.get(fixClassName).intValue();
            } else if (this.f59674d.containsKey(IMSkinTextView.IM_SKIN_COMMON)) {
                i = this.f59674d.get(IMSkinTextView.IM_SKIN_COMMON).intValue();
            }
            if (next.cost > ((long) i)) {
                sb.append(fixClassName);
                sb.append(":");
                sb.append(next.cost);
                sb.append(",");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo180164b() {
        return this.f59673c;
    }
}
