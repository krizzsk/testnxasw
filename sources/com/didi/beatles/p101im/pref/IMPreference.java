package com.didi.beatles.p101im.pref;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didi.beatles.im.pref.IMPreference */
public class IMPreference {
    public static String CHECK_RECORD_PERMISSION = "check_record_permission";
    public static final String IM_RED_DOT = "im_red_dot";
    public static final String SURFIX_MAX = "_max_single";
    public static final String TAB_POINT_NUMBER = "tab_point_number";
    public static String USER_CUSTOM_USEFUL_EXPRESSION = "user_custom_useful_expression";

    /* renamed from: a */
    private static IMPreference f11380a = null;

    /* renamed from: b */
    private static final String f11381b = "should_show_add_word_guide";

    /* renamed from: c */
    private static final String f11382c = "should_show_delete_word_guide";

    /* renamed from: d */
    private static final String f11383d = "should_driver_word_guide";

    /* renamed from: e */
    private static final String f11384e = "top_guide_view";

    /* renamed from: f */
    private static final String f11385f = "use_inner_file";

    /* renamed from: g */
    private static final String f11386g = "use_move_file_";

    /* renamed from: h */
    private static final String f11387h = "url_type";

    /* renamed from: i */
    private static final String f11388i = "off_line_ip";

    /* renamed from: j */
    private static final String f11389j = "list_show_feed";

    /* renamed from: k */
    private static final String f11390k = "notify_close_time";

    /* renamed from: l */
    private static final String f11391l = "take_photo_action_tip_";

    /* renamed from: m */
    private static final String f11392m = "more_btn_take_photo_guide_";

    /* renamed from: n */
    private static final String f11393n = "sql_cipher_enable_count";

    /* renamed from: o */
    private static final String f11394o = "crash_count_new_in";

    /* renamed from: p */
    private static final String f11395p = "p_ext_act_red_dot_count_";

    /* renamed from: q */
    private static final String f11396q = "btm_tab_red_dot_count_";

    /* renamed from: r */
    private static final String f11397r = "p_robot_slide_guide_tip_";

    /* renamed from: s */
    private static final String f11398s = "p_robot_click_robot_guide_tip_";

    /* renamed from: t */
    private static final String f11399t = "sys_audio_auto_play_count_";

    /* renamed from: u */
    private static final String f11400u = "bottom_tab_select_plugin_id_";

    /* renamed from: v */
    private static final String f11401v = "phone_guide_toast_show_";

    /* renamed from: w */
    private static final String f11402w = "complaint_guide_toast_show_";

    /* renamed from: x */
    private SharedPreferences f11403x;

    private IMPreference(Context context) {
        this.f11403x = SystemUtils.getSharedPreferences(context, "didi_im_v1", 0);
    }

    public static IMPreference getInstance(Context context) {
        if (f11380a == null) {
            f11380a = new IMPreference(context);
        }
        return f11380a;
    }

    public long getMaxSingleId(long j) {
        IMLog.m10020d("IMPreference", "uid is " + j + " all preference is " + this.f11403x.getAll());
        SharedPreferences sharedPreferences = this.f11403x;
        return sharedPreferences.getLong(String.valueOf(j) + SURFIX_MAX, 0);
    }

