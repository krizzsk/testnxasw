package com.didichuxing.xpanel.log;

import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.util.HttpRequestUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MisLogHelper {
    public static final String CLICK_TRACKS = "click_tracks";
    public static final String IMP_TRACKS = "imp_tracks";
    public static final String IS_MIS = "isMis";

    /* renamed from: a */
    private static final String f52110a = "fs_resource_sw";

    /* renamed from: b */
    private static final String f52111b = "fs_resource_ck";

    /* renamed from: c */
    private static final String f52112c = "MisLogHelper";
    public ArrayList<String> clickTracks = new ArrayList<>();
    public ArrayList<String> impTracks = new ArrayList<>();
    public boolean isMis = false;

    public static String getLink(String str) {
        return str;
    }

    public static void parseExtension(JSONObject jSONObject, XPanelCardData xPanelCardData) {
        if (jSONObject != null && jSONObject.has(IS_MIS)) {
            MisLogHelper misLogHelper = new MisLogHelper();
            misLogHelper.isMis = jSONObject.optBoolean(IS_MIS);
            m39214a(jSONObject, IMP_TRACKS, misLogHelper.impTracks);
            m39214a(jSONObject, CLICK_TRACKS, misLogHelper.clickTracks);
            xPanelCardData.setMisLogHelper(misLogHelper);
        }
    }

    /* renamed from: a */
    private static void m39214a(JSONObject jSONObject, String str, ArrayList<String> arrayList) {
        if (jSONObject != null && arrayList != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r8.equals("xpanel_card_eff_sw") == false) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void misCardLog(java.lang.String r8, java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
            if (r9 == 0) goto L_0x008d
            int r0 = r9.size()
            if (r0 != 0) goto L_0x000a
            goto L_0x008d
        L_0x000a:
            java.lang.String r0 = "isMis"
            java.lang.Object r0 = r9.remove(r0)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001e
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x001e
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            if (r0 != 0) goto L_0x0022
            return
        L_0x0022:
            java.lang.String r0 = "imp_tracks"
            java.lang.Object r0 = r9.remove(r0)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.lang.String r3 = "click_tracks"
            java.lang.Object r3 = r9.remove(r3)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            r4 = -1
            int r5 = r8.hashCode()
            r6 = -1623722846(0xffffffff9f37f4a2, float:-3.8954113E-20)
            r7 = 2
            if (r5 == r6) goto L_0x005d
            r6 = -1186313404(0xffffffffb94a4b44, float:-1.929226E-4)
            if (r5 == r6) goto L_0x0052
            r6 = 742266330(0x2c3e15da, float:2.7012754E-12)
            if (r5 == r6) goto L_0x0048
            goto L_0x0068
        L_0x0048:
            java.lang.String r5 = "xpanel_card_eff_sw"
            boolean r8 = r8.equals(r5)
            if (r8 == 0) goto L_0x0068
            goto L_0x0069
        L_0x0052:
            java.lang.String r1 = "xpanel_card_ck"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0068
            r1 = 1
            goto L_0x0069
        L_0x005d:
            java.lang.String r1 = "xpanel_button_ck"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0068
            r1 = 2
            goto L_0x0069
        L_0x0068:
            r1 = -1
        L_0x0069:
            java.lang.String r8 = "MisLogHelper"
            if (r1 == 0) goto L_0x0080
            if (r1 == r2) goto L_0x0072
            if (r1 == r7) goto L_0x0072
            goto L_0x008d
        L_0x0072:
            java.lang.String r0 = "mis打点 卡片点击"
            com.didichuxing.xpanel.util.LogcatUtil.m39238e(r8, r0)
            m39213a(r3)
            java.lang.String r8 = "fs_resource_ck"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r8, (java.util.Map<java.lang.String, java.lang.Object>) r9)
            goto L_0x008d
        L_0x0080:
            java.lang.String r1 = "mis打点 有效曝光"
            com.didichuxing.xpanel.util.LogcatUtil.m39238e(r8, r1)
            java.lang.String r8 = "fs_resource_sw"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r8, (java.util.Map<java.lang.String, java.lang.Object>) r9)
            m39213a(r0)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.log.MisLogHelper.misCardLog(java.lang.String, java.util.Map):void");
    }

    /* renamed from: a */
    private static void m39213a(ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            HttpRequestUtil.requestUrl(getLink(it.next()));
        }
    }
}
