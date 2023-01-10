package com.didi.dimina.container.debug;

import android.text.TextUtils;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.RemoteBundleMangerStrategy;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.starbox.module.StarBoxDockerActivity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONArray;
import org.json.JSONObject;

public class DevModeManager {

    /* renamed from: a */
    private static final String f18674a = "DevModeManager";

    /* renamed from: b */
    private static final String f18675b = "dev_mode_key_gift_";

    /* renamed from: c */
    private static final String f18676c = "dev_mode_key_dev_";

    /* renamed from: d */
    private static final String f18677d = "dev_mode_key_ip_";

    /* renamed from: e */
    private static final String f18678e = "dev_mode_key_gift_giftUrl_";

    /* renamed from: f */
    private final String f18679f;

    /* renamed from: g */
    private BundleManagerStrategy f18680g = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DevMode {
        public static final String DEV_GIFT = "dev_mode_gift";
        public static final String DEV_IP = "dev_mode_ip";
    }

    public DevModeManager(String str) {
        this.f18679f = str;
    }

    public void setDevMode4GIFT(String str) {
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.save(f18675b + this.f18679f, str);
    }

    public void setDevMode4GIFTURL(String str) {
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.save(f18678e + this.f18679f, str);
    }

    public void setDevMode4IP(String str) {
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.save(f18677d + this.f18679f, str);
    }

    public void setDevMode(String str) {
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.save(f18676c + this.f18679f, str);
    }

    public void resetDevMode() {
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.remove(f18676c + this.f18679f);
    }

    public BundleManagerStrategy getBundleManagerStrategy(BundleManagerStrategy bundleManagerStrategy) {
        if (this.f18680g == null) {
            MMKVUtil instance = MMKVUtil.getInstance();
            String str = (String) instance.get(f18676c + this.f18679f, "");
            if (TextUtils.equals(str, DevMode.DEV_IP)) {
                MMKVUtil instance2 = MMKVUtil.getInstance();
                this.f18680g = new RemoteBundleMangerStrategy((String) instance2.get(f18677d + this.f18679f, ""));
            } else if (TextUtils.equals(str, DevMode.DEV_GIFT)) {
                MMKVUtil instance3 = MMKVUtil.getInstance();
                this.f18680g = new RemoteBundleMangerStrategy((String) instance3.get(f18675b + this.f18679f, ""));
            } else {
                this.f18680g = bundleManagerStrategy;
            }
        }
        return this.f18680g;
    }

    public JSONArray getDevModeList() {
        JSONArray jSONArray = new JSONArray();
        MMKVUtil instance = MMKVUtil.getInstance();
        String str = (String) instance.get(f18676c + this.f18679f, "");
        JSONObject jSONObject = new JSONObject();
        MMKVUtil instance2 = MMKVUtil.getInstance();
        String str2 = (String) instance2.get(f18675b + this.f18679f, "");
        MMKVUtil instance3 = MMKVUtil.getInstance();
        JSONUtil.put(jSONObject, "enable", !TextUtils.isEmpty(str2));
        JSONUtil.put(jSONObject, "url", (Object) str2);
        JSONUtil.put(jSONObject, "giftUrl", (Object) (String) instance3.get(f18678e + this.f18679f, ""));
        JSONUtil.put(jSONObject, "name", (Object) "预览模式");
        JSONUtil.put(jSONObject, "dev", (Object) StarBoxDockerActivity.VALUE_DEV_MODE_GIFT);
        JSONUtil.put(jSONObject, "select", TextUtils.equals(str, DevMode.DEV_GIFT));
        JSONUtil.put(jSONObject, "needLaunch", true);
        JSONUtil.put(jSONArray, jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        MMKVUtil instance4 = MMKVUtil.getInstance();
        String str3 = (String) instance4.get(f18677d + this.f18679f, "");
        JSONUtil.put(jSONObject2, "enable", TextUtils.isEmpty(str3) ^ true);
        JSONUtil.put(jSONObject2, "url", (Object) str3);
        JSONUtil.put(jSONObject2, "name", (Object) "ip直连模式");
        JSONUtil.put(jSONObject2, "dev", (Object) "ip");
        JSONUtil.put(jSONObject2, "select", TextUtils.equals(str, DevMode.DEV_IP));
        JSONUtil.put(jSONObject2, "needLaunch", true);
        JSONUtil.put(jSONArray, jSONObject2);
        boolean z = TextUtils.equals(str, DevMode.DEV_GIFT) || TextUtils.equals(str, DevMode.DEV_IP);
        JSONObject jSONObject3 = new JSONObject();
        JSONUtil.put(jSONObject3, "enable", true);
        JSONUtil.put(jSONObject3, "url", (Object) "");
        JSONUtil.put(jSONObject3, "name", (Object) "默认模式");
        JSONUtil.put(jSONObject3, "dev", (Object) "none");
        JSONUtil.put(jSONObject3, "select", !z);
        JSONUtil.put(jSONObject3, "needLaunch", false);
        JSONUtil.put(jSONArray, jSONObject3);
        return jSONArray;
    }

    public static boolean isGiftDevModel(String str) {
        MMKVUtil instance = MMKVUtil.getInstance();
        return TextUtils.equals((String) instance.get(f18676c + str, ""), DevMode.DEV_GIFT);
    }
}
