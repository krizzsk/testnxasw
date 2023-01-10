package com.didiglobal.privacysdk;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class GlobalOmegaUtils {

    /* renamed from: a */
    private static final String f53085a = "ibt_gd_profile_setting_privacy_center_entrance_ck";

    /* renamed from: b */
    private static final String f53086b = "ibt_gd_profile_setting_privacy_center_personal_data_download_entrance_ck";

    /* renamed from: c */
    private static final String f53087c = "ibt_gd_profile_setting_privacy_center_system_permission_entrance_ck";

    /* renamed from: d */
    private static final String f53088d = "ibt_gd_profile_setting_shared_position_switch_status_sw";

    /* renamed from: e */
    private static final String f53089e = "ibt_gd_profile_setting_shared_position_comfirm_close_ck";

    /* renamed from: f */
    private static final String f53090f = "ibt_gd_profile_setting_discount_and_information_switch_status_sw";

    /* renamed from: g */
    private static final String f53091g = "ibt_ibt_gd_profile_setting_discount_and_information_confirm_close_ck";

    /* renamed from: h */
    private static final String f53092h = "ibt_gd_profile_setting_position_authority_switch_status_sw";

    /* renamed from: i */
    private static final String f53093i = "ibt_gd_profile_setting_camera_authority_switch_status_sw";

    /* renamed from: j */
    private static final String f53094j = "ibt_gd_profile_setting_address_book_swich_status_sw";

    /* renamed from: k */
    private static final String f53095k = "ibt_gd_profile_setting_album_authorityn_switch_status_sw";

    /* renamed from: l */
    private static final String f53096l = "ibt_gd_profile_setting_microphone_authority_switch_status_sw";

    /* renamed from: m */
    private static final String f53097m = "account_type";

    /* renamed from: n */
    private static final String f53098n = "user_id";

    /* renamed from: o */
    private static final String f53099o = "type";

    /* renamed from: p */
    private static final String f53100p = "channel";

    /* renamed from: q */
    private static final int f53101q = 1;

    /* renamed from: r */
    private static final int f53102r = 2;

    /* renamed from: a */
    private static int m39754a(boolean z) {
        return z ? 1 : 2;
    }

    public static void sendSettingPrivacyEntranceClick() {
        m39757a(f53085a, new HashMap());
    }

    public static void sendDataDownloadEntranceCK() {
        m39757a(f53086b, new HashMap());
    }

    public static void sendSystemPermissionEntranceCK() {
        m39757a(f53087c, new HashMap());
    }

    public static void sendSharedPositionSwitchStatusSw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(m39754a(z)));
        m39757a(f53088d, hashMap);
    }

    public static void sendSharedPositionConfirmCloseCk() {
        m39757a(f53089e, new HashMap());
    }

    public static void sendDiscountSwitchStatusSw(String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("channel", str);
        hashMap.put("type", Integer.valueOf(m39754a(z)));
        m39757a(f53090f, hashMap);
    }

    public static void sendDiscountSwitchConfirmCloseCk(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("channel", str);
        m39757a(f53091g, hashMap);
    }

    public static void sendPositionAuthorityStatusSw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(m39754a(z)));
        m39757a(f53092h, hashMap);
    }

    public static void sendCameraAuthorityStatusSw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(m39754a(z)));
        m39757a(f53093i, hashMap);
    }

    public static void sendAddressBookAuthorityStatusSw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(m39754a(z)));
        m39757a(f53094j, hashMap);
    }

    public static void sendAlbumAuthorityStatusSw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(m39754a(z)));
        m39757a(f53095k, hashMap);
    }

    public static void sendMicrophoneAuthorityStatusSw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(m39754a(z)));
        m39757a(f53096l, hashMap);
    }

    /* renamed from: a */
    private static String m39755a() {
        return GlobalPrivacySDK.getAccountType();
    }

    /* renamed from: b */
    private static String m39758b() {
        return GlobalPrivacySDK.getUserId();
    }

    /* renamed from: a */
    private static void m39757a(String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(f53097m, m39755a());
        map.put("user_id", m39758b());
        m39756a(str, (String) null, map);
    }

    /* renamed from: a */
    private static void m39756a(String str, String str2, Map<String, Object> map) {
        OmegaSDKAdapter.trackEvent(str, str2, map);
    }
}