    public void saveMaxSingleId(long j, long j2) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putLong(String.valueOf(j) + SURFIX_MAX, j2);
        edit.apply();
    }

    public void saveTabNumber(int i) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putInt(TAB_POINT_NUMBER, i);
        edit.apply();
    }

    public boolean getImLocationPageGuide() {
        return this.f11403x.getBoolean("ImLocationPageGuide", true);
    }

    public void setImLocationPageGuide() {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putBoolean("ImLocationPageGuide", false);
        edit.apply();
    }

    public int getTabNumber() {
        return this.f11403x.getInt(TAB_POINT_NUMBER, 0);
    }

    public void setIsHaveRedDot(boolean z) {
        if (this.f11403x.getBoolean(IM_RED_DOT, false) && z) {
            return;
        }
        if (this.f11403x.getBoolean(IM_RED_DOT, false) || z) {
            SharedPreferences.Editor edit = this.f11403x.edit();
            edit.putBoolean(IM_RED_DOT, z);
            edit.apply();
        }
    }

    public boolean isHaveRedDot() {
        return this.f11403x.getBoolean(IM_RED_DOT, false);
    }

    public void setCheckRecord(int i) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putInt(CHECK_RECORD_PERMISSION, i);
        edit.apply();
    }

    public int isNotNeedCheckRecord() {
        return this.f11403x.getInt(CHECK_RECORD_PERMISSION, 0);
    }

    public void saveStringValue(String str, String str2) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public String getStringValue(String str, String str2) {
        return this.f11403x.getString(str, str2);
    }

    public boolean shouldShowAddWordGuide() {
        return this.f11403x.getBoolean(f11381b, true);
    }

    public boolean shouldShowDelteWordGuide() {
        return this.f11403x.getBoolean(f11382c, true);
    }

    public boolean shouldDriverWordGuide() {
        return this.f11403x.getBoolean(f11383d, true);
    }

    public void showedDriverWordGuide() {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putBoolean(f11383d, false);
        edit.apply();
    }

    public void showedAddWordGuide() {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putBoolean(f11381b, false);
        edit.apply();
    }

    public void showedDeleteWordGuide() {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putBoolean(f11382c, false);
        edit.apply();
    }

    public boolean shouldShowTopGuide() {
        return this.f11403x.getBoolean(f11384e, true);
    }

    public void hasShowTopViewGuide() {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putBoolean(f11384e, false);
        edit.apply();
    }

    public void setUseInnerFile() {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putBoolean(f11385f, true);
        edit.apply();
    }

    public boolean isUseInnerFile() {
        return this.f11403x.getBoolean(f11385f, false);
    }

    public void setUrlType(int i) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putInt(f11387h, i);
        edit.apply();
    }

    public int getUrlType() {
        return this.f11403x.getInt(f11387h, 0);
    }

    public void setOffLineIp(String str) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putString(f11388i, str);
        edit.apply();
    }

    public String getOffLineIp() {
        return this.f11403x.getString(f11388i, "");
    }

    public void setListShowFeed(boolean z) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putBoolean(f11389j, z);
        edit.apply();
    }

    public boolean isListShowFeed(boolean z) {
        return this.f11403x.getBoolean(f11389j, z);
    }

    public void setNotifyCloseTime(long j) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putLong(f11390k, j);
        edit.apply();
    }

    public long getNotifyCloseTime() {
        return this.f11403x.getLong(f11390k, 0);
    }

    public Set<String> getTakPhotoActionTip(long j) {
        SharedPreferences sharedPreferences = this.f11403x;
        return sharedPreferences.getStringSet(f11391l + j, new HashSet());
    }

    public void setTakePhotoActionTip(long j, Set<String> set) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putStringSet(f11391l + j, set);
        edit.apply();
    }

    public int getCrashCount() {
        return this.f11403x.getInt(f11394o, 0);
    }

    public void increaseCrashCount() {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putInt(f11394o, getCrashCount() + 1);
        edit.apply();
    }

    public void decreaseCrashCount() {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putInt(f11394o, getCrashCount() - 1);
        edit.apply();
    }

    public int getPluginExtendActionRedDotShowedCount(long j, int i) {
        SharedPreferences sharedPreferences = this.f11403x;
        return sharedPreferences.getInt(f11395p + j + "_" + i, 0);
    }

    public void savePluginExtendActionRedDotShowedCount(long j, int i, int i2) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putInt(f11395p + j + "_" + i, i2);
        edit.apply();
    }

    public int getBtmTabRedDotShowedCount(long j, int i) {
        SharedPreferences sharedPreferences = this.f11403x;
        return sharedPreferences.getInt(f11396q + j + "_" + i, 0);
    }

    public void saveBtmTabRedDotShowedCount(long j, int i, int i2) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putInt(f11396q + j + "_" + i, i2);
        edit.apply();
    }

    public Set<String> getRobotSlideGuideTip(long j) {
        SharedPreferences sharedPreferences = this.f11403x;
        return sharedPreferences.getStringSet(f11397r + j, new HashSet());
    }

    public void setRobotSlideGuideTip(long j, Set<String> set) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putStringSet(f11397r + j, set);
        edit.apply();
    }

    public void setInValue(String str, int i) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public int getInValue(String str, int i) {
        return this.f11403x.getInt(str, i);
    }

    public void setSetValue(String str, Set<String> set) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putStringSet(str, set);
        edit.apply();
    }

    public Set<String> getSetValue(String str, Set<String> set) {
        return this.f11403x.getStringSet(str, set);
    }

    public int getRobotClickRobotGuideTip(long j) {
        SharedPreferences sharedPreferences = this.f11403x;
        return sharedPreferences.getInt(f11398s + j, 0);
    }

    public void setRobotClickRobotGuideTip(long j, int i) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putInt(f11398s + j, i);
        edit.apply();
    }

    public int getSysAudioAutoPlayCount(long j) {
        SharedPreferences sharedPreferences = this.f11403x;
        return sharedPreferences.getInt(f11399t + j, 0);
    }

    public void setSysAudioAutoPlayCount(long j, int i) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putInt(f11399t + j, i);
        edit.apply();
    }

    public int getBottomTabSelectPluginId(long j, int i) {
        SharedPreferences sharedPreferences = this.f11403x;
        return sharedPreferences.getInt(f11400u + j, i);
    }

    public void setBottomTabSelectPluginId(long j, int i) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putInt(f11400u + j, i);
        edit.apply();
    }

    public boolean isPhoneGuideShow(long j) {
        SharedPreferences sharedPreferences = this.f11403x;
        return sharedPreferences.getBoolean(f11401v + j, false);
    }

    public void setPhoneGuideShow(long j) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putBoolean(f11401v + j, true);
        edit.apply();
    }

    public boolean isComplaintGuideShow(long j) {
        SharedPreferences sharedPreferences = this.f11403x;
        return sharedPreferences.getBoolean(f11402w + j, false);
    }

    public void setComplaintGuideShow(long j) {
        SharedPreferences.Editor edit = this.f11403x.edit();
        edit.putBoolean(f11402w + j, true);
        edit.apply();
    }
}
